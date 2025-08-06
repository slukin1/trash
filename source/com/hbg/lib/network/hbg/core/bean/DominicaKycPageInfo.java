package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class DominicaKycPageInfo implements Serializable {
    private BaseInfo baseInfo;
    private String cardApplyText;
    private String cardApplyUrl;
    private String desc;
    private String maxLevel;
    private String maxLevelDesc;
    private List<VerifyStatusInfo> stepStates;
    private String title;
    private long uid;

    public static class BaseInfo implements Serializable {
        private String birthDay;
        private String cardNumber;
        private String firstName;
        private String lastName;
        private String sexDesc;

        public boolean canEqual(Object obj) {
            return obj instanceof BaseInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BaseInfo)) {
                return false;
            }
            BaseInfo baseInfo = (BaseInfo) obj;
            if (!baseInfo.canEqual(this)) {
                return false;
            }
            String firstName2 = getFirstName();
            String firstName3 = baseInfo.getFirstName();
            if (firstName2 != null ? !firstName2.equals(firstName3) : firstName3 != null) {
                return false;
            }
            String lastName2 = getLastName();
            String lastName3 = baseInfo.getLastName();
            if (lastName2 != null ? !lastName2.equals(lastName3) : lastName3 != null) {
                return false;
            }
            String sexDesc2 = getSexDesc();
            String sexDesc3 = baseInfo.getSexDesc();
            if (sexDesc2 != null ? !sexDesc2.equals(sexDesc3) : sexDesc3 != null) {
                return false;
            }
            String cardNumber2 = getCardNumber();
            String cardNumber3 = baseInfo.getCardNumber();
            if (cardNumber2 != null ? !cardNumber2.equals(cardNumber3) : cardNumber3 != null) {
                return false;
            }
            String birthDay2 = getBirthDay();
            String birthDay3 = baseInfo.getBirthDay();
            return birthDay2 != null ? birthDay2.equals(birthDay3) : birthDay3 == null;
        }

        public String getBirthDay() {
            return this.birthDay;
        }

        public String getCardNumber() {
            return this.cardNumber;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getSexDesc() {
            return this.sexDesc;
        }

        public int hashCode() {
            String firstName2 = getFirstName();
            int i11 = 43;
            int hashCode = firstName2 == null ? 43 : firstName2.hashCode();
            String lastName2 = getLastName();
            int hashCode2 = ((hashCode + 59) * 59) + (lastName2 == null ? 43 : lastName2.hashCode());
            String sexDesc2 = getSexDesc();
            int hashCode3 = (hashCode2 * 59) + (sexDesc2 == null ? 43 : sexDesc2.hashCode());
            String cardNumber2 = getCardNumber();
            int hashCode4 = (hashCode3 * 59) + (cardNumber2 == null ? 43 : cardNumber2.hashCode());
            String birthDay2 = getBirthDay();
            int i12 = hashCode4 * 59;
            if (birthDay2 != null) {
                i11 = birthDay2.hashCode();
            }
            return i12 + i11;
        }

        public void setBirthDay(String str) {
            this.birthDay = str;
        }

        public void setCardNumber(String str) {
            this.cardNumber = str;
        }

        public void setFirstName(String str) {
            this.firstName = str;
        }

        public void setLastName(String str) {
            this.lastName = str;
        }

        public void setSexDesc(String str) {
            this.sexDesc = str;
        }

        public String toString() {
            return "DominicaKycPageInfo.BaseInfo(firstName=" + getFirstName() + ", lastName=" + getLastName() + ", sexDesc=" + getSexDesc() + ", cardNumber=" + getCardNumber() + ", birthDay=" + getBirthDay() + ")";
        }
    }

    public static class VerifyStatusInfo implements Serializable {
        public static final int VERIFY_ED = 2;
        public static final int VERIFY_ERROR = 3;
        public static final int VERIFY_FAILURE = 4;
        public static final int VERIFY_IN = 1;
        public static final int VERIFY_NOT = 0;
        private int authState;
        private String authStep;
        private int authStepValue;
        private String equityDesc;
        private List<TextConfigInfo> textConfig;

        public static class TextConfigInfo implements Serializable {
            private String title;
            private String value;

            public boolean canEqual(Object obj) {
                return obj instanceof TextConfigInfo;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof TextConfigInfo)) {
                    return false;
                }
                TextConfigInfo textConfigInfo = (TextConfigInfo) obj;
                if (!textConfigInfo.canEqual(this)) {
                    return false;
                }
                String title2 = getTitle();
                String title3 = textConfigInfo.getTitle();
                if (title2 != null ? !title2.equals(title3) : title3 != null) {
                    return false;
                }
                String value2 = getValue();
                String value3 = textConfigInfo.getValue();
                return value2 != null ? value2.equals(value3) : value3 == null;
            }

            public String getTitle() {
                return this.title;
            }

            public String getValue() {
                return this.value;
            }

            public int hashCode() {
                String title2 = getTitle();
                int i11 = 43;
                int hashCode = title2 == null ? 43 : title2.hashCode();
                String value2 = getValue();
                int i12 = (hashCode + 59) * 59;
                if (value2 != null) {
                    i11 = value2.hashCode();
                }
                return i12 + i11;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public void setValue(String str) {
                this.value = str;
            }

            public String toString() {
                return "DominicaKycPageInfo.VerifyStatusInfo.TextConfigInfo(title=" + getTitle() + ", value=" + getValue() + ")";
            }
        }

        public boolean canEqual(Object obj) {
            return obj instanceof VerifyStatusInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof VerifyStatusInfo)) {
                return false;
            }
            VerifyStatusInfo verifyStatusInfo = (VerifyStatusInfo) obj;
            if (!verifyStatusInfo.canEqual(this) || getAuthState() != verifyStatusInfo.getAuthState()) {
                return false;
            }
            String authStep2 = getAuthStep();
            String authStep3 = verifyStatusInfo.getAuthStep();
            if (authStep2 != null ? !authStep2.equals(authStep3) : authStep3 != null) {
                return false;
            }
            if (getAuthStepValue() != verifyStatusInfo.getAuthStepValue()) {
                return false;
            }
            String equityDesc2 = getEquityDesc();
            String equityDesc3 = verifyStatusInfo.getEquityDesc();
            if (equityDesc2 != null ? !equityDesc2.equals(equityDesc3) : equityDesc3 != null) {
                return false;
            }
            List<TextConfigInfo> textConfig2 = getTextConfig();
            List<TextConfigInfo> textConfig3 = verifyStatusInfo.getTextConfig();
            return textConfig2 != null ? textConfig2.equals(textConfig3) : textConfig3 == null;
        }

        public int getAuthState() {
            return this.authState;
        }

        public String getAuthStep() {
            return this.authStep;
        }

        public int getAuthStepValue() {
            return this.authStepValue;
        }

        public String getEquityDesc() {
            return this.equityDesc;
        }

        public List<TextConfigInfo> getTextConfig() {
            return this.textConfig;
        }

        public int hashCode() {
            String authStep2 = getAuthStep();
            int i11 = 43;
            int authState2 = ((((getAuthState() + 59) * 59) + (authStep2 == null ? 43 : authStep2.hashCode())) * 59) + getAuthStepValue();
            String equityDesc2 = getEquityDesc();
            int hashCode = (authState2 * 59) + (equityDesc2 == null ? 43 : equityDesc2.hashCode());
            List<TextConfigInfo> textConfig2 = getTextConfig();
            int i12 = hashCode * 59;
            if (textConfig2 != null) {
                i11 = textConfig2.hashCode();
            }
            return i12 + i11;
        }

        public void setAuthState(int i11) {
            this.authState = i11;
        }

        public void setAuthStep(String str) {
            this.authStep = str;
        }

        public void setAuthStepValue(int i11) {
            this.authStepValue = i11;
        }

        public void setEquityDesc(String str) {
            this.equityDesc = str;
        }

        public void setTextConfig(List<TextConfigInfo> list) {
            this.textConfig = list;
        }

        public String toString() {
            return "DominicaKycPageInfo.VerifyStatusInfo(authState=" + getAuthState() + ", authStep=" + getAuthStep() + ", authStepValue=" + getAuthStepValue() + ", equityDesc=" + getEquityDesc() + ", textConfig=" + getTextConfig() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof DominicaKycPageInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DominicaKycPageInfo)) {
            return false;
        }
        DominicaKycPageInfo dominicaKycPageInfo = (DominicaKycPageInfo) obj;
        if (!dominicaKycPageInfo.canEqual(this) || getUid() != dominicaKycPageInfo.getUid()) {
            return false;
        }
        String maxLevel2 = getMaxLevel();
        String maxLevel3 = dominicaKycPageInfo.getMaxLevel();
        if (maxLevel2 != null ? !maxLevel2.equals(maxLevel3) : maxLevel3 != null) {
            return false;
        }
        String maxLevelDesc2 = getMaxLevelDesc();
        String maxLevelDesc3 = dominicaKycPageInfo.getMaxLevelDesc();
        if (maxLevelDesc2 != null ? !maxLevelDesc2.equals(maxLevelDesc3) : maxLevelDesc3 != null) {
            return false;
        }
        BaseInfo baseInfo2 = getBaseInfo();
        BaseInfo baseInfo3 = dominicaKycPageInfo.getBaseInfo();
        if (baseInfo2 != null ? !baseInfo2.equals(baseInfo3) : baseInfo3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = dominicaKycPageInfo.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String desc2 = getDesc();
        String desc3 = dominicaKycPageInfo.getDesc();
        if (desc2 != null ? !desc2.equals(desc3) : desc3 != null) {
            return false;
        }
        String cardApplyText2 = getCardApplyText();
        String cardApplyText3 = dominicaKycPageInfo.getCardApplyText();
        if (cardApplyText2 != null ? !cardApplyText2.equals(cardApplyText3) : cardApplyText3 != null) {
            return false;
        }
        String cardApplyUrl2 = getCardApplyUrl();
        String cardApplyUrl3 = dominicaKycPageInfo.getCardApplyUrl();
        if (cardApplyUrl2 != null ? !cardApplyUrl2.equals(cardApplyUrl3) : cardApplyUrl3 != null) {
            return false;
        }
        List<VerifyStatusInfo> stepStates2 = getStepStates();
        List<VerifyStatusInfo> stepStates3 = dominicaKycPageInfo.getStepStates();
        return stepStates2 != null ? stepStates2.equals(stepStates3) : stepStates3 == null;
    }

    public BaseInfo getBaseInfo() {
        return this.baseInfo;
    }

    public String getCardApplyText() {
        return this.cardApplyText;
    }

    public String getCardApplyUrl() {
        return this.cardApplyUrl;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getMaxLevel() {
        return this.maxLevel;
    }

    public String getMaxLevelDesc() {
        return this.maxLevelDesc;
    }

    public List<VerifyStatusInfo> getStepStates() {
        return this.stepStates;
    }

    public String getTitle() {
        return this.title;
    }

    public long getUid() {
        return this.uid;
    }

    public int hashCode() {
        long uid2 = getUid();
        String maxLevel2 = getMaxLevel();
        int i11 = 43;
        int hashCode = ((((int) (uid2 ^ (uid2 >>> 32))) + 59) * 59) + (maxLevel2 == null ? 43 : maxLevel2.hashCode());
        String maxLevelDesc2 = getMaxLevelDesc();
        int hashCode2 = (hashCode * 59) + (maxLevelDesc2 == null ? 43 : maxLevelDesc2.hashCode());
        BaseInfo baseInfo2 = getBaseInfo();
        int hashCode3 = (hashCode2 * 59) + (baseInfo2 == null ? 43 : baseInfo2.hashCode());
        String title2 = getTitle();
        int hashCode4 = (hashCode3 * 59) + (title2 == null ? 43 : title2.hashCode());
        String desc2 = getDesc();
        int hashCode5 = (hashCode4 * 59) + (desc2 == null ? 43 : desc2.hashCode());
        String cardApplyText2 = getCardApplyText();
        int hashCode6 = (hashCode5 * 59) + (cardApplyText2 == null ? 43 : cardApplyText2.hashCode());
        String cardApplyUrl2 = getCardApplyUrl();
        int hashCode7 = (hashCode6 * 59) + (cardApplyUrl2 == null ? 43 : cardApplyUrl2.hashCode());
        List<VerifyStatusInfo> stepStates2 = getStepStates();
        int i12 = hashCode7 * 59;
        if (stepStates2 != null) {
            i11 = stepStates2.hashCode();
        }
        return i12 + i11;
    }

    public void setBaseInfo(BaseInfo baseInfo2) {
        this.baseInfo = baseInfo2;
    }

    public void setCardApplyText(String str) {
        this.cardApplyText = str;
    }

    public void setCardApplyUrl(String str) {
        this.cardApplyUrl = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setMaxLevel(String str) {
        this.maxLevel = str;
    }

    public void setMaxLevelDesc(String str) {
        this.maxLevelDesc = str;
    }

    public void setStepStates(List<VerifyStatusInfo> list) {
        this.stepStates = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUid(long j11) {
        this.uid = j11;
    }

    public String toString() {
        return "DominicaKycPageInfo(uid=" + getUid() + ", maxLevel=" + getMaxLevel() + ", maxLevelDesc=" + getMaxLevelDesc() + ", baseInfo=" + getBaseInfo() + ", title=" + getTitle() + ", desc=" + getDesc() + ", cardApplyText=" + getCardApplyText() + ", cardApplyUrl=" + getCardApplyUrl() + ", stepStates=" + getStepStates() + ")";
    }
}
