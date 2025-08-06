package com.zopim.android.sdk.chatlog;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.model.items.AgentItem;

abstract class AgentHolder<T extends AgentItem> extends RecyclerView.ViewHolder implements ViewBinder<T> {
    private static final String LOG_TAG = "AgentHolder";
    public ImageView avatarView;
    public TextView nameView;

    public AgentHolder(View view) {
        super(view);
        this.avatarView = (ImageView) view.findViewById(R.id.avatar_icon);
        this.nameView = (TextView) view.findViewById(R.id.agent_name);
    }

    private void offset(boolean z11) {
        if (this.itemView.getLayoutParams() instanceof RecyclerView.LayoutParams) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.itemView.getLayoutParams();
            if (z11) {
                try {
                    layoutParams.setMargins(layoutParams.leftMargin, this.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.lead_message_padding_top), layoutParams.rightMargin, layoutParams.bottomMargin);
                } catch (Resources.NotFoundException e11) {
                    Logger.k(LOG_TAG, "Can not find padding dimension.Skipping.", e11, new Object[0]);
                }
            } else {
                layoutParams.setMargins(layoutParams.leftMargin, this.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.chat_message_padding_top), layoutParams.rightMargin, layoutParams.bottomMargin);
            }
        }
    }

    private void setVisibility(View view, int i11) {
        if (view != null) {
            if (i11 == 0) {
                view.setVisibility(0);
            } else if (i11 == 4) {
                view.setVisibility(4);
            } else if (i11 != 8) {
                Logger.l(LOG_TAG, "Illegal visibility configuration. Please use one of the View.VISIBLE, View.INVISIBLE or View.GONE", new Object[0]);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void bind(T t11) {
        if (t11 == null) {
            Logger.d(LOG_TAG, "Item must not be null", new Object[0]);
            return;
        }
        TextView textView = this.nameView;
        if (textView != null) {
            textView.setText(t11.getDisplayName());
        }
        if (t11 instanceof FirstItem) {
            if (((FirstItem) t11).isFirstItem()) {
                setVisibility(this.nameView, 0);
            } else {
                setVisibility(this.nameView, 8);
            }
        }
        if (t11 instanceof LeadItem) {
            if (((LeadItem) t11).isLeadItem()) {
                offset(true);
                setVisibility(this.avatarView, 0);
            } else {
                offset(false);
                setVisibility(this.avatarView, 4);
            }
        }
        PicassoHelper.loadAvatarImage(this.avatarView, t11.getAvatarUri());
    }
}
