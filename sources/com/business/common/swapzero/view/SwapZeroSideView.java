package com.business.common.swapzero.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.j;
import com.bumptech.glide.a;
import com.business.common.R$drawable;
import com.business.common.swapzero.data.SwapZeroSideModel;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.libkt.helper.SensorsDataHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i4.m;
import j4.b;
import j4.c;
import j4.d;
import java.util.HashMap;
import kotlin.jvm.internal.r;

public final class SwapZeroSideView extends FrameLayout implements DefaultLifecycleObserver {

    /* renamed from: b  reason: collision with root package name */
    public final m f64347b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f64348c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f64349d;

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f64350e;

    public SwapZeroSideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    public SwapZeroSideView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        m K = m.K(LayoutInflater.from(context));
        this.f64347b = K;
        addView(K.getRoot());
        this.f64349d = new Handler(Looper.getMainLooper());
        this.f64350e = new d(this);
    }

    public static final void e(SwapZeroSideView swapZeroSideView) {
        swapZeroSideView.f64347b.D.setVisibility(8);
    }

    @SensorsDataInstrumented
    public static final void f(m mVar, SwapZeroSideView swapZeroSideView, SwapZeroSideModel swapZeroSideModel, View view) {
        mVar.D.setVisibility(0);
        swapZeroSideView.f64349d.removeCallbacks(swapZeroSideView.f64350e);
        swapZeroSideView.i(3000);
        Log.d("合约0元购", mVar.getClass().getSimpleName() + "-Icon");
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "side_ad_all");
        String adId = swapZeroSideModel.getAdId();
        String str = "";
        if (adId == null) {
            adId = str;
        }
        hashMap.put("banner_id", adId);
        String content = swapZeroSideModel.getContent();
        if (content != null) {
            str = content;
        }
        hashMap.put("banner_name", str);
        SensorsDataHelper.track("pageview_contracts", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void g(SwapZeroSideModel swapZeroSideModel, SwapZeroSideView swapZeroSideView, m mVar, View view) {
        BaseModuleConfig.a a11;
        String jump = swapZeroSideModel.getJump();
        String str = "";
        if (jump == null) {
            jump = str;
        }
        if ((jump.length() > 0) && (a11 = BaseModuleConfig.a()) != null) {
            a11.k0(jump);
        }
        swapZeroSideView.f64349d.removeCallbacks(swapZeroSideView.f64350e);
        swapZeroSideView.i(0);
        Log.d("合约0元购", mVar.getClass().getSimpleName() + "-Content");
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "side_ad");
        hashMap.put("button_name", "side_ad_go");
        String adId = swapZeroSideModel.getAdId();
        if (adId == null) {
            adId = str;
        }
        hashMap.put("banner_id", adId);
        String content = swapZeroSideModel.getContent();
        if (content != null) {
            str = content;
        }
        hashMap.put("banner_name", str);
        SensorsDataHelper.track("appclick_contracts", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void h(SwapZeroSideView swapZeroSideView, m mVar, View view) {
        swapZeroSideView.f64349d.removeCallbacks(swapZeroSideView.f64350e);
        View.OnClickListener onClickListener = swapZeroSideView.f64348c;
        if (onClickListener != null) {
            onClickListener.onClick(mVar.B);
        }
        Log.d("合约0元购", mVar.getClass().getSimpleName() + "-Close");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void i(long j11) {
        this.f64349d.postDelayed(this.f64350e, j11);
    }

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        j.a(this, lifecycleOwner);
    }

    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        j.b(this, lifecycleOwner);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f64349d.removeCallbacks(this.f64350e);
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        j.c(this, lifecycleOwner);
    }

    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        j.d(this, lifecycleOwner);
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        j.e(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        j.f(this, lifecycleOwner);
    }

    public final void setCloseListener(View.OnClickListener onClickListener) {
        this.f64348c = onClickListener;
    }

    public final void setTradeActivity(SwapZeroSideModel swapZeroSideModel) {
        m mVar = this.f64347b;
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "side_ad");
        String adId = swapZeroSideModel.getAdId();
        String str = "";
        if (adId == null) {
            adId = str;
        }
        hashMap.put("banner_id", adId);
        String content = swapZeroSideModel.getContent();
        if (content == null) {
            content = str;
        }
        hashMap.put("banner_name", content);
        SensorsDataHelper.track("pageview_contracts", hashMap);
        mVar.E.setOnClickListener(new c(mVar, this, swapZeroSideModel));
        ((com.bumptech.glide.c) a.v(getContext()).p(swapZeroSideModel.getIconRes()).l(R$drawable.icon_swap_zero_gift)).D0(mVar.C);
        AppCompatTextView appCompatTextView = mVar.F;
        String content2 = swapZeroSideModel.getContent();
        if (content2 != null) {
            str = content2;
        }
        appCompatTextView.setText(str);
        mVar.F.setOnClickListener(new j4.a(swapZeroSideModel, this, mVar));
        mVar.B.setOnClickListener(new b(this, mVar));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwapZeroSideView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
