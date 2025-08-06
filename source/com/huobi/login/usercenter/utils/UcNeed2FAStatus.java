package com.huobi.login.usercenter.utils;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;

public class UcNeed2FAStatus extends RuntimeException {
    private UcIntCodeResponse<LoginInfoData> ucIntCodeResponse;

    public UcNeed2FAStatus(UcIntCodeResponse<LoginInfoData> ucIntCodeResponse2) {
        this.ucIntCodeResponse = ucIntCodeResponse2;
    }

    public UcIntCodeResponse<LoginInfoData> getUcIntCodeResponse() {
        return this.ucIntCodeResponse;
    }

    public void setUcIntCodeResponse(UcIntCodeResponse<LoginInfoData> ucIntCodeResponse2) {
        this.ucIntCodeResponse = ucIntCodeResponse2;
    }
}
