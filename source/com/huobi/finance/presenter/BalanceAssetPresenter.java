package com.huobi.finance.presenter;

import ad.o;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.widget.EditText;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.network.rx.SilentSubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.ProfitUserInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$string;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.bean.C2CLendBalanceDataTotal;
import com.huobi.finance.bean.C2CMarginBalanceDataTotal;
import com.huobi.finance.bean.ContractDataTotal;
import com.huobi.finance.bean.LegalDataTotal;
import com.huobi.finance.bean.LinearSwapDataTotal;
import com.huobi.finance.bean.MarginBalanceDataTotal;
import com.huobi.finance.bean.MineDataTotal;
import com.huobi.finance.bean.MiningDataTotal;
import com.huobi.finance.bean.OptionDataTotal;
import com.huobi.finance.bean.OtcOptionDataTotal;
import com.huobi.finance.bean.SavingsDataTotal;
import com.huobi.finance.bean.SuperMarginDataTotal;
import com.huobi.finance.bean.SwapDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.finance.ui.x2;
import com.huobi.finance.utils.AssetAnimHelper;
import com.huobi.view.chart.data.PieEntry;
import i6.i;
import i6.k;
import i6.m;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.FuncN;
import vk.v;

public class BalanceAssetPresenter extends BaseFragmentPresenter<f> implements x2.a, PieEntry.PieChartHandleCallback {
    public boolean A;
    public boolean B;
    public boolean C;
    public Map<Integer, Boolean> D = new HashMap();
    public FuncN<Boolean> E = new s1(this);
    public boolean F = true;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<List<s9.a>> f45467c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<List<s9.a>> f45468d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<v9.a> f45469e;

    /* renamed from: f  reason: collision with root package name */
    public String f45470f;

    /* renamed from: g  reason: collision with root package name */
    public String f45471g;

    /* renamed from: h  reason: collision with root package name */
    public int f45472h = -1;

    /* renamed from: i  reason: collision with root package name */
    public g f45473i;

    /* renamed from: j  reason: collision with root package name */
    public SparseArray<Subscription> f45474j = new SparseArray<>();

    /* renamed from: k  reason: collision with root package name */
    public Subscription f45475k;

    /* renamed from: l  reason: collision with root package name */
    public List<s9.a> f45476l;

    /* renamed from: m  reason: collision with root package name */
    public List<s9.a> f45477m;

    /* renamed from: n  reason: collision with root package name */
    public v9.a f45478n;

    /* renamed from: o  reason: collision with root package name */
    public int f45479o = 300;

    /* renamed from: p  reason: collision with root package name */
    public String f45480p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f45481q = true;

    /* renamed from: r  reason: collision with root package name */
    public boolean f45482r = true;

    /* renamed from: s  reason: collision with root package name */
    public SparseIntArray f45483s = new SparseIntArray();

    /* renamed from: t  reason: collision with root package name */
    public Map<Integer, v> f45484t = new HashMap();

    /* renamed from: u  reason: collision with root package name */
    public boolean f45485u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f45486v;

    /* renamed from: w  reason: collision with root package name */
    public String f45487w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f45488x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f45489y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f45490z;

    public class a extends EasySubscriber<Integer> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f45491b;

        public a(int i11) {
            this.f45491b = i11;
        }

        /* renamed from: a */
        public void onNext(Integer num) {
            super.onNext(num);
            ((f) BalanceAssetPresenter.this.getUI()).ra(this.f45491b);
        }
    }

    public class b extends EasySubscriber<BaseAssetTotal> {

        /* renamed from: b  reason: collision with root package name */
        public boolean f45493b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f45494c;

        public b(int i11) {
            this.f45494c = i11;
        }

        /* renamed from: a */
        public void onNext(BaseAssetTotal baseAssetTotal) {
            BaseAssetTotal N1;
            super.onNext(baseAssetTotal);
            if (!this.f45493b && (N1 = BalanceAssetPresenter.this.N1()) != null) {
                ((f) BalanceAssetPresenter.this.getUI()).Qc(N1);
            }
            BalanceAssetPresenter.this.B2(this.f45494c, baseAssetTotal);
        }

        public void onError2(Throwable th2) {
            BalanceAssetPresenter.this.B2(this.f45494c, (BaseAssetTotal) null);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            BalanceAssetPresenter.this.B2(this.f45494c, (BaseAssetTotal) null);
        }

        public void onStart() {
            super.onStart();
            BalanceAssetPresenter balanceAssetPresenter = BalanceAssetPresenter.this;
            balanceAssetPresenter.S3(balanceAssetPresenter.R1(this.f45494c));
            this.f45493b = BalanceAssetPresenter.this.N1() != null;
        }
    }

    public class c extends EasySubscriber<Boolean> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            ((f) BalanceAssetPresenter.this.getUI()).Qc(BalanceAssetPresenter.this.N1());
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }

        public void onStart() {
            super.onStart();
            BalanceAssetPresenter balanceAssetPresenter = BalanceAssetPresenter.this;
            if (balanceAssetPresenter.L1(balanceAssetPresenter.f45472h) == null) {
                BalanceAssetPresenter balanceAssetPresenter2 = BalanceAssetPresenter.this;
                balanceAssetPresenter2.S3(balanceAssetPresenter2.R1(balanceAssetPresenter2.f45472h));
            }
        }
    }

    public class d extends q6.d<Object> {
        public d(u6.g gVar) {
            super(gVar);
        }

        public void onError2(Throwable th2) {
            i6.d.j("BalanceWhitelist", "onError2 " + th2.getMessage());
            BalanceAssetPresenter.this.v1();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            i6.d.j("BalanceWhitelist", "onFailed 1");
            BalanceAssetPresenter.this.v1();
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            i6.d.j("BalanceWhitelist", "onNext 1");
            BalanceAssetPresenter.this.v1();
        }
    }

    public class e implements Action1<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f45498b;

        public e(int i11) {
            this.f45498b = i11;
        }

        /* renamed from: a */
        public void call(Boolean bool) {
            if (bool.booleanValue()) {
                BalanceAssetPresenter.this.R3(this.f45498b);
            }
        }
    }

    public interface f extends u6.g {
        void B6(int i11);

        void Da();

        void Db(int i11);

        void De();

        void L4(int i11);

        void L8();

        boolean O7();

        void Qc(BaseAssetTotal baseAssetTotal);

        void Vf();

        void X4(EditText editText);

        void Y8(v9.a aVar, int i11);

        void Z7(boolean z11);

        void clear();

        int df(int i11);

        void ie();

        void kf(int i11);

        void m8();

        boolean o4();

        void onPieItemClick(int i11, PieEntry pieEntry);

        void p6(BaseAssetTotal baseAssetTotal, List<PieEntry> list, List<Integer> list2);

        void pa(int i11);

        void qd();

        void ra(int i11);

        void v6(String str);

        void vc(int i11, BaseAssetTotal baseAssetTotal);

        void yb(int i11);

        void yc();
    }

    public static class g implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<BalanceAssetPresenter> f45500b;

        public g(BalanceAssetPresenter balanceAssetPresenter) {
            this.f45500b = new WeakReference<>(balanceAssetPresenter);
        }

        public void run() {
            BalanceAssetPresenter balanceAssetPresenter = (BalanceAssetPresenter) this.f45500b.get();
            if (balanceAssetPresenter != null) {
                balanceAssetPresenter.H1();
            }
        }
    }

    public static /* synthetic */ BaseAssetTotal A2(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A3(ContractHeartBeat contractHeartBeat) {
        ((f) getUI()).pa(R1(this.f45472h));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean D2(Boolean bool) {
        this.f45489y = bool.booleanValue();
        i6.d.j("BalanceWhitelist", "Support C2C = " + this.f45489y);
        return bool;
    }

    public static /* synthetic */ Boolean E2(ProfitUserInfo profitUserInfo) {
        boolean isActive = profitUserInfo.isActive();
        i6.d.j("BalanceWhitelist", "isProfitActive = " + isActive);
        AssetModuleConfig.a().E0(Boolean.valueOf(isActive));
        return Boolean.valueOf(isActive);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean G2(Boolean bool) {
        this.f45486v = bool.booleanValue();
        return bool;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean I2(Boolean bool) {
        this.f45490z = bool.booleanValue();
        return bool;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean J2(Boolean bool) {
        this.A = bool.booleanValue();
        return bool;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean L2(Boolean bool) {
        this.B = bool.booleanValue();
        return bool;
    }

    public static /* synthetic */ Object N2(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean O2(Object[] objArr) {
        for (BaseAssetTotal baseAssetTotal : objArr) {
            if (baseAssetTotal instanceof BaseAssetTotal) {
                BaseAssetTotal baseAssetTotal2 = baseAssetTotal;
                if (T1(baseAssetTotal2)) {
                    k.e("onTurkeyRefused " + baseAssetTotal2.getClass().getName() + " has asset!");
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    public static /* synthetic */ BaseAssetTotal P2(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal Q2(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal R2(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal S2(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal T2(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal U2(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal V2(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal W2(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X2(int i11, Boolean bool) {
        if (bool.booleanValue()) {
            R3(i11);
        }
    }

    public static /* synthetic */ Boolean Y2(Boolean bool) {
        return bool;
    }

    public static /* synthetic */ BaseAssetTotal Z2(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal a3(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal b3(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal c3(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable d3(Boolean bool) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(J1(3).onErrorReturn(u0.f46128b));
        arrayList.add(J1(6).onErrorReturn(d1.f45845b));
        arrayList.add(J1(11).onErrorReturn(n1.f46009b));
        arrayList.add(J1(10).onErrorReturn(l1.f45965b));
        return Observable.zip((Iterable<? extends Observable<?>>) arrayList, this.E);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e3(int i11, Boolean bool) {
        if (bool.booleanValue()) {
            R3(i11);
        }
    }

    public static /* synthetic */ BaseAssetTotal f3(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal g3(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal h3(Throwable th2) {
        return null;
    }

    public static /* synthetic */ BaseAssetTotal i3(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean j3(BaseAssetTotal baseAssetTotal, BaseAssetTotal baseAssetTotal2, BaseAssetTotal baseAssetTotal3, BaseAssetTotal baseAssetTotal4) {
        return Boolean.valueOf(T1(baseAssetTotal) || T1(baseAssetTotal2) || T1(baseAssetTotal3) || T1(baseAssetTotal4));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean k3(Boolean bool) {
        boolean z11 = bool.booleanValue() != this.f45486v;
        this.f45486v = bool.booleanValue();
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean m3(Boolean bool) {
        boolean z11 = bool.booleanValue() != this.f45490z;
        this.f45490z = bool.booleanValue();
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n2(OtcOptionDataTotal otcOptionDataTotal) {
        if (otcOptionDataTotal != null) {
            otcOptionDataTotal.setTitle(al.b.a(getActivity(), 15));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o2(SwapDataTotal swapDataTotal) {
        if (swapDataTotal != null) {
            swapDataTotal.setTitle(al.b.a(getActivity(), 6));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean o3(Boolean bool) {
        boolean z11 = bool.booleanValue() != this.A;
        this.A = bool.booleanValue();
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p2(OptionDataTotal optionDataTotal) {
        if (optionDataTotal != null) {
            optionDataTotal.setTitle(al.b.a(getActivity(), 10));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q2(LinearSwapDataTotal linearSwapDataTotal) {
        if (linearSwapDataTotal != null) {
            linearSwapDataTotal.setTitle(al.b.a(getActivity(), 11));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r2(ContractDataTotal contractDataTotal) {
        if (contractDataTotal != null) {
            contractDataTotal.setTitle(al.b.a(getActivity(), 3));
        }
    }

    public static /* synthetic */ Boolean r3(ProfitUserInfo profitUserInfo) {
        boolean isActive = profitUserInfo.isActive();
        i6.d.j("BalanceWhitelist", "isProfitActive = " + isActive);
        Boolean F2 = AssetModuleConfig.a().F();
        if (F2 != null && Boolean.valueOf(isActive).equals(F2)) {
            return Boolean.FALSE;
        }
        AssetModuleConfig.a().E0(Boolean.valueOf(isActive));
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s2(SavingsDataTotal savingsDataTotal) {
        if (savingsDataTotal != null) {
            savingsDataTotal.setTitle(al.b.a(getActivity(), 9));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t2(MineDataTotal mineDataTotal) {
        if (mineDataTotal != null) {
            mineDataTotal.setTitle(al.b.a(getActivity(), 5));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u2(MarginBalanceDataTotal marginBalanceDataTotal) {
        if (marginBalanceDataTotal != null) {
            marginBalanceDataTotal.setTitle(al.b.a(getActivity(), 0));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean u3(Boolean bool) {
        boolean z11 = bool.booleanValue() != this.B;
        this.B = bool.booleanValue();
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v2(C2CMarginBalanceDataTotal c2CMarginBalanceDataTotal) {
        if (c2CMarginBalanceDataTotal != null) {
            c2CMarginBalanceDataTotal.setTitle(al.b.a(getActivity(), 7));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w2(C2CLendBalanceDataTotal c2CLendBalanceDataTotal) {
        if (c2CLendBalanceDataTotal != null) {
            c2CLendBalanceDataTotal.setTitle(al.b.a(getActivity(), 8));
        }
    }

    public static /* synthetic */ Boolean w3(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5) {
        return Boolean.valueOf(bool.booleanValue() || bool2.booleanValue() || bool3.booleanValue() || bool4.booleanValue() || bool5.booleanValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x2(SuperMarginDataTotal superMarginDataTotal) {
        if (superMarginDataTotal != null) {
            superMarginDataTotal.setTitle(al.b.a(getActivity(), 4));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x3(Boolean bool) {
        if (bool.booleanValue()) {
            v1();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y2(BalanceDataTotal balanceDataTotal) {
        if (balanceDataTotal != null) {
            balanceDataTotal.setTitle(al.b.a(getActivity(), 1));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y3(int i11, boolean z11) {
        SP.y(Q1(i11), z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z2(LegalDataTotal legalDataTotal) {
        if (legalDataTotal != null) {
            legalDataTotal.setTitle(al.b.a(getActivity(), 2));
        }
    }

    public static /* synthetic */ void z3(BaseCoreActivity baseCoreActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        BaseModuleConfig.a().N(baseCoreActivity);
    }

    public final v9.a A1(int i11) {
        return this.f45469e.get(i11);
    }

    public void B(EditText editText, String str) {
        ((f) getUI()).X4(editText);
        H3(str);
    }

    public final List<s9.a> B1(int i11) {
        return this.f45467c.get(i11);
    }

    public final void B3() {
        Observable<R> observable;
        this.C = gj.d.n().z();
        Observable<R> map = BaseModuleConfig.a().n0(true).map(new h0(this));
        Boolean bool = Boolean.FALSE;
        Observable<R> onErrorResumeNext = map.onErrorResumeNext((Observable<? extends R>) Observable.just(bool));
        if (AssetModuleConfig.a().F() == null) {
            observable = v7.b.a().getProfitUserInfo().b().map(j0.f45931b).onErrorResumeNext(Observable.just(bool));
        } else {
            observable = Observable.just(AssetModuleConfig.a().F());
            i6.d.j("BalanceWhitelist", "isProfitActive cache = " + AssetModuleConfig.a().F());
        }
        Observable.zip(onErrorResumeNext, observable, zq.e.e().d(true).onErrorReturn(i1.f45917b).map(new y(this)), zq.e.e().f(false).map(new c0(this)).onErrorReturn(w0.f46156b), o.e().map(new a0(this)).onErrorReturn(o0.f46031b), com.hbg.lib.core.util.v.e().g(true).onErrorReturn(p0.f46050b).map(new d0(this)), r1.f46084b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d((u6.g) getUI()));
    }

    public int C1() {
        return this.f45472h;
    }

    public List<PieEntry> C3(BaseAssetTotal baseAssetTotal) {
        BigDecimal bigDecimal;
        int fixedTitleRes;
        ArrayList arrayList = new ArrayList();
        List<? extends BaseAssetInfo> detailInfos = baseAssetTotal.getDetailInfos();
        ArrayList<BaseAssetInfo> arrayList2 = new ArrayList<>();
        if (detailInfos != null && !detailInfos.isEmpty()) {
            arrayList2.addAll(detailInfos);
        }
        if (!arrayList2.isEmpty()) {
            Collections.sort(arrayList2);
            BigDecimal bigDecimal2 = BigDecimal.ZERO;
            ArrayList arrayList3 = new ArrayList();
            for (BaseAssetInfo baseAssetInfo : arrayList2) {
                BigDecimal a11 = m.a(baseAssetInfo.getEstimateAmount());
                if (a11.compareTo(BigDecimal.ZERO) == 0) {
                    break;
                }
                arrayList3.add(baseAssetInfo);
                bigDecimal2 = bigDecimal2.add(a11);
            }
            int size = arrayList3.size();
            if (BigDecimal.ZERO.compareTo(bigDecimal2) != 0) {
                BigDecimal bigDecimal3 = BigDecimal.ZERO;
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    }
                    BaseAssetInfo baseAssetInfo2 = (BaseAssetInfo) arrayList3.get(i11);
                    if (arrayList.size() == 5) {
                        arrayList.add(new PieEntry(BigDecimal.ONE.subtract(bigDecimal3).floatValue(), this.f45471g, "", (PieEntry.PieChartHandleCallback) this));
                        break;
                    }
                    BigDecimal a12 = m.a(baseAssetInfo2.getEstimateAmount());
                    if (a12.compareTo(bigDecimal2) >= 0) {
                        bigDecimal = BigDecimal.ONE;
                    } else if (i11 == size - 1) {
                        bigDecimal = BigDecimal.ONE.subtract(bigDecimal3);
                    } else {
                        bigDecimal = a12.divide(bigDecimal2, 4, 1);
                    }
                    if (bigDecimal.compareTo(new BigDecimal("0.01")) < 0) {
                        arrayList.add(new PieEntry(BigDecimal.ONE.subtract(bigDecimal3).floatValue(), this.f45471g, "", (PieEntry.PieChartHandleCallback) this));
                        break;
                    }
                    String str = null;
                    if ((baseAssetInfo2 instanceof aj.d) && (fixedTitleRes = ((aj.d) baseAssetInfo2).getFixedTitleRes()) != 0) {
                        str = getResources().getString(fixedTitleRes);
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = baseAssetInfo2.getDisplayName();
                    }
                    if (StringUtils.p(str)) {
                        str = d7.k.C().z(baseAssetInfo2.getCurrency());
                    }
                    arrayList.add(new PieEntry(bigDecimal.floatValue(), str, "", (PieEntry.PieChartHandleCallback) this));
                    bigDecimal3 = bigDecimal3.add(bigDecimal);
                    i11++;
                }
            } else {
                arrayList.add(new PieEntry(BigDecimal.ZERO.floatValue(), "", "", (PieEntry.PieChartHandleCallback) this));
            }
        }
        return arrayList;
    }

    public int D1(int i11) {
        return this.f45483s.get(i11, 1);
    }

    public final void D3() {
        int i11 = R$string.turkey_refuse_contract_and_margin;
        if (!SP.l(Q1(i11), false)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(J1(3).onErrorReturn(h1.f45902b));
            arrayList.add(J1(6).onErrorReturn(j1.f45932b));
            arrayList.add(J1(11).onErrorReturn(s0.f46099b));
            arrayList.add(J1(10).onErrorReturn(g1.f45887b));
            arrayList.add(J1(0).onErrorReturn(c1.f45830b));
            arrayList.add(J1(4).onErrorReturn(f1.f45873b));
            arrayList.add(J1(7).onErrorReturn(y0.f46185b));
            arrayList.add(J1(8).onErrorReturn(x0.f46169b));
            Observable.zip((Iterable<? extends Observable<?>>) arrayList, this.E).first().subscribe(EasySubscriber.create(new w(this, i11)));
        }
    }

    public Map<Integer, Boolean> E1() {
        return this.D;
    }

    public final void E3() {
        int i11 = R$string.turkey_refuse_contract;
        if (!SP.l(Q1(i11), false)) {
            Observable.just(Boolean.valueOf(com.hbg.lib.core.util.o.h())).filter(l0.f45964b).flatMap(new b0(this)).compose(RxJavaHelper.t((u6.g) getUI())).first().subscribe(EasySubscriber.create(new v(this, i11)));
        }
    }

    public SparseIntArray F1() {
        return this.f45483s;
    }

    public final void F3() {
        int i11 = R$string.turkey_refuse_margin;
        if (!SP.l(Q1(i11), false)) {
            Observable.zip(J1(0).onErrorReturn(z0.f46198b), J1(4).onErrorReturn(q0.f46067b), J1(7).onErrorReturn(k1.f45951b), J1(8).onErrorReturn(b1.f45812b), new o1(this)).first().subscribe(EasySubscriber.create(new e(i11)));
        }
    }

    public final List<s9.a> G1(int i11) {
        return this.f45468d.get(i11);
    }

    public final void H1() {
        Observable<? extends BaseAssetTotal> J1;
        if (((f) getUI()).isCanBeSeen() && (J1 = J1(this.f45472h)) != null) {
            SparseArray<Subscription> sparseArray = this.f45474j;
            int i11 = this.f45472h;
            sparseArray.put(i11, J1.subscribe((Subscriber<? super Object>) K1(i11)));
        }
    }

    public void H3(String str) {
        boolean z11 = true;
        boolean z12 = TextUtils.isEmpty(this.f45480p) && !TextUtils.isEmpty(str);
        String str2 = this.f45480p;
        if (str2 == null || str2.equals(str)) {
            z11 = false;
        }
        if (z12 || z11) {
            this.f45480p = str;
            ((f) getUI()).v6(str);
            if (!((f) getUI()).o4()) {
                Q3();
            }
        }
    }

    public void I(BaseAssetTotal baseAssetTotal) {
        List<PieEntry> C3 = C3(baseAssetTotal);
        ArrayList arrayList = new ArrayList();
        int size = C3.size();
        if (size != 0) {
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    break;
                }
                PieEntry pieEntry = C3.get(i11);
                if (pieEntry != null) {
                    if (this.f45471g.equals(pieEntry.getTitle())) {
                        int df2 = ((f) getUI()).df(5);
                        pieEntry.setColor(Integer.valueOf(df2));
                        arrayList.add(Integer.valueOf(df2));
                        break;
                    }
                    int df3 = ((f) getUI()).df(i11);
                    pieEntry.setColor(Integer.valueOf(df3));
                    arrayList.add(Integer.valueOf(df3));
                }
                i11++;
            }
        }
        ((f) getUI()).p6(baseAssetTotal, C3, arrayList);
    }

    public void I1() {
        if (BaseModuleConfig.a().a()) {
            if (this.f45473i == null) {
                this.f45473i = new g(this);
            }
            i.b().g(this.f45473i, this.f45479o);
        }
    }

    public void I3() {
        this.f45481q = !this.f45481q;
        com.hbg.lib.core.util.b.c().h(this.f45481q, BaseModuleConfig.a().i0());
    }

    public final Observable<? extends BaseAssetTotal> J1(int i11) {
        switch (i11) {
            case 0:
                return AssetDataCacheManager.k0().n0().compose(RxJavaHelper.t((u6.g) getUI())).doOnNext(new x1(this));
            case 1:
                return AssetDataCacheManager.k0().S().compose(RxJavaHelper.t((u6.g) getUI())).doOnNext(new t0(this));
            case 2:
                return AssetDataCacheManager.k0().l0().compose(RxJavaHelper.t((u6.g) getUI())).doOnNext(new v1(this));
            case 3:
                T3(i11);
                return AssetDataCacheManager.k0().i0().compose(RxJavaHelper.t((u6.g) getUI())).doOnNext(new u1(this));
            case 4:
                return AssetDataCacheManager.k0().J0().compose(RxJavaHelper.t((u6.g) getUI())).doOnNext(new r(this));
            case 5:
                return AssetDataCacheManager.k0().o0().compose(RxJavaHelper.t((u6.g) getUI())).doOnNext(new n(this));
            case 6:
                T3(i11);
                return AssetDataCacheManager.k0().K0().compose(RxJavaHelper.t((u6.g) getUI())).doOnNext(new s(this));
            case 7:
                return AssetDataCacheManager.k0().U().compose(RxJavaHelper.t((u6.g) getUI())).doOnNext(new p1(this));
            case 8:
                return AssetDataCacheManager.k0().T().compose(RxJavaHelper.t((u6.g) getUI())).doOnNext(new e1(this));
            case 9:
                return AssetDataCacheManager.k0().I0().compose(RxJavaHelper.t((u6.g) getUI())).doOnNext(new q(this));
            case 10:
                T3(i11);
                return AssetDataCacheManager.k0().F0().compose(RxJavaHelper.t((u6.g) getUI())).doOnNext(new o(this));
            case 11:
                T3(i11);
                return AssetDataCacheManager.k0().m0().compose(RxJavaHelper.t((u6.g) getUI())).doOnNext(new w1(this));
            case 12:
                return AssetDataCacheManager.k0().p0().compose(RxJavaHelper.t((u6.g) getUI()));
            case 13:
                return AssetDataCacheManager.k0().j0().compose(RxJavaHelper.t((u6.g) getUI()));
            case 14:
                return AssetDataCacheManager.k0().E0().compose(RxJavaHelper.t((u6.g) getUI()));
            case 15:
                return AssetDataCacheManager.k0().G0().compose(RxJavaHelper.t((u6.g) getUI())).doOnNext(new p(this));
            default:
                return null;
        }
    }

    /* renamed from: J3 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, f fVar) {
        super.onUIReady(baseCoreActivity, fVar);
        EventBus.d().p(this);
        this.f45482r = ConfigPreferences.c("user_config", "CONFIG_HIDE_ZERO_BALANCE_" + AssetModuleConfig.a().getUid(), true);
        if (BaseModuleConfig.a().a()) {
            U1();
        }
    }

    public final EasySubscriber<BaseAssetTotal> K1(int i11) {
        return new b(i11);
    }

    public void K3() {
        if (((f) getUI()).O7()) {
            this.f45482r = !this.f45482r;
            ConfigPreferences.n("user_config", "CONFIG_HIDE_ZERO_BALANCE_" + AssetModuleConfig.a().getUid(), this.f45482r);
            ((f) getUI()).De();
            if (!((f) getUI()).o4()) {
                Q3();
                ((f) getUI()).Da();
            }
        }
    }

    public BaseAssetTotal L1(int i11) {
        return AssetDataCacheManager.k0().Q(i11);
    }

    public final void L3() {
        boolean b11 = com.hbg.lib.core.util.b.c().b(BaseModuleConfig.a().i0());
        if (b11 != this.f45481q) {
            this.f45481q = b11;
            ((f) getUI()).yc();
        }
    }

    public v M1(int i11) {
        Map<Integer, v> map = this.f45484t;
        if (map != null) {
            return map.get(Integer.valueOf(i11));
        }
        return null;
    }

    public void M3() {
        Observable<R> onErrorReturn = com.hbg.lib.core.util.v.e().g(true).map(new z(this)).onErrorReturn(n0.f46008b);
        Observable.zip(v7.b.a().getProfitUserInfo().b().map(k0.f45950b).onErrorReturn(r0.f46083b), zq.e.e().d(false).map(new f0(this)).onErrorReturn(v0.f46142b), zq.e.e().f(false).map(new e0(this)).onErrorReturn(m0.f45993b), o.e().map(new g0(this)).onErrorReturn(a1.f45797b), onErrorReturn, q1.f46068b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(SilentSubscriber.a(new t(this)));
        this.C = gj.d.n().z();
    }

    public BaseAssetTotal N1() {
        return AssetDataCacheManager.k0().P(F1());
    }

    public final void N3() {
        this.f45476l = B1(this.f45472h);
        this.f45477m = G1(this.f45472h);
        this.f45478n = A1(this.f45472h);
    }

    public void O1() {
        if (BaseModuleConfig.a().a()) {
            if (L1(this.f45472h) == null) {
                S3(R1(this.f45472h));
            }
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < this.f45483s.size(); i11++) {
                int valueAt = this.f45483s.valueAt(i11);
                Boolean bool = this.D.get(Integer.valueOf(valueAt));
                if (bool == null || bool.booleanValue()) {
                    arrayList.add(J1(valueAt).onErrorReturn(m1.f45994b).doOnNext(new u(this, valueAt)));
                }
            }
            Observable.zip((Iterable<? extends Observable<?>>) arrayList, t1.f46114b).compose(RxJavaHelper.t((u6.g) getUI())).takeLast(1).subscribe(P1());
        }
    }

    public void O3(int i11) {
        this.f45472h = i11;
    }

    public final EasySubscriber P1() {
        return new c();
    }

    public boolean P3() {
        BaseAssetTotal L1;
        if (BaseModuleConfig.a().c() || AssetModuleConfig.a().N0() || (L1 = L1(this.f45472h)) == null || 1 != this.f45472h || !m2() || !BaseAssetTotal.isZeroAsset(L1)) {
            return false;
        }
        return true;
    }

    public final String Q1(int i11) {
        return "sp_key_turkey_refused_dialog_not_show" + BaseModuleConfig.a().i0() + i11;
    }

    public void Q3() {
        y1();
        N3();
        List<s9.a> list = this.f45476l;
        if (list != null) {
            list.clear();
            boolean isEmpty = TextUtils.isEmpty(this.f45480p);
            if (this.f45472h != 3 || !AssetModuleConfig.a().d()) {
                for (s9.a next : this.f45477m) {
                    if (next instanceof BaseAssetInfo) {
                        if (!isEmpty) {
                            BaseAssetInfo baseAssetInfo = (BaseAssetInfo) next;
                            if (baseAssetInfo.getTitle() != null) {
                                String title = baseAssetInfo.getTitle();
                                Locale locale = Locale.US;
                                if (!title.toLowerCase(locale).contains(this.f45480p.toLowerCase(locale))) {
                                }
                            }
                        }
                        if (this.f45482r || !((BaseAssetInfo) next).isMinAmountAsset()) {
                            ((BaseAssetInfo) next).setShow(this.f45481q);
                            this.f45476l.add(next);
                        }
                    } else if (next instanceof BaseAssetTotal) {
                        BaseAssetTotal baseAssetTotal = (BaseAssetTotal) next;
                        baseAssetTotal.setShow(this.f45481q);
                        baseAssetTotal.setShowCallback(this);
                        this.f45476l.add(next);
                    }
                }
            }
            if (this.f45476l.size() <= 1) {
                ((f) getUI()).Db(R1(this.f45472h));
            } else {
                ((f) getUI()).L4(R1(this.f45472h));
            }
            v9.a aVar = this.f45478n;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }
    }

    public int R1(int i11) {
        SparseIntArray sparseIntArray = this.f45483s;
        int indexOfValue = sparseIntArray != null ? sparseIntArray.indexOfValue(i11) : -1;
        if (indexOfValue >= 0) {
            return this.f45483s.keyAt(indexOfValue);
        }
        return -1;
    }

    public final void R3(int i11) {
        i6.d.i("Turkey Refused! Show dialog.");
        BaseCoreActivity activity = getActivity();
        new DialogUtils.b.d(activity).c1(activity.getResources().getString(R$string.allow_access_dialog_title)).x0(true).y0(getString(R$string.do_not_show)).v0(new m(this, i11)).C0(activity.getResources().getString(i11)).R0(activity.getString(R$string.feedback_to_online_service)).T0(true).S0(Integer.valueOf(ContextCompat.getColor(activity, R$color.baseColorMajorTheme100))).P0(activity.getString(R$string.allow_access_dialog_positive_btn)).q0(false).U0(new x(activity)).Q0(ad.b.f3517a).j0().show(activity.getSupportFragmentManager(), "");
    }

    public final void S1() {
        boolean E2 = gj.d.n().E();
        boolean G = gj.d.n().G();
        if (!E2 && !G) {
            D3();
        } else if (!E2) {
            E3();
        } else if (!G) {
            F3();
        }
    }

    public final void S3(int i11) {
        y1();
        this.f45475k = Observable.just(1).delay(400, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new a(i11));
    }

    public final boolean T1(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal != null && m.a(baseAssetTotal.getNetAsset()).compareTo(BigDecimal.ZERO) > 0) {
            return true;
        }
        return false;
    }

    public final void T3(int i11) {
        if (i11 == this.f45472h) {
            AssetModuleConfig.a().X().timeout((long) com.sumsub.sns.presentation.screen.d.N, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t((u6.g) getUI())).onErrorResumeNext(Observable.just(null)).subscribe(EasySubscriber.create(new i0(this)));
        }
    }

    public void U1() {
        this.f45481q = com.hbg.lib.core.util.b.c().b(BaseModuleConfig.a().i0());
        this.f45471g = getResources().getString(R$string.balance_detail_chart_item_other);
        V1();
        this.f45487w = BaseModuleConfig.a().f();
        this.f45485u = !BaseModuleConfig.a().c();
        B3();
    }

    /* renamed from: U3 */
    public final void B2(int i11, BaseAssetTotal baseAssetTotal) {
        if (this.f45472h == i11) {
            SparseIntArray sparseIntArray = this.f45483s;
            if (sparseIntArray == null || sparseIntArray.indexOfValue(i11) >= 0) {
                if (i11 == 12) {
                    if (baseAssetTotal == null) {
                        baseAssetTotal = new MiningDataTotal();
                    }
                    ((f) getUI()).vc(i11, baseAssetTotal);
                }
                if (i11 == 13) {
                    ((f) getUI()).vc(i11, baseAssetTotal);
                }
                if (i11 == 14) {
                    ((f) getUI()).vc(i11, baseAssetTotal);
                }
                if (P3()) {
                    ((f) getUI()).qd();
                }
                if (baseAssetTotal != null) {
                    ArrayList arrayList = new ArrayList();
                    if (baseAssetTotal.getDetailInfos() != null) {
                        arrayList.addAll(baseAssetTotal.getDetailInfos());
                    }
                    List<s9.a> B1 = B1(this.f45472h);
                    List<s9.a> G1 = G1(this.f45472h);
                    if (B1 != null) {
                        B1.clear();
                        B1.add(baseAssetTotal);
                        B1.addAll(arrayList);
                        if (G1 != null) {
                            G1.clear();
                            G1.addAll(B1);
                        }
                    }
                    Q3();
                    return;
                }
                y1();
                N3();
                List<s9.a> list = this.f45476l;
                if (list == null || list.isEmpty()) {
                    ((f) getUI()).yb(R1(this.f45472h));
                }
            }
        }
    }

    public void V1() {
        this.f45479o = Build.VERSION.SDK_INT <= 26 ? 150 : 300;
    }

    public void W1() {
        int i11;
        int i12;
        this.f45483s.clear();
        this.f45484t.clear();
        this.f45483s.put(0, 1);
        this.f45484t.put(1, new v(0, -1));
        if (d2()) {
            this.f45483s.put(1, 3);
            this.f45484t.put(3, new v(1, 0));
            this.f45483s.put(2, 6);
            this.f45484t.put(6, new v(1, 1));
            this.f45483s.put(3, 11);
            this.f45484t.put(11, new v(1, 2));
            this.f45483s.put(4, 10);
            this.f45484t.put(10, new v(1, 3));
            i12 = 1;
            i11 = 4;
        } else {
            i12 = 0;
            i11 = 0;
        }
        if (!BaseModuleConfig.a().c()) {
            i12++;
            i11++;
            this.f45483s.put(i11, 2);
            this.f45484t.put(2, new v(i12, -1));
        }
        if (f2()) {
            i12++;
            i11++;
            this.f45483s.put(i11, 4);
            this.f45484t.put(4, new v(i12, 0));
        }
        if (f2()) {
            i11++;
            this.f45483s.put(i11, 0);
            this.f45484t.put(0, new v(i12, 1));
            if (!BaseModuleConfig.a().c() && this.f45489y) {
                int i13 = i11 + 1;
                this.f45483s.put(i13, 7);
                this.f45484t.put(7, new v(i12, 2));
                i11 = i13 + 1;
                this.f45483s.put(i11, 8);
                this.f45484t.put(8, new v(i12, 3));
            }
        }
        if (this.A) {
            i12++;
            i11++;
            this.f45483s.put(i11, 12);
            this.f45484t.put(12, new v(i12, -1));
        }
        if (this.B) {
            i12++;
            i11++;
            this.f45483s.put(i11, 13);
            this.f45484t.put(13, new v(i12, -1));
        }
        if (this.f45485u) {
            i12++;
            i11++;
            this.f45483s.put(i11, 5);
            this.f45484t.put(5, new v(i12, -1));
        }
        if (this.f45486v) {
            i12++;
            i11++;
            this.f45483s.put(i11, 15);
            this.f45484t.put(15, new v(i12, -1));
        }
        if (this.f45490z) {
            i12++;
            i11++;
            this.f45483s.put(i11, 9);
            this.f45484t.put(9, new v(i12, -1));
        }
        if (this.C) {
            this.f45483s.put(i11 + 1, 14);
            this.f45484t.put(14, new v(i12 + 1, -1));
        }
    }

    public final void X1() {
        Bundle arguments = Q().getArguments();
        if (arguments != null) {
            String string = arguments.getString("total_balance_type");
            if (string != null) {
                this.f45470f = string;
            }
            arguments.clear();
        }
        i6.d.e("initJumpParams-->", this.f45470f);
        if ("total_balance_type_margin".equals(this.f45470f)) {
            this.f45472h = 0;
        } else if ("total_balance_type_balance".equals(this.f45470f)) {
            this.f45472h = 1;
        } else if ("total_balance_type_legal".equals(this.f45470f)) {
            this.f45472h = 2;
        } else if ("total_balance_type_contract".equals(this.f45470f)) {
            this.f45472h = 3;
        } else if ("total_balance_type_swap".equals(this.f45470f)) {
            this.f45472h = 6;
        } else if ("total_balance_type_option".equals(this.f45470f)) {
            this.f45472h = 10;
        } else if ("total_balance_type_linear_swap".equals(this.f45470f)) {
            this.f45472h = 11;
        } else if ("total_balance_type_super_margin".equals(this.f45470f)) {
            this.f45472h = 4;
        } else if ("total_balance_type_grid".equals(this.f45470f)) {
            this.f45472h = 13;
        } else if ("total_balance_type_mine".equals(this.f45470f)) {
            this.f45472h = 5;
        } else if ("total_balance_type_mining".equals(this.f45470f)) {
            this.f45472h = 12;
        } else if ("total_balance_type_savings".equals(this.f45470f)) {
            this.f45472h = 9;
        } else if ("total_balance_type_on_chain".equals(this.f45470f)) {
            this.f45472h = 14;
        } else if ("total_balance_type_otc_option".equals(this.f45470f)) {
            this.f45472h = 15;
        } else if (this.f45483s.indexOfValue(this.f45472h) < 0) {
            this.f45472h = 1;
        }
        ((f) getUI()).kf(this.f45472h);
    }

    public void Y(boolean z11) {
        super.Y(z11);
        if (z11) {
            x1();
        } else {
            w1();
        }
    }

    public void Y1() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = arrayList13;
        ArrayList arrayList18 = new ArrayList();
        ArrayList arrayList19 = new ArrayList();
        ArrayList arrayList20 = arrayList11;
        ArrayList arrayList21 = new ArrayList();
        ArrayList arrayList22 = new ArrayList();
        ArrayList arrayList23 = arrayList9;
        ArrayList arrayList24 = new ArrayList();
        ArrayList arrayList25 = new ArrayList();
        ArrayList arrayList26 = arrayList7;
        ArrayList arrayList27 = new ArrayList();
        ArrayList arrayList28 = new ArrayList();
        ArrayList arrayList29 = arrayList5;
        ArrayList arrayList30 = new ArrayList();
        ArrayList arrayList31 = new ArrayList();
        ArrayList arrayList32 = arrayList3;
        SparseArray<List<s9.a>> sparseArray = new SparseArray<>();
        this.f45468d = sparseArray;
        sparseArray.put(1, arrayList2);
        this.f45468d.put(0, arrayList4);
        this.f45468d.put(7, arrayList6);
        this.f45468d.put(8, arrayList8);
        this.f45468d.put(4, arrayList10);
        this.f45468d.put(2, arrayList12);
        this.f45468d.put(3, arrayList14);
        this.f45468d.put(6, arrayList16);
        this.f45468d.put(10, arrayList19);
        this.f45468d.put(11, arrayList22);
        this.f45468d.put(5, arrayList25);
        this.f45468d.put(9, arrayList28);
        this.f45468d.put(15, arrayList31);
        SparseArray<List<s9.a>> sparseArray2 = new SparseArray<>();
        this.f45467c = sparseArray2;
        ArrayList arrayList33 = arrayList;
        sparseArray2.put(1, arrayList33);
        ArrayList arrayList34 = arrayList32;
        this.f45467c.put(0, arrayList34);
        ArrayList arrayList35 = arrayList29;
        this.f45467c.put(7, arrayList35);
        ArrayList arrayList36 = arrayList26;
        this.f45467c.put(8, arrayList36);
        ArrayList arrayList37 = arrayList23;
        this.f45467c.put(4, arrayList37);
        ArrayList arrayList38 = arrayList20;
        this.f45467c.put(2, arrayList38);
        ArrayList arrayList39 = arrayList17;
        this.f45467c.put(3, arrayList39);
        ArrayList arrayList40 = arrayList15;
        this.f45467c.put(6, arrayList40);
        ArrayList arrayList41 = arrayList18;
        this.f45467c.put(10, arrayList41);
        ArrayList arrayList42 = arrayList21;
        this.f45467c.put(11, arrayList42);
        ArrayList arrayList43 = arrayList24;
        this.f45467c.put(5, arrayList43);
        ArrayList arrayList44 = arrayList27;
        this.f45467c.put(9, arrayList44);
        ArrayList arrayList45 = arrayList30;
        this.f45467c.put(15, arrayList45);
        v9.a aVar = new v9.a(arrayList33);
        ArrayList arrayList46 = arrayList45;
        ((f) getUI()).Y8(aVar, R1(1));
        SparseArray<v9.a> sparseArray3 = new SparseArray<>();
        this.f45469e = sparseArray3;
        sparseArray3.put(1, aVar);
        if (d2()) {
            v9.a aVar2 = new v9.a(arrayList39);
            ((f) getUI()).Y8(aVar2, R1(3));
            this.f45469e.put(3, aVar2);
            v9.a aVar3 = new v9.a(arrayList40);
            ((f) getUI()).Y8(aVar3, R1(6));
            this.f45469e.put(6, aVar3);
            v9.a aVar4 = new v9.a(arrayList42);
            ((f) getUI()).Y8(aVar4, R1(11));
            this.f45469e.put(11, aVar4);
            v9.a aVar5 = new v9.a(arrayList41);
            ((f) getUI()).Y8(aVar5, R1(10));
            this.f45469e.put(10, aVar5);
        }
        if (!BaseModuleConfig.a().c()) {
            v9.a aVar6 = new v9.a(arrayList38);
            ((f) getUI()).Y8(aVar6, R1(2));
            this.f45469e.put(2, aVar6);
        }
        if (f2()) {
            v9.a aVar7 = new v9.a(arrayList37);
            ((f) getUI()).Y8(aVar7, R1(4));
            this.f45469e.put(4, aVar7);
        }
        if (f2()) {
            v9.a aVar8 = new v9.a(arrayList34);
            ((f) getUI()).Y8(aVar8, R1(0));
            this.f45469e.put(0, aVar8);
            v9.a aVar9 = new v9.a(arrayList35);
            ((f) getUI()).Y8(aVar9, R1(7));
            this.f45469e.put(7, aVar9);
            v9.a aVar10 = new v9.a(arrayList36);
            ((f) getUI()).Y8(aVar10, R1(8));
            this.f45469e.put(8, aVar10);
        }
        if (this.f45485u) {
            v9.a aVar11 = new v9.a(arrayList43);
            ((f) getUI()).Y8(aVar11, R1(5));
            this.f45469e.put(5, aVar11);
        }
        if (this.f45490z) {
            v9.a aVar12 = new v9.a(arrayList44);
            ((f) getUI()).Y8(aVar12, R1(9));
            this.f45469e.put(9, aVar12);
        }
        if (this.f45486v) {
            v9.a aVar13 = new v9.a(arrayList46);
            ((f) getUI()).Y8(aVar13, R1(15));
            this.f45469e.put(15, aVar13);
        }
    }

    public void Z(boolean z11) {
        super.Z(z11);
        if (z11) {
            if (!EventBus.d().i(this)) {
                EventBus.d().p(this);
            }
        } else if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        AssetModuleConfig.a().u(z11);
    }

    public boolean Z1(int i11) {
        return i11 == 3 || i11 == 6 || i11 == 11 || i11 == 10;
    }

    public boolean a2(int i11) {
        return i11 == 0 || i11 == 4 || i11 == 7 || i11 == 8;
    }

    public boolean b2() {
        return this.f45481q;
    }

    public boolean c2() {
        return this.f45482r;
    }

    public boolean d2() {
        return com.hbg.lib.core.util.o.h() && gj.d.n().E();
    }

    public boolean e2() {
        return this.B;
    }

    public boolean f2() {
        return gj.d.n().G();
    }

    public boolean g2() {
        return this.f45485u;
    }

    public boolean h2() {
        return this.A;
    }

    public boolean i2() {
        return this.C;
    }

    public boolean j2() {
        return this.f45486v;
    }

    public boolean k2() {
        return this.f45488x;
    }

    public boolean l2() {
        return this.f45490z;
    }

    public boolean m2() {
        String e11 = ConfigPreferences.e("user_config", "frist_enter_balance_by_day", "");
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (e11.equals(format)) {
            return false;
        }
        ConfigPreferences.m("user_config", "frist_enter_balance_by_day", format);
        return true;
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
    }

    public void onPieItemClick(int i11, PieEntry pieEntry) {
        ((f) getUI()).onPieItemClick(i11, pieEntry);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (getUI() != null && getActivity() != null && ((f) getUI()).isCanBeSeen()) {
            AssetModuleConfig.a().g(getActivity());
            ((f) getUI()).Z7(false);
            Bundle bundle = new Bundle();
            bundle.putString("total_balance_type", "total_balance_type_balance");
            Q().setArguments(bundle);
            ((f) getUI()).Vf();
        }
    }

    public final void v1() {
        boolean z11;
        Boolean F2 = AssetModuleConfig.a().F();
        if (F2 == null) {
            z11 = false;
        } else {
            z11 = F2.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(z11);
        this.f45488x = valueOf.booleanValue();
        i6.d.j("BalanceWhitelist", "afterGetWhitelistInfo mIsSupportProfitAndLoss = " + this.f45488x);
        W1();
        AssetAnimHelper.c(valueOf.booleanValue() ^ true);
        z1();
        ((f) getUI()).L8();
        ((f) getUI()).ie();
        ((f) getUI()).B6(this.f45472h);
        ((f) getUI()).m8();
        Y1();
        X1();
    }

    public void w1() {
        AssetDataCacheManager.k0().B1();
        y1();
        ((f) getUI()).Z7(false);
    }

    public final void x1() {
        if (!BaseModuleConfig.a().a()) {
            this.F = false;
            return;
        }
        S1();
        if (!this.F) {
            String str = this.f45487w;
            if (str == null || !str.equals(BaseModuleConfig.a().f())) {
                ((f) getUI()).clear();
                U1();
            } else {
                ((f) getUI()).m8();
                M3();
                L3();
                Bundle arguments = Q() == null ? null : Q().getArguments();
                if (arguments == null || arguments.isEmpty() || this.F) {
                    O1();
                } else {
                    X1();
                }
            }
        }
        this.F = false;
    }

    public final void y1() {
        Subscription subscription = this.f45475k;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void z1() {
        this.f45480p = null;
        this.f45482r = ConfigPreferences.c("user_config", "CONFIG_HIDE_ZERO_BALANCE_" + AssetModuleConfig.a().getUid(), true);
    }
}
