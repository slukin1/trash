package com.huobi.network.interceptor;

import com.google.gson.annotations.SerializedName;
import com.huobi.network.interceptor.BaseTokenErrorCheckInterceptor;

public class ContractErrorCheckInterceptor$HbdmErrorHandleResponse extends BaseTokenErrorCheckInterceptor.BaseTokenErrorHandleResponse {
    @SerializedName("err_code")
    private int errCode;
    @SerializedName("err_msg")
    private String errMsg;
    private String status;

    public String getErrCode() {
        return String.valueOf(this.errCode);
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean isSuccess() {
        return "OK".equalsIgnoreCase(this.status);
    }

    public boolean isTokenError() {
        int i11 = this.errCode;
        return i11 == 1029 || i11 == 1011;
    }
}
