package com.tencent.android.tpush;

public enum NotificationAction {
    clicked(0),
    activity(1),
    url(2),
    intent(3),
    action_package(4),
    intent_with_action(5),
    delete(2),
    open(3),
    open_cancel(4),
    download(5),
    download_cancel(6);
    
    private int type;

    private NotificationAction(int i11) {
        this.type = i11;
    }

    public static NotificationAction getNotificationAction(int i11) {
        if (i11 == 0) {
            return clicked;
        }
        if (i11 == 1) {
            return activity;
        }
        if (i11 == 2) {
            return url;
        }
        if (i11 == 3) {
            return intent;
        }
        if (i11 == 4) {
            return action_package;
        }
        if (i11 != 5) {
            return null;
        }
        return intent_with_action;
    }

    public int getType() {
        return this.type;
    }
}
