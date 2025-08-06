package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Entity implements Serializable {
    private static final int END_INDEX = 1;
    private static final int START_INDEX = 0;
    @SerializedName("indices")
    public final List<Integer> indices;

    public Entity(int i11, int i12) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(0, Integer.valueOf(i11));
        arrayList.add(1, Integer.valueOf(i12));
        this.indices = Collections.unmodifiableList(arrayList);
    }

    public int getEnd() {
        return this.indices.get(1).intValue();
    }

    public int getStart() {
        return this.indices.get(0).intValue();
    }
}
