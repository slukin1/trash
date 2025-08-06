package com.huobi.entity;

import com.hbg.lib.network.retrofit.response.IResponse;

public class UpdateResponse implements IResponse {
    private static final long serialVersionUID = 1827685511385502458L;
    private String actionurl;
    private int code;
    private String content;
    private String direct_downloadurl;
    private String downloadurl;
    private int force_upgrade;
    private int is_popup;
    private String md5;
    private String msgtype;
    private String notice_content;
    private String notice_title;
    private String option;
    private int service_check;
    private int tip_count_sum;
    private String title;
    private String version;
    private int version_code;

    public String getActionurl() {
        return this.actionurl;
    }

    public int getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public String getDirect_downloadurl() {
        return this.direct_downloadurl;
    }

    public String getDownloadurl() {
        return this.downloadurl;
    }

    public int getForce_upgrade() {
        return this.force_upgrade;
    }

    public int getIs_popup() {
        return this.is_popup;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getMsgtype() {
        return this.msgtype;
    }

    public String getNotice_content() {
        return this.notice_content;
    }

    public String getNotice_title() {
        return this.notice_title;
    }

    public String getOption() {
        return this.option;
    }

    public int getService_check() {
        return this.service_check;
    }

    public int getTip_count_sum() {
        return this.tip_count_sum;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVersion() {
        return this.version;
    }

    public int getVersion_code() {
        return this.version_code;
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public void setActionurl(String str) {
        this.actionurl = str;
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDirect_downloadurl(String str) {
        this.direct_downloadurl = str;
    }

    public void setDownloadurl(String str) {
        this.downloadurl = str;
    }

    public void setForce_upgrade(int i11) {
        this.force_upgrade = i11;
    }

    public void setIs_popup(int i11) {
        this.is_popup = i11;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setMsgtype(String str) {
        this.msgtype = str;
    }

    public void setNotice_content(String str) {
        this.notice_content = str;
    }

    public void setNotice_title(String str) {
        this.notice_title = str;
    }

    public void setOption(String str) {
        this.option = str;
    }

    public void setService_check(int i11) {
        this.service_check = i11;
    }

    public void setTip_count_sum(int i11) {
        this.tip_count_sum = i11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setVersion_code(int i11) {
        this.version_code = i11;
    }

    public String toString() {
        return "UpdateResponse{notice_title='" + this.notice_title + '\'' + ", service_check=" + this.service_check + ", code=" + this.code + ", notice_content='" + this.notice_content + '\'' + ", version_code=" + this.version_code + ", downloadurl='" + this.downloadurl + '\'' + ", force_upgrade=" + this.force_upgrade + ", actionurl='" + this.actionurl + '\'' + ", title='" + this.title + '\'' + ", version='" + this.version + '\'' + ", content='" + this.content + '\'' + ", is_popup=" + this.is_popup + ", msgtype='" + this.msgtype + '\'' + ", option='" + this.option + '\'' + ", tip_count_sum=" + this.tip_count_sum + ", direct_downloadurl='" + this.direct_downloadurl + '\'' + ", md5='" + this.md5 + '\'' + '}';
    }
}
