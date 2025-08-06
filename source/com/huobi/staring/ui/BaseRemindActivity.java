package com.huobi.staring.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.EmptyMVPActivity;
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
import com.huobi.login.bean.JumpTarget;
import com.huobi.staring.helper.StaringRemindHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import cs.h;
import cs.n;
import d7.a1;
import ds.i;
import ds.k;
import ds.l;
import ds.m;
import ds.o;
import ds.p;
import ds.q;
import ds.r;
import ds.s;
import ds.t;
import ds.u;
import ds.v;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.functions.Action0;
import rx.functions.Action1;
import u6.g;
import us.j;

public abstract class BaseRemindActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public View f81196b;

    /* renamed from: c  reason: collision with root package name */
    public CommonCheckBox f81197c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f81198d;

    /* renamed from: e  reason: collision with root package name */
    public CommonCheckBox f81199e;

    /* renamed from: f  reason: collision with root package name */
    public View f81200f;

    /* renamed from: g  reason: collision with root package name */
    public CommonRecyclerView<bs.a> f81201g;

    /* renamed from: h  reason: collision with root package name */
    public CommonStatusView f81202h;

    /* renamed from: i  reason: collision with root package name */
    public View f81203i;

    /* renamed from: j  reason: collision with root package name */
    public View f81204j;

    /* renamed from: k  reason: collision with root package name */
    public View f81205k;

    /* renamed from: l  reason: collision with root package name */
    public View f81206l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f81207m;

    /* renamed from: n  reason: collision with root package name */
    public RemindContractType f81208n;

    /* renamed from: o  reason: collision with root package name */
    public RemindBusinessType f81209o;

    /* renamed from: p  reason: collision with root package name */
    public HBDialogFragment f81210p;

    /* renamed from: q  reason: collision with root package name */
    public h f81211q = new b(getUI(), new a());

    public class a implements h.d {
        public a() {
        }

        public void J0() {
            CommonRecyclerView<bs.a> commonRecyclerView = BaseRemindActivity.this.f81201g;
            if (commonRecyclerView != null) {
                commonRecyclerView.j();
            }
        }

        public void a(bs.a aVar) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            BaseRemindActivity.this.Th(arrayList);
            BaseRemindActivity.this.f81201g.m(aVar);
            BaseRemindActivity.this.f81201g.j();
        }

        public void b(bs.a aVar) {
        }
    }

    public class b extends h {
        public b(g gVar, h.d dVar) {
            super(gVar, dVar);
        }

        public int e(RemindContractType remindContractType, RemindBusinessType remindBusinessType, String str) {
            return BaseRemindActivity.this.zh(remindContractType, remindBusinessType, str);
        }

        public boolean f() {
            return BaseRemindActivity.this.f81208n != null;
        }

        public String g(RemindContractType remindContractType, RemindBusinessType remindBusinessType, String str) {
            return BaseRemindActivity.this.Ah(remindContractType, remindBusinessType, str);
        }

        public void h(bs.a aVar, View view, View view2) {
            super.h(aVar, view, view2);
            BaseRemindActivity.this.Xh(false);
        }

        public void i(bs.a aVar) {
            super.i(aVar);
        }

        public void j(bs.a aVar) {
            super.j(aVar);
            BaseRemindActivity.this.Xh(false);
        }

        public String k(RemindContractType remindContractType, RemindBusinessType remindBusinessType, String str, String str2) {
            return BaseRemindActivity.this.yh(remindContractType, remindBusinessType, str, str2);
        }
    }

    public class c extends CommonRecyclerView.Callback<bs.a> {
        public c() {
        }

        public void a(List<bs.a> list) {
            BaseRemindActivity.this.Ph(list);
        }

        public void d(List<bs.a> list) {
            BaseRemindActivity baseRemindActivity = BaseRemindActivity.this;
            boolean z11 = true;
            ViewUtil.m(baseRemindActivity.f81203i, !baseRemindActivity.f81207m && !baseRemindActivity.f81201g.i());
            if (list.isEmpty()) {
                BaseRemindActivity.this.f81202h.n();
                BaseRemindActivity.this.f81211q.v();
            } else {
                BaseRemindActivity.this.f81202h.b();
            }
            if (BaseRemindActivity.this.f81211q.w().isEmpty()) {
                BaseRemindActivity.this.f81197c.setChecked(false);
                BaseRemindActivity.this.f81198d.setTextColor(BaseRemindActivity.this.getResources().getColor(R.color.baseColorThreeLevelText));
            } else {
                BaseRemindActivity.this.f81197c.setChecked(true);
                BaseRemindActivity.this.f81198d.setTextColor(BaseRemindActivity.this.getResources().getColor(R.color.baseColorMajorTheme100));
            }
            CommonCheckBox wh2 = BaseRemindActivity.this.f81199e;
            if (BaseRemindActivity.this.f81201g.i() || BaseRemindActivity.this.f81211q.w().size() != BaseRemindActivity.this.f81201g.getItemCount()) {
                z11 = false;
            }
            wh2.setChecked(z11);
            BaseRemindActivity.this.Sh(list.isEmpty());
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
            BaseRemindActivity.this.dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            if (BaseRemindActivity.this.f81201g.i()) {
                BaseRemindActivity.this.f81202h.o();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (!"1011".equalsIgnoreCase(aPIStatusErrorException.getErrCode())) {
                super.onFailed(aPIStatusErrorException);
            }
            if (BaseRemindActivity.this.f81201g.i()) {
                BaseRemindActivity.this.f81202h.o();
            }
        }

        public void onNext(T t11) {
            super.onNext(t11);
            a(t11);
            BaseRemindActivity.this.f81201g.l();
        }

        public void onStart() {
            super.onStart();
            BaseRemindActivity.this.showProgressDialog(true);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Dh(View view) {
        Qh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Eh(View view) {
        Qh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Fh(int i11, CommonStatusView.b bVar) {
        Uh(i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Gh(View view) {
        Rh();
        ai(true);
        this.f81201g.j();
        Xh(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Hh(View view) {
        ai(false);
        this.f81201g.j();
        Xh(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ih(Object obj) {
        if (this.f81201g != null) {
            HuobiToastUtil.s(R.string.staring_remind_delete_success);
            List<Long> w11 = this.f81211q.w();
            this.f81211q.v();
            List<bs.a> dataList = this.f81201g.getDataList();
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
                    this.f81201g.j();
                    Th(arrayList);
                }
            }
        }
    }

    public static /* synthetic */ void Jh(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void Kh(Throwable th2) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Lh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        Vh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Nh(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        so.b.d(fragmentActivity);
        hBDialogFragment.dismiss();
        finish();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        Oh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        Oh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public String Ah(RemindContractType remindContractType, RemindBusinessType remindBusinessType, String str) {
        if (remindContractType == null) {
            return a1.v().W(str);
        }
        if (remindBusinessType == RemindBusinessType.CONTRACT) {
            ContractCurrencyInfo b11 = ContractCurrencyUtils.b(str);
            if (b11 != null) {
                return ej.g.l(this, b11.getSymbol(), b11.getContractCode(), b11.getContractType());
            }
            return "--";
        } else if (remindBusinessType == RemindBusinessType.SWAP) {
            SwapCurrencyInfo c11 = SwapCurrencyInfoController.k().c(str);
            if (c11 != null) {
                return j.l(this, c11.getSymbol());
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
                return a7.e.v(this, o11.getSymbol(), o11.getQuoteCurrency(), o11.getContractCode(), o11.getContractType());
            }
            return "--";
        }
    }

    public void Bh() {
        try {
            HBDialogFragment hBDialogFragment = this.f81210p;
            if (hBDialogFragment != null && hBDialogFragment.th()) {
                this.f81210p.dismiss();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public boolean Ch() {
        return this.f81208n != null;
    }

    public final void Oh() {
        if (this.f81199e.isChecked()) {
            this.f81211q.v();
        } else {
            for (bs.a h11 : this.f81201g.getDataList()) {
                this.f81211q.u(h11.h());
            }
        }
        CommonCheckBox commonCheckBox = this.f81199e;
        commonCheckBox.setChecked(!commonCheckBox.isChecked());
        this.f81201g.j();
    }

    public abstract void Ph(List<bs.a> list);

    public final void Qh() {
        if (!this.f81211q.w().isEmpty()) {
            Yh();
        }
    }

    public void Rh() {
    }

    public void Sh(boolean z11) {
    }

    public void Th(List<bs.a> list) {
    }

    public void Uh(int i11) {
        if (i11 == -3 || i11 == -2) {
            this.f81202h.b();
            xh();
        }
    }

    public final void Vh() {
        d dVar = new d(getUI(), new ds.j(this), new k(this), l.f53942b, m.f53946b, new i(this));
        if (this.f81208n != null) {
            n.u(this.f81211q.w(), getUI(), dVar);
        } else {
            StaringRemindHelper.m(this.f81211q.w(), getUI(), dVar);
        }
    }

    public void Wh(boolean z11) {
        ViewUtil.m(this.f81196b, z11);
    }

    public void Xh(boolean z11) {
    }

    public void Yh() {
        String string = getString(R.string.allow_access_dialog_title);
        Locale locale = Locale.US;
        String string2 = getString(R.string.staring_remind_delete_confirm_tips2);
        DialogUtils.b0(this, string, String.format(locale, string2, new Object[]{"" + this.f81211q.w().size()}), "", getString(R.string.staring_remind_no_delete_now), getString(R.string.global_string_confirm), ad.b.f3517a, new u(this));
    }

    public void Zh(FragmentActivity fragmentActivity) {
        try {
            if (!p0.m.d(this).a()) {
                if (this.f81210p == null) {
                    this.f81210p = new DialogUtils.b.d(fragmentActivity).c1(fragmentActivity.getString(R.string.allow_access_dialog_title)).C0(fragmentActivity.getString(R.string.staring_remind_need_open_notification_permission)).s0(fragmentActivity.getString(R.string.setting_sign_out)).P0(fragmentActivity.getString(R.string.staring_remind_to_open)).N0(new v(this)).Q0(new ds.h(this, fragmentActivity)).j0();
                }
                if (!this.f81210p.th()) {
                    this.f81210p.show(fragmentActivity.getSupportFragmentManager(), "");
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void addEvent() {
        super.addEvent();
        this.viewFinder.b(R.id.id_back_btn).setOnClickListener(new q(this));
        this.f81199e.setOnClickListener(new s(this));
        this.f81200f.setOnClickListener(new ds.n(this));
        this.f81197c.setOnClickListener(new ds.g(this));
        this.f81198d.setOnClickListener(new o(this));
        this.f81201g.setCallback(new c());
        this.f81202h.setCallback(new t(this));
        this.f81203i.setOnClickListener(new r(this));
        this.f81204j.setOnClickListener(new p(this));
    }

    public void afterInit() {
        super.afterInit();
        this.f81202h.setRelatedView(this.f81201g);
        EventBus.d().p(this);
    }

    public void ai(boolean z11) {
        if (this.f81211q.x()) {
            this.f81211q.F();
            return;
        }
        this.f81207m = z11;
        ViewUtil.m(this.f81203i, !z11 && !this.f81201g.i());
        ViewUtil.m(this.f81204j, this.f81207m);
        ViewUtil.m(this.f81206l, true ^ this.f81207m);
        Wh(this.f81207m);
        this.f81211q.H(this.f81207m);
        if (!z11) {
            this.f81211q.v();
        }
        this.f81205k.setPadding(this.f81207m ? getResources().getDimensionPixelOffset(R.dimen.dimen_25) : 0, 0, 0, 0);
    }

    public void initView() {
        super.initView();
        this.f81201g = (CommonRecyclerView) this.viewFinder.b(R.id.id_reminder_recyclerView);
        this.f81202h = (CommonStatusView) this.viewFinder.b(R.id.id_reminder_commonStatusView);
        this.f81203i = this.viewFinder.b(R.id.id_remind_edit_list_btn);
        this.f81204j = this.viewFinder.b(R.id.id_remind_edit_finish_btn);
        this.f81196b = this.viewFinder.b(R.id.id_all_remind_bottom_layout);
        this.f81197c = (CommonCheckBox) this.viewFinder.b(R.id.id_all_remind_bottom_delete_iv);
        this.f81198d = (TextView) this.viewFinder.b(R.id.id_all_remind_bottom_delete_tv);
        this.f81199e = (CommonCheckBox) this.viewFinder.b(R.id.id_all_remind_bottom_checkbox);
        this.f81200f = this.viewFinder.b(R.id.id_all_remind_bottom_tv);
        this.f81205k = this.viewFinder.b(R.id.id_remind_rule_title_tv);
        this.f81206l = this.viewFinder.b(R.id.id_remind_title_operate_tv);
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    public void onPause() {
        super.onPause();
        Bh();
    }

    public void onResume() {
        super.onResume();
        xh();
        Zh(this);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        rn.c.i().m(this, new JumpTarget((Intent) null, (Intent) null));
        finish();
    }

    public abstract void xh();

    public String yh(RemindContractType remindContractType, RemindBusinessType remindBusinessType, String str, String str2) {
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
        i6.m.h0(str3);
        String string = getResources().getString(R.string.balance_total_cny);
        return String.format(string, new Object[]{" " + LegalCurrencyConfigUtil.w() + " " + str3});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        r3 = com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController.l().m(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int zh(com.hbg.lib.network.contract.core.util.RemindContractType r2, com.hbg.lib.network.contract.core.util.RemindBusinessType r3, java.lang.String r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.staring.ui.BaseRemindActivity.zh(com.hbg.lib.network.contract.core.util.RemindContractType, com.hbg.lib.network.contract.core.util.RemindBusinessType, java.lang.String):int");
    }
}
