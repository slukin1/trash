package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class HomeCommonData implements Serializable {
    private String navigationDayImgUrl;
    private String navigationDefaultImgUrl;
    private String navigationJumpUrl;
    private String navigationNightImgUrl;

    public boolean canEqual(Object obj) {
        return obj instanceof HomeCommonData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HomeCommonData)) {
            return false;
        }
        HomeCommonData homeCommonData = (HomeCommonData) obj;
        if (!homeCommonData.canEqual(this)) {
            return false;
        }
        String navigationDefaultImgUrl2 = getNavigationDefaultImgUrl();
        String navigationDefaultImgUrl3 = homeCommonData.getNavigationDefaultImgUrl();
        if (navigationDefaultImgUrl2 != null ? !navigationDefaultImgUrl2.equals(navigationDefaultImgUrl3) : navigationDefaultImgUrl3 != null) {
            return false;
        }
        String navigationDayImgUrl2 = getNavigationDayImgUrl();
        String navigationDayImgUrl3 = homeCommonData.getNavigationDayImgUrl();
        if (navigationDayImgUrl2 != null ? !navigationDayImgUrl2.equals(navigationDayImgUrl3) : navigationDayImgUrl3 != null) {
            return false;
        }
        String navigationNightImgUrl2 = getNavigationNightImgUrl();
        String navigationNightImgUrl3 = homeCommonData.getNavigationNightImgUrl();
        if (navigationNightImgUrl2 != null ? !navigationNightImgUrl2.equals(navigationNightImgUrl3) : navigationNightImgUrl3 != null) {
            return false;
        }
        String navigationJumpUrl2 = getNavigationJumpUrl();
        String navigationJumpUrl3 = homeCommonData.getNavigationJumpUrl();
        return navigationJumpUrl2 != null ? navigationJumpUrl2.equals(navigationJumpUrl3) : navigationJumpUrl3 == null;
    }

    public String getNavigationDayImgUrl() {
        return this.navigationDayImgUrl;
    }

    public String getNavigationDefaultImgUrl() {
        return this.navigationDefaultImgUrl;
    }

    public String getNavigationJumpUrl() {
        return this.navigationJumpUrl;
    }

    public String getNavigationNightImgUrl() {
        return this.navigationNightImgUrl;
    }

    public int hashCode() {
        String navigationDefaultImgUrl2 = getNavigationDefaultImgUrl();
        int i11 = 43;
        int hashCode = navigationDefaultImgUrl2 == null ? 43 : navigationDefaultImgUrl2.hashCode();
        String navigationDayImgUrl2 = getNavigationDayImgUrl();
        int hashCode2 = ((hashCode + 59) * 59) + (navigationDayImgUrl2 == null ? 43 : navigationDayImgUrl2.hashCode());
        String navigationNightImgUrl2 = getNavigationNightImgUrl();
        int hashCode3 = (hashCode2 * 59) + (navigationNightImgUrl2 == null ? 43 : navigationNightImgUrl2.hashCode());
        String navigationJumpUrl2 = getNavigationJumpUrl();
        int i12 = hashCode3 * 59;
        if (navigationJumpUrl2 != null) {
            i11 = navigationJumpUrl2.hashCode();
        }
        return i12 + i11;
    }

    public void setNavigationDayImgUrl(String str) {
        this.navigationDayImgUrl = str;
    }

    public void setNavigationDefaultImgUrl(String str) {
        this.navigationDefaultImgUrl = str;
    }

    public void setNavigationJumpUrl(String str) {
        this.navigationJumpUrl = str;
    }

    public void setNavigationNightImgUrl(String str) {
        this.navigationNightImgUrl = str;
    }

    public String toString() {
        return "HomeCommonData{navigationDefaultImgUrl='" + this.navigationDefaultImgUrl + '\'' + ", navigationDayImgUrl='" + this.navigationDayImgUrl + '\'' + ", navigationNightImgUrl='" + this.navigationNightImgUrl + '\'' + ", navigationJumpUrl='" + this.navigationJumpUrl + '\'' + '}';
    }
}
