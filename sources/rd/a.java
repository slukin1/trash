package rd;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.huobi.im.group.bean.ActivePageItem;
import com.hbg.module.huobi.im.group.bean.OberverData;
import com.hbg.module.huobi.im.manager.ActiveViewManager;
import com.hbg.module.huobi.im.observer.ActiveObserverHelper;
import i6.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class a implements Application.ActivityLifecycleCallbacks, Observer {

    /* renamed from: p  reason: collision with root package name */
    public static final a f23326p = new a();

    /* renamed from: b  reason: collision with root package name */
    public final FragmentManager.FragmentLifecycleCallbacks f23327b;

    /* renamed from: c  reason: collision with root package name */
    public final FragmentManager.FragmentLifecycleCallbacks f23328c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f23329d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f23330e;

    /* renamed from: f  reason: collision with root package name */
    public int f23331f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23332g = true;

    /* renamed from: h  reason: collision with root package name */
    public HashSet<String> f23333h = new HashSet<>();

    /* renamed from: i  reason: collision with root package name */
    public List<String> f23334i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public List<String> f23335j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public List<String> f23336k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public Map<String, ActivePageItem> f23337l = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    public Map<String, String> f23338m;

    /* renamed from: n  reason: collision with root package name */
    public List<String> f23339n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public boolean f23340o = false;

    /* renamed from: rd.a$a  reason: collision with other inner class name */
    public class C0209a extends FragmentManager.FragmentLifecycleCallbacks {
        public C0209a() {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
            super.onFragmentCreated(fragmentManager, fragment, bundle);
            try {
                a.this.o(fragment);
                String name = fragment.getClass().getName();
                d.b("onFragmentCreated===============" + name + "======" + a.this.f23334i);
                if (a.this.f23334i.contains(name)) {
                    ActivePageItem activePageItem = (ActivePageItem) a.this.f23337l.get(name);
                    d.b("onFragmentCreated===============" + activePageItem);
                    if (activePageItem != null) {
                        activePageItem.setViewCreate(true);
                    }
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
                if (!(fragment instanceof DialogFragment)) {
                    a.this.n();
                }
                if (a.this.f23334i.contains(name) && a.this.f23329d != null && name.equals(a.this.f23329d.getClass().getName())) {
                    Fragment unused = a.this.f23329d = null;
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
                rd.a r2 = rd.a.this     // Catch:{ Exception -> 0x0096 }
                java.util.List r2 = r2.f23334i     // Catch:{ Exception -> 0x0096 }
                r1.append(r2)     // Catch:{ Exception -> 0x0096 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0096 }
                i6.d.b(r1)     // Catch:{ Exception -> 0x0096 }
                rd.a r1 = rd.a.this     // Catch:{ Exception -> 0x0096 }
                java.util.List r1 = r1.f23334i     // Catch:{ Exception -> 0x0096 }
                boolean r1 = r1.contains(r4)     // Catch:{ Exception -> 0x0096 }
                if (r1 != 0) goto L_0x003a
                return
            L_0x003a:
                rd.a r1 = rd.a.this     // Catch:{ Exception -> 0x0096 }
                java.util.Map r1 = r1.f23337l     // Catch:{ Exception -> 0x0096 }
                java.lang.Object r1 = r1.get(r4)     // Catch:{ Exception -> 0x0096 }
                com.hbg.module.huobi.im.group.bean.ActivePageItem r1 = (com.hbg.module.huobi.im.group.bean.ActivePageItem) r1     // Catch:{ Exception -> 0x0096 }
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
                rd.a r4 = rd.a.this     // Catch:{ Exception -> 0x0096 }
                androidx.fragment.app.Fragment unused = r4.f23329d = r5     // Catch:{ Exception -> 0x0096 }
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
            throw new UnsupportedOperationException("Method not decompiled: rd.a.C0209a.onFragmentResumed(androidx.fragment.app.FragmentManager, androidx.fragment.app.Fragment):void");
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
            try {
                String name = fragment.getClass().getName();
                d.b("onFragmentCreated===============" + name + "======" + a.this.f23334i);
                if (a.this.f23334i.contains(name)) {
                    ActivePageItem activePageItem = (ActivePageItem) a.this.f23337l.get(name);
                    d.b("onFragmentCreated===============" + activePageItem);
                    if (activePageItem != null) {
                        activePageItem.setViewCreate(true);
                    }
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
                if (!(fragment instanceof DialogFragment)) {
                    a.this.n();
                }
                if (a.this.f23334i.contains(name) && a.this.f23329d != null && name.equals(a.this.f23329d.getClass().getName())) {
                    Fragment unused = a.this.f23329d = null;
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
                rd.a r2 = rd.a.this     // Catch:{ Exception -> 0x0096 }
                java.util.List r2 = r2.f23334i     // Catch:{ Exception -> 0x0096 }
                r1.append(r2)     // Catch:{ Exception -> 0x0096 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0096 }
                i6.d.b(r1)     // Catch:{ Exception -> 0x0096 }
                rd.a r1 = rd.a.this     // Catch:{ Exception -> 0x0096 }
                java.util.List r1 = r1.f23334i     // Catch:{ Exception -> 0x0096 }
                boolean r1 = r1.contains(r4)     // Catch:{ Exception -> 0x0096 }
                if (r1 != 0) goto L_0x003a
                return
            L_0x003a:
                rd.a r1 = rd.a.this     // Catch:{ Exception -> 0x0096 }
                java.util.Map r1 = r1.f23337l     // Catch:{ Exception -> 0x0096 }
                java.lang.Object r1 = r1.get(r4)     // Catch:{ Exception -> 0x0096 }
                com.hbg.module.huobi.im.group.bean.ActivePageItem r1 = (com.hbg.module.huobi.im.group.bean.ActivePageItem) r1     // Catch:{ Exception -> 0x0096 }
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
                rd.a r4 = rd.a.this     // Catch:{ Exception -> 0x0096 }
                androidx.fragment.app.Fragment unused = r4.f23329d = r5     // Catch:{ Exception -> 0x0096 }
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
            throw new UnsupportedOperationException("Method not decompiled: rd.a.b.onFragmentResumed(androidx.fragment.app.FragmentManager, androidx.fragment.app.Fragment):void");
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f23343b;

        public c(Map map) {
            this.f23343b = map;
        }

        public void run() {
            a aVar = a.this;
            aVar.p(this.f23343b, aVar.f23330e);
            Map unused = a.this.f23338m = null;
            for (String str : a.this.f23339n) {
                if (a.this.f23330e != null && TextUtils.equals(str, a.this.f23330e.getClass().getName())) {
                    Map unused2 = a.this.f23338m = this.f23343b;
                    return;
                }
            }
        }
    }

    public a() {
        ActiveObserverHelper.b().addObserver(this);
        this.f23327b = new C0209a();
        this.f23328c = new b();
    }

    public static a m() {
        return f23326p;
    }

    public void k(List<String> list) {
        this.f23339n.clear();
        this.f23339n.addAll(list);
    }

    public Activity l() {
        return this.f23330e;
    }

    public final void n() {
        if (ActiveViewManager.e().f()) {
            for (String next : this.f23339n) {
                Activity activity = this.f23330e;
                if (activity != null && TextUtils.equals(next, activity.getClass().getName())) {
                    return;
                }
            }
            ActiveViewManager.e().m(1);
        }
    }

    public final void o(Fragment fragment) {
        try {
            if (fragment.getChildFragmentManager() != null) {
                fragment.getChildFragmentManager().O1(this.f23328c);
                fragment.getChildFragmentManager().r1(this.f23328c, false);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            d.b(e11.toString() + "================");
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            if (activity instanceof FragmentActivity) {
                ((FragmentActivity) activity).getSupportFragmentManager().O1(this.f23327b);
                ((FragmentActivity) activity).getSupportFragmentManager().r1(this.f23327b, false);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            d.b(e11.toString() + "================");
        }
    }

    public void onActivityDestroyed(Activity activity) {
        this.f23333h.remove(activity.getClass().getName());
    }

    public void onActivityPaused(Activity activity) {
        if (!activity.getLocalClassName().contains("FeedShareActivity") && !activity.getLocalClassName().contains("GroupShareActivity")) {
            n();
        }
    }

    public void onActivityResumed(Activity activity) {
        this.f23330e = activity;
        Map<String, String> map = this.f23338m;
        if (map != null && this.f23340o) {
            this.f23340o = false;
            p(map, activity);
            this.f23338m = null;
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        this.f23331f++;
    }

    public void onActivityStopped(Activity activity) {
        this.f23331f--;
    }

    public final void p(Map<String, String> map, Activity activity) {
        if (map != null && activity != null && !activity.isFinishing()) {
            d.j("hbactive", "run: params：" + map);
            try {
                String str = map.get("hbgContentUrl");
                if (!TextUtils.isEmpty(map.get("hbgContentUrl"))) {
                    d.j("hbactive", "showActiveView: 开始展示活动界面");
                    if (str.indexOf("/") == 0) {
                        str = str.substring(1);
                    }
                    ActiveViewManager.e().n(1, activity, BaseModuleConfig.a().k(str), 1);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void update(Observable observable, Object obj) {
        if ((observable instanceof ActiveObserverHelper) && (obj instanceof OberverData)) {
            OberverData oberverData = (OberverData) obj;
            if (oberverData.getType() == 1) {
                d.c("hbactive", "update: 监听到了活动header");
                if (oberverData.getData() instanceof Map) {
                    Map<String, String> map = (Map) oberverData.getData();
                    this.f23338m = map;
                    this.f23340o = true;
                    Activity activity = this.f23330e;
                    if (activity != null && !activity.getLocalClassName().contains("FeedShareActivity") && !this.f23330e.getLocalClassName().contains("GroupShareActivity")) {
                        this.f23340o = false;
                        if (this.f23330e.getWindow() != null && this.f23330e.getWindow().getDecorView() != null) {
                            this.f23330e.getWindow().getDecorView().post(new c(map));
                        }
                    }
                }
            }
        }
    }
}
