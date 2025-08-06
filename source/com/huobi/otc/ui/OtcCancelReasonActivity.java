package com.huobi.otc.ui;

import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.p;
import com.hbg.lib.network.otc.core.bean.OtcCancelActionBean;
import com.hbg.lib.network.otc.core.bean.OtcCancelReasonBean;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lite.enums.OtcTradeMode;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.OtcCancelReasonDataType;
import com.huobi.otc.bean.OtcOrderDetailInfo;
import com.huobi.otc.dialog.CommitConsultCancelDialogFragment;
import com.huobi.otc.dialog.ConsultCancelDealDialogFragment;
import com.huobi.otc.persenter.OtcCancelReasonPresenter;
import com.huobi.otc.widget.EditChangeEmptyView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jp.l0;
import rx.Observable;
import rx.functions.Action1;

public class OtcCancelReasonActivity extends BaseActivity<OtcCancelReasonPresenter, OtcCancelReasonPresenter.h> implements OtcCancelReasonPresenter.h, CommitConsultCancelDialogFragment.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f79321b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f79322c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f79323d;

    /* renamed from: e  reason: collision with root package name */
    public EasyRecyclerView f79324e;

    /* renamed from: f  reason: collision with root package name */
    public OtcOrderDetailInfo f79325f;

    /* renamed from: g  reason: collision with root package name */
    public int f79326g;

    /* renamed from: h  reason: collision with root package name */
    public int f79327h;

    /* renamed from: i  reason: collision with root package name */
    public CommitConsultCancelDialogFragment f79328i;

    /* renamed from: j  reason: collision with root package name */
    public LoadingLayout f79329j;

    /* renamed from: k  reason: collision with root package name */
    public EditChangeEmptyView f79330k;

    public class a implements EditChangeEmptyView.a {
        public a() {
        }

        public void a() {
            OtcCancelReasonActivity.this.f79324e.smoothScrollToPosition(OtcCancelReasonActivity.this.f79324e.getAdapter().c().size() - 1);
        }
    }

    public class b implements Action1<Void> {
        public b() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            OtcCancelReasonActivity otcCancelReasonActivity = OtcCancelReasonActivity.this;
            l0.a(otcCancelReasonActivity, otcCancelReasonActivity.f79325f);
        }
    }

    public class c implements Action1<Void> {
        public c() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            if (!(OtcCancelReasonActivity.this.f79325f == null || OtcCancelReasonActivity.this.f79325f.getOtcOrder() == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("run_mode", String.valueOf(OtcCancelReasonActivity.this.f79325f.getOrder().getRunMode()));
                hashMap.put("roid", OtcCancelReasonActivity.this.f79325f.isTaker() ? "taker" : "maker");
                if (OtcCancelReasonActivity.this.f79325f.getOtcOrder().isFastBuy() || OtcCancelReasonActivity.this.f79325f.getOtcOrder().isThirdOrder()) {
                    uf.c.b().o("confirm_cancel", "otc.order.page.confirm_cancel", (HashMap) null);
                } else {
                    uf.c.b().s("confirm_cancel", "otc.order.page.confirm_cancel", (HashMap) null);
                }
            }
            if (((OtcCancelReasonPresenter) OtcCancelReasonActivity.this.getPresenter()).c0()) {
                OtcCancelReasonActivity.this.oh().show(OtcCancelReasonActivity.this.getSupportFragmentManager(), ConsultCancelDealDialogFragment.class.getName());
                OtcModuleConfig.a().m("6204", "1005400", (String) null, (Map<String, Object>) null);
            } else {
                ((OtcCancelReasonPresenter) OtcCancelReasonActivity.this.getPresenter()).X();
            }
            OtcCancelReasonActivity.this.vh();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ((OtcCancelReasonPresenter) OtcCancelReasonActivity.this.getPresenter()).Y(OtcCancelReasonActivity.this.f79325f.getOrder().getId(), OtcCancelReasonActivity.this.getResources().getString(R$string.n_otc_order_detail_ask_about_question));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OtcCancelReasonDataType f79335b;

        public e(OtcCancelReasonDataType otcCancelReasonDataType) {
            this.f79335b = otcCancelReasonDataType;
        }

        public void run() {
            OtcCancelReasonActivity.this.f79324e.smoothScrollToPosition(OtcCancelReasonActivity.this.f79324e.getAdapter().c().indexOf(this.f79335b));
        }
    }

    public void Dd(boolean z11) {
        this.f79322c.setEnabled(z11);
    }

    public void Od(String str) {
        HuobiToastUtil.m(str);
    }

    /* renamed from: Qg */
    public OtcCancelReasonPresenter createPresenter() {
        return new OtcCancelReasonPresenter(this.f79325f.getOrder().getId());
    }

    public String R0() {
        OtcOrderDetailInfo otcOrderDetailInfo = this.f79325f;
        return (otcOrderDetailInfo == null || otcOrderDetailInfo.getOrder() == null) ? "" : this.f79325f.getOrder().getId();
    }

    public void Tc(List<s9.a> list) {
        if (list == null || list.isEmpty()) {
            this.f79329j.k();
            return;
        }
        this.f79324e.setData(list);
        this.f79329j.g();
        wh();
    }

    public void Va(OtcCancelReasonDataType otcCancelReasonDataType, OtcCancelReasonBean otcCancelReasonBean) {
        uh(otcCancelReasonDataType, otcCancelReasonBean);
    }

    public void Xa(String str) {
        HuobiToastUtil.m(str);
    }

    public void Y1() {
        finish();
    }

    public void a0() {
        this.f79328i.dismiss();
        ((OtcCancelReasonPresenter) getPresenter()).W();
        OtcModuleConfig.a().b("6205", (Map<String, Object>) null);
    }

    public void addEvent() {
        Observable<Void> a11 = dw.a.a(this.f79321b);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new b());
        dw.a.a(this.f79322c).throttleFirst(300, timeUnit).subscribe(new c());
        this.f79329j.setOnRetryClickListener(new d());
    }

    public String d9() {
        return getResources().getString(R$string.n_otc_order_detail_cancel_reason, new Object[]{((OtcCancelReasonPresenter) getPresenter()).Z()});
    }

    public void ef(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(R$string.n_no_network);
        }
        HuobiToastUtil.i(str);
        this.f79329j.k();
    }

    public void finishActivity() {
        CommitConsultCancelDialogFragment commitConsultCancelDialogFragment = this.f79328i;
        if (commitConsultCancelDialogFragment != null && commitConsultCancelDialogFragment.isAdded()) {
            this.f79328i.dismiss();
        }
        finish();
    }

    public void g0() {
        this.f79328i.dismiss();
        ((OtcCancelReasonPresenter) getPresenter()).X();
    }

    public int getContentView() {
        return R$layout.activity_otc_select_reason;
    }

    public SpannableString i0() {
        return qh(getResources().getString(R$string.n_otc_order_detail_consult_reason_tip_one, new Object[]{"1"}), "1");
    }

    public void initView() {
        sh();
        th();
        this.f79321b = (ImageView) this.viewFinder.b(R$id.iv_message);
        this.f79330k = (EditChangeEmptyView) this.viewFinder.b(R$id.view);
        this.f79322c = (TextView) this.viewFinder.b(R$id.tv_cancel);
        EasyRecyclerView easyRecyclerView = (EasyRecyclerView) this.viewFinder.b(R$id.rv_select_reason);
        this.f79324e = easyRecyclerView;
        easyRecyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.f79323d = (TextView) this.viewFinder.b(R$id.tv_cancel_order_sub);
        this.f79329j = (LoadingLayout) this.viewFinder.b(R$id.ll_loading);
        this.f79323d.setText(getString(R$string.n_otc_order_detail_cancel_addup, new Object[]{String.valueOf(this.f79327h)}));
        this.f79330k.setOnSizeChangeListener(new a());
    }

    public void j5() {
        finish();
    }

    public SpannableString l7() {
        String valueOf = String.valueOf(this.f79326g);
        return qh(getResources().getString(R$string.n_otc_order_detail_consult_reason_tip_two, new Object[]{valueOf}), valueOf);
    }

    public void o2(int i11) {
        if (i11 > 0) {
            this.f79321b.setImageResource(R$drawable.otc_newchat);
        } else {
            this.f79321b.setImageResource(R$drawable.otc_chat);
        }
    }

    public final CommitConsultCancelDialogFragment oh() {
        if (this.f79328i == null) {
            this.f79328i = new CommitConsultCancelDialogFragment();
        }
        return this.f79328i;
    }

    public void onClick(OtcCancelReasonDataType otcCancelReasonDataType, OtcCancelReasonBean otcCancelReasonBean) {
        ((OtcCancelReasonPresenter) getPresenter()).g0(this.f79324e.getAdapter().c(), otcCancelReasonDataType, otcCancelReasonBean);
        if (otcCancelReasonBean == null) {
            OtcCancelReasonBean dataBean = otcCancelReasonDataType.getDataBean();
            if (dataBean.isOtherType() && dataBean.isChecked()) {
                xh(otcCancelReasonDataType);
            }
        }
    }

    public void onTextChange(String str) {
        ((OtcCancelReasonPresenter) getPresenter()).h0(str);
    }

    public final void ph(HashMap<String, Object> hashMap) {
        hashMap.put("order_taker_type", this.f79325f.getOrder().getAcceptStatus());
        int tradeMode = this.f79325f.getOrder().getTradeMode();
        if (tradeMode == OtcTradeMode.C2C_SIMPLE.getCode() || tradeMode == OtcTradeMode.C2C_BLOCK.getCode()) {
            hashMap.put("now_view_type", "optional_trade");
        } else if (tradeMode == OtcTradeMode.FAST.getCode()) {
            hashMap.put("now_view_type", "quick_trade");
        }
    }

    public final SpannableString qh(String str, String str2) {
        SpannableString spannableString = new SpannableString(str);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R$color.baseColorMajorTheme100));
        int indexOf = str.indexOf(str2);
        boolean h11 = p.h(this);
        int length = str2.length() + indexOf;
        if (h11) {
            length++;
        }
        spannableString.setSpan(foregroundColorSpan, indexOf, length, 34);
        return spannableString;
    }

    /* renamed from: rh */
    public OtcCancelReasonPresenter.h getUI() {
        return this;
    }

    public final void sh() {
        Intent intent = getIntent();
        this.f79325f = (OtcOrderDetailInfo) intent.getSerializableExtra("parma_order_info");
        this.f79326g = intent.getIntExtra("p_cancel_max_num", 0);
        this.f79327h = intent.getIntExtra("p_cancel_num", 0);
    }

    public void tb(OtcCancelReasonDataType otcCancelReasonDataType) {
        Va(otcCancelReasonDataType, (OtcCancelReasonBean) null);
    }

    public final void th() {
        setToolBar((Toolbar) this.viewFinder.b(R$id.toolbar), "", true);
    }

    public final void uh(OtcCancelReasonDataType otcCancelReasonDataType, OtcCancelReasonBean otcCancelReasonBean) {
        v9.a adapter = this.f79324e.getAdapter();
        adapter.notifyItemChanged(adapter.c().indexOf(otcCancelReasonDataType), otcCancelReasonDataType.getDataBean());
    }

    public final void vh() {
        if (this.f79325f != null && getPresenter() != null) {
            HashMap hashMap = new HashMap();
            ph(hashMap);
            hashMap.put("reason_id", ((OtcCancelReasonPresenter) getPresenter()).a0());
            uf.c.b().h("otc_trade_cancel_order_reason_confirm_cancel_click", hashMap);
        }
    }

    public final void wh() {
        if (this.f79325f != null) {
            HashMap hashMap = new HashMap();
            ph(hashMap);
            uf.c.b().h("otc_trade_cancel_order_reason_view", hashMap);
        }
    }

    public final void xh(OtcCancelReasonDataType otcCancelReasonDataType) {
        this.f79324e.postDelayed(new e(otcCancelReasonDataType), 100);
    }

    public void onClick(OtcCancelActionBean otcCancelActionBean) {
        if ("self".equalsIgnoreCase(otcCancelActionBean.getType()) && "chat".equalsIgnoreCase(otcCancelActionBean.getLink())) {
            l0.a(this, this.f79325f);
        } else if ("customerService".equalsIgnoreCase(otcCancelActionBean.getType())) {
            OtcModuleConfig.b().x(this, "Started chat with mandatory pre-chat form");
        }
    }
}
