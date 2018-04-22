package com.company.LiveTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private Integer age;
    private Double salary;
    private Department department;

    public Employee(String name, Integer age, Double salary, Department department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String toString(){
        return "Employee Name:"+this.name;
    }



}
//Enum Department.java
enum Department {
    HR, OPERATIONS, LEGAL, MARKETING
}



public class J8GroupingBy {

    static List<Employee> employeeList = Arrays.asList(
            new Employee("Tom Jones", 45, 12000.00,Department.MARKETING),
            new Employee("Harry Major", 26, 20000.00, Department.LEGAL),
            new Employee("Ethan Hardy", 65, 30000.00, Department.LEGAL),
            new Employee("Nancy Smith", 22, 15000.00, Department.MARKETING),
            new Employee("Catherine Jones", 21, 18000.00, Department.HR),
            new Employee("James Elliot", 58, 24000.00, Department.OPERATIONS),
            new Employee("Frank Anthony", 55, 32000.00, Department.MARKETING),
            new Employee("Michael Reeves", 40, 45000.00, Department.OPERATIONS));

    public static void main(String[] args) {
        Map<Department, List<Employee>> employeeMap =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        employeeMap.forEach((department, employees) -> System.out.println(department+" -> "+employees));




    }
}
