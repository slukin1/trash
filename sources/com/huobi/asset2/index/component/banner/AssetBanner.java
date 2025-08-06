package com.huobi.asset2.index.component.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.AssetBannerData;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$drawable;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.RoundLinesIndicator;
import com.youth.banner.util.BannerUtils;
import f6.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import u6.g;
import v7.b;
import yh.d;

public class AssetBanner extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public final Banner<AssetBannerData, BannerImageAdapter<AssetBannerData>> f42677b;

    /* renamed from: c  reason: collision with root package name */
    public final BannerImageAdapter<AssetBannerData> f42678c;

    public class a extends BannerImageAdapter<AssetBannerData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f42679b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(List list, Context context) {
            super(list);
            this.f42679b = context;
        }

        public static /* synthetic */ void e(Context context, AssetBannerData assetBannerData, Void voidR) {
            AssetModuleConfig.a().t0(context, assetBannerData.getLink(), assetBannerData.getActivityName());
            gi.a.e(assetBannerData.getActivityName());
        }

        /* renamed from: f */
        public void onBindView(BannerImageHolder bannerImageHolder, AssetBannerData assetBannerData, int i11, int i12) {
            if (NightHelper.e().g()) {
                c.a().f(bannerImageHolder.imageView, assetBannerData.getHeaderPic(), R$drawable.wallet_loading_night);
            } else {
                c.a().f(bannerImageHolder.imageView, assetBannerData.getHeaderPic(), R$drawable.wallet_loading);
            }
            dw.a.a(bannerImageHolder.imageView).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new d(this.f42679b, assetBannerData));
        }
    }

    public AssetBanner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(List list) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("loadData Success. list=");
        sb2.append(list);
        i6.d.c("AssetBanner", sb2.toString() != null ? list.toString() : " is empty");
        if (list == null || list.isEmpty()) {
            setVisibility(8);
        } else {
            setVisibility(0);
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(((AssetBannerData) it2.next()).getActivityName());
            }
            gi.a.f(arrayList);
        }
        this.f42678c.setDatas(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(APIStatusErrorException aPIStatusErrorException) {
        i6.d.e("AssetBanner", "loadData api exception:" + aPIStatusErrorException.getErrCode());
        setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(Throwable th2) {
        i6.d.e("AssetBanner", "loadData error:" + th2.getStackTrace());
        setVisibility(8);
    }

    public void d(LifecycleOwner lifecycleOwner) {
        this.f42677b.addBannerLifecycleObserver(lifecycleOwner);
    }

    public void h(g gVar) {
        i6.d.c("AssetBanner", "Start load data.");
        b.a().getAssetBannerList(AssetModuleConfig.a().T()).b().compose(RxJavaHelper.t(gVar)).subscribe(EasySubscriber.create(new yh.c(this), new yh.a(this), new yh.b(this)));
    }

    public AssetBanner(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Banner<AssetBannerData, BannerImageAdapter<AssetBannerData>> banner = new Banner<>(context);
        this.f42677b = banner;
        a aVar = new a(new ArrayList(), context);
        this.f42678c = aVar;
        banner.setAdapter(aVar);
        int dp2px = BannerUtils.dp2px(14.0f);
        int dp2px2 = BannerUtils.dp2px(15.0f);
        banner.setLoopTime(5000);
        banner.setIndicator(new RoundLinesIndicator(getContext())).setIndicatorWidth(dp2px, dp2px).setIndicatorMargins(new IndicatorConfig.Margins(dp2px2, dp2px2, dp2px2, BannerUtils.dp2px(4.0f))).setIndicatorHeight(BannerUtils.dp2px(2.0f)).setIndicatorRadius(0).setIndicatorNormalColor(getResources().getColor(R$color.banner_indicator)).setIndicatorSelectedColor(getResources().getColor(R$color.banner_indicator_selected));
        addView(banner);
    }
}
