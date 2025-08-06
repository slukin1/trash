package com.huobi.finance.bean;

import com.hbg.lib.network.retrofit.response.IResponse;

public class OtcFinanceResponse<T> implements IResponse {
    private static final long serialVersionUID = -5465868120561652060L;
    private int code;
    private int currPage;
    private T data;
    private String message;
    private int pageSize;
    private int totalCount;
    private int totalPage;

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
}
