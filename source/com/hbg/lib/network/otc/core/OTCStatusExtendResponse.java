package com.hbg.lib.network.otc.core;

import com.hbg.lib.network.retrofit.response.IResponse;
import java.io.Serializable;

public class OTCStatusExtendResponse<T> implements IResponse {
    private static final long serialVersionUID = -5465868120561652059L;
    private int code;
    private T data;
    private ExtendBean extend;
    private String message;

    public static class ExtendBean implements Serializable {
        public static final int DIALOG_TYPE_ACTION = 1;
        public static final int DIALOG_TYPE_ORDINARY = 0;
        public static final String KYC_STATUS_OF_T2_FAIL = "-999";
        public static final String KYC_STATUS_OF_T2_ING = "1";
        public static final String KYC_STATUS_OF_T2_MANUAL = "4";
        public static final String KYC_STATUS_OF_T2_PASS = "2";
        public static final String KYC_STATUS_OF_T2_REFUSE = "3";
        private boolean canPartakeDepositActivity;
        private String cancelText;
        private String content;
        private String continueText;
        private Integer continueTrade;
        private ExtraBean extra;
        private Boolean kycAuthorized;
        private Boolean kycForbidden;
        private Boolean kycIdExpired;
        private String kycStatusOfT2;
        private String link;
        private int orderCancelConsult;
        private String title;
        private String traceId;
        private int type;

        public boolean canEqual(Object obj) {
            return obj instanceof ExtendBean;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ExtendBean)) {
                return false;
            }
            ExtendBean extendBean = (ExtendBean) obj;
            if (!extendBean.canEqual(this)) {
                return false;
            }
            String title2 = getTitle();
            String title3 = extendBean.getTitle();
            if (title2 != null ? !title2.equals(title3) : title3 != null) {
                return false;
            }
            String content2 = getContent();
            String content3 = extendBean.getContent();
            if (content2 != null ? !content2.equals(content3) : content3 != null) {
                return false;
            }
            String continueText2 = getContinueText();
            String continueText3 = extendBean.getContinueText();
            if (continueText2 != null ? !continueText2.equals(continueText3) : continueText3 != null) {
                return false;
            }
            String cancelText2 = getCancelText();
            String cancelText3 = extendBean.getCancelText();
            if (cancelText2 != null ? !cancelText2.equals(cancelText3) : cancelText3 != null) {
                return false;
            }
            Integer continueTrade2 = getContinueTrade();
            Integer continueTrade3 = extendBean.getContinueTrade();
            if (continueTrade2 != null ? !continueTrade2.equals(continueTrade3) : continueTrade3 != null) {
                return false;
            }
            if (getType() != extendBean.getType()) {
                return false;
            }
            ExtraBean extra2 = getExtra();
            ExtraBean extra3 = extendBean.getExtra();
            if (extra2 != null ? !extra2.equals(extra3) : extra3 != null) {
                return false;
            }
            String kycStatusOfT22 = getKycStatusOfT2();
            String kycStatusOfT23 = extendBean.getKycStatusOfT2();
            if (kycStatusOfT22 != null ? !kycStatusOfT22.equals(kycStatusOfT23) : kycStatusOfT23 != null) {
                return false;
            }
            if (getOrderCancelConsult() != extendBean.getOrderCancelConsult()) {
                return false;
            }
            Boolean kycAuthorized2 = getKycAuthorized();
            Boolean kycAuthorized3 = extendBean.getKycAuthorized();
            if (kycAuthorized2 != null ? !kycAuthorized2.equals(kycAuthorized3) : kycAuthorized3 != null) {
                return false;
            }
            Boolean kycForbidden2 = getKycForbidden();
            Boolean kycForbidden3 = extendBean.getKycForbidden();
            if (kycForbidden2 != null ? !kycForbidden2.equals(kycForbidden3) : kycForbidden3 != null) {
                return false;
            }
            Boolean kycIdExpired2 = getKycIdExpired();
            Boolean kycIdExpired3 = extendBean.getKycIdExpired();
            if (kycIdExpired2 != null ? !kycIdExpired2.equals(kycIdExpired3) : kycIdExpired3 != null) {
                return false;
            }
            String link2 = getLink();
            String link3 = extendBean.getLink();
            if (link2 != null ? !link2.equals(link3) : link3 != null) {
                return false;
            }
            String traceId2 = getTraceId();
            String traceId3 = extendBean.getTraceId();
            if (traceId2 != null ? traceId2.equals(traceId3) : traceId3 == null) {
                return isCanPartakeDepositActivity() == extendBean.isCanPartakeDepositActivity();
            }
            return false;
        }

        public String getCancelText() {
            return this.cancelText;
        }

        public String getContent() {
            return this.content;
        }

        public String getContinueText() {
            return this.continueText;
        }

        public Integer getContinueTrade() {
            return this.continueTrade;
        }

        public ExtraBean getExtra() {
            return this.extra;
        }

        public Boolean getKycAuthorized() {
            return this.kycAuthorized;
        }

        public Boolean getKycForbidden() {
            return this.kycForbidden;
        }

        public Boolean getKycIdExpired() {
            return this.kycIdExpired;
        }

        public String getKycStatusOfT2() {
            return this.kycStatusOfT2;
        }

        public String getLink() {
            return this.link;
        }

        public int getOrderCancelConsult() {
            return this.orderCancelConsult;
        }

        public String getTitle() {
            return this.title;
        }

        public String getTraceId() {
            return this.traceId;
        }

        public int getType() {
            return this.type;
        }

        public int hashCode() {
            String title2 = getTitle();
            int i11 = 43;
            int hashCode = title2 == null ? 43 : title2.hashCode();
            String content2 = getContent();
            int hashCode2 = ((hashCode + 59) * 59) + (content2 == null ? 43 : content2.hashCode());
            String continueText2 = getContinueText();
            int hashCode3 = (hashCode2 * 59) + (continueText2 == null ? 43 : continueText2.hashCode());
            String cancelText2 = getCancelText();
            int hashCode4 = (hashCode3 * 59) + (cancelText2 == null ? 43 : cancelText2.hashCode());
            Integer continueTrade2 = getContinueTrade();
            int hashCode5 = (((hashCode4 * 59) + (continueTrade2 == null ? 43 : continueTrade2.hashCode())) * 59) + getType();
            ExtraBean extra2 = getExtra();
            int hashCode6 = (hashCode5 * 59) + (extra2 == null ? 43 : extra2.hashCode());
            String kycStatusOfT22 = getKycStatusOfT2();
            int hashCode7 = (((hashCode6 * 59) + (kycStatusOfT22 == null ? 43 : kycStatusOfT22.hashCode())) * 59) + getOrderCancelConsult();
            Boolean kycAuthorized2 = getKycAuthorized();
            int hashCode8 = (hashCode7 * 59) + (kycAuthorized2 == null ? 43 : kycAuthorized2.hashCode());
            Boolean kycForbidden2 = getKycForbidden();
            int hashCode9 = (hashCode8 * 59) + (kycForbidden2 == null ? 43 : kycForbidden2.hashCode());
            Boolean kycIdExpired2 = getKycIdExpired();
            int hashCode10 = (hashCode9 * 59) + (kycIdExpired2 == null ? 43 : kycIdExpired2.hashCode());
            String link2 = getLink();
            int hashCode11 = (hashCode10 * 59) + (link2 == null ? 43 : link2.hashCode());
            String traceId2 = getTraceId();
            int i12 = hashCode11 * 59;
            if (traceId2 != null) {
                i11 = traceId2.hashCode();
            }
            return ((i12 + i11) * 59) + (isCanPartakeDepositActivity() ? 79 : 97);
        }

        public boolean isCanPartakeDepositActivity() {
            return this.canPartakeDepositActivity;
        }

        public void setCanPartakeDepositActivity(boolean z11) {
            this.canPartakeDepositActivity = z11;
        }

        public void setCancelText(String str) {
            this.cancelText = str;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setContinueText(String str) {
            this.continueText = str;
        }

        public void setContinueTrade(Integer num) {
            this.continueTrade = num;
        }

        public void setExtra(ExtraBean extraBean) {
            this.extra = extraBean;
        }

        public void setKycAuthorized(Boolean bool) {
            this.kycAuthorized = bool;
        }

        public void setKycForbidden(Boolean bool) {
            this.kycForbidden = bool;
        }

        public void setKycIdExpired(Boolean bool) {
            this.kycIdExpired = bool;
        }

        public void setKycStatusOfT2(String str) {
            this.kycStatusOfT2 = str;
        }

        public void setLink(String str) {
            this.link = str;
        }

        public void setOrderCancelConsult(int i11) {
            this.orderCancelConsult = i11;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setTraceId(String str) {
            this.traceId = str;
        }

        public void setType(int i11) {
            this.type = i11;
        }

        public String toString() {
            return "OTCStatusExtendResponse.ExtendBean(title=" + getTitle() + ", content=" + getContent() + ", continueText=" + getContinueText() + ", cancelText=" + getCancelText() + ", continueTrade=" + getContinueTrade() + ", type=" + getType() + ", extra=" + getExtra() + ", kycStatusOfT2=" + getKycStatusOfT2() + ", orderCancelConsult=" + getOrderCancelConsult() + ", kycAuthorized=" + getKycAuthorized() + ", kycForbidden=" + getKycForbidden() + ", kycIdExpired=" + getKycIdExpired() + ", link=" + getLink() + ", traceId=" + getTraceId() + ", canPartakeDepositActivity=" + isCanPartakeDepositActivity() + ")";
        }
    }

    public static class ExtraBean implements Serializable {
        private String configWithdrawDays;
        private String jump;
        private boolean lastWithdrawDayAgo;
        private String toggleLimitDays;
        private String tradeLimitHours;
        private boolean userC2cLastToggleTime;
        private boolean userDisputedOrderCount;
        private boolean userHaveCoinOnCoinTrade;
        private boolean userHaveContractTrade;
        private boolean userHaveGlobalWithdraw;
        private boolean userMerchantLevel;
        private boolean userOtcLastTradeTime;
        private boolean userPendingOrderCount;
        private boolean userRegisterCountryId;

        public boolean canEqual(Object obj) {
            return obj instanceof ExtraBean;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ExtraBean)) {
                return false;
            }
            ExtraBean extraBean = (ExtraBean) obj;
            if (!extraBean.canEqual(this)) {
                return false;
            }
            String jump2 = getJump();
            String jump3 = extraBean.getJump();
            if (jump2 != null ? !jump2.equals(jump3) : jump3 != null) {
                return false;
            }
            if (isUserHaveCoinOnCoinTrade() != extraBean.isUserHaveCoinOnCoinTrade() || isUserPendingOrderCount() != extraBean.isUserPendingOrderCount() || isLastWithdrawDayAgo() != extraBean.isLastWithdrawDayAgo()) {
                return false;
            }
            String configWithdrawDays2 = getConfigWithdrawDays();
            String configWithdrawDays3 = extraBean.getConfigWithdrawDays();
            if (configWithdrawDays2 != null ? !configWithdrawDays2.equals(configWithdrawDays3) : configWithdrawDays3 != null) {
                return false;
            }
            if (isUserC2cLastToggleTime() != extraBean.isUserC2cLastToggleTime() || isUserRegisterCountryId() != extraBean.isUserRegisterCountryId() || isUserMerchantLevel() != extraBean.isUserMerchantLevel() || isUserOtcLastTradeTime() != extraBean.isUserOtcLastTradeTime() || isUserHaveContractTrade() != extraBean.isUserHaveContractTrade() || isUserDisputedOrderCount() != extraBean.isUserDisputedOrderCount() || isUserHaveGlobalWithdraw() != extraBean.isUserHaveGlobalWithdraw()) {
                return false;
            }
            String toggleLimitDays2 = getToggleLimitDays();
            String toggleLimitDays3 = extraBean.getToggleLimitDays();
            if (toggleLimitDays2 != null ? !toggleLimitDays2.equals(toggleLimitDays3) : toggleLimitDays3 != null) {
                return false;
            }
            String tradeLimitHours2 = getTradeLimitHours();
            String tradeLimitHours3 = extraBean.getTradeLimitHours();
            return tradeLimitHours2 != null ? tradeLimitHours2.equals(tradeLimitHours3) : tradeLimitHours3 == null;
        }

        public String getConfigWithdrawDays() {
            return this.configWithdrawDays;
        }

        public String getJump() {
            return this.jump;
        }

        public String getToggleLimitDays() {
            return this.toggleLimitDays;
        }

        public String getTradeLimitHours() {
            return this.tradeLimitHours;
        }

        public int hashCode() {
            String jump2 = getJump();
            int i11 = 43;
            int i12 = 79;
            int hashCode = (((((((jump2 == null ? 43 : jump2.hashCode()) + 59) * 59) + (isUserHaveCoinOnCoinTrade() ? 79 : 97)) * 59) + (isUserPendingOrderCount() ? 79 : 97)) * 59) + (isLastWithdrawDayAgo() ? 79 : 97);
            String configWithdrawDays2 = getConfigWithdrawDays();
            int hashCode2 = ((((((((((((((hashCode * 59) + (configWithdrawDays2 == null ? 43 : configWithdrawDays2.hashCode())) * 59) + (isUserC2cLastToggleTime() ? 79 : 97)) * 59) + (isUserRegisterCountryId() ? 79 : 97)) * 59) + (isUserMerchantLevel() ? 79 : 97)) * 59) + (isUserOtcLastTradeTime() ? 79 : 97)) * 59) + (isUserHaveContractTrade() ? 79 : 97)) * 59) + (isUserDisputedOrderCount() ? 79 : 97)) * 59;
            if (!isUserHaveGlobalWithdraw()) {
                i12 = 97;
            }
            String toggleLimitDays2 = getToggleLimitDays();
            int hashCode3 = ((hashCode2 + i12) * 59) + (toggleLimitDays2 == null ? 43 : toggleLimitDays2.hashCode());
            String tradeLimitHours2 = getTradeLimitHours();
            int i13 = hashCode3 * 59;
            if (tradeLimitHours2 != null) {
                i11 = tradeLimitHours2.hashCode();
            }
            return i13 + i11;
        }

        public boolean isLastWithdrawDayAgo() {
            return this.lastWithdrawDayAgo;
        }

        public boolean isUserC2cLastToggleTime() {
            return this.userC2cLastToggleTime;
        }

        public boolean isUserDisputedOrderCount() {
            return this.userDisputedOrderCount;
        }

        public boolean isUserHaveCoinOnCoinTrade() {
            return this.userHaveCoinOnCoinTrade;
        }

        public boolean isUserHaveContractTrade() {
            return this.userHaveContractTrade;
        }

        public boolean isUserHaveGlobalWithdraw() {
            return this.userHaveGlobalWithdraw;
        }

        public boolean isUserMerchantLevel() {
            return this.userMerchantLevel;
        }

        public boolean isUserOtcLastTradeTime() {
            return this.userOtcLastTradeTime;
        }

        public boolean isUserPendingOrderCount() {
            return this.userPendingOrderCount;
        }

        public boolean isUserRegisterCountryId() {
            return this.userRegisterCountryId;
        }

        public void setConfigWithdrawDays(String str) {
            this.configWithdrawDays = str;
        }

        public void setJump(String str) {
            this.jump = str;
        }

        public void setLastWithdrawDayAgo(boolean z11) {
            this.lastWithdrawDayAgo = z11;
        }

        public void setToggleLimitDays(String str) {
            this.toggleLimitDays = str;
        }

        public void setTradeLimitHours(String str) {
            this.tradeLimitHours = str;
        }

        public void setUserC2cLastToggleTime(boolean z11) {
            this.userC2cLastToggleTime = z11;
        }

        public void setUserDisputedOrderCount(boolean z11) {
            this.userDisputedOrderCount = z11;
        }

        public void setUserHaveCoinOnCoinTrade(boolean z11) {
            this.userHaveCoinOnCoinTrade = z11;
        }

        public void setUserHaveContractTrade(boolean z11) {
            this.userHaveContractTrade = z11;
        }

        public void setUserHaveGlobalWithdraw(boolean z11) {
            this.userHaveGlobalWithdraw = z11;
        }

        public void setUserMerchantLevel(boolean z11) {
            this.userMerchantLevel = z11;
        }

        public void setUserOtcLastTradeTime(boolean z11) {
            this.userOtcLastTradeTime = z11;
        }

        public void setUserPendingOrderCount(boolean z11) {
            this.userPendingOrderCount = z11;
        }

        public void setUserRegisterCountryId(boolean z11) {
            this.userRegisterCountryId = z11;
        }

        public String toString() {
            return "OTCStatusExtendResponse.ExtraBean(jump=" + getJump() + ", userHaveCoinOnCoinTrade=" + isUserHaveCoinOnCoinTrade() + ", userPendingOrderCount=" + isUserPendingOrderCount() + ", lastWithdrawDayAgo=" + isLastWithdrawDayAgo() + ", configWithdrawDays=" + getConfigWithdrawDays() + ", userC2cLastToggleTime=" + isUserC2cLastToggleTime() + ", userRegisterCountryId=" + isUserRegisterCountryId() + ", userMerchantLevel=" + isUserMerchantLevel() + ", userOtcLastTradeTime=" + isUserOtcLastTradeTime() + ", userHaveContractTrade=" + isUserHaveContractTrade() + ", userDisputedOrderCount=" + isUserDisputedOrderCount() + ", userHaveGlobalWithdraw=" + isUserHaveGlobalWithdraw() + ", toggleLimitDays=" + getToggleLimitDays() + ", tradeLimitHours=" + getTradeLimitHours() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OTCStatusExtendResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OTCStatusExtendResponse)) {
            return false;
        }
        OTCStatusExtendResponse oTCStatusExtendResponse = (OTCStatusExtendResponse) obj;
        if (!oTCStatusExtendResponse.canEqual(this) || getCode() != oTCStatusExtendResponse.getCode()) {
            return false;
        }
        String message2 = getMessage();
        String message3 = oTCStatusExtendResponse.getMessage();
        if (message2 != null ? !message2.equals(message3) : message3 != null) {
            return false;
        }
        Object data2 = getData();
        Object data3 = oTCStatusExtendResponse.getData();
        if (data2 != null ? !data2.equals(data3) : data3 != null) {
            return false;
        }
        ExtendBean extend2 = getExtend();
        ExtendBean extend3 = oTCStatusExtendResponse.getExtend();
        return extend2 != null ? extend2.equals(extend3) : extend3 == null;
    }

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getErrCode() {
        return String.valueOf(this.code);
    }

    public String getErrMsg() {
        return this.message;
    }

    public ExtendBean getExtend() {
        return this.extend;
    }

    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        String message2 = getMessage();
        int i11 = 43;
        int code2 = ((getCode() + 59) * 59) + (message2 == null ? 43 : message2.hashCode());
        Object data2 = getData();
        int hashCode = (code2 * 59) + (data2 == null ? 43 : data2.hashCode());
        ExtendBean extend2 = getExtend();
        int i12 = hashCode * 59;
        if (extend2 != null) {
            i11 = extend2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setData(T t11) {
        this.data = t11;
    }

    public void setExtend(ExtendBean extendBean) {
        this.extend = extendBean;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "OTCStatusExtendResponse(code=" + getCode() + ", message=" + getMessage() + ", data=" + getData() + ", extend=" + getExtend() + ")";
    }
}
