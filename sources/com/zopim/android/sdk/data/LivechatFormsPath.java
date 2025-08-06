package com.zopim.android.sdk.data;

import com.zopim.android.sdk.model.Forms;

public class LivechatFormsPath extends Path<Forms> {
    private static final LivechatFormsPath INSTANCE = new LivechatFormsPath();

    private LivechatFormsPath() {
    }

    public static LivechatFormsPath getInstance() {
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
                this.data = new Forms();
            }
            this.data = ChatGson.performUpdate(this.data, str, Forms.class);
            broadcast(getData());
        }
    }

    public Forms getData() {
        return (Forms) this.data;
    }
}
