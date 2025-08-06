package com.huobi.view.indexlist;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.view.indexlist.IndexPartEntity;
import com.huobi.view.indexlist.database.DataObservable;
import com.huobi.view.indexlist.database.DataObserver;
import java.util.List;

public abstract class IndexPartAdapter<T extends IndexPartEntity> {
    public static final int TYPE_ALL = 0;
    public static final int TYPE_CLICK_CONTENT = 2;
    public static final int TYPE_CLICK_TITLE = 1;
    public static final int TYPE_LONG_CLICK_CONTENT = 4;
    public static final int TYPE_LONG_CLICK_TITLE = 3;
    private IndexCallback<T> mCallback;
    private OnItemContentClickListener mContentClickListener;
    private OnItemContentLongClickListener mContentLongClickListener;
    private final DataObservable mDataSetObservable = new DataObservable();
    private List<T> mDatas;
    private OnItemTitleClickListener mTitleClickListener;
    private OnItemTitleLongClickListener mTitleLongClickListener;

    public interface IndexCallback<T> {
        void onFinished(List<EntityWrapper<T>> list);
    }

    public interface OnItemContentClickListener<T> {
        void onItemClick(View view, int i11, int i12, T t11);
    }

    public interface OnItemContentLongClickListener<T> {
        boolean onItemLongClick(View view, int i11, int i12, T t11);
    }

    public interface OnItemTitleClickListener {
        void onItemClick(View view, int i11, String str);
    }

    public interface OnItemTitleLongClickListener {
        boolean onItemLongClick(View view, int i11, String str);
    }

    private void notifyInited() {
        this.mDataSetObservable.notifyInited();
    }

    private void notifySetListener(int i11) {
        this.mDataSetObservable.notifySetListener(i11);
    }

    public IndexCallback<T> getIndexCallback() {
        return this.mCallback;
    }

    public List<T> getItems() {
        return this.mDatas;
    }

    public OnItemContentClickListener getOnItemContentClickListener() {
        return this.mContentClickListener;
    }

    public OnItemContentLongClickListener getOnItemContentLongClickListener() {
        return this.mContentLongClickListener;
    }

    public OnItemTitleClickListener getOnItemTitleClickListener() {
        return this.mTitleClickListener;
    }

    public OnItemTitleLongClickListener getOnItemTitleLongClickListener() {
        return this.mTitleLongClickListener;
    }

    public void notifyDataSetChanged() {
        this.mDataSetObservable.notifyInited();
    }

    public abstract void onBindContentViewHolder(RecyclerView.ViewHolder viewHolder, T t11);

    public abstract void onBindTitleViewHolder(RecyclerView.ViewHolder viewHolder, String str);

    public abstract RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup viewGroup);

    public abstract RecyclerView.ViewHolder onCreateTitleViewHolder(ViewGroup viewGroup);

    public void registerDataSetObserver(DataObserver dataObserver) {
        this.mDataSetObservable.registerObserver(dataObserver);
    }

    public void setDatas(List<T> list) {
        setDatas(list, (IndexCallback) null);
    }

    public void setOnItemContentClickListener(OnItemContentClickListener<T> onItemContentClickListener) {
        this.mContentClickListener = onItemContentClickListener;
        notifySetListener(2);
    }

    public void setOnItemContentLongClickListener(OnItemContentLongClickListener<T> onItemContentLongClickListener) {
        this.mContentLongClickListener = onItemContentLongClickListener;
        notifySetListener(4);
    }

    public void setOnItemTitleClickListener(OnItemTitleClickListener onItemTitleClickListener) {
        this.mTitleClickListener = onItemTitleClickListener;
        notifySetListener(1);
    }

    public void setOnItemTitleLongClickListener(OnItemTitleLongClickListener onItemTitleLongClickListener) {
        this.mTitleLongClickListener = onItemTitleLongClickListener;
        notifySetListener(3);
    }

    public void unregisterDataSetObserver(DataObserver dataObserver) {
        this.mDataSetObservable.unregisterObserver(dataObserver);
    }

    public void setDatas(List<T> list, IndexCallback<T> indexCallback) {
        this.mCallback = indexCallback;
        this.mDatas = list;
        notifyInited();
    }
}
