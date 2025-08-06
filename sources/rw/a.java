package rw;

import com.kakao.network.response.ResponseStringConverter;
import org.json.JSONObject;

public class a extends ww.a {

    /* renamed from: g  reason: collision with root package name */
    public static final ResponseStringConverter<a> f25918g = new C0225a();

    /* renamed from: b  reason: collision with root package name */
    public final String f25919b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f25920c;

    /* renamed from: d  reason: collision with root package name */
    public final JSONObject f25921d;

    /* renamed from: e  reason: collision with root package name */
    public final JSONObject f25922e;

    /* renamed from: f  reason: collision with root package name */
    public final JSONObject f25923f;

    /* renamed from: rw.a$a  reason: collision with other inner class name */
    public static class C0225a extends ResponseStringConverter<a> {
        /* renamed from: a */
        public a convert(String str) {
            return new a(str);
        }
    }

    public a(String str) {
        super(str);
        this.f25919b = a().g("template_id", (String) null);
        this.f25920c = a().f("template_args", (JSONObject) null);
        this.f25921d = a().f("template_msg", (JSONObject) null);
        this.f25922e = a().f("warning_msg", (JSONObject) null);
        this.f25923f = a().f("argument_msg", (JSONObject) null);
    }

    public JSONObject b() {
        return this.f25923f;
    }

    public a(JSONObject jSONObject) {
        this(jSONObject.toString());
    }
}
