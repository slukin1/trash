package com.tencent.imsdk.v2;

import java.io.Serializable;
import java.util.Map;

public class V2TIMCreateGroupMemberInfo implements Serializable {
    private Map<String, byte[]> customInfo;
    private int role = 0;
    private String userID;

    public int getRole() {
        return this.role;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setRole(int i11) {
        if (i11 == 200) {
            i11 = 0;
        }
        this.role = i11;
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
