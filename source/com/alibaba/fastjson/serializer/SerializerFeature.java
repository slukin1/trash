package com.alibaba.fastjson.serializer;

public enum SerializerFeature {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    WriteEnumUsingName,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue,
    BrowserSecure,
    IgnoreNonFieldGetter,
    WriteNonStringValueAsString,
    IgnoreErrorGetter,
    WriteBigDecimalAsPlain,
    MapSortField;
    
    public static final SerializerFeature[] EMPTY = null;
    public static final int WRITE_MAP_NULL_FEATURES = 0;
    public final int mask;

    /* access modifiers changed from: public */
    static {
        SerializerFeature serializerFeature;
        SerializerFeature serializerFeature2;
        SerializerFeature serializerFeature3;
        SerializerFeature serializerFeature4;
        SerializerFeature serializerFeature5;
        EMPTY = new SerializerFeature[0];
        WRITE_MAP_NULL_FEATURES = serializerFeature.getMask() | serializerFeature5.getMask() | serializerFeature2.getMask() | serializerFeature4.getMask() | serializerFeature3.getMask();
    }

    public static int config(int i11, SerializerFeature serializerFeature, boolean z11) {
        if (z11) {
            return i11 | serializerFeature.mask;
        }
        return i11 & (~serializerFeature.mask);
    }

    public static boolean isEnabled(int i11, SerializerFeature serializerFeature) {
        return (i11 & serializerFeature.mask) != 0;
    }

    public static int of(SerializerFeature[] serializerFeatureArr) {
        if (serializerFeatureArr == null) {
            return 0;
        }
        int i11 = 0;
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i11 |= serializerFeature.mask;
        }
        return i11;
    }

    public final int getMask() {
        return this.mask;
    }

    public static boolean isEnabled(int i11, int i12, SerializerFeature serializerFeature) {
        int i13 = serializerFeature.mask;
        return ((i11 & i13) == 0 && (i12 & i13) == 0) ? false : true;
    }
}
