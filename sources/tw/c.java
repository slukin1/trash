package tw;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c implements f {

    /* renamed from: a  reason: collision with root package name */
    public final d f26225a;

    /* renamed from: b  reason: collision with root package name */
    public final b f26226b;

    /* renamed from: c  reason: collision with root package name */
    public final List<a> f26227c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public d f26228a;

        /* renamed from: b  reason: collision with root package name */
        public b f26229b;

        /* renamed from: c  reason: collision with root package name */
        public List<a> f26230c = new ArrayList();

        public a(d dVar, b bVar) {
            this.f26228a = dVar;
            this.f26229b = bVar;
        }

        public c a() {
            return new c(this);
        }
    }

    public c(a aVar) {
        this.f26225a = aVar.f26228a;
        this.f26226b = aVar.f26229b;
        this.f26227c = aVar.f26230c;
    }

    public static a c(d dVar, b bVar) {
        return new a(dVar, bVar);
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("object_type", b());
            d dVar = this.f26225a;
            if (dVar != null) {
                jSONObject.put("content", dVar.b());
            }
            b bVar = this.f26226b;
            if (bVar != null) {
                jSONObject.put("commerce", bVar.b());
            }
            if (this.f26227c != null) {
                JSONArray jSONArray = new JSONArray();
                for (a a11 : this.f26227c) {
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
        return "commerce";
    }
}
