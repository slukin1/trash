package com.huochat.community.listener;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.huochat.community.enums.CommunityMenuItems;

public interface OnCommunitySortClickListener {
    FragmentActivity getParentActivity();

    void onClick(View view, View view2, CommunityMenuItems communityMenuItems);
}
