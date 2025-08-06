package com.huobi.assetrecord;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import com.hbg.lib.core.ui.BaseEditActivity;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.CommonDateSelectorView;
import com.hbg.lib.widgets.bean.CommonDateSelectorItemBean;
import com.hbg.lib.widgets.utils.CalendarUtils;
import com.huobi.account.ui.SecurityStrategyBottomMenuFragment;
import com.huobi.account.ui.SecurityStrategyController;
import com.huobi.assetrecord.presenter.AppleOrderHistoryRecordPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.rtmp.TXVodConstants;
import ii.d;
import ii.e;
import ii.f;
import ii.g;
import ii.h;
import ii.i;
import ii.j;
import java.util.List;
import java.util.Map;
import pro.huobi.R;
import tg.r;

public class AppleOrderHistoryRecordActivity extends BaseEditActivity<AppleOrderHistoryRecordPresenter, AppleOrderHistoryRecordPresenter.a> implements AppleOrderHistoryRecordPresenter.a {

    /* renamed from: c  reason: collision with root package name */
    public CommonDateSelectorView f42782c;

    /* renamed from: d  reason: collision with root package name */
    public SecurityStrategyBottomMenuFragment f42783d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f42784e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f42785f;

    /* renamed from: g  reason: collision with root package name */
    public View f42786g;

    /* renamed from: h  reason: collision with root package name */
    public View f42787h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f42788i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f42789j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f42790k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f42791l;

    /* renamed from: m  reason: collision with root package name */
    public View f42792m;

    /* renamed from: n  reason: collision with root package name */
    public View f42793n;

    /* renamed from: o  reason: collision with root package name */
    public CheckBox f42794o;

    /* renamed from: p  reason: collision with root package name */
    public CheckBox f42795p;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            ((AppleOrderHistoryRecordPresenter) AppleOrderHistoryRecordActivity.this.getPresenter()).U(charSequence.toString());
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            ((AppleOrderHistoryRecordPresenter) AppleOrderHistoryRecordActivity.this.getPresenter()).T(charSequence.toString());
        }
    }

    public class c extends SecurityStrategyController {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f42798g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f42799h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f42800i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f42801j;

        public c(boolean z11, boolean z12, boolean z13, String str) {
            this.f42798g = z11;
            this.f42799h = z12;
            this.f42800i = z13;
            this.f42801j = str;
        }

        public boolean C() {
            return this.f42798g;
        }

        public final String Y() {
            return this.f42801j;
        }

        public void i(String str, String str2, String str3, String str4) {
            AppleOrderHistoryRecordActivity.this.f42783d.dismiss();
            ((AppleOrderHistoryRecordPresenter) AppleOrderHistoryRecordActivity.this.getPresenter()).W(str, str2, str3, Y());
        }

        public String n() {
            return r.x().M().e();
        }

        public String o() {
            return r.x().M().h();
        }

        public Map<String, Object> p() {
            return MapParamsBuilder.c().a("use_type", Y()).b();
        }

        public Map<String, Object> s() {
            return MapParamsBuilder.c().a("use_type", Y()).a("voice", Boolean.FALSE).b();
        }

        public boolean x() {
            return this.f42799h;
        }

        public boolean y() {
            return this.f42800i;
        }

        public boolean z() {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ah(View view, boolean z11) {
        if (!z11) {
            ((AppleOrderHistoryRecordPresenter) getPresenter()).f0();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Bh(View view) {
        ((AppleOrderHistoryRecordPresenter) getPresenter()).V(this.f42782c.getStartDate(), this.f42782c.getEndDate());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ch(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Dh(View view) {
        AppleOrderHistoryRecordListActivity.Qg(this, false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Eh(CompoundButton compoundButton, boolean z11) {
        ((AppleOrderHistoryRecordPresenter) getPresenter()).g0();
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fh(CompoundButton compoundButton, boolean z11) {
        ((AppleOrderHistoryRecordPresenter) getPresenter()).g0();
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Gh(View view) {
        ((AppleOrderHistoryRecordPresenter) getPresenter()).g0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void Hh(Context context) {
        context.startActivity(new Intent(context, AppleOrderHistoryRecordActivity.class));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        this.f42784e.setText("");
        K4(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        this.f42785f.setText("");
        sf(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh(View view, boolean z11) {
        if (!z11) {
            ((AppleOrderHistoryRecordPresenter) getPresenter()).d0();
        }
    }

    public boolean C4() {
        return this.f42794o.isChecked() || this.f42795p.isChecked();
    }

    public void Ff(int i11) {
        if (i11 == 0) {
            this.f42788i.setVisibility(8);
            this.f42784e.setBackgroundResource(R.drawable.selector_apple_record_more_edit);
        } else if (i11 == 1) {
            this.f42788i.setVisibility(0);
            this.f42784e.setBackgroundResource(R.drawable.shape_apple_record_mord_edit_error);
        }
    }

    public boolean Gc() {
        return this.f42795p.isChecked();
    }

    public void K4(boolean z11) {
        int i11 = z11 ? 0 : 8;
        if (i11 != this.f42786g.getVisibility()) {
            this.f42786g.setVisibility(i11);
        }
    }

    public void Ka(boolean z11) {
        this.f42791l.setEnabled(z11);
    }

    public void O8(boolean z11, boolean z12, boolean z13, String str) {
        this.f42783d.Ci(new c(z11, z13, z12, str));
        this.f42783d.show(getSupportFragmentManager(), "BottomMenuFragment");
    }

    public boolean Sc() {
        return this.f42782c.getDateEnable();
    }

    public void Xe(int i11) {
        if (i11 == 0) {
            this.f42789j.setVisibility(8);
            this.f42785f.setBackgroundResource(R.drawable.selector_apple_record_more_edit);
        } else if (i11 == 2) {
            this.f42789j.setVisibility(0);
            this.f42785f.setBackgroundResource(R.drawable.shape_apple_record_mord_edit_error);
        } else if (i11 == 1) {
            this.f42789j.setVisibility(0);
            this.f42785f.setBackgroundResource(R.drawable.shape_apple_record_mord_edit_error);
        }
    }

    public void addEvent() {
        this.f42784e.addTextChangedListener(new a());
        this.f42785f.addTextChangedListener(new b());
        this.f42784e.setOnFocusChangeListener(new h(this));
        this.f42785f.setOnFocusChangeListener(new g(this));
        this.f42786g.setOnClickListener(new d(this));
        this.f42787h.setOnClickListener(new ii.b(this));
        this.f42791l.setOnClickListener(new f(this));
        this.f42792m.setOnClickListener(new ii.c(this));
        this.f42793n.setOnClickListener(new e(this));
        this.f42794o.setOnCheckedChangeListener(new i(this));
        this.f42795p.setOnCheckedChangeListener(new j(this));
    }

    public boolean f7() {
        return this.f42794o.isChecked();
    }

    public int getContentView() {
        return R.layout.activity_apple_order_record;
    }

    public void initView() {
        xh();
        this.f42784e = (EditText) this.viewFinder.b(R.id.apple_order_email_edit);
        this.f42785f = (EditText) this.viewFinder.b(R.id.apple_order_confirm_email_edit);
        this.f42786g = this.viewFinder.b(R.id.apple_order_email_edit_close_icon);
        this.f42787h = this.viewFinder.b(R.id.apple_order_confirm_email_edit_close_icon);
        this.f42788i = (TextView) this.viewFinder.b(R.id.apple_order_email_edit_error);
        this.f42789j = (TextView) this.viewFinder.b(R.id.apple_order_confirm_email_edit_error);
        this.f42790k = (TextView) this.viewFinder.b(R.id.apple_order_tips_content);
        this.f42791l = (TextView) this.viewFinder.b(R.id.apple_order_confirm_btn);
        this.f42792m = this.viewFinder.b(R.id.apple_order_submit_back);
        this.f42793n = this.viewFinder.b(R.id.apple_order_record_detail_list);
        this.f42794o = (CheckBox) this.viewFinder.b(R.id.cb_spot_finance);
        this.f42795p = (CheckBox) this.viewFinder.b(R.id.cb_spot_deal);
        yh();
    }

    public void jf(List<CommonDateSelectorItemBean> list) {
        this.f42782c.z(list, 1);
    }

    public void onResume() {
        super.onResume();
        if (this.f42783d == null) {
            this.f42783d = new SecurityStrategyBottomMenuFragment();
        }
    }

    public void p8() {
        AppleOrderHistoryRecordListActivity.Qg(this, true);
    }

    public void sf(boolean z11) {
        int i11 = z11 ? 0 : 8;
        if (i11 != this.f42787h.getVisibility()) {
            this.f42787h.setVisibility(i11);
        }
    }

    /* renamed from: vh */
    public AppleOrderHistoryRecordPresenter createPresenter() {
        return new AppleOrderHistoryRecordPresenter();
    }

    /* renamed from: wh */
    public AppleOrderHistoryRecordPresenter.a getUI() {
        return this;
    }

    public final void xh() {
        CommonDateSelectorView commonDateSelectorView = (CommonDateSelectorView) this.viewFinder.b(R.id.apple_order_date_selector);
        this.f42782c = commonDateSelectorView;
        commonDateSelectorView.setTitle(getString(R.string.n_asset_apply_more_date));
        this.f42782c.setMaxDayTimeInMillis(CalendarUtils.b(TXVodConstants.VOD_PLAY_EVT_FIRST_VIDEO_PACKET, 5, 30));
        this.f42782c.setEndTimeOffsetDay(-1);
        this.f42782c.setOnStatusChangeListener(new ii.a(this));
    }

    public final void yh() {
        this.f42790k.setText(getString(R.string.n_asset_apply_record_tips_1) + "\n\n" + getString(R.string.n_asset_apply_record_tips_2) + "\n\n" + getString(R.string.n_asset_apply_record_tips_3) + "\n\n" + getString(R.string.n_asset_apply_record_tips_4) + "\n\n" + getString(R.string.n_asset_apply_record_tips_5));
    }
}
