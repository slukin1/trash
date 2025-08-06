package com.hbg.lib.network.php.retrofit;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.network.php.core.bean.CurrencyIntro;
import com.hbg.lib.network.php.core.bean.ZendeskTopNotice;
import com.hbg.lib.network.php.retrofit.service.PhpService;
import d9.a;
import java.util.HashMap;
import java.util.Map;
import okhttp3.ResponseBody;
import v8.b;

public class PhpRetrofitImpl implements b {
    public void a(String str, Context context, c9.b bVar) {
        PhpRetrofit.d().init(str, context, bVar);
    }

    public a<ZendeskTopNotice> b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sectionId", str);
        hashMap.put("language", str2);
        return new a<>(((PhpService) PhpRetrofit.request(PhpService.class)).getZendeskTopNotice(hashMap));
    }

    public a<CurrencyIntro> c(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str);
        hashMap.put("lang", str2);
        return new a<>(((PhpService) PhpRetrofit.request(PhpService.class)).getCurrencyIntro(hashMap).compose(PhpRetrofit.e()));
    }

    public a<ResponseBody> getH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2) {
        return new a<>(((PhpService) PhpRetrofit.request(PhpService.class)).getH5UrlRequest(str, map, map2));
    }

    public a<ResponseBody> postH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2) {
        return new a<>(((PhpService) PhpRetrofit.request(PhpService.class)).postH5UrlRequest(str, map, map2));
    }
}
