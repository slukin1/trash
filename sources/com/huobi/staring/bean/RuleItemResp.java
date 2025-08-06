package com.huobi.staring.bean;

import java.io.Serializable;

public class RuleItemResp implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private int f81169id;
    private String intro;
    private boolean subbed;
    private String title;

    public boolean canEqual(Object obj) {
        return obj instanceof RuleItemResp;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RuleItemResp)) {
            return false;
        }
        RuleItemResp ruleItemResp = (RuleItemResp) obj;
        if (!ruleItemResp.canEqual(this) || getId() != ruleItemResp.getId()) {
            return false;
        }
        String title2 = getTitle();
        String title3 = ruleItemResp.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String intro2 = getIntro();
        String intro3 = ruleItemResp.getIntro();
        if (intro2 != null ? intro2.equals(intro3) : intro3 == null) {
            return isSubbed() == ruleItemResp.isSubbed();
        }
        return false;
    }

    public int getId() {
        return this.f81169id;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String title2 = getTitle();
        int i11 = 43;
        int id2 = ((getId() + 59) * 59) + (title2 == null ? 43 : title2.hashCode());
        String intro2 = getIntro();
        int i12 = id2 * 59;
        if (intro2 != null) {
            i11 = intro2.hashCode();
        }
        return ((i12 + i11) * 59) + (isSubbed() ? 79 : 97);
    }

    public boolean isSubbed() {
        return this.subbed;
    }

    public void setId(int i11) {
        this.f81169id = i11;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setSubbed(boolean z11) {
        this.subbed = z11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "RuleItemResp(id=" + getId() + ", title=" + getTitle() + ", intro=" + getIntro() + ", subbed=" + isSubbed() + ")";
    }
}
