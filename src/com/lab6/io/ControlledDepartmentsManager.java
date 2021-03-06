package com.lab6.io;

import com.lab6.humanResources.DepartmentsManager;
import com.lab6.humanResources.Employee;
import com.lab6.humanResources.EmployeeGroup;

import javax.swing.text.html.HTMLDocument;
import java.util.Collection;
import java.util.Iterator;

public class ControlledDepartmentsManager extends DepartmentsManager {
    protected Source<EmployeeGroup> employeeGroupSource;
    public ControlledDepartmentsManager(){
        super();
    }
    public ControlledDepartmentsManager(String name){
        super(name);
    }

    public ControlledDepartmentsManager(String name, int size){
        super(name, size);
    }

    public ControlledDepartmentsManager(String name, EmployeeGroup[] employeeGroups){
        super(name, employeeGroups);
    }


    @Override
    public boolean add(EmployeeGroup employeeGroup) {
        ControlledDepartment controlledDepartment =
                new ControlledDepartment(employeeGroup.getName(), (Employee[]) employeeGroup.toArray());
        employeeGroupSource.create(controlledDepartment);

        return super.add(employeeGroup);
    }

    @Override
    public int remove(EmployeeGroup employeeGroup){
        employeeGroupSource.delete(employeeGroup);

        return super.remove(employeeGroup);
    }

    @Override
    public boolean addAll(Collection<? extends EmployeeGroup> c) {
        for (EmployeeGroup employeeGroup: c) {
            ControlledDepartment controlledDepartment =
                    new ControlledDepartment(employeeGroup.getName(), (Employee[]) employeeGroup.toArray());
            employeeGroupSource.create(controlledDepartment);
        }

        return super.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o: c) {
            if(super.contains(o)){
                employeeGroupSource.delete((EmployeeGroup) o);
            }
        }
        return super.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean changed = false;
        for (EmployeeGroup o: super.getEmployeeGroups()) {
            if(!c.contains(o)){
                employeeGroupSource.delete((EmployeeGroup) o);
            }
        }
        return super.retainAll(c);
    }

    public void store(){
        Iterator iterator = super.iterator();
        while(iterator.hasNext()){
            ControlledDepartment controlledDepartment = (ControlledDepartment) iterator.next();
            if(controlledDepartment.isChanged)
                employeeGroupSource.store(controlledDepartment);
        }
    }

    public void load(){
        Iterator iterator = super.iterator();
        while(iterator.hasNext()){
            ControlledDepartment controlledDepartment = (ControlledDepartment) iterator.next();
            employeeGroupSource.load(controlledDepartment);
        }
    }

    public Source<EmployeeGroup> getEmployeeGroupSource() {
        return employeeGroupSource;
    }

    public void setEmployeeGroupSource(Source<EmployeeGroup> employeeGroupSource) {
        this.employeeGroupSource = employeeGroupSource;
    }
}