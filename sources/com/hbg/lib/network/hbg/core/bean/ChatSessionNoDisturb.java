package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class ChatSessionNoDisturb implements Serializable {
    private List<String> accounts;
    private List<String> groups;

    public List<String> getAccounts() {
        return this.accounts;
    }

    public List<String> getGroups() {
        return this.groups;
    }
}
