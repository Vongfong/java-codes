package com.dragon.book.javacore.chapter4.equals;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Employee {

    String name;

    private double salary;

    private Date hireDay;

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month -1, day);
        hireDay = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Employee otherObj = (Employee) obj;

        return Objects.equals(name, otherObj.name) &&
                salary == otherObj.salary && Objects.equals(hireDay, otherObj.hireDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + "salary=" + salary + "hireday=" + hireDay + "]";
    }
}
