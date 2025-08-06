package com.huobi.trade.engine;

import com.amazonaws.services.s3.model.InstructionFileId;
import i6.d;
import java.util.List;
import sj.f;

public class TradeDataParser implements f {
    public static String b(String str, int i11, int i12) {
        d.b("lylTrade checkNumValid : num: " + str + " ,intPart: " + i11 + " ,floatPart:" + i12);
        if (str == null) {
            return null;
        }
        if (str.length() > str.trim().length()) {
            return str.trim();
        }
        if (str.trim().length() == 0) {
            return "";
        }
        if (str.startsWith("00")) {
            return str.substring(1);
        }
        int indexOf = str.indexOf(InstructionFileId.DOT);
        if (indexOf < 0) {
            indexOf = str.length();
        } else if (i12 == 0) {
            return str.substring(0, indexOf);
        }
        if (indexOf == 0) {
            return new StringBuilder(str).delete(indexOf, indexOf + 1).toString();
        }
        if (indexOf > i11) {
            return b(new StringBuilder(str).delete(i11, indexOf).toString(), i11, i12);
        }
        return (str.length() - indexOf) - 1 > i12 ? new StringBuilder(str).delete(indexOf + i12 + 1, str.length()).toString() : str;
    }

    public String a(List<String> list) {
        d.b("lylTrade parse : " + list);
        if (list.size() != 3) {
            return "";
        }
        try {
            return b(list.get(2), Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)));
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }
}
