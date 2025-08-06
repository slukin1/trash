package com.tencent.qcloud.tuikit.tuicallkit.extensions.recents;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.extensions.recents.interfaces.ICallRecordItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecentCallsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int HEADER_COUNT = 1;
    private static final int ITEM_TYPE_HEADER = 101;
    private static final int ITEM_TYPE_NORMAL = -98;
    private Context mContext;
    private List<TUICallDefine.CallRecords> mDataSource = new ArrayList();
    private boolean mIsMultiSelectMode = false;
    private ICallRecordItemListener mItemListener;
    private HashMap<String, Boolean> mSelectedPositions = new HashMap<>();

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    private int getIndexInAdapter(TUICallDefine.CallRecords callRecords) {
        int indexOf;
        List<TUICallDefine.CallRecords> list = this.mDataSource;
        if (list == null || (indexOf = list.indexOf(callRecords)) == -1) {
            return -1;
        }
        return indexOf + 1;
    }

    private TUICallDefine.CallRecords getItem(int i11) {
        int i12;
        List<TUICallDefine.CallRecords> list = this.mDataSource;
        if (list == null || list.isEmpty() || i11 - 1 >= this.mDataSource.size() || i12 < 0) {
            return null;
        }
        return this.mDataSource.get(i12);
    }

    private boolean isItemChecked(String str) {
        if (this.mSelectedPositions.size() > 0 && this.mSelectedPositions.containsKey(str)) {
            return this.mSelectedPositions.get(str).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$onBindViewHolder$0(RecentCallsItemHolder recentCallsItemHolder, View view) {
        if (this.mItemListener != null) {
            int bindingAdapterPosition = recentCallsItemHolder.getBindingAdapterPosition();
            this.mItemListener.onItemClick(recentCallsItemHolder.itemView, getItemViewType(bindingAdapterPosition), getItem(bindingAdapterPosition));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$onBindViewHolder$1(RecentCallsItemHolder recentCallsItemHolder, View view) {
        ICallRecordItemListener iCallRecordItemListener = this.mItemListener;
        if (iCallRecordItemListener != null) {
            iCallRecordItemListener.onDetailViewClick(view, getItem(recentCallsItemHolder.getBindingAdapterPosition()));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$onBindViewHolder$2(RecentCallsItemHolder recentCallsItemHolder, View view) {
        int bindingAdapterPosition = recentCallsItemHolder.getBindingAdapterPosition();
        TUICallDefine.CallRecords item = getItem(bindingAdapterPosition);
        if (item == null || TextUtils.isEmpty(item.callId)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        setItemChecked(item.callId, true);
        ICallRecordItemListener iCallRecordItemListener = this.mItemListener;
        if (iCallRecordItemListener != null) {
            iCallRecordItemListener.onItemDeleteClick(view, getItemViewType(bindingAdapterPosition), item);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void setCheckBoxStatus(RecentCallsItemHolder recentCallsItemHolder) {
        CheckBox checkBox;
        if (recentCallsItemHolder != null && (checkBox = recentCallsItemHolder.mCheckBoxSelectCall) != null) {
            if (!this.mIsMultiSelectMode) {
                checkBox.setVisibility(8);
                recentCallsItemHolder.itemView.setOnClickListener((View.OnClickListener) null);
                return;
            }
            checkBox.setVisibility(0);
        }
    }

    private void setItemChecked(String str, boolean z11) {
        this.mSelectedPositions.put(str, Boolean.valueOf(z11));
    }

    public int getItemCount() {
        List<TUICallDefine.CallRecords> list = this.mDataSource;
        if (list == null) {
            return 1;
        }
        return list.size() + 1;
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public int getItemViewType(int i11) {
        if (i11 == 0) {
            return 101;
        }
        return ITEM_TYPE_NORMAL;
    }

    public List<TUICallDefine.CallRecords> getSelectedItem() {
        if (this.mSelectedPositions.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < getItemCount() - 1; i11++) {
            TUICallDefine.CallRecords item = getItem(i11);
            if (item != null && isItemChecked(item.callId)) {
                arrayList.add(item);
            }
        }
        return arrayList;
    }

    public boolean isMultiSelectMode() {
        return this.mIsMultiSelectMode;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        if (viewHolder instanceof RecentCallsItemHolder) {
            RecentCallsItemHolder recentCallsItemHolder = (RecentCallsItemHolder) viewHolder;
            recentCallsItemHolder.mLayoutView.setOnClickListener(new i(this, recentCallsItemHolder));
            recentCallsItemHolder.mImageDetails.setOnClickListener(new k(this, recentCallsItemHolder));
            if (!recentCallsItemHolder.mLayoutDelete.hasOnClickListeners()) {
                recentCallsItemHolder.mLayoutDelete.setOnClickListener(new j(this, recentCallsItemHolder));
            }
            recentCallsItemHolder.layoutViews(this.mContext, getItem(i11), i11);
            setCheckBoxStatus(recentCallsItemHolder);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        this.mContext = viewGroup.getContext().getApplicationContext();
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i11 == 101) {
            return new HeaderViewHolder(from.inflate(R.layout.tuicallkit_item_head_view, viewGroup, false));
        }
        return new RecentCallsItemHolder(from.inflate(R.layout.tuicallkit_layout_call_list_item, viewGroup, false));
    }

    public void onDataSourceChanged(List<TUICallDefine.CallRecords> list) {
        this.mDataSource.clear();
        this.mDataSource.addAll(list);
        notifyDataSetChanged();
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof RecentCallsItemHolder) {
            ((RecentCallsItemHolder) viewHolder).mCallIconView.clear();
        }
    }

    public void setOnCallRecordItemListener(ICallRecordItemListener iCallRecordItemListener) {
        this.mItemListener = iCallRecordItemListener;
    }

    public void setShowMultiSelectCheckBox(boolean z11) {
        this.mIsMultiSelectMode = z11;
        for (TUICallDefine.CallRecords next : this.mDataSource) {
            if (next != null && !TextUtils.isEmpty(next.callId)) {
                setItemChecked(next.callId, z11);
                int indexInAdapter = getIndexInAdapter(next);
                if (indexInAdapter != -1) {
                    notifyItemChanged(indexInAdapter);
                }
            }
        }
    }
}
