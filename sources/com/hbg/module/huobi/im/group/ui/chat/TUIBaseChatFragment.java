package com.hbg.module.huobi.im.group.ui.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.hbg.module.huobi.im.IMConversationHelper;
import com.hbg.module.huobi.im.group.ui.chat.ChatView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.TitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.fragments.BaseFragment;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TUIBaseChatFragment extends BaseFragment implements IMConversationHelper.f {
    /* access modifiers changed from: private */
    public static final String TAG = TUIBaseChatFragment.class.getSimpleName();
    public View baseView;
    public ChatView chatView;
    /* access modifiers changed from: private */
    public int mForwardMode;
    /* access modifiers changed from: private */
    public List<TUIMessageBean> mForwardSelectMsgInfos = null;
    public TitleBarLayout titleBar;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        Bundle bundle = new Bundle();
        bundle.putString("group_id", getChatInfo().getId());
        TUICore.startActivity(this, TUIConstants.TUIContact.StartActivity.GroupMemberSelect.CLASSIC_ACTIVITY_NAME, bundle, 1);
    }

    public ChatInfo getChatInfo() {
        return null;
    }

    public ChatPresenter getChatManager() {
        return null;
    }

    public void initView() {
        ChatView chatView2 = (ChatView) this.baseView.findViewById(R.id.chat_layout);
        this.chatView = chatView2;
        ImageView rightIcon = chatView2.getTitleBar().getRightIcon();
        rightIcon.getLayoutParams().width = ScreenUtil.dip2px(30.0f);
        rightIcon.getLayoutParams().height = ScreenUtil.dip2px(30.0f);
        this.chatView.initDefault();
        TitleBarLayout titleBar2 = this.chatView.getTitleBar();
        this.titleBar = titleBar2;
        titleBar2.setOnLeftClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUIBaseChatFragment.this.getActivity().finish();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.chatView.setForwardSelectActivityListener(new ChatView.ForwardSelectActivityListener() {
            public void onStartForwardSelectActivity(int i11, List<TUIMessageBean> list) {
                int unused = TUIBaseChatFragment.this.mForwardMode = i11;
                List unused2 = TUIBaseChatFragment.this.mForwardSelectMsgInfos = list;
                Bundle bundle = new Bundle();
                bundle.putInt(TUIChatConstants.FORWARD_MODE, i11);
                TUICore.startActivity(TUIBaseChatFragment.this, "TUIForwardSelectActivity", bundle, 101);
            }
        });
        this.chatView.getMessageLayout().setOnItemClickListener(new OnItemClickListener() {
            public void onMessageLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                TUIChatLog.d(TUIBaseChatFragment.TAG, "chatfragment onTextSelected selectedText = ");
                TUIBaseChatFragment.this.chatView.getMessageLayout().showItemPopMenu(tUIMessageBean, view);
            }

            public void onReEditRevokeMessage(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean != null) {
                    int msgType = tUIMessageBean.getMsgType();
                    if (msgType == 1) {
                        TUIBaseChatFragment.this.chatView.getInputLayout().appendText(tUIMessageBean.getV2TIMMessage().getTextElem().getText());
                        return;
                    }
                    String access$200 = TUIBaseChatFragment.TAG;
                    TUIChatLog.e(access$200, "error type: " + msgType);
                }
            }

            public void onRecallClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean != null) {
                    int callType = ((CallingMessageBean) tUIMessageBean).getCallType();
                    String str = callType == 2 ? "video" : callType == 1 ? "audio" : "";
                    HashMap hashMap = new HashMap();
                    hashMap.put(TUIConstants.TUICalling.PARAM_NAME_USERIDS, new String[]{tUIMessageBean.getUserId()});
                    hashMap.put("type", str);
                    TUICore.callService("TUICallingService", TUIConstants.TUICalling.METHOD_NAME_CALL, hashMap);
                }
            }

            public void onTextSelected(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean instanceof TextMessageBean) {
                    String access$200 = TUIBaseChatFragment.TAG;
                    TUIChatLog.d(access$200, "chatfragment onTextSelected selectedText = " + ((TextMessageBean) tUIMessageBean).getSelectText());
                }
                TUIBaseChatFragment.this.chatView.getMessageLayout().setSelectedPosition(i11);
                TUIBaseChatFragment.this.chatView.getMessageLayout().showItemPopMenu(tUIMessageBean, view);
            }

            public void onUserIconClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("chatId", tUIMessageBean.getSender());
                    TUICore.startActivity("FriendProfileActivity", bundle);
                }
            }

            public void onUserIconLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
            }
        });
        this.chatView.getInputLayout().setStartActivityListener(new a0(this));
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        List<TUIMessageBean> list;
        HashMap hashMap;
        String str;
        String str2;
        super.onActivityResult(i11, i12, intent);
        if (i11 == 1 && i12 == 3) {
            this.chatView.getInputLayout().updateInputText(intent.getStringArrayListExtra(TUIChatConstants.Selection.USER_NAMECARD_SELECT), intent.getStringArrayListExtra(TUIChatConstants.Selection.USER_ID_SELECT));
        } else if (i11 == 101 && i12 == 101 && intent != null && (list = this.mForwardSelectMsgInfos) != null && !list.isEmpty() && (hashMap = (HashMap) intent.getSerializableExtra(TUIChatConstants.FORWARD_SELECT_CONVERSATION_KEY)) != null && !hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
                String str3 = (String) entry.getKey();
                ChatInfo chatInfo = getChatInfo();
                if (chatInfo != null) {
                    if (TUIChatUtils.isGroupChat(chatInfo.getType())) {
                        str2 = getString(R.string.forward_chats);
                    } else {
                        String selfNickName = TUIConfig.getSelfNickName();
                        if (TextUtils.isEmpty(selfNickName)) {
                            selfNickName = TUILogin.getLoginUser();
                        }
                        if (!TextUtils.isEmpty(getChatInfo().getChatName())) {
                            str = getChatInfo().getChatName();
                        } else {
                            str = getChatInfo().getId();
                        }
                        str2 = selfNickName + getString(R.string.and_text) + str + getString(R.string.forward_chats_c2c);
                    }
                    getChatManager().forwardMessage(this.mForwardSelectMsgInfos, booleanValue, str3, str2, this.mForwardMode, str3 != null && str3.equals(chatInfo.getId()), new IUIKitCallback() {
                        public void onError(String str, int i11, String str2) {
                            String access$200 = TUIBaseChatFragment.TAG;
                            TUIChatLog.v(access$200, "sendMessage fail:" + i11 + ContainerUtils.KEY_VALUE_DELIMITER + str2);
                        }

                        public void onSuccess(Object obj) {
                            TUIChatLog.v(TUIBaseChatFragment.TAG, "sendMessage onSuccess:");
                        }
                    });
                } else {
                    return;
                }
            }
        }
    }

    public abstract /* synthetic */ void onChatSessionRemoveChange();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str = TAG;
        TUIChatLog.i(str, "oncreate view " + this);
        this.baseView = layoutInflater.inflate(R.layout.chat_fragment, viewGroup, false);
        if (getArguments() == null) {
            return this.baseView;
        }
        IMConversationHelper.o().j(this);
        return this.baseView;
    }

    public void onDestroy() {
        super.onDestroy();
        ChatView chatView2 = this.chatView;
        if (chatView2 != null) {
            chatView2.exitChat();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        IMConversationHelper.o().x(this);
    }

    public void onPause() {
        super.onPause();
        ChatView chatView2 = this.chatView;
        if (chatView2 != null) {
            if (chatView2.getInputLayout() != null) {
                this.chatView.getInputLayout().setDraft();
            }
            if (getChatManager() != null) {
                getChatManager().setChatFragmentShow(false);
            }
        }
        AudioPlayer.getInstance().stopPlay();
    }

    public void onResume() {
        super.onResume();
        if (getChatManager() != null) {
            getChatManager().setChatFragmentShow(true);
        }
    }

    public void setPrimeAble(boolean z11, String str) {
        this.chatView.setPrimeAble(z11, str);
    }
}
