package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class AccountLevelCardData implements Serializable {
    public String highlightText;
    public String text;

    public boolean canEqual(Object obj) {
        return obj instanceof AccountLevelCardData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountLevelCardData)) {
            return false;
        }
        AccountLevelCardData accountLevelCardData = (AccountLevelCardData) obj;
        if (!accountLevelCardData.canEqual(this)) {
            return false;
        }
        String text2 = getText();
        String text3 = accountLevelCardData.getText();
        if (text2 != null ? !text2.equals(text3) : text3 != null) {
            return false;
        }
        String highlightText2 = getHighlightText();
        String highlightText3 = accountLevelCardData.getHighlightText();
        return highlightText2 != null ? highlightText2.equals(highlightText3) : highlightText3 == null;
    }

    public String getHighlightText() {
        return this.highlightText;
    }

    public String getText() {
        return this.text;
    }

    public int hashCode() {
        String text2 = getText();
        int i11 = 43;
        int hashCode = text2 == null ? 43 : text2.hashCode();
        String highlightText2 = getHighlightText();
        int i12 = (hashCode + 59) * 59;
        if (highlightText2 != null) {
            i11 = highlightText2.hashCode();
        }
        return i12 + i11;
    }

    public void setHighlightText(String str) {
        this.highlightText = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String toString() {
        return "AccountLevelCardData(text=" + getText() + ", highlightText=" + getHighlightText() + ")";
    }
}
