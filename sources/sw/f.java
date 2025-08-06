package sw;

import android.net.Uri;
import com.kakao.common.IConfiguration;
import java.util.Map;
import qw.b;

public class f extends c {
    public f(b bVar, IConfiguration iConfiguration, String str, String str2, Map<String, String> map) {
        super(bVar, iConfiguration, str, str2, map);
    }

    public String a() {
        return "GET";
    }

    public Uri.Builder f() {
        Uri.Builder f11 = super.f();
        f11.path("v2/api/kakaolink/talk/template/validate");
        return f11;
    }
}
