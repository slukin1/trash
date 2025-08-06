package com.hbg.module.huobi.im.group.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.module.huobi.im.utils.HbGroupUserManager;
import com.tencent.imsdk.common.IMLog;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.BusinessCallbacks;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIC2CChatActivity;
import com.tencent.qcloud.tuikit.tuichat.util.PermissionUtils;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.lang.ref.WeakReference;
import rd.c;

@Route(path = "/im/groupchat")
public class ImGroupChatActivity extends ImBaseChatActivity {
    public static final int QUIT_GROUP_REQUEST_CODE = 100;
    private static final String TAG = TUIC2CChatActivity.class.getSimpleName();
    private ImGroupChatFragment chatFragment;
    private GroupInfo groupInfo;

    public void attachBaseContext(Context context) {
        WeakReference<BusinessCallbacks.ActivityActionListener> weakReference = BusinessCallbacks.activityActionWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(((BusinessCallbacks.ActivityActionListener) weakReference.get()).onAttachBaseContext(context));
        }
    }

    public Resources getResources() {
        WeakReference<BusinessCallbacks.ActivityActionListener> weakReference = BusinessCallbacks.activityActionWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return super.getResources();
        }
        return ((BusinessCallbacks.ActivityActionListener) weakReference.get()).onGetResources(super.getResources());
    }

    public void initChat(ChatInfo chatInfo) {
        String str = TAG;
        TUIChatLog.i(str, "inti chat " + chatInfo);
        if (!TUIChatUtils.isGroupChat(chatInfo.getType())) {
            TUIChatLog.e(str, "init group chat failed , chatInfo = " + chatInfo);
            ToastUtil.toastShortMessage("init group chat failed.");
        }
        this.groupInfo = (GroupInfo) chatInfo;
        c.b().g(this.groupInfo.getId());
        this.chatFragment = new ImGroupChatFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(TUIChatConstants.CHAT_INFO, this.groupInfo);
        this.chatFragment.setArguments(bundle);
        getSupportFragmentManager().q().t(R.id.empty_view, this.chatFragment).k();
        WeakReference<BusinessCallbacks.ImGroupTrackListener> weakReference = BusinessCallbacks.trackListenerWeakReference;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((BusinessCallbacks.ImGroupTrackListener) BusinessCallbacks.trackListenerWeakReference.get()).onGroupChatIn(this.groupInfo.getId());
        }
        try {
            ((BusinessCallbacks.ImGroupTrackListener) BusinessCallbacks.trackListenerWeakReference.get()).onGroupChatSend(this.groupInfo.getId());
        } catch (Exception e11) {
            String str2 = TAG;
            IMLog.i(str2, "track: in = " + e11.getMessage());
        }
        PermissionUtils.checkPermission(this);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 100 && i12 == -1) {
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            c.b().e();
            HbGroupUserManager.c().g();
            ((BusinessCallbacks.ImGroupTrackListener) BusinessCallbacks.trackListenerWeakReference.get()).onGroupChatSend(this.groupInfo.getId());
        } catch (Exception e11) {
            String str = TAG;
            IMLog.i(str, "track: out = " + e11.getMessage());
        }
    }
}
