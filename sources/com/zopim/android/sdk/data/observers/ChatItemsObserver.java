package com.zopim.android.sdk.data.observers;

import android.content.Context;
import com.zopim.android.sdk.model.ChatLog;
import com.zopim.android.sdk.model.items.RowItem;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public abstract class ChatItemsObserver extends ChatLogObserver {
    private static final String LOG_TAG = "ChatItemsObserver";
    private ViewModelFactory viewModelFactory;

    public ChatItemsObserver(Context context) {
        this.viewModelFactory = new ViewModelFactory(context);
    }

    public void update(LinkedHashMap<String, ChatLog> linkedHashMap) {
        updateChatItems(this.viewModelFactory.createItems(linkedHashMap));
    }

    public abstract void updateChatItems(TreeMap<String, RowItem> treeMap);
}
