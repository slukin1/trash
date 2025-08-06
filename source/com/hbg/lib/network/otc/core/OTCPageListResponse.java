package com.hbg.lib.network.otc.core;

import com.hbg.lib.network.retrofit.response.IResponse;

public class OTCPageListResponse<T> implements IResponse {
    private static final long serialVersionUID = -5465868120561652059L;
    private int code;
    public int currPage;
    private T data;
    private String message;
    public int pageSize;
    public int totalCount;
    public int totalPage;

    public boolean canEqual(Object obj) {
        return obj instanceof OTCPageListResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OTCPageListResponse)) {
            return false;
        }
        OTCPageListResponse oTCPageListResponse = (OTCPageListResponse) obj;
        if (!oTCPageListResponse.canEqual(this) || getCode() != oTCPageListResponse.getCode()) {
            return false;
        }
        String message2 = getMessage();
        String message3 = oTCPageListResponse.getMessage();
        if (message2 != null ? !message2.equals(message3) : message3 != null) {
            return false;
        }
        Object data2 = getData();
        Object data3 = oTCPageListResponse.getData();
        if (data2 != null ? data2.equals(data3) : data3 == null) {
            return getCurrPage() == oTCPageListResponse.getCurrPage() && getTotalPage() == oTCPageListResponse.getTotalPage() && getPageSize() == oTCPageListResponse.getPageSize() && getTotalCount() == oTCPageListResponse.getTotalCount();
        }
        return false;
    }

    public int getCode() {
        return this.code;
    }

    public int getCurrPage() {
        return this.currPage;
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

    public String getMessage() {
        return this.message;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public int hashCode() {
        String message2 = getMessage();
        int i11 = 43;
        int code2 = ((getCode() + 59) * 59) + (message2 == null ? 43 : message2.hashCode());
        Object data2 = getData();
        int i12 = code2 * 59;
        if (data2 != null) {
            i11 = data2.hashCode();
        }
        return ((((((((i12 + i11) * 59) + getCurrPage()) * 59) + getTotalPage()) * 59) + getPageSize()) * 59) + getTotalCount();
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setCurrPage(int i11) {
        this.currPage = i11;
    }

    public void setData(T t11) {
        this.data = t11;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setPageSize(int i11) {
        this.pageSize = i11;
    }

    public void setTotalCount(int i11) {
        this.totalCount = i11;
    }

    public void setTotalPage(int i11) {
        this.totalPage = i11;
    }

    public String toString() {
        return "OTCPageListResponse(code=" + getCode() + ", message=" + getMessage() + ", data=" + getData() + ", currPage=" + getCurrPage() + ", totalPage=" + getTotalPage() + ", pageSize=" + getPageSize() + ", totalCount=" + getTotalCount() + ")";
    }
}
