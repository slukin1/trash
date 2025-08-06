package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.ViewUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import k20.h;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;

public class IndexTextListIndicator extends MagicIndicator {

    /* renamed from: c  reason: collision with root package name */
    public CommonNavigatorAdapter f71421c;

    /* renamed from: d  reason: collision with root package name */
    public CommonNavigator f71422d;

    /* renamed from: e  reason: collision with root package name */
    public List<y9.b> f71423e;

    /* renamed from: f  reason: collision with root package name */
    public d f71424f;

    /* renamed from: g  reason: collision with root package name */
    public int f71425g;

    /* renamed from: h  reason: collision with root package name */
    public int f71426h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f71427i;

    /* renamed from: j  reason: collision with root package name */
    public int f71428j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f71429k;

    /* renamed from: l  reason: collision with root package name */
    public e f71430l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f71431m;

    public class a extends CommonNavigatorAdapter {
        public a() {
        }

        public int getCount() {
            if (IndexTextListIndicator.this.f71423e == null) {
                return 0;
            }
            return IndexTextListIndicator.this.f71423e.size();
        }

        public q10.b getIndicator(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setRoundRadius((float) PixelUtils.a(2.0f));
            linePagerIndicator.setMode(2);
            linePagerIndicator.setLineHeight((float) PixelUtils.a(0.0f));
            return linePagerIndicator;
        }

        public q10.c getTitleView(Context context, int i11) {
            IndexTextListIndicator indexTextListIndicator = IndexTextListIndicator.this;
            return indexTextListIndicator.k(context, i11, indexTextListIndicator.f71423e);
        }
    }

    public class b implements CommonPagerTitleView.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextView f71433a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f71434b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f71435c;

        public b(TextView textView, Context context, boolean z11) {
            this.f71433a = textView;
            this.f71434b = context;
            this.f71435c = z11;
        }

        public void onDeselected(int i11, int i12) {
            this.f71433a.setTextColor(ContextCompat.getColor(this.f71434b, R$color.baseColorSecondaryTextNew));
            this.f71433a.setTextSize(1, 14.0f);
            this.f71433a.setTypeface(ResourcesCompat.h(this.f71434b, R$font.roboto_regular));
        }

        public void onEnter(int i11, int i12, float f11, boolean z11) {
        }

        public void onLeave(int i11, int i12, float f11, boolean z11) {
        }

        public void onSelected(int i11, int i12) {
            this.f71433a.setTextColor(ContextCompat.getColor(this.f71434b, R$color.baseColorPrimaryText));
            this.f71433a.setTextSize(1, 20.0f);
            this.f71433a.setTypeface(ResourcesCompat.h(this.f71434b, R$font.roboto_medium));
            if (!this.f71435c || IndexTextListIndicator.this.f71429k == null) {
                boolean unused = IndexTextListIndicator.this.f71431m = false;
                return;
            }
            IndexTextListIndicator.this.f71429k.setVisibility(8);
            boolean unused2 = IndexTextListIndicator.this.f71431m = true;
            if (IndexTextListIndicator.this.f71430l != null) {
                SP.r("key_rank_new_symbol_red_dot_time", IndexTextListIndicator.this.f71430l.f71439a);
            }
        }
    }

    public class c implements CommonPagerTitleView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonPagerTitleView f71437a;

        public c(CommonPagerTitleView commonPagerTitleView) {
            this.f71437a = commonPagerTitleView;
        }

        public int getContentBottom() {
            return this.f71437a.getBottom() + this.f71437a.getPaddingBottom();
        }

        public int getContentLeft() {
            return this.f71437a.getLeft() + this.f71437a.getPaddingLeft();
        }

        public int getContentRight() {
            return (this.f71437a.getLeft() + this.f71437a.getWidth()) - this.f71437a.getPaddingRight();
        }

        public int getContentTop() {
            return this.f71437a.getTop() + this.f71437a.getPaddingTop();
        }
    }

    public interface d {
        void a(int i11, View view);

        void onItemClick(int i11);
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public long f71439a;

        public e(long j11) {
            this.f71439a = j11;
        }
    }

    public IndexTextListIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CommonTextListIndicator, 0, 0);
            boolean z11 = obtainStyledAttributes.getBoolean(R$styleable.CommonTextListIndicator_use_transparent_pic, false);
            this.f71427i = z11;
            if (z11) {
                this.f71426h = obtainStyledAttributes.getResourceId(R$styleable.CommonTextListIndicator_cover_bg_res, R$drawable.sidebar_transparent_pic);
            } else {
                this.f71426h = obtainStyledAttributes.getResourceId(R$styleable.CommonTextListIndicator_cover_bg_res, R$drawable.market_indicator_shadow);
            }
            obtainStyledAttributes.recycle();
        }
        l(context);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m(int i11, View view) {
        d dVar = this.f71424f;
        if (dVar != null) {
            dVar.onItemClick(i11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public List<y9.b> getList() {
        return this.f71423e;
    }

    public CommonNavigator getmCommonNavigator() {
        return this.f71422d;
    }

    public final void j() {
        View view = new View(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f71425g, -1);
        layoutParams.gravity = 8388613;
        view.setLayoutParams(layoutParams);
        view.setBackgroundResource(this.f71426h);
        addView(view);
    }

    public final q10.c k(Context context, int i11, List<y9.b> list) {
        CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_index_page_title, (ViewGroup) null);
        int a11 = PixelUtils.a(8.0f);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.icon_iv);
        TextView textView = (TextView) inflate.findViewById(R$id.title_tv);
        imageView.setVisibility(8);
        y9.b bVar = list.get(i11);
        textView.setText(bVar.b());
        boolean z11 = bVar.f76827c;
        if (z11) {
            EventBus.d().p(this);
            this.f71429k = (ImageView) inflate.findViewById(R$id.iv_red_dot);
        }
        if (!TextUtils.isEmpty(bVar.c())) {
            f6.c.a().f(imageView, bVar.c(), R$drawable.default_icon);
            imageView.setVisibility(0);
        }
        commonPagerTitleView.setContentView(inflate);
        commonPagerTitleView.setPadding(a11, 0, a11, 0);
        commonPagerTitleView.setOnPagerTitleChangeListener(new b(textView, context, z11));
        commonPagerTitleView.setContentPositionDataProvider(new c(commonPagerTitleView));
        commonPagerTitleView.setOnClickListener(new u0(this, i11));
        d dVar = this.f71424f;
        if (dVar != null) {
            dVar.a(i11, inflate);
        }
        return commonPagerTitleView;
    }

    public final void l(Context context) {
        this.f71428j = (ViewUtil.f(context) / 5) - 5;
        this.f71425g = getResources().getDimensionPixelOffset(R$dimen.dimen_30);
    }

    public void n(List<y9.b> list, boolean z11) {
        if (this.f71423e == null) {
            this.f71423e = new ArrayList();
        }
        if (list != null) {
            this.f71423e.clear();
            this.f71423e.addAll(list);
        }
        CommonNavigatorAdapter commonNavigatorAdapter = this.f71421c;
        if (commonNavigatorAdapter == null) {
            this.f71421c = new a();
            CommonNavigator commonNavigator = new CommonNavigator(getContext());
            this.f71422d = commonNavigator;
            commonNavigator.setPadding(PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f), 0);
            this.f71422d.setAdapter(this.f71421c);
            this.f71422d.setSmoothScroll(true);
            this.f71422d.setAdjustMode(z11);
            setNavigator(this.f71422d);
            return;
        }
        commonNavigatorAdapter.notifyDataSetChanged();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onReceiveRetDotEvent(e eVar) {
        ImageView imageView = this.f71429k;
        if (imageView != null) {
            this.f71430l = eVar;
            if (this.f71431m) {
                SP.r("key_rank_new_symbol_red_dot_time", eVar.f71439a);
            } else {
                imageView.setVisibility(0);
            }
        }
    }

    public void setCallback(d dVar) {
        this.f71424f = dVar;
    }

    public void setDataList(List<y9.b> list) {
        n(list, false);
    }

    public void setNavigator(p10.a aVar) {
        super.setNavigator(aVar);
        j();
    }
}
