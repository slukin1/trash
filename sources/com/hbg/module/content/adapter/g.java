package com.hbg.module.content.adapter;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.network.hbg.core.bean.DeepNewsInfo;
import com.hbg.module.community.ui.DynamicDetailActivity;
import com.hbg.module.content.R$attr;
import com.hbg.module.content.R$font;
import com.hbg.module.content.utls.f;
import com.hbg.module.libkt.base.ext.b;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.wtree.helper.Utils;
import he.c;
import java.util.HashMap;
import lc.a4;

public final class g extends c<DeepNewsInfo, c.a<a4>> {

    /* renamed from: f  reason: collision with root package name */
    public String f17851f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Object> f17852g;

    public g(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @SensorsDataInstrumented
    public static final void m(g gVar, DeepNewsInfo deepNewsInfo, View view) {
        if (!b.x(gVar.f17851f)) {
            HashMap<String, Object> hashMap = gVar.f17852g;
            if (hashMap == null) {
                gVar.f17852g = new HashMap<>();
            } else {
                hashMap.clear();
            }
            gVar.f17852g.put("contentid", Long.valueOf(deepNewsInfo.getNews().getId()));
            gVar.f17852g.put("state", "kline_news_articles");
            gVar.f17852g.put("title", deepNewsInfo.getNews().getTitle());
            nc.c.a("articles_click", gVar.f17852g);
        }
        DynamicDetailActivity.a.b(DynamicDetailActivity.H, deepNewsInfo.getNews().getDynamicId(), deepNewsInfo.getNews().getId(), gVar.f(), false, 8, (Object) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    /* renamed from: l */
    public void onBindViewHolder(c.a<a4> aVar, int i11) {
        super.onBindViewHolder(aVar, i11);
        DeepNewsInfo deepNewsInfo = (DeepNewsInfo) g().get(i11);
        aVar.e().M(deepNewsInfo.getNews());
        p(deepNewsInfo, aVar);
        b.G(aVar.e().C, deepNewsInfo.getNews().getImgUrl(), 0, com.hbg.module.libkt.base.ext.c.d(Float.valueOf(8.0f)), 0, 0, 26, (Object) null);
        if (AppLanguageHelper.getInstance().isEnglishLanguage()) {
            aVar.e().G.setTypeface(Utils.c(R$font.roboto_medium));
            aVar.e().E.setTypeface(Utils.c(R$font.roboto_regular));
        }
        aVar.e().D.setOnClickListener(new f(this, deepNewsInfo));
        aVar.e().B.setVisibility(i(i11) ? 8 : 0);
        HashMap<String, Object> hashMap = this.f17852g;
        if (hashMap == null) {
            this.f17852g = new HashMap<>();
        } else {
            hashMap.clear();
        }
        this.f17852g.put("contentid", Long.valueOf(deepNewsInfo.getNews().getId()));
        this.f17852g.put("state", "kline_news_articles");
        this.f17852g.put("title", deepNewsInfo.getNews().getTitle());
        nc.c.a("articles_show", this.f17852g);
    }

    /* renamed from: n */
    public c.a<a4> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c.a<>(a4.K(h(), viewGroup, false));
    }

    public final void o(String str) {
        this.f17851f = str;
    }

    public final void p(DeepNewsInfo deepNewsInfo, c.a<a4> aVar) {
        if (deepNewsInfo.getNews().getIsTop() == 0) {
            aVar.e().G.setText(deepNewsInfo.getNews().getTitle());
            return;
        }
        SpannableString spannableString = new SpannableString("  " + deepNewsInfo.getNews().getTitle());
        Drawable p11 = b.p(f(), R$attr.icon_market_news_top);
        if (p11 != null) {
            p11.setBounds(0, 0, p11.getIntrinsicWidth(), p11.getIntrinsicHeight());
            spannableString.setSpan(new f(p11, 2), 0, 1, 33);
            aVar.e().G.setText(spannableString);
        }
    }
}
