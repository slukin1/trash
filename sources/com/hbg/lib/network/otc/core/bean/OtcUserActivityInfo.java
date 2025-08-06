package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class OtcUserActivityInfo implements Serializable {
    private List<OtcUserActivityCoinInfo> altCoinDtos;
    private String buttonHint;
    private int dayMissionComplete;
    private int dayOpenGiftUsable;
    private List<OtcUserActivityCoinInfo> everyDayGifts;
    private String hint;
    private int onHighSectionOpenDay;
    private String secondHint;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcUserActivityInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcUserActivityInfo)) {
            return false;
        }
        OtcUserActivityInfo otcUserActivityInfo = (OtcUserActivityInfo) obj;
        if (!otcUserActivityInfo.canEqual(this) || getDayMissionComplete() != otcUserActivityInfo.getDayMissionComplete() || getDayOpenGiftUsable() != otcUserActivityInfo.getDayOpenGiftUsable() || getOnHighSectionOpenDay() != otcUserActivityInfo.getOnHighSectionOpenDay()) {
            return false;
        }
        String hint2 = getHint();
        String hint3 = otcUserActivityInfo.getHint();
        if (hint2 != null ? !hint2.equals(hint3) : hint3 != null) {
            return false;
        }
        String secondHint2 = getSecondHint();
        String secondHint3 = otcUserActivityInfo.getSecondHint();
        if (secondHint2 != null ? !secondHint2.equals(secondHint3) : secondHint3 != null) {
            return false;
        }
        String buttonHint2 = getButtonHint();
        String buttonHint3 = otcUserActivityInfo.getButtonHint();
        if (buttonHint2 != null ? !buttonHint2.equals(buttonHint3) : buttonHint3 != null) {
            return false;
        }
        List<OtcUserActivityCoinInfo> altCoinDtos2 = getAltCoinDtos();
        List<OtcUserActivityCoinInfo> altCoinDtos3 = otcUserActivityInfo.getAltCoinDtos();
        if (altCoinDtos2 != null ? !altCoinDtos2.equals(altCoinDtos3) : altCoinDtos3 != null) {
            return false;
        }
        List<OtcUserActivityCoinInfo> everyDayGifts2 = getEveryDayGifts();
        List<OtcUserActivityCoinInfo> everyDayGifts3 = otcUserActivityInfo.getEveryDayGifts();
        return everyDayGifts2 != null ? everyDayGifts2.equals(everyDayGifts3) : everyDayGifts3 == null;
    }

    public List<OtcUserActivityCoinInfo> getAltCoinDtos() {
        return this.altCoinDtos;
    }

    public String getButtonHint() {
        return this.buttonHint;
    }

    public int getDayMissionComplete() {
        return this.dayMissionComplete;
    }

    public int getDayOpenGiftUsable() {
        return this.dayOpenGiftUsable;
    }

    public List<OtcUserActivityCoinInfo> getEveryDayGifts() {
        return this.everyDayGifts;
    }

    public String getHint() {
        return this.hint;
    }

    public int getOnHighSectionOpenDay() {
        return this.onHighSectionOpenDay;
    }

    public String getSecondHint() {
        return this.secondHint;
    }

    public int hashCode() {
        int dayMissionComplete2 = ((((getDayMissionComplete() + 59) * 59) + getDayOpenGiftUsable()) * 59) + getOnHighSectionOpenDay();
        String hint2 = getHint();
        int i11 = 43;
        int hashCode = (dayMissionComplete2 * 59) + (hint2 == null ? 43 : hint2.hashCode());
        String secondHint2 = getSecondHint();
        int hashCode2 = (hashCode * 59) + (secondHint2 == null ? 43 : secondHint2.hashCode());
        String buttonHint2 = getButtonHint();
        int hashCode3 = (hashCode2 * 59) + (buttonHint2 == null ? 43 : buttonHint2.hashCode());
        List<OtcUserActivityCoinInfo> altCoinDtos2 = getAltCoinDtos();
        int hashCode4 = (hashCode3 * 59) + (altCoinDtos2 == null ? 43 : altCoinDtos2.hashCode());
        List<OtcUserActivityCoinInfo> everyDayGifts2 = getEveryDayGifts();
        int i12 = hashCode4 * 59;
        if (everyDayGifts2 != null) {
            i11 = everyDayGifts2.hashCode();
        }
        return i12 + i11;
    }

    public void setAltCoinDtos(List<OtcUserActivityCoinInfo> list) {
        this.altCoinDtos = list;
    }

    public void setButtonHint(String str) {
        this.buttonHint = str;
    }

    public void setDayMissionComplete(int i11) {
        this.dayMissionComplete = i11;
    }

    public void setDayOpenGiftUsable(int i11) {
        this.dayOpenGiftUsable = i11;
    }

    public void setEveryDayGifts(List<OtcUserActivityCoinInfo> list) {
        this.everyDayGifts = list;
    }

    public void setHint(String str) {
        this.hint = str;
    }

    public void setOnHighSectionOpenDay(int i11) {
        this.onHighSectionOpenDay = i11;
    }

    public void setSecondHint(String str) {
        this.secondHint = str;
    }

    public String toString() {
        return "OtcUserActivityInfo(dayMissionComplete=" + getDayMissionComplete() + ", dayOpenGiftUsable=" + getDayOpenGiftUsable() + ", onHighSectionOpenDay=" + getOnHighSectionOpenDay() + ", hint=" + getHint() + ", secondHint=" + getSecondHint() + ", buttonHint=" + getButtonHint() + ", altCoinDtos=" + getAltCoinDtos() + ", everyDayGifts=" + getEveryDayGifts() + ")";
    }
}
