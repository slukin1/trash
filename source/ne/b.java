package ne;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.module.libkt.R$color;
import com.hbg.module.libkt.R$drawable;
import com.hbg.module.libkt.custom.indicator.CoIndicator;
import com.hbg.module.libkt.custom.indicator.TabData;
import com.hbg.module.libkt.custom.indicator.navigator.CommonNavigator;
import com.hbg.module.libkt.custom.indicator.navigator.adapter.NavigatorAdapter;
import com.hbg.module.libkt.custom.indicator.navigator.indicators.LinePagerIndicator;
import com.hbg.module.libkt.custom.indicator.navigator.titles.PagerTitleView;
import com.hbg.module.libkt.custom.indicator.navigator.titles.RedPointPagerTitleView;
import com.hbg.module.libkt.utils.r;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import java.util.ArrayList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f25319a = new b();

    public static final class a extends NavigatorAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List<TabData> f25320b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f25321c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f25322d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f25323e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f25324f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float f25325g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f25326h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ float f25327i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ float f25328j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ int f25329k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ int f25330l;

        /* renamed from: m  reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f25331m;

        /* renamed from: n  reason: collision with root package name */
        public final /* synthetic */ c f25332n;

        /* renamed from: ne.b$a$a  reason: collision with other inner class name */
        public static final class C0219a implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f25333b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f25334c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ViewPager2 f25335d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f25336e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f25337f;

            public C0219a(View view, long j11, ViewPager2 viewPager2, int i11, c cVar) {
                this.f25333b = view;
                this.f25334c = j11;
                this.f25335d = viewPager2;
                this.f25336e = i11;
                this.f25337f = cVar;
            }

            @SensorsDataInstrumented
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                r rVar = r.f24939a;
                if (currentTimeMillis - rVar.b(this.f25333b) > this.f25334c || (this.f25333b instanceof Checkable)) {
                    rVar.e(this.f25333b, currentTimeMillis);
                    RedPointPagerTitleView redPointPagerTitleView = (RedPointPagerTitleView) this.f25333b;
                    this.f25335d.setCurrentItem(this.f25336e, false);
                    c cVar = this.f25337f;
                    if (cVar != null) {
                        cVar.a(this.f25336e);
                    }
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public a(List<TabData> list, float f11, Context context, int i11, int i12, float f12, float f13, float f14, float f15, int i13, int i14, ViewPager2 viewPager2, c cVar) {
            this.f25320b = list;
            this.f25321c = f11;
            this.f25322d = context;
            this.f25323e = i11;
            this.f25324f = i12;
            this.f25325g = f12;
            this.f25326h = f13;
            this.f25327i = f14;
            this.f25328j = f15;
            this.f25329k = i13;
            this.f25330l = i14;
            this.f25331m = viewPager2;
            this.f25332n = cVar;
        }

        public int a() {
            return this.f25320b.size();
        }

        public pe.b b(Context context) {
            return null;
        }

        public pe.c c(Context context, int i11) {
            RedPointPagerTitleView b11 = b.f25319a.b(context, this.f25320b.get(i11).getName(), this.f25321c, this.f25322d.getResources().getColor(this.f25323e), this.f25322d.getResources().getColor(this.f25324f), this.f25325g, this.f25326h, this.f25327i, this.f25328j);
            PagerTitleView pagerTitle = b11.getPagerTitle();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) (pagerTitle != null ? pagerTitle.getLayoutParams() : null);
            if (layoutParams != null) {
                layoutParams.setMarginEnd(com.hbg.module.libkt.base.ext.c.d(Float.valueOf(8.0f)));
            }
            PagerTitleView pagerTitle2 = b11.getPagerTitle();
            if (pagerTitle2 != null) {
                pagerTitle2.setSelectedBgColor(this.f25329k);
            }
            PagerTitleView pagerTitle3 = b11.getPagerTitle();
            if (pagerTitle3 != null) {
                pagerTitle3.setNormalBgColor(this.f25330l);
            }
            r rVar = r.f24939a;
            b11.setOnClickListener(new C0219a(b11, 800, this.f25331m, i11, this.f25332n));
            return b11;
        }
    }

    /* renamed from: ne.b$b  reason: collision with other inner class name */
    public static final class C0220b extends NavigatorAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList<TabData> f25338b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f25339c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f25340d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f25341e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f25342f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f25343g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Float f25344h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Integer f25345i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Integer f25346j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ c f25347k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f25348l;

        /* renamed from: ne.b$b$a */
        public static final class a implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f25349b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f25350c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ c f25351d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f25352e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ ViewPager2 f25353f;

            public a(View view, long j11, c cVar, int i11, ViewPager2 viewPager2) {
                this.f25349b = view;
                this.f25350c = j11;
                this.f25351d = cVar;
                this.f25352e = i11;
                this.f25353f = viewPager2;
            }

            @SensorsDataInstrumented
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                r rVar = r.f24939a;
                if (currentTimeMillis - rVar.b(this.f25349b) > this.f25350c || (this.f25349b instanceof Checkable)) {
                    rVar.e(this.f25349b, currentTimeMillis);
                    RedPointPagerTitleView redPointPagerTitleView = (RedPointPagerTitleView) this.f25349b;
                    c cVar = this.f25351d;
                    if (cVar != null) {
                        cVar.a(this.f25352e);
                    }
                    this.f25353f.setCurrentItem(this.f25352e, false);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public C0220b(ArrayList<TabData> arrayList, float f11, Context context, int i11, int i12, boolean z11, Float f12, Integer num, Integer num2, c cVar, ViewPager2 viewPager2) {
            this.f25338b = arrayList;
            this.f25339c = f11;
            this.f25340d = context;
            this.f25341e = i11;
            this.f25342f = i12;
            this.f25343g = z11;
            this.f25344h = f12;
            this.f25345i = num;
            this.f25346j = num2;
            this.f25347k = cVar;
            this.f25348l = viewPager2;
        }

        public int a() {
            return this.f25338b.size();
        }

        public pe.b b(Context context) {
            return null;
        }

        public pe.c c(Context context, int i11) {
            PagerTitleView pagerTitle;
            Context context2 = context;
            b bVar = b.f25319a;
            String name = this.f25338b.get(i11).getName();
            float f11 = this.f25339c;
            int color = this.f25340d.getResources().getColor(this.f25341e);
            Resources resources = this.f25340d.getResources();
            int i12 = this.f25342f;
            if (i12 == R$color.baseColorMajorTheme100) {
                i12 = bVar.d(context2);
            }
            RedPointPagerTitleView c11 = b.c(bVar, context, name, f11, color, resources.getColor(i12), 0.0f, 0.0f, 0.0f, 0.0f, TXVodDownloadDataSource.QUALITY_480P, (Object) null);
            if (this.f25343g && (pagerTitle = c11.getPagerTitle()) != null) {
                pagerTitle.setTypeface(Typeface.DEFAULT_BOLD);
            }
            Float f12 = this.f25344h;
            if (f12 != null) {
                float floatValue = f12.floatValue();
                PagerTitleView pagerTitle2 = c11.getPagerTitle();
                if (pagerTitle2 != null) {
                    pagerTitle2.setIncludeFontPadding(false);
                }
                PagerTitleView pagerTitle3 = c11.getPagerTitle();
                if (pagerTitle3 != null) {
                    pagerTitle3.setHeight(com.hbg.module.libkt.base.ext.c.d(Float.valueOf(((float) 4) + floatValue)));
                }
                PagerTitleView pagerTitle4 = c11.getPagerTitle();
                if (pagerTitle4 != null) {
                    pagerTitle4.setGravity(80);
                }
                PagerTitleView pagerTitle5 = c11.getPagerTitle();
                if (pagerTitle5 != null) {
                    pagerTitle5.setSelectedTextSize(floatValue);
                }
            }
            Integer num = this.f25345i;
            if (num != null) {
                int intValue = num.intValue();
                PagerTitleView pagerTitle6 = c11.getPagerTitle();
                if (pagerTitle6 != null) {
                    pagerTitle6.setNormalTextFont(ResourcesCompat.h(context2, intValue));
                }
            }
            Integer num2 = this.f25346j;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                PagerTitleView pagerTitle7 = c11.getPagerTitle();
                if (pagerTitle7 != null) {
                    pagerTitle7.setScaleTextFont(ResourcesCompat.h(context2, intValue2));
                }
            }
            r rVar = r.f24939a;
            c11.setOnClickListener(new a(c11, 800, this.f25347k, i11, this.f25348l));
            return c11;
        }
    }

    public static final class c extends NavigatorAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List<TabData> f25354b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f25355c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f25356d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f25357e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f25358f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float f25359g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f25360h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f25361i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f25362j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ int f25363k;

        public static final class a implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f25364b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f25365c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ViewPager2 f25366d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f25367e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f25368f;

            public a(View view, long j11, ViewPager2 viewPager2, int i11, c cVar) {
                this.f25364b = view;
                this.f25365c = j11;
                this.f25366d = viewPager2;
                this.f25367e = i11;
                this.f25368f = cVar;
            }

            @SensorsDataInstrumented
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                r rVar = r.f24939a;
                if (currentTimeMillis - rVar.b(this.f25364b) > this.f25365c || (this.f25364b instanceof Checkable)) {
                    rVar.e(this.f25364b, currentTimeMillis);
                    RedPointPagerTitleView redPointPagerTitleView = (RedPointPagerTitleView) this.f25364b;
                    this.f25366d.setCurrentItem(this.f25367e, false);
                    c cVar = this.f25368f;
                    if (cVar != null) {
                        cVar.a(this.f25367e);
                    }
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public c(List<TabData> list, float f11, Context context, int i11, int i12, float f12, int i13, ViewPager2 viewPager2, c cVar, int i14) {
            this.f25354b = list;
            this.f25355c = f11;
            this.f25356d = context;
            this.f25357e = i11;
            this.f25358f = i12;
            this.f25359g = f12;
            this.f25360h = i13;
            this.f25361i = viewPager2;
            this.f25362j = cVar;
            this.f25363k = i14;
        }

        public int a() {
            return this.f25354b.size();
        }

        public pe.b b(Context context) {
            b bVar = b.f25319a;
            int i11 = this.f25363k;
            if (i11 == -1) {
                i11 = this.f25358f;
            }
            return bVar.a(context, i11);
        }

        public pe.c c(Context context, int i11) {
            b bVar = b.f25319a;
            String name = this.f25354b.get(i11).getName();
            float f11 = this.f25355c;
            int color = this.f25356d.getResources().getColor(this.f25357e);
            Resources resources = this.f25356d.getResources();
            int i12 = this.f25358f;
            if (i12 == R$color.baseColorMajorTheme100) {
                i12 = bVar.d(context);
            } else {
                Context context2 = context;
            }
            RedPointPagerTitleView c11 = b.c(bVar, context, name, f11, color, resources.getColor(i12), 0.0f, 0.0f, 0.0f, 0.0f, TXVodDownloadDataSource.QUALITY_480P, (Object) null);
            PagerTitleView pagerTitle = c11.getPagerTitle();
            if (pagerTitle != null) {
                pagerTitle.setSelectedTextSize(this.f25359g);
            }
            PagerTitleView pagerTitle2 = c11.getPagerTitle();
            if (pagerTitle2 != null) {
                pagerTitle2.setTypeface((Typeface) null, this.f25360h);
            }
            r rVar = r.f24939a;
            c11.setOnClickListener(new a(c11, 800, this.f25361i, i11, this.f25362j));
            return c11;
        }
    }

    public static final class d extends NavigatorAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList<TabData> f25369b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f25370c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f25371d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f25372e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f25373f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f25374g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Float f25375h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Integer f25376i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Integer f25377j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f25378k;

        public static final class a implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f25379b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f25380c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ViewPager2 f25381d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f25382e;

            public a(View view, long j11, ViewPager2 viewPager2, int i11) {
                this.f25379b = view;
                this.f25380c = j11;
                this.f25381d = viewPager2;
                this.f25382e = i11;
            }

            @SensorsDataInstrumented
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                r rVar = r.f24939a;
                if (currentTimeMillis - rVar.b(this.f25379b) > this.f25380c || (this.f25379b instanceof Checkable)) {
                    rVar.e(this.f25379b, currentTimeMillis);
                    RedPointPagerTitleView redPointPagerTitleView = (RedPointPagerTitleView) this.f25379b;
                    this.f25381d.setCurrentItem(this.f25382e, false);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public d(ArrayList<TabData> arrayList, float f11, Context context, int i11, int i12, boolean z11, Float f12, Integer num, Integer num2, ViewPager2 viewPager2) {
            this.f25369b = arrayList;
            this.f25370c = f11;
            this.f25371d = context;
            this.f25372e = i11;
            this.f25373f = i12;
            this.f25374g = z11;
            this.f25375h = f12;
            this.f25376i = num;
            this.f25377j = num2;
            this.f25378k = viewPager2;
        }

        public int a() {
            return this.f25369b.size();
        }

        public pe.b b(Context context) {
            return null;
        }

        public pe.c c(Context context, int i11) {
            PagerTitleView pagerTitle;
            Context context2 = context;
            b bVar = b.f25319a;
            String name = this.f25369b.get(i11).getName();
            float f11 = this.f25370c;
            int color = this.f25371d.getResources().getColor(this.f25372e);
            Resources resources = this.f25371d.getResources();
            int i12 = this.f25373f;
            if (i12 == R$color.baseColorMajorTheme100) {
                i12 = bVar.d(context2);
            }
            RedPointPagerTitleView c11 = b.c(bVar, context, name, f11, color, resources.getColor(i12), 0.0f, 0.0f, 0.0f, 0.0f, TXVodDownloadDataSource.QUALITY_480P, (Object) null);
            if (this.f25374g && (pagerTitle = c11.getPagerTitle()) != null) {
                pagerTitle.setTypeface(Typeface.DEFAULT_BOLD);
            }
            Float f12 = this.f25375h;
            if (f12 != null) {
                float floatValue = f12.floatValue();
                PagerTitleView pagerTitle2 = c11.getPagerTitle();
                if (pagerTitle2 != null) {
                    pagerTitle2.setSelectedTextSize(floatValue);
                }
            }
            Integer num = this.f25376i;
            if (num != null) {
                int intValue = num.intValue();
                PagerTitleView pagerTitle3 = c11.getPagerTitle();
                if (pagerTitle3 != null) {
                    pagerTitle3.setNormalTextFont(ResourcesCompat.h(context2, intValue));
                }
            }
            Integer num2 = this.f25377j;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                PagerTitleView pagerTitle4 = c11.getPagerTitle();
                if (pagerTitle4 != null) {
                    pagerTitle4.setScaleTextFont(ResourcesCompat.h(context2, intValue2));
                }
            }
            r rVar = r.f24939a;
            c11.setOnClickListener(new a(c11, 800, this.f25378k, i11));
            return c11;
        }
    }

    public static /* synthetic */ RedPointPagerTitleView c(b bVar, Context context, String str, float f11, int i11, int i12, float f12, float f13, float f14, float f15, int i13, Object obj) {
        int i14 = i13;
        return bVar.b(context, str, f11, i11, i12, (i14 & 32) != 0 ? 8.0f : f12, (i14 & 64) != 0 ? 0.0f : f13, (i14 & 128) != 0 ? 8.0f : f14, (i14 & 256) != 0 ? 0.0f : f15);
    }

    public static final void e(Context context, List<TabData> list, CoIndicator coIndicator, ViewPager2 viewPager2, float f11, c cVar, int i11, int i12, int i13, int i14, float f12, float f13, float f14, float f15) {
        CoIndicator coIndicator2 = coIndicator;
        Context context2 = context;
        CommonNavigator commonNavigator = new CommonNavigator(context2, 0, 2, (kotlin.jvm.internal.r) null);
        commonNavigator.setAdapter(new a(list, f11, context2, i11, i12, f12, f13, f14, f15, i14, i13, viewPager2, cVar));
        coIndicator2.setNavigator(commonNavigator);
        d.f25383a.a(coIndicator2, viewPager2, cVar);
    }

    public static /* synthetic */ void f(Context context, List list, CoIndicator coIndicator, ViewPager2 viewPager2, float f11, c cVar, int i11, int i12, int i13, int i14, float f12, float f13, float f14, float f15, int i15, Object obj) {
        int i16;
        int i17 = i15;
        float f16 = (i17 & 16) != 0 ? 14.0f : f11;
        int i18 = (i17 & 64) != 0 ? R$color.baseColorSecondaryTextNew : i11;
        if ((i17 & 128) != 0) {
            i16 = f25319a.d(context);
        } else {
            Context context2 = context;
            i16 = i12;
        }
        e(context, list, coIndicator, viewPager2, f16, cVar, i18, i16, (i17 & 256) != 0 ? R$drawable.bg_unsel_indicator : i13, (i17 & 512) != 0 ? R$drawable.bg_sel_indicator : i14, (i17 & 1024) != 0 ? 8.0f : f12, (i17 & 2048) != 0 ? 0.0f : f13, (i17 & 4096) != 0 ? 8.0f : f14, (i17 & 8192) != 0 ? 0.0f : f15);
    }

    public static final void g(Context context, ArrayList<TabData> arrayList, CoIndicator coIndicator, ViewPager2 viewPager2, float f11, int i11, int i12, Float f12, Integer num, Integer num2, boolean z11, c cVar) {
        CoIndicator coIndicator2 = coIndicator;
        coIndicator2.setPadding(com.hbg.module.libkt.base.ext.c.a(8.0f), 0, com.hbg.module.libkt.base.ext.c.a(8.0f), 0);
        Context context2 = context;
        CommonNavigator commonNavigator = new CommonNavigator(context2, 0, 2, (kotlin.jvm.internal.r) null);
        commonNavigator.setAdapter(new C0220b(arrayList, f11, context2, i12, i11, z11, f12, num, num2, cVar, viewPager2));
        coIndicator2.setNavigator(commonNavigator);
        d.b(d.f25383a, coIndicator, viewPager2, (c) null, 4, (Object) null);
    }

    public static /* synthetic */ void h(Context context, ArrayList arrayList, CoIndicator coIndicator, ViewPager2 viewPager2, float f11, int i11, int i12, Float f12, Integer num, Integer num2, boolean z11, c cVar, int i13, Object obj) {
        int i14 = i13;
        g(context, arrayList, coIndicator, viewPager2, (i14 & 16) != 0 ? 14.0f : f11, (i14 & 32) != 0 ? R$color.baseColorMajorTheme100 : i11, (i14 & 64) != 0 ? R$color.baseColorSecondaryTextNew : i12, (i14 & 128) != 0 ? null : f12, (i14 & 256) != 0 ? null : num, (i14 & 512) != 0 ? null : num2, (i14 & 1024) != 0 ? false : z11, (i14 & 2048) != 0 ? null : cVar);
    }

    public static final void i(Context context, List<TabData> list, CoIndicator coIndicator, ViewPager2 viewPager2, int i11, float f11, float f12, int i12, int i13, int i14, c cVar) {
        CoIndicator coIndicator2 = coIndicator;
        coIndicator2.setPadding(com.hbg.module.libkt.base.ext.c.a(8.0f), 0, com.hbg.module.libkt.base.ext.c.a(8.0f), 0);
        Context context2 = context;
        CommonNavigator commonNavigator = new CommonNavigator(context2, 0, 2, (kotlin.jvm.internal.r) null);
        commonNavigator.setAdapter(new c(list, f11, context2, i13, i12, f12, i11, viewPager2, cVar, i14));
        coIndicator2.setNavigator(commonNavigator);
        d.f25383a.a(coIndicator2, viewPager2, cVar);
    }

    public static final void j(Context context, List<TabData> list, CoIndicator coIndicator, ViewPager2 viewPager2, int i11, float f11, float f12, int i12, int i13, c cVar) {
        i(context, list, coIndicator, viewPager2, i11, f11, f12, i12, i13, i12, cVar);
    }

    public static final void k(Context context, List<TabData> list, CoIndicator coIndicator, ViewPager2 viewPager2, int i11, float f11, float f12, c cVar) {
        j(context, list, coIndicator, viewPager2, i11, f11, f12, R$color.baseColorMajorTheme100, R$color.baseColorSecondaryTextNew, cVar);
    }

    public static final void l(Context context, List<TabData> list, CoIndicator coIndicator, ViewPager2 viewPager2, c cVar) {
        k(context, list, coIndicator, viewPager2, 0, 14.0f, 14.0f, cVar);
    }

    public static /* synthetic */ void m(Context context, List list, CoIndicator coIndicator, ViewPager2 viewPager2, int i11, float f11, float f12, int i12, int i13, c cVar, int i14, Object obj) {
        int i15 = i14;
        j(context, list, coIndicator, viewPager2, i11, f11, f12, (i15 & 128) != 0 ? R$color.baseColorMajorTheme100 : i12, (i15 & 256) != 0 ? R$color.baseColorSecondaryTextNew : i13, (i15 & 512) != 0 ? null : cVar);
    }

    public static final void n(Context context, ArrayList<TabData> arrayList, CoIndicator coIndicator, ViewPager2 viewPager2, float f11, int i11, int i12, Float f12, Integer num, Integer num2, boolean z11) {
        CoIndicator coIndicator2 = coIndicator;
        coIndicator2.setPadding(com.hbg.module.libkt.base.ext.c.a(8.0f), 0, com.hbg.module.libkt.base.ext.c.a(8.0f), 0);
        Context context2 = context;
        CommonNavigator commonNavigator = new CommonNavigator(context2, 0, 2, (kotlin.jvm.internal.r) null);
        commonNavigator.setAdapter(new d(arrayList, f11, context2, i12, i11, z11, f12, num, num2, viewPager2));
        coIndicator2.setNavigator(commonNavigator);
        d.b(d.f25383a, coIndicator, viewPager2, (c) null, 4, (Object) null);
    }

    public static /* synthetic */ void o(Context context, ArrayList arrayList, CoIndicator coIndicator, ViewPager2 viewPager2, float f11, int i11, int i12, Float f12, Integer num, Integer num2, boolean z11, int i13, Object obj) {
        int i14 = i13;
        n(context, arrayList, coIndicator, viewPager2, (i14 & 16) != 0 ? 14.0f : f11, (i14 & 32) != 0 ? R$color.baseColorMajorTheme100 : i11, (i14 & 64) != 0 ? R$color.baseColorSecondaryTextNew : i12, (i14 & 128) != 0 ? null : f12, (i14 & 256) != 0 ? null : num, (i14 & 512) != 0 ? null : num2, (i14 & 1024) != 0 ? false : z11);
    }

    public final LinePagerIndicator a(Context context, int i11) {
        LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
        linePagerIndicator.setMode(2);
        linePagerIndicator.setColors(ContextCompat.getColor(context, i11));
        linePagerIndicator.setLineWidth((float) com.hbg.module.libkt.base.ext.c.a(20.0f));
        linePagerIndicator.setLineHeight((float) com.hbg.module.libkt.base.ext.c.a(2.0f));
        return linePagerIndicator;
    }

    public final RedPointPagerTitleView b(Context context, String str, float f11, int i11, int i12, float f12, float f13, float f14, float f15) {
        PagerTitleView pagerTitleView = new PagerTitleView(context);
        pagerTitleView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        RedPointPagerTitleView redPointPagerTitleView = new RedPointPagerTitleView(context, (AttributeSet) null, 0, 6, (kotlin.jvm.internal.r) null);
        redPointPagerTitleView.setPageTitleView(pagerTitleView);
        String str2 = str;
        pagerTitleView.setText(str);
        float f16 = f11;
        pagerTitleView.setTextSize(f11);
        int i13 = i11;
        pagerTitleView.setNormalColor(i11);
        int i14 = i12;
        pagerTitleView.setSelectedColor(i12);
        pagerTitleView.setGravity(17);
        pagerTitleView.setPadding(com.hbg.module.libkt.base.ext.c.d(Float.valueOf(f12)), com.hbg.module.libkt.base.ext.c.d(Float.valueOf(f13)), com.hbg.module.libkt.base.ext.c.d(Float.valueOf(f14)), com.hbg.module.libkt.base.ext.c.d(Float.valueOf(f15)));
        return redPointPagerTitleView;
    }

    public final int d(Context context) {
        if ("LiveCategoryActivity".equals(context.getClass().getSimpleName())) {
            return R$color.baseColorPrimaryText;
        }
        return R$color.baseColorMajorTheme100;
    }
}
