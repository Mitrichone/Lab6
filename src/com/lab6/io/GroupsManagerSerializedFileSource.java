package com.lab6.io;

import com.lab6.humanResources.EmployeeGroup;

import java.io.*;

public class GroupsManagerSerializedFileSource extends GroupsManagerFileSource {
    public String getPath() {
        return super.getPath();
    }

    public void setPath(String path) {
        super.setPath(path);
    }

    public void load(EmployeeGroup employeeGroup) {
        try{
            FileInputStream fileInputStream = new FileInputStream(new File(super.getPath()));
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            employeeGroup = (EmployeeGroup) in.readObject();
            in.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void store(EmployeeGroup employeeGroup) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(super.getPath()));
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(employeeGroup);
            out.flush();
            out.close();
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
