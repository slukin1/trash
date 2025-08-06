package uh;

import al.b;
import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.o;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$string;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.bean.C2CLendBalanceDataTotal;
import com.huobi.finance.bean.C2CMarginBalanceDataTotal;
import com.huobi.finance.bean.ContractDataTotal;
import com.huobi.finance.bean.LinearSwapDataTotal;
import com.huobi.finance.bean.OptionDataTotal;
import com.huobi.finance.bean.SuperMarginDataTotal;
import com.huobi.finance.bean.SwapDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import gj.d;
import i6.k;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.FuncN;
import u6.g;

public class o0 {

    /* renamed from: d  reason: collision with root package name */
    public static o0 f47929d = new o0();

    /* renamed from: a  reason: collision with root package name */
    public Context f47930a;

    /* renamed from: b  reason: collision with root package name */
    public g f47931b;

    /* renamed from: c  reason: collision with root package name */
    public final FuncN<Boolean> f47932c = new g0(this);

    public class a implements Action1<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f47933b;

        public a(int i11) {
            this.f47933b = i11;
        }

        /* renamed from: a */
        public void call(Boolean bool) {
            if (bool.booleanValue()) {
                o0.this.v0(this.f47933b);
            }
        }
    }

    public static o0 G() {
        return f47929d;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(C2CMarginBalanceDataTotal c2CMarginBalanceDataTotal) {
        if (c2CMarginBalanceDataTotal != null) {
            c2CMarginBalanceDataTotal.setTitle(b.a(this.f47930a, 7));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(C2CLendBalanceDataTotal c2CLendBalanceDataTotal) {
        if (c2CLendBalanceDataTotal != null) {
            c2CLendBalanceDataTotal.setTitle(b.a(this.f47930a, 8));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(SuperMarginDataTotal superMarginDataTotal) {
        if (superMarginDataTotal != null) {
            superMarginDataTotal.setTitle(b.a(this.f47930a, 4));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(SwapDataTotal swapDataTotal) {
        if (swapDataTotal != null) {
            swapDataTotal.setTitle(b.a(this.f47930a, 6));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P(OptionDataTotal optionDataTotal) {
        if (optionDataTotal != null) {
            optionDataTotal.setTitle(b.a(this.f47930a, 10));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q(LinearSwapDataTotal linearSwapDataTotal) {
        if (linearSwapDataTotal != null) {
            linearSwapDataTotal.setTitle(b.a(this.f47930a, 11));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R(ContractDataTotal contractDataTotal) {
        if (contractDataTotal != null) {
            contractDataTotal.setTitle(b.a(this.f47930a, 3));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean S(Object[] objArr) {
        for (BaseAssetTotal baseAssetTotal : objArr) {
            if (baseAssetTotal instanceof BaseAssetTotal) {
                BaseAssetTotal baseAssetTotal2 = baseAssetTotal;
                if (K(baseAssetTotal2)) {
                    k.e("onTurkeyRefused " + baseAssetTotal2.getClass().getName() + " has asset!");
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    public static /* synthetic */ BaseAssetTotal T(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal U(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal V(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal W(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal X(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal Y(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal Z(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal a0(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b0(int i11, Boolean bool) {
        if (bool.booleanValue()) {
            v0(i11);
        }
    }

    public static /* synthetic */ BaseAssetTotal c0(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable d0(Boolean bool) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(H(3).onErrorReturn(p.f60693b));
        arrayList.add(H(6).onErrorReturn(t.f60697b));
        arrayList.add(H(11).onErrorReturn(o.f60692b));
        arrayList.add(H(10).onErrorReturn(w.f60700b));
        return Observable.zip((Iterable<? extends Observable<?>>) arrayList, this.f47932c);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e0(int i11, Boolean bool) {
        if (bool.booleanValue()) {
            v0(i11);
        }
    }

    public static /* synthetic */ Boolean f0(Boolean bool) {
        return bool;
    }

    public static /* synthetic */ BaseAssetTotal g0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal h0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal i0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal j0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal k0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal l0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal m0(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean n0(BaseAssetTotal baseAssetTotal, BaseAssetTotal baseAssetTotal2, BaseAssetTotal baseAssetTotal3, BaseAssetTotal baseAssetTotal4) {
        return Boolean.valueOf(K(baseAssetTotal) || K(baseAssetTotal2) || K(baseAssetTotal3) || K(baseAssetTotal4));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o0(int i11, boolean z11) {
        SP.y(I(i11), z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p0(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        BaseModuleConfig.a().N(this.f47930a);
    }

    public final Observable<? extends BaseAssetTotal> H(int i11) {
        if (i11 == 0) {
            return AssetDataCacheManager.k0().n0().compose(RxJavaHelper.t(this.f47931b));
        }
        if (i11 == 3) {
            return AssetDataCacheManager.k0().i0().compose(RxJavaHelper.t(this.f47931b)).doOnNext(new i0(this));
        }
        if (i11 == 4) {
            return AssetDataCacheManager.k0().J0().compose(RxJavaHelper.t(this.f47931b)).doOnNext(new l0(this));
        }
        if (i11 == 6) {
            return AssetDataCacheManager.k0().K0().compose(RxJavaHelper.t(this.f47931b)).doOnNext(new m0(this));
        }
        if (i11 == 7) {
            return AssetDataCacheManager.k0().U().compose(RxJavaHelper.t(this.f47931b)).doOnNext(new h0(this));
        }
        if (i11 == 8) {
            return AssetDataCacheManager.k0().T().compose(RxJavaHelper.t(this.f47931b)).doOnNext(new f0(this));
        }
        if (i11 == 10) {
            return AssetDataCacheManager.k0().F0().compose(RxJavaHelper.t(this.f47931b)).doOnNext(new k0(this));
        }
        if (i11 != 11) {
            return null;
        }
        return AssetDataCacheManager.k0().m0().compose(RxJavaHelper.t(this.f47931b)).doOnNext(new j0(this));
    }

    public final String I(int i11) {
        return "sp_key_turkey_refused_dialog_not_show" + BaseModuleConfig.a().i0() + i11;
    }

    public void J() {
        boolean E = d.n().E();
        boolean G = d.n().G();
        if (!E && !G) {
            q0();
        } else if (!E) {
            r0();
        } else if (!G) {
            s0();
        }
    }

    public final boolean K(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal != null && m.a(baseAssetTotal.getNetAsset()).compareTo(BigDecimal.ZERO) > 0) {
            return true;
        }
        return false;
    }

    public final void q0() {
        int i11 = R$string.turkey_refuse_contract_and_margin;
        if (!SP.l(I(i11), false)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(H(3).onErrorReturn(c0.f60670b));
            arrayList.add(H(6).onErrorReturn(q.f60694b));
            arrayList.add(H(11).onErrorReturn(r.f60695b));
            arrayList.add(H(10).onErrorReturn(a0.f60668b));
            arrayList.add(H(0).onErrorReturn(v.f60699b));
            arrayList.add(H(4).onErrorReturn(b0.f60669b));
            arrayList.add(H(7).onErrorReturn(d0.f60671b));
            arrayList.add(H(8).onErrorReturn(s.f60696b));
            Observable.zip((Iterable<? extends Observable<?>>) arrayList, this.f47932c).first().subscribe(EasySubscriber.create(new k(this, i11)));
        }
    }

    public final void r0() {
        int i11 = R$string.turkey_refuse_contract;
        if (!SP.l(I(i11), false)) {
            Observable.just(Boolean.valueOf(o.h())).filter(m.f60687b).flatMap(new l(this)).compose(RxJavaHelper.t(this.f47931b)).first().subscribe(EasySubscriber.create(new n0(this, i11)));
        }
    }

    public final void s0() {
        int i11 = R$string.turkey_refuse_margin;
        if (!SP.l(I(i11), false)) {
            Observable.zip(H(0).onErrorReturn(y.f60702b), H(4).onErrorReturn(n.f60689b), H(7).onErrorReturn(x.f60701b), H(8).onErrorReturn(z.f60703b), new e0(this)).first().subscribe(EasySubscriber.create(new a(i11)));
        }
    }

    public void t0(Context context) {
        this.f47930a = context;
    }

    public void u0(g gVar) {
        this.f47931b = gVar;
    }

    public final void v0(int i11) {
        i6.d.i("Turkey Refused! Show dialog.");
        FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
        new DialogUtils.b.d(fragmentActivity).c1(this.f47930a.getResources().getString(R$string.allow_access_dialog_title)).x0(true).y0(this.f47930a.getResources().getString(R$string.do_not_show)).v0(new j(this, i11)).C0(this.f47930a.getResources().getString(i11)).R0(this.f47930a.getString(R$string.feedback_to_online_service)).T0(true).S0(Integer.valueOf(ContextCompat.getColor(this.f47930a, R$color.baseColorMajorTheme100))).P0(this.f47930a.getString(R$string.allow_access_dialog_positive_btn)).q0(false).U0(new u(this)).Q0(ad.b.f3517a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
    }
}
