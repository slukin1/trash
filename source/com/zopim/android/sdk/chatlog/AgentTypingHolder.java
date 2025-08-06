package com.zopim.android.sdk.chatlog;

import android.view.View;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.chatlog.view.TypingIndicatorView;
import com.zopim.android.sdk.model.items.AgentTyping;

final class AgentTypingHolder extends AgentHolder<AgentTyping> {
    private TypingIndicatorView typingIndicatorView;

    public AgentTypingHolder(View view) {
        super(view);
        this.typingIndicatorView = (TypingIndicatorView) view.findViewById(R.id.typing_indicator);
    }

    private void hideTyping() {
        this.typingIndicatorView.stop();
        this.typingIndicatorView.setVisibility(8);
        this.avatarView.setVisibility(8);
    }

    private void showTyping() {
        this.typingIndicatorView.setVisibility(0);
        this.typingIndicatorView.start();
    }

    public void bind(AgentTyping agentTyping) {
        super.bind(agentTyping);
        if (agentTyping.isTyping()) {
            showTyping();
        } else {
            hideTyping();
        }
    }
}
