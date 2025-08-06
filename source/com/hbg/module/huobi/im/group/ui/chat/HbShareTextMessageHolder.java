package com.hbg.module.huobi.im.group.ui.chat;

import android.view.View;
import android.widget.TextView;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.utils.LinkMovementMethodInterceptor;

public class HbShareTextMessageHolder extends HbMessageContentHolder {
    private LinkMovementMethodInterceptor linkMovementMethod = new LinkMovementMethodInterceptor();
    private TextView tvTextBody;

    public HbShareTextMessageHolder(View view) {
        super(view);
        this.tvTextBody = (TextView) view.findViewById(R$id.msg_body_tv);
    }

    public int getVariableLayout() {
        return R$layout.im_message_adapter_share;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v23, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layoutVariableViews(final com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean r6, final int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "message"
            boolean r1 = r6 instanceof com.hbg.module.huobi.im.group.bean.HbShareTextMessageBean
            if (r1 == 0) goto L_0x0197
            r1 = 8
            android.widget.LinearLayout r2 = r5.msgContentLinear     // Catch:{ Exception -> 0x0189 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0189 }
            android.view.View r2 = r5.mContentLayout     // Catch:{ Exception -> 0x0189 }
            int r3 = com.hbg.module.huobi.im.R$id.iv_cover     // Catch:{ Exception -> 0x0189 }
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x0189 }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ Exception -> 0x0189 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0189 }
            android.view.View r2 = r5.mContentLayout     // Catch:{ Exception -> 0x0189 }
            int r3 = com.hbg.module.huobi.im.R$id.tv_share_text     // Catch:{ Exception -> 0x0189 }
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x0189 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0189 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0189 }
            com.hbg.module.huobi.im.group.ui.chat.HbShareTextMessageHolder$1 r3 = new com.hbg.module.huobi.im.group.ui.chat.HbShareTextMessageHolder$1     // Catch:{ Exception -> 0x0189 }
            r3.<init>(r6, r7)     // Catch:{ Exception -> 0x0189 }
            r2.setOnLongClickListener(r3)     // Catch:{ Exception -> 0x0189 }
            com.tencent.imsdk.v2.V2TIMMessage r7 = r6.getV2TIMMessage()     // Catch:{ Exception -> 0x0189 }
            if (r7 == 0) goto L_0x0197
            com.tencent.imsdk.v2.V2TIMMessage r7 = r6.getV2TIMMessage()     // Catch:{ Exception -> 0x0189 }
            com.tencent.imsdk.v2.V2TIMCustomElem r7 = r7.getCustomElem()     // Catch:{ Exception -> 0x0189 }
            if (r7 == 0) goto L_0x0197
            boolean r7 = r6.isSelf()     // Catch:{ Exception -> 0x0189 }
            if (r7 == 0) goto L_0x0060
            android.content.Context r7 = r2.getContext()     // Catch:{ Exception -> 0x0189 }
            int r3 = com.hbg.module.huobi.im.R$drawable.im_my_send_message_bg     // Catch:{ Exception -> 0x0189 }
            android.graphics.drawable.Drawable r7 = androidx.core.content.ContextCompat.getDrawable(r7, r3)     // Catch:{ Exception -> 0x0189 }
            r2.setBackground(r7)     // Catch:{ Exception -> 0x0189 }
            android.content.res.Resources r7 = r2.getResources()     // Catch:{ Exception -> 0x0189 }
            int r3 = com.hbg.module.huobi.im.R$color.white     // Catch:{ Exception -> 0x0189 }
            int r7 = r7.getColor(r3)     // Catch:{ Exception -> 0x0189 }
            r2.setTextColor(r7)     // Catch:{ Exception -> 0x0189 }
            goto L_0x007a
        L_0x0060:
            android.content.Context r7 = r2.getContext()     // Catch:{ Exception -> 0x0189 }
            int r3 = com.hbg.module.huobi.im.R$drawable.im_other_send_message_bg     // Catch:{ Exception -> 0x0189 }
            android.graphics.drawable.Drawable r7 = androidx.core.content.ContextCompat.getDrawable(r7, r3)     // Catch:{ Exception -> 0x0189 }
            r2.setBackground(r7)     // Catch:{ Exception -> 0x0189 }
            android.content.res.Resources r7 = r2.getResources()     // Catch:{ Exception -> 0x0189 }
            int r3 = com.hbg.module.huobi.im.R$color.new_common_text_color     // Catch:{ Exception -> 0x0189 }
            int r7 = r7.getColor(r3)     // Catch:{ Exception -> 0x0189 }
            r2.setTextColor(r7)     // Catch:{ Exception -> 0x0189 }
        L_0x007a:
            com.tencent.imsdk.v2.V2TIMMessage r7 = r6.getV2TIMMessage()     // Catch:{ Exception -> 0x0189 }
            com.tencent.imsdk.v2.V2TIMCustomElem r7 = r7.getCustomElem()     // Catch:{ Exception -> 0x0189 }
            if (r7 == 0) goto L_0x0197
            byte[] r3 = r7.getData()     // Catch:{ Exception -> 0x0189 }
            if (r3 == 0) goto L_0x0197
            byte[] r7 = r7.getData()     // Catch:{ Exception -> 0x0189 }
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0189 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x0189 }
            com.google.gson.Gson r7 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0189 }
            r7.<init>()     // Catch:{ Exception -> 0x0189 }
            java.lang.Class<com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage> r4 = com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage.class
            java.lang.Object r7 = r7.fromJson((java.lang.String) r3, r4)     // Catch:{ Exception -> 0x0189 }
            com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage r7 = (com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage) r7     // Catch:{ Exception -> 0x0189 }
            if (r7 == 0) goto L_0x0197
            java.util.Map<java.lang.String, java.lang.Object> r7 = r7.data     // Catch:{ Exception -> 0x0189 }
            if (r7 == 0) goto L_0x0197
            java.lang.String r3 = "extInfo"
            java.lang.Object r7 = r7.get(r3)     // Catch:{ Exception -> 0x0189 }
            boolean r3 = r7 instanceof java.lang.String     // Catch:{ Exception -> 0x0189 }
            if (r3 == 0) goto L_0x00bd
            com.google.gson.Gson r3 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0189 }
            r3.<init>()     // Catch:{ Exception -> 0x0189 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0189 }
            java.lang.Class<java.util.HashMap> r4 = java.util.HashMap.class
            java.lang.Object r7 = r3.fromJson((java.lang.String) r7, r4)     // Catch:{ Exception -> 0x0189 }
        L_0x00bd:
            boolean r3 = r7 instanceof java.util.Map     // Catch:{ Exception -> 0x0189 }
            if (r3 == 0) goto L_0x017e
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Exception -> 0x0189 }
            java.lang.Object r3 = r7.get(r0)     // Catch:{ Exception -> 0x0189 }
            boolean r4 = r3 instanceof java.lang.String     // Catch:{ Exception -> 0x0189 }
            if (r4 == 0) goto L_0x00df
            com.google.gson.Gson r3 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0189 }
            r3.<init>()     // Catch:{ Exception -> 0x0189 }
            java.lang.Object r7 = r7.get(r0)     // Catch:{ Exception -> 0x0189 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0189 }
            java.lang.Class<java.util.HashMap> r0 = java.util.HashMap.class
            java.lang.Object r7 = r3.fromJson((java.lang.String) r7, r0)     // Catch:{ Exception -> 0x0189 }
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Exception -> 0x0189 }
            goto L_0x00e6
        L_0x00df:
            boolean r0 = r3 instanceof java.util.Map     // Catch:{ Exception -> 0x0189 }
            if (r0 == 0) goto L_0x00e6
            r7 = r3
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Exception -> 0x0189 }
        L_0x00e6:
            java.lang.String r0 = "shareText"
            java.lang.Object r0 = r7.get(r0)     // Catch:{ Exception -> 0x0189 }
            boolean r3 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x0189 }
            r4 = 0
            if (r3 == 0) goto L_0x010e
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0189 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0189 }
            if (r3 == 0) goto L_0x00ff
            android.widget.TextView r0 = r5.tvTextBody     // Catch:{ Exception -> 0x0189 }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x0189 }
            goto L_0x010e
        L_0x00ff:
            r3 = r6
            com.hbg.module.huobi.im.group.bean.HbShareTextMessageBean r3 = (com.hbg.module.huobi.im.group.bean.HbShareTextMessageBean) r3     // Catch:{ Exception -> 0x0189 }
            r3.shareText = r0     // Catch:{ Exception -> 0x0189 }
            android.widget.TextView r3 = r5.tvTextBody     // Catch:{ Exception -> 0x0189 }
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x0189 }
            android.widget.TextView r3 = r5.tvTextBody     // Catch:{ Exception -> 0x0189 }
            r3.setText(r0)     // Catch:{ Exception -> 0x0189 }
        L_0x010e:
            java.lang.String r0 = "shareContent"
            java.lang.Object r7 = r7.get(r0)     // Catch:{ Exception -> 0x0189 }
            boolean r0 = r7 instanceof java.lang.String     // Catch:{ Exception -> 0x0189 }
            r3 = 1
            if (r0 == 0) goto L_0x0174
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0189 }
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0189 }
            if (r0 == 0) goto L_0x0125
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0189 }
            goto L_0x0174
        L_0x0125:
            r0 = r6
            com.hbg.module.huobi.im.group.bean.HbShareTextMessageBean r0 = (com.hbg.module.huobi.im.group.bean.HbShareTextMessageBean) r0     // Catch:{ Exception -> 0x0189 }
            r0.shareContent = r7     // Catch:{ Exception -> 0x0189 }
            r2.setVisibility(r4)     // Catch:{ Exception -> 0x0189 }
            r2.setText(r7)     // Catch:{ Exception -> 0x0189 }
            com.hbg.module.huobi.im.utils.HbGroupUserManager r7 = com.hbg.module.huobi.im.utils.HbGroupUserManager.c()     // Catch:{ Exception -> 0x0189 }
            java.lang.String r0 = r6.getSender()     // Catch:{ Exception -> 0x0189 }
            boolean r7 = r7.d(r0)     // Catch:{ Exception -> 0x0189 }
            if (r7 == 0) goto L_0x0173
            android.content.Context r7 = r2.getContext()     // Catch:{ Exception -> 0x0189 }
            rd.u r7 = rd.u.a(r7)     // Catch:{ Exception -> 0x0189 }
            boolean r6 = r6.isSelf()     // Catch:{ Exception -> 0x0189 }
            if (r6 == 0) goto L_0x0157
            android.content.res.Resources r6 = r2.getResources()     // Catch:{ Exception -> 0x0189 }
            int r0 = com.hbg.module.huobi.im.R$color.white     // Catch:{ Exception -> 0x0189 }
            int r6 = r6.getColor(r0)     // Catch:{ Exception -> 0x0189 }
            goto L_0x0161
        L_0x0157:
            android.content.res.Resources r6 = r2.getResources()     // Catch:{ Exception -> 0x0189 }
            int r0 = com.hbg.module.huobi.im.R$color.color_0066ED     // Catch:{ Exception -> 0x0189 }
            int r6 = r6.getColor(r0)     // Catch:{ Exception -> 0x0189 }
        L_0x0161:
            r7.d(r2, r6)     // Catch:{ Exception -> 0x0189 }
            com.hbg.module.huobi.im.utils.LinkMovementMethodInterceptor r6 = r5.linkMovementMethod     // Catch:{ Exception -> 0x0189 }
            com.hbg.module.huobi.im.group.ui.chat.HbShareTextMessageHolder$2 r7 = new com.hbg.module.huobi.im.group.ui.chat.HbShareTextMessageHolder$2     // Catch:{ Exception -> 0x0189 }
            r7.<init>(r2)     // Catch:{ Exception -> 0x0189 }
            r6.a(r7)     // Catch:{ Exception -> 0x0189 }
            com.hbg.module.huobi.im.utils.LinkMovementMethodInterceptor r6 = r5.linkMovementMethod     // Catch:{ Exception -> 0x0189 }
            r2.setMovementMethod(r6)     // Catch:{ Exception -> 0x0189 }
        L_0x0173:
            r3 = r4
        L_0x0174:
            if (r3 == 0) goto L_0x017a
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0189 }
            goto L_0x0197
        L_0x017a:
            r2.setVisibility(r4)     // Catch:{ Exception -> 0x0189 }
            goto L_0x0197
        L_0x017e:
            android.widget.TextView r6 = r5.chatTimeText     // Catch:{ Exception -> 0x0189 }
            r6.setVisibility(r1)     // Catch:{ Exception -> 0x0189 }
            android.widget.RelativeLayout r6 = r5.rightGroupLayout     // Catch:{ Exception -> 0x0189 }
            r6.setVisibility(r1)     // Catch:{ Exception -> 0x0189 }
            goto L_0x0197
        L_0x0189:
            r6 = move-exception
            r6.printStackTrace()
            android.widget.TextView r6 = r5.chatTimeText
            r6.setVisibility(r1)
            android.widget.RelativeLayout r6 = r5.rightGroupLayout
            r6.setVisibility(r1)
        L_0x0197:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.chat.HbShareTextMessageHolder.layoutVariableViews(com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean, int):void");
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
            boolean r5 = r4 instanceof com.hbg.module.huobi.im.group.bean.HbShareTextMessageBean
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
            int r1 = com.hbg.module.huobi.im.R$id.tv_share_text     // Catch:{ Exception -> 0x00f8 }
            android.view.View r0 = r0.findViewById(r1)     // Catch:{ Exception -> 0x00f8 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x00f8 }
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
            android.widget.TextView r1 = r3.tvTextBody     // Catch:{ Exception -> 0x00f8 }
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x00f8 }
            android.widget.LinearLayout r1 = r3.msgContentLinear     // Catch:{ Exception -> 0x00f8 }
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x00f8 }
            android.widget.TextView r1 = r3.tvTextBody     // Catch:{ Exception -> 0x00f8 }
            r1.setText(r5)     // Catch:{ Exception -> 0x00f8 }
            r5 = 1092616192(0x41200000, float:10.0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.chat.HbShareTextMessageHolder.layoutViews(com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean, int):void");
    }
}
