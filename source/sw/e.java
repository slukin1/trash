package sw;

import android.net.Uri;
import com.kakao.common.IConfiguration;
import java.util.Map;
import qw.b;

public class e extends c {

    /* renamed from: h  reason: collision with root package name */
    public final String f26179h;

    public e(b bVar, IConfiguration iConfiguration, String str, String str2, String str3, Map<String, String> map) {
        super(bVar, iConfiguration, str, str3, map);
        this.f26179h = str2;
    }

    public String a() {
        return "GET";
    }

    public Uri.Builder f() {
        return super.f().path("v2/api/kakaolink/talk/template/scrap").appendQueryParameter("request_url", this.f26179h);
    }
}
