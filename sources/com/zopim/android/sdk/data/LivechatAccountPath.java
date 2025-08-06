package com.zopim.android.sdk.data;

import com.zopim.android.sdk.model.Account;

public class LivechatAccountPath extends Path<Account> {
    private static final LivechatAccountPath INSTANCE = new LivechatAccountPath();

    private LivechatAccountPath() {
    }

    public static LivechatAccountPath getInstance() {
        return INSTANCE;
    }

    public void clear() {
        this.data = null;
    }

    public void update(String str) {
        if (isClearRequired(str)) {
            clear();
        } else if (!str.isEmpty()) {
            if (this.data == null) {
                this.data = new Account();
            }
            this.data = ChatGson.performUpdate(this.data, str, Account.class);
            broadcast(getData());
        }
    }

    public Account getData() {
        return (Account) this.data;
    }
}
