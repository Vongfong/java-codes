package com.dragon.book.javacore.chapter14.threadPool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the directory");
        String directory = in.nextLine();
        System.out.println("Enter the keyword");
        String keyword = in.nextLine();

        ExecutorService pool = Executors.newCachedThreadPool();

        MatchCounter matchCounter = new MatchCounter(new File(directory), keyword, pool);
        Future<Integer> result = pool.submit(matchCounter);
        try {
            System.out.println(result.get() + " matching files");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();

        int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
        System.out.println("the largestPoolSize is " + largestPoolSize);
    }
}

class MatchCounter implements Callable<Integer> {

    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MatchCounter(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        List<Future<Integer>> results = new ArrayList<>();
        File[] lists = directory.listFiles();
        if (lists != null) {
            for (File file : lists) {
                if (file.isDirectory()) {
                    MatchCounter matchCounter = new MatchCounter(file, keyword, pool);
                    Future<Integer> result = pool.submit(matchCounter);
                    results.add(result);
                } else {
                    if (search(file)) {
                        count ++;
                    }
                }
            }
        }

        for (Future<Integer> result : results) {
            count += result.get();
        }
        return count;
    }

    public boolean search(File file) throws FileNotFoundException {
        boolean found = false;
        Scanner in = new Scanner(file);
        while (!found && in.hasNextLine()) {
            String line = in.nextLine();
            if (line.contains(keyword)) {
                found = true;
            }
        }
        return found;
    }
}
