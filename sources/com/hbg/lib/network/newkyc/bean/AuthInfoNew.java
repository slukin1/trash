package com.hbg.lib.network.newkyc.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AuthInfoNew implements Serializable {
    public static final int ORGANIZATION = 10;
    private String auth_type;
    private int c1_status;
    private int c2_status;
    private String fullname;
    private boolean global_tr;
    @SerializedName("need_agree_v2")
    private boolean needAgreeV2;
    @SerializedName("need_kyc_v2")
    private boolean needKycV2;
    private int pro_auth_type;
    private String pro_card_no;
    private String pro_first_name;
    private String pro_last_name;
    private String pro_org_name;
    private String[] pro_reason_en;
    private String[] pro_reason_zh;
    private int pro_status;
    private String[] reason_en;
    private String[] reason_zh;
    private String[] sd_reason_en;
    private String[] sd_reason_zh;
    private int supplement_data_status;
    private int u_status;
    private int video_auth_status;

    public String getAuth_type() {
        return this.auth_type;
    }

    public int getC1_status() {
        return this.c1_status;
    }

    public int getC2_status() {
        return this.c2_status;
    }

    public String getFullname() {
        return this.fullname;
    }

    public int getPro_auth_type() {
        return this.pro_auth_type;
    }

    public String getPro_card_no() {
        return this.pro_card_no;
    }

    public String getPro_first_name() {
        return this.pro_first_name;
    }

    public String getPro_last_name() {
        return this.pro_last_name;
    }

    public String getPro_org_name() {
        return this.pro_org_name;
    }

    public String[] getPro_reason_en() {
        return this.pro_reason_en;
    }

    public String[] getPro_reason_zh() {
        return this.pro_reason_zh;
    }

    public int getPro_status() {
        return this.pro_status;
    }

    public String[] getReason_en() {
        return this.reason_en;
    }

    public String[] getReason_zh() {
        return this.reason_zh;
    }

    public String[] getSd_reason_en() {
        return this.sd_reason_en;
    }

    public String[] getSd_reason_zh() {
        return this.sd_reason_zh;
    }

    public int getSupplement_data_status() {
        return this.supplement_data_status;
    }

    public int getU_status() {
        return this.u_status;
    }

    public int getVideo_auth_status() {
        return this.video_auth_status;
    }

    public boolean isGlobal_tr() {
        return this.global_tr;
    }

    public boolean isNeedAgreeV2() {
        return this.needAgreeV2;
    }

    public boolean isNeedKycV2() {
        return this.needKycV2;
    }

    public void setAuth_type(String str) {
        this.auth_type = str;
    }

    public void setC1_status(int i11) {
        this.c1_status = i11;
    }

    public void setC2_status(int i11) {
        this.c2_status = i11;
    }

    public void setFullname(String str) {
        this.fullname = str;
    }

    public void setGlobal_tr(boolean z11) {
        this.global_tr = z11;
    }

    public void setNeedAgreeV2(boolean z11) {
        this.needAgreeV2 = z11;
    }

    public void setNeedKycV2(boolean z11) {
        this.needKycV2 = z11;
    }

    public void setPro_auth_type(int i11) {
        this.pro_auth_type = i11;
    }

    public void setPro_card_no(String str) {
        this.pro_card_no = str;
    }

    public void setPro_first_name(String str) {
        this.pro_first_name = str;
    }

    public void setPro_last_name(String str) {
        this.pro_last_name = str;
    }

    public void setPro_org_name(String str) {
        this.pro_org_name = str;
    }

    public void setPro_reason_en(String[] strArr) {
        this.pro_reason_en = strArr;
    }

    public void setPro_reason_zh(String[] strArr) {
        this.pro_reason_zh = strArr;
    }

    public void setPro_status(int i11) {
        this.pro_status = i11;
    }

    public void setReason_en(String[] strArr) {
        this.reason_en = strArr;
    }

    public void setReason_zh(String[] strArr) {
        this.reason_zh = strArr;
    }

    public void setSd_reason_en(String[] strArr) {
        this.sd_reason_en = strArr;
    }

    public void setSd_reason_zh(String[] strArr) {
        this.sd_reason_zh = strArr;
    }

    public void setSupplement_data_status(Integer num) {
        this.supplement_data_status = num.intValue();
    }

    public void setU_status(int i11) {
        this.u_status = i11;
    }

    public void setVideo_auth_status(int i11) {
        this.video_auth_status = i11;
    }
}
