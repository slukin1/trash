package com.huobi.share.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.zxing.WriterException;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.utils.ImageUtils;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import pro.huobi.R;

public class OtcOptionsShareFragment extends ImageShareFragment {
    public View J;
    public TextView K;
    public ImageView L;
    public TextView M;
    public TextView N;
    public TextView O;
    public TextView P;
    public TextView Q;
    public TextView R;
    public TextView S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;

    /* renamed from: a0  reason: collision with root package name */
    public BigDecimal f80970a0 = BigDecimal.valueOf(1.5d);

    /* renamed from: b0  reason: collision with root package name */
    public BigDecimal f80971b0 = BigDecimal.valueOf(2.5d);

    /* renamed from: c0  reason: collision with root package name */
    public BigDecimal f80972c0 = BigDecimal.valueOf(3.5d);

    /* renamed from: d0  reason: collision with root package name */
    public BigDecimal f80973d0 = BigDecimal.valueOf(4.5d);

    /* renamed from: e0  reason: collision with root package name */
    public BigDecimal f80974e0 = BigDecimal.valueOf(100);

    /* renamed from: f0  reason: collision with root package name */
    public ImageView f80975f0;

    /* renamed from: g0  reason: collision with root package name */
    public TextView f80976g0;

    /* renamed from: h0  reason: collision with root package name */
    public String f80977h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f80978i0;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public float f80979b;

        /* renamed from: c  reason: collision with root package name */
        public float f80980c = -0.25f;

        /* renamed from: d  reason: collision with root package name */
        public float f80981d = 1.25f;

        /* renamed from: e  reason: collision with root package name */
        public float f80982e;

        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() instanceof Float) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f80979b = floatValue;
                this.f80982e = this.f80981d + (this.f80980c * floatValue);
                OtcOptionsShareFragment.this.J.setAlpha(this.f80979b);
                OtcOptionsShareFragment.this.J.setScaleX(this.f80982e);
                OtcOptionsShareFragment.this.J.setScaleY(this.f80982e);
            }
        }
    }

    public void Bh() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new a());
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new b6.a(0.0d, 0.0d, 0.58d, 1.0d));
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f80874h, View.TRANSLATION_Y, new float[]{300.0f, 0.0f});
        ofFloat2.setDuration(300);
        ofFloat2.start();
    }

    public void Zh() {
    }

    public final void fi() {
        if (this.T != null && getActivity() != null) {
            this.K.setText(this.U);
            this.L.setImageResource(hi(this.Z));
            this.M.setText(this.T);
            gi(this.Z);
            this.O.setText(this.W);
            this.P.setText(this.V);
            this.Q.setText(this.Y);
            this.R.setText(this.X);
            this.S.setText(DateTimeUtils.h(System.currentTimeMillis(), "MM/dd HH:mm:ss"));
            this.f80976g0.setText(this.f80977h0);
            float g11 = ((float) PixelUtils.g()) - (getResources().getDimension(R.dimen.dimen_37_5) * 2.0f);
            float dimension = getResources().getDimension(R.dimen.dimen_55);
            if (Float.compare(Wh(), 0.0f) > 0) {
                float Wh = Wh() * g11;
                ViewGroup.LayoutParams layoutParams = this.f80975f0.getLayoutParams();
                layoutParams.height = (int) Wh;
                this.f80975f0.setLayoutParams(layoutParams);
            }
            String Vh = Vh();
            if (!TextUtils.isEmpty(this.f80978i0)) {
                Vh = this.f80978i0;
            }
            try {
                this.f80975f0.setImageBitmap(ImageUtils.c(Vh, (int) dimension));
            } catch (WriterException e11) {
                e11.printStackTrace();
            }
        }
    }

    public int getContentViewResId() {
        return R.layout.activity_otc_options_share;
    }

    public final void gi(String str) {
        BigDecimal a11 = m.a(str);
        if (a11.compareTo(BigDecimal.ZERO) <= 0) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("0.00%");
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(50, true), 0, 1, 17);
            this.N.setText(spannableStringBuilder);
            this.N.setTextColor(ContextCompat.getColor(getContext(), R.color.share_contract_main_text_color));
            return;
        }
        BigDecimal multiply = a11.multiply(this.f80974e0);
        String str2 = "+" + m.s(multiply, 2, false, multiply.toPlainString()) + "%";
        this.N.setTextColor(ContextCompat.getColor(getContext(), R.color.share_otc_options_up_text_color));
        int indexOf = str2.indexOf(InstructionFileId.DOT);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str2);
        if (indexOf != -1) {
            spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(50, true), 1, indexOf, 18);
        }
        this.N.setText(spannableStringBuilder2);
    }

    public final int hi(String str) {
        BigDecimal a11 = m.a(str);
        if (a11.compareTo(this.f80970a0) <= 0) {
            return R.drawable.share_otc_options_img1;
        }
        if (a11.compareTo(this.f80971b0) <= 0) {
            return R.drawable.share_otc_options_img2;
        }
        if (a11.compareTo(this.f80972c0) <= 0) {
            return R.drawable.share_otc_options_img3;
        }
        return a11.compareTo(this.f80973d0) <= 0 ? R.drawable.share_otc_options_img4 : R.drawable.share_otc_options_img5;
    }

    public void ii(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.T = str;
        this.U = str2;
        this.V = str3;
        this.W = str4;
        this.X = str5;
        this.Y = str6;
        this.Z = str7;
        this.f80977h0 = str8;
        this.f80978i0 = str9;
    }

    public void initView(r rVar) {
        super.initView(rVar);
        this.J = rVar.b(R.id.share_img_root);
        this.K = (TextView) rVar.b(R.id.tv_share_product_title);
        this.L = (ImageView) rVar.b(R.id.iv_share_img);
        this.M = (TextView) rVar.b(R.id.tv_share_text);
        this.N = (TextView) rVar.b(R.id.tv_share_income_rate);
        this.O = (TextView) rVar.b(R.id.tv_share_price_title);
        this.P = (TextView) rVar.b(R.id.tv_share_price);
        this.Q = (TextView) rVar.b(R.id.tv_share_settle_price_title);
        this.R = (TextView) rVar.b(R.id.tv_share_settle_price);
        this.S = (TextView) rVar.b(R.id.tv_share_time);
        this.J.setVisibility(0);
        this.f80975f0 = (ImageView) rVar.b(R.id.iv_otc_options_qrcode);
        this.f80976g0 = (TextView) rVar.b(R.id.tv_otc_options_content);
        fi();
    }
}
