package com.hbg.module.livesquare.ui;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import lc.k;
import v7.b;

@Route(path = "/live/category_list")
public final class LiveCategoryActivity extends BaseActivity<k> {

    /* renamed from: i  reason: collision with root package name */
    public int f26560i = -1;

    /* renamed from: j  reason: collision with root package name */
    public int f26561j = 1;

    @SensorsDataInstrumented
    public static final void Eh(LiveCategoryActivity liveCategoryActivity, View view) {
        liveCategoryActivity.Ch();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final /* synthetic */ k zh(LiveCategoryActivity liveCategoryActivity) {
        return (k) liveCategoryActivity.Yf();
    }

    public final void Ch() {
        RequestExtKt.d(b.a().getLiveCategory(this.f26561j, NightHelper.e().g() ? 1 : 0), new LiveCategoryActivity$getCategoryList$1(this), new LiveCategoryActivity$getCategoryList$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    /* renamed from: Dh */
    public k Og() {
        return k.K(getLayoutInflater());
    }

    public void initView() {
        super.initView();
        Qg(NightHelper.e().g());
        ((k) Yf()).M(this);
        ((k) Yf()).C.setOnRetryClickListener(new a(this));
        ((k) Yf()).C.p();
        Ch();
    }

    public void oh() {
        super.oh();
        this.f26560i = getIntent().getIntExtra("selCategoryId", -1);
        this.f26561j = getIntent().getIntExtra("liveStatus", 0);
    }
}
