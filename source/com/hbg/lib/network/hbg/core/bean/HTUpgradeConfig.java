package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class HTUpgradeConfig implements Serializable {
    private String displayDescription;
    private String displayFirstName;
    private String displayIcon;
    private String displayIconNight;
    private String displayJumpName;
    private String displaySecondName;
    private String jumpUrl;
    private int type;
    private String upgradeDetailUrl;
    private String upgradeSymbol;

    public boolean canEqual(Object obj) {
        return obj instanceof HTUpgradeConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HTUpgradeConfig)) {
            return false;
        }
        HTUpgradeConfig hTUpgradeConfig = (HTUpgradeConfig) obj;
        if (!hTUpgradeConfig.canEqual(this)) {
            return false;
        }
        String upgradeSymbol2 = getUpgradeSymbol();
        String upgradeSymbol3 = hTUpgradeConfig.getUpgradeSymbol();
        if (upgradeSymbol2 != null ? !upgradeSymbol2.equals(upgradeSymbol3) : upgradeSymbol3 != null) {
            return false;
        }
        String displayFirstName2 = getDisplayFirstName();
        String displayFirstName3 = hTUpgradeConfig.getDisplayFirstName();
        if (displayFirstName2 != null ? !displayFirstName2.equals(displayFirstName3) : displayFirstName3 != null) {
            return false;
        }
        String displaySecondName2 = getDisplaySecondName();
        String displaySecondName3 = hTUpgradeConfig.getDisplaySecondName();
        if (displaySecondName2 != null ? !displaySecondName2.equals(displaySecondName3) : displaySecondName3 != null) {
            return false;
        }
        String displayDescription2 = getDisplayDescription();
        String displayDescription3 = hTUpgradeConfig.getDisplayDescription();
        if (displayDescription2 != null ? !displayDescription2.equals(displayDescription3) : displayDescription3 != null) {
            return false;
        }
        String displayIcon2 = getDisplayIcon();
        String displayIcon3 = hTUpgradeConfig.getDisplayIcon();
        if (displayIcon2 != null ? !displayIcon2.equals(displayIcon3) : displayIcon3 != null) {
            return false;
        }
        String displayIconNight2 = getDisplayIconNight();
        String displayIconNight3 = hTUpgradeConfig.getDisplayIconNight();
        if (displayIconNight2 != null ? !displayIconNight2.equals(displayIconNight3) : displayIconNight3 != null) {
            return false;
        }
        String jumpUrl2 = getJumpUrl();
        String jumpUrl3 = hTUpgradeConfig.getJumpUrl();
        if (jumpUrl2 != null ? !jumpUrl2.equals(jumpUrl3) : jumpUrl3 != null) {
            return false;
        }
        String displayJumpName2 = getDisplayJumpName();
        String displayJumpName3 = hTUpgradeConfig.getDisplayJumpName();
        if (displayJumpName2 != null ? !displayJumpName2.equals(displayJumpName3) : displayJumpName3 != null) {
            return false;
        }
        String upgradeDetailUrl2 = getUpgradeDetailUrl();
        String upgradeDetailUrl3 = hTUpgradeConfig.getUpgradeDetailUrl();
        if (upgradeDetailUrl2 != null ? upgradeDetailUrl2.equals(upgradeDetailUrl3) : upgradeDetailUrl3 == null) {
            return getType() == hTUpgradeConfig.getType();
        }
        return false;
    }

    public String getDisplayDescription() {
        return this.displayDescription;
    }

    public String getDisplayFirstName() {
        return this.displayFirstName;
    }

    public String getDisplayIcon() {
        return this.displayIcon;
    }

    public String getDisplayIconNight() {
        return this.displayIconNight;
    }

    public String getDisplayJumpName() {
        return this.displayJumpName;
    }

    public String getDisplaySecondName() {
        return this.displaySecondName;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getType() {
        return this.type;
    }

    public String getUpgradeDetailUrl() {
        return this.upgradeDetailUrl;
    }

    public String getUpgradeSymbol() {
        return this.upgradeSymbol;
    }

    public int hashCode() {
        String upgradeSymbol2 = getUpgradeSymbol();
        int i11 = 43;
        int hashCode = upgradeSymbol2 == null ? 43 : upgradeSymbol2.hashCode();
        String displayFirstName2 = getDisplayFirstName();
        int hashCode2 = ((hashCode + 59) * 59) + (displayFirstName2 == null ? 43 : displayFirstName2.hashCode());
        String displaySecondName2 = getDisplaySecondName();
        int hashCode3 = (hashCode2 * 59) + (displaySecondName2 == null ? 43 : displaySecondName2.hashCode());
        String displayDescription2 = getDisplayDescription();
        int hashCode4 = (hashCode3 * 59) + (displayDescription2 == null ? 43 : displayDescription2.hashCode());
        String displayIcon2 = getDisplayIcon();
        int hashCode5 = (hashCode4 * 59) + (displayIcon2 == null ? 43 : displayIcon2.hashCode());
        String displayIconNight2 = getDisplayIconNight();
        int hashCode6 = (hashCode5 * 59) + (displayIconNight2 == null ? 43 : displayIconNight2.hashCode());
        String jumpUrl2 = getJumpUrl();
        int hashCode7 = (hashCode6 * 59) + (jumpUrl2 == null ? 43 : jumpUrl2.hashCode());
        String displayJumpName2 = getDisplayJumpName();
        int hashCode8 = (hashCode7 * 59) + (displayJumpName2 == null ? 43 : displayJumpName2.hashCode());
        String upgradeDetailUrl2 = getUpgradeDetailUrl();
        int i12 = hashCode8 * 59;
        if (upgradeDetailUrl2 != null) {
            i11 = upgradeDetailUrl2.hashCode();
        }
        return ((i12 + i11) * 59) + getType();
    }

    public Boolean isNeedUpdate() {
        return Boolean.valueOf(this.type == 2);
    }

    public void setDisplayDescription(String str) {
        this.displayDescription = str;
    }

    public void setDisplayFirstName(String str) {
        this.displayFirstName = str;
    }

    public void setDisplayIcon(String str) {
        this.displayIcon = str;
    }

    public void setDisplayIconNight(String str) {
        this.displayIconNight = str;
    }

    public void setDisplayJumpName(String str) {
        this.displayJumpName = str;
    }

    public void setDisplaySecondName(String str) {
        this.displaySecondName = str;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setUpgradeDetailUrl(String str) {
        this.upgradeDetailUrl = str;
    }

    public void setUpgradeSymbol(String str) {
        this.upgradeSymbol = str;
    }

    public String toString() {
        return "HTUpgradeConfig(upgradeSymbol=" + getUpgradeSymbol() + ", displayFirstName=" + getDisplayFirstName() + ", displaySecondName=" + getDisplaySecondName() + ", displayDescription=" + getDisplayDescription() + ", displayIcon=" + getDisplayIcon() + ", displayIconNight=" + getDisplayIconNight() + ", jumpUrl=" + getJumpUrl() + ", displayJumpName=" + getDisplayJumpName() + ", upgradeDetailUrl=" + getUpgradeDetailUrl() + ", type=" + getType() + ")";
    }
}
