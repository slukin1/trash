package com.huobi.staring.bean;

import java.io.Serializable;

public class RemindSettingRule implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private long f81167id;
    private String intro;
    private boolean subbed;
    private String title;

    public RemindSettingRule(long j11, String str, String str2, boolean z11) {
        this.f81167id = j11;
        this.title = str;
        this.intro = str2;
        this.subbed = z11;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof RemindSettingRule;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemindSettingRule)) {
            return false;
        }
        RemindSettingRule remindSettingRule = (RemindSettingRule) obj;
        if (!remindSettingRule.canEqual(this) || getId() != remindSettingRule.getId()) {
            return false;
        }
        String title2 = getTitle();
        String title3 = remindSettingRule.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String intro2 = getIntro();
        String intro3 = remindSettingRule.getIntro();
        if (intro2 != null ? intro2.equals(intro3) : intro3 == null) {
            return isSubbed() == remindSettingRule.isSubbed();
        }
        return false;
    }

    public long getId() {
        return this.f81167id;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        long id2 = getId();
        String title2 = getTitle();
        int i11 = 43;
        int hashCode = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (title2 == null ? 43 : title2.hashCode());
        String intro2 = getIntro();
        int i12 = hashCode * 59;
        if (intro2 != null) {
            i11 = intro2.hashCode();
        }
        return ((i12 + i11) * 59) + (isSubbed() ? 79 : 97);
    }

    public boolean isSubbed() {
        return this.subbed;
    }

    public void setId(long j11) {
        this.f81167id = j11;
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
        return "RemindSettingRule(id=" + getId() + ", title=" + getTitle() + ", intro=" + getIntro() + ", subbed=" + isSubbed() + ")";
    }

    public RemindSettingRule() {
    }
}
