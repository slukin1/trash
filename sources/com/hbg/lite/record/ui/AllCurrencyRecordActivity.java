package com.hbg.lite.record.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.widgets.TextImageIndicator;
import com.hbg.lite.R$color;
import com.hbg.lite.R$drawable;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import com.hbg.lite.base.LiteBaseActivity;
import com.hbg.lite.config.bean.LiteOtcTradeType;
import com.hbg.lite.record.presenter.AllCurrencyRecordPresenter;
import com.hbg.lite.record.presenter.OtcCnyRecordPresenter;
import com.hbg.lite.record.presenter.OtcCoinRecordPresenter;
import com.hbg.lite.record.ui.LiteOtcOrderFilterDialog;
import com.hbg.lite.record.ui.LiteOtcTradingHouseFilterDialog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import q10.c;

public class AllCurrencyRecordActivity extends LiteBaseActivity<AllCurrencyRecordPresenter, AllCurrencyRecordPresenter.a> implements AllCurrencyRecordPresenter.a, LiteOtcOrderFilterDialog.a, LiteOtcTradingHouseFilterDialog.a {

    /* renamed from: b  reason: collision with root package name */
    public List<String> f77369b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public MagicIndicator f77370c;

    /* renamed from: d  reason: collision with root package name */
    public int f77371d = 0;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f77372e;

    /* renamed from: f  reason: collision with root package name */
    public LiteOtcOrderFilterDialog f77373f;

    /* renamed from: g  reason: collision with root package name */
    public LiteOtcTradingHouseFilterDialog f77374g;

    /* renamed from: h  reason: collision with root package name */
    public Fragment f77375h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f77376i = false;

    /* renamed from: j  reason: collision with root package name */
    public Toolbar f77377j;

    /* renamed from: k  reason: collision with root package name */
    public AppBarLayout f77378k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f77379l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f77380m;

    /* renamed from: n  reason: collision with root package name */
    public View f77381n;

    /* renamed from: o  reason: collision with root package name */
    public int f77382o;

    public class a extends CommonNavigatorAdapter {
        public a() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            if (AllCurrencyRecordActivity.this.f77371d == i11) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            int unused = AllCurrencyRecordActivity.this.f77371d = i11;
            if (i11 == 0) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("record_show_item_currency", true);
                AllCurrencyRecordActivity.this.xh(OtcCnyRecordFragment.class, bundle);
                AllCurrencyRecordActivity.this.f77373f.setCanReset(true);
                AllCurrencyRecordActivity.this.f77372e.setSelected(false);
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("record_show_item_currency", true);
                AllCurrencyRecordActivity.this.xh(OtcCoinRecordFragment.class, bundle2);
                AllCurrencyRecordActivity.this.f77374g.setCanReset(true);
                AllCurrencyRecordActivity.this.f77372e.setSelected(false);
            }
            AllCurrencyRecordActivity.this.f77370c.c(i11);
            AllCurrencyRecordActivity.this.f77370c.b(i11, 0.0f, 0);
            AllCurrencyRecordActivity.this.f77378k.setExpanded(true);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            return AllCurrencyRecordActivity.this.f77369b.size();
        }

        public q10.b getIndicator(Context context) {
            return null;
        }

        public c getTitleView(Context context, int i11) {
            TextImageIndicator textImageIndicator = new TextImageIndicator(context);
            textImageIndicator.setNormalColor(ContextCompat.getColor(context, R$color.baseColorSecondaryText));
            textImageIndicator.setSelectedColor(ContextCompat.getColor(context, R$color.baseColorMajorTheme100));
            textImageIndicator.setNormalDrawable(0);
            textImageIndicator.setSelectedDrawable(R$drawable.lite_shape_record_indicator_select_bg);
            textImageIndicator.setTextSize(1, 12.0f);
            textImageIndicator.setText((CharSequence) AllCurrencyRecordActivity.this.f77369b.get(i11));
            textImageIndicator.setOnClickListener(new jb.b(this, i11));
            return textImageIndicator;
        }
    }

    public class b implements AppBarLayout.OnOffsetChangedListener {
        public b() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
            int[] iArr = new int[2];
            AllCurrencyRecordActivity.this.f77380m.getLocationOnScreen(iArr);
            if (i11 < 0) {
                AllCurrencyRecordActivity.this.f77381n.setVisibility(0);
            } else {
                AllCurrencyRecordActivity.this.f77381n.setVisibility(8);
            }
            if (iArr[1] <= AllCurrencyRecordActivity.this.f77377j.getMeasuredHeight()) {
                AllCurrencyRecordActivity.this.f77379l.setVisibility(0);
                AllCurrencyRecordActivity.this.f77379l.setText(AllCurrencyRecordActivity.this.f77380m.getText());
                return;
            }
            AllCurrencyRecordActivity.this.f77379l.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (this.f77371d == 0) {
            this.f77373f.show(getSupportFragmentManager(), "mFilterPopup");
        } else {
            this.f77374g.show(getSupportFragmentManager(), "mTradingHouseFilterDialog");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void yh(Context context) {
        context.startActivity(new Intent(context, AllCurrencyRecordActivity.class));
    }

    public void Eb(int i11, String str) {
        this.f77372e.setSelected(i11 != -1 || TextUtils.equals(str, TtmlNode.COMBINE_ALL));
        Fragment fragment = this.f77375h;
        if (fragment instanceof OtcCoinRecordFragment) {
            ((OtcCoinRecordPresenter) ((OtcCoinRecordFragment) fragment).yh()).l0(i11, str);
        }
        this.f77378k.setExpanded(true);
        this.f77374g.dismiss();
    }

    public void Ra(LiteOtcTradeType liteOtcTradeType, String str) {
        this.f77372e.setSelected(liteOtcTradeType != LiteOtcTradeType.NONE || TextUtils.equals(str, TtmlNode.COMBINE_ALL));
        Fragment fragment = this.f77375h;
        if (fragment instanceof OtcCnyRecordFragment) {
            ((OtcCnyRecordPresenter) ((OtcCnyRecordFragment) fragment).yh()).l0(liteOtcTradeType, str);
        }
        this.f77378k.setExpanded(true);
        this.f77373f.dismiss();
    }

    public void addEvent() {
        this.f77372e.setOnClickListener(new jb.a(this));
        this.f77378k.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b());
    }

    public int getContentView() {
        return R$layout.activity_lite_all_currency_record;
    }

    public void initView() {
        String str;
        this.f77377j = (Toolbar) this.viewFinder.b(R$id.all_currency_record_toolbar);
        this.f77378k = (AppBarLayout) this.viewFinder.b(R$id.all_currency_record_appbar);
        this.f77379l = (TextView) this.viewFinder.b(R$id.toolbar_center_tv);
        this.f77381n = this.viewFinder.b(R$id.toolbar_divider_view);
        this.f77380m = (TextView) this.viewFinder.b(R$id.tv_header_title);
        setToolBar(this.f77377j, getString(R$string.trade_record), true);
        this.f77370c = (MagicIndicator) this.viewFinder.b(R$id.single_record_indicator);
        this.f77382o = getIntent().getIntExtra("currency_record_select_tab", 0);
        wh();
        Bundle bundle = new Bundle();
        bundle.putBoolean("record_show_item_currency", true);
        FragmentTransaction q11 = getSupportFragmentManager().q();
        if (this.f77382o == 0) {
            str = OtcCnyRecordFragment.class.getName();
        } else {
            str = OtcCoinRecordFragment.class.getName();
        }
        Fragment instanceFragment = instanceFragment(str, bundle, str);
        if (!instanceFragment.isAdded()) {
            q11.c(R$id.tab_content, instanceFragment, str);
        }
        this.f77375h = instanceFragment;
        q11.A(instanceFragment).k();
        this.f77372e = (ImageView) this.viewFinder.b(R$id.record_filter_iv);
        LiteOtcOrderFilterDialog liteOtcOrderFilterDialog = new LiteOtcOrderFilterDialog();
        this.f77373f = liteOtcOrderFilterDialog;
        liteOtcOrderFilterDialog.Ih(this);
        LiteOtcTradingHouseFilterDialog liteOtcTradingHouseFilterDialog = new LiteOtcTradingHouseFilterDialog();
        this.f77374g = liteOtcTradingHouseFilterDialog;
        liteOtcTradingHouseFilterDialog.Ih(this);
    }

    public void onResume() {
        Fragment fragment;
        super.onResume();
        if (this.f77376i && (fragment = this.f77375h) != null) {
            if (fragment instanceof OtcCnyRecordFragment) {
                if (((OtcCnyRecordFragment) fragment).yh() != null) {
                    ((OtcCnyRecordPresenter) ((OtcCnyRecordFragment) this.f77375h).yh()).k0();
                }
            } else if ((fragment instanceof OtcCoinRecordFragment) && ((OtcCoinRecordFragment) fragment).yh() != null) {
                ((OtcCoinRecordPresenter) ((OtcCoinRecordFragment) this.f77375h).yh()).k0();
            }
        }
        this.f77376i = true;
    }

    /* renamed from: uh */
    public AllCurrencyRecordPresenter createPresenter() {
        return new AllCurrencyRecordPresenter();
    }

    /* renamed from: vh */
    public AllCurrencyRecordPresenter.a getUI() {
        return this;
    }

    public final void wh() {
        this.f77369b.add(getString(R$string.record_curency_indicator));
        this.f77369b.add(getString(R$string.record_usdt_indicator));
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new a());
        this.f77370c.setNavigator(commonNavigator);
        if (this.f77382o == 1) {
            this.f77370c.c(1);
            this.f77371d = 1;
        }
    }

    public final void xh(Class cls, Bundle bundle) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction q11 = supportFragmentManager.q();
        if (supportFragmentManager.B0() != null) {
            for (Fragment next : supportFragmentManager.B0()) {
                if (next != null) {
                    q11.q(next);
                }
            }
        }
        String name = cls.getName();
        Fragment instanceFragment = instanceFragment(cls.getName(), bundle, cls.getName());
        if (!instanceFragment.isAdded()) {
            q11.c(R$id.tab_content, instanceFragment, name);
        }
        this.f77375h = instanceFragment;
        if (instanceFragment instanceof OtcCnyRecordFragment) {
            if (((OtcCnyRecordFragment) instanceFragment).yh() != null) {
                ((OtcCnyRecordPresenter) ((OtcCnyRecordFragment) this.f77375h).yh()).m0();
                ((OtcCnyRecordPresenter) ((OtcCnyRecordFragment) this.f77375h).yh()).k0();
            }
        } else if ((instanceFragment instanceof OtcCoinRecordFragment) && ((OtcCoinRecordFragment) instanceFragment).yh() != null) {
            ((OtcCoinRecordPresenter) ((OtcCoinRecordFragment) this.f77375h).yh()).m0();
            ((OtcCoinRecordPresenter) ((OtcCoinRecordFragment) this.f77375h).yh()).k0();
        }
        q11.A(instanceFragment).k();
    }
}
