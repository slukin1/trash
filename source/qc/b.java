package qc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.LiveBannerData;
import com.hbg.lib.router.HbgRouter;
import com.hbg.module.content.R$color;
import com.hbg.module.libkt.utils.r;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.RectangleIndicator;
import com.youth.banner.listener.OnPageChangeListener;
import java.util.HashMap;
import java.util.List;
import nc.c;

public final class b {

    public static final class a implements OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Banner<LiveBannerData, BannerImageAdapter<LiveBannerData>> f19349b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List<LiveBannerData> f19350c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f19351d;

        public a(Banner<LiveBannerData, BannerImageAdapter<LiveBannerData>> banner, List<? extends LiveBannerData> list, int i11) {
            this.f19349b = banner;
            this.f19350c = list;
            this.f19351d = i11;
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            int realPosition = this.f19349b.getAdapter().getRealPosition(i11);
            if (realPosition < this.f19350c.size()) {
                LiveBannerData liveBannerData = this.f19350c.get(realPosition);
                HashMap hashMap = new HashMap();
                String str = null;
                int i12 = this.f19351d;
                if (i12 == 2) {
                    hashMap.put("url", liveBannerData.getUrl());
                    String liveId = liveBannerData.getLiveId();
                    boolean z11 = true;
                    if (liveId == null || !com.hbg.module.libkt.base.ext.b.x(liveId)) {
                        z11 = false;
                    }
                    if (!z11) {
                        hashMap.put("liveId", liveBannerData.getLiveId());
                    }
                    str = "APP_LIVE_quotation_bannershow";
                } else if (i12 == 5) {
                    hashMap.put("URL", liveBannerData.getUrl());
                    str = "app_community_banner";
                }
                if (str != null) {
                    c.a(str, hashMap);
                }
            }
        }
    }

    /* renamed from: qc.b$b  reason: collision with other inner class name */
    public static final class C0132b extends BannerImageAdapter<LiveBannerData> {
        public C0132b(List<? extends LiveBannerData> list) {
            super(list);
        }

        /* renamed from: d */
        public void onBindView(BannerImageHolder bannerImageHolder, LiveBannerData liveBannerData, int i11, int i12) {
            ImageView imageView;
            if (bannerImageHolder != null && (imageView = bannerImageHolder.imageView) != null) {
                imageView.setPadding(32, 0, 32, 0);
                com.hbg.module.libkt.base.ext.b.L(imageView, liveBannerData != null ? liveBannerData.getImgUrl() : null, 8.0f);
            }
        }
    }

    public static final void b(Banner<LiveBannerData, BannerImageAdapter<LiveBannerData>> banner, Context context, int i11, LifecycleOwner lifecycleOwner, List<? extends LiveBannerData> list) {
        banner.setAdapter(new C0132b(list));
        banner.setLoopTime(4000);
        r.f24939a.c(banner.setIndicator(new RectangleIndicator(context)).setIndicatorNormalWidth(PixelUtils.a(4.0f)).setIndicatorSelectedWidth(PixelUtils.a(8.0f)).setIndicatorHeight(PixelUtils.a(2.0f)).setIndicatorRadius(0).setIndicatorNormalColorRes(R$color.white_070).setIndicatorSelectedColorRes(R$color.white).setIndicatorSpace(PixelUtils.a(2.0f)), R$color.transparent);
        banner.setCurrentItem(0, false);
        if (list.size() > 1) {
            banner.start();
            banner.setStartPosition(list.size() * 10);
            banner.getViewPager2().setUserInputEnabled(true);
        } else {
            banner.stop();
            banner.getViewPager2().setUserInputEnabled(false);
        }
        banner.addBannerLifecycleObserver(lifecycleOwner);
        banner.addOnPageChangeListener(new a(banner, list, i11));
        banner.setOnBannerListener(new a(i11, context));
    }

    public static final void c(int i11, Context context, LiveBannerData liveBannerData, int i12) {
        String str;
        HashMap hashMap = new HashMap();
        if (i11 == 2) {
            hashMap.put("url", liveBannerData.getUrl());
            String liveId = liveBannerData.getLiveId();
            boolean z11 = true;
            if (liveId == null || !com.hbg.module.libkt.base.ext.b.x(liveId)) {
                z11 = false;
            }
            if (!z11) {
                hashMap.put("liveId", liveBannerData.getLiveId());
            }
            str = "APP_LIVE_quotation_bannerclk";
        } else if (i11 != 5) {
            str = null;
        } else {
            hashMap.put("URL", liveBannerData.getUrl());
            str = "app_community_bannerclk";
        }
        if (str != null) {
            c.a(str, hashMap);
        }
        if (!com.hbg.module.libkt.base.ext.b.x(liveBannerData.getUrl())) {
            Intent intent = new Intent();
            intent.putExtra("url", liveBannerData.getUrl());
            intent.setClass(context, HBBaseWebActivity.class);
            context.startActivity(intent);
        } else if (!com.hbg.module.libkt.base.ext.b.x(liveBannerData.getLiveId())) {
            Bundle bundle = new Bundle();
            bundle.putString("liveId", liveBannerData.getLiveId());
            HbgRouter.i(context, "/live/room", bundle);
        }
    }
}
