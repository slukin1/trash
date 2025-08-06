package com.huobi.share.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import d7.a1;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.Random;
import pro.huobi.R;

public class StrategyShareFragment extends ImageShareFragment {
    public ImageView J;
    public TextView K;
    public TextView L;
    public TextView M;
    public TextView N;
    public TextView O;
    public TextView P;
    public TextView Q;
    public TextView R;
    public TextView S;
    public TextView T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;

    /* renamed from: a0  reason: collision with root package name */
    public String f80997a0;

    /* renamed from: b0  reason: collision with root package name */
    public View f80998b0;

    /* renamed from: c0  reason: collision with root package name */
    public View f80999c0;

    /* renamed from: d0  reason: collision with root package name */
    public View f81000d0;

    /* renamed from: e0  reason: collision with root package name */
    public Random f81001e0 = new Random();

    /* renamed from: f0  reason: collision with root package name */
    public TradeType f81002f0 = TradeType.CONTRACT;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public float f81003b;

        /* renamed from: c  reason: collision with root package name */
        public float f81004c = -0.25f;

        /* renamed from: d  reason: collision with root package name */
        public float f81005d = 1.25f;

        /* renamed from: e  reason: collision with root package name */
        public float f81006e;

        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() instanceof Float) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f81003b = floatValue;
                this.f81006e = this.f81005d + (this.f81004c * floatValue);
                StrategyShareFragment.this.f80998b0.setAlpha(this.f81003b);
                StrategyShareFragment.this.f80998b0.setScaleX(this.f81006e);
                StrategyShareFragment.this.f80998b0.setScaleY(this.f81006e);
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
        String str;
        int color = getResources().getColor(R.color.share_contract_main_text_color);
        String p11 = a1.v().p(this.U);
        String F = a1.v().F(this.U);
        this.K.setText(String.format("%s %s", new Object[]{p11 + "/" + F, getString(R.string.n_grid_grid_strategy)}));
        this.O.setText(getString(R.string.n_grid_trade_price_range_with_quote, F));
        this.P.setText(String.format("%s~%s", new Object[]{this.W, this.X}));
        this.R.setText(this.Z);
        this.T.setText(this.f80997a0);
        BigDecimal a11 = m.a(this.V);
        if (a11.compareTo(m.a("0.3")) > 0) {
            this.L.setText(getString(R.string.n_grid_share_title_1));
            this.M.setText(getString(R.string.n_grid_share_subtitle_1));
            this.J.setImageResource(R.drawable.share_bot_pic_1);
        } else if (a11.compareTo(BigDecimal.ZERO) < 0 || a11.compareTo(m.a("0.3")) > 0) {
            this.L.setText(getString(R.string.n_grid_share_title_3));
            this.M.setText(getString(R.string.n_grid_share_subtitle_3));
            this.J.setImageResource(R.drawable.share_bot_pic_3);
        } else {
            this.L.setText(getString(R.string.n_grid_share_title_2));
            this.M.setText(getString(R.string.n_grid_share_subtitle_2));
            this.J.setImageResource(R.drawable.share_bot_pic_2);
        }
        String q11 = m.q(a11.multiply(m.f68179a), 2);
        if (a11.compareTo(BigDecimal.ZERO) > 0) {
            str = "+" + q11 + "%";
        } else {
            str = q11 + "%";
        }
        int indexOf = str.indexOf(InstructionFileId.DOT);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (indexOf != -1) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(43, true), indexOf + 1, str.length(), 33);
        }
        if (a11.compareTo(BigDecimal.ZERO) > 0) {
            if (w.l()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.share_contract_down_text_color)), 0, spannableStringBuilder.length(), 33);
            } else {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.share_contract_up_text_color)), 0, spannableStringBuilder.length(), 33);
            }
        } else if (a11.compareTo(BigDecimal.ZERO) >= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 33);
        } else if (w.l()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.share_contract_up_text_color)), 0, spannableStringBuilder.length(), 33);
        } else {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.share_contract_down_text_color)), 0, spannableStringBuilder.length(), 33);
        }
        this.N.setText(spannableStringBuilder);
    }

    public int getContentViewResId() {
        return R.layout.activity_strategy_share;
    }

    public void gi(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.U = str;
        this.V = str2;
        this.W = str3;
        this.X = str4;
        this.Y = str5;
        this.Z = str6;
        this.f80997a0 = str7;
    }

    public void initView(r rVar) {
        super.initView(rVar);
        this.J = (ImageView) rVar.b(R.id.share_img);
        this.K = (TextView) rVar.b(R.id.tv_strategy_title);
        this.L = (TextView) rVar.b(R.id.share_img_contract_tip);
        this.M = (TextView) rVar.b(R.id.share_img_contract_profit_title);
        this.f81000d0 = rVar.b(R.id.price_container);
        this.N = (TextView) rVar.b(R.id.share_img_contract_profit);
        this.O = (TextView) rVar.b(R.id.tv_data_title1);
        this.P = (TextView) rVar.b(R.id.tv_data_value1);
        this.Q = (TextView) rVar.b(R.id.tv_data_title2);
        this.R = (TextView) rVar.b(R.id.tv_data_value2);
        this.S = (TextView) rVar.b(R.id.tv_data_title3);
        this.T = (TextView) rVar.b(R.id.tv_data_value3);
        this.f80999c0 = rVar.b(R.id.top_container);
        View b11 = rVar.b(R.id.share_img_root);
        this.f80998b0 = b11;
        b11.setVisibility(0);
        fi();
    }
}
