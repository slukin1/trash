package com.huobi.view.indexlist;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.view.indexlist.AbstractHeaderFooterAdapter;
import com.huobi.view.indexlist.IndexPartAdapter;
import com.huobi.view.indexlist.IndexPartEntity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;

class RealAdapter<T extends IndexPartEntity> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private IndexPartAdapter<T> mAdapter;
    /* access modifiers changed from: private */
    public IndexPartAdapter.OnItemContentClickListener<T> mContentClickListener;
    /* access modifiers changed from: private */
    public IndexPartAdapter.OnItemContentLongClickListener<T> mContentLongClickListener;
    private ArrayList<EntityWrapper<T>> mDatas;
    /* access modifiers changed from: private */
    public ArrayList<EntityWrapper<T>> mDatasList = new ArrayList<>();
    /* access modifiers changed from: private */
    public SparseArray<IndexPartFooterAdapter> mFooterAdapterMap = new SparseArray<>();
    private ArrayList<EntityWrapper<T>> mFooterDatasList = new ArrayList<>();
    /* access modifiers changed from: private */
    public SparseArray<IndexHeaderAdapter> mHeaderAdapterMap = new SparseArray<>();
    private ArrayList<EntityWrapper<T>> mHeaderDatasList = new ArrayList<>();
    /* access modifiers changed from: private */
    public IndexPartAdapter.OnItemTitleClickListener mTitleClickListener;
    /* access modifiers changed from: private */
    public IndexPartAdapter.OnItemTitleLongClickListener mTitleLongClickListener;

    private void processAddHeaderFooterData(ArrayList<EntityWrapper<T>> arrayList, EntityWrapper entityWrapper, EntityWrapper entityWrapper2) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            if (arrayList.get(i11) == entityWrapper) {
                int i12 = i11 + 1;
                arrayList.add(i12, entityWrapper2);
                this.mDatasList.add(arrayList == this.mFooterDatasList ? (this.mDatasList.size() - this.mFooterDatasList.size()) + 1 + i12 : i12, entityWrapper2);
                notifyItemInserted(i12);
                return;
            }
        }
    }

    private void processRemoveHeaderFooterData(ArrayList<EntityWrapper<T>> arrayList, EntityWrapper entityWrapper) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            if (arrayList.get(i11) == entityWrapper) {
                arrayList.remove(entityWrapper);
                this.mDatasList.remove(entityWrapper);
                notifyItemRemoved(i11);
                return;
            }
        }
    }

    public void addHeaderFooterData(boolean z11, EntityWrapper entityWrapper, EntityWrapper entityWrapper2) {
        processAddHeaderFooterData(z11 ? this.mHeaderDatasList : this.mFooterDatasList, entityWrapper, entityWrapper2);
    }

    public void addIndexFooterAdapter(IndexPartFooterAdapter indexPartFooterAdapter) {
        this.mFooterDatasList.addAll(indexPartFooterAdapter.getDatas());
        this.mDatasList.addAll(indexPartFooterAdapter.getDatas());
        this.mFooterAdapterMap.put(indexPartFooterAdapter.getItemViewType(), indexPartFooterAdapter);
        notifyDataSetChanged();
    }

    public void addIndexHeaderAdapter(IndexHeaderAdapter indexHeaderAdapter) {
        this.mHeaderDatasList.addAll(0, indexHeaderAdapter.getDatas());
        this.mDatasList.addAll(0, indexHeaderAdapter.getDatas());
        this.mHeaderAdapterMap.put(indexHeaderAdapter.getItemViewType(), indexHeaderAdapter);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.mDatasList.size();
    }

    public int getItemViewType(int i11) {
        return this.mDatasList.get(i11).getItemType();
    }

    public ArrayList<EntityWrapper<T>> getItems() {
        return this.mDatasList;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        AbstractHeaderFooterAdapter abstractHeaderFooterAdapter;
        EntityWrapper entityWrapper = this.mDatasList.get(i11);
        int itemViewType = getItemViewType(i11);
        if (itemViewType == 2147483646) {
            if (4 == viewHolder.itemView.getVisibility()) {
                viewHolder.itemView.setVisibility(0);
            }
            this.mAdapter.onBindTitleViewHolder(viewHolder, entityWrapper.getIndexTitle());
        } else if (itemViewType == Integer.MAX_VALUE) {
            this.mAdapter.onBindContentViewHolder(viewHolder, (IndexPartEntity) entityWrapper.getData());
        } else {
            if (this.mHeaderAdapterMap.indexOfKey(itemViewType) >= 0) {
                abstractHeaderFooterAdapter = this.mHeaderAdapterMap.get(itemViewType);
            } else {
                abstractHeaderFooterAdapter = this.mFooterAdapterMap.get(itemViewType);
            }
            abstractHeaderFooterAdapter.onBindContentViewHolder(viewHolder, entityWrapper.getData());
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i11) {
        final RecyclerView.ViewHolder viewHolder;
        AbstractHeaderFooterAdapter abstractHeaderFooterAdapter;
        if (i11 == 2147483646) {
            viewHolder = this.mAdapter.onCreateTitleViewHolder(viewGroup);
        } else if (i11 == Integer.MAX_VALUE) {
            viewHolder = this.mAdapter.onCreateContentViewHolder(viewGroup);
        } else {
            if (this.mHeaderAdapterMap.indexOfKey(i11) >= 0) {
                abstractHeaderFooterAdapter = this.mHeaderAdapterMap.get(i11);
            } else {
                abstractHeaderFooterAdapter = this.mFooterAdapterMap.get(i11);
            }
            viewHolder = abstractHeaderFooterAdapter.onCreateContentViewHolder(viewGroup);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                AbstractHeaderFooterAdapter abstractHeaderFooterAdapter;
                AbstractHeaderFooterAdapter.OnItemClickListener onItemClickListener;
                int adapterPosition = viewHolder.getAdapterPosition();
                if (adapterPosition == -1) {
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                EntityWrapper entityWrapper = (EntityWrapper) RealAdapter.this.mDatasList.get(adapterPosition);
                int i11 = i11;
                if (i11 == 2147483646) {
                    if (RealAdapter.this.mTitleClickListener != null) {
                        RealAdapter.this.mTitleClickListener.onItemClick(view, adapterPosition, entityWrapper.getIndexTitle());
                    }
                } else if (i11 != Integer.MAX_VALUE) {
                    if (RealAdapter.this.mHeaderAdapterMap.indexOfKey(i11) >= 0) {
                        abstractHeaderFooterAdapter = (AbstractHeaderFooterAdapter) RealAdapter.this.mHeaderAdapterMap.get(i11);
                    } else {
                        abstractHeaderFooterAdapter = (AbstractHeaderFooterAdapter) RealAdapter.this.mFooterAdapterMap.get(i11);
                    }
                    if (!(abstractHeaderFooterAdapter == null || (onItemClickListener = abstractHeaderFooterAdapter.getOnItemClickListener()) == null)) {
                        onItemClickListener.onItemClick(view, adapterPosition, entityWrapper.getData());
                    }
                } else if (RealAdapter.this.mContentClickListener != null) {
                    RealAdapter.this.mContentClickListener.onItemClick(view, entityWrapper.getOriginalPosition(), adapterPosition, (IndexPartEntity) entityWrapper.getData());
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                AbstractHeaderFooterAdapter abstractHeaderFooterAdapter;
                AbstractHeaderFooterAdapter.OnItemLongClickListener onItemLongClickListener;
                int adapterPosition = viewHolder.getAdapterPosition();
                EntityWrapper entityWrapper = (EntityWrapper) RealAdapter.this.mDatasList.get(adapterPosition);
                int i11 = i11;
                if (i11 == 2147483646) {
                    if (RealAdapter.this.mTitleLongClickListener != null) {
                        return RealAdapter.this.mTitleLongClickListener.onItemLongClick(view, adapterPosition, entityWrapper.getIndexTitle());
                    }
                    return true;
                } else if (i11 != Integer.MAX_VALUE) {
                    if (RealAdapter.this.mHeaderAdapterMap.indexOfKey(i11) >= 0) {
                        abstractHeaderFooterAdapter = (AbstractHeaderFooterAdapter) RealAdapter.this.mHeaderAdapterMap.get(i11);
                    } else {
                        abstractHeaderFooterAdapter = (AbstractHeaderFooterAdapter) RealAdapter.this.mFooterAdapterMap.get(i11);
                    }
                    if (abstractHeaderFooterAdapter == null || (onItemLongClickListener = abstractHeaderFooterAdapter.getOnItemLongClickListener()) == null) {
                        return false;
                    }
                    return onItemLongClickListener.onItemLongClick(view, adapterPosition, entityWrapper.getData());
                } else if (RealAdapter.this.mContentLongClickListener != null) {
                    return RealAdapter.this.mContentLongClickListener.onItemLongClick(view, entityWrapper.getOriginalPosition(), adapterPosition, (IndexPartEntity) entityWrapper.getData());
                } else {
                    return true;
                }
            }
        });
        return viewHolder;
    }

    public void removeHeaderFooterData(boolean z11, EntityWrapper entityWrapper) {
        processRemoveHeaderFooterData(z11 ? this.mHeaderDatasList : this.mFooterDatasList, entityWrapper);
    }

    public void removeIndexFooterAdapter(IndexPartFooterAdapter indexPartFooterAdapter) {
        this.mFooterDatasList.removeAll(indexPartFooterAdapter.getDatas());
        if (this.mDatasList.size() > 0) {
            this.mDatasList.removeAll(indexPartFooterAdapter.getDatas());
        }
        this.mFooterAdapterMap.remove(indexPartFooterAdapter.getItemViewType());
        notifyDataSetChanged();
    }

    public void removeIndexHeaderAdapter(IndexHeaderAdapter indexHeaderAdapter) {
        this.mHeaderDatasList.removeAll(indexHeaderAdapter.getDatas());
        if (this.mDatasList.size() > 0) {
            this.mDatasList.removeAll(indexHeaderAdapter.getDatas());
        }
        this.mHeaderAdapterMap.remove(indexHeaderAdapter.getItemViewType());
        notifyDataSetChanged();
    }

    public void setDatas(ArrayList<EntityWrapper<T>> arrayList) {
        if (this.mDatas != null && this.mDatasList.size() > this.mHeaderDatasList.size() + this.mFooterDatasList.size()) {
            this.mDatasList.removeAll(this.mDatas);
        }
        this.mDatas = arrayList;
        this.mDatasList.addAll(this.mHeaderDatasList.size(), arrayList);
        notifyDataSetChanged();
    }

    public void setIndexAdapter(IndexPartAdapter<T> indexPartAdapter) {
        this.mAdapter = indexPartAdapter;
    }

    public void setOnItemContentClickListener(IndexPartAdapter.OnItemContentClickListener<T> onItemContentClickListener) {
        this.mContentClickListener = onItemContentClickListener;
    }

    public void setOnItemContentLongClickListener(IndexPartAdapter.OnItemContentLongClickListener<T> onItemContentLongClickListener) {
        this.mContentLongClickListener = onItemContentLongClickListener;
    }

    public void setOnItemTitleClickListener(IndexPartAdapter.OnItemTitleClickListener onItemTitleClickListener) {
        this.mTitleClickListener = onItemTitleClickListener;
    }

    public void setOnItemTitleLongClickListener(IndexPartAdapter.OnItemTitleLongClickListener onItemTitleLongClickListener) {
        this.mTitleLongClickListener = onItemTitleLongClickListener;
    }
}
