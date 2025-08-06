package tw;

import com.kakao.message.template.LinkObject;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f26213a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkObject f26214b;

    public a(String str, LinkObject linkObject) {
        this.f26213a = str;
        this.f26214b = linkObject;
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("title", this.f26213a);
        jSONObject.put("link", this.f26214b.b());
        return jSONObject;
    }
}
