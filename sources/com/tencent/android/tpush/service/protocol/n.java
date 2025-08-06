package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.j;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class n extends e {

    /* renamed from: a  reason: collision with root package name */
    public long f69801a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f69802b = "";

    /* renamed from: c  reason: collision with root package name */
    public long f69803c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f69804d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f69805e = "";

    /* renamed from: f  reason: collision with root package name */
    public long f69806f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f69807g = 0;

    /* renamed from: h  reason: collision with root package name */
    public String f69808h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f69809i = "";

    /* renamed from: j  reason: collision with root package name */
    public int f69810j = -1;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList<String> f69811k = null;

    public void a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.f69801a = jSONObject.optLong("confVersion", this.f69801a);
        this.f69802b = jSONObject.optString("token", this.f69802b);
        this.f69803c = jSONObject.optLong(TPDownloadProxyEnum.USER_GUID, this.f69803c);
        this.f69804d = jSONObject.optLong("otherPushTokenType", this.f69804d);
        this.f69805e = jSONObject.optString("otherPushToken", this.f69805e);
        this.f69806f = jSONObject.optLong("otherPushTokenCrc32", this.f69806f);
        this.f69807g = jSONObject.optLong("tokenCrc32", this.f69807g);
        this.f69808h = jSONObject.optString("reserved", this.f69808h);
        this.f69809i = jSONObject.optString(Constants.FLAG_TICKET, this.f69809i);
        this.f69810j = jSONObject.optInt(Constants.FLAG_TICKET_TYPE, this.f69810j);
        JSONArray optJSONArray = jSONObject.optJSONArray("groupKeys");
        if (optJSONArray != null) {
            this.f69811k = new ArrayList<>();
            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                this.f69811k.add(optJSONArray.getString(i11));
            }
        }
    }

    public MessageType a() {
        return MessageType.REGISTER;
    }

    public static String a(Context context, String str) {
        if (context != null && !j.b(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                return jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
