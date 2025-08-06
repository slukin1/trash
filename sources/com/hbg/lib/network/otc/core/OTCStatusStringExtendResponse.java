package com.hbg.lib.network.otc.core;

import com.hbg.lib.network.retrofit.response.IResponse;

public class OTCStatusStringExtendResponse<T> implements IResponse {
    private static final long serialVersionUID = -5465868120561652059L;
    private int code;
    private T data;
    private String extend;
    private String message;

    public boolean canEqual(Object obj) {
        return obj instanceof OTCStatusStringExtendResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OTCStatusStringExtendResponse)) {
            return false;
        }
        OTCStatusStringExtendResponse oTCStatusStringExtendResponse = (OTCStatusStringExtendResponse) obj;
        if (!oTCStatusStringExtendResponse.canEqual(this) || getCode() != oTCStatusStringExtendResponse.getCode()) {
            return false;
        }
        String message2 = getMessage();
        String message3 = oTCStatusStringExtendResponse.getMessage();
        if (message2 != null ? !message2.equals(message3) : message3 != null) {
            return false;
        }
        Object data2 = getData();
        Object data3 = oTCStatusStringExtendResponse.getData();
        if (data2 != null ? !data2.equals(data3) : data3 != null) {
            return false;
        }
        String extend2 = getExtend();
        String extend3 = oTCStatusStringExtendResponse.getExtend();
        return extend2 != null ? extend2.equals(extend3) : extend3 == null;
    }

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getErrCode() {
        return String.valueOf(this.code);
    }

    public String getErrMsg() {
        return this.message;
    }

    public String getExtend() {
        return this.extend;
    }

    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        String message2 = getMessage();
        int i11 = 43;
        int code2 = ((getCode() + 59) * 59) + (message2 == null ? 43 : message2.hashCode());
        Object data2 = getData();
        int hashCode = (code2 * 59) + (data2 == null ? 43 : data2.hashCode());
        String extend2 = getExtend();
        int i12 = hashCode * 59;
        if (extend2 != null) {
            i11 = extend2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setData(T t11) {
        this.data = t11;
    }

    public void setExtend(String str) {
        this.extend = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "OTCStatusStringExtendResponse(code=" + getCode() + ", message=" + getMessage() + ", data=" + getData() + ", extend=" + getExtend() + ")";
    }
}
