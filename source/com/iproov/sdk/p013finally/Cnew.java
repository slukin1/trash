package com.iproov.sdk.p013finally;

import android.content.Context;
import com.iproov.sdk.p026return.Cextends;
import com.iproov.sdk.p036volatile.Cdo;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* renamed from: com.iproov.sdk.finally.new  reason: invalid class name and invalid package */
public final class Cnew {

    /* renamed from: do  reason: not valid java name */
    public static final Cnew f536do = new Cnew();

    private Cnew() {
    }

    /* renamed from: do  reason: not valid java name */
    public final Cdo m635do(String str, Context context, Cextends.Ccatch catchR) {
        return new Cdo(m633do(context, catchR).connectTimeout((long) catchR.m1486if(), TimeUnit.SECONDS).build(), m634do(str));
    }

    /* renamed from: do  reason: not valid java name */
    private final OkHttpClient.Builder m633do(Context context, Cextends.Ccatch catchR) {
        if (!catchR.m1485do().isEmpty()) {
            return Cfor.m615do(context, catchR);
        }
        return new OkHttpClient.Builder();
    }

    /* renamed from: do  reason: not valid java name */
    private final Request m634do(String str) {
        return new Request.Builder().url(str).build();
    }
}
