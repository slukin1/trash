package com.huobi.points.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.points.entity.Points;
import com.huobi.points.presenter.MyTransferPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fq.b;
import fq.c;
import fq.d;
import i6.m;
import pro.huobi.R;

public class MyTransferActivity extends BaseActivity<MyTransferPresenter, MyTransferPresenter.a> implements MyTransferPresenter.a, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public float f80344b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80345c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80346d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f80347e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f80348f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f80349g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f80350h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f80351i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f80352j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f80353k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f80354l;

    /* access modifiers changed from: private */
    public /* synthetic */ void Pg(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ((MyTransferPresenter) getPresenter()).d0();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void th(Context context, long j11) {
        if (context != null) {
            Intent intent = new Intent(context, MyTransferActivity.class);
            intent.putExtra("extra", j11);
            context.startActivity(intent);
        }
    }

    public void M9() {
    }

    public void Qg(CharSequence charSequence) {
        TextView textView = this.f80347e;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void Y1() {
        finish();
    }

    public void addEvent() {
        this.viewFinder.b(R.id.id_back).setOnClickListener(new b(this));
        this.viewFinder.b(R.id.id_my_transfer_bottom_btn).setOnClickListener(this);
    }

    /* renamed from: fg */
    public MyTransferPresenter createPresenter() {
        return new MyTransferPresenter();
    }

    public int getContentView() {
        return R.layout.activity_my_transfer;
    }

    /* renamed from: gg */
    public MyTransferPresenter.a getUI() {
        return this;
    }

    public void initView() {
        this.f80345c = (TextView) this.viewFinder.b(R.id.id_my_transfer_status);
        this.f80346d = (TextView) this.viewFinder.b(R.id.id_my_transfer_uid);
        this.f80347e = (TextView) this.viewFinder.b(R.id.id_my_transfer_account);
        this.f80348f = (TextView) this.viewFinder.b(R.id.id_my_transfer_single_price);
        this.f80349g = (TextView) this.viewFinder.b(R.id.id_my_transfer_usdt);
        this.f80350h = (TextView) this.viewFinder.b(R.id.id_points_history_details_amount);
        this.f80351i = (TextView) this.viewFinder.b(R.id.id_points_history_details_amount_unit);
        this.f80352j = (TextView) this.viewFinder.b(R.id.id_points_history_details_title);
        this.f80353k = (TextView) this.viewFinder.b(R.id.detail_date_tv);
        this.f80354l = (TextView) this.viewFinder.b(R.id.detail_points_id_tv);
        uh(getString(R.string.my_transfer_title));
        this.f80344b = getResources().getDimension(R.dimen.dimen_44);
    }

    public void oh(CharSequence charSequence) {
        TextView textView = this.f80349g;
        if (textView != null) {
            textView.setText(charSequence + " " + getString(R.string.string_usdt));
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R.id.id_my_transfer_bottom_btn) {
            DialogUtils.b0(this, getString(R.string.my_transfer_btn_confirm_cancel), getString(R.string.my_transfer_cancel_tips), "", getString(R.string.string_cancel), getString(R.string.string_confirm), d.f54738a, new c(this));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void ph(CharSequence charSequence) {
        TextView textView = this.f80350h;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void qh(CharSequence charSequence) {
        TextView textView = this.f80348f;
        if (textView != null) {
            textView.setText(charSequence + " USDT/" + getString(R.string.points_pts));
        }
    }

    public void rh(CharSequence charSequence) {
        TextView textView = this.f80345c;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void sh(CharSequence charSequence) {
        TextView textView = this.f80346d;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void uh(String str) {
        this.f80352j.setText(str);
    }

    public void z3(Points points) {
        sh(points.getUid());
        oh(m.p0(m.m(points.getTotalAmount(), PrecisionUtil.c((String) null))));
        ph("- " + m.p0(m.m(points.getTotalPoints(), PrecisionUtil.c((String) null))));
        Qg(points.getAccount());
        qh(m.p0(m.m(points.getPrice(), PrecisionUtil.c((String) null))));
        int color = getResources().getColor(R.color.baseColorPrimaryText);
        this.f80350h.setTextColor(color);
        this.f80351i.setTextColor(color);
        this.f80353k.setText(DateTimeUtils.h(points.getCreatedAt(), "HH:mm:ss MM/dd/yyyy "));
        this.f80354l.setText(String.valueOf(points.getId()));
        String string = getString(R.string.points_transfer_order_status_waiting);
        String state = points.getState();
        state.hashCode();
        char c11 = 65535;
        switch (state.hashCode()) {
            case -1335395429:
                if (state.equals(Points.STATE_DENIED)) {
                    c11 = 0;
                    break;
                }
                break;
            case -673660814:
                if (state.equals("finished")) {
                    c11 = 1;
                    break;
                }
                break;
            case -123173735:
                if (state.equals("canceled")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                string = getString(R.string.points_transfer_order_status_reject);
                break;
            case 1:
                string = getString(R.string.points_transfer_order_status_finished);
                break;
            case 2:
                string = getString(R.string.points_transfer_order_status_canceled);
                break;
        }
        rh(string);
    }
}
