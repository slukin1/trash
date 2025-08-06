package com.huobi.otc.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.p;
import com.hbg.lib.widgets.R$color;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.OtcCoin;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import q10.c;
import vp.n;

public class FastTabLayout extends MagicIndicator {

    /* renamed from: c  reason: collision with root package name */
    public CommonNavigatorAdapter f79805c = null;

    /* renamed from: d  reason: collision with root package name */
    public b f79806d = null;

    /* renamed from: e  reason: collision with root package name */
    public List<OtcCoin> f79807e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f79808f = false;

    /* renamed from: g  reason: collision with root package name */
    public int f79809g;

    /* renamed from: h  reason: collision with root package name */
    public int f79810h;

    /* renamed from: i  reason: collision with root package name */
    public int f79811i;

    public class MyPagerTitleView extends FrameLayout implements c {

        /* renamed from: b  reason: collision with root package name */
        public TextView f79812b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f79813c;

        public MyPagerTitleView(FastTabLayout fastTabLayout, Context context) {
            this(context, (AttributeSet) null);
        }

        public void a(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.f79812b.setText(str);
                this.f79812b.setVisibility(0);
            } else {
                this.f79812b.setVisibility(8);
            }
            this.f79813c.setText(str2);
        }

        public void onDeselected(int i11, int i12) {
            this.f79812b.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorThreeLevelText));
            this.f79813c.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorSecondaryText));
        }

        public void onEnter(int i11, int i12, float f11, boolean z11) {
        }

        public void onLeave(int i11, int i12, float f11, boolean z11) {
        }

        public void onMeasure(int i11, int i12) {
            super.onMeasure(i11, i12);
            int size = View.MeasureSpec.getSize(i11);
            int measuredWidth = FastTabLayout.this.getMeasuredWidth();
            if (measuredWidth <= 0) {
                measuredWidth = PixelUtils.g();
            }
            if (measuredWidth > 0) {
                int size2 = FastTabLayout.this.f79807e == null ? 0 : FastTabLayout.this.f79807e.size();
                if (size2 > 4) {
                    size = (measuredWidth / 14) * 3;
                } else {
                    size = measuredWidth / size2;
                }
            }
            setMeasuredDimension(size, View.MeasureSpec.getSize(i12));
        }

        public void onSelected(int i11, int i12) {
            this.f79812b.setTextColor(FastTabLayout.this.f79810h);
            this.f79813c.setTextColor(FastTabLayout.this.f79811i);
        }

        public MyPagerTitleView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            View inflate = View.inflate(context, R$layout.otc_fast_trade_tab, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            addView(inflate, layoutParams);
            this.f79812b = (TextView) findViewById(R$id.otc_tab_coin_name_cn_txt);
            this.f79813c = (TextView) findViewById(R$id.otc_tab_coin_name_txt);
        }
    }

    public class a extends CommonNavigatorAdapter {
        public a() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            if (FastTabLayout.this.f79806d != null) {
                FastTabLayout.this.f79806d.onItemClick(i11);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            if (FastTabLayout.this.f79807e == null) {
                return 0;
            }
            return FastTabLayout.this.f79807e.size();
        }

        public q10.b getIndicator(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(2);
            linePagerIndicator.setColors(Integer.valueOf(FastTabLayout.this.f79809g));
            linePagerIndicator.setLineHeight(context.getResources().getDimension(R$dimen.global_indicator_height));
            linePagerIndicator.setLineWidth((float) PixelUtils.a(34.0f));
            linePagerIndicator.setRoundRadius(context.getResources().getDimension(R$dimen.global_indicator_radius));
            return linePagerIndicator;
        }

        public c getTitleView(Context context, int i11) {
            MyPagerTitleView myPagerTitleView = new MyPagerTitleView(FastTabLayout.this, context);
            myPagerTitleView.a(FastTabLayout.this.f79808f ? ((OtcCoin) FastTabLayout.this.f79807e.get(i11)).getName() : "", ((OtcCoin) FastTabLayout.this.f79807e.get(i11)).getCoinName());
            myPagerTitleView.setOnClickListener(new n(this, i11));
            return myPagerTitleView;
        }
    }

    public interface b {
        void onItemClick(int i11);
    }

    public FastTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f79808f = p.h(context);
        setHorizontalFadingEdgeEnabled(true);
        setFadingEdgeLength(300);
        Context context2 = getContext();
        int i11 = com.hbg.module.otc.R$color.baseColorMajorTheme100;
        this.f79809g = ContextCompat.getColor(context2, i11);
        this.f79810h = ContextCompat.getColor(getContext(), i11);
        this.f79811i = ContextCompat.getColor(getContext(), i11);
    }

    public void setCallback(b bVar) {
        this.f79806d = bVar;
    }

    public void setData(List<OtcCoin> list) {
        if (this.f79807e == null) {
            this.f79807e = new ArrayList();
        }
        if (!this.f79807e.isEmpty()) {
            this.f79807e.clear();
        }
        this.f79807e.addAll(list);
        if (this.f79807e.size() > 4) {
            setForeground(ContextCompat.getDrawable(getContext(), R$drawable.shape_otc_tab_right_gradient));
            setForegroundGravity(5);
        }
        CommonNavigatorAdapter commonNavigatorAdapter = this.f79805c;
        if (commonNavigatorAdapter == null) {
            this.f79805c = new a();
            CommonNavigator commonNavigator = new CommonNavigator(getContext());
            commonNavigator.setSmoothScroll(true);
            commonNavigator.setAdapter(this.f79805c);
            commonNavigator.setIndicatorOnTop(true);
            setNavigator(commonNavigator);
            return;
        }
        commonNavigatorAdapter.notifyDataSetChanged();
    }

    public void setIndicatorColor(int i11) {
        this.f79809g = i11;
    }

    public void setSubTitleSelectColor(int i11) {
        this.f79811i = i11;
    }

    public void setTitleSelectColor(int i11) {
        this.f79810h = i11;
    }
}
