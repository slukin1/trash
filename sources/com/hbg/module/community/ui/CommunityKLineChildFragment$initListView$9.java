package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.p;
import kotlin.jvm.internal.Lambda;

public final class CommunityKLineChildFragment$initListView$9 extends Lambda implements p<Integer, CommunityFeedInfo.ListBean, Integer> {
    public static final CommunityKLineChildFragment$initListView$9 INSTANCE = new CommunityKLineChildFragment$initListView$9();

    public CommunityKLineChildFragment$initListView$9() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (CommunityFeedInfo.ListBean) obj2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r5 != 4) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Integer invoke(int r5, com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.ListBean r6) {
        /*
            r4 = this;
            int r5 = r6.getItemType()
            r0 = 3
            r1 = 0
            r2 = 1
            r3 = 2
            if (r5 != r3) goto L_0x001c
            java.util.List r5 = r6.getFocusList()
            if (r5 == 0) goto L_0x001c
            java.util.List r5 = r6.getFocusList()
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x001c
            r0 = r3
            goto L_0x002f
        L_0x001c:
            int r5 = r6.getItemType()
            if (r5 != r2) goto L_0x002e
            int r5 = r6.getType()
            if (r5 == r0) goto L_0x002c
            r6 = 4
            if (r5 == r6) goto L_0x002f
            goto L_0x002e
        L_0x002c:
            r0 = r2
            goto L_0x002f
        L_0x002e:
            r0 = r1
        L_0x002f:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.ui.CommunityKLineChildFragment$initListView$9.invoke(int, com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean):java.lang.Integer");
    }
}
