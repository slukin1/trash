package mu;

import android.content.Context;
import android.text.TextUtils;
import com.huobi.kalle.Headers;
import com.huobi.kalle.secure.Encryption;
import com.huobi.kalle.simple.cache.Cache;
import mm.a;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public nu.a f22968b;

    public b(Context context) {
        this.f22968b = nu.a.b(context, "huobi_vulcan_cache_store");
    }

    public static Cache b(String str) {
        Cache cache = new Cache();
        try {
            JSONObject jSONObject = new JSONObject(str);
            cache.setKey(jSONObject.optString("key"));
            cache.setCode(jSONObject.optInt("code"));
            cache.setHeaders(Headers.p(jSONObject.optString("headers")));
            cache.setBody(Encryption.c(jSONObject.optString(TtmlNode.TAG_BODY)));
            cache.setExpires(jSONObject.optLong("expires"));
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return cache;
    }

    public boolean a(String str, Cache cache) {
        try {
            this.f22968b.f(d(str), c(cache));
            return true;
        } catch (JSONException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public String c(Cache cache) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", cache.getKey());
        jSONObject.put("code", cache.getCode());
        jSONObject.put("headers", Headers.J(cache.getHeaders()));
        jSONObject.put(TtmlNode.TAG_BODY, Encryption.a(cache.getBody()));
        jSONObject.put("expires", cache.getExpires());
        return jSONObject.toString();
    }

    public final String d(String str) {
        return Encryption.b(str);
    }

    public Cache get(String str) {
        String d11 = this.f22968b.d(d(str), "");
        if (!TextUtils.isEmpty(d11)) {
            return b(d11);
        }
        return null;
    }
}
