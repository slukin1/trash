package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class CardOrderPayResultBean implements Serializable {
    private String liquidity;
    private String message;
    private int orderStatus;
    private String runMode;
    private String tittle;
    private String tradeMode;
    private Boolean verify;
    private VerifyExtend verifyExtend;
    private int verifyType;

    public static class Parameters implements Serializable {
        private String name;
        private String value;

        public boolean canEqual(Object obj) {
            return obj instanceof Parameters;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Parameters)) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            if (!parameters.canEqual(this)) {
                return false;
            }
            String name2 = getName();
            String name3 = parameters.getName();
            if (name2 != null ? !name2.equals(name3) : name3 != null) {
                return false;
            }
            String value2 = getValue();
            String value3 = parameters.getValue();
            return value2 != null ? value2.equals(value3) : value3 == null;
        }

        public String getName() {
            return this.name;
        }

        public String getValue() {
            return this.value;
        }

        public int hashCode() {
            String name2 = getName();
            int i11 = 43;
            int hashCode = name2 == null ? 43 : name2.hashCode();
            String value2 = getValue();
            int i12 = (hashCode + 59) * 59;
            if (value2 != null) {
                i11 = value2.hashCode();
            }
            return i12 + i11;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setValue(String str) {
            this.value = str;
        }

        public String toString() {
            return "CardOrderPayResultBean.Parameters(name=" + getName() + ", value=" + getValue() + ")";
        }
    }

    public static class PostParameterBean implements Serializable {
        private String postForm;
        private String postUrl;

        public boolean canEqual(Object obj) {
            return obj instanceof PostParameterBean;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PostParameterBean)) {
                return false;
            }
            PostParameterBean postParameterBean = (PostParameterBean) obj;
            if (!postParameterBean.canEqual(this)) {
                return false;
            }
            String postUrl2 = getPostUrl();
            String postUrl3 = postParameterBean.getPostUrl();
            if (postUrl2 != null ? !postUrl2.equals(postUrl3) : postUrl3 != null) {
                return false;
            }
            String postForm2 = getPostForm();
            String postForm3 = postParameterBean.getPostForm();
            return postForm2 != null ? postForm2.equals(postForm3) : postForm3 == null;
        }

        public String getPostForm() {
            return this.postForm;
        }

        public String getPostUrl() {
            return this.postUrl;
        }

        public int hashCode() {
            String postUrl2 = getPostUrl();
            int i11 = 43;
            int hashCode = postUrl2 == null ? 43 : postUrl2.hashCode();
            String postForm2 = getPostForm();
            int i12 = (hashCode + 59) * 59;
            if (postForm2 != null) {
                i11 = postForm2.hashCode();
            }
            return i12 + i11;
        }

        public void setPostForm(String str) {
            this.postForm = str;
        }

        public void setPostUrl(String str) {
            this.postUrl = str;
        }

        public String toString() {
            return "CardOrderPayResultBean.PostParameterBean(postUrl=" + getPostUrl() + ", postForm=" + getPostForm() + ")";
        }
    }

    public static class Preconditions implements Serializable {
        private String method;
        private List<Parameters> parameters;
        private String url;

        public boolean canEqual(Object obj) {
            return obj instanceof Preconditions;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Preconditions)) {
                return false;
            }
            Preconditions preconditions = (Preconditions) obj;
            if (!preconditions.canEqual(this)) {
                return false;
            }
            String method2 = getMethod();
            String method3 = preconditions.getMethod();
            if (method2 != null ? !method2.equals(method3) : method3 != null) {
                return false;
            }
            List<Parameters> parameters2 = getParameters();
            List<Parameters> parameters3 = preconditions.getParameters();
            if (parameters2 != null ? !parameters2.equals(parameters3) : parameters3 != null) {
                return false;
            }
            String url2 = getUrl();
            String url3 = preconditions.getUrl();
            return url2 != null ? url2.equals(url3) : url3 == null;
        }

        public String getMethod() {
            return this.method;
        }

        public List<Parameters> getParameters() {
            return this.parameters;
        }

        public String getUrl() {
            return this.url;
        }

        public int hashCode() {
            String method2 = getMethod();
            int i11 = 43;
            int hashCode = method2 == null ? 43 : method2.hashCode();
            List<Parameters> parameters2 = getParameters();
            int hashCode2 = ((hashCode + 59) * 59) + (parameters2 == null ? 43 : parameters2.hashCode());
            String url2 = getUrl();
            int i12 = hashCode2 * 59;
            if (url2 != null) {
                i11 = url2.hashCode();
            }
            return i12 + i11;
        }

        public void setMethod(String str) {
            this.method = str;
        }

        public void setParameters(List<Parameters> list) {
            this.parameters = list;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public String toString() {
            return "CardOrderPayResultBean.Preconditions(method=" + getMethod() + ", parameters=" + getParameters() + ", url=" + getUrl() + ")";
        }
    }

    public static class VerifyExtend implements Serializable {
        private String externalId;
        private String parameters;
        private String preconditions;
        private String verifyUrl;

        public boolean canEqual(Object obj) {
            return obj instanceof VerifyExtend;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof VerifyExtend)) {
                return false;
            }
            VerifyExtend verifyExtend = (VerifyExtend) obj;
            if (!verifyExtend.canEqual(this)) {
                return false;
            }
            String verifyUrl2 = getVerifyUrl();
            String verifyUrl3 = verifyExtend.getVerifyUrl();
            if (verifyUrl2 != null ? !verifyUrl2.equals(verifyUrl3) : verifyUrl3 != null) {
                return false;
            }
            String externalId2 = getExternalId();
            String externalId3 = verifyExtend.getExternalId();
            if (externalId2 != null ? !externalId2.equals(externalId3) : externalId3 != null) {
                return false;
            }
            String preconditions2 = getPreconditions();
            String preconditions3 = verifyExtend.getPreconditions();
            if (preconditions2 != null ? !preconditions2.equals(preconditions3) : preconditions3 != null) {
                return false;
            }
            String parameters2 = getParameters();
            String parameters3 = verifyExtend.getParameters();
            return parameters2 != null ? parameters2.equals(parameters3) : parameters3 == null;
        }

        public String getExternalId() {
            return this.externalId;
        }

        public String getParameters() {
            return this.parameters;
        }

        public String getPreconditions() {
            return this.preconditions;
        }

        public String getVerifyUrl() {
            return this.verifyUrl;
        }

        public int hashCode() {
            String verifyUrl2 = getVerifyUrl();
            int i11 = 43;
            int hashCode = verifyUrl2 == null ? 43 : verifyUrl2.hashCode();
            String externalId2 = getExternalId();
            int hashCode2 = ((hashCode + 59) * 59) + (externalId2 == null ? 43 : externalId2.hashCode());
            String preconditions2 = getPreconditions();
            int hashCode3 = (hashCode2 * 59) + (preconditions2 == null ? 43 : preconditions2.hashCode());
            String parameters2 = getParameters();
            int i12 = hashCode3 * 59;
            if (parameters2 != null) {
                i11 = parameters2.hashCode();
            }
            return i12 + i11;
        }

        public void setExternalId(String str) {
            this.externalId = str;
        }

        public void setParameters(String str) {
            this.parameters = str;
        }

        public void setPreconditions(String str) {
            this.preconditions = str;
        }

        public void setVerifyUrl(String str) {
            this.verifyUrl = str;
        }

        public String toString() {
            return "CardOrderPayResultBean.VerifyExtend(verifyUrl=" + getVerifyUrl() + ", externalId=" + getExternalId() + ", preconditions=" + getPreconditions() + ", parameters=" + getParameters() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof CardOrderPayResultBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CardOrderPayResultBean)) {
            return false;
        }
        CardOrderPayResultBean cardOrderPayResultBean = (CardOrderPayResultBean) obj;
        if (!cardOrderPayResultBean.canEqual(this) || getOrderStatus() != cardOrderPayResultBean.getOrderStatus()) {
            return false;
        }
        String message2 = getMessage();
        String message3 = cardOrderPayResultBean.getMessage();
        if (message2 != null ? !message2.equals(message3) : message3 != null) {
            return false;
        }
        Boolean verify2 = getVerify();
        Boolean verify3 = cardOrderPayResultBean.getVerify();
        if (verify2 != null ? !verify2.equals(verify3) : verify3 != null) {
            return false;
        }
        if (getVerifyType() != cardOrderPayResultBean.getVerifyType()) {
            return false;
        }
        VerifyExtend verifyExtend2 = getVerifyExtend();
        VerifyExtend verifyExtend3 = cardOrderPayResultBean.getVerifyExtend();
        if (verifyExtend2 != null ? !verifyExtend2.equals(verifyExtend3) : verifyExtend3 != null) {
            return false;
        }
        String tradeMode2 = getTradeMode();
        String tradeMode3 = cardOrderPayResultBean.getTradeMode();
        if (tradeMode2 != null ? !tradeMode2.equals(tradeMode3) : tradeMode3 != null) {
            return false;
        }
        String runMode2 = getRunMode();
        String runMode3 = cardOrderPayResultBean.getRunMode();
        if (runMode2 != null ? !runMode2.equals(runMode3) : runMode3 != null) {
            return false;
        }
        String tittle2 = getTittle();
        String tittle3 = cardOrderPayResultBean.getTittle();
        if (tittle2 != null ? !tittle2.equals(tittle3) : tittle3 != null) {
            return false;
        }
        String liquidity2 = getLiquidity();
        String liquidity3 = cardOrderPayResultBean.getLiquidity();
        return liquidity2 != null ? liquidity2.equals(liquidity3) : liquidity3 == null;
    }

    public String getLiquidity() {
        return this.liquidity;
    }

    public String getMessage() {
        return this.message;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public String getRunMode() {
        return this.runMode;
    }

    public String getTittle() {
        return this.tittle;
    }

    public String getTradeMode() {
        return this.tradeMode;
    }

    public Boolean getVerify() {
        return this.verify;
    }

    public VerifyExtend getVerifyExtend() {
        return this.verifyExtend;
    }

    public int getVerifyType() {
        return this.verifyType;
    }

    public int hashCode() {
        String message2 = getMessage();
        int i11 = 43;
        int orderStatus2 = ((getOrderStatus() + 59) * 59) + (message2 == null ? 43 : message2.hashCode());
        Boolean verify2 = getVerify();
        int hashCode = (((orderStatus2 * 59) + (verify2 == null ? 43 : verify2.hashCode())) * 59) + getVerifyType();
        VerifyExtend verifyExtend2 = getVerifyExtend();
        int hashCode2 = (hashCode * 59) + (verifyExtend2 == null ? 43 : verifyExtend2.hashCode());
        String tradeMode2 = getTradeMode();
        int hashCode3 = (hashCode2 * 59) + (tradeMode2 == null ? 43 : tradeMode2.hashCode());
        String runMode2 = getRunMode();
        int hashCode4 = (hashCode3 * 59) + (runMode2 == null ? 43 : runMode2.hashCode());
        String tittle2 = getTittle();
        int hashCode5 = (hashCode4 * 59) + (tittle2 == null ? 43 : tittle2.hashCode());
        String liquidity2 = getLiquidity();
        int i12 = hashCode5 * 59;
        if (liquidity2 != null) {
            i11 = liquidity2.hashCode();
        }
        return i12 + i11;
    }

    public void setLiquidity(String str) {
        this.liquidity = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setOrderStatus(int i11) {
        this.orderStatus = i11;
    }

    public void setRunMode(String str) {
        this.runMode = str;
    }

    public void setTittle(String str) {
        this.tittle = str;
    }

    public void setTradeMode(String str) {
        this.tradeMode = str;
    }

    public void setVerify(Boolean bool) {
        this.verify = bool;
    }

    public void setVerifyExtend(VerifyExtend verifyExtend2) {
        this.verifyExtend = verifyExtend2;
    }

    public void setVerifyType(int i11) {
        this.verifyType = i11;
    }

    public String toString() {
        return "CardOrderPayResultBean(orderStatus=" + getOrderStatus() + ", message=" + getMessage() + ", verify=" + getVerify() + ", verifyType=" + getVerifyType() + ", verifyExtend=" + getVerifyExtend() + ", tradeMode=" + getTradeMode() + ", runMode=" + getRunMode() + ", tittle=" + getTittle() + ", liquidity=" + getLiquidity() + ")";
    }
}
