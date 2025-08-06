package com.huobi.account.entity;

import android.view.View;
import com.huobi.account.viewhandler.PersonalCenterFuncItemHandler;
import java.io.Serializable;
import s9.a;

public class PersonalCenterFuncItem implements Serializable, a {
    private static final long serialVersionUID = -6437636821753647281L;
    private int funcItemBg = -1;
    private int iconJsonRes = -1;
    private int iconRes;
    private boolean isIconJson = false;
    private View.OnClickListener onClickListener;
    private String subtitlePrefix;
    private int subtitleSize;
    private int subtitleSuffixRes;
    private CharSequence subtitleText;
    private int titleRes;
    private int type;

    public boolean canEqual(Object obj) {
        return obj instanceof PersonalCenterFuncItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersonalCenterFuncItem)) {
            return false;
        }
        PersonalCenterFuncItem personalCenterFuncItem = (PersonalCenterFuncItem) obj;
        if (!personalCenterFuncItem.canEqual(this) || getTitleRes() != personalCenterFuncItem.getTitleRes()) {
            return false;
        }
        String subtitlePrefix2 = getSubtitlePrefix();
        String subtitlePrefix3 = personalCenterFuncItem.getSubtitlePrefix();
        if (subtitlePrefix2 != null ? !subtitlePrefix2.equals(subtitlePrefix3) : subtitlePrefix3 != null) {
            return false;
        }
        CharSequence subtitleText2 = getSubtitleText();
        CharSequence subtitleText3 = personalCenterFuncItem.getSubtitleText();
        if (subtitleText2 != null ? !subtitleText2.equals(subtitleText3) : subtitleText3 != null) {
            return false;
        }
        if (getSubtitleSuffixRes() != personalCenterFuncItem.getSubtitleSuffixRes() || getIconRes() != personalCenterFuncItem.getIconRes() || getIconJsonRes() != personalCenterFuncItem.getIconJsonRes() || isIconJson() != personalCenterFuncItem.isIconJson() || getFuncItemBg() != personalCenterFuncItem.getFuncItemBg() || getSubtitleSize() != personalCenterFuncItem.getSubtitleSize() || getType() != personalCenterFuncItem.getType()) {
            return false;
        }
        View.OnClickListener onClickListener2 = getOnClickListener();
        View.OnClickListener onClickListener3 = personalCenterFuncItem.getOnClickListener();
        return onClickListener2 != null ? onClickListener2.equals(onClickListener3) : onClickListener3 == null;
    }

    public int getFuncItemBg() {
        return this.funcItemBg;
    }

    public int getIconJsonRes() {
        return this.iconJsonRes;
    }

    public int getIconRes() {
        return this.iconRes;
    }

    public View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public String getSubtitlePrefix() {
        return this.subtitlePrefix;
    }

    public int getSubtitleSize() {
        return this.subtitleSize;
    }

    public int getSubtitleSuffixRes() {
        return this.subtitleSuffixRes;
    }

    public CharSequence getSubtitleText() {
        return this.subtitleText;
    }

    public int getTitleRes() {
        return this.titleRes;
    }

    public int getType() {
        return this.type;
    }

    public String getViewHandlerName() {
        return PersonalCenterFuncItemHandler.class.getName();
    }

    public int hashCode() {
        String subtitlePrefix2 = getSubtitlePrefix();
        int i11 = 43;
        int titleRes2 = ((getTitleRes() + 59) * 59) + (subtitlePrefix2 == null ? 43 : subtitlePrefix2.hashCode());
        CharSequence subtitleText2 = getSubtitleText();
        int hashCode = (((((((((((((((titleRes2 * 59) + (subtitleText2 == null ? 43 : subtitleText2.hashCode())) * 59) + getSubtitleSuffixRes()) * 59) + getIconRes()) * 59) + getIconJsonRes()) * 59) + (isIconJson() ? 79 : 97)) * 59) + getFuncItemBg()) * 59) + getSubtitleSize()) * 59) + getType();
        View.OnClickListener onClickListener2 = getOnClickListener();
        int i12 = hashCode * 59;
        if (onClickListener2 != null) {
            i11 = onClickListener2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isIconJson() {
        return this.isIconJson;
    }

    public void setFuncItemBg(int i11) {
        this.funcItemBg = i11;
    }

    public void setIconJson(boolean z11) {
        this.isIconJson = z11;
    }

    public void setIconJsonRes(int i11) {
        this.iconJsonRes = i11;
    }

    public void setIconRes(int i11) {
        this.iconRes = i11;
    }

    public void setOnClickListener(View.OnClickListener onClickListener2) {
        this.onClickListener = onClickListener2;
    }

    public void setSubtitlePrefix(String str) {
        this.subtitlePrefix = str;
    }

    public void setSubtitleSize(int i11) {
        this.subtitleSize = i11;
    }

    public void setSubtitleSuffixRes(int i11) {
        this.subtitleSuffixRes = i11;
    }

    public void setSubtitleText(CharSequence charSequence) {
        this.subtitleText = charSequence;
    }

    public void setTitleRes(int i11) {
        this.titleRes = i11;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "PersonalCenterFuncItem(titleRes=" + getTitleRes() + ", subtitlePrefix=" + getSubtitlePrefix() + ", subtitleText=" + getSubtitleText() + ", subtitleSuffixRes=" + getSubtitleSuffixRes() + ", iconRes=" + getIconRes() + ", iconJsonRes=" + getIconJsonRes() + ", isIconJson=" + isIconJson() + ", funcItemBg=" + getFuncItemBg() + ", subtitleSize=" + getSubtitleSize() + ", type=" + getType() + ", onClickListener=" + getOnClickListener() + ")";
    }
}
