package com.zopim.android.sdk.api;

import java.io.Serializable;

public class MyZendeskNote implements Serializable {
    private String departmentName;

    public boolean canEqual(Object obj) {
        return obj instanceof MyZendeskNote;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MyZendeskNote)) {
            return false;
        }
        MyZendeskNote myZendeskNote = (MyZendeskNote) obj;
        if (!myZendeskNote.canEqual(this)) {
            return false;
        }
        String departmentName2 = getDepartmentName();
        String departmentName3 = myZendeskNote.getDepartmentName();
        return departmentName2 != null ? departmentName2.equals(departmentName3) : departmentName3 == null;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public int hashCode() {
        String departmentName2 = getDepartmentName();
        return 59 + (departmentName2 == null ? 43 : departmentName2.hashCode());
    }

    public void setDepartmentName(String str) {
        this.departmentName = str;
    }

    public String toString() {
        return "MyZendeskNote(departmentName=" + getDepartmentName() + ")";
    }
}
