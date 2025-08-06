package com.google.android.exoplayer2.text.ssa;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SsaStyle {
    public static final int SSA_ALIGNMENT_BOTTOM_CENTER = 2;
    public static final int SSA_ALIGNMENT_BOTTOM_LEFT = 1;
    public static final int SSA_ALIGNMENT_BOTTOM_RIGHT = 3;
    public static final int SSA_ALIGNMENT_MIDDLE_CENTER = 5;
    public static final int SSA_ALIGNMENT_MIDDLE_LEFT = 4;
    public static final int SSA_ALIGNMENT_MIDDLE_RIGHT = 6;
    public static final int SSA_ALIGNMENT_TOP_CENTER = 8;
    public static final int SSA_ALIGNMENT_TOP_LEFT = 7;
    public static final int SSA_ALIGNMENT_TOP_RIGHT = 9;
    public static final int SSA_ALIGNMENT_UNKNOWN = -1;
    private static final String TAG = "SsaStyle";
    public final int alignment;
    public final boolean bold;
    public final float fontSize;
    public final boolean italic;
    public final String name;
    public final Integer primaryColor;
    public final boolean strikeout;
    public final boolean underline;

    public static final class Format {
        public final int alignmentIndex;
        public final int boldIndex;
        public final int fontSizeIndex;
        public final int italicIndex;
        public final int length;
        public final int nameIndex;
        public final int primaryColorIndex;
        public final int strikeoutIndex;
        public final int underlineIndex;

        private Format(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
            this.nameIndex = i11;
            this.alignmentIndex = i12;
            this.primaryColorIndex = i13;
            this.fontSizeIndex = i14;
            this.boldIndex = i15;
            this.italicIndex = i16;
            this.underlineIndex = i17;
            this.strikeoutIndex = i18;
            this.length = i19;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.google.android.exoplayer2.text.ssa.SsaStyle.Format fromFormatLine(java.lang.String r14) {
            /*
                r0 = 7
                java.lang.String r14 = r14.substring(r0)
                java.lang.String r1 = ","
                java.lang.String[] r14 = android.text.TextUtils.split(r14, r1)
                r1 = 0
                r2 = -1
                r3 = r1
                r5 = r2
                r6 = r5
                r7 = r6
                r8 = r7
                r9 = r8
                r10 = r9
                r11 = r10
                r12 = r11
            L_0x0016:
                int r4 = r14.length
                if (r3 >= r4) goto L_0x00a0
                r4 = r14[r3]
                java.lang.String r4 = r4.trim()
                java.lang.String r4 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r4)
                r4.hashCode()
                int r13 = r4.hashCode()
                switch(r13) {
                    case -1178781136: goto L_0x007f;
                    case -1026963764: goto L_0x0073;
                    case -192095652: goto L_0x0067;
                    case -70925746: goto L_0x005c;
                    case 3029637: goto L_0x0051;
                    case 3373707: goto L_0x0046;
                    case 366554320: goto L_0x003b;
                    case 1767875043: goto L_0x0030;
                    default: goto L_0x002d;
                }
            L_0x002d:
                r4 = r2
                goto L_0x0089
            L_0x0030:
                java.lang.String r13 = "alignment"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x0039
                goto L_0x002d
            L_0x0039:
                r4 = r0
                goto L_0x0089
            L_0x003b:
                java.lang.String r13 = "fontsize"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x0044
                goto L_0x002d
            L_0x0044:
                r4 = 6
                goto L_0x0089
            L_0x0046:
                java.lang.String r13 = "name"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x004f
                goto L_0x002d
            L_0x004f:
                r4 = 5
                goto L_0x0089
            L_0x0051:
                java.lang.String r13 = "bold"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x005a
                goto L_0x002d
            L_0x005a:
                r4 = 4
                goto L_0x0089
            L_0x005c:
                java.lang.String r13 = "primarycolour"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x0065
                goto L_0x002d
            L_0x0065:
                r4 = 3
                goto L_0x0089
            L_0x0067:
                java.lang.String r13 = "strikeout"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x0071
                goto L_0x002d
            L_0x0071:
                r4 = 2
                goto L_0x0089
            L_0x0073:
                java.lang.String r13 = "underline"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x007d
                goto L_0x002d
            L_0x007d:
                r4 = 1
                goto L_0x0089
            L_0x007f:
                java.lang.String r13 = "italic"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x0088
                goto L_0x002d
            L_0x0088:
                r4 = r1
            L_0x0089:
                switch(r4) {
                    case 0: goto L_0x009b;
                    case 1: goto L_0x0099;
                    case 2: goto L_0x0097;
                    case 3: goto L_0x0095;
                    case 4: goto L_0x0093;
                    case 5: goto L_0x0091;
                    case 6: goto L_0x008f;
                    case 7: goto L_0x008d;
                    default: goto L_0x008c;
                }
            L_0x008c:
                goto L_0x009c
            L_0x008d:
                r6 = r3
                goto L_0x009c
            L_0x008f:
                r8 = r3
                goto L_0x009c
            L_0x0091:
                r5 = r3
                goto L_0x009c
            L_0x0093:
                r9 = r3
                goto L_0x009c
            L_0x0095:
                r7 = r3
                goto L_0x009c
            L_0x0097:
                r12 = r3
                goto L_0x009c
            L_0x0099:
                r11 = r3
                goto L_0x009c
            L_0x009b:
                r10 = r3
            L_0x009c:
                int r3 = r3 + 1
                goto L_0x0016
            L_0x00a0:
                if (r5 == r2) goto L_0x00aa
                com.google.android.exoplayer2.text.ssa.SsaStyle$Format r0 = new com.google.android.exoplayer2.text.ssa.SsaStyle$Format
                int r13 = r14.length
                r4 = r0
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)
                goto L_0x00ab
            L_0x00aa:
                r0 = 0
            L_0x00ab:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ssa.SsaStyle.Format.fromFormatLine(java.lang.String):com.google.android.exoplayer2.text.ssa.SsaStyle$Format");
        }
    }

    public static final class Overrides {
        private static final Pattern ALIGNMENT_OVERRIDE_PATTERN = Pattern.compile("\\\\an(\\d+)");
        private static final Pattern BRACES_PATTERN = Pattern.compile("\\{([^}]*)\\}");
        private static final Pattern MOVE_PATTERN = Pattern.compile(Util.formatInvariant("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", PADDED_DECIMAL_PATTERN));
        private static final String PADDED_DECIMAL_PATTERN = "\\s*\\d+(?:\\.\\d+)?\\s*";
        private static final Pattern POSITION_PATTERN = Pattern.compile(Util.formatInvariant("\\\\pos\\((%1$s),(%1$s)\\)", PADDED_DECIMAL_PATTERN));
        private static final String TAG = "SsaStyle.Overrides";
        public final int alignment;
        public final PointF position;

        private Overrides(int i11, PointF pointF) {
            this.alignment = i11;
            this.position = pointF;
        }

        private static int parseAlignmentOverride(String str) {
            Matcher matcher = ALIGNMENT_OVERRIDE_PATTERN.matcher(str);
            if (matcher.find()) {
                return SsaStyle.parseAlignment((String) Assertions.checkNotNull(matcher.group(1)));
            }
            return -1;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(9:4|5|6|(1:8)|9|10|(2:12|18)(1:17)|15|1) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0021 */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0009 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.google.android.exoplayer2.text.ssa.SsaStyle.Overrides parseFromDialogue(java.lang.String r5) {
            /*
                java.util.regex.Pattern r0 = BRACES_PATTERN
                java.util.regex.Matcher r5 = r0.matcher(r5)
                r0 = -1
                r1 = 0
                r2 = r0
            L_0x0009:
                boolean r3 = r5.find()
                if (r3 == 0) goto L_0x0029
                r3 = 1
                java.lang.String r3 = r5.group(r3)
                java.lang.Object r3 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r3)
                java.lang.String r3 = (java.lang.String) r3
                android.graphics.PointF r4 = parsePosition(r3)     // Catch:{ RuntimeException -> 0x0021 }
                if (r4 == 0) goto L_0x0021
                r1 = r4
            L_0x0021:
                int r3 = parseAlignmentOverride(r3)     // Catch:{ RuntimeException -> 0x0009 }
                if (r3 == r0) goto L_0x0009
                r2 = r3
                goto L_0x0009
            L_0x0029:
                com.google.android.exoplayer2.text.ssa.SsaStyle$Overrides r5 = new com.google.android.exoplayer2.text.ssa.SsaStyle$Overrides
                r5.<init>(r2, r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ssa.SsaStyle.Overrides.parseFromDialogue(java.lang.String):com.google.android.exoplayer2.text.ssa.SsaStyle$Overrides");
        }

        private static PointF parsePosition(String str) {
            String str2;
            String str3;
            Matcher matcher = POSITION_PATTERN.matcher(str);
            Matcher matcher2 = MOVE_PATTERN.matcher(str);
            boolean find = matcher.find();
            boolean find2 = matcher2.find();
            if (find) {
                if (find2) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 82);
                    sb2.append("Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='");
                    sb2.append(str);
                    sb2.append("'");
                    Log.i(TAG, sb2.toString());
                }
                str2 = matcher.group(1);
                str3 = matcher.group(2);
            } else if (!find2) {
                return null;
            } else {
                str2 = matcher2.group(1);
                str3 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) Assertions.checkNotNull(str2)).trim()), Float.parseFloat(((String) Assertions.checkNotNull(str3)).trim()));
        }

        public static String stripStyleOverrides(String str) {
            return BRACES_PATTERN.matcher(str).replaceAll("");
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SsaAlignment {
    }

    private SsaStyle(String str, int i11, Integer num, float f11, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.name = str;
        this.alignment = i11;
        this.primaryColor = num;
        this.fontSize = f11;
        this.bold = z11;
        this.italic = z12;
        this.underline = z13;
        this.strikeout = z14;
    }

    public static SsaStyle fromStyleLine(String str, Format format) {
        Assertions.checkArgument(str.startsWith(SsaDecoder.STYLE_LINE_PREFIX));
        String[] split = TextUtils.split(str.substring(6), Constants.ACCEPT_TIME_SEPARATOR_SP);
        int length = split.length;
        int i11 = format.length;
        boolean z11 = false;
        if (length != i11) {
            Log.w(TAG, Util.formatInvariant("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i11), Integer.valueOf(split.length), str));
            return null;
        }
        try {
            String trim = split[format.nameIndex].trim();
            int i12 = format.alignmentIndex;
            int parseAlignment = i12 != -1 ? parseAlignment(split[i12].trim()) : -1;
            int i13 = format.primaryColorIndex;
            Integer parseColor = i13 != -1 ? parseColor(split[i13].trim()) : null;
            int i14 = format.fontSizeIndex;
            float parseFontSize = i14 != -1 ? parseFontSize(split[i14].trim()) : -3.4028235E38f;
            int i15 = format.boldIndex;
            boolean parseBooleanValue = i15 != -1 ? parseBooleanValue(split[i15].trim()) : false;
            int i16 = format.italicIndex;
            boolean parseBooleanValue2 = i16 != -1 ? parseBooleanValue(split[i16].trim()) : false;
            int i17 = format.underlineIndex;
            boolean parseBooleanValue3 = i17 != -1 ? parseBooleanValue(split[i17].trim()) : false;
            int i18 = format.strikeoutIndex;
            if (i18 != -1) {
                z11 = parseBooleanValue(split[i18].trim());
            }
            return new SsaStyle(trim, parseAlignment, parseColor, parseFontSize, parseBooleanValue, parseBooleanValue2, parseBooleanValue3, z11);
        } catch (RuntimeException e11) {
            StringBuilder sb2 = new StringBuilder(str.length() + 36);
            sb2.append("Skipping malformed 'Style:' line: '");
            sb2.append(str);
            sb2.append("'");
            Log.w(TAG, sb2.toString(), e11);
            return null;
        }
    }

    private static boolean isValidAlignment(int i11) {
        switch (i11) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: private */
    public static int parseAlignment(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (isValidAlignment(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        String valueOf = String.valueOf(str);
        Log.w(TAG, valueOf.length() != 0 ? "Ignoring unknown alignment: ".concat(valueOf) : new String("Ignoring unknown alignment: "));
        return -1;
    }

    private static boolean parseBooleanValue(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt == 1 || parseInt == -1;
        } catch (NumberFormatException e11) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 33);
            sb2.append("Failed to parse boolean value: '");
            sb2.append(str);
            sb2.append("'");
            Log.w(TAG, sb2.toString(), e11);
            return false;
        }
    }

    public static Integer parseColor(String str) {
        long j11;
        try {
            if (str.startsWith("&H")) {
                j11 = Long.parseLong(str.substring(2), 16);
            } else {
                j11 = Long.parseLong(str);
            }
            Assertions.checkArgument(j11 <= 4294967295L);
            return Integer.valueOf(Color.argb(Ints.checkedCast(((j11 >> 24) & 255) ^ 255), Ints.checkedCast(j11 & 255), Ints.checkedCast((j11 >> 8) & 255), Ints.checkedCast((j11 >> 16) & 255)));
        } catch (IllegalArgumentException e11) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 36);
            sb2.append("Failed to parse color expression: '");
            sb2.append(str);
            sb2.append("'");
            Log.w(TAG, sb2.toString(), e11);
            return null;
        }
    }

    private static float parseFontSize(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e11) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 29);
            sb2.append("Failed to parse font size: '");
            sb2.append(str);
            sb2.append("'");
            Log.w(TAG, sb2.toString(), e11);
            return -3.4028235E38f;
        }
    }
}
