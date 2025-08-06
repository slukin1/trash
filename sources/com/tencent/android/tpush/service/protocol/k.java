package com.tencent.android.tpush.service.protocol;

import java.util.ArrayList;
import org.json.JSONObject;

public class k extends e {

    /* renamed from: a  reason: collision with root package name */
    public long f69766a = 0;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<j> f69767b = new ArrayList<>();

    public void a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        j jVar = new j();
        jVar.a(jSONObject);
        this.f69767b.add(jVar);
        this.f69766a = jVar.f69748h * 1000000;
    }

    public MessageType a() {
        return MessageType.PUSH_MESSAGE;
    }
}
