package com.zopim.android.sdk.data.observers;

import android.content.Context;
import com.zopim.android.sdk.model.Agent;
import com.zopim.android.sdk.model.items.AgentTyping;
import java.util.Map;
import java.util.TreeMap;

public abstract class AgentsTypingObserver extends AgentsObserver {
    private ViewModelFactory viewModelFactory;

    public AgentsTypingObserver(Context context) {
        this.viewModelFactory = new ViewModelFactory(context);
    }

    public void update(Map<String, Agent> map) {
        TreeMap<String, AgentTyping> createItems = this.viewModelFactory.createItems(map);
        if (!createItems.isEmpty()) {
            updateTyping(createItems);
        }
    }

    public abstract void updateTyping(Map<String, AgentTyping> map);
}
