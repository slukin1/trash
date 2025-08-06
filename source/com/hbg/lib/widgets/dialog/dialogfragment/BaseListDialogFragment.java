package com.hbg.lib.widgets.dialog.dialogfragment;

import android.widget.FrameLayout;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import i6.r;
import java.util.List;
import s9.a;

public abstract class BaseListDialogFragment<T extends a> extends BaseDialogFragment {
    private FrameLayout mParent;
    public EasyRecyclerView<T> mRecyclerView;

    public void addEvent(r rVar) {
    }

    public void afterInit() {
        reloadDataList();
    }

    public int getContentViewResId() {
        return R$layout.layout_base_list_dialog;
    }

    public abstract List<T> getDataList();

    public int getItemCount() {
        EasyRecyclerView<T> easyRecyclerView = this.mRecyclerView;
        if (easyRecyclerView != null) {
            return easyRecyclerView.getItemCount();
        }
        return 0;
    }

    public FrameLayout getRootLayout() {
        return this.mParent;
    }

    public void initView(r rVar) {
        this.mParent = (FrameLayout) rVar.b(R$id.id_base_list_dialog_parent);
        this.mRecyclerView = (EasyRecyclerView) rVar.b(R$id.id_base_list_dialog_recyclerView);
    }

    public boolean isFullScreen() {
        return false;
    }

    public boolean isTransparent() {
        return false;
    }

    public void reloadDataList() {
        setData(getDataList());
    }

    public void setData(List<T> list) {
        EasyRecyclerView<T> easyRecyclerView = this.mRecyclerView;
        if (easyRecyclerView != null) {
            easyRecyclerView.setData(list);
        }
    }
}
