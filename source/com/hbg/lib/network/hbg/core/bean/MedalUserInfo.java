package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class MedalUserInfo implements Serializable {
    @SerializedName("days")
    private int days;
    @SerializedName("medalNums")
    private int medalNums;
    @SerializedName("medalWearList")
    private List<MedalWearListBean> medalWearList;

    public static class MedalWearListBean implements Serializable {
        @SerializedName("imageUrl")
        private String imageUrl;
        @SerializedName("medalCode")
        private String medalCode;
        @SerializedName("medalLevel")
        private String medalLevel;
        @SerializedName("medalName")
        private String medalName;
        @SerializedName("userMedalId")
        private String userMedalId;

        public String getImageUrl() {
            return this.imageUrl;
        }

        public String getMedalCode() {
            return this.medalCode;
        }

        public String getMedalLevel() {
            return this.medalLevel;
        }

        public String getMedalName() {
            return this.medalName;
        }

        public String getUserMedalId() {
            return this.userMedalId;
        }

        public void setImageUrl(String str) {
            this.imageUrl = str;
        }

        public void setMedalCode(String str) {
            this.medalCode = str;
        }

        public void setMedalLevel(String str) {
            this.medalLevel = str;
        }

        public void setMedalName(String str) {
            this.medalName = str;
        }

        public void setUserMedalId(String str) {
            this.userMedalId = str;
        }
    }

    public int getDays() {
        return this.days;
    }

    public int getMedalNums() {
        return this.medalNums;
    }

    public List<MedalWearListBean> getMedalWearList() {
        return this.medalWearList;
    }

    public void setDays(int i11) {
        this.days = i11;
    }

    public void setMedalNums(int i11) {
        this.medalNums = i11;
    }

    public void setMedalWearList(List<MedalWearListBean> list) {
        this.medalWearList = list;
    }
}
