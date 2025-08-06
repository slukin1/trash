package com.hbg.module.huobi.im.group.ui.chat;

import android.view.View;
import android.widget.TextView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.group.bean.HbSharePrimeMessageBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnItemClickListener;
import java.util.HashMap;
import rd.q;

public class HbSharePrimeMessageHolder extends HbMessageContentHolder {
    private HashMap<String, Object> point;
    private TextView tvTextBody;

    public HbSharePrimeMessageHolder(View view) {
        super(view);
        this.tvTextBody = (TextView) view.findViewById(R$id.msg_body_tv);
    }

    private void jumpActionUrl(String str) {
        BaseModuleConfig.a().k0(str);
        q.a("APP_LIVE_group_primeboxclk", this.point);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$layoutVariableViews$0(TUIMessageBean tUIMessageBean, int i11, View view) {
        ((HbSharePrimeMessageBean) tUIMessageBean).type = 0;
        OnItemClickListener onItemClickListener = this.onItemClickListener;
        if (onItemClickListener == null) {
            return false;
        }
        onItemClickListener.onMessageLongClick(view, i11, tUIMessageBean);
        return true;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$layoutVariableViews$1(String str, View view) {
        jumpActionUrl(str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$layoutVariableViews$2(String str, View view) {
        jumpActionUrl(str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$layoutVariableViews$3(String str, View view) {
        jumpActionUrl(str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$layoutVariableViews$4(String str, View view) {
        jumpActionUrl(str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getVariableLayout() {
        return R$layout.im_message_adapter_share;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layoutVariableViews(com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = "message"
            boolean r1 = r10 instanceof com.hbg.module.huobi.im.group.bean.HbSharePrimeMessageBean
            if (r1 == 0) goto L_0x01d5
            r1 = 8
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r9.point     // Catch:{ Exception -> 0x01c7 }
            if (r2 != 0) goto L_0x002b
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x01c7 }
            r2.<init>()     // Catch:{ Exception -> 0x01c7 }
            r9.point = r2     // Catch:{ Exception -> 0x01c7 }
            java.lang.String r3 = "groupid"
            r4 = r10
            com.hbg.module.huobi.im.group.bean.HbSharePrimeMessageBean r4 = (com.hbg.module.huobi.im.group.bean.HbSharePrimeMessageBean) r4     // Catch:{ Exception -> 0x01c7 }
            java.lang.String r4 = r4.groupId     // Catch:{ Exception -> 0x01c7 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x01c7 }
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r9.point     // Catch:{ Exception -> 0x01c7 }
            java.lang.String r3 = "state"
            r4 = r10
            com.hbg.module.huobi.im.group.bean.HbSharePrimeMessageBean r4 = (com.hbg.module.huobi.im.group.bean.HbSharePrimeMessageBean) r4     // Catch:{ Exception -> 0x01c7 }
            java.lang.String r4 = r4.getNickName()     // Catch:{ Exception -> 0x01c7 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x01c7 }
        L_0x002b:
            java.lang.String r2 = "APP_LIVE_group_primebox"
            java.util.HashMap<java.lang.String, java.lang.Object> r3 = r9.point     // Catch:{ Exception -> 0x01c7 }
            rd.q.a(r2, r3)     // Catch:{ Exception -> 0x01c7 }
            android.widget.LinearLayout r2 = r9.msgContentLinear     // Catch:{ Exception -> 0x01c7 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x01c7 }
            android.view.View r2 = r9.mContentLayout     // Catch:{ Exception -> 0x01c7 }
            int r3 = com.hbg.module.huobi.im.R$id.clSharePrime     // Catch:{ Exception -> 0x01c7 }
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x01c7 }
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2     // Catch:{ Exception -> 0x01c7 }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x01c7 }
            android.view.View r2 = r9.mContentLayout     // Catch:{ Exception -> 0x01c7 }
            int r4 = com.hbg.module.huobi.im.R$id.tvTextPrime     // Catch:{ Exception -> 0x01c7 }
            android.view.View r2 = r2.findViewById(r4)     // Catch:{ Exception -> 0x01c7 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x01c7 }
            android.view.View r4 = r9.mContentLayout     // Catch:{ Exception -> 0x01c7 }
            int r5 = com.hbg.module.huobi.im.R$id.ivCoverPrime     // Catch:{ Exception -> 0x01c7 }
            android.view.View r4 = r4.findViewById(r5)     // Catch:{ Exception -> 0x01c7 }
            android.widget.ImageView r4 = (android.widget.ImageView) r4     // Catch:{ Exception -> 0x01c7 }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x01c7 }
            r4.setTag(r5)     // Catch:{ Exception -> 0x01c7 }
            android.view.View r6 = r9.mContentLayout     // Catch:{ Exception -> 0x01c7 }
            int r7 = com.hbg.module.huobi.im.R$id.tvJumpPrime     // Catch:{ Exception -> 0x01c7 }
            android.view.View r6 = r6.findViewById(r7)     // Catch:{ Exception -> 0x01c7 }
            android.widget.TextView r6 = (android.widget.TextView) r6     // Catch:{ Exception -> 0x01c7 }
            r6.setTag(r5)     // Catch:{ Exception -> 0x01c7 }
            android.view.View r7 = r9.mContentLayout     // Catch:{ Exception -> 0x01c7 }
            int r8 = com.hbg.module.huobi.im.R$id.tvTagPrime     // Catch:{ Exception -> 0x01c7 }
            android.view.View r7 = r7.findViewById(r8)     // Catch:{ Exception -> 0x01c7 }
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ Exception -> 0x01c7 }
            r7.setTag(r5)     // Catch:{ Exception -> 0x01c7 }
            com.hbg.module.huobi.im.group.ui.chat.q r5 = new com.hbg.module.huobi.im.group.ui.chat.q     // Catch:{ Exception -> 0x01c7 }
            r5.<init>(r9, r10, r11)     // Catch:{ Exception -> 0x01c7 }
            r2.setOnLongClickListener(r5)     // Catch:{ Exception -> 0x01c7 }
            r4.setOnLongClickListener(r5)     // Catch:{ Exception -> 0x01c7 }
            r6.setOnLongClickListener(r5)     // Catch:{ Exception -> 0x01c7 }
            r7.setOnLongClickListener(r5)     // Catch:{ Exception -> 0x01c7 }
            com.tencent.imsdk.v2.V2TIMMessage r11 = r10.getV2TIMMessage()     // Catch:{ Exception -> 0x01c7 }
            if (r11 == 0) goto L_0x01d5
            com.tencent.imsdk.v2.V2TIMMessage r11 = r10.getV2TIMMessage()     // Catch:{ Exception -> 0x01c7 }
            com.tencent.imsdk.v2.V2TIMCustomElem r11 = r11.getCustomElem()     // Catch:{ Exception -> 0x01c7 }
            if (r11 == 0) goto L_0x01d5
            com.tencent.imsdk.v2.V2TIMMessage r11 = r10.getV2TIMMessage()     // Catch:{ Exception -> 0x01c7 }
            com.tencent.imsdk.v2.V2TIMCustomElem r11 = r11.getCustomElem()     // Catch:{ Exception -> 0x01c7 }
            if (r11 == 0) goto L_0x01d5
            byte[] r5 = r11.getData()     // Catch:{ Exception -> 0x01c7 }
            if (r5 == 0) goto L_0x01d5
            byte[] r11 = r11.getData()     // Catch:{ Exception -> 0x01c7 }
            java.lang.String r5 = new java.lang.String     // Catch:{ Exception -> 0x01c7 }
            r5.<init>(r11)     // Catch:{ Exception -> 0x01c7 }
            com.google.gson.Gson r11 = new com.google.gson.Gson     // Catch:{ Exception -> 0x01c7 }
            r11.<init>()     // Catch:{ Exception -> 0x01c7 }
            java.lang.Class<com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage> r8 = com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage.class
            java.lang.Object r11 = r11.fromJson((java.lang.String) r5, r8)     // Catch:{ Exception -> 0x01c7 }
            com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage r11 = (com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage) r11     // Catch:{ Exception -> 0x01c7 }
            if (r11 == 0) goto L_0x01d5
            java.util.Map<java.lang.String, java.lang.Object> r11 = r11.data     // Catch:{ Exception -> 0x01c7 }
            if (r11 == 0) goto L_0x01d5
            java.lang.String r5 = "extInfo"
            java.lang.Object r11 = r11.get(r5)     // Catch:{ Exception -> 0x01c7 }
            boolean r5 = r11 instanceof java.lang.String     // Catch:{ Exception -> 0x01c7 }
            if (r5 == 0) goto L_0x00dc
            com.google.gson.Gson r5 = new com.google.gson.Gson     // Catch:{ Exception -> 0x01c7 }
            r5.<init>()     // Catch:{ Exception -> 0x01c7 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x01c7 }
            java.lang.Class<java.util.HashMap> r8 = java.util.HashMap.class
            java.lang.Object r11 = r5.fromJson((java.lang.String) r11, r8)     // Catch:{ Exception -> 0x01c7 }
        L_0x00dc:
            boolean r5 = r11 instanceof java.util.Map     // Catch:{ Exception -> 0x01c7 }
            if (r5 == 0) goto L_0x01bc
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Exception -> 0x01c7 }
            java.lang.Object r5 = r11.get(r0)     // Catch:{ Exception -> 0x01c7 }
            boolean r8 = r5 instanceof java.lang.String     // Catch:{ Exception -> 0x01c7 }
            if (r8 == 0) goto L_0x00fe
            com.google.gson.Gson r5 = new com.google.gson.Gson     // Catch:{ Exception -> 0x01c7 }
            r5.<init>()     // Catch:{ Exception -> 0x01c7 }
            java.lang.Object r11 = r11.get(r0)     // Catch:{ Exception -> 0x01c7 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x01c7 }
            java.lang.Class<java.util.HashMap> r0 = java.util.HashMap.class
            java.lang.Object r11 = r5.fromJson((java.lang.String) r11, r0)     // Catch:{ Exception -> 0x01c7 }
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Exception -> 0x01c7 }
            goto L_0x0105
        L_0x00fe:
            boolean r0 = r5 instanceof java.util.Map     // Catch:{ Exception -> 0x01c7 }
            if (r0 == 0) goto L_0x0105
            r11 = r5
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Exception -> 0x01c7 }
        L_0x0105:
            java.lang.String r0 = "shareTitle"
            java.lang.Object r0 = r11.get(r0)     // Catch:{ Exception -> 0x01c7 }
            boolean r5 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x01c7 }
            if (r5 == 0) goto L_0x0126
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x01c7 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01c7 }
            if (r5 == 0) goto L_0x011b
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x01c7 }
            goto L_0x0126
        L_0x011b:
            r5 = r10
            com.hbg.module.huobi.im.group.bean.HbSharePrimeMessageBean r5 = (com.hbg.module.huobi.im.group.bean.HbSharePrimeMessageBean) r5     // Catch:{ Exception -> 0x01c7 }
            r5.shareText = r0     // Catch:{ Exception -> 0x01c7 }
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x01c7 }
            r2.setText(r0)     // Catch:{ Exception -> 0x01c7 }
        L_0x0126:
            java.lang.String r0 = "shareImageUrl"
            java.lang.Object r0 = r11.get(r0)     // Catch:{ Exception -> 0x01c7 }
            boolean r5 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x01c7 }
            if (r5 == 0) goto L_0x014b
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x01c7 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01c7 }
            if (r5 == 0) goto L_0x013c
            r4.setVisibility(r1)     // Catch:{ Exception -> 0x01c7 }
            goto L_0x014b
        L_0x013c:
            r5 = r10
            com.hbg.module.huobi.im.group.bean.HbSharePrimeMessageBean r5 = (com.hbg.module.huobi.im.group.bean.HbSharePrimeMessageBean) r5     // Catch:{ Exception -> 0x01c7 }
            r5.shareImageUrl = r0     // Catch:{ Exception -> 0x01c7 }
            r4.setVisibility(r3)     // Catch:{ Exception -> 0x01c7 }
            f6.c r5 = f6.c.a()     // Catch:{ Exception -> 0x01c7 }
            r5.e(r4, r0)     // Catch:{ Exception -> 0x01c7 }
        L_0x014b:
            java.lang.String r0 = "shareActionUrl"
            java.lang.Object r0 = r11.get(r0)     // Catch:{ Exception -> 0x01c7 }
            boolean r5 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x01c7 }
            if (r5 == 0) goto L_0x017d
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x01c7 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01c7 }
            if (r5 != 0) goto L_0x017d
            com.hbg.module.huobi.im.group.ui.chat.m r5 = new com.hbg.module.huobi.im.group.ui.chat.m     // Catch:{ Exception -> 0x01c7 }
            r5.<init>(r9, r0)     // Catch:{ Exception -> 0x01c7 }
            r2.setOnClickListener(r5)     // Catch:{ Exception -> 0x01c7 }
            com.hbg.module.huobi.im.group.ui.chat.o r2 = new com.hbg.module.huobi.im.group.ui.chat.o     // Catch:{ Exception -> 0x01c7 }
            r2.<init>(r9, r0)     // Catch:{ Exception -> 0x01c7 }
            r4.setOnClickListener(r2)     // Catch:{ Exception -> 0x01c7 }
            com.hbg.module.huobi.im.group.ui.chat.p r2 = new com.hbg.module.huobi.im.group.ui.chat.p     // Catch:{ Exception -> 0x01c7 }
            r2.<init>(r9, r0)     // Catch:{ Exception -> 0x01c7 }
            r6.setOnClickListener(r2)     // Catch:{ Exception -> 0x01c7 }
            com.hbg.module.huobi.im.group.ui.chat.n r2 = new com.hbg.module.huobi.im.group.ui.chat.n     // Catch:{ Exception -> 0x01c7 }
            r2.<init>(r9, r0)     // Catch:{ Exception -> 0x01c7 }
            r7.setOnClickListener(r2)     // Catch:{ Exception -> 0x01c7 }
        L_0x017d:
            boolean r0 = r10.isSelf()     // Catch:{ Exception -> 0x01c7 }
            if (r0 != 0) goto L_0x01a3
            java.lang.String r0 = "shareActionTitle"
            java.lang.Object r0 = r11.get(r0)     // Catch:{ Exception -> 0x01c7 }
            boolean r2 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x01c7 }
            if (r2 == 0) goto L_0x01a3
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x01c7 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01c7 }
            if (r2 == 0) goto L_0x0199
            r6.setVisibility(r1)     // Catch:{ Exception -> 0x01c7 }
            goto L_0x01a3
        L_0x0199:
            com.hbg.module.huobi.im.group.bean.HbSharePrimeMessageBean r10 = (com.hbg.module.huobi.im.group.bean.HbSharePrimeMessageBean) r10     // Catch:{ Exception -> 0x01c7 }
            r10.shareActionTitle = r0     // Catch:{ Exception -> 0x01c7 }
            r6.setVisibility(r3)     // Catch:{ Exception -> 0x01c7 }
            r6.setText(r0)     // Catch:{ Exception -> 0x01c7 }
        L_0x01a3:
            java.lang.String r10 = "shareSource"
            java.lang.Object r10 = r11.get(r10)     // Catch:{ Exception -> 0x01c7 }
            boolean r11 = r10 instanceof java.lang.String     // Catch:{ Exception -> 0x01c7 }
            if (r11 == 0) goto L_0x01d5
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x01c7 }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x01c7 }
            if (r11 != 0) goto L_0x01d5
            r7.setVisibility(r3)     // Catch:{ Exception -> 0x01c7 }
            r7.setText(r10)     // Catch:{ Exception -> 0x01c7 }
            goto L_0x01d5
        L_0x01bc:
            android.widget.TextView r10 = r9.chatTimeText     // Catch:{ Exception -> 0x01c7 }
            r10.setVisibility(r1)     // Catch:{ Exception -> 0x01c7 }
            android.widget.RelativeLayout r10 = r9.rightGroupLayout     // Catch:{ Exception -> 0x01c7 }
            r10.setVisibility(r1)     // Catch:{ Exception -> 0x01c7 }
            goto L_0x01d5
        L_0x01c7:
            r10 = move-exception
            r10.printStackTrace()
            android.widget.TextView r10 = r9.chatTimeText
            r10.setVisibility(r1)
            android.widget.RelativeLayout r10 = r9.rightGroupLayout
            r10.setVisibility(r1)
        L_0x01d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.chat.HbSharePrimeMessageHolder.layoutVariableViews(com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v24, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layoutViews(com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "message"
            super.layoutViews(r5, r6)
            boolean r6 = r5 instanceof com.hbg.module.huobi.im.group.bean.HbSharePrimeMessageBean
            if (r6 == 0) goto L_0x0109
            com.tencent.imsdk.v2.V2TIMMessage r6 = r5.getV2TIMMessage()     // Catch:{ Exception -> 0x0105 }
            if (r6 == 0) goto L_0x0109
            com.tencent.imsdk.v2.V2TIMMessage r6 = r5.getV2TIMMessage()     // Catch:{ Exception -> 0x0105 }
            com.tencent.imsdk.v2.V2TIMCustomElem r6 = r6.getCustomElem()     // Catch:{ Exception -> 0x0105 }
            if (r6 == 0) goto L_0x0109
            com.tencent.imsdk.v2.V2TIMMessage r6 = r5.getV2TIMMessage()     // Catch:{ Exception -> 0x0105 }
            com.tencent.imsdk.v2.V2TIMCustomElem r6 = r6.getCustomElem()     // Catch:{ Exception -> 0x0105 }
            if (r6 == 0) goto L_0x0109
            byte[] r1 = r6.getData()     // Catch:{ Exception -> 0x0105 }
            if (r1 == 0) goto L_0x0109
            byte[] r6 = r6.getData()     // Catch:{ Exception -> 0x0105 }
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x0105 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0105 }
            com.google.gson.Gson r6 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0105 }
            r6.<init>()     // Catch:{ Exception -> 0x0105 }
            java.lang.Class<com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage> r2 = com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage.class
            java.lang.Object r6 = r6.fromJson((java.lang.String) r1, r2)     // Catch:{ Exception -> 0x0105 }
            com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage r6 = (com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage) r6     // Catch:{ Exception -> 0x0105 }
            if (r6 == 0) goto L_0x0109
            java.util.Map<java.lang.String, java.lang.Object> r6 = r6.data     // Catch:{ Exception -> 0x0105 }
            if (r6 == 0) goto L_0x0109
            java.lang.String r1 = "extInfo"
            java.lang.Object r6 = r6.get(r1)     // Catch:{ Exception -> 0x0105 }
            boolean r1 = r6 instanceof java.lang.String     // Catch:{ Exception -> 0x0105 }
            if (r1 == 0) goto L_0x005c
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0105 }
            r1.<init>()     // Catch:{ Exception -> 0x0105 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0105 }
            java.lang.Class<java.util.HashMap> r2 = java.util.HashMap.class
            java.lang.Object r6 = r1.fromJson((java.lang.String) r6, r2)     // Catch:{ Exception -> 0x0105 }
        L_0x005c:
            boolean r1 = r6 instanceof java.util.Map     // Catch:{ Exception -> 0x0105 }
            if (r1 == 0) goto L_0x0109
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x0105 }
            java.lang.Object r1 = r6.get(r0)     // Catch:{ Exception -> 0x0105 }
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ Exception -> 0x0105 }
            if (r2 == 0) goto L_0x007e
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0105 }
            r1.<init>()     // Catch:{ Exception -> 0x0105 }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ Exception -> 0x0105 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0105 }
            java.lang.Class<java.util.HashMap> r0 = java.util.HashMap.class
            java.lang.Object r6 = r1.fromJson((java.lang.String) r6, r0)     // Catch:{ Exception -> 0x0105 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x0105 }
            goto L_0x0085
        L_0x007e:
            boolean r0 = r1 instanceof java.util.Map     // Catch:{ Exception -> 0x0105 }
            if (r0 == 0) goto L_0x0085
            r6 = r1
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x0105 }
        L_0x0085:
            android.view.View r0 = r4.mContentLayout     // Catch:{ Exception -> 0x0105 }
            int r1 = com.hbg.module.huobi.im.R$id.tv_share_text     // Catch:{ Exception -> 0x0105 }
            android.view.View r0 = r0.findViewById(r1)     // Catch:{ Exception -> 0x0105 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x0105 }
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()     // Catch:{ Exception -> 0x0105 }
            android.widget.RelativeLayout$LayoutParams r0 = (android.widget.RelativeLayout.LayoutParams) r0     // Catch:{ Exception -> 0x0105 }
            java.lang.String r1 = "shareText"
            java.lang.Object r6 = r6.get(r1)     // Catch:{ Exception -> 0x0105 }
            boolean r1 = r6 instanceof java.lang.String     // Catch:{ Exception -> 0x0105 }
            r2 = 0
            r3 = 8
            if (r1 == 0) goto L_0x00f8
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0105 }
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0105 }
            if (r1 == 0) goto L_0x00b7
            android.widget.LinearLayout r5 = r4.msgContentLinear     // Catch:{ Exception -> 0x0105 }
            r5.setVisibility(r3)     // Catch:{ Exception -> 0x0105 }
            android.widget.TextView r5 = r4.tvTextBody     // Catch:{ Exception -> 0x0105 }
            r5.setVisibility(r3)     // Catch:{ Exception -> 0x0105 }
            r0.topMargin = r2     // Catch:{ Exception -> 0x0105 }
            goto L_0x0109
        L_0x00b7:
            android.widget.TextView r1 = r4.tvTextBody     // Catch:{ Exception -> 0x0105 }
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x0105 }
            android.widget.LinearLayout r1 = r4.msgContentLinear     // Catch:{ Exception -> 0x0105 }
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x0105 }
            android.widget.TextView r1 = r4.tvTextBody     // Catch:{ Exception -> 0x0105 }
            r1.setText(r6)     // Catch:{ Exception -> 0x0105 }
            r6 = 1092616192(0x41200000, float:10.0)
            int r6 = com.hbg.lib.common.utils.PixelUtils.a(r6)     // Catch:{ Exception -> 0x0105 }
            r0.topMargin = r6     // Catch:{ Exception -> 0x0105 }
            boolean r5 = r5.isSelf()     // Catch:{ Exception -> 0x0105 }
            if (r5 != 0) goto L_0x00e6
            android.widget.TextView r5 = r4.tvTextBody     // Catch:{ Exception -> 0x0105 }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x0105 }
            int r6 = com.hbg.module.huobi.im.R$color.new_common_text_color     // Catch:{ Exception -> 0x0105 }
            int r5 = r5.getColor(r6)     // Catch:{ Exception -> 0x0105 }
            android.widget.TextView r6 = r4.tvTextBody     // Catch:{ Exception -> 0x0105 }
            r6.setTextColor(r5)     // Catch:{ Exception -> 0x0105 }
            goto L_0x0109
        L_0x00e6:
            android.widget.TextView r5 = r4.tvTextBody     // Catch:{ Exception -> 0x0105 }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x0105 }
            int r6 = com.hbg.module.huobi.im.R$color.white     // Catch:{ Exception -> 0x0105 }
            int r5 = r5.getColor(r6)     // Catch:{ Exception -> 0x0105 }
            android.widget.TextView r6 = r4.tvTextBody     // Catch:{ Exception -> 0x0105 }
            r6.setTextColor(r5)     // Catch:{ Exception -> 0x0105 }
            goto L_0x0109
        L_0x00f8:
            android.widget.LinearLayout r5 = r4.msgContentLinear     // Catch:{ Exception -> 0x0105 }
            r5.setVisibility(r3)     // Catch:{ Exception -> 0x0105 }
            android.widget.TextView r5 = r4.tvTextBody     // Catch:{ Exception -> 0x0105 }
            r5.setVisibility(r3)     // Catch:{ Exception -> 0x0105 }
            r0.topMargin = r2     // Catch:{ Exception -> 0x0105 }
            goto L_0x0109
        L_0x0105:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0109:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.chat.HbSharePrimeMessageHolder.layoutViews(com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean, int):void");
    }
}
