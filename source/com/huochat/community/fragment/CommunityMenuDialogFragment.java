package com.huochat.community.fragment;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.facebook.internal.AnalyticsEvents;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.dialogfragment.BaseTopRightListDialogFragment;
import com.huochat.community.CommunityThemeHelper;
import com.huochat.community.R;
import com.huochat.community.enums.CommunityMenuItems;
import com.huochat.community.enums.CommunityMenuType;
import com.huochat.community.model.CommunityMenuPopwindowItem;
import java.util.ArrayList;
import java.util.List;

public final class CommunityMenuDialogFragment extends BaseTopRightListDialogFragment<CommunityMenuPopwindowItem> {
    private CommunityMenuPopwindowItem.Callback mCallback;
    private CommunityMenuType mCommunityMenuType = CommunityMenuType.UNKNOWN;
    private int mDefMenuIndex = -1;
    private int mLocationRight;
    private int mLocationTop;
    private List<CommunityMenuPopwindowItem> mMenuItemList = new ArrayList();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CommunityMenuType.values().length];
            try {
                iArr[CommunityMenuType.LIST_SORT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void initCommunitySortMenuList(List<CommunityMenuPopwindowItem> list) {
        if (WhenMappings.$EnumSwitchMapping$0[this.mCommunityMenuType.ordinal()] == 1) {
            list.add(new CommunityMenuPopwindowItem(CommunityMenuItems.DEFAULT, getString(R.string.community_sort_menu_normal), this.mCallback));
            list.add(new CommunityMenuPopwindowItem(CommunityMenuItems.LAST_TIME, getString(R.string.community_sort_menu_time), this.mCallback));
        } else {
            list.add(new CommunityMenuPopwindowItem(CommunityMenuItems.UNKNOWN, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, this.mCallback));
        }
        setMenuItemDefSelected(list, this.mDefMenuIndex);
    }

    private final void setMenuItemDefSelected(List<CommunityMenuPopwindowItem> list, int i11) {
        int size = list != null ? list.size() : 0;
        if (size != 0 && i11 >= 0 && i11 < size) {
            CommunityMenuPopwindowItem communityMenuPopwindowItem = list.get(i11);
            communityMenuPopwindowItem.setItemSelected(true);
            list.set(i11, communityMenuPopwindowItem);
        }
    }

    public void afterInit() {
        Context context;
        super.afterInit();
        getRootLayout().setPadding(0, this.mLocationTop, this.mLocationRight, 0);
        EasyRecyclerView<T> easyRecyclerView = this.mRecyclerView;
        if (easyRecyclerView != null && (context = easyRecyclerView.getContext()) != null) {
            CommunityThemeHelper.Companion companion = CommunityThemeHelper.Companion;
            this.mRecyclerView.setBackgroundResource(companion.getDrawableRes(companion.getThemeContext(context), R.attr.communityMenuPanelBg));
        }
    }

    public List<CommunityMenuPopwindowItem> getDataList() {
        this.mMenuItemList.clear();
        initCommunitySortMenuList(this.mMenuItemList);
        return this.mMenuItemList;
    }

    public final int getMenuItemIndex(CommunityMenuPopwindowItem communityMenuPopwindowItem) {
        if (communityMenuPopwindowItem == null || this.mMenuItemList.isEmpty()) {
            return -1;
        }
        return this.mMenuItemList.indexOf(communityMenuPopwindowItem);
    }

    public final void setLocationRight(int i11) {
        this.mLocationRight = i11;
    }

    public final void setLocationTop(int i11) {
        this.mLocationTop = i11;
    }

    public final void setMenuItemClickCallback(CommunityMenuPopwindowItem.Callback callback) {
        this.mCallback = callback;
    }

    public final void show(FragmentManager fragmentManager, String str, CommunityMenuType communityMenuType) {
        show(fragmentManager, str, communityMenuType, -1);
    }

    public final void show(FragmentManager fragmentManager, String str, CommunityMenuType communityMenuType, int i11) {
        this.mCommunityMenuType = communityMenuType;
        this.mDefMenuIndex = i11;
        super.show(fragmentManager, str);
    }
}
