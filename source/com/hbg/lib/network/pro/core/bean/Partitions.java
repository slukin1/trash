package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;
import java.util.Objects;

public class Partitions implements Serializable {
    private static final long serialVersionUID = 902781204347033936L;

    /* renamed from: id  reason: collision with root package name */
    public Long f70614id;
    public String name;
    public String weight;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f70614id.equals(((Partitions) obj).f70614id);
    }

    public Long getId() {
        return this.f70614id;
    }

    public String getName() {
        return this.name;
    }

    public String getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f70614id});
    }

    public void setId(Long l11) {
        this.f70614id = l11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setWeight(String str) {
        this.weight = str;
    }

    public String toString() {
        return "Partitions(id=" + getId() + ", name=" + getName() + ", weight=" + getWeight() + ")";
    }
}
