package com.dragon.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by dsy on 2018/1/19
 */
public class IOUtils {

    public static void main(String[] args) {
        copy();
    }

    public static void copy() {
        try {
            System.out.println(System.getProperty("user.dir"));

            FileInputStream fileInputStream = new FileInputStream("test.txt");
            OutputStream outputStream = new FileOutputStream("test2.txt");
            byte[] bytes = new byte[8192];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(bytes, 0, bytes.length)) != -1) {
                System.out.println(bytes.length);
                outputStream.write(bytes, 0, bytesRead);
            }
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
