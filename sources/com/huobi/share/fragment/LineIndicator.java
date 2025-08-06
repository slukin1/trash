package com.huobi.share.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import pro.huobi.R;
import q10.b;
import q10.c;

public class LineIndicator extends MagicIndicator {

    /* renamed from: c  reason: collision with root package name */
    public CommonNavigatorAdapter f80966c;

    /* renamed from: d  reason: collision with root package name */
    public CommonNavigator f80967d;

    /* renamed from: e  reason: collision with root package name */
    public int f80968e = 0;

    public class a extends CommonNavigatorAdapter {
        public a() {
        }

        public int getCount() {
            return LineIndicator.this.f80968e;
        }

        public b getIndicator(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(0);
            linePagerIndicator.setColors(Integer.valueOf(ContextCompat.getColor(LineIndicator.this.getContext(), R.color.baseColorContentBackground)));
            return linePagerIndicator;
        }

        public c getTitleView(Context context, int i11) {
            return LineIndicator.this.g(context, i11);
        }
    }

    public LineIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i(context);
    }

    public final void f() {
        View view = new View(getContext());
        new FrameLayout.LayoutParams(0, -1);
        addView(view);
    }

    public final SimplePagerTitleView g(Context context, int i11) {
        return h(context, "_");
    }

    public CommonNavigator getmCommonNavigator() {
        return this.f80967d;
    }

    public final SimplePagerTitleView h(Context context, String str) {
        SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
        simplePagerTitleView.setText("_");
        return simplePagerTitleView;
    }

    public final void i(Context context) {
        CommonNavigatorAdapter commonNavigatorAdapter = this.f80966c;
        if (commonNavigatorAdapter == null) {
            this.f80966c = new a();
            CommonNavigator commonNavigator = new CommonNavigator(getContext());
            this.f80967d = commonNavigator;
            commonNavigator.setAdapter(this.f80966c);
            this.f80967d.setSmoothScroll(true);
            this.f80967d.setAdjustMode(true);
            setNavigator(this.f80967d);
            return;
        }
        commonNavigatorAdapter.notifyDataSetChanged();
    }

    public void setData(int i11) {
        this.f80968e = i11;
        CommonNavigatorAdapter commonNavigatorAdapter = this.f80966c;
        if (commonNavigatorAdapter != null) {
            commonNavigatorAdapter.notifyDataSetChanged();
        }
    }

    public void setNavigator(p10.a aVar) {
        super.setNavigator(aVar);
        f();
    }
}
