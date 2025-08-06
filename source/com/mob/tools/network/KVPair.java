package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;

public class KVPair<T> implements PublicMemberKeeper {
    public final String name;
    public final T value;

    public KVPair(String str, T t11) {
        this.name = str;
        this.value = t11;
    }

    public String toString() {
        return this.name + " = " + this.value;
    }
}
