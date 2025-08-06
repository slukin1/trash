package com.hbg.module.huobi.im.group.ui.chat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$layout;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.DraftInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class ImBaseChatActivity extends BaseLightActivity {
    private static final String TAG = "ImBaseChatActivity";

    private void chat(Intent intent) {
        Bundle extras = intent.getExtras();
        String str = TAG;
        TUIChatLog.i(str, "bundle: " + extras + " intent: " + intent);
        if (extras == null || !TUILogin.isUserLogined()) {
            startSplashActivity(extras);
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
        int i11;
        ChatInfo chatInfo;
        try {
            i11 = Integer.parseInt(intent.getStringExtra(TUIConstants.TUIChat.CHAT_TYPE));
        } catch (Throwable th2) {
            th2.printStackTrace();
            i11 = 0;
        }
        if (i11 == 1) {
            chatInfo = new ChatInfo();
        } else if (i11 != 2) {
            return null;
        } else {
            chatInfo = new GroupInfo();
        }
        chatInfo.setType(i11);
        String stringExtra = intent.getStringExtra("chatId");
        String stringExtra2 = intent.getStringExtra("messageId");
        if (i11 == 2 && !stringExtra.startsWith("@TGS#_")) {
            stringExtra = "@TGS#_" + stringExtra;
        }
        chatInfo.setId(stringExtra);
        chatInfo.setMsgId(stringExtra2);
        chatInfo.setChatName(intent.getStringExtra(TUIConstants.TUIChat.CHAT_NAME));
        DraftInfo draftInfo = new DraftInfo();
        draftInfo.setDraftText(intent.getStringExtra(TUIConstants.TUIChat.DRAFT_TEXT));
        draftInfo.setDraftTime(intent.getLongExtra(TUIConstants.TUIChat.DRAFT_TIME, 0));
        chatInfo.setDraft(draftInfo);
        chatInfo.setTopChat(intent.getBooleanExtra(TUIConstants.TUIChat.IS_TOP_CHAT, false));
        chatInfo.setLocateMessage(ChatMessageBuilder.buildMessage((V2TIMMessage) intent.getSerializableExtra(TUIConstants.TUIChat.LOCATE_MESSAGE)));
        chatInfo.setAtInfoList((List) intent.getSerializableExtra(TUIConstants.TUIChat.AT_INFO_LIST));
        if (i11 == 2) {
            GroupInfo groupInfo = (GroupInfo) chatInfo;
            groupInfo.setFaceUrl(intent.getStringExtra(TUIConstants.TUIChat.FACE_URL));
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

    private void startSplashActivity(Bundle bundle) {
        TUICore.startActivity(this, "SplashActivity", bundle);
        finish();
    }

    public void changeStatusBarTextColor(boolean z11) {
        if (Build.VERSION.SDK_INT <= 23) {
            return;
        }
        if (z11) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    public abstract void initChat(ChatInfo chatInfo);

    public void onActivityResult(int i11, int i12, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i11, i12, intent);
        if (i12 == 3 && intent != null && i11 == 11 && (stringArrayListExtra = intent.getStringArrayListExtra("list")) != null && !stringArrayListExtra.isEmpty()) {
            intent.putExtra(TUIConstants.TUICalling.PARAM_NAME_USERIDS, (String[]) stringArrayListExtra.toArray(new String[0]));
            HashMap hashMap = new HashMap();
            for (String str : intent.getExtras().keySet()) {
                hashMap.put(str, intent.getExtras().get(str));
            }
            TUICore.callService("TUICallingService", TUIConstants.TUICalling.METHOD_NAME_CALL, hashMap);
        }
    }

    public void onCreate(Bundle bundle) {
        String str = TAG;
        TUIChatLog.i(str, "onCreate " + this);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R$color.baseColorDeepestBackground));
            getWindow().setNavigationBarColor(getResources().getColor(R$color.white_day_black_night_color));
            changeStatusBarTextColor(!NightHelper.e().g());
        }
        setContentView(R$layout.chat_activity);
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
