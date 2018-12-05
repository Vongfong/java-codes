package com.dragon.book.javacore.chapter6.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
   @version 1.00 2000-04-13
   @author Cay Horstmann
*/

// to resolve conflict with java.util.Timer

public class TimerTest
{
   public static void main(String[] args) {
      ActionListener listener = new TimerPrinter();
      Timer t = new Timer(1000, listener);
      t.start();
      JOptionPane.showMessageDialog(null, "Quit program?");
      System.exit(0);
   }
}

class TimerPrinter implements ActionListener {

   @Override
   public void actionPerformed(ActionEvent e) {
      Date date = new Date();
      System.out.println("At the zone, the time is " + date);
      Toolkit.getDefaultToolkit().beep();
   }
}
