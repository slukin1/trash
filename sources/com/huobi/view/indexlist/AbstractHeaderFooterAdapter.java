package com.huobi.view.indexlist;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.view.indexlist.database.HeaderFooterDataObservable;
import com.huobi.view.indexlist.database.HeaderFooterDataObserver;
import com.huobi.view.indexlist.database.IndexBarDataObservable;
import com.huobi.view.indexlist.database.IndexBarDataObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class AbstractHeaderFooterAdapter<T> {
    private final HeaderFooterDataObservable mDataSetObservable = new HeaderFooterDataObservable();
    public ArrayList<EntityWrapper<T>> mEntityWrapperList = new ArrayList<>();
    private String mIndex;
    private final IndexBarDataObservable mIndexBarDataSetObservable = new IndexBarDataObservable();
    private String mIndexTitle;
    public OnItemClickListener<T> mListener;
    public OnItemLongClickListener<T> mLongListener;

    public interface OnItemClickListener<T> {
        void onItemClick(View view, int i11, T t11);
    }

    public interface OnItemLongClickListener<T> {
        boolean onItemLongClick(View view, int i11, T t11);
    }

    public AbstractHeaderFooterAdapter(String str, String str2, List<T> list) {
        this.mIndex = str;
        this.mIndexTitle = str2;
        if (str2 != null) {
            wrapEntity().setItemType(EntityWrapper.TYPE_TITLE);
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            wrapEntity().setData(list.get(i11));
        }
    }

    private EntityWrapper<T> wrapEntity() {
        EntityWrapper<T> entityWrapper = new EntityWrapper<>();
        entityWrapper.setIndex(this.mIndex);
        entityWrapper.setIndexTitle(this.mIndexTitle);
        entityWrapper.setHeaderFooterType(getHeaderFooterType());
        this.mEntityWrapperList.add(entityWrapper);
        return entityWrapper;
    }

    public void addData(T t11) {
        int size = this.mEntityWrapperList.size();
        EntityWrapper wrapEntity = wrapEntity();
        wrapEntity.setItemType(getItemViewType());
        wrapEntity.setData(t11);
        if (size > 0) {
            this.mDataSetObservable.notifyAdd(getHeaderFooterType() == 1, this.mEntityWrapperList.get(size - 1), wrapEntity);
            this.mIndexBarDataSetObservable.notifyChanged();
        }
    }

    public void addDatas(List<T> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            addData(list.get(i11));
        }
    }

    public ArrayList<EntityWrapper<T>> getDatas() {
        Iterator<EntityWrapper<T>> it2 = this.mEntityWrapperList.iterator();
        while (it2.hasNext()) {
            EntityWrapper next = it2.next();
            if (next.getItemType() == Integer.MAX_VALUE) {
                next.setItemType(getItemViewType());
            }
        }
        return this.mEntityWrapperList;
    }

    public int getHeaderFooterType() {
        return 1;
    }

    public abstract int getItemViewType();

    public OnItemClickListener<T> getOnItemClickListener() {
        return this.mListener;
    }

    public OnItemLongClickListener getOnItemLongClickListener() {
        return this.mLongListener;
    }

    public void notifyDataSetChanged() {
        this.mDataSetObservable.notifyChanged();
    }

    public abstract void onBindContentViewHolder(RecyclerView.ViewHolder viewHolder, T t11);

    public abstract RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup viewGroup);

    public void registerDataSetObserver(HeaderFooterDataObserver headerFooterDataObserver) {
        this.mDataSetObservable.registerObserver(headerFooterDataObserver);
    }

    public void registerIndexBarDataSetObserver(IndexBarDataObserver indexBarDataObserver) {
        this.mIndexBarDataSetObservable.registerObserver(indexBarDataObserver);
    }

    public void removeData(T t11) {
        Iterator<EntityWrapper<T>> it2 = this.mEntityWrapperList.iterator();
        while (it2.hasNext()) {
            EntityWrapper next = it2.next();
            if (next.getData() == t11) {
                this.mEntityWrapperList.remove(next);
                HeaderFooterDataObservable headerFooterDataObservable = this.mDataSetObservable;
                boolean z11 = true;
                if (getHeaderFooterType() != 1) {
                    z11 = false;
                }
                headerFooterDataObservable.notifyRemove(z11, next);
                this.mIndexBarDataSetObservable.notifyChanged();
                return;
            }
        }
    }

    public void unregisterDataSetObserver(HeaderFooterDataObserver headerFooterDataObserver) {
        this.mDataSetObservable.unregisterObserver(headerFooterDataObserver);
    }

    public void unregisterIndexBarDataSetObserver(IndexBarDataObserver indexBarDataObserver) {
        this.mIndexBarDataSetObservable.unregisterObserver(indexBarDataObserver);
    }

    public void addDatas(int i11, List<T> list) {
        if (i11 < this.mEntityWrapperList.size()) {
            for (int size = list.size() - 1; size >= 0; size--) {
                addData(i11, list.get(size));
            }
        }
    }

    private EntityWrapper<T> wrapEntity(int i11) {
        EntityWrapper<T> entityWrapper = new EntityWrapper<>();
        entityWrapper.setIndex(this.mIndex);
        entityWrapper.setIndexTitle(this.mIndexTitle);
        entityWrapper.setHeaderFooterType(getHeaderFooterType());
        this.mEntityWrapperList.add(i11, entityWrapper);
        return entityWrapper;
    }

    public void addData(int i11, T t11) {
        int size = this.mEntityWrapperList.size();
        if (i11 < size) {
            EntityWrapper wrapEntity = wrapEntity(i11 + 1);
            wrapEntity.setItemType(getItemViewType());
            wrapEntity.setData(t11);
            if (size > 0) {
                HeaderFooterDataObservable headerFooterDataObservable = this.mDataSetObservable;
                boolean z11 = true;
                if (getHeaderFooterType() != 1) {
                    z11 = false;
                }
                headerFooterDataObservable.notifyAdd(z11, this.mEntityWrapperList.get(i11), wrapEntity);
                this.mIndexBarDataSetObservable.notifyChanged();
            }
        }
    }
}
