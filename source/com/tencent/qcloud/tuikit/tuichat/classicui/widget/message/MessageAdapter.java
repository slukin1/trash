package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageBaseHolder;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageContentHolder;
import com.tencent.qcloud.tuikit.timcommon.component.fragments.BaseFragment;
import com.tencent.qcloud.tuikit.timcommon.interfaces.ICommonMessageAdapter;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.timcommon.util.ThreadUtils;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.ClassicUIService;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageHeaderHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageViewHolderFactory;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter implements IMessageAdapter, ICommonMessageAdapter {
    private static final int ITEM_POSITION_UNKNOWN = -1;
    private static final String TAG = "MessageAdapter";
    private BaseFragment fragment;
    private boolean isForwardMode = false;
    private boolean isReplyDetailMode = false;
    public boolean isShowMultiSelectCheckBox = false;
    private List<TUIMessageBean> mDataSource = new ArrayList();
    private int mHighShowPosition;
    private boolean mLoading = true;
    private OnItemClickListener mOnItemClickListener;
    private MessageRecyclerView mRecycleView;
    private HashMap<String, Boolean> mSelectedPositions = new HashMap<>();
    private ChatPresenter presenter;

    private int getMessagePosition(TUIMessageBean tUIMessageBean) {
        int indexOf;
        List<TUIMessageBean> list = this.mDataSource;
        if (list == null || list.isEmpty() || (indexOf = this.mDataSource.indexOf(tUIMessageBean)) == -1) {
            return -1;
        }
        return indexOf + 1;
    }

    private boolean isItemChecked(String str) {
        if (this.mSelectedPositions.size() > 0 && this.mSelectedPositions.containsKey(str)) {
            return this.mSelectedPositions.get(str).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewNeedRefresh$0(int i11, TUIMessageBean tUIMessageBean) {
        this.mLoading = false;
        refreshLoadView();
        if (i11 == 7) {
            notifyDataSetChanged();
            int messagePosition = getMessagePosition(tUIMessageBean);
            if (messagePosition != -1) {
                this.mRecycleView.scrollToPosition(messagePosition);
                this.mRecycleView.setHighShowPosition(messagePosition);
            }
        } else if (i11 == 9) {
            int messagePosition2 = getMessagePosition(tUIMessageBean);
            if (messagePosition2 != -1) {
                this.mRecycleView.scrollToPosition(messagePosition2);
                this.mRecycleView.setHighShowPosition(messagePosition2);
                notifyItemChanged(messagePosition2);
                this.mRecycleView.scrollMessageFinish();
            }
        } else if (i11 == 10) {
            notifyDataSetChanged();
            int messagePosition3 = getMessagePosition(tUIMessageBean);
            if (messagePosition3 != -1) {
                this.mRecycleView.scrollToEnd();
                this.mRecycleView.smoothScrollToPosition(messagePosition3);
                this.mRecycleView.setHighShowPosition(messagePosition3);
                notifyItemChanged(messagePosition3);
                this.mRecycleView.scrollMessageFinish();
            }
        } else if (i11 == 4) {
            int messagePosition4 = getMessagePosition(tUIMessageBean);
            if (messagePosition4 != -1) {
                notifyItemChanged(messagePosition4);
            }
        } else if (i11 == 11) {
            notifyDataSetChanged();
            int messagePosition5 = getMessagePosition(tUIMessageBean);
            if (messagePosition5 != -1) {
                this.mRecycleView.scrollToPosition(messagePosition5);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewNeedRefresh$1(int i11, int i12) {
        this.mLoading = false;
        if (i11 == 0) {
            notifyDataSetChanged();
            this.mRecycleView.scrollToEnd();
        } else if (i11 == 3) {
            notifyItemRangeInserted(this.mDataSource.size() + 1, i12);
        } else if (i11 == 8) {
            notifyItemRangeInserted(this.mDataSource.size() + 1, i12);
            this.mRecycleView.onMsgAddBack();
        } else if (i11 == 4) {
            notifyDataSetChanged();
        } else if (i11 == 2) {
            if (i12 != 0) {
                notifyItemRangeInserted(0, i12);
            }
        } else if (i11 == 1) {
            notifyDataSetChanged();
            this.mRecycleView.scrollToEnd();
            this.mRecycleView.loadMessageFinish();
        } else if (i11 == 5) {
            if (i12 != -1) {
                notifyItemRemoved(getViewPositionByDataPosition(i12));
            } else {
                return;
            }
        }
        refreshLoadView();
    }

    private void refreshLoadView() {
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
                    MessageAdapter.this.changeCheckedStatus(str, i11);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            messageBaseHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    MessageAdapter.this.changeCheckedStatus(str, i11);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            messageBaseHolder.setOnItemClickListener(new OnItemClickListener() {
                public void onMessageClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                    MessageAdapter.this.changeCheckedStatus(str, i11);
                }

                public void onMessageLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                }

                public void onReEditRevokeMessage(View view, int i11, TUIMessageBean tUIMessageBean) {
                }

                public void onRecallClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                }

                public void onReplyMessageClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                    MessageAdapter.this.changeCheckedStatus(str, i11);
                }

                public void onUserIconClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                    MessageAdapter.this.changeCheckedStatus(str, i11);
                }

                public void onUserIconLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                    MessageAdapter.this.changeCheckedStatus(str, i11);
                }
            });
            FrameLayout frameLayout2 = messageBaseHolder.msgContentFrame;
            if (frameLayout2 != null) {
                frameLayout2.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        MessageAdapter.this.changeCheckedStatus(str, i11);
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

    public List<TUIMessageBean> getItemList(int i11, int i12) {
        if (i11 < 0 || i12 < 0) {
            return new ArrayList(0);
        }
        if (i11 == 0) {
            i11 = 1;
        }
        if (i12 == 0) {
            i12 = 1;
        }
        List<TUIMessageBean> list = this.mDataSource;
        if (list == null || list.size() == 0 || i11 > i12) {
            return new ArrayList(0);
        }
        if (i11 >= this.mDataSource.size() + 1 || i12 >= this.mDataSource.size() + 1) {
            return new ArrayList(0);
        }
        return new ArrayList(this.mDataSource.subList(i11 - 1, i12));
    }

    public int getItemViewType(int i11) {
        if (i11 == 0) {
            return -99;
        }
        TUIMessageBean item = getItem(i11);
        if (item.getStatus() == 275) {
            return ClassicUIService.getInstance().getViewType(TipsMessageBean.class);
        }
        return ClassicUIService.getInstance().getViewType(item.getClass());
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

    public int getViewPositionByDataPosition(int i11) {
        if (i11 == -1) {
            return -1;
        }
        return i11 + 1;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        MessageRecyclerView messageRecyclerView = (MessageRecyclerView) recyclerView;
        this.mRecycleView = messageRecyclerView;
        messageRecyclerView.setItemViewCacheSize(5);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        TUIMessageBean item = getItem(i11);
        if (viewHolder instanceof MessageBaseHolder) {
            if (viewHolder instanceof MessageContentHolder) {
                ((MessageContentHolder) viewHolder).isMultiSelectMode = this.isShowMultiSelectCheckBox;
            }
            MessageBaseHolder messageBaseHolder = (MessageBaseHolder) viewHolder;
            messageBaseHolder.setOnItemClickListener(this.mOnItemClickListener);
            setCheckBoxStatus(i11, item != null ? item.getId() : "", messageBaseHolder);
            messageBaseHolder.layoutViews(item, i11);
            if (getItemViewType(i11) == -99) {
                if (this.isForwardMode) {
                    ((MessageHeaderHolder) messageBaseHolder).setLoadingStatus(false);
                } else {
                    ((MessageHeaderHolder) messageBaseHolder).setLoadingStatus(this.mLoading);
                }
            } else if (i11 == this.mHighShowPosition && messageBaseHolder.mContentLayout != null) {
                messageBaseHolder.startHighLight();
                this.mHighShowPosition = -1;
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        RecyclerView.ViewHolder instance = MessageViewHolderFactory.getInstance(viewGroup, this, i11);
        if (instance instanceof MessageContentHolder) {
            MessageContentHolder messageContentHolder = (MessageContentHolder) instance;
            messageContentHolder.isForwardMode = this.isForwardMode;
            messageContentHolder.isReplyDetailMode = this.isReplyDetailMode;
            messageContentHolder.setShowRead(TUIChatConfigs.getConfigs().getGeneralConfig().isShowRead());
            messageContentHolder.setNeedShowTranslation(this.presenter.isNeedShowTranslation());
            messageContentHolder.setRecyclerView(this.mRecycleView);
            messageContentHolder.setFragment(this.fragment);
            if (this.isForwardMode) {
                messageContentHolder.setDataSource(this.mDataSource);
            }
        }
        return instance;
    }

    public void onDataSourceChanged(List<TUIMessageBean> list) {
        this.mDataSource = list;
    }

    public void onScrollToEnd() {
        MessageRecyclerView messageRecyclerView = this.mRecycleView;
        if (messageRecyclerView != null) {
            messageRecyclerView.scrollToEnd();
        }
    }

    public void onViewNeedRefresh(int i11, TUIMessageBean tUIMessageBean) {
        ThreadUtils.postOnUiThread(new b(this, i11, tUIMessageBean));
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MessageContentHolder) {
            MessageContentHolder messageContentHolder = (MessageContentHolder) viewHolder;
            messageContentHolder.msgArea.setBackground((Drawable) null);
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
            } else if (findViewHolderForAdapterPosition instanceof MessageContentHolder) {
                ((MessageContentHolder) findViewHolderForAdapterPosition).resetSelectableText();
            }
        }
    }

    public void setForwardMode(boolean z11) {
        this.isForwardMode = z11;
    }

    public void setFragment(BaseFragment baseFragment) {
        this.fragment = baseFragment;
    }

    public void setHighShowPosition(int i11) {
        this.mHighShowPosition = i11;
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

    public void setReplyDetailMode(boolean z11) {
        this.isReplyDetailMode = z11;
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

    public void onViewNeedRefresh(int i11, int i12) {
        ThreadUtils.postOnUiThread(new a(this, i11, i12));
    }
}
