package com.huobi.trade.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cpiz.android.bubbleview.d;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroPositionProfitInfoBean;
import com.hbg.lib.network.hbg.core.bean.NewBannerBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.libkt.helper.SensorsDataHelper;
import com.hbg.module.libkt.utils.f;
import com.huobi.R$styleable;
import com.huobi.trade.helper.l;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import f6.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import pro.huobi.R;
import rx.Subscription;
import u6.g;

public class TradeHeadView extends LinearLayout {
    public TextPaint A;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f82399b;

    /* renamed from: c  reason: collision with root package name */
    public View f82400c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f82401d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f82402e;

    /* renamed from: f  reason: collision with root package name */
    public View f82403f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, Boolean> f82404g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f82405h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f82406i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f82407j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f82408k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f82409l;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f82410m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f82411n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f82412o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f82413p;

    /* renamed from: q  reason: collision with root package name */
    public View f82414q;

    /* renamed from: r  reason: collision with root package name */
    public View f82415r;

    /* renamed from: s  reason: collision with root package name */
    public String f82416s;

    /* renamed from: t  reason: collision with root package name */
    public TradeType f82417t;

    /* renamed from: u  reason: collision with root package name */
    public b f82418u;

    /* renamed from: v  reason: collision with root package name */
    public int f82419v;

    /* renamed from: w  reason: collision with root package name */
    public int[] f82420w;

    /* renamed from: x  reason: collision with root package name */
    public int f82421x;

    /* renamed from: y  reason: collision with root package name */
    public int f82422y;

    /* renamed from: z  reason: collision with root package name */
    public List<Subscription> f82423z;

    public class a extends BaseSubscriber<ActivityZeroPositionProfitInfoBean> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(ActivityZeroPositionProfitInfoBean activityZeroPositionProfitInfoBean) {
            super.onNext(activityZeroPositionProfitInfoBean);
            if (activityZeroPositionProfitInfoBean != null && activityZeroPositionProfitInfoBean.getProfitNotice() != null && activityZeroPositionProfitInfoBean.getProfitNotice().intValue() == 0 && activityZeroPositionProfitInfoBean.getHighestProfitFlag() != null && 1 == activityZeroPositionProfitInfoBean.getHighestProfitFlag().intValue()) {
                f.g(TradeHeadView.this.getContext(), R.string.n_zero_swap_position_upper_limit_tips, TradeHeadView.this.f82406i, new d(4, 2), (Integer) null, (d10.a<Unit>) null);
                v7.b.a().activityZeroNoticeSure(4).b().compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber());
            }
        }
    }

    public interface b {
        void D(View view);

        void Q(View view);

        void R(View view);

        void a0(View view);

        void e(View view);

        void g0(View view, String str);

        void s(View view);
    }

    public TradeHeadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(View view) {
        b bVar = this.f82418u;
        if (bVar != null) {
            bVar.Q(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(Void voidR) {
        b bVar = this.f82418u;
        if (bVar != null) {
            bVar.s(this.f82400c);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void p(View view) {
        b bVar = this.f82418u;
        if (bVar != null) {
            bVar.D(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q(View view) {
        b bVar = this.f82418u;
        if (bVar != null) {
            bVar.a0(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void r(View view) {
        b bVar = this.f82418u;
        if (bVar != null) {
            bVar.R(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void s(View view) {
        is.a.j("4307", (Map<String, Object>) null, "1000048");
        b bVar = this.f82418u;
        if (bVar != null) {
            bVar.e(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void t(View view) {
        b bVar = this.f82418u;
        if (bVar != null) {
            bVar.g0(view, this.f82416s);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void u(String str, NewBannerBean.BannerAdv bannerAdv, View view) {
        if (str != null && !str.isEmpty()) {
            BaseModuleConfig.a().k0(str);
            HashMap hashMap = new HashMap();
            hashMap.put("business_category", "top_ad");
            hashMap.put("button_name", "top_ad_go");
            hashMap.put("banner_id", bannerAdv.getAdvId());
            hashMap.put("banner_name", bannerAdv.getTitle());
            SensorsDataHelper.track("appclick_contracts", hashMap);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int[] getRightPopIvLocation() {
        int[] iArr = new int[2];
        this.f82402e.getLocationOnScreen(iArr);
        return iArr;
    }

    public int getRightPopIvMarginRight() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f82402e.getLayoutParams();
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public int getRightPopIvWidth() {
        return this.f82402e.getWidth();
    }

    public int[] getSymbolChangeIvLocation() {
        int[] iArr = new int[2];
        this.f82408k.getLocationOnScreen(iArr);
        return iArr;
    }

    public int getSymbolChangeIvWidth() {
        return this.f82408k.getWidth();
    }

    public ImageView getTradeKlineIv() {
        return this.f82405h;
    }

    public View getTradeRightPopIv() {
        return this.f82402e;
    }

    public final void j() {
        this.f82405h.setOnClickListener(new a2(this));
        dw.a.a(this.f82400c).throttleFirst(1, TimeUnit.SECONDS).subscribe(new h2(this));
        this.f82402e.setOnClickListener(new e2(this));
        this.f82407j.setOnClickListener(new d2(this));
        this.f82408k.setOnClickListener(new c2(this));
        this.f82413p.setOnClickListener(new f2(this));
        b2 b2Var = new b2(this);
        this.f82409l.setOnClickListener(b2Var);
        this.f82410m.setOnClickListener(b2Var);
    }

    public void k(String str, boolean z11) {
        int i11;
        boolean z12;
        this.f82404g.put(str, Boolean.valueOf(z11));
        Iterator<Boolean> it2 = this.f82404g.values().iterator();
        while (true) {
            i11 = 0;
            if (it2.hasNext()) {
                if (it2.next().booleanValue()) {
                    z12 = true;
                    break;
                }
            } else {
                z12 = false;
                break;
            }
        }
        View view = this.f82403f;
        if (!z12) {
            i11 = 4;
        }
        view.setVisibility(i11);
    }

    public final int l(int i11) {
        int measureText;
        int measureText2;
        this.A.set(this.f82401d.getPaint());
        int measureText3 = ((int) this.A.measureText(this.f82401d.getText().toString())) - i11;
        if (i11 < 0) {
            do {
                float textSize = this.A.getTextSize();
                int i12 = this.f82421x;
                if (textSize >= ((float) i12)) {
                    return i12;
                }
                TextPaint textPaint = this.A;
                textPaint.setTextSize(textPaint.getTextSize() + 1.0f);
                measureText2 = (int) this.A.measureText(this.f82401d.getText().toString());
                if (measureText2 == measureText3) {
                    return (int) this.A.getTextSize();
                }
            } while (measureText2 <= measureText3);
            return ((int) this.A.getTextSize()) - 1;
        }
        do {
            float textSize2 = this.A.getTextSize();
            int i13 = this.f82422y;
            if (textSize2 <= ((float) i13)) {
                return i13;
            }
            TextPaint textPaint2 = this.A;
            textPaint2.setTextSize(textPaint2.getTextSize() - 1.0f);
            measureText = (int) this.A.measureText(this.f82401d.getText().toString());
            if (measureText == measureText3) {
                return (int) this.A.getTextSize();
            }
        } while (measureText >= measureText3);
        return ((int) this.A.getTextSize()) - 1;
    }

    public final void m(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_trade_head, this, true);
        this.f82399b = (ImageView) findViewById(R.id.trade_drawer_iv);
        this.f82401d = (TextView) findViewById(R.id.trade_head_symbol_tv);
        this.f82400c = findViewById(R.id.trade_drawer_iv_wapper);
        this.f82405h = (ImageView) findViewById(R.id.trade_kline_iv);
        this.f82406i = (ImageView) findViewById(R.id.ivTradeActivity);
        this.f82402e = (ImageView) findViewById(R.id.trade_right_pop_iv);
        this.f82403f = findViewById(R.id.tradeRightPopRedDot);
        this.f82407j = (ImageView) findViewById(R.id.trade_description_iv);
        this.f82408k = (ImageView) findViewById(R.id.trade_symbol_change_iv);
        this.f82411n = (TextView) findViewById(R.id.trade_price_change_tv);
        this.f82412o = (ImageView) findViewById(R.id.trade_reminder_tv);
        this.f82415r = findViewById(R.id.divider_view);
        this.f82413p = (TextView) findViewById(R.id.margin_lever_tv);
        this.f82409l = (ImageView) findViewById(R.id.grid_entrance_iv);
        this.f82410m = (ImageView) findViewById(R.id.grid_entrance_new_iv);
        this.f82414q = findViewById(R.id.ll_right);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.TradeHeadView);
        if (obtainStyledAttributes != null) {
            int integer = obtainStyledAttributes.getInteger(0, 2);
            if (integer == 0) {
                this.f82407j.setVisibility(0);
            } else if (integer == 1) {
                this.f82407j.setVisibility(4);
            } else if (integer != 2) {
                this.f82407j.setVisibility(8);
            } else {
                this.f82407j.setVisibility(8);
            }
            int integer2 = obtainStyledAttributes.getInteger(5, 0);
            if (integer2 == 0) {
                this.f82408k.setVisibility(0);
            } else if (integer2 == 1) {
                this.f82408k.setVisibility(4);
            } else if (integer2 != 2) {
                this.f82408k.setVisibility(8);
            } else {
                this.f82408k.setVisibility(8);
            }
            int integer3 = obtainStyledAttributes.getInteger(4, 2);
            if (integer3 == 0) {
                this.f82412o.setVisibility(0);
            } else if (integer3 == 1) {
                this.f82412o.setVisibility(4);
            } else if (integer3 != 2) {
                this.f82412o.setVisibility(8);
            } else {
                this.f82412o.setVisibility(8);
            }
            int integer4 = obtainStyledAttributes.getInteger(1, 2);
            if (integer4 == 0) {
                this.f82415r.setVisibility(8);
            } else if (integer4 == 1) {
                this.f82415r.setVisibility(8);
            } else if (integer4 != 2) {
                this.f82415r.setVisibility(8);
            } else {
                this.f82415r.setVisibility(8);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, PixelUtils.a(20.0f));
            this.f82421x = dimensionPixelSize;
            this.f82422y = dimensionPixelSize - PixelUtils.a(8.0f);
            this.f82401d.setTextSize(0, (float) PixelUtils.h((float) this.f82421x));
            obtainStyledAttributes.recycle();
        }
        this.f82419v = PixelUtils.g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("合约", getClass().getSimpleName() + "-onDetachedFromWindow");
        for (int i11 = 0; i11 < this.f82423z.size(); i11++) {
            Subscription subscription = this.f82423z.get(i11);
            if (subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.f82411n.getLocationOnScreen(this.f82420w);
        int width = ((this.f82420w[0] + this.f82411n.getWidth()) + this.f82414q.getWidth()) - this.f82419v;
        if (width != 0) {
            if (width >= 0 || this.f82411n.getTextSize() != ((float) this.f82421x)) {
                int l11 = l(width);
                int i15 = this.f82422y;
                if (l11 < i15 || l11 >= (i15 = this.f82421x)) {
                    l11 = i15;
                }
                float f11 = (float) l11;
                if (this.f82401d.getTextSize() != f11) {
                    this.f82401d.setTextSize(0, f11);
                }
            }
        }
    }

    public void setCalculatorVisibility(int i11) {
    }

    public void setGridEntranceVisible(boolean z11) {
    }

    public void setKlineVisibility(int i11) {
        this.f82405h.setVisibility(i11);
    }

    public void setMarginLeverText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f82413p.setVisibility(8);
            return;
        }
        this.f82413p.setText(str);
        this.f82413p.setVisibility(0);
    }

    public void setOnHeadClickListener(b bVar) {
        this.f82418u = bVar;
    }

    public void setReminderBg(int i11) {
        this.f82412o.setImageResource(i11);
    }

    public void setReminderTvOnClickListener(View.OnClickListener onClickListener) {
        this.f82412o.setOnClickListener(onClickListener);
    }

    public void setReminderTvVisible(boolean z11) {
        ViewUtil.m(this.f82412o, z11);
    }

    public void setRightPopDotVisibility(int i11) {
        this.f82403f.setVisibility(i11);
    }

    public void setRightPopVisibility(int i11) {
        this.f82402e.setVisibility(i11);
    }

    public void setSymbol(String str) {
        this.f82416s = str;
    }

    public void setTradeActivity(List<NewBannerBean.BannerAdv> list) {
        Log.d("合约", getClass().getSimpleName() + "-设置顶部右侧资源位: " + com.hbg.module.libkt.base.ext.f.e().toJson((Object) list));
        if (list.isEmpty()) {
            this.f82406i.setVisibility(8);
            return;
        }
        NewBannerBean.BannerAdv bannerAdv = list.get(0);
        if (NightHelper.e().g()) {
            c.a().e(this.f82406i, bannerAdv.getNightImageUrl());
        } else {
            c.a().e(this.f82406i, bannerAdv.getImageUrl());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "top_ad");
        hashMap.put("banner_id", bannerAdv.getAdvId());
        hashMap.put("banner_name", bannerAdv.getTitle());
        SensorsDataHelper.track("pageview_contracts", hashMap);
        String jumpTo = bannerAdv.getJumpTo();
        this.f82406i.setOnClickListener(new g2(jumpTo, bannerAdv));
        this.f82406i.setVisibility(0);
        if (jumpTo.contains("/contract/activityZero")) {
            this.f82423z.add(v7.b.a().activityZeroPositionProfitInfo().b().compose(RxJavaHelper.t((g) null)).subscribe(new a()));
        }
    }

    public void setTradePriceChangeTvVisible(boolean z11) {
        ViewUtil.m(this.f82411n, z11);
    }

    public void setTradeType(TradeType tradeType) {
        this.f82417t = tradeType;
    }

    public void v(String str, int i11, int i12) {
        this.f82411n.setText(str);
        this.f82411n.setTextColor(i11);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.argb(15, Color.red(i11), Color.green(i11), Color.blue(i11)));
        gradientDrawable.setCornerRadius((float) PixelUtils.a(2.0f));
        this.f82411n.setBackgroundDrawable(gradientDrawable);
    }

    public void w() {
        l.b().e();
    }

    public void x(String str) {
        this.f82401d.setText(str);
        if (!TextUtils.isEmpty(str) && this.f82412o.getVisibility() == 0) {
            if (str.length() <= 9) {
                this.f82401d.setTextSize(1, 20.0f);
            } else if (str.length() <= 11) {
                this.f82401d.setTextSize(1, 16.0f);
            } else {
                this.f82401d.setTextSize(1, 12.0f);
            }
        }
        if (!TextUtils.isEmpty(str) && this.f82401d.getWidth() == 0) {
            ViewGroup.LayoutParams layoutParams = this.f82401d.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.f82401d.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public TradeHeadView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f82404g = new HashMap<>();
        this.f82420w = new int[2];
        this.f82423z = new ArrayList();
        this.A = new TextPaint();
        m(attributeSet);
        j();
    }
}
