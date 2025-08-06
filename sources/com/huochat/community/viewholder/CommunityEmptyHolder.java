package com.huochat.community.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huochat.community.CommunityManager;
import com.huochat.community.CommunityThemeColor;
import com.huochat.community.R;

public final class CommunityEmptyHolder extends RecyclerView.ViewHolder {
    private TextView mHintTextView;
    private View mItemView;

    public CommunityEmptyHolder(View view) {
        super(view);
        this.mItemView = view;
        CommunityThemeColor communityThemeColor = CommunityManager.Companion.getInstance().getCommunityThemeColor();
        ((ImageView) view.findViewById(R.id.iv_item_empty_icon)).setImageResource(communityThemeColor.getErrorDefIconMomentEmpty());
        TextView textView = (TextView) view.findViewById(R.id.tv_item_empty_hint);
        this.mHintTextView = textView;
        textView.setTextColor(communityThemeColor.getErrorDefTipsMomentEmptyTextColor());
    }

    public final void bindData() {
        Context context = this.itemView.getContext();
        if (context != null) {
            this.mHintTextView.setText(context.getResources().getString(R.string.community_empty_no_content_hint));
        }
    }
}
