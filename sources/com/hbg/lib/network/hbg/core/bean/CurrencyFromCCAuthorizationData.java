package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class CurrencyFromCCAuthorizationData implements Serializable {
    private static final int MAX_LEVEL = 4;
    public static final int NOT_PASS = 0;
    public static final int PASS = 1;
    public static final int STATUS_AUTH_FAILED = 3;
    public static final int STATUS_AUTH_INIT = 0;
    public static final int STATUS_AUTH_PENDING = 4;
    public static final int STATUS_AUTH_WAITING = 1;
    public static final int STATUS_AUT_SUCCESS = 2;
    private static final long serialVersionUID = -1817698282201638982L;
    private String appId;
    private List<AuthData> authList;
    private int authorized;
    private int localLevel;
    private int localMinLevel;
    private int localStatus;

    public static class AuthData implements Serializable {
        private static final long serialVersionUID = -1817698282201638982L;
        /* access modifiers changed from: private */
        public int authState;
        /* access modifiers changed from: private */
        public int level;
        private long userId;

        public boolean canEqual(Object obj) {
            return obj instanceof AuthData;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AuthData)) {
                return false;
            }
            AuthData authData = (AuthData) obj;
            return authData.canEqual(this) && getUserId() == authData.getUserId() && getLevel() == authData.getLevel() && getAuthState() == authData.getAuthState();
        }

        public int getAuthState() {
            return this.authState;
        }

        public int getLevel() {
            return this.level;
        }

        public long getUserId() {
            return this.userId;
        }

        public int hashCode() {
            long userId2 = getUserId();
            return ((((((int) (userId2 ^ (userId2 >>> 32))) + 59) * 59) + getLevel()) * 59) + getAuthState();
        }

        public void setAuthState(int i11) {
            this.authState = i11;
        }

        public void setLevel(int i11) {
            this.level = i11;
        }

        public void setUserId(long j11) {
            this.userId = j11;
        }

        public String toString() {
            return "CurrencyFromCCAuthorizationData.AuthData(userId=" + getUserId() + ", level=" + getLevel() + ", authState=" + getAuthState() + ")";
        }
    }

    private int convertLocalStatus(int i11) {
        if (i11 != 1) {
            if (i11 == 2) {
                return i11 * 100;
            }
            if (i11 != 4) {
                return i11;
            }
        }
        return i11 * 10;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof CurrencyFromCCAuthorizationData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencyFromCCAuthorizationData)) {
            return false;
        }
        CurrencyFromCCAuthorizationData currencyFromCCAuthorizationData = (CurrencyFromCCAuthorizationData) obj;
        if (!currencyFromCCAuthorizationData.canEqual(this) || getAuthorized() != currencyFromCCAuthorizationData.getAuthorized()) {
            return false;
        }
        String appId2 = getAppId();
        String appId3 = currencyFromCCAuthorizationData.getAppId();
        if (appId2 != null ? !appId2.equals(appId3) : appId3 != null) {
            return false;
        }
        List<AuthData> authList2 = getAuthList();
        List<AuthData> authList3 = currencyFromCCAuthorizationData.getAuthList();
        if (authList2 != null ? authList2.equals(authList3) : authList3 == null) {
            return getLocalMinLevel() == currencyFromCCAuthorizationData.getLocalMinLevel() && getLocalStatus() == currencyFromCCAuthorizationData.getLocalStatus() && getLocalLevel() == currencyFromCCAuthorizationData.getLocalLevel();
        }
        return false;
    }

    public String getAppId() {
        return this.appId;
    }

    public List<AuthData> getAuthList() {
        return this.authList;
    }

    public int getAuthorized() {
        return this.authorized;
    }

    public int getLocalLevel() {
        return this.localLevel;
    }

    public int getLocalMinLevel() {
        return this.localMinLevel;
    }

    public int getLocalStatus() {
        return this.localStatus;
    }

    public int hashCode() {
        String appId2 = getAppId();
        int i11 = 43;
        int authorized2 = ((getAuthorized() + 59) * 59) + (appId2 == null ? 43 : appId2.hashCode());
        List<AuthData> authList2 = getAuthList();
        int i12 = authorized2 * 59;
        if (authList2 != null) {
            i11 = authList2.hashCode();
        }
        return ((((((i12 + i11) * 59) + getLocalMinLevel()) * 59) + getLocalStatus()) * 59) + getLocalLevel();
    }

    public void initLocalStateAndLevel(int i11) {
        this.localMinLevel = i11;
        List<AuthData> list = this.authList;
        if (list != null && !list.isEmpty()) {
            HashMap hashMap = new HashMap();
            int i12 = i11;
            for (AuthData next : this.authList) {
                if (next != null) {
                    hashMap.put(Integer.valueOf(next.level), next);
                    if (i12 < next.level) {
                        i12 = next.level;
                    }
                }
            }
            int i13 = 0;
            int i14 = 0;
            while (i11 <= i12) {
                AuthData authData = (AuthData) hashMap.get(Integer.valueOf(i11));
                if (authData != null && convertLocalStatus(authData.authState) > convertLocalStatus(i13)) {
                    i14 = authData.level;
                    i13 = authData.authState;
                }
                i11++;
            }
            this.localStatus = i13;
            this.localLevel = i14;
        }
    }

    public boolean isPassed() {
        return this.authorized == 1;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAuthList(List<AuthData> list) {
        this.authList = list;
    }

    public void setAuthorized(int i11) {
        this.authorized = i11;
    }

    public void setLocalLevel(int i11) {
        this.localLevel = i11;
    }

    public void setLocalMinLevel(int i11) {
        this.localMinLevel = i11;
    }

    public void setLocalStatus(int i11) {
        this.localStatus = i11;
    }

    public String toString() {
        return "CurrencyFromCCAuthorizationData(authorized=" + getAuthorized() + ", appId=" + getAppId() + ", authList=" + getAuthList() + ", localMinLevel=" + getLocalMinLevel() + ", localStatus=" + getLocalStatus() + ", localLevel=" + getLocalLevel() + ")";
    }
}
