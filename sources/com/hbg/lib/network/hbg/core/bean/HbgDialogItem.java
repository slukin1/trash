package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class HbgDialogItem implements Serializable {
    private static final long serialVersionUID = 9048307263476622534L;
    public String buttonText;
    public String icon;
    public String language;
    public String showCloseButton;
    public String showText;
    public String showTitle;
    public String url;

    public boolean canEqual(Object obj) {
        return obj instanceof HbgDialogItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HbgDialogItem)) {
            return false;
        }
        HbgDialogItem hbgDialogItem = (HbgDialogItem) obj;
        if (!hbgDialogItem.canEqual(this)) {
            return false;
        }
        String language2 = getLanguage();
        String language3 = hbgDialogItem.getLanguage();
        if (language2 != null ? !language2.equals(language3) : language3 != null) {
            return false;
        }
        String icon2 = getIcon();
        String icon3 = hbgDialogItem.getIcon();
        if (icon2 != null ? !icon2.equals(icon3) : icon3 != null) {
            return false;
        }
        String url2 = getUrl();
        String url3 = hbgDialogItem.getUrl();
        if (url2 != null ? !url2.equals(url3) : url3 != null) {
            return false;
        }
        String showTitle2 = getShowTitle();
        String showTitle3 = hbgDialogItem.getShowTitle();
        if (showTitle2 != null ? !showTitle2.equals(showTitle3) : showTitle3 != null) {
            return false;
        }
        String showText2 = getShowText();
        String showText3 = hbgDialogItem.getShowText();
        if (showText2 != null ? !showText2.equals(showText3) : showText3 != null) {
            return false;
        }
        String buttonText2 = getButtonText();
        String buttonText3 = hbgDialogItem.getButtonText();
        if (buttonText2 != null ? !buttonText2.equals(buttonText3) : buttonText3 != null) {
            return false;
        }
        String showCloseButton2 = getShowCloseButton();
        String showCloseButton3 = hbgDialogItem.getShowCloseButton();
        return showCloseButton2 != null ? showCloseButton2.equals(showCloseButton3) : showCloseButton3 == null;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getShowCloseButton() {
        return this.showCloseButton;
    }

    public String getShowText() {
        return this.showText;
    }

    public String getShowTitle() {
        return this.showTitle;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String language2 = getLanguage();
        int i11 = 43;
        int hashCode = language2 == null ? 43 : language2.hashCode();
        String icon2 = getIcon();
        int hashCode2 = ((hashCode + 59) * 59) + (icon2 == null ? 43 : icon2.hashCode());
        String url2 = getUrl();
        int hashCode3 = (hashCode2 * 59) + (url2 == null ? 43 : url2.hashCode());
        String showTitle2 = getShowTitle();
        int hashCode4 = (hashCode3 * 59) + (showTitle2 == null ? 43 : showTitle2.hashCode());
        String showText2 = getShowText();
        int hashCode5 = (hashCode4 * 59) + (showText2 == null ? 43 : showText2.hashCode());
        String buttonText2 = getButtonText();
        int hashCode6 = (hashCode5 * 59) + (buttonText2 == null ? 43 : buttonText2.hashCode());
        String showCloseButton2 = getShowCloseButton();
        int i12 = hashCode6 * 59;
        if (showCloseButton2 != null) {
            i11 = showCloseButton2.hashCode();
        }
        return i12 + i11;
    }

    public void setButtonText(String str) {
        this.buttonText = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setShowCloseButton(String str) {
        this.showCloseButton = str;
    }

    public void setShowText(String str) {
        this.showText = str;
    }

    public void setShowTitle(String str) {
        this.showTitle = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "HbgDialogItem(language=" + getLanguage() + ", icon=" + getIcon() + ", url=" + getUrl() + ", showTitle=" + getShowTitle() + ", showText=" + getShowText() + ", buttonText=" + getButtonText() + ", showCloseButton=" + getShowCloseButton() + ")";
    }
}
