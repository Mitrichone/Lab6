package com.lab6.io;

import com.lab6.humanResources.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class GroupsManagerTextFileSource extends GroupsManagerFileSource {
    public String getPath() {
        return super.getPath();
    }

    public void setPath(String path) {
        super.setPath(path);
    }

    public void load(EmployeeGroup employeeGroup) {
        File file = new File(super.getPath());
        try(Scanner sc = new Scanner(file)){
            switch (sc.nextLine().trim()) {
                case "Department":
                    employeeGroup = new Department(file.getName());
                    break;
                case "Project":
                    employeeGroup = new Project(file.getName());
                    break;
            }
            int size = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < size; i++) {
                switch (sc.nextLine().trim()) {
                    case "PartTimeEmployee":
                        employeeGroup.add(new PartTimeEmployee(
                                sc.nextLine(),
                                sc.nextLine(),
                                JobTitlesEnum.valueOf(sc.nextLine()),
                                Integer.parseInt(sc.nextLine())));
                        break;
                    case "StaffEmployee":
                        StaffEmployee staffEmployee = new StaffEmployee(
                                sc.nextLine(),
                                sc.nextLine(),
                                JobTitlesEnum.valueOf(sc.nextLine()),
                                Integer.parseInt(sc.nextLine()),
                                Integer.parseInt(sc.nextLine()));
                        int travelsQuantity = Integer.parseInt(sc.nextLine());
                        for(int j = 0; j < travelsQuantity; j++){
                            BusinessTravel businessTravel = new BusinessTravel(
                                    sc.nextLine(),
                                    LocalDate.parse(sc.nextLine()), //default "yyyy-MM-d"
                                    LocalDate.parse(sc.nextLine()),
                                    Integer.parseInt(sc.nextLine()),
                                    sc.nextLine());
                            staffEmployee.add(businessTravel);
                        }
                        employeeGroup.add(staffEmployee);
                        break;
                }

            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public void store(EmployeeGroup employeeGroup) {
        StringBuilder stringBuilder = new StringBuilder(employeeGroup.getClass().getName());
        stringBuilder.append('\n')
                .append(employeeGroup.size());
        for (Employee employee : employeeGroup) {
            stringBuilder.append('\n')
                    .append(employee.getClass().getName())
                    .append('\n')
                    .append(employee.getFirstName())
                    .append('\n')
                    .append(employee.getSecondName())
                    .append('\n')
                    .append(employee.getJobTitle())
                    .append('\n')
                    .append(employee.getSalary());
            if (employee instanceof StaffEmployee) {
                stringBuilder.append('\n')
                        .append(((StaffEmployee) employee).getTravelsQuantity());
                for (BusinessTravel businessTravel : ((StaffEmployee) employee)) {
                    stringBuilder.append('\n')
                            .append(businessTravel.getDestination())
                            .append('\n')
                            .append(businessTravel.getDayStart().toString())
                            .append('\n')
                            .append(businessTravel.getDayStart().toString())
                            .append('\n')
                            .append(businessTravel.getDescription());
                }
            }
        }
        try(PrintWriter printWriter = new PrintWriter(new File(super.getPath()))){
            printWriter.write(stringBuilder.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(EmployeeGroup employeeGroup) {
        employeeGroup.clear();
        try {
            File file = new File(super.getPath());
            file.delete();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void create(EmployeeGroup employeeGroup) {
        store(employeeGroup);
    }
}
