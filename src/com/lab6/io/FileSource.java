package com.lab6.io;

import com.lab6.humanResources.EmployeeGroup;

public interface FileSource extends Source<EmployeeGroup> {
    void setPath(String path);  // – изменяющий путь к файлу, в который записывается состояние объекта
    String getPath();           // – возвращающий путь к файлу, в который записывается состояние объекта
}
