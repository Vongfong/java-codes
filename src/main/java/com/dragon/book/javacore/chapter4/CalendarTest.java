package com.dragon.book.javacore.chapter4;

import com.dragon.book.javacore.chapter4.abstractClasses.Person;
import com.dragon.book.javacore.chapter4.abstractClasses.Student;

import java.text.DateFormatSymbols;
import java.util.*;

/**
 * @version 1.4 2007-04-07
 * @author Cay Horstmann
 */

public class CalendarTest
{
   public static void main(String[] args) {
      Object person = new Student("job", "steve");
      Person[] people = new Person[3];
      people[0] = (Student)person;
      people[1] = (Student)person;
      people[2] = (Student)person;
      person = people;
      System.out.println(person);
      // 创建日历
      GregorianCalendar d = new GregorianCalendar();

      int today = d.get(Calendar.DAY_OF_MONTH);
      int month = d.get(Calendar.MONTH);

      // 设置为第一天
      d.set(Calendar.DAY_OF_MONTH, 1);

      int weekday = d.get(Calendar.DAY_OF_WEEK);
      int firstDayWeek = d.getFirstDayOfWeek();

      // 设置首行的缩进
      int indent = 0;
      while (weekday != firstDayWeek) {
          indent ++;
          d.add(Calendar.DAY_OF_MONTH, -1);
          weekday = d.get(Calendar.DAY_OF_WEEK);
      }

      String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
      do {
         System.out.printf("%4s", weekdayNames[weekday]);
         d.add(Calendar.DAY_OF_MONTH, 1);
         weekday = d.get(Calendar.DAY_OF_WEEK);
      } while (weekday != firstDayWeek);
      System.out.println();
      for (int i = 1; i <= indent; i++) {
         System.out.print("    ");
      }

      d.set(Calendar.DAY_OF_MONTH, 1);

      do
      {
         // print day
         int day = d.get(Calendar.DAY_OF_MONTH);
         System.out.printf("%5d", day);

         // mark current day with *
         if (day == today) System.out.print("*");
         else System.out.print(" ");

         // advance d to the next day
         d.add(Calendar.DAY_OF_MONTH, 1);
         weekday = d.get(Calendar.DAY_OF_WEEK);

         // start a new line at the start of the week
         if (weekday == firstDayWeek) System.out.println();
      }
      while (d.get(Calendar.MONTH) == month);
      // the loop exits when d is day 1 of the next month

      // print final end of line if necessary
      if (weekday != firstDayWeek) System.out.println();


   }























/*   public static void main(String[] args)
   {
      // construct d as current date
      GregorianCalendar d = new GregorianCalendar();

      int today = d.get(Calendar.DAY_OF_MONTH);
      int month = d.get(Calendar.MONTH);

      // set d to start date of the month
      d.set(Calendar.DAY_OF_MONTH, 1);

      int weekday = d.get(Calendar.DAY_OF_WEEK);

      // get first day of week (Sunday in the U.S.)
      int firstDayOfWeek = d.getFirstDayOfWeek();

      // determine the required indentation for the first line
      int indent = 0;
      while (weekday != firstDayOfWeek)
      {
         indent++;
         d.add(Calendar.DAY_OF_MONTH, -1);
         weekday = d.get(Calendar.DAY_OF_WEEK);
      }

      // print weekday names
      String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
      do
      {
         System.out.printf("%4s", weekdayNames[weekday]);
         d.add(Calendar.DAY_OF_MONTH, 1);
         weekday = d.get(Calendar.DAY_OF_WEEK);
      }
      while (weekday != firstDayOfWeek);
      System.out.println();

      for (int i = 1; i <= indent; i++)
         System.out.print("    ");

      d.set(Calendar.DAY_OF_MONTH, 1);
      do
      {
         // print day
         int day = d.get(Calendar.DAY_OF_MONTH);
         System.out.printf("%5d", day);

         // mark current day with *
         if (day == today) System.out.print("*");
         else System.out.print(" ");

         // advance d to the next day
         d.add(Calendar.DAY_OF_MONTH, 1);
         weekday = d.get(Calendar.DAY_OF_WEEK);

         // start a new line at the start of the week
         if (weekday == firstDayOfWeek) System.out.println();
      }
      while (d.get(Calendar.MONTH) == month);
      // the loop exits when d is day 1 of the next month

      // print final end of line if necessary
      if (weekday != firstDayOfWeek) System.out.println();
   }*/
}
