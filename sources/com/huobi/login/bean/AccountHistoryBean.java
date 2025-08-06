package com.huobi.login.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.huobi.login.holder.AccountHistoryHolder;
import java.io.Serializable;
import java.util.Objects;
import lombok.NonNull;
import s9.a;

public class AccountHistoryBean implements a, Serializable {
    @SerializedName("account")
    @NonNull
    private String account;
    @Expose(deserialize = false, serialize = false)
    private xn.a listener;

    public AccountHistoryBean(@NonNull String str) {
        Objects.requireNonNull(str, "account is marked @NonNull but is null");
        this.account = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.account.equals(((AccountHistoryBean) obj).account);
    }

    @NonNull
    public String getAccount() {
        return this.account;
    }

    public xn.a getListener() {
        return this.listener;
    }

    public String getViewHandlerName() {
        return AccountHistoryHolder.class.getName();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.account});
    }

    public void setAccount(@NonNull String str) {
        Objects.requireNonNull(str, "account is marked @NonNull but is null");
        this.account = str;
    }

    public void setListener(xn.a aVar) {
        this.listener = aVar;
    }

    public String toString() {
        return "AccountHistoryBean(account=" + getAccount() + ", listener=" + getListener() + ")";
    }
}
