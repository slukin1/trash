package com.tencent.qcloud.tuikit.tuichat.classicui.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuikit.timcommon.component.TitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.presenter.ForwardPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

public class TUIForwardChatActivity extends BaseLightActivity {
    private static final String TAG = "TUIForwardChatActivity";
    private ChatInfo chatInfo;
    private MessageAdapter mForwardChatAdapter;
    private MessageRecyclerView mFowardChatMessageRecyclerView;
    private MergeMessageBean mMessageInfo;
    private String mTitle;
    private TitleBarLayout mTitleBar;
    private ForwardPresenter presenter;

    private void init() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mTitleBar.setTitle(this.mTitle, ITitleBarLayout.Position.MIDDLE);
            this.mTitleBar.getRightGroup().setVisibility(8);
            this.mMessageInfo = (MergeMessageBean) intent.getSerializableExtra(TUIChatConstants.FORWARD_MERGE_MESSAGE_KEY);
            ChatInfo chatInfo2 = (ChatInfo) intent.getSerializableExtra(TUIChatConstants.CHAT_INFO);
            this.chatInfo = chatInfo2;
            if (this.mMessageInfo == null) {
                TUIChatLog.e(TAG, "mMessageInfo is null");
                return;
            }
            this.presenter.setChatInfo(chatInfo2);
            this.presenter.downloadMergerMessage(this.mMessageInfo);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forward_chat_layout);
        MessageRecyclerView messageRecyclerView = (MessageRecyclerView) findViewById(R.id.chat_message_layout);
        this.mFowardChatMessageRecyclerView = messageRecyclerView;
        messageRecyclerView.setLayoutManager(new CustomLinearLayoutManager(this, 1, false));
        MessageAdapter messageAdapter = new MessageAdapter();
        this.mForwardChatAdapter = messageAdapter;
        messageAdapter.setForwardMode(true);
        ForwardPresenter forwardPresenter = new ForwardPresenter();
        this.presenter = forwardPresenter;
        forwardPresenter.setMessageListAdapter(this.mForwardChatAdapter);
        this.presenter.setNeedShowTranslation(false);
        this.mForwardChatAdapter.setPresenter(this.presenter);
        this.mFowardChatMessageRecyclerView.setAdapter(this.mForwardChatAdapter);
        this.mFowardChatMessageRecyclerView.setPresenter(this.presenter);
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.chat_title_bar);
        this.mTitleBar = titleBarLayout;
        titleBarLayout.setOnLeftClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUIForwardChatActivity.this.finish();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mFowardChatMessageRecyclerView.setOnItemClickListener(new OnItemClickListener() {
            public void onMessageClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean instanceof MergeMessageBean) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(TUIChatConstants.FORWARD_MERGE_MESSAGE_KEY, tUIMessageBean);
                    TUICore.startActivity(TUIForwardChatActivity.TAG, bundle);
                }
            }

            public void onUserIconClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean instanceof MergeMessageBean) {
                    Intent intent = new Intent(TUIForwardChatActivity.this.getBaseContext(), TUIForwardChatActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(TUIChatConstants.FORWARD_MERGE_MESSAGE_KEY, tUIMessageBean);
                    intent.putExtras(bundle);
                    TUIForwardChatActivity.this.startActivity(intent);
                }
            }
        });
        init();
    }
}
