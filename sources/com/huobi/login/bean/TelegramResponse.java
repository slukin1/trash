package com.huobi.login.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class TelegramResponse implements Serializable {
    private String html;
    private String origin;
    private User user;

    public static class User implements Serializable {
        @SerializedName("auth_date")
        private String authDate;
        @SerializedName("first_name")
        private String firstName;
        private String hash;

        /* renamed from: id  reason: collision with root package name */
        private long f75436id;
        @SerializedName("last_name")
        private String lastName;
        @SerializedName("photo_url")
        private String photoUrl;
        @SerializedName("username")
        private String username;

        public boolean canEqual(Object obj) {
            return obj instanceof User;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof User)) {
                return false;
            }
            User user = (User) obj;
            if (!user.canEqual(this)) {
                return false;
            }
            String lastName2 = getLastName();
            String lastName3 = user.getLastName();
            if (lastName2 != null ? !lastName2.equals(lastName3) : lastName3 != null) {
                return false;
            }
            String authDate2 = getAuthDate();
            String authDate3 = user.getAuthDate();
            if (authDate2 != null ? !authDate2.equals(authDate3) : authDate3 != null) {
                return false;
            }
            if (getId() != user.getId()) {
                return false;
            }
            String firstName2 = getFirstName();
            String firstName3 = user.getFirstName();
            if (firstName2 != null ? !firstName2.equals(firstName3) : firstName3 != null) {
                return false;
            }
            String hash2 = getHash();
            String hash3 = user.getHash();
            if (hash2 != null ? !hash2.equals(hash3) : hash3 != null) {
                return false;
            }
            String username2 = getUsername();
            String username3 = user.getUsername();
            if (username2 != null ? !username2.equals(username3) : username3 != null) {
                return false;
            }
            String photoUrl2 = getPhotoUrl();
            String photoUrl3 = user.getPhotoUrl();
            return photoUrl2 != null ? photoUrl2.equals(photoUrl3) : photoUrl3 == null;
        }

        public String getAuthDate() {
            return this.authDate;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getHash() {
            return this.hash;
        }

        public long getId() {
            return this.f75436id;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getPhotoUrl() {
            return this.photoUrl;
        }

        public String getUsername() {
            return this.username;
        }

        public int hashCode() {
            String lastName2 = getLastName();
            int i11 = 43;
            int hashCode = lastName2 == null ? 43 : lastName2.hashCode();
            String authDate2 = getAuthDate();
            int hashCode2 = ((hashCode + 59) * 59) + (authDate2 == null ? 43 : authDate2.hashCode());
            long id2 = getId();
            int i12 = (hashCode2 * 59) + ((int) (id2 ^ (id2 >>> 32)));
            String firstName2 = getFirstName();
            int hashCode3 = (i12 * 59) + (firstName2 == null ? 43 : firstName2.hashCode());
            String hash2 = getHash();
            int hashCode4 = (hashCode3 * 59) + (hash2 == null ? 43 : hash2.hashCode());
            String username2 = getUsername();
            int hashCode5 = (hashCode4 * 59) + (username2 == null ? 43 : username2.hashCode());
            String photoUrl2 = getPhotoUrl();
            int i13 = hashCode5 * 59;
            if (photoUrl2 != null) {
                i11 = photoUrl2.hashCode();
            }
            return i13 + i11;
        }

        public void setAuthDate(String str) {
            this.authDate = str;
        }

        public void setFirstName(String str) {
            this.firstName = str;
        }

        public void setHash(String str) {
            this.hash = str;
        }

        public void setId(long j11) {
            this.f75436id = j11;
        }

        public void setLastName(String str) {
            this.lastName = str;
        }

        public void setPhotoUrl(String str) {
            this.photoUrl = str;
        }

        public void setUsername(String str) {
            this.username = str;
        }

        public String toString() {
            return "TelegramResponse.User(lastName=" + getLastName() + ", authDate=" + getAuthDate() + ", id=" + getId() + ", firstName=" + getFirstName() + ", hash=" + getHash() + ", username=" + getUsername() + ", photoUrl=" + getPhotoUrl() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof TelegramResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TelegramResponse)) {
            return false;
        }
        TelegramResponse telegramResponse = (TelegramResponse) obj;
        if (!telegramResponse.canEqual(this)) {
            return false;
        }
        String origin2 = getOrigin();
        String origin3 = telegramResponse.getOrigin();
        if (origin2 != null ? !origin2.equals(origin3) : origin3 != null) {
            return false;
        }
        String html2 = getHtml();
        String html3 = telegramResponse.getHtml();
        if (html2 != null ? !html2.equals(html3) : html3 != null) {
            return false;
        }
        User user2 = getUser();
        User user3 = telegramResponse.getUser();
        return user2 != null ? user2.equals(user3) : user3 == null;
    }

    public String getHtml() {
        return this.html;
    }

    public String getOrigin() {
        return this.origin;
    }

    public User getUser() {
        return this.user;
    }

    public int hashCode() {
        String origin2 = getOrigin();
        int i11 = 43;
        int hashCode = origin2 == null ? 43 : origin2.hashCode();
        String html2 = getHtml();
        int hashCode2 = ((hashCode + 59) * 59) + (html2 == null ? 43 : html2.hashCode());
        User user2 = getUser();
        int i12 = hashCode2 * 59;
        if (user2 != null) {
            i11 = user2.hashCode();
        }
        return i12 + i11;
    }

    public void setHtml(String str) {
        this.html = str;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public void setUser(User user2) {
        this.user = user2;
    }

    public String toString() {
        return "TelegramResponse(origin=" + getOrigin() + ", html=" + getHtml() + ", user=" + getUser() + ")";
    }
}
