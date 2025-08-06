package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class RankJumpTitle implements Serializable {
    private String name;
    private int sort;
    private int sortType;

    public boolean canEqual(Object obj) {
        return obj instanceof RankJumpTitle;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RankJumpTitle)) {
            return false;
        }
        RankJumpTitle rankJumpTitle = (RankJumpTitle) obj;
        if (!rankJumpTitle.canEqual(this) || getSortType() != rankJumpTitle.getSortType() || getSort() != rankJumpTitle.getSort()) {
            return false;
        }
        String name2 = getName();
        String name3 = rankJumpTitle.getName();
        return name2 != null ? name2.equals(name3) : name3 == null;
    }

    public String getName() {
        return this.name;
    }

    public int getSort() {
        return this.sort;
    }

    public int getSortType() {
        return this.sortType;
    }

    public int hashCode() {
        int sortType2 = ((getSortType() + 59) * 59) + getSort();
        String name2 = getName();
        return (sortType2 * 59) + (name2 == null ? 43 : name2.hashCode());
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSort(int i11) {
        this.sort = i11;
    }

    public void setSortType(int i11) {
        this.sortType = i11;
    }

    public String toString() {
        return "RankJumpTitle(sortType=" + getSortType() + ", sort=" + getSort() + ", name=" + getName() + ")";
    }
}
