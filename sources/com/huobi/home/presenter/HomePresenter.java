package com.huobi.home.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.controller.FutureProductInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.activity.NetworkDetectionActivity;
import com.huobi.app.H5CacheServiceHelper;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.domain.DomainSwitcher;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.home.api.HomeService;
import com.huobi.home.data.HomePageConfigDataModule;
import com.huobi.home.data.HomepageConfig;
import com.huobi.home.data.TransferAmountInfo;
import com.huobi.home.data.TransferAmountInfoDataModule;
import com.huobi.utils.a0;
import d10.p;
import d7.a1;
import d7.m;
import i6.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.r;
import pro.huobi.R;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import yl.n;

public final class HomePresenter extends BaseFragmentPresenter<b> {

    /* renamed from: g  reason: collision with root package name */
    public static final a f72482g = new a((r) null);

    /* renamed from: h  reason: collision with root package name */
    public static String f72483h = "HomePresenter";

    /* renamed from: c  reason: collision with root package name */
    public HomePageConfigDataModule f72484c = new HomePageConfigDataModule();

    /* renamed from: d  reason: collision with root package name */
    public TransferAmountInfoDataModule f72485d = new TransferAmountInfoDataModule();

    /* renamed from: e  reason: collision with root package name */
    public Subscription f72486e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f72487f;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public interface b extends u6.g {
        void Kd();

        void P5();

        void nh(HomepageConfig homepageConfig, TransferAmountInfo transferAmountInfo);
    }

    public static final class c extends EasySubscriber<Boolean> {
        public static final void c(Integer num) {
            if (num != null) {
                n.e(num.intValue());
            }
        }

        public void b(boolean z11) {
            super.onNext(Boolean.valueOf(z11));
            n.c(i.f72506b);
        }

        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            b(((Boolean) obj).booleanValue());
        }
    }

    public static final class d extends BaseSubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public HomepageConfig f72488b;

        /* renamed from: c  reason: collision with root package name */
        public TransferAmountInfo f72489c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HomePresenter f72490d;

        public d(HomePresenter homePresenter) {
            this.f72490d = homePresenter;
        }

        public final HomepageConfig a() {
            HomepageConfig homepageConfig = this.f72488b;
            if (homepageConfig != null) {
                return homepageConfig;
            }
            return null;
        }

        public final TransferAmountInfo b() {
            TransferAmountInfo transferAmountInfo = this.f72489c;
            if (transferAmountInfo != null) {
                return transferAmountInfo;
            }
            return null;
        }

        public final void c(HomepageConfig homepageConfig) {
            this.f72488b = homepageConfig;
        }

        public final void d(TransferAmountInfo transferAmountInfo) {
            this.f72489c = transferAmountInfo;
        }

        public void onCompleted() {
            Log.d("Home", "onCompleted ");
            this.f72490d.N0();
            this.f72490d.z0();
        }

        public void onError(Throwable th2) {
            Log.d("Home", "onError ");
            try {
                this.f72490d.K0();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            if (this.f72490d.t0().d() == null) {
                this.f72490d.t0().m();
            }
            if (this.f72490d.x0().d() == null) {
                this.f72490d.x0().m();
            }
            this.f72490d.N0();
            this.f72490d.z0();
        }

        public void onNext(Object obj) {
            Log.d("Home", "onNext ");
            if (obj instanceof HomepageConfig) {
                HomePresenter homePresenter = this.f72490d;
                c((HomepageConfig) obj);
                homePresenter.t0().j(a());
            }
            if (obj instanceof TransferAmountInfo) {
                HomePresenter homePresenter2 = this.f72490d;
                d((TransferAmountInfo) obj);
                homePresenter2.x0().j(b());
            }
        }
    }

    public static final class e extends BaseSubscriber<HomepageConfig> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePresenter f72491b;

        public e(HomePresenter homePresenter) {
            this.f72491b = homePresenter;
        }

        /* renamed from: a */
        public void onNext(HomepageConfig homepageConfig) {
            Log.d("Home", "homePageConfigObservable  onNext ");
            this.f72491b.t0().j(homepageConfig);
            this.f72491b.N0();
            this.f72491b.z0();
        }

        public void onError(Throwable th2) {
            Log.d("Home", "homePageConfigObservable onError ");
            try {
                this.f72491b.K0();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            if (this.f72491b.t0().d() == null) {
                this.f72491b.t0().m();
            }
            this.f72491b.N0();
            this.f72491b.z0();
        }
    }

    public static final class f extends EasySubscriber<List<? extends SymbolBean>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePresenter f72492b;

        public f(HomePresenter homePresenter) {
            this.f72492b = homePresenter;
        }

        public void onError2(Throwable th2) {
            k.k(th2);
        }

        public void onNext(List<? extends SymbolBean> list) {
            super.onNext(list);
            b bVar = (b) this.f72492b.getUI();
            if (bVar != null) {
                bVar.P5();
            }
            if (tg.r.x().F0()) {
                this.f72492b.p0();
            }
        }
    }

    public static final class g extends BaseSubscriber<TransferAmountInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePresenter f72493b;

        public g(HomePresenter homePresenter) {
            this.f72493b = homePresenter;
        }

        /* renamed from: a */
        public void onNext(TransferAmountInfo transferAmountInfo) {
            Log.d("Home", "getTransferAmountInfo  onNext ");
            this.f72493b.x0().j(transferAmountInfo);
            this.f72493b.N0();
            this.f72493b.z0();
        }

        public void onError(Throwable th2) {
            Log.d("Home", "homePageConfigObservable onError ");
        }
    }

    public static final class h extends BaseSubscriber<List<? extends ContractCurrencyInfo>> {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.huobi.home.data.TransferAmountInfo} */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = (r0 = (com.huobi.home.data.HomepageConfig) r0.d()).modules;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void A0(com.huobi.home.presenter.HomePresenter r2, kotlin.jvm.internal.Ref$ObjectRef r3, int r4, java.lang.String r5) {
        /*
            com.huobi.home.engine.HomeEngineCore r4 = com.huobi.home.engine.HomeEngineCore.f72473a
            com.huobi.home.data.HomePageConfigDataModule r0 = r2.f72484c
            r1 = 0
            if (r0 == 0) goto L_0x001a
            java.lang.Object r0 = r0.d()
            com.huobi.home.data.HomepageConfig r0 = (com.huobi.home.data.HomepageConfig) r0
            if (r0 == 0) goto L_0x001a
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.home.data.HomepageConfig$Module> r0 = r0.modules
            if (r0 == 0) goto L_0x001a
            java.lang.Object r0 = r0.get(r5)
            com.huobi.home.data.HomepageConfig$Module r0 = (com.huobi.home.data.HomepageConfig.Module) r0
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            com.huobi.home.data.TransferAmountInfoDataModule r2 = r2.f72485d
            if (r2 == 0) goto L_0x0026
            java.lang.Object r2 = r2.d()
            r1 = r2
            com.huobi.home.data.TransferAmountInfo r1 = (com.huobi.home.data.TransferAmountInfo) r1
        L_0x0026:
            boolean r2 = r4.b(r0, r1)
            if (r2 != 0) goto L_0x0033
            T r2 = r3.element
            java.util.List r2 = (java.util.List) r2
            r2.add(r5)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.home.presenter.HomePresenter.A0(com.huobi.home.presenter.HomePresenter, kotlin.jvm.internal.Ref$ObjectRef, int, java.lang.String):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.huobi.home.data.TransferAmountInfo} */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = (r0 = (com.huobi.home.data.HomepageConfig) r0.d()).modules;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void B0(com.huobi.home.presenter.HomePresenter r2, kotlin.jvm.internal.Ref$ObjectRef r3, int r4, java.lang.String r5) {
        /*
            com.huobi.home.engine.HomeEngineCore r4 = com.huobi.home.engine.HomeEngineCore.f72473a
            com.huobi.home.data.HomePageConfigDataModule r0 = r2.f72484c
            r1 = 0
            if (r0 == 0) goto L_0x001a
            java.lang.Object r0 = r0.d()
            com.huobi.home.data.HomepageConfig r0 = (com.huobi.home.data.HomepageConfig) r0
            if (r0 == 0) goto L_0x001a
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.home.data.HomepageConfig$Module> r0 = r0.modules
            if (r0 == 0) goto L_0x001a
            java.lang.Object r0 = r0.get(r5)
            com.huobi.home.data.HomepageConfig$Module r0 = (com.huobi.home.data.HomepageConfig.Module) r0
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            com.huobi.home.data.TransferAmountInfoDataModule r2 = r2.f72485d
            if (r2 == 0) goto L_0x0026
            java.lang.Object r2 = r2.d()
            r1 = r2
            com.huobi.home.data.TransferAmountInfo r1 = (com.huobi.home.data.TransferAmountInfo) r1
        L_0x0026:
            boolean r2 = r4.b(r0, r1)
            if (r2 != 0) goto L_0x0033
            T r2 = r3.element
            java.util.List r2 = (java.util.List) r2
            r2.add(r5)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.home.presenter.HomePresenter.B0(com.huobi.home.presenter.HomePresenter, kotlin.jvm.internal.Ref$ObjectRef, int, java.lang.String):void");
    }

    public static final void F0(HomePresenter homePresenter, HashSet hashSet, Map map) {
        H5CacheServiceHelper.startPreloadService(homePresenter.getActivity(), hashSet, map, false);
    }

    public static final void H0(HomePresenter homePresenter) {
        if (!homePresenter.f72487f) {
            try {
                BaseCoreActivity activity = homePresenter.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    homePresenter.E0();
                }
            } catch (Exception unused) {
            }
        }
    }

    public static final List J0(p pVar, Object obj, Object obj2) {
        return (List) pVar.invoke(obj, obj2);
    }

    public static final void L0(Ref$ObjectRef ref$ObjectRef, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ((FragmentActivity) ref$ObjectRef.element).startActivity(new Intent((Context) ref$ObjectRef.element, NetworkDetectionActivity.class));
    }

    public static final void M0(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
    }

    public static final Boolean q0(p pVar, Object obj, Object obj2) {
        return (Boolean) pVar.invoke(obj, obj2);
    }

    public final void C0() {
        if (this.f72484c.d() == null) {
            this.f72484c.h();
        }
        if (this.f72484c.d() == null) {
            this.f72484c.m();
        }
    }

    /* renamed from: D0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        m.c();
        C0();
        N0();
    }

    public final void E0() {
        if (!com.huobi.webcache.c.j().m()) {
            List<String> arrayList = new ArrayList<>();
            this.f72487f = true;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("topic/primelist");
            arrayList2.add("topic/activity");
            arrayList2.add("topic/mining");
            arrayList2.add("welcome-bonus");
            arrayList2.add("topic/trading-activity-tmpl");
            arrayList2.add("topic/christmas");
            if (arrayList.size() > 20) {
                arrayList = arrayList.subList(0, 20);
            }
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            arrayList4.addAll(arrayList);
            for (String str : arrayList) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (StringsKt__StringsKt.R(str, (String) it2.next(), false, 2, (Object) null)) {
                            arrayList4.remove(str);
                            arrayList3.add(str);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Accept-Language", AppLanguageHelper.getInstance().getCurLanguageHeader());
            ArrayList<String> arrayList5 = new ArrayList<>();
            arrayList5.addAll(arrayList3);
            arrayList5.addAll(arrayList4);
            HashSet hashSet = new HashSet();
            for (String next : H5CacheServiceHelper.getConfigBean().preloadUrlList) {
                if (!TextUtils.isEmpty(next)) {
                    if (StringsKt__StringsJVMKt.M(next, "/", false, 2, (Object) null)) {
                        hashSet.add(a0.j() + next);
                    } else if (StringsKt__StringsJVMKt.M(next, "http", false, 2, (Object) null)) {
                        hashSet.add(next);
                    } else if (StringsKt__StringsJVMKt.M(next, "$host", false, 2, (Object) null) || StringsKt__StringsKt.R(next, "$language", false, 2, (Object) null) || StringsKt__StringsKt.R(next, "$version", false, 2, (Object) null)) {
                        hashSet.add(StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(next, "$host", a0.j(), false, 4, (Object) null), "$language", m6.a.f().toLowerCase(Locale.getDefault()), false, 4, (Object) null), "$version", "10.54.0", false, 4, (Object) null));
                    }
                }
            }
            for (String str2 : arrayList5) {
                if (!StringsKt__StringsKt.R(str2, "/p/page", false, 2, (Object) null) && !StringsKt__StringsJVMKt.M(str2, "holigeit", false, 2, (Object) null)) {
                    hashSet.add(str2);
                }
            }
            if (H5CacheServiceHelper.isIsInit()) {
                H5CacheServiceHelper.startPreloadService(getActivity(), hashSet, hashMap, false);
            } else {
                H5CacheServiceHelper.init(new e(this, hashSet, hashMap));
            }
        }
    }

    public final void G0() {
        if (!this.f72487f) {
            new Handler(Looper.getMainLooper()).postDelayed(new f(this), H5CacheServiceHelper.getConfigBean().delaySecond);
        }
    }

    public final void I0() {
        Observable.zip(ContractCurrencyUtils.g(true).compose(RxJavaHelper.t((u6.g) getUI())), SwapCurrencyInfoController.k().f(true).compose(RxJavaHelper.t((u6.g) getUI())), new g(HomePresenter$refreshContract$1.INSTANCE)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new h());
        FutureContractInfoController.n().s(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        FutureProductInfoController.d().h(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        FutureContractInfoController.n().q(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        FutureProductInfoController.d().i(TradeType.LINEAR_SWAP, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
    }

    public final void K0() {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        T activity = getActivity();
        ref$ObjectRef.element = activity;
        if (activity == null) {
            ref$ObjectRef.element = (FragmentActivity) oa.a.g().b();
        }
        DomainSwitcher.A().V0();
        T t11 = ref$ObjectRef.element;
        DialogUtils.c0((FragmentActivity) t11, ((FragmentActivity) t11).getString(R.string.n_network_error_content), (String) null, ((FragmentActivity) ref$ObjectRef.element).getString(R.string.n_check_network_status), ((FragmentActivity) ref$ObjectRef.element).getString(R.string.n_dialog_ok), new c(ref$ObjectRef), d.f72499a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void N0() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "Home"
            java.lang.String r1 = "updateHomeUI "
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x002d }
            h6.a r0 = r3.getUI()     // Catch:{ all -> 0x002d }
            if (r0 != 0) goto L_0x0010
            monitor-exit(r3)
            return
        L_0x0010:
            com.huobi.home.data.HomePageConfigDataModule r0 = r3.f72484c     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.d()     // Catch:{ all -> 0x002d }
            com.huobi.home.data.HomepageConfig r0 = (com.huobi.home.data.HomepageConfig) r0     // Catch:{ all -> 0x002d }
            com.huobi.home.data.TransferAmountInfoDataModule r1 = r3.f72485d     // Catch:{ all -> 0x002d }
            java.lang.Object r1 = r1.d()     // Catch:{ all -> 0x002d }
            com.huobi.home.data.TransferAmountInfo r1 = (com.huobi.home.data.TransferAmountInfo) r1     // Catch:{ all -> 0x002d }
            h6.a r2 = r3.getUI()     // Catch:{ all -> 0x002d }
            com.huobi.home.presenter.HomePresenter$b r2 = (com.huobi.home.presenter.HomePresenter.b) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            r2.nh(r0, r1)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return
        L_0x002d:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.home.presenter.HomePresenter.N0():void");
    }

    public void Z(boolean z11) {
        super.Z(z11);
        Log.d("HOME", "presenter--onVisibleChangedFinal -- visible:" + z11);
        if (z11) {
            gj.b.j().w();
            b bVar = (b) getUI();
            if (bVar != null) {
                bVar.Kd();
            }
        }
    }

    public final void m0() {
        Subscription subscription = this.f72486e;
        boolean z11 = false;
        if (subscription != null && !subscription.isUnsubscribed()) {
            z11 = true;
        }
        if (z11) {
            Subscription subscription2 = this.f72486e;
            if (subscription2 != null) {
                subscription2.unsubscribe();
            }
            this.f72486e = null;
        }
    }

    public final void n0() {
        this.f72485d.a();
    }

    public final void p0() {
        Observable<R> observable;
        m0();
        if (gj.a.b().d()) {
            observable = Observable.zip(v7.b.a().getCouponUserOtc().b().compose(RxJavaHelper.t((u6.g) getUI())).onErrorResumeNext(Observable.just(null)), AssetDataCacheManager.k0().z0().compose(RxJavaHelper.t((u6.g) getUI())).onErrorResumeNext(Observable.just(Boolean.FALSE)), new h(HomePresenter$getBalanceData$observable$1.INSTANCE));
        } else {
            observable = AssetDataCacheManager.k0().z0().compose(RxJavaHelper.t((u6.g) getUI())).onErrorResumeNext(Observable.just(Boolean.FALSE));
        }
        this.f72486e = observable.subscribe((Subscriber<? super R>) new c());
    }

    public final Map<String, Object> r0() {
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-language", AppLanguageHelper.getInstance().getCurLanguageHeader());
        int g11 = yl.g.h().g();
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
        hashMap.put("HB-COUNTRY-ID", Integer.valueOf(g11));
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s0() {
        /*
            r3 = this;
            r3.v0()
            rx.Observable r0 = r3.y0()
            rx.Observable r1 = r3.u0()
            r3.C0()
            tg.r r2 = tg.r.x()
            boolean r2 = r2.F0()
            if (r2 == 0) goto L_0x003b
            tg.r r2 = tg.r.x()
            java.lang.String r2 = r2.H()
            if (r2 == 0) goto L_0x002b
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r2 = 0
            goto L_0x002c
        L_0x002b:
            r2 = 1
        L_0x002c:
            if (r2 != 0) goto L_0x003b
            rx.Observable r0 = rx.Observable.mergeDelayError(r1, r0)
            com.huobi.home.presenter.HomePresenter$d r1 = new com.huobi.home.presenter.HomePresenter$d
            r1.<init>(r3)
            r0.subscribe(r1)
            goto L_0x005a
        L_0x003b:
            com.huobi.home.data.TransferAmountInfoDataModule r0 = r3.f72485d
            java.lang.Object r0 = r0.d()
            if (r0 != 0) goto L_0x0052
            tg.r r0 = tg.r.x()
            boolean r0 = r0.F0()
            if (r0 == 0) goto L_0x0052
            com.huobi.home.data.TransferAmountInfoDataModule r0 = r3.f72485d
            r0.m()
        L_0x0052:
            com.huobi.home.presenter.HomePresenter$e r0 = new com.huobi.home.presenter.HomePresenter$e
            r0.<init>(r3)
            r1.subscribe(r0)
        L_0x005a:
            com.hbg.lib.common.ui.BaseCoreActivity r0 = r3.getActivity()
            boolean r0 = com.hbg.lib.common.network.NetworkStatus.c(r0)
            if (r0 == 0) goto L_0x0067
            r3.G0()
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.home.presenter.HomePresenter.s0():void");
    }

    public final HomePageConfigDataModule t0() {
        return this.f72484c;
    }

    public final Observable<HomepageConfig> u0() {
        return ((HomeService) tq.p.C(HomeService.class)).getHomeConfigList(r0()).compose(tq.p.E()).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public final void v0() {
        a1.v().z0(true).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new f(this));
    }

    public final void w0() {
        if (tg.r.x().F0()) {
            y0().subscribe(new g(this));
            return;
        }
        n0();
        N0();
        z0();
    }

    public final TransferAmountInfoDataModule x0() {
        return this.f72485d;
    }

    public final Observable<TransferAmountInfo> y0() {
        return ((HomeService) tq.p.C(HomeService.class)).getTransferAmountInfo(r0()).compose(tq.p.E()).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001e, code lost:
        r2 = (r2 = (com.huobi.home.data.HomepageConfig) r2.d()).structure;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z0() {
        /*
            r13 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.element = r2
            com.huobi.home.data.HomePageConfigDataModule r2 = r13.f72484c
            r3 = 0
            if (r2 == 0) goto L_0x0025
            java.lang.Object r2 = r2.d()
            com.huobi.home.data.HomepageConfig r2 = (com.huobi.home.data.HomepageConfig) r2
            if (r2 == 0) goto L_0x0025
            com.huobi.home.data.HomepageConfig$Structure r2 = r2.structure
            if (r2 == 0) goto L_0x0025
            java.util.List<java.lang.String> r2 = r2.navigation
            goto L_0x0026
        L_0x0025:
            r2 = r3
        L_0x0026:
            com.huobi.home.presenter.a r4 = new com.huobi.home.presenter.a
            r4.<init>(r13, r1)
            com.hbg.lib.common.utils.UtilCollections.c(r2, r4)
            com.huobi.home.data.HomePageConfigDataModule r2 = r13.f72484c
            if (r2 == 0) goto L_0x0041
            java.lang.Object r2 = r2.d()
            com.huobi.home.data.HomepageConfig r2 = (com.huobi.home.data.HomepageConfig) r2
            if (r2 == 0) goto L_0x0041
            com.huobi.home.data.HomepageConfig$Structure r2 = r2.structure
            if (r2 == 0) goto L_0x0041
            java.util.List<java.lang.String> r2 = r2.fluent
            goto L_0x0042
        L_0x0041:
            r2 = r3
        L_0x0042:
            com.huobi.home.presenter.b r4 = new com.huobi.home.presenter.b
            r4.<init>(r13, r1)
            com.hbg.lib.common.utils.UtilCollections.c(r2, r4)
            T r1 = r1.element
            r4 = r1
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 62
            r12 = 0
            java.lang.String r5 = ","
            java.lang.String r1 = kotlin.collections.CollectionsKt___CollectionsKt.k0(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            java.lang.String r2 = "layout"
            r0.put(r2, r1)
            tg.r r1 = tg.r.x()
            boolean r1 = r1.F0()
            r2 = 0
            if (r1 != 0) goto L_0x0070
            java.lang.String r1 = "login"
            goto L_0x008e
        L_0x0070:
            com.huobi.home.data.TransferAmountInfoDataModule r1 = r13.f72485d
            if (r1 == 0) goto L_0x007f
            java.lang.Object r1 = r1.d()
            com.huobi.home.data.TransferAmountInfo r1 = (com.huobi.home.data.TransferAmountInfo) r1
            if (r1 == 0) goto L_0x007f
            java.lang.String r1 = r1.f72470a
            goto L_0x0080
        L_0x007f:
            r1 = r3
        L_0x0080:
            r4 = 2
            java.lang.String r5 = "1"
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.x(r1, r5, r2, r4, r3)
            if (r1 == 0) goto L_0x008c
            java.lang.String r1 = "general"
            goto L_0x008e
        L_0x008c:
            java.lang.String r1 = "deposit"
        L_0x008e:
            java.lang.String r3 = "status"
            r0.put(r3, r1)
            java.lang.String r1 = com.huobi.utils.ADJustHelper.d()
            int r3 = r1.length()
            r4 = 1
            if (r3 <= 0) goto L_0x00a0
            r3 = r4
            goto L_0x00a1
        L_0x00a0:
            r3 = r2
        L_0x00a1:
            if (r3 == 0) goto L_0x00a8
            java.lang.String r3 = "adjust_adid"
            r0.put(r3, r1)
        L_0x00a8:
            java.lang.String r1 = com.huobi.utils.ADJustHelper.e()
            int r3 = r1.length()
            if (r3 <= 0) goto L_0x00b3
            r2 = r4
        L_0x00b3:
            if (r2 == 0) goto L_0x00ba
            java.lang.String r2 = "gps_adid"
            r0.put(r2, r1)
        L_0x00ba:
            java.lang.String r1 = "homepage_view"
            gs.g.i(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.home.presenter.HomePresenter.z0():void");
    }
}
