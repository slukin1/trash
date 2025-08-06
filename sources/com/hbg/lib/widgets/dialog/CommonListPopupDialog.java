package com.hbg.lib.widgets.dialog;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import java.util.List;

public class CommonListPopupDialog extends BaseListPopupDialog<CommonPopListItem> {

    /* renamed from: b  reason: collision with root package name */
    public List<CommonPopListItem> f71768b;

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
        this.mRecyclerView.setBackgroundResource(R$drawable.shape_base_pop_list_bg);
        super.afterInit();
        customizeWindowDimAmount();
    }

    public List<CommonPopListItem> getDataList() {
        return this.f71768b;
    }

    public void setData(List<CommonPopListItem> list) {
        this.f71768b = list;
        super.setData(list);
    }
}
