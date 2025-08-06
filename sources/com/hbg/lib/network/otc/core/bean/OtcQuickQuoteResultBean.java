package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class OtcQuickQuoteResultBean implements Serializable {
    public String businessCode;
    public List<OtcQuickQuoteDetail> detail;
    public List<String> payMethods;
    public List<Integer> tags;
    public List<Tip> tips;

    public static class OtcPayMethodCardInfo implements Serializable {
        public String accountNumber;
        public int cardId;
        public String cardName;
        public String cardNum;
        public int cardState;
        public boolean newCard;
        public String payMethodCode;

        public boolean canEqual(Object obj) {
            return obj instanceof OtcPayMethodCardInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OtcPayMethodCardInfo)) {
                return false;
            }
            OtcPayMethodCardInfo otcPayMethodCardInfo = (OtcPayMethodCardInfo) obj;
            if (!otcPayMethodCardInfo.canEqual(this) || getCardId() != otcPayMethodCardInfo.getCardId() || getCardState() != otcPayMethodCardInfo.getCardState()) {
                return false;
            }
            String payMethodCode2 = getPayMethodCode();
            String payMethodCode3 = otcPayMethodCardInfo.getPayMethodCode();
            if (payMethodCode2 != null ? !payMethodCode2.equals(payMethodCode3) : payMethodCode3 != null) {
                return false;
            }
            String accountNumber2 = getAccountNumber();
            String accountNumber3 = otcPayMethodCardInfo.getAccountNumber();
            if (accountNumber2 != null ? !accountNumber2.equals(accountNumber3) : accountNumber3 != null) {
                return false;
            }
            String cardNum2 = getCardNum();
            String cardNum3 = otcPayMethodCardInfo.getCardNum();
            if (cardNum2 != null ? !cardNum2.equals(cardNum3) : cardNum3 != null) {
                return false;
            }
            String cardName2 = getCardName();
            String cardName3 = otcPayMethodCardInfo.getCardName();
            if (cardName2 != null ? cardName2.equals(cardName3) : cardName3 == null) {
                return isNewCard() == otcPayMethodCardInfo.isNewCard();
            }
            return false;
        }

        public String getAccountNumber() {
            return this.accountNumber;
        }

        public int getCardId() {
            return this.cardId;
        }

        public String getCardName() {
            return this.cardName;
        }

        public String getCardNum() {
            return this.cardNum;
        }

        public int getCardState() {
            return this.cardState;
        }

        public String getPayMethodCode() {
            return this.payMethodCode;
        }

        public int hashCode() {
            int cardId2 = ((getCardId() + 59) * 59) + getCardState();
            String payMethodCode2 = getPayMethodCode();
            int i11 = 43;
            int hashCode = (cardId2 * 59) + (payMethodCode2 == null ? 43 : payMethodCode2.hashCode());
            String accountNumber2 = getAccountNumber();
            int hashCode2 = (hashCode * 59) + (accountNumber2 == null ? 43 : accountNumber2.hashCode());
            String cardNum2 = getCardNum();
            int hashCode3 = (hashCode2 * 59) + (cardNum2 == null ? 43 : cardNum2.hashCode());
            String cardName2 = getCardName();
            int i12 = hashCode3 * 59;
            if (cardName2 != null) {
                i11 = cardName2.hashCode();
            }
            return ((i12 + i11) * 59) + (isNewCard() ? 79 : 97);
        }

        public boolean isNewCard() {
            return this.newCard;
        }

        public void setAccountNumber(String str) {
            this.accountNumber = str;
        }

        public void setCardId(int i11) {
            this.cardId = i11;
        }

        public void setCardName(String str) {
            this.cardName = str;
        }

        public void setCardNum(String str) {
            this.cardNum = str;
        }

        public void setCardState(int i11) {
            this.cardState = i11;
        }

        public void setNewCard(boolean z11) {
            this.newCard = z11;
        }

        public void setPayMethodCode(String str) {
            this.payMethodCode = str;
        }

        public String toString() {
            return "OtcQuickQuoteResultBean.OtcPayMethodCardInfo(cardId=" + getCardId() + ", cardState=" + getCardState() + ", payMethodCode=" + getPayMethodCode() + ", accountNumber=" + getAccountNumber() + ", cardNum=" + getCardNum() + ", cardName=" + getCardName() + ", newCard=" + isNewCard() + ")";
        }
    }

    public static class OtcQuickQuoteDetail implements Serializable {
        public String amount;
        public int bizRuleCode;
        public String bizRuleMessage;
        public List<OtcPayMethodCardInfo> cardIds;
        public String catalog;
        public int expireTimeMs;
        public String feeAsset;
        public String feeRatio;
        public boolean isNeedPassword;
        public boolean isPriceLow;
        public String payMethodCode;
        public int payMethodId;
        public String price;
        public String quantity;
        public int sort;
        public String statement;
        public List<Integer> tags;
        public String token;
        public String totalFee;

        public boolean canEqual(Object obj) {
            return obj instanceof OtcQuickQuoteDetail;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OtcQuickQuoteDetail)) {
                return false;
            }
            OtcQuickQuoteDetail otcQuickQuoteDetail = (OtcQuickQuoteDetail) obj;
            if (!otcQuickQuoteDetail.canEqual(this)) {
                return false;
            }
            String token2 = getToken();
            String token3 = otcQuickQuoteDetail.getToken();
            if (token2 != null ? !token2.equals(token3) : token3 != null) {
                return false;
            }
            String price2 = getPrice();
            String price3 = otcQuickQuoteDetail.getPrice();
            if (price2 != null ? !price2.equals(price3) : price3 != null) {
                return false;
            }
            String quantity2 = getQuantity();
            String quantity3 = otcQuickQuoteDetail.getQuantity();
            if (quantity2 != null ? !quantity2.equals(quantity3) : quantity3 != null) {
                return false;
            }
            String amount2 = getAmount();
            String amount3 = otcQuickQuoteDetail.getAmount();
            if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
                return false;
            }
            String feeRatio2 = getFeeRatio();
            String feeRatio3 = otcQuickQuoteDetail.getFeeRatio();
            if (feeRatio2 != null ? !feeRatio2.equals(feeRatio3) : feeRatio3 != null) {
                return false;
            }
            String totalFee2 = getTotalFee();
            String totalFee3 = otcQuickQuoteDetail.getTotalFee();
            if (totalFee2 != null ? !totalFee2.equals(totalFee3) : totalFee3 != null) {
                return false;
            }
            String feeAsset2 = getFeeAsset();
            String feeAsset3 = otcQuickQuoteDetail.getFeeAsset();
            if (feeAsset2 != null ? !feeAsset2.equals(feeAsset3) : feeAsset3 != null) {
                return false;
            }
            String payMethodCode2 = getPayMethodCode();
            String payMethodCode3 = otcQuickQuoteDetail.getPayMethodCode();
            if (payMethodCode2 != null ? !payMethodCode2.equals(payMethodCode3) : payMethodCode3 != null) {
                return false;
            }
            if (getPayMethodId() != otcQuickQuoteDetail.getPayMethodId() || getExpireTimeMs() != otcQuickQuoteDetail.getExpireTimeMs()) {
                return false;
            }
            List<Integer> tags2 = getTags();
            List<Integer> tags3 = otcQuickQuoteDetail.getTags();
            if (tags2 != null ? !tags2.equals(tags3) : tags3 != null) {
                return false;
            }
            if (isNeedPassword() != otcQuickQuoteDetail.isNeedPassword()) {
                return false;
            }
            String catalog2 = getCatalog();
            String catalog3 = otcQuickQuoteDetail.getCatalog();
            if (catalog2 != null ? !catalog2.equals(catalog3) : catalog3 != null) {
                return false;
            }
            List<OtcPayMethodCardInfo> cardIds2 = getCardIds();
            List<OtcPayMethodCardInfo> cardIds3 = otcQuickQuoteDetail.getCardIds();
            if (cardIds2 != null ? !cardIds2.equals(cardIds3) : cardIds3 != null) {
                return false;
            }
            if (isPriceLow() != otcQuickQuoteDetail.isPriceLow() || getBizRuleCode() != otcQuickQuoteDetail.getBizRuleCode()) {
                return false;
            }
            String bizRuleMessage2 = getBizRuleMessage();
            String bizRuleMessage3 = otcQuickQuoteDetail.getBizRuleMessage();
            if (bizRuleMessage2 != null ? !bizRuleMessage2.equals(bizRuleMessage3) : bizRuleMessage3 != null) {
                return false;
            }
            if (getSort() != otcQuickQuoteDetail.getSort()) {
                return false;
            }
            String statement2 = getStatement();
            String statement3 = otcQuickQuoteDetail.getStatement();
            return statement2 != null ? statement2.equals(statement3) : statement3 == null;
        }

        public String getAmount() {
            return this.amount;
        }

        public int getBizRuleCode() {
            return this.bizRuleCode;
        }

        public String getBizRuleMessage() {
            return this.bizRuleMessage;
        }

        public List<OtcPayMethodCardInfo> getCardIds() {
            return this.cardIds;
        }

        public String getCatalog() {
            return this.catalog;
        }

        public int getExpireTimeMs() {
            return this.expireTimeMs;
        }

        public String getFeeAsset() {
            return this.feeAsset;
        }

        public String getFeeRatio() {
            return this.feeRatio;
        }

        public String getPayMethodCode() {
            return this.payMethodCode;
        }

        public int getPayMethodId() {
            return this.payMethodId;
        }

        public String getPrice() {
            return this.price;
        }

        public String getQuantity() {
            return this.quantity;
        }

        public int getSort() {
            return this.sort;
        }

        public String getStatement() {
            return this.statement;
        }

        public List<Integer> getTags() {
            return this.tags;
        }

        public String getToken() {
            return this.token;
        }

        public String getTotalFee() {
            return this.totalFee;
        }

        public int hashCode() {
            String token2 = getToken();
            int i11 = 43;
            int hashCode = token2 == null ? 43 : token2.hashCode();
            String price2 = getPrice();
            int hashCode2 = ((hashCode + 59) * 59) + (price2 == null ? 43 : price2.hashCode());
            String quantity2 = getQuantity();
            int hashCode3 = (hashCode2 * 59) + (quantity2 == null ? 43 : quantity2.hashCode());
            String amount2 = getAmount();
            int hashCode4 = (hashCode3 * 59) + (amount2 == null ? 43 : amount2.hashCode());
            String feeRatio2 = getFeeRatio();
            int hashCode5 = (hashCode4 * 59) + (feeRatio2 == null ? 43 : feeRatio2.hashCode());
            String totalFee2 = getTotalFee();
            int hashCode6 = (hashCode5 * 59) + (totalFee2 == null ? 43 : totalFee2.hashCode());
            String feeAsset2 = getFeeAsset();
            int hashCode7 = (hashCode6 * 59) + (feeAsset2 == null ? 43 : feeAsset2.hashCode());
            String payMethodCode2 = getPayMethodCode();
            int hashCode8 = (((((hashCode7 * 59) + (payMethodCode2 == null ? 43 : payMethodCode2.hashCode())) * 59) + getPayMethodId()) * 59) + getExpireTimeMs();
            List<Integer> tags2 = getTags();
            int i12 = 79;
            int hashCode9 = (((hashCode8 * 59) + (tags2 == null ? 43 : tags2.hashCode())) * 59) + (isNeedPassword() ? 79 : 97);
            String catalog2 = getCatalog();
            int hashCode10 = (hashCode9 * 59) + (catalog2 == null ? 43 : catalog2.hashCode());
            List<OtcPayMethodCardInfo> cardIds2 = getCardIds();
            int hashCode11 = ((hashCode10 * 59) + (cardIds2 == null ? 43 : cardIds2.hashCode())) * 59;
            if (!isPriceLow()) {
                i12 = 97;
            }
            int bizRuleCode2 = ((hashCode11 + i12) * 59) + getBizRuleCode();
            String bizRuleMessage2 = getBizRuleMessage();
            int hashCode12 = (((bizRuleCode2 * 59) + (bizRuleMessage2 == null ? 43 : bizRuleMessage2.hashCode())) * 59) + getSort();
            String statement2 = getStatement();
            int i13 = hashCode12 * 59;
            if (statement2 != null) {
                i11 = statement2.hashCode();
            }
            return i13 + i11;
        }

        public boolean isNeedPassword() {
            return this.isNeedPassword;
        }

        public boolean isPriceLow() {
            return this.isPriceLow;
        }

        public void setAmount(String str) {
            this.amount = str;
        }

        public void setBizRuleCode(int i11) {
            this.bizRuleCode = i11;
        }

        public void setBizRuleMessage(String str) {
            this.bizRuleMessage = str;
        }

        public void setCardIds(List<OtcPayMethodCardInfo> list) {
            this.cardIds = list;
        }

        public void setCatalog(String str) {
            this.catalog = str;
        }

        public void setExpireTimeMs(int i11) {
            this.expireTimeMs = i11;
        }

        public void setFeeAsset(String str) {
            this.feeAsset = str;
        }

        public void setFeeRatio(String str) {
            this.feeRatio = str;
        }

        public void setNeedPassword(boolean z11) {
            this.isNeedPassword = z11;
        }

        public void setPayMethodCode(String str) {
            this.payMethodCode = str;
        }

        public void setPayMethodId(int i11) {
            this.payMethodId = i11;
        }

        public void setPrice(String str) {
            this.price = str;
        }

        public void setPriceLow(boolean z11) {
            this.isPriceLow = z11;
        }

        public void setQuantity(String str) {
            this.quantity = str;
        }

        public void setSort(int i11) {
            this.sort = i11;
        }

        public void setStatement(String str) {
            this.statement = str;
        }

        public void setTags(List<Integer> list) {
            this.tags = list;
        }

        public void setToken(String str) {
            this.token = str;
        }

        public void setTotalFee(String str) {
            this.totalFee = str;
        }

        public String toString() {
            return "OtcQuickQuoteResultBean.OtcQuickQuoteDetail(token=" + getToken() + ", price=" + getPrice() + ", quantity=" + getQuantity() + ", amount=" + getAmount() + ", feeRatio=" + getFeeRatio() + ", totalFee=" + getTotalFee() + ", feeAsset=" + getFeeAsset() + ", payMethodCode=" + getPayMethodCode() + ", payMethodId=" + getPayMethodId() + ", expireTimeMs=" + getExpireTimeMs() + ", tags=" + getTags() + ", isNeedPassword=" + isNeedPassword() + ", catalog=" + getCatalog() + ", cardIds=" + getCardIds() + ", isPriceLow=" + isPriceLow() + ", bizRuleCode=" + getBizRuleCode() + ", bizRuleMessage=" + getBizRuleMessage() + ", sort=" + getSort() + ", statement=" + getStatement() + ")";
        }
    }

    public static class Tip implements Serializable {
        public int type;
        public List<Variable> variable;

        public boolean canEqual(Object obj) {
            return obj instanceof Tip;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Tip)) {
                return false;
            }
            Tip tip = (Tip) obj;
            if (!tip.canEqual(this) || getType() != tip.getType()) {
                return false;
            }
            List<Variable> variable2 = getVariable();
            List<Variable> variable3 = tip.getVariable();
            return variable2 != null ? variable2.equals(variable3) : variable3 == null;
        }

        public int getType() {
            return this.type;
        }

        public List<Variable> getVariable() {
            return this.variable;
        }

        public int hashCode() {
            List<Variable> variable2 = getVariable();
            return ((getType() + 59) * 59) + (variable2 == null ? 43 : variable2.hashCode());
        }

        public void setType(int i11) {
            this.type = i11;
        }

        public void setVariable(List<Variable> list) {
            this.variable = list;
        }

        public String toString() {
            return "OtcQuickQuoteResultBean.Tip(type=" + getType() + ", variable=" + getVariable() + ")";
        }
    }

    public static class Variable implements Serializable {
        public String amount;

        public boolean canEqual(Object obj) {
            return obj instanceof Variable;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Variable)) {
                return false;
            }
            Variable variable = (Variable) obj;
            if (!variable.canEqual(this)) {
                return false;
            }
            String amount2 = getAmount();
            String amount3 = variable.getAmount();
            return amount2 != null ? amount2.equals(amount3) : amount3 == null;
        }

        public String getAmount() {
            return this.amount;
        }

        public int hashCode() {
            String amount2 = getAmount();
            return 59 + (amount2 == null ? 43 : amount2.hashCode());
        }

        public void setAmount(String str) {
            this.amount = str;
        }

        public String toString() {
            return "OtcQuickQuoteResultBean.Variable(amount=" + getAmount() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcQuickQuoteResultBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcQuickQuoteResultBean)) {
            return false;
        }
        OtcQuickQuoteResultBean otcQuickQuoteResultBean = (OtcQuickQuoteResultBean) obj;
        if (!otcQuickQuoteResultBean.canEqual(this)) {
            return false;
        }
        String businessCode2 = getBusinessCode();
        String businessCode3 = otcQuickQuoteResultBean.getBusinessCode();
        if (businessCode2 != null ? !businessCode2.equals(businessCode3) : businessCode3 != null) {
            return false;
        }
        List<Integer> tags2 = getTags();
        List<Integer> tags3 = otcQuickQuoteResultBean.getTags();
        if (tags2 != null ? !tags2.equals(tags3) : tags3 != null) {
            return false;
        }
        List<Tip> tips2 = getTips();
        List<Tip> tips3 = otcQuickQuoteResultBean.getTips();
        if (tips2 != null ? !tips2.equals(tips3) : tips3 != null) {
            return false;
        }
        List<String> payMethods2 = getPayMethods();
        List<String> payMethods3 = otcQuickQuoteResultBean.getPayMethods();
        if (payMethods2 != null ? !payMethods2.equals(payMethods3) : payMethods3 != null) {
            return false;
        }
        List<OtcQuickQuoteDetail> detail2 = getDetail();
        List<OtcQuickQuoteDetail> detail3 = otcQuickQuoteResultBean.getDetail();
        return detail2 != null ? detail2.equals(detail3) : detail3 == null;
    }

    public String getBusinessCode() {
        return this.businessCode;
    }

    public List<OtcQuickQuoteDetail> getDetail() {
        return this.detail;
    }

    public List<String> getPayMethods() {
        return this.payMethods;
    }

    public List<Integer> getTags() {
        return this.tags;
    }

    public List<Tip> getTips() {
        return this.tips;
    }

    public int hashCode() {
        String businessCode2 = getBusinessCode();
        int i11 = 43;
        int hashCode = businessCode2 == null ? 43 : businessCode2.hashCode();
        List<Integer> tags2 = getTags();
        int hashCode2 = ((hashCode + 59) * 59) + (tags2 == null ? 43 : tags2.hashCode());
        List<Tip> tips2 = getTips();
        int hashCode3 = (hashCode2 * 59) + (tips2 == null ? 43 : tips2.hashCode());
        List<String> payMethods2 = getPayMethods();
        int hashCode4 = (hashCode3 * 59) + (payMethods2 == null ? 43 : payMethods2.hashCode());
        List<OtcQuickQuoteDetail> detail2 = getDetail();
        int i12 = hashCode4 * 59;
        if (detail2 != null) {
            i11 = detail2.hashCode();
        }
        return i12 + i11;
    }

    public void setBusinessCode(String str) {
        this.businessCode = str;
    }

    public void setDetail(List<OtcQuickQuoteDetail> list) {
        this.detail = list;
    }

    public void setPayMethods(List<String> list) {
        this.payMethods = list;
    }

    public void setTags(List<Integer> list) {
        this.tags = list;
    }

    public void setTips(List<Tip> list) {
        this.tips = list;
    }

    public String toString() {
        return "OtcQuickQuoteResultBean(businessCode=" + getBusinessCode() + ", tags=" + getTags() + ", tips=" + getTips() + ", payMethods=" + getPayMethods() + ", detail=" + getDetail() + ")";
    }
}
