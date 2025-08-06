package com.alibaba.fastjson.parser;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.internal.AnalyticsEvents;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sns.internal.core.analytics.d;
import com.xiaomi.mipush.sdk.Constants;

public class JSONToken {
    public static String a(int i11) {
        switch (i11) {
            case 1:
                return "error";
            case 2:
                return "int";
            case 3:
                return "float";
            case 4:
                return "string";
            case 5:
                return "iso8601";
            case 6:
                return "true";
            case 7:
                return d.f31895b;
            case 8:
                return OptionsBridge.NULL_VALUE;
            case 9:
                return ChainInfo.CHAIN_TYPE_NEW;
            case 10:
                return "(";
            case 11:
                return ")";
            case 12:
                return "{";
            case 13:
                return "}";
            case 14:
                return "[";
            case 15:
                return "]";
            case 16:
                return Constants.ACCEPT_TIME_SEPARATOR_SP;
            case 17:
                return ":";
            case 18:
                return "ident";
            case 19:
                return "fieldName";
            case 20:
                return "EOF";
            case 21:
                return "Set";
            case 22:
                return "TreeSet";
            case 23:
                return "undefined";
            case 24:
                return ";";
            case 25:
                return InstructionFileId.DOT;
            case 26:
                return "hex";
            default:
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }
}
