package com.zopim.android.sdk.data;

import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.zendesk.logger.Logger;

enum PathName {
    LIVECHAT_CHANNEL_LOG("livechat.channel.log"),
    LIVECHAT_PROFILE("livechat.profile"),
    LIVECHAT_AGENTS("livechat.agents"),
    LIVECHAT_UI("livechat.ui"),
    LIVECHAT_DEPARTMENTS("livechat.departments"),
    LIVECHAT_ACCOUNT("livechat.account"),
    LIVECHAT_SETTINGS_FORMS("livechat.settings.forms"),
    LIVECHAT_SETTINGS_FILE_SENDING("livechat.settings.file_sending"),
    CONNECTION("connection"),
    UNKNOWN("unknown");
    
    private static final String LOG_TAG = "PathName";
    private final String value;

    private PathName(String str) {
        this.value = str;
    }

    public static PathName get(String str) {
        for (PathName pathName : values()) {
            if (pathName.value.contentEquals(str)) {
                return pathName;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unknown protocol path, will return ");
        PathName pathName2 = UNKNOWN;
        sb2.append(pathName2);
        sb2.append(l.f34627b);
        sb2.append(str);
        Logger.g(LOG_TAG, sb2.toString(), new Object[0]);
        return pathName2;
    }
}
