package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class ChatSessionRemark implements Serializable {
    private String account;
    private String comment;

    public String getAccount() {
        return this.account;
    }

    public String getComment() {
        return this.comment;
    }
}
