package tw;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.kakao.message.template.SocialObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e implements f {

    /* renamed from: a  reason: collision with root package name */
    public final d f26243a;

    /* renamed from: b  reason: collision with root package name */
    public final SocialObject f26244b;

    /* renamed from: c  reason: collision with root package name */
    public final List<a> f26245c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public d f26246a;

        /* renamed from: b  reason: collision with root package name */
        public SocialObject f26247b;

        /* renamed from: c  reason: collision with root package name */
        public List<a> f26248c = new ArrayList();

        public a(d dVar) {
            this.f26246a = dVar;
        }

        public a a(a aVar) {
            if (aVar != null) {
                this.f26248c.add(aVar);
            }
            return this;
        }

        public e b() {
            return new e(this);
        }

        public a c(SocialObject socialObject) {
            this.f26247b = socialObject;
            return this;
        }
    }

    public e(a aVar) {
        this.f26243a = aVar.f26246a;
        this.f26244b = aVar.f26247b;
        this.f26245c = aVar.f26248c;
    }

    public static a c(d dVar) {
        return new a(dVar);
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("object_type", b());
            d dVar = this.f26243a;
            if (dVar != null) {
                jSONObject.put("content", dVar.b());
            }
            SocialObject socialObject = this.f26244b;
            if (socialObject != null) {
                jSONObject.put("social", socialObject.b());
            }
            if (this.f26245c != null) {
                JSONArray jSONArray = new JSONArray();
                for (a a11 : this.f26245c) {
                    jSONArray.put(a11.a());
                }
                jSONObject.put(MessengerShareContentUtility.BUTTONS, jSONArray);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public String b() {
        return "feed";
    }
}
