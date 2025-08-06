package com.huobi.account.entity;

import com.huobi.view.indexlist.IndexPartEntity;
import java.io.Serializable;

public class ChooseCityEntity implements IndexPartEntity, Serializable {

    /* renamed from: id  reason: collision with root package name */
    private long f40979id;
    private boolean isSelected;
    private String name;

    public ChooseCityEntity(long j11, String str) {
        this.f40979id = j11;
        this.name = str;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ChooseCityEntity;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChooseCityEntity)) {
            return false;
        }
        ChooseCityEntity chooseCityEntity = (ChooseCityEntity) obj;
        if (!chooseCityEntity.canEqual(this) || getId() != chooseCityEntity.getId()) {
            return false;
        }
        String name2 = getName();
        String name3 = chooseCityEntity.getName();
        if (name2 != null ? name2.equals(name3) : name3 == null) {
            return isSelected() == chooseCityEntity.isSelected();
        }
        return false;
    }

    public String getFieldIndexBy() {
        return this.name;
    }

    public long getId() {
        return this.f40979id;
    }

    public String getName() {
        return this.name;
    }

    public String getSearchKey() {
        return this.name;
    }

    public int hashCode() {
        long id2 = getId();
        String name2 = getName();
        return ((((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (name2 == null ? 43 : name2.hashCode())) * 59) + (isSelected() ? 79 : 97);
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setId(long j11) {
        this.f40979id = j11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public String toString() {
        return "ChooseCityEntity(id=" + getId() + ", name=" + getName() + ", isSelected=" + isSelected() + ")";
    }
}
