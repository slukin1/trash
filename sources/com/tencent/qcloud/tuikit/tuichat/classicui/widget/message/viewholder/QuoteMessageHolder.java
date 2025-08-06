package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.QuoteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FaceReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FileReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.ImageReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.MergeReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.SoundReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.VideoReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import java.util.ArrayList;
import java.util.List;

public class QuoteMessageHolder extends TextMessageHolder {
    public final List<String> downloadEles = new ArrayList();
    private final FrameLayout fileFrame;
    private final ImageView fileIconIv;
    private final TextView fileNameTv;
    private final FrameLayout imageFrame;
    /* access modifiers changed from: private */
    public final ImageView imageIv;
    public String mImagePath = null;
    private final ImageView playIv;
    private FrameLayout quoteContentFrameLayout;
    private final TextView senderNameTv;
    private final FrameLayout soundFrame;
    private final ImageView soundIconIv;
    private final TextView soundTimeTv;
    private final FrameLayout textFrame;
    private final TextView textTv;

    public QuoteMessageHolder(View view) {
        super(view);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.quote_content_fl);
        this.quoteContentFrameLayout = frameLayout;
        frameLayout.setVisibility(0);
        LayoutInflater.from(view.getContext()).inflate(R.layout.quote_message_content_layout, this.quoteContentFrameLayout);
        this.senderNameTv = (TextView) this.quoteContentFrameLayout.findViewById(R.id.sender_name_tv);
        this.textFrame = (FrameLayout) this.quoteContentFrameLayout.findViewById(R.id.text_msg_area);
        this.textTv = (TextView) this.quoteContentFrameLayout.findViewById(R.id.msg_abstract_tv);
        this.imageFrame = (FrameLayout) this.quoteContentFrameLayout.findViewById(R.id.image_video_msg_area);
        this.imageIv = (ImageView) this.quoteContentFrameLayout.findViewById(R.id.msg_image_iv);
        this.playIv = (ImageView) this.quoteContentFrameLayout.findViewById(R.id.msg_play_iv);
        this.fileFrame = (FrameLayout) this.quoteContentFrameLayout.findViewById(R.id.file_msg_area);
        this.fileNameTv = (TextView) this.quoteContentFrameLayout.findViewById(R.id.file_name_tv);
        this.fileIconIv = (ImageView) this.quoteContentFrameLayout.findViewById(R.id.file_icon_iv);
        this.soundFrame = (FrameLayout) this.quoteContentFrameLayout.findViewById(R.id.sound_msg_area);
        this.soundTimeTv = (TextView) this.quoteContentFrameLayout.findViewById(R.id.sound_msg_time_tv);
        this.soundIconIv = (ImageView) this.quoteContentFrameLayout.findViewById(R.id.sound_msg_icon_iv);
    }

    private void performFile(FileReplyQuoteBean fileReplyQuoteBean) {
        this.fileFrame.setVisibility(0);
        this.fileNameTv.setText(fileReplyQuoteBean.getFileName());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ba, code lost:
        r9 = com.tencent.qcloud.tuikit.timcommon.util.ImageUtil.generateImagePath(r0.getUUID(), 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c8, code lost:
        if (r9.equals(r8.mImagePath) != false) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ca, code lost:
        com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine.clear(r8.imageIv);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cf, code lost:
        r4 = r0;
        r6 = r9;
        r0.downloadImage(r9, new com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.QuoteMessageHolder.AnonymousClass3(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void performImage(com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean r9) {
        /*
            r8 = this;
            android.widget.FrameLayout r0 = r8.imageFrame
            r1 = 0
            r0.setVisibility(r1)
            r0 = 1073070735(0x3ff5c28f, float:1.92)
            int r7 = com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil.dip2px(r0)
            boolean r0 = r9 instanceof com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FaceReplyQuoteBean
            if (r0 == 0) goto L_0x0044
            com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FaceReplyQuoteBean r9 = (com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FaceReplyQuoteBean) r9
            java.lang.String r0 = new java.lang.String
            byte[] r1 = r9.getData()
            r0.<init>(r1)
            android.widget.ImageView r1 = r8.imageIv
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            if (r1 == 0) goto L_0x0039
            android.view.View r2 = r8.itemView
            android.content.res.Resources r2 = r2.getResources()
            int r3 = com.tencent.qcloud.tuikit.tuichat.R.dimen.reply_message_image_size
            int r2 = r2.getDimensionPixelSize(r3)
            r1.width = r2
            r1.height = r2
            android.widget.ImageView r2 = r8.imageIv
            r2.setLayoutParams(r1)
        L_0x0039:
            int r9 = r9.getIndex()
            android.widget.ImageView r1 = r8.imageIv
            com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager.loadFace(r9, r0, r1)
            goto L_0x0164
        L_0x0044:
            boolean r0 = r9 instanceof com.tencent.qcloud.tuikit.tuichat.bean.message.reply.ImageReplyQuoteBean
            r2 = 0
            if (r0 == 0) goto L_0x00e3
            com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean r9 = r9.getMessageBean()
            r5 = r9
            com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean r5 = (com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean) r5
            android.widget.ImageView r9 = r8.imageIv
            android.view.ViewGroup$LayoutParams r0 = r9.getLayoutParams()
            int r3 = r5.getImgWidth()
            int r4 = r5.getImgHeight()
            android.view.ViewGroup$LayoutParams r0 = r8.getImageParams(r0, r3, r4)
            r9.setLayoutParams(r0)
            java.util.List r9 = r5.getImageBeanList()
            java.lang.String r0 = r5.getDataPath()
            java.lang.String r3 = com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils.getOriginImagePath(r5)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0078
            r0 = r3
        L_0x0078:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x0086
            android.widget.ImageView r9 = r8.imageIv
            float r1 = (float) r7
            com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine.loadCornerImageWithoutPlaceHolder(r9, r0, r2, r1)
            goto L_0x0164
        L_0x0086:
            android.widget.ImageView r0 = r8.imageIv
            com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine.clear(r0)
        L_0x008b:
            int r0 = r9.size()
            if (r1 >= r0) goto L_0x0164
            java.lang.Object r0 = r9.get(r1)
            com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean$ImageBean r0 = (com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean) r0
            int r2 = r0.getType()
            r3 = 1
            if (r2 != r3) goto L_0x00e0
            java.util.List<java.lang.String> r2 = r8.downloadEles
            monitor-enter(r2)
            java.util.List<java.lang.String> r9 = r8.downloadEles     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = r0.getUUID()     // Catch:{ all -> 0x00dd }
            boolean r9 = r9.contains(r1)     // Catch:{ all -> 0x00dd }
            if (r9 == 0) goto L_0x00b0
            monitor-exit(r2)     // Catch:{ all -> 0x00dd }
            goto L_0x0164
        L_0x00b0:
            java.util.List<java.lang.String> r9 = r8.downloadEles     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = r0.getUUID()     // Catch:{ all -> 0x00dd }
            r9.add(r1)     // Catch:{ all -> 0x00dd }
            monitor-exit(r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r9 = r0.getUUID()
            java.lang.String r9 = com.tencent.qcloud.tuikit.timcommon.util.ImageUtil.generateImagePath(r9, r3)
            java.lang.String r1 = r8.mImagePath
            boolean r1 = r9.equals(r1)
            if (r1 != 0) goto L_0x00cf
            android.widget.ImageView r1 = r8.imageIv
            com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine.clear(r1)
        L_0x00cf:
            com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.QuoteMessageHolder$3 r1 = new com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.QuoteMessageHolder$3
            r2 = r1
            r3 = r8
            r4 = r0
            r6 = r9
            r2.<init>(r4, r5, r6, r7)
            r0.downloadImage(r9, r1)
            goto L_0x0164
        L_0x00dd:
            r9 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00dd }
            throw r9
        L_0x00e0:
            int r1 = r1 + 1
            goto L_0x008b
        L_0x00e3:
            boolean r0 = r9 instanceof com.tencent.qcloud.tuikit.tuichat.bean.message.reply.VideoReplyQuoteBean
            if (r0 == 0) goto L_0x0164
            com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean r9 = r9.getMessageBean()
            com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean r9 = (com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean) r9
            android.widget.ImageView r0 = r8.imageIv
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            int r3 = r9.getImgWidth()
            int r4 = r9.getImgHeight()
            android.view.ViewGroup$LayoutParams r0 = r8.getImageParams(r0, r3, r4)
            android.widget.ImageView r3 = r8.imageIv
            r3.setLayoutParams(r0)
            android.widget.ImageView r3 = r8.playIv
            r3.setLayoutParams(r0)
            android.widget.ImageView r0 = r8.playIv
            r0.setVisibility(r1)
            java.lang.String r0 = r9.getDataPath()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0123
            android.widget.ImageView r0 = r8.imageIv
            java.lang.String r9 = r9.getDataPath()
            float r1 = (float) r7
            com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine.loadCornerImageWithoutPlaceHolder(r0, r9, r2, r1)
            goto L_0x0164
        L_0x0123:
            android.widget.ImageView r0 = r8.imageIv
            com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine.clear(r0)
            java.util.List<java.lang.String> r0 = r8.downloadEles
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = r8.downloadEles     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = r9.getSnapshotUUID()     // Catch:{ all -> 0x0161 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0161 }
            if (r1 != 0) goto L_0x0140
            java.util.List<java.lang.String> r1 = r8.downloadEles     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = r9.getSnapshotUUID()     // Catch:{ all -> 0x0161 }
            r1.add(r2)     // Catch:{ all -> 0x0161 }
        L_0x0140:
            monitor-exit(r0)     // Catch:{ all -> 0x0161 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.tencent.qcloud.tuicore.TUIConfig.getImageDownloadDir()
            r0.append(r1)
            java.lang.String r1 = r9.getSnapshotUUID()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.QuoteMessageHolder$4 r1 = new com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.QuoteMessageHolder$4
            r1.<init>(r9, r0, r7)
            r9.downloadSnapshot(r0, r1)
            goto L_0x0164
        L_0x0161:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0161 }
            throw r9
        L_0x0164:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.QuoteMessageHolder.performImage(com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean):void");
    }

    private void performMsgAbstract(QuoteMessageBean quoteMessageBean) {
        resetAll();
        TUIMessageBean originMessageBean = quoteMessageBean.getOriginMessageBean();
        TUIReplyQuoteBean replyQuoteBean = quoteMessageBean.getReplyQuoteBean();
        if (originMessageBean != null) {
            performQuote(replyQuoteBean, quoteMessageBean);
        } else {
            performNotFound(replyQuoteBean, quoteMessageBean);
        }
    }

    private void performNotFound(TUIReplyQuoteBean tUIReplyQuoteBean, QuoteMessageBean quoteMessageBean) {
        String msgTypeStr = ChatMessageParser.getMsgTypeStr(tUIReplyQuoteBean.getMessageType());
        String defaultAbstract = tUIReplyQuoteBean.getDefaultAbstract();
        if (ChatMessageParser.isFileType(tUIReplyQuoteBean.getMessageType())) {
            defaultAbstract = "";
        }
        performTextMessage(msgTypeStr + defaultAbstract);
    }

    private void performQuote(TUIReplyQuoteBean tUIReplyQuoteBean, QuoteMessageBean quoteMessageBean) {
        String str;
        boolean z11 = tUIReplyQuoteBean instanceof TextReplyQuoteBean;
        if (z11 || (tUIReplyQuoteBean instanceof MergeReplyQuoteBean)) {
            if (z11) {
                str = ((TextReplyQuoteBean) tUIReplyQuoteBean).getText();
            } else {
                str = quoteMessageBean.getOriginMsgAbstract();
            }
            performTextMessage(str);
        } else if (tUIReplyQuoteBean instanceof FileReplyQuoteBean) {
            performFile((FileReplyQuoteBean) tUIReplyQuoteBean);
        } else if (tUIReplyQuoteBean instanceof SoundReplyQuoteBean) {
            performSound((SoundReplyQuoteBean) tUIReplyQuoteBean);
        } else if ((tUIReplyQuoteBean instanceof ImageReplyQuoteBean) || (tUIReplyQuoteBean instanceof VideoReplyQuoteBean) || (tUIReplyQuoteBean instanceof FaceReplyQuoteBean)) {
            performImage(tUIReplyQuoteBean);
        } else {
            performTextMessage(tUIReplyQuoteBean.getDefaultAbstract());
        }
    }

    private void performSound(SoundReplyQuoteBean soundReplyQuoteBean) {
        this.soundFrame.setVisibility(0);
        TextView textView = this.soundTimeTv;
        textView.setText(soundReplyQuoteBean.getDuring() + "''");
    }

    private void performTextMessage(String str) {
        this.textFrame.setVisibility(0);
        FaceManager.handlerEmojiText(this.textTv, str, false);
    }

    private void resetAll() {
        this.textFrame.setVisibility(8);
        this.imageFrame.setVisibility(8);
        this.fileFrame.setVisibility(8);
        this.soundFrame.setVisibility(8);
        this.playIv.setVisibility(8);
    }

    private void setThemeColor(TUIMessageBean tUIMessageBean) {
        if (this.isForwardMode || this.isReplyDetailMode || !tUIMessageBean.isSelf()) {
            this.msgBodyText.setTextColor(this.msgBodyText.getResources().getColor(TUIThemeManager.getAttrResId(this.msgBodyText.getContext(), R.attr.chat_other_msg_text_color)));
            return;
        }
        this.msgBodyText.setTextColor(this.msgBodyText.getResources().getColor(TUIThemeManager.getAttrResId(this.msgBodyText.getContext(), R.attr.chat_self_msg_text_color)));
    }

    public ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams layoutParams, int i11, int i12) {
        if (!(i11 == 0 || i12 == 0)) {
            int dimensionPixelSize = this.itemView.getResources().getDimensionPixelSize(R.dimen.reply_message_image_size);
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

    public void layoutVariableViews(TUIMessageBean tUIMessageBean, final int i11) {
        tUIMessageBean.setSelectText(tUIMessageBean.getExtra());
        final QuoteMessageBean quoteMessageBean = (QuoteMessageBean) tUIMessageBean;
        String extra = quoteMessageBean.getContentMessageBean().getExtra();
        String originMsgSender = quoteMessageBean.getOriginMsgSender();
        TextView textView = this.senderNameTv;
        textView.setText(originMsgSender + l.f34627b);
        boolean z11 = false;
        FaceManager.handlerEmojiText(this.msgBodyText, extra, false);
        performMsgAbstract(quoteMessageBean);
        this.msgArea.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                QuoteMessageHolder.this.selectableTextHelper.selectAll();
                return true;
            }
        });
        this.quoteContentFrameLayout.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (QuoteMessageHolder.this.onItemClickListener != null) {
                    QuoteMessageHolder.this.onItemClickListener.onReplyMessageClick(view, i11, quoteMessageBean);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        setThemeColor(tUIMessageBean);
        if (!this.isForwardMode && !this.isReplyDetailMode) {
            if (!TextUtils.isEmpty(extra)) {
                z11 = FaceManager.handlerEmojiText(this.msgBodyText, extra, false);
            }
            setSelectableTextHelper(tUIMessageBean, this.msgBodyText, i11, z11);
        }
    }
}
