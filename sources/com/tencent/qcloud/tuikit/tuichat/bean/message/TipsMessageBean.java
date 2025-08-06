package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;

public class TipsMessageBean extends TUIMessageBean {
    public static final int MSG_TYPE_GROUP_CREATE = 257;
    public static final int MSG_TYPE_GROUP_DELETE = 258;
    public static final int MSG_TYPE_GROUP_JOIN = 259;
    public static final int MSG_TYPE_GROUP_KICK = 261;
    public static final int MSG_TYPE_GROUP_MODIFY_NAME = 262;
    public static final int MSG_TYPE_GROUP_MODIFY_NOTICE = 263;
    public static final int MSG_TYPE_GROUP_QUITE = 260;
    private String text;
    private int tipType;

    private static String getDisplayName(V2TIMGroupMemberInfo v2TIMGroupMemberInfo) {
        if (v2TIMGroupMemberInfo == null) {
            return null;
        }
        if (!TextUtils.isEmpty(v2TIMGroupMemberInfo.getNameCard())) {
            return v2TIMGroupMemberInfo.getNameCard();
        }
        if (!TextUtils.isEmpty(v2TIMGroupMemberInfo.getFriendRemark())) {
            return v2TIMGroupMemberInfo.getFriendRemark();
        }
        if (!TextUtils.isEmpty(v2TIMGroupMemberInfo.getNickName())) {
            return v2TIMGroupMemberInfo.getNickName();
        }
        return v2TIMGroupMemberInfo.getUserID();
    }

    public String getText() {
        return this.text;
    }

    public int getTipType() {
        return this.tipType;
    }

    public String onGetDisplayString() {
        return getExtra();
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x03a5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0394  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onProcessMessage(com.tencent.imsdk.v2.V2TIMMessage r18) {
        /*
            r17 = this;
            r0 = r17
            com.tencent.imsdk.v2.V2TIMGroupTipsElem r1 = r18.getGroupTipsElem()
            if (r1 != 0) goto L_0x0009
            return
        L_0x0009:
            int r2 = r1.getType()
            java.util.List r3 = r1.getMemberList()
            int r3 = r3.size()
            java.lang.String r4 = ""
            r5 = 3
            r6 = 2
            if (r3 <= 0) goto L_0x0080
            java.util.List r3 = r1.getMemberList()
            r9 = r4
            r8 = 0
        L_0x0021:
            int r10 = r3.size()
            if (r8 >= r10) goto L_0x0081
            java.lang.Object r10 = r3.get(r8)
            com.tencent.imsdk.v2.V2TIMGroupMemberInfo r10 = (com.tencent.imsdk.v2.V2TIMGroupMemberInfo) r10
            if (r8 != 0) goto L_0x0043
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = getDisplayName(r10)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            goto L_0x007d
        L_0x0043:
            if (r8 != r6) goto L_0x0065
            int r11 = r3.size()
            if (r11 <= r5) goto L_0x0065
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            android.content.Context r8 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r9 = com.tencent.qcloud.tuikit.tuichat.R.string.etc
            java.lang.String r8 = r8.getString(r9)
            r3.append(r8)
            java.lang.String r9 = r3.toString()
            goto L_0x0081
        L_0x0065:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = "，"
            r11.append(r9)
            java.lang.String r9 = getDisplayName(r10)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
        L_0x007d:
            int r8 = r8 + 1
            goto L_0x0021
        L_0x0080:
            r9 = r4
        L_0x0081:
            com.tencent.imsdk.v2.V2TIMGroupMemberInfo r3 = r1.getOpMember()
            java.lang.String r3 = getDisplayName(r3)
            boolean r8 = android.text.TextUtils.isEmpty(r9)
            if (r8 != 0) goto L_0x0093
            java.lang.String r9 = com.tencent.qcloud.tuikit.tuichat.TUIChatConstants.covert2HTMLString(r9)
        L_0x0093:
            boolean r8 = android.text.TextUtils.isEmpty(r3)
            if (r8 != 0) goto L_0x009d
            java.lang.String r3 = com.tencent.qcloud.tuikit.tuichat.TUIChatConstants.covert2HTMLString(r3)
        L_0x009d:
            r8 = 259(0x103, float:3.63E-43)
            r10 = 1
            if (r2 != r10) goto L_0x00be
            r0.setTipType(r8)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r9)
            android.content.Context r11 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r12 = com.tencent.qcloud.tuikit.tuichat.R.string.join_group
            java.lang.String r11 = r11.getString(r12)
            r4.append(r11)
            java.lang.String r4 = r4.toString()
        L_0x00be:
            if (r2 != r6) goto L_0x00dc
            r0.setTipType(r8)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r9)
            android.content.Context r8 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r11 = com.tencent.qcloud.tuikit.tuichat.R.string.invite_joined_group
            java.lang.String r8 = r8.getString(r11)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
        L_0x00dc:
            if (r2 != r5) goto L_0x00fc
            r4 = 260(0x104, float:3.64E-43)
            r0.setTipType(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            android.content.Context r8 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r11 = com.tencent.qcloud.tuikit.tuichat.R.string.quit_group
            java.lang.String r8 = r8.getString(r11)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
        L_0x00fc:
            r8 = 4
            if (r2 != r8) goto L_0x011d
            r4 = 261(0x105, float:3.66E-43)
            r0.setTipType(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r9)
            android.content.Context r11 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r12 = com.tencent.qcloud.tuikit.tuichat.R.string.kick_group_tip
            java.lang.String r11 = r11.getString(r12)
            r4.append(r11)
            java.lang.String r4 = r4.toString()
        L_0x011d:
            r11 = 5
            r12 = 263(0x107, float:3.69E-43)
            if (r2 != r11) goto L_0x013e
            r0.setTipType(r12)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r9)
            android.content.Context r13 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r14 = com.tencent.qcloud.tuikit.tuichat.R.string.be_group_manager
            java.lang.String r13 = r13.getString(r14)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
        L_0x013e:
            r13 = 6
            if (r2 != r13) goto L_0x015d
            r0.setTipType(r12)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r9)
            android.content.Context r13 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r14 = com.tencent.qcloud.tuikit.tuichat.R.string.cancle_group_manager
            java.lang.String r13 = r13.getString(r14)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
        L_0x015d:
            r13 = 7
            java.lang.String r15 = "\""
            if (r2 != r13) goto L_0x03af
            java.util.List r13 = r1.getGroupChangeInfoList()
            r7 = 0
        L_0x0167:
            int r14 = r13.size()
            if (r7 >= r14) goto L_0x03af
            java.lang.Object r14 = r13.get(r7)
            com.tencent.imsdk.v2.V2TIMGroupChangeInfo r14 = (com.tencent.imsdk.v2.V2TIMGroupChangeInfo) r14
            int r6 = r14.getType()
            if (r6 != r10) goto L_0x01a7
            r4 = 262(0x106, float:3.67E-43)
            r0.setTipType(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            android.content.Context r6 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r10 = com.tencent.qcloud.tuikit.tuichat.R.string.modify_group_name_is
            java.lang.String r6 = r6.getString(r10)
            r4.append(r6)
            r4.append(r15)
            java.lang.String r6 = r14.getValue()
            r4.append(r6)
            r4.append(r15)
            java.lang.String r4 = r4.toString()
        L_0x01a4:
            r10 = 2
            goto L_0x038c
        L_0x01a7:
            if (r6 != r5) goto L_0x01d3
            r0.setTipType(r12)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            android.content.Context r6 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r10 = com.tencent.qcloud.tuikit.tuichat.R.string.modify_notice
            java.lang.String r6 = r6.getString(r10)
            r4.append(r6)
            r4.append(r15)
            java.lang.String r6 = r14.getValue()
            r4.append(r6)
            r4.append(r15)
            java.lang.String r4 = r4.toString()
            goto L_0x01a4
        L_0x01d3:
            if (r6 != r11) goto L_0x022d
            r0.setTipType(r12)
            boolean r4 = android.text.TextUtils.isEmpty(r9)
            if (r4 != 0) goto L_0x0201
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            android.content.Context r6 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r10 = com.tencent.qcloud.tuikit.tuichat.R.string.move_owner
            java.lang.String r6 = r6.getString(r10)
            r4.append(r6)
            r4.append(r15)
            r4.append(r9)
            r4.append(r15)
            java.lang.String r4 = r4.toString()
            goto L_0x01a4
        L_0x0201:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            android.content.Context r6 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r10 = com.tencent.qcloud.tuikit.tuichat.R.string.move_owner
            java.lang.String r6 = r6.getString(r10)
            r4.append(r6)
            r4.append(r15)
            java.lang.String r6 = r14.getValue()
            java.lang.String r6 = com.tencent.qcloud.tuikit.tuichat.TUIChatConstants.covert2HTMLString(r6)
            r4.append(r6)
            r4.append(r15)
            java.lang.String r4 = r4.toString()
            goto L_0x01a4
        L_0x022d:
            if (r6 != r8) goto L_0x024d
            r0.setTipType(r12)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            android.content.Context r6 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r10 = com.tencent.qcloud.tuikit.tuichat.R.string.modify_group_avatar
            java.lang.String r6 = r6.getString(r10)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            goto L_0x01a4
        L_0x024d:
            r10 = 2
            if (r6 != r10) goto L_0x027b
            r0.setTipType(r12)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            android.content.Context r6 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r5 = com.tencent.qcloud.tuikit.tuichat.R.string.modify_introduction
            java.lang.String r5 = r6.getString(r5)
            r4.append(r5)
            r4.append(r15)
            java.lang.String r5 = r14.getValue()
            r4.append(r5)
            r4.append(r15)
            java.lang.String r4 = r4.toString()
            goto L_0x038c
        L_0x027b:
            r5 = 8
            if (r6 != r5) goto L_0x02be
            r0.setTipType(r12)
            boolean r4 = r14.getBoolValue()
            if (r4 == 0) goto L_0x02a3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            android.content.Context r5 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r6 = com.tencent.qcloud.tuikit.tuichat.R.string.modify_shut_up_all
            java.lang.String r5 = r5.getString(r6)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            goto L_0x038c
        L_0x02a3:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            android.content.Context r5 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r6 = com.tencent.qcloud.tuikit.tuichat.R.string.modify_cancel_shut_up_all
            java.lang.String r5 = r5.getString(r6)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            goto L_0x038c
        L_0x02be:
            r5 = 11
            if (r6 != r5) goto L_0x0328
            r0.setTipType(r12)
            android.content.Context r4 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r5 = com.tencent.qcloud.tuikit.tuichat.R.string.modify_group_add_opt
            java.lang.String r4 = r4.getString(r5)
            int r5 = r14.getIntValue()
            if (r5 != 0) goto L_0x02f0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            android.content.Context r4 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r6 = com.tencent.qcloud.tuikit.tuichat.R.string.group_add_opt_join_disable
            java.lang.String r4 = r4.getString(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            goto L_0x038c
        L_0x02f0:
            r6 = 1
            if (r5 != r6) goto L_0x030e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            android.content.Context r4 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r6 = com.tencent.qcloud.tuikit.tuichat.R.string.group_add_opt_admin_approve
            java.lang.String r4 = r4.getString(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            goto L_0x038c
        L_0x030e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            android.content.Context r4 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r6 = com.tencent.qcloud.tuikit.tuichat.R.string.group_add_opt_auto_approval
            java.lang.String r4 = r4.getString(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            goto L_0x038c
        L_0x0328:
            r5 = 12
            if (r6 != r5) goto L_0x038c
            android.content.Context r4 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r5 = com.tencent.qcloud.tuikit.tuichat.R.string.modify_group_invite_opt
            java.lang.String r4 = r4.getString(r5)
            int r5 = r14.getIntValue()
            if (r5 != 0) goto L_0x0356
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            android.content.Context r4 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r6 = com.tencent.qcloud.tuikit.tuichat.R.string.group_add_opt_join_disable
            java.lang.String r4 = r4.getString(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            goto L_0x038c
        L_0x0356:
            r6 = 1
            if (r5 != r6) goto L_0x0373
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            android.content.Context r4 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r6 = com.tencent.qcloud.tuikit.tuichat.R.string.group_add_opt_admin_approve
            java.lang.String r4 = r4.getString(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            goto L_0x038c
        L_0x0373:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            android.content.Context r4 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r6 = com.tencent.qcloud.tuikit.tuichat.R.string.group_add_opt_auto_approval
            java.lang.String r4 = r4.getString(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
        L_0x038c:
            int r5 = r13.size()
            r6 = 1
            int r5 = r5 - r6
            if (r7 >= r5) goto L_0x03a5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = "、"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
        L_0x03a5:
            int r7 = r7 + 1
            r5 = 3
            r16 = r10
            r10 = r6
            r6 = r16
            goto L_0x0167
        L_0x03af:
            r3 = 8
            if (r2 != r3) goto L_0x0411
            java.util.List r1 = r1.getMemberChangeInfoList()
            int r2 = r1.size()
            if (r2 <= 0) goto L_0x0411
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.tencent.imsdk.v2.V2TIMGroupMemberChangeInfo r1 = (com.tencent.imsdk.v2.V2TIMGroupMemberChangeInfo) r1
            long r1 = r1.getMuteTime()
            r0.setTipType(r12)
            r3 = 0
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x03f8
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            android.content.Context r4 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r5 = com.tencent.qcloud.tuikit.tuichat.R.string.banned
            java.lang.String r4 = r4.getString(r5)
            r3.append(r4)
            r3.append(r15)
            java.lang.String r1 = com.tencent.qcloud.tuikit.timcommon.util.DateTimeUtil.formatSeconds(r1)
            r3.append(r1)
            r3.append(r15)
            java.lang.String r4 = r3.toString()
            goto L_0x0411
        L_0x03f8:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            android.content.Context r2 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r3 = com.tencent.qcloud.tuikit.tuichat.R.string.cancle_banned
            java.lang.String r2 = r2.getString(r3)
            r1.append(r2)
            java.lang.String r4 = r1.toString()
        L_0x0411:
            r0.text = r4
            r0.setExtra(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean.onProcessMessage(com.tencent.imsdk.v2.V2TIMMessage):void");
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTipType(int i11) {
        this.tipType = i11;
    }
}
