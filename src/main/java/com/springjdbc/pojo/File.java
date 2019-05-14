package com.springjdbc.pojo;

public class File {
    private Integer id;
    private String fileUploader;
    private String path;
    private String fileName;

    public File(Integer id, String fileUploader, String path) {
        this.id = id;
        this.fileUploader = fileUploader;
        this.path = path;
    }

    public File(String fileUploader, String path) {
        this.fileUploader = fileUploader;
        this.path = path;
    }

    public File(String fileUploader, String path, String fileName) {
        this.fileUploader = fileUploader;
        this.path = path;
        this.fileName = fileName;
    }

    public File() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileUploader() {
        return fileUploader;
    }

    public void setFileUploader(String fileUploader) {
        this.fileUploader = fileUploader;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
