package com.business.common.interceptor;

import com.business.common.airdrop.AirdropManager;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

public class ResponseHeaderInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        String header = proceed.header("content-airdrop");
        if (header != null) {
            LogAndWoodRecorder.a("Airdrop", "Header(" + header + ")");
            AirdropManager.e(header);
        }
        return proceed;
    }
}
