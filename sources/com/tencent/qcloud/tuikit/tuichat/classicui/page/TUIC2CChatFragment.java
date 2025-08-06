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
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.HashMap;
import java.util.List;

public class TUIC2CChatFragment extends TUIBaseChatFragment {
    private static final String TAG = TUIC2CChatFragment.class.getSimpleName();
    /* access modifiers changed from: private */
    public ChatInfo chatInfo;
    private C2CChatPresenter presenter;

    private void setTitleBarExtension() {
        HashMap hashMap = new HashMap();
        hashMap.put(TUIConstants.TUIChat.Extension.ChatNavigationMoreItem.USER_ID, this.chatInfo.getId());
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
                        hashMap.put(TUIConstants.TUIChat.Extension.ChatNavigationMoreItem.USER_ID, TUIC2CChatFragment.this.chatInfo.getId());
                        hashMap.put(TUIConstants.TUIChat.CHAT_BACKGROUND_URI, TUIC2CChatFragment.this.mChatBackgroundThumbnailUrl);
                        extensionListener.onClicked(hashMap);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }
    }

    public ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    public void initView() {
        super.initView();
        setTitleBarExtension();
        this.chatView.setPresenter(this.presenter);
        this.presenter.setChatInfo(this.chatInfo);
        this.presenter.setTypingListener(this.chatView.mTypingListener);
        this.chatView.setChatInfo(this.chatInfo);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str = TAG;
        TUIChatLog.i(str, "oncreate view " + this);
        this.baseView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return this.baseView;
        }
        ChatInfo chatInfo2 = (ChatInfo) arguments.getSerializable(TUIChatConstants.CHAT_INFO);
        this.chatInfo = chatInfo2;
        if (chatInfo2 == null) {
            return this.baseView;
        }
        initView();
        return this.baseView;
    }

    public void setPresenter(C2CChatPresenter c2CChatPresenter) {
        this.presenter = c2CChatPresenter;
    }

    public C2CChatPresenter getPresenter() {
        return this.presenter;
    }
}
