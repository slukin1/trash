package com.huobi.network.interceptor;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.huobi.network.interceptor.LoganInterceptor;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

public class RiskLoganInterceptor extends LoganInterceptor {

    public class RiskErrorResponse extends LoganInterceptor.ResponseError {
        @SerializedName("code")
        private int code;
        @SerializedName("message")
        private String message;

        public RiskErrorResponse() {
            super();
        }

        public String getErrCode() {
            return String.valueOf(this.code);
        }

        public String getErrMsg() {
            return this.message;
        }

        public boolean isSuccess() {
            return this.code == 200;
        }
    }

    public LoganInterceptor.ResponseError a(String str, String str2) {
        return (LoganInterceptor.ResponseError) new Gson().fromJson(str2, RiskErrorResponse.class);
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        return super.intercept(chain);
    }
}
