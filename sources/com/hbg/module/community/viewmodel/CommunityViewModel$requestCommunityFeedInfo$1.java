package com.hbg.module.community.viewmodel;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityViewModel$requestCommunityFeedInfo$1 extends Lambda implements l<CommunityFeedInfo, Unit> {
    public final /* synthetic */ int $loadStatus;
    public final /* synthetic */ CommunityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityViewModel$requestCommunityFeedInfo$1(int i11, CommunityViewModel communityViewModel) {
        super(1);
        this.$loadStatus = i11;
        this.this$0 = communityViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommunityFeedInfo) obj);
        return Unit.f56620a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f5, code lost:
        if (((r5 == null || (r5 = r5.getList()) == null || r5.size() != 0) ? false : true) != false) goto L_0x00f7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo r8) {
        /*
            r7 = this;
            int r0 = r7.$loadStatus
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == r1) goto L_0x0122
            r4 = -1
            if (r0 != r4) goto L_0x000c
            goto L_0x0122
        L_0x000c:
            if (r8 == 0) goto L_0x012b
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo r0 = new com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo
            r0.<init>()
            com.hbg.module.community.viewmodel.CommunityViewModel r4 = r7.this$0
            androidx.lifecycle.MutableLiveData r4 = r4.j0()
            java.lang.Object r4 = r4.getValue()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo r4 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo) r4
            if (r4 == 0) goto L_0x0026
            java.util.List r4 = r4.getTopic()
            goto L_0x0027
        L_0x0026:
            r4 = r3
        L_0x0027:
            if (r4 == 0) goto L_0x0061
            com.hbg.module.community.viewmodel.CommunityViewModel r4 = r7.this$0
            androidx.lifecycle.MutableLiveData r4 = r4.j0()
            java.lang.Object r4 = r4.getValue()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo r4 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo) r4
            if (r4 == 0) goto L_0x0045
            java.util.List r4 = r4.getTopic()
            if (r4 == 0) goto L_0x0045
            int r4 = r4.size()
            if (r4 != 0) goto L_0x0045
            r4 = r1
            goto L_0x0046
        L_0x0045:
            r4 = r2
        L_0x0046:
            if (r4 == 0) goto L_0x0049
            goto L_0x0061
        L_0x0049:
            com.hbg.module.community.viewmodel.CommunityViewModel r4 = r7.this$0
            androidx.lifecycle.MutableLiveData r4 = r4.j0()
            java.lang.Object r4 = r4.getValue()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo r4 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo) r4
            if (r4 == 0) goto L_0x005c
            java.util.List r4 = r4.getTopic()
            goto L_0x005d
        L_0x005c:
            r4 = r3
        L_0x005d:
            r0.setTopic(r4)
            goto L_0x0068
        L_0x0061:
            java.util.List r4 = r8.getTopic()
            r0.setTopic(r4)
        L_0x0068:
            com.hbg.module.community.viewmodel.CommunityViewModel r4 = r7.this$0
            androidx.lifecycle.MutableLiveData r4 = r4.j0()
            java.lang.Object r4 = r4.getValue()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo r4 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo) r4
            if (r4 == 0) goto L_0x007b
            java.util.List r4 = r4.getRecommend()
            goto L_0x007c
        L_0x007b:
            r4 = r3
        L_0x007c:
            if (r4 == 0) goto L_0x00b6
            com.hbg.module.community.viewmodel.CommunityViewModel r4 = r7.this$0
            androidx.lifecycle.MutableLiveData r4 = r4.j0()
            java.lang.Object r4 = r4.getValue()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo r4 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo) r4
            if (r4 == 0) goto L_0x009a
            java.util.List r4 = r4.getRecommend()
            if (r4 == 0) goto L_0x009a
            int r4 = r4.size()
            if (r4 != 0) goto L_0x009a
            r4 = r1
            goto L_0x009b
        L_0x009a:
            r4 = r2
        L_0x009b:
            if (r4 == 0) goto L_0x009e
            goto L_0x00b6
        L_0x009e:
            com.hbg.module.community.viewmodel.CommunityViewModel r4 = r7.this$0
            androidx.lifecycle.MutableLiveData r4 = r4.j0()
            java.lang.Object r4 = r4.getValue()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo r4 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo) r4
            if (r4 == 0) goto L_0x00b1
            java.util.List r4 = r4.getRecommend()
            goto L_0x00b2
        L_0x00b1:
            r4 = r3
        L_0x00b2:
            r0.setRecommend(r4)
            goto L_0x00bd
        L_0x00b6:
            java.util.List r4 = r8.getRecommend()
            r0.setRecommend(r4)
        L_0x00bd:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            com.hbg.module.community.viewmodel.CommunityViewModel r5 = r7.this$0
            androidx.lifecycle.MutableLiveData r5 = r5.j0()
            java.lang.Object r5 = r5.getValue()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo r5 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo) r5
            if (r5 == 0) goto L_0x00d5
            java.util.List r5 = r5.getList()
            goto L_0x00d6
        L_0x00d5:
            r5 = r3
        L_0x00d6:
            if (r5 == 0) goto L_0x00f7
            com.hbg.module.community.viewmodel.CommunityViewModel r5 = r7.this$0
            androidx.lifecycle.MutableLiveData r5 = r5.j0()
            java.lang.Object r5 = r5.getValue()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo r5 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo) r5
            if (r5 == 0) goto L_0x00f4
            java.util.List r5 = r5.getList()
            if (r5 == 0) goto L_0x00f4
            int r5 = r5.size()
            if (r5 != 0) goto L_0x00f4
            r5 = r1
            goto L_0x00f5
        L_0x00f4:
            r5 = r2
        L_0x00f5:
            if (r5 == 0) goto L_0x010e
        L_0x00f7:
            com.hbg.module.community.viewmodel.CommunityViewModel r5 = r7.this$0
            androidx.lifecycle.MutableLiveData r5 = r5.j0()
            java.lang.Object r5 = r5.getValue()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo r5 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo) r5
            if (r5 == 0) goto L_0x010a
            java.util.List r5 = r5.getList()
            goto L_0x010b
        L_0x010a:
            r5 = r3
        L_0x010b:
            r4.addAll(r5)
        L_0x010e:
            java.util.List r5 = r8.getList()
            r4.addAll(r5)
            r0.setList(r4)
            com.hbg.module.community.viewmodel.CommunityViewModel r4 = r7.this$0
            androidx.lifecycle.MutableLiveData r4 = r4.j0()
            r4.setValue(r0)
            goto L_0x012b
        L_0x0122:
            com.hbg.module.community.viewmodel.CommunityViewModel r0 = r7.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.j0()
            r0.setValue(r8)
        L_0x012b:
            com.hbg.module.community.viewmodel.CommunityViewModel r0 = r7.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.j0()
            java.lang.Object r0 = r0.getValue()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo r0 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo) r0
            if (r0 == 0) goto L_0x015b
            java.util.List r0 = r0.getList()
            if (r0 == 0) goto L_0x015b
            com.hbg.module.community.viewmodel.CommunityViewModel r4 = r7.this$0
            int r5 = r0.size()
            if (r5 <= 0) goto L_0x0156
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.m0(r0)
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean r0 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.ListBean) r0
            java.lang.Long r0 = r0.getCreatedTime()
            long r5 = r0.longValue()
            goto L_0x0158
        L_0x0156:
            r5 = 0
        L_0x0158:
            r4.f17622h = r5
        L_0x015b:
            com.hbg.module.community.viewmodel.CommunityViewModel r0 = r7.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.l0()
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r0.setValue(r4)
            if (r8 == 0) goto L_0x0194
            java.util.List r0 = r8.getList()
            if (r0 == 0) goto L_0x0194
            com.hbg.module.community.viewmodel.CommunityViewModel r0 = r7.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.n0()
            java.util.List r8 = r8.getList()
            if (r8 == 0) goto L_0x0182
            int r8 = r8.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
        L_0x0182:
            int r8 = r3.intValue()
            r3 = 10
            if (r8 < r3) goto L_0x018b
            goto L_0x018c
        L_0x018b:
            r1 = r2
        L_0x018c:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r1)
            r0.setValue(r8)
            goto L_0x019d
        L_0x0194:
            com.hbg.module.community.viewmodel.CommunityViewModel r8 = r7.this$0
            androidx.lifecycle.MutableLiveData r8 = r8.n0()
            r8.setValue(r4)
        L_0x019d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.viewmodel.CommunityViewModel$requestCommunityFeedInfo$1.invoke(com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo):void");
    }
}
