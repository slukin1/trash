package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.text.TextUtils;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForwardPresenter extends ChatPresenter {
    public static final String TAG = "ForwardPresenter";
    private ChatInfo chatInfo;
    public List<TUIMessageBean> loadedData = new ArrayList();
    private IMessageAdapter messageListAdapter;
    private final ChatProvider provider;

    public ForwardPresenter() {
        TUIChatLog.i(TAG, "ChatPresenter Init");
        this.provider = ChatProvider.getInstance();
    }

    /* access modifiers changed from: private */
    public void onMergeMessageDownloaded(List<TUIMessageBean> list) {
        this.loadedData.clear();
        this.loadedData.addAll(list);
        IMessageAdapter iMessageAdapter = this.messageListAdapter;
        if (iMessageAdapter != null) {
            iMessageAdapter.onDataSourceChanged(this.loadedData);
            this.messageListAdapter.onViewNeedRefresh(4, this.loadedData.size());
        }
    }

    public void downloadMergerMessage(MergeMessageBean mergeMessageBean) {
        if (mergeMessageBean == null) {
            return;
        }
        if (mergeMessageBean.isLayersOverLimit()) {
            TUIChatLog.e(TAG, "merge message Layers Over Limit");
        } else {
            this.provider.downloadMergerMessage(mergeMessageBean, new IUIKitCallback<List<TUIMessageBean>>() {
                public void onError(String str, int i11, String str2) {
                    String str3 = ForwardPresenter.TAG;
                    TUIChatLog.e(str3, "downloadMergerMessage error , code = " + i11 + "  message = " + str2);
                }

                public void onSuccess(final List<TUIMessageBean> list) {
                    ForwardPresenter.this.preProcessMessage(list, (IUIKitCallback<List<TUIMessageBean>>) new IUIKitCallback<List<TUIMessageBean>>() {
                        public void onError(String str, int i11, String str2) {
                            ForwardPresenter.this.onMergeMessageDownloaded(list);
                        }

                        public void onSuccess(List<TUIMessageBean> list) {
                            ForwardPresenter.this.onMergeMessageDownloaded(list);
                        }
                    });
                }
            });
        }
    }

    public ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    public void locateMessage(String str, IUIKitCallback<Void> iUIKitCallback) {
        boolean z11;
        Iterator<TUIMessageBean> it2 = this.loadedData.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z11 = false;
                break;
            }
            TUIMessageBean next = it2.next();
            if (TextUtils.equals(str, next.getId())) {
                z11 = true;
                updateAdapter(9, next);
                break;
            }
        }
        if (z11) {
            TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
        } else {
            TUIChatUtils.callbackOnError(iUIKitCallback, -1, "not find");
        }
    }

    public void setChatInfo(ChatInfo chatInfo2) {
        this.chatInfo = chatInfo2;
    }

    public void setMessageListAdapter(IMessageAdapter iMessageAdapter) {
        this.messageListAdapter = iMessageAdapter;
    }

    public void updateAdapter(int i11, TUIMessageBean tUIMessageBean) {
        IMessageAdapter iMessageAdapter = this.messageListAdapter;
        if (iMessageAdapter != null) {
            iMessageAdapter.onViewNeedRefresh(i11, tUIMessageBean);
        }
    }
}
