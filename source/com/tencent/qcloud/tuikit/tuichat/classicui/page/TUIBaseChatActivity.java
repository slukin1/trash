package com.tencent.qcloud.tuikit.tuichat.classicui.page;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.DraftInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.List;

public abstract class TUIBaseChatActivity extends BaseLightActivity {
    private static final String TAG = "TUIBaseChatActivity";

    private void chat(Intent intent) {
        Bundle extras = intent.getExtras();
        String str = TAG;
        TUIChatLog.i(str, "bundle: " + extras + " intent: " + intent);
        if (!TUILogin.isUserLogined()) {
            ToastUtil.toastShortMessage(getString(R.string.chat_tips_not_login));
            finish();
            return;
        }
        ChatInfo chatInfo = getChatInfo(intent);
        TUIChatLog.i(str, "start chatActivity chatInfo: " + chatInfo);
        if (chatInfo != null) {
            initChat(chatInfo);
            return;
        }
        ToastUtil.toastShortMessage("init chat failed , chatInfo is empty.");
        TUIChatLog.e(str, "init chat failed , chatInfo is empty.");
        finish();
    }

    private ChatInfo getChatInfo(Intent intent) {
        ChatInfo chatInfo;
        int intExtra = intent.getIntExtra(TUIConstants.TUIChat.CHAT_TYPE, 0);
        if (intExtra == 1) {
            chatInfo = new ChatInfo();
        } else if (intExtra != 2) {
            return null;
        } else {
            chatInfo = new GroupInfo();
        }
        chatInfo.setType(intExtra);
        chatInfo.setId(intent.getStringExtra("chatId"));
        chatInfo.setChatName(intent.getStringExtra(TUIConstants.TUIChat.CHAT_NAME));
        DraftInfo draftInfo = new DraftInfo();
        draftInfo.setDraftText(intent.getStringExtra(TUIConstants.TUIChat.DRAFT_TEXT));
        draftInfo.setDraftTime(intent.getLongExtra(TUIConstants.TUIChat.DRAFT_TIME, 0));
        chatInfo.setDraft(draftInfo);
        chatInfo.setTopChat(intent.getBooleanExtra(TUIConstants.TUIChat.IS_TOP_CHAT, false));
        chatInfo.setLocateMessage(ChatMessageBuilder.buildMessage((V2TIMMessage) intent.getSerializableExtra(TUIConstants.TUIChat.LOCATE_MESSAGE)));
        chatInfo.setAtInfoList((List) intent.getSerializableExtra(TUIConstants.TUIChat.AT_INFO_LIST));
        chatInfo.setFaceUrl(intent.getStringExtra(TUIConstants.TUIChat.FACE_URL));
        if (intExtra == 2) {
            GroupInfo groupInfo = (GroupInfo) chatInfo;
            groupInfo.setGroupName(intent.getStringExtra("groupName"));
            groupInfo.setGroupType(intent.getStringExtra(TUIConstants.TUIChat.GROUP_TYPE));
            groupInfo.setJoinType(intent.getIntExtra(TUIConstants.TUIChat.JOIN_TYPE, 0));
            groupInfo.setMemberCount(intent.getIntExtra(TUIConstants.TUIChat.MEMBER_COUNT, 0));
            groupInfo.setMessageReceiveOption(intent.getBooleanExtra(TUIConstants.TUIChat.RECEIVE_OPTION, false));
            groupInfo.setNotice(intent.getStringExtra(TUIConstants.TUIChat.NOTICE));
            groupInfo.setOwner(intent.getStringExtra(TUIConstants.TUIChat.OWNER));
            groupInfo.setMemberDetails((List) intent.getSerializableExtra(TUIConstants.TUIChat.MEMBER_DETAILS));
        }
        if (TextUtils.isEmpty(chatInfo.getId())) {
            return null;
        }
        return chatInfo;
    }

    public abstract void initChat(ChatInfo chatInfo);

    public void onCreate(Bundle bundle) {
        String str = TAG;
        TUIChatLog.i(str, "onCreate " + this);
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity);
        chat(getIntent());
    }

    public void onNewIntent(Intent intent) {
        TUIChatLog.i(TAG, "onNewIntent");
        super.onNewIntent(intent);
        chat(intent);
    }

    public void onResume() {
        TUIChatLog.i(TAG, "onResume");
        super.onResume();
    }
}
