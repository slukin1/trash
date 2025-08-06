package com.huobi.asset.event;

public class ChangeVerticalSpotFromWhiteListEvent {
    public boolean a(Object obj) {
        return obj instanceof ChangeVerticalSpotFromWhiteListEvent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ChangeVerticalSpotFromWhiteListEvent) && ((ChangeVerticalSpotFromWhiteListEvent) obj).a(this);
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "ChangeVerticalSpotFromWhiteListEvent()";
    }
}
