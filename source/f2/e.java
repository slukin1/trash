package f2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.TimeZone;

public final class e extends c {

    /* renamed from: t  reason: collision with root package name */
    public final String f15737t;

    /* renamed from: u  reason: collision with root package name */
    public final int f15738u;

    public e(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public static boolean A0(char c11, char c12, char c13, char c14, char c15, char c16, int i11, int i12) {
        if ((c11 == '1' || c11 == '2') && c12 >= '0' && c12 <= '9' && c13 >= '0' && c13 <= '9' && c14 >= '0' && c14 <= '9') {
            if (c15 == '0') {
                if (c16 < '1' || c16 > '9') {
                    return false;
                }
            } else if (!(c15 == '1' && (c16 == '0' || c16 == '1' || c16 == '2'))) {
                return false;
            }
            return i11 == 48 ? i12 >= 49 && i12 <= 57 : (i11 == 49 || i11 == 50) ? i12 >= 48 && i12 <= 57 : i11 == 51 && (i12 == 48 || i12 == 49);
        }
    }

    public static boolean z0(String str, int i11, char[] cArr) {
        int length = cArr.length;
        if (length + i11 > str.length()) {
            return false;
        }
        for (int i12 = 0; i12 < length; i12++) {
            if (cArr[i12] != str.charAt(i11 + i12)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r6 <= '4') goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean B0(char r5, char r6, char r7, char r8, char r9, char r10) {
        /*
            r4 = this;
            r0 = 57
            r1 = 0
            r2 = 48
            if (r5 != r2) goto L_0x000c
            if (r6 < r2) goto L_0x000b
            if (r6 <= r0) goto L_0x0020
        L_0x000b:
            return r1
        L_0x000c:
            r3 = 49
            if (r5 != r3) goto L_0x0015
            if (r6 < r2) goto L_0x0014
            if (r6 <= r0) goto L_0x0020
        L_0x0014:
            return r1
        L_0x0015:
            r3 = 50
            if (r5 != r3) goto L_0x0042
            if (r6 < r2) goto L_0x0042
            r5 = 52
            if (r6 <= r5) goto L_0x0020
            goto L_0x0042
        L_0x0020:
            r5 = 53
            r6 = 54
            if (r7 < r2) goto L_0x002d
            if (r7 > r5) goto L_0x002d
            if (r8 < r2) goto L_0x002c
            if (r8 <= r0) goto L_0x0032
        L_0x002c:
            return r1
        L_0x002d:
            if (r7 != r6) goto L_0x0042
            if (r8 == r2) goto L_0x0032
            return r1
        L_0x0032:
            if (r9 < r2) goto L_0x003b
            if (r9 > r5) goto L_0x003b
            if (r10 < r2) goto L_0x003a
            if (r10 <= r0) goto L_0x0040
        L_0x003a:
            return r1
        L_0x003b:
            if (r9 != r6) goto L_0x0042
            if (r10 == r2) goto L_0x0040
            return r1
        L_0x0040:
            r5 = 1
            return r5
        L_0x0042:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.e.B0(char, char, char, char, char, char):boolean");
    }

    public boolean C0() {
        return D0(true);
    }

    public boolean D0(boolean z11) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        char c11;
        char R;
        int i16;
        int i17;
        char R2;
        int i18;
        char R3;
        char R4;
        char c12;
        int i19;
        int i21 = this.f15738u;
        int i22 = this.f15722f;
        int i23 = i21 - i22;
        if (!z11 && i23 > 13) {
            char R5 = R(i22);
            char R6 = R(this.f15722f + 1);
            char R7 = R(this.f15722f + 2);
            char R8 = R(this.f15722f + 3);
            char R9 = R(this.f15722f + 4);
            char R10 = R(this.f15722f + 5);
            char R11 = R((this.f15722f + i23) - 1);
            char R12 = R((this.f15722f + i23) - 2);
            if (R5 == '/' && R6 == 'D' && R7 == 'a' && R8 == 't' && R9 == 'e' && R10 == '(' && R11 == '/' && R12 == ')') {
                int i24 = -1;
                for (int i25 = 6; i25 < i23; i25++) {
                    char R13 = R(this.f15722f + i25);
                    if (R13 != '+') {
                        if (R13 < '0' || R13 > '9') {
                            break;
                        }
                    } else {
                        i24 = i25;
                    }
                }
                if (i24 == -1) {
                    return false;
                }
                int i26 = this.f15722f + 6;
                long parseLong = Long.parseLong(x0(i26, i24 - i26));
                Calendar instance = Calendar.getInstance(this.f15729m, this.f15730n);
                this.f15728l = instance;
                instance.setTimeInMillis(parseLong);
                this.f15718b = 5;
                return true;
            }
        }
        if (i23 == 8 || i23 == 14 || (i23 == 17 && R(this.f15722f + 6) != '-')) {
            int i27 = 0;
            if (z11) {
                return false;
            }
            char R14 = R(this.f15722f);
            char R15 = R(this.f15722f + 1);
            char R16 = R(this.f15722f + 2);
            char R17 = R(this.f15722f + 3);
            char R18 = R(this.f15722f + 4);
            char R19 = R(this.f15722f + 5);
            char R20 = R(this.f15722f + 6);
            char R21 = R(this.f15722f + 7);
            if (!A0(R14, R15, R16, R17, R18, R19, R20, R21)) {
                return false;
            }
            E0(R14, R15, R16, R17, R18, R19, R20, R21);
            if (i23 != 8) {
                char R22 = R(this.f15722f + 8);
                char R23 = R(this.f15722f + 9);
                char R24 = R(this.f15722f + 10);
                char R25 = R(this.f15722f + 11);
                char R26 = R(this.f15722f + 12);
                char R27 = R(this.f15722f + 13);
                if (!B0(R22, R23, R24, R25, R26, R27)) {
                    return false;
                }
                if (i23 == 17) {
                    char R28 = R(this.f15722f + 14);
                    char R29 = R(this.f15722f + 15);
                    char R30 = R(this.f15722f + 16);
                    if (R28 < '0' || R28 > '9' || R29 < '0' || R29 > '9' || R30 < '0' || R30 > '9') {
                        return false;
                    }
                    i14 = ((R28 - '0') * 100) + ((R29 - '0') * 10) + (R30 - '0');
                } else {
                    i14 = 0;
                }
                i13 = ((R24 - '0') * 10) + (R25 - '0');
                i12 = ((R26 - '0') * 10) + (R27 - '0');
                i27 = i14;
                i11 = ((R22 - '0') * 10) + (R23 - '0');
            } else {
                i13 = 0;
                i12 = 0;
                i11 = 0;
            }
            this.f15728l.set(11, i11);
            this.f15728l.set(12, i13);
            this.f15728l.set(13, i12);
            this.f15728l.set(14, i27);
            this.f15718b = 5;
            return true;
        } else if (i23 < 9) {
            return false;
        } else {
            char R31 = R(this.f15722f);
            char R32 = R(this.f15722f + 1);
            char R33 = R(this.f15722f + 2);
            char R34 = R(this.f15722f + 3);
            char R35 = R(this.f15722f + 4);
            char R36 = R(this.f15722f + 5);
            char R37 = R(this.f15722f + 6);
            char R38 = R(this.f15722f + 7);
            char R39 = R(this.f15722f + 8);
            char R40 = R(this.f15722f + 9);
            if ((R35 == '-' && R38 == '-') || (R35 == '/' && R38 == '/')) {
                R38 = R40;
                c11 = R36;
                R36 = R37;
                i15 = 10;
            } else {
                if (R35 == '-' && R37 == '-') {
                    if (R39 == ' ') {
                        c12 = '0';
                        i19 = 8;
                    } else {
                        i15 = 9;
                        c11 = '0';
                        char c13 = R39;
                        R39 = R38;
                        R38 = c13;
                    }
                } else if ((R33 == '.' && R36 == '.') || (R33 == '-' && R36 == '-')) {
                    R36 = R35;
                    R33 = R39;
                    R39 = R31;
                    R31 = R37;
                    i15 = 10;
                    char c14 = R38;
                    R38 = R32;
                    R32 = c14;
                    char c15 = R34;
                    R34 = R40;
                    c11 = c15;
                } else if (R35 != 24180 && R35 != 45380) {
                    return false;
                } else {
                    if (R38 == 26376 || R38 == 50900) {
                        if (R40 == 26085 || R40 == 51068) {
                            c12 = R36;
                            R36 = R37;
                            R38 = R39;
                            i19 = 10;
                        } else if (R(this.f15722f + 10) != 26085 && R(this.f15722f + 10) != 51068) {
                            return false;
                        } else {
                            R38 = R40;
                            c11 = R36;
                            R36 = R37;
                            i15 = 11;
                        }
                    } else if (R37 != 26376 && R37 != 50900) {
                        return false;
                    } else {
                        if (R39 == 26085 || R39 == 51068) {
                            i19 = 10;
                            c12 = '0';
                        } else if (R40 != 26085 && R40 != 51068) {
                            return false;
                        } else {
                            i15 = 10;
                            c11 = '0';
                            char c132 = R39;
                            R39 = R38;
                            R38 = c132;
                        }
                    }
                }
                R39 = '0';
            }
            if (!A0(R31, R32, R33, R34, c11, R36, R39, R38)) {
                return false;
            }
            E0(R31, R32, R33, R34, c11, R36, R39, R38);
            char R41 = R(this.f15722f + i15);
            if (R41 == 'T' || (R41 == ' ' && !z11)) {
                int i28 = i15 + 9;
                if (i23 < i28 || R(this.f15722f + i15 + 3) != ':' || R(this.f15722f + i15 + 6) != ':') {
                    return false;
                }
                char R42 = R(this.f15722f + i15 + 1);
                char R43 = R(this.f15722f + i15 + 2);
                char R44 = R(this.f15722f + i15 + 4);
                char R45 = R(this.f15722f + i15 + 5);
                char R46 = R(this.f15722f + i15 + 7);
                char R47 = R(this.f15722f + i15 + 8);
                if (!B0(R42, R43, R44, R45, R46, R47)) {
                    return false;
                }
                F0(R42, R43, R44, R45, R46, R47);
                char R48 = R(this.f15722f + i15 + 9);
                if (R48 == '.') {
                    int i29 = i15 + 11;
                    if (i23 >= i29 && (R = R(this.f15722f + i15 + 10)) >= '0' && R <= '9') {
                        int i30 = R - '0';
                        if (i23 <= i29 || (R4 = R(this.f15722f + i15 + 11)) < '0' || R4 > '9') {
                            i16 = 1;
                        } else {
                            i30 = (i30 * 10) + (R4 - '0');
                            i16 = 2;
                        }
                        if (i16 == 2 && (R3 = R(this.f15722f + i15 + 12)) >= '0' && R3 <= '9') {
                            i30 = (i30 * 10) + (R3 - '0');
                            i16 = 3;
                        }
                        this.f15728l.set(14, i30);
                        char R49 = R(this.f15722f + i15 + 10 + i16);
                        if (R49 == '+' || R49 == '-') {
                            char R50 = R(this.f15722f + i15 + 10 + i16 + 1);
                            if (R50 >= '0' && R50 <= '1' && (R2 = R(this.f15722f + i15 + 10 + i16 + 2)) >= '0' && R2 <= '9') {
                                char R51 = R(this.f15722f + i15 + 10 + i16 + 3);
                                if (R51 == ':') {
                                    if (R(this.f15722f + i15 + 10 + i16 + 4) != '0' || R(this.f15722f + i15 + 10 + i16 + 5) != '0') {
                                        return false;
                                    }
                                    i18 = 6;
                                } else if (R51 != '0') {
                                    i18 = 3;
                                } else if (R(this.f15722f + i15 + 10 + i16 + 4) != '0') {
                                    return false;
                                } else {
                                    i18 = 5;
                                }
                                G0(R49, R50, R2);
                                i17 = i18;
                            }
                        } else if (R49 == 'Z') {
                            if (this.f15728l.getTimeZone().getRawOffset() != 0) {
                                String[] availableIDs = TimeZone.getAvailableIDs(0);
                                if (availableIDs.length > 0) {
                                    this.f15728l.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                }
                            }
                            i17 = 1;
                        } else {
                            i17 = 0;
                        }
                        int i31 = i15 + 10 + i16 + i17;
                        char R52 = R(this.f15722f + i31);
                        if (R52 != 26 && R52 != '\"') {
                            return false;
                        }
                        int i32 = this.f15722f + i31;
                        this.f15722f = i32;
                        this.f15721e = R(i32);
                        this.f15718b = 5;
                        return true;
                    }
                    return false;
                }
                this.f15728l.set(14, 0);
                int i33 = this.f15722f + i28;
                this.f15722f = i33;
                this.f15721e = R(i33);
                this.f15718b = 5;
                if (R48 == 'Z' && this.f15728l.getTimeZone().getRawOffset() != 0) {
                    String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                    if (availableIDs2.length > 0) {
                        this.f15728l.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                    }
                }
                return true;
            } else if (R41 == '\"' || R41 == 26 || R41 == 26085 || R41 == 51068) {
                this.f15728l.set(11, 0);
                this.f15728l.set(12, 0);
                this.f15728l.set(13, 0);
                this.f15728l.set(14, 0);
                int i34 = this.f15722f + i15;
                this.f15722f = i34;
                this.f15721e = R(i34);
                this.f15718b = 5;
                return true;
            } else if ((R41 != '+' && R41 != '-') || this.f15738u != i15 + 6 || R(this.f15722f + i15 + 3) != ':' || R(this.f15722f + i15 + 4) != '0' || R(this.f15722f + i15 + 5) != '0') {
                return false;
            } else {
                F0('0', '0', '0', '0', '0', '0');
                this.f15728l.set(14, 0);
                G0(R41, R(this.f15722f + i15 + 1), R(this.f15722f + i15 + 2));
                return true;
            }
        }
    }

    public final void E0(char c11, char c12, char c13, char c14, char c15, char c16, char c17, char c18) {
        Calendar instance = Calendar.getInstance(this.f15729m, this.f15730n);
        this.f15728l = instance;
        instance.set(1, ((c11 - '0') * 1000) + ((c12 - '0') * 100) + ((c13 - '0') * 10) + (c14 - '0'));
        this.f15728l.set(2, (((c15 - '0') * 10) + (c16 - '0')) - 1);
        this.f15728l.set(5, ((c17 - '0') * 10) + (c18 - '0'));
    }

    public void F0(char c11, char c12, char c13, char c14, char c15, char c16) {
        this.f15728l.set(11, ((c11 - '0') * 10) + (c12 - '0'));
        this.f15728l.set(12, ((c13 - '0') * 10) + (c14 - '0'));
        this.f15728l.set(13, ((c15 - '0') * 10) + (c16 - '0'));
    }

    public final BigDecimal G() {
        char R = R((this.f15726j + this.f15725i) - 1);
        int i11 = this.f15725i;
        if (R == 'L' || R == 'S' || R == 'B' || R == 'F' || R == 'D') {
            i11--;
        }
        int i12 = this.f15726j;
        char[] cArr = this.f15724h;
        if (i11 < cArr.length) {
            this.f15737t.getChars(i12, i12 + i11, cArr, 0);
            return new BigDecimal(this.f15724h, 0, i11);
        }
        char[] cArr2 = new char[i11];
        this.f15737t.getChars(i12, i11 + i12, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    public void G0(char c11, char c12, char c13) {
        int i11 = (((c12 - '0') * 10) + (c13 - '0')) * 3600 * 1000;
        if (c11 == '-') {
            i11 = -i11;
        }
        if (this.f15728l.getTimeZone().getRawOffset() != i11) {
            String[] availableIDs = TimeZone.getAvailableIDs(i11);
            if (availableIDs.length > 0) {
                this.f15728l.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    public final String H() {
        if (!this.f15727k) {
            return x0(this.f15726j + 1, this.f15725i);
        }
        return new String(this.f15724h, 0, this.f15725i);
    }

    public final String N() {
        char R = R((this.f15726j + this.f15725i) - 1);
        int i11 = this.f15725i;
        if (R == 'L' || R == 'S' || R == 'B' || R == 'F' || R == 'D') {
            i11--;
        }
        return x0(this.f15726j, i11);
    }

    public final String O(int i11, int i12, int i13, g gVar) {
        return gVar.a(this.f15737t, i11, i12, i13);
    }

    public final void P(int i11, char[] cArr, int i12, int i13) {
        this.f15737t.getChars(i11, i13 + i11, cArr, i12);
    }

    public final boolean Q(char[] cArr) {
        return z0(this.f15737t, this.f15722f, cArr);
    }

    public final char R(int i11) {
        if (i11 >= this.f15738u) {
            return 26;
        }
        return this.f15737t.charAt(i11);
    }

    public final void S(int i11, int i12, char[] cArr) {
        this.f15737t.getChars(i11, i12 + i11, cArr, 0);
    }

    public final int V(char c11, int i11) {
        return this.f15737t.indexOf(c11, i11);
    }

    public boolean W() {
        int i11 = this.f15722f;
        int i12 = this.f15738u;
        if (i11 != i12) {
            return this.f15721e == 26 && i11 + 1 == i12;
        }
        return true;
    }

    public boolean f0(char[] cArr) {
        char c11;
        boolean z11;
        this.f15731o = 0;
        if (!z0(this.f15737t, this.f15722f, cArr)) {
            this.f15731o = -2;
            return false;
        }
        int length = this.f15722f + cArr.length;
        int i11 = length + 1;
        char R = R(length);
        if (R == 't') {
            int i12 = i11 + 1;
            if (R(i11) != 'r') {
                this.f15731o = -1;
                return false;
            }
            int i13 = i12 + 1;
            if (R(i12) != 'u') {
                this.f15731o = -1;
                return false;
            }
            int i14 = i13 + 1;
            if (R(i13) != 'e') {
                this.f15731o = -1;
                return false;
            }
            this.f15722f = i14;
            c11 = R(i14);
            z11 = true;
        } else if (R == 'f') {
            int i15 = i11 + 1;
            if (R(i11) != 'a') {
                this.f15731o = -1;
                return false;
            }
            int i16 = i15 + 1;
            if (R(i15) != 'l') {
                this.f15731o = -1;
                return false;
            }
            int i17 = i16 + 1;
            if (R(i16) != 's') {
                this.f15731o = -1;
                return false;
            }
            int i18 = i17 + 1;
            if (R(i17) != 'e') {
                this.f15731o = -1;
                return false;
            }
            this.f15722f = i18;
            c11 = R(i18);
            z11 = false;
        } else {
            this.f15731o = -1;
            return false;
        }
        while (true) {
            if (c11 == ',') {
                int i19 = this.f15722f + 1;
                this.f15722f = i19;
                this.f15721e = R(i19);
                this.f15731o = 3;
                this.f15718b = 16;
                break;
            } else if (c11 == '}') {
                int i21 = this.f15722f + 1;
                this.f15722f = i21;
                char R2 = R(i21);
                while (true) {
                    if (R2 == ',') {
                        this.f15718b = 16;
                        int i22 = this.f15722f + 1;
                        this.f15722f = i22;
                        this.f15721e = R(i22);
                        break;
                    } else if (R2 == ']') {
                        this.f15718b = 15;
                        int i23 = this.f15722f + 1;
                        this.f15722f = i23;
                        this.f15721e = R(i23);
                        break;
                    } else if (R2 == '}') {
                        this.f15718b = 13;
                        int i24 = this.f15722f + 1;
                        this.f15722f = i24;
                        this.f15721e = R(i24);
                        break;
                    } else if (R2 == 26) {
                        this.f15718b = 20;
                        break;
                    } else if (c.X(R2)) {
                        int i25 = this.f15722f + 1;
                        this.f15722f = i25;
                        R2 = R(i25);
                    } else {
                        this.f15731o = -1;
                        return false;
                    }
                }
                this.f15731o = 4;
            } else if (c.X(c11)) {
                int i26 = this.f15722f + 1;
                this.f15722f = i26;
                c11 = R(i26);
            } else {
                this.f15731o = -1;
                return false;
            }
        }
        return z11;
    }

    public final int g(char c11) {
        int i11;
        char R;
        this.f15731o = 0;
        int i12 = this.f15722f;
        int i13 = i12 + 1;
        char R2 = R(i12);
        boolean z11 = R2 == '-';
        if (z11) {
            char R3 = R(i13);
            i13++;
            R2 = R3;
        }
        if (R2 < '0' || R2 > '9') {
            this.f15731o = -1;
            return 0;
        }
        int i14 = R2 - '0';
        while (true) {
            i11 = i13 + 1;
            R = R(i13);
            if (R >= '0' && R <= '9') {
                i14 = (i14 * 10) + (R - '0');
                i13 = i11;
            }
        }
        if (R == '.') {
            this.f15731o = -1;
            return 0;
        } else if (i14 < 0) {
            this.f15731o = -1;
            return 0;
        } else {
            while (R != c11) {
                if (c.X(R)) {
                    R = R(i11);
                    i11++;
                } else {
                    this.f15731o = -1;
                    return z11 ? -i14 : i14;
                }
            }
            this.f15722f = i11;
            this.f15721e = R(i11);
            this.f15731o = 3;
            this.f15718b = 16;
            return z11 ? -i14 : i14;
        }
    }

    public byte[] j() {
        if (this.f15718b != 26) {
            return IOUtils.d(this.f15737t, this.f15726j + 1, this.f15725i);
        }
        int i11 = this.f15726j + 1;
        int i12 = this.f15725i;
        if (i12 % 2 == 0) {
            int i13 = i12 / 2;
            byte[] bArr = new byte[i13];
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = (i14 * 2) + i11;
                char charAt = this.f15737t.charAt(i15);
                char charAt2 = this.f15737t.charAt(i15 + 1);
                char c11 = '0';
                int i16 = charAt - (charAt <= '9' ? '0' : '7');
                if (charAt2 > '9') {
                    c11 = '7';
                }
                bArr[i14] = (byte) ((i16 << 4) | (charAt2 - c11));
            }
            return bArr;
        }
        throw new JSONException("illegal state. " + i12);
    }

    public int k0(char[] cArr) {
        boolean z11;
        int i11;
        char R;
        this.f15731o = 0;
        int i12 = this.f15722f;
        char c11 = this.f15721e;
        if (!z0(this.f15737t, i12, cArr)) {
            this.f15731o = -2;
            return 0;
        }
        int length = this.f15722f + cArr.length;
        int i13 = length + 1;
        char R2 = R(length);
        if (R2 == '-') {
            z11 = true;
            R2 = R(i13);
            i13++;
        } else {
            z11 = false;
        }
        if (R2 < '0' || R2 > '9') {
            this.f15731o = -1;
            return 0;
        }
        int i14 = R2 - '0';
        while (true) {
            i11 = i13 + 1;
            R = R(i13);
            if (R >= '0' && R <= '9') {
                i14 = (i14 * 10) + (R - '0');
                i13 = i11;
            }
        }
        if (R == '.') {
            this.f15731o = -1;
            return 0;
        } else if (i14 < 0) {
            this.f15731o = -1;
            return 0;
        } else {
            while (R != ',' && R != '}') {
                if (c.X(R)) {
                    char R3 = R(i11);
                    i11++;
                    R = R3;
                } else {
                    this.f15731o = -1;
                    return 0;
                }
            }
            int i15 = i11 - 1;
            this.f15722f = i15;
            if (R == ',') {
                int i16 = i15 + 1;
                this.f15722f = i16;
                this.f15721e = R(i16);
                this.f15731o = 3;
                this.f15718b = 16;
                return z11 ? -i14 : i14;
            }
            if (R == '}') {
                this.f15722f = i15;
                int i17 = i15 + 1;
                this.f15722f = i17;
                char R4 = R(i17);
                while (true) {
                    if (R4 == ',') {
                        this.f15718b = 16;
                        int i18 = this.f15722f + 1;
                        this.f15722f = i18;
                        this.f15721e = R(i18);
                        break;
                    } else if (R4 == ']') {
                        this.f15718b = 15;
                        int i19 = this.f15722f + 1;
                        this.f15722f = i19;
                        this.f15721e = R(i19);
                        break;
                    } else if (R4 == '}') {
                        this.f15718b = 13;
                        int i21 = this.f15722f + 1;
                        this.f15722f = i21;
                        this.f15721e = R(i21);
                        break;
                    } else if (R4 == 26) {
                        this.f15718b = 20;
                        break;
                    } else if (c.X(R4)) {
                        int i22 = this.f15722f + 1;
                        this.f15722f = i22;
                        R4 = R(i22);
                    } else {
                        this.f15722f = i12;
                        this.f15721e = c11;
                        this.f15731o = -1;
                        return 0;
                    }
                }
                this.f15731o = 4;
            }
            return z11 ? -i14 : i14;
        }
    }

    public long m0(char[] cArr) {
        int i11;
        char R;
        char[] cArr2 = cArr;
        boolean z11 = false;
        this.f15731o = 0;
        int i12 = this.f15722f;
        char c11 = this.f15721e;
        if (!z0(this.f15737t, i12, cArr2)) {
            this.f15731o = -2;
            return 0;
        }
        int length = this.f15722f + cArr2.length;
        int i13 = length + 1;
        char R2 = R(length);
        if (R2 == '-') {
            R2 = R(i13);
            i13++;
            z11 = true;
        }
        if (R2 < '0' || R2 > '9') {
            this.f15722f = i12;
            this.f15721e = c11;
            this.f15731o = -1;
            return 0;
        }
        long j11 = (long) (R2 - '0');
        while (true) {
            i11 = i13 + 1;
            R = R(i13);
            if (R >= '0' && R <= '9') {
                j11 = (j11 * 10) + ((long) (R - '0'));
                i13 = i11;
            }
        }
        if (R == '.') {
            this.f15731o = -1;
            return 0;
        }
        if (R == ',' || R == '}') {
            this.f15722f = i11 - 1;
        }
        if (j11 < 0) {
            this.f15722f = i12;
            this.f15721e = c11;
            this.f15731o = -1;
            return 0;
        }
        while (R != ',') {
            if (R == '}') {
                int i14 = this.f15722f + 1;
                this.f15722f = i14;
                char R3 = R(i14);
                while (true) {
                    if (R3 == ',') {
                        this.f15718b = 16;
                        int i15 = this.f15722f + 1;
                        this.f15722f = i15;
                        this.f15721e = R(i15);
                        break;
                    } else if (R3 == ']') {
                        this.f15718b = 15;
                        int i16 = this.f15722f + 1;
                        this.f15722f = i16;
                        this.f15721e = R(i16);
                        break;
                    } else if (R3 == '}') {
                        this.f15718b = 13;
                        int i17 = this.f15722f + 1;
                        this.f15722f = i17;
                        this.f15721e = R(i17);
                        break;
                    } else if (R3 == 26) {
                        this.f15718b = 20;
                        break;
                    } else if (c.X(R3)) {
                        int i18 = this.f15722f + 1;
                        this.f15722f = i18;
                        R3 = R(i18);
                    } else {
                        this.f15722f = i12;
                        this.f15721e = c11;
                        this.f15731o = -1;
                        return 0;
                    }
                }
                this.f15731o = 4;
                return z11 ? -j11 : j11;
            } else if (c.X(R)) {
                this.f15722f = i11;
                char R4 = R(i11);
                i11++;
                R = R4;
            } else {
                this.f15731o = -1;
                return 0;
            }
        }
        int i19 = this.f15722f + 1;
        this.f15722f = i19;
        this.f15721e = R(i19);
        this.f15731o = 3;
        this.f15718b = 16;
        return z11 ? -j11 : j11;
    }

    public String n0(char[] cArr) {
        this.f15731o = 0;
        int i11 = this.f15722f;
        char c11 = this.f15721e;
        if (!z0(this.f15737t, i11, cArr)) {
            this.f15731o = -2;
            return w0();
        }
        int length = this.f15722f + cArr.length;
        int i12 = length + 1;
        if (R(length) != '\"') {
            this.f15731o = -1;
            return w0();
        }
        int V = V('\"', i12);
        if (V != -1) {
            String x02 = x0(i12, V - i12);
            if (x02.indexOf(92) != -1) {
                while (true) {
                    int i13 = V - 1;
                    int i14 = 0;
                    while (i13 >= 0 && R(i13) == '\\') {
                        i14++;
                        i13--;
                    }
                    if (i14 % 2 == 0) {
                        break;
                    }
                    V = V('\"', V + 1);
                }
                int i15 = this.f15722f;
                int length2 = V - ((cArr.length + i15) + 1);
                x02 = c.d0(y0(i15 + cArr.length + 1, length2), length2);
            }
            char R = R(V + 1);
            while (R != ',' && R != '}') {
                if (c.X(R)) {
                    V++;
                    R = R(V + 1);
                } else {
                    this.f15731o = -1;
                    return w0();
                }
            }
            int i16 = V + 1;
            this.f15722f = i16;
            this.f15721e = R;
            if (R == ',') {
                int i17 = i16 + 1;
                this.f15722f = i17;
                this.f15721e = R(i17);
                this.f15731o = 3;
                return x02;
            }
            int i18 = i16 + 1;
            this.f15722f = i18;
            char R2 = R(i18);
            if (R2 == ',') {
                this.f15718b = 16;
                int i19 = this.f15722f + 1;
                this.f15722f = i19;
                this.f15721e = R(i19);
            } else if (R2 == ']') {
                this.f15718b = 15;
                int i21 = this.f15722f + 1;
                this.f15722f = i21;
                this.f15721e = R(i21);
            } else if (R2 == '}') {
                this.f15718b = 13;
                int i22 = this.f15722f + 1;
                this.f15722f = i22;
                this.f15721e = R(i22);
            } else if (R2 == 26) {
                this.f15718b = 20;
            } else {
                this.f15722f = i11;
                this.f15721e = c11;
                this.f15731o = -1;
                return w0();
            }
            this.f15731o = 4;
            return x02;
        }
        throw new JSONException("unclosed str");
    }

    public final char next() {
        char c11;
        int i11 = this.f15722f + 1;
        this.f15722f = i11;
        if (i11 >= this.f15738u) {
            c11 = 26;
        } else {
            c11 = this.f15737t.charAt(i11);
        }
        this.f15721e = c11;
        return c11;
    }

    public long o0(char[] cArr) {
        this.f15731o = 0;
        if (!z0(this.f15737t, this.f15722f, cArr)) {
            this.f15731o = -2;
            return 0;
        }
        int length = this.f15722f + cArr.length;
        int i11 = length + 1;
        if (R(length) != '\"') {
            this.f15731o = -1;
            return 0;
        }
        long j11 = -2128831035;
        while (true) {
            int i12 = i11 + 1;
            char R = R(i11);
            if (R == '\"') {
                this.f15722f = i12;
                char R2 = R(i12);
                this.f15721e = R2;
                while (R2 != ',') {
                    if (R2 == '}') {
                        next();
                        p();
                        char A = A();
                        if (A == ',') {
                            this.f15718b = 16;
                            int i13 = this.f15722f + 1;
                            this.f15722f = i13;
                            this.f15721e = R(i13);
                        } else if (A == ']') {
                            this.f15718b = 15;
                            int i14 = this.f15722f + 1;
                            this.f15722f = i14;
                            this.f15721e = R(i14);
                        } else if (A == '}') {
                            this.f15718b = 13;
                            int i15 = this.f15722f + 1;
                            this.f15722f = i15;
                            this.f15721e = R(i15);
                        } else if (A == 26) {
                            this.f15718b = 20;
                        } else {
                            this.f15731o = -1;
                            return 0;
                        }
                        this.f15731o = 4;
                        return j11;
                    } else if (c.X(R2)) {
                        int i16 = this.f15722f + 1;
                        this.f15722f = i16;
                        R2 = R(i16);
                    } else {
                        this.f15731o = -1;
                        return 0;
                    }
                }
                int i17 = this.f15722f + 1;
                this.f15722f = i17;
                this.f15721e = R(i17);
                this.f15731o = 3;
                return j11;
            } else if (i12 > this.f15738u) {
                this.f15731o = -1;
                return 0;
            } else {
                j11 = (j11 ^ ((long) R)) * 16777619;
                i11 = i12;
            }
        }
    }

    public long r(char c11) {
        int i11;
        char R;
        boolean z11 = false;
        this.f15731o = 0;
        int i12 = this.f15722f;
        int i13 = i12 + 1;
        char R2 = R(i12);
        if (R2 == '-') {
            z11 = true;
        }
        if (z11) {
            char R3 = R(i13);
            i13++;
            R2 = R3;
        }
        if (R2 < '0' || R2 > '9') {
            this.f15731o = -1;
            return 0;
        }
        long j11 = (long) (R2 - '0');
        while (true) {
            i11 = i13 + 1;
            R = R(i13);
            if (R >= '0' && R <= '9') {
                j11 = (j11 * 10) + ((long) (R - '0'));
                i13 = i11;
            }
        }
        if (R == '.') {
            this.f15731o = -1;
            return 0;
        } else if (j11 < 0) {
            this.f15731o = -1;
            return 0;
        } else {
            while (R != c11) {
                if (c.X(R)) {
                    R = R(i11);
                    i11++;
                } else {
                    this.f15731o = -1;
                    return j11;
                }
            }
            this.f15722f = i11;
            this.f15721e = R(i11);
            this.f15731o = 3;
            this.f15718b = 16;
            return z11 ? -j11 : j11;
        }
    }

    public String t() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("pos ");
        sb2.append(this.f15722f);
        sb2.append(", json : ");
        if (this.f15737t.length() < 65536) {
            str = this.f15737t;
        } else {
            str = this.f15737t.substring(0, 65536);
        }
        sb2.append(str);
        return sb2.toString();
    }

    public final String x0(int i11, int i12) {
        if (!ASMUtils.f14383b) {
            return this.f15737t.substring(i11, i12 + i11);
        }
        char[] cArr = this.f15724h;
        if (i12 < cArr.length) {
            this.f15737t.getChars(i11, i11 + i12, cArr, 0);
            return new String(this.f15724h, 0, i12);
        }
        char[] cArr2 = new char[i12];
        this.f15737t.getChars(i11, i12 + i11, cArr2, 0);
        return new String(cArr2);
    }

    public final char[] y0(int i11, int i12) {
        if (ASMUtils.f14383b) {
            char[] cArr = this.f15724h;
            if (i12 < cArr.length) {
                this.f15737t.getChars(i11, i12 + i11, cArr, 0);
                return this.f15724h;
            }
        }
        char[] cArr2 = new char[i12];
        this.f15737t.getChars(i11, i12 + i11, cArr2, 0);
        return cArr2;
    }

    public e(String str, int i11) {
        super(i11);
        this.f15737t = str;
        this.f15738u = str.length();
        this.f15722f = -1;
        next();
        if (this.f15721e == 65279) {
            next();
        }
    }

    public e(char[] cArr, int i11, int i12) {
        this(new String(cArr, 0, i11), i12);
    }
}
