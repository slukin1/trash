package androidx.test.espresso.core.internal.deps.guava.base;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class Strings {
    public static String a(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i11 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i12 = 0; i12 < objArr.length; i12++) {
                objArr[i12] = b(objArr[i12]);
            }
        }
        StringBuilder sb2 = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i13 = 0;
        while (i11 < objArr.length && (indexOf = valueOf.indexOf("%s", i13)) != -1) {
            sb2.append(valueOf, i13, indexOf);
            sb2.append(objArr[i11]);
            i13 = indexOf + 2;
            i11++;
        }
        sb2.append(valueOf, i13, valueOf.length());
        if (i11 < objArr.length) {
            sb2.append(" [");
            sb2.append(objArr[i11]);
            for (int i14 = i11 + 1; i14 < objArr.length; i14++) {
                sb2.append(", ");
                sb2.append(objArr[i14]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }

    public static String b(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception e11) {
            String name = obj.getClass().getName();
            String hexString = Integer.toHexString(System.identityHashCode(obj));
            StringBuilder sb2 = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
            sb2.append(name);
            sb2.append('@');
            sb2.append(hexString);
            String sb3 = sb2.toString();
            Logger logger = Logger.getLogger("androidx.test.espresso.core.internal.deps.guava.base.Strings");
            Level level = Level.WARNING;
            String valueOf = String.valueOf(sb3);
            logger.logp(level, "androidx.test.espresso.core.internal.deps.guava.base.Strings", "lenientToString", valueOf.length() != 0 ? "Exception during lenientFormat for ".concat(valueOf) : new String("Exception during lenientFormat for "), e11);
            String name2 = e11.getClass().getName();
            StringBuilder sb4 = new StringBuilder(String.valueOf(sb3).length() + 9 + name2.length());
            sb4.append("<");
            sb4.append(sb3);
            sb4.append(" threw ");
            sb4.append(name2);
            sb4.append(">");
            return sb4.toString();
        }
    }

    public static String c(String str, int i11, char c11) {
        Preconditions.i(str);
        if (str.length() >= i11) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(i11);
        for (int length = str.length(); length < i11; length++) {
            sb2.append(c11);
        }
        sb2.append(str);
        return sb2.toString();
    }
}
