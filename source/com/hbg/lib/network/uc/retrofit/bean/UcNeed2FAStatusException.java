package com.hbg.lib.network.uc.retrofit.bean;

import com.hbg.lib.network.uc.core.response.UcIntCodeResponse;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;

public class UcNeed2FAStatusException extends RuntimeException {
    private UcIntCodeResponse<LoginInfoData> ucIntCodeResponse;

    public UcNeed2FAStatusException(UcIntCodeResponse<LoginInfoData> ucIntCodeResponse2) {
        this.ucIntCodeResponse = ucIntCodeResponse2;
    }

    public UcIntCodeResponse<LoginInfoData> getUcIntCodeResponse() {
        return this.ucIntCodeResponse;
    }

    public void setUcIntCodeResponse(UcIntCodeResponse<LoginInfoData> ucIntCodeResponse2) {
        this.ucIntCodeResponse = ucIntCodeResponse2;
    }
}
