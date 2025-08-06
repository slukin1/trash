package com.google.zxing.client.android.encode;

import com.huobi.login.usercenter.data.source.bean.KvStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class VCardContactEncoder extends ContactEncoder {
    private static final char TERMINATOR = '\n';

    private static List<Map<String, Set<String>>> buildPhoneMetadata(Collection<String> collection, List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < collection.size(); i11++) {
            if (list.size() <= i11) {
                arrayList.add((Object) null);
            } else {
                HashMap hashMap = new HashMap();
                arrayList.add(hashMap);
                HashSet hashSet = new HashSet();
                hashMap.put("TYPE", hashSet);
                String str = list.get(i11);
                Integer maybeIntValue = maybeIntValue(str);
                if (maybeIntValue == null) {
                    hashSet.add(str);
                } else {
                    String vCardPurposeLabelForAndroidType = vCardPurposeLabelForAndroidType(maybeIntValue.intValue());
                    String vCardContextLabelForAndroidType = vCardContextLabelForAndroidType(maybeIntValue.intValue());
                    if (vCardPurposeLabelForAndroidType != null) {
                        hashSet.add(vCardPurposeLabelForAndroidType);
                    }
                    if (vCardContextLabelForAndroidType != null) {
                        hashSet.add(vCardContextLabelForAndroidType);
                    }
                }
            }
        }
        return arrayList;
    }

    private static Integer maybeIntValue(String str) {
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static String vCardContextLabelForAndroidType(int i11) {
        if (i11 == 10 || i11 == 17 || i11 == 18) {
            return "work";
        }
        switch (i11) {
            case 1:
            case 2:
            case 5:
            case 6:
                return "home";
            case 3:
            case 4:
                return "work";
            default:
                return null;
        }
    }

    private static String vCardPurposeLabelForAndroidType(int i11) {
        if (i11 == 4 || i11 == 5) {
            return "fax";
        }
        if (i11 == 6) {
            return "pager";
        }
        if (i11 == 13) {
            return "fax";
        }
        if (i11 == 16) {
            return "textphone";
        }
        if (i11 == 18) {
            return "pager";
        }
        if (i11 != 20) {
            return null;
        }
        return "text";
    }

    public String[] encode(List<String> list, String str, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, String str2) {
        StringBuilder sb2 = new StringBuilder(100);
        sb2.append("BEGIN:VCARD");
        sb2.append(TERMINATOR);
        sb2.append("VERSION:3.0");
        sb2.append(TERMINATOR);
        StringBuilder sb3 = new StringBuilder(100);
        VCardFieldFormatter vCardFieldFormatter = new VCardFieldFormatter();
        StringBuilder sb4 = sb2;
        StringBuilder sb5 = sb3;
        VCardFieldFormatter vCardFieldFormatter2 = vCardFieldFormatter;
        ContactEncoder.appendUpToUnique(sb4, sb5, KvStore.N, list, 1, (Formatter) null, vCardFieldFormatter2, TERMINATOR);
        ContactEncoder.append(sb4, sb5, "ORG", str, vCardFieldFormatter, TERMINATOR);
        ContactEncoder.appendUpToUnique(sb4, sb5, "ADR", list2, 1, (Formatter) null, vCardFieldFormatter2, TERMINATOR);
        List<Map<String, Set<String>>> buildPhoneMetadata = buildPhoneMetadata(list3, list4);
        VCardTelDisplayFormatter vCardTelDisplayFormatter = new VCardTelDisplayFormatter(buildPhoneMetadata);
        VCardFieldFormatter vCardFieldFormatter3 = new VCardFieldFormatter(buildPhoneMetadata);
        StringBuilder sb6 = sb2;
        ContactEncoder.appendUpToUnique(sb6, sb5, "TEL", list3, Integer.MAX_VALUE, vCardTelDisplayFormatter, vCardFieldFormatter3, TERMINATOR);
        VCardFieldFormatter vCardFieldFormatter4 = vCardFieldFormatter;
        ContactEncoder.appendUpToUnique(sb6, sb5, "EMAIL", list5, Integer.MAX_VALUE, (Formatter) null, vCardFieldFormatter4, TERMINATOR);
        ContactEncoder.appendUpToUnique(sb6, sb5, "URL", list6, Integer.MAX_VALUE, (Formatter) null, vCardFieldFormatter4, TERMINATOR);
        ContactEncoder.append(sb2, sb3, "NOTE", str2, vCardFieldFormatter, TERMINATOR);
        sb2.append("END:VCARD");
        sb2.append(TERMINATOR);
        return new String[]{sb2.toString(), sb3.toString()};
    }
}
