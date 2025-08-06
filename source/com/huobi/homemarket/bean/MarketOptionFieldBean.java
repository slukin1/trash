package com.huobi.homemarket.bean;

import java.io.Serializable;

public class MarketOptionFieldBean implements Serializable {
    private static final long serialVersionUID = 9092760383861252036L;
    private OptionFieldTitleEnum fieldTitleEnum;
    private float width;

    public MarketOptionFieldBean(OptionFieldTitleEnum optionFieldTitleEnum) {
        this.fieldTitleEnum = optionFieldTitleEnum;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof MarketOptionFieldBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketOptionFieldBean)) {
            return false;
        }
        MarketOptionFieldBean marketOptionFieldBean = (MarketOptionFieldBean) obj;
        if (!marketOptionFieldBean.canEqual(this)) {
            return false;
        }
        OptionFieldTitleEnum fieldTitleEnum2 = getFieldTitleEnum();
        OptionFieldTitleEnum fieldTitleEnum3 = marketOptionFieldBean.getFieldTitleEnum();
        if (fieldTitleEnum2 != null ? fieldTitleEnum2.equals(fieldTitleEnum3) : fieldTitleEnum3 == null) {
            return Float.compare(getWidth(), marketOptionFieldBean.getWidth()) == 0;
        }
        return false;
    }

    public OptionFieldTitleEnum getFieldTitleEnum() {
        return this.fieldTitleEnum;
    }

    public float getWidth() {
        return this.width;
    }

    public int hashCode() {
        OptionFieldTitleEnum fieldTitleEnum2 = getFieldTitleEnum();
        return (((fieldTitleEnum2 == null ? 43 : fieldTitleEnum2.hashCode()) + 59) * 59) + Float.floatToIntBits(getWidth());
    }

    public void setFieldTitleEnum(OptionFieldTitleEnum optionFieldTitleEnum) {
        this.fieldTitleEnum = optionFieldTitleEnum;
    }

    public void setWidth(float f11) {
        this.width = f11;
    }

    public String toString() {
        return "MarketOptionFieldBean(fieldTitleEnum=" + getFieldTitleEnum() + ", width=" + getWidth() + ")";
    }
}
