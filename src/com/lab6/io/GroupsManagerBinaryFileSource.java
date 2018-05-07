package com.lab6.io;

import com.lab6.humanResources.*;

import java.io.*;
import java.time.LocalDate;

public class GroupsManagerBinaryFileSource extends GroupsManagerFileSource {
    public String getPath() {
        return super.getPath();
    }

    public void setPath(String path) {
        super.setPath(path);
    }

    public void load(EmployeeGroup employeeGroup) {
        File file = new File(super.getPath());
        try(DataInputStream in = new DataInputStream(new FileInputStream("data.bin")))
        {
            switch (in.readUTF()) {
                case "Department":
                    employeeGroup = new Department(file.getName());
                    break;
                case "Project":
                    employeeGroup = new Project(file.getName());
                    break;
            }
            int size = in.readInt();
            for (int i = 0; i < size; i++) {
                switch (in.readUTF()) {
                    case "PartTimeEmployee":
                        employeeGroup.add(new PartTimeEmployee(
                                in.readUTF(),
                                in.readUTF(),
                                JobTitlesEnum.valueOf(in.readUTF()),
                                in.readInt()));
                        break;
                    case "StaffEmployee":
                        StaffEmployee staffEmployee = new StaffEmployee(
                                in.readUTF(),
                                in.readUTF(),
                                JobTitlesEnum.valueOf(in.readUTF()),
                                in.readInt(),
                                in.readInt());
                        int travelsQuantity = Integer.parseInt(in.readUTF());
                        for(int j = 0; j < travelsQuantity; j++){
                            BusinessTravel businessTravel = new BusinessTravel(
                                    in.readUTF(),
                                    LocalDate.parse(in.readUTF()), //default "yyyy-MM-d"
                                    LocalDate.parse(in.readUTF()),
                                    in.readInt(),
                                    in.readUTF());
                            staffEmployee.add(businessTravel);
                        }
                        employeeGroup.add(staffEmployee);
                        break;
                }

            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void store(EmployeeGroup employeeGroup) {
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(super.getPath()))) {
            out.writeUTF(employeeGroup.getClass().getName());
            out.writeInt(employeeGroup.size());
            for (Employee employee : employeeGroup) {
                out.writeUTF(employee.getClass().getName());
                out.writeUTF(employee.getFirstName());
                out.writeUTF(employee.getSecondName());
                out.writeUTF(employee.getJobTitle().toString());
                out.writeInt(employee.getSalary());
                if (employee instanceof StaffEmployee) {
                    out.writeInt(((StaffEmployee) employee).getTravelsQuantity());
                    for (BusinessTravel businessTravel : ((StaffEmployee) employee)) {
                        out.writeUTF(businessTravel.getDestination());
                        out.writeUTF(businessTravel.getDayStart().toString());
                        out.writeUTF(businessTravel.getDayStart().toString());
                        out.writeUTF(businessTravel.getDescription());
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(EmployeeGroup employeeGroup) {
        employeeGroup.clear();
        try {
            PrintWriter printWriter = new PrintWriter(new File(super.getPath()));
            printWriter.write("");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void create(EmployeeGroup employeeGroup) {
        store(employeeGroup);
    }
}
