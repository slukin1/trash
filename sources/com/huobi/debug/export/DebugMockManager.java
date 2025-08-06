package com.huobi.debug.export;

import android.content.Context;
import com.alibaba.android.arouter.facade.template.IProvider;
import okhttp3.OkHttpClient;

public interface DebugMockManager extends IProvider {
    void addMockInterceptor(OkHttpClient.Builder builder);

    void startMockSettingPage(Context context);
}
