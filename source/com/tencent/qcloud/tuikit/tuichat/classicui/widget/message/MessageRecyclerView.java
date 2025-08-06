package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.interfaces.TUIExtensionEventListener;
import com.tencent.qcloud.tuicore.interfaces.TUIExtensionInfo;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuikit.timcommon.component.MessageProperties;
import com.tencent.qcloud.tuikit.timcommon.component.dialog.TUIKitDialog;
import com.tencent.qcloud.tuikit.timcommon.component.face.Emoji;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnChatPopActionClickListener;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.timcommon.util.ThreadUtils;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.QuoteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.ChatPopMenuAction;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.IMessageLayout;
import com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReplyDetailActivity;
import com.tencent.qcloud.tuikit.tuichat.component.popmenu.ChatPopMenu;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageRecyclerView extends RecyclerView implements IMessageRecyclerView, IMessageLayout {
    private static final int SCROLL_TO_END_OFFSET = -999999;
    private static final String TAG = MessageRecyclerView.class.getSimpleName();
    private Handler handler = new Handler();
    public MessageAdapter mAdapter;
    /* access modifiers changed from: private */
    public ChatPopMenu mChatPopMenu;
    public OnEmptySpaceClickListener mEmptySpaceClickListener;
    public OnLoadMoreHandler mHandler;
    public List<ChatPopMenuAction> mMorePopActions = new ArrayList();
    public OnItemClickListener mOnItemClickListener;
    public OnChatPopActionClickListener mOnPopActionClickListener;
    public List<ChatPopMenuAction> mPopActions = new ArrayList();
    private int mSelectedPosition = -1;
    private OnMenuEmojiClickListener menuEmojiOnClickListener;
    /* access modifiers changed from: private */
    public ChatPresenter presenter;
    private final MessageProperties properties = MessageProperties.getInstance();
    public Runnable runnable = new Runnable() {
        public void run() {
            if (MessageRecyclerView.this.mChatPopMenu != null) {
                MessageRecyclerView.this.mChatPopMenu.hide();
            }
            MessageAdapter messageAdapter = MessageRecyclerView.this.mAdapter;
            if (messageAdapter != null) {
                messageAdapter.resetSelectableText();
            }
        }
    };

    public interface OnEmptySpaceClickListener {
        void onClick();
    }

    public interface OnLoadMoreHandler {
        void displayBackToLastMessage(boolean z11);

        void displayBackToNewMessage(boolean z11, String str, int i11);

        void hideBackToAtMessage();

        boolean isListEnd(int i11);

        void loadMessageFinish();

        void loadMore(int i11);

        void scrollMessageFinish();
    }

    public interface OnMenuEmojiClickListener {
        void onClick(Emoji emoji, TUIMessageBean tUIMessageBean);
    }

    public MessageRecyclerView(Context context) {
        super(context);
        init();
    }

    private List<ChatPopMenuAction> getExtensionActions(TUIMessageBean tUIMessageBean) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put(TUIConstants.TUIChat.Extension.MessagePopMenu.MESSAGE_BEAN, tUIMessageBean);
        hashMap.put(TUIConstants.TUIChat.Extension.MessagePopMenu.ON_POP_CLICK_LISTENER, this.mOnPopActionClickListener);
        for (final TUIExtensionInfo next : TUICore.getExtensionList(TUIConstants.TUIChat.Extension.MessagePopMenu.CLASSIC_EXTENSION_ID, hashMap)) {
            ChatPopMenuAction chatPopMenuAction = new ChatPopMenuAction();
            chatPopMenuAction.setActionIcon(((Integer) next.getIcon()).intValue());
            chatPopMenuAction.setActionName(next.getText());
            chatPopMenuAction.setPriority(next.getWeight());
            chatPopMenuAction.setActionClickListener(new ChatPopMenuAction.OnClickListener() {
                public void onClick() {
                    TUIExtensionEventListener extensionListener = next.getExtensionListener();
                    if (extensionListener != null) {
                        extensionListener.onClicked((Map<String, Object>) null);
                    }
                }
            });
            arrayList.add(chatPopMenuAction);
        }
        return arrayList;
    }

    private void init() {
        TUIChatLog.d(TAG, "init()");
        setLayoutFrozen(false);
        setItemViewCacheSize(0);
        setHasFixedSize(true);
        setFocusableInTouchMode(false);
        setFocusable(true);
        setClickable(true);
        CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getContext());
        customLinearLayoutManager.setOrientation(1);
        setLayoutManager(customLinearLayoutManager);
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) getItemAnimator();
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        setClickEmptySpaceEvent();
    }

    private boolean isListEnd(int i11) {
        return this.mHandler.isListEnd(i11);
    }

    /* access modifiers changed from: private */
    public void locateOriginMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            ToastUtil.toastShortMessage(getContext().getString(R.string.locate_origin_msg_failed_tip));
        } else {
            this.presenter.locateMessage(str, new IUIKitCallback<Void>() {
                public void onError(String str, int i11, String str2) {
                    ToastUtil.toastShortMessage(MessageRecyclerView.this.getContext().getString(R.string.locate_origin_msg_failed_tip));
                }

                public void onSuccess(Void voidR) {
                }
            });
        }
    }

    private void setClickEmptySpaceEvent() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                OnEmptySpaceClickListener onEmptySpaceClickListener = MessageRecyclerView.this.mEmptySpaceClickListener;
                if (onEmptySpaceClickListener == null) {
                    return false;
                }
                onEmptySpaceClickListener.onClick();
                return true;
            }
        });
        setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!(view instanceof RecyclerView)) {
                    return false;
                }
                gestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });
    }

    /* access modifiers changed from: private */
    public void showRootMessageReplyDetail(TUIMessageBean tUIMessageBean) {
        if (this.presenter.getChatInfo() != null) {
            Intent intent = new Intent(getContext(), MessageReplyDetailActivity.class);
            intent.putExtra("messageBean", tUIMessageBean);
            intent.putExtra(TUIChatConstants.CHAT_INFO, this.presenter.getChatInfo());
            intent.setFlags(268435456);
            getContext().startActivity(intent);
        }
    }

    public void addPopAction(ChatPopMenuAction chatPopMenuAction) {
        this.mMorePopActions.add(chatPopMenuAction);
    }

    public void addPopActions(List<ChatPopMenuAction> list) {
        this.mPopActions.clear();
        this.mPopActions.addAll(list);
    }

    public void displayBackToNewMessage(boolean z11, String str, int i11) {
        OnLoadMoreHandler onLoadMoreHandler = this.mHandler;
        if (onLoadMoreHandler != null) {
            onLoadMoreHandler.displayBackToNewMessage(z11, str, i11);
        }
    }

    public int getAvatar() {
        return this.properties.getAvatar();
    }

    public int getAvatarRadius() {
        return this.properties.getAvatarRadius();
    }

    public int[] getAvatarSize() {
        return this.properties.getAvatarSize();
    }

    public int getChatContextFontSize() {
        return this.properties.getChatContextFontSize();
    }

    public Drawable getChatTimeBubble() {
        return this.properties.getChatTimeBubble();
    }

    public int getChatTimeFontColor() {
        return this.properties.getChatTimeFontColor();
    }

    public int getChatTimeFontSize() {
        return this.properties.getChatTimeFontSize();
    }

    public OnEmptySpaceClickListener getEmptySpaceClickListener() {
        return this.mEmptySpaceClickListener;
    }

    public Drawable getLeftBubble() {
        return this.properties.getLeftBubble();
    }

    public int getLeftChatContentFontColor() {
        return this.properties.getLeftChatContentFontColor();
    }

    public int getLeftNameVisibility() {
        return this.properties.getLeftNameVisibility();
    }

    public OnLoadMoreHandler getLoadMoreHandler() {
        return this.mHandler;
    }

    public int getNameFontColor() {
        return this.properties.getNameFontColor();
    }

    public int getNameFontSize() {
        return this.properties.getNameFontSize();
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.mAdapter.getOnItemClickListener();
    }

    public List<ChatPopMenuAction> getPopActions() {
        return this.mPopActions;
    }

    public Drawable getRightBubble() {
        return this.properties.getRightBubble();
    }

    public int getRightChatContentFontColor() {
        return this.properties.getRightChatContentFontColor();
    }

    public int getRightNameVisibility() {
        return this.properties.getRightNameVisibility();
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public Drawable getTipsMessageBubble() {
        return this.properties.getTipsMessageBubble();
    }

    public int getTipsMessageFontColor() {
        return this.properties.getTipsMessageFontColor();
    }

    public int getTipsMessageFontSize() {
        return this.properties.getTipsMessageFontSize();
    }

    public boolean isDisplayJumpMessageLayout() {
        String str = TAG;
        TUIChatLog.d(str, "computeVerticalScrollRange() = " + computeVerticalScrollRange() + ", computeVerticalScrollExtent() = " + computeVerticalScrollExtent() + ", computeVerticalScrollOffset() = " + computeVerticalScrollOffset());
        int computeVerticalScrollRange = (computeVerticalScrollRange() - computeVerticalScrollExtent()) - computeVerticalScrollOffset();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("toBottom = ");
        sb2.append(computeVerticalScrollRange);
        TUIChatLog.d(str, sb2.toString());
        return computeVerticalScrollRange > 0 && computeVerticalScrollRange >= computeVerticalScrollExtent() * 2;
    }

    public boolean isLastItemVisibleCompleted() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
        if (linearLayoutManager == null) {
            return false;
        }
        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() >= (linearLayoutManager.findFirstVisibleItemPosition() + linearLayoutManager.getChildCount()) - 1) {
            return true;
        }
        return false;
    }

    public void loadMessageFinish() {
        OnLoadMoreHandler onLoadMoreHandler = this.mHandler;
        if (onLoadMoreHandler != null) {
            onLoadMoreHandler.loadMessageFinish();
        }
    }

    public void onMsgAddBack() {
        if (this.mAdapter != null && isLastItemVisibleCompleted()) {
            scrollToEnd();
        }
    }

    public void onScrollStateChanged(int i11) {
        OnLoadMoreHandler onLoadMoreHandler;
        super.onScrollStateChanged(i11);
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null) {
            messageAdapter.resetSelectableText();
        }
        if (i11 == 0) {
            if (this.mHandler != null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
                int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition == 0 && (findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1 < getAdapter().getItemCount()) {
                    if (getAdapter() instanceof MessageAdapter) {
                        ((MessageAdapter) getAdapter()).showLoading();
                    }
                    this.mHandler.loadMore(0);
                } else if (isListEnd(findLastCompletelyVisibleItemPosition)) {
                    if (getAdapter() instanceof MessageAdapter) {
                        ((MessageAdapter) getAdapter()).showLoading();
                    }
                    this.mHandler.loadMore(1);
                    this.mHandler.displayBackToLastMessage(false);
                    this.mHandler.displayBackToNewMessage(false, "", 0);
                    this.presenter.resetCurrentChatUnreadCount();
                }
                if (isDisplayJumpMessageLayout()) {
                    this.mHandler.displayBackToLastMessage(true);
                } else {
                    this.mHandler.displayBackToLastMessage(false);
                }
            }
        } else if (i11 == 1 && (onLoadMoreHandler = this.mHandler) != null) {
            onLoadMoreHandler.hideBackToAtMessage();
        }
    }

    public void scrollMessageFinish() {
        OnLoadMoreHandler onLoadMoreHandler = this.mHandler;
        if (onLoadMoreHandler != null) {
            onLoadMoreHandler.scrollMessageFinish();
        }
    }

    public void scrollToEnd() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    MessageRecyclerView.this.scrollToEnd();
                }
            });
        } else if (getAdapter() != null) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            int itemCount = getAdapter().getItemCount();
            if ((layoutManager instanceof LinearLayoutManager) && itemCount > 0) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(itemCount - 1, SCROLL_TO_END_OFFSET);
            }
        }
    }

    public void scrollToPosition(int i11) {
        if (getAdapter() != null && i11 < getAdapter().getItemCount()) {
            super.scrollToPosition(i11);
        }
    }

    public void setAdapter(MessageAdapter messageAdapter) {
        super.setAdapter(messageAdapter);
        this.mAdapter = messageAdapter;
    }

    public void setAdapterListener() {
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() {
            public void onMessageClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onMessageClick(view, i11, tUIMessageBean);
                }
            }

            public void onMessageLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onMessageLongClick(view, i11, tUIMessageBean);
                }
            }

            public void onMessageReadStatusClick(View view, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onMessageReadStatusClick(view, tUIMessageBean);
                }
            }

            public void onReEditRevokeMessage(View view, int i11, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onReEditRevokeMessage(view, i11, tUIMessageBean);
                }
            }

            public void onReactOnClick(String str, TUIMessageBean tUIMessageBean) {
                MessageRecyclerView.this.presenter.reactMessage(str, tUIMessageBean);
            }

            public void onRecallClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onRecallClick(view, i11, tUIMessageBean);
                }
            }

            public void onReplyDetailClick(TUIMessageBean tUIMessageBean) {
                MessageRecyclerView.this.showRootMessageReplyDetail(tUIMessageBean);
            }

            public void onReplyMessageClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean instanceof ReplyMessageBean) {
                    MessageRecyclerView.this.showRootMessageReplyDetail(((ReplyMessageBean) tUIMessageBean).getMsgRootId());
                } else if (tUIMessageBean instanceof QuoteMessageBean) {
                    MessageRecyclerView.this.locateOriginMessage(((QuoteMessageBean) tUIMessageBean).getOriginMsgId());
                }
            }

            public void onSendFailBtnClick(View view, int i11, final TUIMessageBean tUIMessageBean) {
                new TUIKitDialog(MessageRecyclerView.this.getContext()).builder().setCancelable(true).setCancelOutside(true).setTitle(MessageRecyclerView.this.getContext().getString(R.string.resend_tips)).setDialogWidth(0.75f).setPositiveButton(MessageRecyclerView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.sure), new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        MessageRecyclerView.this.mOnPopActionClickListener.onSendMessageClick(tUIMessageBean, true);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                }).setNegativeButton(MessageRecyclerView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.cancel), new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                }).show();
            }

            public void onTextSelected(View view, int i11, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onTextSelected(view, i11, tUIMessageBean);
                }
            }

            public void onUserIconClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onUserIconClick(view, i11, tUIMessageBean);
                }
            }

            public void onUserIconLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onUserIconLongClick(view, i11, tUIMessageBean);
                }
            }
        });
    }

    public void setAvatar(int i11) {
        this.properties.setAvatar(i11);
    }

    public void setAvatarRadius(int i11) {
        this.properties.setAvatarRadius(i11);
    }

    public void setAvatarSize(int[] iArr) {
        this.properties.setAvatarSize(iArr);
    }

    public void setChatContextFontSize(int i11) {
        this.properties.setChatContextFontSize(i11);
    }

    public void setChatTimeBubble(Drawable drawable) {
        this.properties.setChatTimeBubble(drawable);
    }

    public void setChatTimeFontColor(int i11) {
        this.properties.setChatTimeFontColor(i11);
    }

    public void setChatTimeFontSize(int i11) {
        this.properties.setChatTimeFontSize(i11);
    }

    public void setEmptySpaceClickListener(OnEmptySpaceClickListener onEmptySpaceClickListener) {
        this.mEmptySpaceClickListener = onEmptySpaceClickListener;
    }

    public void setHighShowPosition(int i11) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null) {
            messageAdapter.setHighShowPosition(i11);
        }
    }

    public void setLeftBubble(Drawable drawable) {
        this.properties.setLeftBubble(drawable);
    }

    public void setLeftChatContentFontColor(int i11) {
        this.properties.setLeftChatContentFontColor(i11);
    }

    public void setLeftNameVisibility(int i11) {
        this.properties.setLeftNameVisibility(i11);
    }

    public void setLoadMoreMessageHandler(OnLoadMoreHandler onLoadMoreHandler) {
        this.mHandler = onLoadMoreHandler;
    }

    public void setMenuEmojiOnClickListener(OnMenuEmojiClickListener onMenuEmojiClickListener) {
        this.menuEmojiOnClickListener = onMenuEmojiClickListener;
    }

    public void setNameFontColor(int i11) {
        this.properties.setNameFontColor(i11);
    }

    public void setNameFontSize(int i11) {
        this.properties.setNameFontSize(i11);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        setAdapterListener();
    }

    public void setPopActionClickListener(OnChatPopActionClickListener onChatPopActionClickListener) {
        this.mOnPopActionClickListener = onChatPopActionClickListener;
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
    }

    public void setRightBubble(Drawable drawable) {
        this.properties.setRightBubble(drawable);
    }

    public void setRightChatContentFontColor(int i11) {
        this.properties.setRightChatContentFontColor(i11);
    }

    public void setRightNameVisibility(int i11) {
        this.properties.setRightNameVisibility(i11);
    }

    public void setSelectedPosition(int i11) {
        this.mSelectedPosition = i11;
    }

    public void setTipsMessageBubble(Drawable drawable) {
        this.properties.setTipsMessageBubble(drawable);
    }

    public void setTipsMessageFontColor(int i11) {
        this.properties.setTipsMessageFontColor(i11);
    }

    public void setTipsMessageFontSize(int i11) {
        this.properties.setTipsMessageFontSize(i11);
    }

    public void showItemPopMenu(TUIMessageBean tUIMessageBean, View view) {
        stopScroll();
        if (this.mPopActions.size() != 0) {
            ChatPopMenu chatPopMenu = this.mChatPopMenu;
            if (chatPopMenu != null) {
                chatPopMenu.hide();
                this.mChatPopMenu = null;
                this.handler.removeCallbacks(this.runnable);
            }
            ChatPopMenu chatPopMenu2 = new ChatPopMenu(getContext(), this.mPopActions);
            this.mChatPopMenu = chatPopMenu2;
            chatPopMenu2.setChatPopMenuActionList(this.mPopActions);
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            this.mChatPopMenu.show(view, iArr[1]);
            this.mChatPopMenu.setEmptySpaceClickListener(new OnEmptySpaceClickListener() {
                public void onClick() {
                    MessageAdapter messageAdapter = MessageRecyclerView.this.mAdapter;
                    if (messageAdapter != null) {
                        messageAdapter.resetSelectableText();
                    }
                }
            });
            this.handler.postDelayed(this.runnable, 10000);
        }
    }

    public void smoothScrollToPosition(int i11) {
        if (getAdapter() != null && i11 < getAdapter().getItemCount()) {
            super.smoothScrollToPosition(i11);
        }
    }

    /* access modifiers changed from: private */
    public void showRootMessageReplyDetail(String str) {
        if (this.presenter.getChatInfo() != null) {
            this.presenter.findMessage(str, (IUIKitCallback<TUIMessageBean>) new IUIKitCallback<TUIMessageBean>() {
                public void onError(String str, int i11, String str2) {
                    ToastUtil.toastShortMessage(MessageRecyclerView.this.getContext().getString(R.string.locate_origin_msg_failed_tip) + " code = " + i11 + " message = " + str2);
                }

                public void onSuccess(TUIMessageBean tUIMessageBean) {
                    if (tUIMessageBean.getStatus() == 275) {
                        ToastUtil.toastShortMessage(MessageRecyclerView.this.getContext().getString(R.string.locate_origin_msg_failed_tip));
                        return;
                    }
                    Intent intent = new Intent(MessageRecyclerView.this.getContext(), MessageReplyDetailActivity.class);
                    intent.putExtra("messageBean", tUIMessageBean);
                    intent.putExtra(TUIChatConstants.CHAT_INFO, MessageRecyclerView.this.presenter.getChatInfo());
                    intent.setFlags(268435456);
                    MessageRecyclerView.this.getContext().startActivity(intent);
                }
            });
        }
    }

    public MessageRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MessageRecyclerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
