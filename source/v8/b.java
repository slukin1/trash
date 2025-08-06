package v8;

import android.content.Context;
import com.hbg.lib.network.php.core.bean.CurrencyIntro;
import com.hbg.lib.network.php.core.bean.ZendeskTopNotice;
import d9.a;
import java.util.Map;
import okhttp3.ResponseBody;

public interface b {
    void a(String str, Context context, c9.b bVar);

    a<ZendeskTopNotice> b(String str, String str2);

    a<CurrencyIntro> c(String str, String str2);

    a<ResponseBody> getH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2);

    a<ResponseBody> postH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2);
}
