package com.huobi.staring.adapter;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.MutableLiveData;
import as.d;
import as.e;
import as.f;
import as.g;
import as.h;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.b;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.staring.bean.StareInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import kotlin.Unit;
import pro.huobi.R;
import s9.c;

public class StareConfigListViewHandler implements c {

    public class a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EditText f81160b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ImageView f81161c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ImageView f81162d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f81163e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ StareInfo f81164f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ImageView f81165g;

        public a(EditText editText, ImageView imageView, ImageView imageView2, TextView textView, StareInfo stareInfo, ImageView imageView3) {
            this.f81160b = editText;
            this.f81161c = imageView;
            this.f81162d = imageView2;
            this.f81163e = textView;
            this.f81164f = stareInfo;
            this.f81165g = imageView3;
        }

        public void afterTextChanged(Editable editable) {
            int i11;
            String obj = this.f81160b.getText().toString();
            if (obj.equals("0")) {
                this.f81160b.setText("1");
            } else if (obj.length() <= 1 || !obj.startsWith("0")) {
                try {
                    i11 = Integer.parseInt(obj);
                } catch (Exception e11) {
                    e11.printStackTrace();
                    i11 = 1;
                }
                if (i11 == 1) {
                    this.f81161c.setImageResource(R.drawable.icon_stare_minus_gray);
                    this.f81162d.setImageResource(R.drawable.icon_stare_plus_normal);
                } else if (i11 == 999999) {
                    this.f81161c.setImageResource(R.drawable.icon_stare_minus_normal);
                    this.f81162d.setImageResource(R.drawable.icon_stare_plus_gray);
                } else {
                    this.f81161c.setImageResource(R.drawable.icon_stare_minus_normal);
                    this.f81162d.setImageResource(R.drawable.icon_stare_plus_normal);
                }
                this.f81163e.setText(StareConfigListViewHandler.this.h(this.f81164f.getBusinessType(), this.f81164f.getPrice(), this.f81164f.getSymbol(), ((double) i11) / 100.0d));
                if (b.x(obj) || this.f81164f.getRate() == i11) {
                    this.f81165g.setEnabled(false);
                    this.f81165g.setImageResource(R.drawable.icon_stare_change_btn_gray);
                    return;
                }
                this.f81165g.setImageResource(R.drawable.icon_stare_change_btn_blue);
                this.f81165g.setEnabled(true);
            } else {
                this.f81160b.setText(obj.replaceFirst("0", ""));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void j(StareInfo stareInfo, int i11, SwitchCompat switchCompat, View view) {
        stareInfo.getStatusChangeListener().a(i11, stareInfo.getStrategyId(), switchCompat.isChecked());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void k(EditText editText, ImageView imageView, ImageView imageView2, View view) {
        String obj = editText.getText().toString();
        if (b.x(obj)) {
            obj = "1";
        }
        int parseInt = Integer.parseInt(obj);
        if (parseInt > 1) {
            parseInt--;
        } else {
            imageView.setImageResource(R.drawable.icon_stare_minus_gray);
        }
        imageView2.setImageResource(R.drawable.icon_stare_plus_normal);
        editText.setText(String.valueOf(parseInt));
        editText.clearFocus();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void l(EditText editText, ImageView imageView, ImageView imageView2, View view) {
        String obj = editText.getText().toString();
        if (b.x(obj)) {
            obj = "1";
        }
        int parseInt = Integer.parseInt(obj);
        if (parseInt < 999999) {
            editText.setText(String.valueOf(parseInt + 1));
        } else {
            imageView.setImageResource(R.drawable.icon_stare_plus_gray);
        }
        imageView2.setImageResource(R.drawable.icon_stare_minus_normal);
        editText.clearFocus();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ Unit m(EditText editText, StareInfo stareInfo, int i11, com.hbg.lib.network.hbg.core.bean.StareInfo stareInfo2) {
        editText.clearFocus();
        stareInfo.setRate(stareInfo2.getRate());
        stareInfo.setDescription(stareInfo2.getDescription());
        HuobiToastUtil.g(R.string.save_success);
        stareInfo.getStatusChangeListener().b(i11);
        return null;
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void o(EditText editText, StareInfo stareInfo, int i11, View view) {
        try {
            RequestExtKt.c(v7.b.a().H(stareInfo.getSymbol(), String.valueOf(stareInfo.getStrategyId()), Double.valueOf(Double.parseDouble(editText.getText().toString()))), new g(editText, stareInfo, i11), h.f12209b, (MutableLiveData) null);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getResId() {
        return R.layout.item_stare_config;
    }

    public String h(RemindBusinessType remindBusinessType, String str, String str2, double d11) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            if (remindBusinessType != null) {
                try {
                    str3 = LegalCurrencyConfigUtil.B(str);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            } else if (TextUtils.isEmpty(str2) || !a1.v().D(str2).equalsIgnoreCase("usdt")) {
                str3 = LegalCurrencyConfigUtil.A(str, str2, TradeType.PRO);
            } else {
                str3 = LegalCurrencyConfigUtil.B(str);
            }
            return "≈ " + LegalCurrencyConfigUtil.w() + p(m.h0(str3), d11);
        }
        return "≈ " + LegalCurrencyConfigUtil.w() + IdManager.DEFAULT_VERSION_NAME;
    }

    /* renamed from: i */
    public void handleView(v9.c cVar, int i11, StareInfo stareInfo, ViewGroup viewGroup) {
        int i12 = i11;
        StareInfo stareInfo2 = stareInfo;
        r e11 = cVar.e();
        SwitchCompat switchCompat = (SwitchCompat) e11.b(R.id.scSwitch);
        LinearLayout linearLayout = (LinearLayout) e11.b(R.id.llChangeLay);
        EditText editText = (EditText) e11.b(R.id.etPercent);
        ImageView imageView = (ImageView) e11.b(R.id.ivMinus);
        ImageView imageView2 = (ImageView) e11.b(R.id.ivPlus);
        ImageView imageView3 = (ImageView) e11.b(R.id.ivChangeBtn);
        TextView textView = (TextView) e11.b(R.id.tvLegalCurrency);
        ((TextView) e11.b(R.id.tvStareName)).setText(stareInfo.getStrategyName());
        ((TextView) e11.b(R.id.tvStareDesc)).setText(stareInfo.getDescription());
        switchCompat.setChecked(stareInfo.getStatus() == 1);
        switchCompat.setOnClickListener(new f(stareInfo2, i12, switchCompat));
        if (stareInfo.getIsSupport() == 1 && stareInfo.getStatus() == 1) {
            linearLayout.setVisibility(0);
            textView.setVisibility(0);
            imageView.setImageResource(stareInfo.getRate() > 1 ? R.drawable.icon_stare_minus_normal : R.drawable.icon_stare_minus_gray);
            imageView2.setImageResource(stareInfo.getRate() < 999999 ? R.drawable.icon_stare_plus_normal : R.drawable.icon_stare_plus_gray);
            editText.addTextChangedListener(new a(editText, imageView, imageView2, textView, stareInfo, imageView3));
            editText.setText(String.valueOf(stareInfo.getRate()));
            imageView.setOnClickListener(new d(editText, imageView, imageView2));
            imageView2.setOnClickListener(new as.c(editText, imageView2, imageView));
            imageView3.setOnClickListener(new e(editText, stareInfo2, i12));
            return;
        }
        linearLayout.setVisibility(8);
        textView.setVisibility(8);
    }

    public final String p(double d11, double d12) {
        return new BigDecimal(Double.toString(d11)).multiply(new BigDecimal(Double.toString(d12))).toPlainString();
    }
}
