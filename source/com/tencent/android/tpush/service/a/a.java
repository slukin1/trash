package com.tencent.android.tpush.service.a;

import android.content.Context;
import java.util.Map;
import org.json.JSONArray;

public class a {
    private static volatile a L;
    public int A = 60000;
    public int B = 1;
    public int C = 1;
    public int D = 1;
    public int E = -1;
    public int F = -1;
    public int G = -1;
    public int H = -1;
    public String I = "xiaomi";
    public JSONArray J = null;
    public Map<String, String> K;
    private Context M = null;

    /* renamed from: a  reason: collision with root package name */
    public long f69556a;

    /* renamed from: b  reason: collision with root package name */
    public int f69557b;

    /* renamed from: c  reason: collision with root package name */
    public int f69558c;

    /* renamed from: d  reason: collision with root package name */
    public int f69559d;

    /* renamed from: e  reason: collision with root package name */
    public int f69560e;

    /* renamed from: f  reason: collision with root package name */
    public int f69561f;

    /* renamed from: g  reason: collision with root package name */
    public int f69562g;

    /* renamed from: h  reason: collision with root package name */
    public int f69563h;

    /* renamed from: i  reason: collision with root package name */
    public int f69564i;

    /* renamed from: j  reason: collision with root package name */
    public int f69565j;

    /* renamed from: k  reason: collision with root package name */
    public int f69566k;

    /* renamed from: l  reason: collision with root package name */
    public int f69567l;

    /* renamed from: m  reason: collision with root package name */
    public int f69568m;

    /* renamed from: n  reason: collision with root package name */
    public int f69569n;

    /* renamed from: o  reason: collision with root package name */
    public int f69570o;

    /* renamed from: p  reason: collision with root package name */
    public int f69571p;

    /* renamed from: q  reason: collision with root package name */
    public int f69572q;

    /* renamed from: r  reason: collision with root package name */
    public int f69573r;

    /* renamed from: s  reason: collision with root package name */
    public int f69574s;

    /* renamed from: t  reason: collision with root package name */
    public int f69575t;

    /* renamed from: u  reason: collision with root package name */
    public String f69576u;

    /* renamed from: v  reason: collision with root package name */
    public int f69577v;

    /* renamed from: w  reason: collision with root package name */
    public int f69578w;

    /* renamed from: x  reason: collision with root package name */
    public String f69579x = null;

    /* renamed from: y  reason: collision with root package name */
    public int f69580y = 1;

    /* renamed from: z  reason: collision with root package name */
    public int f69581z = 1;

    private a() {
    }

    public static a a(Context context) {
        if (L == null) {
            synchronized (a.class) {
                if (L == null) {
                    L = new a(context);
                }
            }
        }
        return L;
    }

    public String toString() {
        return "ConfigurationManager [context=" + this.M + ", configurationVersion=" + this.f69556a + ", receiveTimeout=" + this.f69557b + ", heartbeatInterval=" + this.f69558c + ", httpHeartbeatInterval=" + this.f69559d + ", speedTestInterval=" + this.f69560e + ", channelMessageExpires=" + this.f69561f + ", freqencySuccess=" + this.f69562g + ", freqencyFailed=" + this.f69563h + ", reportInterval=" + this.f69564i + ", reportMaxCount=" + this.f69565j + ", httpRetryCount=" + this.f69566k + ", ackMaxCount=" + this.f69567l + ", ackDuration=" + this.f69568m + ", loadIpInerval=" + this.f69569n + ", redirectConnectTimeOut=" + this.f69570o + ", redirectSoTimeOut=" + this.f69571p + ", strategyExpiredTime=" + this.f69572q + ", logLevel=" + this.f69573r + ", logFileSizeLimit=" + this.f69574s + ", errCount=" + this.f69575t + ", logUploadDomain=" + this.f69576u + ", rptLive=" + this.f69577v + ", rptLiveIntvl=" + this.f69578w + ", disableXG=" + this.f69579x + ", enableNewWd=" + this.f69580y + ", enableMonitor=" + this.f69581z + ", monitorFreg=" + this.A + ", enableReport=" + this.B + ", abTestVersion=" + this.C + ", isHttpDNSEnable=" + this.D + ", isLBSEnable=" + this.E + ", isAPPListEnable=" + this.F + ", isNotificatiobStatusEnable=" + this.G + ", isQgameEnable=" + this.H + ", pullup_Arr_ProviderAndActivty=" + this.J + ", pullup_packges_map=" + this.K + ", wakeupCtrl=" + this.I + "]";
    }

    private a(Context context) {
        this.M = context.getApplicationContext();
    }
}
