package com.hbg.lib.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import q10.c;

public class IndexTextListCompactIndicator extends MagicIndicator {

    /* renamed from: c  reason: collision with root package name */
    public CommonNavigatorAdapter f71416c;

    /* renamed from: d  reason: collision with root package name */
    public CommonNavigator f71417d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f71418e;

    /* renamed from: f  reason: collision with root package name */
    public b f71419f;

    public class a extends CommonNavigatorAdapter {
        public a() {
        }

        public int getCount() {
            if (IndexTextListCompactIndicator.this.f71418e == null) {
                return 0;
            }
            return IndexTextListCompactIndicator.this.f71418e.size();
        }

        public q10.b getIndicator(Context context) {
            return null;
        }

        public c getTitleView(Context context, int i11) {
            IndexTextListCompactIndicator indexTextListCompactIndicator = IndexTextListCompactIndicator.this;
            return indexTextListCompactIndicator.g(context, i11, indexTextListCompactIndicator.f71418e);
        }
    }

    public interface b {
        void a(int i11, View view);

        void onItemClick(int i11);
    }

    public IndexTextListCompactIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i(context);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void j(int i11, View view) {
        b bVar = this.f71419f;
        if (bVar != null) {
            bVar.onItemClick(i11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final SimplePagerTitleView g(Context context, int i11, List<String> list) {
        SimplePagerTitleView h11 = h(context, list.get(i11));
        h11.setClickable(true);
        h11.setOnClickListener(new t0(this, i11));
        b bVar = this.f71419f;
        if (bVar != null) {
            bVar.a(i11, h11);
        }
        return h11;
    }

    public List<String> getList() {
        return this.f71418e;
    }

    public CommonNavigator getmCommonNavigator() {
        return this.f71417d;
    }

    public final SimplePagerTitleView h(Context context, String str) {
        ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
        colorTransitionPagerTitleView.setNormalColor(ContextCompat.getColor(context, R$color.baseColorSecondaryText));
        colorTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(context, R$color.baseColorPrimaryText));
        colorTransitionPagerTitleView.getPaint().setFakeBoldText(true);
        colorTransitionPagerTitleView.setText(str);
        return colorTransitionPagerTitleView;
    }

    public final void i(Context context) {
    }

    public void k(List<String> list, boolean z11) {
        if (this.f71418e == null) {
            this.f71418e = new ArrayList();
        }
        if (list != null) {
            this.f71418e.clear();
            this.f71418e.addAll(list);
        }
        CommonNavigatorAdapter commonNavigatorAdapter = this.f71416c;
        if (commonNavigatorAdapter == null) {
            this.f71416c = new a();
            CommonNavigator commonNavigator = new CommonNavigator(getContext());
            this.f71417d = commonNavigator;
            commonNavigator.setAdapter(this.f71416c);
            this.f71417d.setSmoothScroll(true);
            this.f71417d.setAdjustMode(z11);
            setNavigator(this.f71417d);
            return;
        }
        commonNavigatorAdapter.notifyDataSetChanged();
    }

    public void setCallback(b bVar) {
        this.f71419f = bVar;
    }

    public void setDataList(List<String> list) {
        k(list, false);
    }

    public void setNavigator(p10.a aVar) {
        super.setNavigator(aVar);
    }
}
