package com.google.zxing.client.result;

import com.facebook.share.internal.ShareConstants;
import com.google.zxing.Result;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class VCardResultParser extends ResultParser {
    private static final Pattern BEGIN_VCARD = Pattern.compile("BEGIN:VCARD", 2);
    private static final Pattern COMMA = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);
    private static final Pattern CR_LF_SPACE_TAB = Pattern.compile("\r\n[ \t]");
    private static final Pattern EQUALS = Pattern.compile(ContainerUtils.KEY_VALUE_DELIMITER);
    private static final Pattern NEWLINE_ESCAPE = Pattern.compile("\\\\[nN]");
    private static final Pattern SEMICOLON = Pattern.compile(";");
    private static final Pattern SEMICOLON_OR_COMMA = Pattern.compile("[;,]");
    private static final Pattern UNESCAPED_SEMICOLONS = Pattern.compile("(?<!\\\\);+");
    private static final Pattern VCARD_ESCAPES = Pattern.compile("\\\\([,;\\\\])");
    private static final Pattern VCARD_LIKE_DATE = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    private static String decodeQuotedPrintable(CharSequence charSequence, String str) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i11 = 0;
        while (i11 < length) {
            char charAt2 = charSequence.charAt(i11);
            if (!(charAt2 == 10 || charAt2 == 13)) {
                if (charAt2 != '=') {
                    maybeAppendFragment(byteArrayOutputStream, str, sb2);
                    sb2.append(charAt2);
                } else if (!(i11 >= length - 2 || (charAt = charSequence.charAt(i11 + 1)) == 13 || charAt == 10)) {
                    i11 += 2;
                    char charAt3 = charSequence.charAt(i11);
                    int parseHexDigit = ResultParser.parseHexDigit(charAt);
                    int parseHexDigit2 = ResultParser.parseHexDigit(charAt3);
                    if (parseHexDigit >= 0 && parseHexDigit2 >= 0) {
                        byteArrayOutputStream.write((parseHexDigit << 4) + parseHexDigit2);
                    }
                }
            }
            i11++;
        }
        maybeAppendFragment(byteArrayOutputStream, str, sb2);
        return sb2.toString();
    }

    private static void formatNames(Iterable<List<String>> iterable) {
        int indexOf;
        if (iterable != null) {
            for (List next : iterable) {
                String str = (String) next.get(0);
                String[] strArr = new String[5];
                int i11 = 0;
                int i12 = 0;
                while (i11 < 4 && (indexOf = str.indexOf(59, i12)) >= 0) {
                    strArr[i11] = str.substring(i12, indexOf);
                    i11++;
                    i12 = indexOf + 1;
                }
                strArr[i11] = str.substring(i12);
                StringBuilder sb2 = new StringBuilder(100);
                maybeAppendComponent(strArr, 3, sb2);
                maybeAppendComponent(strArr, 1, sb2);
                maybeAppendComponent(strArr, 2, sb2);
                maybeAppendComponent(strArr, 0, sb2);
                maybeAppendComponent(strArr, 4, sb2);
                next.set(0, sb2.toString().trim());
            }
        }
    }

    private static boolean isLikeVCardDate(CharSequence charSequence) {
        return charSequence == null || VCARD_LIKE_DATE.matcher(charSequence).matches();
    }

    public static List<String> matchSingleVCardPrefixedField(CharSequence charSequence, String str, boolean z11, boolean z12) {
        List<List<String>> matchVCardPrefixedField = matchVCardPrefixedField(charSequence, str, z11, z12);
        if (matchVCardPrefixedField == null || matchVCardPrefixedField.isEmpty()) {
            return null;
        }
        return matchVCardPrefixedField.get(0);
    }

    public static List<List<String>> matchVCardPrefixedField(CharSequence charSequence, String str, boolean z11, boolean z12) {
        String str2;
        String str3;
        int i11;
        ArrayList arrayList;
        int indexOf;
        int i12;
        String str4;
        String str5 = str;
        int length = str.length();
        int i13 = 0;
        int i14 = 0;
        ArrayList arrayList2 = null;
        while (i14 < length) {
            int i15 = 2;
            Matcher matcher = Pattern.compile("(?:^|\n)" + charSequence + "(?:;([^:]*))?:", 2).matcher(str5);
            if (i14 > 0) {
                i14--;
            }
            if (!matcher.find(i14)) {
                break;
            }
            int end = matcher.end(i13);
            String group = matcher.group(1);
            if (group != null) {
                String[] split = SEMICOLON.split(group);
                int length2 = split.length;
                int i16 = i13;
                i11 = i16;
                arrayList = null;
                str3 = null;
                str2 = null;
                while (i16 < length2) {
                    String str6 = split[i16];
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(str6);
                    String[] split2 = EQUALS.split(str6, i15);
                    if (split2.length > 1) {
                        String str7 = split2[0];
                        String str8 = split2[1];
                        if ("ENCODING".equalsIgnoreCase(str7) && "QUOTED-PRINTABLE".equalsIgnoreCase(str8)) {
                            i11 = 1;
                        } else if ("CHARSET".equalsIgnoreCase(str7)) {
                            str3 = str8;
                        } else if ("VALUE".equalsIgnoreCase(str7)) {
                            str2 = str8;
                        }
                    }
                    i16++;
                    i15 = 2;
                }
            } else {
                arrayList = null;
                i11 = 0;
                str3 = null;
                str2 = null;
            }
            int i17 = end;
            while (true) {
                indexOf = str5.indexOf(10, i17);
                if (indexOf < 0) {
                    break;
                }
                if (indexOf < str.length() - 1) {
                    int i18 = indexOf + 1;
                    if (str5.charAt(i18) == ' ' || str5.charAt(i18) == 9) {
                        i17 = indexOf + 2;
                    }
                }
                if (i11 == 0) {
                    break;
                }
                if (indexOf <= 0 || str5.charAt(indexOf - 1) != '=') {
                    if (indexOf >= 2) {
                        if (str5.charAt(indexOf - 2) != '=') {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i17 = indexOf + 1;
            }
            if (indexOf < 0) {
                i14 = length;
                i13 = 0;
            } else {
                if (indexOf > end) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                    }
                    if (indexOf > 0 && str5.charAt(indexOf - 1) == 13) {
                        indexOf--;
                    }
                    String substring = str5.substring(end, indexOf);
                    if (z11) {
                        substring = substring.trim();
                    }
                    if (i11 != 0) {
                        str4 = decodeQuotedPrintable(substring, str3);
                        if (z12) {
                            str4 = UNESCAPED_SEMICOLONS.matcher(str4).replaceAll("\n").trim();
                        }
                    } else {
                        if (z12) {
                            substring = UNESCAPED_SEMICOLONS.matcher(substring).replaceAll("\n").trim();
                        }
                        str4 = VCARD_ESCAPES.matcher(NEWLINE_ESCAPE.matcher(CR_LF_SPACE_TAB.matcher(substring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                    }
                    if (ShareConstants.MEDIA_URI.equals(str2)) {
                        try {
                            str4 = URI.create(str4).getSchemeSpecificPart();
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    if (arrayList == null) {
                        ArrayList arrayList3 = new ArrayList(1);
                        arrayList3.add(str4);
                        arrayList2.add(arrayList3);
                    } else {
                        i12 = 0;
                        arrayList.add(0, str4);
                        arrayList2.add(arrayList);
                        i13 = i12;
                        i14 = indexOf + 1;
                    }
                }
                i12 = 0;
                i13 = i12;
                i14 = indexOf + 1;
            }
        }
        return arrayList2;
    }

    private static void maybeAppendComponent(String[] strArr, int i11, StringBuilder sb2) {
        if (strArr[i11] != null && !strArr[i11].isEmpty()) {
            if (sb2.length() > 0) {
                sb2.append(' ');
            }
            sb2.append(strArr[i11]);
        }
    }

    private static void maybeAppendFragment(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb2) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb2.append(str2);
        }
    }

    private static String toPrimaryValue(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static String[] toPrimaryValues(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = (String) list.get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] toTypes(Collection<List<String>> collection) {
        String str;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List next : collection) {
            String str2 = (String) next.get(0);
            if (str2 != null && !str2.isEmpty()) {
                int i11 = 1;
                while (true) {
                    if (i11 >= next.size()) {
                        str = null;
                        break;
                    }
                    str = (String) next.get(i11);
                    int indexOf = str.indexOf(61);
                    if (indexOf < 0) {
                        break;
                    } else if ("TYPE".equalsIgnoreCase(str.substring(0, indexOf))) {
                        str = str.substring(indexOf + 1);
                        break;
                    } else {
                        i11++;
                    }
                }
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public AddressBookParsedResult parse(Result result) {
        String[] strArr;
        String[] strArr2;
        String massagedText = ResultParser.getMassagedText(result);
        Matcher matcher = BEGIN_VCARD.matcher(massagedText);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> matchVCardPrefixedField = matchVCardPrefixedField("FN", massagedText, true, false);
        if (matchVCardPrefixedField == null) {
            matchVCardPrefixedField = matchVCardPrefixedField(KvStore.N, massagedText, true, false);
            formatNames(matchVCardPrefixedField);
        }
        List<String> matchSingleVCardPrefixedField = matchSingleVCardPrefixedField("NICKNAME", massagedText, true, false);
        if (matchSingleVCardPrefixedField == null) {
            strArr = null;
        } else {
            strArr = COMMA.split(matchSingleVCardPrefixedField.get(0));
        }
        List<List<String>> matchVCardPrefixedField2 = matchVCardPrefixedField("TEL", massagedText, true, false);
        List<List<String>> matchVCardPrefixedField3 = matchVCardPrefixedField("EMAIL", massagedText, true, false);
        List<String> matchSingleVCardPrefixedField2 = matchSingleVCardPrefixedField("NOTE", massagedText, false, false);
        List<List<String>> matchVCardPrefixedField4 = matchVCardPrefixedField("ADR", massagedText, true, true);
        List<String> matchSingleVCardPrefixedField3 = matchSingleVCardPrefixedField("ORG", massagedText, true, true);
        List<String> matchSingleVCardPrefixedField4 = matchSingleVCardPrefixedField("BDAY", massagedText, true, false);
        List<String> list = (matchSingleVCardPrefixedField4 == null || isLikeVCardDate(matchSingleVCardPrefixedField4.get(0))) ? matchSingleVCardPrefixedField4 : null;
        List<String> matchSingleVCardPrefixedField5 = matchSingleVCardPrefixedField(ShareConstants.TITLE, massagedText, true, false);
        List<List<String>> matchVCardPrefixedField5 = matchVCardPrefixedField("URL", massagedText, true, false);
        List<String> matchSingleVCardPrefixedField6 = matchSingleVCardPrefixedField("IMPP", massagedText, true, false);
        List<String> matchSingleVCardPrefixedField7 = matchSingleVCardPrefixedField("GEO", massagedText, true, false);
        if (matchSingleVCardPrefixedField7 == null) {
            strArr2 = null;
        } else {
            strArr2 = SEMICOLON_OR_COMMA.split(matchSingleVCardPrefixedField7.get(0));
        }
        return new AddressBookParsedResult(toPrimaryValues(matchVCardPrefixedField), strArr, (String) null, toPrimaryValues(matchVCardPrefixedField2), toTypes(matchVCardPrefixedField2), toPrimaryValues(matchVCardPrefixedField3), toTypes(matchVCardPrefixedField3), toPrimaryValue(matchSingleVCardPrefixedField6), toPrimaryValue(matchSingleVCardPrefixedField2), toPrimaryValues(matchVCardPrefixedField4), toTypes(matchVCardPrefixedField4), toPrimaryValue(matchSingleVCardPrefixedField3), toPrimaryValue(list), toPrimaryValue(matchSingleVCardPrefixedField5), toPrimaryValues(matchVCardPrefixedField5), (strArr2 == null || strArr2.length == 2) ? strArr2 : null);
    }
}
