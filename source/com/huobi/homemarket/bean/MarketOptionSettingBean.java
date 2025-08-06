package com.huobi.homemarket.bean;

import android.view.View;
import com.huobi.homemarket.handler.MarketOptionSettingItemHandler;
import java.io.Serializable;
import s9.a;

public class MarketOptionSettingBean implements Serializable, a {
    private static final long serialVersionUID = 7858605540126028698L;
    private String contractType;
    private String deliveryDate;
    private int direction;
    private OptionFieldTitleEnum fieldTitleEnum;
    private String name;
    private View.OnClickListener onClickListener;
    private boolean selected = false;
    private boolean temporarySelectedState = false;
    private int type;

    public MarketOptionSettingBean(int i11, String str) {
        this.type = i11;
        this.name = str;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof MarketOptionSettingBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketOptionSettingBean)) {
            return false;
        }
        MarketOptionSettingBean marketOptionSettingBean = (MarketOptionSettingBean) obj;
        if (!marketOptionSettingBean.canEqual(this) || getType() != marketOptionSettingBean.getType()) {
            return false;
        }
        String name2 = getName();
        String name3 = marketOptionSettingBean.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = marketOptionSettingBean.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String deliveryDate2 = getDeliveryDate();
        String deliveryDate3 = marketOptionSettingBean.getDeliveryDate();
        if (deliveryDate2 != null ? !deliveryDate2.equals(deliveryDate3) : deliveryDate3 != null) {
            return false;
        }
        if (isSelected() != marketOptionSettingBean.isSelected() || isTemporarySelectedState() != marketOptionSettingBean.isTemporarySelectedState()) {
            return false;
        }
        View.OnClickListener onClickListener2 = getOnClickListener();
        View.OnClickListener onClickListener3 = marketOptionSettingBean.getOnClickListener();
        if (onClickListener2 != null ? !onClickListener2.equals(onClickListener3) : onClickListener3 != null) {
            return false;
        }
        if (getDirection() != marketOptionSettingBean.getDirection()) {
            return false;
        }
        OptionFieldTitleEnum fieldTitleEnum2 = getFieldTitleEnum();
        OptionFieldTitleEnum fieldTitleEnum3 = marketOptionSettingBean.getFieldTitleEnum();
        return fieldTitleEnum2 != null ? fieldTitleEnum2.equals(fieldTitleEnum3) : fieldTitleEnum3 == null;
    }

    public String getContractType() {
        return this.contractType;
    }

    public String getDeliveryDate() {
        return this.deliveryDate;
    }

    public int getDirection() {
        return this.direction;
    }

    public OptionFieldTitleEnum getFieldTitleEnum() {
        return this.fieldTitleEnum;
    }

    public String getName() {
        return this.name;
    }

    public View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public int getType() {
        return this.type;
    }

    public String getViewHandlerName() {
        return MarketOptionSettingItemHandler.class.getName();
    }

    public int hashCode() {
        String name2 = getName();
        int i11 = 43;
        int type2 = ((getType() + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
        String contractType2 = getContractType();
        int hashCode = (type2 * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String deliveryDate2 = getDeliveryDate();
        int i12 = 79;
        int hashCode2 = ((((hashCode * 59) + (deliveryDate2 == null ? 43 : deliveryDate2.hashCode())) * 59) + (isSelected() ? 79 : 97)) * 59;
        if (!isTemporarySelectedState()) {
            i12 = 97;
        }
        View.OnClickListener onClickListener2 = getOnClickListener();
        int hashCode3 = ((((hashCode2 + i12) * 59) + (onClickListener2 == null ? 43 : onClickListener2.hashCode())) * 59) + getDirection();
        OptionFieldTitleEnum fieldTitleEnum2 = getFieldTitleEnum();
        int i13 = hashCode3 * 59;
        if (fieldTitleEnum2 != null) {
            i11 = fieldTitleEnum2.hashCode();
        }
        return i13 + i11;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public boolean isTemporarySelectedState() {
        return this.temporarySelectedState;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setDeliveryDate(String str) {
        this.deliveryDate = str;
    }

    public void setDirection(int i11) {
        this.direction = i11;
    }

    public void setFieldTitleEnum(OptionFieldTitleEnum optionFieldTitleEnum) {
        this.fieldTitleEnum = optionFieldTitleEnum;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOnClickListener(View.OnClickListener onClickListener2) {
        this.onClickListener = onClickListener2;
    }

    public void setSelected(boolean z11) {
        this.selected = z11;
        this.temporarySelectedState = z11;
    }

    public void setTemporarySelectedState(boolean z11) {
        this.temporarySelectedState = z11;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "MarketOptionSettingBean(type=" + getType() + ", name=" + getName() + ", contractType=" + getContractType() + ", deliveryDate=" + getDeliveryDate() + ", selected=" + isSelected() + ", temporarySelectedState=" + isTemporarySelectedState() + ", onClickListener=" + getOnClickListener() + ", direction=" + getDirection() + ", fieldTitleEnum=" + getFieldTitleEnum() + ")";
    }

    public MarketOptionSettingBean(int i11, OptionFieldTitleEnum optionFieldTitleEnum, boolean z11) {
        this.type = i11;
        this.fieldTitleEnum = optionFieldTitleEnum;
        setSelected(z11);
    }

    public MarketOptionSettingBean(int i11, String str, String str2, String str3) {
        this.type = i11;
        this.name = str;
        this.contractType = str2;
        this.deliveryDate = str3;
    }

    public MarketOptionSettingBean(int i11, String str, int i12) {
        this.type = i11;
        this.name = str;
        this.direction = i12;
    }
}
