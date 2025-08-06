package com.huobi.view.indexlist;

import com.huobi.view.indexlist.AbstractHeaderFooterAdapter;
import java.util.List;

public abstract class IndexHeaderAdapter<T> extends AbstractHeaderFooterAdapter<T> {

    public interface OnItemHeaderClickListener<T> extends AbstractHeaderFooterAdapter.OnItemClickListener<T> {
    }

    public interface OnItemHeaderLongClickListener<T> extends AbstractHeaderFooterAdapter.OnItemLongClickListener<T> {
    }

    public IndexHeaderAdapter(String str, String str2, List<T> list) {
        super(str, str2, list);
    }

    public /* bridge */ /* synthetic */ void addData(int i11, Object obj) {
        super.addData(i11, obj);
    }

    public /* bridge */ /* synthetic */ void addDatas(int i11, List list) {
        super.addDatas(i11, list);
    }

    public int getHeaderFooterType() {
        return 1;
    }

    public /* bridge */ /* synthetic */ void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public /* bridge */ /* synthetic */ void removeData(Object obj) {
        super.removeData(obj);
    }

    public void setOnItemHeaderClickListener(OnItemHeaderClickListener<T> onItemHeaderClickListener) {
        this.mListener = onItemHeaderClickListener;
    }

    public void setOnItemHeaderLongClickListener(OnItemHeaderLongClickListener<T> onItemHeaderLongClickListener) {
        this.mLongListener = onItemHeaderLongClickListener;
    }

    public /* bridge */ /* synthetic */ void addData(Object obj) {
        super.addData(obj);
    }

    public /* bridge */ /* synthetic */ void addDatas(List list) {
        super.addDatas(list);
    }
}
