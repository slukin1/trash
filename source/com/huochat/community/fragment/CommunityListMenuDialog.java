package com.huochat.community.fragment;

import android.content.Context;
import com.hbg.lib.widgets.dialog.BaseListPopupDialog;
import com.huochat.community.CommunityThemeHelper;
import com.huochat.community.R;
import com.huochat.community.model.CommunityMenuListItem;
import java.util.List;

public final class CommunityListMenuDialog extends BaseListPopupDialog<CommunityMenuListItem> {
    private List<CommunityMenuListItem> list;

    public void afterInit() {
        this.mLocationY += getResources().getDimensionPixelOffset(R.dimen.dimen_3);
        this.mRecyclerView.addItemDecoration(new CommunityListMenuDialog$afterInit$1());
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dimen_0_5);
        this.mRecyclerView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        Context context = getContext();
        if (context != null) {
            CommunityThemeHelper.Companion companion = CommunityThemeHelper.Companion;
            this.mRecyclerView.setBackgroundResource(companion.getDrawableRes(companion.getThemeContext(context), R.attr.communityMenuPanelBg));
        }
        super.afterInit();
        customizeWindowDimAmount();
    }

    public List<CommunityMenuListItem> getDataList() {
        return this.list;
    }

    public void setData(List<CommunityMenuListItem> list2) {
        this.list = list2;
        super.setData(list2);
    }
}
