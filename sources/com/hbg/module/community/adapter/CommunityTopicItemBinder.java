package com.hbg.module.community.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.multiadapter.ItemViewBinder;
import com.hbg.module.content.R$color;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.huochat.community.base.CommunityConstants;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import kotlin.Pair;
import kotlin.l;
import lc.w3;
import nc.c;
import rd.s;

public final class CommunityTopicItemBinder extends ItemViewBinder<CommunityFeedInfo.Topic, ItemViewBinder.a<w3>> {

    /* renamed from: e  reason: collision with root package name */
    public HbgBaseProvider f17158e = ((HbgBaseProvider) b2.a.d().a("/provider/content").navigation());

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17159b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17160c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.Topic f17161d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityTopicItemBinder f17162e;

        public a(View view, long j11, CommunityFeedInfo.Topic topic, CommunityTopicItemBinder communityTopicItemBinder) {
            this.f17159b = view;
            this.f17160c = j11;
            this.f17161d = topic;
            this.f17162e = communityTopicItemBinder;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17159b) > this.f17160c || (this.f17159b instanceof Checkable)) {
                sVar.e(this.f17159b, currentTimeMillis);
                Pair[] pairArr = new Pair[7];
                pairArr[0] = l.a("url", this.f17161d.getUrl());
                pairArr[1] = l.a("type", Integer.valueOf(this.f17161d.getType()));
                pairArr[2] = l.a(CommunityConstants.TOPIC_ID, Integer.valueOf(this.f17161d.getTopicId()));
                pairArr[3] = l.a("title", this.f17161d.getTitle());
                pairArr[4] = l.a("identification", Integer.valueOf(this.f17161d.getIdentification()));
                String j11 = this.f17162e.j();
                if (j11 == null) {
                    j11 = "";
                }
                pairArr[5] = l.a("TransPair_current_id", j11);
                pairArr[6] = l.a("markets_kline_class", k.a(this.f17162e.k(), this.f17162e.l()));
                c.a("app_community_htrq", MapsKt__MapsKt.j(pairArr));
                try {
                    HbgBaseProvider q11 = this.f17162e.f17158e;
                    if (q11 != null) {
                        q11.g(this.f17161d.getUrl() + "&symbolId=" + this.f17162e.j() + "&tradeType=" + this.f17162e.k());
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: r */
    public void c(ItemViewBinder.a<w3> aVar, CommunityFeedInfo.Topic topic, boolean z11, int i11) {
        Context context = aVar.itemView.getContext();
        boolean z12 = true;
        aVar.e().C.setText(i11 != 0 ? i11 != 1 ? "3" : "2" : "1");
        String specialIde = topic.getSpecialIde();
        if (!(specialIde == null || specialIde.length() == 0)) {
            z12 = false;
        }
        if (z12) {
            aVar.e().B.setText(topic.getTitle());
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(topic.getSpecialIde() + topic.getTitle());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ResourcesCompat.d(context.getResources(), R$color.baseColorMajorTheme100, (Resources.Theme) null)), 0, topic.getSpecialIde().length(), 17);
            aVar.e().B.setText(spannableStringBuilder);
        }
        s sVar = s.f23381a;
        View view = aVar.itemView;
        view.setOnClickListener(new a(view, 800, topic, this));
    }

    /* renamed from: s */
    public ItemViewBinder.a<w3> m(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ItemViewBinder.a<>(w3.K(layoutInflater, viewGroup, false));
    }
}
