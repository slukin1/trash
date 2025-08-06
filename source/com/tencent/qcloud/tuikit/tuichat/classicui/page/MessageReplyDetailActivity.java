package com.tencent.qcloud.tuikit.tuichat.classicui.page;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.TitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ReplyDetailsView;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IReplyMessageHandler;
import com.tencent.qcloud.tuikit.tuichat.presenter.ReplyPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import java.util.ArrayList;
import java.util.Map;

public class MessageReplyDetailActivity extends BaseLightActivity implements InputView.MessageHandler, IReplyMessageHandler {
    private static final int SCROLL_TO_END_OFFSET = -999999;
    private ChatInfo chatInfo;
    /* access modifiers changed from: private */
    public InputView inputView;
    private TUIMessageBean message;
    private MessageAdapter messageAdapter;
    private MessageRecyclerView messageRecyclerView;
    private ReplyPresenter presenter;
    private ReplyDetailsView repliesList;
    private TitleBarLayout titleBarLayout;

    private void initData() {
        TUIMessageBean tUIMessageBean = this.message;
        if (tUIMessageBean != null) {
            MessageRepliesBean messageRepliesBean = tUIMessageBean.getMessageRepliesBean();
            if (messageRepliesBean != null) {
                this.presenter.findReplyMessages(messageRepliesBean);
            }
            MessageAdapter messageAdapter2 = new MessageAdapter();
            this.messageAdapter = messageAdapter2;
            messageAdapter2.setReplyDetailMode(true);
            this.messageAdapter.setPresenter(this.presenter.getChatPresenter());
            this.messageRecyclerView.setAdapter(this.messageAdapter);
            this.messageRecyclerView.setOnItemClickListener(new OnItemClickListener() {
                public void onMessageClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                    if (tUIMessageBean instanceof MergeMessageBean) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(TUIChatConstants.FORWARD_MERGE_MESSAGE_KEY, tUIMessageBean);
                        TUICore.startActivity("TUIForwardChatActivity", bundle);
                    }
                }
            });
            this.presenter.getReactUserBean(this.message, new IUIKitCallback<Void>() {
                public void onError(String str, int i11, String str2) {
                    MessageReplyDetailActivity.this.initMessageDetail();
                }

                public void onSuccess(Void voidR) {
                    MessageReplyDetailActivity.this.initMessageDetail();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void initMessageDetail() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.message);
        this.messageAdapter.onDataSourceChanged(arrayList);
        this.messageAdapter.onViewNeedRefresh(4, this.message);
    }

    private void setOnEmptyAreaClickListener() {
        final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                MessageReplyDetailActivity.this.inputView.onEmptyClick();
                return true;
            }
        });
        this.repliesList.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_message_reply_detail);
        this.message = (TUIMessageBean) getIntent().getSerializableExtra("messageBean");
        this.chatInfo = (ChatInfo) getIntent().getSerializableExtra(TUIChatConstants.CHAT_INFO);
        ReplyPresenter replyPresenter = new ReplyPresenter();
        this.presenter = replyPresenter;
        replyPresenter.setMessageId(this.message.getId());
        this.presenter.setChatInfo(this.chatInfo);
        this.presenter.setChatEventListener();
        this.presenter.setReplyHandler(this);
        TitleBarLayout titleBarLayout2 = (TitleBarLayout) findViewById(R.id.reply_title);
        this.titleBarLayout = titleBarLayout2;
        titleBarLayout2.setOnLeftClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                MessageReplyDetailActivity.this.finish();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.titleBarLayout.setTitle(getString(R.string.chat_reply_detail), ITitleBarLayout.Position.MIDDLE);
        InputView inputView2 = (InputView) findViewById(R.id.reply_input_layout);
        this.inputView = inputView2;
        inputView2.disableMoreInput(true);
        this.inputView.disableAudioInput(true);
        this.inputView.disableShowCustomFace(true);
        this.inputView.setMessageHandler(this);
        this.repliesList = (ReplyDetailsView) findViewById(R.id.replies_detail);
        MessageRecyclerView messageRecyclerView2 = (MessageRecyclerView) findViewById(R.id.message_view);
        this.messageRecyclerView = messageRecyclerView2;
        messageRecyclerView2.setLayoutManager(new LinearLayoutManager(this));
        this.messageRecyclerView.setPresenter(this.presenter.getChatPresenter());
        this.messageRecyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        setOnEmptyAreaClickListener();
        initData();
    }

    public void onRepliesMessageFound(Map<MessageRepliesBean.ReplyBean, TUIMessageBean> map) {
        ReplyDetailsView replyDetailsView = this.repliesList;
        if (replyDetailsView != null) {
            replyDetailsView.setData(map);
        }
    }

    public void scrollToEnd() {
        if (this.repliesList.getAdapter() != null) {
            RecyclerView.LayoutManager layoutManager = this.repliesList.getLayoutManager();
            int itemCount = this.repliesList.getAdapter().getItemCount();
            if ((layoutManager instanceof LinearLayoutManager) && itemCount > 0) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(itemCount - 1, SCROLL_TO_END_OFFSET);
            }
        }
    }

    public void sendMessage(TUIMessageBean tUIMessageBean) {
        this.presenter.sendReplyMessage(ChatMessageBuilder.buildReplyMessage(tUIMessageBean.getExtra(), ChatMessageBuilder.buildReplyPreviewBean(this.message)), new IUIKitCallback<TUIMessageBean>() {
            public void onError(String str, int i11, String str2) {
                ToastUtil.toastShortMessage("send reply failed code=" + i11 + " msg=" + str2);
            }

            public void onSuccess(TUIMessageBean tUIMessageBean) {
                MessageReplyDetailActivity.this.scrollToEnd();
            }
        });
    }

    public void updateData(TUIMessageBean tUIMessageBean) {
        this.message = tUIMessageBean;
        initData();
    }
}
