package zendesk.core;

import com.google.gson.annotations.SerializedName;

class AccessToken {
    private String accessToken;
    @SerializedName("user_id")
    private String userId;

    public AccessToken() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AccessToken accessToken2 = (AccessToken) obj;
        String str = this.accessToken;
        if (str == null ? accessToken2.accessToken != null : !str.equals(accessToken2.accessToken)) {
            return false;
        }
        String str2 = this.userId;
        String str3 = accessToken2.userId;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.accessToken;
        int i11 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.userId;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public AccessToken(String str, String str2) {
        this.accessToken = str;
        this.userId = str2;
    }
}
