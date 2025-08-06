package com.tencent.qcloud.tuikit.tuichat;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import java.lang.ref.WeakReference;

public class BusinessCallbacks {
    public static WeakReference<ActivityActionListener> activityActionWeakReference;
    public static WeakReference<ImGroupTrackListener> trackListenerWeakReference;

    public interface ActivityActionListener {
        Context onAttachBaseContext(Context context);

        Resources onGetResources(Resources resources);
    }

    public interface ImGroupMessageListener {
        void onGroupMemberKick();

        void onGroupReceiveCustomMsg(TUIMessageBean tUIMessageBean);
    }

    public interface ImGroupTrackListener {
        void onGroupChatIn(String str);

        void onGroupChatOut(String str);

        void onGroupChatQuit(String str);

        void onGroupChatSend(String str);

        void onGroupChatShare(String str);
    }
}
