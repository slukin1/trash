package com.hbg.module.huobi.im.group.ui.chat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.photoviewer.PhotoViewerActivity;
import com.hbg.lib.widgets.photoviewer.PhotoViewerUtils;
import com.hbg.lib.widgets.photoviewer.data.ImageData;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import java.util.ArrayList;

public class HbShareMessageHolder extends HbMessageContentHolder {
    private static final int DEFAULT_MAX_SIZE = PixelUtils.a(130.0f);
    private TextView tvTextBody;

    public HbShareMessageHolder(View view) {
        super(view);
        this.tvTextBody = (TextView) view.findViewById(R$id.msg_body_tv);
    }

    /* access modifiers changed from: private */
    public void gotoBigImageView(Context context, String str) {
        if (!TextUtils.isEmpty(str) && (context instanceof Activity)) {
            context.startActivity(new Intent(context, PhotoViewerActivity.class));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ImageData(str, str));
            PhotoViewerUtils.a((Activity) context, arrayList, 0);
        }
    }

    public int getVariableLayout() {
        return R$layout.im_message_adapter_share;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v24, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layoutVariableViews(final com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean r11, final int r12) {
        /*
            r10 = this;
            java.lang.String r0 = "message"
            boolean r1 = r11 instanceof com.hbg.module.huobi.im.group.bean.HbShareMessageBean
            if (r1 == 0) goto L_0x01e1
            r1 = 8
            android.widget.LinearLayout r2 = r10.msgContentLinear     // Catch:{ Exception -> 0x01d3 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x01d3 }
            android.view.View r2 = r10.mContentLayout     // Catch:{ Exception -> 0x01d3 }
            int r3 = com.hbg.module.huobi.im.R$id.iv_cover     // Catch:{ Exception -> 0x01d3 }
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x01d3 }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ Exception -> 0x01d3 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x01d3 }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x01d3 }
            r2.setTag(r3)     // Catch:{ Exception -> 0x01d3 }
            android.view.View r4 = r10.mContentLayout     // Catch:{ Exception -> 0x01d3 }
            int r5 = com.hbg.module.huobi.im.R$id.tv_jump     // Catch:{ Exception -> 0x01d3 }
            android.view.View r4 = r4.findViewById(r5)     // Catch:{ Exception -> 0x01d3 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x01d3 }
            r4.setTag(r3)     // Catch:{ Exception -> 0x01d3 }
            r4.setVisibility(r1)     // Catch:{ Exception -> 0x01d3 }
            android.view.View r3 = r10.mContentLayout     // Catch:{ Exception -> 0x01d3 }
            int r5 = com.hbg.module.huobi.im.R$id.rl_share     // Catch:{ Exception -> 0x01d3 }
            android.view.View r3 = r3.findViewById(r5)     // Catch:{ Exception -> 0x01d3 }
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3     // Catch:{ Exception -> 0x01d3 }
            com.hbg.module.huobi.im.group.ui.chat.HbShareMessageHolder$1 r5 = new com.hbg.module.huobi.im.group.ui.chat.HbShareMessageHolder$1     // Catch:{ Exception -> 0x01d3 }
            r5.<init>(r11, r12)     // Catch:{ Exception -> 0x01d3 }
            r2.setOnLongClickListener(r5)     // Catch:{ Exception -> 0x01d3 }
            r4.setOnLongClickListener(r5)     // Catch:{ Exception -> 0x01d3 }
            com.tencent.imsdk.v2.V2TIMMessage r12 = r11.getV2TIMMessage()     // Catch:{ Exception -> 0x01d3 }
            if (r12 == 0) goto L_0x01e1
            com.tencent.imsdk.v2.V2TIMMessage r12 = r11.getV2TIMMessage()     // Catch:{ Exception -> 0x01d3 }
            com.tencent.imsdk.v2.V2TIMCustomElem r12 = r12.getCustomElem()     // Catch:{ Exception -> 0x01d3 }
            if (r12 == 0) goto L_0x01e1
            com.tencent.imsdk.v2.V2TIMMessage r12 = r11.getV2TIMMessage()     // Catch:{ Exception -> 0x01d3 }
            com.tencent.imsdk.v2.V2TIMCustomElem r12 = r12.getCustomElem()     // Catch:{ Exception -> 0x01d3 }
            if (r12 == 0) goto L_0x01e1
            byte[] r5 = r12.getData()     // Catch:{ Exception -> 0x01d3 }
            if (r5 == 0) goto L_0x01e1
            byte[] r12 = r12.getData()     // Catch:{ Exception -> 0x01d3 }
            java.lang.String r5 = new java.lang.String     // Catch:{ Exception -> 0x01d3 }
            r5.<init>(r12)     // Catch:{ Exception -> 0x01d3 }
            com.google.gson.Gson r12 = new com.google.gson.Gson     // Catch:{ Exception -> 0x01d3 }
            r12.<init>()     // Catch:{ Exception -> 0x01d3 }
            java.lang.Class<com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage> r6 = com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage.class
            java.lang.Object r12 = r12.fromJson((java.lang.String) r5, r6)     // Catch:{ Exception -> 0x01d3 }
            com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage r12 = (com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage) r12     // Catch:{ Exception -> 0x01d3 }
            if (r12 == 0) goto L_0x01e1
            java.util.Map<java.lang.String, java.lang.Object> r12 = r12.data     // Catch:{ Exception -> 0x01d3 }
            if (r12 == 0) goto L_0x01e1
            java.lang.String r5 = "extInfo"
            java.lang.Object r12 = r12.get(r5)     // Catch:{ Exception -> 0x01d3 }
            boolean r5 = r12 instanceof java.lang.String     // Catch:{ Exception -> 0x01d3 }
            if (r5 == 0) goto L_0x0097
            com.google.gson.Gson r5 = new com.google.gson.Gson     // Catch:{ Exception -> 0x01d3 }
            r5.<init>()     // Catch:{ Exception -> 0x01d3 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x01d3 }
            java.lang.Class<java.util.HashMap> r6 = java.util.HashMap.class
            java.lang.Object r12 = r5.fromJson((java.lang.String) r12, r6)     // Catch:{ Exception -> 0x01d3 }
        L_0x0097:
            boolean r5 = r12 instanceof java.util.Map     // Catch:{ Exception -> 0x01d3 }
            if (r5 == 0) goto L_0x01c8
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ Exception -> 0x01d3 }
            java.lang.Object r5 = r12.get(r0)     // Catch:{ Exception -> 0x01d3 }
            boolean r6 = r5 instanceof java.lang.String     // Catch:{ Exception -> 0x01d3 }
            if (r6 == 0) goto L_0x00b9
            com.google.gson.Gson r5 = new com.google.gson.Gson     // Catch:{ Exception -> 0x01d3 }
            r5.<init>()     // Catch:{ Exception -> 0x01d3 }
            java.lang.Object r12 = r12.get(r0)     // Catch:{ Exception -> 0x01d3 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x01d3 }
            java.lang.Class<java.util.HashMap> r0 = java.util.HashMap.class
            java.lang.Object r12 = r5.fromJson((java.lang.String) r12, r0)     // Catch:{ Exception -> 0x01d3 }
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ Exception -> 0x01d3 }
            goto L_0x00c0
        L_0x00b9:
            boolean r0 = r5 instanceof java.util.Map     // Catch:{ Exception -> 0x01d3 }
            if (r0 == 0) goto L_0x00c0
            r12 = r5
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ Exception -> 0x01d3 }
        L_0x00c0:
            java.lang.String r0 = "shareText"
            java.lang.Object r0 = r12.get(r0)     // Catch:{ Exception -> 0x01d3 }
            boolean r5 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x01d3 }
            r6 = 0
            if (r5 == 0) goto L_0x00e8
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x01d3 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01d3 }
            if (r5 == 0) goto L_0x00d9
            android.widget.TextView r0 = r10.tvTextBody     // Catch:{ Exception -> 0x01d3 }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x01d3 }
            goto L_0x00e8
        L_0x00d9:
            r5 = r11
            com.hbg.module.huobi.im.group.bean.HbShareMessageBean r5 = (com.hbg.module.huobi.im.group.bean.HbShareMessageBean) r5     // Catch:{ Exception -> 0x01d3 }
            r5.shareText = r0     // Catch:{ Exception -> 0x01d3 }
            android.widget.TextView r5 = r10.tvTextBody     // Catch:{ Exception -> 0x01d3 }
            r5.setVisibility(r6)     // Catch:{ Exception -> 0x01d3 }
            android.widget.TextView r5 = r10.tvTextBody     // Catch:{ Exception -> 0x01d3 }
            r5.setText(r0)     // Catch:{ Exception -> 0x01d3 }
        L_0x00e8:
            java.lang.String r0 = "shareImageWidth"
            java.lang.Object r0 = r12.get(r0)     // Catch:{ Exception -> 0x01d3 }
            java.lang.String r5 = "shareImageHeight"
            java.lang.Object r5 = r12.get(r5)     // Catch:{ Exception -> 0x01d3 }
            java.lang.String r7 = "shareImageUrl"
            java.lang.Object r7 = r12.get(r7)     // Catch:{ Exception -> 0x01d3 }
            boolean r8 = r7 instanceof java.lang.String     // Catch:{ Exception -> 0x01d3 }
            if (r8 == 0) goto L_0x0127
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x01d3 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01d3 }
            if (r8 == 0) goto L_0x010d
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x01d3 }
            r3.setVisibility(r1)     // Catch:{ Exception -> 0x01d3 }
            goto L_0x0127
        L_0x010d:
            r8 = r11
            com.hbg.module.huobi.im.group.bean.HbShareMessageBean r8 = (com.hbg.module.huobi.im.group.bean.HbShareMessageBean) r8     // Catch:{ Exception -> 0x01d3 }
            r8.shareImageUrl = r7     // Catch:{ Exception -> 0x01d3 }
            r2.setVisibility(r6)     // Catch:{ Exception -> 0x01d3 }
            r3.setVisibility(r6)     // Catch:{ Exception -> 0x01d3 }
            f6.c r3 = f6.c.a()     // Catch:{ Exception -> 0x01d3 }
            r3.e(r2, r7)     // Catch:{ Exception -> 0x01d3 }
            com.hbg.module.huobi.im.group.ui.chat.HbShareMessageHolder$2 r3 = new com.hbg.module.huobi.im.group.ui.chat.HbShareMessageHolder$2     // Catch:{ Exception -> 0x01d3 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x01d3 }
            r2.setOnClickListener(r3)     // Catch:{ Exception -> 0x01d3 }
        L_0x0127:
            java.lang.String r3 = "shareActionTitle"
            java.lang.Object r3 = r12.get(r3)     // Catch:{ Exception -> 0x01d3 }
            java.lang.String r7 = "shareActionUrl"
            java.lang.Object r12 = r12.get(r7)     // Catch:{ Exception -> 0x01d3 }
            boolean r7 = r3 instanceof java.lang.String     // Catch:{ Exception -> 0x01d3 }
            if (r7 == 0) goto L_0x014d
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x01d3 }
            boolean r7 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01d3 }
            if (r7 == 0) goto L_0x0143
            r4.setVisibility(r1)     // Catch:{ Exception -> 0x01d3 }
            goto L_0x014d
        L_0x0143:
            com.hbg.module.huobi.im.group.bean.HbShareMessageBean r11 = (com.hbg.module.huobi.im.group.bean.HbShareMessageBean) r11     // Catch:{ Exception -> 0x01d3 }
            r11.shareActionTitle = r3     // Catch:{ Exception -> 0x01d3 }
            r4.setVisibility(r6)     // Catch:{ Exception -> 0x01d3 }
            r4.setText(r3)     // Catch:{ Exception -> 0x01d3 }
        L_0x014d:
            boolean r11 = r12 instanceof java.lang.String     // Catch:{ Exception -> 0x01d3 }
            if (r11 == 0) goto L_0x0167
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x01d3 }
            boolean r11 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x01d3 }
            if (r11 != 0) goto L_0x0167
            int r11 = r4.getVisibility()     // Catch:{ Exception -> 0x01d3 }
            if (r11 != 0) goto L_0x0167
            com.hbg.module.huobi.im.group.ui.chat.HbShareMessageHolder$3 r11 = new com.hbg.module.huobi.im.group.ui.chat.HbShareMessageHolder$3     // Catch:{ Exception -> 0x01d3 }
            r11.<init>(r12)     // Catch:{ Exception -> 0x01d3 }
            r4.setOnClickListener(r11)     // Catch:{ Exception -> 0x01d3 }
        L_0x0167:
            int r11 = DEFAULT_MAX_SIZE     // Catch:{ Exception -> 0x01d3 }
            boolean r12 = r5 instanceof java.lang.Double     // Catch:{ Exception -> 0x01d3 }
            if (r12 == 0) goto L_0x01e1
            boolean r12 = r0 instanceof java.lang.Double     // Catch:{ Exception -> 0x01d3 }
            if (r12 == 0) goto L_0x01e1
            int r12 = r2.getVisibility()     // Catch:{ Exception -> 0x01d3 }
            if (r12 != 0) goto L_0x01b0
            android.view.ViewGroup$LayoutParams r12 = r2.getLayoutParams()     // Catch:{ Exception -> 0x01d3 }
            android.widget.RelativeLayout$LayoutParams r12 = (android.widget.RelativeLayout.LayoutParams) r12     // Catch:{ Exception -> 0x01d3 }
            double r6 = (double) r11     // Catch:{ Exception -> 0x01d3 }
            r3 = r0
            java.lang.Double r3 = (java.lang.Double) r3     // Catch:{ Exception -> 0x01d3 }
            double r8 = r3.doubleValue()     // Catch:{ Exception -> 0x01d3 }
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x019d
            java.lang.Double r0 = (java.lang.Double) r0     // Catch:{ Exception -> 0x01d3 }
            double r8 = r0.doubleValue()     // Catch:{ Exception -> 0x01d3 }
            double r6 = r6 / r8
            r12.width = r11     // Catch:{ Exception -> 0x01d3 }
            java.lang.Double r5 = (java.lang.Double) r5     // Catch:{ Exception -> 0x01d3 }
            double r8 = r5.doubleValue()     // Catch:{ Exception -> 0x01d3 }
            double r8 = r8 * r6
            int r11 = (int) r8     // Catch:{ Exception -> 0x01d3 }
            r12.height = r11     // Catch:{ Exception -> 0x01d3 }
            goto L_0x01ad
        L_0x019d:
            java.lang.Double r0 = (java.lang.Double) r0     // Catch:{ Exception -> 0x01d3 }
            int r11 = r0.intValue()     // Catch:{ Exception -> 0x01d3 }
            r12.width = r11     // Catch:{ Exception -> 0x01d3 }
            java.lang.Double r5 = (java.lang.Double) r5     // Catch:{ Exception -> 0x01d3 }
            int r11 = r5.intValue()     // Catch:{ Exception -> 0x01d3 }
            r12.height = r11     // Catch:{ Exception -> 0x01d3 }
        L_0x01ad:
            r2.setLayoutParams(r12)     // Catch:{ Exception -> 0x01d3 }
        L_0x01b0:
            int r11 = r4.getVisibility()     // Catch:{ Exception -> 0x01d3 }
            if (r11 != 0) goto L_0x01e1
            android.view.ViewGroup$LayoutParams r11 = r4.getLayoutParams()     // Catch:{ Exception -> 0x01d3 }
            android.widget.RelativeLayout$LayoutParams r11 = (android.widget.RelativeLayout.LayoutParams) r11     // Catch:{ Exception -> 0x01d3 }
            android.view.ViewGroup$LayoutParams r12 = r2.getLayoutParams()     // Catch:{ Exception -> 0x01d3 }
            int r12 = r12.width     // Catch:{ Exception -> 0x01d3 }
            r11.width = r12     // Catch:{ Exception -> 0x01d3 }
            r4.setLayoutParams(r11)     // Catch:{ Exception -> 0x01d3 }
            goto L_0x01e1
        L_0x01c8:
            android.widget.TextView r11 = r10.chatTimeText     // Catch:{ Exception -> 0x01d3 }
            r11.setVisibility(r1)     // Catch:{ Exception -> 0x01d3 }
            android.widget.RelativeLayout r11 = r10.rightGroupLayout     // Catch:{ Exception -> 0x01d3 }
            r11.setVisibility(r1)     // Catch:{ Exception -> 0x01d3 }
            goto L_0x01e1
        L_0x01d3:
            r11 = move-exception
            r11.printStackTrace()
            android.widget.TextView r11 = r10.chatTimeText
            r11.setVisibility(r1)
            android.widget.RelativeLayout r11 = r10.rightGroupLayout
            r11.setVisibility(r1)
        L_0x01e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.chat.HbShareMessageHolder.layoutVariableViews(com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layoutViews(com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "message"
            super.layoutViews(r4, r5)
            boolean r5 = r4 instanceof com.hbg.module.huobi.im.group.bean.HbShareMessageBean
            if (r5 == 0) goto L_0x00fc
            com.tencent.imsdk.v2.V2TIMMessage r5 = r4.getV2TIMMessage()     // Catch:{ Exception -> 0x00f8 }
            if (r5 == 0) goto L_0x00fc
            com.tencent.imsdk.v2.V2TIMMessage r5 = r4.getV2TIMMessage()     // Catch:{ Exception -> 0x00f8 }
            com.tencent.imsdk.v2.V2TIMCustomElem r5 = r5.getCustomElem()     // Catch:{ Exception -> 0x00f8 }
            if (r5 == 0) goto L_0x00fc
            com.tencent.imsdk.v2.V2TIMMessage r5 = r4.getV2TIMMessage()     // Catch:{ Exception -> 0x00f8 }
            com.tencent.imsdk.v2.V2TIMCustomElem r5 = r5.getCustomElem()     // Catch:{ Exception -> 0x00f8 }
            if (r5 == 0) goto L_0x00fc
            byte[] r1 = r5.getData()     // Catch:{ Exception -> 0x00f8 }
            if (r1 == 0) goto L_0x00fc
            byte[] r5 = r5.getData()     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x00f8 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x00f8 }
            com.google.gson.Gson r5 = new com.google.gson.Gson     // Catch:{ Exception -> 0x00f8 }
            r5.<init>()     // Catch:{ Exception -> 0x00f8 }
            java.lang.Class<com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage> r2 = com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage.class
            java.lang.Object r5 = r5.fromJson((java.lang.String) r1, r2)     // Catch:{ Exception -> 0x00f8 }
            com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage r5 = (com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage) r5     // Catch:{ Exception -> 0x00f8 }
            if (r5 == 0) goto L_0x00fc
            java.util.Map<java.lang.String, java.lang.Object> r5 = r5.data     // Catch:{ Exception -> 0x00f8 }
            if (r5 == 0) goto L_0x00fc
            java.lang.String r1 = "extInfo"
            java.lang.Object r5 = r5.get(r1)     // Catch:{ Exception -> 0x00f8 }
            boolean r1 = r5 instanceof java.lang.String     // Catch:{ Exception -> 0x00f8 }
            if (r1 == 0) goto L_0x005c
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ Exception -> 0x00f8 }
            r1.<init>()     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x00f8 }
            java.lang.Class<java.util.HashMap> r2 = java.util.HashMap.class
            java.lang.Object r5 = r1.fromJson((java.lang.String) r5, r2)     // Catch:{ Exception -> 0x00f8 }
        L_0x005c:
            boolean r1 = r5 instanceof java.util.Map     // Catch:{ Exception -> 0x00f8 }
            if (r1 == 0) goto L_0x00fc
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x00f8 }
            java.lang.Object r1 = r5.get(r0)     // Catch:{ Exception -> 0x00f8 }
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ Exception -> 0x00f8 }
            if (r2 == 0) goto L_0x007e
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ Exception -> 0x00f8 }
            r1.<init>()     // Catch:{ Exception -> 0x00f8 }
            java.lang.Object r5 = r5.get(r0)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x00f8 }
            java.lang.Class<java.util.HashMap> r0 = java.util.HashMap.class
            java.lang.Object r5 = r1.fromJson((java.lang.String) r5, r0)     // Catch:{ Exception -> 0x00f8 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x00f8 }
            goto L_0x0085
        L_0x007e:
            boolean r0 = r1 instanceof java.util.Map     // Catch:{ Exception -> 0x00f8 }
            if (r0 == 0) goto L_0x0085
            r5 = r1
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x00f8 }
        L_0x0085:
            android.view.View r0 = r3.mContentLayout     // Catch:{ Exception -> 0x00f8 }
            int r1 = com.hbg.module.huobi.im.R$id.rl_share     // Catch:{ Exception -> 0x00f8 }
            android.view.View r0 = r0.findViewById(r1)     // Catch:{ Exception -> 0x00f8 }
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0     // Catch:{ Exception -> 0x00f8 }
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()     // Catch:{ Exception -> 0x00f8 }
            android.widget.RelativeLayout$LayoutParams r0 = (android.widget.RelativeLayout.LayoutParams) r0     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r1 = "shareText"
            java.lang.Object r5 = r5.get(r1)     // Catch:{ Exception -> 0x00f8 }
            boolean r1 = r5 instanceof java.lang.String     // Catch:{ Exception -> 0x00f8 }
            if (r1 == 0) goto L_0x00fc
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x00f8 }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00f8 }
            r2 = 0
            if (r1 == 0) goto L_0x00b7
            android.widget.LinearLayout r4 = r3.msgContentLinear     // Catch:{ Exception -> 0x00f8 }
            r5 = 8
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x00f8 }
            android.widget.TextView r4 = r3.tvTextBody     // Catch:{ Exception -> 0x00f8 }
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x00f8 }
            r0.topMargin = r2     // Catch:{ Exception -> 0x00f8 }
            goto L_0x00fc
        L_0x00b7:
            android.widget.LinearLayout r1 = r3.msgContentLinear     // Catch:{ Exception -> 0x00f8 }
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x00f8 }
            android.widget.TextView r1 = r3.tvTextBody     // Catch:{ Exception -> 0x00f8 }
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x00f8 }
            android.widget.TextView r1 = r3.tvTextBody     // Catch:{ Exception -> 0x00f8 }
            r1.setText(r5)     // Catch:{ Exception -> 0x00f8 }
            r5 = 1090519040(0x41000000, float:8.0)
            int r5 = com.hbg.lib.common.utils.PixelUtils.a(r5)     // Catch:{ Exception -> 0x00f8 }
            r0.topMargin = r5     // Catch:{ Exception -> 0x00f8 }
            boolean r4 = r4.isSelf()     // Catch:{ Exception -> 0x00f8 }
            if (r4 != 0) goto L_0x00e6
            android.widget.TextView r4 = r3.tvTextBody     // Catch:{ Exception -> 0x00f8 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ Exception -> 0x00f8 }
            int r5 = com.hbg.module.huobi.im.R$color.new_common_text_color     // Catch:{ Exception -> 0x00f8 }
            int r4 = r4.getColor(r5)     // Catch:{ Exception -> 0x00f8 }
            android.widget.TextView r5 = r3.tvTextBody     // Catch:{ Exception -> 0x00f8 }
            r5.setTextColor(r4)     // Catch:{ Exception -> 0x00f8 }
            goto L_0x00fc
        L_0x00e6:
            android.widget.TextView r4 = r3.tvTextBody     // Catch:{ Exception -> 0x00f8 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ Exception -> 0x00f8 }
            int r5 = com.hbg.module.huobi.im.R$color.white     // Catch:{ Exception -> 0x00f8 }
            int r4 = r4.getColor(r5)     // Catch:{ Exception -> 0x00f8 }
            android.widget.TextView r5 = r3.tvTextBody     // Catch:{ Exception -> 0x00f8 }
            r5.setTextColor(r4)     // Catch:{ Exception -> 0x00f8 }
            goto L_0x00fc
        L_0x00f8:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.chat.HbShareMessageHolder.layoutViews(com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean, int):void");
    }
}
