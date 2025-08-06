package g2;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import com.xiaomi.mipush.sdk.Constants;
import d2.d;
import f2.a;
import f2.c;
import f2.f;
import i2.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class k implements l {

    /* renamed from: a  reason: collision with root package name */
    public final i[] f15810a;

    /* renamed from: b  reason: collision with root package name */
    public final i[] f15811b;

    /* renamed from: c  reason: collision with root package name */
    public final Class<?> f15812c;

    /* renamed from: d  reason: collision with root package name */
    public final b f15813d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f15814e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, i> f15815f;

    public k(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, b.c(cls, type, parserConfig.f14186d, parserConfig.f14193k, parserConfig.f14194l));
    }

    public static boolean m(int i11, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        int i12 = i11 / 32;
        int i13 = i11 % 32;
        if (i12 < iArr.length) {
            if (((1 << i13) & iArr[i12]) != 0) {
                return true;
            }
        }
        return false;
    }

    public int b() {
        return 12;
    }

    public void c(f2.b bVar, int i11) {
        if (bVar.J() != i11) {
            throw new JSONException("syntax error");
        }
    }

    public Object d(a aVar, Type type) {
        Object obj;
        if (!(type instanceof Class) || !this.f15812c.isInterface()) {
            b bVar = this.f15813d;
            Constructor<?> constructor = bVar.f15985c;
            Object obj2 = null;
            if (constructor == null && bVar.f15987e == null) {
                return null;
            }
            Method method = bVar.f15987e;
            if (method != null && bVar.f15989g > 0) {
                return null;
            }
            try {
                if (bVar.f15989g != 0) {
                    f l11 = aVar.l();
                    if (l11 != null) {
                        if (l11.f15739a != null) {
                            if (type instanceof Class) {
                                String name = ((Class) type).getName();
                                String substring = name.substring(0, name.lastIndexOf(36));
                                Object obj3 = l11.f15739a;
                                String name2 = obj3.getClass().getName();
                                if (!name2.equals(substring)) {
                                    f fVar = l11.f15740b;
                                    if (!(fVar == null || fVar.f15739a == null || ((!"java.util.ArrayList".equals(name2) && !"java.util.List".equals(name2) && !"java.util.Collection".equals(name2) && !"java.util.Map".equals(name2) && !"java.util.HashMap".equals(name2)) || !fVar.f15739a.getClass().getName().equals(substring)))) {
                                        obj2 = fVar.f15739a;
                                    }
                                    obj3 = obj2;
                                }
                                if (obj3 != null) {
                                    obj = constructor.newInstance(new Object[]{obj3});
                                } else {
                                    throw new JSONException("can't create non-static inner class instance.");
                                }
                            } else {
                                throw new JSONException("can't create non-static inner class instance.");
                            }
                        }
                    }
                    throw new JSONException("can't create non-static inner class instance.");
                } else if (constructor != null) {
                    obj = constructor.newInstance(new Object[0]);
                } else {
                    obj = method.invoke((Object) null, new Object[0]);
                }
                if (aVar != null && aVar.f15701g.a(Feature.InitStringFieldAsEmpty)) {
                    for (i2.a aVar2 : this.f15813d.f15990h) {
                        if (aVar2.f15966f == String.class) {
                            try {
                                aVar2.l(obj, "");
                            } catch (Exception e11) {
                                throw new JSONException("create instance error, class " + this.f15812c.getName(), e11);
                            }
                        }
                    }
                }
                return obj;
            } catch (JSONException e12) {
                throw e12;
            } catch (Exception e13) {
                throw new JSONException("create instance error, class " + this.f15812c.getName(), e13);
            }
        } else {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
    }

    public <T> T e(a aVar, Type type, Object obj) {
        return g(aVar, type, obj, 0);
    }

    public Object f(Map<String, Object> map, ParserConfig parserConfig) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        b bVar = this.f15813d;
        if (bVar.f15986d == null && bVar.f15987e == null) {
            Object d11 = d((a) null, this.f15812c);
            for (Map.Entry next : map.entrySet()) {
                Object value = next.getValue();
                i q11 = q((String) next.getKey());
                if (q11 != null) {
                    q11.e(d11, TypeUtils.f(value, q11.f15808a.f15967g, parserConfig));
                }
            }
            Method method = this.f15813d.f15988f;
            if (method == null) {
                return d11;
            }
            try {
                return method.invoke(d11, new Object[0]);
            } catch (Exception e11) {
                throw new JSONException("build object error", e11);
            }
        } else {
            i2.a[] aVarArr = bVar.f15990h;
            int length = aVarArr.length;
            Object[] objArr = new Object[length];
            for (int i11 = 0; i11 < length; i11++) {
                i2.a aVar = aVarArr[i11];
                char c11 = map.get(aVar.f15962b);
                if (c11 == null) {
                    Class<?> cls = aVar.f15966f;
                    if (cls == Integer.TYPE) {
                        c11 = 0;
                    } else if (cls == Long.TYPE) {
                        c11 = 0L;
                    } else if (cls == Short.TYPE) {
                        c11 = (short) 0;
                    } else if (cls == Byte.TYPE) {
                        c11 = (byte) 0;
                    } else if (cls == Float.TYPE) {
                        c11 = Float.valueOf(0.0f);
                    } else if (cls == Double.TYPE) {
                        c11 = Double.valueOf(0.0d);
                    } else if (cls == Character.TYPE) {
                        c11 = '0';
                    } else if (cls == Boolean.TYPE) {
                        c11 = Boolean.FALSE;
                    }
                }
                objArr[i11] = c11;
            }
            b bVar2 = this.f15813d;
            Constructor<?> constructor = bVar2.f15986d;
            if (constructor != null) {
                try {
                    return constructor.newInstance(objArr);
                } catch (Exception e12) {
                    throw new JSONException("create instance error, " + this.f15813d.f15986d.toGenericString(), e12);
                }
            } else {
                Method method2 = bVar2.f15987e;
                if (method2 == null) {
                    return null;
                }
                try {
                    return method2.invoke((Object) null, objArr);
                } catch (Exception e13) {
                    throw new JSONException("create factory method error, " + this.f15813d.f15987e.toString(), e13);
                }
            }
        }
    }

    public <T> T g(a aVar, Type type, Object obj, int i11) {
        return h(aVar, type, obj, (Object) null, i11, (int[]) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:195:0x024a, code lost:
        if (r7 == -2) goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0289, code lost:
        r11.y(4);
        r2 = r11.J();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0291, code lost:
        if (r2 != 4) goto L_0x030d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0293, code lost:
        r0 = r11.H();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x029d, code lost:
        if (com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText.TIM_MENTION_TAG.equals(r0) == false) goto L_0x02a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x029f, code lost:
        r1 = r15.f15739a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x02a9, code lost:
        if ("..".equals(r0) == false) goto L_0x02bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x02ab, code lost:
        r2 = r15.f15740b;
        r3 = r2.f15739a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x02af, code lost:
        if (r3 == null) goto L_0x02b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x02b1, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x02b3, code lost:
        r9.f(new f2.a.C0078a(r2, r0));
        r9.f15706l = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x02c5, code lost:
        if ("$".equals(r0) == false) goto L_0x02df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x02c7, code lost:
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x02c8, code lost:
        r3 = r2.f15740b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x02ca, code lost:
        if (r3 == null) goto L_0x02ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x02cc, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x02ce, code lost:
        r3 = r2.f15739a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x02d0, code lost:
        if (r3 == null) goto L_0x02d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x02d3, code lost:
        r9.f(new f2.a.C0078a(r2, r0));
        r9.f15706l = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x02df, code lost:
        r9.f(new f2.a.C0078a(r15, r0));
        r9.f15706l = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x02ea, code lost:
        r11.f(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x02f3, code lost:
        if (r11.J() != 13) goto L_0x0305;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x02f5, code lost:
        r11.f(16);
        r9.R(r15, r1, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x02fd, code lost:
        if (r6 == null) goto L_0x0301;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x02ff, code lost:
        r6.f15739a = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0301, code lost:
        r9.T(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0304, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x030c, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0327, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.a(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x039a, code lost:
        r14 = r25;
        r0 = r18;
        r27 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:343:0x04bd, code lost:
        r1 = r17;
        r6 = r18;
        r0 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x04c3, code lost:
        if (r1 != null) goto L_0x058e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x04c5, code lost:
        if (r0 != null) goto L_0x04d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:?, code lost:
        r1 = d(r24, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x04cb, code lost:
        if (r6 != null) goto L_0x04d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x04cd, code lost:
        r6 = r9.R(r15, r1, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x04d1, code lost:
        if (r6 == null) goto L_0x04d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x04d3, code lost:
        r6.f15739a = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x04d5, code lost:
        r9.T(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x04d8, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:?, code lost:
        r2 = r8.f15813d.f15990h;
        r3 = r2.length;
        r4 = new java.lang.Object[r3];
        r5 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x04e2, code lost:
        if (r5 >= r3) goto L_0x0536;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x04e4, code lost:
        r7 = r2[r5];
        r10 = r0.get(r7.f15962b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x04ec, code lost:
        if (r10 != null) goto L_0x0531;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x04ee, code lost:
        r7 = r7.f15967g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x04f2, code lost:
        if (r7 != java.lang.Byte.TYPE) goto L_0x04f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x04f4, code lost:
        r10 = java.lang.Byte.valueOf(r27);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x04fb, code lost:
        if (r7 != java.lang.Short.TYPE) goto L_0x0502;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x04fd, code lost:
        r10 = java.lang.Short.valueOf(r27);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x0504, code lost:
        if (r7 != java.lang.Integer.TYPE) goto L_0x050b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x0506, code lost:
        r10 = java.lang.Integer.valueOf(r27);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x050d, code lost:
        if (r7 != java.lang.Long.TYPE) goto L_0x0516;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x050f, code lost:
        r10 = 0L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x0518, code lost:
        if (r7 != java.lang.Float.TYPE) goto L_0x0520;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x051a, code lost:
        r10 = java.lang.Float.valueOf(0.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x0522, code lost:
        if (r7 != java.lang.Double.TYPE) goto L_0x052b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0524, code lost:
        r10 = java.lang.Double.valueOf(0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x052d, code lost:
        if (r7 != java.lang.Boolean.TYPE) goto L_0x0531;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x052f, code lost:
        r10 = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x0531, code lost:
        r4[r5] = r10;
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x0536, code lost:
        r0 = r8.f15813d;
        r2 = r0.f15986d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x053a, code lost:
        if (r2 == null) goto L_0x0563;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:?, code lost:
        r0 = r2.newInstance(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x0540, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:391:0x0563, code lost:
        r0 = r0.f15987e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:392:0x0565, code lost:
        if (r0 == null) goto L_0x058e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:395:?, code lost:
        r0 = r0.invoke((java.lang.Object) null, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:401:0x058e, code lost:
        r0 = r8.f15813d.f15988f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x0592, code lost:
        if (r0 != null) goto L_0x059c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x0594, code lost:
        if (r6 == null) goto L_0x0598;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:404:0x0596, code lost:
        r6.f15739a = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x0598, code lost:
        r9.T(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x059b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:409:?, code lost:
        r0 = r0.invoke(r1, new java.lang.Object[r27]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x05a4, code lost:
        if (r6 == null) goto L_0x05a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:411:0x05a6, code lost:
        r6.f15739a = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:412:0x05a8, code lost:
        r9.T(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x05ab, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0259 A[Catch:{ Exception -> 0x05ac, Exception -> 0x056d, Exception -> 0x0542, all -> 0x0608 }] */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x03bf A[Catch:{ Exception -> 0x05ac, Exception -> 0x056d, Exception -> 0x0542, all -> 0x0608 }] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x03d0 A[Catch:{ Exception -> 0x05ac, Exception -> 0x056d, Exception -> 0x0542, all -> 0x0608 }] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x03e0 A[Catch:{ Exception -> 0x05ac, Exception -> 0x056d, Exception -> 0x0542, all -> 0x0608 }] */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x0469  */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x04b1 A[Catch:{ all -> 0x0602 }] */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x04b4 A[Catch:{ all -> 0x0602 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e A[Catch:{ all -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:438:0x0611  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T h(f2.a r24, java.lang.reflect.Type r25, java.lang.Object r26, java.lang.Object r27, int r28, int[] r29) {
        /*
            r23 = this;
            r8 = r23
            r9 = r24
            r0 = r25
            r10 = r26
            java.lang.Class<com.alibaba.fastjson.JSON> r1 = com.alibaba.fastjson.JSON.class
            if (r0 == r1) goto L_0x0617
            java.lang.Class<com.alibaba.fastjson.JSONObject> r1 = com.alibaba.fastjson.JSONObject.class
            if (r0 != r1) goto L_0x0012
            goto L_0x0617
        L_0x0012:
            f2.b r1 = r9.f15701g
            r11 = r1
            f2.c r11 = (f2.c) r11
            com.alibaba.fastjson.parser.ParserConfig r12 = r24.k()
            int r1 = r11.J()
            r2 = 8
            r13 = 16
            r14 = 0
            if (r1 != r2) goto L_0x002a
            r11.f(r13)
            return r14
        L_0x002a:
            f2.f r2 = r24.l()
            if (r27 == 0) goto L_0x0034
            if (r2 == 0) goto L_0x0034
            f2.f r2 = r2.f15740b
        L_0x0034:
            r15 = r2
            r7 = 13
            if (r1 != r7) goto L_0x004e
            r11.f(r13)     // Catch:{ all -> 0x0049 }
            if (r27 != 0) goto L_0x0043
            java.lang.Object r0 = r23.d(r24, r25)     // Catch:{ all -> 0x0049 }
            goto L_0x0045
        L_0x0043:
            r0 = r27
        L_0x0045:
            r9.T(r15)
            return r0
        L_0x0049:
            r0 = move-exception
        L_0x004a:
            r1 = r27
            goto L_0x060f
        L_0x004e:
            r2 = 14
            r6 = 0
            if (r1 != r2) goto L_0x0076
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean     // Catch:{ all -> 0x0049 }
            int r4 = r3.mask     // Catch:{ all -> 0x0049 }
            i2.b r5 = r8.f15813d     // Catch:{ all -> 0x0049 }
            int r5 = r5.f15992j     // Catch:{ all -> 0x0049 }
            r5 = r5 & r4
            if (r5 != 0) goto L_0x006b
            boolean r3 = r11.a(r3)     // Catch:{ all -> 0x0049 }
            if (r3 != 0) goto L_0x006b
            r3 = r28 & r4
            if (r3 == 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r3 = r6
            goto L_0x006c
        L_0x006b:
            r3 = 1
        L_0x006c:
            if (r3 == 0) goto L_0x0076
            java.lang.Object r0 = r23.i(r24, r25, r26, r27)     // Catch:{ all -> 0x0049 }
            r9.T(r15)
            return r0
        L_0x0076:
            r3 = 12
            r5 = 4
            if (r1 == r3) goto L_0x010b
            if (r1 == r13) goto L_0x010b
            boolean r0 = r11.E()     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0087
            r9.T(r15)
            return r14
        L_0x0087:
            if (r1 != r5) goto L_0x00ba
            java.lang.String r0 = r11.H()     // Catch:{ all -> 0x0049 }
            int r3 = r0.length()     // Catch:{ all -> 0x0049 }
            if (r3 != 0) goto L_0x009a
            r11.nextToken()     // Catch:{ all -> 0x0049 }
            r9.T(r15)
            return r14
        L_0x009a:
            i2.b r3 = r8.f15813d     // Catch:{ all -> 0x0049 }
            d2.d r3 = r3.f15993k     // Catch:{ all -> 0x0049 }
            java.lang.Class[] r3 = r3.seeAlso()     // Catch:{ all -> 0x0049 }
            int r4 = r3.length     // Catch:{ all -> 0x0049 }
        L_0x00a3:
            if (r6 >= r4) goto L_0x00ba
            r5 = r3[r6]     // Catch:{ all -> 0x0049 }
            java.lang.Class<java.lang.Enum> r7 = java.lang.Enum.class
            boolean r7 = r7.isAssignableFrom(r5)     // Catch:{ all -> 0x0049 }
            if (r7 == 0) goto L_0x00b7
            java.lang.Enum r0 = java.lang.Enum.valueOf(r5, r0)     // Catch:{ IllegalArgumentException -> 0x00b7 }
            r9.T(r15)
            return r0
        L_0x00b7:
            int r6 = r6 + 1
            goto L_0x00a3
        L_0x00ba:
            if (r1 != r2) goto L_0x00ce
            char r0 = r11.A()     // Catch:{ all -> 0x0049 }
            r1 = 93
            if (r0 != r1) goto L_0x00ce
            r11.next()     // Catch:{ all -> 0x0049 }
            r11.nextToken()     // Catch:{ all -> 0x0049 }
            r9.T(r15)
            return r14
        L_0x00ce:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ all -> 0x0049 }
            r0.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = "syntax error, expect {, actual "
            r0.append(r1)     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = r11.b()     // Catch:{ all -> 0x0049 }
            r0.append(r1)     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = ", pos "
            r0.append(r1)     // Catch:{ all -> 0x0049 }
            int r1 = r11.s()     // Catch:{ all -> 0x0049 }
            r0.append(r1)     // Catch:{ all -> 0x0049 }
            boolean r1 = r10 instanceof java.lang.String     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x00f7
            java.lang.String r1 = ", fieldName "
            r0.append(r1)     // Catch:{ all -> 0x0049 }
            r0.append(r10)     // Catch:{ all -> 0x0049 }
        L_0x00f7:
            java.lang.String r1 = ", fastjson-version "
            r0.append(r1)     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = "1.2.35"
            r0.append(r1)     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0049 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0049 }
            r1.<init>(r0)     // Catch:{ all -> 0x0049 }
            throw r1     // Catch:{ all -> 0x0049 }
        L_0x010b:
            int r1 = r9.f15706l     // Catch:{ all -> 0x060b }
            r2 = 2
            if (r1 != r2) goto L_0x0112
            r9.f15706l = r6     // Catch:{ all -> 0x0049 }
        L_0x0112:
            i2.b r1 = r8.f15813d     // Catch:{ all -> 0x060b }
            java.lang.String r4 = r1.f15995m     // Catch:{ all -> 0x060b }
            r1 = r27
            r2 = r29
            r3 = r6
            r6 = r14
            r18 = r6
        L_0x011e:
            g2.i[] r14 = r8.f15811b     // Catch:{ all -> 0x0608 }
            int r5 = r14.length     // Catch:{ all -> 0x0608 }
            if (r3 >= r5) goto L_0x012e
            r5 = r14[r3]     // Catch:{ all -> 0x0608 }
            i2.a r14 = r5.f15808a     // Catch:{ all -> 0x0608 }
            java.lang.Class<?> r13 = r14.f15966f     // Catch:{ all -> 0x0608 }
            d2.b r19 = r14.e()     // Catch:{ all -> 0x0608 }
            goto L_0x0133
        L_0x012e:
            r5 = 0
            r13 = 0
            r14 = 0
            r19 = 0
        L_0x0133:
            if (r5 == 0) goto L_0x0250
            char[] r7 = r14.f15977q     // Catch:{ all -> 0x0608 }
            r27 = r3
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0608 }
            r29 = r14
            r14 = -2
            if (r13 == r3) goto L_0x023a
            java.lang.Class<java.lang.Integer> r3 = java.lang.Integer.class
            if (r13 != r3) goto L_0x0146
            goto L_0x023a
        L_0x0146:
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0608 }
            if (r13 == r3) goto L_0x0229
            java.lang.Class<java.lang.Long> r3 = java.lang.Long.class
            if (r13 != r3) goto L_0x0150
            goto L_0x0229
        L_0x0150:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r13 != r3) goto L_0x0162
            java.lang.String r3 = r11.n0(r7)     // Catch:{ all -> 0x0608 }
            int r7 = r11.f15731o     // Catch:{ all -> 0x0608 }
            if (r7 <= 0) goto L_0x015e
            goto L_0x0246
        L_0x015e:
            if (r7 != r14) goto L_0x0255
            goto L_0x024c
        L_0x0162:
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0608 }
            if (r13 == r3) goto L_0x0218
            java.lang.Class<java.lang.Boolean> r3 = java.lang.Boolean.class
            if (r13 != r3) goto L_0x016c
            goto L_0x0218
        L_0x016c:
            java.lang.Class r3 = java.lang.Float.TYPE     // Catch:{ all -> 0x0608 }
            if (r13 == r3) goto L_0x0207
            java.lang.Class<java.lang.Float> r3 = java.lang.Float.class
            if (r13 != r3) goto L_0x0176
            goto L_0x0207
        L_0x0176:
            java.lang.Class r3 = java.lang.Double.TYPE     // Catch:{ all -> 0x0608 }
            if (r13 == r3) goto L_0x01f6
            java.lang.Class<java.lang.Double> r3 = java.lang.Double.class
            if (r13 != r3) goto L_0x0180
            goto L_0x01f6
        L_0x0180:
            boolean r3 = r13.isEnum()     // Catch:{ all -> 0x0608 }
            if (r3 == 0) goto L_0x01b4
            com.alibaba.fastjson.parser.ParserConfig r3 = r24.k()     // Catch:{ all -> 0x0608 }
            g2.l r3 = r3.j(r13)     // Catch:{ all -> 0x0608 }
            boolean r3 = r3 instanceof g2.e     // Catch:{ all -> 0x0608 }
            if (r3 == 0) goto L_0x01b4
            if (r19 == 0) goto L_0x019c
            java.lang.Class r3 = r19.deserializeUsing()     // Catch:{ all -> 0x0608 }
            java.lang.Class<java.lang.Void> r14 = java.lang.Void.class
            if (r3 != r14) goto L_0x01b4
        L_0x019c:
            boolean r3 = r5 instanceof g2.d     // Catch:{ all -> 0x0608 }
            if (r3 == 0) goto L_0x0254
            r3 = r5
            g2.d r3 = (g2.d) r3     // Catch:{ all -> 0x0608 }
            g2.l r3 = r3.f15803c     // Catch:{ all -> 0x0608 }
            java.lang.Enum r3 = r8.p(r11, r7, r3)     // Catch:{ all -> 0x0608 }
            int r7 = r11.f15731o     // Catch:{ all -> 0x0608 }
            if (r7 <= 0) goto L_0x01af
            goto L_0x0246
        L_0x01af:
            r14 = -2
            if (r7 != r14) goto L_0x0255
            goto L_0x024c
        L_0x01b4:
            java.lang.Class<int[]> r3 = int[].class
            if (r13 != r3) goto L_0x01c7
            int[] r3 = r11.l0(r7)     // Catch:{ all -> 0x0608 }
            int r7 = r11.f15731o     // Catch:{ all -> 0x0608 }
            if (r7 <= 0) goto L_0x01c2
            goto L_0x0246
        L_0x01c2:
            r14 = -2
            if (r7 != r14) goto L_0x0255
            goto L_0x024c
        L_0x01c7:
            java.lang.Class<float[]> r3 = float[].class
            if (r13 != r3) goto L_0x01da
            float[] r3 = r11.i0(r7)     // Catch:{ all -> 0x0608 }
            int r7 = r11.f15731o     // Catch:{ all -> 0x0608 }
            if (r7 <= 0) goto L_0x01d5
            goto L_0x0246
        L_0x01d5:
            r14 = -2
            if (r7 != r14) goto L_0x0255
            goto L_0x024c
        L_0x01da:
            java.lang.Class<float[][]> r3 = float[][].class
            if (r13 != r3) goto L_0x01ec
            float[][] r3 = r11.j0(r7)     // Catch:{ all -> 0x0608 }
            int r7 = r11.f15731o     // Catch:{ all -> 0x0608 }
            if (r7 <= 0) goto L_0x01e7
            goto L_0x0246
        L_0x01e7:
            r14 = -2
            if (r7 != r14) goto L_0x0255
            goto L_0x024c
        L_0x01ec:
            boolean r3 = r11.Z(r7)     // Catch:{ all -> 0x0608 }
            if (r3 == 0) goto L_0x024c
            r3 = 0
            r7 = 1
            goto L_0x0256
        L_0x01f6:
            double r21 = r11.g0(r7)     // Catch:{ all -> 0x0608 }
            java.lang.Double r3 = java.lang.Double.valueOf(r21)     // Catch:{ all -> 0x0608 }
            int r7 = r11.f15731o     // Catch:{ all -> 0x0608 }
            if (r7 <= 0) goto L_0x0203
            goto L_0x0246
        L_0x0203:
            r14 = -2
            if (r7 != r14) goto L_0x0255
            goto L_0x024c
        L_0x0207:
            float r3 = r11.h0(r7)     // Catch:{ all -> 0x0608 }
            java.lang.Float r3 = java.lang.Float.valueOf(r3)     // Catch:{ all -> 0x0608 }
            int r7 = r11.f15731o     // Catch:{ all -> 0x0608 }
            if (r7 <= 0) goto L_0x0214
            goto L_0x0246
        L_0x0214:
            r14 = -2
            if (r7 != r14) goto L_0x0255
            goto L_0x024c
        L_0x0218:
            boolean r3 = r11.f0(r7)     // Catch:{ all -> 0x0608 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0608 }
            int r7 = r11.f15731o     // Catch:{ all -> 0x0608 }
            if (r7 <= 0) goto L_0x0225
            goto L_0x0246
        L_0x0225:
            r14 = -2
            if (r7 != r14) goto L_0x0255
            goto L_0x024c
        L_0x0229:
            long r21 = r11.m0(r7)     // Catch:{ all -> 0x0608 }
            java.lang.Long r3 = java.lang.Long.valueOf(r21)     // Catch:{ all -> 0x0608 }
            int r7 = r11.f15731o     // Catch:{ all -> 0x0608 }
            if (r7 <= 0) goto L_0x0236
            goto L_0x0246
        L_0x0236:
            r14 = -2
            if (r7 != r14) goto L_0x0255
            goto L_0x024c
        L_0x023a:
            int r3 = r11.k0(r7)     // Catch:{ all -> 0x0608 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0608 }
            int r7 = r11.f15731o     // Catch:{ all -> 0x0608 }
            if (r7 <= 0) goto L_0x0249
        L_0x0246:
            r7 = 1
            r14 = 1
            goto L_0x0257
        L_0x0249:
            r14 = -2
            if (r7 != r14) goto L_0x0255
        L_0x024c:
            r3 = 13
            goto L_0x03a2
        L_0x0250:
            r27 = r3
            r29 = r14
        L_0x0254:
            r3 = 0
        L_0x0255:
            r7 = 0
        L_0x0256:
            r14 = 0
        L_0x0257:
            if (r7 != 0) goto L_0x03bf
            r19 = r13
            f2.g r13 = r9.f15697c     // Catch:{ all -> 0x0608 }
            java.lang.String r13 = r11.L(r13)     // Catch:{ all -> 0x0608 }
            if (r13 != 0) goto L_0x0281
            r21 = r3
            int r3 = r11.J()     // Catch:{ all -> 0x0608 }
            r0 = 13
            if (r3 != r0) goto L_0x0274
            r0 = 16
            r11.f(r0)     // Catch:{ all -> 0x0608 }
            goto L_0x039a
        L_0x0274:
            r0 = 16
            if (r3 != r0) goto L_0x0283
            com.alibaba.fastjson.parser.Feature r0 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x0608 }
            boolean r0 = r11.a(r0)     // Catch:{ all -> 0x0608 }
            if (r0 == 0) goto L_0x0283
            goto L_0x024c
        L_0x0281:
            r21 = r3
        L_0x0283:
            java.lang.String r0 = "$ref"
            if (r0 != r13) goto L_0x0328
            if (r15 == 0) goto L_0x0328
            r0 = 4
            r11.y(r0)     // Catch:{ all -> 0x0608 }
            int r2 = r11.J()     // Catch:{ all -> 0x0608 }
            if (r2 != r0) goto L_0x030d
            java.lang.String r0 = r11.H()     // Catch:{ all -> 0x0608 }
            java.lang.String r2 = "@"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0608 }
            if (r2 == 0) goto L_0x02a3
            java.lang.Object r0 = r15.f15739a     // Catch:{ all -> 0x0608 }
            r1 = r0
            goto L_0x02ea
        L_0x02a3:
            java.lang.String r2 = ".."
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0608 }
            if (r2 == 0) goto L_0x02bf
            f2.f r2 = r15.f15740b     // Catch:{ all -> 0x0608 }
            java.lang.Object r3 = r2.f15739a     // Catch:{ all -> 0x0608 }
            if (r3 == 0) goto L_0x02b3
        L_0x02b1:
            r1 = r3
            goto L_0x02ea
        L_0x02b3:
            f2.a$a r3 = new f2.a$a     // Catch:{ all -> 0x0608 }
            r3.<init>(r2, r0)     // Catch:{ all -> 0x0608 }
            r9.f(r3)     // Catch:{ all -> 0x0608 }
            r0 = 1
            r9.f15706l = r0     // Catch:{ all -> 0x0608 }
            goto L_0x02ea
        L_0x02bf:
            java.lang.String r2 = "$"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0608 }
            if (r2 == 0) goto L_0x02df
            r2 = r15
        L_0x02c8:
            f2.f r3 = r2.f15740b     // Catch:{ all -> 0x0608 }
            if (r3 == 0) goto L_0x02ce
            r2 = r3
            goto L_0x02c8
        L_0x02ce:
            java.lang.Object r3 = r2.f15739a     // Catch:{ all -> 0x0608 }
            if (r3 == 0) goto L_0x02d3
            goto L_0x02b1
        L_0x02d3:
            f2.a$a r3 = new f2.a$a     // Catch:{ all -> 0x0608 }
            r3.<init>(r2, r0)     // Catch:{ all -> 0x0608 }
            r9.f(r3)     // Catch:{ all -> 0x0608 }
            r0 = 1
            r9.f15706l = r0     // Catch:{ all -> 0x0608 }
            goto L_0x02ea
        L_0x02df:
            f2.a$a r2 = new f2.a$a     // Catch:{ all -> 0x0608 }
            r2.<init>(r15, r0)     // Catch:{ all -> 0x0608 }
            r9.f(r2)     // Catch:{ all -> 0x0608 }
            r0 = 1
            r9.f15706l = r0     // Catch:{ all -> 0x0608 }
        L_0x02ea:
            r0 = 13
            r11.f(r0)     // Catch:{ all -> 0x0608 }
            int r2 = r11.J()     // Catch:{ all -> 0x0608 }
            if (r2 != r0) goto L_0x0305
            r0 = 16
            r11.f(r0)     // Catch:{ all -> 0x0608 }
            r9.R(r15, r1, r10)     // Catch:{ all -> 0x0608 }
            if (r6 == 0) goto L_0x0301
            r6.f15739a = r1
        L_0x0301:
            r9.T(r15)
            return r1
        L_0x0305:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0608 }
            java.lang.String r2 = "illegal ref"
            r0.<init>(r2)     // Catch:{ all -> 0x0608 }
            throw r0     // Catch:{ all -> 0x0608 }
        L_0x030d:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0608 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0608 }
            r3.<init>()     // Catch:{ all -> 0x0608 }
            java.lang.String r4 = "illegal ref, "
            r3.append(r4)     // Catch:{ all -> 0x0608 }
            java.lang.String r2 = com.alibaba.fastjson.parser.JSONToken.a(r2)     // Catch:{ all -> 0x0608 }
            r3.append(r2)     // Catch:{ all -> 0x0608 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0608 }
            r0.<init>(r2)     // Catch:{ all -> 0x0608 }
            throw r0     // Catch:{ all -> 0x0608 }
        L_0x0328:
            if (r4 == 0) goto L_0x0330
            boolean r0 = r4.equals(r13)     // Catch:{ all -> 0x0608 }
            if (r0 != 0) goto L_0x0334
        L_0x0330:
            java.lang.String r0 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x0608 }
            if (r0 != r13) goto L_0x03bc
        L_0x0334:
            r0 = 4
            r11.y(r0)     // Catch:{ all -> 0x0608 }
            int r3 = r11.J()     // Catch:{ all -> 0x0608 }
            if (r3 != r0) goto L_0x03b4
            java.lang.String r0 = r11.H()     // Catch:{ all -> 0x0608 }
            r3 = 16
            r11.f(r3)     // Catch:{ all -> 0x0608 }
            i2.b r3 = r8.f15813d     // Catch:{ all -> 0x0608 }
            java.lang.String r3 = r3.f15994l     // Catch:{ all -> 0x0608 }
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0608 }
            if (r3 != 0) goto L_0x038f
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.IgnoreAutoType     // Catch:{ all -> 0x0608 }
            boolean r3 = r9.y(r3)     // Catch:{ all -> 0x0608 }
            if (r3 == 0) goto L_0x035a
            goto L_0x038f
        L_0x035a:
            i2.b r2 = r8.f15813d     // Catch:{ all -> 0x0608 }
            g2.k r2 = r8.l(r12, r2, r0)     // Catch:{ all -> 0x0608 }
            if (r2 != 0) goto L_0x0373
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.D(r25)     // Catch:{ all -> 0x0608 }
            java.lang.Class r14 = r12.e(r0, r2)     // Catch:{ all -> 0x0608 }
            com.alibaba.fastjson.parser.ParserConfig r2 = r24.k()     // Catch:{ all -> 0x0608 }
            g2.l r2 = r2.j(r14)     // Catch:{ all -> 0x0608 }
            goto L_0x0374
        L_0x0373:
            r14 = 0
        L_0x0374:
            java.lang.Object r3 = r2.e(r9, r14, r10)     // Catch:{ all -> 0x0608 }
            boolean r5 = r2 instanceof g2.k     // Catch:{ all -> 0x0608 }
            if (r5 == 0) goto L_0x0387
            g2.k r2 = (g2.k) r2     // Catch:{ all -> 0x0608 }
            if (r4 == 0) goto L_0x0387
            g2.i r2 = r2.j(r4)     // Catch:{ all -> 0x0608 }
            r2.f(r3, r0)     // Catch:{ all -> 0x0608 }
        L_0x0387:
            if (r6 == 0) goto L_0x038b
            r6.f15739a = r1
        L_0x038b:
            r9.T(r15)
            return r3
        L_0x038f:
            int r0 = r11.J()     // Catch:{ all -> 0x0608 }
            r3 = 13
            if (r0 != r3) goto L_0x03a2
            r11.nextToken()     // Catch:{ all -> 0x0608 }
        L_0x039a:
            r14 = r25
            r0 = r18
            r27 = 0
            goto L_0x04c3
        L_0x03a2:
            r14 = r25
            r16 = r27
            r0 = r2
            r13 = r4
            r22 = r12
            r2 = 16
            r4 = 0
            r5 = 1
            r21 = 4
            r12 = r3
            r3 = 0
            goto L_0x05cd
        L_0x03b4:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0608 }
            java.lang.String r2 = "syntax error"
            r0.<init>(r2)     // Catch:{ all -> 0x0608 }
            throw r0     // Catch:{ all -> 0x0608 }
        L_0x03bc:
            r3 = 13
            goto L_0x03c6
        L_0x03bf:
            r21 = r3
            r19 = r13
            r3 = 13
            r13 = 0
        L_0x03c6:
            if (r1 != 0) goto L_0x03e9
            if (r18 != 0) goto L_0x03e9
            java.lang.Object r1 = r23.d(r24, r25)     // Catch:{ all -> 0x0608 }
            if (r1 != 0) goto L_0x03da
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0608 }
            g2.i[] r3 = r8.f15810a     // Catch:{ all -> 0x0608 }
            int r3 = r3.length     // Catch:{ all -> 0x0608 }
            r0.<init>(r3)     // Catch:{ all -> 0x0608 }
            r18 = r0
        L_0x03da:
            f2.f r6 = r9.R(r15, r1, r10)     // Catch:{ all -> 0x0608 }
            if (r2 != 0) goto L_0x03e9
            g2.i[] r0 = r8.f15810a     // Catch:{ all -> 0x0608 }
            int r0 = r0.length     // Catch:{ all -> 0x0608 }
            int r0 = r0 / 32
            r2 = 1
            int r0 = r0 + r2
            int[] r2 = new int[r0]     // Catch:{ all -> 0x0608 }
        L_0x03e9:
            r0 = r2
            r3 = r18
            r18 = r6
            r6 = r1
            if (r7 == 0) goto L_0x0469
            if (r14 != 0) goto L_0x040d
            r14 = r25
            r5.b(r9, r6, r14, r3)     // Catch:{ all -> 0x0409 }
            r16 = r27
            r19 = r3
            r13 = r4
            r17 = r6
            r22 = r12
            r27 = 0
            r12 = 13
            r21 = 4
            goto L_0x04a9
        L_0x0409:
            r0 = move-exception
            r1 = r6
            goto L_0x0605
        L_0x040d:
            r14 = r25
            if (r6 != 0) goto L_0x041b
            r1 = r29
            java.lang.String r1 = r1.f15962b     // Catch:{ all -> 0x0409 }
            r2 = r21
            r3.put(r1, r2)     // Catch:{ all -> 0x0409 }
            goto L_0x043c
        L_0x041b:
            r2 = r21
            if (r2 != 0) goto L_0x0439
            java.lang.Class r1 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0409 }
            r13 = r19
            if (r13 == r1) goto L_0x043c
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x0409 }
            if (r13 == r1) goto L_0x043c
            java.lang.Class r1 = java.lang.Float.TYPE     // Catch:{ all -> 0x0409 }
            if (r13 == r1) goto L_0x043c
            java.lang.Class r1 = java.lang.Double.TYPE     // Catch:{ all -> 0x0409 }
            if (r13 == r1) goto L_0x043c
            java.lang.Class r1 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0409 }
            if (r13 == r1) goto L_0x043c
            r5.e(r6, r2)     // Catch:{ all -> 0x0409 }
            goto L_0x043c
        L_0x0439:
            r5.e(r6, r2)     // Catch:{ all -> 0x0409 }
        L_0x043c:
            if (r0 == 0) goto L_0x044b
            int r1 = r27 / 32
            int r2 = r27 % 32
            r5 = r0[r1]     // Catch:{ all -> 0x0409 }
            r7 = 1
            int r2 = r7 >> r2
            r2 = r2 | r5
            r0[r1] = r2     // Catch:{ all -> 0x0409 }
            goto L_0x044c
        L_0x044b:
            r7 = 1
        L_0x044c:
            int r1 = r11.f15731o     // Catch:{ all -> 0x0409 }
            r5 = 4
            if (r1 != r5) goto L_0x0459
            r19 = r3
            r17 = r6
            r27 = 0
            goto L_0x04bd
        L_0x0459:
            r16 = r27
            r19 = r3
            r13 = r4
            r21 = r5
            r17 = r6
            r22 = r12
            r27 = 0
            r12 = 13
            goto L_0x04a9
        L_0x0469:
            r14 = r25
            r5 = 4
            r7 = 1
            r1 = r23
            r2 = r24
            r16 = r27
            r19 = r3
            r20 = 13
            r3 = r13
            r13 = r4
            r4 = r6
            r21 = r5
            r5 = r25
            r17 = r6
            r27 = 0
            r6 = r19
            r22 = r12
            r12 = r20
            r7 = r0
            boolean r1 = r1.n(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0602 }
            if (r1 != 0) goto L_0x04a1
            int r1 = r11.J()     // Catch:{ all -> 0x0602 }
            if (r1 != r12) goto L_0x0499
            r11.nextToken()     // Catch:{ all -> 0x0602 }
            goto L_0x04bd
        L_0x0499:
            r4 = r27
            r2 = 16
        L_0x049d:
            r3 = 0
            r5 = 1
            goto L_0x05c7
        L_0x04a1:
            int r1 = r11.J()     // Catch:{ all -> 0x0602 }
            r2 = 17
            if (r1 == r2) goto L_0x05fa
        L_0x04a9:
            int r1 = r11.J()     // Catch:{ all -> 0x0602 }
            r2 = 16
            if (r1 != r2) goto L_0x04b4
            r4 = r27
            goto L_0x049d
        L_0x04b4:
            int r1 = r11.J()     // Catch:{ all -> 0x0602 }
            if (r1 != r12) goto L_0x05b5
            r11.f(r2)     // Catch:{ all -> 0x0602 }
        L_0x04bd:
            r1 = r17
            r6 = r18
            r0 = r19
        L_0x04c3:
            if (r1 != 0) goto L_0x058e
            if (r0 != 0) goto L_0x04d9
            java.lang.Object r1 = r23.d(r24, r25)     // Catch:{ all -> 0x0608 }
            if (r6 != 0) goto L_0x04d1
            f2.f r6 = r9.R(r15, r1, r10)     // Catch:{ all -> 0x0608 }
        L_0x04d1:
            if (r6 == 0) goto L_0x04d5
            r6.f15739a = r1
        L_0x04d5:
            r9.T(r15)
            return r1
        L_0x04d9:
            i2.b r2 = r8.f15813d     // Catch:{ all -> 0x0608 }
            i2.a[] r2 = r2.f15990h     // Catch:{ all -> 0x0608 }
            int r3 = r2.length     // Catch:{ all -> 0x0608 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0608 }
            r5 = r27
        L_0x04e2:
            if (r5 >= r3) goto L_0x0536
            r7 = r2[r5]     // Catch:{ all -> 0x0608 }
            java.lang.String r10 = r7.f15962b     // Catch:{ all -> 0x0608 }
            java.lang.Object r10 = r0.get(r10)     // Catch:{ all -> 0x0608 }
            if (r10 != 0) goto L_0x0531
            java.lang.reflect.Type r7 = r7.f15967g     // Catch:{ all -> 0x0608 }
            java.lang.Class r11 = java.lang.Byte.TYPE     // Catch:{ all -> 0x0608 }
            if (r7 != r11) goto L_0x04f9
            java.lang.Byte r10 = java.lang.Byte.valueOf(r27)     // Catch:{ all -> 0x0608 }
            goto L_0x0531
        L_0x04f9:
            java.lang.Class r11 = java.lang.Short.TYPE     // Catch:{ all -> 0x0608 }
            if (r7 != r11) goto L_0x0502
            java.lang.Short r10 = java.lang.Short.valueOf(r27)     // Catch:{ all -> 0x0608 }
            goto L_0x0531
        L_0x0502:
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0608 }
            if (r7 != r11) goto L_0x050b
            java.lang.Integer r10 = java.lang.Integer.valueOf(r27)     // Catch:{ all -> 0x0608 }
            goto L_0x0531
        L_0x050b:
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0608 }
            if (r7 != r11) goto L_0x0516
            r10 = 0
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0608 }
            goto L_0x0531
        L_0x0516:
            java.lang.Class r11 = java.lang.Float.TYPE     // Catch:{ all -> 0x0608 }
            if (r7 != r11) goto L_0x0520
            r7 = 0
            java.lang.Float r10 = java.lang.Float.valueOf(r7)     // Catch:{ all -> 0x0608 }
            goto L_0x0531
        L_0x0520:
            java.lang.Class r11 = java.lang.Double.TYPE     // Catch:{ all -> 0x0608 }
            if (r7 != r11) goto L_0x052b
            r10 = 0
            java.lang.Double r10 = java.lang.Double.valueOf(r10)     // Catch:{ all -> 0x0608 }
            goto L_0x0531
        L_0x052b:
            java.lang.Class r11 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0608 }
            if (r7 != r11) goto L_0x0531
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0608 }
        L_0x0531:
            r4[r5] = r10     // Catch:{ all -> 0x0608 }
            int r5 = r5 + 1
            goto L_0x04e2
        L_0x0536:
            i2.b r0 = r8.f15813d     // Catch:{ all -> 0x0608 }
            java.lang.reflect.Constructor<?> r2 = r0.f15986d     // Catch:{ all -> 0x0608 }
            if (r2 == 0) goto L_0x0563
            java.lang.Object r0 = r2.newInstance(r4)     // Catch:{ Exception -> 0x0542 }
        L_0x0540:
            r1 = r0
            goto L_0x058e
        L_0x0542:
            r0 = move-exception
            r2 = r0
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0608 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0608 }
            r3.<init>()     // Catch:{ all -> 0x0608 }
            java.lang.String r4 = "create instance error, "
            r3.append(r4)     // Catch:{ all -> 0x0608 }
            i2.b r4 = r8.f15813d     // Catch:{ all -> 0x0608 }
            java.lang.reflect.Constructor<?> r4 = r4.f15986d     // Catch:{ all -> 0x0608 }
            java.lang.String r4 = r4.toGenericString()     // Catch:{ all -> 0x0608 }
            r3.append(r4)     // Catch:{ all -> 0x0608 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0608 }
            r0.<init>(r3, r2)     // Catch:{ all -> 0x0608 }
            throw r0     // Catch:{ all -> 0x0608 }
        L_0x0563:
            java.lang.reflect.Method r0 = r0.f15987e     // Catch:{ all -> 0x0608 }
            if (r0 == 0) goto L_0x058e
            r3 = 0
            java.lang.Object r0 = r0.invoke(r3, r4)     // Catch:{ Exception -> 0x056d }
            goto L_0x0540
        L_0x056d:
            r0 = move-exception
            r2 = r0
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0608 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0608 }
            r3.<init>()     // Catch:{ all -> 0x0608 }
            java.lang.String r4 = "create factory method error, "
            r3.append(r4)     // Catch:{ all -> 0x0608 }
            i2.b r4 = r8.f15813d     // Catch:{ all -> 0x0608 }
            java.lang.reflect.Method r4 = r4.f15987e     // Catch:{ all -> 0x0608 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0608 }
            r3.append(r4)     // Catch:{ all -> 0x0608 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0608 }
            r0.<init>(r3, r2)     // Catch:{ all -> 0x0608 }
            throw r0     // Catch:{ all -> 0x0608 }
        L_0x058e:
            i2.b r0 = r8.f15813d     // Catch:{ all -> 0x0608 }
            java.lang.reflect.Method r0 = r0.f15988f     // Catch:{ all -> 0x0608 }
            if (r0 != 0) goto L_0x059c
            if (r6 == 0) goto L_0x0598
            r6.f15739a = r1
        L_0x0598:
            r9.T(r15)
            return r1
        L_0x059c:
            r4 = r27
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x05ac }
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch:{ Exception -> 0x05ac }
            if (r6 == 0) goto L_0x05a8
            r6.f15739a = r1
        L_0x05a8:
            r9.T(r15)
            return r0
        L_0x05ac:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0608 }
            java.lang.String r3 = "build object error"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0608 }
            throw r2     // Catch:{ all -> 0x0608 }
        L_0x05b5:
            r4 = r27
            r3 = 0
            int r1 = r11.J()     // Catch:{ all -> 0x0602 }
            r5 = 18
            if (r1 == r5) goto L_0x05db
            int r1 = r11.J()     // Catch:{ all -> 0x0602 }
            r5 = 1
            if (r1 == r5) goto L_0x05db
        L_0x05c7:
            r1 = r17
            r6 = r18
            r18 = r19
        L_0x05cd:
            int r7 = r16 + 1
            r3 = r7
            r7 = r12
            r4 = r13
            r5 = r21
            r12 = r22
            r13 = r2
            r2 = r0
            r0 = r14
            goto L_0x011e
        L_0x05db:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0602 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0602 }
            r1.<init>()     // Catch:{ all -> 0x0602 }
            java.lang.String r2 = "syntax error, unexpect token "
            r1.append(r2)     // Catch:{ all -> 0x0602 }
            int r2 = r11.J()     // Catch:{ all -> 0x0602 }
            java.lang.String r2 = com.alibaba.fastjson.parser.JSONToken.a(r2)     // Catch:{ all -> 0x0602 }
            r1.append(r2)     // Catch:{ all -> 0x0602 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0602 }
            r0.<init>(r1)     // Catch:{ all -> 0x0602 }
            throw r0     // Catch:{ all -> 0x0602 }
        L_0x05fa:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0602 }
            java.lang.String r1 = "syntax error, unexpect token ':'"
            r0.<init>(r1)     // Catch:{ all -> 0x0602 }
            throw r0     // Catch:{ all -> 0x0602 }
        L_0x0602:
            r0 = move-exception
            r1 = r17
        L_0x0605:
            r14 = r18
            goto L_0x060f
        L_0x0608:
            r0 = move-exception
            r14 = r6
            goto L_0x060f
        L_0x060b:
            r0 = move-exception
            r3 = r14
            goto L_0x004a
        L_0x060f:
            if (r14 == 0) goto L_0x0613
            r14.f15739a = r1
        L_0x0613:
            r9.T(r15)
            throw r0
        L_0x0617:
            java.lang.Object r0 = r24.z()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.k.h(f2.a, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int, int[]):java.lang.Object");
    }

    public <T> T i(a aVar, Type type, Object obj, Object obj2) {
        Enum<?> enumR;
        f2.b bVar = aVar.f15701g;
        if (bVar.J() == 14) {
            T d11 = d(aVar, type);
            int i11 = 0;
            int length = this.f15811b.length;
            while (true) {
                int i12 = 16;
                if (i11 < length) {
                    char c11 = i11 == length + -1 ? ']' : ',';
                    i iVar = this.f15811b[i11];
                    Class<?> cls = iVar.f15808a.f15966f;
                    if (cls == Integer.TYPE) {
                        iVar.c(d11, bVar.g(c11));
                    } else if (cls == String.class) {
                        iVar.f(d11, bVar.m(c11));
                    } else if (cls == Long.TYPE) {
                        iVar.d(d11, bVar.r(c11));
                    } else if (cls.isEnum()) {
                        char A = bVar.A();
                        if (A == '\"' || A == 'n') {
                            enumR = bVar.n(cls, aVar.w(), c11);
                        } else if (A < '0' || A > '9') {
                            enumR = o(bVar, c11);
                        } else {
                            enumR = ((e) ((d) iVar).h(aVar.k())).d(bVar.g(c11));
                        }
                        iVar.e(d11, enumR);
                    } else if (cls == Boolean.TYPE) {
                        iVar.g(d11, bVar.F(c11));
                    } else if (cls == Float.TYPE) {
                        iVar.e(d11, Float.valueOf(bVar.v(c11)));
                    } else if (cls == Double.TYPE) {
                        iVar.e(d11, Double.valueOf(bVar.z(c11)));
                    } else if (cls == Date.class && bVar.A() == '1') {
                        iVar.e(d11, new Date(bVar.r(c11)));
                    } else {
                        bVar.f(14);
                        iVar.e(d11, aVar.L(iVar.f15808a.f15967g));
                        if (c11 == ']') {
                            i12 = 15;
                        }
                        c(bVar, i12);
                    }
                    i11++;
                } else {
                    bVar.f(16);
                    return d11;
                }
            }
        } else {
            throw new JSONException("error");
        }
    }

    public i j(String str) {
        return k(str, (int[]) null);
    }

    public i k(String str, int[] iArr) {
        if (str == null) {
            return null;
        }
        int i11 = 0;
        int length = this.f15811b.length - 1;
        while (i11 <= length) {
            int i12 = (i11 + length) >>> 1;
            int compareTo = this.f15811b[i12].f15808a.f15962b.compareTo(str);
            if (compareTo < 0) {
                i11 = i12 + 1;
            } else if (compareTo > 0) {
                length = i12 - 1;
            } else if (m(i12, iArr)) {
                return null;
            } else {
                return this.f15811b[i12];
            }
        }
        Map<String, i> map = this.f15815f;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public k l(ParserConfig parserConfig, b bVar, String str) {
        d dVar = bVar.f15993k;
        if (dVar == null) {
            return null;
        }
        for (Class j11 : dVar.seeAlso()) {
            l j12 = parserConfig.j(j11);
            if (j12 instanceof k) {
                k kVar = (k) j12;
                b bVar2 = kVar.f15813d;
                if (bVar2.f15994l.equals(str)) {
                    return kVar;
                }
                k l11 = l(parserConfig, bVar2, str);
                if (l11 != null) {
                    return l11;
                }
            }
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r17v0, types: [boolean] */
    /* JADX WARNING: type inference failed for: r17v1 */
    /* JADX WARNING: type inference failed for: r17v3 */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean n(f2.a r22, java.lang.String r23, java.lang.Object r24, java.lang.reflect.Type r25, java.util.Map<java.lang.String, java.lang.Object> r26, int[] r27) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r11 = r23
            r12 = r24
            r13 = r25
            r14 = r26
            r15 = r27
            f2.b r10 = r0.f15701g
            com.alibaba.fastjson.parser.Feature r2 = com.alibaba.fastjson.parser.Feature.DisableFieldSmartMatch
            int r2 = r2.mask
            boolean r3 = r10.isEnabled(r2)
            if (r3 != 0) goto L_0x0027
            i2.b r3 = r1.f15813d
            int r3 = r3.f15992j
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0022
            goto L_0x0027
        L_0x0022:
            g2.i r2 = r1.r(r11, r15)
            goto L_0x002b
        L_0x0027:
            g2.i r2 = r1.j(r11)
        L_0x002b:
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.SupportNonPublicField
            int r3 = r3.mask
            r16 = 0
            r9 = 1
            if (r2 != 0) goto L_0x0088
            boolean r4 = r10.isEnabled(r3)
            if (r4 != 0) goto L_0x0041
            i2.b r4 = r1.f15813d
            int r4 = r4.f15992j
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0088
        L_0x0041:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Object> r3 = r1.f15814e
            if (r3 != 0) goto L_0x0079
            java.util.concurrent.ConcurrentHashMap r3 = new java.util.concurrent.ConcurrentHashMap
            r4 = 1061158912(0x3f400000, float:0.75)
            r3.<init>(r9, r4, r9)
            java.lang.Class<?> r4 = r1.f15812c
            java.lang.reflect.Field[] r4 = r4.getDeclaredFields()
            int r5 = r4.length
            r6 = r16
        L_0x0055:
            if (r6 >= r5) goto L_0x0077
            r7 = r4[r6]
            java.lang.String r8 = r7.getName()
            g2.i r17 = r1.j(r8)
            if (r17 == 0) goto L_0x0064
            goto L_0x0074
        L_0x0064:
            int r17 = r7.getModifiers()
            r18 = r17 & 16
            if (r18 != 0) goto L_0x0074
            r17 = r17 & 8
            if (r17 == 0) goto L_0x0071
            goto L_0x0074
        L_0x0071:
            r3.put(r8, r7)
        L_0x0074:
            int r6 = r6 + 1
            goto L_0x0055
        L_0x0077:
            r1.f15814e = r3
        L_0x0079:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Object> r3 = r1.f15814e
            java.lang.Object r3 = r3.get(r11)
            if (r3 == 0) goto L_0x0088
            boolean r2 = r3 instanceof g2.i
            if (r2 == 0) goto L_0x008c
            r2 = r3
            g2.i r2 = (g2.i) r2
        L_0x0088:
            r17 = r9
            r15 = r10
            goto L_0x00c9
        L_0x008c:
            r7 = r3
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            r7.setAccessible(r9)
            i2.a r8 = new i2.a
            java.lang.Class r4 = r7.getDeclaringClass()
            java.lang.Class r5 = r7.getType()
            java.lang.reflect.Type r6 = r7.getGenericType()
            r17 = 0
            r18 = 0
            r19 = 0
            r2 = r8
            r3 = r23
            r20 = r8
            r8 = r17
            r17 = r9
            r9 = r18
            r15 = r10
            r10 = r19
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            g2.d r2 = new g2.d
            com.alibaba.fastjson.parser.ParserConfig r3 = r22.k()
            java.lang.Class<?> r4 = r1.f15812c
            r5 = r20
            r2.<init>(r3, r4, r5)
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Object> r3 = r1.f15814e
            r3.put(r11, r2)
        L_0x00c9:
            if (r2 != 0) goto L_0x01a5
            com.alibaba.fastjson.parser.Feature r2 = com.alibaba.fastjson.parser.Feature.IgnoreNotMatch
            boolean r2 = r15.a(r2)
            if (r2 == 0) goto L_0x0180
            g2.i[] r2 = r1.f15811b
            int r3 = r2.length
            r4 = r16
        L_0x00d8:
            if (r4 >= r3) goto L_0x017c
            r5 = r2[r4]
            i2.a r6 = r5.f15808a
            boolean r7 = r6.f15980t
            if (r7 == 0) goto L_0x0178
            boolean r7 = r5 instanceof g2.d
            if (r7 == 0) goto L_0x0178
            java.lang.reflect.Field r7 = r6.f15964d
            java.lang.String r8 = "parse unwrapped field error."
            if (r7 == 0) goto L_0x0154
            r7 = r5
            g2.d r7 = (g2.d) r7
            com.alibaba.fastjson.parser.ParserConfig r9 = r22.k()
            g2.l r9 = r7.h(r9)
            boolean r10 = r9 instanceof g2.k
            if (r10 == 0) goto L_0x0129
            r10 = r9
            g2.k r10 = (g2.k) r10
            g2.i r10 = r10.j(r11)
            if (r10 == 0) goto L_0x0178
            java.lang.reflect.Field r2 = r6.f15964d     // Catch:{ Exception -> 0x0122 }
            java.lang.Object r2 = r2.get(r12)     // Catch:{ Exception -> 0x0122 }
            if (r2 != 0) goto L_0x0117
            g2.k r9 = (g2.k) r9     // Catch:{ Exception -> 0x0122 }
            java.lang.reflect.Type r2 = r6.f15967g     // Catch:{ Exception -> 0x0122 }
            java.lang.Object r2 = r9.d(r0, r2)     // Catch:{ Exception -> 0x0122 }
            r5.e(r12, r2)     // Catch:{ Exception -> 0x0122 }
        L_0x0117:
            int r3 = r7.a()     // Catch:{ Exception -> 0x0122 }
            r15.y(r3)     // Catch:{ Exception -> 0x0122 }
            r10.b(r0, r2, r13, r14)     // Catch:{ Exception -> 0x0122 }
            return r17
        L_0x0122:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            r2.<init>(r8, r0)
            throw r2
        L_0x0129:
            boolean r7 = r9 instanceof com.alibaba.fastjson.parser.deserializer.MapDeserializer
            if (r7 == 0) goto L_0x0178
            com.alibaba.fastjson.parser.deserializer.MapDeserializer r9 = (com.alibaba.fastjson.parser.deserializer.MapDeserializer) r9
            java.lang.reflect.Field r2 = r6.f15964d     // Catch:{ Exception -> 0x014d }
            java.lang.Object r2 = r2.get(r12)     // Catch:{ Exception -> 0x014d }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x014d }
            if (r2 != 0) goto L_0x0142
            java.lang.reflect.Type r2 = r6.f15967g     // Catch:{ Exception -> 0x014d }
            java.util.Map r2 = r9.c(r2)     // Catch:{ Exception -> 0x014d }
            r5.e(r12, r2)     // Catch:{ Exception -> 0x014d }
        L_0x0142:
            r15.B()     // Catch:{ Exception -> 0x014d }
            java.lang.Object r0 = r22.B(r23)     // Catch:{ Exception -> 0x014d }
            r2.put(r11, r0)     // Catch:{ Exception -> 0x014d }
            return r17
        L_0x014d:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            r2.<init>(r8, r0)
            throw r2
        L_0x0154:
            java.lang.reflect.Method r5 = r6.f15963c
            java.lang.Class[] r5 = r5.getParameterTypes()
            int r5 = r5.length
            r7 = 2
            if (r5 != r7) goto L_0x0178
            r15.B()
            java.lang.Object r0 = r22.B(r23)
            java.lang.reflect.Method r2 = r6.f15963c     // Catch:{ Exception -> 0x0171 }
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0171 }
            r3[r16] = r11     // Catch:{ Exception -> 0x0171 }
            r3[r17] = r0     // Catch:{ Exception -> 0x0171 }
            r2.invoke(r12, r3)     // Catch:{ Exception -> 0x0171 }
            return r17
        L_0x0171:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            r2.<init>(r8, r0)
            throw r2
        L_0x0178:
            int r4 = r4 + 1
            goto L_0x00d8
        L_0x017c:
            r0.I(r12, r11)
            return r16
        L_0x0180:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "setter not found, class "
            r2.append(r3)
            java.lang.Class<?> r3 = r1.f15812c
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            java.lang.String r3 = ", property "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x01a5:
            r3 = r16
        L_0x01a7:
            g2.i[] r4 = r1.f15811b
            int r5 = r4.length
            r6 = -1
            if (r3 >= r5) goto L_0x01b5
            r4 = r4[r3]
            if (r4 != r2) goto L_0x01b2
            goto L_0x01b6
        L_0x01b2:
            int r3 = r3 + 1
            goto L_0x01a7
        L_0x01b5:
            r3 = r6
        L_0x01b6:
            if (r3 == r6) goto L_0x01cf
            r4 = r27
            r5 = r15
            if (r4 == 0) goto L_0x01d0
            java.lang.String r6 = "_"
            boolean r6 = r11.startsWith(r6)
            if (r6 == 0) goto L_0x01d0
            boolean r3 = m(r3, r4)
            if (r3 == 0) goto L_0x01d0
            r0.I(r12, r11)
            return r16
        L_0x01cf:
            r5 = r15
        L_0x01d0:
            int r3 = r2.a()
            r5.y(r3)
            r2.b(r0, r12, r13, r14)
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.k.n(f2.a, java.lang.String, java.lang.Object, java.lang.reflect.Type, java.util.Map, int[]):boolean");
    }

    public Enum<?> o(f2.b bVar, char c11) {
        throw new JSONException("illegal enum. " + bVar.t());
    }

    public Enum p(c cVar, char[] cArr, l lVar) {
        e eVar = lVar instanceof e ? (e) lVar : null;
        if (eVar == null) {
            cVar.f15731o = -1;
            return null;
        }
        long o02 = cVar.o0(cArr);
        if (cVar.f15731o > 0) {
            return eVar.c(o02);
        }
        return null;
    }

    public i q(String str) {
        return r(str, (int[]) null);
    }

    public i r(String str, int[] iArr) {
        boolean z11;
        i iVar;
        String str2 = null;
        if (str == null) {
            return null;
        }
        i k11 = k(str, iArr);
        if (k11 == null) {
            boolean startsWith = str.startsWith("is");
            int i11 = 0;
            while (true) {
                if (i11 >= this.f15811b.length) {
                    break;
                }
                if (!m(i11, iArr)) {
                    iVar = this.f15811b[i11];
                    i2.a aVar = iVar.f15808a;
                    if ((aVar.f15971k & Feature.DisableFieldSmartMatch.mask) != 0) {
                        return null;
                    }
                    Class<?> cls = aVar.f15966f;
                    String str3 = aVar.f15962b;
                    if (str3.equalsIgnoreCase(str) || (startsWith && ((cls == Boolean.TYPE || cls == Boolean.class) && str3.equalsIgnoreCase(str.substring(2))))) {
                        k11 = iVar;
                    }
                }
                i11++;
            }
            k11 = iVar;
        }
        if (k11 != null) {
            return k11;
        }
        int i12 = 0;
        while (true) {
            z11 = true;
            if (i12 >= str.length()) {
                z11 = false;
                break;
            }
            char charAt = str.charAt(i12);
            if (charAt == '_') {
                str2 = str.replaceAll("_", "");
                break;
            } else if (charAt == '-') {
                str2 = str.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                break;
            } else {
                i12++;
            }
        }
        if (!z11) {
            return k11;
        }
        i k12 = k(str2, iArr);
        if (k12 != null) {
            return k12;
        }
        for (int i13 = 0; i13 < this.f15811b.length; i13++) {
            if (!m(i13, iArr)) {
                i iVar2 = this.f15811b[i13];
                if (iVar2.f15808a.f15962b.equalsIgnoreCase(str2)) {
                    return iVar2;
                }
            }
        }
        return k12;
    }

    public k(ParserConfig parserConfig, b bVar) {
        this.f15812c = bVar.f15983a;
        this.f15813d = bVar;
        i2.a[] aVarArr = bVar.f15991i;
        this.f15811b = new i[aVarArr.length];
        int length = aVarArr.length;
        HashMap hashMap = null;
        for (int i11 = 0; i11 < length; i11++) {
            i2.a aVar = bVar.f15991i[i11];
            i f11 = parserConfig.f(parserConfig, bVar, aVar);
            this.f15811b[i11] = f11;
            for (String str : aVar.f15982v) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, f11);
            }
        }
        this.f15815f = hashMap;
        i2.a[] aVarArr2 = bVar.f15990h;
        this.f15810a = new i[aVarArr2.length];
        int length2 = aVarArr2.length;
        for (int i12 = 0; i12 < length2; i12++) {
            this.f15810a[i12] = j(bVar.f15990h[i12].f15962b);
        }
    }
}
