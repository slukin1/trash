package com.huobi.finance.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.ViewPager;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.module.asset.R$font;
import com.hbg.module.asset.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import java.util.Map;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import q10.b;
import q10.c;

public class BalanceNavigatorAdapter extends CommonNavigatorAdapter {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<BalanceColorTransitionPagerTitleView> f46377a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public LinePagerIndicator f46378b;

    /* renamed from: c  reason: collision with root package name */
    public int f46379c;

    /* renamed from: d  reason: collision with root package name */
    public int f46380d;

    /* renamed from: e  reason: collision with root package name */
    public int f46381e = PixelUtils.a(15.0f);

    /* renamed from: f  reason: collision with root package name */
    public float f46382f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f46383g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f46384h;

    /* renamed from: i  reason: collision with root package name */
    public ViewPager f46385i;

    public class BalanceColorTransitionPagerTitleView extends ColorTransitionPagerTitleView {

        /* renamed from: d  reason: collision with root package name */
        public boolean f46386d = false;

        /* renamed from: e  reason: collision with root package name */
        public int f46387e;

        public BalanceColorTransitionPagerTitleView(Context context, int i11) {
            super(context);
            this.f46387e = i11;
        }

        public boolean b() {
            return this.f46386d;
        }

        public void onDeselected(int i11, int i12) {
            this.f46386d = false;
        }

        public void onSelected(int i11, int i12) {
            this.f46386d = this.f46387e == i11;
        }
    }

    public BalanceNavigatorAdapter(ViewPager viewPager, List<String> list, int i11, int i12) {
        this.f46385i = viewPager;
        this.f46384h = list;
        this.f46379c = i11;
        this.f46380d = i12;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
        Resources resources = view.getContext().getResources();
        this.f46385i.setCurrentItem(i11);
        if (resources.getString(R$string.margin_toolbar_header_title).equals(this.f46384h.get(i11))) {
            BaseModuleConfig.a().b("220", (Map<String, Object>) null);
        } else if (resources.getString(R$string.n_spot).equals(this.f46384h.get(i11))) {
            BaseModuleConfig.a().b("255", (Map<String, Object>) null);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void b(int i11, int i12, float f11, float f12, int i13) {
        this.f46379c = i11;
        this.f46380d = i12;
        this.f46382f = f11;
        this.f46383g = f12;
        LinePagerIndicator linePagerIndicator = this.f46378b;
        if (linePagerIndicator != null) {
            linePagerIndicator.setAlpha(f12);
            this.f46378b.setColors(Integer.valueOf(i13));
        }
        SparseArray<BalanceColorTransitionPagerTitleView> sparseArray = this.f46377a;
        if (sparseArray != null && sparseArray.size() != 0) {
            int size = this.f46377a.size();
            for (int i14 = 0; i14 < size; i14++) {
                BalanceColorTransitionPagerTitleView valueAt = this.f46377a.valueAt(i14);
                if (valueAt != null) {
                    valueAt.setTypeface(ResourcesCompat.h(valueAt.getContext(), R$font.roboto_medium));
                    valueAt.setTextColor(valueAt.b() ? i12 : i11);
                    valueAt.setSelectedColor(this.f46380d);
                    valueAt.setNormalColor(this.f46379c);
                    valueAt.setAlpha(this.f46382f);
                }
            }
        }
    }

    public int getCount() {
        List<String> list = this.f46384h;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public b getIndicator(Context context) {
        if (this.f46378b == null) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            this.f46378b = linePagerIndicator;
            linePagerIndicator.setColors(Integer.valueOf(this.f46380d));
            this.f46378b.setMode(0);
            this.f46378b.setLineWidth((float) PixelUtils.a(17.5f));
            this.f46378b.setLineHeight(context.getResources().getDimension(R$dimen.global_indicator_height));
        }
        this.f46378b.setAlpha(this.f46383g);
        return this.f46378b;
    }

    public c getTitleView(Context context, int i11) {
        int i12;
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            i12 = PixelUtils.a(20.5f);
        } else {
            i12 = PixelUtils.a(15.0f);
        }
        this.f46381e = i12;
        BalanceColorTransitionPagerTitleView balanceColorTransitionPagerTitleView = this.f46377a.get(i11);
        if (balanceColorTransitionPagerTitleView == null) {
            balanceColorTransitionPagerTitleView = new BalanceColorTransitionPagerTitleView(context, i11);
            balanceColorTransitionPagerTitleView.getPaint().setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
            int i13 = this.f46381e;
            balanceColorTransitionPagerTitleView.setPadding(i13, 0, i13, 0);
            balanceColorTransitionPagerTitleView.setText(this.f46384h.get(i11));
            balanceColorTransitionPagerTitleView.setClickable(true);
            balanceColorTransitionPagerTitleView.setOnClickListener(new w2(this, i11));
            balanceColorTransitionPagerTitleView.setAllCaps(false);
            balanceColorTransitionPagerTitleView.setTextSize(14.0f);
            this.f46377a.put(i11, balanceColorTransitionPagerTitleView);
        }
        balanceColorTransitionPagerTitleView.setAlpha(this.f46382f);
        balanceColorTransitionPagerTitleView.setNormalColor(this.f46379c);
        balanceColorTransitionPagerTitleView.setSelectedColor(this.f46380d);
        return balanceColorTransitionPagerTitleView;
    }
}
