package com.huobi.linearswap.ordertutorial.presenter;

import android.text.TextUtils;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.controller.LinearSwapAllowLevelController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import i6.m;
import java.math.BigDecimal;
import java.util.List;
import u6.g;
import z6.l;

public class OrderTutorialPresenter extends ActivityPresenter<b> implements an.a {

    /* renamed from: b  reason: collision with root package name */
    public FutureContractInfo f74969b;

    /* renamed from: c  reason: collision with root package name */
    public FutureContractInfo f74970c;

    /* renamed from: d  reason: collision with root package name */
    public LinearSwapAccountInfo f74971d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f74972e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f74973f;

    /* renamed from: g  reason: collision with root package name */
    public String f74974g;

    /* renamed from: h  reason: collision with root package name */
    public String f74975h;

    /* renamed from: i  reason: collision with root package name */
    public String f74976i;

    /* renamed from: j  reason: collision with root package name */
    public double f74977j;

    /* renamed from: k  reason: collision with root package name */
    public double f74978k;

    /* renamed from: l  reason: collision with root package name */
    public double f74979l;

    /* renamed from: m  reason: collision with root package name */
    public final int f74980m = 1;

    public class a extends EasySubscriber<List<String>> {
        public a() {
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            ((b) OrderTutorialPresenter.this.getUI()).S4(2);
        }
    }

    public interface b extends g {
        void S4(int i11);
    }

    public double A() {
        return this.f74979l;
    }

    public void C(String str) {
        this.f74974g = str;
    }

    public String D() {
        return this.f74975h;
    }

    public double E() {
        return this.f74978k;
    }

    public void F(double d11) {
        this.f74979l = d11;
    }

    public FutureContractInfo H() {
        return this.f74969b;
    }

    public void J(String str) {
        this.f74976i = str;
    }

    public void L() {
        LinearSwapAllowLevelController.c(false, this.f74969b.getContractCode(), 1).compose(RxJavaHelper.t((g) getUI())).retry(3).subscribe(new a());
    }

    public void N() {
        this.f74973f = true;
    }

    public FutureContractInfo Q() {
        return this.f74970c;
    }

    /* renamed from: R */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        l.c().d(TradeType.LINEAR_SWAP, false);
    }

    public void S() {
        this.f74974g = null;
        this.f74975h = null;
        this.f74976i = null;
        this.f74977j = 0.0d;
        this.f74978k = 0.0d;
        this.f74979l = 0.0d;
    }

    public void f(FutureContractInfo futureContractInfo) {
        this.f74969b = futureContractInfo;
    }

    public String h() {
        return this.f74974g;
    }

    public void k(boolean z11) {
        this.f74972e = z11;
    }

    public double l() {
        return this.f74977j;
    }

    public boolean m() {
        return this.f74972e;
    }

    public String n() {
        return this.f74976i;
    }

    public LinearSwapAccountInfo o() {
        return this.f74971d;
    }

    public void q(FutureContractInfo futureContractInfo) {
        this.f74970c = futureContractInfo;
    }

    public void s(double d11) {
        this.f74978k = d11;
    }

    public void t(LinearSwapAccountInfo linearSwapAccountInfo) {
        this.f74971d = linearSwapAccountInfo;
        if (linearSwapAccountInfo != null && !TextUtils.isEmpty(linearSwapAccountInfo.getLeverRate()) && m.a(linearSwapAccountInfo.getLeverRate()).compareTo(BigDecimal.ZERO) != 0) {
            this.f74974g = linearSwapAccountInfo.getLeverRate();
        }
    }

    public void w(String str) {
        this.f74975h = str;
    }

    public void y(double d11) {
        this.f74977j = d11;
    }
}
