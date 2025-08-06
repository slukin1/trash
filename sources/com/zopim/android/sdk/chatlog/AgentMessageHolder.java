package com.zopim.android.sdk.chatlog;

import android.view.View;
import android.widget.TextView;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.model.items.AgentMessage;

final class AgentMessageHolder extends AgentHolder<AgentMessage> {
    private TextView messageView;

    public AgentMessageHolder(View view) {
        super(view);
        this.messageView = (TextView) view.findViewById(R.id.message_text);
    }

    public void bind(AgentMessage agentMessage) {
        super.bind(agentMessage);
        this.messageView.setText(agentMessage.getMessage());
    }
}
