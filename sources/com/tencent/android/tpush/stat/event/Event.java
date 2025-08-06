package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.huochat.community.base.CommunityConstants;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.android.tpush.stat.b.e;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import com.twitter.sdk.android.core.identity.AuthHandler;
import org.json.JSONObject;

public abstract class Event {
    public static String channel = "xgsdk";

    /* renamed from: h  reason: collision with root package name */
    public static String f69995h;

    /* renamed from: i  reason: collision with root package name */
    public static long f69996i;

    /* renamed from: c  reason: collision with root package name */
    public String f69997c = null;

    /* renamed from: d  reason: collision with root package name */
    public long f69998d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f69999e;

    /* renamed from: f  reason: collision with root package name */
    public int f70000f;

    /* renamed from: g  reason: collision with root package name */
    public String f70001g = null;

    /* renamed from: j  reason: collision with root package name */
    public long f70002j = 0;

    /* renamed from: k  reason: collision with root package name */
    public Context f70003k;

    public Event(Context context, int i11, long j11) {
        this.f69997c = "Axg" + j11;
        a(context, i11, j11);
    }

    private void a(Context context, int i11, long j11) {
        this.f70003k = context;
        this.f69998d = j11;
        this.f69999e = System.currentTimeMillis() / 1000;
        this.f70000f = i11;
        this.f70001g = b.b(context, j11);
        String str = f69995h;
        if (str == null || str.trim().length() < 40) {
            String token = XGPushConfig.getToken(context);
            f69995h = token;
            if (!b.c(token)) {
                f69995h = "0";
            }
        }
        if (f69996i == 0) {
            f69996i = CacheManager.getGuid(getContext());
        }
    }

    public boolean decode(JSONObject jSONObject) {
        return true;
    }

    public boolean encode(JSONObject jSONObject) {
        try {
            e.a(jSONObject, "ky", this.f69997c);
            EventType type = getType();
            if (type != null) {
                jSONObject.put("et", type.GetIntValue());
            }
            jSONObject.put(OptionsBridge.UI_KEY, e.a(this.f70003k));
            e.a(jSONObject, "mc", CustomDeviceInfos.getFacilityMacAddr(this.f70003k));
            jSONObject.put("ut", 1);
            if (getType() != EventType.SESSION_ENV) {
                e.a(jSONObject, "av", this.f70001g);
                e.a(jSONObject, "ch", channel);
            }
            e.a(jSONObject, CommunityConstants.REQUEST_KEY_MID, f69995h);
            jSONObject.put("si", this.f70000f);
            if (getType() == EventType.CUSTOM) {
                jSONObject.put("cts", this.f69999e);
                long j11 = this.f70002j;
                if (j11 == 0) {
                    long j12 = this.f69999e;
                    if (j12 != 0) {
                        jSONObject.put(AuthHandler.EXTRA_TOKEN_SECRET, j12);
                    }
                }
                jSONObject.put(AuthHandler.EXTRA_TOKEN_SECRET, j11);
            } else {
                jSONObject.put(AuthHandler.EXTRA_TOKEN_SECRET, this.f69999e);
            }
            if ("0".equals(b.a(this.f70003k, this.f69998d))) {
                jSONObject.put("sv", b.a(this.f70003k));
            } else {
                jSONObject.put("sv", b.a(this.f70003k, this.f69998d));
            }
            jSONObject.put(TPDownloadProxyEnum.USER_GUID, f69996i);
            jSONObject.put("dts", b.a(this.f70003k, false));
            return onEncode(jSONObject);
        } catch (Throwable unused) {
            return false;
        }
    }

    public long getAccessid() {
        return this.f69998d;
    }

    public String getAppkey() {
        return this.f69997c;
    }

    public Context getContext() {
        return this.f70003k;
    }

    public long getMsgTimeSec() {
        return this.f70002j;
    }

    public long getTimestamp() {
        return this.f69999e;
    }

    public abstract EventType getType();

    public abstract boolean onEncode(JSONObject jSONObject);

    public void setAccessid(long j11) {
        this.f69998d = j11;
    }

    public void setAppkey(String str) {
        this.f69997c = str;
    }

    public void setMsgTimeSec(long j11) {
        this.f70002j = j11;
    }

    public String toJsonString() {
        try {
            JSONObject jSONObject = new JSONObject();
            encode(jSONObject);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String toString() {
        return toJsonString();
    }

    public Event(Context context, String str) {
        this.f69997c = str;
        a(context, 0, 0);
    }

    public Event(Context context, String str, long j11) {
        this.f69997c = str;
        a(context, 0, j11);
    }

    public Event(Context context) {
        a(context, 0, 0);
    }
}
