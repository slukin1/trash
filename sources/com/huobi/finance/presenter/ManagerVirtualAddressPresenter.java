package com.huobi.finance.presenter;

import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.VirtualAddressInfo;
import com.huobi.finance.controller.VirtualAddressProvider;
import com.huobi.finance.viewhandler.VirtualAddressViewHander;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import rx.Observable;
import tq.p;
import u6.f;
import u6.g;

public class ManagerVirtualAddressPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<VirtualAddressInfo> f45592a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public v9.a<VirtualAddressInfo> f45593b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45594c;

    /* renamed from: d  reason: collision with root package name */
    public String f45595d;

    /* renamed from: e  reason: collision with root package name */
    public String f45596e;

    /* renamed from: f  reason: collision with root package name */
    public String f45597f;

    /* renamed from: g  reason: collision with root package name */
    public VirtualAddressViewHander.a f45598g = new p4(this);

    public class a extends EasySubscriber<List<VirtualAddressInfo>> {
        public a() {
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onError2(Throwable th2) {
            ((b) ManagerVirtualAddressPresenter.this.getUI()).f6().k();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((b) ManagerVirtualAddressPresenter.this.getUI()).f6().i();
        }

        public void onStart() {
            super.onStart();
            ((b) ManagerVirtualAddressPresenter.this.getUI()).f6().p();
        }

        public void onNext(List<VirtualAddressInfo> list) {
            super.onNext(list);
            ManagerVirtualAddressPresenter.this.f45592a.clear();
            ManagerVirtualAddressPresenter.this.f45592a.addAll(list);
            ManagerVirtualAddressPresenter.this.f45593b.notifyDataSetChanged();
            ((b) ManagerVirtualAddressPresenter.this.getUI()).ud(list.size() == 0);
        }
    }

    public interface b extends f {
        void Id(boolean z11);

        void b(v9.a aVar);

        void ud(boolean z11);

        void wc(String str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ VirtualAddressInfo b0(VirtualAddressInfo virtualAddressInfo) {
        virtualAddressInfo.setOnDeleteClickListener(this.f45598g);
        virtualAddressInfo.setIsSelect(this.f45594c);
        if (!TextUtils.isEmpty(this.f45596e) && virtualAddressInfo.getAddress().equals(this.f45596e)) {
            virtualAddressInfo.setChecked(true);
        }
        return virtualAddressInfo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable c0(StringStatusResponse stringStatusResponse) {
        return VirtualAddressProvider.f().e(this.f45595d, this.f45597f, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d0(VirtualAddressInfo virtualAddressInfo) {
        W(((FinanceService) p.W(FinanceService.class)).deleteWithdrawAddress(String.valueOf(virtualAddressInfo.getId()), MapParamsBuilder.c().b()).flatMap(new q4(this)));
    }

    public void W(Observable<ArrayList<VirtualAddressInfo>> observable) {
        observable.flatMap(s4.f46103b).map(new r4(this)).toList().compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
    }

    public String X() {
        return this.f45597f;
    }

    public String Y() {
        return this.f45595d.toUpperCase(Locale.US);
    }

    public String Z() {
        return this.f45595d;
    }

    /* renamed from: f0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f45594c = intent.getBooleanExtra("select_address", false);
            this.f45595d = intent.getStringExtra("coin_type");
            this.f45596e = intent.getStringExtra("coin_address");
            this.f45597f = intent.getStringExtra("chain");
        }
        ((b) getUI()).wc(Y());
        ((b) getUI()).Id(!this.f45594c);
        this.f45593b = new v9.a<>(this.f45592a);
        ((b) getUI()).b(this.f45593b);
    }

    public void g0() {
        W(VirtualAddressProvider.f().e(this.f45595d, this.f45597f, false));
    }

    public void onResume() {
        super.onResume();
        g0();
    }
}
