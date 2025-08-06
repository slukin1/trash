package com.hbg.module.huobi.im.group.ui.chat;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.group.bean.HbAccountManagerUnreadBean;
import com.hbg.module.huobi.im.group.bean.HbImageMessageBean;
import com.hbg.module.huobi.im.group.bean.HbShareMessageBean;
import com.hbg.module.huobi.im.group.bean.HbSharePrimeMessageBean;
import com.hbg.module.huobi.im.group.bean.HbShareTextMessageBean;
import com.hbg.module.huobi.im.group.bean.HbSoundMessageBean;
import com.hbg.module.huobi.im.group.bean.HbTextMessageBean;
import com.hbg.module.huobi.im.group.bean.HbTipMessageBean;
import com.hbg.module.huobi.im.utils.HbGroupUserManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageBaseHolder;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageContentHolder;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.HbNoticeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageHeaderHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageViewHolderFactory;
import com.tencent.qcloud.tuikit.tuichat.manager.HbGroupChatManager;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HbChatMessageAdapter extends MessageAdapter {
    private static final String TAG = "HbChatMessageAdapter";
    public long atSeq = -1;
    private boolean isForwardMode = false;
    private boolean isGroup = true;
    public boolean isShowMultiSelectCheckBox = false;
    /* access modifiers changed from: private */
    public List<TUIMessageBean> mDataSource = new ArrayList();
    private int mHighShowPosition;
    /* access modifiers changed from: private */
    public boolean mLoading = true;
    private OnItemClickListener mOnItemClickListener;
    /* access modifiers changed from: private */
    public MessageRecyclerView mRecycleView;
    private HashMap<String, Boolean> mSelectedPositions = new HashMap<>();
    private ChatPresenter presenter;

    public HbChatMessageAdapter() {
        HbGroupChatManager.getInstance().addCustomViewType("hb_group_chat_text", HbTextMessageBean.class, HbTextMessageHolder.class);
        HbGroupChatManager.getInstance().addCustomViewType("hb_group_notice_text", HbNoticeMessageBean.class, HbNoticeMessageHolder.class);
        HbGroupChatManager.getInstance().addCustomViewType("hb_group_chat_image", HbImageMessageBean.class, HbImageMessageHolder.class);
        HbGroupChatManager.getInstance().addCustomViewType("hb_group_chat_sound", HbSoundMessageBean.class, HbSoundMessageHolder.class);
        HbGroupChatManager.getInstance().addCustomViewType("huobi_group_business_share", HbShareMessageBean.class, HbShareMessageHolder.class);
        HbGroupChatManager.getInstance().addCustomViewType("huobi_group_business_share_text", HbShareTextMessageBean.class, HbShareTextMessageHolder.class);
        HbGroupChatManager.getInstance().addCustomViewType("hb_group_tips_text", HbTipMessageBean.class, HbTipsMessageHolder.class);
        HbGroupChatManager.getInstance().addCustomViewType("huobi_live_timeout_unread", HbAccountManagerUnreadBean.class, HbAccountManagerUnreadHolder.class);
        HbGroupChatManager.getInstance().addCustomViewType("huobi_group_business_share_prime", HbSharePrimeMessageBean.class, HbSharePrimeMessageHolder.class);
    }

    private boolean isItemChecked(String str) {
        if (this.mSelectedPositions.size() > 0 && this.mSelectedPositions.containsKey(str)) {
            return this.mSelectedPositions.get(str).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void refreshLoadView() {
        notifyItemChanged(0);
    }

    private void setCheckBoxStatus(final int i11, final String str, MessageBaseHolder messageBaseHolder) {
        CheckBox checkBox = messageBaseHolder.mMutiSelectCheckBox;
        if (checkBox != null) {
            if (!this.isShowMultiSelectCheckBox) {
                checkBox.setVisibility(8);
                messageBaseHolder.setOnItemClickListener(this.mOnItemClickListener);
                FrameLayout frameLayout = messageBaseHolder.msgContentFrame;
                if (frameLayout != null) {
                    frameLayout.setOnClickListener((View.OnClickListener) null);
                    return;
                }
                return;
            }
            checkBox.setVisibility(0);
            messageBaseHolder.mMutiSelectCheckBox.setChecked(isItemChecked(str));
            messageBaseHolder.mMutiSelectCheckBox.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    HbChatMessageAdapter.this.changeCheckedStatus(str, i11);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            messageBaseHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    HbChatMessageAdapter.this.changeCheckedStatus(str, i11);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            messageBaseHolder.setOnItemClickListener(new OnItemClickListener() {
                public void onMessageClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                    HbChatMessageAdapter.this.changeCheckedStatus(str, i11);
                }

                public void onMessageLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                }

                public void onReEditRevokeMessage(View view, int i11, TUIMessageBean tUIMessageBean) {
                }

                public void onRecallClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                }

                public void onReplyMessageClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                    HbChatMessageAdapter.this.changeCheckedStatus(str, i11);
                }

                public void onUserIconClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                    HbChatMessageAdapter.this.changeCheckedStatus(str, i11);
                }

                public void onUserIconLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                    HbChatMessageAdapter.this.changeCheckedStatus(str, i11);
                }
            });
            FrameLayout frameLayout2 = messageBaseHolder.msgContentFrame;
            if (frameLayout2 != null) {
                frameLayout2.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        HbChatMessageAdapter.this.changeCheckedStatus(str, i11);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
            }
        }
    }

    public void changeCheckedStatus(String str, int i11) {
        if (isItemChecked(str)) {
            setItemChecked(str, false);
        } else {
            setItemChecked(str, true);
        }
        notifyItemChanged(i11);
    }

    public TUIMessageBean getItem(int i11) {
        List<TUIMessageBean> list;
        if (i11 == 0 || (list = this.mDataSource) == null || list.size() == 0 || i11 >= this.mDataSource.size() + 1) {
            return null;
        }
        return this.mDataSource.get(i11 - 1);
    }

    public int getItemCount() {
        return this.mDataSource.size() + 1;
    }

    public int getItemViewType(int i11) {
        if (i11 == 0) {
            return -99;
        }
        TUIMessageBean item = getItem(i11);
        if (item.getStatus() == 275) {
            return TUIChatService.getInstance().getViewType(TipsMessageBean.class);
        }
        if (item.getV2TIMMessage() == null || item.getV2TIMMessage().getStatus() != 5) {
            if (item.getBusinessID() != null && item.getBusinessID().equals("huobi_group_business_share_prime")) {
                return TUIChatService.getInstance().getViewType(HbSharePrimeMessageBean.class);
            }
        } else if (item.getMsgType() == 1) {
            return TUIChatService.getInstance().getViewType(HbTipMessageBean.class);
        }
        return TUIChatService.getInstance().getViewType(item.getClass());
    }

    public int getMessagePosition(TUIMessageBean tUIMessageBean) {
        List<TUIMessageBean> list = this.mDataSource;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.mDataSource.size(); i12++) {
            if (TextUtils.equals(this.mDataSource.get(i12).getId(), tUIMessageBean.getId())) {
                i11 = i12;
            }
        }
        return i11 + 1;
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public ArrayList<TUIMessageBean> getSelectedItem() {
        HashMap<String, Boolean> hashMap = this.mSelectedPositions;
        if (hashMap == null || hashMap.size() == 0) {
            return null;
        }
        ArrayList<TUIMessageBean> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < getItemCount() - 1; i11++) {
            if (isItemChecked(this.mDataSource.get(i11).getId())) {
                arrayList.add(this.mDataSource.get(i11));
            }
        }
        return arrayList;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        MessageRecyclerView messageRecyclerView = (MessageRecyclerView) recyclerView;
        this.mRecycleView = messageRecyclerView;
        messageRecyclerView.setItemViewCacheSize(5);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        ImageView imageView;
        TUIMessageBean item = getItem(i11);
        if (viewHolder instanceof MessageBaseHolder) {
            if (!(item == null || item.getV2TIMMessage() == null || this.atSeq != item.getV2TIMMessage().getSeq())) {
                View view = ((MessageBaseHolder) viewHolder).mContentLayout;
                ValueAnimator ofArgb = ValueAnimator.ofArgb(new int[]{ContextCompat.getColor(view.getContext(), R$color.baseColorSecondaryBackground), 0});
                ofArgb.setDuration(2000);
                ofArgb.addUpdateListener(new k(view, ofArgb));
                ofArgb.start();
                this.atSeq = -1;
            }
            boolean z11 = viewHolder instanceof MessageContentHolder;
            if (z11) {
                ((MessageContentHolder) viewHolder).isMultiSelectMode = this.isShowMultiSelectCheckBox;
            }
            MessageBaseHolder messageBaseHolder = (MessageBaseHolder) viewHolder;
            messageBaseHolder.setOnItemClickListener(this.mOnItemClickListener);
            String id2 = item != null ? item.getId() : "";
            if (z11 && (imageView = (ImageView) ((MessageContentHolder) viewHolder).itemView.findViewById(R$id.iv_user_tag)) != null) {
                if (item.isSelf() || !this.isGroup) {
                    imageView.setVisibility(8);
                } else if (HbGroupUserManager.c().d(item.getSender())) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
            }
            if (viewHolder instanceof HbMessageContentHolder) {
                ((HbMessageContentHolder) viewHolder).setGroup(this.isGroup);
            }
            if (getItemViewType(i11) != -99) {
                if (i11 == this.mHighShowPosition && messageBaseHolder.mContentLayout != null) {
                    messageBaseHolder.startHighLight();
                    this.mHighShowPosition = -1;
                }
            } else if (this.isForwardMode) {
                ((MessageHeaderHolder) messageBaseHolder).setLoadingStatus(false);
            } else {
                ((MessageHeaderHolder) messageBaseHolder).setLoadingStatus(this.mLoading);
            }
            setCheckBoxStatus(i11, id2, messageBaseHolder);
            messageBaseHolder.layoutViews(item, i11);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        RecyclerView.ViewHolder instance = MessageViewHolderFactory.getInstance(viewGroup, this, i11);
        if (instance instanceof MessageContentHolder) {
            MessageContentHolder messageContentHolder = (MessageContentHolder) instance;
            boolean z11 = this.isForwardMode;
            messageContentHolder.isForwardMode = z11;
            if (z11) {
                messageContentHolder.setDataSource(this.mDataSource);
            }
        }
        return instance;
    }

    public void onDataSourceChanged(List<TUIMessageBean> list) {
        List<TUIMessageBean> list2 = list;
        Iterator<TUIMessageBean> it2 = list.iterator();
        while (it2.hasNext()) {
            TUIMessageBean next = it2.next();
            if (!(next.getMsgType() == 1 || next.getMsgType() == 3 || next.getMsgType() == 4)) {
                it2.remove();
            }
        }
        Collections.sort(list2, l.f20449b);
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        Calendar calendar = (Calendar) instance.clone();
        calendar.add(6, -1);
        long timeInMillis2 = calendar.getTimeInMillis();
        long j11 = -1;
        for (int i11 = 0; i11 < list.size(); i11++) {
            TUIMessageBean tUIMessageBean = list2.get(i11);
            long messageTime = tUIMessageBean.getMessageTime() * 1000;
            long j12 = ((messageTime > timeInMillis ? 1 : (messageTime == timeInMillis ? 0 : -1)) >= 0 ? 0 : (messageTime > timeInMillis2 ? 1 : (messageTime == timeInMillis2 ? 0 : -1)) >= 0 ? (char) 1 : 2) <= 1 ? 600000 : Period.MIN60_MILLS;
            if (i11 == 0 || messageTime - j11 > j12) {
                tUIMessageBean.setShowTime(true);
                j11 = messageTime;
            } else {
                tUIMessageBean.setShowTime(false);
            }
        }
        this.mDataSource = list2;
    }

    public void onScrollToEnd() {
        MessageRecyclerView messageRecyclerView = this.mRecycleView;
        if (messageRecyclerView != null) {
            messageRecyclerView.scrollToEnd();
        }
    }

    public void onViewNeedRefresh(final int i11, final TUIMessageBean tUIMessageBean) {
        BackgroundTasks.getInstance().runOnUiThread(new Runnable() {
            public void run() {
                boolean unused = HbChatMessageAdapter.this.mLoading = false;
                int i11 = i11;
                if (i11 == 7) {
                    HbChatMessageAdapter.this.notifyDataSetChanged();
                    int messagePosition = HbChatMessageAdapter.this.getMessagePosition(tUIMessageBean);
                    HbChatMessageAdapter.this.mRecycleView.scrollToPosition(messagePosition);
                    HbChatMessageAdapter.this.mRecycleView.setHighShowPosition(messagePosition);
                } else if (i11 == 9) {
                    int messagePosition2 = HbChatMessageAdapter.this.getMessagePosition(tUIMessageBean);
                    HbChatMessageAdapter.this.mRecycleView.setHighShowPosition(messagePosition2);
                    HbChatMessageAdapter.this.mRecycleView.scrollToPosition(messagePosition2);
                    HbChatMessageAdapter.this.notifyItemChanged(messagePosition2);
                    HbChatMessageAdapter.this.mRecycleView.scrollMessageFinish();
                } else if (i11 == 10) {
                    HbChatMessageAdapter.this.notifyDataSetChanged();
                    int messagePosition3 = HbChatMessageAdapter.this.getMessagePosition(tUIMessageBean);
                    HbChatMessageAdapter.this.mRecycleView.setHighShowPosition(messagePosition3);
                    HbChatMessageAdapter.this.mRecycleView.scrollToEnd();
                    HbChatMessageAdapter.this.mRecycleView.smoothScrollToPosition(messagePosition3);
                    HbChatMessageAdapter.this.notifyItemChanged(messagePosition3);
                    HbChatMessageAdapter.this.mRecycleView.scrollMessageFinish();
                } else if (i11 == 4) {
                    HbChatMessageAdapter.this.notifyItemChanged(HbChatMessageAdapter.this.getMessagePosition(tUIMessageBean));
                }
            }
        });
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MessageContentHolder) {
            MessageContentHolder messageContentHolder = (MessageContentHolder) viewHolder;
            messageContentHolder.msgContentFrame.setBackground((Drawable) null);
            messageContentHolder.stopHighLight();
            messageContentHolder.onRecycled();
        }
    }

    public void resetSelectableText() {
        int selectedPosition = this.mRecycleView.getSelectedPosition();
        if (selectedPosition >= 0) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.mRecycleView.findViewHolderForAdapterPosition(selectedPosition);
            if (findViewHolderForAdapterPosition == null) {
                TUIChatLog.d(TAG, "holder == null");
            } else if (findViewHolderForAdapterPosition instanceof HbTextMessageHolder) {
                ((HbTextMessageHolder) findViewHolderForAdapterPosition).resetSelectableText();
            }
        }
    }

    public void setForwardMode(boolean z11) {
        this.isForwardMode = z11;
    }

    public void setHighShowPosition(int i11) {
        this.mHighShowPosition = i11;
    }

    public void setIsGroup(boolean z11) {
        this.isGroup = z11;
        notifyDataSetChanged();
    }

    public void setItemChecked(String str, boolean z11) {
        HashMap<String, Boolean> hashMap = this.mSelectedPositions;
        if (hashMap != null) {
            hashMap.put(str, Boolean.valueOf(z11));
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
    }

    public void setShowMultiSelectCheckBox(boolean z11) {
        HashMap<String, Boolean> hashMap;
        this.isShowMultiSelectCheckBox = z11;
        if (!z11 && (hashMap = this.mSelectedPositions) != null) {
            hashMap.clear();
        }
    }

    public void showLoading() {
        if (!this.isForwardMode && !this.mLoading) {
            this.mLoading = true;
            notifyItemChanged(0);
        }
    }

    public void onViewNeedRefresh(final int i11, final int i12) {
        BackgroundTasks.getInstance().postDelayed(new Runnable() {
            public void run() {
                boolean unused = HbChatMessageAdapter.this.mLoading = false;
                int i11 = i11;
                if (i11 == 0) {
                    HbChatMessageAdapter.this.notifyDataSetChanged();
                    HbChatMessageAdapter.this.mRecycleView.scrollToEnd();
                } else if (i11 == 3) {
                    HbChatMessageAdapter hbChatMessageAdapter = HbChatMessageAdapter.this;
                    hbChatMessageAdapter.notifyItemRangeInserted(hbChatMessageAdapter.mDataSource.size() + 1, i12);
                } else if (i11 == 8) {
                    HbChatMessageAdapter hbChatMessageAdapter2 = HbChatMessageAdapter.this;
                    hbChatMessageAdapter2.notifyItemRangeInserted(hbChatMessageAdapter2.mDataSource.size() + 1, i12);
                    HbChatMessageAdapter.this.mRecycleView.onMsgAddBack();
                } else if (i11 == 4) {
                    HbChatMessageAdapter.this.notifyDataSetChanged();
                } else if (i11 == 2) {
                    if (i12 != 0) {
                        int itemCount = HbChatMessageAdapter.this.getItemCount();
                        int i12 = i12;
                        if (itemCount > i12) {
                            HbChatMessageAdapter.this.notifyItemRangeInserted(0, i12);
                        } else {
                            HbChatMessageAdapter.this.notifyItemRangeInserted(0, i12);
                        }
                    }
                } else if (i11 == 5) {
                    HbChatMessageAdapter.this.notifyItemRemoved(i12);
                    HbChatMessageAdapter.this.notifyDataSetChanged();
                } else if (i11 == 1) {
                    HbChatMessageAdapter.this.notifyDataSetChanged();
                    HbChatMessageAdapter.this.mRecycleView.scrollToEnd();
                    HbChatMessageAdapter.this.mRecycleView.loadMessageFinish();
                }
                HbChatMessageAdapter.this.refreshLoadView();
            }
        }, 100);
    }
}
