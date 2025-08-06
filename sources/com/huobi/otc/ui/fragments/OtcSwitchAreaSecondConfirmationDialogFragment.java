package com.huobi.otc.ui.fragments;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.concurrent.TimeUnit;
import tp.d;
import tp.e;
import tp.f;

public class OtcSwitchAreaSecondConfirmationDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TextView f79625b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f79626c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f79627d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f79628e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f79629f;

    /* renamed from: g  reason: collision with root package name */
    public ConstraintLayout f79630g;

    /* renamed from: h  reason: collision with root package name */
    public a f79631h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f79632i;

    public interface a {
        void a(boolean z11);

        void onDismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f79630g.getLayoutParams();
        marginLayoutParams.width = PixelUtils.g();
        this.f79630g.setLayoutParams(marginLayoutParams);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vh(Void voidR) {
        a aVar;
        if (getActivity() != null && (aVar = this.f79631h) != null) {
            aVar.a(this.f79632i);
        }
    }

    public void addEvent(r rVar) {
        dw.a.a(this.f79629f).throttleFirst(1, TimeUnit.SECONDS).subscribe(new f(this));
        this.f79626c.setOnClickListener(new d(this));
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R$layout.dialog_fragment_switch_area_second_confir_layout;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f79625b = (TextView) rVar.b(R$id.second_confirm_title);
        this.f79626c = (TextView) rVar.b(R$id.second_confirm_close);
        this.f79627d = (TextView) rVar.b(R$id.second_confirm_content);
        this.f79628e = (TextView) rVar.b(R$id.second_confirm_sub_content);
        this.f79629f = (TextView) rVar.b(R$id.id_second_confirm_sure_tv);
        this.f79630g = (ConstraintLayout) rVar.b(R$id.root_cl);
        if (this.f79632i) {
            this.f79625b.setText(getString(R$string.n_otc_trade_switch_trade_alert_to_safe_alert_title));
            this.f79627d.setText(getString(R$string.n_otc_trade_switch_trade_alert_to_safe_content));
            this.f79629f.setBackgroundResource(R$drawable.common_blue_5_radius_selector);
        } else {
            this.f79625b.setText(getString(R$string.n_otc_trade_switch_trade_alert_to_normal_alert_title));
            this.f79627d.setText(getString(R$string.n_otc_trade_switch_trade_alert_to_normal_content));
            this.f79629f.setBackgroundResource(R$drawable.common_blue_5_radius_selector);
        }
        setCanceledOnTouchOutside(false);
        this.f79630g.post(new e(this));
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return true;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        a aVar = this.f79631h;
        if (aVar != null) {
            aVar.onDismiss();
        }
    }

    public boolean useWindowBg() {
        return false;
    }
}
