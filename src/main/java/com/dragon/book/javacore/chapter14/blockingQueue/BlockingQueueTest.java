package com.dragon.book.javacore.chapter14.blockingQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 实现指定目录下通过关键词搜索出文件内容中指定的行
 * User: dengshenyan
 * Time: 2018-12-18 13:57
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a Directory. eg: D:\\tools");
        String directory = in.nextLine();
        System.out.println("Enter the keyword");
        String keyword = in.nextLine();

        final int BLOCKING_QUEUE_SIZE = 10;
        final int SEARCH_THREADS = 100;
        BlockingQueue<File> blockingQueue = new ArrayBlockingQueue<>(BLOCKING_QUEUE_SIZE);
        FileEnumerationTask fileEnumerationTask = new FileEnumerationTask(blockingQueue, new File(directory));
        new Thread(fileEnumerationTask).start();
        for (int i = 0; i < SEARCH_THREADS; i++) {
            new Thread(new SearchTask(blockingQueue, keyword)).start();
        }
    }
}

class FileEnumerationTask implements Runnable{

    public static File DUMMY = new File("");
    private BlockingQueue<File> queue;
    private File startingDirectory;

    public FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory) {
        this.queue = queue;
        this.startingDirectory = startingDirectory;
    }

    @Override
    public void run() {
        try {
            enumeration(startingDirectory);
            queue.put(DUMMY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enumeration(File rootFile) throws InterruptedException {
            File[] files = rootFile.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        enumeration(file);
                    } else {
                        queue.put(file);
                    }
                }
            }
    }
}

class SearchTask implements Runnable{

    private BlockingQueue<File> queue;
    private String keyword;

    public SearchTask(BlockingQueue<File> queue, String keyword) {
        this.queue = queue;
        this.keyword = keyword;
    }

    @Override
    public void run() {
        try {
            boolean done = false;
            while (!done) {
                File file = queue.take();
                if (file == FileEnumerationTask.DUMMY) {
                    queue.put(file);
                    done = true;
                } else {
                    search(file);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void search(File file) {
        try {
            Scanner in = new Scanner(file);
            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber ++;
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
