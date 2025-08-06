package com.hbg.lib.widgets.tablayout;

import java.io.Serializable;

public class TabItemLayoutData implements Serializable {
    private boolean isCheck;
    private String leftTabText;
    private String middleTabText;
    private String rightTabText;

    public boolean canEqual(Object obj) {
        return obj instanceof TabItemLayoutData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TabItemLayoutData)) {
            return false;
        }
        TabItemLayoutData tabItemLayoutData = (TabItemLayoutData) obj;
        if (!tabItemLayoutData.canEqual(this) || isCheck() != tabItemLayoutData.isCheck()) {
            return false;
        }
        String leftTabText2 = getLeftTabText();
        String leftTabText3 = tabItemLayoutData.getLeftTabText();
        if (leftTabText2 != null ? !leftTabText2.equals(leftTabText3) : leftTabText3 != null) {
            return false;
        }
        String middleTabText2 = getMiddleTabText();
        String middleTabText3 = tabItemLayoutData.getMiddleTabText();
        if (middleTabText2 != null ? !middleTabText2.equals(middleTabText3) : middleTabText3 != null) {
            return false;
        }
        String rightTabText2 = getRightTabText();
        String rightTabText3 = tabItemLayoutData.getRightTabText();
        return rightTabText2 != null ? rightTabText2.equals(rightTabText3) : rightTabText3 == null;
    }

    public String getLeftTabText() {
        return this.leftTabText;
    }

    public String getMiddleTabText() {
        return this.middleTabText;
    }

    public String getRightTabText() {
        return this.rightTabText;
    }

    public int hashCode() {
        int i11 = isCheck() ? 79 : 97;
        String leftTabText2 = getLeftTabText();
        int i12 = 43;
        int hashCode = ((i11 + 59) * 59) + (leftTabText2 == null ? 43 : leftTabText2.hashCode());
        String middleTabText2 = getMiddleTabText();
        int hashCode2 = (hashCode * 59) + (middleTabText2 == null ? 43 : middleTabText2.hashCode());
        String rightTabText2 = getRightTabText();
        int i13 = hashCode2 * 59;
        if (rightTabText2 != null) {
            i12 = rightTabText2.hashCode();
        }
        return i13 + i12;
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public void setCheck(boolean z11) {
        this.isCheck = z11;
    }

    public void setLeftTabText(String str) {
        this.leftTabText = str;
    }

    public void setMiddleTabText(String str) {
        this.middleTabText = str;
    }

    public void setRightTabText(String str) {
        this.rightTabText = str;
    }

    public String toString() {
        return "TabItemLayoutData(isCheck=" + isCheck() + ", leftTabText=" + getLeftTabText() + ", middleTabText=" + getMiddleTabText() + ", rightTabText=" + getRightTabText() + ")";
    }
}
