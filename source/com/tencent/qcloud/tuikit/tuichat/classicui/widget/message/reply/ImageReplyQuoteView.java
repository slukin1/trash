package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.TUIReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.R;
import java.util.ArrayList;
import java.util.List;

public class ImageReplyQuoteView extends TUIReplyQuoteView {
    public static final int DEFAULT_RADIUS = 2;
    public final List<String> downloadEles = new ArrayList();
    public ImageView imageMsgIv = ((ImageView) findViewById(R.id.image_msg_iv));
    public View imageMsgLayout = findViewById(R.id.image_msg_layout);
    public String mImagePath = null;
    public ImageView videoPlayIv = ((ImageView) findViewById(R.id.video_play_iv));

    public ImageReplyQuoteView(Context context) {
        super(context);
    }

    public ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams layoutParams, int i11, int i12) {
        if (!(i11 == 0 || i12 == 0)) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.reply_message_image_size);
            if (i11 > i12) {
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = (dimensionPixelSize * i12) / i11;
            } else {
                layoutParams.width = (i11 * dimensionPixelSize) / i12;
                layoutParams.height = dimensionPixelSize;
            }
        }
        return layoutParams;
    }

    public int getLayoutResourceId() {
        return R.layout.chat_reply_quote_image_layout;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0076, code lost:
        r0 = com.tencent.qcloud.tuikit.timcommon.util.ImageUtil.generateImagePath(r2.getUUID(), 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0084, code lost:
        if (r0.equals(r5.mImagePath) != false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0086, code lost:
        com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine.clear(r5.imageMsgIv);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008b, code lost:
        r2.downloadImage(r0, new com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ImageReplyQuoteView.AnonymousClass1(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDrawReplyQuote(com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean r6) {
        /*
            r5 = this;
            com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean r6 = r6.getMessageBean()
            com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean r6 = (com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean) r6
            android.view.View r0 = r5.imageMsgLayout
            r1 = 0
            r0.setVisibility(r1)
            android.widget.ImageView r0 = r5.imageMsgIv
            android.view.ViewGroup$LayoutParams r2 = r0.getLayoutParams()
            int r3 = r6.getImgWidth()
            int r4 = r6.getImgHeight()
            android.view.ViewGroup$LayoutParams r2 = r5.getImageParams(r2, r3, r4)
            r0.setLayoutParams(r2)
            java.util.List r0 = r6.getImageBeanList()
            java.lang.String r2 = r6.getDataPath()
            java.lang.String r3 = com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils.getOriginImagePath(r6)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0034
            r2 = r3
        L_0x0034:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0043
            android.widget.ImageView r6 = r5.imageMsgIv
            r0 = 0
            r1 = 1073741824(0x40000000, float:2.0)
            com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine.loadCornerImageWithoutPlaceHolder(r6, r2, r0, r1)
            goto L_0x009a
        L_0x0043:
            android.widget.ImageView r2 = r5.imageMsgIv
            com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine.clear(r2)
        L_0x0048:
            int r2 = r0.size()
            if (r1 >= r2) goto L_0x009a
            java.lang.Object r2 = r0.get(r1)
            com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean$ImageBean r2 = (com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean) r2
            int r3 = r2.getType()
            r4 = 1
            if (r3 != r4) goto L_0x0097
            java.util.List<java.lang.String> r3 = r5.downloadEles
            monitor-enter(r3)
            java.util.List<java.lang.String> r0 = r5.downloadEles     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = r2.getUUID()     // Catch:{ all -> 0x0094 }
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x0094 }
            if (r0 == 0) goto L_0x006c
            monitor-exit(r3)     // Catch:{ all -> 0x0094 }
            goto L_0x009a
        L_0x006c:
            java.util.List<java.lang.String> r0 = r5.downloadEles     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = r2.getUUID()     // Catch:{ all -> 0x0094 }
            r0.add(r1)     // Catch:{ all -> 0x0094 }
            monitor-exit(r3)     // Catch:{ all -> 0x0094 }
            java.lang.String r0 = r2.getUUID()
            java.lang.String r0 = com.tencent.qcloud.tuikit.timcommon.util.ImageUtil.generateImagePath(r0, r4)
            java.lang.String r1 = r5.mImagePath
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x008b
            android.widget.ImageView r1 = r5.imageMsgIv
            com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine.clear(r1)
        L_0x008b:
            com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ImageReplyQuoteView$1 r1 = new com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ImageReplyQuoteView$1
            r1.<init>(r2, r6, r0)
            r2.downloadImage(r0, r1)
            goto L_0x009a
        L_0x0094:
            r6 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0094 }
            throw r6
        L_0x0097:
            int r1 = r1 + 1
            goto L_0x0048
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ImageReplyQuoteView.onDrawReplyQuote(com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean):void");
    }
}
