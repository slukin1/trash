package hs;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import bh.j;
import com.facebook.places.model.PlaceFields;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lite.base.LiteBaseFragment;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.statistics.hbg.bean.AnalyticsClickItem;
import com.huobi.statistics.hbg.bean.AnalyticsExposureItem;
import com.huobi.statistics.hbg.bean.AnalyticsInfo;
import gs.g;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p0.m;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subjects.BehaviorSubject;
import tg.r;

public final class b implements Application.ActivityLifecycleCallbacks {

    /* renamed from: i  reason: collision with root package name */
    public static final b f84220i = new b();

    /* renamed from: b  reason: collision with root package name */
    public final FragmentManager.FragmentLifecycleCallbacks f84221b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, AnalyticsExposureItem> f84222c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public List<String> f84223d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public AnalyticsExposureItem f84224e;

    /* renamed from: f  reason: collision with root package name */
    public AnalyticsExposureItem f84225f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f84226g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f84227h = 0;

    public class a extends FragmentManager.FragmentLifecycleCallbacks {
        public a() {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
            AnalyticsExposureItem analyticsExposureItem;
            super.onFragmentCreated(fragmentManager, fragment, bundle);
            try {
                String name = fragment.getClass().getName();
                if (!b.this.f84223d.contains(name)) {
                    i6.d.j("HbgAnalytics", "onFragmentCreated - " + name);
                    AnalyticsExposureItem analyticsExposureItem2 = (AnalyticsExposureItem) b.this.f84222c.get(name);
                    if (analyticsExposureItem2 == null) {
                        return;
                    }
                    if (!(fragment instanceof BaseDialogFragment) || !analyticsExposureItem2.isDialog()) {
                        analyticsExposureItem2.setFragmentCreate(true);
                        b.this.q(fragment, analyticsExposureItem2);
                        return;
                    }
                    String actClazz = analyticsExposureItem2.getActClazz();
                    if (!TextUtils.isEmpty(actClazz) && (analyticsExposureItem = (AnalyticsExposureItem) b.this.f84222c.get(actClazz)) != null) {
                        b.this.o(analyticsExposureItem);
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
            super.onFragmentStopped(fragmentManager, fragment);
            try {
                String name = fragment.getClass().getName();
                if (!b.this.f84223d.contains(name)) {
                    AnalyticsExposureItem analyticsExposureItem = (AnalyticsExposureItem) b.this.f84222c.get(name);
                    i6.d.j("HbgAnalytics", "onFragmentPaused - " + name);
                    if (analyticsExposureItem != null) {
                        if (!(fragment instanceof BaseDialogFragment) || !analyticsExposureItem.isDialog()) {
                            boolean isChildFragment = analyticsExposureItem.isChildFragment();
                            if (fragment.isVisible() && !analyticsExposureItem.isMenu() && analyticsExposureItem.getPageType() != 2 && !isChildFragment) {
                                b.this.o(analyticsExposureItem);
                                return;
                            }
                            return;
                        }
                        if (analyticsExposureItem.isMultiPageId()) {
                            b.this.n(analyticsExposureItem, fragment);
                        }
                        if (b.this.j(analyticsExposureItem, fragment)) {
                            b.this.o(analyticsExposureItem);
                        }
                    } else if (fragment.isVisible() && b.this.f84224e != null) {
                        AnalyticsExposureItem unused = b.this.f84224e = null;
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
            boolean z11;
            super.onFragmentStarted(fragmentManager, fragment);
            try {
                String name = fragment.getClass().getName();
                if (!b.this.f84223d.contains(name)) {
                    AnalyticsExposureItem analyticsExposureItem = (AnalyticsExposureItem) b.this.f84222c.get(name);
                    i6.d.j("HbgAnalytics", "onFragmentResumed - " + name);
                    if (analyticsExposureItem == null) {
                        return;
                    }
                    if (!(fragment instanceof BaseDialogFragment) || !analyticsExposureItem.isDialog()) {
                        if (!fragment.isVisible()) {
                            if (!analyticsExposureItem.isFragmentCreate()) {
                                z11 = false;
                                boolean isChildFragment = analyticsExposureItem.isChildFragment();
                                if (z11 && !analyticsExposureItem.isMenu() && analyticsExposureItem.getPageType() != 2 && !isChildFragment) {
                                    analyticsExposureItem.setFragmentCreate(false);
                                    if (analyticsExposureItem.isMultiPageId()) {
                                        b.this.n(analyticsExposureItem, fragment);
                                    }
                                    b.this.p(analyticsExposureItem);
                                    return;
                                }
                                return;
                            }
                        }
                        z11 = true;
                        boolean isChildFragment2 = analyticsExposureItem.isChildFragment();
                        if (z11 || !analyticsExposureItem.isMenu() || analyticsExposureItem.getPageType() != 2) {
                            return;
                        }
                        return;
                    }
                    analyticsExposureItem.setFragmentCreate(false);
                    b.this.p(analyticsExposureItem);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
            AnalyticsExposureItem analyticsExposureItem;
            super.onFragmentViewDestroyed(fragmentManager, fragment);
            try {
                String name = fragment.getClass().getName();
                if (!b.this.f84223d.contains(name)) {
                    i6.d.j("HbgAnalytics", "onFragmentViewDestroyed - " + name);
                    AnalyticsExposureItem analyticsExposureItem2 = (AnalyticsExposureItem) b.this.f84222c.get(name);
                    if (analyticsExposureItem2 != null && (fragment instanceof BaseDialogFragment) && analyticsExposureItem2.isDialog()) {
                        String actClazz = analyticsExposureItem2.getActClazz();
                        if (!TextUtils.isEmpty(actClazz) && (analyticsExposureItem = (AnalyticsExposureItem) b.this.f84222c.get(actClazz)) != null) {
                            b.this.p(analyticsExposureItem);
                        }
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* renamed from: hs.b$b  reason: collision with other inner class name */
    public class C0867b implements Action1<Integer> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f84229b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AnalyticsExposureItem f84230c;

        public C0867b(String str, AnalyticsExposureItem analyticsExposureItem) {
            this.f84229b = str;
            this.f84230c = analyticsExposureItem;
        }

        /* renamed from: a */
        public void call(Integer num) {
            i6.d.j("HbgAnalytics", "onNext - clazz " + this.f84229b + " uiState - " + num);
            if (num.intValue() == 16) {
                b.this.p(this.f84230c);
            } else if (num.intValue() == 17) {
                b.this.o(this.f84230c);
            }
        }
    }

    public class c implements Action1<Throwable> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f84232b;

        public c(String str) {
            this.f84232b = str;
        }

        /* renamed from: a */
        public void call(Throwable th2) {
            th2.printStackTrace();
            i6.d.j("HbgAnalytics", "onError - " + this.f84232b);
        }
    }

    public class d implements Action0 {
        public d() {
        }

        public void call() {
        }
    }

    public class e implements Func1<Integer, Boolean> {
        public e() {
        }

        /* renamed from: a */
        public Boolean call(Integer num) {
            return Boolean.valueOf(num.intValue() == 16 || num.intValue() == 17);
        }
    }

    public class f extends Subscriber<Object> {
        public f() {
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
        }

        public void onNext(Object obj) {
        }
    }

    public b() {
        InputStream inputStream = null;
        try {
            this.f84222c.clear();
            a.b().a().clear();
            InputStream open = j.c().getResources().getAssets().open("hbg_analytics.json");
            AnalyticsInfo analyticsInfo = (AnalyticsInfo) new Gson().fromJson(FileUtil.k(open), AnalyticsInfo.class);
            for (AnalyticsExposureItem next : analyticsInfo.getExposure().getExposureList()) {
                if (!TextUtils.isEmpty(next.getClazz())) {
                    this.f84222c.put(next.getClazz(), next);
                }
            }
            for (AnalyticsClickItem next2 : analyticsInfo.getClick().getClickList()) {
                a.b().a().put(next2.getEventId(), next2);
            }
            i6.d.j("HbgAnalytics", "analyticsMap = " + this.f84222c);
            i6.d.j("HbgAnalytics", "analyticsClickMap = " + a.b().a());
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
        } catch (IOException e12) {
            e12.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            throw th2;
        }
        this.f84223d.add("com.hbg.lib.widgets.dialog.LoadingDialog");
        this.f84223d.add("com.huobi.account.ui.AccountDialogFragment");
        this.f84223d.add("com.hbg.lite.account.LiteAccountDialogFragment");
        this.f84223d.add("com.hbg.lib.widgets.dialog.CommonListPopupDialog");
        this.f84221b = new a();
    }

    public static b l() {
        return f84220i;
    }

    public final boolean j(AnalyticsExposureItem analyticsExposureItem, Fragment fragment) {
        return !"1000110".equals(analyticsExposureItem.getPageId()) && !"1000111".equals(analyticsExposureItem.getPageId());
    }

    public final void k(Activity activity) {
        r(activity);
    }

    public AnalyticsExposureItem m() {
        return this.f84224e;
    }

    public final void n(AnalyticsExposureItem analyticsExposureItem, Fragment fragment) {
        String str = "1000102";
        if (str.equals(analyticsExposureItem.getPageId())) {
            String tag = fragment.getTag();
            if (TextUtils.isEmpty(tag) || !tag.contains("SUPERMARGIN")) {
                str = "1000103";
            }
            analyticsExposureItem.setPageId(str);
        }
    }

    public final void o(AnalyticsExposureItem analyticsExposureItem) {
        AnalyticsExposureItem analyticsExposureItem2 = this.f84224e;
        String pageId = analyticsExposureItem2 != null ? analyticsExposureItem2.getPageId() : "";
        this.f84224e = analyticsExposureItem;
        analyticsExposureItem.setPageStopTime(System.currentTimeMillis());
        this.f84224e.setRef(pageId);
        AnalyticsExposureItem analyticsExposureItem3 = this.f84224e;
        if (!(analyticsExposureItem3 == null || analyticsExposureItem3.getPageStopTime() == 0 || this.f84224e.getPageStartTime() == 0)) {
            this.f84224e.setDuration(this.f84224e.getPageStopTime() - this.f84224e.getPageStartTime());
        }
        i6.d.j("HbgAnalytics", "report data - " + this.f84224e);
        is.a.l(this.f84224e);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            AnalyticsExposureItem analyticsExposureItem = this.f84222c.get(activity.getLocalClassName());
            if (analyticsExposureItem != null && analyticsExposureItem.isHasFragment() && (activity instanceof FragmentActivity)) {
                ((FragmentActivity) activity).getSupportFragmentManager().O1(this.f84221b);
                ((FragmentActivity) activity).getSupportFragmentManager().r1(this.f84221b, false);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (!this.f84223d.contains(localClassName)) {
            i6.d.j("HbgAnalytics", "onActivityPaused - " + localClassName);
        }
    }

    public void onActivityResumed(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (!this.f84223d.contains(localClassName)) {
            i6.d.j("HbgAnalytics", "onActivityResumed - " + localClassName);
            gj.e.b().a(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        try {
            if (this.f84227h == 0) {
                if (this.f84226g) {
                    k(activity);
                } else {
                    this.f84226g = true;
                }
            }
            String localClassName = activity.getLocalClassName();
            if (!this.f84223d.contains(localClassName)) {
                i6.d.j("HbgAnalytics", "onActivityStarted - " + localClassName);
                AnalyticsExposureItem analyticsExposureItem = this.f84222c.get(localClassName);
                if (analyticsExposureItem != null && (!analyticsExposureItem.isHasFragment() || analyticsExposureItem.isPage())) {
                    if (analyticsExposureItem.isMultiPageId() && "com.huobi.otc.ui.CouponActivity".equals(localClassName)) {
                        analyticsExposureItem.setPageId("1005194");
                    } else if ("com.huobi.login.v2.ui.UserLoginActivityV2".equals(localClassName)) {
                        Intent intent = activity.getIntent();
                        if (intent.hasExtra("USER_LOGIN_TYPE")) {
                            int intExtra = intent.getIntExtra("USER_LOGIN_TYPE", 1);
                            if (intExtra == 1) {
                                analyticsExposureItem.setPageId("1005271");
                            } else if (intExtra == 2) {
                                analyticsExposureItem.setPageId("1005253");
                            }
                        }
                    }
                    p(analyticsExposureItem);
                }
                this.f84227h++;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void onActivityStopped(Activity activity) {
        try {
            String localClassName = activity.getLocalClassName();
            if (!this.f84223d.contains(localClassName)) {
                i6.d.j("HbgAnalytics", "onActivityStopped - " + localClassName);
                AnalyticsExposureItem analyticsExposureItem = this.f84222c.get(localClassName);
                if (analyticsExposureItem != null && (!analyticsExposureItem.isHasFragment() || analyticsExposureItem.isPage())) {
                    if (analyticsExposureItem.isMultiPageId() && "com.huobi.otc.ui.CouponActivity".equals(localClassName)) {
                        analyticsExposureItem.setPageId("1005194");
                    }
                    o(analyticsExposureItem);
                }
                this.f84227h--;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void p(AnalyticsExposureItem analyticsExposureItem) {
        long currentTimeMillis = System.currentTimeMillis();
        AnalyticsExposureItem analyticsExposureItem2 = this.f84224e;
        if (analyticsExposureItem2 != null) {
            analyticsExposureItem2.setPageStopTime(currentTimeMillis);
        }
        this.f84225f = analyticsExposureItem;
        analyticsExposureItem.setPageStartTime(currentTimeMillis);
        i6.d.j("HbgAnalytics", "makeVisibleEvent - " + this.f84225f);
    }

    public final void q(Fragment fragment, AnalyticsExposureItem analyticsExposureItem) {
        BehaviorSubject<Integer> uIChangeSubject;
        String name = fragment.getClass().getName();
        if (!this.f84223d.contains(name) && (fragment instanceof LiteBaseFragment) && (uIChangeSubject = ((LiteBaseFragment) fragment).getUIChangeSubject()) != null) {
            uIChangeSubject.filter(new e()).subscribe(new C0867b(name, analyticsExposureItem), new c(name), new d());
        }
    }

    public final void r(Activity activity) {
        if (!TextUtils.isEmpty(r.x().I())) {
            String str = m.d(activity).a() ? "0" : "1";
            HashMap hashMap = new HashMap();
            hashMap.put("pushswitch", str);
            g.i("APP_LIVE_notice_pushswitch", hashMap);
            UserCenterRemoteDataSource.A().putKvStore(MapParamsBuilder.c().a(PlaceFields.WEBSITE, "PRO").a("store_key", "PUSH_SWITCH").a("store_value", str).b()).compose(RxJavaHelper.t((u6.g) null)).subscribe(new f());
        }
    }
}
