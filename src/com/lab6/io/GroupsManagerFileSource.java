package com.lab6.io;

public abstract class GroupsManagerFileSource implements FileSource {
    private String path;

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
