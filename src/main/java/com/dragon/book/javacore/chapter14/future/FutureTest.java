package com.dragon.book.javacore.chapter14.future;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * User: dengshenyan
 * Time: 2018-12-20 9:27
 */
public class FutureTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a base directory");
        String directory = in.nextLine();
        System.out.println("Enter keyword");
        String keyword = in.nextLine();

        MatchCounter matchCounter = new MatchCounter(new File(directory), keyword);
        FutureTask<Integer> futureTask = new FutureTask<>(matchCounter);
        new Thread(futureTask).start();
        try {
            System.out.println("all file count: " + futureTask.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MatchCounter implements Callable<Integer> {

    private File directoryFile;
    private String keyword;
    private int count;

    public MatchCounter(File directoryFile, String keyword) {
        this.directoryFile = directoryFile;
        this.keyword = keyword;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        File[] files = directoryFile.listFiles();
        List<FutureTask<Integer>> results = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    MatchCounter matchCounter = new MatchCounter(file, keyword);
                    FutureTask<Integer> task = new FutureTask<>(matchCounter);
                    results.add(task);
                    Thread t = new Thread(task);
                    t.start();
                } else {
                    if (search(file)) {
                        count ++;
                    }
                }
            }
        }

        for (FutureTask<Integer> result : results) {
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
