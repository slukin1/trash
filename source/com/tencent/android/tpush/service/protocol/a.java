package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import com.tencent.android.tpush.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public long f69691a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f69692b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f69693c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f69694d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f69695e = "";

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<q> f69696f = null;

    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.f69691a);
        jSONObject.put("accessKey", this.f69692b);
        jSONObject.put(Constants.FLAG_ACCOUNT_OP_TYPE, this.f69693c);
        jSONObject.put("timestamp", this.f69694d);
        jSONObject.put("sdkVersion", this.f69695e);
        if (this.f69696f != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<q> it2 = this.f69696f.iterator();
            while (it2.hasNext()) {
                JSONObject a11 = it2.next().a();
                if (a11 != null) {
                    jSONArray.put(a11);
                }
            }
            jSONObject.put("typeAccounts", jSONArray);
        }
        return jSONObject;
    }

    public MessageType a() {
        return MessageType.ACCOUNT;
    }
}
