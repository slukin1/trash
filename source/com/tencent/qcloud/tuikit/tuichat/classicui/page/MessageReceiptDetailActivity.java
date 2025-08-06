package com.tencent.qcloud.tuikit.tuichat.classicui.page;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuikit.timcommon.component.TitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.timcommon.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.GroupMessageReadMembersInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.presenter.MessageReceiptPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageReceiptDetailActivity extends BaseLightActivity {
    /* access modifiers changed from: private */
    public static final String TAG = "MessageReceiptDetailActivity";
    private View c2cDetailArea;
    private ChatInfo chatInfo;
    private View groupDetailArea;
    private TUIMessageBean messageBean;
    private TextView msgAbstract;
    private ImageView msgAbstractImg;
    private TextView nameTv;
    private MessageReceiptPresenter presenter;
    /* access modifiers changed from: private */
    public MemberAdapter readAdapter;
    /* access modifiers changed from: private */
    public boolean readFinished = false;
    /* access modifiers changed from: private */
    public RecyclerView readList;
    /* access modifiers changed from: private */
    public boolean readLoading = false;
    /* access modifiers changed from: private */
    public final List<GroupMemberInfo> readMemberList = new ArrayList();
    /* access modifiers changed from: private */
    public long readNextSeq;
    private View readTitle;
    /* access modifiers changed from: private */
    public View readTitleLine;
    /* access modifiers changed from: private */
    public TextView readTitleTv;
    private TextView timeTv;
    private TitleBarLayout titleBarLayout;
    /* access modifiers changed from: private */
    public MemberAdapter unreadAdapter;
    /* access modifiers changed from: private */
    public boolean unreadFinished = false;
    /* access modifiers changed from: private */
    public RecyclerView unreadList;
    /* access modifiers changed from: private */
    public boolean unreadLoading = false;
    /* access modifiers changed from: private */
    public final List<GroupMemberInfo> unreadMemberList = new ArrayList();
    /* access modifiers changed from: private */
    public long unreadNextSeq;
    private View unreadTitle;
    /* access modifiers changed from: private */
    public View unreadTitleLine;
    /* access modifiers changed from: private */
    public TextView unreadTitleTv;
    private ImageView userFace;
    private TextView userName;

    public static class MemberAdapter extends RecyclerView.Adapter<MemberViewHolder> {
        private List<GroupMemberInfo> data;

        public static class MemberViewHolder extends RecyclerView.ViewHolder {
            /* access modifiers changed from: private */
            public final ImageView face;
            /* access modifiers changed from: private */
            public final TextView name;

            public MemberViewHolder(View view) {
                super(view);
                this.face = (ImageView) view.findViewById(R.id.avatar_img);
                this.name = (TextView) view.findViewById(R.id.name_tv);
            }
        }

        private String getDisplayName(GroupMemberInfo groupMemberInfo) {
            if (!TextUtils.isEmpty(groupMemberInfo.getNameCard())) {
                return groupMemberInfo.getNameCard();
            }
            if (!TextUtils.isEmpty(groupMemberInfo.getFriendRemark())) {
                return groupMemberInfo.getFriendRemark();
            }
            if (!TextUtils.isEmpty(groupMemberInfo.getNickName())) {
                return groupMemberInfo.getNickName();
            }
            return groupMemberInfo.getAccount();
        }

        public int getItemCount() {
            List<GroupMemberInfo> list = this.data;
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return this.data.size();
        }

        public void setData(List<GroupMemberInfo> list) {
            this.data = list;
        }

        public void onBindViewHolder(MemberViewHolder memberViewHolder, int i11) {
            final GroupMemberInfo groupMemberInfo = this.data.get(i11);
            GlideEngine.loadUserIcon(memberViewHolder.face, groupMemberInfo.getIconUrl());
            memberViewHolder.name.setText(getDisplayName(groupMemberInfo));
            memberViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString("chatId", groupMemberInfo.getAccount());
                    TUICore.startActivity("FriendProfileActivity", bundle);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }

        public MemberViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new MemberViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.group_receipt_member_item, viewGroup, false));
        }
    }

    private ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams layoutParams, TUIMessageBean tUIMessageBean) {
        int i11;
        int i12;
        if (tUIMessageBean instanceof ImageMessageBean) {
            ImageMessageBean imageMessageBean = (ImageMessageBean) tUIMessageBean;
            i12 = imageMessageBean.getImgWidth();
            i11 = imageMessageBean.getImgHeight();
        } else {
            VideoMessageBean videoMessageBean = (VideoMessageBean) tUIMessageBean;
            i12 = videoMessageBean.getImgWidth();
            i11 = videoMessageBean.getImgHeight();
        }
        if (!(i12 == 0 || i11 == 0)) {
            int dip2px = ScreenUtil.dip2px(40.32f);
            if (i12 > i11) {
                layoutParams.width = dip2px;
                layoutParams.height = (dip2px * i11) / i12;
            } else {
                layoutParams.width = (i12 * dip2px) / i11;
                layoutParams.height = dip2px;
            }
        }
        return layoutParams;
    }

    private void initData() {
        Intent intent = getIntent();
        this.messageBean = (TUIMessageBean) intent.getSerializableExtra("messageBean");
        this.chatInfo = (ChatInfo) intent.getSerializableExtra(TUIChatConstants.CHAT_INFO);
        this.presenter = new MessageReceiptPresenter();
        setMsgAbstract();
        this.nameTv.setText(this.messageBean.getUserDisplayName());
        this.timeTv.setText(DateTimeUtil.getTimeFormatText(new Date(this.messageBean.getMessageTime() * 1000)));
        if (!this.messageBean.isGroup()) {
            setUserDetail(this.messageBean);
            return;
        }
        this.readAdapter = new MemberAdapter();
        this.unreadAdapter = new MemberAdapter();
        this.readList.setLayoutManager(new CustomLinearLayoutManager(this));
        this.unreadList.setLayoutManager(new CustomLinearLayoutManager(this));
        this.readList.setAdapter(this.readAdapter);
        this.unreadList.setAdapter(this.unreadAdapter);
        this.presenter.getGroupMessageReadReceipt(this.messageBean, new IUIKitCallback<List<MessageReceiptInfo>>() {
            public void onError(String str, int i11, String str2) {
            }

            public void onSuccess(List<MessageReceiptInfo> list) {
                MessageReceiptInfo messageReceiptInfo = list.get(0);
                MessageReceiptDetailActivity.this.readTitleTv.setText(MessageReceiptDetailActivity.this.getString(R.string.someone_have_read, new Object[]{Long.valueOf(messageReceiptInfo.getReadCount())}));
                MessageReceiptDetailActivity.this.unreadTitleTv.setText(MessageReceiptDetailActivity.this.getString(R.string.someone_unread, new Object[]{Long.valueOf(messageReceiptInfo.getUnreadCount())}));
            }
        });
        this.readList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
                if (i11 == 0) {
                    MessageReceiptDetailActivity messageReceiptDetailActivity = MessageReceiptDetailActivity.this;
                    if (messageReceiptDetailActivity.isLastItemVisibleCompleted(messageReceiptDetailActivity.readList) && !MessageReceiptDetailActivity.this.readFinished) {
                        MessageReceiptDetailActivity messageReceiptDetailActivity2 = MessageReceiptDetailActivity.this;
                        messageReceiptDetailActivity2.loadGroupMessageReadMembers(messageReceiptDetailActivity2.readNextSeq);
                    }
                }
            }
        });
        this.unreadList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
                if (i11 == 0) {
                    MessageReceiptDetailActivity messageReceiptDetailActivity = MessageReceiptDetailActivity.this;
                    if (messageReceiptDetailActivity.isLastItemVisibleCompleted(messageReceiptDetailActivity.unreadList) && !MessageReceiptDetailActivity.this.unreadFinished) {
                        MessageReceiptDetailActivity messageReceiptDetailActivity2 = MessageReceiptDetailActivity.this;
                        messageReceiptDetailActivity2.loadGroupMessageUnreadMembers(messageReceiptDetailActivity2.unreadNextSeq);
                    }
                }
            }
        });
        loadGroupMessageReadMembers(0);
        loadGroupMessageUnreadMembers(0);
    }

    private void initView() {
        TitleBarLayout titleBarLayout2 = (TitleBarLayout) findViewById(R.id.receipt_title);
        this.titleBarLayout = titleBarLayout2;
        titleBarLayout2.setOnLeftClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                MessageReceiptDetailActivity.this.finish();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.titleBarLayout.setTitle(getString(R.string.chat_message_detail), ITitleBarLayout.Position.MIDDLE);
        this.groupDetailArea = findViewById(R.id.group_read_details);
        this.c2cDetailArea = findViewById(R.id.user_read_detail);
        this.userFace = (ImageView) findViewById(R.id.user_face);
        this.userName = (TextView) findViewById(R.id.user_name_tv);
        this.msgAbstract = (TextView) findViewById(R.id.msg_abstract);
        this.msgAbstractImg = (ImageView) findViewById(R.id.msg_abstract_iv);
        this.nameTv = (TextView) findViewById(R.id.name_tv);
        this.timeTv = (TextView) findViewById(R.id.time_tv);
        this.readTitleTv = (TextView) findViewById(R.id.read_title_tv);
        this.unreadTitleTv = (TextView) findViewById(R.id.unread_title_tv);
        this.readTitleLine = findViewById(R.id.read_title_line);
        this.unreadTitleLine = findViewById(R.id.unread_title_line);
        this.readList = (RecyclerView) findViewById(R.id.read_list);
        this.unreadList = (RecyclerView) findViewById(R.id.unread_list);
        this.readTitle = findViewById(R.id.read_title);
        this.unreadTitle = findViewById(R.id.unread_title);
        this.readTitle.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                MessageReceiptDetailActivity.this.readTitleLine.setVisibility(0);
                MessageReceiptDetailActivity.this.readTitleTv.setTextColor(MessageReceiptDetailActivity.this.getResources().getColor(TUIThemeManager.getAttrResId(MessageReceiptDetailActivity.this, com.tencent.qcloud.tuicore.R.attr.core_primary_color)));
                MessageReceiptDetailActivity.this.readList.setVisibility(0);
                MessageReceiptDetailActivity.this.unreadList.setVisibility(8);
                MessageReceiptDetailActivity.this.unreadTitleLine.setVisibility(4);
                MessageReceiptDetailActivity.this.unreadTitleTv.setTextColor(-12303292);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.unreadTitle.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                MessageReceiptDetailActivity.this.unreadTitleLine.setVisibility(0);
                MessageReceiptDetailActivity.this.unreadTitleTv.setTextColor(MessageReceiptDetailActivity.this.getResources().getColor(TUIThemeManager.getAttrResId(MessageReceiptDetailActivity.this, com.tencent.qcloud.tuicore.R.attr.core_primary_color)));
                MessageReceiptDetailActivity.this.unreadList.setVisibility(0);
                MessageReceiptDetailActivity.this.readList.setVisibility(8);
                MessageReceiptDetailActivity.this.readTitleLine.setVisibility(4);
                MessageReceiptDetailActivity.this.readTitleTv.setTextColor(-12303292);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public void loadGroupMessageReadMembers(long j11) {
        if (!this.readLoading) {
            this.readLoading = true;
            this.presenter.getGroupMessageReadMembers(this.messageBean, true, j11, new IUIKitCallback<GroupMessageReadMembersInfo>() {
                public void onError(String str, int i11, String str2) {
                    boolean unused = MessageReceiptDetailActivity.this.readLoading = false;
                    String access$1500 = MessageReceiptDetailActivity.TAG;
                    TUIChatLog.e(access$1500, "errCode " + i11 + " errMsg " + str2);
                }

                public void onSuccess(GroupMessageReadMembersInfo groupMessageReadMembersInfo) {
                    long unused = MessageReceiptDetailActivity.this.readNextSeq = groupMessageReadMembersInfo.getNextSeq();
                    boolean unused2 = MessageReceiptDetailActivity.this.readFinished = groupMessageReadMembersInfo.isFinished();
                    MessageReceiptDetailActivity.this.readMemberList.addAll(groupMessageReadMembersInfo.getGroupMemberInfoList());
                    MessageReceiptDetailActivity.this.readAdapter.setData(MessageReceiptDetailActivity.this.readMemberList);
                    MessageReceiptDetailActivity.this.readAdapter.notifyDataSetChanged();
                    boolean unused3 = MessageReceiptDetailActivity.this.readLoading = false;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void loadGroupMessageUnreadMembers(long j11) {
        if (!this.unreadLoading) {
            this.unreadLoading = true;
            this.presenter.getGroupMessageReadMembers(this.messageBean, false, j11, new IUIKitCallback<GroupMessageReadMembersInfo>() {
                public void onError(String str, int i11, String str2) {
                    boolean unused = MessageReceiptDetailActivity.this.unreadLoading = false;
                    String access$1500 = MessageReceiptDetailActivity.TAG;
                    TUIChatLog.e(access$1500, "errCode " + i11 + " errMsg " + str2);
                }

                public void onSuccess(GroupMessageReadMembersInfo groupMessageReadMembersInfo) {
                    long unused = MessageReceiptDetailActivity.this.unreadNextSeq = groupMessageReadMembersInfo.getNextSeq();
                    boolean unused2 = MessageReceiptDetailActivity.this.unreadFinished = groupMessageReadMembersInfo.isFinished();
                    MessageReceiptDetailActivity.this.unreadMemberList.addAll(groupMessageReadMembersInfo.getGroupMemberInfoList());
                    MessageReceiptDetailActivity.this.unreadAdapter.setData(MessageReceiptDetailActivity.this.unreadMemberList);
                    MessageReceiptDetailActivity.this.unreadAdapter.notifyDataSetChanged();
                    boolean unused3 = MessageReceiptDetailActivity.this.unreadLoading = false;
                }
            });
        }
    }

    private void setMsgAbstract() {
        TUIMessageBean tUIMessageBean = this.messageBean;
        if ((tUIMessageBean instanceof ImageMessageBean) || (tUIMessageBean instanceof VideoMessageBean)) {
            ImageView imageView = this.msgAbstractImg;
            imageView.setLayoutParams(getImageParams(imageView.getLayoutParams(), this.messageBean));
            this.msgAbstractImg.setVisibility(0);
            TUIMessageBean tUIMessageBean2 = this.messageBean;
            if (tUIMessageBean2 instanceof ImageMessageBean) {
                GlideEngine.loadImage(this.msgAbstractImg, ((ImageMessageBean) tUIMessageBean2).getDataPath());
            } else if (tUIMessageBean2 instanceof VideoMessageBean) {
                GlideEngine.loadImage(this.msgAbstractImg, ((VideoMessageBean) tUIMessageBean2).getDataPath());
            }
            this.msgAbstract.setText("");
            return;
        }
        this.msgAbstractImg.setVisibility(8);
        TUIMessageBean tUIMessageBean3 = this.messageBean;
        if (tUIMessageBean3 instanceof FileMessageBean) {
            TextView textView = this.msgAbstract;
            textView.setText(this.messageBean.getExtra() + ((FileMessageBean) this.messageBean).getFileName());
            return;
        }
        FaceManager.handlerEmojiText(this.msgAbstract, tUIMessageBean3.getExtra(), false);
    }

    private void setUserDetail(TUIMessageBean tUIMessageBean) {
        this.groupDetailArea.setVisibility(8);
        this.c2cDetailArea.setVisibility(0);
        final String userId = tUIMessageBean.getUserId();
        ChatInfo chatInfo2 = this.chatInfo;
        if (chatInfo2 != null) {
            GlideEngine.loadUserIcon(this.userFace, chatInfo2.getFaceUrl());
            this.userName.setText(this.chatInfo.getChatName());
        }
        this.c2cDetailArea.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("chatId", userId);
                TUICore.startActivity("FriendProfileActivity", bundle);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    public boolean isLastItemVisibleCompleted(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager == null) {
            return false;
        }
        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() >= (linearLayoutManager.findFirstVisibleItemPosition() + linearLayoutManager.getChildCount()) - 1) {
            return true;
        }
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = TAG;
        TUIChatLog.i(str, "onCreate " + this);
        setContentView(R.layout.msg_receipt_detail_layout);
        initView();
        initData();
    }
}
