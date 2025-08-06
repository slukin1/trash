package com.huobi.otc.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.OtcU1000DetailBean;
import com.huobi.otc.ui.OtcOperationActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;

public class OtcOperationDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f78308b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f78309c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f78310d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f78311e;

    /* renamed from: f  reason: collision with root package name */
    public OtcU1000DetailBean f78312f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            OtcOperationDialog.this.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            Context context = view.getContext();
            if ((context instanceof Activity) && OtcOperationDialog.this.f78312f != null) {
                OtcOperationActivity.Xf((Activity) context, OtcOperationDialog.this.f78312f);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            Activity b11 = oa.a.g().b();
            if (!(b11 == null || OtcOperationDialog.this.f78312f == null)) {
                OtcModuleConfig.b().f(b11, OtcOperationDialog.this.f78312f.getActivityUrl());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public OtcOperationDialog(ViewGroup viewGroup, ViewGroup viewGroup2, OtcU1000DetailBean otcU1000DetailBean) {
        this.f78310d = viewGroup;
        this.f78311e = viewGroup2;
        this.f78312f = otcU1000DetailBean;
    }

    public void addEvent(r rVar) {
        rVar.b(R$id.op_1000u_close).setOnClickListener(new a());
        this.f78311e.findViewById(R$id.lottery_desc).setOnClickListener(new b());
        TextView textView = (TextView) this.f78311e.findViewById(R$id.u100_attivity_detail);
        textView.getPaint().setFlags(8);
        textView.getPaint().setAntiAlias(true);
        textView.setOnClickListener(new c());
    }

    public void afterInit() {
        setCancelable(false);
        setCanceledOnTouchOutside(true);
        setCanDismissOnBackPress(true);
    }

    public int getContentViewResId() {
        return R$layout.otc_operation_dialog_layout;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f78308b = (LinearLayout) rVar.b(R$id.operation_dialog_content);
        this.f78309c = (LinearLayout) rVar.b(R$id.operation_dialog_bottom);
        TextView textView = (TextView) this.f78310d.findViewById(R$id.u1000_allEarns);
        TextView textView2 = (TextView) this.f78310d.findViewById(R$id.u1000_adOnline);
        TextView textView3 = (TextView) this.f78310d.findViewById(R$id.u1000_byOrder);
        if (this.f78312f != null) {
            textView.setText(String.valueOf(this.f78312f.getAllEarns()) + " USDT");
            textView2.setText(String.valueOf(this.f78312f.getAdvertiseEarns()));
            textView3.setText(String.valueOf(this.f78312f.getOrderEarns()));
        }
        uh(this.f78310d);
        th(this.f78311e);
        setCoverViewBgColor(getResources().getColor(R$color.global_dialog_bg_alpha_color_u1000));
    }

    public boolean isTransparent() {
        return false;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
    }

    public void th(ViewGroup viewGroup) {
        this.f78309c.addView(viewGroup);
    }

    public void uh(ViewGroup viewGroup) {
        this.f78308b.addView(viewGroup);
    }

    public boolean useWindowBg() {
        return false;
    }
}
