package com.lab6.humanResources;

public abstract class EmployeeFactory {
    abstract EmployeeGroup createDepartment();
    //region other constructors
        abstract EmployeeGroup createDepartment(String name);
        abstract EmployeeGroup createDepartment(String name, int size);
        abstract EmployeeGroup createDepartment(String name, Employee[] employees);
    //endregion

    abstract EmployeeGroup createProject();
    //region other constructors
        abstract EmployeeGroup createProject(String name);
        abstract EmployeeGroup createProject(String name, Employee[] employees);
    //endregion

    abstract GroupsManager createDepartmentManager();
    //region other constructors
        abstract GroupsManager createDepartmentManager(String name, int size);
        abstract GroupsManager createDepartmentManager(String name, EmployeeGroup[] employeeGroups);
    //endregion

    abstract GroupsManager createProjectManager();
    //region other constructors
        abstract GroupsManager createProjectManager(EmployeeGroup[] employeeGroups);
    //endregion

    static public EmployeeFactory getEmployeeFactory(EmployeeFactoryTypesEnumeration type){
        switch (type){
            case ORDINARY_GROUPS_FACTORY:
                return new OrdinaryEmployeeFactory();
            case TEXT_FILE_BASED_GROUPS_FACTORY:
                return new TextFileBasedEmployeeFactory();
            case BINARY_FILE_BASED_GROUPS_FACTORY:
                return new BinaryFileBasedEmployeeFactory();
            case SERIALIZED_FILE_BASED_GROUPS_FACTORY:
                return new SerializedFileBasedEmployeeFactory();
            case SOCKET_BASED_GROUPS_FACTORY:
                //todo ?????
                return new OrdinaryEmployeeFactory();
        }
        return new OrdinaryEmployeeFactory();
    }
}
