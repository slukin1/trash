package com.zopim.android.sdk.chatlog;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.model.items.ChatMemberEvent;

final class ChatMemberEventHolder extends RecyclerView.ViewHolder implements ViewBinder<ChatMemberEvent> {
    private static final String LOG_TAG = "ChatMemberEventHolder";
    private TextView messageView;

    public ChatMemberEventHolder(View view) {
        super(view);
        this.messageView = (TextView) view.findViewById(R.id.message_text);
    }

    public void bind(ChatMemberEvent chatMemberEvent) {
        if (chatMemberEvent == null) {
            Logger.d(LOG_TAG, "Item must not be null", new Object[0]);
        } else {
            this.messageView.setText(chatMemberEvent.getMessage());
        }
    }
}
