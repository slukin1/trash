package com.hbg.module.community.ui;

import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.hbg.module.libkt.base.ext.b;
import com.huochat.community.base.CommunityConstants;
import d10.l;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import nc.c;

public final class TopicDetailActivity$getTopicDetailInfo$1 extends Lambda implements l<TopicDetailInfo, Unit> {
    public final /* synthetic */ TopicDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicDetailActivity$getTopicDetailInfo$1(TopicDetailActivity topicDetailActivity) {
        super(1);
        this.this$0 = topicDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TopicDetailInfo) obj);
        return Unit.f56620a;
    }

    public final void invoke(TopicDetailInfo topicDetailInfo) {
        this.this$0.Df();
        TopicDetailActivity topicDetailActivity = this.this$0;
        if (topicDetailInfo != null) {
            topicDetailActivity.f17515o = topicDetailInfo;
            TopicDetailActivity.yh(topicDetailActivity).M(topicDetailActivity.f17515o);
            AppCompatTextView appCompatTextView = TopicDetailActivity.yh(topicDetailActivity).K;
            TopicDetailInfo.HeaderInfo info = topicDetailInfo.getInfo();
            Integer num = null;
            appCompatTextView.setText(info != null ? info.getTitle() : null);
            AppCompatTextView appCompatTextView2 = TopicDetailActivity.yh(topicDetailActivity).I;
            TopicDetailInfo.HeaderInfo info2 = topicDetailInfo.getInfo();
            appCompatTextView2.setText(info2 != null ? info2.getDesc() : null);
            AppCompatTextView appCompatTextView3 = TopicDetailActivity.yh(topicDetailActivity).I;
            TopicDetailInfo.HeaderInfo info3 = topicDetailInfo.getInfo();
            appCompatTextView3.setVisibility(b.x(info3 != null ? info3.getDesc() : null) ? 8 : 0);
            topicDetailActivity.fi();
            if (topicDetailActivity.f17525y) {
                Pair[] pairArr = new Pair[5];
                TopicDetailInfo.HeaderInfo info4 = topicDetailInfo.getInfo();
                pairArr[0] = kotlin.l.a(CommunityConstants.TOPIC_ID, info4 != null ? Integer.valueOf(info4.getTopicId()) : null);
                TopicDetailInfo.HeaderInfo info5 = topicDetailInfo.getInfo();
                pairArr[1] = kotlin.l.a("title", info5 != null ? info5.getTitle() : null);
                TopicDetailInfo.HeaderInfo info6 = topicDetailInfo.getInfo();
                if (info6 != null) {
                    num = Integer.valueOf(info6.getIdentification());
                }
                pairArr[2] = kotlin.l.a("identification", num);
                String stringExtra = topicDetailActivity.getIntent().getStringExtra("symbolId");
                String str = "";
                if (stringExtra == null) {
                    stringExtra = str;
                }
                pairArr[3] = kotlin.l.a("TransPair_current_id", stringExtra);
                String stringExtra2 = topicDetailActivity.getIntent().getStringExtra("tradeType");
                if (stringExtra2 != null) {
                    str = stringExtra2;
                }
                pairArr[4] = kotlin.l.a("markets_kline_class", str);
                c.a("app_community_htpv", MapsKt__MapsKt.j(pairArr));
                topicDetailActivity.f17525y = false;
            }
        }
    }
}
