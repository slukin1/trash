package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.p;
import kotlin.jvm.internal.Lambda;

public final class TopicDetailChildFragment$initBefore$8 extends Lambda implements p<Integer, CommunityFeedInfo.ListBean, Integer> {
    public static final TopicDetailChildFragment$initBefore$8 INSTANCE = new TopicDetailChildFragment$initBefore$8();

    public TopicDetailChildFragment$initBefore$8() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (CommunityFeedInfo.ListBean) obj2);
    }

    public final Integer invoke(int i11, CommunityFeedInfo.ListBean listBean) {
        int type = listBean.getType();
        int i12 = 0;
        if (type != 1) {
            if (type == 3) {
                i12 = 1;
            } else if (type == 4) {
                i12 = 2;
            }
        }
        return Integer.valueOf(i12);
    }
}
