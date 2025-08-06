package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;

public class ProjectItem implements Serializable {
    private String farmingCost;
    private String farmingIncome;
    private String icon;
    private String name;

    public boolean canEqual(Object obj) {
        return obj instanceof ProjectItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProjectItem)) {
            return false;
        }
        ProjectItem projectItem = (ProjectItem) obj;
        if (!projectItem.canEqual(this)) {
            return false;
        }
        String farmingIncome2 = getFarmingIncome();
        String farmingIncome3 = projectItem.getFarmingIncome();
        if (farmingIncome2 != null ? !farmingIncome2.equals(farmingIncome3) : farmingIncome3 != null) {
            return false;
        }
        String farmingCost2 = getFarmingCost();
        String farmingCost3 = projectItem.getFarmingCost();
        if (farmingCost2 != null ? !farmingCost2.equals(farmingCost3) : farmingCost3 != null) {
            return false;
        }
        String name2 = getName();
        String name3 = projectItem.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String icon2 = getIcon();
        String icon3 = projectItem.getIcon();
        return icon2 != null ? icon2.equals(icon3) : icon3 == null;
    }

    public String getFarmingCost() {
        return this.farmingCost;
    }

    public String getFarmingIncome() {
        return this.farmingIncome;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String farmingIncome2 = getFarmingIncome();
        int i11 = 43;
        int hashCode = farmingIncome2 == null ? 43 : farmingIncome2.hashCode();
        String farmingCost2 = getFarmingCost();
        int hashCode2 = ((hashCode + 59) * 59) + (farmingCost2 == null ? 43 : farmingCost2.hashCode());
        String name2 = getName();
        int hashCode3 = (hashCode2 * 59) + (name2 == null ? 43 : name2.hashCode());
        String icon2 = getIcon();
        int i12 = hashCode3 * 59;
        if (icon2 != null) {
            i11 = icon2.hashCode();
        }
        return i12 + i11;
    }

    public void setFarmingCost(String str) {
        this.farmingCost = str;
    }

    public void setFarmingIncome(String str) {
        this.farmingIncome = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "ProjectItem(farmingIncome=" + getFarmingIncome() + ", farmingCost=" + getFarmingCost() + ", name=" + getName() + ", icon=" + getIcon() + ")";
    }
}
