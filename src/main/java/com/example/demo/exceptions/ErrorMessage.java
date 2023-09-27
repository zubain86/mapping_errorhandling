package com.example.demo.exceptions;


import java.util.Date;

public class ErrorMessage {
    private String errorMessage;
    private Date timestamp;

    public ErrorMessage() {
    }

    public ErrorMessage(String errorMessage, Date timestamp) {
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
