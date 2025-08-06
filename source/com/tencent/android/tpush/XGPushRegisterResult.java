package com.tencent.android.tpush;

import android.content.Intent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.logging.TLogger;
import org.json.JSONObject;

public class XGPushRegisterResult implements XGIResult {

    /* renamed from: a  reason: collision with root package name */
    public long f68063a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f68064b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f68065c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f68066d = "";

    /* renamed from: e  reason: collision with root package name */
    public short f68067e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f68068f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f68069g = "";

    /* renamed from: h  reason: collision with root package name */
    public int f68070h = 100;

    public long getAccessId() {
        return this.f68063a;
    }

    public String getAccount() {
        return this.f68065c;
    }

    public String getFacilityIdentity() {
        return this.f68064b;
    }

    public String getOtherPushToken() {
        return this.f68069g;
    }

    public int getPushChannel() {
        return this.f68070h;
    }

    public String getTicket() {
        return this.f68066d;
    }

    public short getTicketType() {
        return this.f68067e;
    }

    public String getToken() {
        return this.f68068f;
    }

    public void parseIntent(Intent intent) {
        try {
            this.f68063a = intent.getLongExtra("accId", -1);
            this.f68064b = intent.getStringExtra(Constants.FLAG_DEVICE_ID);
            this.f68065c = intent.getStringExtra(Constants.FLAG_ACCOUNT);
            this.f68066d = intent.getStringExtra(Constants.FLAG_TICKET);
            this.f68067e = intent.getShortExtra(Constants.FLAG_TICKET_TYPE, 0);
            this.f68068f = intent.getStringExtra("token");
        } catch (Throwable unused) {
            TLogger.w("XGPushRegisterResult", "unexpected for parseIntent");
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.FLAG_ACCOUNT, this.f68065c);
            jSONObject.put(Constants.FLAG_TICKET, this.f68066d);
            jSONObject.put(Constants.FLAG_DEVICE_ID, this.f68064b);
            jSONObject.put(Constants.FLAG_TICKET_TYPE, this.f68067e);
            jSONObject.put("token", this.f68068f);
        } catch (Throwable unused) {
            TLogger.w("XGPushRegisterResult", "unexpected for toJson");
        }
        return jSONObject;
    }

    public String toString() {
        return "TPushRegisterMessage [accessId=" + this.f68063a + ", deviceId=" + this.f68064b + ", account=" + this.f68065c + ", ticket=" + this.f68066d + ", ticketType=" + this.f68067e + ", token=" + this.f68068f + ", pushChannel=" + this.f68070h + "]";
    }
}
