package sw;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import ax.b;
import com.adjust.sdk.Constants;
import com.kakao.common.IConfiguration;
import com.kakao.kakaolink.R;
import com.kakao.kakaolink.internal.KakaoTalkLinkProtocol;
import com.kakao.kakaolink.v2.network.KakaoLinkCore;
import com.kakao.util.exception.KakaoException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tw.f;
import uw.e;

public class a implements KakaoLinkCore {

    /* renamed from: a  reason: collision with root package name */
    public com.kakao.common.a f26171a;

    /* renamed from: b  reason: collision with root package name */
    public b f26172b;

    public a(com.kakao.common.a aVar, b bVar) {
        this.f26171a = aVar;
        this.f26172b = bVar;
    }

    public Intent a(Context context, String str, JSONObject jSONObject, Map<String, String> map) throws KakaoException {
        this.f26171a.c(context);
        qw.b d11 = this.f26171a.d();
        IConfiguration a11 = this.f26171a.a();
        try {
            int i11 = i(d11, a11, jSONObject);
            com.kakao.util.helper.log.a.k("KakaoLink intent size is %d bytes.", Integer.valueOf(i11));
            if (i11 <= 10240) {
                String optString = jSONObject.optString("template_id", (String) null);
                JSONObject optJSONObject = jSONObject.optJSONObject("template_args");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("template_msg");
                Uri.Builder builder = new Uri.Builder();
                builder.scheme("kakaolink").authority("send");
                builder.appendQueryParameter("linkver", "4.0");
                if (str == null) {
                    str = d11.b();
                }
                builder.appendQueryParameter("appkey", str);
                builder.appendQueryParameter("appver", a11.a());
                if (optString != null) {
                    builder.appendQueryParameter("template_id", optString);
                }
                if (optJSONObject != null) {
                    builder.appendQueryParameter("template_args", optJSONObject.toString());
                }
                if (optJSONObject2 != null) {
                    builder.appendQueryParameter("template_json", optJSONObject2.toString());
                }
                if (a11.c() != null) {
                    builder.appendQueryParameter("extras", j(a11.c(), map).toString());
                }
                Intent intent = new Intent("android.intent.action.SEND", builder.build());
                intent.addFlags(335544320);
                return this.f26172b.a(context, intent, 1400255);
            }
            throw new KakaoException(KakaoException.ErrorType.URI_LENGTH_EXCEEDED, context.getString(R.string.com_kakao_alert_uri_too_long));
        } catch (JSONException e11) {
            throw new KakaoException(KakaoException.ErrorType.JSON_PARSING_ERROR, e11.toString());
        }
    }

    public Uri b(Context context, String str, String str2, Map<String, String> map, Map<String, String> map2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request_url", str);
            if (str2 != null) {
                jSONObject.put("template_id", Integer.parseInt(str2));
            }
            if (map != null) {
                jSONObject.put("template_args", new JSONObject(map));
            }
            return k(context, "scrap", jSONObject, map2);
        } catch (JSONException unused) {
            return null;
        }
    }

    public Uri c(Context context, f fVar, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("template_object", fVar.a());
            return k(context, "default", jSONObject, map);
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean d(Context context) {
        return this.f26172b.a(context, new Intent("android.intent.action.VIEW", new Uri.Builder().scheme("kakaolink").authority("send").build()), 1400255) != null;
    }

    public e e(Context context, String str, f fVar) {
        this.f26171a.c(context);
        return new d(this.f26171a.d(), this.f26171a.a(), str, fVar);
    }

    public e f(Context context, String str, String str2, Map<String, String> map) {
        this.f26171a.c(context);
        return new f(this.f26171a.d(), this.f26171a.a(), str, str2, map);
    }

    public e g(Context context, String str, String str2, String str3, Map<String, String> map) {
        this.f26171a.c(context);
        return new e(this.f26171a.d(), this.f26171a.a(), str, str2, str3, map);
    }

    public Uri h(Context context, String str, Map<String, String> map, Map<String, String> map2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("template_id", Integer.parseInt(str));
            if (map != null) {
                jSONObject.put("template_args", new JSONObject(map));
            }
            return k(context, "custom", jSONObject, map2);
        } catch (JSONException unused) {
            return null;
        }
    }

    public int i(qw.b bVar, IConfiguration iConfiguration, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("lv", "4.0");
        jSONObject2.put("av", "4.0");
        jSONObject2.put("ak", bVar.b());
        JSONObject optJSONObject = jSONObject.optJSONObject("template_msg");
        jSONObject2.put("P", optJSONObject.get("P"));
        jSONObject2.put("C", optJSONObject.get("C"));
        jSONObject2.put("template_id", jSONObject.optString("template_id", (String) null));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("template_args");
        if (optJSONObject2 != null) {
            jSONObject2.put("template_args", optJSONObject2);
        }
        if (iConfiguration.c() != null) {
            jSONObject2.put("extras", iConfiguration.c().toString());
        }
        return jSONObject2.toString().getBytes().length;
    }

    public JSONObject j(JSONObject jSONObject, Map<String, String> map) {
        if (jSONObject == null) {
            return null;
        }
        if (map == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("lcba", new JSONObject(map).toString());
        } catch (JSONException unused) {
            com.kakao.util.helper.log.a.p(String.format("failed to put Kakaolink callback parameters %s to extras.", new Object[]{map.toString()}));
        }
        return jSONObject;
    }

    public final Uri k(Context context, String str, JSONObject jSONObject, Map<String, String> map) {
        this.f26171a.c(context);
        IConfiguration a11 = this.f26171a.a();
        qw.b d11 = this.f26171a.d();
        JSONObject jSONObject2 = null;
        try {
            jSONObject.put("link_ver", "4.0");
            try {
                jSONObject2 = new JSONObject(map);
            } catch (NullPointerException unused) {
            }
            Uri.Builder appendQueryParameter = new Uri.Builder().authority(KakaoTalkLinkProtocol.b()).scheme(Constants.SCHEME).path("talk/friends/picker/easylink").appendQueryParameter("app_key", d11.b()).appendQueryParameter("validation_action", str).appendQueryParameter("validation_params", jSONObject.toString()).appendQueryParameter("ka", a11.b());
            if (jSONObject2 != null) {
                appendQueryParameter.appendQueryParameter("lcba", jSONObject2.toString());
            }
            return appendQueryParameter.build();
        } catch (JSONException unused2) {
            return null;
        }
    }
}
