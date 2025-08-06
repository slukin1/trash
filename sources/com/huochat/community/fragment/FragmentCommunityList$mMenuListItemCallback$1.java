package com.huochat.community.fragment;

import com.huochat.community.adapter.CommunityAdapter;
import com.huochat.community.enums.CommunityMenuItems;
import com.huochat.community.model.CommunityMenuListItem;

public final class FragmentCommunityList$mMenuListItemCallback$1 implements CommunityMenuListItem.Callback {
    public final /* synthetic */ FragmentCommunityList this$0;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.huochat.community.enums.CommunityMenuItems[] r0 = com.huochat.community.enums.CommunityMenuItems.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.huochat.community.enums.CommunityMenuItems r1 = com.huochat.community.enums.CommunityMenuItems.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.huochat.community.enums.CommunityMenuItems r1 = com.huochat.community.enums.CommunityMenuItems.LAST_TIME     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.fragment.FragmentCommunityList$mMenuListItemCallback$1.WhenMappings.<clinit>():void");
        }
    }

    public FragmentCommunityList$mMenuListItemCallback$1(FragmentCommunityList fragmentCommunityList) {
        this.this$0 = fragmentCommunityList;
    }

    public boolean isChecked(CommunityMenuListItem communityMenuListItem) {
        return communityMenuListItem != null && this.this$0.mListSortType == communityMenuListItem.getType();
    }

    public void onItemClick(CommunityMenuListItem communityMenuListItem) {
        CommunityListMenuDialog access$getMCommunityMenuDialog$p = this.this$0.mCommunityMenuDialog;
        if (access$getMCommunityMenuDialog$p != null) {
            access$getMCommunityMenuDialog$p.dismiss();
        }
        if (communityMenuListItem != null) {
            CommunityMenuItems type = CommunityMenuItems.Companion.getType(Integer.valueOf(communityMenuListItem.getType()));
            int i11 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i11 == 1) {
                this.this$0.mListSortType = type.getType();
                this.this$0.mCommunityMenuPopwindowItem = communityMenuListItem;
                CommunityAdapter access$getCommunityAdapter$p = this.this$0.communityAdapter;
                if (access$getCommunityAdapter$p != null) {
                    access$getCommunityAdapter$p.refreshTopListSortStatus(type);
                }
                this.this$0.refreshData();
            } else if (i11 == 2) {
                this.this$0.mListSortType = type.getType();
                this.this$0.mCommunityMenuPopwindowItem = communityMenuListItem;
                CommunityAdapter access$getCommunityAdapter$p2 = this.this$0.communityAdapter;
                if (access$getCommunityAdapter$p2 != null) {
                    access$getCommunityAdapter$p2.refreshTopListSortStatus(type);
                }
                this.this$0.refreshData();
            }
        }
    }
}
