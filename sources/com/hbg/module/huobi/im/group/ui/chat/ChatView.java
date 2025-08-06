package com.hbg.module.huobi.im.group.ui.chat;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.sharesdk.framework.InnerShareParams;
import com.google.gson.Gson;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.GroupInviteBean;
import com.hbg.lib.network.hbg.core.bean.GroupUserListData;
import com.hbg.lib.network.hbg.core.bean.TranslateBean;
import com.hbg.module.huobi.im.IMConversationHelper;
import com.hbg.module.huobi.im.R$attr;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.R$style;
import com.hbg.module.huobi.im.group.bean.HbAccountManagerUnreadBean;
import com.hbg.module.huobi.im.group.bean.HbShareMessageBean;
import com.hbg.module.huobi.im.group.bean.HbSharePrimeMessageBean;
import com.hbg.module.huobi.im.group.bean.HbShareTextMessageBean;
import com.hbg.module.huobi.im.group.bean.HbTextMessageBean;
import com.hbg.module.huobi.im.group.bean.HbTipMessageBean;
import com.hbg.module.huobi.im.group.listener.OnCustomPopActionClickListener;
import com.hbg.module.huobi.im.group.ui.chat.InputView;
import com.hbg.module.huobi.im.utils.HbGroupUserManager;
import com.hbg.module.huobi.im.utils.MessageBusinessID;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMGroupAtInfo;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageListGetOption;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.TitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.UnreadCountTextView;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage;
import com.tencent.qcloud.tuikit.tuichat.BusinessCallbacks;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupApplyInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.HbNoticeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.noticelayout.NoticeLayout;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.ChatPopMenuAction;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.component.progress.ProgressPresenter;
import com.tencent.qcloud.tuikit.tuichat.interfaces.TotalUnreadCountListener;
import com.tencent.qcloud.tuikit.tuichat.manager.HbGroupChatManager;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kd.a;
import kotlin.Unit;
import ld.e;
import ld.f;
import nd.b;
import rd.q;

public class ChatView extends LinearLayout implements IChatLayout {
    public static final long CLICK_INTERVAL_TIME = 2000;
    private static final int FORWARD_MSG_NUM_LIMIT = 30;
    /* access modifiers changed from: private */
    public static final String TAG = ChatView.class.getSimpleName();
    /* access modifiers changed from: private */
    public int atClickCount = 0;
    /* access modifiers changed from: private */
    public int atCount = 0;
    /* access modifiers changed from: private */
    public ChatPresenter chatManager;
    private ChatPresenter.ChatNotifyHandler chatNotifyHandler;
    /* access modifiers changed from: private */
    public int chatType = 1;
    /* access modifiers changed from: private */
    public int currentChatUnreadCount = 0;
    /* access modifiers changed from: private */
    public boolean firstLoadList = true;
    /* access modifiers changed from: private */
    public String groupAvatar;
    private GroupUserListData groupUserListData;
    private BusinessCallbacks.ImGroupMessageListener imGroupMessageListener;
    /* access modifiers changed from: private */
    public boolean isCanClearAt = true;
    /* access modifiers changed from: private */
    public boolean isGroup = false;
    /* access modifiers changed from: private */
    public ImageView ivAtClose;
    /* access modifiers changed from: private */
    public long lastTime = 0;
    /* access modifiers changed from: private */
    public f liveImPresenter = new f((e) null);
    public HbChatMessageAdapter mAdapter;
    /* access modifiers changed from: private */
    public List<Long> mAtUserIdList = new ArrayList();
    /* access modifiers changed from: private */
    public TUIMessageBean mCacheNewMessage = null;
    public ChatInfo mChatInfo;
    /* access modifiers changed from: private */
    public boolean mClickLastMessageShow;
    private TUIMessageBean mConversationLastMessage;
    /* access modifiers changed from: private */
    public ImageView mCrossView;
    private Button mDeleteButton;
    private Button mForwardButton;
    private LinearLayout mForwardLayout;
    private ForwardSelectActivityListener mForwardSelectActivityListener;
    /* access modifiers changed from: private */
    public ImGroupChatFragment mFragment;
    public NoticeLayout mGroupApplyLayout;
    private InputView mInputView;
    /* access modifiers changed from: private */
    public boolean mJumpGroupAtInfoShow;
    private RelativeLayout mJumpMessageLayout;
    private TextView mJumpMessageTextView;
    /* access modifiers changed from: private */
    public boolean mJumpNewMessageShow;
    /* access modifiers changed from: private */
    public ImageView mMantleView;
    /* access modifiers changed from: private */
    public MessageRecyclerView mMessageRecyclerView;
    private NoticeLayout mNoticeLayout;
    public View mRecordingGroup;
    public ImageView mRecordingIcon;
    public TextView mRecordingTips;
    private TitleBarLayout mTitleBar;
    private TextView mTvAtCount;
    private TextView mTvAtHint;
    private Runnable mTypingRunnable = null;
    /* access modifiers changed from: private */
    public TextView mUpCancleTextView;
    /* access modifiers changed from: private */
    public TextView mUpSendTextView;
    /* access modifiers changed from: private */
    public LinearLayout mVoiceRecordingBottom;
    /* access modifiers changed from: private */
    public RelativeLayout mVoiceRecordingShortTip;
    private AnimationDrawable mVolumeAnim;
    /* access modifiers changed from: private */
    public LinearLayout mllAtLayout;
    private HashMap<String, Object> pointMap = new HashMap<>();
    private OnCustomPopActionClickListener popActionClickListener;
    /* access modifiers changed from: private */
    public HbgBaseShareProvider shareProvider;
    private TotalUnreadCountListener unreadCountListener;
    /* access modifiers changed from: private */
    public UpdateAdapterListener updateAdapterListener;

    public interface ForwardSelectActivityListener {
        void onStartForwardSelectActivity(int i11, List<TUIMessageBean> list);
    }

    public interface UpdateAdapterListener {
        void onUpdate();
    }

    public ChatView(Context context) {
        super(context);
        initViews();
    }

    public static /* synthetic */ int access$1908(ChatView chatView) {
        int i11 = chatView.currentChatUnreadCount;
        chatView.currentChatUnreadCount = i11 + 1;
        return i11;
    }

    public static /* synthetic */ int access$1910(ChatView chatView) {
        int i11 = chatView.currentChatUnreadCount;
        chatView.currentChatUnreadCount = i11 - 1;
        return i11;
    }

    /* access modifiers changed from: private */
    public List<TUIMessageBean> getNeedDeleteMsgBySeq(List<Object> list) {
        ChatPresenter chatPresenter;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0 || (chatPresenter = this.chatManager) == null) {
            return arrayList;
        }
        try {
            List<TUIMessageBean> loadedMessageInfoList = chatPresenter.getLoadedMessageInfoList();
            if (loadedMessageInfoList != null && loadedMessageInfoList.size() > 0) {
                for (int i11 = 0; i11 < list.size(); i11++) {
                    Double d11 = (Double) list.get(i11);
                    if (d11.doubleValue() != 0.0d) {
                        Iterator<TUIMessageBean> it2 = loadedMessageInfoList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            TUIMessageBean next = it2.next();
                            if (next.getV2TIMMessage() != null) {
                                if (next.getV2TIMMessage().getSeq() == ((long) d11.intValue())) {
                                    arrayList.add(next);
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e11) {
            IMLog.e(TAG, e11.getMessage());
        }
        for (int size = this.chatManager.getLoadedMessageInfoList().size() - 1; size >= 0; size--) {
            int size2 = arrayList.size() - 1;
            while (true) {
                if (size2 < 0) {
                    break;
                } else if (this.chatManager.getLoadedMessageInfoList().get(size).getId().equals(((TUIMessageBean) arrayList.get(size2)).getId())) {
                    this.chatManager.getLoadedMessageInfoList().remove(size);
                    HbChatMessageAdapter hbChatMessageAdapter = this.mAdapter;
                    if (hbChatMessageAdapter != null) {
                        hbChatMessageAdapter.onDataSourceChanged(this.chatManager.getLoadedMessageInfoList());
                        this.mAdapter.onViewNeedRefresh(5, size);
                    }
                } else {
                    size2--;
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void handlerMessageIsAtMe(TUIMessageBean tUIMessageBean) {
        List<String> groupAtUserList;
        if (tUIMessageBean != null && tUIMessageBean.getV2TIMMessage() != null && (groupAtUserList = tUIMessageBean.getV2TIMMessage().getGroupAtUserList()) != null && groupAtUserList.size() != 0) {
            this.mAtUserIdList.add(Long.valueOf(tUIMessageBean.getV2TIMMessage().getSeq()));
            for (int i11 = 0; i11 < groupAtUserList.size(); i11++) {
                if (TextUtils.equals(groupAtUserList.get(i11), V2TIMManager.getInstance().getLoginUser())) {
                    int i12 = this.atCount + 1;
                    this.atCount = i12;
                    this.isCanClearAt = true;
                    setTvAtCountText(i12);
                }
            }
        }
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
        this.popActionClickListener = new OnCustomPopActionClickListener() {
            public void onCopyClick(TUIMessageBean tUIMessageBean) {
                TUIMessageBean contentMessageBean;
                ClipboardManager clipboardManager = (ClipboardManager) ChatView.this.getContext().getSystemService("clipboard");
                if (clipboardManager != null && tUIMessageBean != null) {
                    if (tUIMessageBean instanceof TextMessageBean) {
                        if (tUIMessageBean instanceof HbShareTextMessageBean) {
                            HbShareTextMessageBean hbShareTextMessageBean = (HbShareTextMessageBean) tUIMessageBean;
                            int i11 = hbShareTextMessageBean.type;
                            if (i11 == 0) {
                                clipboardManager.setPrimaryClip(ClipData.newPlainText("message", hbShareTextMessageBean.shareText));
                            } else if (i11 == 1) {
                                clipboardManager.setPrimaryClip(ClipData.newPlainText("message", hbShareTextMessageBean.shareContent));
                            }
                            hbShareTextMessageBean.type = 0;
                        } else if (tUIMessageBean instanceof HbShareMessageBean) {
                            clipboardManager.setPrimaryClip(ClipData.newPlainText("message", ((HbShareMessageBean) tUIMessageBean).shareText));
                        } else {
                            clipboardManager.setPrimaryClip(ClipData.newPlainText("message", ((TextMessageBean) tUIMessageBean).getSelectText()));
                        }
                    } else if ((tUIMessageBean instanceof ReplyMessageBean) && (contentMessageBean = ((ReplyMessageBean) tUIMessageBean).getContentMessageBean()) != null) {
                        clipboardManager.setPrimaryClip(ClipData.newPlainText("message", contentMessageBean.getExtra()));
                    }
                    ToastUtil.toastShortMessage(ChatView.this.getResources().getString(R$string.copy_success_tip));
                }
            }

            public void onDeleteMessageClick(final TUIMessageBean tUIMessageBean) {
                new b(ChatView.this.getContext()).a().c(true).b(true).i(ChatView.this.getContext().getString(R$string.chat_delete_msg_tip)).e(0.75f).h(ChatView.this.getContext().getString(R$string.n_sure), new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        ChatView.this.deleteMessage(tUIMessageBean);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                }).g(ChatView.this.getContext().getString(R$string.n_cancel), new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                }).k();
            }

            public void onForwardMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.forwardMessage(tUIMessageBean);
            }

            public void onMultiSelectMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.multiSelectMessage(tUIMessageBean);
            }

            public void onReplyMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.replyMessage(tUIMessageBean);
            }

            public void onRevokeMessageClick(final TUIMessageBean tUIMessageBean) {
                new b(ChatView.this.getContext()).a().c(true).b(true).d(ChatView.this.getContext().getString(R$string.n_group_im_release_message)).e(0.75f).h(ChatView.this.getContext().getString(R$string.sure), new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        ChatView.this.revokeMessage(tUIMessageBean);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                }).g(ChatView.this.getContext().getString(R$string.cancel), new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                }).k();
            }

            public void onSendMessageClick(TUIMessageBean tUIMessageBean, boolean z11) {
                ChatView.this.sendMessage(tUIMessageBean, z11);
            }

            public void onTranslateMessageClick(final TUIMessageBean tUIMessageBean, int i11) {
                if (tUIMessageBean != null) {
                    String access$000 = ChatView.TAG;
                    TUIChatLog.d(access$000, "onTranslateMessageClick " + tUIMessageBean.getClass().getName());
                    if (tUIMessageBean instanceof HbTextMessageBean) {
                        HbTextMessageBean hbTextMessageBean = (HbTextMessageBean) tUIMessageBean;
                        String access$0002 = ChatView.TAG;
                        TUIChatLog.d(access$0002, "onTranslateMessageClick text:" + hbTextMessageBean.getText());
                        ChatView.this.liveImPresenter.o(hbTextMessageBean.getText(), new a<TranslateBean>() {
                            public void onFailed(int i11, String str) {
                                String access$000 = ChatView.TAG;
                                TUIChatLog.d(access$000, "onTranslateMessageClick  code:" + i11 + "   message:" + str);
                            }

                            public void onSuccess(TranslateBean translateBean) {
                                HbChatMessageAdapter hbChatMessageAdapter;
                                if ((ChatView.this.getContext() instanceof Activity) && !((Activity) ChatView.this.getContext()).isFinishing() && translateBean != null && (hbChatMessageAdapter = ChatView.this.mAdapter) != null) {
                                    TUIMessageBean item = hbChatMessageAdapter.getItem(hbChatMessageAdapter.getMessagePosition(tUIMessageBean));
                                    if (item instanceof HbTextMessageBean) {
                                        ((HbTextMessageBean) item).setTranslateText(translateBean.getContent());
                                        HbChatMessageAdapter hbChatMessageAdapter2 = ChatView.this.mAdapter;
                                        hbChatMessageAdapter2.notifyItemChanged(hbChatMessageAdapter2.getMessagePosition(tUIMessageBean));
                                    }
                                }
                            }
                        });
                    }
                }
            }
        };
        getMessageLayout().setPopActionClickListener(this.popActionClickListener);
        getMessageLayout().setLoadMoreMessageHandler(new MessageRecyclerView.OnLoadMoreHandler() {
            public void displayBackToLastMessage(boolean z11) {
                if (!ChatView.this.mJumpNewMessageShow) {
                    if (z11) {
                        HbChatMessageAdapter hbChatMessageAdapter = ChatView.this.mAdapter;
                        if (hbChatMessageAdapter != null) {
                            TUIMessageBean tUIMessageBean = null;
                            int itemCount = hbChatMessageAdapter.getItemCount() - 1;
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
                ChatView.this.getInputLayout().hideSoftInput();
            }
        });
        getInputLayout().setChatInputHandler(new InputView.ChatInputHandler() {
            private void cancelRecording() {
                ChatView.this.post(new Runnable() {
                    public void run() {
                        AnonymousClass19.this.cancelShow();
                        ChatView.this.mRecordingGroup.setBackgroundResource(R$drawable.group_chat_voice_input_red);
                        ChatView.this.mRecordingTips.setText(ServiceInitializer.getAppContext().getString(R$string.up_cancle_send));
                    }
                });
            }

            /* access modifiers changed from: private */
            public void cancelShow() {
                ChatView.this.mCrossView.setImageResource(R$drawable.cross_white);
                ChatView.this.mUpCancleTextView.setVisibility(0);
                ChatView.this.mUpSendTextView.setVisibility(8);
                ChatView.this.mVoiceRecordingShortTip.setVisibility(8);
            }

            /* access modifiers changed from: private */
            public void recordShow() {
                ChatView.this.mCrossView.setImageResource(R$drawable.cross_black);
                ChatView.this.mUpCancleTextView.setVisibility(8);
                ChatView.this.mUpSendTextView.setVisibility(0);
                ChatView.this.mVoiceRecordingShortTip.setVisibility(8);
            }

            private void startRecording() {
                ChatView.this.post(new Runnable() {
                    public void run() {
                        AudioPlayer.getInstance().stopPlay();
                        ChatView.this.mMantleView.setVisibility(0);
                        ChatView.this.mVoiceRecordingBottom.setVisibility(0);
                        ChatView.this.mRecordingGroup.setVisibility(0);
                        ChatView.this.mRecordingGroup.setBackgroundResource(R$drawable.group_chat_voice_input_blue);
                        AnonymousClass19.this.recordShow();
                        com.bumptech.glide.a.v(ChatView.this.mRecordingIcon.getContext()).o(Integer.valueOf(R$drawable.group_chat_voice_input)).D0(ChatView.this.mRecordingIcon);
                        ChatView.this.mRecordingTips.setTextColor(-1);
                        ChatView.this.mRecordingTips.setText(ServiceInitializer.getAppContext().getString(R$string.down_cancle_send));
                    }
                });
            }

            private void stopAbnormally(final int i11) {
                ChatView.this.postDelayed(new Runnable() {
                    public void run() {
                        ChatView.this.mRecordingTips.setTextColor(-1);
                        if (i11 == 4) {
                            ChatView.this.mVoiceRecordingShortTip.setVisibility(0);
                        } else {
                            ChatView.this.mRecordingTips.setText(ServiceInitializer.getAppContext().getString(R$string.record_fail));
                        }
                        ChatView.this.mVoiceRecordingShortTip.setVisibility(0);
                    }
                }, 500);
                ChatView.this.postDelayed(new Runnable() {
                    public void run() {
                        ChatView.this.mRecordingGroup.setVisibility(8);
                        ChatView.this.mVoiceRecordingBottom.setVisibility(8);
                        ChatView.this.mVoiceRecordingShortTip.setVisibility(8);
                        ChatView.this.mMantleView.setVisibility(8);
                    }
                }, 1000);
            }

            private void stopRecording() {
                ChatView.this.postDelayed(new Runnable() {
                    public void run() {
                        ChatView.this.mRecordingGroup.setVisibility(8);
                        ChatView.this.mVoiceRecordingBottom.setVisibility(8);
                        ChatView.this.mMantleView.setVisibility(8);
                    }
                }, 500);
            }

            public void onInputAreaClick() {
                ChatView.this.post(new Runnable() {
                    public void run() {
                        ChatView.this.scrollToEnd();
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
        });
    }

    private void initViews() {
        this.imGroupMessageListener = new BusinessCallbacks.ImGroupMessageListener() {
            public /* synthetic */ void onGroupMemberKick() {
                com.tencent.qcloud.tuikit.tuichat.b.a(this);
            }

            public void onGroupReceiveCustomMsg(TUIMessageBean tUIMessageBean) {
                try {
                    TUIBarrageMessage tUIBarrageMessage = (TUIBarrageMessage) new Gson().fromJson(new String(tUIMessageBean.getV2TIMMessage().getCustomElem().getData()), TUIBarrageMessage.class);
                    if (TextUtils.equals(tUIBarrageMessage.businessID, MessageBusinessID.MSG_BUSINESS_ID_NOTIFICATION.getValue())) {
                        String access$000 = ChatView.TAG;
                        TUIChatLog.d(access$000, "onGroupReceiveCustomMsg notice map:" + tUIBarrageMessage.data);
                        if (tUIBarrageMessage.data != null) {
                            TUIChatLog.d(ChatView.TAG, "onGroupReceiveCustomMsg notice message.data");
                            HbNoticeMessageBean hbNoticeMessageBean = new HbNoticeMessageBean();
                            hbNoticeMessageBean.setV2TIMMessage(tUIMessageBean.getV2TIMMessage());
                            Object obj = tUIBarrageMessage.data.get(InnerShareParams.EXT_INFO);
                            if (obj instanceof Map) {
                                Map map = (Map) obj;
                                if ((map.get(RemoteMessageConst.NOTIFICATION) instanceof String) && !TextUtils.isEmpty((CharSequence) map.get(RemoteMessageConst.NOTIFICATION))) {
                                    hbNoticeMessageBean.setNoticeMsg((String) map.get(RemoteMessageConst.NOTIFICATION));
                                    if (map.get("groupId") instanceof String) {
                                        hbNoticeMessageBean.setGroupId((String) map.get("groupId"));
                                    }
                                    ChatView.this.chatManager.addMessageInfo(hbNoticeMessageBean);
                                }
                            }
                            if (ChatView.this.mFragment != null && !ChatView.this.mFragment.isDetached()) {
                                ChatView.this.mFragment.updateNoticeView();
                            }
                        }
                    } else if (TextUtils.equals(tUIBarrageMessage.businessID, MessageBusinessID.MSG_BUSINESS_ID_DELETE_USER_MESSAGE.getValue())) {
                        String access$0002 = ChatView.TAG;
                        TUIChatLog.d(access$0002, "onGroupReceiveCustomMsg notice MSG_BUSINESS_ID_DELETE_USER_MESSAGE收到删除自定义消息 map:" + tUIBarrageMessage.data);
                        if (tUIBarrageMessage.data != null) {
                            String access$0003 = ChatView.TAG;
                            TUIChatLog.d(access$0003, "onGroupReceiveCustomMsg notice message.data deleteUserId:" + tUIMessageBean.getSender());
                            Map<String, Object> map2 = tUIBarrageMessage.data;
                            if (map2 != null) {
                                Object obj2 = map2.get(InnerShareParams.EXT_INFO);
                                if (obj2 instanceof Map) {
                                    Object obj3 = ((Map) obj2).get("msgSeqList");
                                    if (obj3 instanceof List) {
                                        ChatView.this.chatManager.deleteMessageInfos(ChatView.this.getNeedDeleteMsgBySeq((List) obj3));
                                    }
                                }
                            }
                        }
                    } else if (TextUtils.equals(tUIBarrageMessage.businessID, MessageBusinessID.MSG_BUSINESS_ID_HUOBI_GROUP_BUSINESS_SHARE.getValue())) {
                        if (tUIBarrageMessage.data != null) {
                            HbShareMessageBean hbShareMessageBean = new HbShareMessageBean();
                            hbShareMessageBean.setV2TIMMessage(tUIMessageBean.getV2TIMMessage());
                            if (hbShareMessageBean.getBusinessID().equals("huobi_group_business_share_prime")) {
                                HbSharePrimeMessageBean hbSharePrimeMessageBean = new HbSharePrimeMessageBean();
                                hbSharePrimeMessageBean.setV2TIMMessage(tUIMessageBean.getV2TIMMessage());
                                ChatView.this.chatManager.addMessageInfo(hbSharePrimeMessageBean);
                                return;
                            }
                            ChatView.this.chatManager.addMessageInfo(hbShareMessageBean);
                        }
                    } else if (TextUtils.equals(tUIBarrageMessage.businessID, MessageBusinessID.MSG_BUSINESS_ID_HUOBI_GROUP_BUSINESS_SHARE_TEXT.getValue())) {
                        if (tUIBarrageMessage.data != null) {
                            HbShareTextMessageBean hbShareTextMessageBean = new HbShareTextMessageBean();
                            hbShareTextMessageBean.setV2TIMMessage(tUIMessageBean.getV2TIMMessage());
                            if (hbShareTextMessageBean.getBusinessID().equals("huobi_group_business_share_prime")) {
                                HbSharePrimeMessageBean hbSharePrimeMessageBean2 = new HbSharePrimeMessageBean();
                                hbSharePrimeMessageBean2.setV2TIMMessage(tUIMessageBean.getV2TIMMessage());
                                ChatView.this.chatManager.addMessageInfo(hbSharePrimeMessageBean2);
                                return;
                            }
                            ChatView.this.chatManager.addMessageInfo(hbShareTextMessageBean);
                        }
                    } else if (TextUtils.equals(tUIBarrageMessage.businessID, MessageBusinessID.MSG_BUSINESS_ID_HUOBI_ACCOUNT_MANAGER_UNREAD.getValue())) {
                        ChatView.this.chatManager.addMessageInfo(new HbAccountManagerUnreadBean());
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        };
        HbGroupChatManager.getInstance().addImGroupMessageListener(this.imGroupMessageListener);
        LinearLayout.inflate(getContext(), R$layout.chat_layout, this);
        this.mTitleBar = (TitleBarLayout) findViewById(R$id.chat_title_bar);
        MessageRecyclerView messageRecyclerView = (MessageRecyclerView) findViewById(R$id.chat_message_layout);
        this.mMessageRecyclerView = messageRecyclerView;
        com.hbg.module.libkt.base.ext.b.f(messageRecyclerView);
        InputView inputView = (InputView) findViewById(R$id.chat_input_layout);
        this.mInputView = inputView;
        inputView.setChatLayout(this);
        this.mRecordingGroup = findViewById(R$id.voice_recording_view);
        this.mRecordingIcon = (ImageView) findViewById(R$id.recording_icon);
        this.mRecordingTips = (TextView) findViewById(R$id.recording_tips);
        this.mGroupApplyLayout = (NoticeLayout) findViewById(R$id.chat_group_apply_layout);
        this.mNoticeLayout = (NoticeLayout) findViewById(R$id.chat_notice_layout);
        this.mForwardLayout = (LinearLayout) findViewById(R$id.forward_layout);
        this.mForwardButton = (Button) findViewById(R$id.forward_button);
        this.mDeleteButton = (Button) findViewById(R$id.delete_button);
        this.mJumpMessageLayout = (RelativeLayout) findViewById(R$id.jump_message_layout);
        this.mJumpMessageTextView = (TextView) findViewById(R$id.jump_message_content);
        this.mllAtLayout = (LinearLayout) findViewById(R$id.ll_at_layout);
        this.mTvAtHint = (TextView) findViewById(R$id.tv_at_hint);
        this.mTvAtCount = (TextView) findViewById(R$id.tv_at_count);
        this.ivAtClose = (ImageView) findViewById(R$id.ivAtClose);
        TextView textView = this.mTvAtHint;
        textView.setText(TIMMentionEditText.TIM_MENTION_TAG + getContext().getString(R$string.n_im_group_me));
        this.mllAtLayout.setVisibility(8);
        this.ivAtClose.setVisibility(8);
        this.ivAtClose.setOnClickListener(new b(this));
        this.mllAtLayout.setOnClickListener(new a(this));
        this.mVoiceRecordingBottom = (LinearLayout) findViewById(R$id.voice_recording_bottom);
        this.mVoiceRecordingShortTip = (RelativeLayout) findViewById(R$id.voice_recording_short_tip);
        this.mCrossView = (ImageView) findViewById(R$id.cross_iv);
        this.mMantleView = (ImageView) findViewById(R$id.mantle_iv);
        this.mUpCancleTextView = (TextView) findViewById(R$id.up_cancle_tv);
        this.mUpSendTextView = (TextView) findViewById(R$id.up_send_tv);
        this.mJumpNewMessageShow = false;
        hideJumpMessageLayouts();
        this.mTitleBar.getMiddleTitle().setEllipsize(TextUtils.TruncateAt.END);
        this.mTitleBar.setLeftIcon(R$drawable.icon_group_back);
        this.mMessageRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            }

            public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
                int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) ChatView.this.mMessageRecyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                if (findLastCompletelyVisibleItemPosition == ChatView.this.mAdapter.getItemCount() - 1 || findLastCompletelyVisibleItemPosition == -1) {
                    ChatView.this.hideJumpMessageLayouts();
                }
            }
        });
        try {
            this.shareProvider = (HbgBaseShareProvider) b2.a.d().a("/provider/share/h5").navigation();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initActions$2(TUIMessageBean tUIMessageBean) {
        this.popActionClickListener.onDeleteMessageClick(tUIMessageBean);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initActions$3(TUIMessageBean tUIMessageBean) {
        this.popActionClickListener.onCopyClick(tUIMessageBean);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initActions$4(TUIMessageBean tUIMessageBean) {
        this.popActionClickListener.onRevokeMessageClick(tUIMessageBean);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initActions$5(TUIMessageBean tUIMessageBean, int i11) {
        this.popActionClickListener.onTranslateMessageClick(tUIMessageBean, i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initViews$0(View view) {
        this.atCount = 0;
        this.mAtUserIdList.clear();
        this.mllAtLayout.setVisibility(8);
        this.ivAtClose.setVisibility(8);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initViews$1(View view) {
        q.a("webclick_app_activity", new HashMap<String, Object>() {
            {
                put("business_category", "chatdetail");
                put("group_id", ChatView.this.mChatInfo.getId());
            }
        });
        List<Long> list = this.mAtUserIdList;
        if (list != null && !list.isEmpty()) {
            this.atCount--;
            this.atClickCount++;
            List<Long> list2 = this.mAtUserIdList;
            long longValue = list2.get(list2.size() - 1).longValue();
            this.mAdapter.atSeq = longValue;
            this.chatManager.loadAtMessage(longValue, (String) null);
            List<Long> list3 = this.mAtUserIdList;
            list3.remove(list3.size() - 1);
            setTvAtCountText(this.atCount);
            if (this.atClickCount >= 3) {
                this.ivAtClose.setVisibility(0);
            }
        }
        if (this.atCount == 0) {
            this.ivAtClose.setVisibility(8);
            this.mllAtLayout.setVisibility(8);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setPrimeAble$6() {
        if (this.isGroup) {
            q.a("APP_LIVE_group_more", this.pointMap);
            findViewById(R$id.tvPrimeTips).setVisibility(8);
        }
    }

    private void loadApplyList() {
        this.chatManager.loadApplyList(new IUIKitCallback<List<GroupApplyInfo>>() {
            public void onError(String str, int i11, String str2) {
            }

            public void onSuccess(List<GroupApplyInfo> list) {
                if (list != null && list.size() > 0) {
                    ChatView.this.mGroupApplyLayout.getContent().setText(ChatView.this.getContext().getString(R$string.group_apply_tips, new Object[]{Integer.valueOf(list.size())}));
                    ChatView.this.mGroupApplyLayout.setVisibility(0);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void locateOriginMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            ToastUtil.toastShortMessage(getContext().getString(R$string.locate_origin_msg_failed_tip));
            return;
        }
        this.chatManager.locateMessage(str, new IUIKitCallback<Void>() {
            public void onError(String str, int i11, String str2) {
                ChatView.this.hideJumpMessageLayouts();
                ToastUtil.toastShortMessage(ChatView.this.getContext().getString(R$string.locate_origin_msg_failed_tip));
            }

            public void onSuccess(Void voidR) {
                ChatView.this.hideJumpMessageLayouts();
            }
        });
        hideJumpMessageLayouts();
    }

    /* access modifiers changed from: private */
    public void locateOriginMessageBySeq(long j11) {
        this.chatManager.locateMessageBySeq(this.mChatInfo.getId(), j11, new IUIKitCallback<Void>() {
            public void onError(String str, int i11, String str2) {
                ChatView.this.hideJumpMessageLayouts();
                ToastUtil.toastShortMessage(ChatView.this.getContext().getString(R$string.locate_origin_msg_failed_tip));
            }

            public void onSuccess(Void voidR) {
                ChatView.this.hideJumpMessageLayouts();
            }
        });
    }

    /* access modifiers changed from: private */
    public void resetForwardState(String str) {
        HbChatMessageAdapter hbChatMessageAdapter = this.mAdapter;
        if (hbChatMessageAdapter != null) {
            hbChatMessageAdapter.setShowMultiSelectCheckBox(false);
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
    }

    private void setChatHandler() {
        AnonymousClass14 r02 = new ChatPresenter.ChatNotifyHandler() {
            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$updateAdapter$0(int i11) {
                ChatView.this.getMessageLayout().smoothScrollToPosition(i11);
            }

            public void addMessageAfterPreProcess(TUIMessageBean tUIMessageBean) {
                boolean z11;
                String str;
                String str2;
                if (tUIMessageBean != null) {
                    if (!TextUtils.isEmpty(tUIMessageBean.getGroupId())) {
                        str2 = tUIMessageBean.getGroupId();
                        str = null;
                        z11 = true;
                    } else if (!TextUtils.isEmpty(tUIMessageBean.getUserId())) {
                        str = tUIMessageBean.getUserId();
                        str2 = null;
                        z11 = false;
                    } else {
                        return;
                    }
                    if (ChatView.this.chatManager.isChatFragmentShow()) {
                        tUIMessageBean.setRead(true);
                    }
                    ChatView.this.chatManager.addMessageInfo(tUIMessageBean);
                    ChatView.this.handlerMessageIsAtMe(tUIMessageBean);
                    if (!ChatView.this.chatManager.isChatFragmentShow()) {
                        return;
                    }
                    if (ChatView.this.mMessageRecyclerView == null || !ChatView.this.mMessageRecyclerView.isDisplayJumpMessageLayout()) {
                        TUIMessageBean unused = ChatView.this.mCacheNewMessage = null;
                        int unused2 = ChatView.this.currentChatUnreadCount = 0;
                        if (z11) {
                            ChatView.this.chatManager.limitReadReport(str2, true);
                        } else {
                            ChatView.this.chatManager.limitReadReport(str, false);
                        }
                    } else if (tUIMessageBean.getStatus() != 275) {
                        ChatView.access$1908(ChatView.this);
                        if (ChatView.this.mCacheNewMessage == null) {
                            TUIMessageBean unused3 = ChatView.this.mCacheNewMessage = tUIMessageBean;
                        }
                        ChatView.this.mMessageRecyclerView.displayBackToNewMessage(true, ChatView.this.mCacheNewMessage.getId(), ChatView.this.currentChatUnreadCount);
                    } else if (tUIMessageBean.getStatus() == 275) {
                        ChatView.access$1910(ChatView.this);
                        if (ChatView.this.currentChatUnreadCount == 0) {
                            ChatView.this.mMessageRecyclerView.displayBackToNewMessage(false, "", 0);
                            TUIMessageBean unused4 = ChatView.this.mCacheNewMessage = null;
                            return;
                        }
                        ChatView.this.mMessageRecyclerView.displayBackToNewMessage(true, ChatView.this.mCacheNewMessage.getId(), ChatView.this.currentChatUnreadCount);
                    }
                }
            }

            public void clearMessage() {
                ChatView.this.chatManager.getLoadedMessageInfoList().clear();
                ChatView.this.mAdapter.onViewNeedRefresh(0, 0);
            }

            public void clearMessageAndReLoad() {
                if (!ChatView.this.chatManager.isHaveMoreNewMessage) {
                    ChatView.this.mAdapter.onScrollToEnd();
                    return;
                }
                ChatView.this.chatManager.getLoadedMessageInfoList().clear();
                ChatView.this.mAdapter.onViewNeedRefresh(0, 0);
                ChatView.this.chatManager.loadMessage(0, (TUIMessageBean) null);
            }

            public void onApplied(int i11) {
                ChatView.this.onApplied(i11);
            }

            public void onExitChat(String str) {
                ChatView.this.onExitChat();
            }

            public /* synthetic */ void onFriendFaceUrlChanged(String str) {
                com.tencent.qcloud.tuikit.tuichat.presenter.a.f(this, str);
            }

            public void onFriendNameChanged(String str) {
                ChatView.this.onFriendNameChanged(str);
            }

            public /* synthetic */ void onGroupFaceUrlChanged(String str) {
                com.tencent.qcloud.tuikit.tuichat.presenter.a.h(this, str);
            }

            public void onGroupForceExit() {
                ChatView.this.onExitChat();
            }

            public void onGroupNameChanged(String str) {
                ChatView.this.onGroupNameChanged(str);
            }

            public void onReceiveCustomMessage(TUIMessageBean tUIMessageBean) {
            }

            public void resetCurrentChatUnreadCount() {
                int unused = ChatView.this.currentChatUnreadCount = 0;
                TUIMessageBean unused2 = ChatView.this.mCacheNewMessage = null;
            }

            public void updateAdapter(int i11, int i12) {
                ChatView chatView = ChatView.this;
                if (chatView.mAdapter != null) {
                    if (chatView.updateAdapterListener != null) {
                        ChatView.this.updateAdapterListener.onUpdate();
                    }
                    List<TUIMessageBean> loadedMessageInfoList = ChatView.this.chatManager.getLoadedMessageInfoList();
                    ChatView.this.mAdapter.onDataSourceChanged(loadedMessageInfoList);
                    ChatView.this.mAdapter.onViewNeedRefresh(i11, i12);
                    if (ChatView.this.isGroup && ChatView.this.firstLoadList && !com.hbg.module.libkt.base.ext.b.x(ChatView.this.mChatInfo.getMsgId()) && !com.hbg.module.libkt.base.ext.b.w(loadedMessageInfoList)) {
                        int i13 = 0;
                        while (true) {
                            if (i13 >= loadedMessageInfoList.size()) {
                                break;
                            } else if (String.valueOf(loadedMessageInfoList.get(i13).getV2TIMMessage().getSeq()).equals(ChatView.this.mChatInfo.getMsgId())) {
                                ChatView.this.getMessageLayout().postDelayed(new j(this, i13), 300);
                                break;
                            } else {
                                i13++;
                            }
                        }
                    }
                    boolean unused = ChatView.this.firstLoadList = false;
                }
            }

            public void updateAdapter(int i11, TUIMessageBean tUIMessageBean) {
                ChatView chatView = ChatView.this;
                if (chatView.mAdapter != null) {
                    if (chatView.updateAdapterListener != null) {
                        ChatView.this.updateAdapterListener.onUpdate();
                    }
                    ChatView chatView2 = ChatView.this;
                    chatView2.mAdapter.onDataSourceChanged(chatView2.chatManager.getLoadedMessageInfoList());
                    ChatView.this.mAdapter.onViewNeedRefresh(i11, tUIMessageBean);
                }
            }
        };
        this.chatNotifyHandler = r02;
        this.chatManager.setChatNotifyHandler(r02);
    }

    private void setTitleBarWhenMultiSelectMessage() {
        getTitleBar().getRightGroup().setVisibility(8);
        getTitleBar().getLeftGroup().setVisibility(0);
        getTitleBar().getLeftIcon().setVisibility(8);
        final CharSequence text = getTitleBar().getLeftTitle().getText();
        getTitleBar().setTitle(getContext().getString(R$string.cancel), ITitleBarLayout.Position.LEFT);
        getTitleBar().setOnLeftClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ChatView.this.resetForwardState(text.toString());
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        getForwardLayout().setVisibility(0);
        getForwardButton().setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ChatView.this.showForwardDialog(true);
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
        unreadCountTextView.setPaintColor(getResources().getColor(TUIThemeManager.getAttrResId(getContext(), R$attr.chat_unread_dot_bg_color)));
        unreadCountTextView.setTextColor(getResources().getColor(TUIThemeManager.getAttrResId(getContext(), R$attr.chat_unread_dot_text_color)));
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
    public void setTvAtCountText(int i11) {
        String str;
        LinearLayout linearLayout = this.mllAtLayout;
        if (linearLayout != null && i11 > 0) {
            linearLayout.setVisibility(0);
        }
        if (this.mTvAtCount != null) {
            if (i11 > 99) {
                str = "...";
            } else {
                str = String.valueOf(i11);
            }
            this.mTvAtCount.setText(str);
        }
    }

    /* access modifiers changed from: private */
    public void showForwardDialog(boolean z11) {
        HbChatMessageAdapter hbChatMessageAdapter = this.mAdapter;
        if (hbChatMessageAdapter != null) {
            final ArrayList<TUIMessageBean> selectedItem = hbChatMessageAdapter.getSelectedItem();
            if (selectedItem == null || selectedItem.isEmpty()) {
                ToastUtil.toastShortMessage(getContext().getString(R$string.forward_tip));
            } else if (checkFailedMessageInfos(selectedItem)) {
                ToastUtil.toastShortMessage(getContext().getString(R$string.forward_failed_tip));
            } else {
                if (!z11) {
                    this.mAdapter.setShowMultiSelectCheckBox(false);
                }
                final Dialog dialog = new Dialog(getContext(), R$style.BottomDialog);
                View inflate = LayoutInflater.from(getContext()).inflate(R$layout.forward_dialog_layout, (ViewGroup) null);
                dialog.setContentView(inflate);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) inflate.getLayoutParams();
                marginLayoutParams.width = getResources().getDisplayMetrics().widthPixels - 8;
                inflate.setLayoutParams(marginLayoutParams);
                dialog.getWindow().setGravity(80);
                dialog.getWindow().setWindowAnimations(R$style.BottomDialog_Animation);
                dialog.show();
                inflate.findViewById(R$id.forward_one_by_one).setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        if (selectedItem.size() > 30) {
                            ChatView.this.showForwardLimitDialog(dialog, selectedItem);
                        } else {
                            dialog.dismiss();
                            ChatView.this.startSelectForwardActivity(0, selectedItem);
                            ChatView.this.resetForwardState("");
                        }
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
                inflate.findViewById(R$id.forward_merge).setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        dialog.dismiss();
                        ChatView.this.startSelectForwardActivity(1, selectedItem);
                        ChatView.this.resetForwardState("");
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
                inflate.findViewById(R$id.cancel_action).setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        dialog.dismiss();
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void showForwardLimitDialog(final Dialog dialog, final List<TUIMessageBean> list) {
        new b(getContext()).a().c(true).b(true).i(getContext().getString(R$string.forward_oneByOne_limit_number_tip)).e(0.75f).h(getContext().getString(R$string.forward_mode_merge), new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                dialog.dismiss();
                ChatView.this.startSelectForwardActivity(1, list);
                ChatView.this.resetForwardState("");
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }).g(getContext().getString(R$string.cancel), new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }).k();
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

    public boolean checkFailedMessage(List<Integer> list) {
        return this.chatManager.checkFailedMessages(list);
    }

    public boolean checkFailedMessageInfos(List<TUIMessageBean> list) {
        return this.chatManager.checkFailedMessageInfos(list);
    }

    public void deleteMessage(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean != null) {
            ChatInfo chatInfo = this.mChatInfo;
            if ((chatInfo instanceof GroupInfo) && (this.chatManager instanceof HbGroupChatManager) && (((GroupInfo) chatInfo).isOwner() || ((HbGroupChatManager) this.chatManager).isGroupAdmin(V2TIMManager.getInstance().getLoginUser()))) {
                f fVar = this.liveImPresenter;
                String groupId = tUIMessageBean.getGroupId();
                fVar.w(groupId, "" + tUIMessageBean.getV2TIMMessage().getSeq());
            }
            this.chatManager.deleteMessage(tUIMessageBean);
        }
    }

    public void deleteMessageInfos(List<TUIMessageBean> list) {
        this.chatManager.deleteMessageInfos(list);
    }

    public void deleteMessages(List<Integer> list) {
        this.chatManager.deleteMessages(list);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        HbChatMessageAdapter hbChatMessageAdapter;
        if (motionEvent.getAction() == 0 && (hbChatMessageAdapter = this.mAdapter) != null) {
            hbChatMessageAdapter.resetSelectableText();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void displayBackToAtMessages(final V2TIMGroupAtInfo v2TIMGroupAtInfo) {
        this.mJumpGroupAtInfoShow = true;
        this.mJumpMessageLayout.setVisibility(0);
        if (v2TIMGroupAtInfo.getAtType() == 2) {
            this.mJumpMessageTextView.setText(getContext().getString(R$string.back_to_atmessage_all));
        } else {
            this.mJumpMessageTextView.setText(getContext().getString(R$string.back_to_atmessage_me));
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
        this.mJumpMessageTextView.setText(getContext().getString(R$string.n_im_check_new_msg));
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
        this.mJumpMessageTextView.setText(String.format(getContext().getString(R$string.n_im_new_msg_tips), new Object[]{String.valueOf(i11)}));
        this.mJumpMessageLayout.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ChatView.this.locateOriginMessage(str);
                ChatView.this.chatManager.markMessageAsRead(ChatView.this.mChatInfo);
                boolean unused = ChatView.this.mJumpNewMessageShow = false;
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    public void exitChat() {
        getTitleBar().getMiddleTitle().removeCallbacks(this.mTypingRunnable);
        AudioPlayer.getInstance().stopRecord();
        AudioPlayer.getInstance().stopPlay();
        this.chatManager.markMessageAsRead(this.mChatInfo);
    }

    public void forwardMessage(TUIMessageBean tUIMessageBean) {
        if (this.mAdapter != null) {
            this.mInputView.hideSoftInput();
            this.mAdapter.setItemChecked(tUIMessageBean.getId(), true);
            this.mAdapter.notifyDataSetChanged();
            showForwardDialog(false);
        }
    }

    public ChatInfo getChatInfo() {
        return this.mChatInfo;
    }

    public void getConversationMessageList(String str) {
        new ArrayList().add(str);
        V2TIMManager.getConversationManager().getConversation(str, new V2TIMValueCallback<V2TIMConversation>() {
            public void onError(int i11, String str) {
            }

            public void onSuccess(V2TIMConversation v2TIMConversation) {
                if (v2TIMConversation != null && v2TIMConversation.getGroupAtInfoList() != null) {
                    List<V2TIMGroupAtInfo> groupAtInfoList = v2TIMConversation.getGroupAtInfoList();
                    ChatView.this.mAtUserIdList.clear();
                    for (int i11 = 0; i11 < groupAtInfoList.size(); i11++) {
                        ChatView.this.mAtUserIdList.add(Long.valueOf(groupAtInfoList.get(i11).getSeq()));
                    }
                    boolean unused = ChatView.this.isCanClearAt = true;
                    if (groupAtInfoList.size() == 0) {
                        ChatView.this.mllAtLayout.setVisibility(8);
                        ChatView.this.ivAtClose.setVisibility(8);
                    } else {
                        int unused2 = ChatView.this.atCount = groupAtInfoList.size();
                        if (ChatView.this.mllAtLayout != null) {
                            int unused3 = ChatView.this.atClickCount = 0;
                            ChatView.this.mllAtLayout.setVisibility(0);
                        }
                        ChatView.this.setTvAtCountText(groupAtInfoList.size());
                    }
                    q.a("pageview_app_activity", new HashMap<String, Object>() {
                        {
                            put("business_category", "chatdetail");
                            put("group_id", ChatView.this.mChatInfo.getId());
                            put("button_mention", Integer.valueOf(ChatView.this.atCount > 0 ? 1 : 0));
                        }
                    });
                }
            }
        });
    }

    public Button getDeleteButton() {
        return this.mDeleteButton;
    }

    public Button getForwardButton() {
        return this.mForwardButton;
    }

    public LinearLayout getForwardLayout() {
        return this.mForwardLayout;
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

    public void handlerAtCount() {
        HbTextMessageBean hbTextMessageBean;
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mMessageRecyclerView.getLayoutManager();
        int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        if (findFirstCompletelyVisibleItemPosition < this.mAdapter.getItemCount() && findLastCompletelyVisibleItemPosition < this.mAdapter.getItemCount()) {
            int i11 = 0;
            while (findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                if ((this.mAdapter.getItem(findFirstCompletelyVisibleItemPosition) instanceof HbTextMessageBean) && (hbTextMessageBean = (HbTextMessageBean) this.mAdapter.getItem(findFirstCompletelyVisibleItemPosition)) != null && hbTextMessageBean.getV2TIMMessage() != null && hbTextMessageBean.getV2TIMMessage().getGroupAtUserList() != null && hbTextMessageBean.getV2TIMMessage().getGroupAtUserList().size() > 0 && !hbTextMessageBean.isCount()) {
                    i11++;
                    if (this.isCanClearAt) {
                        hbTextMessageBean.setCount(true);
                    }
                }
                findFirstCompletelyVisibleItemPosition++;
            }
            if (!this.isCanClearAt) {
                this.isCanClearAt = true;
                return;
            }
            int i12 = this.atCount - i11;
            this.atCount = i12;
            if (i12 - i11 <= 0) {
                this.atCount = 0;
                this.mllAtLayout.setVisibility(8);
                this.ivAtClose.setVisibility(8);
                return;
            }
            this.atClickCount = 0;
            this.mllAtLayout.setVisibility(0);
            setTvAtCountText(this.atCount);
        }
    }

    public void hideBackToAtMessages() {
        if (this.mJumpGroupAtInfoShow) {
            this.mJumpGroupAtInfoShow = false;
            hideJumpMessageLayouts();
        }
    }

    public void hideJumpMessageLayouts() {
        this.mJumpMessageLayout.setVisibility(4);
    }

    public ArrayList<ChatPopMenuAction> initActions(TUIMessageBean tUIMessageBean, View view, int i11) {
        HbChatMessageAdapter hbChatMessageAdapter;
        ArrayList<ChatPopMenuAction> arrayList = new ArrayList<>();
        arrayList.clear();
        if (tUIMessageBean.getStatus() != 3) {
            ChatPopMenuAction chatPopMenuAction = new ChatPopMenuAction();
            chatPopMenuAction.setActionName(getContext().getString(R$string.n_login_delete));
            chatPopMenuAction.setActionIcon(R$drawable.im_icon_pop_delete);
            chatPopMenuAction.setActionClickListener(new d(this, tUIMessageBean));
            arrayList.add(chatPopMenuAction);
            boolean z11 = view.getTag() instanceof Boolean ? !((Boolean) view.getTag()).booleanValue() : true;
            if (tUIMessageBean.getMsgType() == 1 && z11) {
                ChatPopMenuAction chatPopMenuAction2 = new ChatPopMenuAction();
                chatPopMenuAction2.setActionName(getContext().getString(R$string.n_im_msg_copy));
                chatPopMenuAction2.setActionIcon(R$drawable.im_icon_pop_copy);
                chatPopMenuAction2.setActionClickListener(new e(this, tUIMessageBean));
                arrayList.add(chatPopMenuAction2);
            }
            if (tUIMessageBean.isSelf() && (System.currentTimeMillis() / 1000) - tUIMessageBean.getMessageTime() <= ((long) dd.b.f22740a.c())) {
                ChatPopMenuAction chatPopMenuAction3 = new ChatPopMenuAction();
                chatPopMenuAction3.setActionName(getContext().getString(R$string.n_im_msg_back));
                chatPopMenuAction3.setActionIcon(R$drawable.im_icon_pop_revoke);
                chatPopMenuAction3.setActionClickListener(new f(this, tUIMessageBean));
                arrayList.add(chatPopMenuAction3);
            }
            if (!tUIMessageBean.isSelf() && (tUIMessageBean instanceof HbTextMessageBean) && (hbChatMessageAdapter = this.mAdapter) != null) {
                TUIMessageBean item = hbChatMessageAdapter.getItem(i11);
                if ((item instanceof HbTextMessageBean) && TextUtils.isEmpty(((HbTextMessageBean) item).getTranslateText())) {
                    ChatPopMenuAction chatPopMenuAction4 = new ChatPopMenuAction();
                    chatPopMenuAction4.setActionName(getContext().getString(R$string.n_content_translate));
                    chatPopMenuAction4.setActionIcon(R$drawable.im_icon_text_translate);
                    chatPopMenuAction4.setActionClickListener(new g(this, tUIMessageBean, i11));
                    arrayList.add(chatPopMenuAction4);
                }
            }
        }
        return arrayList;
    }

    public void initDefault() {
        getTitleBar().getTitleLayout().setBackgroundResource(R$color.baseColorDeepestBackground);
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
                ChatView.this.sendMessage(tUIMessageBean, false);
            }
        });
        getInputLayout().clearCustomActionList();
        if (getMessageLayout().getAdapter() == null) {
            this.mAdapter = new HbChatMessageAdapter();
            getMessageLayout().setAdapter(this.mAdapter);
        }
        initListener();
        resetForwardState("");
    }

    public void loadGroupMessage(String str, long j11, int i11, TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMMessageListGetOption v2TIMMessageListGetOption = new V2TIMMessageListGetOption();
        v2TIMMessageListGetOption.setGroupID(str);
        v2TIMMessageListGetOption.setCount(20);
        v2TIMMessageListGetOption.setGetType(i11 == 0 ? 1 : 2);
        if (j11 > 0) {
            v2TIMMessageListGetOption.setLastMsgSeq(j11);
        } else {
            v2TIMMessageListGetOption.setLastMsg(tUIMessageBean.getV2TIMMessage());
        }
        V2TIMManager.getMessageManager().getHistoryMessageList(v2TIMMessageListGetOption, new V2TIMValueCallback<List<V2TIMMessage>>() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatView.TAG, i11, str);
                String access$000 = ChatView.TAG;
                TUIChatLog.e(access$000, "loadChatMessages getC2CHistoryMessageList failed, code = " + i11 + ", desc = " + ErrorMessageConverter.convertIMError(i11, str));
            }

            public void onSuccess(List<V2TIMMessage> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
            }
        });
    }

    public void loadMessages(TUIMessageBean tUIMessageBean, int i11) {
        ChatPresenter chatPresenter = this.chatManager;
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
        if (i11 == 0) {
            this.mGroupApplyLayout.setVisibility(8);
            return;
        }
        this.mGroupApplyLayout.getContent().setText(getContext().getString(R$string.group_apply_tips, new Object[]{Integer.valueOf(i11)}));
        this.mGroupApplyLayout.setVisibility(0);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        exitChat();
        this.chatManager.release();
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

    public void replyMessage(TUIMessageBean tUIMessageBean) {
        this.mInputView.showReplyPreview(ChatMessageBuilder.buildReplyPreviewBean(tUIMessageBean));
    }

    public void revokeMessage(TUIMessageBean tUIMessageBean) {
        this.chatManager.revokeMessage(tUIMessageBean);
    }

    public void scrollToEnd() {
        getMessageLayout().scrollToEnd();
    }

    public void sendMessage(final TUIMessageBean tUIMessageBean, boolean z11) {
        try {
            ((BusinessCallbacks.ImGroupTrackListener) BusinessCallbacks.trackListenerWeakReference.get()).onGroupChatSend(this.mChatInfo.getId());
        } catch (Exception e11) {
            String str = TAG;
            IMLog.i(str, "track: send = " + e11.getMessage());
        }
        this.chatManager.sendMessage(tUIMessageBean, z11, (IUIKitCallback<TUIMessageBean>) new IUIKitCallback() {
            public void onError(String str, int i11, String str2) {
                String access$000 = ChatView.TAG;
                IMLog.d(access$000, i11 + str2);
                if (i11 != 10007) {
                    if (i11 != 10102) {
                        if (i11 != 20006) {
                            if (i11 == 10016) {
                                ToastUtil.toastLongMessage(ChatView.this.getContext().getString(R$string.n_im_sensitive_word));
                                return;
                            } else if (i11 != 10017) {
                                ToastUtil.toastLongMessage(str2);
                                return;
                            }
                        } else if (!ChatView.this.isGroup) {
                            HbTipMessageBean buildTipsMessage = ChatMessageBuilder.buildTipsMessage(ChatView.this.getContext().getString(R$string.n_im_msg_rejection));
                            ChatView chatView = ChatView.this;
                            if (!(chatView.mAdapter == null || chatView.chatManager == null)) {
                                ChatView.this.chatManager.getLoadedMessageInfoList().add(buildTipsMessage);
                                ChatView.this.mAdapter.onViewNeedRefresh(8, 1);
                            }
                            if (tUIMessageBean != null) {
                                V2TIMManager.getMessageManager().insertC2CMessageToLocalStorage(buildTipsMessage.getV2TIMMessage(), tUIMessageBean.getUserId(), TUILogin.getLoginUser(), new V2TIMValueCallback<V2TIMMessage>() {
                                    public void onError(int i11, String str) {
                                    }

                                    public void onSuccess(V2TIMMessage v2TIMMessage) {
                                    }
                                });
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    ToastUtil.toastLongMessage(ChatView.this.getContext().getString(R$string.n_im_forbidden));
                    return;
                }
                ToastUtil.toastLongMessage(ChatView.this.getContext().getString(R$string.n_im_kick_out));
            }

            public void onProgress(Object obj) {
                ProgressPresenter.getInstance().updateProgress(tUIMessageBean.getId(), ((Integer) obj).intValue());
            }

            public void onSuccess(Object obj) {
                BackgroundTasks.getInstance().runOnUiThread(new Runnable() {
                    public void run() {
                        ChatView.this.scrollToEnd();
                    }
                });
            }
        });
    }

    public void setChatInfo(final ChatInfo chatInfo) {
        this.mChatInfo = chatInfo;
        if (chatInfo != null) {
            HbGroupUserManager.c().b(chatInfo.getId(), new a<GroupUserListData>() {
                public void onFailed(int i11, String str) {
                }

                public void onSuccess(GroupUserListData groupUserListData) {
                    HbChatMessageAdapter hbChatMessageAdapter = ChatView.this.mAdapter;
                    if (hbChatMessageAdapter != null) {
                        hbChatMessageAdapter.notifyDataSetChanged();
                    }
                }
            });
            this.mInputView.setChatInfo(chatInfo);
            final String p11 = IMConversationHelper.o().p(chatInfo.getId());
            if (TextUtils.isEmpty(p11)) {
                p11 = chatInfo.getChatName();
            }
            getTitleBar().setTitle(p11, ITitleBarLayout.Position.MIDDLE);
            getTitleBar().findViewById(R$id.noDisturbView).setVisibility(IMConversationHelper.o().u(chatInfo.getId()) ? 0 : 8);
            if (TUIChatUtils.isC2CChat(chatInfo.getType())) {
                this.isGroup = false;
            } else {
                this.isGroup = true;
                this.pointMap.put("groupid", chatInfo.getId());
                this.pointMap.put("state", chatInfo.getChatName());
            }
            HbChatMessageAdapter hbChatMessageAdapter = this.mAdapter;
            if (hbChatMessageAdapter != null) {
                hbChatMessageAdapter.setIsGroup(this.isGroup);
            }
            setChatHandler();
            if (this.isGroup) {
                loadApplyList();
                getTitleBar().getExtralGroup().setVisibility(0);
                getTitleBar().setExtralIcon(TUIThemeManager.getAttrResId(getContext(), R$attr.chat_title_bar_extral_menu));
                getTitleBar().setOnRightClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        if (chatInfo == null) {
                            SensorsDataAutoTrackHelper.trackViewOnClick(view);
                            return;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ChatView.this.lastTime > 2000) {
                            long unused = ChatView.this.lastTime = currentTimeMillis;
                            Bundle bundle = new Bundle();
                            bundle.putString("group_id", chatInfo.getId());
                            TUICore.startActivity(ChatView.this.getContext(), "GroupChatInfoActivity", bundle, 100);
                        }
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
                getTitleBar().setOnExtralClickListener(new View.OnClickListener() {
                    private View getShareView() {
                        View findViewById = ChatView.this.findViewById(R$id.clShareView);
                        ((TextView) ChatView.this.findViewById(R$id.tvNickName)).setText(p11);
                        ((TextView) ChatView.this.findViewById(R$id.tvInviteTips)).setText(String.format(ChatView.this.getResources().getString(R$string.n_content_im_group_invitation), new Object[]{BaseModuleConfig.a().j0()}));
                        return findViewById;
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ Unit lambda$onClick$0(GroupInviteBean groupInviteBean) {
                        View shareView = getShareView();
                        String access$1200 = ChatView.this.groupAvatar;
                        BaseModuleConfig.a a11 = BaseModuleConfig.a();
                        ChatView.this.shareProvider.m((FragmentActivity) ChatView.this.getContext(), shareView, access$1200, a11.k("live/community/privateGroup?groupId=" + ChatView.this.mChatInfo.getId().replace("@TGS#_", "")), groupInviteBean.inviteCode);
                        return null;
                    }

                    public String encodeUrl(String str) {
                        try {
                            return URLEncoder.encode(str, "UTF-8");
                        } catch (Exception unused) {
                            return str;
                        }
                    }

                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        try {
                            if (ChatView.this.chatType != 2) {
                                if (ChatView.this.chatType != 3) {
                                    View shareView = getShareView();
                                    String access$1200 = ChatView.this.groupAvatar;
                                    StringBuilder sb2 = new StringBuilder();
                                    BaseModuleConfig.a a11 = BaseModuleConfig.a();
                                    sb2.append(a11.k("live/chat-group?groupId=" + ChatView.this.mChatInfo.getId().replace("@TGS#_", "")));
                                    sb2.append("&title=");
                                    sb2.append(ChatView.this.mChatInfo.getChatName());
                                    ChatView.this.shareProvider.m((FragmentActivity) ChatView.this.getContext(), shareView, access$1200, sb2.toString(), (String) null);
                                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                                }
                            }
                            RequestExtKt.c(v7.b.a().getGroupInviteCode(ChatView.this.mChatInfo.getId()), new h(this), i.f20444b, (MutableLiveData) null);
                        } catch (Exception e11) {
                            String access$000 = ChatView.TAG;
                            IMLog.i(access$000, "track: share = " + e11.getMessage());
                        }
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
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
            getTitleBar().setRightIcon(TUIThemeManager.getAttrResId(getContext(), R$attr.chat_title_bar_more_menu));
            getConversationMessageList(TUIChatUtils.getConversationIdByUserId(chatInfo.getId(), this.isGroup));
            loadMessages(chatInfo.getLocateMessage(), 0);
            setTotalUnread();
        }
    }

    public void setChatManager(ChatPresenter chatPresenter) {
        this.chatManager = chatPresenter;
        this.mMessageRecyclerView.setPresenter(chatPresenter);
        this.mInputView.setChatManager(chatPresenter);
        this.mAdapter.setPresenter(chatPresenter);
    }

    public void setChatType(int i11) {
        this.chatType = i11;
    }

    public void setForwardSelectActivityListener(ForwardSelectActivityListener forwardSelectActivityListener) {
        this.mForwardSelectActivityListener = forwardSelectActivityListener;
    }

    public void setGroupAvatar(String str) {
        this.groupAvatar = str;
    }

    public void setImGroupChatFragment(ImGroupChatFragment imGroupChatFragment) {
        this.mFragment = imGroupChatFragment;
    }

    public void setOnUpdateAdapterListener(UpdateAdapterListener updateAdapterListener2) {
        this.updateAdapterListener = updateAdapterListener2;
    }

    public void setParentLayout(Object obj) {
    }

    public void setPrimeAble(boolean z11, String str) {
        this.mInputView.ableSendPrimeAction(z11, str);
        this.mInputView.setOnPlusClickListener(new c(this));
    }

    public void showItemPopMenu(View view, int i11, TUIMessageBean tUIMessageBean) {
        if (!(tUIMessageBean instanceof HbNoticeMessageBean)) {
            getMessageLayout().addPopActions(initActions(tUIMessageBean, view, i11));
            getMessageLayout().showItemPopMenu(tUIMessageBean, view);
        }
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
                HbChatMessageAdapter hbChatMessageAdapter = this.mAdapter;
                tUIMessageBean = hbChatMessageAdapter.getItem(hbChatMessageAdapter.getItemCount() - 1);
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
