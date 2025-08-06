package com.hbg.lib.network.pro.socket.response;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.retrofit.response.IResponse;
import java.io.Serializable;

public class ContractAuthenticationResponse implements IResponse {
    private UserId data;
    @SerializedName("err-code")
    private int errCode;
    @SerializedName("err-msg")
    private String errMsg;

    public class UserId implements Serializable {
        @SerializedName("user-id")
        public String userId;

        public UserId() {
        }

        public String toString() {
            return "UserId{userId='" + this.userId + '\'' + '}';
        }
    }

    public UserId getData() {
        return this.data;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getResponseUid() {
        UserId userId = this.data;
        return userId == null ? "" : userId.userId;
    }

    public boolean isSuccess() {
        return true;
    }

    public void setData(UserId userId) {
        this.data = userId;
    }

    public void setErrCode(int i11) {
        this.errCode = i11;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public String toString() {
        return "ContractAuthenticationResponse{errMsg='" + this.errMsg + '\'' + ", errCode=" + this.errCode + ", data='" + this.data + '\'' + '}';
    }
}
