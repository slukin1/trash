package rw;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import com.kakao.kakaolink.R;
import com.kakao.kakaolink.v2.network.KakaoLinkCore;
import com.kakao.kakaolink.v2.network.KakaoLinkImageService;
import com.kakao.network.NetworkService;
import com.kakao.network.callback.ResponseCallback;
import com.kakao.network.response.ResponseStringConverter;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.AbstractFuture;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: e  reason: collision with root package name */
    public static b f25924e = new b(KakaoLinkCore.Factory.a(), KakaoLinkImageService.Factory.a(), NetworkService.Factory.a());

    /* renamed from: f  reason: collision with root package name */
    public static final ResponseStringConverter<JSONObject> f25925f = new d();

    /* renamed from: a  reason: collision with root package name */
    public KakaoLinkCore f25926a;

    /* renamed from: b  reason: collision with root package name */
    public KakaoLinkImageService f25927b;

    /* renamed from: c  reason: collision with root package name */
    public NetworkService f25928c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f25929d = Arrays.asList(new String[]{"com.android.chrome", "com.chrome.beta", "com.chrome.dev"});

    public class a extends AbstractFuture<uw.e> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f25930b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f25931c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f25932d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f25933e;

        public a(Context context, String str, String str2, Map map) {
            this.f25930b = context;
            this.f25931c = str;
            this.f25932d = str2;
            this.f25933e = map;
        }

        /* renamed from: a */
        public uw.e get() {
            return b.this.f25926a.g(this.f25930b, (String) null, this.f25931c, this.f25932d, this.f25933e);
        }
    }

    /* renamed from: rw.b$b  reason: collision with other inner class name */
    public class C0226b extends AbstractFuture<Uri> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f25935b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f25936c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f25937d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f25938e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f25939f;

        public C0226b(Context context, String str, String str2, Map map, Map map2) {
            this.f25935b = context;
            this.f25936c = str;
            this.f25937d = str2;
            this.f25938e = map;
            this.f25939f = map2;
        }

        /* renamed from: a */
        public Uri get() {
            return b.this.f25926a.b(this.f25935b, this.f25936c, this.f25937d, this.f25938e, this.f25939f);
        }
    }

    public class c extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ResponseCallback f25941a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f25942b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f25943c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Future f25944d;

        public c(ResponseCallback responseCallback, Context context, Map map, Future future) {
            this.f25941a = responseCallback;
            this.f25942b = context;
            this.f25943c = map;
            this.f25944d = future;
        }

        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject) {
            try {
                if (b.this.c(this.f25942b)) {
                    this.f25942b.startActivity(b.this.f25926a.a(this.f25942b, (String) null, jSONObject, this.f25943c));
                } else {
                    b.this.e(this.f25942b, (Uri) this.f25944d.get());
                }
                ResponseCallback responseCallback = this.f25941a;
                if (responseCallback != null) {
                    responseCallback.onSuccess(new a(jSONObject));
                }
            } catch (Exception e11) {
                ResponseCallback responseCallback2 = this.f25941a;
                if (responseCallback2 != null) {
                    responseCallback2.onFailure(new uw.c(e11));
                }
            }
        }

        public void onDidEnd() {
            super.onDidEnd();
            this.f25941a.onDidEnd();
        }

        public void onDidStart() {
            super.onDidStart();
            this.f25941a.onDidStart();
        }

        public void onFailure(uw.c cVar) {
            this.f25941a.onFailure(cVar);
        }
    }

    public static class d extends ResponseStringConverter<JSONObject> {
        /* renamed from: a */
        public JSONObject convert(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e11) {
                com.kakao.util.helper.log.a.e(e11.toString());
                return null;
            }
        }
    }

    public class e extends CustomTabsServiceConnection {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Uri f25946c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f25947d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f25948e;

        public e(Uri uri, String str, Context context) {
            this.f25946c = uri;
            this.f25947d = str;
            this.f25948e = context;
        }

        public void a(ComponentName componentName, k.a aVar) {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            builder.b();
            builder.d(true);
            CustomTabsIntent a11 = builder.a();
            a11.f4859a.setData(this.f25946c);
            a11.f4859a.setPackage(this.f25947d);
            this.f25948e.startActivity(a11.f4859a);
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public class f extends AbstractFuture<uw.e> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f25950b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f25951c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Map f25952d;

        public f(Context context, String str, Map map) {
            this.f25950b = context;
            this.f25951c = str;
            this.f25952d = map;
        }

        /* renamed from: a */
        public uw.e get() {
            return b.this.f25926a.f(this.f25950b, (String) null, this.f25951c, this.f25952d);
        }
    }

    public class g extends AbstractFuture<Uri> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f25954b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f25955c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Map f25956d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f25957e;

        public g(Context context, String str, Map map, Map map2) {
            this.f25954b = context;
            this.f25955c = str;
            this.f25956d = map;
            this.f25957e = map2;
        }

        /* renamed from: a */
        public Uri get() {
            return b.this.f25926a.h(this.f25954b, this.f25955c, this.f25956d, this.f25957e);
        }
    }

    public class h extends AbstractFuture<uw.e> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f25959b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ tw.f f25960c;

        public h(Context context, tw.f fVar) {
            this.f25959b = context;
            this.f25960c = fVar;
        }

        /* renamed from: a */
        public uw.e get() {
            return b.this.f25926a.e(this.f25959b, (String) null, this.f25960c);
        }
    }

    public class i extends AbstractFuture<Uri> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f25962b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ tw.f f25963c;

        public i(Context context, tw.f fVar) {
            this.f25962b = context;
            this.f25963c = fVar;
        }

        /* renamed from: a */
        public Uri get() {
            return b.this.f25926a.c(this.f25962b, this.f25963c, (Map<String, String>) null);
        }
    }

    public class j extends AbstractFuture<uw.e> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f25965b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ tw.f f25966c;

        public j(Context context, tw.f fVar) {
            this.f25965b = context;
            this.f25966c = fVar;
        }

        /* renamed from: a */
        public uw.e get() {
            return b.this.f25926a.e(this.f25965b, (String) null, this.f25966c);
        }
    }

    public class k extends AbstractFuture<Uri> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f25968b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ tw.f f25969c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Map f25970d;

        public k(Context context, tw.f fVar, Map map) {
            this.f25968b = context;
            this.f25969c = fVar;
            this.f25970d = map;
        }

        /* renamed from: a */
        public Uri get() {
            return b.this.f25926a.c(this.f25968b, this.f25969c, this.f25970d);
        }
    }

    public b(KakaoLinkCore kakaoLinkCore, KakaoLinkImageService kakaoLinkImageService, NetworkService networkService) {
        this.f25926a = kakaoLinkCore;
        this.f25927b = kakaoLinkImageService;
        this.f25928c = networkService;
    }

    public static b b() {
        return f25924e;
    }

    public boolean c(Context context) {
        return this.f25926a.d(context);
    }

    public final boolean d(String str) {
        return this.f25929d.contains(str);
    }

    public void e(Context context, Uri uri) throws KakaoException {
        String f11 = f(context, uri);
        if (f11 != null) {
            k.a.a(context, f11, new e(uri, f11, context));
            return;
        }
        throw new KakaoException(KakaoException.ErrorType.KAKAOTALK_NOT_INSTALLED, context.getString(R.string.com_kakao_alert_install_kakaotalk));
    }

    public String f(Context context, Uri uri) {
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW", uri), 65536);
        Intent intent = new Intent();
        intent.setAction("android.support.customtabs.action.CustomTabsService");
        Iterator<ResolveInfo> it2 = context.getPackageManager().queryIntentServices(intent, 0).iterator();
        String str = null;
        String str2 = null;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            ResolveInfo next = it2.next();
            if (str2 == null && d(next.serviceInfo.packageName)) {
                str2 = next.serviceInfo.packageName;
            }
            if (next.serviceInfo.packageName.equals(resolveActivity.activityInfo.packageName)) {
                str = resolveActivity.activityInfo.packageName;
                break;
            }
        }
        if (str == null && str2 != null) {
            str = str2;
        }
        com.kakao.util.helper.log.a.b("selected browser for kakaolink is %s", str);
        return str;
    }

    public void g(Context context, String str, Map<String, String> map, Map<String, String> map2, ResponseCallback<a> responseCallback) {
        j(context, new f(context, str, map), new g(context, str, map, map2), map2, responseCallback);
    }

    public void h(Context context, tw.f fVar, ResponseCallback<a> responseCallback) {
        j(context, new h(context, fVar), new i(context, fVar), (Map<String, String>) null, responseCallback);
    }

    public void i(Context context, tw.f fVar, Map<String, String> map, ResponseCallback<a> responseCallback) {
        j(context, new j(context, fVar), new k(context, fVar, map), map, responseCallback);
    }

    public final void j(Context context, Future<uw.e> future, Future<Uri> future2, Map<String, String> map, ResponseCallback<a> responseCallback) {
        try {
            this.f25928c.a(future.get(), f25925f, new c(responseCallback, context, map, future2));
        } catch (Exception e11) {
            if (responseCallback != null) {
                responseCallback.onFailure(new uw.c(e11));
            }
        }
    }

    public void k(Context context, String str, String str2, Map<String, String> map, Map<String, String> map2, ResponseCallback<a> responseCallback) {
        j(context, new a(context, str, str2, map), new C0226b(context, str, str2, map, map2), map2, responseCallback);
    }

    public void l(Context context, String str, Map<String, String> map, ResponseCallback<a> responseCallback) {
        k(context, str, (String) null, (Map<String, String>) null, map, responseCallback);
    }
}
