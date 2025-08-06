package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ChatSessionRemove implements Serializable {
    @SerializedName("customerServers")
    private List<String> accountManagers;
    private List<String> accounts;
    private ChatSessionNoDisturb disturb;
    private HashSet<String> disturbSet;
    private List<String> groups;
    private HashSet<String> managerSet;
    @SerializedName("comments")
    private List<ChatSessionRemark> remarkList;
    private HashMap<String, String> remarkMap;
    private HashSet<String> removeSet;

    public List<String> getAccounts() {
        return this.accounts;
    }

    public List<String> getGroups() {
        return this.groups;
    }

    public String getRemarkName(String str) {
        if (this.remarkMap == null) {
            this.remarkMap = new HashMap<>();
            List<ChatSessionRemark> list = this.remarkList;
            if (list != null && !list.isEmpty()) {
                for (int i11 = 0; i11 < this.remarkList.size(); i11++) {
                    ChatSessionRemark chatSessionRemark = this.remarkList.get(i11);
                    this.remarkMap.put(chatSessionRemark.getAccount(), chatSessionRemark.getComment());
                }
            }
        }
        return this.remarkMap.get(str);
    }

    public boolean hasRemove(String str) {
        List<String> list = this.groups;
        if (list != null && list.contains(str)) {
            return true;
        }
        List<String> list2 = this.accounts;
        if (list2 == null || !list2.contains(str)) {
            return false;
        }
        return true;
    }

    public boolean isManager(String str) {
        if (this.managerSet == null) {
            this.managerSet = new HashSet<>();
            List<String> list = this.accountManagers;
            if (list != null && !list.isEmpty()) {
                this.managerSet.addAll(this.accountManagers);
            }
        }
        return this.managerSet.contains(str);
    }

    public boolean isNeedRemove(String str) {
        if (this.removeSet == null) {
            this.removeSet = new HashSet<>();
            List<String> list = this.groups;
            if (list != null && !list.isEmpty()) {
                this.removeSet.addAll(this.groups);
            }
            List<String> list2 = this.accounts;
            if (list2 != null && !list2.isEmpty()) {
                this.removeSet.addAll(this.accounts);
            }
        }
        return this.removeSet.contains(str);
    }

    public boolean isNoDisturb(String str) {
        if (this.disturbSet == null) {
            this.disturbSet = new HashSet<>();
            ChatSessionNoDisturb chatSessionNoDisturb = this.disturb;
            if (chatSessionNoDisturb != null) {
                if (chatSessionNoDisturb.getGroups() != null && !this.disturb.getGroups().isEmpty()) {
                    this.disturbSet.addAll(this.disturb.getGroups());
                }
                if (this.disturb.getAccounts() != null && !this.disturb.getAccounts().isEmpty()) {
                    this.disturbSet.addAll(this.disturb.getAccounts());
                }
            }
        }
        return this.disturbSet.contains(str);
    }

    public String toString() {
        String str;
        List<String> list = this.groups;
        String str2 = OptionsBridge.EMPTY_VALUE;
        if (list == null) {
            str = OptionsBridge.NULL_VALUE;
        } else if (list.isEmpty()) {
            str = str2;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            int size = this.groups.size();
            for (int i11 = 0; i11 < size; i11++) {
                sb2.append(" ");
                sb2.append(this.groups.get(i11));
                sb2.append(" ");
            }
            sb2.append("]");
            str = sb2.toString();
        }
        List<String> list2 = this.accounts;
        if (list2 == null) {
            str2 = OptionsBridge.NULL_VALUE;
        } else if (!list2.isEmpty()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[");
            int size2 = this.accounts.size();
            for (int i12 = 0; i12 < size2; i12++) {
                sb3.append(" ");
                sb3.append(this.accounts.get(i12));
                sb3.append(" ");
            }
            sb3.append("]");
            str2 = sb3.toString();
        }
        return "ChatSessionRemove{groups=" + str + ", accounts=" + str2 + '}';
    }
}
