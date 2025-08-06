package v7;

import android.content.Context;
import c9.b;
import d9.a;
import java.util.Map;
import okhttp3.ResponseBody;

public interface c {
    void a(String str, Context context, b bVar);

    a<ResponseBody> postH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2);

    a<ResponseBody> putH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2);
}
