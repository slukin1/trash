package com.hbg.lib.imsdk;

import java.io.Serializable;

public class HbgDialogJsWidthHeight implements Serializable {
    private static final long serialVersionUID = -8006618821562055451L;
    private String availableLocationY;
    private String displayHeight;
    private String displayWidth;
    private String navigatorHeight;

    public boolean canEqual(Object obj) {
        return obj instanceof HbgDialogJsWidthHeight;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HbgDialogJsWidthHeight)) {
            return false;
        }
        HbgDialogJsWidthHeight hbgDialogJsWidthHeight = (HbgDialogJsWidthHeight) obj;
        if (!hbgDialogJsWidthHeight.canEqual(this)) {
            return false;
        }
        String displayWidth2 = getDisplayWidth();
        String displayWidth3 = hbgDialogJsWidthHeight.getDisplayWidth();
        if (displayWidth2 != null ? !displayWidth2.equals(displayWidth3) : displayWidth3 != null) {
            return false;
        }
        String displayHeight2 = getDisplayHeight();
        String displayHeight3 = hbgDialogJsWidthHeight.getDisplayHeight();
        if (displayHeight2 != null ? !displayHeight2.equals(displayHeight3) : displayHeight3 != null) {
            return false;
        }
        String navigatorHeight2 = getNavigatorHeight();
        String navigatorHeight3 = hbgDialogJsWidthHeight.getNavigatorHeight();
        if (navigatorHeight2 != null ? !navigatorHeight2.equals(navigatorHeight3) : navigatorHeight3 != null) {
            return false;
        }
        String availableLocationY2 = getAvailableLocationY();
        String availableLocationY3 = hbgDialogJsWidthHeight.getAvailableLocationY();
        return availableLocationY2 != null ? availableLocationY2.equals(availableLocationY3) : availableLocationY3 == null;
    }

    public String getAvailableLocationY() {
        return this.availableLocationY;
    }

    public String getDisplayHeight() {
        return this.displayHeight;
    }

    public String getDisplayWidth() {
        return this.displayWidth;
    }

    public String getNavigatorHeight() {
        return this.navigatorHeight;
    }

    public int hashCode() {
        String displayWidth2 = getDisplayWidth();
        int i11 = 43;
        int hashCode = displayWidth2 == null ? 43 : displayWidth2.hashCode();
        String displayHeight2 = getDisplayHeight();
        int hashCode2 = ((hashCode + 59) * 59) + (displayHeight2 == null ? 43 : displayHeight2.hashCode());
        String navigatorHeight2 = getNavigatorHeight();
        int hashCode3 = (hashCode2 * 59) + (navigatorHeight2 == null ? 43 : navigatorHeight2.hashCode());
        String availableLocationY2 = getAvailableLocationY();
        int i12 = hashCode3 * 59;
        if (availableLocationY2 != null) {
            i11 = availableLocationY2.hashCode();
        }
        return i12 + i11;
    }

    public void setAvailableLocationY(String str) {
        this.availableLocationY = str;
    }

    public void setDisplayHeight(String str) {
        this.displayHeight = str;
    }

    public void setDisplayWidth(String str) {
        this.displayWidth = str;
    }

    public void setNavigatorHeight(String str) {
        this.navigatorHeight = str;
    }

    public String toString() {
        return "HbgDialogJsWidthHeight(displayWidth=" + getDisplayWidth() + ", displayHeight=" + getDisplayHeight() + ", navigatorHeight=" + getNavigatorHeight() + ", availableLocationY=" + getAvailableLocationY() + ")";
    }
}
