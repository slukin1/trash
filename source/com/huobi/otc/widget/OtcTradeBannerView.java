package com.huobi.otc.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.h0;
import androidx.viewpager.widget.ViewPager;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.R$styleable;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.OtcBannerBean;
import com.huobi.otc.persenter.OtcTradePresenter;
import com.huobi.view.rollviewpager.RollPagerView;
import com.huobi.view.rollviewpager.hintview.AnimHintView;
import com.xiaomi.mipush.sdk.Constants;
import i6.d;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import vp.n0;

public class OtcTradeBannerView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f80075b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f80076c = true;

    /* renamed from: d  reason: collision with root package name */
    public int f80077d;

    /* renamed from: e  reason: collision with root package name */
    public AnimHintView f80078e;

    /* renamed from: f  reason: collision with root package name */
    public RollPagerView f80079f;

    /* renamed from: g  reason: collision with root package name */
    public bp.b f80080g;

    /* renamed from: h  reason: collision with root package name */
    public OtcCommonRectFIndicator f80081h;

    /* renamed from: i  reason: collision with root package name */
    public List<OtcBannerBean> f80082i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public OtcTradePresenter.i f80083j;

    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            OtcTradeBannerView.this.f80081h.setPosition(i11);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f80085b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f80086c;

        public b(ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
            this.f80085b = marginLayoutParams;
            this.f80086c = i11;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.MarginLayoutParams marginLayoutParams = this.f80085b;
            marginLayoutParams.height = this.f80086c - intValue;
            OtcTradeBannerView.this.setLayoutParams(marginLayoutParams);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            OtcTradeBannerView.this.c();
            OtcTradeBannerView.this.setVisibility(8);
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            OtcTradeBannerView.this.c();
            OtcTradeBannerView.this.setVisibility(8);
        }
    }

    public OtcTradeBannerView(Context context) {
        super(context);
        d(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(Void voidR) {
        ConfigPreferences.n("otc_config", getOtcBannerShowKey(), true);
        OtcTradePresenter.i iVar = this.f80083j;
        if (iVar != null) {
            iVar.jg();
        }
    }

    public static String getOtcBannerShowKey() {
        String format = new SimpleDateFormat("yyyy-MM-dd").format(DateTimeUtils.p(System.currentTimeMillis(), TimeZone.getDefault().getDisplayName(true, 0)));
        if (OtcModuleConfig.a().a()) {
            String uid = OtcModuleConfig.a().getUid();
            return format + Constants.ACCEPT_TIME_SEPARATOR_SERVER + uid;
        }
        return format + "-none";
    }

    public void c() {
        this.f80082i.clear();
        this.f80080g.notifyDataSetChanged();
        this.f80081h.setVisibility(4);
    }

    public final void d(Context context) {
        setGravity(16);
        View.inflate(context, R$layout.otc_trade_banner_layout, this);
        this.f80075b = (ImageView) findViewById(R$id.iv_close_tip);
        this.f80081h = (OtcCommonRectFIndicator) findViewById(R$id.id_otc_banner_indicator);
        dw.a.a(this.f80075b).throttleFirst(1, TimeUnit.SECONDS).subscribe(new n0(this));
        RollPagerView rollPagerView = (RollPagerView) findViewById(R$id.roll_view_pager);
        this.f80079f = rollPagerView;
        rollPagerView.getViewPager().setPageMargin(0);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f80079f.getViewPager().setNestedScrollingEnabled(false);
        }
        h0.N0(this.f80079f.getViewPager(), false);
        AnimHintView animHintView = new AnimHintView(context);
        this.f80078e = animHintView;
        animHintView.setNormalResId(0);
        this.f80078e.setBgResId(R$drawable.hint_indicator_bg);
        this.f80078e.setFocusResId(R$drawable.hint_indicator_focus);
        this.f80079f.setHintView(this.f80078e);
        bp.b bVar = new bp.b(this.f80079f, this.f80083j);
        this.f80080g = bVar;
        bVar.setPosDelta(-1);
        this.f80079f.setAdapter(this.f80080g);
        this.f80075b.setVisibility(8);
        this.f80079f.getViewPager().addOnPageChangeListener(new a());
        f(this.f80082i, (OtcTradePresenter.i) null);
    }

    public void f(List<OtcBannerBean> list, OtcTradePresenter.i iVar) {
        List<OtcBannerBean> otcBannerBeans = getOtcBannerBeans();
        if (otcBannerBeans == list) {
            d.j("refreshBanner", "otcBannerBeans == list-otcBannerBeans == list>" + CollectionsUtils.b(list));
            return;
        }
        this.f80083j = iVar;
        otcBannerBeans.clear();
        otcBannerBeans.addAll(list);
        this.f80081h.setPages(list.size());
        this.f80080g.f(otcBannerBeans);
        this.f80080g.notifyDataSetChanged();
        this.f80078e.setVisibility(otcBannerBeans.size() > 1 ? 0 : 8);
        if (!otcBannerBeans.isEmpty()) {
            this.f80079f.setPlayDelay(5000);
            if (otcBannerBeans.size() == 1) {
                this.f80079f.setScrollable(false);
                this.f80081h.setVisibility(4);
                return;
            }
            this.f80079f.setScrollable(true);
            this.f80079f.resume();
            this.f80081h.setVisibility(0);
        }
    }

    public void g(List<OtcBannerBean> list, OtcTradePresenter.i iVar, boolean z11) {
        if (list != null && list.size() != 0) {
            setVisibility(0);
            f(list, iVar);
        } else if (getVisibility() != 0 || !z11) {
            setVisibility(8);
            d.j("refreshBanner", "setVisibility(GONE)--isEmpty>" + CollectionsUtils.b(list));
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            int i11 = marginLayoutParams.height;
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, i11});
            ofInt.setDuration(270);
            ofInt.addUpdateListener(new b(marginLayoutParams, i11));
            ofInt.addListener(new c());
            ofInt.start();
        }
    }

    public List<OtcBannerBean> getOtcBannerBeans() {
        return this.f80082i;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f80077d = Math.max(this.f80077d, i12);
    }

    public void setBannerPosition(int i11) {
        if (this.f80079f.getViewPager().getAdapter() != null && this.f80079f.getViewPager().getAdapter().getCount() > i11) {
            this.f80079f.getViewPager().setCurrentItem(i11);
        }
    }

    public OtcTradeBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f80076c = context.obtainStyledAttributes(attributeSet, R$styleable.OtcTradeBannerView).getBoolean(R$styleable.OtcTradeBannerView_isCloseAble, false);
        d(context);
    }
}
