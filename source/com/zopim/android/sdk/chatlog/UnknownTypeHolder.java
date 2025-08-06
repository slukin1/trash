package com.zopim.android.sdk.chatlog;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.model.items.RowItem;

final class UnknownTypeHolder extends RecyclerView.ViewHolder implements ViewBinder {
    private static final String LOG_TAG = "UnknownTypeHolder";

    public UnknownTypeHolder(View view) {
        super(view);
        Logger.d(LOG_TAG, "Something went wrong. Unknown item type encountered. Check your ViewHolder model creation.", new Object[0]);
    }

    public void bind(RowItem rowItem) {
    }
}
