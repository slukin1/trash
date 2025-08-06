package com.hbg.module.market.widget.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$style;
import com.hbg.module.market.R$drawable;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$string;
import com.huobi.homemarket.presenter.MarketPlateDetailActivityPresenter;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import net.lucode.hackware.magicindicator.ViewPagerHelper;

@Route(path = "/market/plateDetail")
public class MarketPlateDetailActivity extends BaseActivity<MarketPlateDetailActivityPresenter, MarketPlateDetailActivityPresenter.b> implements MarketPlateDetailActivityPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public HbTitleBar f26728b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f26729c;

    /* renamed from: d  reason: collision with root package name */
    public View f26730d;

    /* renamed from: e  reason: collision with root package name */
    public CommonTextListIndicator f26731e;

    public class a implements CommonTextListIndicator.b {
        public a() {
        }

        public void a(int i11, View view) {
        }

        public void onItemClick(int i11) {
            MarketPlateDetailActivity.this.f26729c.setCurrentItem(i11);
            HashMap hashMap = new HashMap();
            if (i11 == 0) {
                hashMap.put("tab_name", "detail");
            } else {
                hashMap.put("tab_name", "community");
            }
            BaseModuleConfig.a().w("plate_details_tab_click", hashMap);
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            HashMap hashMap = new HashMap();
            hashMap.put("plate_name", MarketPlateDetailActivity.this.getIntent().getStringExtra("plateId"));
            if (i11 == 0) {
                BaseModuleConfig.a().w("plate_details_view", hashMap);
            } else {
                BaseModuleConfig.a().w("plate_details_community_view", hashMap);
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void gg(View view) {
        ((MarketPlateDetailActivityPresenter) getPresenter()).S();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Og(String str) {
        this.f26728b.setTitle(str);
        this.f26728b.getIvAction().setImageResource(R$drawable.icon_share_market_plate);
        this.f26728b.getIvAction().setVisibility(0);
        this.f26728b.getIvAction().setOnClickListener(new mf.a(this));
    }

    /* renamed from: Zf */
    public MarketPlateDetailActivityPresenter createPresenter() {
        return new MarketPlateDetailActivityPresenter();
    }

    public void addEvent() {
    }

    /* renamed from: fg */
    public MarketPlateDetailActivityPresenter.b getUI() {
        return this;
    }

    public ViewPager g3() {
        return this.f26729c;
    }

    public int getContentView() {
        return R$layout.activity_market_plate_detail;
    }

    public View getRootView() {
        return this.f26730d;
    }

    public void initView() {
        this.f26730d = this.viewFinder.b(R$id.rl_market_info_root);
        this.f26729c = (ViewPager) this.viewFinder.b(R$id.view_pager_kline_content);
        this.f26728b = (HbTitleBar) this.viewFinder.b(com.hbg.module.market.R$id.title_bar);
        CommonTextListIndicator commonTextListIndicator = (CommonTextListIndicator) findViewById(com.hbg.module.market.R$id.common_text_list_indicator);
        this.f26731e = commonTextListIndicator;
        commonTextListIndicator.setCallback(new a());
        b bVar = new b();
        this.f26729c.addOnPageChangeListener(bVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R$string.market_plate_detail));
        arrayList.add(getResources().getString(R$string.n_content_community));
        this.f26731e.setDataList(arrayList);
        ViewPagerHelper.a(this.f26731e, this.f26729c);
        bVar.onPageSelected(0);
    }

    public void onCreate(Bundle bundle) {
        if (!NightHelper.e().g()) {
            setTheme(R$style.ActivityKlineLight);
        } else {
            setTheme(R$style.ActivityKlineNight);
        }
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable((Drawable) null);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
