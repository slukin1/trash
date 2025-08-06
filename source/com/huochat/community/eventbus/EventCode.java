package com.huochat.community.eventbus;

public final class EventCode {
    private static int BASE_EVENT_CODE;
    public static int REFRESH_COMMUNITY_LIST;
    public static int SWITCH_THEME;

    static {
        int i11 = 0 + 1;
        BASE_EVENT_CODE = i11;
        BASE_EVENT_CODE = i11 + 1;
        REFRESH_COMMUNITY_LIST = i11;
    }
}
