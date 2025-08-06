package com.facebook.places.model;

import java.util.HashSet;
import java.util.Set;

public final class PlaceInfoRequestParams {
    private final Set<String> fields;
    private final String placeId;

    public static class Builder {
        /* access modifiers changed from: private */
        public final Set<String> fields = new HashSet();
        /* access modifiers changed from: private */
        public String placeId;

        public Builder addField(String str) {
            this.fields.add(str);
            return this;
        }

        public Builder addFields(String[] strArr) {
            for (String add : strArr) {
                this.fields.add(add);
            }
            return this;
        }

        public PlaceInfoRequestParams build() {
            return new PlaceInfoRequestParams(this);
        }

        public Builder setPlaceId(String str) {
            this.placeId = str;
            return this;
        }
    }

    public Set<String> getFields() {
        return this.fields;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    private PlaceInfoRequestParams(Builder builder) {
        HashSet hashSet = new HashSet();
        this.fields = hashSet;
        this.placeId = builder.placeId;
        hashSet.addAll(builder.fields);
    }
}
