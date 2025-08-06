package com.google.zxing.client.android.encode;

import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.regex.Pattern;

final class MECARDContactEncoder extends ContactEncoder {
    private static final char TERMINATOR = ';';

    public static class MECARDFieldFormatter implements Formatter {
        private static final Pattern NEWLINE = Pattern.compile("\\n");
        private static final Pattern RESERVED_MECARD_CHARS = Pattern.compile("([\\\\:;])");

        private MECARDFieldFormatter() {
        }

        public CharSequence format(CharSequence charSequence, int i11) {
            return ':' + NEWLINE.matcher(RESERVED_MECARD_CHARS.matcher(charSequence).replaceAll("\\\\$1")).replaceAll("");
        }
    }

    public static class MECARDNameDisplayFormatter implements Formatter {
        private static final Pattern COMMA = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

        private MECARDNameDisplayFormatter() {
        }

        public CharSequence format(CharSequence charSequence, int i11) {
            return COMMA.matcher(charSequence).replaceAll("");
        }
    }

    public static class MECARDTelDisplayFormatter implements Formatter {
        private static final Pattern NOT_DIGITS_OR_PLUS = Pattern.compile("[^0-9+]+");

        private MECARDTelDisplayFormatter() {
        }

        public CharSequence format(CharSequence charSequence, int i11) {
            return NOT_DIGITS_OR_PLUS.matcher(ContactEncoder.formatPhone(charSequence.toString())).replaceAll("");
        }
    }

    public String[] encode(List<String> list, String str, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, String str2) {
        StringBuilder sb2 = new StringBuilder(100);
        sb2.append("MECARD:");
        StringBuilder sb3 = new StringBuilder(100);
        MECARDFieldFormatter mECARDFieldFormatter = new MECARDFieldFormatter();
        StringBuilder sb4 = sb2;
        StringBuilder sb5 = sb3;
        MECARDFieldFormatter mECARDFieldFormatter2 = mECARDFieldFormatter;
        ContactEncoder.appendUpToUnique(sb4, sb5, KvStore.N, list, 1, new MECARDNameDisplayFormatter(), mECARDFieldFormatter2, TERMINATOR);
        ContactEncoder.append(sb4, sb5, "ORG", str, mECARDFieldFormatter, TERMINATOR);
        ContactEncoder.appendUpToUnique(sb4, sb5, "ADR", list2, 1, (Formatter) null, mECARDFieldFormatter2, TERMINATOR);
        ContactEncoder.appendUpToUnique(sb4, sb5, "TEL", list3, Integer.MAX_VALUE, new MECARDTelDisplayFormatter(), mECARDFieldFormatter2, TERMINATOR);
        ContactEncoder.appendUpToUnique(sb4, sb5, "EMAIL", list5, Integer.MAX_VALUE, (Formatter) null, mECARDFieldFormatter2, TERMINATOR);
        ContactEncoder.appendUpToUnique(sb4, sb5, "URL", list6, Integer.MAX_VALUE, (Formatter) null, mECARDFieldFormatter2, TERMINATOR);
        ContactEncoder.append(sb2, sb3, "NOTE", str2, mECARDFieldFormatter, TERMINATOR);
        sb2.append(TERMINATOR);
        return new String[]{sb2.toString(), sb3.toString()};
    }
}
