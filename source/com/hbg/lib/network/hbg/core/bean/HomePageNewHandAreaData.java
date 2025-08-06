package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class HomePageNewHandAreaData implements Serializable {
    public String benefitAmount;
    public String benefitJumpUrl;
    public String benefitText;
    public String benefitTitle;
    public long endTime;
    public String navigationDayImgUrl;
    public String navigationDefaultImgUrl;
    public String navigationJumpUrl;
    public String navigationNightImgUrl;
    public String newHandImgUrl;
    public List<NewHandAreaProjectInfo> projectList;
    public int showStatus;
    public String showType;
    public long startTime;

    public static class NewHandAreaProjectInfo implements Serializable {
        public String imgUrl;
        public String projectBenefitText;
        public String projectJumpUrl;
        public String projectSubTitle;
        public String projectTitle;
    }

    public String toString() {
        return "showStatus = " + this.showStatus + "showType = " + this.showType + "startTime = " + this.startTime + "endTime = " + this.endTime + "newHandImgUrl = " + this.newHandImgUrl + "benefitTitle = " + this.benefitTitle + "benefitText = " + this.benefitText + "benefitAmount = " + this.benefitAmount + "benefitJumpUrl = " + this.benefitJumpUrl + "navigationDefaultImgUrl = " + this.navigationDefaultImgUrl + "navigationDayImgUrl = " + this.navigationDayImgUrl + "navigationNightImgUrl = " + this.navigationNightImgUrl + "navigationJumpUrl = " + this.navigationJumpUrl;
    }
}
