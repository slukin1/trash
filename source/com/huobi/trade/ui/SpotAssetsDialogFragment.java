package com.huobi.trade.ui;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;

public class SpotAssetsDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f82289b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f82290c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f82291d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f82292e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f82293f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f82294g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f82295h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f82296i;

    /* renamed from: j  reason: collision with root package name */
    public View f82297j;

    /* renamed from: k  reason: collision with root package name */
    public View f82298k;

    /* renamed from: l  reason: collision with root package name */
    public View f82299l;

    /* renamed from: m  reason: collision with root package name */
    public int f82300m;

    /* renamed from: n  reason: collision with root package name */
    public int f82301n;

    /* renamed from: o  reason: collision with root package name */
    public String f82302o;

    /* renamed from: p  reason: collision with root package name */
    public String f82303p;

    /* renamed from: q  reason: collision with root package name */
    public String f82304q;

    /* renamed from: r  reason: collision with root package name */
    public String f82305r;

    /* renamed from: s  reason: collision with root package name */
    public float f82306s = 0.0f;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Bh(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ch(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Eh(View view) {
        DialogUtils.Y(getActivity(), getResources().getString(R.string.n_spot_account_status), getResources().getString(R.string.n_spot_account_status_text), getResources().getString(R.string.n_known), p.f82686a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Gh(View view) {
        FragmentActivity activity = getActivity();
        String string = getResources().getString(R.string.n_spot_margin_status);
        DialogUtils.Y(activity, string, getResources().getString(R.string.n_spot_effective_trade_margin_text) + "\n" + getResources().getString(R.string.n_spot_occupy_trade_margin_text) + "\n" + getResources().getString(R.string.n_spot_free_trade_margin_text), getResources().getString(R.string.n_known), q.f82692a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static SpotAssetsDialogFragment Hh(String str, int i11, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        SpotAssetsDialogFragment spotAssetsDialogFragment = new SpotAssetsDialogFragment();
        bundle.putInt("status", i11);
        bundle.putString("progress", str);
        bundle.putString("accountEffectiveMargin", str2);
        bundle.putString("accountOccupyMargin", str3);
        bundle.putString("accountFreeMargin", str4);
        spotAssetsDialogFragment.setArguments(bundle);
        return spotAssetsDialogFragment;
    }

    public void Ih(String str, int i11, String str2, String str3, String str4) {
        if (this.f82289b != null && !isDetached()) {
            this.f82301n = i11;
            this.f82302o = str;
            this.f82305r = str4;
            this.f82304q = str3;
            this.f82303p = str2;
            Kh();
        }
    }

    public void Jh(int i11) {
        if (this.f82289b != null && !isDetached()) {
            float f11 = i11 == 0 ? 0.0f : (float) ((i11 * 40) - 20);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f82289b, "rotation", new float[]{this.f82306s, f11});
            ofFloat.setDuration(300);
            ofFloat.start();
            this.f82306s = f11;
        }
    }

    public void Kh() {
        if (this.f82289b != null && !isDetached()) {
            this.f82290c.setText(this.f82303p);
            this.f82291d.setText(this.f82304q);
            this.f82293f.setText(this.f82305r);
            Lh();
            this.f82299l.setOnClickListener(o.f82679b);
            this.f82297j.setOnClickListener(new l(this));
            this.f82298k.setOnClickListener(new m(this));
            this.f82294g.setOnClickListener(new k(this));
            this.f82292e.setOnClickListener(new n(this));
        }
    }

    public final void Lh() {
        switch (this.f82301n) {
            case 0:
                this.f82300m = 0;
                TextView textView = this.f82295h;
                textView.setText(getResources().getString(R.string.n_spot_account_no_risk) + "(" + this.f82302o + ")");
                this.f82295h.setTextColor(getResources().getColor(R.color.color_00925D));
                this.f82296i.setText(zh(R.string.n_spot_account_status_info_low_risk, R.string.n_spot_account_no_risk, R.color.color_00925D));
                break;
            case 1:
                this.f82300m = 1;
                TextView textView2 = this.f82295h;
                textView2.setText(getResources().getString(R.string.n_spot_order_little_risk) + "(" + this.f82302o + ")");
                this.f82295h.setTextColor(getResources().getColor(R.color.color_00925D));
                this.f82296i.setText(zh(R.string.n_spot_account_status_info_low_risk, R.string.n_spot_order_little_risk, R.color.color_00925D));
                break;
            case 2:
                this.f82300m = 2;
                TextView textView3 = this.f82295h;
                textView3.setText(getResources().getString(R.string.n_spot_order_middle_risk) + "(" + this.f82302o + ")");
                this.f82295h.setTextColor(getResources().getColor(R.color.color_00D488));
                this.f82296i.setText(zh(R.string.n_spot_account_status_info_high_risk, R.string.n_spot_order_middle_risk, R.color.color_00D488));
                break;
            case 3:
                this.f82300m = 3;
                int i11 = NightHelper.e().g() ? R.color.color_F2BD00 : R.color.color_FFC700;
                TextView textView4 = this.f82295h;
                textView4.setText(getResources().getString(R.string.n_spot_order_high_risk) + "(" + this.f82302o + ")");
                this.f82295h.setTextColor(getResources().getColor(i11));
                this.f82296i.setText(zh(R.string.n_spot_account_status_info_high_risk, R.string.n_spot_order_high_risk, i11));
                break;
            case 4:
                this.f82300m = 4;
                TextView textView5 = this.f82295h;
                textView5.setText(getResources().getString(R.string.n_spot_order_very_high_risk) + "(" + this.f82302o + ")");
                this.f82295h.setTextColor(getResources().getColor(R.color.color_FF800C));
                this.f82296i.setText(zh(R.string.n_spot_account_status_info_high_risk, R.string.n_spot_order_very_high_risk, R.color.color_FF800C));
                break;
            case 5:
                this.f82300m = 0;
                TextView textView6 = this.f82295h;
                textView6.setText(getResources().getString(R.string.n_asset_ybb_lock) + "(" + this.f82302o + ")");
                this.f82295h.setTextColor(getResources().getColor(R.color.color_909090));
                this.f82296i.setText(zh(R.string.n_spot_account_status_info_unusable, R.string.n_asset_ybb_lock, R.color.color_909090));
                break;
            case 6:
                this.f82300m = 5;
                TextView textView7 = this.f82295h;
                textView7.setText(getResources().getString(R.string.n_spot_account_liquidation_risk) + "(" + this.f82302o + ")");
                this.f82295h.setTextColor(getResources().getColor(R.color.color_FD0000));
                this.f82296i.setText(zh(R.string.n_spot_account_status_info_unusable, R.string.n_spot_account_liquidation_risk, R.color.color_FD0000));
                break;
            case 7:
                this.f82300m = 6;
                TextView textView8 = this.f82295h;
                textView8.setText(getResources().getString(R.string.n_spot_account_wear_risk) + "(" + this.f82302o + ")");
                this.f82295h.setTextColor(getResources().getColor(R.color.color_890000));
                this.f82296i.setText(zh(R.string.n_spot_account_status_info_unusable, R.string.n_spot_account_wear_risk, R.color.color_890000));
                break;
        }
        Jh(this.f82300m);
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R.layout.dialog_spot_assets;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f82289b = rVar.c(R.id.iv_spot_margin_risk_pointer);
        this.f82290c = rVar.e(R.id.tv_v_spot_account_effective_margin);
        this.f82291d = rVar.e(R.id.tv_v_spot_account_occupy_margin);
        this.f82293f = rVar.e(R.id.tv_v_spot_account_free_margin);
        this.f82292e = rVar.e(R.id.tv_n_spot_account_status);
        this.f82294g = rVar.e(R.id.tv_account_status);
        this.f82295h = rVar.e(R.id.tv_liquiation);
        this.f82298k = rVar.b(R.id.cl_rootView);
        this.f82299l = rVar.b(R.id.cl_btn_root);
        this.f82297j = rVar.b(R.id.iv_closed);
        this.f82296i = rVar.e(R.id.tv_tost);
        this.f82301n = getArguments().getInt("status");
        this.f82302o = getArguments().getString("progress");
        this.f82305r = getArguments().getString("accountFreeMargin");
        this.f82304q = getArguments().getString("accountOccupyMargin");
        this.f82303p = getArguments().getString("accountEffectiveMargin");
        Kh();
    }

    public boolean isTransparent() {
        return false;
    }

    public final SpannableStringBuilder zh(int i11, int i12, int i13) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = getResources().getString(i12);
        String format = String.format(getResources().getString(i11), new Object[]{string});
        int indexOf = format.indexOf(string, 0);
        if (indexOf != -1) {
            spannableStringBuilder.append(format);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(i13)), indexOf, string.length() + indexOf, 34);
        }
        return spannableStringBuilder;
    }
}
