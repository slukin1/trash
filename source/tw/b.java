package tw;

import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f26215a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f26216b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f26217c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f26218d;

    /* renamed from: e  reason: collision with root package name */
    public final String f26219e;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Integer f26220a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f26221b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f26222c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f26223d;

        /* renamed from: e  reason: collision with root package name */
        public String f26224e;

        public a(Integer num) {
            this.f26220a = num;
        }

        public b f() {
            return new b(this);
        }

        public a g(Integer num) {
            this.f26221b = num;
            return this;
        }

        public a h(Integer num) {
            this.f26222c = num;
            return this;
        }

        public a i(String str) {
            this.f26224e = str;
            return this;
        }
    }

    public b(a aVar) {
        this.f26215a = aVar.f26220a;
        this.f26216b = aVar.f26221b;
        this.f26217c = aVar.f26222c;
        this.f26218d = aVar.f26223d;
        this.f26219e = aVar.f26224e;
    }

    public static a a(Integer num) {
        return new a(num);
    }

    public JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("regular_price", this.f26215a);
            jSONObject.put("discount_price", this.f26216b);
            jSONObject.put("discount_rate", this.f26217c);
            jSONObject.put("fixed_discount_price", this.f26218d);
            jSONObject.put("product_name", this.f26219e);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
