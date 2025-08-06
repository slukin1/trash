package com.huobi.staring.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.hbg.lib.network.hbg.core.bean.ProRemindListData;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.lib.widgets.CommonStatusView;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.recycler.CommonRecyclerView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.staring.bean.ProRemindListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import cs.o;
import ds.j0;
import ds.k0;
import ds.l0;
import ds.m0;
import ds.n0;
import ds.o0;
import ds.p0;
import ds.q0;
import ds.r0;
import ds.s0;
import ds.t0;
import ds.u0;
import ds.v0;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;
import sn.t;
import u6.g;

public class ProRemindFragment extends AllRemindNewFragment {
    public CommonRecyclerView<ProRemindListItem> C;
    public CommonStatusView D;
    public RadioGroup E;
    public View F;
    public View G;
    public View H;
    public CommonCheckBox I;
    public TextView J;
    public CommonCheckBox K;
    public View L;
    public boolean M;
    public int N = 0;
    public o O = new c(zh(), new b());

    public class a extends CommonRecyclerView.Callback<ProRemindListItem> {
        public a() {
        }

        public void a(List<ProRemindListItem> list) {
        }

        public void d(List<ProRemindListItem> list) {
            boolean z11 = false;
            if (list.isEmpty()) {
                ProRemindFragment.this.D.n();
                ProRemindFragment.this.O.g();
                ProRemindFragment.this.ui(false);
            } else {
                ProRemindFragment.this.D.b();
            }
            if (ProRemindFragment.this.O.h().isEmpty()) {
                ProRemindFragment.this.I.setChecked(false);
                ProRemindFragment.this.J.setTextColor(ProRemindFragment.this.getResources().getColor(R.color.baseColorThreeLevelText));
            } else {
                ProRemindFragment.this.I.setChecked(true);
                ProRemindFragment.this.J.setTextColor(ProRemindFragment.this.getResources().getColor(R.color.baseColorMajorTheme100));
            }
            CommonCheckBox Vi = ProRemindFragment.this.K;
            if (!ProRemindFragment.this.C.i() && ProRemindFragment.this.O.h().size() == ProRemindFragment.this.C.getItemCount()) {
                z11 = true;
            }
            Vi.setChecked(z11);
            AllRemindNewActivity allRemindNewActivity = (AllRemindNewActivity) ProRemindFragment.this.getActivity();
            if (allRemindNewActivity != null) {
                allRemindNewActivity.qh(ProRemindFragment.this.Xh());
            }
        }
    }

    public class b implements o.a {
        public b() {
        }

        public void J0() {
            if (ProRemindFragment.this.C != null) {
                ProRemindFragment.this.C.j();
            }
        }
    }

    public class c extends o {
        public c(g gVar, o.a aVar) {
            super(gVar, aVar);
        }

        public void b(ProRemindListItem proRemindListItem, int i11, CommonSwitchButton commonSwitchButton) {
            ProRemindFragment.this.lj(proRemindListItem, i11, commonSwitchButton);
        }

        public void d(ProRemindListItem proRemindListItem) {
            if (!ProRemindFragment.this.O.a()) {
                StaringRemindActivity.pj(ProRemindFragment.this.getActivity(), proRemindListItem.symbol, (RemindContractType) null, (RemindBusinessType) null);
            }
        }
    }

    public class d extends BaseSubscriber<List<ProRemindListItem>> {
        public d() {
        }

        public void onAfter() {
            super.onAfter();
            ProRemindFragment.this.dismissProgressDialog();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            i6.d.g(th2);
            if (ProRemindFragment.this.C.i()) {
                ProRemindFragment.this.m0();
            }
        }

        @SuppressLint({"NotifyDataSetChanged"})
        public void onNext(List<ProRemindListItem> list) {
            ProRemindFragment.this.mj(list);
        }
    }

    public class e extends BaseSubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommonSwitchButton f81239b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ProRemindListItem f81240c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f81241d;

        public e(CommonSwitchButton commonSwitchButton, ProRemindListItem proRemindListItem, int i11) {
            this.f81239b = commonSwitchButton;
            this.f81240c = proRemindListItem;
            this.f81241d = i11;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            ProRemindFragment.this.C.j();
        }

        /* renamed from: c */
        public void onNext(String str) {
            super.onNext(str);
            ProRemindFragment.this.dismissProgressDialog();
            this.f81239b.setChecked(false);
            ProRemindFragment.this.C.m(this.f81240c);
            ProRemindFragment.this.C.getAdapter().notifyItemRemoved(this.f81241d);
            ProRemindFragment.this.C.postDelayed(new v0(this), 500);
            HuobiToastUtil.m(ProRemindFragment.this.getString(R.string.otc_pay_method_close_success_toast));
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f81239b.setChecked(true);
            ProRemindFragment.this.dismissProgressDialog();
        }

        public void printLog(Throwable th2) {
            super.printLog(th2);
        }
    }

    public ProRemindFragment() {
        this.f81227v = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aj(List list, boolean z11, Throwable th2) {
        List<ProRemindListItem> dataList;
        if (z11 && (dataList = this.C.getDataList()) != null) {
            ArrayList arrayList = null;
            for (ProRemindListItem next : dataList) {
                if (next != null && list.contains(next.symbol)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                }
            }
            if (arrayList != null) {
                dataList.removeAll(arrayList);
                this.C.j();
            }
        }
        dismissProgressDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bj(int i11, CommonStatusView.b bVar) {
        oi(i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void cj(RadioGroup radioGroup, int i11) {
        switch (i11) {
            case R.id.rbPriceRemind:
                if (this.N != 1) {
                    ui(false);
                    Wh().j();
                    this.N = 1;
                    this.F.setVisibility(8);
                    this.G.setVisibility(0);
                    break;
                } else {
                    SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i11);
                    return;
                }
            case R.id.rbStare:
                if (this.N != 0) {
                    ui(false);
                    Wh().j();
                    this.N = 0;
                    this.G.setVisibility(8);
                    this.F.setVisibility(0);
                    break;
                } else {
                    SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i11);
                    return;
                }
        }
        SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List dj(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                ProRemindListData proRemindListData = (ProRemindListData) list.get(i11);
                ProRemindListItem proRemindListItem = new ProRemindListItem();
                proRemindListItem.symbol = proRemindListData.symbol;
                proRemindListItem.baseCurrency = proRemindListData.baseCurrency;
                proRemindListItem.quoteCurrency = proRemindListData.quoteCurrency;
                proRemindListItem.status = proRemindListData.status;
                proRemindListItem.callback = this.O;
                arrayList.add(proRemindListItem);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ej(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        Zi();
    }

    public static /* synthetic */ void gj(CommonSwitchButton commonSwitchButton, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        commonSwitchButton.setChecked(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void hj(ProRemindListItem proRemindListItem, int i11, CommonSwitchButton commonSwitchButton, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        jj(proRemindListItem, i11, commonSwitchButton);
    }

    private void ji() {
        if (this.K.isChecked()) {
            this.O.g();
        } else {
            for (ProRemindListItem proRemindListItem : this.C.getDataList()) {
                this.O.f(proRemindListItem.symbol);
            }
        }
        CommonCheckBox commonCheckBox = this.K;
        commonCheckBox.setChecked(!commonCheckBox.isChecked());
        this.C.j();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        ji();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        ji();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        li();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        li();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void li() {
        if (!this.O.h().isEmpty()) {
            kj();
        }
    }

    public void Ah() {
        super.Ah();
        this.K.setOnClickListener(new j0(this));
        this.L.setOnClickListener(new o0(this));
        this.I.setOnClickListener(new m0(this));
        this.J.setOnClickListener(new n0(this));
    }

    public boolean Ph() {
        if (this.N == 1) {
            return super.Ph();
        }
        return this.M;
    }

    public void Th(boolean z11) {
        super.Th(z11);
        if (!z11) {
            ij();
        }
    }

    public CommonRecyclerView Wh() {
        if (this.N == 1) {
            return super.Wh();
        }
        return this.C;
    }

    public final void Zi() {
        String str;
        showProgressDialog();
        List<String> h11 = this.O.h();
        this.O.g();
        if (h11 != null) {
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < h11.size(); i11++) {
                sb2.append(h11.get(i11) + Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            str = sb2.toString();
        } else {
            str = "";
        }
        t.o(str, new l0(this, h11));
    }

    public void afterInit() {
        super.afterInit();
        this.D.setRelatedView(this.C);
        ij();
    }

    public boolean bi() {
        if (this.N == 1) {
            return super.bi();
        }
        CommonRecyclerView<ProRemindListItem> commonRecyclerView = this.C;
        if (commonRecyclerView == null || commonRecyclerView.i()) {
            return true;
        }
        return false;
    }

    public final void ij() {
        showProgressDialog();
        v7.b.a().getAllOpenStare().b().compose(RxJavaHelper.t((g) null)).map(new k0(this)).subscribe(new d());
    }

    public void initViews() {
        super.initViews();
        this.C = (CommonRecyclerView) this.f67460i.b(R.id.id_pro_recyclerView);
        this.D = (CommonStatusView) this.f67460i.b(R.id.id_pro_commonStatusView);
        this.E = (RadioGroup) this.f67460i.b(R.id.rgCheck);
        this.G = this.f67460i.b(R.id.layPriceRecomind);
        this.F = this.f67460i.b(R.id.layStareList);
        this.C.setCallback(new a());
        this.D.setCallback(new q0(this));
        this.E.setOnCheckedChangeListener(new p0(this));
        this.H = this.f67460i.b(R.id.id_pro_remind_bottom_layout);
        this.I = (CommonCheckBox) this.f67460i.b(R.id.id_pro_remind_bottom_delete_iv);
        this.J = (TextView) this.f67460i.b(R.id.id_pro_remind_bottom_delete_tv);
        this.K = (CommonCheckBox) this.f67460i.b(R.id.id_pro_remind_bottom_checkbox);
        this.L = this.f67460i.b(R.id.id_pro_remind_bottom_tv);
    }

    public final void jj(ProRemindListItem proRemindListItem, int i11, CommonSwitchButton commonSwitchButton) {
        showProgressDialog();
        v7.b.a().setStareConfig(proRemindListItem.symbol, 0, 0).b().compose(RxJavaHelper.t((g) null)).subscribe(new e(commonSwitchButton, proRemindListItem, i11));
    }

    public final void kj() {
        DialogUtils.b0(getActivity(), getString(R.string.n_turn_off_marking_reminder), getString(R.string.n_close_will_no_signal), "", getString(R.string.n_cancel), getString(R.string.n_confirm), u0.f53971a, new s0(this));
    }

    public final void lj(ProRemindListItem proRemindListItem, int i11, CommonSwitchButton commonSwitchButton) {
        DialogUtils.b0(getActivity(), getString(R.string.n_turn_off_marking_reminder), getString(R.string.n_close_will_no_signal), "", getString(R.string.n_cancel), getString(R.string.n_confirm), new r0(commonSwitchButton), new t0(this, proRemindListItem, i11, commonSwitchButton));
    }

    public final void m0() {
        this.D.p();
    }

    public final void mj(List<ProRemindListItem> list) {
        if (list == null || list.isEmpty()) {
            this.C.d();
            this.D.n();
            return;
        }
        this.C.setData(list);
        this.D.b();
    }

    public void oi(int i11) {
        if (this.N == 1) {
            super.oi(i11);
        } else if (i11 == -3 || i11 == -2) {
            this.D.b();
            ij();
        } else if (i11 == -1) {
            RemindSearchListActivity.gg(getActivity());
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_pro_remind, viewGroup, false);
    }

    public boolean ui(boolean z11) {
        if (this.N == 1) {
            return super.ui(z11);
        }
        if (this.M == z11) {
            return false;
        }
        this.M = z11;
        ViewUtil.m(this.H, z11);
        this.O.i(this.M);
        if (!z11) {
            this.O.g();
        }
        return true;
    }
}
