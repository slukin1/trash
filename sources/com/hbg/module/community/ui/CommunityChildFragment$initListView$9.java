package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.p;
import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;

public final class CommunityChildFragment$initListView$9 extends Lambda implements p<Integer, CommunityFeedInfo.ListBean, Integer> {
    public static final CommunityChildFragment$initListView$9 INSTANCE = new CommunityChildFragment$initListView$9();

    public CommunityChildFragment$initListView$9() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (CommunityFeedInfo.ListBean) obj2);
    }

    public final Integer invoke(int i11, CommunityFeedInfo.ListBean listBean) {
        int i12 = 0;
        if (listBean.getParentDynamic() != null && listBean.getParentDynamic().getType() == 3) {
            i12 = 1;
        } else if (listBean.getParentDynamic() != null && listBean.getParentDynamic().getType() == 1) {
            i12 = 2;
        } else if (listBean.getImgList() != null) {
            ArrayList<CommunityFeedInfo.imgListBean> imgList = listBean.getImgList();
            int intValue = (imgList != null ? Integer.valueOf(imgList.size()) : null).intValue();
        }
        return Integer.valueOf(i12);
    }
}
