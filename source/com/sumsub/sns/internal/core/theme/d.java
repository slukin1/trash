package com.sumsub.sns.internal.core.theme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.SizeF;
import androidx.core.content.res.ResourcesCompat;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSCustomizationFileFormat;
import com.sumsub.sns.core.theme.SNSCustomizationTheme;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.core.theme.SNSTheme;
import com.sumsub.sns.core.theme.SNSThemeColor;
import com.sumsub.sns.core.theme.SNSThemeFont;
import com.sumsub.sns.core.theme.SNSThemeMetric;
import com.sumsub.sns.core.theme.SNSTypographyElement;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.theme.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.reflect.p;
import kotlin.reflect.q;
import kotlinx.serialization.h;

public final class d implements SNSCustomizationTheme {

    /* renamed from: f  reason: collision with root package name */
    public static final a f34050f = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final SNSCustomizationFileFormat f34051a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, b.g> f34052b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, b.a> f34053c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, ? extends b> f34054d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, ? extends b> f34055e;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }

        public final d a(Map<String, ? extends Object> map, SNSCustomizationFileFormat sNSCustomizationFileFormat) {
            d dVar = new d(sNSCustomizationFileFormat);
            dVar.a(map);
            return dVar;
        }

        public final d a(SNSTheme sNSTheme) {
            d dVar = new d(SNSCustomizationFileFormat.NATIVE);
            dVar.a(sNSTheme);
            return dVar;
        }

        public final int a(int i11) {
            return (int) (((float) i11) * Resources.getSystem().getDisplayMetrics().density);
        }

        public final float a(float f11) {
            return f11 * Resources.getSystem().getDisplayMetrics().density;
        }

        public final d a(kotlinx.serialization.json.a aVar, String str, SNSCustomizationFileFormat sNSCustomizationFileFormat) {
            try {
                kotlinx.serialization.modules.d a11 = aVar.a();
                q.a aVar2 = q.f56856c;
                p p11 = Reflection.p(Map.class, aVar2.a(Reflection.n(String.class)), aVar2.a(Reflection.n(Object.class)));
                MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
                return a((Map<String, ? extends Object>) (Map) aVar.c(h.d(a11, p11), str), sNSCustomizationFileFormat);
            } catch (Exception e11) {
                com.sumsub.sns.internal.log.a aVar3 = com.sumsub.sns.internal.log.a.f34862a;
                String a12 = com.sumsub.sns.internal.log.c.a(this);
                String message = e11.getMessage();
                if (message == null) {
                    message = "";
                }
                aVar3.e(a12, message, e11);
                return null;
            }
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34056a;

        static {
            int[] iArr = new int[SNSCustomizationFileFormat.values().length];
            iArr[SNSCustomizationFileFormat.CORDOVA.ordinal()] = 1;
            iArr[SNSCustomizationFileFormat.REACT_NATIVE.ordinal()] = 2;
            iArr[SNSCustomizationFileFormat.FLUTTER.ordinal()] = 3;
            iArr[SNSCustomizationFileFormat.NATIVE.ordinal()] = 4;
            f34056a = iArr;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f34057a;

        /* renamed from: b  reason: collision with root package name */
        public final int f34058b;

        public c(String str, int i11) {
            this.f34057a = str;
            this.f34058b = i11;
        }

        public final String a() {
            return this.f34057a;
        }

        public final int b() {
            return this.f34058b;
        }

        public final String c() {
            return this.f34057a;
        }

        public final int d() {
            return this.f34058b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(this.f34057a, cVar.f34057a) && this.f34058b == cVar.f34058b;
        }

        public int hashCode() {
            return (this.f34057a.hashCode() * 31) + this.f34058b;
        }

        public String toString() {
            return "Font(name=" + this.f34057a + ", size=" + this.f34058b + ')';
        }

        public final c a(String str, int i11) {
            return new c(str, i11);
        }

        public static /* synthetic */ c a(c cVar, String str, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = cVar.f34057a;
            }
            if ((i12 & 2) != 0) {
                i11 = cVar.f34058b;
            }
            return cVar.a(str, i11);
        }
    }

    public d(SNSCustomizationFileFormat sNSCustomizationFileFormat) {
        this.f34051a = sNSCustomizationFileFormat;
    }

    public static final d a(kotlinx.serialization.json.a aVar, String str, SNSCustomizationFileFormat sNSCustomizationFileFormat) {
        return f34050f.a(aVar, str, sNSCustomizationFileFormat);
    }

    public static final d b(SNSTheme sNSTheme) {
        return f34050f.a(sNSTheme);
    }

    public final Map<String, b> c() {
        return this.f34054d;
    }

    public final Map<String, b.g> d() {
        return this.f34052b;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(java.util.Map<java.lang.String, ? extends java.lang.Object> r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r3 = com.sumsub.sns.internal.log.c.a(r22)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "collectTypography map="
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            r5 = 0
            r6 = 4
            r7 = 0
            com.sumsub.log.logger.a.a(r2, r3, r4, r5, r6, r7)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            java.util.Set r5 = r23.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0038:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x013a
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = "assets"
            boolean r7 = kotlin.jvm.internal.x.b(r6, r7)
            java.lang.String r8 = "name"
            r9 = 0
            if (r7 == 0) goto L_0x00b8
            java.lang.Object r6 = r1.get(r6)
            boolean r7 = r6 instanceof java.util.List
            if (r7 == 0) goto L_0x005a
            java.util.List r6 = (java.util.List) r6
            goto L_0x005b
        L_0x005a:
            r6 = r9
        L_0x005b:
            if (r6 == 0) goto L_0x0038
            java.util.Iterator r6 = r6.iterator()
        L_0x0061:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0038
            java.lang.Object r7 = r6.next()
            boolean r10 = r7 instanceof java.util.Map
            if (r10 == 0) goto L_0x0073
            r10 = r7
            java.util.Map r10 = (java.util.Map) r10
            goto L_0x0074
        L_0x0073:
            r10 = r9
        L_0x0074:
            if (r10 == 0) goto L_0x0061
            java.lang.Object r11 = r10.get(r8)
            boolean r12 = r11 instanceof java.lang.String
            if (r12 == 0) goto L_0x0081
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x0082
        L_0x0081:
            r11 = r9
        L_0x0082:
            java.lang.String r12 = "file"
            java.lang.Object r10 = r10.get(r12)
            boolean r12 = r10 instanceof java.lang.String
            if (r12 == 0) goto L_0x008f
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0090
        L_0x008f:
            r10 = r9
        L_0x0090:
            if (r11 == 0) goto L_0x0098
            if (r10 == 0) goto L_0x0098
            r2.put(r11, r10)
            goto L_0x0061
        L_0x0098:
            com.sumsub.sns.internal.log.a r12 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r13 = com.sumsub.sns.internal.log.c.a(r22)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Theme: file and name must exist: "
            r10.append(r11)
            r10.append(r7)
            java.lang.String r14 = r10.toString()
            r15 = 0
            r16 = 4
            r17 = 0
            com.sumsub.log.logger.a.a(r12, r13, r14, r15, r16, r17)
            goto L_0x0061
        L_0x00b8:
            com.sumsub.sns.core.theme.SNSTypographyElement$Companion r7 = com.sumsub.sns.core.theme.SNSTypographyElement.Companion
            java.util.List r7 = r7.getNames()
            boolean r7 = r7.contains(r6)
            if (r7 == 0) goto L_0x0118
            java.lang.Object r7 = r1.get(r6)
            boolean r10 = r7 instanceof java.util.Map
            if (r10 == 0) goto L_0x00cf
            java.util.Map r7 = (java.util.Map) r7
            goto L_0x00d0
        L_0x00cf:
            r7 = r9
        L_0x00d0:
            if (r7 == 0) goto L_0x0038
            java.lang.Object r8 = r7.get(r8)
            boolean r10 = r8 instanceof java.lang.String
            if (r10 == 0) goto L_0x00dd
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
        L_0x00dd:
            java.lang.String r8 = "size"
            java.lang.Object r8 = r7.get(r8)
            java.lang.Integer r8 = r0.a((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00f9
            if (r8 == 0) goto L_0x00f9
            com.sumsub.sns.internal.core.theme.d$c r7 = new com.sumsub.sns.internal.core.theme.d$c
            int r8 = r8.intValue()
            r7.<init>(r9, r8)
            r3.put(r6, r7)
            goto L_0x0038
        L_0x00f9:
            com.sumsub.sns.internal.log.a r10 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r11 = com.sumsub.sns.internal.log.c.a(r22)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "Theme: name and size must exist: "
            r6.append(r8)
            r6.append(r7)
            java.lang.String r12 = r6.toString()
            r13 = 0
            r14 = 4
            r15 = 0
            com.sumsub.log.logger.a.a(r10, r11, r12, r13, r14, r15)
            goto L_0x0038
        L_0x0118:
            com.sumsub.sns.internal.log.a r16 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r17 = com.sumsub.sns.internal.log.c.a(r22)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Unknown typography "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r18 = r7.toString()
            r19 = 0
            r20 = 4
            r21 = 0
            com.sumsub.log.logger.a.a(r16, r17, r18, r19, r20, r21)
            goto L_0x0038
        L_0x013a:
            java.util.Set r1 = r3.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0142:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0179
            java.lang.Object r5 = r1.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r3.get(r5)
            com.sumsub.sns.internal.core.theme.d$c r6 = (com.sumsub.sns.internal.core.theme.d.c) r6
            if (r6 == 0) goto L_0x0142
            java.lang.String r7 = r6.c()
            java.lang.Object r7 = r2.get(r7)
            r11 = r7
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x0142
            java.lang.String r9 = r6.c()
            int r10 = r6.d()
            com.sumsub.sns.internal.core.theme.b$g r6 = new com.sumsub.sns.internal.core.theme.b$g
            r12 = 0
            r13 = 8
            r14 = 0
            r8 = r6
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r4.put(r5, r6)
            goto L_0x0142
        L_0x0179:
            com.sumsub.sns.internal.log.a r15 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r16 = com.sumsub.sns.internal.log.c.a(r22)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "typography result="
            r1.append(r2)
            r1.append(r4)
            java.lang.String r17 = r1.toString()
            r18 = 0
            r19 = 4
            r20 = 0
            com.sumsub.log.logger.a.a(r15, r16, r17, r18, r19, r20)
            java.util.Map<java.lang.String, com.sumsub.sns.internal.core.theme.b$g> r1 = r0.f34052b
            if (r1 == 0) goto L_0x01a7
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.y(r1)
            if (r1 == 0) goto L_0x01a7
            r1.putAll(r4)
            r4 = r1
        L_0x01a7:
            r0.f34052b = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.theme.d.e(java.util.Map):void");
    }

    public static final d a(Map<String, ? extends Object> map, SNSCustomizationFileFormat sNSCustomizationFileFormat) {
        return f34050f.a(map, sNSCustomizationFileFormat);
    }

    public final Map<String, b> b() {
        return this.f34055e;
    }

    public final void c(Map<String, ? extends Object> map) {
        Map y11;
        Map<String, ? extends Object> map2 = map;
        Map linkedHashMap = new LinkedHashMap();
        for (String str : map.keySet()) {
            if (ImageElementName.Companion.a().contains(str)) {
                Object obj = map2.get(str);
                String str2 = null;
                Map map3 = obj instanceof Map ? (Map) obj : null;
                if (map3 == null) {
                    Object obj2 = map2.get(str);
                    if (obj2 instanceof String) {
                        str2 = (String) obj2;
                    }
                    linkedHashMap.put(str, new b.c(str2, (Integer) null, (String) null, (Bitmap) null, 8, (r) null));
                } else if (map3.containsKey("image")) {
                    linkedHashMap.put(str, b(this, map3));
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (String str3 : map3.keySet()) {
                        Object obj3 = map3.get(str3);
                        Map map4 = obj3 instanceof Map ? (Map) obj3 : null;
                        if (map4 != null) {
                            linkedHashMap2.put(str3, b(this, map4));
                        } else {
                            Object obj4 = map3.get(str3);
                            String str4 = obj4 instanceof String ? (String) obj4 : null;
                            if (str4 != null) {
                                linkedHashMap2.put(str3, new b.c(str4, (Integer) null, (String) null, (Bitmap) null, 8, (r) null));
                            }
                        }
                    }
                    linkedHashMap.put(str, new b.d(linkedHashMap2));
                }
            } else {
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                String a11 = com.sumsub.sns.internal.log.c.a(this);
                com.sumsub.log.logger.a.a(aVar, a11, "Unknown image " + str, (Throwable) null, 4, (Object) null);
            }
        }
        Map<String, ? extends b> map5 = this.f34055e;
        if (!(map5 == null || (y11 = MapsKt__MapsKt.y(map5)) == null)) {
            y11.putAll(linkedHashMap);
            linkedHashMap = y11;
        }
        this.f34055e = linkedHashMap;
    }

    public final void d(Map<String, ? extends Object> map) {
        Map y11;
        Float f11;
        Map linkedHashMap = new LinkedHashMap();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof String) {
                linkedHashMap.put(str, new b.f((String) obj));
            } else if (obj instanceof Double) {
                linkedHashMap.put(str, new b.C0385b(Float.valueOf(f34050f.a((float) ((Number) obj).doubleValue()))));
            } else if (obj instanceof Integer) {
                linkedHashMap.put(str, new b.C0385b(Float.valueOf(f34050f.a((float) ((Number) obj).intValue()))));
            } else if (obj instanceof Map) {
                Map map2 = (Map) obj;
                Integer a11 = a(map2.get("width"));
                Integer a12 = a(map2.get("height"));
                Float f12 = null;
                if (a11 != null) {
                    f11 = Float.valueOf(f34050f.a((float) a11.intValue()));
                } else {
                    f11 = null;
                }
                if (a12 != null) {
                    f12 = Float.valueOf(f34050f.a((float) a12.intValue()));
                }
                linkedHashMap.put(str, new b.e(f11, f12));
            } else {
                com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "Unknown metric " + str, (Throwable) null, 4, (Object) null);
            }
        }
        Map<String, ? extends b> map3 = this.f34054d;
        if (!(map3 == null || (y11 = MapsKt__MapsKt.y(map3)) == null)) {
            y11.putAll(linkedHashMap);
            linkedHashMap = y11;
        }
        this.f34054d = linkedHashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095 A[Catch:{ Exception -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0098 A[Catch:{ Exception -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b A[Catch:{ Exception -> 0x00a6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.util.Map<java.lang.String, ? extends java.lang.Object> r13) {
        /*
            r12 = this;
            com.sumsub.sns.internal.log.a r0 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r1 = com.sumsub.sns.internal.log.c.a(r12)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Collect colors "
            r2.append(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r3 = 0
            r4 = 4
            r5 = 0
            com.sumsub.log.logger.a.a(r0, r1, r2, r3, r4, r5)
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Set r1 = r13.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x002a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x011e
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            com.sumsub.sns.internal.log.a r9 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r4 = com.sumsub.sns.internal.log.c.a(r12)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "key="
            r3.append(r5)
            r3.append(r2)
            java.lang.String r5 = r3.toString()
            r6 = 0
            r7 = 4
            r8 = 0
            r3 = r9
            com.sumsub.log.logger.a.a(r3, r4, r5, r6, r7, r8)
            com.sumsub.sns.core.theme.SNSColorElement$Companion r3 = com.sumsub.sns.core.theme.SNSColorElement.Companion
            java.util.List r3 = r3.getNames()
            boolean r3 = r3.contains(r2)
            if (r3 == 0) goto L_0x0100
            java.lang.Object r3 = r13.get(r2)
            boolean r4 = r3 instanceof java.util.Map
            r5 = 0
            if (r4 == 0) goto L_0x006c
            java.util.Map r3 = (java.util.Map) r3
            goto L_0x006d
        L_0x006c:
            r3 = r5
        L_0x006d:
            if (r3 == 0) goto L_0x00b2
            java.lang.String r4 = "dark"
            java.lang.Object r4 = r3.get(r4)     // Catch:{ Exception -> 0x008a }
            boolean r6 = r4 instanceof java.lang.String     // Catch:{ Exception -> 0x008a }
            if (r6 == 0) goto L_0x007c
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x008a }
            goto L_0x007d
        L_0x007c:
            r4 = r5
        L_0x007d:
            if (r4 == 0) goto L_0x008a
            com.sumsub.sns.internal.core.theme.a$a r6 = com.sumsub.sns.internal.core.theme.a.f34034a     // Catch:{ Exception -> 0x008a }
            int r4 = r6.a(r4)     // Catch:{ Exception -> 0x008a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x008a }
            goto L_0x008b
        L_0x008a:
            r4 = r5
        L_0x008b:
            java.lang.String r6 = "light"
            java.lang.Object r3 = r3.get(r6)     // Catch:{ Exception -> 0x00a6 }
            boolean r6 = r3 instanceof java.lang.String     // Catch:{ Exception -> 0x00a6 }
            if (r6 == 0) goto L_0x0098
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x00a6 }
            goto L_0x0099
        L_0x0098:
            r3 = r5
        L_0x0099:
            if (r3 == 0) goto L_0x00a6
            com.sumsub.sns.internal.core.theme.a$a r6 = com.sumsub.sns.internal.core.theme.a.f34034a     // Catch:{ Exception -> 0x00a6 }
            int r3 = r6.a(r3)     // Catch:{ Exception -> 0x00a6 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00a7
        L_0x00a6:
            r3 = r5
        L_0x00a7:
            com.sumsub.sns.internal.core.theme.b$a r6 = new com.sumsub.sns.internal.core.theme.b$a
            r6.<init>(r4, r3)
            r0.put(r2, r6)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x00b3
        L_0x00b2:
            r3 = r5
        L_0x00b3:
            if (r3 != 0) goto L_0x00d5
            java.lang.Object r3 = r13.get(r2)     // Catch:{ Exception -> 0x00cd }
            boolean r4 = r3 instanceof java.lang.String     // Catch:{ Exception -> 0x00cd }
            if (r4 == 0) goto L_0x00c0
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x00cd }
            goto L_0x00c1
        L_0x00c0:
            r3 = r5
        L_0x00c1:
            if (r3 == 0) goto L_0x00cd
            com.sumsub.sns.internal.core.theme.a$a r4 = com.sumsub.sns.internal.core.theme.a.f34034a     // Catch:{ Exception -> 0x00cd }
            int r3 = r4.a(r3)     // Catch:{ Exception -> 0x00cd }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x00cd }
        L_0x00cd:
            com.sumsub.sns.internal.core.theme.b$a r3 = new com.sumsub.sns.internal.core.theme.b$a
            r3.<init>(r5, r5)
            r0.put(r2, r3)
        L_0x00d5:
            com.sumsub.sns.internal.log.a r6 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r7 = com.sumsub.sns.internal.log.c.a(r12)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "parsed "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = " = "
            r3.append(r4)
            java.lang.Object r2 = r0.get(r2)
            r3.append(r2)
            java.lang.String r8 = r3.toString()
            r9 = 0
            r10 = 4
            r11 = 0
            com.sumsub.log.logger.a.a(r6, r7, r8, r9, r10, r11)
            goto L_0x002a
        L_0x0100:
            java.lang.String r4 = com.sumsub.sns.internal.log.c.a(r12)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Unknown color: "
            r3.append(r5)
            r3.append(r2)
            java.lang.String r5 = r3.toString()
            r6 = 0
            r7 = 4
            r8 = 0
            r3 = r9
            com.sumsub.log.logger.a.a(r3, r4, r5, r6, r7, r8)
            goto L_0x002a
        L_0x011e:
            java.util.Map<java.lang.String, com.sumsub.sns.internal.core.theme.b$a> r13 = r12.f34053c
            if (r13 == 0) goto L_0x012c
            java.util.Map r13 = kotlin.collections.MapsKt__MapsKt.y(r13)
            if (r13 == 0) goto L_0x012c
            r13.putAll(r0)
            r0 = r13
        L_0x012c:
            r12.f34053c = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.theme.d.b(java.util.Map):void");
    }

    public final Map<String, b.a> a() {
        return this.f34053c;
    }

    public final void a(SNSTheme sNSTheme) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (Map.Entry next : i.a(sNSTheme.getFonts()).entrySet()) {
            hashMap.put(((SNSTypographyElement) next.getKey()).getValue(), new b.g("", ((SNSThemeFont) next.getValue()).getSizeSp(), "", ((SNSThemeFont) next.getValue()).getTypeface()));
        }
        for (Map.Entry next2 : i.a(sNSTheme.getColors()).entrySet()) {
            hashMap2.put(((SNSColorElement) next2.getKey()).getValue(), new b.a(Integer.valueOf(((SNSThemeColor) next2.getValue()).getDark()), Integer.valueOf(((SNSThemeColor) next2.getValue()).getLight())));
        }
        for (Map.Entry next3 : i.a(sNSTheme.getMetrics()).entrySet()) {
            String value = ((SNSMetricElement) next3.getKey()).getValue();
            Object value2 = next3.getValue();
            if (value2 instanceof Float) {
                hashMap3.put(value, new b.C0385b((Float) value2));
            } else if (value2 instanceof SizeF) {
                SizeF sizeF = (SizeF) value2;
                hashMap3.put(value, new b.e(Float.valueOf(sizeF.getWidth()), Float.valueOf(sizeF.getHeight())));
            } else if (value2 instanceof SNSThemeMetric.Size) {
                hashMap3.put(value, new b.f(((SNSThemeMetric.Size) value2).getValue()));
            } else if (value2 instanceof SNSThemeMetric.CardStyle) {
                hashMap3.put(value, new b.f(((SNSThemeMetric.CardStyle) value2).getValue()));
            } else if (value2 instanceof SNSThemeMetric.TextAlignment) {
                hashMap3.put(value, new b.f(((SNSThemeMetric.TextAlignment) value2).getValue()));
            }
        }
        this.f34052b = hashMap;
        this.f34053c = hashMap2;
        this.f34054d = hashMap3;
    }

    public static final b.c b(d dVar, Map<String, ? extends Object> map) {
        Object obj = map.get("image");
        String str = null;
        String str2 = obj instanceof String ? (String) obj : null;
        Integer a11 = dVar.a((Object) map.get("scale"));
        Object obj2 = map.get("rendering");
        if (obj2 instanceof String) {
            str = (String) obj2;
        }
        return new b.c(str2, a11, str, (Bitmap) null, 8, (r) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.util.Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.util.Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.util.Map} */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0324, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008e, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01da, code lost:
        r3 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0460  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0504  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x0053 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x00f9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x019f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0243 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x02e9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x038d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x0433 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x04d7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.Map<java.lang.String, ? extends java.lang.Object> r14) {
        /*
            r13 = this;
            java.lang.String r0 = "universal"
            java.lang.String r1 = "fonts"
            java.lang.String[] r2 = new java.lang.String[]{r0, r1}
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.n(r2)
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            r3.element = r14
            int r4 = r2.size()
            int r4 = r4 + -1
            r5 = 0
            kotlin.ranges.h r4 = kotlin.ranges.RangesKt___RangesKt.o(r5, r4)
            java.util.Iterator r4 = r4.iterator()
        L_0x0022:
            boolean r6 = r4.hasNext()
            r7 = 0
            if (r6 == 0) goto L_0x0090
            r6 = r4
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.a()
            T r8 = r3.element
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r6 = r2.get(r6)
            java.lang.Object r6 = r8.get(r6)
            boolean r8 = r6 instanceof java.util.Map
            if (r8 == 0) goto L_0x0043
            java.util.Map r6 = (java.util.Map) r6
            goto L_0x0044
        L_0x0043:
            r6 = r7
        L_0x0044:
            if (r6 == 0) goto L_0x008e
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0053:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x0084
            java.lang.Object r9 = r6.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r10 = r9.getKey()
            boolean r11 = r10 instanceof java.lang.String
            if (r11 != 0) goto L_0x0068
            r10 = r7
        L_0x0068:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto L_0x006d
            goto L_0x0078
        L_0x006d:
            java.lang.Object r9 = r9.getValue()
            boolean r11 = r9 instanceof java.lang.Object
            if (r11 != 0) goto L_0x0076
            r9 = r7
        L_0x0076:
            if (r9 != 0) goto L_0x007a
        L_0x0078:
            r9 = r7
            goto L_0x007e
        L_0x007a:
            kotlin.Pair r9 = kotlin.l.a(r10, r9)
        L_0x007e:
            if (r9 == 0) goto L_0x0053
            r8.add(r9)
            goto L_0x0053
        L_0x0084:
            java.util.Map r6 = kotlin.collections.MapsKt__MapsKt.s(r8)
            if (r6 != 0) goto L_0x008b
            goto L_0x008e
        L_0x008b:
            r3.element = r6
            goto L_0x0022
        L_0x008e:
            r2 = r7
            goto L_0x00a3
        L_0x0090:
            T r3 = r3.element
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r2)
            java.lang.Object r2 = r3.get(r2)
            boolean r3 = r2 instanceof java.util.Map
            if (r3 != 0) goto L_0x00a1
            r2 = r7
        L_0x00a1:
            java.util.Map r2 = (java.util.Map) r2
        L_0x00a3:
            if (r2 == 0) goto L_0x00aa
            r13.e(r2)
            kotlin.Unit r2 = kotlin.Unit.f56620a
        L_0x00aa:
            java.lang.String r2 = "android"
            java.lang.String[] r1 = new java.lang.String[]{r2, r1}
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.n(r1)
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            r3.element = r14
            int r4 = r1.size()
            int r4 = r4 + -1
            kotlin.ranges.h r4 = kotlin.ranges.RangesKt___RangesKt.o(r5, r4)
            java.util.Iterator r4 = r4.iterator()
        L_0x00c9:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0136
            r6 = r4
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.a()
            T r8 = r3.element
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r6 = r1.get(r6)
            java.lang.Object r6 = r8.get(r6)
            boolean r8 = r6 instanceof java.util.Map
            if (r8 == 0) goto L_0x00e9
            java.util.Map r6 = (java.util.Map) r6
            goto L_0x00ea
        L_0x00e9:
            r6 = r7
        L_0x00ea:
            if (r6 == 0) goto L_0x0134
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x00f9:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x012a
            java.lang.Object r9 = r6.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r10 = r9.getKey()
            boolean r11 = r10 instanceof java.lang.String
            if (r11 != 0) goto L_0x010e
            r10 = r7
        L_0x010e:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto L_0x0113
            goto L_0x011e
        L_0x0113:
            java.lang.Object r9 = r9.getValue()
            boolean r11 = r9 instanceof java.lang.Object
            if (r11 != 0) goto L_0x011c
            r9 = r7
        L_0x011c:
            if (r9 != 0) goto L_0x0120
        L_0x011e:
            r9 = r7
            goto L_0x0124
        L_0x0120:
            kotlin.Pair r9 = kotlin.l.a(r10, r9)
        L_0x0124:
            if (r9 == 0) goto L_0x00f9
            r8.add(r9)
            goto L_0x00f9
        L_0x012a:
            java.util.Map r6 = kotlin.collections.MapsKt__MapsKt.s(r8)
            if (r6 != 0) goto L_0x0131
            goto L_0x0134
        L_0x0131:
            r3.element = r6
            goto L_0x00c9
        L_0x0134:
            r1 = r7
            goto L_0x0149
        L_0x0136:
            T r3 = r3.element
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r1)
            java.lang.Object r1 = r3.get(r1)
            boolean r3 = r1 instanceof java.util.Map
            if (r3 != 0) goto L_0x0147
            r1 = r7
        L_0x0147:
            java.util.Map r1 = (java.util.Map) r1
        L_0x0149:
            if (r1 == 0) goto L_0x0150
            r13.e(r1)
            kotlin.Unit r1 = kotlin.Unit.f56620a
        L_0x0150:
            java.lang.String r1 = "colors"
            java.lang.String[] r3 = new java.lang.String[]{r0, r1}
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.n(r3)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            r4.element = r14
            int r6 = r3.size()
            int r6 = r6 + -1
            kotlin.ranges.h r6 = kotlin.ranges.RangesKt___RangesKt.o(r5, r6)
            java.util.Iterator r6 = r6.iterator()
        L_0x016f:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x01dc
            r8 = r6
            kotlin.collections.IntIterator r8 = (kotlin.collections.IntIterator) r8
            int r8 = r8.a()
            T r9 = r4.element
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r8 = r3.get(r8)
            java.lang.Object r8 = r9.get(r8)
            boolean r9 = r8 instanceof java.util.Map
            if (r9 == 0) goto L_0x018f
            java.util.Map r8 = (java.util.Map) r8
            goto L_0x0190
        L_0x018f:
            r8 = r7
        L_0x0190:
            if (r8 == 0) goto L_0x01da
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x019f:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x01d0
            java.lang.Object r10 = r8.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r11 = r10.getKey()
            boolean r12 = r11 instanceof java.lang.String
            if (r12 != 0) goto L_0x01b4
            r11 = r7
        L_0x01b4:
            java.lang.String r11 = (java.lang.String) r11
            if (r11 != 0) goto L_0x01b9
            goto L_0x01c4
        L_0x01b9:
            java.lang.Object r10 = r10.getValue()
            boolean r12 = r10 instanceof java.lang.Object
            if (r12 != 0) goto L_0x01c2
            r10 = r7
        L_0x01c2:
            if (r10 != 0) goto L_0x01c6
        L_0x01c4:
            r10 = r7
            goto L_0x01ca
        L_0x01c6:
            kotlin.Pair r10 = kotlin.l.a(r11, r10)
        L_0x01ca:
            if (r10 == 0) goto L_0x019f
            r9.add(r10)
            goto L_0x019f
        L_0x01d0:
            java.util.Map r8 = kotlin.collections.MapsKt__MapsKt.s(r9)
            if (r8 != 0) goto L_0x01d7
            goto L_0x01da
        L_0x01d7:
            r4.element = r8
            goto L_0x016f
        L_0x01da:
            r3 = r7
            goto L_0x01ef
        L_0x01dc:
            T r4 = r4.element
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r3)
            java.lang.Object r3 = r4.get(r3)
            boolean r4 = r3 instanceof java.util.Map
            if (r4 != 0) goto L_0x01ed
            r3 = r7
        L_0x01ed:
            java.util.Map r3 = (java.util.Map) r3
        L_0x01ef:
            if (r3 == 0) goto L_0x01f6
            r13.b((java.util.Map<java.lang.String, ? extends java.lang.Object>) r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
        L_0x01f6:
            java.lang.String[] r1 = new java.lang.String[]{r2, r1}
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.n(r1)
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            r3.element = r14
            int r4 = r1.size()
            int r4 = r4 + -1
            kotlin.ranges.h r4 = kotlin.ranges.RangesKt___RangesKt.o(r5, r4)
            java.util.Iterator r4 = r4.iterator()
        L_0x0213:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0280
            r6 = r4
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.a()
            T r8 = r3.element
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r6 = r1.get(r6)
            java.lang.Object r6 = r8.get(r6)
            boolean r8 = r6 instanceof java.util.Map
            if (r8 == 0) goto L_0x0233
            java.util.Map r6 = (java.util.Map) r6
            goto L_0x0234
        L_0x0233:
            r6 = r7
        L_0x0234:
            if (r6 == 0) goto L_0x027e
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0243:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x0274
            java.lang.Object r9 = r6.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r10 = r9.getKey()
            boolean r11 = r10 instanceof java.lang.String
            if (r11 != 0) goto L_0x0258
            r10 = r7
        L_0x0258:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto L_0x025d
            goto L_0x0268
        L_0x025d:
            java.lang.Object r9 = r9.getValue()
            boolean r11 = r9 instanceof java.lang.Object
            if (r11 != 0) goto L_0x0266
            r9 = r7
        L_0x0266:
            if (r9 != 0) goto L_0x026a
        L_0x0268:
            r9 = r7
            goto L_0x026e
        L_0x026a:
            kotlin.Pair r9 = kotlin.l.a(r10, r9)
        L_0x026e:
            if (r9 == 0) goto L_0x0243
            r8.add(r9)
            goto L_0x0243
        L_0x0274:
            java.util.Map r6 = kotlin.collections.MapsKt__MapsKt.s(r8)
            if (r6 != 0) goto L_0x027b
            goto L_0x027e
        L_0x027b:
            r3.element = r6
            goto L_0x0213
        L_0x027e:
            r1 = r7
            goto L_0x0293
        L_0x0280:
            T r3 = r3.element
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r1)
            java.lang.Object r1 = r3.get(r1)
            boolean r3 = r1 instanceof java.util.Map
            if (r3 != 0) goto L_0x0291
            r1 = r7
        L_0x0291:
            java.util.Map r1 = (java.util.Map) r1
        L_0x0293:
            if (r1 == 0) goto L_0x029a
            r13.b((java.util.Map<java.lang.String, ? extends java.lang.Object>) r1)
            kotlin.Unit r1 = kotlin.Unit.f56620a
        L_0x029a:
            java.lang.String r1 = "metrics"
            java.lang.String[] r3 = new java.lang.String[]{r0, r1}
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.n(r3)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            r4.element = r14
            int r6 = r3.size()
            int r6 = r6 + -1
            kotlin.ranges.h r6 = kotlin.ranges.RangesKt___RangesKt.o(r5, r6)
            java.util.Iterator r6 = r6.iterator()
        L_0x02b9:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0326
            r8 = r6
            kotlin.collections.IntIterator r8 = (kotlin.collections.IntIterator) r8
            int r8 = r8.a()
            T r9 = r4.element
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r8 = r3.get(r8)
            java.lang.Object r8 = r9.get(r8)
            boolean r9 = r8 instanceof java.util.Map
            if (r9 == 0) goto L_0x02d9
            java.util.Map r8 = (java.util.Map) r8
            goto L_0x02da
        L_0x02d9:
            r8 = r7
        L_0x02da:
            if (r8 == 0) goto L_0x0324
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x02e9:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x031a
            java.lang.Object r10 = r8.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r11 = r10.getKey()
            boolean r12 = r11 instanceof java.lang.String
            if (r12 != 0) goto L_0x02fe
            r11 = r7
        L_0x02fe:
            java.lang.String r11 = (java.lang.String) r11
            if (r11 != 0) goto L_0x0303
            goto L_0x030e
        L_0x0303:
            java.lang.Object r10 = r10.getValue()
            boolean r12 = r10 instanceof java.lang.Object
            if (r12 != 0) goto L_0x030c
            r10 = r7
        L_0x030c:
            if (r10 != 0) goto L_0x0310
        L_0x030e:
            r10 = r7
            goto L_0x0314
        L_0x0310:
            kotlin.Pair r10 = kotlin.l.a(r11, r10)
        L_0x0314:
            if (r10 == 0) goto L_0x02e9
            r9.add(r10)
            goto L_0x02e9
        L_0x031a:
            java.util.Map r8 = kotlin.collections.MapsKt__MapsKt.s(r9)
            if (r8 != 0) goto L_0x0321
            goto L_0x0324
        L_0x0321:
            r4.element = r8
            goto L_0x02b9
        L_0x0324:
            r3 = r7
            goto L_0x0339
        L_0x0326:
            T r4 = r4.element
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r3)
            java.lang.Object r3 = r4.get(r3)
            boolean r4 = r3 instanceof java.util.Map
            if (r4 != 0) goto L_0x0337
            r3 = r7
        L_0x0337:
            java.util.Map r3 = (java.util.Map) r3
        L_0x0339:
            if (r3 == 0) goto L_0x0340
            r13.d(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
        L_0x0340:
            java.lang.String[] r1 = new java.lang.String[]{r2, r1}
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.n(r1)
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            r3.element = r14
            int r4 = r1.size()
            int r4 = r4 + -1
            kotlin.ranges.h r4 = kotlin.ranges.RangesKt___RangesKt.o(r5, r4)
            java.util.Iterator r4 = r4.iterator()
        L_0x035d:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x03ca
            r6 = r4
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.a()
            T r8 = r3.element
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r6 = r1.get(r6)
            java.lang.Object r6 = r8.get(r6)
            boolean r8 = r6 instanceof java.util.Map
            if (r8 == 0) goto L_0x037d
            java.util.Map r6 = (java.util.Map) r6
            goto L_0x037e
        L_0x037d:
            r6 = r7
        L_0x037e:
            if (r6 == 0) goto L_0x03c8
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x038d:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x03be
            java.lang.Object r9 = r6.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r10 = r9.getKey()
            boolean r11 = r10 instanceof java.lang.String
            if (r11 != 0) goto L_0x03a2
            r10 = r7
        L_0x03a2:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto L_0x03a7
            goto L_0x03b2
        L_0x03a7:
            java.lang.Object r9 = r9.getValue()
            boolean r11 = r9 instanceof java.lang.Object
            if (r11 != 0) goto L_0x03b0
            r9 = r7
        L_0x03b0:
            if (r9 != 0) goto L_0x03b4
        L_0x03b2:
            r9 = r7
            goto L_0x03b8
        L_0x03b4:
            kotlin.Pair r9 = kotlin.l.a(r10, r9)
        L_0x03b8:
            if (r9 == 0) goto L_0x038d
            r8.add(r9)
            goto L_0x038d
        L_0x03be:
            java.util.Map r6 = kotlin.collections.MapsKt__MapsKt.s(r8)
            if (r6 != 0) goto L_0x03c5
            goto L_0x03c8
        L_0x03c5:
            r3.element = r6
            goto L_0x035d
        L_0x03c8:
            r1 = r7
            goto L_0x03dd
        L_0x03ca:
            T r3 = r3.element
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r1)
            java.lang.Object r1 = r3.get(r1)
            boolean r3 = r1 instanceof java.util.Map
            if (r3 != 0) goto L_0x03db
            r1 = r7
        L_0x03db:
            java.util.Map r1 = (java.util.Map) r1
        L_0x03dd:
            if (r1 == 0) goto L_0x03e4
            r13.d(r1)
            kotlin.Unit r1 = kotlin.Unit.f56620a
        L_0x03e4:
            java.lang.String r1 = "images"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.n(r0)
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            r3.element = r14
            int r4 = r0.size()
            int r4 = r4 + -1
            kotlin.ranges.h r4 = kotlin.ranges.RangesKt___RangesKt.o(r5, r4)
            java.util.Iterator r4 = r4.iterator()
        L_0x0403:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0470
            r6 = r4
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.a()
            T r8 = r3.element
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r6 = r0.get(r6)
            java.lang.Object r6 = r8.get(r6)
            boolean r8 = r6 instanceof java.util.Map
            if (r8 == 0) goto L_0x0423
            java.util.Map r6 = (java.util.Map) r6
            goto L_0x0424
        L_0x0423:
            r6 = r7
        L_0x0424:
            if (r6 == 0) goto L_0x046e
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0433:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x0464
            java.lang.Object r9 = r6.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r10 = r9.getKey()
            boolean r11 = r10 instanceof java.lang.String
            if (r11 != 0) goto L_0x0448
            r10 = r7
        L_0x0448:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto L_0x044d
            goto L_0x0458
        L_0x044d:
            java.lang.Object r9 = r9.getValue()
            boolean r11 = r9 instanceof java.lang.Object
            if (r11 != 0) goto L_0x0456
            r9 = r7
        L_0x0456:
            if (r9 != 0) goto L_0x045a
        L_0x0458:
            r9 = r7
            goto L_0x045e
        L_0x045a:
            kotlin.Pair r9 = kotlin.l.a(r10, r9)
        L_0x045e:
            if (r9 == 0) goto L_0x0433
            r8.add(r9)
            goto L_0x0433
        L_0x0464:
            java.util.Map r6 = kotlin.collections.MapsKt__MapsKt.s(r8)
            if (r6 != 0) goto L_0x046b
            goto L_0x046e
        L_0x046b:
            r3.element = r6
            goto L_0x0403
        L_0x046e:
            r0 = r7
            goto L_0x0483
        L_0x0470:
            T r3 = r3.element
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r0)
            java.lang.Object r0 = r3.get(r0)
            boolean r3 = r0 instanceof java.util.Map
            if (r3 != 0) goto L_0x0481
            r0 = r7
        L_0x0481:
            java.util.Map r0 = (java.util.Map) r0
        L_0x0483:
            if (r0 == 0) goto L_0x048a
            r13.c(r0)
            kotlin.Unit r0 = kotlin.Unit.f56620a
        L_0x048a:
            java.lang.String[] r0 = new java.lang.String[]{r2, r1}
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.n(r0)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            r1.element = r14
            int r14 = r0.size()
            int r14 = r14 + -1
            kotlin.ranges.h r14 = kotlin.ranges.RangesKt___RangesKt.o(r5, r14)
            java.util.Iterator r14 = r14.iterator()
        L_0x04a7:
            boolean r2 = r14.hasNext()
            if (r2 == 0) goto L_0x0512
            r2 = r14
            kotlin.collections.IntIterator r2 = (kotlin.collections.IntIterator) r2
            int r2 = r2.a()
            T r3 = r1.element
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r2 = r0.get(r2)
            java.lang.Object r2 = r3.get(r2)
            boolean r3 = r2 instanceof java.util.Map
            if (r3 == 0) goto L_0x04c7
            java.util.Map r2 = (java.util.Map) r2
            goto L_0x04c8
        L_0x04c7:
            r2 = r7
        L_0x04c8:
            if (r2 == 0) goto L_0x0526
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x04d7:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0508
            java.lang.Object r4 = r2.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            boolean r6 = r5 instanceof java.lang.String
            if (r6 != 0) goto L_0x04ec
            r5 = r7
        L_0x04ec:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto L_0x04f1
            goto L_0x04fc
        L_0x04f1:
            java.lang.Object r4 = r4.getValue()
            boolean r6 = r4 instanceof java.lang.Object
            if (r6 != 0) goto L_0x04fa
            r4 = r7
        L_0x04fa:
            if (r4 != 0) goto L_0x04fe
        L_0x04fc:
            r4 = r7
            goto L_0x0502
        L_0x04fe:
            kotlin.Pair r4 = kotlin.l.a(r5, r4)
        L_0x0502:
            if (r4 == 0) goto L_0x04d7
            r3.add(r4)
            goto L_0x04d7
        L_0x0508:
            java.util.Map r2 = kotlin.collections.MapsKt__MapsKt.s(r3)
            if (r2 != 0) goto L_0x050f
            goto L_0x0526
        L_0x050f:
            r1.element = r2
            goto L_0x04a7
        L_0x0512:
            T r14 = r1.element
            java.util.Map r14 = (java.util.Map) r14
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r0)
            java.lang.Object r14 = r14.get(r0)
            boolean r0 = r14 instanceof java.util.Map
            if (r0 != 0) goto L_0x0523
            goto L_0x0524
        L_0x0523:
            r7 = r14
        L_0x0524:
            java.util.Map r7 = (java.util.Map) r7
        L_0x0526:
            if (r7 == 0) goto L_0x052d
            r13.c(r7)
            kotlin.Unit r14 = kotlin.Unit.f56620a
        L_0x052d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.theme.d.a(java.util.Map):void");
    }

    @SuppressLint({"DiscouragedApi"})
    public final void a(Context context) {
        String str;
        Collection<? extends b> values;
        Bitmap bitmap;
        Collection<b.g> values2;
        Collection<? extends b> values3;
        Collection<b.g> values4;
        int i11 = b.f34056a[this.f34051a.ordinal()];
        if (i11 == 1 || i11 == 2) {
            str = "";
        } else if (i11 == 3) {
            str = "flutter_assets/";
        } else if (i11 != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            return;
        }
        SNSCustomizationFileFormat sNSCustomizationFileFormat = this.f34051a;
        if (sNSCustomizationFileFormat == SNSCustomizationFileFormat.CORDOVA || sNSCustomizationFileFormat == SNSCustomizationFileFormat.FLUTTER) {
            Map<String, b.g> map = this.f34052b;
            if (!(map == null || (values2 = map.values()) == null)) {
                for (b.g gVar : values2) {
                    try {
                        com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "Loading typeface " + gVar.f(), (Throwable) null, 4, (Object) null);
                        gVar.a(Typeface.createFromAsset(context.getResources().getAssets(), str + gVar.f()));
                    } catch (Exception e11) {
                        com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "", e11);
                    }
                }
            }
            Map<String, ? extends b> map2 = this.f34055e;
            if (map2 != null && (values = map2.values()) != null) {
                for (b bVar : values) {
                    Bitmap bitmap2 = null;
                    if (bVar instanceof b.c) {
                        b.c cVar = (b.c) bVar;
                        String f11 = cVar.f();
                        if (f11 != null) {
                            bitmap2 = a(context.getResources().getAssets(), str + f11);
                        }
                        cVar.a(bitmap2);
                    } else if (bVar instanceof b.d) {
                        for (b.c cVar2 : ((b.d) bVar).b().values()) {
                            String f12 = cVar2.f();
                            if (f12 != null) {
                                bitmap = a(context.getResources().getAssets(), str + f12);
                                Integer h11 = cVar2.h();
                                if ((h11 != null ? h11.intValue() : 1) > 1 && bitmap != null) {
                                    Integer h12 = cVar2.h();
                                    int intValue = h12 != null ? h12.intValue() : 1;
                                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() * intValue, bitmap.getHeight() * intValue, true);
                                    bitmap.recycle();
                                    bitmap = createScaledBitmap;
                                }
                            } else {
                                bitmap = null;
                            }
                            cVar2.a(bitmap);
                        }
                    } else {
                        com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "Theme: Invalid element in images: " + bVar, (Throwable) null, 4, (Object) null);
                    }
                }
            }
        } else if (sNSCustomizationFileFormat == SNSCustomizationFileFormat.REACT_NATIVE) {
            Map<String, b.g> map3 = this.f34052b;
            if (!(map3 == null || (values4 = map3.values()) == null)) {
                for (b.g gVar2 : values4) {
                    try {
                        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                        com.sumsub.log.logger.a.a(aVar, com.sumsub.sns.internal.log.c.a(this), "Loading typeface " + gVar2.f(), (Throwable) null, 4, (Object) null);
                        String a11 = a(gVar2.f());
                        com.sumsub.log.logger.a.a(aVar, com.sumsub.sns.internal.log.c.a(this), "filename=" + a11, (Throwable) null, 4, (Object) null);
                        int identifier = context.getResources().getIdentifier(a11, "raw", context.getPackageName());
                        com.sumsub.log.logger.a.a(aVar, com.sumsub.sns.internal.log.c.a(this), "resId=" + identifier, (Throwable) null, 4, (Object) null);
                        gVar2.a(ResourcesCompat.h(context, identifier));
                    } catch (Exception e12) {
                        com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
                        String a12 = com.sumsub.sns.internal.log.c.a(this);
                        String message = e12.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        aVar2.e(a12, message, e12);
                    }
                }
            }
            Map<String, ? extends b> map4 = this.f34055e;
            if (map4 != null && (values3 = map4.values()) != null) {
                for (b bVar2 : values3) {
                    if (bVar2 instanceof b.c) {
                        b.c cVar3 = (b.c) bVar2;
                        cVar3.a(a(context, cVar3));
                    } else if (bVar2 instanceof b.d) {
                        for (b.c cVar4 : ((b.d) bVar2).b().values()) {
                            cVar4.a(a(context, cVar4));
                        }
                    } else {
                        com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "Theme: Invalid element in images: " + bVar2, (Throwable) null, 4, (Object) null);
                    }
                }
            }
        }
    }

    @SuppressLint({"DiscouragedApi"})
    public final Bitmap a(Context context, b.c cVar) {
        String a11;
        Integer num = null;
        if (cVar.f() == null || (a11 = a(cVar.f())) == null) {
            return null;
        }
        int identifier = context.getResources().getIdentifier(a11, "drawable", context.getPackageName());
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), identifier);
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String a12 = com.sumsub.sns.internal.log.c.a(this);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("loadRNImage: ");
        sb2.append(cVar);
        sb2.append(", filename: ");
        sb2.append(a11);
        sb2.append(", resId: ");
        sb2.append(identifier);
        sb2.append(", result=");
        sb2.append(decodeResource != null ? Integer.valueOf(decodeResource.getWidth()) : null);
        sb2.append('x');
        if (decodeResource != null) {
            num = Integer.valueOf(decodeResource.getHeight());
        }
        sb2.append(num);
        com.sumsub.log.logger.a.a(aVar, a12, sb2.toString(), (Throwable) null, 4, (Object) null);
        return decodeResource;
    }

    public final String a(String str) {
        return StringsKt__StringsKt.g1(StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(str, " ", "", false, 4, (Object) null), "/", "_", false, 4, (Object) null), Constants.ACCEPT_TIME_SEPARATOR_SERVER, "", false, 4, (Object) null), '.', (String) null, 2, (Object) null).toLowerCase(Locale.ROOT);
    }

    public final Bitmap a(AssetManager assetManager, String str) {
        try {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String a11 = com.sumsub.sns.internal.log.c.a(this);
            com.sumsub.log.logger.a.a(aVar, a11, "Loading image " + str, (Throwable) null, 4, (Object) null);
            return BitmapFactory.decodeStream(assetManager.open(str));
        } catch (Exception e11) {
            com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
            String a12 = com.sumsub.sns.internal.log.c.a(this);
            String message = e11.getMessage();
            if (message == null) {
                message = "";
            }
            aVar2.d(a12, message, e11);
            return null;
        }
    }

    public final Integer a(Object obj) {
        Number number = obj instanceof Double ? (Double) obj : null;
        if (number == null) {
            number = obj instanceof Integer ? (Integer) obj : null;
            if (number == null) {
                String str = obj instanceof String ? (String) obj : null;
                number = str != null ? StringsKt__StringNumberConversionsKt.m(str) : null;
            }
        }
        if (number != null) {
            return Integer.valueOf(number.intValue());
        }
        return null;
    }
}
