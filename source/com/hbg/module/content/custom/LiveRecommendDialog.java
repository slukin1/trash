package com.hbg.module.content.custom;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.Postcard;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.CommonPkData;
import com.hbg.lib.network.hbg.core.bean.LiveRecommendInfo;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$string;
import com.hbg.module.content.R$style;
import com.hbg.module.content.custom.H5FragmentDialog;
import com.hbg.module.content.ui.activity.live.LiveDetailActivity;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.io.Serializable;
import kotlin.jvm.internal.r;
import kotlin.l;
import lc.k0;
import rd.s;

public final class LiveRecommendDialog extends DialogFragment {

    /* renamed from: f  reason: collision with root package name */
    public static final a f18033f = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public int f18034b;

    /* renamed from: c  reason: collision with root package name */
    public String f18035c;

    /* renamed from: d  reason: collision with root package name */
    public FragmentManager f18036d;

    /* renamed from: e  reason: collision with root package name */
    public LiveRecommendInfo f18037e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final LiveRecommendDialog a(FragmentManager fragmentManager, LiveRecommendInfo liveRecommendInfo, int i11, String str) {
            Fragment fragment;
            if (fragmentManager == null) {
                return null;
            }
            try {
                FragmentTransaction q11 = fragmentManager.q();
                try {
                    fragment = fragmentManager.m0("LiveRecommendDialog");
                } catch (NullPointerException e11) {
                    e11.printStackTrace();
                    fragment = null;
                }
                if (fragment != null) {
                    q11.s(fragment);
                }
                LiveRecommendDialog liveRecommendDialog = new LiveRecommendDialog();
                liveRecommendDialog.f18036d = fragmentManager;
                Bundle bundle = new Bundle();
                bundle.putSerializable("recommendInfo", liveRecommendInfo);
                bundle.putInt("type", i11);
                bundle.putString("liveId", str);
                liveRecommendDialog.setArguments(bundle);
                q11.e(liveRecommendDialog, "LiveRecommendDialog");
                q11.k();
                return liveRecommendDialog;
            } catch (Exception e12) {
                e12.printStackTrace();
                return null;
            }
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18038b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18039c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveRecommendDialog f18040d;

        public b(View view, long j11, LiveRecommendDialog liveRecommendDialog) {
            this.f18038b = view;
            this.f18039c = j11;
            this.f18040d = liveRecommendDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18038b) > this.f18039c || (this.f18038b instanceof Checkable)) {
                sVar.e(this.f18038b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18038b;
                this.f18040d.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18041b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18042c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveRecommendDialog f18043d;

        public c(View view, long j11, LiveRecommendDialog liveRecommendDialog) {
            this.f18041b = view;
            this.f18042c = j11;
            this.f18043d = liveRecommendDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18041b) > this.f18042c || (this.f18041b instanceof Checkable)) {
                sVar.e(this.f18041b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18041b;
                nc.c.a("app_live_trader_contentpage_avatarclick", MapsKt__MapsKt.j(l.a("uid", BaseModuleConfig.a().getUid()), l.a("liveId", this.f18043d.f18035c)));
                Postcard a11 = b2.a.d().a("/webView/index");
                BaseModuleConfig.a a12 = BaseModuleConfig.a();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("tradingbot/h5/futures/trader-detail?login=1&userSign=");
                LiveRecommendInfo sh2 = this.f18043d.f18037e;
                sb2.append(sh2 != null ? sh2.userSign : null);
                a11.withString("url", a12.k(sb2.toString())).navigation(this.f18043d.getActivity());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18044b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18045c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveRecommendDialog f18046d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveRecommendInfo f18047e;

        public d(View view, long j11, LiveRecommendDialog liveRecommendDialog, LiveRecommendInfo liveRecommendInfo) {
            this.f18044b = view;
            this.f18045c = j11;
            this.f18046d = liveRecommendDialog;
            this.f18047e = liveRecommendInfo;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18044b) > this.f18045c || (this.f18044b instanceof Checkable)) {
                sVar.e(this.f18044b, currentTimeMillis);
                TextView textView = (TextView) this.f18044b;
                if (this.f18046d.f18034b == 0) {
                    nc.c.a("app_live_trader_contentpage_tradeclick", MapsKt__MapsKt.j(l.a("uid", BaseModuleConfig.a().getUid()), l.a("liveId", this.f18046d.f18035c)));
                    this.f18046d.dismiss();
                    H5FragmentDialog.a aVar = H5FragmentDialog.f18006e;
                    FragmentManager rh2 = this.f18046d.f18036d;
                    BaseModuleConfig.a a11 = BaseModuleConfig.a();
                    aVar.a(rh2, a11.k("tradingbot/h5/futures/documentary?login=1&userSign=" + this.f18047e.userSign + "&isSelf=false"));
                } else {
                    nc.c.a("app_live_trader_downbuttonclick", MapsKt__MapsKt.j(l.a("uid", BaseModuleConfig.a().getUid()), l.a("liveId", this.f18046d.f18035c)));
                    LiveDetailActivity liveDetailActivity = (LiveDetailActivity) this.f18046d.getActivity();
                    if (liveDetailActivity != null) {
                        liveDetailActivity.sh();
                    }
                    RequestExtKt.d(v7.b.a().j(String.valueOf(this.f18047e.f70255id)), new LiveRecommendDialog$onCreateDialog$2$3$1(this.f18046d), new LiveRecommendDialog$onCreateDialog$2$3$2(this.f18046d, this.f18047e), (MutableLiveData) null, 4, (Object) null);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18048b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18049c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveRecommendDialog f18050d;

        public e(View view, long j11, LiveRecommendDialog liveRecommendDialog) {
            this.f18048b = view;
            this.f18049c = j11;
            this.f18050d = liveRecommendDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18048b) > this.f18049c || (this.f18048b instanceof Checkable)) {
                sVar.e(this.f18048b, currentTimeMillis);
                TextView textView = (TextView) this.f18048b;
                nc.c.a("app_live_trader_contentpage_myclick", MapsKt__MapsKt.j(l.a("uid", BaseModuleConfig.a().getUid()), l.a("liveId", this.f18050d.f18035c)));
                this.f18050d.dismiss();
                b2.a.d().a("/webView/index").withString("url", "holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/Contract/CopyTrading?index=2").navigation(this.f18050d.getContext());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    @SensorsDataInstrumented
    public static final void vh(k0 k0Var, LiveRecommendDialog liveRecommendDialog, View view) {
        if (k0Var.P.getMaxLines() > 2) {
            k0Var.P.setMaxLines(2);
            k0Var.I.setText(liveRecommendDialog.getResources().getString(R$string.n_content_expand));
            k0Var.C.setImageResource(R$drawable.ic_live_recommend_arrow_bottom);
        } else {
            k0Var.P.setMaxLines(8);
            k0Var.I.setText(liveRecommendDialog.getResources().getString(R$string.n_content_collapse));
            k0Var.C.setImageResource(R$drawable.ic_live_recommend_arrow_top);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int i11;
        View decorView;
        k0 K = k0.K(LayoutInflater.from(getActivity()));
        Dialog dialog = new Dialog(requireActivity());
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
        dialog.requestWindowFeature(1);
        dialog.setContentView(K.getRoot());
        Window window = dialog.getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.setPadding(0, 0, 0, 0);
        }
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.height = -1;
        }
        if (attributes != null) {
            attributes.width = -1;
        }
        if (window != null) {
            window.setAttributes(attributes);
        }
        if (window != null) {
            window.setBackgroundDrawableResource(R$color.transparent);
        }
        if (window != null) {
            window.setWindowAnimations(R$style.bottom_dialog_animation);
        }
        s sVar = s.f23381a;
        ImageView imageView = K.E;
        imageView.setOnClickListener(new b(imageView, 800, this));
        LiveRecommendInfo liveRecommendInfo = this.f18037e;
        if (liveRecommendInfo != null) {
            nc.c.a("app_live_trader_contentpageshow", MapsKt__MapsKt.j(l.a("uid", BaseModuleConfig.a().getUid()), l.a("liveId", this.f18035c)));
            com.hbg.module.libkt.base.ext.b.K(K.D, liveRecommendInfo.imgUrl, R$drawable.icon_community_user_header);
            ImageView imageView2 = K.D;
            imageView2.setOnClickListener(new c(imageView2, 800, this));
            K.O.setText(liveRecommendInfo.nickname);
            K.T.setText(liveRecommendInfo.totalProfit);
            TextView textView = K.M;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(liveRecommendInfo.copyUserNum);
            sb2.append('/');
            sb2.append(liveRecommendInfo.fullUserNum);
            textView.setText(sb2.toString());
            K.W.setText(liveRecommendInfo.getWinRateStr());
            K.S.setText(liveRecommendInfo.getThirtyYieldStr());
            TextView textView2 = K.L;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(liveRecommendInfo.copyTotalProfit > 0.0d ? "+" : "");
            sb3.append(liveRecommendInfo.copyTotalProfit);
            textView2.setText(sb3.toString());
            K.K.setText(String.valueOf(liveRecommendInfo.copyNum));
            K.V.setText(String.valueOf(liveRecommendInfo.winNum));
            K.H.setText(DateTimeUtils.e(liveRecommendInfo.avgHoldTime));
            TextView textView3 = K.U;
            textView3.setText(((liveRecommendInfo.f70256ts - liveRecommendInfo.firstSignUp) / ((long) 86400000)) + getResources().getString(R$string.n_day));
            K.R.setText(liveRecommendInfo.symbolPref);
            CommonPkData commonPkData = liveRecommendInfo.voteInfo;
            if (commonPkData != null && this.f18034b == 0) {
                commonPkData.content = getResources().getString(R$string.n_live_recommend_today_voting_decision);
                K.G.setView(liveRecommendInfo.voteInfo);
                K.G.setVisibility(0);
            }
            if (!com.hbg.module.libkt.base.ext.b.x(liveRecommendInfo.reason) && this.f18034b == 0) {
                K.P.setText(liveRecommendInfo.reason);
                K.B.setVisibility(0);
                K.F.setOnClickListener(new h(K, this));
            }
            TextView textView4 = K.J;
            Resources resources = getResources();
            if (this.f18034b == 0) {
                i11 = R$string.n_live_recommend_copy;
            } else {
                i11 = R$string.n_market_qicek_trade_position;
            }
            textView4.setText(resources.getString(i11));
            TextView textView5 = K.J;
            textView5.setOnClickListener(new d(textView5, 800, this, liveRecommendInfo));
            TextView textView6 = K.N;
            textView6.setOnClickListener(new e(textView6, 800, this));
        }
        return dialog;
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setArguments(Bundle bundle) {
        Serializable serializable;
        String string;
        super.setArguments(bundle);
        if (bundle != null) {
            this.f18034b = bundle.getInt("type");
        }
        if (!(bundle == null || (string = bundle.getString("liveId")) == null)) {
            this.f18035c = string;
        }
        if (bundle != null && (serializable = bundle.getSerializable("recommendInfo")) != null) {
            this.f18037e = (LiveRecommendInfo) serializable;
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
