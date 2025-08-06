package al;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.R$raw;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$style;
import com.huobi.view.button.StatusButton;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.n;

public final class w0 implements DialogInterface.OnDismissListener {

    /* renamed from: k  reason: collision with root package name */
    public static w0 f40744k = new w0();

    /* renamed from: b  reason: collision with root package name */
    public TextView f40745b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f40746c;

    /* renamed from: d  reason: collision with root package name */
    public StatusButton f40747d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f40748e;

    /* renamed from: f  reason: collision with root package name */
    public Dialog f40749f;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f40750g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40751h;

    /* renamed from: i  reason: collision with root package name */
    public LottieAnimationView f40752i;

    /* renamed from: j  reason: collision with root package name */
    public LoadingView f40753j;

    public interface a {
        void a(boolean z11);
    }

    public static w0 g() {
        return f40744k;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(View view) {
        Dialog dialog = this.f40750g;
        if (dialog != null) {
            dialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void i(a aVar, CompoundButton compoundButton, boolean z11) {
        if (aVar != null) {
            aVar.a(z11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(DialogInterface dialogInterface) {
        this.f40750g = null;
    }

    public void d() {
        this.f40751h = false;
        Dialog dialog = this.f40749f;
        if (dialog != null) {
            dialog.dismiss();
            this.f40749f = null;
        }
    }

    public void e() {
        this.f40753j.d();
        this.f40753j.setVisibility(8);
    }

    public boolean f() {
        return this.f40751h;
    }

    public void k(boolean z11) {
        this.f40751h = z11;
    }

    public void l(String str) {
        TextView textView = this.f40746c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void m() {
        this.f40753j.setLottieAnimationRes(R$raw.nd_middle_bg);
        this.f40753j.c();
        this.f40753j.setVisibility(0);
    }

    public void n(Context context, boolean z11, a aVar) {
        if (this.f40750g == null) {
            this.f40750g = new Dialog(context, R$style.TranslateDialog);
            View inflate = LayoutInflater.from(context).inflate(R$layout.dialog_withdraw_quick, (ViewGroup) null);
            SwitchCompat switchCompat = (SwitchCompat) inflate.findViewById(R$id.switch_compat_withdraw_quick_dialog);
            u0 u0Var = new u0(this);
            inflate.findViewById(R$id.text_view_quick_withdraw_dialog_close).setOnClickListener(u0Var);
            inflate.findViewById(R$id.status_button_withdraw_quick_dialog_ensure).setOnClickListener(u0Var);
            switchCompat.setChecked(z11);
            switchCompat.setOnCheckedChangeListener(new v0(aVar));
            this.f40750g.setContentView(inflate);
        }
        this.f40750g.setOnDismissListener(new t0(this));
        this.f40750g.setCanceledOnTouchOutside(false);
        this.f40750g.show();
        WindowManager.LayoutParams attributes = this.f40750g.getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = n.g(context);
        this.f40750g.getWindow().setAttributes(attributes);
    }

    public Dialog o(Context context, String str, String str2, String str3, View.OnClickListener onClickListener, String str4, View.OnClickListener onClickListener2) {
        if (this.f40749f == null) {
            this.f40749f = new Dialog(context, R$style.TranslateDialog);
            View inflate = LayoutInflater.from(context).inflate(R$layout.dialog_withdraw_detain, (ViewGroup) null);
            this.f40752i = (LottieAnimationView) inflate.findViewById(R$id.lottie_animation_view_withdraw_detain_dialog_image);
            this.f40753j = (LoadingView) inflate.findViewById(R$id.loading_view_withdraw_detain_dialog);
            this.f40745b = (TextView) inflate.findViewById(R$id.text_view_withdraw_detain_dialog_title);
            this.f40746c = (TextView) inflate.findViewById(R$id.text_view_withdraw_detain_dialog_desc);
            this.f40747d = (StatusButton) inflate.findViewById(R$id.status_button_withdraw_detain_dialog_ensure);
            this.f40748e = (TextView) inflate.findViewById(R$id.text_view_withdraw_detain_dialog_cancel);
            this.f40749f.setContentView(inflate);
            this.f40749f.setCanceledOnTouchOutside(false);
            int i11 = com.hbg.module.asset.R$raw.check_in_success;
            this.f40752i.setAnimation(context.getResources().openRawResource(i11), "rawRes_" + i11);
            this.f40752i.setRepeatCount(0);
            this.f40752i.playAnimation();
        }
        this.f40746c.setText(str2);
        this.f40745b.setText(str);
        this.f40747d.setButtonText(str3);
        this.f40748e.setText(str4);
        this.f40747d.setOnClickListener(onClickListener);
        this.f40748e.setOnClickListener(onClickListener2);
        this.f40749f.setOnDismissListener(this);
        this.f40749f.setCancelable(false);
        if (!this.f40749f.isShowing()) {
            this.f40749f.show();
        }
        return this.f40749f;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        k(false);
    }
}
