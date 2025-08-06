package gj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bh.j;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.index.api.IndexService;
import com.huobi.index.bean.IndexFeature;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.lancher.guide.AppWelcomeActivityV4;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.litere.main.ui.LiteReMainActivity;
import com.huobi.main.ui.HuobiMainActivity;
import com.twitter.sdk.android.core.identity.AuthHandler;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import ra.c;
import so.b;
import tg.r;
import tq.p;
import yl.g;

public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final e f47556b = new e();

    /* renamed from: a  reason: collision with root package name */
    public boolean f47557a = false;

    public class a extends BaseSubscriber<IndexFeature> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(IndexFeature indexFeature) {
            super.onNext(indexFeature);
            List<IndexFeatureItem> indexFeatureItems = indexFeature.getIndexFeatureItems();
            if (indexFeatureItems != null && indexFeatureItems.size() > 0) {
                String title = indexFeatureItems.get(0).getTitle();
                String introduction = indexFeatureItems.get(0).getIntroduction();
                IndexFeatureItem indexFeatureItem = new IndexFeatureItem();
                indexFeatureItem.setJumpMode(1001);
                b.c(j.c(), title, introduction, indexFeatureItem);
                is.a.u();
            }
        }

        public void onAfter() {
            super.onAfter();
            ConfigPreferences.k("user_config", "FIRST_INSTALL_TIME", 0);
        }
    }

    public static e b() {
        return f47556b;
    }

    public static Intent c(Activity activity) {
        if (!LiteReHelper.a().b()) {
            return new Intent(activity, HuobiMainActivity.class);
        }
        if (LegalCurrencyConfigUtil.y().equalsIgnoreCase("krw")) {
            LegalCurrencyConfigUtil.c0("usd");
        }
        return new Intent(activity, LiteReMainActivity.class);
    }

    public void a(Activity activity) {
        if ("com.huobi.main.ui.HuobiMainActivity".equals(activity.getLocalClassName())) {
            long i11 = ConfigPreferences.i("user_config", "FIRST_INSTALL_TIME", 0);
            if (i11 != 0 && TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis() - i11) >= 24 && ConfigPreferences.g("user_config", "ALREADY_LOGGED_IN", 0) == 0) {
                g();
            }
        }
    }

    public Intent d(Context context) {
        return new Intent(context, AppWelcomeActivityV4.class);
    }

    public void e(Activity activity) {
        ConfigPreferences.n("user_config", "lite_chosen", false);
        if (a.b().c()) {
            activity.startActivity(c(activity));
        } else if (!ConfigPreferences.b("user_config", "is_first_use")) {
            Intent o11 = c.b().o(activity);
            c.b().e(activity, o11, o11);
        } else {
            activity.startActivity(c(activity));
        }
    }

    public boolean f() {
        return ConfigPreferences.a("user_config", "lite_chosen");
    }

    public void g() {
        long j11;
        int i11;
        String valueOf = String.valueOf(9);
        String J = r.x().J();
        if (TextUtils.isEmpty(J) || !valueOf.equals(8)) {
            i11 = 0;
            j11 = 0;
        } else {
            i11 = Integer.parseInt(J);
            j11 = System.currentTimeMillis();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("platform", 1);
        hashMap.put("version", String.valueOf(105400));
        hashMap.put("nightMode", Integer.valueOf(NightHelper.e().g() ? 1 : 0));
        hashMap.put("uid", Integer.valueOf(i11));
        hashMap.put("moduleSize", 20);
        if (j11 > 0) {
            hashMap.put(AuthHandler.EXTRA_TOKEN_SECRET, Long.valueOf(j11));
        }
        int g11 = g.h().g();
        if (g11 == -1) {
            try {
                String a11 = sn.a.c().a();
                if (!com.hbg.module.libkt.base.ext.b.x(a11)) {
                    g11 = Integer.parseInt(a11);
                }
            } catch (NumberFormatException e11) {
                e11.printStackTrace();
            }
        }
        ((IndexService) p.V(IndexService.class)).getAppFeatures(String.valueOf(9), g11, hashMap).compose(p.E()).compose(RxJavaHelper.t((u6.g) null)).subscribe(new a());
    }
}
