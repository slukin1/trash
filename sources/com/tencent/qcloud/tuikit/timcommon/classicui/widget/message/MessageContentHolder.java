package com.tencent.qcloud.tuikit.timcommon.classicui.widget.message;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.timcommon.R;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageReactBean;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.ChatFlowReactView;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper;
import com.tencent.qcloud.tuikit.timcommon.component.fragments.BaseFragment;
import com.tencent.qcloud.tuikit.timcommon.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.timcommon.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;
import com.tencent.qcloud.tuikit.timcommon.util.TIMCommonLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public abstract class MessageContentHolder extends MessageBaseHolder {
    private BaseFragment fragment;
    public boolean isForwardMode = false;
    public boolean isMultiSelectMode = false;
    public boolean isNeedShowTranslation = true;
    public TextView isReadText;
    public boolean isReplyDetailMode = false;
    public boolean isShowRead = false;
    public UserIconView leftUserIcon;
    private List<TUIMessageBean> mDataSource = new ArrayList();
    public TextView messageDetailsTimeTv;
    public LinearLayout msgContentLinear;
    private LinearLayout msgReplyDetailLayout;
    private RecyclerView recyclerView;
    public UserIconView rightUserIcon;
    public SelectTextHelper selectableTextHelper;
    public ProgressBar sendingProgress;
    public ImageView statusImage;
    private FrameLayout translationContentFrameLayout;
    public TextView unreadAudioText;
    public TextView usernameText;

    public MessageContentHolder(View view) {
        super(view);
        this.leftUserIcon = (UserIconView) view.findViewById(R.id.left_user_icon_view);
        this.rightUserIcon = (UserIconView) view.findViewById(R.id.right_user_icon_view);
        this.usernameText = (TextView) view.findViewById(R.id.user_name_tv);
        this.msgContentLinear = (LinearLayout) view.findViewById(R.id.msg_content_ll);
        this.statusImage = (ImageView) view.findViewById(R.id.message_status_iv);
        this.sendingProgress = (ProgressBar) view.findViewById(R.id.message_sending_pb);
        this.isReadText = (TextView) view.findViewById(R.id.is_read_tv);
        this.unreadAudioText = (TextView) view.findViewById(R.id.audio_unread);
        this.msgReplyDetailLayout = (LinearLayout) view.findViewById(R.id.msg_reply_detail_fl);
        this.messageDetailsTimeTv = (TextView) view.findViewById(R.id.msg_detail_time_tv);
        this.translationContentFrameLayout = (FrameLayout) view.findViewById(R.id.translate_content_fl);
    }

    private void loadAvatar(final TUIMessageBean tUIMessageBean) {
        String str;
        if (tUIMessageBean.isUseMsgReceiverAvatar()) {
            if (TextUtils.equals(tUIMessageBean.getSender(), V2TIMManager.getInstance().getLoginUser())) {
                str = tUIMessageBean.getUserId();
            } else {
                str = V2TIMManager.getInstance().getLoginUser();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            V2TIMManager.getInstance().getUsersInfo(arrayList, new V2TIMValueCallback<List<V2TIMUserFullInfo>>() {
                public void onError(int i11, String str) {
                    MessageContentHolder.this.setupAvatar("", tUIMessageBean.isSelf());
                }

                public void onSuccess(List<V2TIMUserFullInfo> list) {
                    V2TIMUserFullInfo v2TIMUserFullInfo = list.get(0);
                    if (v2TIMUserFullInfo == null) {
                        MessageContentHolder.this.setupAvatar("", tUIMessageBean.isSelf());
                    } else {
                        MessageContentHolder.this.setupAvatar(v2TIMUserFullInfo.getFaceUrl(), tUIMessageBean.isSelf());
                    }
                }
            });
            return;
        }
        setupAvatar(tUIMessageBean.getFaceUrl(), tUIMessageBean.isSelf());
    }

    private void setReactContent(final TUIMessageBean tUIMessageBean) {
        MessageReactBean messageReactBean = tUIMessageBean.getMessageReactBean();
        if (messageReactBean == null || messageReactBean.getReactSize() <= 0) {
            this.reactView.setVisibility(8);
            this.reactView.setOnLongClickListener((View.OnLongClickListener) null);
        } else {
            this.reactView.setVisibility(0);
            this.reactView.setData(messageReactBean);
            this.reactView.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    OnItemClickListener onItemClickListener = MessageContentHolder.this.onItemClickListener;
                    if (onItemClickListener == null) {
                        return true;
                    }
                    onItemClickListener.onMessageLongClick(view, 0, tUIMessageBean);
                    return true;
                }
            });
            if (!this.isForwardMode) {
                this.reactView.setReactOnClickListener(new ChatFlowReactView.ReactOnClickListener() {
                    public void onClick(String str) {
                        OnItemClickListener onItemClickListener = MessageContentHolder.this.onItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onReactOnClick(str, tUIMessageBean);
                        }
                    }
                });
            } else {
                this.reactView.setOnLongClickListener((View.OnLongClickListener) null);
            }
        }
        if (!tUIMessageBean.isSelf() || this.isForwardMode || this.isReplyDetailMode) {
            ChatFlowReactView chatFlowReactView = this.reactView;
            chatFlowReactView.setThemeColorId(TUIThemeManager.getAttrResId(chatFlowReactView.getContext(), R.attr.chat_react_other_text_color));
            return;
        }
        this.reactView.setThemeColorId(0);
    }

    private void setReplyContent(final TUIMessageBean tUIMessageBean) {
        MessageRepliesBean messageRepliesBean = tUIMessageBean.getMessageRepliesBean();
        if (messageRepliesBean == null || messageRepliesBean.getRepliesSize() <= 0) {
            this.msgReplyDetailLayout.setVisibility(8);
            this.msgReplyDetailLayout.setOnClickListener((View.OnClickListener) null);
        } else {
            TextView textView = (TextView) this.msgReplyDetailLayout.findViewById(R.id.reply_num);
            textView.setText(textView.getResources().getString(R.string.chat_reply_num, new Object[]{Integer.valueOf(messageRepliesBean.getRepliesSize())}));
            this.msgReplyDetailLayout.setVisibility(0);
            this.msgReplyDetailLayout.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    OnItemClickListener onItemClickListener = MessageContentHolder.this.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onReplyDetailClick(tUIMessageBean);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }
        if (!this.isReplyDetailMode) {
            this.messageDetailsTimeTv.setVisibility(8);
            return;
        }
        this.messageDetailsTimeTv.setText(DateTimeUtil.getTimeFormatText(new Date(tUIMessageBean.getMessageTime() * 1000)));
        this.messageDetailsTimeTv.setVisibility(0);
    }

    private void setTranslationContent(TUIMessageBean tUIMessageBean) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageBean", tUIMessageBean);
        hashMap.put(TUIConstants.TUIChat.CHAT_RECYCLER_VIEW, this.recyclerView);
        hashMap.put(TUIConstants.TUIChat.FRAGMENT, this.fragment);
        TUICore.raiseExtension(TUIConstants.TUITranslation.Extension.TranslationView.CLASSIC_EXTENSION_ID, this.translationContentFrameLayout, hashMap);
    }

    /* access modifiers changed from: private */
    public void setupAvatar(String str, boolean z11) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            if (this.isForwardMode || this.isReplyDetailMode) {
                this.leftUserIcon.setIconUrls(arrayList);
            } else if (z11) {
                this.rightUserIcon.setIconUrls(arrayList);
            } else {
                this.leftUserIcon.setIconUrls(arrayList);
            }
        } else {
            this.rightUserIcon.setIconUrls((List<Object>) null);
            this.leftUserIcon.setIconUrls((List<Object>) null);
        }
    }

    private void showReadText(final TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean.isGroup()) {
            this.isReadText.setVisibility(0);
            if (tUIMessageBean.isAllRead()) {
                this.isReadText.setText(R.string.has_all_read);
            } else if (tUIMessageBean.isUnread()) {
                TextView textView = this.isReadText;
                textView.setTextColor(textView.getResources().getColor(TUIThemeManager.getAttrResId(this.isReadText.getContext(), R.attr.chat_read_receipt_text_color)));
                this.isReadText.setText(R.string.unread);
                this.isReadText.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        MessageContentHolder.this.onReadStatusClick(view, tUIMessageBean);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
            } else {
                long readCount = tUIMessageBean.getReadCount();
                if (readCount > 0) {
                    TextView textView2 = this.isReadText;
                    textView2.setText(textView2.getResources().getString(R.string.someone_has_read, new Object[]{Long.valueOf(readCount)}));
                    TextView textView3 = this.isReadText;
                    textView3.setTextColor(textView3.getResources().getColor(TUIThemeManager.getAttrResId(this.isReadText.getContext(), R.attr.chat_read_receipt_text_color)));
                    this.isReadText.setOnClickListener(new View.OnClickListener() {
                        @SensorsDataInstrumented
                        public void onClick(View view) {
                            MessageContentHolder.this.onReadStatusClick(view, tUIMessageBean);
                            SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        }
                    });
                }
            }
        } else {
            this.isReadText.setVisibility(0);
            if (tUIMessageBean.isPeerRead()) {
                this.isReadText.setText(R.string.has_read);
                return;
            }
            this.isReadText.setText(R.string.unread);
            TextView textView4 = this.isReadText;
            textView4.setTextColor(textView4.getResources().getColor(TUIThemeManager.getAttrResId(this.isReadText.getContext(), R.attr.chat_read_receipt_text_color)));
            this.isReadText.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    MessageContentHolder.this.onReadStatusClick(view, tUIMessageBean);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }
    }

    public List<TUIMessageBean> getDataSource() {
        return this.mDataSource;
    }

    public abstract void layoutVariableViews(TUIMessageBean tUIMessageBean, int i11);

    public void layoutViews(final TUIMessageBean tUIMessageBean, final int i11) {
        super.layoutViews(tUIMessageBean, i11);
        if (this.isForwardMode || this.isReplyDetailMode) {
            this.leftUserIcon.setVisibility(0);
            this.rightUserIcon.setVisibility(8);
        } else if (tUIMessageBean.isSelf()) {
            this.leftUserIcon.setVisibility(8);
            this.rightUserIcon.setVisibility(0);
        } else {
            this.leftUserIcon.setVisibility(0);
            this.rightUserIcon.setVisibility(8);
        }
        if (this.properties.getAvatar() != 0) {
            this.leftUserIcon.setDefaultImageResId(this.properties.getAvatar());
            this.rightUserIcon.setDefaultImageResId(this.properties.getAvatar());
        } else {
            UserIconView userIconView = this.leftUserIcon;
            Context context = userIconView.getContext();
            int i12 = R.attr.core_default_user_icon;
            userIconView.setDefaultImageResId(TUIThemeManager.getAttrResId(context, i12));
            UserIconView userIconView2 = this.rightUserIcon;
            userIconView2.setDefaultImageResId(TUIThemeManager.getAttrResId(userIconView2.getContext(), i12));
        }
        if (this.properties.getAvatarRadius() != 0) {
            this.leftUserIcon.setRadius(this.properties.getAvatarRadius());
            this.rightUserIcon.setRadius(this.properties.getAvatarRadius());
        } else {
            int dip2px = ScreenUtil.dip2px(4.0f);
            this.leftUserIcon.setRadius(dip2px);
            this.rightUserIcon.setRadius(dip2px);
        }
        if (this.properties.getAvatarSize() != null && this.properties.getAvatarSize().length == 2) {
            ViewGroup.LayoutParams layoutParams = this.leftUserIcon.getLayoutParams();
            layoutParams.width = this.properties.getAvatarSize()[0];
            layoutParams.height = this.properties.getAvatarSize()[1];
            this.leftUserIcon.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.rightUserIcon.getLayoutParams();
            layoutParams2.width = this.properties.getAvatarSize()[0];
            layoutParams2.height = this.properties.getAvatarSize()[1];
            this.rightUserIcon.setLayoutParams(layoutParams2);
        }
        if (this.isForwardMode || this.isReplyDetailMode) {
            this.usernameText.setVisibility(0);
        } else if (tUIMessageBean.isSelf()) {
            if (this.properties.getRightNameVisibility() == 0) {
                this.usernameText.setVisibility(8);
            } else {
                this.usernameText.setVisibility(this.properties.getRightNameVisibility());
            }
        } else if (this.properties.getLeftNameVisibility() != 0) {
            this.usernameText.setVisibility(this.properties.getLeftNameVisibility());
        } else if (tUIMessageBean.isGroup()) {
            this.usernameText.setVisibility(0);
        } else {
            this.usernameText.setVisibility(8);
        }
        if (this.properties.getNameFontColor() != 0) {
            this.usernameText.setTextColor(this.properties.getNameFontColor());
        }
        if (this.properties.getNameFontSize() != 0) {
            this.usernameText.setTextSize((float) this.properties.getNameFontSize());
        }
        if (!TextUtils.isEmpty(tUIMessageBean.getNameCard())) {
            this.usernameText.setText(tUIMessageBean.getNameCard());
        } else if (!TextUtils.isEmpty(tUIMessageBean.getFriendRemark())) {
            this.usernameText.setText(tUIMessageBean.getFriendRemark());
        } else if (!TextUtils.isEmpty(tUIMessageBean.getNickName())) {
            this.usernameText.setText(tUIMessageBean.getNickName());
        } else {
            this.usernameText.setText(tUIMessageBean.getSender());
        }
        loadAvatar(tUIMessageBean);
        if (this.isForwardMode || this.isReplyDetailMode) {
            this.sendingProgress.setVisibility(8);
        } else if (!tUIMessageBean.isSelf()) {
            this.sendingProgress.setVisibility(8);
        } else if (tUIMessageBean.getStatus() == 3 || tUIMessageBean.getStatus() == 2 || tUIMessageBean.isPeerRead()) {
            this.sendingProgress.setVisibility(8);
        } else {
            this.sendingProgress.setVisibility(0);
        }
        if (this.isForwardMode || this.isReplyDetailMode) {
            this.msgArea.setBackgroundResource(TUIThemeManager.getAttrResId(this.itemView.getContext(), R.attr.chat_bubble_other_bg));
            this.statusImage.setVisibility(8);
        } else {
            if (tUIMessageBean.isSelf()) {
                if (this.properties.getRightBubble() == null || this.properties.getRightBubble().getConstantState() == null) {
                    this.msgArea.setBackgroundResource(TUIThemeManager.getAttrResId(this.itemView.getContext(), R.attr.chat_bubble_self_bg));
                } else {
                    this.msgArea.setBackground(this.properties.getRightBubble().getConstantState().newDrawable());
                }
            } else if (this.properties.getLeftBubble() == null || this.properties.getLeftBubble().getConstantState() == null) {
                this.msgArea.setBackgroundResource(TUIThemeManager.getAttrResId(this.itemView.getContext(), R.attr.chat_bubble_other_bg));
            } else {
                this.msgArea.setBackground(this.properties.getLeftBubble().getConstantState().newDrawable());
            }
            if (this.onItemClickListener != null) {
                this.msgContentFrame.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        MessageContentHolder.this.onItemClickListener.onMessageLongClick(view, i11, tUIMessageBean);
                        return true;
                    }
                });
                this.msgArea.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        MessageContentHolder messageContentHolder = MessageContentHolder.this;
                        messageContentHolder.onItemClickListener.onMessageLongClick(messageContentHolder.msgArea, i11, tUIMessageBean);
                        return true;
                    }
                });
                this.leftUserIcon.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        MessageContentHolder.this.onItemClickListener.onUserIconClick(view, i11, tUIMessageBean);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
                this.leftUserIcon.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        MessageContentHolder.this.onItemClickListener.onUserIconLongClick(view, i11, tUIMessageBean);
                        return true;
                    }
                });
                this.rightUserIcon.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        MessageContentHolder.this.onItemClickListener.onUserIconClick(view, i11, tUIMessageBean);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
            }
            if (tUIMessageBean.getStatus() == 3) {
                this.statusImage.setVisibility(0);
                this.msgContentFrame.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        MessageContentHolder messageContentHolder = MessageContentHolder.this;
                        OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onMessageLongClick(messageContentHolder.msgContentFrame, i11, tUIMessageBean);
                        }
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
                this.statusImage.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        MessageContentHolder messageContentHolder = MessageContentHolder.this;
                        OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onSendFailBtnClick(messageContentHolder.statusImage, i11, tUIMessageBean);
                        }
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
            } else {
                this.msgContentFrame.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        MessageContentHolder messageContentHolder = MessageContentHolder.this;
                        OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onMessageClick(messageContentHolder.msgContentFrame, i11, tUIMessageBean);
                        }
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
                this.statusImage.setVisibility(8);
            }
        }
        if (this.isForwardMode || this.isReplyDetailMode) {
            setGravity(true);
            this.msgContentLinear.removeView(this.msgAreaAndReply);
            this.msgContentLinear.addView(this.msgAreaAndReply);
        } else if (tUIMessageBean.isSelf()) {
            setGravity(false);
            this.msgContentLinear.removeView(this.msgAreaAndReply);
            this.msgContentLinear.addView(this.msgAreaAndReply);
        } else {
            setGravity(true);
            this.msgContentLinear.removeView(this.msgAreaAndReply);
            this.msgContentLinear.addView(this.msgAreaAndReply, 0);
        }
        RelativeLayout relativeLayout = this.rightGroupLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        this.msgContentLinear.setVisibility(0);
        TextView textView = this.isReadText;
        textView.setTextColor(textView.getResources().getColor(R.color.text_gray1));
        this.isReadText.setOnClickListener((View.OnClickListener) null);
        if (this.isForwardMode || this.isReplyDetailMode) {
            this.isReadText.setVisibility(8);
            this.unreadAudioText.setVisibility(8);
        } else {
            if (this.isShowRead) {
                if (!tUIMessageBean.isSelf() || 2 != tUIMessageBean.getStatus()) {
                    this.isReadText.setVisibility(8);
                } else if (!tUIMessageBean.isNeedReadReceipt()) {
                    this.isReadText.setVisibility(8);
                } else {
                    showReadText(tUIMessageBean);
                }
            }
            this.unreadAudioText.setVisibility(8);
        }
        if (this.isReplyDetailMode) {
            this.chatTimeText.setVisibility(8);
        }
        setReplyContent(tUIMessageBean);
        setReactContent(tUIMessageBean);
        if (this.isNeedShowTranslation) {
            setTranslationContent(tUIMessageBean);
        }
        setMessageAreaPadding();
        layoutVariableViews(tUIMessageBean, i11);
    }

    public void onReadStatusClick(View view, TUIMessageBean tUIMessageBean) {
        OnItemClickListener onItemClickListener = this.onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onMessageReadStatusClick(view, tUIMessageBean);
        }
    }

    public void onRecycled() {
        SelectTextHelper selectTextHelper = this.selectableTextHelper;
        if (selectTextHelper != null) {
            selectTextHelper.destroy();
        }
    }

    public void resetSelectableText() {
        SelectTextHelper selectTextHelper = this.selectableTextHelper;
        if (selectTextHelper != null) {
            selectTextHelper.reset();
        }
    }

    public void setDataSource(List<TUIMessageBean> list) {
        if (list == null || list.isEmpty()) {
            this.mDataSource = null;
        }
        ArrayList arrayList = new ArrayList();
        for (TUIMessageBean next : list) {
            int msgType = next.getMsgType();
            if (msgType == 3 || msgType == 5) {
                arrayList.add(next);
            }
        }
        this.mDataSource = arrayList;
    }

    public void setFragment(BaseFragment baseFragment) {
        this.fragment = baseFragment;
    }

    public void setGravity(boolean z11) {
        int i11 = z11 ? 8388611 : 8388613;
        this.msgAreaAndReply.setGravity(i11);
        ViewGroup.LayoutParams layoutParams = this.msgContentFrame.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i11;
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).gravity = i11;
        }
        this.msgContentFrame.setLayoutParams(layoutParams);
    }

    public void setMessageAreaPadding() {
        int dimensionPixelSize = this.itemView.getResources().getDimensionPixelSize(R.dimen.chat_message_area_padding_left_right);
        int dimensionPixelSize2 = this.itemView.getResources().getDimensionPixelSize(R.dimen.chat_message_area_padding_top_bottom);
        this.msgArea.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
    }

    public void setNeedShowTranslation(boolean z11) {
        this.isNeedShowTranslation = z11;
    }

    public void setRecyclerView(RecyclerView recyclerView2) {
        this.recyclerView = recyclerView2;
    }

    public void setSelectableTextHelper(final TUIMessageBean tUIMessageBean, TextView textView, final int i11, boolean z11) {
        SelectTextHelper selectTextHelper = this.selectableTextHelper;
        if (selectTextHelper != null) {
            selectTextHelper.destroy();
        }
        SelectTextHelper build = new SelectTextHelper.Builder(textView).setCursorHandleColor(ServiceInitializer.getAppContext().getResources().getColor(R.color.font_blue)).setCursorHandleSizeInDp(18.0f).setSelectedColor(ServiceInitializer.getAppContext().getResources().getColor(R.color.test_blue)).setSelectAll(true).setIsEmoji(z11).setScrollShow(false).setSelectedAllNoPop(true).setMagnifierShow(false).build();
        this.selectableTextHelper = build;
        build.setSelectListener(new SelectTextHelper.OnSelectListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            public void onClickUrl(String str) {
            }

            public void onDismiss() {
                TUIMessageBean tUIMessageBean = tUIMessageBean;
                tUIMessageBean.setSelectText(tUIMessageBean.getExtra());
            }

            public void onDismissCustomPop() {
            }

            public void onLongClick(View view) {
            }

            public void onReset() {
                tUIMessageBean.setSelectText((String) null);
                TUIMessageBean tUIMessageBean = tUIMessageBean;
                tUIMessageBean.setSelectText(tUIMessageBean.getExtra());
            }

            public void onScrolling() {
            }

            public void onSelectAllShowCustomPop() {
            }

            public void onTextSelected(CharSequence charSequence) {
                String charSequence2 = charSequence.toString();
                tUIMessageBean.setSelectText(charSequence2);
                TIMCommonLog.d("TextMessageHolder", "onTextSelected selectedText = " + charSequence2);
                MessageContentHolder messageContentHolder = MessageContentHolder.this;
                OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onTextSelected(messageContentHolder.msgArea, i11, tUIMessageBean);
                }
            }
        });
    }

    public void setShowRead(boolean z11) {
        this.isShowRead = z11;
    }
}
