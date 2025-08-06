package com.huobi.account.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import java.util.regex.Pattern;
import pro.huobi.R;

public class StepRateItemCardView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public a f41542b;

    /* renamed from: c  reason: collision with root package name */
    public Context f41543c;

    public static class Data {

        /* renamed from: a  reason: collision with root package name */
        public int f41544a;

        /* renamed from: b  reason: collision with root package name */
        public int f41545b;

        /* renamed from: c  reason: collision with root package name */
        public String f41546c;

        /* renamed from: d  reason: collision with root package name */
        public String f41547d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41548e;

        /* renamed from: f  reason: collision with root package name */
        public String f41549f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f41550g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f41551h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f41552i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f41553j;

        public boolean a(Object obj) {
            return obj instanceof Data;
        }

        public int b() {
            return this.f41545b;
        }

        public String c() {
            return this.f41546c;
        }

        public String d() {
            return this.f41549f;
        }

        public View.OnClickListener e() {
            return this.f41551h;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            if (!data.a(this) || h() != data.h() || b() != data.b()) {
                return false;
            }
            String c11 = c();
            String c12 = data.c();
            if (c11 != null ? !c11.equals(c12) : c12 != null) {
                return false;
            }
            String g11 = g();
            String g12 = data.g();
            if (g11 != null ? !g11.equals(g12) : g12 != null) {
                return false;
            }
            if (k() != data.k()) {
                return false;
            }
            String d11 = d();
            String d12 = data.d();
            if (d11 != null ? !d11.equals(d12) : d12 != null) {
                return false;
            }
            View.OnClickListener f11 = f();
            View.OnClickListener f12 = data.f();
            if (f11 != null ? !f11.equals(f12) : f12 != null) {
                return false;
            }
            View.OnClickListener e11 = e();
            View.OnClickListener e12 = data.e();
            if (e11 != null ? e11.equals(e12) : e12 == null) {
                return i() == data.i() && j() == data.j();
            }
            return false;
        }

        public View.OnClickListener f() {
            return this.f41550g;
        }

        public String g() {
            return this.f41547d;
        }

        public int h() {
            return this.f41544a;
        }

        public int hashCode() {
            int h11 = ((h() + 59) * 59) + b();
            String c11 = c();
            int i11 = 43;
            int hashCode = (h11 * 59) + (c11 == null ? 43 : c11.hashCode());
            String g11 = g();
            int i12 = 79;
            int hashCode2 = (((hashCode * 59) + (g11 == null ? 43 : g11.hashCode())) * 59) + (k() ? 79 : 97);
            String d11 = d();
            int hashCode3 = (hashCode2 * 59) + (d11 == null ? 43 : d11.hashCode());
            View.OnClickListener f11 = f();
            int hashCode4 = (hashCode3 * 59) + (f11 == null ? 43 : f11.hashCode());
            View.OnClickListener e11 = e();
            int i13 = hashCode4 * 59;
            if (e11 != null) {
                i11 = e11.hashCode();
            }
            int i14 = (((i13 + i11) * 59) + (i() ? 79 : 97)) * 59;
            if (!j()) {
                i12 = 97;
            }
            return i14 + i12;
        }

        public boolean i() {
            return this.f41552i;
        }

        public boolean j() {
            return this.f41553j;
        }

        public boolean k() {
            return this.f41548e;
        }

        public void l(boolean z11) {
            this.f41552i = z11;
        }

        public void m(boolean z11) {
            this.f41553j = z11;
        }

        public void n(int i11) {
            this.f41545b = i11;
        }

        public void o(String str) {
            this.f41546c = str;
        }

        public void p(String str) {
            this.f41549f = str;
        }

        public void q(View.OnClickListener onClickListener) {
            this.f41551h = onClickListener;
        }

        public void r(View.OnClickListener onClickListener) {
            this.f41550g = onClickListener;
        }

        public void s(boolean z11) {
            this.f41548e = z11;
        }

        public void t(String str) {
            this.f41547d = str;
        }

        public String toString() {
            return "StepRateItemCardView.Data(titleRes=" + h() + ", iconRes=" + b() + ", maker=" + c() + ", taker=" + g() + ", showDesc=" + k() + ", makerLabel=" + d() + ", onClickDescListener=" + f() + ", onClickCardListener=" + e() + ", hideMaker=" + i() + ", hideTaker=" + j() + ")";
        }

        public void u(int i11) {
            this.f41544a = i11;
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public View f41554a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f41555b;

        /* renamed from: c  reason: collision with root package name */
        public AppCompatTextView f41556c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f41557d;

        /* renamed from: e  reason: collision with root package name */
        public AppCompatTextView f41558e;

        /* renamed from: f  reason: collision with root package name */
        public View f41559f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f41560g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f41561h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f41562i;

        /* renamed from: j  reason: collision with root package name */
        public LinearLayout f41563j;

        /* renamed from: k  reason: collision with root package name */
        public LinearLayout f41564k;

        public a(View view) {
            this.f41554a = view;
            this.f41555b = (TextView) view.findViewById(R.id.tv_title);
            this.f41556c = (AppCompatTextView) view.findViewById(R.id.tv_trade_maker_rate);
            this.f41558e = (AppCompatTextView) view.findViewById(R.id.tv_trade_taker_rate);
            this.f41559f = view.findViewById(R.id.divider_trade_rate_desc);
            this.f41560g = (TextView) view.findViewById(R.id.tv_trade_fee_desc_more);
            this.f41561h = (RelativeLayout) view.findViewById(R.id.rl_trade_rate_desc);
            this.f41562i = (LinearLayout) view.findViewById(R.id.ll_trade_area);
            this.f41563j = (LinearLayout) view.findViewById(R.id.ll_maker);
            this.f41564k = (LinearLayout) view.findViewById(R.id.ll_taker);
            this.f41557d = (TextView) view.findViewById(R.id.tv_maker_label);
        }
    }

    public StepRateItemCardView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f41543c = context;
        LayoutInflater.from(context).inflate(R.layout.item_step_rate_card, this);
        this.f41542b = new a(this);
    }

    @SuppressLint({"ResourceType"})
    public void b(Data data) {
        if (f(data)) {
            Drawable drawable = this.f41543c.getResources().getDrawable(data.f41545b);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.f41542b.f41555b.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f41542b.f41555b.setText(data.f41544a);
            if (!TextUtils.isEmpty(data.f41549f)) {
                this.f41542b.f41557d.setText(data.f41549f);
            }
            if (!TextUtils.isEmpty(data.f41546c)) {
                this.f41542b.f41556c.setText(data.f41546c);
            }
            if (!TextUtils.isEmpty(data.f41547d)) {
                this.f41542b.f41558e.setText(data.f41547d);
            }
            this.f41542b.f41563j.setVisibility(data.f41552i ? 8 : 0);
            this.f41542b.f41564k.setVisibility(data.f41553j ? 8 : 0);
            if (data.k()) {
                this.f41542b.f41559f.setVisibility(0);
                this.f41542b.f41561h.setVisibility(0);
            } else {
                this.f41542b.f41559f.setVisibility(8);
                this.f41542b.f41561h.setVisibility(8);
            }
            d(this.f41542b.f41556c);
            d(this.f41542b.f41558e);
            this.f41542b.f41562i.setOnClickListener(data.f41551h);
            this.f41542b.f41561h.setOnClickListener(data.f41550g);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public final void c(AppCompatTextView appCompatTextView) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.global_text_size_10);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.global_text_size_20);
        appCompatTextView.setTextSize((float) dimensionPixelSize2);
        appCompatTextView.setAutoSizeTextTypeUniformWithConfiguration(dimensionPixelSize, dimensionPixelSize2, 1, 0);
        appCompatTextView.setTypeface(ResourcesCompat.h(appCompatTextView.getContext(), R.font.roboto_medium));
    }

    public final void d(AppCompatTextView appCompatTextView) {
        CharSequence text = appCompatTextView.getText();
        if (!TextUtils.isEmpty(text)) {
            if (Pattern.compile("^[\\d.%-]*$").matcher(text).find()) {
                e(appCompatTextView);
            } else {
                c(appCompatTextView);
            }
        }
    }

    @SuppressLint({"RestrictedApi", "WrongConstant"})
    public final void e(AppCompatTextView appCompatTextView) {
        appCompatTextView.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.global_text_size_24));
        appCompatTextView.setAutoSizeTextTypeWithDefaults(0);
    }

    public final boolean f(Data data) {
        return (data == null || data.f41544a == 0 || data.f41545b == 0) ? false : true;
    }

    public StepRateItemCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public StepRateItemCardView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
