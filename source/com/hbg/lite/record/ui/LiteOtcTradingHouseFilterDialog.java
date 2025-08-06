package com.hbg.lite.record.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.hbg.lib.network.otc.enums.OrderStatus;
import com.hbg.lib.widgets.BaseOrderFilterDialogFragment;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import jb.m;
import jb.n;
import jb.o;
import jb.p;
import jb.q;
import jb.s;
import jb.t;
import jb.u;
import jb.v;

public class LiteOtcTradingHouseFilterDialog extends BaseOrderFilterDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TextView f77398b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f77399c;

    /* renamed from: d  reason: collision with root package name */
    public CheckBox f77400d;

    /* renamed from: e  reason: collision with root package name */
    public CheckBox f77401e;

    /* renamed from: f  reason: collision with root package name */
    public CheckBox f77402f;

    /* renamed from: g  reason: collision with root package name */
    public CheckBox f77403g;

    /* renamed from: h  reason: collision with root package name */
    public CheckBox f77404h;

    /* renamed from: i  reason: collision with root package name */
    public CheckBox f77405i;

    /* renamed from: j  reason: collision with root package name */
    public CheckBox f77406j;

    /* renamed from: k  reason: collision with root package name */
    public CheckBox f77407k;

    /* renamed from: l  reason: collision with root package name */
    public int f77408l = -1;

    /* renamed from: m  reason: collision with root package name */
    public String f77409m = TtmlNode.COMBINE_ALL;

    /* renamed from: n  reason: collision with root package name */
    public a f77410n;

    public interface a {
        void Eb(int i11, String str);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Dh(View view) {
        String str;
        String str2 = this.f77409m;
        OrderStatus orderStatus = OrderStatus.CANCEL;
        if (TextUtils.equals(str2, orderStatus.getKey())) {
            str = TtmlNode.COMBINE_ALL;
        } else {
            str = orderStatus.getKey();
        }
        this.f77409m = str;
        Jh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Eh(View view) {
        String str;
        String str2 = this.f77409m;
        OrderStatus orderStatus = OrderStatus.COMPLETED;
        if (TextUtils.equals(str2, orderStatus.getKey())) {
            str = TtmlNode.COMBINE_ALL;
        } else {
            str = orderStatus.getKey();
        }
        this.f77409m = str;
        Jh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fh(View view) {
        String str;
        String str2 = this.f77409m;
        OrderStatus orderStatus = OrderStatus.APPEAL;
        if (TextUtils.equals(str2, orderStatus.getKey())) {
            str = TtmlNode.COMBINE_ALL;
        } else {
            str = orderStatus.getKey();
        }
        this.f77409m = str;
        Jh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Gh(View view) {
        String str;
        String str2 = this.f77409m;
        OrderStatus orderStatus = OrderStatus.QUOTE_EXPIRED;
        if (TextUtils.equals(str2, orderStatus.getKey())) {
            str = TtmlNode.COMBINE_ALL;
        } else {
            str = orderStatus.getKey();
        }
        this.f77409m = str;
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
        this.f77408l = this.f77408l == 0 ? -1 : 0;
        Lh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        int i11 = 1;
        if (this.f77408l == 1) {
            i11 = -1;
        }
        this.f77408l = i11;
        Lh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        String str;
        String str2 = this.f77409m;
        OrderStatus orderStatus = OrderStatus.UNPAID;
        if (TextUtils.equals(str2, orderStatus.getKey())) {
            str = TtmlNode.COMBINE_ALL;
        } else {
            str = orderStatus.getKey();
        }
        this.f77409m = str;
        Jh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        String str;
        String str2 = this.f77409m;
        OrderStatus orderStatus = OrderStatus.PAID;
        if (TextUtils.equals(str2, orderStatus.getKey())) {
            str = TtmlNode.COMBINE_ALL;
        } else {
            str = orderStatus.getKey();
        }
        this.f77409m = str;
        Jh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Hh() {
        a aVar = this.f77410n;
        if (aVar != null) {
            aVar.Eb(this.f77408l, this.f77409m);
        }
    }

    public void Ih(a aVar) {
        this.f77410n = aVar;
    }

    public final void Jh() {
        String str = this.f77409m;
        if (str == TtmlNode.COMBINE_ALL) {
            this.f77402f.setChecked(false);
            this.f77403g.setChecked(false);
            this.f77405i.setChecked(false);
            this.f77404h.setChecked(false);
            this.f77406j.setChecked(false);
            this.f77407k.setChecked(false);
            return;
        }
        this.f77402f.setChecked(TextUtils.equals(str, OrderStatus.UNPAID.getKey()));
        this.f77403g.setChecked(TextUtils.equals(this.f77409m, OrderStatus.PAID.getKey()));
        this.f77405i.setChecked(TextUtils.equals(this.f77409m, OrderStatus.CANCEL.getKey()));
        this.f77404h.setChecked(TextUtils.equals(this.f77409m, OrderStatus.COMPLETED.getKey()));
        this.f77406j.setChecked(TextUtils.equals(this.f77409m, OrderStatus.APPEAL.getKey()));
        this.f77407k.setChecked(TextUtils.equals(this.f77409m, OrderStatus.QUOTE_EXPIRED.getKey()));
    }

    public final void Kh() {
        Lh();
        Jh();
    }

    public final void Lh() {
        int i11 = this.f77408l;
        boolean z11 = false;
        if (i11 == -1) {
            this.f77400d.setChecked(false);
            this.f77401e.setChecked(false);
            return;
        }
        this.f77400d.setChecked(i11 == 0);
        CheckBox checkBox = this.f77401e;
        if (this.f77408l == 1) {
            z11 = true;
        }
        checkBox.setChecked(z11);
    }

    public void addEvent(r rVar) {
        super.addEvent(rVar);
        this.f77398b.setOnClickListener(new s(this));
        this.f77399c.setOnClickListener(new o(this));
        this.f77400d.setOnClickListener(new v(this));
        this.f77401e.setOnClickListener(new p(this));
        this.f77402f.setOnClickListener(new jb.r(this));
        this.f77403g.setOnClickListener(new n(this));
        this.f77405i.setOnClickListener(new m(this));
        this.f77404h.setOnClickListener(new q(this));
        this.f77406j.setOnClickListener(new t(this));
        this.f77407k.setOnClickListener(new u(this));
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
        this.f77398b = (TextView) rVar.b(R$id.otc_order_filter_reset_tv);
        this.f77399c = (TextView) rVar.b(R$id.otc_order_filter_sure_tv);
        this.f77400d = (CheckBox) rVar.b(R$id.otc_order_tradetype_buy_cb);
        this.f77401e = (CheckBox) rVar.b(R$id.otc_order_tradetype_sell_cb);
        this.f77402f = (CheckBox) rVar.b(R$id.otc_order_status_unpay_cb);
        this.f77403g = (CheckBox) rVar.b(R$id.otc_order_status_paid_cb);
        this.f77404h = (CheckBox) rVar.b(R$id.otc_order_status_finished_cb);
        this.f77405i = (CheckBox) rVar.b(R$id.otc_order_status_cancel_cb);
        this.f77406j = (CheckBox) rVar.b(R$id.otc_order_status_appeal_cb);
        this.f77407k = (CheckBox) rVar.b(R$id.otc_order_status_expire_cb);
    }

    public void reset() {
        this.f77408l = -1;
        this.f77409m = TtmlNode.COMBINE_ALL;
        Kh();
    }
}
