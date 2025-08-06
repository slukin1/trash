package com.zopim.android.sdk.model;

import java.io.Serializable;

public class VisitorInfo implements Serializable {
    private static final long serialVersionUID = 8250425043423370849L;
    private String email;
    private String name;
    private String note;
    private String phoneNumber;

    public static class Builder {
        public String email;
        public String name;
        public String note;
        public String phoneNumber;

        public VisitorInfo build() {
            return new VisitorInfo(this);
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder note(String str) {
            this.note = str;
            return this;
        }

        public Builder phoneNumber(String str) {
            this.phoneNumber = str;
            return this;
        }
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public String getNote() {
        return this.note;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNote(String str) {
        this.note = str;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    private VisitorInfo() {
    }

    private VisitorInfo(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.note = builder.note;
    }
}
