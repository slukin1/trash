package tw;

import android.util.Log;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.kakao.message.template.LinkObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public final String f26249a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkObject f26250b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26251c;

    /* renamed from: d  reason: collision with root package name */
    public final List<a> f26252d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26253a;

        /* renamed from: b  reason: collision with root package name */
        public LinkObject f26254b;

        /* renamed from: c  reason: collision with root package name */
        public String f26255c;

        /* renamed from: d  reason: collision with root package name */
        public List<a> f26256d;

        public a(String str, LinkObject linkObject) {
            if (str == null) {
                throw new IllegalArgumentException("TextTemplate's text field cannot be null.");
            } else if (linkObject != null) {
                this.f26253a = str;
                this.f26254b = linkObject;
                this.f26256d = new ArrayList();
            } else {
                throw new IllegalArgumentException("TextTemplate's link field cannot be null.");
            }
        }

        public g a() {
            return new g(this);
        }

        public a b(String str) {
            this.f26255c = str;
            return this;
        }
    }

    public g(a aVar) {
        this.f26249a = aVar.f26253a;
        this.f26250b = aVar.f26254b;
        this.f26251c = aVar.f26255c;
        this.f26252d = aVar.f26256d;
    }

    public static a c(String str, LinkObject linkObject) {
        return new a(str, linkObject);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("object_type", b());
            jSONObject.put("text", this.f26249a);
            jSONObject.put("link", this.f26250b.b());
            jSONObject.put("button_title", this.f26251c);
            if (this.f26252d != null) {
                JSONArray jSONArray = new JSONArray();
                for (a a11 : this.f26252d) {
                    jSONArray.put(a11.a());
                }
                jSONObject.put(MessengerShareContentUtility.BUTTONS, jSONArray);
            }
        } catch (JSONException e11) {
            Log.w("com.kakao.message", e11.toString());
        }
        return jSONObject;
    }

    public String b() {
        return "text";
    }
}
