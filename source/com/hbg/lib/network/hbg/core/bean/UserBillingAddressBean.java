package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class UserBillingAddressBean implements Serializable {
    public String addressLine1;
    public String addressLine2;
    public long cardId;
    public String city;
    public String country;
    public String countryName;
    public String state;
    public String zip;

    public boolean canEqual(Object obj) {
        return obj instanceof UserBillingAddressBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserBillingAddressBean)) {
            return false;
        }
        UserBillingAddressBean userBillingAddressBean = (UserBillingAddressBean) obj;
        if (!userBillingAddressBean.canEqual(this) || getCardId() != userBillingAddressBean.getCardId()) {
            return false;
        }
        String addressLine12 = getAddressLine1();
        String addressLine13 = userBillingAddressBean.getAddressLine1();
        if (addressLine12 != null ? !addressLine12.equals(addressLine13) : addressLine13 != null) {
            return false;
        }
        String addressLine22 = getAddressLine2();
        String addressLine23 = userBillingAddressBean.getAddressLine2();
        if (addressLine22 != null ? !addressLine22.equals(addressLine23) : addressLine23 != null) {
            return false;
        }
        String city2 = getCity();
        String city3 = userBillingAddressBean.getCity();
        if (city2 != null ? !city2.equals(city3) : city3 != null) {
            return false;
        }
        String state2 = getState();
        String state3 = userBillingAddressBean.getState();
        if (state2 != null ? !state2.equals(state3) : state3 != null) {
            return false;
        }
        String zip2 = getZip();
        String zip3 = userBillingAddressBean.getZip();
        if (zip2 != null ? !zip2.equals(zip3) : zip3 != null) {
            return false;
        }
        String country2 = getCountry();
        String country3 = userBillingAddressBean.getCountry();
        if (country2 != null ? !country2.equals(country3) : country3 != null) {
            return false;
        }
        String countryName2 = getCountryName();
        String countryName3 = userBillingAddressBean.getCountryName();
        return countryName2 != null ? countryName2.equals(countryName3) : countryName3 == null;
    }

    public String getAddressLine1() {
        return this.addressLine1;
    }

    public String getAddressLine2() {
        return this.addressLine2;
    }

    public long getCardId() {
        return this.cardId;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public String getState() {
        return this.state;
    }

    public String getZip() {
        return this.zip;
    }

    public int hashCode() {
        long cardId2 = getCardId();
        String addressLine12 = getAddressLine1();
        int i11 = 43;
        int hashCode = ((((int) (cardId2 ^ (cardId2 >>> 32))) + 59) * 59) + (addressLine12 == null ? 43 : addressLine12.hashCode());
        String addressLine22 = getAddressLine2();
        int hashCode2 = (hashCode * 59) + (addressLine22 == null ? 43 : addressLine22.hashCode());
        String city2 = getCity();
        int hashCode3 = (hashCode2 * 59) + (city2 == null ? 43 : city2.hashCode());
        String state2 = getState();
        int hashCode4 = (hashCode3 * 59) + (state2 == null ? 43 : state2.hashCode());
        String zip2 = getZip();
        int hashCode5 = (hashCode4 * 59) + (zip2 == null ? 43 : zip2.hashCode());
        String country2 = getCountry();
        int hashCode6 = (hashCode5 * 59) + (country2 == null ? 43 : country2.hashCode());
        String countryName2 = getCountryName();
        int i12 = hashCode6 * 59;
        if (countryName2 != null) {
            i11 = countryName2.hashCode();
        }
        return i12 + i11;
    }

    public void setAddressLine1(String str) {
        this.addressLine1 = str;
    }

    public void setAddressLine2(String str) {
        this.addressLine2 = str;
    }

    public void setCardId(long j11) {
        this.cardId = j11;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCountryName(String str) {
        this.countryName = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setZip(String str) {
        this.zip = str;
    }

    public String toString() {
        return "UserBillingAddressBean(cardId=" + getCardId() + ", addressLine1=" + getAddressLine1() + ", addressLine2=" + getAddressLine2() + ", city=" + getCity() + ", state=" + getState() + ", zip=" + getZip() + ", country=" + getCountry() + ", countryName=" + getCountryName() + ")";
    }
}
