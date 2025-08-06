package com.huobi.otc.handler;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.AlphaAnimTextView;
import com.hbg.lib.widgets.RotateAnimTextView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.bean.OtcOneKeyBuyConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import i6.r;
import up.f;

public class EasyTradeOtc implements s9.c {

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f78701b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ RotateAnimTextView f78702c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ads f78703d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditText f78704e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AlphaAnimTextView f78705f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f78706g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f78707h;

        public a(TextView textView, RotateAnimTextView rotateAnimTextView, Ads ads, EditText editText, AlphaAnimTextView alphaAnimTextView, String str, String str2) {
            this.f78701b = textView;
            this.f78702c = rotateAnimTextView;
            this.f78703d = ads;
            this.f78704e = editText;
            this.f78705f = alphaAnimTextView;
            this.f78706g = str;
            this.f78707h = str2;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            Application b11 = BaseApplication.b();
            int i11 = R$string.n_otc_buy_coin_by_amount;
            if (b11.getString(i11).equals(this.f78701b.getText())) {
                this.f78701b.setText(BaseApplication.b().getString(R$string.n_otc_buy_coin_by_money));
                this.f78702c.d(this.f78703d.getOtcOneKeyBuyConfig().getCoinName());
                this.f78704e.setText("");
                this.f78705f.setVisibility(0);
                this.f78705f.c(BaseApplication.b().getString(R$string.otc_buy_all_coin));
            } else {
                this.f78704e.setText("");
                this.f78702c.d(BaseApplication.b().getString(R$string.otc_cny));
                this.f78701b.setText(BaseApplication.b().getString(i11));
                this.f78705f.setVisibility(0);
                AlphaAnimTextView alphaAnimTextView = this.f78705f;
                alphaAnimTextView.c(this.f78706g + Constants.WAVE_SEPARATOR + this.f78707h);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ v9.c f78709b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TextView f78710c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EditText f78711d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ads f78712e;

        public b(v9.c cVar, TextView textView, EditText editText, Ads ads) {
            this.f78709b = cVar;
            this.f78710c = textView;
            this.f78711d = editText;
            this.f78712e = ads;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (!OtcModuleConfig.a().a()) {
                OtcModuleConfig.a().l((Activity) this.f78709b.itemView.getContext(), (Intent) null, (Intent) null);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            boolean equals = BaseApplication.b().getString(R$string.n_otc_buy_coin_by_amount).equals(this.f78710c.getText());
            String obj = this.f78711d.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                if (!equals) {
                    HuobiToastUtil.j(R$string.otc_please_input_amount_tip);
                } else {
                    HuobiToastUtil.j(R$string.otc_please_input_money_tip);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            this.f78712e.getOnClickOneKeyToBuyListener().o9(MapParamsBuilder.c().a("coinId", Integer.valueOf(this.f78712e.getOtcOneKeyBuyConfig().getCoinId())).a("currencyId", 1).a(equals ? "amount" : FirebaseAnalytics.Param.QUANTITY, obj).b(), this.f78712e);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EditText f78714b;

        public c(EditText editText) {
            this.f78714b = editText;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || OtcModuleConfig.a().a()) {
                return false;
            }
            OtcModuleConfig.a().l(EasyTradeOtc.this.e(this.f78714b), (Intent) null, (Intent) null);
            return true;
        }
    }

    public class d implements View.OnFocusChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f78716b;

        public d(RelativeLayout relativeLayout) {
            this.f78716b = relativeLayout;
        }

        public void onFocusChange(View view, boolean z11) {
            if (z11) {
                RelativeLayout relativeLayout = this.f78716b;
                relativeLayout.setBackground(ContextCompat.getDrawable(relativeLayout.getContext(), R$drawable.otc_one_tobuy_divider));
                return;
            }
            RelativeLayout relativeLayout2 = this.f78716b;
            relativeLayout2.setBackground(ContextCompat.getDrawable(relativeLayout2.getContext(), R$drawable.otc_one_tobuy_unseleted_divider));
        }
    }

    public class e implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AlphaAnimTextView f78718b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TextView f78719c;

        public e(AlphaAnimTextView alphaAnimTextView, TextView textView) {
            this.f78718b = alphaAnimTextView;
            this.f78719c = textView;
        }

        public void afterTextChanged(Editable editable) {
            if (BaseApplication.b().getString(R$string.n_otc_buy_coin_by_amount).equals(this.f78719c.getText())) {
                EasyTradeOtc.this.d(editable, 6, 2);
            } else {
                EasyTradeOtc.this.d(editable, 5, 6);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (charSequence.length() > 0) {
                this.f78718b.setVisibility(8);
            } else {
                this.f78718b.setVisibility(0);
            }
        }
    }

    public final void d(Editable editable, int i11, int i12) {
        String obj = editable.toString();
        if (obj.startsWith("00")) {
            editable.delete(0, 1);
            obj = editable.toString();
        }
        if (obj.startsWith(InstructionFileId.DOT)) {
            editable.delete(0, 1);
            obj = editable.toString();
        }
        if (obj.startsWith("0") && obj.length() == 2 && obj.toCharArray()[1] != '0' && obj.toCharArray()[1] != '.') {
            editable.delete(0, 1);
            obj = editable.toString();
        }
        if (obj.contains(InstructionFileId.DOT)) {
            try {
                if (obj.split("\\.")[1].length() > i12) {
                    editable.delete(editable.length() - 1, editable.length());
                    obj = editable.toString();
                }
                if (obj.split("\\.")[0].length() > i11) {
                    editable.delete(i11, i11 + 1);
                }
            } catch (Exception unused) {
            }
        } else if (obj.length() > i11) {
            editable.delete(editable.length() - 1, editable.length());
        }
    }

    public final Activity e(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    /* renamed from: f */
    public void handleView(v9.c cVar, int i11, Ads ads, ViewGroup viewGroup) {
        r e11 = cVar.e();
        EditText editText = (EditText) e11.b(R$id.money_count);
        TextView textView = (TextView) e11.b(R$id.buy_model_text);
        RelativeLayout relativeLayout = (RelativeLayout) e11.b(R$id.input_rl);
        View b11 = e11.b(R$id.buy_model_ll);
        RelativeLayout relativeLayout2 = (RelativeLayout) e11.b(R$id.buy_rl);
        RelativeLayout relativeLayout3 = (RelativeLayout) e11.b(R$id.empty_rl);
        AlphaAnimTextView alphaAnimTextView = (AlphaAnimTextView) e11.b(R$id.text_hint);
        RotateAnimTextView rotateAnimTextView = (RotateAnimTextView) e11.b(R$id.pay_flag);
        editText.setImeOptions(6);
        OtcOneKeyBuyConfig otcOneKeyBuyConfig = ads.getOtcOneKeyBuyConfig();
        f6.c.a().f((ImageView) e11.b(R$id.coin_logo), f.b().c(otcOneKeyBuyConfig.getCoinName()), R$drawable.coin_default_icon);
        if (otcOneKeyBuyConfig.isShowEmptyPic()) {
            relativeLayout3.setVisibility(0);
        } else {
            relativeLayout3.setVisibility(8);
        }
        alphaAnimTextView.setVisibility(0);
        Application b12 = BaseApplication.b();
        int i12 = R$string.otc_limit_price;
        String format = String.format(b12.getString(i12), new Object[]{String.valueOf(otcOneKeyBuyConfig.getMinAmount())});
        String format2 = String.format(BaseApplication.b().getString(i12), new Object[]{String.valueOf(otcOneKeyBuyConfig.getMaxAmount())});
        if (BaseApplication.b().getString(R$string.n_otc_buy_coin_by_amount).equals(textView.getText())) {
            alphaAnimTextView.c(format + Constants.WAVE_SEPARATOR + format2);
        }
        editText.setText("");
        RelativeLayout relativeLayout4 = relativeLayout;
        a aVar = r0;
        a aVar2 = new a(textView, rotateAnimTextView, ads, editText, alphaAnimTextView, format, format2);
        b11.setOnClickListener(aVar);
        relativeLayout2.setOnClickListener(new b(cVar, textView, editText, ads));
        editText.setOnTouchListener(new c(editText));
        editText.setOnFocusChangeListener(new d(relativeLayout4));
        editText.addTextChangedListener(new e(alphaAnimTextView, textView));
    }

    public int getResId() {
        return R$layout.item_easy_trade;
    }
}
