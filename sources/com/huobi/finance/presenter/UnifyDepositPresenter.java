package com.huobi.finance.presenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.ChainItem;
import com.huobi.finance.bean.CurrencyAddrWithTag;
import com.huobi.finance.bean.OneOffAddress;
import com.huobi.finance.controller.DepositWithdrawController;
import com.huobi.finance.utils.DepositWithdrawHelper;
import com.huobi.utils.e1;
import d7.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;
import tq.p;

public class UnifyDepositPresenter extends ActivityPresenter<g> {

    /* renamed from: a  reason: collision with root package name */
    public final List<ChainItem> f45657a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Subscription f45658b;

    /* renamed from: c  reason: collision with root package name */
    public String f45659c;

    /* renamed from: d  reason: collision with root package name */
    public String f45660d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45661e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45662f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45663g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f45664h;

    /* renamed from: i  reason: collision with root package name */
    public OneOffAddress f45665i;

    /* renamed from: j  reason: collision with root package name */
    public HBDialogFragment f45666j;

    /* renamed from: k  reason: collision with root package name */
    public List<ChainInfo> f45667k;

    /* renamed from: l  reason: collision with root package name */
    public ChainInfo f45668l;

    /* renamed from: m  reason: collision with root package name */
    public ChainItem.a f45669m = new a();

    public class a implements ChainItem.a {

        /* renamed from: com.huobi.finance.presenter.UnifyDepositPresenter$a$a  reason: collision with other inner class name */
        public class C0569a extends BaseSubscriber<Integer> {
            public C0569a() {
            }

            /* renamed from: a */
            public void onNext(Integer num) {
                super.onNext(num);
                UnifyDepositPresenter.this.w0();
            }

            public void onError(Throwable th2) {
                super.onError(th2);
                ((g) UnifyDepositPresenter.this.getUI()).dismissProgressDialog();
            }

            public void onStart() {
                super.onStart();
                ((g) UnifyDepositPresenter.this.getUI()).showProgressDialog();
            }
        }

        public a() {
        }

        public boolean a(int i11, ChainInfo chainInfo) {
            return UnifyDepositPresenter.this.f45668l != null && UnifyDepositPresenter.this.f45668l.equals(chainInfo);
        }

        public void b(int i11, ChainInfo chainInfo) {
            if (!DepositWithdrawHelper.v(chainInfo)) {
                DepositWithdrawController.y(UnifyDepositPresenter.this.getActivity(), chainInfo);
                return;
            }
            ChainInfo unused = UnifyDepositPresenter.this.f45668l = chainInfo;
            ((g) UnifyDepositPresenter.this.getUI()).K3(UnifyDepositPresenter.this.f45657a);
            boolean unused2 = UnifyDepositPresenter.this.f45662f = true;
            boolean unused3 = UnifyDepositPresenter.this.f45661e = false;
            boolean unused4 = UnifyDepositPresenter.this.f45663g = false;
            UnifyDepositPresenter.this.u0();
            ((g) UnifyDepositPresenter.this.getUI()).Oc(UnifyDepositPresenter.this.I0());
            ((g) UnifyDepositPresenter.this.getUI()).J4(DepositWithdrawHelper.d(UnifyDepositPresenter.this.f45668l));
            Subscription unused5 = UnifyDepositPresenter.this.f45658b = Observable.just(1).subscribe(new C0569a());
        }
    }

    public class b extends EasySubscriber<androidx.core.util.c<String, Bitmap>> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(androidx.core.util.c<String, Bitmap> cVar) {
            super.onNext(cVar);
            ((g) UnifyDepositPresenter.this.getUI()).Lc((String) cVar.f8468a, (String) null, (Bitmap) cVar.f8469b);
        }

        public void onAfter() {
            super.onAfter();
            ((g) UnifyDepositPresenter.this.getUI()).dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((g) UnifyDepositPresenter.this.getUI()).Ne();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((g) UnifyDepositPresenter.this.getUI()).Ne();
        }
    }

    public class c extends EasySubscriber<androidx.core.util.c<CurrencyAddrWithTag, Bitmap>> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(androidx.core.util.c<CurrencyAddrWithTag, Bitmap> cVar) {
            String str;
            super.onNext(cVar);
            F f11 = cVar.f8468a;
            String str2 = null;
            if (f11 == null) {
                str = null;
            } else {
                str = ((CurrencyAddrWithTag) f11).getAddress();
            }
            F f12 = cVar.f8468a;
            if (f12 != null) {
                str2 = ((CurrencyAddrWithTag) f12).getTag();
            }
            ((g) UnifyDepositPresenter.this.getUI()).Lc(str, str2, (Bitmap) cVar.f8469b);
        }

        public void onAfter() {
            super.onAfter();
            ((g) UnifyDepositPresenter.this.getUI()).dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((g) UnifyDepositPresenter.this.getUI()).Ne();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((g) UnifyDepositPresenter.this.getUI()).Ne();
        }
    }

    public class d extends EasySubscriber<List<Object>> {
        public d() {
        }

        public void onAfter() {
            super.onAfter();
            ((g) UnifyDepositPresenter.this.getUI()).dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((g) UnifyDepositPresenter.this.getUI()).Ne();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((g) UnifyDepositPresenter.this.getUI()).Ne();
        }

        public void onNext(List<Object> list) {
            super.onNext(list);
            if (!((List) list.get(0)).isEmpty()) {
                ((g) UnifyDepositPresenter.this.getUI()).p9((Bitmap) list.get(1));
                boolean unused = UnifyDepositPresenter.this.f45661e = false;
                return;
            }
            boolean unused2 = UnifyDepositPresenter.this.f45661e = true;
        }
    }

    public class e extends EasySubscriber<List<Object>> {
        public e() {
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }

        public void onNext(List<Object> list) {
            super.onNext(list);
            ((g) UnifyDepositPresenter.this.getUI()).Nf((OneOffAddress) list.get(0), (String) null, (Bitmap) list.get(1));
        }
    }

    public class f extends EasySubscriber<Bitmap> {
        public f() {
        }

        public void onError2(Throwable th2) {
            ((g) UnifyDepositPresenter.this.getUI()).Ne();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((g) UnifyDepositPresenter.this.getUI()).Ne();
        }

        public void onNext(Bitmap bitmap) {
            super.onNext(bitmap);
            ((g) UnifyDepositPresenter.this.getUI()).p9(bitmap);
        }
    }

    public interface g extends u6.g {
        void J4(String str);

        void K3(List<ChainItem> list);

        void Lc(String str, String str2, Bitmap bitmap);

        void Lf();

        void M6();

        void Ne();

        void Nf(OneOffAddress oneOffAddress, String str, Bitmap bitmap);

        void Oc(boolean z11);

        Bitmap S6(String str, int i11, int i12);

        void dg(boolean z11);

        void gc(String str, Bitmap bitmap);

        void gf(boolean z11);

        void i5();

        void p9(Bitmap bitmap);

        void u8();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ androidx.core.util.c J0(CurrencyAddrWithTag currencyAddrWithTag) {
        if (currencyAddrWithTag instanceof CurrencyAddrWithTag) {
            return new androidx.core.util.c(currencyAddrWithTag, ((g) getUI()).S6(currencyAddrWithTag.getAddress(), (PixelUtils.g() * 9) / 20, (PixelUtils.g() * 9) / 20));
        }
        return new androidx.core.util.c(null, null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ androidx.core.util.c K0(String str) {
        if (str instanceof String) {
            return new androidx.core.util.c(str, ((g) getUI()).S6(str, (PixelUtils.g() * 9) / 20, (PixelUtils.g() * 9) / 20));
        }
        return new androidx.core.util.c(null, null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List L0(List list) {
        this.f45667k = list;
        ChainInfo l11 = DepositWithdrawHelper.l(list);
        if (DepositWithdrawHelper.z(list)) {
            if (l11 == null) {
                l11 = DepositWithdrawHelper.f(list);
            }
            this.f45668l = l11;
            ((g) getUI()).gf(false);
            ((g) getUI()).dg(false);
        } else if (DepositWithdrawHelper.y(list)) {
            ChainInfo g11 = DepositWithdrawHelper.g(list);
            if (g11 != null) {
                l11 = g11;
            } else if (l11 == null) {
                l11 = DepositWithdrawHelper.f(list);
            }
            this.f45668l = l11;
            ((g) getUI()).gf(false);
            ((g) getUI()).dg(true);
        } else if (DepositWithdrawHelper.x(list)) {
            if (l11 == null) {
                l11 = DepositWithdrawHelper.f(list);
            }
            this.f45668l = l11;
            ((g) getUI()).gf(true);
            ((g) getUI()).dg(false);
        } else {
            if (l11 == null) {
                l11 = DepositWithdrawHelper.f(list);
            }
            this.f45668l = l11;
            ((g) getUI()).gf(false);
            ((g) getUI()).dg(false);
        }
        ((g) getUI()).Oc(I0());
        ((g) getUI()).J4(DepositWithdrawHelper.d(this.f45668l));
        this.f45657a.clear();
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ChainInfo chainInfo = (ChainInfo) it2.next();
                if (chainInfo != null) {
                    ChainItem chainItem = new ChainItem();
                    chainItem.f(this.f45669m);
                    chainItem.g(chainInfo);
                    chainItem.h(chainInfo.equals(this.f45668l));
                    this.f45657a.add(chainItem);
                }
            }
        }
        ((g) getUI()).K3(this.f45657a);
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M0() {
        ((g) getUI()).showProgressDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N0(List list) {
        w0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0(APIStatusErrorException aPIStatusErrorException) {
        ((g) getUI()).Ne();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P0(Throwable th2) {
        ((g) getUI()).Ne();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q0() {
        this.f45664h = false;
        ((g) getUI()).dismissProgressDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R0(androidx.core.util.c cVar) {
        ((g) getUI()).gc((String) cVar.f8468a, (Bitmap) cVar.f8469b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List S0(OneOffAddress oneOffAddress) {
        return Arrays.asList(new Object[]{oneOffAddress, ((g) getUI()).S6(oneOffAddress.getAddress(), (PixelUtils.g() * 9) / 20, (PixelUtils.g() * 9) / 20)});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T0(List list) {
        this.f45661e = false;
        HuobiToastUtil.p(R.string.currency_deposit_new_address_already_builded);
        ((g) getUI()).Nf((OneOffAddress) list.get(0), (String) null, (Bitmap) list.get(1));
    }

    public static /* synthetic */ void U0(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void V0(Throwable th2) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List W0(List list) {
        return Arrays.asList(new Object[]{list, v0()});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X0(HBDialogFragment hBDialogFragment) {
        l1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List Y0(OneOffAddress oneOffAddress) {
        return Arrays.asList(new Object[]{oneOffAddress, ((g) getUI()).S6(oneOffAddress.getAddress(), (PixelUtils.g() * 9) / 20, (PixelUtils.g() * 9) / 20)});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Bitmap Z0(Integer num) {
        return v0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a1(DialogUtils.b.f fVar, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        if (fVar != null) {
            fVar.a(hBDialogFragment);
        }
        if (this.f45662f) {
            this.f45662f = false;
            if (this.f45661e) {
                e1();
            }
        } else if (this.f45663g) {
            OneOffAddress oneOffAddress = this.f45665i;
            if (oneOffAddress != null) {
                this.f45663g = false;
                Observable.just(oneOffAddress).observeOn(Schedulers.io()).map(new a7(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new e());
            }
        } else {
            Observable.just(0).observeOn(Schedulers.io()).map(new c7(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new f());
        }
    }

    public final void A0() {
        this.f45662f = true;
        this.f45661e = false;
        this.f45663g = false;
        this.f45664h = true;
        ((g) getUI()).i5();
        D0();
    }

    public final Observable B0(boolean z11, String str, String str2) {
        Class cls = FinanceService.class;
        MapParamsBuilder a11 = new MapParamsBuilder().a(FirebaseAnalytics.Param.CURRENCY, str);
        if (str2 != null) {
            a11.a("chain", str2);
        }
        if (z11) {
            return ((FinanceService) p.W(cls)).getDepositAddressWithTag(a11.b()).compose(p.a0()).observeOn(Schedulers.computation()).map(new z6(this)).compose(RxJavaHelper.t((u6.g) getUI()));
        }
        return ((FinanceService) p.W(cls)).getDepositAddress(a11.b()).compose(p.a0()).observeOn(Schedulers.computation()).map(new d7(this)).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public String C0() {
        return this.f45659c;
    }

    public void D0() {
        u0();
        b1().map(new e7(this)).subscribe(new q6.d((u6.g) getUI(), new i7(this), new n7(this), new k7(this), new l7(this), new h7(this)));
    }

    public void E0() {
        String str;
        if (DepositWithdrawHelper.y(this.f45667k)) {
            ChainInfo H0 = H0();
            boolean t11 = DepositWithdrawHelper.t(H0);
            String str2 = this.f45659c;
            if (H0 == null) {
                str = null;
            } else {
                str = H0.getChain();
            }
            B0(t11, str2, str).subscribe(q6.d.c((u6.g) getUI(), new j7(this)));
        }
    }

    public String F0() {
        String i11 = DepositWithdrawHelper.i(H0());
        return TextUtils.isEmpty(i11) ? e1.a(y0()) : i11;
    }

    public String G0() {
        String j11 = DepositWithdrawHelper.j(H0());
        return j11 == null ? "" : j11;
    }

    public ChainInfo H0() {
        return DepositWithdrawHelper.h(this.f45667k);
    }

    public boolean I0() {
        return DepositWithdrawHelper.s(this.f45668l);
    }

    public Observable<List<ChainInfo>> b1() {
        return k.C().r(this.f45659c, false, AppLanguageHelper.getInstance().getCurLanguageHeader(), "1").compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public final void c1() {
        boolean t11 = DepositWithdrawHelper.t(this.f45668l);
        String str = this.f45659c;
        ChainInfo chainInfo = this.f45668l;
        this.f45658b = B0(t11, str, chainInfo == null ? null : chainInfo.getChain()).subscribe(new b());
    }

    public final void d1() {
        boolean t11 = DepositWithdrawHelper.t(this.f45668l);
        String str = this.f45659c;
        ChainInfo chainInfo = this.f45668l;
        this.f45658b = B0(t11, str, chainInfo == null ? null : chainInfo.getChain()).subscribe(new c());
    }

    public void e1() {
        MapParamsBuilder a11 = new MapParamsBuilder().a(FirebaseAnalytics.Param.CURRENCY, this.f45659c);
        String a12 = DepositWithdrawHelper.a(this.f45668l);
        if (a12 != null) {
            a11.a("chain", a12);
        }
        ((FinanceService) p.W(FinanceService.class)).oneOffAddressAssign(a11.b()).compose(p.a0()).observeOn(Schedulers.computation()).map(new b7(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.d((u6.g) getUI(), new m7(this), o7.f46039b, y6.f46191b));
    }

    /* renamed from: f1 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, g gVar) {
        super.onUIReady(baseCoreActivity, gVar);
        EventBus.d().p(this);
        Intent intent = getActivity().getIntent();
        m1(intent != null ? intent.getStringExtra("coin") : "btc");
    }

    public void g1() {
        MapParamsBuilder a11 = new MapParamsBuilder().a(FirebaseAnalytics.Param.CURRENCY, this.f45659c);
        String a12 = DepositWithdrawHelper.a(this.f45668l);
        if (a12 != null) {
            a11.a("chain", a12);
        }
        this.f45658b = ((FinanceService) p.W(FinanceService.class)).oneOffAddressQuery(a11.b()).compose(p.a0()).observeOn(Schedulers.io()).map(new f7(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d());
    }

    public void h1(String str) {
        this.f45659c = str;
    }

    public final boolean i1(ChainInfo chainInfo) {
        String chain;
        if (chainInfo == null || (chain = chainInfo.getChain()) == null || (!chain.toLowerCase().startsWith("hrc20") && !chain.toLowerCase().startsWith("ht2"))) {
            return false;
        }
        return !ConfigPreferences.c("user_config", "config_deposit_chain_hrc20_tips_no_more", false);
    }

    public void j1() {
        if (I0()) {
            k1(new x6(this));
        } else {
            l1();
        }
    }

    public final void k1(DialogUtils.b.f fVar) {
        if (this.f45666j == null) {
            this.f45666j = new DialogUtils.b.d(getActivity()).C0(String.format(getResources().getString(R.string.currency_deposit_iota_dialog_message), new Object[]{z0()})).c1(getString(R.string.currency_deposit_iota_dialog_title)).q0(false).F0(3).P0(getResources().getString(R.string.currency_deposit_iota_dialog_confirm_btn)).Q0(new g7(this, fVar)).j0();
        }
        if (!this.f45666j.th()) {
            this.f45666j.show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public final void l1() {
        if (!DepositWithdrawHelper.t(this.f45668l) || !DepositWithdrawHelper.u(this.f45668l)) {
            ((g) getUI()).Lf();
        } else {
            ((g) getUI()).u8();
        }
    }

    public void m1(String str) {
        if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase(this.f45659c)) {
            this.f45659c = str.toLowerCase(Locale.US);
            this.f45660d = k.C().z(this.f45659c);
            A0();
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        OneOffAddress oneOffAddress;
        super.onActivityResult(i11, i12, intent);
        if (i12 != -1) {
            return;
        }
        if (i11 == 1001) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("coin");
                if (stringExtra == null) {
                    stringExtra = "btc";
                }
                m1(stringExtra);
                getActivity().invalidateOptionsMenu();
            }
        } else if (i11 == 300 && intent != null && (oneOffAddress = (OneOffAddress) intent.getSerializableExtra("one_off_address")) != null) {
            this.f45663g = true;
            this.f45665i = oneOffAddress;
        }
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (!this.f45664h && I0()) {
            k1((DialogUtils.b.f) null);
        }
    }

    public void onStop() {
        u0();
        HBDialogFragment hBDialogFragment = this.f45666j;
        if (hBDialogFragment != null && hBDialogFragment.th()) {
            this.f45666j.sh();
        }
        super.onStop();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        rn.c.i().m(getActivity(), (kn.a) null);
        getActivity().finish();
    }

    public final void u0() {
        Subscription subscription = this.f45658b;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final Bitmap v0() {
        Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.address_unabled_image);
        int g11 = (PixelUtils.g() * 9) / 20;
        int g12 = (PixelUtils.g() * 9) / 20;
        Bitmap createBitmap = Bitmap.createBitmap(g11, g12, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, g11, g12);
        drawable.draw(canvas);
        return createBitmap;
    }

    public final void w0() {
        if (I0()) {
            g1();
        } else if (DepositWithdrawHelper.t(this.f45668l)) {
            d1();
        } else {
            c1();
        }
        if (i1(this.f45668l)) {
            ((g) getUI()).M6();
        } else {
            j1();
        }
    }

    public ChainInfo x0() {
        return this.f45668l;
    }

    public String y0() {
        return !TextUtils.isEmpty(this.f45659c) ? this.f45659c.toUpperCase(Locale.US) : "";
    }

    public String z0() {
        return !TextUtils.isEmpty(this.f45660d) ? this.f45660d : "";
    }
}
