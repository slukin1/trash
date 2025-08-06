package com.geetest.captcha;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/geetest/captcha/model/ErrorBean;", "", "code", "", "msg", "desc", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "toJson", "Companion", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65270a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final String f65271b;

    /* renamed from: c  reason: collision with root package name */
    private final String f65272c;

    /* renamed from: d  reason: collision with root package name */
    private final JSONObject f65273d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/geetest/captcha/model/ErrorBean$Companion;", "", "()V", "build", "Lcom/geetest/captcha/model/ErrorBean;", "code", "", "msg", "desc", "Lorg/json/JSONObject;", "description", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class a {
        private a() {
        }

        public static u a(String str, String str2, JSONObject jSONObject) {
            return new u(str, str2, jSONObject, (byte) 0);
        }

        public /* synthetic */ a(byte b11) {
            this();
        }
    }

    private u(String str, String str2, JSONObject jSONObject) {
        this.f65271b = str;
        this.f65272c = str2;
        this.f65273d = jSONObject;
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f65271b);
            jSONObject.put(RemoteMessageConst.MessageBody.MSG, this.f65272c);
            jSONObject.put("desc", this.f65273d);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject.toString();
    }

    public /* synthetic */ u(String str, String str2, JSONObject jSONObject, byte b11) {
        this(str, str2, jSONObject);
    }
}
