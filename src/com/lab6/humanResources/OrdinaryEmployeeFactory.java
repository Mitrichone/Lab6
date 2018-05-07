package com.lab6.humanResources;

import com.lab6.io.GroupsManagerSerializedFileSource;

public class OrdinaryEmployeeFactory extends EmployeeFactory {
    private GroupsManagerSerializedFileSource source;

    public OrdinaryEmployeeFactory() {
        source = new GroupsManagerSerializedFileSource();
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
        Department department = new Department();
        source.create(department);
        return department;
    }

    @Override
    EmployeeGroup createDepartment(String name){
        Department department = new Department(name);
        source.create(department);
        return department;
    }

    @Override
    EmployeeGroup createDepartment(String name, int size){
        Department department = new Department(name, size);
        source.create(department);
        return department;
    }

    @Override
    EmployeeGroup createDepartment(String name, Employee[] employees){
        Department department = new Department(name, employees);
        source.create(department);
        return department;
    }

    @Override
    EmployeeGroup createProject(){
        Project project = new Project();
        source.create(project);
        return project;
    }

    @Override
    EmployeeGroup createProject(String name){
        Project project = new Project(name);
        source.create(project);
        return project;

    }

    @Override
    EmployeeGroup createProject(String name, Employee[] employees){
        Project project = new Project(name, employees);
        source.create(project);
        return project;
    }

    @Override
    GroupsManager createDepartmentManager(){
        DepartmentsManager departmentsManager = new DepartmentsManager();
        //source? //todo ЧТО МНЕ ДЕЛАТЬ?
        return departmentsManager;
    }

    @Override
    GroupsManager createDepartmentManager(String name, int size){
        DepartmentsManager departmentsManager = new DepartmentsManager(name, size);
        //source? //todo КАК ДАЛЬШЕ ЖИТЬ?
        return departmentsManager;
    }

    @Override
    GroupsManager createDepartmentManager(String name, EmployeeGroup[] employeeGroups){
        DepartmentsManager departmentsManager = new DepartmentsManager(name, employeeGroups);
        //source? //todo О НЕЕЕЕЕТ!
        return departmentsManager;
    }

    @Override
    GroupsManager createProjectManager(){
        ProjectsManager projectsManager = new ProjectsManager();
        //source? //todo ПОМОГИТЕ!
        return projectsManager;
    }

    @Override
    GroupsManager createProjectManager(EmployeeGroup[] employeeGroups){
        ProjectsManager projectsManager = new ProjectsManager(employeeGroups);
        //source? //todo ПОЖАЛУЙСТА!
        return projectsManager;
    }
}
