package com.google.zxing.client.result;

abstract class AbstractDoCoMoResultParser extends ResultParser {
    public static String[] matchDoCoMoPrefixedField(String str, String str2, boolean z11) {
        return ResultParser.matchPrefixedField(str, str2, ';', z11);
    }

    public static String matchSingleDoCoMoPrefixedField(String str, String str2, boolean z11) {
        return ResultParser.matchSinglePrefixedField(str, str2, ';', z11);
    }
}
