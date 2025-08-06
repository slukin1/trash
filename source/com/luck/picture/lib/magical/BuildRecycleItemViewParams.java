package com.luck.picture.lib.magical;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class BuildRecycleItemViewParams {
    private static final List<ViewParams> viewParams = new ArrayList();

    public static void clear() {
        List<ViewParams> list = viewParams;
        if (list.size() > 0) {
            list.clear();
        }
    }

    private static void fillPlaceHolder(List<View> list, int i11, int i12, int i13) {
        if (i12 > 0) {
            while (i12 >= 1) {
                list.add(0, (Object) null);
                i12--;
            }
        }
        if (i13 < i11) {
            for (int i14 = (i11 - 1) - i13; i14 >= 1; i14--) {
                list.add((Object) null);
            }
        }
    }

    public static void generateViewParams(ViewGroup viewGroup, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        ArrayList arrayList = new ArrayList();
        boolean z11 = viewGroup instanceof RecyclerView;
        if (z11) {
            i12 = ((RecyclerView) viewGroup).getChildCount();
        } else if (viewGroup instanceof ListView) {
            i12 = ((ListView) viewGroup).getChildCount();
        } else {
            throw new IllegalArgumentException(viewGroup.getClass().getCanonicalName() + " Must be " + RecyclerView.class + " or " + ListView.class);
        }
        for (int i16 = 0; i16 < i12; i16++) {
            View childAt = viewGroup.getChildAt(i16);
            if (childAt != null) {
                arrayList.add(childAt);
            }
        }
        if (z11) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) ((RecyclerView) viewGroup).getLayoutManager();
            if (gridLayoutManager != null) {
                i15 = gridLayoutManager.getItemCount();
                i14 = gridLayoutManager.findFirstVisibleItemPosition();
                i13 = gridLayoutManager.findLastVisibleItemPosition();
            } else {
                return;
            }
        } else {
            ListView listView = (ListView) viewGroup;
            ListAdapter adapter = listView.getAdapter();
            if (adapter != null) {
                i15 = adapter.getCount();
                i14 = listView.getFirstVisiblePosition();
                i13 = listView.getLastVisiblePosition();
            } else {
                return;
            }
        }
        if (i13 > i15) {
            i13 = i15 - 1;
        }
        fillPlaceHolder(arrayList, i15, i14, i13);
        viewParams.clear();
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            View view = (View) arrayList.get(i17);
            ViewParams viewParams2 = new ViewParams();
            if (view == null) {
                viewParams2.setLeft(0);
                viewParams2.setTop(0);
                viewParams2.setWidth(0);
                viewParams2.setHeight(0);
            } else {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                viewParams2.setLeft(iArr[0]);
                viewParams2.setTop(iArr[1] - i11);
                viewParams2.setWidth(view.getWidth());
                viewParams2.setHeight(view.getHeight());
            }
            viewParams.add(viewParams2);
        }
    }

    public static ViewParams getItemViewParams(int i11) {
        List<ViewParams> list = viewParams;
        if (list.size() > i11) {
            return list.get(i11);
        }
        return null;
    }
}
