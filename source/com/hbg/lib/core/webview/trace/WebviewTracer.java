package com.hbg.lib.core.webview.trace;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.huobi.vulcan.model.VulcanInfo;
import com.huobi.woodpecker.WoodPeckerSDK;
import com.huobi.woodpecker.core.ActionType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class WebviewTracer {

    /* renamed from: g  reason: collision with root package name */
    public static String f68820g = "WebChangeDomainStartLoadRequest";

    /* renamed from: a  reason: collision with root package name */
    public final String f68821a = UUID.randomUUID().toString();

    /* renamed from: b  reason: collision with root package name */
    public int f68822b;

    /* renamed from: c  reason: collision with root package name */
    public final Date f68823c = new Date();

    /* renamed from: d  reason: collision with root package name */
    public long f68824d;

    /* renamed from: e  reason: collision with root package name */
    public Date f68825e;

    /* renamed from: f  reason: collision with root package name */
    public int f68826f;

    public static void f(String str) {
        f68820g = str;
    }

    public final String a(Date date) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
    }

    public int b() {
        return this.f68822b;
    }

    public final void c(StepType stepType) {
        String str = stepType.step;
        if (str == StepType.WebViewCreate.step) {
            this.f68826f = 0;
        } else if (str == StepType.WebViewRequest.step) {
            this.f68824d = System.currentTimeMillis();
            this.f68825e = new Date(this.f68824d);
            this.f68822b++;
            this.f68826f = 1;
        } else if (str == StepType.WebViewDidSuccess.step) {
            this.f68826f = 2;
        } else if (str == StepType.WebViewDidFail.step) {
            this.f68826f = 3;
        }
    }

    public void d(StepType stepType, String str) {
        c(stepType);
        e(stepType.step, str, "", "");
    }

    public void e(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("step", str);
            if (!TextUtils.isEmpty(str2)) {
                Uri parse = Uri.parse(str2);
                hashMap.put("url", str2);
                if (!TextUtils.isEmpty(parse.getPath())) {
                    hashMap.put("path", parse.getPath());
                }
                if (!TextUtils.isEmpty(parse.getHost())) {
                    hashMap.put(VulcanInfo.HOST, parse.getHost());
                }
                if (str == StepType.WebViewRequest.step) {
                    hashMap.put("timeConsuming", 0);
                } else if (0 != this.f68824d) {
                    hashMap.put("timeConsuming", Long.valueOf(System.currentTimeMillis() - this.f68824d));
                    hashMap.put("startRequestTime", a(this.f68825e));
                } else {
                    hashMap.put("timeConsuming", 0);
                    hashMap.put("startRequestTime", 0);
                }
            }
            hashMap.put("webCreateTime", a(this.f68823c));
            hashMap.put("requestType", f68820g);
            hashMap.put("loadState", Integer.valueOf(this.f68826f));
            hashMap.put("webUUID", this.f68821a);
            hashMap.put("currentTime", a(new Date()));
            hashMap.put("requestCount", Integer.valueOf(b()));
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("errorCode", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("errorInfo", str4);
            }
        } catch (Exception e11) {
            Log.e("webview_report", e11.getMessage());
        }
        WoodPeckerSDK.f().g().b(ActionType.APP_WEBVIEW_LIFE_CYCLE, hashMap);
    }
}
