package com.zopim.android.sdk.data;

import com.zopim.android.sdk.model.FileSending;

public class LivechatFileSendingPath extends Path<FileSending> {
    private static final LivechatFileSendingPath INSTANCE = new LivechatFileSendingPath();

    private LivechatFileSendingPath() {
    }

    public static LivechatFileSendingPath getInstance() {
        return INSTANCE;
    }

    public void clear() {
        this.data = null;
    }

    public void update(String str) {
        if (isClearRequired(str)) {
            clear();
        } else if (str != null && !str.isEmpty()) {
            if (this.data == null) {
                this.data = new FileSending();
            }
            this.data = ChatGson.performUpdate(this.data, str, FileSending.class);
            broadcast(getData());
        }
    }

    public FileSending getData() {
        return (FileSending) this.data;
    }
}
