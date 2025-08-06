package com.sensorsdata.analytics.android.sdk.plugin.encrypt;

public interface StorePlugin {
    Boolean getBool(String str);

    Float getFloat(String str);

    Integer getInteger(String str);

    Long getLong(String str);

    String getString(String str);

    boolean isExists(String str);

    void remove(String str);

    void setBool(String str, boolean z11);

    void setFloat(String str, float f11);

    void setInteger(String str, int i11);

    void setLong(String str, long j11);

    void setString(String str, String str2);

    String type();

    void upgrade(StorePlugin storePlugin);
}
