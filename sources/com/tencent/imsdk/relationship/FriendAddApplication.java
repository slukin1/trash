package com.tencent.imsdk.relationship;

import android.text.TextUtils;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

public class FriendAddApplication implements Serializable {
    private byte[] addSourceBytes;
    private int addType;
    private byte[] addWordingBytes;
    private byte[] groupNameBytes;
    private byte[] remarkBytes;
    private String userID;

    public void setAddSource(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.addSourceBytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
    }

    public void setAddType(int i11) {
        this.addType = i11;
    }

    public void setAddWording(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.addWordingBytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.groupNameBytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
    }

    public void setRemark(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.remarkBytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
