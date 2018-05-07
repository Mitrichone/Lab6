package com.lab6.humanResources;


import com.lab6.io.*;

public class BinaryFileBasedEmployeeFactory extends EmployeeFactory {
    private GroupsManagerBinaryFileSource source;

    public BinaryFileBasedEmployeeFactory() {
        source = new GroupsManagerBinaryFileSource();
    }

    public void setPath(String path)
    {
        source.setPath(path);
    }
    public String getPath()
    {
        return source.getPath();
    }

    @Override
    EmployeeGroup createDepartment(){
        ControlledDepartment controlledDepartment = new ControlledDepartment();
        source.create(controlledDepartment);
        return controlledDepartment;
    }

    @Override
    EmployeeGroup createDepartment(String name){
        ControlledDepartment controlledDepartment = new ControlledDepartment(name);
        source.create(controlledDepartment);
        return controlledDepartment;
    }

    @Override
    EmployeeGroup createDepartment(String name, int size){
        ControlledDepartment controlledDepartment = new ControlledDepartment(name, size);
        source.create(controlledDepartment);
        return controlledDepartment;
    }

    @Override
    EmployeeGroup createDepartment(String name, Employee[] employees){
        ControlledDepartment controlledDepartment = new ControlledDepartment(name, employees);
        source.create(controlledDepartment);
        return controlledDepartment;
    }

    @Override
    EmployeeGroup createProject(){
        ControlledProject controlledProject = new ControlledProject();
        source.create(controlledProject);
        return controlledProject;
    }

    @Override
    EmployeeGroup createProject(String name){
        ControlledProject controlledProject = new ControlledProject(name);
        source.create(controlledProject);
        return controlledProject;

    }

    @Override
    EmployeeGroup createProject(String name, Employee[] employees){
        ControlledProject controlledProject = new ControlledProject(name, employees);
        source.create(controlledProject);
        return controlledProject;
    }

    @Override
    GroupsManager createDepartmentManager(){
        ControlledDepartmentsManager departmentsManager = new ControlledDepartmentsManager();
        //source? //todo ЧТО МНЕ ДЕЛАТЬ?
        return departmentsManager;
    }

    @Override
    GroupsManager createDepartmentManager(String name, int size){
        ControlledDepartmentsManager departmentsManager = new ControlledDepartmentsManager(name, size);
        //source? //todo КАК ДАЛЬШЕ ЖИТЬ?
        return departmentsManager;
    }

    @Override
    GroupsManager createDepartmentManager(String name, EmployeeGroup[] employeeGroups){
        ControlledDepartmentsManager departmentsManager = new ControlledDepartmentsManager(name, employeeGroups);
        //source? //todo О НЕЕЕЕЕТ!
        return departmentsManager;
    }

    @Override
    GroupsManager createProjectManager(){
        ControlledProjectsManager projectsManager = new ControlledProjectsManager();
        //source? //todo ПОМОГИТЕ!
        return projectsManager;
    }

    @Override
    GroupsManager createProjectManager(EmployeeGroup[] employeeGroups){
        ControlledProjectsManager projectsManager = new ControlledProjectsManager(employeeGroups);
        //source? //todo ПОЖАЛУЙСТА!
        return projectsManager;
    }
}
