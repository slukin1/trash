package com.huobi.asset.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bj.o0;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import vh.q;
import vh.r;
import vh.s;
import vh.t;

public class AssetPositionHeaderView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f42457b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f42458c;

    public AssetPositionHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(View view) {
        k();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(View view) {
        k();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void e() {
        findViewById(R$id.position_header_verify_proposal).setOnClickListener(new q(this));
        findViewById(R$id.position_header_verify_proposal_font_icon).setOnClickListener(new r(this));
        findViewById(R$id.position_header_sort_title_layout).setOnClickListener(t.f61056b);
        this.f42458c.setOnClickListener(s.f61055b);
    }

    public final void f() {
        this.f42457b = (TextView) findViewById(R$id.position_header_sort_title);
        this.f42458c = (ImageView) findViewById(R$id.position_header_sort_icon);
    }

    public final void k() {
        FragmentActivity fragmentActivity = (FragmentActivity) getContext();
        new DialogUtils.b.d(fragmentActivity).c1(getContext().getString(R$string.balance_safety_hint)).i1(1).M0(Integer.valueOf(R$drawable.popups_safety_img)).P0(getContext().getString(R$string.contract_trade_i_know)).x0(false).y0(getContext().getString(R$string.contract_trigger_order_change_not_show)).q0(false).Q0(o0.f12469a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
    }

    public AssetPositionHeaderView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater.from(context).inflate(R$layout.asset_position_header_layout, this);
        f();
        e();
    }
}
