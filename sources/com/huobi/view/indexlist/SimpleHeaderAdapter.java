package com.huobi.view.indexlist;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.view.indexlist.IndexPartEntity;
import java.util.List;

public class SimpleHeaderAdapter<T extends IndexPartEntity> extends IndexHeaderAdapter<T> {
    private IndexPartAdapter<T> mAdapter;

    public SimpleHeaderAdapter(IndexPartAdapter<T> indexPartAdapter, String str, String str2, List<T> list) {
        super(str, str2, list);
        this.mAdapter = indexPartAdapter;
    }

    public int getItemViewType() {
        return Integer.MAX_VALUE;
    }

    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup viewGroup) {
        return this.mAdapter.onCreateContentViewHolder(viewGroup);
    }

    public void onBindContentViewHolder(RecyclerView.ViewHolder viewHolder, T t11) {
        this.mAdapter.onBindContentViewHolder(viewHolder, t11);
    }
}
