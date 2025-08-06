package com.hbg.lite.index.ui;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.core.view.h0;
import cb.b;
import com.hbg.lib.network.php.core.bean.ZendeskTopNotice;
import com.hbg.lib.widgets.TopScrollData;
import com.hbg.lib.widgets.TopScrollView;
import com.hbg.lite.R$drawable;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.index.bean.LiteIndexBannerTopNoticeModel;
import com.huobi.view.rollviewpager.RollPagerView;
import com.huobi.view.rollviewpager.hintview.AnimHintView;
import java.util.ArrayList;
import java.util.List;

public class LiteIndexBannerTopNoticeView extends BaseHeaderItemView<LiteIndexBannerTopNoticeModel> {

    /* renamed from: f  reason: collision with root package name */
    public RollPagerView f77116f;

    /* renamed from: g  reason: collision with root package name */
    public TopScrollView f77117g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f77118h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f77119i;

    /* renamed from: j  reason: collision with root package name */
    public LiteIndexTutorialView f77120j;

    /* renamed from: k  reason: collision with root package name */
    public b f77121k;

    /* renamed from: l  reason: collision with root package name */
    public AnimHintView f77122l;

    public class a implements TopScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiteIndexBannerTopNoticeModel f77123a;

        public a(LiteIndexBannerTopNoticeModel liteIndexBannerTopNoticeModel) {
            this.f77123a = liteIndexBannerTopNoticeModel;
        }

        public void a(TopScrollData topScrollData) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
            r0 = r4.f77123a.c().getArticles();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r4 = this;
                com.hbg.lite.index.bean.LiteIndexBannerTopNoticeModel r0 = r4.f77123a
                com.hbg.lib.network.php.core.bean.ZendeskTopNotice r0 = r0.c()
                r1 = 0
                if (r0 == 0) goto L_0x001f
                com.hbg.lite.index.bean.LiteIndexBannerTopNoticeModel r0 = r4.f77123a
                com.hbg.lib.network.php.core.bean.ZendeskTopNotice r0 = r0.c()
                java.util.List r0 = r0.getArticles()
                if (r0 == 0) goto L_0x001f
                com.google.gson.Gson r2 = new com.google.gson.Gson
                r2.<init>()
                java.lang.String r0 = r2.toJson((java.lang.Object) r0)
                goto L_0x0020
            L_0x001f:
                r0 = r1
            L_0x0020:
                ra.b r2 = ra.c.b()
                com.hbg.lite.index.ui.LiteIndexBannerTopNoticeView r3 = com.hbg.lite.index.ui.LiteIndexBannerTopNoticeView.this
                android.content.Context r3 = r3.f77108b
                r2.a(r3, r0)
                ra.d r0 = ra.c.c()
                java.lang.String r2 = "3564"
                r0.l(r2, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.lite.index.ui.LiteIndexBannerTopNoticeView.a.b():void");
        }

        public void c(TopScrollData topScrollData) {
            za.a aVar = LiteIndexBannerTopNoticeView.this.f77110d;
            if (aVar != null) {
                aVar.a(topScrollData);
            }
        }
    }

    public LiteIndexBannerTopNoticeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a() {
        this.f77116f = (RollPagerView) this.f77111e.b(R$id.roll_view_pager);
        this.f77117g = (TopScrollView) this.f77111e.b(R$id.index_notice_layout);
        this.f77120j = (LiteIndexTutorialView) this.f77111e.b(R$id.tutorial_view);
        this.f77118h = (LinearLayout) this.f77111e.b(R$id.content_view_ll);
        this.f77119i = (LinearLayout) this.f77111e.b(R$id.empty_view_ll);
        AnimHintView animHintView = new AnimHintView(this.f77116f.getContext());
        this.f77122l = animHintView;
        animHintView.setNormalResId(0);
        this.f77122l.setBgResId(R$drawable.hint_indicator_bg);
        this.f77122l.setFocusResId(R$drawable.hint_indicator_focus);
        this.f77116f.setHintView(this.f77122l);
        this.f77116f.getViewPager().setClipToPadding(false);
        this.f77116f.getViewPager().setPageMargin(0);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f77116f.getViewPager().setNestedScrollingEnabled(false);
        }
        h0.N0(this.f77116f.getViewPager(), false);
        b bVar = new b(this.f77116f);
        this.f77121k = bVar;
        bVar.setPosDelta(-1);
        this.f77116f.setAdapter(this.f77121k);
    }

    public void d() {
        this.f77119i.setVisibility(8);
        this.f77118h.setVisibility(0);
    }

    public void e() {
        this.f77119i.setVisibility(0);
        this.f77118h.setVisibility(8);
    }

    /* renamed from: f */
    public void c(LiteIndexBannerTopNoticeModel liteIndexBannerTopNoticeModel) {
        int i11 = 8;
        this.f77119i.setVisibility(8);
        this.f77118h.setVisibility(0);
        List b11 = liteIndexBannerTopNoticeModel.b();
        if (b11 == null) {
            b11 = new ArrayList();
        }
        this.f77121k.c(b11);
        this.f77121k.notifyDataSetChanged();
        AnimHintView animHintView = this.f77122l;
        if (b11.size() > 1) {
            i11 = 0;
        }
        animHintView.setVisibility(i11);
        this.f77116f.setPlayDelay(3000);
        if (liteIndexBannerTopNoticeModel.c() != null) {
            List<ZendeskTopNotice.ArticlesBean> articles = liteIndexBannerTopNoticeModel.c().getArticles();
            if (articles == null || articles.isEmpty()) {
                this.f77117g.setVisibility(4);
            } else {
                ArrayList arrayList = new ArrayList();
                for (ZendeskTopNotice.ArticlesBean next : articles) {
                    TopScrollData topScrollData = new TopScrollData();
                    topScrollData.l(next.getTitle());
                    topScrollData.n(next.getWebUrl());
                    arrayList.add(topScrollData);
                }
                this.f77117g.setVisibility(0);
                this.f77117g.setDatas(arrayList);
            }
        } else {
            this.f77117g.setVisibility(4);
        }
        this.f77117g.setCallback(new a(liteIndexBannerTopNoticeModel));
        if (liteIndexBannerTopNoticeModel.d()) {
            this.f77116f.resume();
            this.f77117g.g();
            return;
        }
        this.f77116f.pause();
        this.f77117g.h();
    }

    public int getResId() {
        return R$layout.lite_index_banner_layout;
    }

    public LiteIndexTutorialView getTutorialView() {
        return this.f77120j;
    }

    public LiteIndexBannerTopNoticeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
