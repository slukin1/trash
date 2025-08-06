package com.huobi.finance.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.sharesdk.framework.InnerShareParams;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.finance.utils.DepositWithdrawHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.io.Serializable;
import pro.huobi.R;

public class OldCurrencyDepositFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TextView f46671b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f46672c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f46673d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46674e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46675f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46676g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46677h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46678i;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(this.f46675f.getText(), this.f46675f.getText()));
        HuobiToastUtil.t(getActivity(), R.string.currency_deposit_copied);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if (getActivity() instanceof UnifyDepositActivity) {
            ((UnifyDepositActivity) getActivity()).Mh(true);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        this.f46677h.setOnClickListener(new x6(this));
        this.f46676g.setOnClickListener(new w6(this));
        this.f46674e.setOnClickListener(new v6(this));
    }

    public void afterInit() {
    }

    public int getAnimationStyle() {
        return R.style.menu_animation;
    }

    public int getContentViewResId() {
        return R.layout.layout_dialog_deposit_old_addr;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        String str;
        this.f46671b = (TextView) rVar.b(R.id.tv_old_currency_deposit_title);
        this.f46672c = (TextView) rVar.b(R.id.tv_old_currency_deposit_hint);
        this.f46673d = (ImageView) rVar.b(R.id.iv_currency_deposit_oldqr);
        this.f46674e = (TextView) rVar.b(R.id.tv_currency_deposit_copy_oldqr);
        this.f46675f = (TextView) rVar.b(R.id.tv_currency_deposit_old_address);
        this.f46676g = (TextView) rVar.b(R.id.tv_currency_deposit_old_address_copy);
        this.f46678i = (TextView) rVar.b(R.id.deposit_hint_tv);
        this.f46677h = (TextView) rVar.b(R.id.tv_currency_deposit_old_ok);
        Bundle arguments = getArguments();
        String string = arguments.getString(InnerShareParams.ADDRESS);
        if (!TextUtils.isEmpty(string)) {
            this.f46675f.setText(string);
        }
        Bitmap bitmap = (Bitmap) arguments.getParcelable("bitmap");
        if (bitmap != null) {
            this.f46673d.setImageBitmap(bitmap);
        }
        String string2 = arguments.getString("coin");
        Serializable serializable = arguments.getSerializable("oldcoinname");
        ChainInfo chainInfo = serializable instanceof ChainInfo ? (ChainInfo) serializable : null;
        String a11 = DepositWithdrawHelper.a(chainInfo);
        if (!TextUtils.isEmpty(string2)) {
            if (!TextUtils.isEmpty(a11)) {
                str = String.format(getResources().getString(R.string.old_currency_deposit_title_18t_coin), new Object[]{StringUtils.i(a11)});
            } else {
                str = String.format(getResources().getString(R.string.old_currency_deposit_title_coin), new Object[]{StringUtils.i(string2)});
            }
            this.f46671b.setText(str);
        }
        this.f46672c.setText(DepositWithdrawHelper.k(chainInfo));
        if (chainInfo != null) {
            this.f46678i.setVisibility(0);
            this.f46678i.setText(DepositWithdrawHelper.d(chainInfo));
        }
    }

    public boolean isTransparent() {
        return false;
    }
}
