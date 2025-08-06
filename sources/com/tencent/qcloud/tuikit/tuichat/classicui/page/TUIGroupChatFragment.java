package com.tencent.qcloud.tuikit.tuichat.classicui.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.interfaces.TUIExtensionEventListener;
import com.tencent.qcloud.tuicore.interfaces.TUIExtensionInfo;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.HashMap;
import java.util.List;

public class TUIGroupChatFragment extends TUIBaseChatFragment {
    /* access modifiers changed from: private */
    public static final String TAG = TUIGroupChatFragment.class.getSimpleName();
    /* access modifiers changed from: private */
    public GroupInfo groupInfo;
    private GroupChatPresenter presenter;

    private void setTitleBarExtension() {
        HashMap hashMap = new HashMap();
        if (TUIChatUtils.isTopicGroup(this.groupInfo.getId())) {
            hashMap.put(TUIConstants.TUIChat.Extension.ChatNavigationMoreItem.TOPIC_ID, this.groupInfo.getId());
        } else {
            hashMap.put(TUIConstants.TUIChat.Extension.ChatNavigationMoreItem.GROUP_ID, this.groupInfo.getId());
        }
        List<TUIExtensionInfo> extensionList = TUICore.getExtensionList(TUIConstants.TUIChat.Extension.ChatNavigationMoreItem.CLASSIC_EXTENSION_ID, hashMap);
        if (!extensionList.isEmpty()) {
            final TUIExtensionInfo tUIExtensionInfo = extensionList.get(0);
            this.titleBar.setRightIcon(((Integer) tUIExtensionInfo.getIcon()).intValue());
            this.titleBar.setOnRightClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    TUIExtensionEventListener extensionListener = tUIExtensionInfo.getExtensionListener();
                    if (extensionListener != null) {
                        HashMap hashMap = new HashMap();
                        if (TUIChatUtils.isTopicGroup(TUIGroupChatFragment.this.groupInfo.getId())) {
                            hashMap.put(TUIConstants.TUIChat.Extension.ChatNavigationMoreItem.TOPIC_ID, TUIGroupChatFragment.this.groupInfo.getId());
                        } else {
                            hashMap.put(TUIConstants.TUIChat.Extension.ChatNavigationMoreItem.GROUP_ID, TUIGroupChatFragment.this.groupInfo.getId());
                        }
                        hashMap.put(TUIConstants.TUIChat.CHAT_BACKGROUND_URI, TUIGroupChatFragment.this.mChatBackgroundThumbnailUrl);
                        extensionListener.onClicked(hashMap);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }
    }

    public ChatInfo getChatInfo() {
        return this.groupInfo;
    }

    public void initView() {
        super.initView();
        this.chatView.setPresenter(this.presenter);
        this.presenter.setGroupInfo(this.groupInfo);
        this.chatView.setChatInfo(this.groupInfo);
        this.chatView.getMessageLayout().setOnItemClickListener(new OnItemClickListener() {
            public void onMessageClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                if ((tUIMessageBean instanceof MergeMessageBean) && TUIGroupChatFragment.this.getChatInfo() != null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(TUIChatConstants.FORWARD_MERGE_MESSAGE_KEY, tUIMessageBean);
                    bundle.putSerializable(TUIChatConstants.CHAT_INFO, TUIGroupChatFragment.this.getChatInfo());
                    TUICore.startActivity("TUIForwardChatActivity", bundle);
                }
            }

            public void onMessageLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                TUIGroupChatFragment.this.chatView.getMessageLayout().showItemPopMenu(tUIMessageBean, view);
            }

            public void onMessageReadStatusClick(View view, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean != null && TUIGroupChatFragment.this.getChatInfo() != null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("messageBean", tUIMessageBean);
                    bundle.putSerializable(TUIChatConstants.CHAT_INFO, TUIGroupChatFragment.this.getChatInfo());
                    TUICore.startActivity("MessageReceiptDetailActivity", bundle);
                }
            }

            public void onReEditRevokeMessage(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean != null) {
                    int msgType = tUIMessageBean.getMsgType();
                    if (msgType == 1) {
                        TUIGroupChatFragment.this.chatView.getInputLayout().appendText(tUIMessageBean.getV2TIMMessage().getTextElem().getText());
                        return;
                    }
                    String access$000 = TUIGroupChatFragment.TAG;
                    TUIChatLog.e(access$000, "error type: " + msgType);
                }
            }

            public void onTextSelected(View view, int i11, TUIMessageBean tUIMessageBean) {
                TUIGroupChatFragment.this.chatView.getMessageLayout().setSelectedPosition(i11);
                TUIGroupChatFragment.this.chatView.getMessageLayout().showItemPopMenu(tUIMessageBean, view);
            }

            public void onUserIconClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean != null) {
                    ChatInfo chatInfo = new ChatInfo();
                    chatInfo.setId(tUIMessageBean.getSender());
                    Bundle bundle = new Bundle();
                    bundle.putString("chatId", chatInfo.getId());
                    TUICore.startActivity("FriendProfileActivity", bundle);
                }
            }

            public void onUserIconLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                String sender = tUIMessageBean.getV2TIMMessage().getSender();
                TUIGroupChatFragment.this.chatView.getInputLayout().addInputText(tUIMessageBean.getV2TIMMessage().getNickName(), sender);
            }
        });
        setTitleBarExtension();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str = TAG;
        TUIChatLog.i(str, "oncreate view " + this);
        this.baseView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return this.baseView;
        }
        GroupInfo groupInfo2 = (GroupInfo) arguments.getSerializable(TUIChatConstants.CHAT_INFO);
        this.groupInfo = groupInfo2;
        if (groupInfo2 == null) {
            return this.baseView;
        }
        initView();
        return this.baseView;
    }

    public void setPresenter(GroupChatPresenter groupChatPresenter) {
        this.presenter = groupChatPresenter;
    }

    public GroupChatPresenter getPresenter() {
        return this.presenter;
    }
}
