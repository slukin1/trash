package com.huobi.finance.ui;

import ad.b;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.otc.helper.OtcFaitDWJumpHelper;
import pro.huobi.R;

public class KycConditionAuthDialog {

    /* renamed from: a  reason: collision with root package name */
    public int f46584a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f46585b = 0;

    /* renamed from: c  reason: collision with root package name */
    public a f46586c;

    /* renamed from: d  reason: collision with root package name */
    public String f46587d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46588e = true;

    /* renamed from: f  reason: collision with root package name */
    public String f46589f;

    /* renamed from: g  reason: collision with root package name */
    public int f46590g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46591h;

    /* renamed from: i  reason: collision with root package name */
    public View f46592i;

    public interface a {
        void a(int i11, int i12);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        a aVar = this.f46586c;
        if (aVar != null) {
            aVar.a(this.f46584a, this.f46585b);
        }
    }

    public final View b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_content_kyc_condition_auto, (ViewGroup) null);
        this.f46592i = inflate.findViewById(R.id.kyc_ll);
        c(context, this.f46584a, (ImageView) inflate.findViewById(R.id.iv_condition_item1), (TextView) inflate.findViewById(R.id.tv_condition_item1));
        c(context, this.f46585b, (ImageView) inflate.findViewById(R.id.iv_condition_item2), (TextView) inflate.findViewById(R.id.tv_condition_item2));
        if (this.f46590g != OtcFaitDWJumpHelper.f78856h || this.f46591h) {
            inflate.findViewById(R.id.fa2_container).setVisibility(8);
        } else {
            inflate.findViewById(R.id.fa2_container).setVisibility(0);
        }
        if (this.f46588e) {
            this.f46592i.setVisibility(0);
        } else {
            this.f46592i.setVisibility(8);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        if (TextUtils.isEmpty(this.f46589f)) {
            textView.setText(R.string.n_currency_kyc_condition_auth_tips);
        } else {
            textView.setText(this.f46589f);
        }
        return inflate;
    }

    public final void c(Context context, int i11, ImageView imageView, TextView textView) {
        if (i11 == 1) {
            textView.append(" ");
            textView.append(context.getString(R.string.n_currency_kyc_condition_authenticating));
            imageView.setImageResource(R.drawable.common_marquee_selected_gray);
            textView.setTextColor(ContextCompat.getColor(context, R.color.global_secondary_text_color));
        } else if (i11 == 2) {
            imageView.setImageResource(R.drawable.marquee_selected);
            textView.setTextColor(ContextCompat.getColor(context, R.color.global_jump_btn_color));
        } else if (i11 != 3) {
            imageView.setImageResource(R.drawable.common_marquee_selected_gray);
            textView.setTextColor(ContextCompat.getColor(context, R.color.global_secondary_text_color));
        } else {
            textView.append(" (");
            textView.append(context.getString(R.string.n_kyc_authentication_fail));
            textView.append(")");
            imageView.setImageResource(R.drawable.common_marquee_selected_gray);
            textView.setTextColor(ContextCompat.getColor(context, R.color.global_secondary_text_color));
        }
    }

    public void e(String str) {
        this.f46587d = str;
    }

    public void f(a aVar) {
        this.f46586c = aVar;
    }

    public void g(int i11) {
        this.f46584a = i11;
    }

    public void h(int i11) {
        this.f46585b = i11;
    }

    public void i(String str) {
        this.f46589f = str;
    }

    public void j(boolean z11) {
        this.f46591h = z11;
    }

    public void k(int i11) {
        this.f46590g = i11;
    }

    public void l(boolean z11) {
        this.f46588e = z11;
    }

    public void m(FragmentActivity fragmentActivity) {
        boolean z11 = true;
        if (this.f46584a == 1 || this.f46585b == 1) {
            z11 = false;
        }
        n(fragmentActivity, z11);
    }

    public void n(FragmentActivity fragmentActivity, boolean z11) {
        HBDialogFragment x02 = new DialogUtils.b.d(fragmentActivity).i1(4).c1(fragmentActivity.getString(R.string.n_login_tip)).n0(true).q0(z11).s0(fragmentActivity.getString(R.string.global_string_cancel)).N0(b.f3517a).P0(this.f46587d).Q0(new d6(this)).I0(b(fragmentActivity)).m0().x0();
        x02.setCanceledOnTouchOutside(false);
        x02.show(fragmentActivity.getSupportFragmentManager(), "");
    }
}
