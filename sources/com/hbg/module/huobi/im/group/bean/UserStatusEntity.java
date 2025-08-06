package com.hbg.module.huobi.im.group.bean;

public final class UserStatusEntity {
    private Integer customer = 0;
    private Integer focus = 0;
    private Integer forbid = 0;
    private Integer inblackList = 0;
    private Integer manager = 0;
    private Integer noDisturbStatus = 0;
    private Integer speaker = 0;

    public final Integer getCustomer() {
        return this.customer;
    }

    public final Integer getFocus() {
        return this.focus;
    }

    public final Integer getForbid() {
        return this.forbid;
    }

    public final Integer getInblackList() {
        return this.inblackList;
    }

    public final Integer getManager() {
        return this.manager;
    }

    public final Integer getNoDisturbStatus() {
        return this.noDisturbStatus;
    }

    public final Integer getSpeaker() {
        return this.speaker;
    }

    public final void setCustomer(Integer num) {
        this.customer = num;
    }

    public final void setFocus(Integer num) {
        this.focus = num;
    }

    public final void setForbid(Integer num) {
        this.forbid = num;
    }

    public final void setInblackList(Integer num) {
        this.inblackList = num;
    }

    public final void setManager(Integer num) {
        this.manager = num;
    }

    public final void setNoDisturbStatus(Integer num) {
        this.noDisturbStatus = num;
    }

    public final void setSpeaker(Integer num) {
        this.speaker = num;
    }
}
