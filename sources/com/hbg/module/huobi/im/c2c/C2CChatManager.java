package com.hbg.module.huobi.im.c2c;

import android.text.TextUtils;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.lang.ref.WeakReference;
import java.util.List;

public class C2CChatManager extends ChatPresenter {

    /* renamed from: c  reason: collision with root package name */
    public static final String f19641c = "C2CChatManager";

    /* renamed from: a  reason: collision with root package name */
    public ChatInfo f19642a;

    /* renamed from: b  reason: collision with root package name */
    public C2CChatEventListener f19643b;

    public class a extends C2CChatEventListener {
        public a() {
        }

        public void exitC2CChat(String str) {
            C2CChatManager.this.onExitChat(str);
        }

        public void handleRevoke(String str) {
            C2CChatManager.this.handleRevoke(str);
        }

        public void onFriendNameChanged(String str, String str2) {
            if (C2CChatManager.this.f19642a != null && TextUtils.equals(str, C2CChatManager.this.f19642a.getId())) {
                C2CChatManager.this.onFriendInfoChanged();
            }
        }

        public void onReadReport(List<MessageReceiptInfo> list) {
            C2CChatManager.this.onReadReport(list);
        }

        public void onRecvNewMessage(TUIMessageBean tUIMessageBean) {
            if (C2CChatManager.this.f19642a == null || !TextUtils.equals(tUIMessageBean.getUserId(), C2CChatManager.this.f19642a.getId())) {
                TUIChatLog.i(C2CChatManager.f19641c, "receive a new message , not belong to current chat.");
            } else {
                C2CChatManager.this.onRecvNewMessage(tUIMessageBean);
            }
        }
    }

    public class b extends IUIKitCallback<List<TUIMessageBean>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUIMessageBean f19645a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IUIKitCallback f19646b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f19647c;

        public b(TUIMessageBean tUIMessageBean, IUIKitCallback iUIKitCallback, int i11) {
            this.f19645a = tUIMessageBean;
            this.f19646b = iUIKitCallback;
            this.f19647c = i11;
        }

        public void onError(String str, int i11, String str2) {
            String access$100 = C2CChatManager.f19641c;
            TUIChatLog.e(access$100, "load c2c message failed " + i11 + "  " + str2);
            TUIChatUtils.callbackOnError(this.f19646b, i11, str2);
        }

        public void onSuccess(List<TUIMessageBean> list) {
            String access$100 = C2CChatManager.f19641c;
            TUIChatLog.i(access$100, "load c2c message success " + list.size());
            if (this.f19645a == null) {
                C2CChatManager.this.isHaveMoreNewMessage = false;
            }
            TUIChatUtils.callbackOnSuccess(this.f19646b, list);
            C2CChatManager.this.onMessageLoadCompleted(list, this.f19647c);
        }
    }

    public class c extends IUIKitCallback<String[]> {
        public c() {
        }

        public void onError(String str, int i11, String str2) {
        }

        public void onSuccess(String[] strArr) {
            String id2 = C2CChatManager.this.f19642a.getId();
            if (!TextUtils.isEmpty(strArr[0])) {
                id2 = strArr[0];
            } else if (!TextUtils.isEmpty(strArr[1])) {
                id2 = strArr[1];
            }
            C2CChatManager.this.onFriendNameChanged(id2);
        }
    }

    public C2CChatManager() {
        TUIChatLog.i(f19641c, "C2CChatPresenter Init");
    }

    public ChatInfo getChatInfo() {
        return this.f19642a;
    }

    public void initListener() {
        this.f19643b = new a();
        TUIChatService.getInstance().addC2CChatEventListener(this.f19643b);
        initMessageSender();
    }

    public void loadMessage(int i11, TUIMessageBean tUIMessageBean, IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        ChatInfo chatInfo = this.f19642a;
        if (chatInfo != null && !this.isLoading) {
            this.isLoading = true;
            String id2 = chatInfo.getId();
            if (i11 == 0) {
                this.provider.loadC2CMessage(id2, 20, tUIMessageBean, new b(tUIMessageBean, iUIKitCallback, i11));
            } else {
                loadHistoryMessageList(id2, false, i11, 20, tUIMessageBean, iUIKitCallback);
            }
        }
    }

    public void onFriendInfoChanged() {
        this.provider.getFriendName(this.f19642a.getId(), new c());
    }

    public void onFriendNameChanged(String str) {
        WeakReference<ChatPresenter.ChatNotifyHandler> weakReference = this.chatNotifyHandler;
        if (weakReference != null && weakReference.get() != null) {
            ((ChatPresenter.ChatNotifyHandler) this.chatNotifyHandler.get()).onFriendNameChanged(str);
        }
    }

    public void onMessageLoadCompleted(List<TUIMessageBean> list, int i11) {
        c2cReadReport(this.f19642a.getId());
        processLoadedMessage(list, i11);
    }

    public void setChatInfo(ChatInfo chatInfo) {
        this.f19642a = chatInfo;
    }
}
