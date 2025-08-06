package e7;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.imsdk.HbgDialogManager;
import com.hbg.lib.imsdk.HbgDialogPageItem;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import i6.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import u6.g;

public final class i implements Application.ActivityLifecycleCallbacks {

    /* renamed from: k  reason: collision with root package name */
    public static final i f70058k = new i();

    /* renamed from: b  reason: collision with root package name */
    public final FragmentManager.FragmentLifecycleCallbacks f70059b = new a();

    /* renamed from: c  reason: collision with root package name */
    public final FragmentManager.FragmentLifecycleCallbacks f70060c = new b();

    /* renamed from: d  reason: collision with root package name */
    public Fragment f70061d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f70062e;

    /* renamed from: f  reason: collision with root package name */
    public int f70063f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f70064g = true;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f70065h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public List<String> f70066i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public Map<String, HbgDialogPageItem> f70067j = new HashMap();

    public class a extends FragmentManager.FragmentLifecycleCallbacks {
        public a() {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
            super.onFragmentCreated(fragmentManager, fragment, bundle);
            try {
                String name = fragment.getClass().getName();
                d.b("onFragmentCreated===============" + name + "======" + i.this.f70065h);
                if (i.this.f70065h.contains(name)) {
                    HbgDialogPageItem hbgDialogPageItem = (HbgDialogPageItem) i.this.f70067j.get(name);
                    d.b("onFragmentCreated===============" + hbgDialogPageItem);
                    if (hbgDialogPageItem != null) {
                        hbgDialogPageItem.setViewCreate(true);
                    }
                    i.this.i(fragment);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                d.b(e11.toString() + "================");
            }
        }

        public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
            super.onFragmentStopped(fragmentManager, fragment);
            try {
                String name = fragment.getClass().getName();
                d.b("onFragmentPaused===============+" + name);
                if (i.this.f70065h.contains(name) && i.this.f70061d != null && name.equals(i.this.f70061d.getClass().getName())) {
                    Fragment unused = i.this.f70061d = null;
                    d.b(fragment.toString() + "===========");
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                d.b(e11.toString() + "================");
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0075 A[Catch:{ Exception -> 0x0096 }] */
        /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFragmentResumed(androidx.fragment.app.FragmentManager r4, androidx.fragment.app.Fragment r5) {
            /*
                r3 = this;
                java.lang.String r0 = "onFragmentResumed===============+"
                super.onFragmentStarted(r4, r5)
                java.lang.Class r4 = r5.getClass()     // Catch:{ Exception -> 0x0096 }
                java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x0096 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0096 }
                r1.<init>()     // Catch:{ Exception -> 0x0096 }
                r1.append(r0)     // Catch:{ Exception -> 0x0096 }
                r1.append(r4)     // Catch:{ Exception -> 0x0096 }
                java.lang.String r2 = "===="
                r1.append(r2)     // Catch:{ Exception -> 0x0096 }
                e7.i r2 = e7.i.this     // Catch:{ Exception -> 0x0096 }
                java.util.List r2 = r2.f70065h     // Catch:{ Exception -> 0x0096 }
                r1.append(r2)     // Catch:{ Exception -> 0x0096 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0096 }
                i6.d.b(r1)     // Catch:{ Exception -> 0x0096 }
                e7.i r1 = e7.i.this     // Catch:{ Exception -> 0x0096 }
                java.util.List r1 = r1.f70065h     // Catch:{ Exception -> 0x0096 }
                boolean r1 = r1.contains(r4)     // Catch:{ Exception -> 0x0096 }
                if (r1 != 0) goto L_0x003a
                return
            L_0x003a:
                e7.i r1 = e7.i.this     // Catch:{ Exception -> 0x0096 }
                java.util.Map r1 = r1.f70067j     // Catch:{ Exception -> 0x0096 }
                java.lang.Object r1 = r1.get(r4)     // Catch:{ Exception -> 0x0096 }
                com.hbg.lib.imsdk.HbgDialogPageItem r1 = (com.hbg.lib.imsdk.HbgDialogPageItem) r1     // Catch:{ Exception -> 0x0096 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0096 }
                r2.<init>()     // Catch:{ Exception -> 0x0096 }
                r2.append(r0)     // Catch:{ Exception -> 0x0096 }
                r2.append(r4)     // Catch:{ Exception -> 0x0096 }
                java.lang.String r4 = "====="
                r2.append(r4)     // Catch:{ Exception -> 0x0096 }
                r2.append(r1)     // Catch:{ Exception -> 0x0096 }
                java.lang.String r4 = r2.toString()     // Catch:{ Exception -> 0x0096 }
                i6.d.b(r4)     // Catch:{ Exception -> 0x0096 }
                if (r1 == 0) goto L_0x00b2
                boolean r4 = r1.isViewCreate()     // Catch:{ Exception -> 0x0096 }
                r0 = 0
                if (r4 != 0) goto L_0x0072
                boolean r4 = r5.isVisible()     // Catch:{ Exception -> 0x0096 }
                if (r4 == 0) goto L_0x0070
                goto L_0x0072
            L_0x0070:
                r4 = r0
                goto L_0x0073
            L_0x0072:
                r4 = 1
            L_0x0073:
                if (r4 == 0) goto L_0x00b2
                e7.i r4 = e7.i.this     // Catch:{ Exception -> 0x0096 }
                androidx.fragment.app.Fragment unused = r4.f70061d = r5     // Catch:{ Exception -> 0x0096 }
                r1.setViewCreate(r0)     // Catch:{ Exception -> 0x0096 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0096 }
                r4.<init>()     // Catch:{ Exception -> 0x0096 }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0096 }
                r4.append(r5)     // Catch:{ Exception -> 0x0096 }
                java.lang.String r5 = "==========="
                r4.append(r5)     // Catch:{ Exception -> 0x0096 }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0096 }
                i6.d.b(r4)     // Catch:{ Exception -> 0x0096 }
                goto L_0x00b2
            L_0x0096:
                r4 = move-exception
                r4.printStackTrace()
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r4 = r4.toString()
                r5.append(r4)
                java.lang.String r4 = "================"
                r5.append(r4)
                java.lang.String r4 = r5.toString()
                i6.d.b(r4)
            L_0x00b2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e7.i.a.onFragmentResumed(androidx.fragment.app.FragmentManager, androidx.fragment.app.Fragment):void");
        }

        public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
            super.onFragmentViewDestroyed(fragmentManager, fragment);
        }
    }

    public class b extends FragmentManager.FragmentLifecycleCallbacks {
        public b() {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
            super.onFragmentCreated(fragmentManager, fragment, bundle);
        }
    }

    public class c extends BaseSubscriber<Long> {
        public c() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            HbgDialogManager.A().e0(l11.longValue());
        }
    }

    public static i h() {
        return f70058k;
    }

    public Activity f() {
        return this.f70062e;
    }

    public Fragment g() {
        return this.f70061d;
    }

    public final void i(Fragment fragment) {
        try {
            if (fragment.getChildFragmentManager() != null) {
                fragment.getChildFragmentManager().O1(this.f70060c);
                fragment.getChildFragmentManager().r1(this.f70060c, false);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void j(List<String> list) {
        this.f70066i.clear();
        this.f70066i.addAll(list);
    }

    public void k(List<String> list) {
        this.f70065h.clear();
        this.f70065h.addAll(list);
        for (String next : list) {
            HbgDialogPageItem hbgDialogPageItem = new HbgDialogPageItem();
            hbgDialogPageItem.setClassName(next);
            this.f70067j.put(next, hbgDialogPageItem);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            String localClassName = activity.getLocalClassName();
            boolean contains = this.f70066i.contains(localClassName);
            d.b("================" + localClassName + "=====" + contains + "=====" + this.f70066i);
            if (contains && (activity instanceof FragmentActivity)) {
                ((FragmentActivity) activity).getSupportFragmentManager().O1(this.f70059b);
                ((FragmentActivity) activity).getSupportFragmentManager().r1(this.f70059b, false);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            d.b(e11.toString() + "================");
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        this.f70062e = activity;
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (this.f70063f != 0) {
            HbgDialogManager.A().u();
        } else if (this.f70064g) {
            this.f70064g = false;
        } else {
            v7.b.a().n().b().compose(RxJavaHelper.t((g) null)).subscribe(new c());
            HbgDialogManager.A().m0();
        }
        this.f70063f++;
    }

    public void onActivityStopped(Activity activity) {
        int i11 = this.f70063f - 1;
        this.f70063f = i11;
        if (i11 == 0) {
            HbgDialogManager.A().n0();
        }
    }
}
