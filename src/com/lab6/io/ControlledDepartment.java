package com.lab6.io;

import com.lab6.humanResources.Department;
import com.lab6.humanResources.Employee;
import com.lab6.humanResources.JobTitlesEnum;

import java.util.Collection;

public class ControlledDepartment extends Department {

    protected boolean isChanged = false;
    private final static int DEFAULT_CAPACITY = 8;

    public ControlledDepartment(){
        super();
    }
    public ControlledDepartment(String name){
        super(name, DEFAULT_CAPACITY);
    }
    public ControlledDepartment(String name, int size) {
        super(name, size);
    }
    public ControlledDepartment(String name, Employee[] employees) {
        super(name, employees);
    }

    protected boolean isChanged(){
        return isChanged;
    }

    @Override
    public boolean remove(String firstName, String secondName) {
        isChanged = true;
        return super.remove(firstName, secondName);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        isChanged = true;
    }

    @Override
    public int removeAll(JobTitlesEnum jobTitlesEnum) {
        isChanged = true;
        return super.removeAll(jobTitlesEnum);
    }

    @Override
    public boolean add(Employee employee) {
        isChanged = true;
        return super.add(employee);
    }

    @Override
    public boolean remove(Object o) {
        isChanged = true;
        return super.remove(o);
    }

    @Override
    public boolean addAll(Collection<? extends Employee> c) {
        isChanged = true;
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Employee> c) {
        isChanged = true;
        return super.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        isChanged = true;
        return super.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        isChanged = true;
        return super.retainAll(c);
    }

    @Override
    public void add(int index, Employee element) {
        isChanged = true;
        super.add(index, element);
    }

    @Override
    public Employee remove(int index) {
        isChanged = true;
        return super.remove(index);
    }

    @Override
    public void clear() {
        isChanged = true;
        super.clear();
    }
}
