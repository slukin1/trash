package com.hbg.lib.network.hbg.socket.response;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.retrofit.response.IResponse;
import java.io.Serializable;

public class BaseHbgResponse<T> implements IResponse, Serializable {
    public static final String STATUS_ERROR = "error";
    public static final String STATUS_OK = "ok";
    private static final long serialVersionUID = -8434372273715937272L;

    /* renamed from: ch  reason: collision with root package name */
    private String f70296ch;
    private T data;
    @SerializedName("err-code")
    private String errCode;
    @SerializedName("err-msg")
    private String errMsg;
    private String status;

    /* renamed from: ts  reason: collision with root package name */
    private long f70297ts;
    private long version;

    public boolean canEqual(Object obj) {
        return obj instanceof BaseHbgResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseHbgResponse)) {
            return false;
        }
        BaseHbgResponse baseHbgResponse = (BaseHbgResponse) obj;
        if (!baseHbgResponse.canEqual(this)) {
            return false;
        }
        String status2 = getStatus();
        String status3 = baseHbgResponse.getStatus();
        if (status2 != null ? !status2.equals(status3) : status3 != null) {
            return false;
        }
        String errCode2 = getErrCode();
        String errCode3 = baseHbgResponse.getErrCode();
        if (errCode2 != null ? !errCode2.equals(errCode3) : errCode3 != null) {
            return false;
        }
        String errMsg2 = getErrMsg();
        String errMsg3 = baseHbgResponse.getErrMsg();
        if (errMsg2 != null ? !errMsg2.equals(errMsg3) : errMsg3 != null) {
            return false;
        }
        String ch2 = getCh();
        String ch3 = baseHbgResponse.getCh();
        if (ch2 != null ? !ch2.equals(ch3) : ch3 != null) {
            return false;
        }
        if (getVersion() != baseHbgResponse.getVersion() || getTs() != baseHbgResponse.getTs()) {
            return false;
        }
        Object data2 = getData();
        Object data3 = baseHbgResponse.getData();
        return data2 != null ? data2.equals(data3) : data3 == null;
    }

    public String getCh() {
        return this.f70296ch;
    }

    public T getData() {
        return this.data;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getStatus() {
        return this.status;
    }

    public long getTs() {
        return this.f70297ts;
    }

    public long getVersion() {
        return this.version;
    }

    public int hashCode() {
        String status2 = getStatus();
        int i11 = 43;
        int hashCode = status2 == null ? 43 : status2.hashCode();
        String errCode2 = getErrCode();
        int hashCode2 = ((hashCode + 59) * 59) + (errCode2 == null ? 43 : errCode2.hashCode());
        String errMsg2 = getErrMsg();
        int hashCode3 = (hashCode2 * 59) + (errMsg2 == null ? 43 : errMsg2.hashCode());
        String ch2 = getCh();
        int hashCode4 = (hashCode3 * 59) + (ch2 == null ? 43 : ch2.hashCode());
        long version2 = getVersion();
        int i12 = (hashCode4 * 59) + ((int) (version2 ^ (version2 >>> 32)));
        long ts2 = getTs();
        int i13 = (i12 * 59) + ((int) (ts2 ^ (ts2 >>> 32)));
        Object data2 = getData();
        int i14 = i13 * 59;
        if (data2 != null) {
            i11 = data2.hashCode();
        }
        return i14 + i11;
    }

    public boolean isSuccess() {
        return this.data != null;
    }

    public void setCh(String str) {
        this.f70296ch = str;
    }

    public void setData(T t11) {
        this.data = t11;
    }

    public void setErrCode(String str) {
        this.errCode = str;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTs(long j11) {
        this.f70297ts = j11;
    }

    public void setVersion(long j11) {
        this.version = j11;
    }

    public String toString() {
        return "BaseHbgResponse(status=" + getStatus() + ", errCode=" + getErrCode() + ", errMsg=" + getErrMsg() + ", ch=" + getCh() + ", version=" + getVersion() + ", ts=" + getTs() + ", data=" + getData() + ")";
    }
}
