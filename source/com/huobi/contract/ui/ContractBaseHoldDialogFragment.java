package com.huobi.contract.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.feature.util.FutureTpSlHelper;
import com.xiaomi.mipush.sdk.Constants;
import i6.r;
import java.util.ArrayList;
import pro.huobi.R;

public abstract class ContractBaseHoldDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public CommonTextListIndicator f43192b;

    /* renamed from: c  reason: collision with root package name */
    public View f43193c;

    /* renamed from: d  reason: collision with root package name */
    public View f43194d;

    /* renamed from: e  reason: collision with root package name */
    public FutureTpSlHelper f43195e;

    /* renamed from: f  reason: collision with root package name */
    public FutureTpSlHelper f43196f;

    /* renamed from: g  reason: collision with root package name */
    public int f43197g = 0;

    public class a implements CommonTextListIndicator.b {
        public a() {
        }

        public void a(int i11, View view) {
        }

        public void onItemClick(int i11) {
            ContractBaseHoldDialogFragment.this.wh(i11, 4);
        }
    }

    public void dismiss() {
        th();
        super.dismiss();
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.dialog_contract_position_stop_trade;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f43193c = rVar.b(R.id.tab_first_parent);
        this.f43194d = rVar.b(R.id.tab_second_parent);
        CommonTextListIndicator commonTextListIndicator = (CommonTextListIndicator) rVar.b(R.id.common_text_list_indicator);
        this.f43192b = commonTextListIndicator;
        commonTextListIndicator.setCallback(new a());
        ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R.string.n_contract_position_tab_first));
        arrayList.add(getResources().getString(R.string.n_contract_position_tab_second));
        this.f43192b.setDataList(arrayList);
        String string = getResources().getString(R.string.n_contract_tpsl_loss_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + getResources().getString(R.string.n_contract_hold_dialog_tpsl_tips));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.color_FE8731)), string.length(), spannableStringBuilder.length(), 33);
        ((TextView) rVar.b(R.id.tv_hold_dialog_tpsl_tips)).setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string + getResources().getString(R.string.n_contract_hold_dialog_position_tpsl_tips));
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.color_FE8731)), string.length(), spannableStringBuilder2.length(), 33);
        ((TextView) rVar.b(R.id.hold_dialog_position_tpsl_tips)).setText(spannableStringBuilder2);
        this.f43195e.I0((ViewGroup) rVar.b(R.id.ll_tpsl_content), this, false);
        this.f43195e.Q0(this);
        this.f43196f.I0((ViewGroup) rVar.b(R.id.all_ll_tpsl_content), this, false);
        this.f43196f.Q0(this);
        this.f43196f.C1();
    }

    public boolean isTransparent() {
        return false;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vh();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.f43195e.k0();
        this.f43196f.k0();
    }

    public void onStart() {
        super.onStart();
        this.f43195e.u1();
    }

    public String sh(String str, String str2) {
        if (this.f43197g == 1) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2;
            } else if (!TextUtils.isEmpty(str)) {
                return str;
            } else {
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            }
        }
        return "";
    }

    public void th() {
        View findFocus;
        if (getView() != null && (findFocus = getView().findFocus()) != null) {
            SoftInputUtils.g(getActivity(), findFocus);
        }
    }

    public void uh() {
        th();
        this.f43195e.h0();
        this.f43196f.h0();
    }

    public abstract void vh();

    public void wh(int i11, int i12) {
        this.f43197g = i11;
        this.f43192b.c(i11);
        this.f43192b.b(i11, 0.0f, 0);
        if (this.f43197g == 0) {
            this.f43193c.setVisibility(0);
            this.f43194d.setVisibility(i12);
            return;
        }
        this.f43193c.setVisibility(i12);
        this.f43194d.setVisibility(0);
    }
}
