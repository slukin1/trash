package com.alibaba.fastjson.parser;

public enum Feature {
    AutoCloseSource,
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty,
    SupportArrayToBean,
    OrderedField,
    DisableSpecialKeyDetect,
    UseObjectArray,
    SupportNonPublicField,
    IgnoreAutoType,
    DisableFieldSmartMatch;
    
    public final int mask;

    public static int config(int i11, Feature feature, boolean z11) {
        if (z11) {
            return i11 | feature.mask;
        }
        return i11 & (~feature.mask);
    }

    public static boolean isEnabled(int i11, Feature feature) {
        return (i11 & feature.mask) != 0;
    }

    public static int of(Feature[] featureArr) {
        if (featureArr == null) {
            return 0;
        }
        int i11 = 0;
        for (Feature feature : featureArr) {
            i11 |= feature.mask;
        }
        return i11;
    }

    public final int getMask() {
        return this.mask;
    }
}
