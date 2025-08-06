package com.huobi.network.interceptor;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.huobi.network.interceptor.LoganInterceptor;

public class ContractLoganInterceptor extends LoganInterceptor {

    public class ContractErrorResponse extends LoganInterceptor.ResponseError {
        @SerializedName("err_code")
        private int errCode;
        @SerializedName("err_msg")
        private String errMsg;
        @SerializedName("status")
        private String status;

        public ContractErrorResponse() {
            super();
        }

        public String getErrCode() {
            return String.valueOf(this.errCode);
        }

        public String getErrMsg() {
            return this.errMsg;
        }

        public boolean isSuccess() {
            return "OK".equalsIgnoreCase(this.status);
        }
    }

    public LoganInterceptor.ResponseError a(String str, String str2) {
        return (LoganInterceptor.ResponseError) new Gson().fromJson(str2, ContractErrorResponse.class);
    }
}
