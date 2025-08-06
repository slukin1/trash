package com.kakao.network.response;

import com.kakao.network.exception.ResponseStatusError;

public class ApiResponseStatusError extends ResponseStatusError {
    private static final long serialVersionUID = 3702596857996303483L;
    private final int errorCode;
    private final String errorMsg;
    private ResponseBody errorResponse;
    private final int httpStatusCode;

    public ApiResponseStatusError(int i11, String str, int i12) {
        super(str);
        this.errorCode = i11;
        this.errorMsg = str;
        this.httpStatusCode = i12;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public ResponseBody getErrorResponse() {
        return this.errorResponse;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public ApiResponseStatusError(int i11, String str, int i12, ResponseBody responseBody) {
        this(i11, str, i12);
        this.errorResponse = responseBody;
    }
}
