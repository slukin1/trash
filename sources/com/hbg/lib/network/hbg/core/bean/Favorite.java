package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class Favorite implements Serializable {
    public String favSymbol;
    public String favType;

    public boolean canEqual(Object obj) {
        return obj instanceof Favorite;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Favorite)) {
            return false;
        }
        Favorite favorite = (Favorite) obj;
        if (!favorite.canEqual(this)) {
            return false;
        }
        String favSymbol2 = getFavSymbol();
        String favSymbol3 = favorite.getFavSymbol();
        if (favSymbol2 != null ? !favSymbol2.equals(favSymbol3) : favSymbol3 != null) {
            return false;
        }
        String favType2 = getFavType();
        String favType3 = favorite.getFavType();
        return favType2 != null ? favType2.equals(favType3) : favType3 == null;
    }

    public String getFavSymbol() {
        return this.favSymbol;
    }

    public String getFavType() {
        return this.favType;
    }

    public int hashCode() {
        String favSymbol2 = getFavSymbol();
        int i11 = 43;
        int hashCode = favSymbol2 == null ? 43 : favSymbol2.hashCode();
        String favType2 = getFavType();
        int i12 = (hashCode + 59) * 59;
        if (favType2 != null) {
            i11 = favType2.hashCode();
        }
        return i12 + i11;
    }

    public void setFavSymbol(String str) {
        this.favSymbol = str;
    }

    public void setFavType(String str) {
        this.favType = str;
    }

    public String toString() {
        return "Favorite(favSymbol=" + getFavSymbol() + ", favType=" + getFavType() + ")";
    }
}
