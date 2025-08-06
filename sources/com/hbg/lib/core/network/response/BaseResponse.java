package com.hbg.lib.core.network.response;

import com.hbg.lib.network.retrofit.response.IResponse;

public class BaseResponse implements IResponse {
    private static final long serialVersionUID = 241939852359132938L;
    private String message;
    private int status;

    public String getMessage() {
        return this.message;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isSuccess() {
        return this.status == 0;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }
}
