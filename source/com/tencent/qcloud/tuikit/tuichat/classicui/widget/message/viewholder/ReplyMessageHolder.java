package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageContentHolder;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.TUIReplyQuoteView;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.ClassicUIService;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.TextReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import java.lang.reflect.InvocationTargetException;

public class ReplyMessageHolder extends MessageContentHolder {
    private View line;
    private View originMsgLayout;
    private FrameLayout quoteFrameLayout;
    private LinearLayout replyContainer;
    private TextView replyContentTv;
    private TextView senderNameTv;

    public ReplyMessageHolder(View view) {
        super(view);
        this.senderNameTv = (TextView) view.findViewById(R.id.sender_tv);
        this.replyContainer = (LinearLayout) view.findViewById(R.id.reply_container);
        this.replyContentTv = (TextView) view.findViewById(R.id.reply_content_tv);
        this.originMsgLayout = view.findViewById(R.id.origin_msg_abs_layout);
        this.quoteFrameLayout = (FrameLayout) view.findViewById(R.id.quote_frame_layout);
        this.line = view.findViewById(R.id.reply_line);
    }

    private void performMsgAbstract(final ReplyMessageBean replyMessageBean, final int i11) {
        TUIMessageBean originMessageBean = replyMessageBean.getOriginMessageBean();
        TUIReplyQuoteBean replyQuoteBean = replyMessageBean.getReplyQuoteBean();
        if (originMessageBean != null) {
            performQuote(replyQuoteBean, replyMessageBean);
        } else {
            performNotFound(replyQuoteBean, replyMessageBean);
        }
        this.originMsgLayout.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (ReplyMessageHolder.this.onItemClickListener != null) {
                    ReplyMessageHolder.this.onItemClickListener.onReplyMessageClick(view, i11, replyMessageBean);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    private void performNotFound(TUIReplyQuoteBean tUIReplyQuoteBean, ReplyMessageBean replyMessageBean) {
        String msgTypeStr = ChatMessageParser.getMsgTypeStr(tUIReplyQuoteBean.getMessageType());
        String defaultAbstract = tUIReplyQuoteBean.getDefaultAbstract();
        if (ChatMessageParser.isFileType(tUIReplyQuoteBean.getMessageType())) {
            defaultAbstract = "";
        }
        TextReplyQuoteBean textReplyQuoteBean = new TextReplyQuoteBean();
        textReplyQuoteBean.setText(msgTypeStr + defaultAbstract);
        TextReplyQuoteView textReplyQuoteView = new TextReplyQuoteView(this.itemView.getContext());
        textReplyQuoteView.onDrawReplyQuote(textReplyQuoteBean);
        if (this.isForwardMode || this.isReplyDetailMode) {
            textReplyQuoteView.setSelf(false);
        } else {
            textReplyQuoteView.setSelf(replyMessageBean.isSelf());
        }
        this.quoteFrameLayout.removeAllViews();
        this.quoteFrameLayout.addView(textReplyQuoteView);
    }

    private void performQuote(TUIReplyQuoteBean tUIReplyQuoteBean, ReplyMessageBean replyMessageBean) {
        Class<? extends TUIReplyQuoteView> replyMessageViewClass = ClassicUIService.getInstance().getReplyMessageViewClass(tUIReplyQuoteBean.getClass());
        if (replyMessageViewClass != null) {
            TUIReplyQuoteView tUIReplyQuoteView = null;
            try {
                tUIReplyQuoteView = (TUIReplyQuoteView) replyMessageViewClass.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.itemView.getContext()});
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            } catch (IllegalAccessException e12) {
                e12.printStackTrace();
            } catch (InstantiationException e13) {
                e13.printStackTrace();
            } catch (InvocationTargetException e14) {
                e14.printStackTrace();
            }
            if (tUIReplyQuoteView != null) {
                tUIReplyQuoteView.onDrawReplyQuote(tUIReplyQuoteBean);
                this.quoteFrameLayout.removeAllViews();
                this.quoteFrameLayout.addView(tUIReplyQuoteView);
                if (this.isForwardMode || this.isReplyDetailMode) {
                    tUIReplyQuoteView.setSelf(false);
                } else {
                    tUIReplyQuoteView.setSelf(replyMessageBean.isSelf());
                }
            }
        }
    }

    private void setThemeColor(TUIMessageBean tUIMessageBean) {
        Context context = this.itemView.getContext();
        Resources resources = this.itemView.getResources();
        if (this.isReplyDetailMode || this.isForwardMode || !tUIMessageBean.isSelf()) {
            this.originMsgLayout.setBackgroundColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_other_reply_quote_bg_color)));
            this.senderNameTv.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_other_reply_quote_text_color)));
            this.replyContentTv.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_other_reply_text_color)));
            this.line.setBackgroundColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_other_reply_line_bg_color)));
            return;
        }
        this.originMsgLayout.setBackgroundColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_self_reply_quote_bg_color)));
        this.senderNameTv.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_self_reply_quote_text_color)));
        this.replyContentTv.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_self_reply_text_color)));
        this.line.setBackgroundColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_self_reply_line_bg_color)));
    }

    public int getVariableLayout() {
        return R.layout.message_adapter_content_reply;
    }

    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i11) {
        tUIMessageBean.setSelectText(tUIMessageBean.getExtra());
        ReplyMessageBean replyMessageBean = (ReplyMessageBean) tUIMessageBean;
        String extra = replyMessageBean.getContentMessageBean().getExtra();
        String originMsgSender = replyMessageBean.getOriginMsgSender();
        TextView textView = this.senderNameTv;
        textView.setText(originMsgSender + ":");
        boolean z11 = false;
        FaceManager.handlerEmojiText(this.replyContentTv, extra, false);
        performMsgAbstract(replyMessageBean, i11);
        this.msgArea.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                ReplyMessageHolder.this.selectableTextHelper.selectAll();
                return true;
            }
        });
        this.msgContentFrame.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                ReplyMessageHolder.this.selectableTextHelper.selectAll();
                return true;
            }
        });
        this.originMsgLayout.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                ReplyMessageHolder.this.selectableTextHelper.selectAll();
                return true;
            }
        });
        setThemeColor(tUIMessageBean);
        if (!this.isForwardMode && !this.isReplyDetailMode) {
            if (!TextUtils.isEmpty(extra)) {
                z11 = FaceManager.handlerEmojiText(this.replyContentTv, extra, false);
            }
            setSelectableTextHelper(tUIMessageBean, this.replyContentTv, i11, z11);
        }
    }

    public void setGravity(boolean z11) {
        super.setGravity(z11);
    }
}
