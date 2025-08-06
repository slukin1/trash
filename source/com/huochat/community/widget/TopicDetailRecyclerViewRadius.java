package com.huochat.community.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.huochat.community.CommunityThemeHelper;
import com.huochat.community.R;

public class TopicDetailRecyclerViewRadius extends RecyclerView.ItemDecoration {
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            view.setBackgroundResource(CommunityThemeHelper.Companion.getDrawableRes(recyclerView.getContext(), R.attr.communityFirstItemBgOnTopicDetail));
        } else {
            view.setBackgroundResource(CommunityThemeHelper.Companion.getDrawableRes(recyclerView.getContext(), R.attr.communityOtherItemBgOnTopicDetail));
        }
        super.getItemOffsets(rect, view, recyclerView, state);
    }
}
