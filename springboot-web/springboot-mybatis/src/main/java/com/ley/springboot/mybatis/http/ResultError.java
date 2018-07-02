package com.ley.springboot.mybatis.http;

/**
 * Result error is has errorObject,errorField,errorMessage fields and this class
 * is use to encapsulation(封装) field error message
 * @author  LiuEnYuan
 * @version  2.0.0
 * **/
public class ResultError {

    /***
     * Error entity class name
     * */
    private String className;

    /**
     * Error object name
     * **/
    private String errorObjectName;

    /**
     * Error field name
     * **/
    private String errorField;

    /**
     * Error field message
     * **/
    private String errorMessage;

    public ResultError() {
    }

    public ResultError(String className, String errorObjectName, String errorField, String errorMessage) {
        this.className = className;
        this.errorObjectName = errorObjectName;
        this.errorField = errorField;
        this.errorMessage = errorMessage;
    }

    public String getErrorObjectName() {
        return errorObjectName;
    }

    public void setErrorObjectName(String errorObjectName) {
        this.errorObjectName = errorObjectName;
    }

    public String getErrorField() {
        return errorField;
    }

    public void setErrorField(String errorField) {
        this.errorField = errorField;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"className\":\"")
                .append(className).append('\"');
        sb.append(",\"errorObjectName\":\"")
                .append(errorObjectName).append('\"');
        sb.append(",\"errorField\":\"")
                .append(errorField).append('\"');
        sb.append(",\"errorMessage\":\"")
                .append(errorMessage).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
