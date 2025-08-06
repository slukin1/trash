package com.cloud.sdk;

public class ServiceException extends ClientException {
    private static final long serialVersionUID = 1;
    private String errorCode;
    private String errorMessage;
    private ErrorType errorType = ErrorType.Unknown;
    private String requestId;
    private String serviceName;
    private int statusCode;

    public enum ErrorType {
        Client,
        Service,
        Unknown
    }

    public ServiceException(String str) {
        super((String) null);
        this.errorMessage = str;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    public String getMessage() {
        return getErrorMessage() + " (Service: " + getServiceName() + "; Status Code: " + getStatusCode() + "; Error Code: " + getErrorCode() + "; Request ID: " + getRequestId() + ")";
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorType(ErrorType errorType2) {
        this.errorType = errorType2;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public void setStatusCode(int i11) {
        this.statusCode = i11;
    }

    public ServiceException(String str, Exception exc) {
        super((String) null, exc);
        this.errorMessage = str;
    }
}
