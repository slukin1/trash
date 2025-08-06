package com.hbg.lib.network.hbg.core.bean;

import android.text.TextUtils;
import java.io.Serializable;

public class PersonalcenterActivityInfoBean implements Serializable {
    private String desc;
    private String f_end_time;
    private String f_start_time;
    private String img_night_url;
    private String img_url;
    private String introduction;
    private String jump_url;
    private String sub_url;
    private String title;
    private String titleMd;
    private int weight;

    public boolean canEqual(Object obj) {
        return obj instanceof PersonalcenterActivityInfoBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersonalcenterActivityInfoBean)) {
            return false;
        }
        PersonalcenterActivityInfoBean personalcenterActivityInfoBean = (PersonalcenterActivityInfoBean) obj;
        if (!personalcenterActivityInfoBean.canEqual(this)) {
            return false;
        }
        String title2 = getTitle();
        String title3 = personalcenterActivityInfoBean.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String introduction2 = getIntroduction();
        String introduction3 = personalcenterActivityInfoBean.getIntroduction();
        if (introduction2 != null ? !introduction2.equals(introduction3) : introduction3 != null) {
            return false;
        }
        String img_url2 = getImg_url();
        String img_url3 = personalcenterActivityInfoBean.getImg_url();
        if (img_url2 != null ? !img_url2.equals(img_url3) : img_url3 != null) {
            return false;
        }
        String img_night_url2 = getImg_night_url();
        String img_night_url3 = personalcenterActivityInfoBean.getImg_night_url();
        if (img_night_url2 != null ? !img_night_url2.equals(img_night_url3) : img_night_url3 != null) {
            return false;
        }
        String sub_url2 = getSub_url();
        String sub_url3 = personalcenterActivityInfoBean.getSub_url();
        if (sub_url2 != null ? !sub_url2.equals(sub_url3) : sub_url3 != null) {
            return false;
        }
        String jump_url2 = getJump_url();
        String jump_url3 = personalcenterActivityInfoBean.getJump_url();
        if (jump_url2 != null ? !jump_url2.equals(jump_url3) : jump_url3 != null) {
            return false;
        }
        if (getWeight() != personalcenterActivityInfoBean.getWeight()) {
            return false;
        }
        String desc2 = getDesc();
        String desc3 = personalcenterActivityInfoBean.getDesc();
        if (desc2 != null ? !desc2.equals(desc3) : desc3 != null) {
            return false;
        }
        String f_start_time2 = getF_start_time();
        String f_start_time3 = personalcenterActivityInfoBean.getF_start_time();
        if (f_start_time2 != null ? !f_start_time2.equals(f_start_time3) : f_start_time3 != null) {
            return false;
        }
        String f_end_time2 = getF_end_time();
        String f_end_time3 = personalcenterActivityInfoBean.getF_end_time();
        if (f_end_time2 != null ? !f_end_time2.equals(f_end_time3) : f_end_time3 != null) {
            return false;
        }
        String titleMd2 = getTitleMd();
        String titleMd3 = personalcenterActivityInfoBean.getTitleMd();
        return titleMd2 != null ? titleMd2.equals(titleMd3) : titleMd3 == null;
    }

    public String getBusinessCategory() {
        if (!TextUtils.isEmpty(this.titleMd)) {
            return this.titleMd;
        }
        return this.title;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getF_end_time() {
        return this.f_end_time;
    }

    public String getF_start_time() {
        return this.f_start_time;
    }

    public String getImg_night_url() {
        return this.img_night_url;
    }

    public String getImg_url() {
        return this.img_url;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public String getJump_url() {
        return this.jump_url;
    }

    public String getSub_url() {
        return this.sub_url;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleMd() {
        return this.titleMd;
    }

    public int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        String title2 = getTitle();
        int i11 = 43;
        int hashCode = title2 == null ? 43 : title2.hashCode();
        String introduction2 = getIntroduction();
        int hashCode2 = ((hashCode + 59) * 59) + (introduction2 == null ? 43 : introduction2.hashCode());
        String img_url2 = getImg_url();
        int hashCode3 = (hashCode2 * 59) + (img_url2 == null ? 43 : img_url2.hashCode());
        String img_night_url2 = getImg_night_url();
        int hashCode4 = (hashCode3 * 59) + (img_night_url2 == null ? 43 : img_night_url2.hashCode());
        String sub_url2 = getSub_url();
        int hashCode5 = (hashCode4 * 59) + (sub_url2 == null ? 43 : sub_url2.hashCode());
        String jump_url2 = getJump_url();
        int hashCode6 = (((hashCode5 * 59) + (jump_url2 == null ? 43 : jump_url2.hashCode())) * 59) + getWeight();
        String desc2 = getDesc();
        int hashCode7 = (hashCode6 * 59) + (desc2 == null ? 43 : desc2.hashCode());
        String f_start_time2 = getF_start_time();
        int hashCode8 = (hashCode7 * 59) + (f_start_time2 == null ? 43 : f_start_time2.hashCode());
        String f_end_time2 = getF_end_time();
        int hashCode9 = (hashCode8 * 59) + (f_end_time2 == null ? 43 : f_end_time2.hashCode());
        String titleMd2 = getTitleMd();
        int i12 = hashCode9 * 59;
        if (titleMd2 != null) {
            i11 = titleMd2.hashCode();
        }
        return i12 + i11;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setF_end_time(String str) {
        this.f_end_time = str;
    }

    public void setF_start_time(String str) {
        this.f_start_time = str;
    }

    public void setImg_night_url(String str) {
        this.img_night_url = str;
    }

    public void setImg_url(String str) {
        this.img_url = str;
    }

    public void setIntroduction(String str) {
        this.introduction = str;
    }

    public void setJump_url(String str) {
        this.jump_url = str;
    }

    public void setSub_url(String str) {
        this.sub_url = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTitleMd(String str) {
        this.titleMd = str;
    }

    public void setWeight(int i11) {
        this.weight = i11;
    }

    public String toString() {
        return "PersonalcenterActivityInfoBean(title=" + getTitle() + ", introduction=" + getIntroduction() + ", img_url=" + getImg_url() + ", img_night_url=" + getImg_night_url() + ", sub_url=" + getSub_url() + ", jump_url=" + getJump_url() + ", weight=" + getWeight() + ", desc=" + getDesc() + ", f_start_time=" + getF_start_time() + ", f_end_time=" + getF_end_time() + ", titleMd=" + getTitleMd() + ")";
    }
}
