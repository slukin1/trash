package com.hbg.lite.record.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.hbg.lib.network.otc.enums.OrderStatus;
import com.hbg.lib.widgets.BaseOrderFilterDialogFragment;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.config.bean.LiteOtcTradeType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import jb.c;
import jb.d;
import jb.e;
import jb.f;
import jb.g;
import jb.h;
import jb.i;
import jb.j;
import jb.k;
import jb.l;

public class LiteOtcOrderFilterDialog extends BaseOrderFilterDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TextView f77385b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f77386c;

    /* renamed from: d  reason: collision with root package name */
    public CheckBox f77387d;

    /* renamed from: e  reason: collision with root package name */
    public CheckBox f77388e;

    /* renamed from: f  reason: collision with root package name */
    public CheckBox f77389f;

    /* renamed from: g  reason: collision with root package name */
    public CheckBox f77390g;

    /* renamed from: h  reason: collision with root package name */
    public CheckBox f77391h;

    /* renamed from: i  reason: collision with root package name */
    public CheckBox f77392i;

    /* renamed from: j  reason: collision with root package name */
    public CheckBox f77393j;

    /* renamed from: k  reason: collision with root package name */
    public CheckBox f77394k;

    /* renamed from: l  reason: collision with root package name */
    public LiteOtcTradeType f77395l = LiteOtcTradeType.NONE;

    /* renamed from: m  reason: collision with root package name */
    public String f77396m = TtmlNode.COMBINE_ALL;

    /* renamed from: n  reason: collision with root package name */
    public a f77397n;

    public interface a {
        void Ra(LiteOtcTradeType liteOtcTradeType, String str);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Dh(View view) {
        String str;
        String str2 = this.f77396m;
        OrderStatus orderStatus = OrderStatus.CANCEL;
        if (TextUtils.equals(str2, orderStatus.getKey())) {
            str = TtmlNode.COMBINE_ALL;
        } else {
            str = orderStatus.getKey();
        }
        this.f77396m = str;
        Jh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Eh(View view) {
        String str;
        String str2 = this.f77396m;
        OrderStatus orderStatus = OrderStatus.COMPLETED;
        if (TextUtils.equals(str2, orderStatus.getKey())) {
            str = TtmlNode.COMBINE_ALL;
        } else {
            str = orderStatus.getKey();
        }
        this.f77396m = str;
        Jh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fh(View view) {
        String str;
        String str2 = this.f77396m;
        OrderStatus orderStatus = OrderStatus.APPEAL;
        if (TextUtils.equals(str2, orderStatus.getKey())) {
            str = TtmlNode.COMBINE_ALL;
        } else {
            str = orderStatus.getKey();
        }
        this.f77396m = str;
        Jh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Gh(View view) {
        String str;
        String str2 = this.f77396m;
        OrderStatus orderStatus = OrderStatus.QUOTE_EXPIRED;
        if (TextUtils.equals(str2, orderStatus.getKey())) {
            str = TtmlNode.COMBINE_ALL;
        } else {
            str = orderStatus.getKey();
        }
        this.f77396m = str;
        Jh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        reset();
        Hh();
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        Hh();
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        LiteOtcTradeType liteOtcTradeType = this.f77395l;
        LiteOtcTradeType liteOtcTradeType2 = LiteOtcTradeType.BUY;
        if (liteOtcTradeType == liteOtcTradeType2) {
            liteOtcTradeType2 = LiteOtcTradeType.NONE;
        }
        this.f77395l = liteOtcTradeType2;
        Lh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        LiteOtcTradeType liteOtcTradeType = this.f77395l;
        LiteOtcTradeType liteOtcTradeType2 = LiteOtcTradeType.SELL;
        if (liteOtcTradeType == liteOtcTradeType2) {
            liteOtcTradeType2 = LiteOtcTradeType.NONE;
        }
        this.f77395l = liteOtcTradeType2;
        Lh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        String str;
        String str2 = this.f77396m;
        OrderStatus orderStatus = OrderStatus.UNPAID;
        if (TextUtils.equals(str2, orderStatus.getKey())) {
            str = TtmlNode.COMBINE_ALL;
        } else {
            str = orderStatus.getKey();
        }
        this.f77396m = str;
        Jh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        String str;
        String str2 = this.f77396m;
        OrderStatus orderStatus = OrderStatus.PAID;
        if (TextUtils.equals(str2, orderStatus.getKey())) {
            str = TtmlNode.COMBINE_ALL;
        } else {
            str = orderStatus.getKey();
        }
        this.f77396m = str;
        Jh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Hh() {
        a aVar = this.f77397n;
        if (aVar != null) {
            aVar.Ra(this.f77395l, this.f77396m);
        }
    }

    public void Ih(a aVar) {
        this.f77397n = aVar;
    }

    public final void Jh() {
        if (TextUtils.equals(this.f77396m, TtmlNode.COMBINE_ALL)) {
            this.f77389f.setChecked(false);
            this.f77390g.setChecked(false);
            this.f77392i.setChecked(false);
            this.f77391h.setChecked(false);
            this.f77393j.setChecked(false);
            this.f77394k.setChecked(false);
            return;
        }
        this.f77389f.setChecked(TextUtils.equals(this.f77396m, OrderStatus.UNPAID.getKey()));
        this.f77390g.setChecked(TextUtils.equals(this.f77396m, OrderStatus.PAID.getKey()));
        this.f77392i.setChecked(TextUtils.equals(this.f77396m, OrderStatus.CANCEL.getKey()));
        this.f77391h.setChecked(TextUtils.equals(this.f77396m, OrderStatus.COMPLETED.getKey()));
        this.f77393j.setChecked(TextUtils.equals(this.f77396m, OrderStatus.APPEAL.getKey()));
        this.f77394k.setChecked(TextUtils.equals(this.f77396m, OrderStatus.QUOTE_EXPIRED.getKey()));
    }

    public final void Kh() {
        Lh();
        Jh();
    }

    public final void Lh() {
        LiteOtcTradeType liteOtcTradeType = this.f77395l;
        boolean z11 = false;
        if (liteOtcTradeType == LiteOtcTradeType.NONE) {
            this.f77387d.setChecked(false);
            this.f77388e.setChecked(false);
            return;
        }
        this.f77387d.setChecked(liteOtcTradeType == LiteOtcTradeType.BUY);
        CheckBox checkBox = this.f77388e;
        if (this.f77395l == LiteOtcTradeType.SELL) {
            z11 = true;
        }
        checkBox.setChecked(z11);
    }

    public void addEvent(r rVar) {
        super.addEvent(rVar);
        this.f77385b.setOnClickListener(new i(this));
        this.f77386c.setOnClickListener(new h(this));
        this.f77387d.setOnClickListener(new f(this));
        this.f77388e.setOnClickListener(new c(this));
        this.f77389f.setOnClickListener(new d(this));
        this.f77390g.setOnClickListener(new e(this));
        this.f77392i.setOnClickListener(new l(this));
        this.f77391h.setOnClickListener(new g(this));
        this.f77393j.setOnClickListener(new j(this));
        this.f77394k.setOnClickListener(new k(this));
    }

    public void afterInit() {
    }

    public View getBackBtn() {
        return this.viewFinder.b(R$id.order_filter_back_btn);
    }

    public int getContentViewResId() {
        return R$layout.dialog_lite_otc_order_filter;
    }

    public View getFilterLayout() {
        return this.viewFinder.b(R$id.filter_view);
    }

    public void initView(r rVar) {
        this.f77385b = (TextView) rVar.b(R$id.otc_order_filter_reset_tv);
        this.f77386c = (TextView) rVar.b(R$id.otc_order_filter_sure_tv);
        this.f77387d = (CheckBox) rVar.b(R$id.otc_order_tradetype_buy_cb);
        this.f77388e = (CheckBox) rVar.b(R$id.otc_order_tradetype_sell_cb);
        this.f77389f = (CheckBox) rVar.b(R$id.otc_order_status_unpay_cb);
        this.f77390g = (CheckBox) rVar.b(R$id.otc_order_status_paid_cb);
        this.f77391h = (CheckBox) rVar.b(R$id.otc_order_status_finished_cb);
        this.f77392i = (CheckBox) rVar.b(R$id.otc_order_status_cancel_cb);
        this.f77393j = (CheckBox) rVar.b(R$id.otc_order_status_appeal_cb);
        this.f77394k = (CheckBox) rVar.b(R$id.otc_order_status_expire_cb);
    }

    public void reset() {
        this.f77395l = LiteOtcTradeType.NONE;
        this.f77396m = TtmlNode.COMBINE_ALL;
        Kh();
    }
}
