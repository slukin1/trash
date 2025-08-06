package com.huobi.app.rms;

import d10.a;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;

public final class HBResourceDownloadManager$downloadRequestManager$2 extends Lambda implements a<OkHttpClient> {
    public static final HBResourceDownloadManager$downloadRequestManager$2 INSTANCE = new HBResourceDownloadManager$downloadRequestManager$2();

    public HBResourceDownloadManager$downloadRequestManager$2() {
        super(0);
    }

    public final OkHttpClient invoke() {
        return new OkHttpClient.Builder().build();
    }
}
