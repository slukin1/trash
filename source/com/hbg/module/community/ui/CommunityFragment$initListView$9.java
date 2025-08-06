package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.p;
import kotlin.jvm.internal.Lambda;

public final class CommunityFragment$initListView$9 extends Lambda implements p<Integer, CommunityFeedInfo.ListBean, Integer> {
    public static final CommunityFragment$initListView$9 INSTANCE = new CommunityFragment$initListView$9();

    public CommunityFragment$initListView$9() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (CommunityFeedInfo.ListBean) obj2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (com.hbg.module.libkt.base.ext.b.w(r7.getInterestTags()) == false) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Integer invoke(int r6, com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.ListBean r7) {
        /*
            r5 = this;
            int r6 = r7.getItemType()
            r0 = 4
            r1 = 2
            r2 = 0
            r3 = 3
            r4 = 1
            if (r6 != r1) goto L_0x001d
            java.util.List r6 = r7.getFocusList()
            if (r6 == 0) goto L_0x001d
            java.util.List r6 = r7.getFocusList()
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x001d
            r0 = r1
            goto L_0x0044
        L_0x001d:
            int r6 = r7.getItemType()
            if (r6 != r4) goto L_0x0032
            int r6 = r7.getType()
            if (r6 == r4) goto L_0x0043
            if (r6 == r3) goto L_0x0030
            if (r6 == r0) goto L_0x002e
            goto L_0x0043
        L_0x002e:
            r0 = r3
            goto L_0x0044
        L_0x0030:
            r0 = r4
            goto L_0x0044
        L_0x0032:
            int r6 = r7.getItemType()
            if (r6 != r3) goto L_0x0043
            java.util.List r6 = r7.getInterestTags()
            boolean r6 = com.hbg.module.libkt.base.ext.b.w(r6)
            if (r6 != 0) goto L_0x0043
            goto L_0x0044
        L_0x0043:
            r0 = r2
        L_0x0044:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.ui.CommunityFragment$initListView$9.invoke(int, com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean):java.lang.Integer");
    }
}
