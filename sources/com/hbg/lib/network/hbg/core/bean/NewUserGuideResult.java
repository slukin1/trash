package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class NewUserGuideResult implements Serializable {
    private int activityId;
    private int activityTime;
    private long curDate;
    private String deviceId;
    private long registryDate;
    private int rewardTime;
    private int stepId;
    private List<Step> steps;
    private BigDecimal totalReward;
    private String userId;

    public class Step implements Serializable {
        private int actionCode;
        private String desc;

        /* renamed from: id  reason: collision with root package name */
        private int f70261id;
        private int isDoubled;
        private BigDecimal multiple;
        private BigDecimal reward;
        private String targetPrice;
        private String url;

        public Step() {
        }

        public boolean canEqual(Object obj) {
            return obj instanceof Step;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Step)) {
                return false;
            }
            Step step = (Step) obj;
            if (!step.canEqual(this) || getId() != step.getId()) {
                return false;
            }
            String desc2 = getDesc();
            String desc3 = step.getDesc();
            if (desc2 != null ? !desc2.equals(desc3) : desc3 != null) {
                return false;
            }
            String url2 = getUrl();
            String url3 = step.getUrl();
            if (url2 != null ? !url2.equals(url3) : url3 != null) {
                return false;
            }
            if (getActionCode() != step.getActionCode()) {
                return false;
            }
            BigDecimal reward2 = getReward();
            BigDecimal reward3 = step.getReward();
            if (reward2 != null ? !reward2.equals(reward3) : reward3 != null) {
                return false;
            }
            if (getIsDoubled() != step.getIsDoubled()) {
                return false;
            }
            BigDecimal multiple2 = getMultiple();
            BigDecimal multiple3 = step.getMultiple();
            if (multiple2 != null ? !multiple2.equals(multiple3) : multiple3 != null) {
                return false;
            }
            String targetPrice2 = getTargetPrice();
            String targetPrice3 = step.getTargetPrice();
            return targetPrice2 != null ? targetPrice2.equals(targetPrice3) : targetPrice3 == null;
        }

        public int getActionCode() {
            return this.actionCode;
        }

        public String getDesc() {
            return this.desc;
        }

        public int getId() {
            return this.f70261id;
        }

        public int getIsDoubled() {
            return this.isDoubled;
        }

        public BigDecimal getMultiple() {
            return this.multiple;
        }

        public BigDecimal getReward() {
            return this.reward;
        }

        public String getTargetPrice() {
            return this.targetPrice;
        }

        public String getUrl() {
            return this.url;
        }

        public int hashCode() {
            String desc2 = getDesc();
            int i11 = 43;
            int id2 = ((getId() + 59) * 59) + (desc2 == null ? 43 : desc2.hashCode());
            String url2 = getUrl();
            int hashCode = (((id2 * 59) + (url2 == null ? 43 : url2.hashCode())) * 59) + getActionCode();
            BigDecimal reward2 = getReward();
            int hashCode2 = (((hashCode * 59) + (reward2 == null ? 43 : reward2.hashCode())) * 59) + getIsDoubled();
            BigDecimal multiple2 = getMultiple();
            int hashCode3 = (hashCode2 * 59) + (multiple2 == null ? 43 : multiple2.hashCode());
            String targetPrice2 = getTargetPrice();
            int i12 = hashCode3 * 59;
            if (targetPrice2 != null) {
                i11 = targetPrice2.hashCode();
            }
            return i12 + i11;
        }

        public void setActionCode(int i11) {
            this.actionCode = i11;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setId(int i11) {
            this.f70261id = i11;
        }

        public void setIsDoubled(int i11) {
            this.isDoubled = i11;
        }

        public void setMultiple(BigDecimal bigDecimal) {
            this.multiple = bigDecimal;
        }

        public void setReward(BigDecimal bigDecimal) {
            this.reward = bigDecimal;
        }

        public void setTargetPrice(String str) {
            this.targetPrice = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public String toString() {
            return "NewUserGuideResult.Step(id=" + getId() + ", desc=" + getDesc() + ", url=" + getUrl() + ", actionCode=" + getActionCode() + ", reward=" + getReward() + ", isDoubled=" + getIsDoubled() + ", multiple=" + getMultiple() + ", targetPrice=" + getTargetPrice() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof NewUserGuideResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NewUserGuideResult)) {
            return false;
        }
        NewUserGuideResult newUserGuideResult = (NewUserGuideResult) obj;
        if (!newUserGuideResult.canEqual(this)) {
            return false;
        }
        String deviceId2 = getDeviceId();
        String deviceId3 = newUserGuideResult.getDeviceId();
        if (deviceId2 != null ? !deviceId2.equals(deviceId3) : deviceId3 != null) {
            return false;
        }
        String userId2 = getUserId();
        String userId3 = newUserGuideResult.getUserId();
        if (userId2 != null ? !userId2.equals(userId3) : userId3 != null) {
            return false;
        }
        if (getStepId() != newUserGuideResult.getStepId() || getActivityId() != newUserGuideResult.getActivityId()) {
            return false;
        }
        BigDecimal totalReward2 = getTotalReward();
        BigDecimal totalReward3 = newUserGuideResult.getTotalReward();
        if (totalReward2 != null ? !totalReward2.equals(totalReward3) : totalReward3 != null) {
            return false;
        }
        if (getRegistryDate() != newUserGuideResult.getRegistryDate() || getCurDate() != newUserGuideResult.getCurDate() || getRewardTime() != newUserGuideResult.getRewardTime() || getActivityTime() != newUserGuideResult.getActivityTime()) {
            return false;
        }
        List<Step> steps2 = getSteps();
        List<Step> steps3 = newUserGuideResult.getSteps();
        return steps2 != null ? steps2.equals(steps3) : steps3 == null;
    }

    public int getActivityId() {
        return this.activityId;
    }

    public int getActivityTime() {
        return this.activityTime;
    }

    public long getCurDate() {
        return this.curDate;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public long getRegistryDate() {
        return this.registryDate;
    }

    public int getRewardTime() {
        return this.rewardTime;
    }

    public int getStepId() {
        return this.stepId;
    }

    public List<Step> getSteps() {
        return this.steps;
    }

    public BigDecimal getTotalReward() {
        return this.totalReward;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String deviceId2 = getDeviceId();
        int i11 = 43;
        int hashCode = deviceId2 == null ? 43 : deviceId2.hashCode();
        String userId2 = getUserId();
        int hashCode2 = ((((((hashCode + 59) * 59) + (userId2 == null ? 43 : userId2.hashCode())) * 59) + getStepId()) * 59) + getActivityId();
        BigDecimal totalReward2 = getTotalReward();
        int hashCode3 = (hashCode2 * 59) + (totalReward2 == null ? 43 : totalReward2.hashCode());
        long registryDate2 = getRegistryDate();
        int i12 = (hashCode3 * 59) + ((int) (registryDate2 ^ (registryDate2 >>> 32)));
        long curDate2 = getCurDate();
        int rewardTime2 = (((((i12 * 59) + ((int) (curDate2 ^ (curDate2 >>> 32)))) * 59) + getRewardTime()) * 59) + getActivityTime();
        List<Step> steps2 = getSteps();
        int i13 = rewardTime2 * 59;
        if (steps2 != null) {
            i11 = steps2.hashCode();
        }
        return i13 + i11;
    }

    public void setActivityId(int i11) {
        this.activityId = i11;
    }

    public void setActivityTime(int i11) {
        this.activityTime = i11;
    }

    public void setCurDate(long j11) {
        this.curDate = j11;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setRegistryDate(long j11) {
        this.registryDate = j11;
    }

    public void setRewardTime(int i11) {
        this.rewardTime = i11;
    }

    public void setStepId(int i11) {
        this.stepId = i11;
    }

    public void setSteps(List<Step> list) {
        this.steps = list;
    }

    public void setTotalReward(BigDecimal bigDecimal) {
        this.totalReward = bigDecimal;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "NewUserGuideResult(deviceId=" + getDeviceId() + ", userId=" + getUserId() + ", stepId=" + getStepId() + ", activityId=" + getActivityId() + ", totalReward=" + getTotalReward() + ", registryDate=" + getRegistryDate() + ", curDate=" + getCurDate() + ", rewardTime=" + getRewardTime() + ", activityTime=" + getActivityTime() + ", steps=" + getSteps() + ")";
    }
}
