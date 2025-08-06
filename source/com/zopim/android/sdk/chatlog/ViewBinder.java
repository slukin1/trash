package com.zopim.android.sdk.chatlog;

import com.zopim.android.sdk.model.items.RowItem;

interface ViewBinder<T extends RowItem> {
    void bind(T t11);
}
