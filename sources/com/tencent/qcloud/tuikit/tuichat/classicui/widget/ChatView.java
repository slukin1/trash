package com.tencent.qcloud.tuikit.tuichat.classicui.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.ContainerUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.v2.V2TIMGroupAtInfo;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.TitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.UnreadCountTextView;
import com.tencent.qcloud.tuikit.timcommon.component.dialog.TUIKitDialog;
import com.tencent.qcloud.tuikit.timcommon.component.face.Emoji;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnChatPopActionClickListener;
import com.tencent.qcloud.tuikit.timcommon.util.ThreadUtils;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupApplyInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageTyping;
import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.noticelayout.NoticeLayout;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.IChatLayout;
import com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIBaseChatFragment;
import com.tencent.qcloud.tuikit.tuichat.classicui.setting.ChatLayoutSetting;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder;
import com.tencent.qcloud.tuikit.tuichat.component.progress.ProgressPresenter;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.interfaces.TotalUnreadCountListener;
import com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.presenter.a;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChatView extends LinearLayout implements IChatLayout {
    private static final int FORWARD_MSG_NUM_LIMIT = 30;
    /* access modifiers changed from: private */
    public static final String TAG = ChatView.class.getSimpleName();
    /* access modifiers changed from: private */
    public boolean isSupportTyping = false;
    /* access modifiers changed from: private */
    public long lastTypingTime = 0;
    public MessageAdapter mAdapter;
    private ImageView mArrowImageView;
    /* access modifiers changed from: private */
    public ChatInfo mChatInfo;
    /* access modifiers changed from: private */
    public boolean mClickLastMessageShow;
    public FrameLayout mCustomView;
    private View mDeleteButton;
    private LinearLayout mForwardLayout;
    private View mForwardMergeButton;
    private View mForwardOneButton;
    private ForwardSelectActivityListener mForwardSelectActivityListener;
    public NoticeLayout mGroupApplyLayout;
    private InputView mInputView;
    /* access modifiers changed from: private */
    public boolean mJumpGroupAtInfoShow;
    private LinearLayout mJumpMessageLayout;
    private TextView mJumpMessageTextView;
    /* access modifiers changed from: private */
    public boolean mJumpNewMessageShow;
    /* access modifiers changed from: private */
    public MessageRecyclerView mMessageRecyclerView;
    private NoticeLayout mNoticeLayout;
    public View mRecordingGroup;
    public ImageView mRecordingIcon;
    public TextView mRecordingTips;
    private TitleBarLayout mTitleBar;
    public ChatPresenter.TypingListener mTypingListener = new ChatPresenter.TypingListener() {
        public void onTyping(int i11) {
            if (TUIChatConfigs.getConfigs().getGeneralConfig().isEnableMessageTyping() && ChatView.this.mChatInfo != null) {
                String access$100 = ChatView.TAG;
                TUIChatLog.d(access$100, "mTypingListener status= " + i11);
                final String chatName = ChatView.this.mChatInfo.getChatName();
                if (i11 == 1) {
                    ChatView.this.getTitleBar().getMiddleTitle().setText(R.string.typing);
                    if (ChatView.this.mTypingRunnable == null) {
                        Runnable unused = ChatView.this.mTypingRunnable = new Runnable() {
                            public void run() {
                                ChatView.this.getTitleBar().getMiddleTitle().setText(chatName);
                            }
                        };
                    }
                    ChatView.this.getTitleBar().getMiddleTitle().removeCallbacks(ChatView.this.mTypingRunnable);
                    ChatView.this.getTitleBar().getMiddleTitle().postDelayed(ChatView.this.mTypingRunnable, 5000);
                } else if (i11 == 0) {
                    ChatView.this.getTitleBar().getMiddleTitle().removeCallbacks(ChatView.this.mTypingRunnable);
                    ChatView.this.getTitleBar().getMiddleTitle().setText(chatName);
                } else {
                    String access$1002 = ChatView.TAG;
                    TUIChatLog.e(access$1002, "parseTypingMessage error status =" + i11);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public Runnable mTypingRunnable = null;
    /* access modifiers changed from: private */
    public AnimationDrawable mVolumeAnim;
    /* access modifiers changed from: private */
    public ChatPresenter presenter;
    private TotalUnreadCountListener unreadCountListener;

    public interface ForwardSelectActivityListener {
        void onStartForwardSelectActivity(int i11, List<TUIMessageBean> list);
    }

    public ChatView(Context context) {
        super(context);
        initViews();
    }

    /* access modifiers changed from: private */
    public void initGroupAtInfoLayout() {
        ChatInfo chatInfo = this.mChatInfo;
        if (chatInfo != null) {
            List<V2TIMGroupAtInfo> atInfoList = chatInfo.getAtInfoList();
            if (atInfoList == null || atInfoList.size() <= 0) {
                TUIChatLog.d(TAG, "initGroupAtInfoLayout groupAtInfos == null");
                this.mJumpGroupAtInfoShow = false;
                hideJumpMessageLayouts();
                return;
            }
            V2TIMGroupAtInfo v2TIMGroupAtInfo = atInfoList.get(0);
            if (v2TIMGroupAtInfo != null) {
                displayBackToAtMessages(v2TIMGroupAtInfo);
                return;
            }
            this.mJumpGroupAtInfoShow = false;
            hideJumpMessageLayouts();
            return;
        }
        TUIChatLog.d(TAG, "initGroupAtInfoLayout mChatInfo == null");
        this.mJumpGroupAtInfoShow = false;
        hideJumpMessageLayouts();
    }

    private void initListener() {
        getMessageLayout().setPopActionClickListener(new OnChatPopActionClickListener() {
            public void onCopyClick(TUIMessageBean tUIMessageBean) {
                ClipboardManager clipboardManager = (ClipboardManager) ChatView.this.getContext().getSystemService("clipboard");
                if (clipboardManager != null && tUIMessageBean != null) {
                    String selectText = tUIMessageBean.getSelectText();
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("message", selectText));
                    if (!TextUtils.isEmpty(selectText)) {
                        ToastUtil.toastShortMessage(ChatView.this.getResources().getString(R.string.copy_success_tip));
                    }
                }
            }

            public void onDeleteMessageClick(final TUIMessageBean tUIMessageBean) {
                new TUIKitDialog(ChatView.this.getContext()).builder().setCancelable(true).setCancelOutside(true).setTitle(ChatView.this.getContext().getString(R.string.chat_delete_msg_tip)).setDialogWidth(0.75f).setPositiveButton(ChatView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.sure), new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        ChatView.this.deleteMessage(tUIMessageBean);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                }).setNegativeButton(ChatView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.cancel), new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                }).show();
            }

            public void onForwardMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.forwardMessage(tUIMessageBean);
            }

            public void onMultiSelectMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.multiSelectMessage(tUIMessageBean);
            }

            public void onQuoteMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.quoteMessage(tUIMessageBean);
            }

            public void onReplyMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.replyMessage(tUIMessageBean);
            }

            public void onRevokeMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.revokeMessage(tUIMessageBean);
            }

            public void onSendMessageClick(TUIMessageBean tUIMessageBean, boolean z11) {
                ChatView.this.sendMessage(tUIMessageBean, z11);
            }
        });
        getMessageLayout().setLoadMoreMessageHandler(new MessageRecyclerView.OnLoadMoreHandler() {
            public void displayBackToLastMessage(boolean z11) {
                if (!ChatView.this.mJumpNewMessageShow) {
                    if (z11) {
                        MessageAdapter messageAdapter = ChatView.this.mAdapter;
                        if (messageAdapter != null) {
                            TUIMessageBean tUIMessageBean = null;
                            int itemCount = messageAdapter.getItemCount() - 1;
                            while (true) {
                                if (itemCount >= 0) {
                                    TUIMessageBean item = ChatView.this.mAdapter.getItem(itemCount);
                                    if (item != null && item.getStatus() != 275) {
                                        tUIMessageBean = ChatView.this.mAdapter.getItem(itemCount);
                                        break;
                                    }
                                    itemCount--;
                                } else {
                                    break;
                                }
                            }
                            if (tUIMessageBean != null) {
                                ChatView.this.displayBackToLastMessages(tUIMessageBean.getId());
                            } else {
                                TUIChatLog.e(ChatView.TAG, "displayJumpLayout messageBean is null");
                            }
                        } else {
                            TUIChatLog.e(ChatView.TAG, "displayJumpLayout mAdapter is null");
                        }
                    } else {
                        ChatView.this.hideJumpMessageLayouts();
                    }
                }
            }

            public void displayBackToNewMessage(boolean z11, String str, int i11) {
                if (z11) {
                    ChatView.this.displayBackToNewMessages(str, i11);
                    return;
                }
                boolean unused = ChatView.this.mJumpNewMessageShow = false;
                ChatView.this.hideJumpMessageLayouts();
            }

            public void hideBackToAtMessage() {
                ChatView.this.hideBackToAtMessages();
            }

            public boolean isListEnd(int i11) {
                return ChatView.this.getMessageLayout().isLastItemVisibleCompleted();
            }

            public void loadMessageFinish() {
                ChatView.this.initGroupAtInfoLayout();
            }

            public void loadMore(int i11) {
                ChatView.this.loadMessages(i11);
            }

            public void scrollMessageFinish() {
                if (ChatView.this.mClickLastMessageShow && ChatView.this.mMessageRecyclerView != null) {
                    boolean unused = ChatView.this.mClickLastMessageShow = false;
                    ChatView.this.mMessageRecyclerView.setHighShowPosition(-1);
                }
            }
        });
        getMessageLayout().setEmptySpaceClickListener(new MessageRecyclerView.OnEmptySpaceClickListener() {
            public void onClick() {
                ChatView.this.getInputLayout().onEmptyClick();
            }
        });
        getInputLayout().setChatInputHandler(new InputView.ChatInputHandler() {
            private void cancelRecording() {
                ChatView.this.post(new Runnable() {
                    public void run() {
                        ChatView.this.mRecordingIcon.setImageResource(R.drawable.ic_volume_dialog_cancel);
                        ChatView.this.mRecordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.up_cancle_send));
                    }
                });
            }

            private void startRecording() {
                ChatView.this.post(new Runnable() {
                    public void run() {
                        AudioPlayer.getInstance().stopPlay();
                        ChatView.this.mRecordingGroup.setVisibility(0);
                        ChatView.this.mRecordingIcon.setImageResource(R.drawable.recording_volume);
                        ChatView chatView = ChatView.this;
                        AnimationDrawable unused = chatView.mVolumeAnim = (AnimationDrawable) chatView.mRecordingIcon.getDrawable();
                        ChatView.this.mVolumeAnim.start();
                        ChatView.this.mRecordingTips.setTextColor(-1);
                        ChatView.this.mRecordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.down_cancle_send));
                    }
                });
            }

            private void stopAbnormally(final int i11) {
                ChatView.this.post(new Runnable() {
                    public void run() {
                        ChatView.this.mVolumeAnim.stop();
                        ChatView.this.mRecordingIcon.setImageResource(R.drawable.ic_volume_dialog_length_short);
                        ChatView.this.mRecordingTips.setTextColor(-1);
                        if (i11 == 4) {
                            ChatView.this.mRecordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.say_time_short));
                        } else {
                            ChatView.this.mRecordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.record_fail));
                        }
                    }
                });
                ChatView.this.post(new Runnable() {
                    public void run() {
                        ChatView.this.mRecordingGroup.setVisibility(8);
                    }
                });
            }

            private void stopRecording() {
                ChatView.this.post(new Runnable() {
                    public void run() {
                        if (ChatView.this.mVolumeAnim != null) {
                            ChatView.this.mVolumeAnim.stop();
                        }
                        ChatView.this.mRecordingGroup.setVisibility(8);
                    }
                });
            }

            public void onInputAreaClick() {
                ChatView.this.post(new Runnable() {
                    public void run() {
                        if (ChatView.this.presenter != null) {
                            ChatView.this.presenter.scrollToNewestMessage();
                        }
                    }
                });
            }

            public void onRecordStatusChanged(int i11) {
                if (i11 == 1) {
                    startRecording();
                } else if (i11 == 2) {
                    stopRecording();
                } else if (i11 == 3) {
                    cancelRecording();
                } else if (i11 == 4 || i11 == 5) {
                    stopAbnormally(i11);
                }
            }

            public void onUserTyping(boolean z11, long j11) {
                if (TUIChatConfigs.getConfigs().getGeneralConfig().isEnableMessageTyping()) {
                    if (!ChatView.this.isSupportTyping) {
                        if (!ChatView.this.isSupportTyping(j11)) {
                            TUIChatLog.d(ChatView.TAG, "onUserTyping trigger condition not met");
                            return;
                        }
                        boolean unused = ChatView.this.isSupportTyping = true;
                    }
                    if (!z11) {
                        ChatView.this.sendTypingStatusMessage(false);
                    } else if (ChatView.this.lastTypingTime == 0 || j11 - ChatView.this.lastTypingTime >= 4) {
                        long unused2 = ChatView.this.lastTypingTime = j11;
                        ChatView.this.sendTypingStatusMessage(true);
                    }
                }
            }
        });
    }

    private void initViews() {
        LinearLayout.inflate(getContext(), R.layout.chat_layout, this);
        this.mTitleBar = (TitleBarLayout) findViewById(R.id.chat_title_bar);
        this.mMessageRecyclerView = (MessageRecyclerView) findViewById(R.id.chat_message_layout);
        InputView inputView = (InputView) findViewById(R.id.chat_input_layout);
        this.mInputView = inputView;
        inputView.setChatLayout(this);
        this.mRecordingGroup = findViewById(R.id.voice_recording_view);
        this.mRecordingIcon = (ImageView) findViewById(R.id.recording_icon);
        this.mRecordingTips = (TextView) findViewById(R.id.recording_tips);
        this.mGroupApplyLayout = (NoticeLayout) findViewById(R.id.chat_group_apply_layout);
        this.mNoticeLayout = (NoticeLayout) findViewById(R.id.chat_notice_layout);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.custom_layout);
        this.mCustomView = frameLayout;
        frameLayout.setVisibility(8);
        this.mForwardLayout = (LinearLayout) findViewById(R.id.forward_layout);
        this.mForwardOneButton = findViewById(R.id.forward_one_by_one_button);
        this.mForwardMergeButton = findViewById(R.id.forward_merge_button);
        this.mDeleteButton = findViewById(R.id.delete_button);
        this.mJumpMessageLayout = (LinearLayout) findViewById(R.id.jump_message_layout);
        this.mJumpMessageTextView = (TextView) findViewById(R.id.jump_message_content);
        this.mArrowImageView = (ImageView) findViewById(R.id.arrow_icon);
        this.mJumpNewMessageShow = false;
        hideJumpMessageLayouts();
        this.mTitleBar.getMiddleTitle().setEllipsize(TextUtils.TruncateAt.END);
        this.lastTypingTime = 0;
        this.isSupportTyping = false;
    }

    private void loadApplyList() {
        this.presenter.loadApplyList(new IUIKitCallback<List<GroupApplyInfo>>() {
            public void onError(String str, int i11, String str2) {
                String access$100 = ChatView.TAG;
                TUIChatLog.e(access$100, "loadApplyList onError: " + str2);
            }

            public void onSuccess(List<GroupApplyInfo> list) {
                if (list != null && list.size() > 0) {
                    ChatView.this.mGroupApplyLayout.getContent().setText(ChatView.this.getContext().getString(R.string.group_apply_tips, new Object[]{Integer.valueOf(list.size())}));
                    ChatView.this.mGroupApplyLayout.setVisibility(0);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void locateOriginMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            ToastUtil.toastShortMessage(getContext().getString(R.string.locate_origin_msg_failed_tip));
            return;
        }
        this.presenter.locateMessage(str, new IUIKitCallback<Void>() {
            public void onError(String str, int i11, String str2) {
                ChatView.this.hideJumpMessageLayouts();
                ToastUtil.toastShortMessage(ChatView.this.getContext().getString(R.string.locate_origin_msg_failed_tip));
            }

            public void onSuccess(Void voidR) {
                ChatView.this.hideJumpMessageLayouts();
            }
        });
        hideJumpMessageLayouts();
    }

    /* access modifiers changed from: private */
    public void locateOriginMessageBySeq(long j11) {
        this.presenter.locateMessageBySeq(this.mChatInfo.getId(), j11, new IUIKitCallback<Void>() {
            public void onError(String str, int i11, String str2) {
                ChatView.this.hideJumpMessageLayouts();
                ToastUtil.toastShortMessage(ChatView.this.getContext().getString(R.string.locate_origin_msg_failed_tip));
            }

            public void onSuccess(Void voidR) {
                ChatView.this.hideJumpMessageLayouts();
            }
        });
    }

    /* access modifiers changed from: private */
    public void markCallingMsgRead(int i11, int i12) {
        if (this.mAdapter != null && this.presenter != null) {
            ArrayList arrayList = new ArrayList();
            for (TUIMessageBean next : this.mAdapter.getItemList(i11, i12)) {
                if (next instanceof CallingMessageBean) {
                    arrayList.add((CallingMessageBean) next);
                }
            }
            this.presenter.markCallingMsgRead(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public void openWebUrl(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        getContext().startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void resetForwardState(String str) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null) {
            messageAdapter.setShowMultiSelectCheckBox(false);
            this.mAdapter.notifyDataSetChanged();
        }
        resetTitleBar(str);
    }

    private void resetTitleBar(String str) {
        getTitleBar().getRightGroup().setVisibility(0);
        getTitleBar().getLeftGroup().setVisibility(0);
        getTitleBar().getLeftIcon().setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            getTitleBar().setTitle(str, ITitleBarLayout.Position.LEFT);
        } else {
            getTitleBar().setTitle("", ITitleBarLayout.Position.LEFT);
        }
        getTitleBar().setOnLeftClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (ChatView.this.getContext() instanceof Activity) {
                    ((Activity) ChatView.this.getContext()).finish();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        getForwardLayout().setVisibility(8);
        getInputLayout().setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void sendMsgReadReceipt(int i11, int i12) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null && this.presenter != null) {
            this.presenter.sendMessageReadReceipt(messageAdapter.getItemList(i11, i12), new IUIKitCallback<Void>() {
                public void onError(String str, int i11, String str2) {
                    if (i11 == 7013) {
                        ChatView.this.showNotSupportDialog();
                    }
                }

                public void onSuccess(Void voidR) {
                }
            });
        }
    }

    private void setChatHandler() {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter instanceof GroupChatPresenter) {
            chatPresenter.setChatNotifyHandler(new ChatPresenter.ChatNotifyHandler() {
                public /* synthetic */ void addMessageAfterPreProcess(TUIMessageBean tUIMessageBean) {
                    a.a(this, tUIMessageBean);
                }

                public /* synthetic */ void clearMessage() {
                    a.b(this);
                }

                public /* synthetic */ void clearMessageAndReLoad() {
                    a.c(this);
                }

                public void onApplied(int i11) {
                    ChatView.this.onApplied(i11);
                }

                public void onExitChat(String str) {
                    ChatView.this.onExitChat();
                }

                public /* synthetic */ void onFriendFaceUrlChanged(String str) {
                    a.f(this, str);
                }

                public /* synthetic */ void onFriendNameChanged(String str) {
                    a.g(this, str);
                }

                public /* synthetic */ void onGroupFaceUrlChanged(String str) {
                    a.h(this, str);
                }

                public void onGroupForceExit() {
                    ChatView.this.onExitChat();
                }

                public void onGroupNameChanged(String str) {
                    ChatView.this.onGroupNameChanged(str);
                }

                public /* synthetic */ void onReceiveCustomMessage(TUIMessageBean tUIMessageBean) {
                    a.k(this, tUIMessageBean);
                }

                public /* synthetic */ void resetCurrentChatUnreadCount() {
                    a.l(this);
                }

                public /* synthetic */ void updateAdapter(int i11, int i12) {
                    a.m(this, i11, i12);
                }

                public /* synthetic */ void updateAdapter(int i11, TUIMessageBean tUIMessageBean) {
                    a.n(this, i11, tUIMessageBean);
                }
            });
        } else if (chatPresenter instanceof C2CChatPresenter) {
            chatPresenter.setChatNotifyHandler(new ChatPresenter.ChatNotifyHandler() {
                public /* synthetic */ void addMessageAfterPreProcess(TUIMessageBean tUIMessageBean) {
                    a.a(this, tUIMessageBean);
                }

                public /* synthetic */ void clearMessage() {
                    a.b(this);
                }

                public /* synthetic */ void clearMessageAndReLoad() {
                    a.c(this);
                }

                public /* synthetic */ void onApplied(int i11) {
                    a.d(this, i11);
                }

                public void onExitChat(String str) {
                    ChatView.this.onExitChat();
                }

                public /* synthetic */ void onFriendFaceUrlChanged(String str) {
                    a.f(this, str);
                }

                public void onFriendNameChanged(String str) {
                    ChatView.this.onFriendNameChanged(str);
                }

                public /* synthetic */ void onGroupFaceUrlChanged(String str) {
                    a.h(this, str);
                }

                public /* synthetic */ void onGroupForceExit() {
                    a.i(this);
                }

                public /* synthetic */ void onGroupNameChanged(String str) {
                    a.j(this, str);
                }

                public /* synthetic */ void onReceiveCustomMessage(TUIMessageBean tUIMessageBean) {
                    a.k(this, tUIMessageBean);
                }

                public /* synthetic */ void resetCurrentChatUnreadCount() {
                    a.l(this);
                }

                public /* synthetic */ void updateAdapter(int i11, int i12) {
                    a.m(this, i11, i12);
                }

                public /* synthetic */ void updateAdapter(int i11, TUIMessageBean tUIMessageBean) {
                    a.n(this, i11, tUIMessageBean);
                }
            });
        }
    }

    private void setTitleBarWhenMultiSelectMessage() {
        getTitleBar().getRightGroup().setVisibility(8);
        getTitleBar().getLeftGroup().setVisibility(0);
        getTitleBar().getLeftIcon().setVisibility(8);
        final CharSequence text = getTitleBar().getLeftTitle().getText();
        getTitleBar().setTitle(getContext().getString(com.tencent.qcloud.tuicore.R.string.cancel), ITitleBarLayout.Position.LEFT);
        getTitleBar().setOnLeftClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ChatView.this.resetForwardState(text.toString());
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        getInputLayout().setVisibility(8);
        getForwardLayout().setVisibility(0);
        getForwardOneButton().setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ChatView.this.showForwardDialog(true, true);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        getForwardMergeButton().setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ChatView.this.showForwardDialog(true, false);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        getDeleteButton().setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ArrayList<TUIMessageBean> selectedItem = ChatView.this.mAdapter.getSelectedItem();
                if (selectedItem == null || selectedItem.isEmpty()) {
                    ToastUtil.toastShortMessage("please select message!");
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                ChatView.this.deleteMessageInfos(selectedItem);
                ChatView.this.resetForwardState(text.toString());
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    private void setTotalUnread() {
        final UnreadCountTextView unreadCountTextView = this.mTitleBar.getUnreadCountTextView();
        unreadCountTextView.setPaintColor(getResources().getColor(TUIThemeManager.getAttrResId(getContext(), R.attr.chat_unread_dot_bg_color)));
        unreadCountTextView.setTextColor(getResources().getColor(TUIThemeManager.getAttrResId(getContext(), R.attr.chat_unread_dot_text_color)));
        Object callService = TUICore.callService("TUIConversationService", TUIConstants.TUIConversation.METHOD_GET_TOTAL_UNREAD_COUNT, (Map<String, Object>) null);
        updateUnreadCount(unreadCountTextView, (callService == null || !(callService instanceof Long)) ? 0 : ((Long) TUICore.callService("TUIConversationService", TUIConstants.TUIConversation.METHOD_GET_TOTAL_UNREAD_COUNT, (Map<String, Object>) null)).longValue());
        this.unreadCountListener = new TotalUnreadCountListener() {
            public void onTotalUnreadCountChanged(long j11) {
                ChatView.this.updateUnreadCount(unreadCountTextView, j11);
            }
        };
        TUIChatService.getInstance().addUnreadCountListener(this.unreadCountListener);
    }

    /* access modifiers changed from: private */
    public void showForwardDialog(boolean z11, boolean z12) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null) {
            ArrayList<TUIMessageBean> selectedItem = messageAdapter.getSelectedItem();
            if (selectedItem == null || selectedItem.isEmpty()) {
                ToastUtil.toastShortMessage(getContext().getString(R.string.forward_tip));
            } else if (checkFailedMessageInfos(selectedItem)) {
                ToastUtil.toastShortMessage(getContext().getString(R.string.forward_failed_tip));
            } else {
                for (TUIMessageBean isEnableForward : selectedItem) {
                    if (!isEnableForward.isEnableForward()) {
                        ToastUtil.toastShortMessage(getContext().getString(R.string.forward_group_note_or_poll_failed_tip));
                        return;
                    }
                }
                if (!z11) {
                    this.mAdapter.setShowMultiSelectCheckBox(false);
                }
                if (!z12) {
                    startSelectForwardActivity(1, selectedItem);
                    resetForwardState("");
                } else if (selectedItem.size() > 30) {
                    showForwardLimitDialog(selectedItem);
                } else {
                    startSelectForwardActivity(0, selectedItem);
                    resetForwardState("");
                }
            }
        }
    }

    private void showForwardLimitDialog(final List<TUIMessageBean> list) {
        new TUIKitDialog(getContext()).builder().setCancelable(true).setCancelOutside(true).setTitle(getContext().getString(R.string.forward_oneByOne_limit_number_tip)).setDialogWidth(0.75f).setPositiveButton(getContext().getString(R.string.forward_mode_merge), new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ChatView.this.startSelectForwardActivity(1, list);
                ChatView.this.resetForwardState("");
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }).setNegativeButton(getContext().getString(com.tencent.qcloud.tuicore.R.string.cancel), new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }).show();
    }

    /* access modifiers changed from: private */
    public void showNotSupportDialog() {
        String string = getResources().getString(R.string.chat_im_flagship_edition_update_tip, new Object[]{getResources().getString(R.string.chat_message_read_receipt)});
        String string2 = getResources().getString(R.string.chat_buying_guidelines);
        int lastIndexOf = string.lastIndexOf(string2);
        int color = getResources().getColor(TUIThemeManager.getAttrResId(getContext(), com.tencent.qcloud.tuicore.R.attr.core_primary_color));
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(color), lastIndexOf, string2.length() + lastIndexOf, 34);
        spannableString.setSpan(new ClickableSpan() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (TextUtils.equals(TUIThemeManager.getInstance().getCurrentLanguage(), "zh")) {
                    ChatView.this.openWebUrl(TUIConstants.BuyingFeature.BUYING_PRICE_DESC);
                } else {
                    ChatView.this.openWebUrl(TUIConstants.BuyingFeature.BUYING_PRICE_DESC_EN);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, lastIndexOf, string2.length() + lastIndexOf, 34);
        TUIKitDialog.TUIIMUpdateDialog.getInstance().createDialog(getContext()).setShowOnlyDebug(true).setMovementMethod(LinkMovementMethod.getInstance()).setHighlightColor(0).setCancelable(true).setCancelOutside(true).setTitle(spannableString).setDialogWidth(0.75f).setDialogFeatureName(TUIConstants.BuyingFeature.BUYING_FEATURE_MESSAGE_RECEIPT).setPositiveButton(getResources().getString(R.string.chat_no_more_reminders), new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUIKitDialog.TUIIMUpdateDialog.getInstance().dismiss();
                TUIKitDialog.TUIIMUpdateDialog.getInstance().setNeverShow(true);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }).setNegativeButton(getResources().getString(R.string.chat_i_know), new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUIKitDialog.TUIIMUpdateDialog.getInstance().dismiss();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }).show();
    }

    /* access modifiers changed from: private */
    public void startSelectForwardActivity(int i11, List<TUIMessageBean> list) {
        ForwardSelectActivityListener forwardSelectActivityListener = this.mForwardSelectActivityListener;
        if (forwardSelectActivityListener != null) {
            forwardSelectActivityListener.onStartForwardSelectActivity(i11, list);
        }
    }

    /* access modifiers changed from: private */
    public void updateUnreadCount(UnreadCountTextView unreadCountTextView, long j11) {
        if (j11 <= 0) {
            unreadCountTextView.setVisibility(8);
            return;
        }
        unreadCountTextView.setVisibility(0);
        String str = j11 + "";
        if (j11 > 99) {
            str = "99+";
        }
        unreadCountTextView.setText(str);
    }

    public boolean checkFailedMessageInfos(List<TUIMessageBean> list) {
        return this.presenter.checkFailedMessageInfos(list);
    }

    public void deleteMessage(TUIMessageBean tUIMessageBean) {
        this.presenter.deleteMessage(tUIMessageBean);
    }

    public void deleteMessageInfos(List<TUIMessageBean> list) {
        this.presenter.deleteMessageInfos(list);
    }

    public void deleteMessages(List<Integer> list) {
        this.presenter.deleteMessages(list);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        MessageAdapter messageAdapter;
        if (motionEvent.getAction() == 0 && (messageAdapter = this.mAdapter) != null) {
            messageAdapter.resetSelectableText();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void displayBackToAtMessages(final V2TIMGroupAtInfo v2TIMGroupAtInfo) {
        this.mJumpGroupAtInfoShow = true;
        this.mJumpMessageLayout.setVisibility(0);
        this.mArrowImageView.setBackgroundResource(TUIThemeManager.getAttrResId(getContext(), R.attr.chat_jump_recent_up_icon));
        if (v2TIMGroupAtInfo.getAtType() == 2) {
            this.mJumpMessageTextView.setText(getContext().getString(R.string.back_to_atmessage_all));
        } else {
            this.mJumpMessageTextView.setText(getContext().getString(R.string.back_to_atmessage_me));
        }
        this.mJumpMessageLayout.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ChatView.this.locateOriginMessageBySeq(v2TIMGroupAtInfo.getSeq());
                ChatView.this.hideJumpMessageLayouts();
                boolean unused = ChatView.this.mJumpGroupAtInfoShow = false;
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    public void displayBackToLastMessages(final String str) {
        this.mJumpMessageLayout.setVisibility(0);
        this.mArrowImageView.setBackgroundResource(TUIThemeManager.getAttrResId(getContext(), R.attr.chat_jump_recent_down_icon));
        this.mJumpMessageTextView.setText(getContext().getString(R.string.back_to_lastmessage));
        this.mJumpMessageLayout.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ChatView.this.locateOriginMessage(str);
                boolean unused = ChatView.this.mClickLastMessageShow = true;
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    public void displayBackToNewMessages(final String str, int i11) {
        this.mJumpNewMessageShow = true;
        this.mJumpMessageLayout.setVisibility(0);
        this.mArrowImageView.setBackgroundResource(TUIThemeManager.getAttrResId(getContext(), R.attr.chat_jump_recent_down_icon));
        TextView textView = this.mJumpMessageTextView;
        textView.setText(String.valueOf(i11) + getContext().getString(R.string.back_to_newmessage));
        this.mJumpMessageLayout.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ChatView.this.locateOriginMessage(str);
                ChatView.this.presenter.markMessageAsRead(ChatView.this.mChatInfo);
                boolean unused = ChatView.this.mJumpNewMessageShow = false;
                ChatView.this.presenter.resetNewMessageCount();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    public void exitChat() {
        getTitleBar().getMiddleTitle().removeCallbacks(this.mTypingRunnable);
        AudioRecorder.getInstance().stopRecord();
        AudioPlayer.getInstance().stopPlay();
        this.presenter.markMessageAsRead(this.mChatInfo);
    }

    public void forwardMessage(TUIMessageBean tUIMessageBean) {
        if (this.mAdapter != null) {
            this.mInputView.hideSoftInput();
            this.mAdapter.setItemChecked(tUIMessageBean.getId(), true);
            this.mAdapter.notifyDataSetChanged();
            showForwardDialog(false, true);
        }
    }

    public ChatInfo getChatInfo() {
        return this.mChatInfo;
    }

    public FrameLayout getCustomView() {
        return this.mCustomView;
    }

    public View getDeleteButton() {
        return this.mDeleteButton;
    }

    public LinearLayout getForwardLayout() {
        return this.mForwardLayout;
    }

    public View getForwardMergeButton() {
        return this.mForwardMergeButton;
    }

    public View getForwardOneButton() {
        return this.mForwardOneButton;
    }

    public InputView getInputLayout() {
        return this.mInputView;
    }

    public MessageRecyclerView getMessageLayout() {
        return this.mMessageRecyclerView;
    }

    public NoticeLayout getNoticeLayout() {
        return this.mNoticeLayout;
    }

    public TitleBarLayout getTitleBar() {
        return this.mTitleBar;
    }

    public void hideBackToAtMessages() {
        if (this.mJumpGroupAtInfoShow) {
            this.mJumpGroupAtInfoShow = false;
            hideJumpMessageLayouts();
        }
    }

    public void hideJumpMessageLayouts() {
        this.mJumpMessageLayout.setVisibility(8);
    }

    public void initDefault(TUIBaseChatFragment tUIBaseChatFragment) {
        getTitleBar().getLeftGroup().setVisibility(0);
        getTitleBar().setOnLeftClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (ChatView.this.getContext() instanceof Activity) {
                    ((Activity) ChatView.this.getContext()).finish();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        getInputLayout().setMessageHandler(new InputView.MessageHandler() {
            public void scrollToEnd() {
                ChatView.this.scrollToEnd();
            }

            public void sendMessage(TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean instanceof ReplyMessageBean) {
                    ChatView.this.sendReplyMessage(tUIMessageBean, false);
                } else {
                    ChatView.this.sendMessage(tUIMessageBean, false);
                }
            }
        });
        getInputLayout().clearCustomActionList();
        if (getMessageLayout().getAdapter() == null) {
            MessageAdapter messageAdapter = new MessageAdapter();
            this.mAdapter = messageAdapter;
            messageAdapter.setFragment(tUIBaseChatFragment);
            this.mMessageRecyclerView.setAdapter(this.mAdapter);
        }
        new ChatLayoutSetting(getContext()).customizeChatLayout(this);
        initListener();
        resetForwardState("");
    }

    public boolean isSupportTyping(long j11) {
        return this.presenter.isSupportTyping(j11);
    }

    public void loadMessages(TUIMessageBean tUIMessageBean, int i11) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.loadMessage(i11, tUIMessageBean);
        }
    }

    public void multiSelectMessage(TUIMessageBean tUIMessageBean) {
        if (this.mAdapter != null) {
            this.mInputView.hideSoftInput();
            this.mAdapter.setShowMultiSelectCheckBox(true);
            this.mAdapter.setItemChecked(tUIMessageBean.getId(), true);
            this.mAdapter.notifyDataSetChanged();
            setTitleBarWhenMultiSelectMessage();
        }
    }

    public void onApplied(int i11) {
        if (i11 <= 0) {
            this.mGroupApplyLayout.setVisibility(8);
            return;
        }
        this.mGroupApplyLayout.getContent().setText(getContext().getString(R.string.group_apply_tips, new Object[]{Integer.valueOf(i11)}));
        this.mGroupApplyLayout.setVisibility(0);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mCustomView.removeAllViews();
        exitChat();
    }

    public void onExitChat() {
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).finish();
        }
    }

    public void onFriendNameChanged(String str) {
        getTitleBar().setTitle(str, ITitleBarLayout.Position.MIDDLE);
    }

    public void onGroupNameChanged(String str) {
        getTitleBar().setTitle(str, ITitleBarLayout.Position.MIDDLE);
    }

    public void onVisibilityChanged(View view, int i11) {
        LinearLayoutManager linearLayoutManager;
        if (i11 == 0 && getMessageLayout() != null && (linearLayoutManager = (LinearLayoutManager) getMessageLayout().getLayoutManager()) != null) {
            sendMsgReadReceipt(linearLayoutManager.findFirstCompletelyVisibleItemPosition(), linearLayoutManager.findLastCompletelyVisibleItemPosition());
        }
    }

    public void quoteMessage(TUIMessageBean tUIMessageBean) {
        ReplyPreviewBean buildReplyPreviewBean = ChatMessageBuilder.buildReplyPreviewBean(tUIMessageBean);
        buildReplyPreviewBean.setMessageRootID((String) null);
        this.mInputView.showReplyPreview(buildReplyPreviewBean);
    }

    public void reactMessage(Emoji emoji, TUIMessageBean tUIMessageBean) {
        this.presenter.reactMessage(emoji.getFaceKey(), tUIMessageBean);
    }

    public void replyMessage(TUIMessageBean tUIMessageBean) {
        this.mInputView.showReplyPreview(ChatMessageBuilder.buildReplyPreviewBean(tUIMessageBean));
    }

    public void revokeMessage(TUIMessageBean tUIMessageBean) {
        this.presenter.revokeMessage(tUIMessageBean);
    }

    public void scrollToEnd() {
        getMessageLayout().scrollToEnd();
    }

    public void sendMessage(final TUIMessageBean tUIMessageBean, boolean z11) {
        this.presenter.sendMessage(tUIMessageBean, z11, (IUIKitCallback<TUIMessageBean>) new IUIKitCallback<TUIMessageBean>() {
            public void onError(String str, int i11, String str2) {
                String str3 = i11 + ", " + str2;
                if (i11 == 7013) {
                    ChatView.this.showNotSupportDialog();
                    if (tUIMessageBean.isNeedReadReceipt()) {
                        str3 = ChatView.this.getResources().getString(R.string.chat_message_read_receipt) + ChatView.this.getResources().getString(com.tencent.qcloud.tuicore.R.string.TUIKitErrorUnsupporInterfaceSuffix);
                    }
                }
                ToastUtil.toastLongMessage(str3);
            }

            public void onProgress(Object obj) {
                ProgressPresenter.getInstance().updateProgress(tUIMessageBean.getId(), ((Integer) obj).intValue());
            }

            public void onSuccess(TUIMessageBean tUIMessageBean) {
                ThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        ChatView.this.scrollToEnd();
                    }
                });
            }
        });
    }

    public void sendReplyMessage(final TUIMessageBean tUIMessageBean, boolean z11) {
        this.presenter.sendMessage(tUIMessageBean, z11, (IUIKitCallback<TUIMessageBean>) new IUIKitCallback<TUIMessageBean>() {
            public void onError(String str, int i11, String str2) {
                String str3 = i11 + ", " + str2;
                if (i11 == 7013) {
                    ChatView.this.showNotSupportDialog();
                    if (tUIMessageBean.isNeedReadReceipt()) {
                        str3 = ChatView.this.getResources().getString(R.string.chat_message_read_receipt) + ChatView.this.getResources().getString(com.tencent.qcloud.tuicore.R.string.TUIKitErrorUnsupporInterfaceSuffix);
                    }
                }
                ToastUtil.toastLongMessage(str3);
            }

            public void onSuccess(TUIMessageBean tUIMessageBean) {
                ThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        ChatView.this.scrollToEnd();
                    }
                });
                ChatView.this.presenter.modifyRootMessageToAddReplyInfo((ReplyMessageBean) tUIMessageBean, (IUIKitCallback<Void>) new IUIKitCallback<Void>() {
                    public void onError(String str, int i11, String str2) {
                        ToastUtil.toastShortMessage("modify message failed code = " + i11 + " message = " + str2);
                    }
                });
            }
        });
    }

    public void sendTypingStatusMessage(boolean z11) {
        if (this.mChatInfo == null || TextUtils.isEmpty(getChatInfo().getId())) {
            TUIChatLog.e(TAG, "sendTypingStatusMessage receiver is invalid");
            return;
        }
        Gson gson = new Gson();
        MessageTyping messageTyping = new MessageTyping();
        messageTyping.setTypingStatus(z11);
        String json = gson.toJson((Object) messageTyping);
        String str = TAG;
        TUIChatLog.d(str, "sendTypingStatusMessage data = " + json);
        this.presenter.sendTypingStatusMessage(ChatMessageBuilder.buildCustomMessage(json, "", (byte[]) null), this.mChatInfo.getId(), new IUIKitCallback<TUIMessageBean>() {
            public void onError(String str, int i11, String str2) {
                String access$100 = ChatView.TAG;
                TUIChatLog.d(access$100, "sendTypingStatusMessage fail:" + i11 + ContainerUtils.KEY_VALUE_DELIMITER + str2);
            }

            public void onSuccess(TUIMessageBean tUIMessageBean) {
                String access$100 = ChatView.TAG;
                TUIChatLog.d(access$100, "sendTypingStatusMessage onSuccess:" + tUIMessageBean.getId());
            }
        });
    }

    public void setChatInfo(final ChatInfo chatInfo) {
        this.mChatInfo = chatInfo;
        if (chatInfo != null) {
            this.mInputView.setChatInfo(chatInfo);
            getTitleBar().setTitle(chatInfo.getChatName(), ITitleBarLayout.Position.MIDDLE);
            setChatHandler();
            if (!TUIChatUtils.isC2CChat(chatInfo.getType())) {
                loadApplyList();
                this.mGroupApplyLayout.setOnNoticeClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putString("group_id", chatInfo.getId());
                        TUICore.startActivity(ChatView.this.getContext(), "GroupApplyManagerActivity", bundle);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
            }
            this.mMessageRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) ChatView.this.getMessageLayout().getLayoutManager();
                    int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                    int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                    ChatView.this.sendMsgReadReceipt(findFirstCompletelyVisibleItemPosition, findLastCompletelyVisibleItemPosition);
                    ChatView.this.markCallingMsgRead(findFirstCompletelyVisibleItemPosition, findLastCompletelyVisibleItemPosition);
                }
            });
            this.mMessageRecyclerView.setMenuEmojiOnClickListener(new MessageRecyclerView.OnMenuEmojiClickListener() {
                public void onClick(Emoji emoji, TUIMessageBean tUIMessageBean) {
                    ChatView.this.reactMessage(emoji, tUIMessageBean);
                }
            });
            loadMessages(chatInfo.getLocateMessage(), chatInfo.getLocateMessage() == null ? 0 : 2);
            setTotalUnread();
        }
    }

    public void setForwardSelectActivityListener(ForwardSelectActivityListener forwardSelectActivityListener) {
        this.mForwardSelectActivityListener = forwardSelectActivityListener;
    }

    public void setParentLayout(Object obj) {
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
        this.mMessageRecyclerView.setPresenter(chatPresenter);
        this.mInputView.setPresenter(chatPresenter);
        chatPresenter.setMessageListAdapter(this.mAdapter);
        this.mAdapter.setPresenter(chatPresenter);
        chatPresenter.setMessageRecycleView(this.mMessageRecyclerView);
    }

    public void loadMessages(int i11) {
        TUIMessageBean tUIMessageBean = null;
        if (i11 == 0) {
            if (this.mAdapter.getItemCount() > 0) {
                tUIMessageBean = this.mAdapter.getItem(1);
            }
            loadMessages(tUIMessageBean, i11);
        } else if (i11 == 1) {
            if (this.mAdapter.getItemCount() > 0) {
                MessageAdapter messageAdapter = this.mAdapter;
                tUIMessageBean = messageAdapter.getItem(messageAdapter.getItemCount() - 1);
            }
            loadMessages(tUIMessageBean, i11);
        }
    }

    public ChatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViews();
    }

    public ChatView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initViews();
    }
}
