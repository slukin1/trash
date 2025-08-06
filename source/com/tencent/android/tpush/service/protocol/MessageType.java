package com.tencent.android.tpush.service.protocol;

import com.tencent.android.tpush.common.Constants;
import com.xiaomi.mipush.sdk.MiPushClient;

public enum MessageType {
    REGISTER(MiPushClient.COMMAND_REGISTER),
    ACCOUNT(Constants.FLAG_ACCOUNT),
    UNREGISTER(MiPushClient.COMMAND_UNREGISTER),
    TAG_INFO("tag"),
    ATTRIBUTE_INFO("attribute"),
    UPDATE_OTHER_TOKEN("update_channel_token"),
    PUSH_MESSAGE(com.adjust.sdk.Constants.PUSH),
    PUSH_VERIFY("push_stat"),
    COMMON_REPORT("common_report"),
    QUERY_TAGS("query_token_tags");
    
    private String str;

    private MessageType(String str2) {
        this.str = str2;
    }

    public String getStr() {
        return this.str;
    }
}
