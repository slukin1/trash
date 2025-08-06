package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class LiveWiningInfo implements Serializable {
    private static final long serialVersionUID = 5628828266428787116L;
    private List<QueryAwardDrawResult> queryAwardDrawResultList;
    private String ruleContent;

    public static class DrawDetailList implements Serializable {
        private static final long serialVersionUID = 4289012016862126975L;
        private Integer awardId;
        private String count;
        private String currency;
        private String desc;
        private String properties;
        private Map<String, String> propertiesMap;
        private Integer type;
        private String usdt;

        public Integer getAwardId() {
            return this.awardId;
        }

        public String getCount() {
            return this.count;
        }

        public String getCurrency() {
            return this.currency;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getProperties() {
            return this.properties;
        }

        public Map<String, String> getPropertiesMap() {
            return this.propertiesMap;
        }

        public Integer getType() {
            return this.type;
        }

        public String getUsdt() {
            return this.usdt;
        }

        public void setAwardId(Integer num) {
            this.awardId = num;
        }

        public void setCount(String str) {
            this.count = str;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setProperties(String str) {
            this.properties = str;
        }

        public void setPropertiesMap(Map<String, String> map) {
            this.propertiesMap = map;
        }

        public void setType(Integer num) {
            this.type = num;
        }

        public void setUsdt(String str) {
            this.usdt = str;
        }
    }

    public static class PropertiesBean implements Serializable {
        private static final long serialVersionUID = 6008031593542539825L;
        private Long expiryDate;

        /* renamed from: id  reason: collision with root package name */
        private String f70258id;
        private String rate;
        private Integer rateCycle;
        private String title;
        private String transactionId;
        private String use;
        private String value;

        public Long getExpiryDate() {
            return this.expiryDate;
        }

        public String getId() {
            return this.f70258id;
        }

        public String getRate() {
            return this.rate;
        }

        public Integer getRateCycle() {
            return this.rateCycle;
        }

        public String getTitle() {
            return this.title;
        }

        public String getTransactionId() {
            return this.transactionId;
        }

        public String getUse() {
            return this.use;
        }

        public String getValue() {
            return this.value;
        }

        public void setExpiryDate(Long l11) {
            this.expiryDate = l11;
        }

        public void setId(String str) {
            this.f70258id = str;
        }

        public void setRate(String str) {
            this.rate = str;
        }

        public void setRateCycle(Integer num) {
            this.rateCycle = num;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setTransactionId(String str) {
            this.transactionId = str;
        }

        public void setUse(String str) {
            this.use = str;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }

    public static class QueryAwardDrawResult implements Serializable {
        private static final long serialVersionUID = 3667769485829335123L;
        private List<DrawDetailList> drawDetailList;
        private Integer type;

        public List<DrawDetailList> getDrawDetailList() {
            return this.drawDetailList;
        }

        public Integer getType() {
            return this.type;
        }

        public void setDrawDetailList(List<DrawDetailList> list) {
            this.drawDetailList = list;
        }

        public void setType(Integer num) {
            this.type = num;
        }
    }

    public List<QueryAwardDrawResult> getQueryAwardDrawResultList() {
        return this.queryAwardDrawResultList;
    }

    public String getRuleContent() {
        return this.ruleContent;
    }

    public void setQueryAwardDrawResultList(List<QueryAwardDrawResult> list) {
        this.queryAwardDrawResultList = list;
    }

    public void setRuleContent(String str) {
        this.ruleContent = str;
    }
}
