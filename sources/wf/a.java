package wf;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.share.R$anim;
import com.hbg.module.share.R$string;
import kotlin.Unit;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f40622a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static HbgBaseProvider f40623b = ((HbgBaseProvider) b2.a.d().a("/provider/content").navigation());

    /* renamed from: c  reason: collision with root package name */
    public static b f40624c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f40625d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f40626e = true;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f40627f;

    /* renamed from: g  reason: collision with root package name */
    public static String f40628g;

    /* renamed from: h  reason: collision with root package name */
    public static String f40629h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f40630i = true;

    public static final void l(Bundle bundle, String str, int i11) {
        b2.a.d().a(str).withTransition(i11, 0).with(bundle).navigation();
    }

    public static final void m(Context context, Bitmap bitmap, String str, String str2, String str3, b bVar) {
        Unit unit;
        HbgBaseProvider hbgBaseProvider = f40623b;
        boolean z11 = true;
        if (hbgBaseProvider == null || !hbgBaseProvider.j(context)) {
            z11 = false;
        }
        if (z11) {
            a aVar = f40622a;
            if (f40627f) {
                f40624c = bVar;
                l(aVar.b((Uri) null, bitmap, str, str2, str3), "/share/shareFeed", 0);
                return;
            }
            String str4 = f40628g;
            if (str4 != null) {
                HuobiToastUtil.i(str4);
                unit = Unit.f56620a;
            } else {
                unit = null;
            }
            if (unit == null) {
                HuobiToastUtil.i(context.getResources().getString(R$string.n_share_not_support_now));
            }
        }
    }

    public static final void n(Context context, Uri uri, String str, String str2, String str3, b bVar) {
        Unit unit;
        HbgBaseProvider hbgBaseProvider = f40623b;
        boolean z11 = true;
        if (hbgBaseProvider == null || !hbgBaseProvider.j(context)) {
            z11 = false;
        }
        if (z11) {
            a aVar = f40622a;
            if (f40627f) {
                f40624c = bVar;
                l(aVar.b(uri, (Bitmap) null, str, str2, str3), "/share/shareFeed", 0);
                return;
            }
            String str4 = f40628g;
            if (str4 != null) {
                HuobiToastUtil.i(str4);
                unit = Unit.f56620a;
            } else {
                unit = null;
            }
            if (unit == null) {
                HuobiToastUtil.i(context.getResources().getString(R$string.n_share_not_support_now));
            }
        }
    }

    public static final void o(Context context, Bitmap bitmap, String str, String str2, String str3, b bVar) {
        HbgBaseProvider hbgBaseProvider = f40623b;
        boolean z11 = true;
        if (hbgBaseProvider == null || !hbgBaseProvider.j(context)) {
            z11 = false;
        }
        if (z11) {
            a aVar = f40622a;
            if (aVar.a(str3)) {
                f40624c = bVar;
                l(aVar.b((Uri) null, bitmap, str, str2, str3), "/share/shareGroup", R$anim.bottom_in);
                return;
            }
            HuobiToastUtil.i(context.getResources().getString(R$string.n_not_support));
        }
    }

    public static final void p(Context context, Uri uri, String str, String str2, String str3, b bVar) {
        HbgBaseProvider hbgBaseProvider = f40623b;
        boolean z11 = true;
        if (hbgBaseProvider == null || !hbgBaseProvider.j(context)) {
            z11 = false;
        }
        if (z11) {
            a aVar = f40622a;
            if (aVar.a(str3)) {
                f40624c = bVar;
                l(aVar.b(uri, (Bitmap) null, str, str2, str3), "/share/shareGroup", R$anim.bottom_in);
                return;
            }
            HuobiToastUtil.i(context.getResources().getString(R$string.n_not_support));
        }
    }

    public final boolean a(String str) {
        try {
            if (b.x(str) || new JSONObject(str).optInt("shareChannel") != 5 || f40625d) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return true;
    }

    public final Bundle b(Uri uri, Bitmap bitmap, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        if (uri != null) {
            bundle.putParcelable("shareImage", uri);
        }
        if (bitmap != null) {
            bundle.putParcelable("shareBitmap", bitmap);
        }
        if (uri == null && bitmap == null && !b.x(str)) {
            bundle.putString("shareText", str);
        }
        if (!b.x(str2)) {
            bundle.putString("shareUrl", str2);
        }
        if (!b.x(str3)) {
            JSONObject jSONObject = new JSONObject(str3);
            if (uri == null && bitmap == null) {
                bundle.putString("extendedParameter", str3);
            } else {
                jSONObject.put("shareImageUrl", "");
                bundle.putString("extendedParameter", jSONObject.toString());
            }
        }
        return bundle;
    }

    public final boolean c() {
        return f40630i;
    }

    public final boolean d() {
        return f40626e;
    }

    public final boolean e() {
        return f40627f;
    }

    public final String f() {
        return f40629h;
    }

    public final b g() {
        return f40624c;
    }

    public final void h(boolean z11) {
        f40625d = z11;
    }

    public final void i(boolean z11) {
        f40627f = z11;
    }

    public final void j(String str) {
        f40629h = str;
    }

    public final void k(String str) {
        f40628g = str;
    }
}
