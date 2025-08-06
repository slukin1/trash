package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.relationship.UserInfo;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class V2TIMUserInfo implements Serializable {
    public HashMap<String, Object> modifyParams = new HashMap<>();
    public UserInfo userInfo = new UserInfo();

    public long getBirthday() {
        return this.userInfo.getBirthday();
    }

    public String getFaceUrl() {
        return this.userInfo.getFaceUrl();
    }

    public HashMap<String, Object> getModifyParams() {
        return this.modifyParams;
    }

    public String getNickName() {
        return this.userInfo.getNickname();
    }

    public String getUserID() {
        return this.userInfo.getUserID();
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setBirthday(long j11) {
        this.userInfo.setBirthday(j11);
        this.modifyParams.put(UserInfo.USERINFO_KEY_BIRTHDAY, Long.valueOf(j11));
    }

    public void setFaceUrl(String str) {
        this.userInfo.setFaceUrl(str);
        this.modifyParams.put("Tag_Profile_IM_Image", str);
    }

    public void setNickName(String str) {
        byte[] bArr;
        this.userInfo.setNickname(str);
        if (!TextUtils.isEmpty(str)) {
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
                bArr = new byte[0];
            }
        } else {
            bArr = new byte[0];
        }
        this.modifyParams.put("Tag_Profile_IM_Nick", bArr);
    }

    public void setUserID(String str) {
        this.userInfo.setUserID(str);
    }

    public void setUserInfo(UserInfo userInfo2) {
        this.userInfo = userInfo2;
    }
}
