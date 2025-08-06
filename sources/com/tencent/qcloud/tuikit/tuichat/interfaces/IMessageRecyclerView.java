package com.tencent.qcloud.tuikit.tuichat.interfaces;

public interface IMessageRecyclerView {
    public static final int DATA_CHANGE_LOCATE_TO_POSITION = 7;
    public static final int DATA_CHANGE_NEW_MESSAGE = 8;
    public static final int DATA_CHANGE_SCROLL_TO_POSITION = 10;
    public static final int DATA_CHANGE_SCROLL_TO_POSITION_WITHOUT_HIGH_LIGHT = 11;
    public static final int DATA_CHANGE_TYPE_ADD_BACK = 3;
    public static final int DATA_CHANGE_TYPE_ADD_FRONT = 2;
    public static final int DATA_CHANGE_TYPE_CLEAR = 6;
    public static final int DATA_CHANGE_TYPE_DELETE = 5;
    public static final int DATA_CHANGE_TYPE_LOAD = 1;
    public static final int DATA_CHANGE_TYPE_REFRESH = 0;
    public static final int DATA_CHANGE_TYPE_UPDATE = 4;
    public static final int SCROLL_TO_POSITION = 9;

    void displayBackToNewMessage(boolean z11, String str, int i11);

    boolean isDisplayJumpMessageLayout();
}
