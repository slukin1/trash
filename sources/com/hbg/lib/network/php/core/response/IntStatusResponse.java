package com.hbg.lib.network.php.core.response;

import com.hbg.lib.network.retrofit.response.IResponse;

public class IntStatusResponse<T> implements IResponse {
    private static final long serialVersionUID = -5465868120561652059L;
    private T data;
    private String message;
    private int status;

    public T getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isSuccess() {
        return this.status == 0;
    }

    public void setData(T t11) {
        this.data = t11;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }
}
