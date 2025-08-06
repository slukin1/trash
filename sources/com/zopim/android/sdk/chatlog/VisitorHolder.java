package com.zopim.android.sdk.chatlog;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.model.items.VisitorItem;

abstract class VisitorHolder<T extends VisitorItem> extends RecyclerView.ViewHolder implements ViewBinder<T> {
    private static final String LOG_TAG = "VisitorHolder";
    /* access modifiers changed from: private */
    public OnClickListener clickListener;
    private final ImageView sendFailedIcon;
    private final TextView sendFailedLabel;

    public interface OnClickListener {
        void onClick(int i11);
    }

    public VisitorHolder(View view) {
        super(view);
        this.sendFailedLabel = (TextView) view.findViewById(R.id.send_failed_label);
        this.sendFailedIcon = (ImageView) view.findViewById(R.id.send_failed_icon);
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

    public void setClickListener(OnClickListener onClickListener) {
        this.clickListener = onClickListener;
    }

    public void bind(T t11) {
        if (t11 == null) {
            Logger.d(LOG_TAG, "Item must not be null", new Object[0]);
            return;
        }
        if (t11.isFailed()) {
            this.sendFailedIcon.setVisibility(0);
            this.sendFailedLabel.setVisibility(0);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (VisitorHolder.this.clickListener != null) {
                        VisitorHolder.this.clickListener.onClick(VisitorHolder.this.getAdapterPosition());
                    } else {
                        Logger.g(VisitorHolder.LOG_TAG, "Failed message click listener not configured. Click events are ignored.", new Object[0]);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        } else {
            this.sendFailedLabel.setVisibility(8);
            this.sendFailedIcon.setVisibility(8);
            this.itemView.setOnClickListener((View.OnClickListener) null);
        }
        if (t11 instanceof LeadItem) {
            offset(((LeadItem) t11).isLeadItem());
        }
    }
}
