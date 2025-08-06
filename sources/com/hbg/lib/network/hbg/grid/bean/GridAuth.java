package com.hbg.lib.network.hbg.grid.bean;

import java.io.Serializable;

public class GridAuth implements Serializable {
    private static final long serialVersionUID = 5309549820300381597L;
    private int isAnswer;
    private int isNewUser;

    public boolean canEqual(Object obj) {
        return obj instanceof GridAuth;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridAuth)) {
            return false;
        }
        GridAuth gridAuth = (GridAuth) obj;
        return gridAuth.canEqual(this) && getIsAnswer() == gridAuth.getIsAnswer() && getIsNewUser() == gridAuth.getIsNewUser();
    }

    public int getIsAnswer() {
        return this.isAnswer;
    }

    public int getIsNewUser() {
        return this.isNewUser;
    }

    public int hashCode() {
        return ((getIsAnswer() + 59) * 59) + getIsNewUser();
    }

    public void setIsAnswer(int i11) {
        this.isAnswer = i11;
    }

    public void setIsNewUser(int i11) {
        this.isNewUser = i11;
    }

    public String toString() {
        return "GridAuth(isAnswer=" + getIsAnswer() + ", isNewUser=" + getIsNewUser() + ")";
    }
}
