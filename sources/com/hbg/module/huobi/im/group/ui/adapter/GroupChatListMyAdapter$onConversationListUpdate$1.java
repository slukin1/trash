package com.hbg.module.huobi.im.group.ui.adapter;

import com.tencent.imsdk.v2.V2TIMConversation;
import d10.p;
import kotlin.jvm.internal.Lambda;

public final class GroupChatListMyAdapter$onConversationListUpdate$1 extends Lambda implements p<V2TIMConversation, V2TIMConversation, Integer> {
    public static final GroupChatListMyAdapter$onConversationListUpdate$1 INSTANCE = new GroupChatListMyAdapter$onConversationListUpdate$1();

    public GroupChatListMyAdapter$onConversationListUpdate$1() {
        super(2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r5 = r5.getLastMessage();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Integer invoke(com.tencent.imsdk.v2.V2TIMConversation r5, com.tencent.imsdk.v2.V2TIMConversation r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x000f
            com.tencent.imsdk.v2.V2TIMMessage r5 = r5.getLastMessage()
            if (r5 == 0) goto L_0x000f
            long r2 = r5.getTimestamp()
            goto L_0x0010
        L_0x000f:
            r2 = r0
        L_0x0010:
            if (r6 == 0) goto L_0x001c
            com.tencent.imsdk.v2.V2TIMMessage r5 = r6.getLastMessage()
            if (r5 == 0) goto L_0x001c
            long r0 = r5.getTimestamp()
        L_0x001c:
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 <= 0) goto L_0x0022
            r5 = -1
            goto L_0x0027
        L_0x0022:
            if (r5 >= 0) goto L_0x0026
            r5 = 1
            goto L_0x0027
        L_0x0026:
            r5 = 0
        L_0x0027:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.adapter.GroupChatListMyAdapter$onConversationListUpdate$1.invoke(com.tencent.imsdk.v2.V2TIMConversation, com.tencent.imsdk.v2.V2TIMConversation):java.lang.Integer");
    }
}
