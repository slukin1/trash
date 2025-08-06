package i6;

import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.xiaomi.mipush.sdk.Constants;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final BigDecimal f68179a;

    /* renamed from: b  reason: collision with root package name */
    public static NumberFormat f68180b = NumberFormat.getNumberInstance(Locale.CHINA);

    /* renamed from: c  reason: collision with root package name */
    public static NumberFormat f68181c = NumberFormat.getNumberInstance(Locale.CHINA);

    /* renamed from: d  reason: collision with root package name */
    public static final NumberFormat f68182d = NumberFormat.getNumberInstance(Locale.CHINA);

    static {
        BigDecimal bigDecimal = BigDecimal.TEN;
        f68179a = bigDecimal.multiply(bigDecimal);
    }

    public static String A(String str, int i11, boolean z11, String str2) {
        try {
            return B(new BigDecimal(str), i11, z11, str2);
        } catch (Exception unused) {
            return B(BigDecimal.ZERO, i11, z11, str2);
        }
    }

    public static synchronized String B(BigDecimal bigDecimal, int i11, boolean z11, String str) {
        String format;
        synchronized (m.class) {
            if (i11 != Integer.MIN_VALUE) {
                try {
                    f68180b.setMinimumFractionDigits(i11);
                } catch (Exception unused) {
                    return str;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (i11 != Integer.MIN_VALUE) {
                f68180b.setMaximumFractionDigits(i11);
            }
            f68180b.setRoundingMode(RoundingMode.HALF_UP);
            f68180b.setGroupingUsed(z11);
            format = f68180b.format(bigDecimal);
        }
        return format;
    }

    public static String C(double d11, int i11) {
        return D(d11, i11, false);
    }

    public static String D(double d11, int i11, boolean z11) {
        return E(d11, i11, z11, "");
    }

    public static String E(double d11, int i11, boolean z11, String str) {
        return H(String.valueOf(d11), i11, z11, str);
    }

    public static String F(String str, int i11) {
        return G(str, i11, false);
    }

    public static String G(String str, int i11, boolean z11) {
        return H(str, i11, z11, "");
    }

    public static String H(String str, int i11, boolean z11, String str2) {
        try {
            return K(new BigDecimal(str), i11, z11, str2);
        } catch (Exception unused) {
            return K(BigDecimal.ZERO, i11, z11, str2);
        }
    }

    public static String I(BigDecimal bigDecimal, int i11) {
        return J(bigDecimal, i11, false);
    }

    public static String J(BigDecimal bigDecimal, int i11, boolean z11) {
        return K(bigDecimal, i11, z11, "");
    }

    public static synchronized String K(BigDecimal bigDecimal, int i11, boolean z11, String str) {
        String format;
        synchronized (m.class) {
            if (i11 != Integer.MIN_VALUE) {
                try {
                    f68180b.setMinimumFractionDigits(i11);
                } catch (Exception unused) {
                    return str;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (i11 != Integer.MIN_VALUE) {
                f68180b.setMaximumFractionDigits(i11);
            }
            f68180b.setRoundingMode(RoundingMode.UP);
            f68180b.setGroupingUsed(z11);
            format = f68180b.format(bigDecimal);
        }
        return format;
    }

    public static String L(String str, int i11) {
        String G = G(str, i11, false);
        return a0(G) ? new BigDecimal(G).stripTrailingZeros().toPlainString() : G;
    }

    public static String M(double d11, int i11) {
        String q11 = q(BigDecimal.valueOf(d11).multiply(f68179a), i11);
        return q11 + "%";
    }

    @Deprecated
    public static String N(String str, int i11, int i12) {
        String plainString = a(str).multiply(f68179a).setScale(i11, i12).toPlainString();
        return plainString + "%";
    }

    public static String O(BigDecimal bigDecimal, int i11, int i12) {
        String plainString = bigDecimal.multiply(f68179a).setScale(i11, i12).toPlainString();
        return plainString + "%";
    }

    public static String P(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            bigDecimal = BigDecimal.ZERO;
        }
        String plainString = bigDecimal.multiply(f68179a).stripTrailingZeros().toPlainString();
        return plainString + "%";
    }

    public static String Q(String str, int i11, int i12) {
        String str2;
        BigDecimal a11 = a(str);
        BigDecimal scale = a11.multiply(f68179a).setScale(i11, i12);
        if (scale.signum() == 0 || scale.signum() == -1 || a11.signum() != -1) {
            str2 = scale.toPlainString();
        } else {
            str2 = Constants.ACCEPT_TIME_SEPARATOR_SERVER + scale.toPlainString();
        }
        return str2 + "%";
    }

    public static String R(String str, int i11, int i12, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return Q(str, i11, i12);
    }

    public static String S(double d11, int i11) {
        String str = d11 > 0.0d ? "+" : "";
        String q11 = q(BigDecimal.valueOf(d11).multiply(f68179a), i11);
        return str + q11 + "%";
    }

    public static String T(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(str);
            if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                return "0";
            }
            if (bigDecimal.compareTo(f68179a) < 0) {
                return bigDecimal.setScale(i11, 1).stripTrailingZeros().toPlainString();
            }
            if (bigDecimal.compareTo(new BigDecimal(10000)) < 0) {
                if (i11 > 2) {
                    return bigDecimal.setScale(2, 1).stripTrailingZeros().toPlainString();
                }
                return bigDecimal.setScale(i11, 1).stripTrailingZeros().toPlainString();
            } else if (bigDecimal.compareTo(new BigDecimal(1000000)) < 0) {
                return bigDecimal.divide(new BigDecimal(1000)).setScale(2, 1).stripTrailingZeros().toPlainString() + "K";
            } else if (bigDecimal.compareTo(new BigDecimal(1000000000)) < 0) {
                return bigDecimal.divide(new BigDecimal(1000000)).setScale(2, 1).stripTrailingZeros().toPlainString() + "M";
            } else {
                return bigDecimal.divide(new BigDecimal(1000000000)).setScale(2, 1).stripTrailingZeros().toPlainString() + "B";
            }
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r2 = new java.math.BigDecimal(r2).toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int U(java.lang.String r2) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            r1 = -1
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r2)
            java.lang.String r2 = r0.toString()
            r0 = 46
            int r0 = r2.indexOf(r0)
            if (r0 <= 0) goto L_0x0021
            int r2 = r2.length()
            int r2 = r2 + -1
            int r1 = r2 - r0
        L_0x0021:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.m.U(java.lang.String):int");
    }

    public static String V(String str, int i11) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(InstructionFileId.DOT);
        if (indexOf == -1) {
            return str;
        }
        int i12 = indexOf + i11 + 1;
        if (i12 > str.length()) {
            i12 = str.length();
        }
        return str.substring(0, i12);
    }

    public static String W(String str, String str2, boolean z11) {
        StringBuilder sb2;
        if (!a0(str)) {
            return str;
        }
        boolean z12 = a(str).compareTo(BigDecimal.ZERO) > 0;
        String str3 = z12 ? "+" : Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        if (z11) {
            sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(str3);
        } else {
            sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(str2);
        }
        String sb3 = sb2.toString();
        if (z12) {
            return sb3 + str;
        }
        return sb3 + a(str).abs().toPlainString();
    }

    public static String X(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        BigDecimal bigDecimal = new BigDecimal(str);
        if (bigDecimal.compareTo(new BigDecimal("1000000000")) >= 0) {
            BigDecimal divide = bigDecimal.divide(new BigDecimal(1000000000));
            String plainString = divide.toPlainString();
            if (plainString.length() <= 5) {
                return divide.toPlainString() + "B";
            } else if (plainString.substring(0, 5).endsWith(InstructionFileId.DOT)) {
                return plainString.substring(0, 4) + "B";
            } else {
                return plainString.substring(0, 5) + "B";
            }
        } else if (bigDecimal.compareTo(new BigDecimal("1000000")) >= 0 && bigDecimal.compareTo(new BigDecimal("1000000000")) < 0) {
            BigDecimal divide2 = bigDecimal.divide(new BigDecimal(1000000));
            String plainString2 = divide2.toPlainString();
            if (plainString2.length() <= 5) {
                return divide2.toPlainString() + "M";
            } else if (plainString2.substring(0, 5).endsWith(InstructionFileId.DOT)) {
                return plainString2.substring(0, 4) + "M";
            } else {
                return plainString2.substring(0, 5) + "M";
            }
        } else if (bigDecimal.compareTo(new BigDecimal("1000")) >= 0 && bigDecimal.compareTo(new BigDecimal("1000000")) < 0) {
            BigDecimal divide3 = bigDecimal.divide(new BigDecimal(1000));
            String plainString3 = divide3.toPlainString();
            if (plainString3.length() <= 5) {
                return divide3.toPlainString() + "K";
            } else if (plainString3.substring(0, 5).endsWith(InstructionFileId.DOT)) {
                return plainString3.substring(0, 4) + "K";
            } else {
                return plainString3.substring(0, 5) + "K";
            }
        } else if (bigDecimal.compareTo(new BigDecimal("1000")) >= 0 || bigDecimal.compareTo(BigDecimal.ONE) < 0) {
            String plainString4 = bigDecimal.toPlainString();
            return plainString4.length() > 6 ? plainString4.substring(0, 6) : plainString4;
        } else {
            String plainString5 = bigDecimal.toPlainString();
            if (plainString5.length() > 6) {
                return plainString5.substring(0, 6);
            }
            return plainString5;
        }
    }

    public static boolean Y(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (!Character.isDigit(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public static boolean Z(String str) {
        if (str == null || "".equals(str.trim())) {
            return false;
        }
        return str.matches("^[1-9]\\d*$");
    }

    public static BigDecimal a(String str) {
        if (TextUtils.isEmpty(str)) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(str);
        } catch (Exception unused) {
            return BigDecimal.ZERO;
        }
    }

    public static boolean a0(String str) {
        if (str == null || "".equals(str.trim())) {
            return false;
        }
        return str.matches("^(-?\\d+)(\\.\\d+)?$");
    }

    public static String b(Editable editable, int i11, int i12) {
        if (editable == null) {
            return null;
        }
        if (editable.length() > editable.toString().trim().length()) {
            return editable.toString().trim();
        }
        if (editable.toString().trim().length() == 0) {
            return null;
        }
        int indexOf = editable.toString().indexOf(InstructionFileId.DOT);
        if (indexOf < 0) {
            indexOf = editable.length();
        }
        if (indexOf == 0) {
            return editable.delete(indexOf, indexOf + 1).toString();
        }
        if (indexOf > i11) {
            return editable.delete(indexOf - 1, indexOf).toString();
        }
        if ((editable.length() - indexOf) - 1 <= i12) {
            return null;
        }
        int i13 = indexOf + i12;
        return editable.delete(i13 + 1, i13 + 2).toString();
    }

    public static boolean b0(String str) {
        return c0(a(str));
    }

    public static String c(String str, String str2) {
        if (str != null && str.startsWith("0.")) {
            return str;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return d(str, str2);
        }
        try {
            f68181c.setGroupingUsed(true);
            int indexOf = str.indexOf(InstructionFileId.DOT);
            if (indexOf != -1) {
                int length = str.substring(indexOf).length() - 1;
                if (length != Integer.MIN_VALUE) {
                    f68181c.setMinimumFractionDigits(length);
                    f68181c.setMaximumFractionDigits(length);
                }
            } else {
                f68181c.setMinimumFractionDigits(0);
                f68181c.setMaximumFractionDigits(0);
            }
            return f68181c.format(new BigDecimal(str));
        } catch (Exception unused) {
            return str2;
        }
    }

    public static boolean c0(BigDecimal bigDecimal) {
        return BigDecimal.ZERO.compareTo(bigDecimal) == 0;
    }

    public static String d(String str, String str2) {
        String format;
        NumberFormat numberFormat = f68182d;
        synchronized (numberFormat) {
            try {
                numberFormat.setGroupingUsed(true);
                int indexOf = str.indexOf(InstructionFileId.DOT);
                if (indexOf != -1) {
                    int length = str.substring(indexOf).length() - 1;
                    if (length != Integer.MIN_VALUE) {
                        numberFormat.setMinimumFractionDigits(length);
                        numberFormat.setMaximumFractionDigits(length);
                    }
                } else {
                    numberFormat.setMinimumFractionDigits(0);
                    numberFormat.setMaximumFractionDigits(0);
                }
                format = numberFormat.format(new BigDecimal(str));
            } catch (Exception unused) {
                return str2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return format;
    }

    public static boolean d0(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal != null && bigDecimal.compareTo(bigDecimal2) < 0;
    }

    public static String e(String str, int i11) {
        String str2;
        if (!a0(str)) {
            return str;
        }
        if (i11 == 1) {
            if (str.equals("0")) {
                return IdManager.DEFAULT_VERSION_NAME;
            }
            str2 = "#.0";
        } else if (i11 == 2) {
            if (str.equals("0")) {
                return "0.00";
            }
            str2 = "#.00";
        } else if (i11 == 3) {
            if (str.equals("0")) {
                return "0.000";
            }
            str2 = "#.000";
        } else if (i11 == 4) {
            if (str.equals("0")) {
                return "0.0000";
            }
            str2 = "#.0000";
        } else if (i11 == 5) {
            if (str.equals("0")) {
                return "0.00000";
            }
            str2 = "#.00000";
        } else if (i11 == 6) {
            if (str.equals("0")) {
                return "0.000000";
            }
            str2 = "#.000000";
        } else if (i11 == 7) {
            if (str.equals("0")) {
                return "0.0000000";
            }
            str2 = "#.0000000";
        } else if (str.equals("0")) {
            return "0.00000000";
        } else {
            str2 = "#.00000000";
        }
        return new DecimalFormat(str2).format(Double.parseDouble(str));
    }

    public static boolean e0(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal != null && bigDecimal.compareTo(bigDecimal2) <= 0;
    }

    public static String f(String str, boolean z11) {
        if (str != null && !str.trim().isEmpty()) {
            try {
                BigDecimal bigDecimal = new BigDecimal(str.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, ""));
                String[] strArr = z11 ? new String[]{"", "万", "亿", "万亿"} : new String[]{"", "K", "M", "B", "T"};
                BigDecimal[] bigDecimalArr = z11 ? new BigDecimal[]{new BigDecimal("10000"), new BigDecimal("100000000"), new BigDecimal("1000000000000")} : new BigDecimal[]{new BigDecimal("1000"), new BigDecimal("1000000"), new BigDecimal("1000000000"), new BigDecimal("1000000000000")};
                int length = bigDecimalArr.length - 1;
                while (length >= 0 && bigDecimal.abs().compareTo(bigDecimalArr[length]) < 0) {
                    length--;
                }
                if (length >= 0) {
                    bigDecimal = bigDecimal.divide(bigDecimalArr[length]);
                }
                return new DecimalFormat("#,##0.00").format(bigDecimal) + strArr[length + 1];
            } catch (NumberFormatException unused) {
            }
        }
        return "--";
    }

    public static boolean f0(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal != null && bigDecimal.compareTo(bigDecimal2) > 0;
    }

    public static String g(String str) {
        String str2;
        if (str == null) {
            return "--";
        }
        String str3 = "";
        if (str3.equals(str.trim())) {
            return "--";
        }
        try {
            String replaceAll = str.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, str3);
            if (!replaceAll.matches("^(-?\\d+)(\\.\\d+)?$")) {
                return "0";
            }
            BigDecimal scale = new BigDecimal(replaceAll).setScale(2, 1);
            BigDecimal bigDecimal = new BigDecimal("10000");
            BigDecimal bigDecimal2 = new BigDecimal("100000000");
            if (scale.compareTo(bigDecimal) < 0) {
                str2 = scale.toPlainString();
            } else if (scale.compareTo(bigDecimal2) < 0) {
                str2 = scale.divide(bigDecimal, 2, 1).toString();
                str3 = "万";
            } else {
                str2 = scale.divide(bigDecimal2, 2, 1).toString();
                str3 = "亿";
            }
            if (str2.length() == 0) {
                return "0";
            }
            String plainString = new BigDecimal(str2).stripTrailingZeros().toPlainString();
            String c11 = c(plainString, plainString);
            return c11 + str3;
        } catch (Exception unused) {
            return "0";
        }
    }

    public static boolean g0(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal != null && bigDecimal.compareTo(bigDecimal2) >= 0;
    }

    public static String h(String str, boolean z11) {
        if (str != null && !str.trim().isEmpty()) {
            try {
                BigDecimal bigDecimal = new BigDecimal(str.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, ""));
                String[] strArr = z11 ? new String[]{"", "万", "亿", "万亿"} : new String[]{"", "K", "M", "B", "T"};
                BigDecimal[] bigDecimalArr = z11 ? new BigDecimal[]{new BigDecimal("10000"), new BigDecimal("100000000"), new BigDecimal("1000000000000")} : new BigDecimal[]{new BigDecimal("1000"), new BigDecimal("1000000"), new BigDecimal("1000000000"), new BigDecimal("1000000000000")};
                int length = bigDecimalArr.length - 1;
                while (length >= 0 && bigDecimal.compareTo(bigDecimalArr[length]) < 0) {
                    length--;
                }
                if (length >= 0) {
                    bigDecimal = bigDecimal.divide(bigDecimalArr[length]);
                }
                return new DecimalFormat("#,##0.##").format(bigDecimal) + strArr[length + 1];
            } catch (NumberFormatException unused) {
            }
        }
        return "--";
    }

    public static double h0(String str) {
        if (!(str == null || str.length() == 0)) {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e11) {
                d.d(e11.toString());
            }
        }
        return 0.0d;
    }

    public static String i(double d11, int i11) {
        return l(d11, i11, false, "");
    }

    public static float i0(String str) {
        if (!(str == null || str.length() == 0)) {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException e11) {
                d.d(e11.toString());
            }
        }
        return 0.0f;
    }

    public static String j(double d11, int i11, String str) {
        return l(d11, i11, false, str);
    }

    public static int j0(String str) {
        if (!(str == null || str.length() == 0)) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt == 0) {
                    return 1;
                }
                return parseInt;
            } catch (NumberFormatException e11) {
                d.d(e11.toString());
            }
        }
        return 1;
    }

    public static String k(double d11, int i11, boolean z11) {
        return l(d11, i11, z11, "");
    }

    public static int k0(String str) {
        return l0(str, 0);
    }

    public static String l(double d11, int i11, boolean z11, String str) {
        try {
            return p(String.valueOf(d11), i11, z11, str);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return str;
        }
    }

    public static int l0(String str, int i11) {
        if (!(str == null || str.length() == 0)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e11) {
                d.d(e11.toString());
            }
        }
        return i11;
    }

    public static String m(String str, int i11) {
        return o(str, i11, false);
    }

    public static long m0(String str) {
        if (!(str == null || str.length() == 0)) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e11) {
                d.d(e11.toString());
            }
        }
        return 0;
    }

    public static String n(String str, int i11, String str2) {
        return p(str, i11, false, str2);
    }

    public static BigDecimal n0(String str) {
        if (TextUtils.isEmpty(str)) {
            return BigDecimal.ZERO;
        }
        if (str.lastIndexOf("%") == str.length() - 1) {
            return a(str.substring(0, str.length() - 1)).divide(BigDecimal.valueOf(100), 32, 1);
        }
        return BigDecimal.ZERO;
    }

    public static String o(String str, int i11, boolean z11) {
        return p(str, i11, z11, "");
    }

    public static String o0(String str) {
        if (str.contains(InstructionFileId.DOT)) {
            str = str.replaceAll("0*$", "");
            if (str.endsWith(InstructionFileId.DOT)) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return (!str.startsWith("0") || str.length() <= 1) ? str : str.substring(1);
    }

    public static String p(String str, int i11, boolean z11, String str2) {
        try {
            return s(new BigDecimal(str), i11, z11, str2);
        } catch (Exception unused) {
            return s(BigDecimal.ZERO, i11, z11, str2);
        }
    }

    public static String p0(String str) {
        return a(str).stripTrailingZeros().toPlainString();
    }

    public static String q(BigDecimal bigDecimal, int i11) {
        return r(bigDecimal, i11, false);
    }

    public static String q0(String str, int i11) {
        try {
            return new BigDecimal(str).setScale(i11, 2).toPlainString();
        } catch (Exception e11) {
            d.g(e11);
            return "";
        }
    }

    public static String r(BigDecimal bigDecimal, int i11, boolean z11) {
        return s(bigDecimal, i11, z11, "");
    }

    public static String r0(BigDecimal bigDecimal, int i11) {
        try {
            return bigDecimal.setScale(i11, 2).toPlainString();
        } catch (Exception e11) {
            d.g(e11);
            return "";
        }
    }

    public static synchronized String s(BigDecimal bigDecimal, int i11, boolean z11, String str) {
        String format;
        synchronized (m.class) {
            if (i11 != Integer.MIN_VALUE) {
                try {
                    f68180b.setMinimumFractionDigits(i11);
                } catch (Exception unused) {
                    return str;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (i11 != Integer.MIN_VALUE) {
                f68180b.setMaximumFractionDigits(i11);
            }
            f68180b.setRoundingMode(RoundingMode.DOWN);
            f68180b.setGroupingUsed(z11);
            format = f68180b.format(bigDecimal);
        }
        return format;
    }

    public static String s0(String str, int i11) {
        try {
            return new BigDecimal(str).setScale(i11, 3).toPlainString();
        } catch (Exception e11) {
            d.g(e11);
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        return r5;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String t(java.math.BigDecimal r2, int r3, boolean r4, java.lang.String r5) {
        /*
            java.lang.Class<i6.m> r0 = i6.m.class
            monitor-enter(r0)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 == r1) goto L_0x0011
            java.text.NumberFormat r1 = f68180b     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r1.setMinimumFractionDigits(r3)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            java.text.NumberFormat r1 = f68180b     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r1.setMaximumFractionDigits(r3)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
        L_0x0011:
            java.text.NumberFormat r3 = f68180b     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r3.setRoundingMode(r1)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            java.text.NumberFormat r3 = f68180b     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r3.setGroupingUsed(r4)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            java.text.NumberFormat r3 = f68180b     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            java.lang.String r3 = r3.format(r2)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            java.math.BigDecimal r4 = java.math.BigDecimal.ZERO     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            int r2 = r2.compareTo(r4)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            if (r2 >= 0) goto L_0x002d
            r2 = 1
            goto L_0x002e
        L_0x002d:
            r2 = 0
        L_0x002e:
            if (r2 == 0) goto L_0x0049
            java.lang.String r2 = "-"
            boolean r2 = r3.startsWith(r2)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            if (r2 != 0) goto L_0x0049
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r2.<init>()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            java.lang.String r4 = "-"
            r2.append(r4)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r2.append(r3)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            java.lang.String r3 = r2.toString()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
        L_0x0049:
            monitor-exit(r0)
            return r3
        L_0x004b:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L_0x004e:
            monitor-exit(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.m.t(java.math.BigDecimal, int, boolean, java.lang.String):java.lang.String");
    }

    public static String t0(BigDecimal bigDecimal, int i11) {
        try {
            return bigDecimal.setScale(i11, 3).toPlainString();
        } catch (Exception e11) {
            d.g(e11);
            return "";
        }
    }

    public static String u(String str, int i11) {
        String m11 = m(str, i11);
        if (a(str).compareTo(BigDecimal.ZERO) >= 0 || a(m11).compareTo(BigDecimal.ZERO) != 0) {
            return m11;
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + m11;
    }

    public static String u0(String str, int i11, int i12) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(46);
        int i13 = (i11 - i12) - 1;
        if (indexOf <= -1) {
            int length = str.length();
            if (length >= i11) {
                return str;
            }
            int i14 = (i11 - length) - 1;
            if (i14 < i12) {
                str2 = m(str, i14);
            } else {
                str2 = m(str, i12);
            }
            return str2;
        }
        int i15 = i11 - 1;
        if (indexOf >= i15) {
            return m(str, 0);
        }
        if (indexOf <= i13) {
            return m(str, i12);
        }
        if (indexOf < i15) {
            return m(str, i15 - indexOf);
        }
        return "";
    }

    public static String v(String str, int i11, boolean z11) {
        String o11 = o(str, i11, z11);
        if (a(str).compareTo(BigDecimal.ZERO) >= 0 || a(m(str, i11)).compareTo(BigDecimal.ZERO) != 0) {
            return o11;
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + o11;
    }

    public static BigDecimal v0(List<BigDecimal> list) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (list == null) {
            return bigDecimal;
        }
        for (BigDecimal add : list) {
            bigDecimal = bigDecimal.add(add);
        }
        return bigDecimal;
    }

    public static String w(double d11, int i11) {
        return x(d11, i11, false, "");
    }

    public static String x(double d11, int i11, boolean z11, String str) {
        return A(String.valueOf(d11), i11, z11, str);
    }

    public static String y(String str, int i11) {
        return z(str, i11, false);
    }

    public static String z(String str, int i11, boolean z11) {
        return A(str, i11, z11, "");
    }
}
