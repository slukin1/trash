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
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.network.otc.core.bean.OtcMarketCoinInfo;
import com.hbg.lib.widgets.TextImageIndicator;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lite.R$color;
import com.hbg.lite.R$drawable;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import com.hbg.lite.base.LiteBaseActivity;
import com.hbg.lite.config.bean.LiteOtcTradeType;
import com.hbg.lite.record.presenter.OtcCnyRecordPresenter;
import com.hbg.lite.record.presenter.OtcCoinRecordPresenter;
import com.hbg.lite.record.presenter.SingleCurrencyRecordPresenter;
import com.hbg.lite.record.ui.LiteOtcOrderFilterDialog;
import com.hbg.lite.record.ui.LiteOtcTradingHouseFilterDialog;
import com.hbg.lite.wallet.bean.LegalDetailInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.util.ArrayList;
import java.util.List;
import jb.a0;
import jb.b0;
import jb.y;
import jb.z;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import q10.c;

public class SingleCurrencyRecordActivity extends LiteBaseActivity<SingleCurrencyRecordPresenter, SingleCurrencyRecordPresenter.b> implements SingleCurrencyRecordPresenter.b, LiteOtcOrderFilterDialog.a, LiteOtcTradingHouseFilterDialog.a {

    /* renamed from: b  reason: collision with root package name */
    public Toolbar f77417b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f77418c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f77419d;

    /* renamed from: e  reason: collision with root package name */
    public View f77420e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f77421f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f77422g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f77423h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f77424i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f77425j;

    /* renamed from: k  reason: collision with root package name */
    public List<String> f77426k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public MagicIndicator f77427l;

    /* renamed from: m  reason: collision with root package name */
    public int f77428m = 0;

    /* renamed from: n  reason: collision with root package name */
    public TextView f77429n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f77430o;

    /* renamed from: p  reason: collision with root package name */
    public LiteOtcOrderFilterDialog f77431p;

    /* renamed from: q  reason: collision with root package name */
    public LiteOtcTradingHouseFilterDialog f77432q;

    /* renamed from: r  reason: collision with root package name */
    public Fragment f77433r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f77434s = false;

    public class a extends CommonNavigatorAdapter {
        public a() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            if (SingleCurrencyRecordActivity.this.f77428m == i11) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            int unused = SingleCurrencyRecordActivity.this.f77428m = i11;
            if (i11 == 0) {
                SingleCurrencyRecordActivity.this.f77431p.setCanReset(true);
                SingleCurrencyRecordActivity.this.f77430o.setSelected(false);
                SingleCurrencyRecordActivity.this.Ch(OtcCnyRecordFragment.class, new Bundle());
            } else {
                SingleCurrencyRecordActivity.this.f77432q.setCanReset(true);
                SingleCurrencyRecordActivity.this.f77430o.setSelected(false);
                SingleCurrencyRecordActivity.this.Ch(OtcCoinRecordFragment.class, new Bundle());
            }
            SingleCurrencyRecordActivity.this.f77427l.c(i11);
            SingleCurrencyRecordActivity.this.f77427l.b(i11, 0.0f, 0);
            SingleCurrencyRecordActivity.this.f77418c.setExpanded(true);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            return SingleCurrencyRecordActivity.this.f77426k.size();
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
            textImageIndicator.setText((CharSequence) SingleCurrencyRecordActivity.this.f77426k.get(i11));
            textImageIndicator.setOnClickListener(new b0(this, i11));
            return textImageIndicator;
        }
    }

    public class b implements AppBarLayout.OnOffsetChangedListener {
        public b() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
            int[] iArr = new int[2];
            SingleCurrencyRecordActivity.this.f77422g.getLocationOnScreen(iArr);
            if (i11 < 0) {
                SingleCurrencyRecordActivity.this.f77420e.setVisibility(0);
            } else {
                SingleCurrencyRecordActivity.this.f77420e.setVisibility(8);
            }
            if (iArr[1] <= SingleCurrencyRecordActivity.this.f77417b.getMeasuredHeight()) {
                SingleCurrencyRecordActivity.this.f77419d.setVisibility(0);
                SingleCurrencyRecordActivity.this.f77419d.setText(StringUtils.i(((SingleCurrencyRecordPresenter) SingleCurrencyRecordActivity.this.getPresenter()).S().getCurrency()));
                return;
            }
            SingleCurrencyRecordActivity.this.f77419d.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Bh(View view) {
        String string = getResources().getString(R$string.withdraw_action_1);
        DialogUtils.b.d dVar = new DialogUtils.b.d(this);
        dVar.c1(getResources().getString(R$string.lite_withdraw_building_title));
        dVar.T0(true);
        dVar.S0(Integer.valueOf(getResources().getColor(R$color.baseColorSecondaryText)));
        dVar.R0(getResources().getString(R$string.n_lite_withdraw_building_content));
        dVar.i1(1).M0(Integer.valueOf(R$drawable.lite_transfer_building)).P0(string).q0(false).Q0(a0.f55896a).j0().show(getSupportFragmentManager(), "");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void Dh(Context context, LegalDetailInfo legalDetailInfo) {
        Intent intent = new Intent(context, SingleCurrencyRecordActivity.class);
        intent.putExtra("record_coin_id", legalDetailInfo);
        context.startActivity(intent);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if (this.f77428m == 0) {
            this.f77431p.show(getSupportFragmentManager(), "mFilterPopup");
        } else {
            this.f77432q.show(getSupportFragmentManager(), "mTradingHouseFilterDialog");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Ch(Class cls, Bundle bundle) {
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
        this.f77433r = instanceFragment;
        if (instanceFragment instanceof OtcCnyRecordFragment) {
            if (((OtcCnyRecordFragment) instanceFragment).yh() != null) {
                ((OtcCnyRecordPresenter) ((OtcCnyRecordFragment) this.f77433r).yh()).m0();
                ((OtcCnyRecordPresenter) ((OtcCnyRecordFragment) this.f77433r).yh()).k0();
            }
        } else if ((instanceFragment instanceof OtcCoinRecordFragment) && ((OtcCoinRecordFragment) instanceFragment).yh() != null) {
            ((OtcCoinRecordPresenter) ((OtcCoinRecordFragment) this.f77433r).yh()).m0();
            ((OtcCoinRecordPresenter) ((OtcCoinRecordFragment) this.f77433r).yh()).k0();
        }
        q11.A(instanceFragment).k();
    }

    public void Eb(int i11, String str) {
        this.f77430o.setSelected(i11 != -1 || TextUtils.equals(str, TtmlNode.COMBINE_ALL));
        Fragment fragment = this.f77433r;
        if (fragment instanceof OtcCoinRecordFragment) {
            ((OtcCoinRecordPresenter) ((OtcCoinRecordFragment) fragment).yh()).l0(i11, str);
        }
        this.f77418c.setExpanded(true);
        this.f77432q.dismiss();
    }

    public void Ra(LiteOtcTradeType liteOtcTradeType, String str) {
        this.f77430o.setSelected(liteOtcTradeType != LiteOtcTradeType.NONE || TextUtils.equals(str, TtmlNode.COMBINE_ALL));
        Fragment fragment = this.f77433r;
        if (fragment instanceof OtcCnyRecordFragment) {
            ((OtcCnyRecordPresenter) ((OtcCnyRecordFragment) fragment).yh()).l0(liteOtcTradeType, str);
        }
        this.f77418c.setExpanded(true);
        this.f77431p.dismiss();
    }

    public void S3(LegalDetailInfo legalDetailInfo) {
        if (legalDetailInfo != null) {
            g6.b.c().i(this.f77421f, legalDetailInfo.getLiteLogo(), R$drawable.shape_logo_default_bg);
            this.f77422g.setText(StringUtils.i(legalDetailInfo.getCurrency()));
            OtcMarketCoinInfo.CoinInfo s11 = va.b.s(legalDetailInfo.getCoinId());
            String fullName = s11 != null ? s11.getFullName() : "";
            if (!TextUtils.isEmpty(fullName)) {
                this.f77423h.setVisibility(0);
                this.f77423h.setText(String.format(getString(R$string.brackets_with_content), new Object[]{fullName}));
            } else {
                this.f77423h.setVisibility(8);
            }
            n8(legalDetailInfo);
        }
    }

    public void addEvent() {
        this.f77429n.setOnClickListener(new z(this));
        this.f77418c.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b());
        this.f77430o.setOnClickListener(new y(this));
    }

    public int getContentView() {
        return R$layout.activity_lite_single_currency_record;
    }

    public View getView() {
        return this.f77420e;
    }

    public void initView() {
        this.f77417b = (Toolbar) this.viewFinder.b(R$id.single_currency_record_toolbar);
        this.f77418c = (AppBarLayout) this.viewFinder.b(R$id.single_currency_record_appbar);
        this.f77419d = (TextView) this.viewFinder.b(R$id.toolbar_center_tv);
        this.f77420e = this.viewFinder.b(R$id.toolbar_divider_view);
        this.f77421f = (ImageView) this.viewFinder.b(R$id.currency_icon_iv);
        this.f77422g = (TextView) this.viewFinder.b(R$id.currency_name_tv);
        this.f77423h = (TextView) this.viewFinder.b(R$id.currency_zh_name_iv);
        this.f77424i = (TextView) this.viewFinder.b(R$id.currency_amount_value_tv);
        this.f77425j = (TextView) this.viewFinder.b(R$id.currency_amount_frozen_value_tv);
        setToolBar(this.f77417b, "", true);
        this.f77427l = (MagicIndicator) this.viewFinder.b(R$id.single_record_indicator);
        zh();
        this.f77429n = (TextView) this.viewFinder.b(R$id.single_currency_record_tv);
        FragmentTransaction q11 = getSupportFragmentManager().q();
        String name = OtcCnyRecordFragment.class.getName();
        Fragment instanceFragment = instanceFragment(name, new Bundle(), name);
        if (!instanceFragment.isAdded()) {
            q11.c(R$id.tab_content, instanceFragment, name);
        }
        this.f77433r = instanceFragment;
        q11.A(instanceFragment).k();
        this.f77430o = (ImageView) this.viewFinder.b(R$id.record_filter_iv);
        LiteOtcOrderFilterDialog liteOtcOrderFilterDialog = new LiteOtcOrderFilterDialog();
        this.f77431p = liteOtcOrderFilterDialog;
        liteOtcOrderFilterDialog.Ih(this);
        LiteOtcTradingHouseFilterDialog liteOtcTradingHouseFilterDialog = new LiteOtcTradingHouseFilterDialog();
        this.f77432q = liteOtcTradingHouseFilterDialog;
        liteOtcTradingHouseFilterDialog.Ih(this);
    }

    public void n8(LegalDetailInfo legalDetailInfo) {
        if (!TextUtils.isEmpty(legalDetailInfo.getAvailable())) {
            this.f77424i.setText(m.u0(legalDetailInfo.getAvailable(), 12, wa.a.a(legalDetailInfo.getCoinId())));
        }
        if (!TextUtils.isEmpty(legalDetailInfo.getOnOrders())) {
            this.f77425j.setText(m.u0(legalDetailInfo.getOnOrders(), 12, wa.a.a(legalDetailInfo.getCoinId())));
        }
    }

    public void onResume() {
        Fragment fragment;
        super.onResume();
        if (this.f77434s && (fragment = this.f77433r) != null) {
            if (fragment instanceof OtcCnyRecordFragment) {
                if (((OtcCnyRecordFragment) fragment).yh() != null) {
                    ((OtcCnyRecordPresenter) ((OtcCnyRecordFragment) this.f77433r).yh()).k0();
                }
            } else if ((fragment instanceof OtcCoinRecordFragment) && ((OtcCoinRecordFragment) fragment).yh() != null) {
                ((OtcCoinRecordPresenter) ((OtcCoinRecordFragment) this.f77433r).yh()).k0();
            }
        }
        this.f77434s = true;
    }

    /* renamed from: xh */
    public SingleCurrencyRecordPresenter createPresenter() {
        return new SingleCurrencyRecordPresenter();
    }

    /* renamed from: yh */
    public SingleCurrencyRecordPresenter.b getUI() {
        return this;
    }

    public final void zh() {
        this.f77426k.add(getString(R$string.record_curency_indicator));
        this.f77426k.add(getString(R$string.record_usdt_indicator));
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new a());
        this.f77427l.setNavigator(commonNavigator);
    }
}
