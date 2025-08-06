package com.hbg.module.community.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.hbg.module.community.multiadapter.ItemViewBinder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import kotlin.Unit;
import lc.y6;
import rd.s;

public final class TopicNewsItemBinder extends ItemViewBinder<TopicDetailInfo.NewsInfo, ItemViewBinder.a<y6>> {

    /* renamed from: e  reason: collision with root package name */
    public l<? super String, Unit> f17163e;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17164b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17165c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TopicNewsItemBinder f17166d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicDetailInfo.NewsInfo f17167e;

        public a(View view, long j11, TopicNewsItemBinder topicNewsItemBinder, TopicDetailInfo.NewsInfo newsInfo) {
            this.f17164b = view;
            this.f17165c = j11;
            this.f17166d = topicNewsItemBinder;
            this.f17167e = newsInfo;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17164b) > this.f17165c || (this.f17164b instanceof Checkable)) {
                sVar.e(this.f17164b, currentTimeMillis);
                l q11 = this.f17166d.f17163e;
                if (q11 == null) {
                    q11 = null;
                }
                q11.invoke(this.f17167e.getUrl());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: r */
    public void c(ItemViewBinder.a<y6> aVar, TopicDetailInfo.NewsInfo newsInfo, boolean z11, int i11) {
        if (z11) {
            ((ViewGroup.MarginLayoutParams) aVar.e().D.getLayoutParams()).bottomMargin = 0;
        }
        aVar.e().C.setText(newsInfo.getTitle());
        s sVar = s.f23381a;
        View view = aVar.itemView;
        view.setOnClickListener(new a(view, 800, this, newsInfo));
    }

    /* renamed from: s */
    public ItemViewBinder.a<y6> m(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ItemViewBinder.a<>(y6.K(layoutInflater, viewGroup, false));
    }

    public final void t(l<? super String, Unit> lVar) {
        this.f17163e = lVar;
    }
}
