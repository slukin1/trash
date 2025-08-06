package com.huobi.trade.ui;

import android.os.Bundle;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.trade.bean.TradeTimeInfo;
import com.huobi.trade.engine.TradeDataParser;
import com.huobi.trade.engine.TradeNativeAbility;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConstants;
import i6.r;
import java.lang.ref.WeakReference;
import nk.a;
import pro.huobi.R;
import rj.b;

public class TradeTimeOrderFragment extends BaseDialogFragment implements a.C0579a {

    /* renamed from: b  reason: collision with root package name */
    public a f82465b;

    /* renamed from: c  reason: collision with root package name */
    public View f82466c;

    /* renamed from: d  reason: collision with root package name */
    public TradeTimeView f82467d;

    /* renamed from: e  reason: collision with root package name */
    public TradeTimeInfo f82468e;

    /* renamed from: f  reason: collision with root package name */
    public b f82469f;

    public interface a {
        void callback();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        doDismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static TradeTimeOrderFragment uh(TradeTimeInfo tradeTimeInfo) {
        TradeTimeOrderFragment tradeTimeOrderFragment = new TradeTimeOrderFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("FeatureTradeTimeInfo", tradeTimeInfo);
        tradeTimeOrderFragment.setArguments(bundle);
        return tradeTimeOrderFragment;
    }

    public void addEvent(r rVar) {
        this.f82466c.setOnClickListener(new k2(this));
    }

    public void afterInit() {
        setCanDismissOnBackPress(true);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void close() {
        doDismiss();
    }

    public void doDismiss() {
        super.doDismiss();
        a aVar = this.f82465b;
        if (aVar != null) {
            aVar.callback();
        }
        this.f82469f.B();
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.trade_time_order_layout;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f82466c = rVar.b(R.id.v_space);
        TradeTimeView tradeTimeView = (TradeTimeView) rVar.b(R.id.trade_layout);
        this.f82467d = tradeTimeView;
        tradeTimeView.setActivity(getActivity());
        this.f82468e = (TradeTimeInfo) getArguments().getSerializable("FeatureTradeTimeInfo");
        b bVar = new b(getActivity(), "tradetime");
        this.f82469f = bVar;
        bVar.t("trade", TradeNativeAbility.class);
        this.f82469f.z("trade_parser", TradeDataParser.class);
        this.f82469f.s(TUIConstants.TUIChat.FRAGMENT, new WeakReference(this));
        this.f82467d.setTradeTimeInfo(this.f82468e);
        this.f82467d.setEdgeEngine(this.f82469f);
    }

    public boolean isTransparent() {
        return false;
    }

    public void th(String str, String str2) {
        if (this.f82469f != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("availableOfBuy", (Object) str);
            jSONObject.put("availableOfSell", (Object) str2);
            b bVar = this.f82469f;
            bVar.I("updateAssetAvailable('" + jSONObject.toJSONString() + "')");
        }
    }

    public void vh(String str, boolean z11) {
        if (this.f82469f != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FirebaseAnalytics.Param.PRICE, (Object) str);
            jSONObject.put("rise", (Object) Integer.valueOf(z11 ? 1 : 0));
            b bVar = this.f82469f;
            bVar.I("updateLastPrice('" + jSONObject.toJSONString() + "')");
        }
    }
}
