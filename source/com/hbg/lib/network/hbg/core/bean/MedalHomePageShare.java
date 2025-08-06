package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class MedalHomePageShare implements Serializable {
    @SerializedName("lightUpNum")
    private int lightUpNum;
    @SerializedName("showMedals")
    private List<ShowMedalsBean> showMedals;
    @SerializedName("surpassPercent")
    private String surpassPercent;

    public static class ShowMedalsBean implements Serializable {
        @SerializedName("imageUrl")
        private String imageUrl;
        @SerializedName("medalCode")
        private String medalCode;
        @SerializedName("medalLevel")
        private String medalLevel;
        @SerializedName("medalName")
        private String medalName;

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
    }

    public int getLightUpNum() {
        return this.lightUpNum;
    }

    public List<ShowMedalsBean> getShowMedals() {
        return this.showMedals;
    }

    public String getSurpassPercent() {
        return this.surpassPercent;
    }

    public void setLightUpNum(int i11) {
        this.lightUpNum = i11;
    }

    public void setShowMedals(List<ShowMedalsBean> list) {
        this.showMedals = list;
    }

    public void setSurpassPercent(String str) {
        this.surpassPercent = str;
    }
}
