package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huochat.community.base.CommunityConstants;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.android.tpush.common.MessageKey;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

public class JSONPath implements a {

    /* renamed from: f  reason: collision with root package name */
    public static int f14090f = 1024;

    /* renamed from: g  reason: collision with root package name */
    public static ConcurrentMap<String, JSONPath> f14091g = new ConcurrentHashMap(128, 0.75f, 1);

    /* renamed from: b  reason: collision with root package name */
    public final String f14092b;

    /* renamed from: c  reason: collision with root package name */
    public r[] f14093c;

    /* renamed from: d  reason: collision with root package name */
    public SerializeConfig f14094d;

    /* renamed from: e  reason: collision with root package name */
    public ParserConfig f14095e;

    public enum Operator {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN
    }

    public static class a implements r {

        /* renamed from: a  reason: collision with root package name */
        public final int f14096a;

        public a(int i11) {
            this.f14096a = i11;
        }

        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.f(obj2, this.f14096a);
        }
    }

    public static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final String f14097a;

        /* renamed from: b  reason: collision with root package name */
        public final double f14098b;

        /* renamed from: c  reason: collision with root package name */
        public final Operator f14099c;

        public b(String str, double d11, Operator operator) {
            this.f14097a = str;
            this.f14098b = d11;
            this.f14099c = operator;
        }

        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object h11 = jSONPath.h(obj3, this.f14097a, false);
            if (h11 == null || !(h11 instanceof Number)) {
                return false;
            }
            double doubleValue = ((Number) h11).doubleValue();
            Operator operator = this.f14099c;
            if (operator == Operator.EQ) {
                if (doubleValue == this.f14098b) {
                    return true;
                }
                return false;
            } else if (operator == Operator.NE) {
                if (doubleValue != this.f14098b) {
                    return true;
                }
                return false;
            } else if (operator == Operator.GE) {
                if (doubleValue >= this.f14098b) {
                    return true;
                }
                return false;
            } else if (operator == Operator.GT) {
                if (doubleValue > this.f14098b) {
                    return true;
                }
                return false;
            } else if (operator == Operator.LE) {
                if (doubleValue <= this.f14098b) {
                    return true;
                }
                return false;
            } else if (operator != Operator.LT || doubleValue >= this.f14098b) {
                return false;
            } else {
                return true;
            }
        }
    }

    public interface c {
        boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    public static class d implements r {

        /* renamed from: a  reason: collision with root package name */
        public final c f14100a;

        public d(c cVar) {
            this.f14100a = cVar;
        }

        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (obj2 instanceof Iterable) {
                for (Object next : (Iterable) obj2) {
                    if (this.f14100a.a(jSONPath, obj, obj2, next)) {
                        jSONArray.add(next);
                    }
                }
                return jSONArray;
            } else if (this.f14100a.a(jSONPath, obj, obj2, obj2)) {
                return obj2;
            } else {
                return null;
            }
        }
    }

    public static class e implements c {

        /* renamed from: a  reason: collision with root package name */
        public final String f14101a;

        /* renamed from: b  reason: collision with root package name */
        public final long f14102b;

        /* renamed from: c  reason: collision with root package name */
        public final long f14103c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f14104d;

        public e(String str, long j11, long j12, boolean z11) {
            this.f14101a = str;
            this.f14102b = j11;
            this.f14103c = j12;
            this.f14104d = z11;
        }

        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object h11 = jSONPath.h(obj3, this.f14101a, false);
            if (h11 == null) {
                return false;
            }
            if (h11 instanceof Number) {
                long longValue = ((Number) h11).longValue();
                if (longValue >= this.f14102b && longValue <= this.f14103c) {
                    return !this.f14104d;
                }
            }
            return this.f14104d;
        }
    }

    public static class f implements c {

        /* renamed from: a  reason: collision with root package name */
        public final String f14105a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f14106b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f14107c;

        public f(String str, long[] jArr, boolean z11) {
            this.f14105a = str;
            this.f14106b = jArr;
            this.f14107c = z11;
        }

        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object h11 = jSONPath.h(obj3, this.f14105a, false);
            if (h11 == null) {
                return false;
            }
            if (h11 instanceof Number) {
                long longValue = ((Number) h11).longValue();
                for (long j11 : this.f14106b) {
                    if (j11 == longValue) {
                        return !this.f14107c;
                    }
                }
            }
            return this.f14107c;
        }
    }

    public static class g implements c {

        /* renamed from: a  reason: collision with root package name */
        public final String f14108a;

        /* renamed from: b  reason: collision with root package name */
        public final Long[] f14109b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f14110c;

        public g(String str, Long[] lArr, boolean z11) {
            this.f14108a = str;
            this.f14109b = lArr;
            this.f14110c = z11;
        }

        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int i11 = 0;
            Object h11 = jSONPath.h(obj3, this.f14108a, false);
            if (h11 == null) {
                Long[] lArr = this.f14109b;
                int length = lArr.length;
                while (i11 < length) {
                    if (lArr[i11] == null) {
                        return !this.f14110c;
                    }
                    i11++;
                }
                return this.f14110c;
            }
            if (h11 instanceof Number) {
                long longValue = ((Number) h11).longValue();
                Long[] lArr2 = this.f14109b;
                int length2 = lArr2.length;
                while (i11 < length2) {
                    Long l11 = lArr2[i11];
                    if (l11 != null && l11.longValue() == longValue) {
                        return !this.f14110c;
                    }
                    i11++;
                }
            }
            return this.f14110c;
        }
    }

    public static class h implements c {

        /* renamed from: a  reason: collision with root package name */
        public final String f14111a;

        /* renamed from: b  reason: collision with root package name */
        public final long f14112b;

        /* renamed from: c  reason: collision with root package name */
        public final Operator f14113c;

        public h(String str, long j11, Operator operator) {
            this.f14111a = str;
            this.f14112b = j11;
            this.f14113c = operator;
        }

        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object h11 = jSONPath.h(obj3, this.f14111a, false);
            if (h11 == null || !(h11 instanceof Number)) {
                return false;
            }
            long longValue = ((Number) h11).longValue();
            Operator operator = this.f14113c;
            if (operator == Operator.EQ) {
                if (longValue == this.f14112b) {
                    return true;
                }
                return false;
            } else if (operator == Operator.NE) {
                if (longValue != this.f14112b) {
                    return true;
                }
                return false;
            } else if (operator == Operator.GE) {
                if (longValue >= this.f14112b) {
                    return true;
                }
                return false;
            } else if (operator == Operator.GT) {
                if (longValue > this.f14112b) {
                    return true;
                }
                return false;
            } else if (operator == Operator.LE) {
                if (longValue <= this.f14112b) {
                    return true;
                }
                return false;
            } else if (operator != Operator.LT || longValue >= this.f14112b) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public final String f14114a;

        /* renamed from: b  reason: collision with root package name */
        public int f14115b;

        /* renamed from: c  reason: collision with root package name */
        public char f14116c;

        /* renamed from: d  reason: collision with root package name */
        public int f14117d;

        public i(String str) {
            this.f14114a = str;
            f();
        }

        public static boolean d(char c11) {
            return c11 == '-' || c11 == '+' || (c11 >= '0' && c11 <= '9');
        }

        public void a(char c11) {
            if (this.f14116c != c11) {
                throw new JSONPathException("expect '" + c11 + ", but '" + this.f14116c + "'");
            } else if (!e()) {
                f();
            }
        }

        public r b(String str) {
            int length = str.length();
            int i11 = 0;
            char charAt = str.charAt(0);
            int i12 = 1;
            int i13 = length - 1;
            char charAt2 = str.charAt(i13);
            int indexOf = str.indexOf(44);
            int i14 = -1;
            if (str.length() <= 2 || charAt != '\'' || charAt2 != '\'') {
                int indexOf2 = str.indexOf(58);
                if (indexOf == -1 && indexOf2 == -1) {
                    if (!TypeUtils.S(str)) {
                        return new o(str, false);
                    }
                    try {
                        return new a(Integer.parseInt(str));
                    } catch (NumberFormatException unused) {
                        return new o(str, false);
                    }
                } else if (indexOf != -1) {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    int[] iArr = new int[split.length];
                    while (i11 < split.length) {
                        iArr[i11] = Integer.parseInt(split[i11]);
                        i11++;
                    }
                    return new k(iArr);
                } else if (indexOf2 != -1) {
                    String[] split2 = str.split(":");
                    int length2 = split2.length;
                    int[] iArr2 = new int[length2];
                    for (int i15 = 0; i15 < split2.length; i15++) {
                        String str2 = split2[i15];
                        if (str2.length() != 0) {
                            iArr2[i15] = Integer.parseInt(str2);
                        } else if (i15 == 0) {
                            iArr2[i15] = 0;
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    }
                    int i16 = iArr2[0];
                    if (length2 > 1) {
                        i14 = iArr2[1];
                    }
                    if (length2 == 3) {
                        i12 = iArr2[2];
                    }
                    if (i14 >= 0 && i14 < i16) {
                        throw new UnsupportedOperationException("end must greater than or equals start. start " + i16 + ",  end " + i14);
                    } else if (i12 > 0) {
                        return new p(i16, i14, i12);
                    } else {
                        throw new UnsupportedOperationException("step must greater than zero : " + i12);
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            } else if (indexOf == -1) {
                return new o(str.substring(1, i13), false);
            } else {
                String[] split3 = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String[] strArr = new String[split3.length];
                while (i11 < split3.length) {
                    String str3 = split3[i11];
                    strArr[i11] = str3.substring(1, str3.length() - 1);
                    i11++;
                }
                return new l(strArr);
            }
        }

        public r[] c() {
            String str = this.f14114a;
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException();
            }
            r[] rVarArr = new r[8];
            while (true) {
                r l11 = l();
                if (l11 == null) {
                    break;
                }
                int i11 = this.f14117d;
                if (i11 == rVarArr.length) {
                    r[] rVarArr2 = new r[((i11 * 3) / 2)];
                    System.arraycopy(rVarArr, 0, rVarArr2, 0, i11);
                    rVarArr = rVarArr2;
                }
                int i12 = this.f14117d;
                this.f14117d = i12 + 1;
                rVarArr[i12] = l11;
            }
            int i13 = this.f14117d;
            if (i13 == rVarArr.length) {
                return rVarArr;
            }
            r[] rVarArr3 = new r[i13];
            System.arraycopy(rVarArr, 0, rVarArr3, 0, i13);
            return rVarArr3;
        }

        public boolean e() {
            return this.f14115b >= this.f14114a.length();
        }

        public void f() {
            String str = this.f14114a;
            int i11 = this.f14115b;
            this.f14115b = i11 + 1;
            this.f14116c = str.charAt(i11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0088  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.alibaba.fastjson.JSONPath.r g(boolean r15) {
            /*
                r14 = this;
                if (r15 == 0) goto L_0x0007
                r0 = 91
                r14.a(r0)
            L_0x0007:
                char r0 = r14.f14116c
                r1 = 63
                r2 = 40
                r3 = 46
                r4 = 0
                r5 = 1
                if (r0 != r1) goto L_0x0027
                r14.f()
                r14.a(r2)
                char r0 = r14.f14116c
                r1 = 64
                if (r0 != r1) goto L_0x0025
                r14.f()
                r14.a(r3)
            L_0x0025:
                r0 = r5
                goto L_0x0028
            L_0x0027:
                r0 = r4
            L_0x0028:
                r1 = -1
                r6 = 93
                if (r0 != 0) goto L_0x0098
                char r7 = r14.f14116c
                boolean r7 = com.alibaba.fastjson.util.IOUtils.h(r7)
                if (r7 == 0) goto L_0x0036
                goto L_0x0098
            L_0x0036:
                int r2 = r14.f14115b
                int r2 = r2 - r5
            L_0x0039:
                char r7 = r14.f14116c
                r8 = 47
                if (r7 == r6) goto L_0x005b
                if (r7 == r8) goto L_0x005b
                boolean r7 = r14.e()
                if (r7 != 0) goto L_0x005b
                char r7 = r14.f14116c
                if (r7 != r3) goto L_0x0050
                if (r0 != 0) goto L_0x0050
                if (r0 != 0) goto L_0x0050
                goto L_0x005b
            L_0x0050:
                r8 = 92
                if (r7 != r8) goto L_0x0057
                r14.f()
            L_0x0057:
                r14.f()
                goto L_0x0039
            L_0x005b:
                if (r15 == 0) goto L_0x0061
                int r0 = r14.f14115b
            L_0x005f:
                int r0 = r0 - r5
                goto L_0x006e
            L_0x0061:
                char r0 = r14.f14116c
                if (r0 == r8) goto L_0x006b
                if (r0 != r3) goto L_0x0068
                goto L_0x006b
            L_0x0068:
                int r0 = r14.f14115b
                goto L_0x006e
            L_0x006b:
                int r0 = r14.f14115b
                goto L_0x005f
            L_0x006e:
                java.lang.String r3 = r14.f14114a
                java.lang.String r0 = r3.substring(r2, r0)
                java.lang.String r2 = "\\."
                int r3 = r0.indexOf(r2)
                if (r3 == r1) goto L_0x0088
                java.lang.String r15 = "\\\\\\."
                java.lang.String r15 = r0.replaceAll(r15, r2)
                com.alibaba.fastjson.JSONPath$o r0 = new com.alibaba.fastjson.JSONPath$o
                r0.<init>(r15, r4)
                return r0
            L_0x0088:
                com.alibaba.fastjson.JSONPath$r r0 = r14.b(r0)
                if (r15 == 0) goto L_0x0097
                boolean r15 = r14.e()
                if (r15 != 0) goto L_0x0097
                r14.a(r6)
            L_0x0097:
                return r0
            L_0x0098:
                java.lang.String r8 = r14.j()
                r14.o()
                r7 = 41
                if (r0 == 0) goto L_0x00ba
                char r9 = r14.f14116c
                if (r9 != r7) goto L_0x00ba
                r14.f()
                if (r15 == 0) goto L_0x00af
                r14.a(r6)
            L_0x00af:
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$m r0 = new com.alibaba.fastjson.JSONPath$m
                r0.<init>(r8)
                r15.<init>(r0)
                return r15
            L_0x00ba:
                if (r15 == 0) goto L_0x00ce
                char r9 = r14.f14116c
                if (r9 != r6) goto L_0x00ce
                r14.f()
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$m r0 = new com.alibaba.fastjson.JSONPath$m
                r0.<init>(r8)
                r15.<init>(r0)
                return r15
            L_0x00ce:
                com.alibaba.fastjson.JSONPath$Operator r9 = r14.k()
                r14.o()
                com.alibaba.fastjson.JSONPath$Operator r10 = com.alibaba.fastjson.JSONPath.Operator.BETWEEN
                if (r9 == r10) goto L_0x0404
                com.alibaba.fastjson.JSONPath$Operator r10 = com.alibaba.fastjson.JSONPath.Operator.NOT_BETWEEN
                if (r9 != r10) goto L_0x00df
                goto L_0x0404
            L_0x00df:
                com.alibaba.fastjson.JSONPath$Operator r10 = com.alibaba.fastjson.JSONPath.Operator.IN
                if (r9 == r10) goto L_0x02c7
                com.alibaba.fastjson.JSONPath$Operator r10 = com.alibaba.fastjson.JSONPath.Operator.NOT_IN
                if (r9 != r10) goto L_0x00e9
                goto L_0x02c7
            L_0x00e9:
                char r2 = r14.f14116c
                r10 = 39
                if (r2 == r10) goto L_0x01f3
                r10 = 34
                if (r2 != r10) goto L_0x00f5
                goto L_0x01f3
            L_0x00f5:
                boolean r1 = d(r2)
                if (r1 == 0) goto L_0x012f
                long r1 = r14.i()
                char r4 = r14.f14116c
                r10 = 0
                if (r4 != r3) goto L_0x010a
                double r3 = r14.h(r1)
                goto L_0x010b
            L_0x010a:
                r3 = r10
            L_0x010b:
                if (r0 == 0) goto L_0x0110
                r14.a(r7)
            L_0x0110:
                if (r15 == 0) goto L_0x0115
                r14.a(r6)
            L_0x0115:
                int r15 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
                if (r15 != 0) goto L_0x0124
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$h r0 = new com.alibaba.fastjson.JSONPath$h
                r0.<init>(r8, r1, r9)
                r15.<init>(r0)
                return r15
            L_0x0124:
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$b r0 = new com.alibaba.fastjson.JSONPath$b
                r0.<init>(r8, r3, r9)
                r15.<init>(r0)
                return r15
            L_0x012f:
                char r15 = r14.f14116c
                r1 = 110(0x6e, float:1.54E-43)
                if (r15 != r1) goto L_0x016d
                java.lang.String r15 = r14.j()
                java.lang.String r1 = "null"
                boolean r15 = r1.equals(r15)
                if (r15 == 0) goto L_0x01ed
                if (r0 == 0) goto L_0x0146
                r14.a(r7)
            L_0x0146:
                r14.a(r6)
                com.alibaba.fastjson.JSONPath$Operator r15 = com.alibaba.fastjson.JSONPath.Operator.EQ
                if (r9 != r15) goto L_0x0158
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$n r0 = new com.alibaba.fastjson.JSONPath$n
                r0.<init>(r8)
                r15.<init>(r0)
                return r15
            L_0x0158:
                com.alibaba.fastjson.JSONPath$Operator r15 = com.alibaba.fastjson.JSONPath.Operator.NE
                if (r9 != r15) goto L_0x0167
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$m r0 = new com.alibaba.fastjson.JSONPath$m
                r0.<init>(r8)
                r15.<init>(r0)
                return r15
            L_0x0167:
                java.lang.UnsupportedOperationException r15 = new java.lang.UnsupportedOperationException
                r15.<init>()
                throw r15
            L_0x016d:
                r1 = 116(0x74, float:1.63E-43)
                if (r15 != r1) goto L_0x01ad
                java.lang.String r15 = r14.j()
                java.lang.String r1 = "true"
                boolean r15 = r1.equals(r15)
                if (r15 == 0) goto L_0x01ed
                if (r0 == 0) goto L_0x0182
                r14.a(r7)
            L_0x0182:
                r14.a(r6)
                com.alibaba.fastjson.JSONPath$Operator r15 = com.alibaba.fastjson.JSONPath.Operator.EQ
                if (r9 != r15) goto L_0x0196
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$v r0 = new com.alibaba.fastjson.JSONPath$v
                java.lang.Boolean r1 = java.lang.Boolean.TRUE
                r0.<init>(r8, r1, r5)
                r15.<init>(r0)
                return r15
            L_0x0196:
                com.alibaba.fastjson.JSONPath$Operator r15 = com.alibaba.fastjson.JSONPath.Operator.NE
                if (r9 != r15) goto L_0x01a7
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$v r0 = new com.alibaba.fastjson.JSONPath$v
                java.lang.Boolean r1 = java.lang.Boolean.TRUE
                r0.<init>(r8, r1, r4)
                r15.<init>(r0)
                return r15
            L_0x01a7:
                java.lang.UnsupportedOperationException r15 = new java.lang.UnsupportedOperationException
                r15.<init>()
                throw r15
            L_0x01ad:
                r1 = 102(0x66, float:1.43E-43)
                if (r15 != r1) goto L_0x01ed
                java.lang.String r15 = r14.j()
                java.lang.String r1 = "false"
                boolean r15 = r1.equals(r15)
                if (r15 == 0) goto L_0x01ed
                if (r0 == 0) goto L_0x01c2
                r14.a(r7)
            L_0x01c2:
                r14.a(r6)
                com.alibaba.fastjson.JSONPath$Operator r15 = com.alibaba.fastjson.JSONPath.Operator.EQ
                if (r9 != r15) goto L_0x01d6
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$v r0 = new com.alibaba.fastjson.JSONPath$v
                java.lang.Boolean r1 = java.lang.Boolean.FALSE
                r0.<init>(r8, r1, r5)
                r15.<init>(r0)
                return r15
            L_0x01d6:
                com.alibaba.fastjson.JSONPath$Operator r15 = com.alibaba.fastjson.JSONPath.Operator.NE
                if (r9 != r15) goto L_0x01e7
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$v r0 = new com.alibaba.fastjson.JSONPath$v
                java.lang.Boolean r1 = java.lang.Boolean.FALSE
                r0.<init>(r8, r1, r4)
                r15.<init>(r0)
                return r15
            L_0x01e7:
                java.lang.UnsupportedOperationException r15 = new java.lang.UnsupportedOperationException
                r15.<init>()
                throw r15
            L_0x01ed:
                java.lang.UnsupportedOperationException r15 = new java.lang.UnsupportedOperationException
                r15.<init>()
                throw r15
            L_0x01f3:
                java.lang.String r2 = r14.m()
                if (r0 == 0) goto L_0x01fc
                r14.a(r7)
            L_0x01fc:
                if (r15 == 0) goto L_0x0201
                r14.a(r6)
            L_0x0201:
                com.alibaba.fastjson.JSONPath$Operator r15 = com.alibaba.fastjson.JSONPath.Operator.RLIKE
                if (r9 != r15) goto L_0x0210
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$q r0 = new com.alibaba.fastjson.JSONPath$q
                r0.<init>(r8, r2, r4)
                r15.<init>(r0)
                return r15
            L_0x0210:
                com.alibaba.fastjson.JSONPath$Operator r15 = com.alibaba.fastjson.JSONPath.Operator.NOT_RLIKE
                if (r9 != r15) goto L_0x021f
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$q r0 = new com.alibaba.fastjson.JSONPath$q
                r0.<init>(r8, r2, r5)
                r15.<init>(r0)
                return r15
            L_0x021f:
                com.alibaba.fastjson.JSONPath$Operator r15 = com.alibaba.fastjson.JSONPath.Operator.LIKE
                if (r9 == r15) goto L_0x0227
                com.alibaba.fastjson.JSONPath$Operator r15 = com.alibaba.fastjson.JSONPath.Operator.NOT_LIKE
                if (r9 != r15) goto L_0x024e
            L_0x0227:
                java.lang.String r15 = "%%"
                int r0 = r2.indexOf(r15)
                java.lang.String r3 = "%"
                if (r0 == r1) goto L_0x0236
                java.lang.String r2 = r2.replaceAll(r15, r3)
                goto L_0x0227
            L_0x0236:
                com.alibaba.fastjson.JSONPath$Operator r15 = com.alibaba.fastjson.JSONPath.Operator.NOT_LIKE
                if (r9 != r15) goto L_0x023c
                r12 = r5
                goto L_0x023d
            L_0x023c:
                r12 = r4
            L_0x023d:
                r15 = 37
                int r0 = r2.indexOf(r15)
                if (r0 != r1) goto L_0x0259
                com.alibaba.fastjson.JSONPath$Operator r15 = com.alibaba.fastjson.JSONPath.Operator.LIKE
                if (r9 != r15) goto L_0x024c
                com.alibaba.fastjson.JSONPath$Operator r9 = com.alibaba.fastjson.JSONPath.Operator.EQ
                goto L_0x024e
            L_0x024c:
                com.alibaba.fastjson.JSONPath$Operator r9 = com.alibaba.fastjson.JSONPath.Operator.NE
            L_0x024e:
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$u r0 = new com.alibaba.fastjson.JSONPath$u
                r0.<init>(r8, r2, r9)
                r15.<init>(r0)
                return r15
            L_0x0259:
                java.lang.String[] r1 = r2.split(r3)
                r3 = 0
                r6 = 2
                if (r0 != 0) goto L_0x028b
                int r0 = r2.length()
                int r0 = r0 - r5
                char r0 = r2.charAt(r0)
                if (r0 != r15) goto L_0x0275
                int r15 = r1.length
                int r15 = r15 - r5
                java.lang.String[] r0 = new java.lang.String[r15]
                java.lang.System.arraycopy(r1, r5, r0, r4, r15)
                r11 = r0
                goto L_0x0297
            L_0x0275:
                int r15 = r1.length
                int r15 = r15 - r5
                r15 = r1[r15]
                int r0 = r1.length
                if (r0 <= r6) goto L_0x0287
                int r0 = r1.length
                int r0 = r0 - r6
                java.lang.String[] r2 = new java.lang.String[r0]
                java.lang.System.arraycopy(r1, r5, r2, r4, r0)
                r10 = r15
                r11 = r2
                r9 = r3
                goto L_0x02bb
            L_0x0287:
                r10 = r15
                r9 = r3
                r11 = r9
                goto L_0x02bb
            L_0x028b:
                int r0 = r2.length()
                int r0 = r0 - r5
                char r0 = r2.charAt(r0)
                if (r0 != r15) goto L_0x029a
                r11 = r1
            L_0x0297:
                r9 = r3
                r10 = r9
                goto L_0x02bb
            L_0x029a:
                int r15 = r1.length
                if (r15 != r5) goto L_0x02a3
                r15 = r1[r4]
                r9 = r15
                r10 = r3
                r11 = r10
                goto L_0x02bb
            L_0x02a3:
                int r15 = r1.length
                if (r15 != r6) goto L_0x02ab
                r15 = r1[r4]
                r0 = r1[r5]
                goto L_0x02b8
            L_0x02ab:
                r15 = r1[r4]
                int r0 = r1.length
                int r0 = r0 - r5
                r0 = r1[r0]
                int r2 = r1.length
                int r2 = r2 - r6
                java.lang.String[] r3 = new java.lang.String[r2]
                java.lang.System.arraycopy(r1, r5, r3, r4, r2)
            L_0x02b8:
                r9 = r15
                r10 = r0
                r11 = r3
            L_0x02bb:
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$j r0 = new com.alibaba.fastjson.JSONPath$j
                r7 = r0
                r7.<init>(r8, r9, r10, r11, r12)
                r15.<init>(r0)
                return r15
            L_0x02c7:
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.NOT_IN
                if (r9 != r1) goto L_0x02cd
                r1 = r5
                goto L_0x02ce
            L_0x02cd:
                r1 = r4
            L_0x02ce:
                r14.a(r2)
                com.alibaba.fastjson.JSONArray r2 = new com.alibaba.fastjson.JSONArray
                r2.<init>()
                java.lang.Object r3 = r14.n()
                r2.add(r3)
            L_0x02dd:
                r14.o()
                char r3 = r14.f14116c
                r9 = 44
                if (r3 == r9) goto L_0x03f8
                r14.a(r7)
                if (r0 == 0) goto L_0x02ee
                r14.a(r7)
            L_0x02ee:
                if (r15 == 0) goto L_0x02f3
                r14.a(r6)
            L_0x02f3:
                java.util.Iterator r15 = r2.iterator()
                r0 = r5
                r3 = r0
                r6 = r3
            L_0x02fa:
                boolean r7 = r15.hasNext()
                if (r7 == 0) goto L_0x032a
                java.lang.Object r7 = r15.next()
                if (r7 != 0) goto L_0x030a
                if (r0 == 0) goto L_0x02fa
                r0 = r4
                goto L_0x02fa
            L_0x030a:
                java.lang.Class r7 = r7.getClass()
                if (r0 == 0) goto L_0x0322
                java.lang.Class<java.lang.Byte> r9 = java.lang.Byte.class
                if (r7 == r9) goto L_0x0322
                java.lang.Class<java.lang.Short> r9 = java.lang.Short.class
                if (r7 == r9) goto L_0x0322
                java.lang.Class<java.lang.Integer> r9 = java.lang.Integer.class
                if (r7 == r9) goto L_0x0322
                java.lang.Class<java.lang.Long> r9 = java.lang.Long.class
                if (r7 == r9) goto L_0x0322
                r0 = r4
                r6 = r0
            L_0x0322:
                if (r3 == 0) goto L_0x02fa
                java.lang.Class<java.lang.String> r9 = java.lang.String.class
                if (r7 == r9) goto L_0x02fa
                r3 = r4
                goto L_0x02fa
            L_0x032a:
                int r15 = r2.size()
                if (r15 != r5) goto L_0x034e
                java.lang.Object r15 = r2.get(r4)
                if (r15 != 0) goto L_0x034e
                if (r1 == 0) goto L_0x0343
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$m r0 = new com.alibaba.fastjson.JSONPath$m
                r0.<init>(r8)
                r15.<init>(r0)
                return r15
            L_0x0343:
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$n r0 = new com.alibaba.fastjson.JSONPath$n
                r0.<init>(r8)
                r15.<init>(r0)
                return r15
            L_0x034e:
                if (r0 == 0) goto L_0x0394
                int r15 = r2.size()
                if (r15 != r5) goto L_0x0372
                java.lang.Object r15 = r2.get(r4)
                java.lang.Number r15 = (java.lang.Number) r15
                long r2 = r15.longValue()
                if (r1 == 0) goto L_0x0365
                com.alibaba.fastjson.JSONPath$Operator r15 = com.alibaba.fastjson.JSONPath.Operator.NE
                goto L_0x0367
            L_0x0365:
                com.alibaba.fastjson.JSONPath$Operator r15 = com.alibaba.fastjson.JSONPath.Operator.EQ
            L_0x0367:
                com.alibaba.fastjson.JSONPath$d r0 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$h r1 = new com.alibaba.fastjson.JSONPath$h
                r1.<init>(r8, r2, r15)
                r0.<init>(r1)
                return r0
            L_0x0372:
                int r15 = r2.size()
                long[] r0 = new long[r15]
            L_0x0378:
                if (r4 >= r15) goto L_0x0389
                java.lang.Object r3 = r2.get(r4)
                java.lang.Number r3 = (java.lang.Number) r3
                long r5 = r3.longValue()
                r0[r4] = r5
                int r4 = r4 + 1
                goto L_0x0378
            L_0x0389:
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$f r2 = new com.alibaba.fastjson.JSONPath$f
                r2.<init>(r8, r0, r1)
                r15.<init>(r2)
                return r15
            L_0x0394:
                if (r3 == 0) goto L_0x03c8
                int r15 = r2.size()
                if (r15 != r5) goto L_0x03b4
                java.lang.Object r15 = r2.get(r4)
                java.lang.String r15 = (java.lang.String) r15
                if (r1 == 0) goto L_0x03a7
                com.alibaba.fastjson.JSONPath$Operator r0 = com.alibaba.fastjson.JSONPath.Operator.NE
                goto L_0x03a9
            L_0x03a7:
                com.alibaba.fastjson.JSONPath$Operator r0 = com.alibaba.fastjson.JSONPath.Operator.EQ
            L_0x03a9:
                com.alibaba.fastjson.JSONPath$d r1 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$u r2 = new com.alibaba.fastjson.JSONPath$u
                r2.<init>(r8, r15, r0)
                r1.<init>(r2)
                return r1
            L_0x03b4:
                int r15 = r2.size()
                java.lang.String[] r15 = new java.lang.String[r15]
                r2.toArray(r15)
                com.alibaba.fastjson.JSONPath$d r0 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$t r2 = new com.alibaba.fastjson.JSONPath$t
                r2.<init>(r8, r15, r1)
                r0.<init>(r2)
                return r0
            L_0x03c8:
                if (r6 == 0) goto L_0x03f2
                int r15 = r2.size()
                java.lang.Long[] r0 = new java.lang.Long[r15]
            L_0x03d0:
                if (r4 >= r15) goto L_0x03e7
                java.lang.Object r3 = r2.get(r4)
                java.lang.Number r3 = (java.lang.Number) r3
                if (r3 == 0) goto L_0x03e4
                long r5 = r3.longValue()
                java.lang.Long r3 = java.lang.Long.valueOf(r5)
                r0[r4] = r3
            L_0x03e4:
                int r4 = r4 + 1
                goto L_0x03d0
            L_0x03e7:
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                com.alibaba.fastjson.JSONPath$g r2 = new com.alibaba.fastjson.JSONPath$g
                r2.<init>(r8, r0, r1)
                r15.<init>(r2)
                return r15
            L_0x03f2:
                java.lang.UnsupportedOperationException r15 = new java.lang.UnsupportedOperationException
                r15.<init>()
                throw r15
            L_0x03f8:
                r14.f()
                java.lang.Object r3 = r14.n()
                r2.add(r3)
                goto L_0x02dd
            L_0x0404:
                com.alibaba.fastjson.JSONPath$Operator r15 = com.alibaba.fastjson.JSONPath.Operator.NOT_BETWEEN
                if (r9 != r15) goto L_0x040a
                r13 = r5
                goto L_0x040b
            L_0x040a:
                r13 = r4
            L_0x040b:
                java.lang.Object r15 = r14.n()
                java.lang.String r0 = r14.j()
                java.lang.String r1 = "and"
                boolean r0 = r1.equalsIgnoreCase(r0)
                if (r0 == 0) goto L_0x045f
                java.lang.Object r0 = r14.n()
                if (r15 == 0) goto L_0x0457
                if (r0 == 0) goto L_0x0457
                java.lang.Class r1 = r15.getClass()
                boolean r1 = com.alibaba.fastjson.JSONPath.k(r1)
                if (r1 == 0) goto L_0x044f
                java.lang.Class r1 = r0.getClass()
                boolean r1 = com.alibaba.fastjson.JSONPath.k(r1)
                if (r1 == 0) goto L_0x044f
                com.alibaba.fastjson.JSONPath$e r1 = new com.alibaba.fastjson.JSONPath$e
                java.lang.Number r15 = (java.lang.Number) r15
                long r9 = r15.longValue()
                java.lang.Number r0 = (java.lang.Number) r0
                long r11 = r0.longValue()
                r7 = r1
                r7.<init>(r8, r9, r11, r13)
                com.alibaba.fastjson.JSONPath$d r15 = new com.alibaba.fastjson.JSONPath$d
                r15.<init>(r1)
                return r15
            L_0x044f:
                com.alibaba.fastjson.JSONPathException r15 = new com.alibaba.fastjson.JSONPathException
                java.lang.String r0 = r14.f14114a
                r15.<init>(r0)
                throw r15
            L_0x0457:
                com.alibaba.fastjson.JSONPathException r15 = new com.alibaba.fastjson.JSONPathException
                java.lang.String r0 = r14.f14114a
                r15.<init>(r0)
                throw r15
            L_0x045f:
                com.alibaba.fastjson.JSONPathException r15 = new com.alibaba.fastjson.JSONPathException
                java.lang.String r0 = r14.f14114a
                r15.<init>(r0)
                throw r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.i.g(boolean):com.alibaba.fastjson.JSONPath$r");
        }

        public double h(long j11) {
            int i11 = this.f14115b - 1;
            f();
            while (true) {
                char c11 = this.f14116c;
                if (c11 < '0' || c11 > '9') {
                } else {
                    f();
                }
            }
            return Double.parseDouble(this.f14114a.substring(i11, this.f14115b - 1)) + ((double) j11);
        }

        public long i() {
            int i11 = this.f14115b - 1;
            char c11 = this.f14116c;
            if (c11 == '+' || c11 == '-') {
                f();
            }
            while (true) {
                char c12 = this.f14116c;
                if (c12 < '0' || c12 > '9') {
                } else {
                    f();
                }
            }
            return Long.parseLong(this.f14114a.substring(i11, this.f14115b - 1));
        }

        public String j() {
            o();
            char c11 = this.f14116c;
            if (c11 == '\\' || IOUtils.h(c11)) {
                StringBuilder sb2 = new StringBuilder();
                while (!e()) {
                    char c12 = this.f14116c;
                    if (c12 == '\\') {
                        f();
                        sb2.append(this.f14116c);
                        if (e()) {
                            break;
                        }
                        f();
                    } else if (!IOUtils.l(c12)) {
                        break;
                    } else {
                        sb2.append(this.f14116c);
                        f();
                    }
                }
                if (e() && IOUtils.l(this.f14116c)) {
                    sb2.append(this.f14116c);
                }
                return sb2.toString();
            }
            throw new JSONPathException("illeal jsonpath syntax. " + this.f14114a);
        }

        public Operator k() {
            Operator operator;
            char c11 = this.f14116c;
            if (c11 == '=') {
                f();
                operator = Operator.EQ;
            } else if (c11 == '!') {
                f();
                a('=');
                operator = Operator.NE;
            } else if (c11 == '<') {
                f();
                if (this.f14116c == '=') {
                    f();
                    operator = Operator.LE;
                } else {
                    operator = Operator.LT;
                }
            } else if (c11 == '>') {
                f();
                if (this.f14116c == '=') {
                    f();
                    operator = Operator.GE;
                } else {
                    operator = Operator.GT;
                }
            } else {
                operator = null;
            }
            if (operator != null) {
                return operator;
            }
            String j11 = j();
            if ("not".equalsIgnoreCase(j11)) {
                o();
                String j12 = j();
                if (CommunityConstants.REQUEST_KEY_LINE.equalsIgnoreCase(j12)) {
                    return Operator.NOT_LIKE;
                }
                if ("rlike".equalsIgnoreCase(j12)) {
                    return Operator.NOT_RLIKE;
                }
                if ("in".equalsIgnoreCase(j12)) {
                    return Operator.NOT_IN;
                }
                if ("between".equalsIgnoreCase(j12)) {
                    return Operator.NOT_BETWEEN;
                }
                throw new UnsupportedOperationException();
            } else if (CommunityConstants.REQUEST_KEY_LINE.equalsIgnoreCase(j11)) {
                return Operator.LIKE;
            } else {
                if ("rlike".equalsIgnoreCase(j11)) {
                    return Operator.RLIKE;
                }
                if ("in".equalsIgnoreCase(j11)) {
                    return Operator.IN;
                }
                if ("between".equalsIgnoreCase(j11)) {
                    return Operator.BETWEEN;
                }
                throw new UnsupportedOperationException();
            }
        }

        public r l() {
            boolean z11 = true;
            if (this.f14117d == 0 && this.f14114a.length() == 1) {
                if (d(this.f14116c)) {
                    return new a(this.f14116c - '0');
                }
                char c11 = this.f14116c;
                if ((c11 >= 'a' && c11 <= 'z') || (c11 >= 'A' && c11 <= 'Z')) {
                    return new o(Character.toString(c11), false);
                }
            }
            while (!e()) {
                o();
                char c12 = this.f14116c;
                if (c12 == '$') {
                    f();
                } else if (c12 == '.' || c12 == '/') {
                    f();
                    if (c12 == '.' && this.f14116c == '.') {
                        f();
                    } else {
                        z11 = false;
                    }
                    char c13 = this.f14116c;
                    if (c13 == '*') {
                        if (!e()) {
                            f();
                        }
                        return w.f14146a;
                    } else if (d(c13)) {
                        return g(false);
                    } else {
                        String j11 = j();
                        if (this.f14116c != '(') {
                            return new o(j11, z11);
                        }
                        f();
                        if (this.f14116c == ')') {
                            if (!e()) {
                                f();
                            }
                            if ("size".equals(j11)) {
                                return s.f14136a;
                            }
                            throw new UnsupportedOperationException();
                        }
                        throw new UnsupportedOperationException();
                    }
                } else if (c12 == '[') {
                    return g(true);
                } else {
                    if (this.f14117d == 0) {
                        return new o(j(), false);
                    }
                    throw new UnsupportedOperationException();
                }
            }
            return null;
        }

        public String m() {
            char c11 = this.f14116c;
            f();
            int i11 = this.f14115b - 1;
            while (this.f14116c != c11 && !e()) {
                f();
            }
            String substring = this.f14114a.substring(i11, e() ? this.f14115b : this.f14115b - 1);
            a(c11);
            return substring;
        }

        public Object n() {
            o();
            if (d(this.f14116c)) {
                return Long.valueOf(i());
            }
            char c11 = this.f14116c;
            if (c11 == '\"' || c11 == '\'') {
                return m();
            }
            if (c11 != 'n') {
                throw new UnsupportedOperationException();
            } else if (OptionsBridge.NULL_VALUE.equals(j())) {
                return null;
            } else {
                throw new JSONPathException(this.f14114a);
            }
        }

        public final void o() {
            while (true) {
                char c11 = this.f14116c;
                if (c11 > ' ') {
                    return;
                }
                if (c11 == ' ' || c11 == 13 || c11 == 10 || c11 == 9 || c11 == 12 || c11 == 8) {
                    f();
                } else {
                    return;
                }
            }
        }
    }

    public static class j implements c {

        /* renamed from: a  reason: collision with root package name */
        public final String f14118a;

        /* renamed from: b  reason: collision with root package name */
        public final String f14119b;

        /* renamed from: c  reason: collision with root package name */
        public final String f14120c;

        /* renamed from: d  reason: collision with root package name */
        public final String[] f14121d;

        /* renamed from: e  reason: collision with root package name */
        public final int f14122e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f14123f;

        public j(String str, String str2, String str3, String[] strArr, boolean z11) {
            this.f14118a = str;
            this.f14119b = str2;
            this.f14120c = str3;
            this.f14121d = strArr;
            this.f14123f = z11;
            int length = str2 != null ? str2.length() + 0 : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                for (String length2 : strArr) {
                    length += length2.length();
                }
            }
            this.f14122e = length;
        }

        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int i11;
            Object h11 = jSONPath.h(obj3, this.f14118a, false);
            if (h11 == null) {
                return false;
            }
            String obj4 = h11.toString();
            if (obj4.length() < this.f14122e) {
                return this.f14123f;
            }
            String str = this.f14119b;
            if (str == null) {
                i11 = 0;
            } else if (!obj4.startsWith(str)) {
                return this.f14123f;
            } else {
                i11 = this.f14119b.length() + 0;
            }
            String[] strArr = this.f14121d;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int indexOf = obj4.indexOf(str2, i11);
                    if (indexOf == -1) {
                        return this.f14123f;
                    }
                    i11 = indexOf + str2.length();
                }
            }
            String str3 = this.f14120c;
            if (str3 == null || obj4.endsWith(str3)) {
                return !this.f14123f;
            }
            return this.f14123f;
        }
    }

    public static class k implements r {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f14124a;

        public k(int[] iArr) {
            this.f14124a = iArr;
        }

        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.f14124a.length);
            int i11 = 0;
            while (true) {
                int[] iArr = this.f14124a;
                if (i11 >= iArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.f(obj2, iArr[i11]));
                i11++;
            }
        }
    }

    public static class l implements r {

        /* renamed from: a  reason: collision with root package name */
        public final String[] f14125a;

        public l(String[] strArr) {
            this.f14125a = strArr;
        }

        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.f14125a.length);
            for (String h11 : this.f14125a) {
                arrayList.add(jSONPath.h(obj2, h11, true));
            }
            return arrayList;
        }
    }

    public static class m implements c {

        /* renamed from: a  reason: collision with root package name */
        public final String f14126a;

        public m(String str) {
            this.f14126a = str;
        }

        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.h(obj3, this.f14126a, false) != null;
        }
    }

    public static class n implements c {

        /* renamed from: a  reason: collision with root package name */
        public final String f14127a;

        public n(String str) {
            this.f14127a = str;
        }

        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.h(obj3, this.f14127a, false) == null;
        }
    }

    public static class o implements r {

        /* renamed from: a  reason: collision with root package name */
        public final String f14128a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f14129b;

        public o(String str, boolean z11) {
            this.f14128a = str;
            this.f14129b = z11;
        }

        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            if (!this.f14129b) {
                return jSONPath.h(obj2, this.f14128a, true);
            }
            ArrayList arrayList = new ArrayList();
            jSONPath.b(obj2, this.f14128a, arrayList);
            return arrayList;
        }
    }

    public static class p implements r {

        /* renamed from: a  reason: collision with root package name */
        public final int f14130a;

        /* renamed from: b  reason: collision with root package name */
        public final int f14131b;

        /* renamed from: c  reason: collision with root package name */
        public final int f14132c;

        public p(int i11, int i12, int i13) {
            this.f14130a = i11;
            this.f14131b = i12;
            this.f14132c = i13;
        }

        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            int intValue = s.f14136a.a(jSONPath, obj, obj2).intValue();
            int i11 = this.f14130a;
            if (i11 < 0) {
                i11 += intValue;
            }
            int i12 = this.f14131b;
            if (i12 < 0) {
                i12 += intValue;
            }
            int i13 = ((i12 - i11) / this.f14132c) + 1;
            if (i13 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i13);
            while (i11 <= i12 && i11 < intValue) {
                arrayList.add(jSONPath.f(obj2, i11));
                i11 += this.f14132c;
            }
            return arrayList;
        }
    }

    public static class q implements c {

        /* renamed from: a  reason: collision with root package name */
        public final String f14133a;

        /* renamed from: b  reason: collision with root package name */
        public final Pattern f14134b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f14135c;

        public q(String str, String str2, boolean z11) {
            this.f14133a = str;
            this.f14134b = Pattern.compile(str2);
            this.f14135c = z11;
        }

        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object h11 = jSONPath.h(obj3, this.f14133a, false);
            if (h11 == null) {
                return false;
            }
            boolean matches = this.f14134b.matcher(h11.toString()).matches();
            return this.f14135c ? !matches : matches;
        }
    }

    public interface r {
        Object a(JSONPath jSONPath, Object obj, Object obj2);
    }

    public static class s implements r {

        /* renamed from: a  reason: collision with root package name */
        public static final s f14136a = new s();

        /* renamed from: b */
        public Integer a(JSONPath jSONPath, Object obj, Object obj2) {
            return Integer.valueOf(jSONPath.e(obj2));
        }
    }

    public static class t implements c {

        /* renamed from: a  reason: collision with root package name */
        public final String f14137a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f14138b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f14139c;

        public t(String str, String[] strArr, boolean z11) {
            this.f14137a = str;
            this.f14138b = strArr;
            this.f14139c = z11;
        }

        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object h11 = jSONPath.h(obj3, this.f14137a, false);
            for (String str : this.f14138b) {
                if (str == h11) {
                    return !this.f14139c;
                }
                if (str != null && str.equals(h11)) {
                    return !this.f14139c;
                }
            }
            return this.f14139c;
        }
    }

    public static class u implements c {

        /* renamed from: a  reason: collision with root package name */
        public final String f14140a;

        /* renamed from: b  reason: collision with root package name */
        public final String f14141b;

        /* renamed from: c  reason: collision with root package name */
        public final Operator f14142c;

        public u(String str, String str2, Operator operator) {
            this.f14140a = str;
            this.f14141b = str2;
            this.f14142c = operator;
        }

        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object h11 = jSONPath.h(obj3, this.f14140a, false);
            Operator operator = this.f14142c;
            if (operator == Operator.EQ) {
                return this.f14141b.equals(h11);
            }
            if (operator == Operator.NE) {
                return !this.f14141b.equals(h11);
            }
            if (h11 == null) {
                return false;
            }
            int compareTo = this.f14141b.compareTo(h11.toString());
            Operator operator2 = this.f14142c;
            if (operator2 == Operator.GE) {
                if (compareTo <= 0) {
                    return true;
                }
                return false;
            } else if (operator2 == Operator.GT) {
                if (compareTo < 0) {
                    return true;
                }
                return false;
            } else if (operator2 == Operator.LE) {
                if (compareTo >= 0) {
                    return true;
                }
                return false;
            } else if (operator2 != Operator.LT || compareTo <= 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static class v implements c {

        /* renamed from: a  reason: collision with root package name */
        public final String f14143a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f14144b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f14145c = true;

        public v(String str, Object obj, boolean z11) {
            if (obj != null) {
                this.f14143a = str;
                this.f14144b = obj;
                this.f14145c = z11;
                return;
            }
            throw new IllegalArgumentException("value is null");
        }

        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean equals = this.f14144b.equals(jSONPath.h(obj3, this.f14143a, false));
            return !this.f14145c ? !equals : equals;
        }
    }

    public static class w implements r {

        /* renamed from: a  reason: collision with root package name */
        public static w f14146a = new w();

        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.i(obj2);
        }
    }

    public JSONPath(String str) {
        this(str, SerializeConfig.d(), ParserConfig.m());
    }

    public static JSONPath a(String str) {
        if (str != null) {
            JSONPath jSONPath = (JSONPath) f14091g.get(str);
            if (jSONPath != null) {
                return jSONPath;
            }
            JSONPath jSONPath2 = new JSONPath(str);
            if (f14091g.size() >= f14090f) {
                return jSONPath2;
            }
            f14091g.putIfAbsent(str, jSONPath2);
            return (JSONPath) f14091g.get(str);
        }
        throw new JSONPathException("jsonpath can not be null");
    }

    public static Object d(Object obj, String str) {
        return a(str).c(obj);
    }

    public static boolean k(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    public void b(Object obj, String str, List<Object> list) {
        if (obj != null) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.containsKey(str)) {
                    list.add(map.get(str));
                    return;
                }
                for (Object b11 : map.values()) {
                    b(b11, str, list);
                }
                return;
            }
            h2.h g11 = g(obj.getClass());
            if (g11 != null) {
                try {
                    h2.f r11 = g11.r(str);
                    if (r11 != null) {
                        list.add(r11.c(obj));
                        return;
                    }
                    for (Object b12 : g11.t(obj)) {
                        b(b12, str, list);
                    }
                } catch (InvocationTargetException e11) {
                    throw new JSONException("getFieldValue error." + str, e11);
                } catch (IllegalAccessException e12) {
                    throw new JSONException("getFieldValue error." + str, e12);
                } catch (Exception e13) {
                    throw new JSONPathException("jsonpath error, path " + this.f14092b + ", segement " + str, e13);
                }
            } else if (obj instanceof List) {
                List list2 = (List) obj;
                for (int i11 = 0; i11 < list2.size(); i11++) {
                    b(list2.get(i11), str, list);
                }
            }
        }
    }

    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        j();
        int i11 = 0;
        Object obj2 = obj;
        while (true) {
            r[] rVarArr = this.f14093c;
            if (i11 >= rVarArr.length) {
                return obj2;
            }
            obj2 = rVarArr[i11].a(this, obj, obj2);
            i11++;
        }
    }

    public int e(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        if (obj instanceof Map) {
            int i11 = 0;
            for (Object obj2 : ((Map) obj).values()) {
                if (obj2 != null) {
                    i11++;
                }
            }
            return i11;
        }
        h2.h g11 = g(obj.getClass());
        if (g11 == null) {
            return -1;
        }
        try {
            return g11.v(obj);
        } catch (Exception e11) {
            throw new JSONPathException("evalSize error : " + this.f14092b, e11);
        }
    }

    public Object f(Object obj, int i11) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i11 >= 0) {
                if (i11 < list.size()) {
                    return list.get(i11);
                }
                return null;
            } else if (Math.abs(i11) <= list.size()) {
                return list.get(list.size() + i11);
            } else {
                return null;
            }
        } else if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i11 >= 0) {
                if (i11 < length) {
                    return Array.get(obj, i11);
                }
                return null;
            } else if (Math.abs(i11) <= length) {
                return Array.get(obj, length + i11);
            } else {
                return null;
            }
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i11));
            return obj2 == null ? map.get(Integer.toString(i11)) : obj2;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public h2.h g(Class<?> cls) {
        h2.k e11 = this.f14094d.e(cls);
        if (e11 instanceof h2.h) {
            return (h2.h) e11;
        }
        return null;
    }

    public Object h(Object obj, String str, boolean z11) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(str);
            return (obj2 != null || !"size".equals(str)) ? obj2 : Integer.valueOf(map.size());
        }
        h2.h g11 = g(obj.getClass());
        if (g11 != null) {
            try {
                return g11.s(obj, str);
            } catch (Exception e11) {
                throw new JSONPathException("jsonpath error, path " + this.f14092b + ", segement " + str, e11);
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            if ("size".equals(str)) {
                return Integer.valueOf(list.size());
            }
            JSONArray jSONArray = new JSONArray(list.size());
            for (int i11 = 0; i11 < list.size(); i11++) {
                Object h11 = h(list.get(i11), str, z11);
                if (h11 instanceof Collection) {
                    jSONArray.addAll((Collection) h11);
                } else {
                    jSONArray.add(h11);
                }
            }
            return jSONArray;
        } else {
            if (obj instanceof Enum) {
                Enum enumR = (Enum) obj;
                if ("name".equals(str)) {
                    return enumR.name();
                }
                if ("ordinal".equals(str)) {
                    return Integer.valueOf(enumR.ordinal());
                }
            }
            if (obj instanceof Calendar) {
                Calendar calendar = (Calendar) obj;
                if ("year".equals(str)) {
                    return Integer.valueOf(calendar.get(1));
                }
                if ("month".equals(str)) {
                    return Integer.valueOf(calendar.get(2));
                }
                if (MTPushConstants.NotificationTime.KEY_DAYS.equals(str)) {
                    return Integer.valueOf(calendar.get(5));
                }
                if (MessageKey.MSG_ACCEPT_TIME_HOUR.equals(str)) {
                    return Integer.valueOf(calendar.get(11));
                }
                if ("minute".equals(str)) {
                    return Integer.valueOf(calendar.get(12));
                }
                if ("second".equals(str)) {
                    return Integer.valueOf(calendar.get(13));
                }
            }
            throw new JSONPathException("jsonpath error, path " + this.f14092b + ", segement " + str);
        }
    }

    public Collection<Object> i(Object obj) {
        h2.h g11 = g(obj.getClass());
        if (g11 != null) {
            try {
                return g11.t(obj);
            } catch (Exception e11) {
                throw new JSONPathException("jsonpath error, path " + this.f14092b, e11);
            }
        } else if (obj instanceof Map) {
            return ((Map) obj).values();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void j() {
        if (this.f14093c == null) {
            if ("*".equals(this.f14092b)) {
                this.f14093c = new r[]{w.f14146a};
                return;
            }
            this.f14093c = new i(this.f14092b).c();
        }
    }

    public String toJSONString() {
        return JSON.toJSONString(this.f14092b);
    }

    public JSONPath(String str, SerializeConfig serializeConfig, ParserConfig parserConfig) {
        if (str == null || str.length() == 0) {
            throw new JSONPathException("json-path can not be null or empty");
        }
        this.f14092b = str;
        this.f14094d = serializeConfig;
        this.f14095e = parserConfig;
    }
}
