package com.zopim.android.sdk.data;

import com.zopim.android.sdk.model.Profile;

public class LivechatProfilePath extends Path<Profile> {
    private static final LivechatProfilePath INSTANCE = new LivechatProfilePath();

    private LivechatProfilePath() {
    }

    public static LivechatProfilePath getInstance() {
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
                this.data = new Profile();
            }
            this.data = ChatGson.performUpdate(this.data, str, Profile.class);
            broadcast(getData());
        }
    }

    public Profile getData() {
        return (Profile) this.data;
    }
}
