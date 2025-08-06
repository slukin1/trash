package com.huobi.feature.ui.dialog;

import a7.e;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huobi.contract.entity.ContractOrderTimingRequestData;
import com.huobi.feature.util.TimeSharingOrderHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import pro.huobi.R;

public class TimeSharingOrderConfirmDialog extends BaseDialogFragment implements TimeSharingOrderHelper.b {

    /* renamed from: b  reason: collision with root package name */
    public ContractOrderTimingRequestData f45049b;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        uh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismissAllowingStateLoss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static TimeSharingOrderConfirmDialog vh(ContractOrderTimingRequestData contractOrderTimingRequestData) {
        TimeSharingOrderConfirmDialog timeSharingOrderConfirmDialog = new TimeSharingOrderConfirmDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable(RemoteMessageConst.MessageBody.PARAM, contractOrderTimingRequestData);
        timeSharingOrderConfirmDialog.setArguments(bundle);
        return timeSharingOrderConfirmDialog;
    }

    public void Af() {
    }

    public void addEvent(r rVar) {
        rVar.b(R.id.dialog_confirm_button).setOnClickListener(new g(this));
        rVar.b(R.id.iv_close).setOnClickListener(new h(this));
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R.layout.dialog_time_sharing_order_confirm;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        int i11;
        Resources resources;
        r rVar2 = rVar;
        this.f45049b = (ContractOrderTimingRequestData) getArguments().getSerializable(RemoteMessageConst.MessageBody.PARAM);
        TextView textView = (TextView) rVar2.b(R.id.tv_value_type);
        TextView textView2 = (TextView) rVar2.b(R.id.tv_key_timing_taker_open_distance);
        TextView textView3 = (TextView) rVar2.b(R.id.tv_value_timing_taker_open_distance);
        TextView textView4 = (TextView) rVar2.b(R.id.tv_value_timing_taker_price_limit);
        TextView textView5 = (TextView) rVar2.b(R.id.tv_value_timing_interval);
        TextView textView6 = (TextView) rVar2.b(R.id.tv_value_timing_one_order_amount);
        TextView textView7 = (TextView) rVar2.b(R.id.tv_value_timing_order_total_amount);
        int i12 = TextUtils.equals(FutureContractInfo.MARGIN_CROSS, this.f45049b.getMarginMode()) ? 1 : 2;
        int priceIntervalMode = this.f45049b.getPriceIntervalMode();
        double priceInterval = this.f45049b.getPriceInterval();
        if (priceIntervalMode == 1) {
            textView3.setText((priceInterval * 100.0d) + "%");
            textView2.setText(getResources().getString(R.string.n_exchange_timing_taker_price_range_ratio));
        } else {
            textView2.setText(getResources().getString(R.string.n_exchange_timing_taker_open_distance));
            textView3.setText(String.format("%s %s", new Object[]{m.a(String.valueOf(this.f45049b.getPriceInterval())).toPlainString(), this.f45049b.getQuoteCurrency()}));
        }
        if (TextUtils.equals(this.f45049b.getDirection(), "buy")) {
            resources = getResources();
            i11 = R.string.string_bid;
        } else {
            resources = getResources();
            i11 = R.string.string_ask;
        }
        String string = resources.getString(i11);
        textView.setText(e.m(getContext(), this.f45049b.getSymbol(), this.f45049b.getQuoteCurrency(), this.f45049b.getContractCode(), this.f45049b.getContractType(), i12) + (" " + this.f45049b.getLevelRate() + "X " + string));
        textView4.setText(String.format("%s %s", new Object[]{m.a(String.valueOf(this.f45049b.getPriceLimit())).toPlainString(), this.f45049b.getQuoteCurrency()}));
        textView5.setText(this.f45049b.getTimeInterval() + " " + getResources().getString(R.string.n_exchange_timing_second));
        textView6.setText(this.f45049b.getDisplayUnitVolume() + " " + this.f45049b.getDisplayUnitName());
        textView7.setText(this.f45049b.getDisplayTotalVolume() + " " + this.f45049b.getDisplayUnitName());
    }

    public boolean isTransparent() {
        return false;
    }

    public final void uh() {
        TimeSharingOrderHelper.b(getContext(), this.f45049b, this);
    }

    public void v4() {
        dismissAllowingStateLoss();
    }
}
