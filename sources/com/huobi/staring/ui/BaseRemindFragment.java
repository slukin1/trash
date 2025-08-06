package com.huobi.staring.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.lib.widgets.CommonStatusView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.recycler.CommonRecyclerView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.staring.helper.StaringRemindHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import cs.h;
import cs.n;
import d7.a1;
import ds.a0;
import ds.b0;
import ds.c0;
import ds.d0;
import ds.e0;
import ds.f0;
import ds.g0;
import ds.h0;
import ds.i0;
import ds.w;
import ds.x;
import ds.y;
import ds.z;
import i6.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;
import rx.functions.Action0;
import rx.functions.Action1;
import u6.g;
import us.j;

public abstract class BaseRemindFragment extends EmptyMVPFragment {

    /* renamed from: l  reason: collision with root package name */
    public View f81217l;

    /* renamed from: m  reason: collision with root package name */
    public CommonCheckBox f81218m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f81219n;

    /* renamed from: o  reason: collision with root package name */
    public CommonCheckBox f81220o;

    /* renamed from: p  reason: collision with root package name */
    public View f81221p;

    /* renamed from: q  reason: collision with root package name */
    public CommonRecyclerView<bs.a> f81222q;

    /* renamed from: r  reason: collision with root package name */
    public CommonStatusView f81223r;

    /* renamed from: s  reason: collision with root package name */
    public View f81224s;

    /* renamed from: t  reason: collision with root package name */
    public View f81225t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f81226u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f81227v;

    /* renamed from: w  reason: collision with root package name */
    public HBDialogFragment f81228w;

    /* renamed from: x  reason: collision with root package name */
    public h f81229x;

    public class a implements h.d {
        public a() {
        }

        public void J0() {
            CommonRecyclerView<bs.a> commonRecyclerView = BaseRemindFragment.this.f81222q;
            if (commonRecyclerView != null) {
                commonRecyclerView.j();
            }
        }

        public void a(bs.a aVar) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            BaseRemindFragment.this.ni(arrayList);
            BaseRemindFragment.this.f81222q.m(aVar);
            BaseRemindFragment.this.f81222q.j();
        }

        public void b(bs.a aVar) {
            StaringRemindActivity.qj(BaseRemindFragment.this.getActivity(), aVar.i(), aVar.e(), aVar.b(), 1);
        }
    }

    public class b extends h {
        public b(g gVar, h.d dVar) {
            super(gVar, dVar);
        }

        public int e(RemindContractType remindContractType, RemindBusinessType remindBusinessType, String str) {
            return BaseRemindFragment.this.Vh(remindContractType, remindBusinessType, str);
        }

        public boolean f() {
            return BaseRemindFragment.this.ai();
        }

        public String g(RemindContractType remindContractType, RemindBusinessType remindBusinessType, String str) {
            return BaseRemindFragment.this.Yh(remindContractType, remindBusinessType, str);
        }

        public void h(bs.a aVar, View view, View view2) {
            super.h(aVar, view, view2);
            BaseRemindFragment.this.ri(false);
        }

        public void i(bs.a aVar) {
            super.i(aVar);
        }

        public void j(bs.a aVar) {
            super.j(aVar);
            BaseRemindFragment.this.ri(false);
        }

        public String k(RemindContractType remindContractType, RemindBusinessType remindBusinessType, String str, String str2) {
            return BaseRemindFragment.this.Uh(remindContractType, remindBusinessType, str, str2);
        }
    }

    public class c extends CommonRecyclerView.Callback<bs.a> {
        public c() {
        }

        public void a(List<bs.a> list) {
            BaseRemindFragment.this.ki(list);
        }

        public void d(List<bs.a> list) {
            if (list.isEmpty()) {
                BaseRemindFragment.this.f81223r.n();
                BaseRemindFragment.this.f81229x.v();
            } else {
                BaseRemindFragment.this.f81223r.b();
            }
            boolean z11 = false;
            if (BaseRemindFragment.this.f81229x.w().isEmpty()) {
                BaseRemindFragment.this.f81218m.setChecked(false);
                BaseRemindFragment.this.f81219n.setTextColor(BaseRemindFragment.this.getResources().getColor(R.color.baseColorThreeLevelText));
            } else {
                BaseRemindFragment.this.f81218m.setChecked(true);
                BaseRemindFragment.this.f81219n.setTextColor(BaseRemindFragment.this.getResources().getColor(R.color.baseColorMajorTheme100));
            }
            CommonCheckBox Sh = BaseRemindFragment.this.f81220o;
            if (!BaseRemindFragment.this.f81222q.i() && BaseRemindFragment.this.f81229x.w().size() == BaseRemindFragment.this.f81222q.getItemCount()) {
                z11 = true;
            }
            Sh.setChecked(z11);
            BaseRemindFragment.this.mi(list.isEmpty());
        }
    }

    public class d extends q6.d<Object> {
        public d(g gVar, Action0 action0, Action1 action1, Action1 action12, Action1 action13, Action0 action02) {
            super(gVar, action0, action1, action12, action13, action02);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (!"1011".equalsIgnoreCase(aPIStatusErrorException.getErrCode())) {
                super.onFailed(aPIStatusErrorException);
            }
        }
    }

    public abstract class e<T> extends EasySubscriber<T> {
        public e() {
        }

        public abstract void a(T t11);

        public void onAfter() {
            super.onAfter();
            BaseRemindFragment.this.dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            if (BaseRemindFragment.this.f81222q.i()) {
                BaseRemindFragment.this.f81223r.o();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (!"1011".equalsIgnoreCase(aPIStatusErrorException.getErrCode())) {
                super.onFailed(aPIStatusErrorException);
            }
            if (BaseRemindFragment.this.f81222q.i()) {
                BaseRemindFragment.this.f81223r.o();
            }
        }

        public void onNext(T t11) {
            super.onNext(t11);
            a(t11);
            BaseRemindFragment.this.f81222q.l();
        }

        public void onStart() {
            super.onStart();
            BaseRemindFragment.this.showProgressDialog(true);
        }
    }

    public BaseRemindFragment() {
        this.f81229x = new b(zh(), new a());
        this.f81227v = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ci(int i11, CommonStatusView.b bVar) {
        oi(i11);
    }

    public static /* synthetic */ void di(Throwable th2) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ei(Object obj) {
        if (this.f81222q != null) {
            HuobiToastUtil.s(R.string.staring_remind_delete_success);
            List<Long> w11 = this.f81229x.w();
            this.f81229x.v();
            List<bs.a> dataList = this.f81222q.getDataList();
            if (dataList != null) {
                ArrayList arrayList = null;
                for (bs.a next : dataList) {
                    if (next != null && w11.contains(Long.valueOf(next.h()))) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next);
                    }
                }
                if (arrayList != null) {
                    dataList.removeAll(arrayList);
                    this.f81222q.j();
                    ni(arrayList);
                }
            }
        }
    }

    public static /* synthetic */ void fi(APIStatusErrorException aPIStatusErrorException) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gi(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        pi();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void hi(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ii(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        so.b.d(fragmentActivity);
        hBDialogFragment.dismiss();
        getActivity().finish();
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

    public void Ah() {
        super.Ah();
        this.f81220o.setOnClickListener(new c0(this));
        this.f81221p.setOnClickListener(new w(this));
        this.f81218m.setOnClickListener(new b0(this));
        this.f81219n.setOnClickListener(new a0(this));
        this.f81222q.setCallback(new c());
        this.f81223r.setCallback(new d0(this));
    }

    public boolean Ph() {
        return this.f81226u;
    }

    public abstract void Th(boolean z11);

    public String Uh(RemindContractType remindContractType, RemindBusinessType remindBusinessType, String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return "--";
        }
        if (remindBusinessType != null) {
            str3 = LegalCurrencyConfigUtil.B(str);
        } else if (TextUtils.isEmpty(str2) || !a1.v().D(str2).equalsIgnoreCase("usdt")) {
            str3 = LegalCurrencyConfigUtil.A(str, str2, TradeType.PRO);
        } else {
            str3 = LegalCurrencyConfigUtil.B(str);
        }
        m.h0(str3);
        String string = getResources().getString(R.string.balance_total_cny);
        return String.format(string, new Object[]{" " + LegalCurrencyConfigUtil.w() + " " + str3});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        r3 = com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController.l().m(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int Vh(com.hbg.lib.network.contract.core.util.RemindContractType r2, com.hbg.lib.network.contract.core.util.RemindBusinessType r3, java.lang.String r4) {
        /*
            r1 = this;
            int r2 = com.hbg.lib.data.symbol.PrecisionUtil.x(r4)
            com.hbg.lib.network.contract.core.util.RemindBusinessType r0 = com.hbg.lib.network.contract.core.util.RemindBusinessType.CONTRACT
            if (r3 != r0) goto L_0x0017
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r3 = com.huobi.contract.helper.ContractCurrencyUtils.b(r4)
            if (r3 == 0) goto L_0x004a
            java.lang.String r2 = r3.getContractCode()
            int r2 = ej.f.p(r2)
            goto L_0x004a
        L_0x0017:
            com.hbg.lib.network.contract.core.util.RemindBusinessType r0 = com.hbg.lib.network.contract.core.util.RemindBusinessType.SWAP
            if (r3 != r0) goto L_0x002e
            com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController r3 = com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController.k()
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r3 = r3.c(r4)
            if (r3 == 0) goto L_0x004a
            java.lang.String r2 = r3.getSymbol()
            int r2 = us.i.o(r2)
            goto L_0x004a
        L_0x002e:
            com.hbg.lib.network.contract.core.util.RemindBusinessType r0 = com.hbg.lib.network.contract.core.util.RemindBusinessType.LINEAR_SWAP
            if (r3 != r0) goto L_0x004a
            com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController r3 = com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController.l()
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo r3 = r3.m(r4)
            if (r3 == 0) goto L_0x004a
            java.lang.String r2 = r3.getContractCode()
            java.lang.String r3 = r3.getContractShortType()
            java.lang.String r4 = ""
            int r2 = com.hbg.lib.data.future.util.FuturePrecisionUtil.y(r2, r3, r4)
        L_0x004a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.staring.ui.BaseRemindFragment.Vh(com.hbg.lib.network.contract.core.util.RemindContractType, com.hbg.lib.network.contract.core.util.RemindBusinessType, java.lang.String):int");
    }

    public CommonRecyclerView Wh() {
        return this.f81222q;
    }

    public int Xh() {
        return ai() ? 1 : 0;
    }

    public String Yh(RemindContractType remindContractType, RemindBusinessType remindBusinessType, String str) {
        if (remindContractType == null) {
            return a1.v().W(str);
        }
        if (remindBusinessType == RemindBusinessType.CONTRACT) {
            ContractCurrencyInfo b11 = ContractCurrencyUtils.b(str);
            if (b11 != null) {
                return ej.g.l(getContext(), b11.getSymbol(), b11.getContractCode(), b11.getContractType());
            }
            return "--";
        } else if (remindBusinessType == RemindBusinessType.SWAP) {
            SwapCurrencyInfo c11 = SwapCurrencyInfoController.k().c(str);
            if (c11 != null) {
                return j.l(getContext(), c11.getSymbol());
            }
            return "--";
        } else if (remindBusinessType != RemindBusinessType.LINEAR_SWAP) {
            return "--";
        } else {
            FutureContractInfo o11 = FutureContractInfoController.n().o(str);
            if (o11 == null) {
                o11 = FutureContractInfoController.n().m(str);
            }
            if (o11 != null) {
                return a7.e.v(getContext(), o11.getSymbol(), o11.getQuoteCurrency(), o11.getContractCode(), o11.getContractType());
            }
            return "--";
        }
    }

    public void Zh() {
        try {
            HBDialogFragment hBDialogFragment = this.f81228w;
            if (hBDialogFragment != null && hBDialogFragment.th()) {
                this.f81228w.dismiss();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void afterInit() {
        super.afterInit();
        this.f81223r.setRelatedView(this.f81222q);
    }

    public boolean ai() {
        return this.f81227v;
    }

    public boolean bi() {
        CommonRecyclerView<bs.a> commonRecyclerView = this.f81222q;
        if (commonRecyclerView == null) {
            return true;
        }
        return commonRecyclerView.i();
    }

    public void initViews() {
        super.initViews();
        this.f81222q = (CommonRecyclerView) this.f67460i.b(R.id.id_reminder_recyclerView);
        this.f81223r = (CommonStatusView) this.f67460i.b(R.id.id_reminder_commonStatusView);
        this.f81217l = this.f67460i.b(R.id.id_all_remind_bottom_layout);
        this.f81218m = (CommonCheckBox) this.f67460i.b(R.id.id_all_remind_bottom_delete_iv);
        this.f81219n = (TextView) this.f67460i.b(R.id.id_all_remind_bottom_delete_tv);
        this.f81220o = (CommonCheckBox) this.f67460i.b(R.id.id_all_remind_bottom_checkbox);
        this.f81221p = this.f67460i.b(R.id.id_all_remind_bottom_tv);
        this.f81224s = this.f67460i.b(R.id.id_remind_rule_title_tv);
        this.f81225t = this.f67460i.b(R.id.id_remind_title_operate_tv);
    }

    public final void ji() {
        if (this.f81220o.isChecked()) {
            this.f81229x.v();
        } else {
            for (bs.a h11 : this.f81222q.getDataList()) {
                this.f81229x.u(h11.h());
            }
        }
        CommonCheckBox commonCheckBox = this.f81220o;
        commonCheckBox.setChecked(!commonCheckBox.isChecked());
        this.f81222q.j();
    }

    public abstract void ki(List<bs.a> list);

    public final void li() {
        if (!this.f81229x.w().isEmpty()) {
            si();
        }
    }

    public void mi(boolean z11) {
    }

    public void ni(List<bs.a> list) {
    }

    public void oi(int i11) {
        if (i11 == -3 || i11 == -2) {
            this.f81223r.b();
            Th(false);
        }
    }

    public final void pi() {
        d dVar = new d(zh(), new i0(this), new x(this), y.f53978b, z.f53980b, new h0(this));
        if (ai()) {
            n.u(this.f81229x.w(), zh(), dVar);
        } else {
            StaringRemindHelper.m(this.f81229x.w(), zh(), dVar);
        }
    }

    public void qi(boolean z11) {
        ViewUtil.m(this.f81217l, z11);
    }

    public void ri(boolean z11) {
    }

    public void si() {
        FragmentActivity activity = getActivity();
        String string = getString(R.string.allow_access_dialog_title);
        Locale locale = Locale.US;
        String string2 = getString(R.string.staring_remind_delete_confirm_tips2);
        DialogUtils.b0(activity, string, String.format(locale, string2, new Object[]{"" + this.f81229x.w().size()}), "", getString(R.string.staring_remind_no_delete_now), getString(R.string.global_string_confirm), ad.b.f3517a, new f0(this));
    }

    public void ti(FragmentActivity fragmentActivity) {
        try {
            if (!p0.m.d(getActivity()).a()) {
                if (this.f81228w == null) {
                    this.f81228w = new DialogUtils.b.d(fragmentActivity).c1(fragmentActivity.getString(R.string.allow_access_dialog_title)).C0(fragmentActivity.getString(R.string.staring_remind_need_open_notification_permission)).s0(fragmentActivity.getString(R.string.setting_sign_out)).P0(fragmentActivity.getString(R.string.staring_remind_to_open)).N0(new e0(this)).Q0(new g0(this, fragmentActivity)).j0();
                }
                if (!this.f81228w.th()) {
                    this.f81228w.show(fragmentActivity.getSupportFragmentManager(), "");
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            Th(true);
            ti(getActivity());
            return;
        }
        Zh();
    }

    public boolean ui(boolean z11) {
        if (this.f81229x.x()) {
            this.f81229x.F();
            return false;
        } else if (this.f81226u == z11) {
            return false;
        } else {
            this.f81226u = z11;
            ViewUtil.m(this.f81225t, !z11);
            qi(this.f81226u);
            this.f81229x.H(this.f81226u);
            if (!z11) {
                this.f81229x.v();
            }
            this.f81224s.setPadding(this.f81226u ? getResources().getDimensionPixelOffset(R.dimen.dimen_25) : 0, 0, 0, 0);
            return true;
        }
    }

    public BaseRemindFragment(boolean z11) {
        this.f81229x = new b(zh(), new a());
        this.f81227v = z11;
    }
}
