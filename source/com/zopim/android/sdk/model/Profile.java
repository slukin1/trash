package com.zopim.android.sdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {
    @SerializedName("department_id$int")
    @Expose
    private String departmentId;
    @SerializedName("display_name$string")
    @Expose
    private String displayName;
    @SerializedName("email$string")
    @Expose
    private String email;
    @SerializedName("mid$string")
    @Expose
    private String machineId;
    @SerializedName("phone$string")
    @Expose
    private String phoneNumber;

    public String getDepartmentId() {
        return this.departmentId;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMachineId() {
        return this.machineId;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String toString() {
        return " mid:" + this.machineId + " email:" + this.email + " name:" + this.displayName + " depId:" + this.departmentId;
    }
}
