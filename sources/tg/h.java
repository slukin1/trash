package tg;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import bh.j;
import com.google.android.gms.common.GoogleApiAvailability;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.usercenter.data.source.bean.PasskeyAbtestData;
import com.huobi.utils.x;
import i6.k;
import u6.g;

public final class h {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f47865b = false;

    /* renamed from: c  reason: collision with root package name */
    public static long f47866c = 231815000;

    /* renamed from: a  reason: collision with root package name */
    public boolean f47867a;

    public class a extends EasySubscriber<PasskeyAbtestData> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(PasskeyAbtestData passkeyAbtestData) {
            k.d("HBPasskey", "build version: " + Build.VERSION.SDK_INT);
            if (passkeyAbtestData == null) {
                k.d("HBPasskey", "abtest: null!");
                return;
            }
            k.d("HBPasskey", "abtest: " + passkeyAbtestData.isAbTest());
            boolean unused = h.f47865b = passkeyAbtestData.isAbTest();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            k.g("HBPasskey", "abtest: error!", th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            k.g("HBPasskey", "abtest: failed!", aPIStatusErrorException);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static h f47869a = new h((a) null);
    }

    public /* synthetic */ h(a aVar) {
        this();
    }

    public static h c() {
        return b.f47869a;
    }

    public final long b(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).getLongVersionCode();
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public boolean d() {
        boolean z11 = this.f47867a;
        this.f47867a = false;
        return z11;
    }

    public boolean e(String str) {
        boolean l11 = SP.l("SP_PASSKEY_CREATED_" + str, false);
        k.d("HBPasskey", "hasPasskey uid!" + str + " hasPasskey: " + l11);
        return l11;
    }

    public boolean f() {
        if ("1".equals(x.b())) {
            k.d("HBPasskey", "ip error!");
            return false;
        } else if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(j.c()) != 0) {
            k.d("HBPasskey", "google service api error!");
            return false;
        } else if (b(j.c()) >= f47866c) {
            return true;
        } else {
            return false;
        }
    }

    public void g(String str, boolean z11) {
        k.d("HBPasskey", "savePasskeyCreated uid!" + str + " created:" + z11);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SP_PASSKEY_CREATED_");
        sb2.append(str);
        SP.y(sb2.toString(), z11);
    }

    public void h(boolean z11) {
        this.f47867a = z11;
    }

    public boolean i() {
        return f47865b && Build.VERSION.SDK_INT >= 28 && f();
    }

    public h() {
        this.f47867a = false;
        o9.a.a().passkeyABTest().b().compose(RxJavaHelper.t((g) null)).subscribe(new a());
    }
}
