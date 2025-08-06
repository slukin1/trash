package com.hbg.lib.widgets.dialog;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import java.util.List;

public class TransparentListPopupDialog extends BaseListPopupDialog<CommonPopListItem> {

    /* renamed from: b  reason: collision with root package name */
    public List<CommonPopListItem> f71875b;

    public class a extends RecyclerView.ItemDecoration {
        public a() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            int dimensionPixelOffset = recyclerView.getResources().getDimensionPixelOffset(R$dimen.dimen_5);
            rect.set(0, recyclerView.getChildAdapterPosition(view) == 0 ? dimensionPixelOffset : 0, 0, dimensionPixelOffset);
        }
    }

    public void afterInit() {
        this.mLocationY += getResources().getDimensionPixelOffset(R$dimen.dimen_3);
        this.mRecyclerView.addItemDecoration(new a());
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.dimen_0_5);
        this.mRecyclerView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.mRecyclerView.setBackgroundResource(R$drawable.contract_holding_dialog_trigger_bg);
        super.afterInit();
    }

    public int getContentViewResId() {
        return R$layout.layout_base_list_dialog_match_parent;
    }

    public List<CommonPopListItem> getDataList() {
        return this.f71875b;
    }

    public boolean isRunDefaultAnimation() {
        return false;
    }

    public boolean isTransparent() {
        return true;
    }

    public void setCoverViewBgColor(int i11) {
        super.setCoverViewBgColor(0);
    }

    public void setData(List<CommonPopListItem> list) {
        this.f71875b = list;
        super.setData(list);
    }

    public boolean useWindowBg() {
        return true;
    }
}
