package sw;

import android.net.Uri;
import com.kakao.common.IConfiguration;
import com.kakao.network.ServerProtocol;
import java.util.Map;
import org.json.JSONObject;
import qw.b;
import uw.a;

public abstract class c extends a {

    /* renamed from: e  reason: collision with root package name */
    public final String f26174e;

    /* renamed from: f  reason: collision with root package name */
    public final String f26175f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, String> f26176g;

    public c(b bVar, IConfiguration iConfiguration, String str, String str2, Map<String, String> map) {
        super(bVar, iConfiguration);
        this.f26175f = str;
        this.f26174e = str2;
        this.f26176g = map;
    }

    public Uri.Builder f() {
        Uri.Builder f11 = super.f();
        f11.authority(ServerProtocol.a());
        f11.appendQueryParameter("link_ver", "4.0");
        String str = this.f26174e;
        if (str != null) {
            f11.appendQueryParameter("template_id", str);
        }
        Map<String, String> map = this.f26176g;
        if (map != null && !map.isEmpty()) {
            f11.appendQueryParameter("template_args", g());
        }
        String str2 = this.f26175f;
        if (str2 != null) {
            f11.appendQueryParameter("target_app_key", str2);
        }
        return f11;
    }

    public String g() {
        Map<String, String> map = this.f26176g;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return new JSONObject(this.f26176g).toString();
    }

    public c(b bVar, IConfiguration iConfiguration, String str) {
        super(bVar, iConfiguration);
        this.f26175f = str;
        this.f26174e = null;
        this.f26176g = null;
    }
}
