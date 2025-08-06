package sw;

import android.net.Uri;
import com.kakao.common.IConfiguration;
import java.util.Map;
import org.json.JSONObject;
import qw.b;
import tw.f;

public class d extends c {

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, Object> f26177h = null;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f26178i;

    public d(b bVar, IConfiguration iConfiguration, String str, f fVar) {
        super(bVar, iConfiguration, str);
        this.f26178i = fVar.a();
    }

    public String a() {
        return "GET";
    }

    public Uri.Builder f() {
        JSONObject jSONObject;
        Uri.Builder f11 = super.f();
        f11.path("v2/api/kakaolink/talk/template/default");
        if (this.f26177h != null) {
            jSONObject = new JSONObject(this.f26177h);
        } else {
            jSONObject = this.f26178i;
            if (jSONObject == null) {
                throw new IllegalArgumentException("Template object is null.");
            }
        }
        f11.appendQueryParameter("template_object", jSONObject.toString());
        return f11;
    }
}
