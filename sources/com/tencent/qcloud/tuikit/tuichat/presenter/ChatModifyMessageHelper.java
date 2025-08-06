package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.os.Handler;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ChatModifyMessageHelper {
    private static final int RETRY_MAX_TIME = 3000;
    private static final int RETRY_MIN_TIME = 500;
    private static final int RETRY_TIMES = 3;
    /* access modifiers changed from: private */
    public static final ChatModifyMessageHelper helper = new ChatModifyMessageHelper();
    /* access modifiers changed from: private */
    public final Map<String, TUIMessageBean> cache = new HashMap();
    private final Handler handler = new Handler();
    /* access modifiers changed from: private */
    public final ChatProvider provider = ChatProvider.getInstance();

    public static abstract class ModifyMessageTask {
        /* access modifiers changed from: private */
        public final IUIKitCallback<TUIMessageBean> callback;
        /* access modifiers changed from: private */
        public TUIMessageBean messageBean;
        /* access modifiers changed from: private */
        public int retryTimes = 0;

        public ModifyMessageTask(TUIMessageBean tUIMessageBean, IUIKitCallback<TUIMessageBean> iUIKitCallback) {
            this.messageBean = tUIMessageBean;
            this.callback = iUIKitCallback;
        }

        public static /* synthetic */ int access$508(ModifyMessageTask modifyMessageTask) {
            int i11 = modifyMessageTask.retryTimes;
            modifyMessageTask.retryTimes = i11 + 1;
            return i11;
        }

        public abstract TUIMessageBean packageMessage(TUIMessageBean tUIMessageBean);
    }

    private ChatModifyMessageHelper() {
        TUIChatService.getInstance().addC2CChatEventListener(new C2CChatEventListener() {
            public void onRecvMessageModified(TUIMessageBean tUIMessageBean) {
                ChatModifyMessageHelper.this.onUpdateCache(tUIMessageBean);
            }
        });
    }

    public static void enqueueTask(ModifyMessageTask modifyMessageTask) {
        enqueueTask(modifyMessageTask, 0);
    }

    /* access modifiers changed from: private */
    public int getRetryDelay() {
        return new Random().nextInt(2501) + 500;
    }

    /* access modifiers changed from: private */
    public void onUpdateCache(TUIMessageBean tUIMessageBean) {
        if (this.cache.get(tUIMessageBean.getId()) != null) {
            this.cache.put(tUIMessageBean.getId(), tUIMessageBean);
        }
    }

    /* access modifiers changed from: private */
    public static void enqueueTask(final ModifyMessageTask modifyMessageTask, long j11) {
        helper.handler.postDelayed(new Runnable() {
            public void run() {
                if (ModifyMessageTask.this.messageBean == null) {
                    TUIChatUtils.callbackOnError(ModifyMessageTask.this.callback, -1, "params error , message is null");
                    return;
                }
                TUIMessageBean tUIMessageBean = (TUIMessageBean) ChatModifyMessageHelper.helper.cache.get(ModifyMessageTask.this.messageBean.getId());
                if (tUIMessageBean != null) {
                    TUIMessageBean unused = ModifyMessageTask.this.messageBean = tUIMessageBean;
                }
                ModifyMessageTask modifyMessageTask = ModifyMessageTask.this;
                TUIMessageBean packageMessage = modifyMessageTask.packageMessage(modifyMessageTask.messageBean);
                if (packageMessage == null) {
                    ChatModifyMessageHelper.helper.cache.remove(ModifyMessageTask.this.messageBean.getId());
                    TUIChatUtils.callbackOnError(ModifyMessageTask.this.callback, -1, "message is null");
                    return;
                }
                ChatModifyMessageHelper.helper.provider.modifyMessage(packageMessage, new IUIKitCallback<TUIMessageBean>() {
                    public void onError(int i11, String str, TUIMessageBean tUIMessageBean) {
                        ChatModifyMessageHelper.helper.cache.put(tUIMessageBean.getId(), tUIMessageBean);
                        if (ModifyMessageTask.this.retryTimes <= 3) {
                            int access$600 = ChatModifyMessageHelper.helper.getRetryDelay();
                            ModifyMessageTask.access$508(ModifyMessageTask.this);
                            TUIMessageBean unused = ModifyMessageTask.this.messageBean = tUIMessageBean;
                            ChatModifyMessageHelper.enqueueTask(ModifyMessageTask.this, (long) access$600);
                            return;
                        }
                        ChatModifyMessageHelper.helper.cache.remove(ModifyMessageTask.this.messageBean.getId());
                        TUIChatUtils.callbackOnError(ModifyMessageTask.this.callback, i11, str);
                    }

                    public void onSuccess(TUIMessageBean tUIMessageBean) {
                        ChatModifyMessageHelper.helper.cache.remove(ModifyMessageTask.this.messageBean.getId());
                        TUIChatUtils.callbackOnSuccess(ModifyMessageTask.this.callback, tUIMessageBean);
                    }
                });
            }
        }, j11);
    }
}
