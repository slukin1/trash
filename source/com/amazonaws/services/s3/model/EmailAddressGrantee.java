package com.amazonaws.services.s3.model;

public class EmailAddressGrantee implements Grantee {

    /* renamed from: b  reason: collision with root package name */
    public String f15217b = null;

    public EmailAddressGrantee(String str) {
        setIdentifier(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EmailAddressGrantee emailAddressGrantee = (EmailAddressGrantee) obj;
        String str = this.f15217b;
        if (str == null) {
            if (emailAddressGrantee.f15217b != null) {
                return false;
            }
        } else if (!str.equals(emailAddressGrantee.f15217b)) {
            return false;
        }
        return true;
    }

    public String getIdentifier() {
        return this.f15217b;
    }

    public String getTypeIdentifier() {
        return "emailAddress";
    }

    public int hashCode() {
        String str = this.f15217b;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public void setIdentifier(String str) {
        this.f15217b = str;
    }

    public String toString() {
        return this.f15217b;
    }
}
