package com.iproov.sdk.p033throws;

import com.tencent.android.tpush.common.MessageKey;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.iproov.sdk.throws.catch  reason: invalid class name and invalid package */
public class Ccatch {

    /* renamed from: this  reason: not valid java name */
    private static final Cnew f2031this = new Cnew(0, 0, 0, 66, false, (Ctry) null);

    /* renamed from: case  reason: not valid java name */
    private boolean f2032case;

    /* renamed from: do  reason: not valid java name */
    private Cnew[] f2033do = new Cnew[256];
    /* access modifiers changed from: private */

    /* renamed from: else  reason: not valid java name */
    public String f2034else;

    /* renamed from: for  reason: not valid java name */
    private final SortedMap<String, Double> f2035for;
    /* access modifiers changed from: private */

    /* renamed from: goto  reason: not valid java name */
    public int f2036goto;

    /* renamed from: if  reason: not valid java name */
    private final SortedMap<String, Double> f2037if;

    /* renamed from: new  reason: not valid java name */
    private final SortedMap<String, Cfor> f2038new;

    /* renamed from: try  reason: not valid java name */
    private final SortedMap<String, Cfor> f2039try;

    /* renamed from: com.iproov.sdk.throws.catch$do  reason: invalid class name */
    public final class Cdo {

        /* renamed from: do  reason: not valid java name */
        public final int f2040do;

        /* renamed from: if  reason: not valid java name */
        public int f2042if;

        public Cdo(int i11, int i12) {
            this.f2040do = i12;
            this.f2042if = i11 + 1;
            this.f2042if = Ccatch.this.m1915do(Ccatch.this.f2034else, this.f2042if, i12 - 1);
        }

        /* renamed from: do  reason: not valid java name */
        private double m1934do() {
            if (Ccatch.this.f2034else.charAt(this.f2042if) == ',') {
                this.f2042if++;
            }
            double d11 = Ccatch.this.m1910do(this.f2042if, this.f2040do);
            this.f2042if = Ccatch.this.f2036goto;
            return d11;
        }

        /* renamed from: for  reason: not valid java name */
        public boolean m1935for() {
            return Ccatch.this.f2034else.charAt(this.f2042if) != ')';
        }

        /* renamed from: if  reason: not valid java name */
        public int m1936if() {
            return this.f2042if;
        }

        /* renamed from: new  reason: not valid java name */
        public double m1937new() {
            if (m1935for()) {
                return m1934do();
            }
            throw Ccatch.this.m1917do(this.f2042if, "Function has too few arguments");
        }
    }

    /* renamed from: com.iproov.sdk.throws.catch$for  reason: invalid class name */
    public interface Cfor {
        /* renamed from: do  reason: not valid java name */
        double m1938do(String str, Cdo doVar) throws Cdo;
    }

    /* renamed from: com.iproov.sdk.throws.catch$new  reason: invalid class name */
    public static final class Cnew {

        /* renamed from: case  reason: not valid java name */
        public final Ctry f2056case;

        /* renamed from: do  reason: not valid java name */
        public final char f2057do;

        /* renamed from: for  reason: not valid java name */
        public final int f2058for;

        /* renamed from: if  reason: not valid java name */
        public final int f2059if;

        /* renamed from: new  reason: not valid java name */
        public final int f2060new;

        /* renamed from: try  reason: not valid java name */
        public final boolean f2061try;

        public Cnew(char c11, int i11, Ctry tryR) {
            this(c11, i11, i11, 66, false, tryR);
        }

        public String toString() {
            return "MathOperator['" + this.f2057do + "']";
        }

        public Cnew(char c11, int i11, int i12, int i13, boolean z11, Ctry tryR) {
            this.f2057do = c11;
            this.f2059if = i11;
            this.f2058for = i12;
            this.f2060new = i13;
            this.f2061try = z11;
            this.f2056case = tryR;
        }
    }

    /* renamed from: com.iproov.sdk.throws.catch$try  reason: invalid class name */
    public interface Ctry {
        /* renamed from: do  reason: not valid java name */
        double m1943do(double d11, char c11, double d12) throws Cdo;
    }

    static {
        Cif ifVar = Cif.f2048do;
    }

    public Ccatch() {
        Cif.m1940if(this);
        this.f2037if = new TreeMap();
        this.f2035for = new TreeMap();
        m1928do("E", 2.718281828459045d);
        m1928do("Euler", 0.577215664901533d);
        m1928do("LN2", 0.693147180559945d);
        m1928do("LN10", 2.302585092994046d);
        m1928do("LOG2E", 1.442695040888963d);
        m1928do("LOG10E", 0.434294481903252d);
        m1928do("PHI", 1.618033988749895d);
        m1928do("PI", 3.141592653589793d);
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        this.f2038new = new TreeMap(comparator);
        this.f2039try = new TreeMap(comparator);
        Cif.m1939do(this);
        this.f2032case = false;
        this.f2036goto = 0;
    }

    /* renamed from: for  reason: not valid java name */
    private double m1922for(int i11, int i12) {
        while (i11 < i12 && Character.isWhitespace(this.f2034else.charAt(i12))) {
            i12--;
        }
        String substring = this.f2034else.substring(i11, i12 + 1);
        Double d11 = (Double) this.f2037if.get(substring);
        if (d11 != null) {
            return d11.doubleValue();
        }
        Double d12 = (Double) this.f2035for.get(substring);
        if (d12 != null) {
            return d12.doubleValue();
        }
        if (this.f2032case) {
            return 0.0d;
        }
        throw m1917do(i11, "Unrecognized constant or variable \"" + substring + "\"");
    }

    /* renamed from: com.iproov.sdk.throws.catch$if  reason: invalid class name */
    public static class Cif implements Ctry, Cfor {

        /* renamed from: break  reason: not valid java name */
        private static final Cnew f2043break;

        /* renamed from: case  reason: not valid java name */
        private static final Cnew f2044case;

        /* renamed from: catch  reason: not valid java name */
        private static final Cnew f2045catch;

        /* renamed from: class  reason: not valid java name */
        private static final Cnew f2046class;

        /* renamed from: const  reason: not valid java name */
        private static final Cnew f2047const;

        /* renamed from: do  reason: not valid java name */
        public static final Cif f2048do;

        /* renamed from: else  reason: not valid java name */
        private static final Cnew f2049else;

        /* renamed from: for  reason: not valid java name */
        private static final Cnew f2050for;

        /* renamed from: goto  reason: not valid java name */
        private static final Cnew f2051goto;

        /* renamed from: if  reason: not valid java name */
        private static final Cnew f2052if;

        /* renamed from: new  reason: not valid java name */
        private static final Cnew f2053new;

        /* renamed from: this  reason: not valid java name */
        private static final Cnew f2054this;

        /* renamed from: try  reason: not valid java name */
        private static final Cnew f2055try;

        static {
            Cif ifVar = new Cif();
            f2048do = ifVar;
            Cif ifVar2 = ifVar;
            f2052if = new Cnew('=', 99, 99, 82, true, ifVar2);
            f2050for = new Cnew('^', 80, 81, 66, false, ifVar2);
            f2053new = new Cnew(177, 60, 60, 82, true, ifVar2);
            f2055try = new Cnew('*', 40, ifVar);
            f2044case = new Cnew(215, 40, ifVar);
            f2049else = new Cnew(183, 40, ifVar);
            f2051goto = new Cnew('(', 40, ifVar);
            f2054this = new Cnew('/', 40, ifVar);
            f2043break = new Cnew(247, 40, ifVar);
            f2045catch = new Cnew('%', 40, ifVar);
            f2046class = new Cnew('+', 20, ifVar);
            f2047const = new Cnew('-', 20, ifVar);
        }

        private Cif() {
        }

        /* renamed from: if  reason: not valid java name */
        public static void m1940if(Ccatch catchR) {
            catchR.m1927do(f2052if);
            catchR.m1927do(f2050for);
            catchR.m1927do(f2053new);
            catchR.m1927do(f2055try);
            catchR.m1927do(f2044case);
            catchR.m1927do(f2049else);
            catchR.m1927do(f2051goto);
            catchR.m1927do(f2054this);
            catchR.m1927do(f2043break);
            catchR.m1927do(f2045catch);
            catchR.m1927do(f2046class);
            catchR.m1927do(f2047const);
        }

        /* renamed from: do  reason: not valid java name */
        public double m1941do(double d11, char c11, double d12) {
            if (c11 == '%') {
                return d11 % d12;
            }
            if (c11 == '(') {
                return d11 * d12;
            }
            if (c11 == '-') {
                return d11 - d12;
            }
            if (c11 == '/') {
                return d11 / d12;
            }
            if (c11 == '=') {
                return d12;
            }
            if (c11 == '^') {
                return Math.pow(d11, d12);
            }
            if (c11 == 177) {
                return -d12;
            }
            if (c11 == 183) {
                return d11 * d12;
            }
            if (c11 == 215) {
                return d11 * d12;
            }
            if (c11 == 247) {
                return d11 / d12;
            }
            if (c11 == '*') {
                return d11 * d12;
            }
            if (c11 == '+') {
                return d11 + d12;
            }
            throw new UnsupportedOperationException("MathEval internal operator setup is incorrect - internal operator \"" + c11 + "\" not handled");
        }

        /* renamed from: do  reason: not valid java name */
        public double m1942do(String str, Cdo doVar) throws Cdo {
            char lowerCase = Character.toLowerCase(str.charAt(0));
            if (lowerCase != 'a') {
                if (lowerCase != 'c') {
                    if (lowerCase != 'e') {
                        if (lowerCase != 'f') {
                            if (lowerCase != 'l') {
                                if (lowerCase != 'm') {
                                    switch (lowerCase) {
                                        case 'r':
                                            if (str.equalsIgnoreCase("random")) {
                                                return Math.random();
                                            }
                                            if (str.equalsIgnoreCase("round")) {
                                                return (double) Math.round(doVar.m1937new());
                                            }
                                            if (str.equalsIgnoreCase("roundHE")) {
                                                return Math.rint(doVar.m1937new());
                                            }
                                            break;
                                        case 's':
                                            if (str.equalsIgnoreCase("signum")) {
                                                return Math.signum(doVar.m1937new());
                                            }
                                            if (str.equalsIgnoreCase("sin")) {
                                                return Math.sin(doVar.m1937new());
                                            }
                                            if (str.equalsIgnoreCase("sinh")) {
                                                return Math.sinh(doVar.m1937new());
                                            }
                                            if (str.equalsIgnoreCase("sqrt")) {
                                                return Math.sqrt(doVar.m1937new());
                                            }
                                            break;
                                        case 't':
                                            if (str.equalsIgnoreCase("tan")) {
                                                return Math.tan(doVar.m1937new());
                                            }
                                            if (str.equalsIgnoreCase("tanh")) {
                                                return Math.tanh(doVar.m1937new());
                                            }
                                            if (str.equalsIgnoreCase("toDegrees")) {
                                                return Math.toDegrees(doVar.m1937new());
                                            }
                                            if (str.equalsIgnoreCase("toRadians")) {
                                                return Math.toRadians(doVar.m1937new());
                                            }
                                            break;
                                        case 'u':
                                            if (str.equalsIgnoreCase("ulp")) {
                                                return Math.ulp(doVar.m1937new());
                                            }
                                            break;
                                    }
                                } else if (str.equalsIgnoreCase("max")) {
                                    return Math.max(doVar.m1937new(), doVar.m1937new());
                                } else {
                                    if (str.equalsIgnoreCase(MessageKey.MSG_ACCEPT_TIME_MIN)) {
                                        return Math.min(doVar.m1937new(), doVar.m1937new());
                                    }
                                }
                            } else if (str.equalsIgnoreCase("log")) {
                                return Math.log(doVar.m1937new());
                            } else {
                                if (str.equalsIgnoreCase("log10")) {
                                    return Math.log10(doVar.m1937new());
                                }
                                if (str.equalsIgnoreCase("log1p")) {
                                    return Math.log1p(doVar.m1937new());
                                }
                            }
                        } else if (str.equalsIgnoreCase("floor")) {
                            return Math.floor(doVar.m1937new());
                        }
                    } else if (str.equalsIgnoreCase("exp")) {
                        return Math.exp(doVar.m1937new());
                    } else {
                        if (str.equalsIgnoreCase("expm1")) {
                            return Math.expm1(doVar.m1937new());
                        }
                    }
                } else if (str.equalsIgnoreCase("cbrt")) {
                    return Math.cbrt(doVar.m1937new());
                } else {
                    if (str.equalsIgnoreCase("ceil")) {
                        return Math.ceil(doVar.m1937new());
                    }
                    if (str.equalsIgnoreCase("cos")) {
                        return Math.cos(doVar.m1937new());
                    }
                    if (str.equalsIgnoreCase("cosh")) {
                        return Math.cosh(doVar.m1937new());
                    }
                }
            } else if (str.equalsIgnoreCase("abs")) {
                return Math.abs(doVar.m1937new());
            } else {
                if (str.equalsIgnoreCase("acos")) {
                    return Math.acos(doVar.m1937new());
                }
                if (str.equalsIgnoreCase("asin")) {
                    return Math.asin(doVar.m1937new());
                }
                if (str.equalsIgnoreCase("atan")) {
                    return Math.atan(doVar.m1937new());
                }
            }
            throw new UnsupportedOperationException("MathEval internal function setup is incorrect - internal function \"" + str + "\" not handled");
        }

        /* renamed from: do  reason: not valid java name */
        public static void m1939do(Ccatch catchR) {
            Cif ifVar = f2048do;
            catchR.m1929do("abs", (Cfor) ifVar);
            catchR.m1929do("acos", (Cfor) ifVar);
            catchR.m1929do("asin", (Cfor) ifVar);
            catchR.m1929do("atan", (Cfor) ifVar);
            catchR.m1929do("cbrt", (Cfor) ifVar);
            catchR.m1929do("ceil", (Cfor) ifVar);
            catchR.m1929do("cos", (Cfor) ifVar);
            catchR.m1929do("cosh", (Cfor) ifVar);
            catchR.m1929do("exp", (Cfor) ifVar);
            catchR.m1929do("expm1", (Cfor) ifVar);
            catchR.m1929do("floor", (Cfor) ifVar);
            catchR.m1929do("log", (Cfor) ifVar);
            catchR.m1929do("log10", (Cfor) ifVar);
            catchR.m1929do("log1p", (Cfor) ifVar);
            catchR.m1929do("max", (Cfor) ifVar);
            catchR.m1929do(MessageKey.MSG_ACCEPT_TIME_MIN, (Cfor) ifVar);
            catchR.m1930do("random", (Cfor) ifVar, true);
            catchR.m1929do("round", (Cfor) ifVar);
            catchR.m1929do("roundHE", (Cfor) ifVar);
            catchR.m1929do("signum", (Cfor) ifVar);
            catchR.m1929do("sin", (Cfor) ifVar);
            catchR.m1929do("sinh", (Cfor) ifVar);
            catchR.m1929do("sqrt", (Cfor) ifVar);
            catchR.m1929do("tan", (Cfor) ifVar);
            catchR.m1929do("tanh", (Cfor) ifVar);
            catchR.m1929do("toDegrees", (Cfor) ifVar);
            catchR.m1929do("toRadians", (Cfor) ifVar);
            catchR.m1929do("ulp", (Cfor) ifVar);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public Ccatch m1932if(String str, double d11) {
        return m1933if(str, Double.valueOf(d11));
    }

    /* renamed from: if  reason: not valid java name */
    public Ccatch m1933if(String str, Double d11) {
        m1925if(str);
        if (d11 == null) {
            this.f2035for.remove(str);
        } else {
            this.f2035for.put(str, d11);
        }
        return this;
    }

    /* renamed from: do  reason: not valid java name */
    public Ccatch m1928do(String str, double d11) {
        return m1931do(str, Double.valueOf(d11));
    }

    /* renamed from: if  reason: not valid java name */
    private void m1925if(String str) {
        if (!Character.isLetter(str.charAt(0))) {
            throw new IllegalArgumentException("Names for constants, variables and functions must start with a letter");
        } else if (str.indexOf(40) != -1 || str.indexOf(41) != -1) {
            throw new IllegalArgumentException("Names for constants, variables and functions may not contain a parenthesis");
        }
    }

    /* renamed from: do  reason: not valid java name */
    public Ccatch m1931do(String str, Double d11) {
        if (this.f2037if.get(str) == null) {
            m1925if(str);
            this.f2037if.put(str, d11);
            return this;
        }
        throw new IllegalArgumentException("Constants may not be redefined");
    }

    /* renamed from: if  reason: not valid java name */
    private double m1923if(int i11, int i12) {
        int i13 = i11;
        while (i13 <= i12 && this.f2034else.charAt(i13) != '(') {
            i13++;
        }
        String trim = this.f2034else.substring(i11, i13).trim();
        Cdo doVar = new Cdo(i13, i12);
        try {
            Cfor forR = (Cfor) this.f2038new.get(trim);
            if (forR != null) {
                double d11 = forR.m1938do(trim, doVar);
                if (!doVar.m1935for()) {
                    this.f2036goto = doVar.m1936if();
                    return d11;
                }
                throw m1917do(doVar.m1936if(), "Function has too many arguments");
            }
            Cfor forR2 = (Cfor) this.f2039try.get(trim);
            if (forR2 != null) {
                double d12 = forR2.m1938do(trim, doVar);
                if (!doVar.m1935for()) {
                    this.f2036goto = doVar.m1936if();
                    return d12;
                }
                throw m1917do(doVar.m1936if(), "Function has too many arguments");
            }
            throw m1917do(i11, "Function \"" + trim + "\" not recognized");
        } catch (Cdo e11) {
            throw e11;
        } catch (NoSuchMethodError unused) {
            throw m1917do(i11, "Function not supported in this JVM: \"" + trim + "\"");
        } catch (UnsupportedOperationException e12) {
            throw m1917do(i11, e12.getMessage());
        } catch (Throwable th2) {
            throw m1918do(i11, "Unexpected exception parsing function arguments", th2);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public Ccatch m1927do(Cnew newR) {
        char c11 = newR.f2057do;
        Cnew[] newArr = this.f2033do;
        if (c11 >= newArr.length) {
            Cnew[] newArr2 = new Cnew[(c11 + (c11 % 255) + 1)];
            System.arraycopy(newArr, 0, newArr2, 0, newArr.length);
            this.f2033do = newArr2;
        }
        this.f2033do[newR.f2057do] = newR;
        return this;
    }

    /* renamed from: do  reason: not valid java name */
    public Ccatch m1929do(String str, Cfor forR) {
        return m1930do(str, forR, false);
    }

    /* renamed from: do  reason: not valid java name */
    public Ccatch m1930do(String str, Cfor forR, boolean z11) {
        m1925if(str);
        if (forR == null) {
            this.f2038new.remove(str);
            this.f2039try.remove(str);
        } else if (z11) {
            this.f2038new.remove(str);
            this.f2039try.put(str, forR);
        } else {
            this.f2038new.put(str, forR);
            this.f2039try.remove(str);
        }
        return this;
    }

    /* renamed from: do  reason: not valid java name */
    public double m1926do(String str) throws NumberFormatException, Cdo {
        this.f2034else = str;
        this.f2036goto = 0;
        return m1910do(0, str.length() - 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public double m1910do(int i11, int i12) throws NumberFormatException, Cdo {
        return m1911do(i11, i12, 0.0d, f2031this, m1916do('='));
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0139 A[SYNTHETIC] */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private double m1911do(int r22, int r23, double r24, com.iproov.sdk.p033throws.Ccatch.Cnew r26, com.iproov.sdk.p033throws.Ccatch.Cnew r27) throws java.lang.NumberFormatException, com.iproov.sdk.p033throws.Cdo {
        /*
            r21 = this;
            r7 = r21
            r8 = r23
            com.iproov.sdk.throws.catch$new r0 = f2031this
            r1 = r22
            r9 = r24
            r11 = r27
            r2 = r0
            r0 = r1
        L_0x000e:
            java.lang.String r3 = r7.f2034else
            int r12 = r7.m1915do((java.lang.String) r3, (int) r0, (int) r8)
            r13 = 76
            if (r12 > r8) goto L_0x017d
            r0 = r12
        L_0x0019:
            if (r0 > r8) goto L_0x003b
            java.lang.String r1 = r7.f2034else
            char r1 = r1.charAt(r0)
            com.iproov.sdk.throws.catch$new r2 = r7.m1916do((char) r1)
            com.iproov.sdk.throws.catch$new r3 = f2031this
            if (r2 == r3) goto L_0x002f
            boolean r1 = r2.f2061try
            if (r1 == 0) goto L_0x003b
            r2 = r3
            goto L_0x0038
        L_0x002f:
            r3 = 41
            if (r1 == r3) goto L_0x003b
            r3 = 44
            if (r1 != r3) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            int r0 = r0 + 1
            goto L_0x0019
        L_0x003b:
            java.lang.String r1 = r7.f2034else
            char r1 = r1.charAt(r12)
            boolean r3 = java.lang.Character.isLetter(r1)
            int r4 = r11.f2060new
            if (r4 == r13) goto L_0x005d
            r4 = 43
            if (r1 != r4) goto L_0x0053
            r3 = r9
            r9 = r2
            r2 = r26
            goto L_0x0151
        L_0x0053:
            r4 = 45
            if (r1 != r4) goto L_0x005d
            r2 = 177(0xb1, float:2.48E-43)
            com.iproov.sdk.throws.catch$new r2 = r7.m1916do((char) r2)
        L_0x005d:
            r14 = 82
            r15 = 40
            if (r12 != r0) goto L_0x0070
            int r4 = r11.f2060new
            if (r4 == r13) goto L_0x006b
            int r4 = r2.f2060new
            if (r4 != r14) goto L_0x0070
        L_0x006b:
            r3 = 9221120237041090560(0x7ff8000000000000, double:NaN)
        L_0x006d:
            r6 = r2
            goto L_0x00f0
        L_0x0070:
            if (r1 != r15) goto L_0x0095
            int r0 = r12 + 1
            double r0 = r7.m1910do((int) r0, (int) r8)
            java.lang.String r2 = r7.f2034else
            int r3 = r7.f2036goto
            int r3 = r3 + 1
            int r2 = r7.m1915do((java.lang.String) r2, (int) r3, (int) r8)
            if (r2 > r8) goto L_0x008f
            java.lang.String r3 = r7.f2034else
            char r3 = r3.charAt(r2)
            com.iproov.sdk.throws.catch$new r3 = r7.m1916do((char) r3)
            goto L_0x0091
        L_0x008f:
            com.iproov.sdk.throws.catch$new r3 = f2031this
        L_0x0091:
            r6 = r3
            r3 = r0
            r0 = r2
            goto L_0x00f0
        L_0x0095:
            if (r3 == 0) goto L_0x00b9
            char r1 = r2.f2057do
            if (r1 != r15) goto L_0x00b9
            double r0 = r7.m1923if((int) r12, (int) r8)
            java.lang.String r2 = r7.f2034else
            int r3 = r7.f2036goto
            int r3 = r3 + 1
            int r2 = r7.m1915do((java.lang.String) r2, (int) r3, (int) r8)
            if (r2 > r8) goto L_0x00b6
            java.lang.String r3 = r7.f2034else
            char r3 = r3.charAt(r2)
            com.iproov.sdk.throws.catch$new r3 = r7.m1916do((char) r3)
            goto L_0x0091
        L_0x00b6:
            com.iproov.sdk.throws.catch$new r3 = f2031this
            goto L_0x0091
        L_0x00b9:
            if (r3 == 0) goto L_0x00c2
            int r1 = r0 + -1
            double r3 = r7.m1922for(r12, r1)
            goto L_0x006d
        L_0x00c2:
            java.lang.String r1 = r7.f2034else     // Catch:{ NumberFormatException -> 0x0158 }
            java.lang.String r3 = "0x"
            boolean r1 = r7.m1921do((java.lang.String) r1, (int) r12, (java.lang.String) r3)     // Catch:{ NumberFormatException -> 0x0158 }
            if (r1 == 0) goto L_0x00e0
            java.lang.String r1 = r7.f2034else     // Catch:{ NumberFormatException -> 0x0158 }
            int r3 = r12 + 2
            java.lang.String r1 = r1.substring(r3, r0)     // Catch:{ NumberFormatException -> 0x0158 }
            java.lang.String r1 = r1.trim()     // Catch:{ NumberFormatException -> 0x0158 }
            r3 = 16
            long r3 = java.lang.Long.parseLong(r1, r3)     // Catch:{ NumberFormatException -> 0x0158 }
            double r3 = (double) r3     // Catch:{ NumberFormatException -> 0x0158 }
            goto L_0x006d
        L_0x00e0:
            java.lang.String r1 = r7.f2034else     // Catch:{ NumberFormatException -> 0x0158 }
            java.lang.String r1 = r1.substring(r12, r0)     // Catch:{ NumberFormatException -> 0x0158 }
            java.lang.String r1 = r1.trim()     // Catch:{ NumberFormatException -> 0x0158 }
            double r3 = java.lang.Double.parseDouble(r1)     // Catch:{ NumberFormatException -> 0x0158 }
            goto L_0x006d
        L_0x00f0:
            int r1 = r7.m1913do((com.iproov.sdk.p033throws.Ccatch.Cnew) r11, (int) r13)
            int r2 = r7.m1913do((com.iproov.sdk.p033throws.Ccatch.Cnew) r6, (int) r14)
            if (r1 >= r2) goto L_0x011c
            int r1 = r0 + 1
            r0 = r21
            r2 = r23
            r5 = r11
            double r0 = r0.m1911do(r1, r2, r3, r5, r6)
            int r2 = r7.f2036goto
            if (r2 > r8) goto L_0x0114
            java.lang.String r3 = r7.f2034else
            char r3 = r3.charAt(r2)
            com.iproov.sdk.throws.catch$new r3 = r7.m1916do((char) r3)
            goto L_0x0116
        L_0x0114:
            com.iproov.sdk.throws.catch$new r3 = f2031this
        L_0x0116:
            r17 = r0
            r16 = r2
            r5 = r3
            goto L_0x0121
        L_0x011c:
            r16 = r0
            r17 = r3
            r5 = r6
        L_0x0121:
            r0 = r21
            r1 = r12
            r2 = r9
            r4 = r11
            r9 = r5
            r5 = r17
            double r0 = r0.m1909do((int) r1, (double) r2, (com.iproov.sdk.p033throws.Ccatch.Cnew) r4, (double) r5)
            r2 = r26
            int r3 = r7.m1913do((com.iproov.sdk.p033throws.Ccatch.Cnew) r2, (int) r13)
            int r4 = r7.m1913do((com.iproov.sdk.p033throws.Ccatch.Cnew) r9, (int) r14)
            if (r3 < r4) goto L_0x0140
            r2 = r9
            r4 = r2
            r9 = r0
            r1 = r12
            r12 = r16
            goto L_0x017e
        L_0x0140:
            char r3 = r9.f2057do
            if (r3 != r15) goto L_0x014d
            int r3 = r16 + -1
            r11 = r9
            r19 = r0
            r0 = r3
            r3 = r19
            goto L_0x0151
        L_0x014d:
            r3 = r0
            r11 = r9
            r0 = r16
        L_0x0151:
            int r0 = r0 + 1
            r2 = r9
            r1 = r12
            r9 = r3
            goto L_0x000e
        L_0x0158:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid numeric value \""
            r1.append(r2)
            java.lang.String r2 = r7.f2034else
            java.lang.String r0 = r2.substring(r12, r0)
            java.lang.String r0 = r0.trim()
            r1.append(r0)
            java.lang.String r0 = "\""
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.iproov.sdk.throws.do r0 = r7.m1917do((int) r12, (java.lang.String) r0)
            throw r0
        L_0x017d:
            r4 = r11
        L_0x017e:
            if (r12 <= r8) goto L_0x01af
            com.iproov.sdk.throws.catch$new r0 = f2031this
            if (r4 == r0) goto L_0x01af
            int r0 = r4.f2060new
            if (r0 != r13) goto L_0x0192
            r5 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            r0 = r21
            r2 = r9
            double r9 = r0.m1909do((int) r1, (double) r2, (com.iproov.sdk.p033throws.Ccatch.Cnew) r4, (double) r5)
            goto L_0x01af
        L_0x0192:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expression ends with a blank operand after operator '"
            r0.append(r1)
            char r1 = r2.f2057do
            r0.append(r1)
            java.lang.String r1 = "'"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.iproov.sdk.throws.do r0 = r7.m1917do((int) r12, (java.lang.String) r0)
            throw r0
        L_0x01af:
            r7.f2036goto = r12
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p033throws.Ccatch.m1911do(int, int, double, com.iproov.sdk.throws.catch$new, com.iproov.sdk.throws.catch$new):double");
    }

    /* renamed from: do  reason: not valid java name */
    private Cnew m1916do(char c11) {
        Cnew newR;
        Cnew[] newArr = this.f2033do;
        if (c11 >= newArr.length || (newR = newArr[c11]) == null) {
            return f2031this;
        }
        return newR;
    }

    /* renamed from: do  reason: not valid java name */
    private int m1913do(Cnew newR, int i11) {
        if (newR == null) {
            return Integer.MIN_VALUE;
        }
        int i12 = newR.f2060new;
        if (i12 == 66 || i12 != i11) {
            return i11 == 76 ? newR.f2059if : newR.f2058for;
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: do  reason: not valid java name */
    private double m1909do(int i11, double d11, Cnew newR, double d12) {
        if (newR.f2060new != 82 && Double.isNaN(d11)) {
            throw m1917do(i11, "Mathematical NaN detected in right-operand");
        } else if (newR.f2060new == 76 || !Double.isNaN(d12)) {
            try {
                return newR.f2056case.m1943do(d11, newR.f2057do, d12);
            } catch (Cdo e11) {
                throw m1918do(i11, "Mathematical expression \"" + this.f2034else + "\" failed to evaluate", (Throwable) e11);
            } catch (UnsupportedOperationException unused) {
                while (i11 > 0 && m1916do(this.f2034else.charAt(i11)) == null) {
                    i11--;
                }
                throw m1917do(i11, "Operator \"" + newR.f2057do + "\" not handled by math engine (Programmer error: The list of operators is inconsistent within the engine)");
            }
        } else {
            throw m1917do(i11, "Mathematical NaN detected in left-operand");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public Cdo m1917do(int i11, String str) {
        return new Cdo(str + " at offset " + i11 + " in expression \"" + this.f2034else + "\"");
    }

    /* renamed from: do  reason: not valid java name */
    private Cdo m1918do(int i11, String str, Throwable th2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" at offset ");
        sb2.append(i11);
        sb2.append(" in expression \"");
        sb2.append(this.f2034else);
        sb2.append("\" (Cause: ");
        sb2.append(th2.getMessage() != null ? th2.getMessage() : th2.toString());
        sb2.append(")");
        return new Cdo(sb2.toString());
    }

    /* renamed from: do  reason: not valid java name */
    private boolean m1921do(String str, int i11, String str2) {
        return str.regionMatches(true, i11, str2, 0, str2.length());
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public int m1915do(String str, int i11, int i12) {
        while (i11 <= i12 && Character.isWhitespace(str.charAt(i11))) {
            i11++;
        }
        return i11;
    }
}
