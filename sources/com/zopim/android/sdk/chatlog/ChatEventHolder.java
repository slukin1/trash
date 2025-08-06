package com.zopim.android.sdk.chatlog;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.model.items.ChatEvent;

final class ChatEventHolder extends RecyclerView.ViewHolder implements ViewBinder<ChatEvent> {
    private static final String LOG_TAG = "ChatEventHolder";
    private TextView messageView;

    public ChatEventHolder(View view) {
        super(view);
        this.messageView = (TextView) view.findViewById(R.id.message_text);
    }

    public void bind(ChatEvent chatEvent) {
        if (chatEvent == null) {
            Logger.d(LOG_TAG, "Item must not be null", new Object[0]);
        } else {
            this.messageView.setText(chatEvent.getMessage());
        }
    }
}
