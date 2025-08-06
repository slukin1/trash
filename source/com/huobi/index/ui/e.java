package com.huobi.index.ui;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.hbg.lib.network.hbg.core.bean.NewFeed;
import com.hbg.module.libkt.utils.r;
import com.huochat.community.base.CommunityConstants;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import kotlin.Pair;
import kotlin.l;
import nc.c;
import pro.huobi.R;

public final class e extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public final List<NewFeed.TopicItem> f73879a;

    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f73880a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f73881b;

        public a(View view) {
            super(view);
            this.f73880a = (TextView) view.findViewById(R.id.tvRank);
            this.f73881b = (TextView) view.findViewById(R.id.atv_topic);
        }

        public final TextView e() {
            return this.f73880a;
        }

        public final TextView f() {
            return this.f73881b;
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f73883b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f73884c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewFeed.TopicItem f73885d;

        public b(View view, long j11, NewFeed.TopicItem topicItem) {
            this.f73883b = view;
            this.f73884c = j11;
            this.f73885d = topicItem;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f73883b) > this.f73884c || (this.f73883b instanceof Checkable)) {
                rVar.e(this.f73883b, currentTimeMillis);
                Pair[] pairArr = new Pair[3];
                NewFeed.TopicItem topicItem = this.f73885d;
                Integer num = null;
                pairArr[0] = l.a(CommunityConstants.TOPIC_ID, topicItem != null ? Integer.valueOf(topicItem.topicId) : null);
                NewFeed.TopicItem topicItem2 = this.f73885d;
                pairArr[1] = l.a("topic.title", topicItem2 != null ? topicItem2.title : null);
                NewFeed.TopicItem topicItem3 = this.f73885d;
                pairArr[2] = l.a("topic.identification", topicItem3 != null ? Integer.valueOf(topicItem3.identification) : null);
                c.a("app_community_htrq", MapsKt__MapsKt.j(pairArr));
                Postcard a11 = b2.a.d().a("/content/topicDetail");
                NewFeed.TopicItem topicItem4 = this.f73885d;
                if (topicItem4 != null) {
                    num = Integer.valueOf(topicItem4.topicId);
                }
                a11.withString(CommunityConstants.TOPIC_ID, String.valueOf(num)).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public e(List<? extends NewFeed.TopicItem> list) {
        this.f73879a = list;
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i11) {
        String str;
        List<NewFeed.TopicItem> list = this.f73879a;
        String str2 = null;
        NewFeed.TopicItem topicItem = list != null ? list.get(i11) : null;
        boolean z11 = true;
        aVar.e().setText(i11 != 0 ? i11 != 1 ? "3" : "2" : "1");
        if (topicItem == null || topicItem.type != 2) {
            z11 = false;
        }
        String str3 = "";
        if (z11) {
            str = '[' + aVar.itemView.getContext().getString(R.string.n_home_feed_special) + ']';
        } else {
            str = str3;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (topicItem != null) {
            str2 = topicItem.title;
        }
        if (str2 != null) {
            str3 = str2;
        }
        sb2.append(str3);
        SpannableString spannableString = new SpannableString(sb2.toString());
        spannableString.setSpan(new ForegroundColorSpan(aVar.f().getContext().getResources().getColor(R.color.baseColorMajorTheme100)), 0, str.length(), 18);
        aVar.f().setText(spannableString);
        r rVar = r.f24939a;
        View view = aVar.itemView;
        view.setOnClickListener(new b(view, 800, topicItem));
    }

    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new a(View.inflate(viewGroup.getContext(), R.layout.item_index_topic_item, (ViewGroup) null));
    }

    public int getItemCount() {
        List<NewFeed.TopicItem> list = this.f73879a;
        if (list == null) {
            return 0;
        }
        if (list.size() > 5) {
            return 5;
        }
        return this.f73879a.size();
    }
}
