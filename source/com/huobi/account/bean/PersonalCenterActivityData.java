package com.huobi.account.bean;

import androidx.annotation.Keep;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.PersonalcenterActivityInfoBean;
import com.huobi.account.viewhandler.PersonalCenterActivityHandler;
import java.io.Serializable;
import s9.a;

@Keep
public class PersonalCenterActivityData implements a, Serializable {
    private PersonalcenterActivityInfoBean infoBean;

    public PersonalCenterActivityData(PersonalcenterActivityInfoBean personalcenterActivityInfoBean) {
        this.infoBean = personalcenterActivityInfoBean;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof PersonalCenterActivityData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersonalCenterActivityData)) {
            return false;
        }
        PersonalCenterActivityData personalCenterActivityData = (PersonalCenterActivityData) obj;
        if (!personalCenterActivityData.canEqual(this)) {
            return false;
        }
        PersonalcenterActivityInfoBean infoBean2 = getInfoBean();
        PersonalcenterActivityInfoBean infoBean3 = personalCenterActivityData.getInfoBean();
        return infoBean2 != null ? infoBean2.equals(infoBean3) : infoBean3 == null;
    }

    public String getImageUrl() {
        if (NightHelper.e().g()) {
            return getNightImageUrl();
        }
        return this.infoBean.getImg_url();
    }

    public PersonalcenterActivityInfoBean getInfoBean() {
        return this.infoBean;
    }

    public String getIntroduction() {
        return this.infoBean.getIntroduction();
    }

    public String getJumpUrl() {
        return this.infoBean.getJump_url();
    }

    public String getNightImageUrl() {
        return this.infoBean.getImg_night_url();
    }

    public String getSubUrl() {
        return this.infoBean.getSub_url();
    }

    public String getTitle() {
        return this.infoBean.getTitle();
    }

    public String getViewHandlerName() {
        return PersonalCenterActivityHandler.class.getName();
    }

    public int hashCode() {
        PersonalcenterActivityInfoBean infoBean2 = getInfoBean();
        return 59 + (infoBean2 == null ? 43 : infoBean2.hashCode());
    }

    public void setInfoBean(PersonalcenterActivityInfoBean personalcenterActivityInfoBean) {
        this.infoBean = personalcenterActivityInfoBean;
    }

    public String toString() {
        return "PersonalCenterActivityData(infoBean=" + getInfoBean() + ")";
    }
}
