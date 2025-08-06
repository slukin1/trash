package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.google.zxing.oned.Code39Reader;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.thumbplayer.tcmedia.core.common.TPPixelFormat;
import d2.b;
import e2.c;
import e2.e;
import h2.h;
import h2.k;
import h2.n;
import h2.o;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.HttpUrl;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public class ASMSerializerFactory {

    /* renamed from: c  reason: collision with root package name */
    public static final String f14225c = ASMUtils.f(JSONSerializer.class);

    /* renamed from: d  reason: collision with root package name */
    public static final String f14226d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f14227e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f14228f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f14229g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f14230h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f14231i;

    /* renamed from: j  reason: collision with root package name */
    public static final String f14232j = ASMUtils.b(n.class);

    /* renamed from: k  reason: collision with root package name */
    public static final String f14233k = ASMUtils.b(SerializeFilterable.class);

    /* renamed from: a  reason: collision with root package name */
    public final ASMClassLoader f14234a = new ASMClassLoader();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f14235b = new AtomicLong();

    public static class a {

        /* renamed from: h  reason: collision with root package name */
        public static int f14236h = 6;

        /* renamed from: i  reason: collision with root package name */
        public static int f14237i = 7;

        /* renamed from: j  reason: collision with root package name */
        public static int f14238j = 8;

        /* renamed from: a  reason: collision with root package name */
        public final i2.a[] f14239a;

        /* renamed from: b  reason: collision with root package name */
        public final String f14240b;

        /* renamed from: c  reason: collision with root package name */
        public final o f14241c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f14242d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, Integer> f14243e = new HashMap();

        /* renamed from: f  reason: collision with root package name */
        public int f14244f = 9;

        /* renamed from: g  reason: collision with root package name */
        public boolean f14245g;

        public a(i2.a[] aVarArr, o oVar, String str, boolean z11, boolean z12) {
            this.f14239a = aVarArr;
            this.f14240b = str;
            this.f14241c = oVar;
            this.f14242d = z11;
            this.f14245g = z12;
        }

        public int f(String str) {
            int length = this.f14239a.length;
            for (int i11 = 0; i11 < length; i11++) {
                if (this.f14239a[i11].f15962b.equals(str)) {
                    return i11;
                }
            }
            return -1;
        }

        public int g(String str) {
            if (this.f14243e.get(str) == null) {
                Map<String, Integer> map = this.f14243e;
                int i11 = this.f14244f;
                this.f14244f = i11 + 1;
                map.put(str, Integer.valueOf(i11));
            }
            return this.f14243e.get(str).intValue();
        }

        public int h(String str, int i11) {
            if (this.f14243e.get(str) == null) {
                this.f14243e.put(str, Integer.valueOf(this.f14244f));
                this.f14244f += i11;
            }
            return this.f14243e.get(str).intValue();
        }
    }

    static {
        Class<h> cls = h.class;
        String f11 = ASMUtils.f(k.class);
        f14226d = f11;
        f14227e = "L" + f11 + ";";
        String f12 = ASMUtils.f(SerializeWriter.class);
        f14228f = f12;
        f14229g = "L" + f12 + ";";
        f14230h = ASMUtils.f(cls);
        f14231i = "L" + ASMUtils.f(cls) + ";";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v86, resolved type: java.lang.Class<java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v87, resolved type: java.lang.Class<java.lang.Object>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A(java.lang.Class<?> r33, e2.c r34, i2.a[] r35, com.alibaba.fastjson.serializer.ASMSerializerFactory.a r36) throws java.lang.Exception {
        /*
            r32 = this;
            r0 = r32
            r1 = r34
            r2 = r35
            r3 = r36
            java.lang.String r4 = "out"
            int r5 = r3.g(r4)
            r6 = 25
            r1.f(r6, r5)
            r5 = 16
            r7 = 91
            r1.f(r5, r7)
            java.lang.String r7 = f14228f
            r8 = 182(0xb6, float:2.55E-43)
            java.lang.String r9 = "write"
            java.lang.String r10 = "(I)V"
            r1.k(r8, r7, r9, r10)
            int r11 = r2.length
            if (r11 != 0) goto L_0x0038
            int r2 = r3.g(r4)
            r1.f(r6, r2)
            r2 = 93
            r1.f(r5, r2)
            r1.k(r8, r7, r9, r10)
            return
        L_0x0038:
            r7 = 0
        L_0x0039:
            if (r7 >= r11) goto L_0x07f2
            int r12 = r11 + -1
            if (r7 != r12) goto L_0x0042
            r12 = 93
            goto L_0x0044
        L_0x0042:
            r12 = 44
        L_0x0044:
            r13 = r2[r7]
            java.lang.Class<?> r14 = r13.f15966f
            java.lang.String r15 = r13.f15962b
            r1.b(r15)
            int r15 = com.alibaba.fastjson.serializer.ASMSerializerFactory.a.f14236h
            r5 = 58
            r1.f(r5, r15)
            java.lang.Class r15 = java.lang.Byte.TYPE
            r5 = 89
            if (r14 == r15) goto L_0x07bc
            java.lang.Class r15 = java.lang.Short.TYPE
            if (r14 == r15) goto L_0x07bc
            java.lang.Class r15 = java.lang.Integer.TYPE
            if (r14 != r15) goto L_0x0064
            goto L_0x07bc
        L_0x0064:
            java.lang.Class r15 = java.lang.Long.TYPE
            if (r14 != r15) goto L_0x0093
            int r14 = r3.g(r4)
            r1.f(r6, r14)
            r1.i(r5)
            r0.i(r1, r3, r13)
            java.lang.String r5 = f14228f
            java.lang.String r13 = "writeLong"
            java.lang.String r14 = "(J)V"
            r1.k(r8, r5, r13, r14)
            r13 = 16
            r1.f(r13, r12)
            r1.k(r8, r5, r9, r10)
        L_0x0086:
            r2 = r0
            r0 = r4
            r4 = r6
            r20 = r7
            r6 = r8
            r5 = r10
            r19 = r11
        L_0x008f:
            r8 = 16
            goto L_0x07e4
        L_0x0093:
            java.lang.Class r15 = java.lang.Float.TYPE
            if (r14 != r15) goto L_0x00ba
            int r14 = r3.g(r4)
            r1.f(r6, r14)
            r1.i(r5)
            r0.i(r1, r3, r13)
            r5 = 4
            r1.i(r5)
            java.lang.String r5 = f14228f
            java.lang.String r13 = "writeFloat"
            java.lang.String r14 = "(FZ)V"
            r1.k(r8, r5, r13, r14)
            r13 = 16
            r1.f(r13, r12)
            r1.k(r8, r5, r9, r10)
            goto L_0x0086
        L_0x00ba:
            java.lang.Class r15 = java.lang.Double.TYPE
            if (r14 != r15) goto L_0x00e1
            int r14 = r3.g(r4)
            r1.f(r6, r14)
            r1.i(r5)
            r0.i(r1, r3, r13)
            r5 = 4
            r1.i(r5)
            java.lang.String r5 = f14228f
            java.lang.String r13 = "writeDouble"
            java.lang.String r14 = "(DZ)V"
            r1.k(r8, r5, r13, r14)
            r13 = 16
            r1.f(r13, r12)
            r1.k(r8, r5, r9, r10)
            goto L_0x0086
        L_0x00e1:
            java.lang.Class r15 = java.lang.Boolean.TYPE
            if (r14 != r15) goto L_0x0102
            int r14 = r3.g(r4)
            r1.f(r6, r14)
            r1.i(r5)
            r0.i(r1, r3, r13)
            java.lang.String r5 = f14228f
            java.lang.String r13 = "(Z)V"
            r1.k(r8, r5, r9, r13)
            r13 = 16
            r1.f(r13, r12)
            r1.k(r8, r5, r9, r10)
            goto L_0x0086
        L_0x0102:
            java.lang.Class r15 = java.lang.Character.TYPE
            r5 = 184(0xb8, float:2.58E-43)
            if (r14 != r15) goto L_0x0135
            int r14 = r3.g(r4)
            r1.f(r6, r14)
            r0.i(r1, r3, r13)
            java.lang.String r13 = "java/lang/Character"
            java.lang.String r14 = "toString"
            java.lang.String r15 = "(C)Ljava/lang/String;"
            r1.k(r5, r13, r14, r15)
            r15 = 16
            r1.f(r15, r12)
            java.lang.String r5 = f14228f
            java.lang.String r12 = "writeString"
            java.lang.String r13 = "(Ljava/lang/String;C)V"
            r1.k(r8, r5, r12, r13)
            r2 = r0
            r0 = r4
            r4 = r6
            r20 = r7
            r6 = r8
            r5 = r10
            r19 = r11
            r8 = r15
            goto L_0x07e4
        L_0x0135:
            r15 = 16
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            if (r14 != r5) goto L_0x0153
            int r5 = r3.g(r4)
            r1.f(r6, r5)
            r0.i(r1, r3, r13)
            r1.f(r15, r12)
            java.lang.String r5 = f14228f
            java.lang.String r12 = "writeString"
            java.lang.String r13 = "(Ljava/lang/String;C)V"
            r1.k(r8, r5, r12, r13)
            goto L_0x0086
        L_0x0153:
            boolean r5 = r14.isEnum()
            if (r5 == 0) goto L_0x017b
            int r5 = r3.g(r4)
            r1.f(r6, r5)
            r5 = 89
            r1.i(r5)
            r0.i(r1, r3, r13)
            java.lang.String r5 = f14228f
            java.lang.String r13 = "writeEnum"
            java.lang.String r14 = "(Ljava/lang/Enum;)V"
            r1.k(r8, r5, r13, r14)
            r13 = 16
            r1.f(r13, r12)
            r1.k(r8, r5, r9, r10)
            goto L_0x0086
        L_0x017b:
            java.lang.Class<java.util.List> r5 = java.util.List.class
            boolean r5 = r5.isAssignableFrom(r14)
            java.lang.String r15 = "writeWithFieldName"
            java.lang.String r8 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            java.lang.String r6 = "(L"
            if (r5 == 0) goto L_0x0549
            java.lang.reflect.Type r5 = r13.f15967g
            boolean r14 = r5 instanceof java.lang.Class
            if (r14 == 0) goto L_0x0192
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            goto L_0x019b
        L_0x0192:
            java.lang.reflect.ParameterizedType r5 = (java.lang.reflect.ParameterizedType) r5
            java.lang.reflect.Type[] r5 = r5.getActualTypeArguments()
            r14 = 0
            r5 = r5[r14]
        L_0x019b:
            boolean r14 = r5 instanceof java.lang.Class
            if (r14 == 0) goto L_0x01a6
            r14 = r5
            java.lang.Class r14 = (java.lang.Class) r14
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            if (r14 != r2) goto L_0x01a7
        L_0x01a6:
            r14 = 0
        L_0x01a7:
            r0.i(r1, r3, r13)
            r2 = 192(0xc0, float:2.69E-43)
            r19 = r11
            java.lang.String r11 = "java/util/List"
            r1.c(r2, r11)
            java.lang.String r2 = "list"
            int r11 = r3.g(r2)
            r20 = r7
            r7 = 58
            r1.f(r7, r11)
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            if (r14 != r7) goto L_0x01ed
            boolean r7 = r36.f14242d
            if (r7 == 0) goto L_0x01ed
            int r5 = r3.g(r4)
            r6 = 25
            r1.f(r6, r5)
            int r2 = r3.g(r2)
            r1.f(r6, r2)
            java.lang.String r2 = f14228f
            java.lang.String r5 = "(Ljava/util/List;)V"
            r6 = 182(0xb6, float:2.55E-43)
            r1.k(r6, r2, r9, r5)
            r0 = r4
            r7 = r10
            r21 = r12
            r4 = 25
            r5 = 16
            goto L_0x0531
        L_0x01ed:
            com.alibaba.fastjson.asm.Label r7 = new com.alibaba.fastjson.asm.Label
            r7.<init>()
            com.alibaba.fastjson.asm.Label r11 = new com.alibaba.fastjson.asm.Label
            r11.<init>()
            r21 = r12
            int r12 = r3.g(r2)
            r22 = r15
            r15 = 25
            r1.f(r15, r12)
            r12 = 199(0xc7, float:2.79E-43)
            r1.e(r12, r11)
            int r12 = r3.g(r4)
            r1.f(r15, r12)
            java.lang.String r12 = f14228f
            java.lang.String r15 = "writeNull"
            r17 = r5
            java.lang.String r5 = "()V"
            r23 = r8
            r8 = 182(0xb6, float:2.55E-43)
            r1.k(r8, r12, r15, r5)
            r5 = 167(0xa7, float:2.34E-43)
            r1.e(r5, r7)
            r1.d(r11)
            int r5 = r3.g(r2)
            r8 = 25
            r1.f(r8, r5)
            java.lang.String r5 = "java/util/List"
            java.lang.String r11 = "size"
            java.lang.String r15 = "()I"
            r8 = 185(0xb9, float:2.59E-43)
            r1.k(r8, r5, r11, r15)
            r5 = 54
            java.lang.String r8 = "size"
            int r8 = r3.g(r8)
            r1.f(r5, r8)
            int r5 = r3.g(r4)
            r8 = 25
            r1.f(r8, r5)
            r5 = 91
            r8 = 16
            r1.f(r8, r5)
            r5 = 182(0xb6, float:2.55E-43)
            r1.k(r5, r12, r9, r10)
            com.alibaba.fastjson.asm.Label r5 = new com.alibaba.fastjson.asm.Label
            r5.<init>()
            com.alibaba.fastjson.asm.Label r8 = new com.alibaba.fastjson.asm.Label
            r8.<init>()
            com.alibaba.fastjson.asm.Label r11 = new com.alibaba.fastjson.asm.Label
            r11.<init>()
            r15 = 3
            r1.i(r15)
            r15 = 54
            r24 = r7
            java.lang.String r7 = "i"
            r25 = r6
            int r6 = r3.g(r7)
            r1.f(r15, r6)
            r1.d(r5)
            int r6 = r3.g(r7)
            r15 = 21
            r1.f(r15, r6)
            java.lang.String r6 = "size"
            int r6 = r3.g(r6)
            r1.f(r15, r6)
            r6 = 162(0xa2, float:2.27E-43)
            r1.e(r6, r11)
            int r6 = r3.g(r7)
            r1.f(r15, r6)
            r6 = 153(0x99, float:2.14E-43)
            r1.e(r6, r8)
            int r6 = r3.g(r4)
            r15 = 25
            r1.f(r15, r6)
            r6 = 44
            r15 = 16
            r1.f(r15, r6)
            r6 = 182(0xb6, float:2.55E-43)
            r1.k(r6, r12, r9, r10)
            r1.d(r8)
            int r2 = r3.g(r2)
            r6 = 25
            r1.f(r6, r2)
            int r2 = r3.g(r7)
            r6 = 21
            r1.f(r6, r2)
            java.lang.String r2 = "java/util/List"
            java.lang.String r6 = "get"
            java.lang.String r8 = "(I)Ljava/lang/Object;"
            r15 = 185(0xb9, float:2.59E-43)
            r1.k(r15, r2, r6, r8)
            java.lang.String r2 = "list_item"
            int r6 = r3.g(r2)
            r8 = 58
            r1.f(r8, r6)
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            com.alibaba.fastjson.asm.Label r8 = new com.alibaba.fastjson.asm.Label
            r8.<init>()
            int r15 = r3.g(r2)
            r26 = r10
            r10 = 25
            r1.f(r10, r15)
            r15 = 199(0xc7, float:2.79E-43)
            r1.e(r15, r8)
            int r15 = r3.g(r4)
            r1.f(r10, r15)
            java.lang.String r10 = "writeNull"
            java.lang.String r15 = "()V"
            r27 = r4
            r4 = 182(0xb6, float:2.55E-43)
            r1.k(r4, r12, r10, r15)
            r4 = 167(0xa7, float:2.34E-43)
            r1.e(r4, r6)
            r1.d(r8)
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            com.alibaba.fastjson.asm.Label r8 = new com.alibaba.fastjson.asm.Label
            r8.<init>()
            if (r14 == 0) goto L_0x0482
            int r10 = r14.getModifiers()
            boolean r10 = java.lang.reflect.Modifier.isPublic(r10)
            if (r10 == 0) goto L_0x0482
            int r10 = r3.g(r2)
            r15 = 25
            r1.f(r15, r10)
            java.lang.String r10 = "java/lang/Object"
            java.lang.String r15 = "getClass"
            r28 = r12
            java.lang.String r12 = "()Ljava/lang/Class;"
            r29 = r11
            r11 = 182(0xb6, float:2.55E-43)
            r1.k(r11, r10, r15, r12)
            java.lang.String r10 = com.alibaba.fastjson.util.ASMUtils.b(r14)
            e2.e r10 = e2.e.d(r10)
            r1.b(r10)
            r10 = 166(0xa6, float:2.33E-43)
            r1.e(r10, r8)
            r0.k(r3, r1, r13, r14)
            java.lang.String r10 = "list_item_desc"
            int r11 = r3.g(r10)
            r12 = 58
            r1.f(r12, r11)
            com.alibaba.fastjson.asm.Label r11 = new com.alibaba.fastjson.asm.Label
            r11.<init>()
            com.alibaba.fastjson.asm.Label r12 = new com.alibaba.fastjson.asm.Label
            r12.<init>()
            boolean r15 = r36.f14242d
            if (r15 == 0) goto L_0x0408
            int r15 = r3.g(r10)
            r0 = 25
            r1.f(r0, r15)
            r15 = 193(0xc1, float:2.7E-43)
            java.lang.String r0 = f14230h
            r1.c(r15, r0)
            r15 = 153(0x99, float:2.14E-43)
            r1.e(r15, r11)
            int r15 = r3.g(r10)
            r16 = r5
            r5 = 25
            r1.f(r5, r15)
            r15 = 192(0xc0, float:2.69E-43)
            r1.c(r15, r0)
            r15 = 1
            r1.f(r5, r15)
            int r15 = r3.g(r2)
            r1.f(r5, r15)
            boolean r5 = r36.f14245g
            if (r5 == 0) goto L_0x03b2
            r5 = 1
            r1.i(r5)
            r30 = r6
            r31 = r8
            goto L_0x03ca
        L_0x03b2:
            int r5 = r3.g(r7)
            r15 = 21
            r1.f(r15, r5)
            java.lang.String r5 = "java/lang/Integer"
            java.lang.String r15 = "valueOf"
            r30 = r6
            java.lang.String r6 = "(I)Ljava/lang/Integer;"
            r31 = r8
            r8 = 184(0xb8, float:2.58E-43)
            r1.k(r8, r5, r15, r6)
        L_0x03ca:
            java.lang.String r5 = com.alibaba.fastjson.util.ASMUtils.b(r14)
            e2.e r5 = e2.e.d(r5)
            r1.b(r5)
            int r5 = r13.f15970j
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.b(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = r25
            r5.append(r6)
            java.lang.String r8 = f14225c
            r5.append(r8)
            r8 = r23
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r15 = "writeAsArrayNonContext"
            r23 = r4
            r4 = 182(0xb6, float:2.55E-43)
            r1.k(r4, r0, r15, r5)
            r0 = 167(0xa7, float:2.34E-43)
            r1.e(r0, r12)
            r1.d(r11)
            goto L_0x0414
        L_0x0408:
            r16 = r5
            r30 = r6
            r31 = r8
            r8 = r23
            r6 = r25
            r23 = r4
        L_0x0414:
            int r0 = r3.g(r10)
            r4 = 25
            r1.f(r4, r0)
            r0 = 1
            r1.f(r4, r0)
            int r5 = r3.g(r2)
            r1.f(r4, r5)
            boolean r4 = r36.f14245g
            if (r4 == 0) goto L_0x0432
            r1.i(r0)
            goto L_0x0446
        L_0x0432:
            int r0 = r3.g(r7)
            r4 = 21
            r1.f(r4, r0)
            java.lang.String r0 = "java/lang/Integer"
            java.lang.String r4 = "valueOf"
            java.lang.String r5 = "(I)Ljava/lang/Integer;"
            r10 = 184(0xb8, float:2.58E-43)
            r1.k(r10, r0, r4, r5)
        L_0x0446:
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.b(r14)
            e2.e r0 = e2.e.d(r0)
            r1.b(r0)
            int r0 = r13.f15970j
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.b(r0)
            java.lang.String r0 = f14226d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            java.lang.String r5 = f14225c
            r4.append(r5)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            r5 = 185(0xb9, float:2.59E-43)
            r1.k(r5, r0, r9, r4)
            r1.d(r12)
            r0 = r23
            r4 = 167(0xa7, float:2.34E-43)
            r1.e(r4, r0)
            r4 = r31
            goto L_0x048c
        L_0x0482:
            r0 = r4
            r16 = r5
            r30 = r6
            r29 = r11
            r28 = r12
            r4 = r8
        L_0x048c:
            r1.d(r4)
            r4 = 1
            r5 = 25
            r1.f(r5, r4)
            int r2 = r3.g(r2)
            r1.f(r5, r2)
            boolean r2 = r36.f14245g
            if (r2 == 0) goto L_0x04a6
            r1.i(r4)
            goto L_0x04ba
        L_0x04a6:
            int r2 = r3.g(r7)
            r4 = 21
            r1.f(r4, r2)
            java.lang.String r2 = "java/lang/Integer"
            java.lang.String r4 = "valueOf"
            java.lang.String r5 = "(I)Ljava/lang/Integer;"
            r6 = 184(0xb8, float:2.58E-43)
            r1.k(r6, r2, r4, r5)
        L_0x04ba:
            if (r14 == 0) goto L_0x04ea
            int r2 = r14.getModifiers()
            boolean r2 = java.lang.reflect.Modifier.isPublic(r2)
            if (r2 == 0) goto L_0x04ea
            r5 = r17
            java.lang.Class r5 = (java.lang.Class) r5
            java.lang.String r2 = com.alibaba.fastjson.util.ASMUtils.b(r5)
            e2.e r2 = e2.e.d(r2)
            r1.b(r2)
            int r2 = r13.f15970j
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.b(r2)
            java.lang.String r2 = f14225c
            java.lang.String r4 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            r5 = r22
            r6 = 182(0xb6, float:2.55E-43)
            r1.k(r6, r2, r5, r4)
            goto L_0x04f5
        L_0x04ea:
            r5 = r22
            r6 = 182(0xb6, float:2.55E-43)
            java.lang.String r2 = f14225c
            java.lang.String r4 = "(Ljava/lang/Object;Ljava/lang/Object;)V"
            r1.k(r6, r2, r5, r4)
        L_0x04f5:
            r1.d(r0)
            r0 = r30
            r1.d(r0)
            int r0 = r3.g(r7)
            r2 = 1
            r1.g(r0, r2)
            r0 = r16
            r2 = 167(0xa7, float:2.34E-43)
            r1.e(r2, r0)
            r0 = r29
            r1.d(r0)
            r0 = r27
            int r2 = r3.g(r0)
            r4 = 25
            r1.f(r4, r2)
            r2 = 93
            r5 = 16
            r1.f(r5, r2)
            r7 = r26
            r2 = r28
            r6 = 182(0xb6, float:2.55E-43)
            r1.k(r6, r2, r9, r7)
            r2 = r24
            r1.d(r2)
        L_0x0531:
            int r2 = r3.g(r0)
            r1.f(r4, r2)
            r12 = r21
            r1.f(r5, r12)
            java.lang.String r2 = f14228f
            r1.k(r6, r2, r9, r7)
            r2 = r32
            r5 = r7
            r4 = 25
            goto L_0x008f
        L_0x0549:
            r0 = r4
            r20 = r7
            r7 = r10
            r19 = r11
            r5 = r15
            com.alibaba.fastjson.asm.Label r2 = new com.alibaba.fastjson.asm.Label
            r2.<init>()
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            r10 = r32
            r10.i(r1, r3, r13)
            r11 = 89
            r1.i(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r15 = "field_"
            r11.append(r15)
            r26 = r7
            java.lang.Class<?> r7 = r13.f15966f
            java.lang.String r7 = r7.getName()
            r11.append(r7)
            java.lang.String r7 = r11.toString()
            int r7 = r3.g(r7)
            r11 = 58
            r1.f(r11, r7)
            r7 = 199(0xc7, float:2.79E-43)
            r1.e(r7, r4)
            int r7 = r3.g(r0)
            r11 = 25
            r1.f(r11, r7)
            java.lang.String r7 = f14228f
            java.lang.String r11 = "writeNull"
            r21 = r12
            java.lang.String r12 = "()V"
            r27 = r0
            r0 = 182(0xb6, float:2.55E-43)
            r1.k(r0, r7, r11, r12)
            r0 = 167(0xa7, float:2.34E-43)
            r1.e(r0, r2)
            r1.d(r4)
            com.alibaba.fastjson.asm.Label r0 = new com.alibaba.fastjson.asm.Label
            r0.<init>()
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r15)
            java.lang.Class<?> r12 = r13.f15966f
            java.lang.String r12 = r12.getName()
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            int r11 = r3.g(r11)
            r12 = 25
            r1.f(r12, r11)
            java.lang.String r11 = "java/lang/Object"
            java.lang.String r12 = "getClass"
            r17 = r7
            java.lang.String r7 = "()Ljava/lang/Class;"
            r18 = r2
            r2 = 182(0xb6, float:2.55E-43)
            r1.k(r2, r11, r12, r7)
            java.lang.String r2 = com.alibaba.fastjson.util.ASMUtils.b(r14)
            e2.e r2 = e2.e.d(r2)
            r1.b(r2)
            r2 = 166(0xa6, float:2.33E-43)
            r1.e(r2, r4)
            r10.j(r3, r1, r13)
            java.lang.String r2 = "fied_ser"
            int r7 = r3.g(r2)
            r11 = 58
            r1.f(r11, r7)
            com.alibaba.fastjson.asm.Label r7 = new com.alibaba.fastjson.asm.Label
            r7.<init>()
            com.alibaba.fastjson.asm.Label r11 = new com.alibaba.fastjson.asm.Label
            r11.<init>()
            boolean r12 = r36.f14242d
            if (r12 == 0) goto L_0x06a0
            int r12 = r14.getModifiers()
            boolean r12 = java.lang.reflect.Modifier.isPublic(r12)
            if (r12 == 0) goto L_0x06a0
            int r12 = r3.g(r2)
            r10 = 25
            r1.f(r10, r12)
            r12 = 193(0xc1, float:2.7E-43)
            java.lang.String r10 = f14230h
            r1.c(r12, r10)
            r12 = 153(0x99, float:2.14E-43)
            r1.e(r12, r7)
            int r12 = r3.g(r2)
            r22 = r5
            r5 = 25
            r1.f(r5, r12)
            r12 = 192(0xc0, float:2.69E-43)
            r1.c(r12, r10)
            r12 = 1
            r1.f(r5, r12)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r15)
            java.lang.Class<?> r5 = r13.f15966f
            java.lang.String r5 = r5.getName()
            r12.append(r5)
            java.lang.String r5 = r12.toString()
            int r5 = r3.g(r5)
            r12 = 25
            r1.f(r12, r5)
            int r5 = com.alibaba.fastjson.serializer.ASMSerializerFactory.a.f14236h
            r1.f(r12, r5)
            java.lang.String r5 = com.alibaba.fastjson.util.ASMUtils.b(r14)
            e2.e r5 = e2.e.d(r5)
            r1.b(r5)
            int r5 = r13.f15970j
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.b(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r6)
            java.lang.String r12 = f14225c
            r5.append(r12)
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r12 = "writeAsArrayNonContext"
            r16 = r4
            r4 = 182(0xb6, float:2.55E-43)
            r1.k(r4, r10, r12, r5)
            r4 = 167(0xa7, float:2.34E-43)
            r1.e(r4, r11)
            r1.d(r7)
            goto L_0x06a4
        L_0x06a0:
            r16 = r4
            r22 = r5
        L_0x06a4:
            int r2 = r3.g(r2)
            r4 = 25
            r1.f(r4, r2)
            r2 = 1
            r1.f(r4, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r15)
            java.lang.Class<?> r5 = r13.f15966f
            java.lang.String r5 = r5.getName()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            int r2 = r3.g(r2)
            r1.f(r4, r2)
            int r2 = com.alibaba.fastjson.serializer.ASMSerializerFactory.a.f14236h
            r1.f(r4, r2)
            java.lang.String r2 = com.alibaba.fastjson.util.ASMUtils.b(r14)
            e2.e r2 = e2.e.d(r2)
            r1.b(r2)
            int r2 = r13.f15970j
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.b(r2)
            java.lang.String r2 = f14226d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            java.lang.String r5 = f14225c
            r4.append(r5)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            r6 = 185(0xb9, float:2.59E-43)
            r1.k(r6, r2, r9, r4)
            r1.d(r11)
            r2 = 167(0xa7, float:2.34E-43)
            r1.e(r2, r0)
            r2 = r16
            r1.d(r2)
            java.lang.String r2 = r13.i()
            r4 = 1
            r6 = 25
            r1.f(r6, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r15)
            java.lang.Class<?> r7 = r13.f15966f
            java.lang.String r7 = r7.getName()
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            int r4 = r3.g(r4)
            r1.f(r6, r4)
            if (r2 == 0) goto L_0x0744
            r1.b(r2)
            java.lang.String r2 = "writeWithFormat"
            java.lang.String r4 = "(Ljava/lang/Object;Ljava/lang/String;)V"
            r7 = 182(0xb6, float:2.55E-43)
            r1.k(r7, r5, r2, r4)
        L_0x0742:
            r6 = r7
            goto L_0x0797
        L_0x0744:
            r7 = 182(0xb6, float:2.55E-43)
            int r2 = com.alibaba.fastjson.serializer.ASMSerializerFactory.a.f14236h
            r1.f(r6, r2)
            java.lang.reflect.Type r2 = r13.f15967g
            boolean r4 = r2 instanceof java.lang.Class
            if (r4 == 0) goto L_0x0761
            java.lang.Class r2 = (java.lang.Class) r2
            boolean r2 = r2.isPrimitive()
            if (r2 == 0) goto L_0x0761
            java.lang.String r2 = "(Ljava/lang/Object;Ljava/lang/Object;)V"
            r4 = r22
            r1.k(r7, r5, r4, r2)
            goto L_0x0742
        L_0x0761:
            r4 = r22
            r2 = 0
            r6 = 25
            r1.f(r6, r2)
            r2 = 180(0xb4, float:2.52E-43)
            java.lang.String r6 = r36.f14240b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r13.f15962b
            r7.append(r8)
            java.lang.String r8 = "_asm_fieldType"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "Ljava/lang/reflect/Type;"
            r1.a(r2, r6, r7, r8)
            int r2 = r13.f15970j
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.b(r2)
            java.lang.String r2 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            r6 = 182(0xb6, float:2.55E-43)
            r1.k(r6, r5, r4, r2)
        L_0x0797:
            r1.d(r0)
            r0 = r18
            r1.d(r0)
            r0 = r27
            int r2 = r3.g(r0)
            r4 = 25
            r1.f(r4, r2)
            r12 = r21
            r2 = 16
            r1.f(r2, r12)
            r2 = r17
            r5 = r26
            r1.k(r6, r2, r9, r5)
            r2 = r32
            goto L_0x008f
        L_0x07bc:
            r0 = r4
            r4 = r6
            r20 = r7
            r6 = r8
            r5 = r10
            r19 = r11
            int r2 = r3.g(r0)
            r1.f(r4, r2)
            r2 = 89
            r1.i(r2)
            r2 = r32
            r2.i(r1, r3, r13)
            java.lang.String r7 = f14228f
            java.lang.String r8 = "writeInt"
            r1.k(r6, r7, r8, r5)
            r8 = 16
            r1.f(r8, r12)
            r1.k(r6, r7, r9, r5)
        L_0x07e4:
            int r7 = r20 + 1
            r10 = r5
            r5 = r8
            r11 = r19
            r8 = r6
            r6 = r4
            r4 = r0
            r0 = r2
            r2 = r35
            goto L_0x0039
        L_0x07f2:
            r2 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ASMSerializerFactory.A(java.lang.Class, e2.c, i2.a[], com.alibaba.fastjson.serializer.ASMSerializerFactory$a):void");
    }

    public final void B(Class<?> cls, c cVar, i2.a[] aVarArr, a aVar) throws Exception {
        Label label;
        String str;
        char c11;
        int i11;
        String str2;
        Class<?> cls2;
        Class<?> cls3 = cls;
        c cVar2 = cVar;
        i2.a[] aVarArr2 = aVarArr;
        a aVar2 = aVar;
        Label label2 = new Label();
        int length = aVarArr2.length;
        String str3 = "out";
        if (!aVar.f14242d) {
            Label label3 = new Label();
            Label label4 = new Label();
            label = label2;
            cVar2.f(25, aVar2.g(str3));
            cVar2.b(Integer.valueOf(SerializerFeature.PrettyFormat.mask));
            cVar2.k(182, f14228f, "isEnabled", "(I)Z");
            cVar2.e(154, label4);
            int length2 = aVarArr2.length;
            int i12 = 0;
            boolean z11 = false;
            while (i12 < length2) {
                int i13 = length2;
                if (aVarArr2[i12].f15963c != null) {
                    z11 = true;
                }
                i12++;
                length2 = i13;
            }
            if (z11) {
                cVar2.f(25, aVar2.g(str3));
                cVar2.b(Integer.valueOf(SerializerFeature.IgnoreErrorGetter.mask));
                cVar2.k(182, f14228f, "isEnabled", "(I)Z");
                cVar2.e(153, label3);
            } else {
                cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label3);
            }
            cVar2.d(label4);
            cVar2.f(25, 0);
            cVar2.f(25, 1);
            cVar2.f(25, 2);
            cVar2.f(25, 3);
            cVar2.f(25, 4);
            cVar2.f(21, 5);
            String str4 = f14230h;
            cVar2.k(183, str4, "write", "(L" + f14225c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            cVar2.i(177);
            cVar2.d(label3);
        } else {
            label = label2;
        }
        if (!aVar.f14245g) {
            Label label5 = new Label();
            cVar2.f(25, 0);
            cVar2.f(25, 1);
            cVar2.f(25, 2);
            cVar2.f(21, 5);
            String str5 = f14230h;
            cVar2.k(182, str5, "writeReference", "(L" + f14225c + ";Ljava/lang/Object;I)Z");
            cVar2.e(153, label5);
            cVar2.i(177);
            cVar2.d(label5);
        }
        String str6 = aVar.f14242d ? aVar.f14245g ? "writeAsArrayNonContext" : "writeAsArray" : "writeAsArrayNormal";
        int i14 = aVar.f14241c.f15933g;
        SerializerFeature serializerFeature = SerializerFeature.BeanToArray;
        if ((i14 & serializerFeature.mask) == 0) {
            Label label6 = new Label();
            cVar2.f(25, aVar2.g(str3));
            cVar2.b(Integer.valueOf(serializerFeature.mask));
            cVar2.k(182, f14228f, "isEnabled", "(I)Z");
            cVar2.e(153, label6);
            cVar2.f(25, 0);
            cVar2.f(25, 1);
            cVar2.f(25, 2);
            cVar2.f(25, 3);
            cVar2.f(25, 4);
            cVar2.f(21, 5);
            String d11 = aVar.f14240b;
            cVar2.k(182, d11, str6, "(L" + f14225c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            cVar2.i(177);
            cVar2.d(label6);
        } else {
            cVar2.f(25, 0);
            cVar2.f(25, 1);
            cVar2.f(25, 2);
            cVar2.f(25, 3);
            cVar2.f(25, 4);
            cVar2.f(21, 5);
            String d12 = aVar.f14240b;
            cVar2.k(182, d12, str6, "(L" + f14225c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            cVar2.i(177);
        }
        if (!aVar.f14245g) {
            cVar2.f(25, 1);
            String str7 = f14225c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("()");
            String str8 = f14232j;
            sb2.append(str8);
            cVar2.k(182, str7, "getContext", sb2.toString());
            cVar2.f(58, aVar2.g("parent"));
            cVar2.f(25, 1);
            cVar2.f(25, aVar2.g("parent"));
            cVar2.f(25, 2);
            cVar2.f(25, 3);
            cVar2.b(Integer.valueOf(aVar.f14241c.f15933g));
            cVar2.k(182, str7, "setContext", "(" + str8 + "Ljava/lang/Object;Ljava/lang/Object;I)V");
        }
        if (!aVar.f14242d) {
            Label label7 = new Label();
            Label label8 = new Label();
            Label label9 = new Label();
            cVar2.f(25, 1);
            cVar2.f(25, 4);
            cVar2.f(25, 2);
            String str9 = f14225c;
            str = "parent";
            cVar2.k(182, str9, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            cVar2.e(153, label8);
            cVar2.f(25, 4);
            cVar2.f(25, 2);
            cVar2.k(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            cVar2.e(165, label8);
            cVar2.d(label9);
            cVar2.f(25, aVar2.g(str3));
            cVar2.f(16, 123);
            cVar2.k(182, f14228f, "write", "(I)V");
            cVar2.f(25, 0);
            cVar2.f(25, 1);
            if (aVar.f14241c.f15929c != null) {
                cVar2.b(aVar.f14241c.f15929c);
            } else {
                cVar2.i(1);
            }
            cVar2.f(25, 2);
            String str10 = f14230h;
            cVar2.k(182, str10, "writeClassName", "(L" + str9 + ";Ljava/lang/String;Ljava/lang/Object;)V");
            c11 = 16;
            cVar2.f(16, 44);
            cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label7);
            cVar2.d(label8);
            cVar2.f(16, 123);
            cVar2.d(label7);
        } else {
            str = "parent";
            c11 = 16;
            cVar2.f(16, 123);
        }
        cVar2.f(54, aVar2.g("seperator"));
        if (!aVar.f14242d) {
            c(cVar2, aVar2);
        }
        if (!aVar.f14242d) {
            cVar2.f(25, aVar2.g(str3));
            cVar2.k(182, f14228f, "isNotWriteDefaultValue", "()Z");
            cVar2.f(54, aVar2.g("notWriteDefaultValue"));
            cVar2.f(25, 1);
            cVar2.f(25, 0);
            String str11 = f14225c;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(");
            String str12 = f14233k;
            sb3.append(str12);
            sb3.append(")Z");
            cVar2.k(182, str11, "checkValue", sb3.toString());
            cVar2.f(54, aVar2.g("checkValue"));
            cVar2.f(25, 1);
            i11 = 0;
            cVar2.f(25, 0);
            cVar2.k(182, str11, "hasNameFilters", "(" + str12 + ")Z");
            cVar2.f(54, aVar2.g("hasNameFilters"));
        } else {
            i11 = 0;
        }
        int i15 = i11;
        while (i15 < length) {
            i2.a aVar3 = aVarArr[i15];
            Class<?> cls4 = aVar3.f15966f;
            cVar2.b(aVar3.f15962b);
            cVar2.f(58, a.f14236h);
            if (cls4 == Byte.TYPE || cls4 == Short.TYPE || cls4 == Integer.TYPE) {
                Class<?> cls5 = cls;
                str2 = str3;
                m(cls, cVar, aVar3, aVar, aVar2.g(cls4.getName()), 'I');
            } else {
                if (cls4 == Long.TYPE) {
                    cls2 = cls;
                    p(cls2, cVar2, aVar3, aVar2);
                } else {
                    cls2 = cls;
                    if (cls4 == Float.TYPE) {
                        h(cls2, cVar2, aVar3, aVar2);
                    } else if (cls4 == Double.TYPE) {
                        e(cls2, cVar2, aVar3, aVar2);
                    } else if (cls4 == Boolean.TYPE) {
                        Class<?> cls6 = cls2;
                        char c12 = c11;
                        str2 = str3;
                        m(cls, cVar, aVar3, aVar, aVar2.g("boolean"), Matrix.MATRIX_TYPE_ZERO);
                    } else {
                        Class<?> cls7 = cls2;
                        str2 = str3;
                        if (cls4 == Character.TYPE) {
                            m(cls, cVar, aVar3, aVar, aVar2.g("char"), 'C');
                        } else if (cls4 == String.class) {
                            w(cls7, cVar2, aVar3, aVar2);
                        } else if (cls4 == BigDecimal.class) {
                            d(cls7, cVar2, aVar3, aVar2);
                        } else if (List.class.isAssignableFrom(cls4)) {
                            o(cls7, cVar2, aVar3, aVar2);
                        } else if (cls4.isEnum()) {
                            f(cls7, cVar2, aVar3, aVar2);
                        } else {
                            s(cls7, cVar2, aVar3, aVar2);
                        }
                    }
                }
                Class<?> cls8 = cls2;
                str2 = str3;
            }
            i15++;
            str3 = str2;
            c11 = 16;
        }
        String str13 = str3;
        if (!aVar.f14242d) {
            a(cVar2, aVar2);
        }
        Label label10 = new Label();
        Label label11 = new Label();
        cVar2.f(21, aVar2.g("seperator"));
        cVar2.h(16, 123);
        cVar2.e(160, label10);
        String str14 = str13;
        cVar2.f(25, aVar2.g(str14));
        cVar2.f(16, 123);
        String str15 = f14228f;
        cVar2.k(182, str15, "write", "(I)V");
        cVar2.d(label10);
        cVar2.f(25, aVar2.g(str14));
        cVar2.f(16, 125);
        cVar2.k(182, str15, "write", "(I)V");
        cVar2.d(label11);
        cVar2.d(label);
        if (!aVar.f14245g) {
            cVar2.f(25, 1);
            cVar2.f(25, aVar2.g(str));
            String str16 = f14225c;
            cVar2.k(182, str16, "setContext", "(" + f14232j + ")V");
        }
    }

    public final void a(c cVar, a aVar) {
        cVar.f(25, 0);
        cVar.f(25, 1);
        cVar.f(25, 2);
        cVar.f(21, aVar.g("seperator"));
        String str = f14230h;
        cVar.k(182, str, "writeAfter", "(L" + f14225c + ";Ljava/lang/Object;C)C");
        cVar.f(54, aVar.g("seperator"));
    }

    public final void b(c cVar, i2.a aVar, a aVar2) {
        Class<?> cls = aVar.f15966f;
        cVar.f(25, 0);
        cVar.f(25, 1);
        cVar.f(25, 2);
        cVar.f(25, a.f14236h);
        if (cls == Byte.TYPE) {
            cVar.f(21, aVar2.g("byte"));
            cVar.k(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            cVar.f(21, aVar2.g("short"));
            cVar.k(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            cVar.f(21, aVar2.g("int"));
            cVar.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            cVar.f(21, aVar2.g("char"));
            cVar.k(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            cVar.f(22, aVar2.h("long", 2));
            cVar.k(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            cVar.f(23, aVar2.g("float"));
            cVar.k(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            cVar.f(24, aVar2.h("double", 2));
            cVar.k(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            cVar.f(21, aVar2.g("boolean"));
            cVar.k(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            cVar.f(25, aVar2.g("decimal"));
        } else if (cls == String.class) {
            cVar.f(25, aVar2.g("string"));
        } else if (cls.isEnum()) {
            cVar.f(25, aVar2.g("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            cVar.f(25, aVar2.g("list"));
        } else {
            cVar.f(25, aVar2.g("object"));
        }
        String str = f14230h;
        cVar.k(182, str, TUIChatConstants.Group.MEMBER_APPLY, "(L" + f14225c + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
    }

    public final void c(c cVar, a aVar) {
        cVar.f(25, 0);
        cVar.f(25, 1);
        cVar.f(25, 2);
        cVar.f(21, aVar.g("seperator"));
        String str = f14230h;
        cVar.k(182, str, "writeBefore", "(L" + f14225c + ";Ljava/lang/Object;C)C");
        cVar.f(54, aVar.g("seperator"));
    }

    public final void d(Class<?> cls, c cVar, i2.a aVar, a aVar2) {
        Label label = new Label();
        q(cVar, aVar, aVar2, label);
        i(cVar, aVar2, aVar);
        cVar.f(58, aVar2.g("decimal"));
        g(cVar, aVar, aVar2, label);
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        cVar.d(label2);
        cVar.f(25, aVar2.g("decimal"));
        cVar.e(199, label3);
        l(cVar, aVar, aVar2);
        cVar.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label4);
        cVar.d(label3);
        cVar.f(25, aVar2.g("out"));
        cVar.f(21, aVar2.g("seperator"));
        cVar.f(25, a.f14236h);
        cVar.f(25, aVar2.g("decimal"));
        cVar.k(182, f14228f, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
        v(cVar, aVar2);
        cVar.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label4);
        cVar.d(label4);
        cVar.d(label);
    }

    public final void e(Class<?> cls, c cVar, i2.a aVar, a aVar2) {
        Label label = new Label();
        q(cVar, aVar, aVar2, label);
        i(cVar, aVar2, aVar);
        cVar.f(57, aVar2.h("double", 2));
        g(cVar, aVar, aVar2, label);
        cVar.f(25, aVar2.g("out"));
        cVar.f(21, aVar2.g("seperator"));
        cVar.f(25, a.f14236h);
        cVar.f(24, aVar2.h("double", 2));
        cVar.k(182, f14228f, "writeFieldValue", "(CLjava/lang/String;D)V");
        v(cVar, aVar2);
        cVar.d(label);
    }

    public final void f(Class<?> cls, c cVar, i2.a aVar, a aVar2) {
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        q(cVar, aVar, aVar2, label3);
        i(cVar, aVar2, aVar);
        cVar.c(192, "java/lang/Enum");
        cVar.f(58, aVar2.g("enum"));
        g(cVar, aVar, aVar2, label3);
        cVar.f(25, aVar2.g("enum"));
        cVar.e(199, label);
        l(cVar, aVar, aVar2);
        cVar.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label2);
        cVar.d(label);
        if (aVar2.f14242d) {
            cVar.f(25, aVar2.g("out"));
            cVar.f(21, aVar2.g("seperator"));
            cVar.f(25, a.f14236h);
            cVar.f(25, aVar2.g("enum"));
            cVar.k(182, "java/lang/Enum", "name", "()Ljava/lang/String;");
            cVar.k(182, f14228f, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            cVar.f(25, aVar2.g("out"));
            cVar.f(21, aVar2.g("seperator"));
            String str = f14228f;
            cVar.k(182, str, "write", "(I)V");
            cVar.f(25, aVar2.g("out"));
            cVar.f(25, a.f14236h);
            cVar.i(3);
            cVar.k(182, str, "writeFieldName", "(Ljava/lang/String;Z)V");
            cVar.f(25, 1);
            cVar.f(25, aVar2.g("enum"));
            cVar.f(25, a.f14236h);
            cVar.b(e.d(ASMUtils.b(aVar.f15966f)));
            cVar.b(Integer.valueOf(aVar.f15970j));
            cVar.k(182, f14225c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        }
        v(cVar, aVar2);
        cVar.d(label2);
        cVar.d(label3);
    }

    public final void g(c cVar, i2.a aVar, a aVar2, Label label) {
        if (aVar.f15976p) {
            cVar.f(25, aVar2.g("out"));
            cVar.b(Integer.valueOf(SerializerFeature.SkipTransientField.mask));
            cVar.k(182, f14228f, "isEnabled", "(I)Z");
            cVar.e(154, label);
        }
        r(cVar, aVar, aVar2, label);
        if (!aVar2.f14242d) {
            b(cVar, aVar, aVar2);
            cVar.e(153, label);
            t(cVar, aVar, aVar2);
            u(cVar, aVar, aVar2, label);
        }
    }

    public final void h(Class<?> cls, c cVar, i2.a aVar, a aVar2) {
        Label label = new Label();
        q(cVar, aVar, aVar2, label);
        i(cVar, aVar2, aVar);
        cVar.f(56, aVar2.g("float"));
        g(cVar, aVar, aVar2, label);
        cVar.f(25, aVar2.g("out"));
        cVar.f(21, aVar2.g("seperator"));
        cVar.f(25, a.f14236h);
        cVar.f(23, aVar2.g("float"));
        cVar.k(182, f14228f, "writeFieldValue", "(CLjava/lang/String;F)V");
        v(cVar, aVar2);
        cVar.d(label);
    }

    public final void i(c cVar, a aVar, i2.a aVar2) {
        Method method = aVar2.f15963c;
        if (method != null) {
            cVar.f(25, aVar.g("entity"));
            Class<?> declaringClass = method.getDeclaringClass();
            cVar.k(declaringClass.isInterface() ? 185 : 182, ASMUtils.f(declaringClass), method.getName(), ASMUtils.c(method));
            if (!method.getReturnType().equals(aVar2.f15966f)) {
                cVar.c(192, ASMUtils.f(aVar2.f15966f));
                return;
            }
            return;
        }
        cVar.f(25, aVar.g("entity"));
        Field field = aVar2.f15964d;
        cVar.a(180, ASMUtils.f(aVar2.f15968h), field.getName(), ASMUtils.b(field.getType()));
        if (!field.getType().equals(aVar2.f15966f)) {
            cVar.c(192, ASMUtils.f(aVar2.f15966f));
        }
    }

    public final void j(a aVar, c cVar, i2.a aVar2) {
        Label label = new Label();
        cVar.f(25, 0);
        String str = f14227e;
        cVar.a(180, aVar.f14240b, aVar2.f15962b + "_asm_ser_", str);
        cVar.e(199, label);
        cVar.f(25, 0);
        cVar.f(25, 1);
        cVar.b(e.d(ASMUtils.b(aVar2.f15966f)));
        cVar.k(182, f14225c, "getObjectWriter", "(Ljava/lang/Class;)" + str);
        cVar.a(181, aVar.f14240b, aVar2.f15962b + "_asm_ser_", str);
        cVar.d(label);
        cVar.f(25, 0);
        cVar.a(180, aVar.f14240b, aVar2.f15962b + "_asm_ser_", str);
    }

    public final void k(a aVar, c cVar, i2.a aVar2, Class<?> cls) {
        Label label = new Label();
        cVar.f(25, 0);
        String str = f14227e;
        cVar.a(180, aVar.f14240b, aVar2.f15962b + "_asm_list_item_ser_", str);
        cVar.e(199, label);
        cVar.f(25, 0);
        cVar.f(25, 1);
        cVar.b(e.d(ASMUtils.b(cls)));
        cVar.k(182, f14225c, "getObjectWriter", "(Ljava/lang/Class;)" + str);
        cVar.a(181, aVar.f14240b, aVar2.f15962b + "_asm_list_item_ser_", str);
        cVar.d(label);
        cVar.f(25, 0);
        cVar.a(180, aVar.f14240b, aVar2.f15962b + "_asm_list_item_ser_", str);
    }

    public final void l(c cVar, i2.a aVar, a aVar2) {
        Class<?> cls = aVar.f15966f;
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        cVar.d(label);
        b e11 = aVar.e();
        int of2 = e11 != null ? SerializerFeature.of(e11.serialzeFeatures()) : 0;
        int i11 = SerializerFeature.WRITE_MAP_NULL_FEATURES;
        if ((of2 & i11) == 0) {
            cVar.f(25, aVar2.g("out"));
            cVar.b(Integer.valueOf(i11));
            cVar.k(182, f14228f, "isEnabled", "(I)Z");
            cVar.e(153, label2);
        }
        cVar.d(label3);
        cVar.f(25, aVar2.g("out"));
        cVar.f(21, aVar2.g("seperator"));
        String str = f14228f;
        cVar.k(182, str, "write", "(I)V");
        x(cVar, aVar2);
        cVar.f(25, aVar2.g("out"));
        cVar.b(Integer.valueOf(of2));
        if (cls == String.class || cls == Character.class) {
            cVar.b(Integer.valueOf(SerializerFeature.WriteNullStringAsEmpty.mask));
        } else if (Number.class.isAssignableFrom(cls)) {
            cVar.b(Integer.valueOf(SerializerFeature.WriteNullNumberAsZero.mask));
        } else if (cls == Boolean.class) {
            cVar.b(Integer.valueOf(SerializerFeature.WriteNullBooleanAsFalse.mask));
        } else if (Collection.class.isAssignableFrom(cls) || cls.isArray()) {
            cVar.b(Integer.valueOf(SerializerFeature.WriteNullListAsEmpty.mask));
        } else {
            cVar.b(0);
        }
        cVar.k(182, str, "writeNull", "(II)V");
        v(cVar, aVar2);
        cVar.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label4);
        cVar.d(label2);
        cVar.d(label4);
    }

    public final void m(Class<?> cls, c cVar, i2.a aVar, a aVar2, int i11, char c11) {
        Label label = new Label();
        q(cVar, aVar, aVar2, label);
        i(cVar, aVar2, aVar);
        cVar.f(54, i11);
        g(cVar, aVar, aVar2, label);
        cVar.f(25, aVar2.g("out"));
        cVar.f(21, aVar2.g("seperator"));
        cVar.f(25, a.f14236h);
        cVar.f(21, i11);
        String str = f14228f;
        cVar.k(182, str, "writeFieldValue", "(CLjava/lang/String;" + c11 + ")V");
        v(cVar, aVar2);
        cVar.d(label);
    }

    public final void n(c cVar, i2.a aVar, a aVar2, Label label) {
        cVar.f(25, 0);
        cVar.f(25, 1);
        cVar.b(aVar.f15972l);
        String str = f14230h;
        cVar.k(182, str, "applyLabel", "(L" + f14225c + ";Ljava/lang/String;)Z");
        cVar.e(153, label);
    }

    public final void o(Class<?> cls, c cVar, i2.a aVar, a aVar2) {
        Label label;
        int i11;
        int i12;
        int i13;
        Label label2;
        Label label3;
        Label label4;
        Label label5;
        String str;
        String str2;
        i2.a aVar3;
        Label label6;
        String str3;
        Label label7;
        String str4;
        c cVar2 = cVar;
        i2.a aVar4 = aVar;
        a aVar5 = aVar2;
        Type G = TypeUtils.G(aVar4.f15967g);
        Class<Serializable> cls2 = null;
        Class<Serializable> cls3 = G instanceof Class ? (Class) G : null;
        if (!(cls3 == Object.class || cls3 == Serializable.class)) {
            cls2 = cls3;
        }
        Label label8 = new Label();
        Label label9 = new Label();
        Label label10 = new Label();
        q(cVar2, aVar4, aVar5, label8);
        i(cVar2, aVar5, aVar4);
        cVar2.c(192, "java/util/List");
        cVar2.f(58, aVar5.g("list"));
        g(cVar2, aVar4, aVar5, label8);
        cVar2.f(25, aVar5.g("list"));
        cVar2.e(199, label9);
        l(cVar2, aVar4, aVar5);
        cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label10);
        cVar2.d(label9);
        cVar2.f(25, aVar5.g("out"));
        cVar2.f(21, aVar5.g("seperator"));
        String str5 = f14228f;
        cVar2.k(182, str5, "write", "(I)V");
        x(cVar2, aVar5);
        cVar2.f(25, aVar5.g("list"));
        Label label11 = label8;
        cVar2.k(185, "java/util/List", "size", "()I");
        cVar2.f(54, aVar5.g("size"));
        Label label12 = new Label();
        Label label13 = new Label();
        Label label14 = label10;
        cVar2.f(21, aVar5.g("size"));
        cVar2.i(3);
        cVar2.e(160, label12);
        cVar2.f(25, aVar5.g("out"));
        cVar2.b(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        cVar2.k(182, str5, "write", "(Ljava/lang/String;)V");
        cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label13);
        cVar2.d(label12);
        if (!aVar2.f14245g) {
            cVar2.f(25, 1);
            cVar2.f(25, aVar5.g("list"));
            cVar2.f(25, a.f14236h);
            label = label13;
            cVar2.k(182, f14225c, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
        } else {
            label = label13;
        }
        if (G != String.class || !aVar2.f14242d) {
            cVar2.f(25, aVar5.g("out"));
            cVar2.f(16, 91);
            cVar2.k(182, str5, "write", "(I)V");
            Label label15 = new Label();
            Label label16 = new Label();
            Label label17 = new Label();
            cVar2.i(3);
            Type type = G;
            cVar2.f(54, aVar5.g("i"));
            cVar2.d(label15);
            cVar2.f(21, aVar5.g("i"));
            cVar2.f(21, aVar5.g("size"));
            cVar2.e(162, label17);
            cVar2.f(21, aVar5.g("i"));
            cVar2.e(153, label16);
            cVar2.f(25, aVar5.g("out"));
            cVar2.f(16, 44);
            cVar2.k(182, str5, "write", "(I)V");
            cVar2.d(label16);
            cVar2.f(25, aVar5.g("list"));
            cVar2.f(21, aVar5.g("i"));
            cVar2.k(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
            cVar2.f(58, aVar5.g("list_item"));
            Label label18 = new Label();
            Label label19 = new Label();
            cVar2.f(25, aVar5.g("list_item"));
            cVar2.e(199, label19);
            cVar2.f(25, aVar5.g("out"));
            cVar2.k(182, str5, "writeNull", "()V");
            cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label18);
            cVar2.d(label19);
            Label label20 = new Label();
            Label label21 = new Label();
            String str6 = str5;
            String str7 = "(I)V";
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                label4 = label15;
                label2 = label18;
                str = "out";
                label6 = label20;
                label3 = label21;
                str2 = "write";
                label5 = label17;
                aVar3 = aVar;
            } else {
                str = "out";
                cVar2.f(25, aVar5.g("list_item"));
                label5 = label17;
                label4 = label15;
                cVar2.k(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                cVar2.b(e.d(ASMUtils.b(cls2)));
                cVar2.e(166, label21);
                aVar3 = aVar;
                k(aVar5, cVar2, aVar3, cls2);
                cVar2.f(58, aVar5.g("list_item_desc"));
                Label label22 = new Label();
                Label label23 = new Label();
                if (aVar2.f14242d) {
                    if (!aVar2.f14245g || !aVar2.f14242d) {
                        label2 = label18;
                        label3 = label21;
                        str4 = "write";
                    } else {
                        label2 = label18;
                        str4 = "writeDirectNonContext";
                        label3 = label21;
                    }
                    label7 = label20;
                    cVar2.f(25, aVar5.g("list_item_desc"));
                    String str8 = f14230h;
                    cVar2.c(193, str8);
                    cVar2.e(153, label22);
                    str3 = "write";
                    cVar2.f(25, aVar5.g("list_item_desc"));
                    cVar2.c(192, str8);
                    cVar2.f(25, 1);
                    cVar2.f(25, aVar5.g("list_item"));
                    if (aVar2.f14245g) {
                        cVar2.i(1);
                    } else {
                        cVar2.f(21, aVar5.g("i"));
                        cVar2.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    }
                    cVar2.b(e.d(ASMUtils.b(cls2)));
                    cVar2.b(Integer.valueOf(aVar3.f15970j));
                    cVar2.k(182, str8, str4, "(L" + f14225c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label23);
                    cVar2.d(label22);
                } else {
                    label2 = label18;
                    label7 = label20;
                    label3 = label21;
                    str3 = "write";
                }
                cVar2.f(25, aVar5.g("list_item_desc"));
                cVar2.f(25, 1);
                cVar2.f(25, aVar5.g("list_item"));
                if (aVar2.f14245g) {
                    cVar2.i(1);
                } else {
                    cVar2.f(21, aVar5.g("i"));
                    cVar2.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                }
                cVar2.b(e.d(ASMUtils.b(cls2)));
                cVar2.b(Integer.valueOf(aVar3.f15970j));
                str2 = str3;
                cVar2.k(185, f14226d, str2, "(L" + f14225c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                cVar2.d(label23);
                label6 = label7;
                cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label6);
            }
            cVar2.d(label3);
            cVar2.f(25, 1);
            cVar2.f(25, aVar5.g("list_item"));
            if (aVar2.f14245g) {
                cVar2.i(1);
            } else {
                cVar2.f(21, aVar5.g("i"));
                cVar2.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            }
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                cVar2.k(182, f14225c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                cVar2.b(e.d(ASMUtils.b((Class) type)));
                cVar2.b(Integer.valueOf(aVar3.f15970j));
                cVar2.k(182, f14225c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
            cVar2.d(label6);
            cVar2.d(label2);
            i13 = 1;
            cVar2.g(aVar5.g("i"), 1);
            cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label4);
            cVar2.d(label5);
            i12 = 25;
            cVar2.f(25, aVar5.g(str));
            cVar2.f(16, 93);
            i11 = 182;
            cVar2.k(182, str6, str2, str7);
        } else {
            cVar2.f(25, aVar5.g("out"));
            cVar2.f(25, aVar5.g("list"));
            cVar2.k(182, str5, "write", "(Ljava/util/List;)V");
            i12 = 25;
            i11 = 182;
            i13 = 1;
        }
        cVar2.f(i12, i13);
        cVar2.k(i11, f14225c, "popContext", "()V");
        cVar2.d(label);
        v(cVar2, aVar5);
        cVar2.d(label14);
        cVar2.d(label11);
    }

    public final void p(Class<?> cls, c cVar, i2.a aVar, a aVar2) {
        Label label = new Label();
        q(cVar, aVar, aVar2, label);
        i(cVar, aVar2, aVar);
        cVar.f(55, aVar2.h("long", 2));
        g(cVar, aVar, aVar2, label);
        cVar.f(25, aVar2.g("out"));
        cVar.f(21, aVar2.g("seperator"));
        cVar.f(25, a.f14236h);
        cVar.f(22, aVar2.h("long", 2));
        cVar.k(182, f14228f, "writeFieldValue", "(CLjava/lang/String;J)V");
        v(cVar, aVar2);
        cVar.d(label);
    }

    public final void q(c cVar, i2.a aVar, a aVar2, Label label) {
        if (!aVar2.f14242d) {
            cVar.f(25, 0);
            cVar.f(25, 1);
            cVar.f(25, 2);
            cVar.f(25, a.f14236h);
            String str = f14230h;
            cVar.k(182, str, "applyName", "(L" + f14225c + ";Ljava/lang/Object;Ljava/lang/String;)Z");
            cVar.e(153, label);
            n(cVar, aVar, aVar2, label);
        }
        if (aVar.f15964d == null) {
            cVar.f(25, aVar2.g("out"));
            cVar.b(Integer.valueOf(SerializerFeature.IgnoreNonFieldGetter.mask));
            cVar.k(182, f14228f, "isEnabled", "(I)Z");
            cVar.e(154, label);
        }
    }

    public final void r(c cVar, i2.a aVar, a aVar2, Label label) {
        if (!aVar2.f14242d) {
            Label label2 = new Label();
            cVar.f(21, aVar2.g("notWriteDefaultValue"));
            cVar.e(153, label2);
            Class<?> cls = aVar.f15966f;
            if (cls == Boolean.TYPE) {
                cVar.f(21, aVar2.g("boolean"));
                cVar.e(153, label);
            } else if (cls == Byte.TYPE) {
                cVar.f(21, aVar2.g("byte"));
                cVar.e(153, label);
            } else if (cls == Short.TYPE) {
                cVar.f(21, aVar2.g("short"));
                cVar.e(153, label);
            } else if (cls == Integer.TYPE) {
                cVar.f(21, aVar2.g("int"));
                cVar.e(153, label);
            } else if (cls == Long.TYPE) {
                cVar.f(22, aVar2.g("long"));
                cVar.i(9);
                cVar.i(Code39Reader.ASTERISK_ENCODING);
                cVar.e(153, label);
            } else if (cls == Float.TYPE) {
                cVar.f(23, aVar2.g("float"));
                cVar.i(11);
                cVar.i(149);
                cVar.e(153, label);
            } else if (cls == Double.TYPE) {
                cVar.f(24, aVar2.g("double"));
                cVar.i(14);
                cVar.i(151);
                cVar.e(153, label);
            }
            cVar.d(label2);
        }
    }

    public final void s(Class<?> cls, c cVar, i2.a aVar, a aVar2) {
        Label label = new Label();
        q(cVar, aVar, aVar2, label);
        i(cVar, aVar2, aVar);
        cVar.f(58, aVar2.g("object"));
        g(cVar, aVar, aVar2, label);
        y(cVar, aVar, aVar2, label);
        cVar.d(label);
    }

    public final void t(c cVar, i2.a aVar, a aVar2) {
        Label label = new Label();
        cVar.f(21, aVar2.g("hasNameFilters"));
        cVar.e(153, label);
        Class<?> cls = aVar.f15966f;
        cVar.f(25, 0);
        cVar.f(25, 1);
        cVar.f(25, 2);
        cVar.f(25, a.f14236h);
        if (cls == Byte.TYPE) {
            cVar.f(21, aVar2.g("byte"));
            cVar.k(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            cVar.f(21, aVar2.g("short"));
            cVar.k(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            cVar.f(21, aVar2.g("int"));
            cVar.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            cVar.f(21, aVar2.g("char"));
            cVar.k(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            cVar.f(22, aVar2.h("long", 2));
            cVar.k(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            cVar.f(23, aVar2.g("float"));
            cVar.k(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            cVar.f(24, aVar2.h("double", 2));
            cVar.k(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            cVar.f(21, aVar2.g("boolean"));
            cVar.k(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            cVar.f(25, aVar2.g("decimal"));
        } else if (cls == String.class) {
            cVar.f(25, aVar2.g("string"));
        } else if (cls.isEnum()) {
            cVar.f(25, aVar2.g("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            cVar.f(25, aVar2.g("list"));
        } else {
            cVar.f(25, aVar2.g("object"));
        }
        String str = f14230h;
        cVar.k(182, str, "processKey", "(L" + f14225c + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        cVar.f(58, a.f14236h);
        cVar.d(label);
    }

    public final void u(c cVar, i2.a aVar, a aVar2, Label label) {
        c cVar2 = cVar;
        i2.a aVar3 = aVar;
        a aVar4 = aVar2;
        Class<h2.c> cls = h2.c.class;
        Label label2 = new Label();
        Class<?> cls2 = aVar3.f15966f;
        if (cls2.isPrimitive()) {
            Label label3 = new Label();
            cVar2.f(21, aVar4.g("checkValue"));
            cVar2.e(154, label3);
            cVar2.i(1);
            cVar2.i(89);
            cVar2.f(58, a.f14237i);
            cVar2.f(58, a.f14238j);
            cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label2);
            cVar2.d(label3);
        }
        cVar2.f(25, 0);
        cVar2.f(25, 1);
        cVar2.f(25, 0);
        cVar2.b(Integer.valueOf(aVar4.f(aVar3.f15962b)));
        String str = f14230h;
        cVar2.k(182, str, "getBeanContext", "(I)" + ASMUtils.b(cls));
        cVar2.f(25, 2);
        cVar2.f(25, a.f14236h);
        if (cls2 == Byte.TYPE) {
            cVar2.f(21, aVar4.g("byte"));
            cVar2.k(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            cVar2.i(89);
            cVar2.f(58, a.f14237i);
        } else if (cls2 == Short.TYPE) {
            cVar2.f(21, aVar4.g("short"));
            cVar2.k(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            cVar2.i(89);
            cVar2.f(58, a.f14237i);
        } else if (cls2 == Integer.TYPE) {
            cVar2.f(21, aVar4.g("int"));
            cVar2.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            cVar2.i(89);
            cVar2.f(58, a.f14237i);
        } else if (cls2 == Character.TYPE) {
            cVar2.f(21, aVar4.g("char"));
            cVar2.k(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            cVar2.i(89);
            cVar2.f(58, a.f14237i);
        } else if (cls2 == Long.TYPE) {
            cVar2.f(22, aVar4.h("long", 2));
            cVar2.k(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            cVar2.i(89);
            cVar2.f(58, a.f14237i);
        } else if (cls2 == Float.TYPE) {
            cVar2.f(23, aVar4.g("float"));
            cVar2.k(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            cVar2.i(89);
            cVar2.f(58, a.f14237i);
        } else if (cls2 == Double.TYPE) {
            cVar2.f(24, aVar4.h("double", 2));
            cVar2.k(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            cVar2.i(89);
            cVar2.f(58, a.f14237i);
        } else if (cls2 == Boolean.TYPE) {
            cVar2.f(21, aVar4.g("boolean"));
            cVar2.k(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            cVar2.i(89);
            cVar2.f(58, a.f14237i);
        } else if (cls2 == BigDecimal.class) {
            cVar2.f(25, aVar4.g("decimal"));
            cVar2.f(58, a.f14237i);
            cVar2.f(25, a.f14237i);
        } else if (cls2 == String.class) {
            cVar2.f(25, aVar4.g("string"));
            cVar2.f(58, a.f14237i);
            cVar2.f(25, a.f14237i);
        } else if (cls2.isEnum()) {
            cVar2.f(25, aVar4.g("enum"));
            cVar2.f(58, a.f14237i);
            cVar2.f(25, a.f14237i);
        } else if (List.class.isAssignableFrom(cls2)) {
            cVar2.f(25, aVar4.g("list"));
            cVar2.f(58, a.f14237i);
            cVar2.f(25, a.f14237i);
        } else {
            cVar2.f(25, aVar4.g("object"));
            cVar2.f(58, a.f14237i);
            cVar2.f(25, a.f14237i);
        }
        cVar2.k(182, str, "processValue", "(L" + f14225c + ";" + ASMUtils.b(cls) + "Ljava/lang/Object;Ljava/lang/String;" + "Ljava/lang/Object;" + ")Ljava/lang/Object;");
        cVar2.f(58, a.f14238j);
        cVar2.f(25, a.f14237i);
        cVar2.f(25, a.f14238j);
        cVar2.e(165, label2);
        y(cVar, aVar, aVar2, label);
        cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label);
        cVar2.d(label2);
    }

    public final void v(c cVar, a aVar) {
        cVar.f(16, 44);
        cVar.f(54, aVar.g("seperator"));
    }

    public final void w(Class<?> cls, c cVar, i2.a aVar, a aVar2) {
        Label label = new Label();
        if (aVar.f15962b.equals(aVar2.f14241c.f15929c)) {
            cVar.f(25, 1);
            cVar.f(25, 4);
            cVar.f(25, 2);
            cVar.k(182, f14225c, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            cVar.e(154, label);
        }
        q(cVar, aVar, aVar2, label);
        i(cVar, aVar2, aVar);
        cVar.f(58, aVar2.g("string"));
        g(cVar, aVar, aVar2, label);
        Label label2 = new Label();
        Label label3 = new Label();
        cVar.f(25, aVar2.g("string"));
        cVar.e(199, label2);
        l(cVar, aVar, aVar2);
        cVar.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label3);
        cVar.d(label2);
        if (aVar2.f14242d) {
            cVar.f(25, aVar2.g("out"));
            cVar.f(21, aVar2.g("seperator"));
            cVar.f(25, a.f14236h);
            cVar.f(25, aVar2.g("string"));
            cVar.k(182, f14228f, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            cVar.f(25, aVar2.g("out"));
            cVar.f(21, aVar2.g("seperator"));
            cVar.f(25, a.f14236h);
            cVar.f(25, aVar2.g("string"));
            cVar.k(182, f14228f, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        }
        v(cVar, aVar2);
        cVar.d(label3);
        cVar.d(label);
    }

    public final void x(c cVar, a aVar) {
        if (aVar.f14242d) {
            cVar.f(25, aVar.g("out"));
            cVar.f(25, a.f14236h);
            cVar.k(182, f14228f, "writeFieldNameDirect", "(Ljava/lang/String;)V");
            return;
        }
        cVar.f(25, aVar.g("out"));
        cVar.f(25, a.f14236h);
        cVar.i(3);
        cVar.k(182, f14228f, "writeFieldName", "(Ljava/lang/String;Z)V");
    }

    public final void y(c cVar, i2.a aVar, a aVar2, Label label) {
        Class<String> cls;
        String str;
        Label label2;
        Label label3;
        c cVar2 = cVar;
        i2.a aVar3 = aVar;
        a aVar4 = aVar2;
        Class<String> cls2 = String.class;
        String i11 = aVar.i();
        Class<?> cls3 = aVar3.f15966f;
        Label label4 = new Label();
        if (aVar2.f14242d) {
            cVar2.f(25, aVar4.g("object"));
        } else {
            cVar2.f(25, a.f14238j);
        }
        cVar2.i(89);
        cVar2.f(58, aVar4.g("object"));
        cVar2.e(199, label4);
        l(cVar, aVar, aVar2);
        cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label);
        cVar2.d(label4);
        cVar2.f(25, aVar4.g("out"));
        cVar2.f(21, aVar4.g("seperator"));
        cVar2.k(182, f14228f, "write", "(I)V");
        x(cVar2, aVar4);
        Label label5 = new Label();
        Label label6 = new Label();
        if (!Modifier.isPublic(cls3.getModifiers()) || ParserConfig.n(cls3)) {
            cls = cls2;
            str = i11;
            label3 = label5;
            label2 = label6;
        } else {
            cVar2.f(25, aVar4.g("object"));
            cls = cls2;
            cVar2.k(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            cVar2.b(e.d(ASMUtils.b(cls3)));
            cVar2.e(166, label6);
            j(aVar4, cVar2, aVar3);
            cVar2.f(58, aVar4.g("fied_ser"));
            Label label7 = new Label();
            Label label8 = new Label();
            cVar2.f(25, aVar4.g("fied_ser"));
            String str2 = f14230h;
            cVar2.c(193, str2);
            cVar2.e(153, label7);
            int i12 = aVar3.f15970j;
            str = i11;
            boolean z11 = (SerializerFeature.DisableCircularReferenceDetect.mask & i12) != 0;
            boolean z12 = (SerializerFeature.BeanToArray.mask & i12) != 0;
            String str3 = (z11 || (aVar2.f14245g && aVar2.f14242d)) ? z12 ? "writeAsArrayNonContext" : "writeDirectNonContext" : z12 ? "writeAsArray" : "write";
            cVar2.f(25, aVar4.g("fied_ser"));
            cVar2.c(192, str2);
            cVar2.f(25, 1);
            cVar2.f(25, aVar4.g("object"));
            cVar2.f(25, a.f14236h);
            cVar2.f(25, 0);
            String d11 = aVar2.f14240b;
            StringBuilder sb2 = new StringBuilder();
            Label label9 = label6;
            sb2.append(aVar3.f15962b);
            sb2.append("_asm_fieldType");
            cVar2.a(180, d11, sb2.toString(), "Ljava/lang/reflect/Type;");
            cVar2.b(Integer.valueOf(aVar3.f15970j));
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(L");
            String str4 = f14225c;
            sb3.append(str4);
            sb3.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            cVar2.k(182, str2, str3, sb3.toString());
            cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label8);
            cVar2.d(label7);
            cVar2.f(25, aVar4.g("fied_ser"));
            cVar2.f(25, 1);
            cVar2.f(25, aVar4.g("object"));
            cVar2.f(25, a.f14236h);
            cVar2.f(25, 0);
            String d12 = aVar2.f14240b;
            cVar2.a(180, d12, aVar3.f15962b + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            cVar2.b(Integer.valueOf(aVar3.f15970j));
            String str5 = f14226d;
            cVar2.k(185, str5, "write", "(L" + str4 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            cVar2.d(label8);
            label3 = label5;
            cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label3);
            label2 = label9;
        }
        cVar2.d(label2);
        cVar2.f(25, 1);
        if (aVar2.f14242d) {
            cVar2.f(25, aVar4.g("object"));
        } else {
            cVar2.f(25, a.f14238j);
        }
        if (str != null) {
            cVar2.b(str);
            cVar2.k(182, f14225c, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            cVar2.f(25, a.f14236h);
            Type type = aVar3.f15967g;
            if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
                Class<String> cls4 = cls;
                if (aVar3.f15966f == cls4) {
                    cVar2.b(e.d(ASMUtils.b(cls4)));
                } else {
                    cVar2.f(25, 0);
                    String d13 = aVar2.f14240b;
                    cVar2.a(180, d13, aVar3.f15962b + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                }
                cVar2.b(Integer.valueOf(aVar3.f15970j));
                cVar2.k(182, f14225c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            } else {
                cVar2.k(182, f14225c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            }
        }
        cVar2.d(label3);
        v(cVar2, aVar4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x04b5 A[EDGE_INSN: B:119:0x04b5->B:87:0x04b5 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x04c5  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x053c  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0541  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h2.h z(h2.o r35) throws java.lang.Exception {
        /*
            r34 = this;
            r0 = r34
            r7 = r35
            java.lang.Class<h2.o> r8 = h2.o.class
            java.lang.Class<?> r9 = r7.f15927a
            boolean r1 = r9.isPrimitive()
            if (r1 != 0) goto L_0x05fe
            java.lang.Class<d2.d> r1 = d2.d.class
            java.lang.annotation.Annotation r1 = r9.getAnnotation(r1)
            r10 = r1
            d2.d r10 = (d2.d) r10
            i2.a[] r11 = r7.f15931e
            int r1 = r11.length
            r12 = 0
            r2 = r12
        L_0x001c:
            if (r2 >= r1) goto L_0x003b
            r3 = r11[r2]
            java.lang.reflect.Field r4 = r3.f15964d
            if (r4 != 0) goto L_0x0038
            java.lang.reflect.Method r3 = r3.f15963c
            if (r3 == 0) goto L_0x0038
            java.lang.Class r3 = r3.getDeclaringClass()
            boolean r3 = r3.isInterface()
            if (r3 == 0) goto L_0x0038
            h2.h r1 = new h2.h
            r1.<init>((java.lang.Class<?>) r9)
            return r1
        L_0x0038:
            int r2 = r2 + 1
            goto L_0x001c
        L_0x003b:
            i2.a[] r13 = r7.f15932f
            i2.a[] r1 = r7.f15931e
            r14 = 1
            if (r13 != r1) goto L_0x0044
            r15 = r14
            goto L_0x0045
        L_0x0044:
            r15 = r12
        L_0x0045:
            int r1 = r13.length
            r2 = 256(0x100, float:3.59E-43)
            if (r1 <= r2) goto L_0x0050
            h2.h r1 = new h2.h
            r1.<init>((java.lang.Class<?>) r9)
            return r1
        L_0x0050:
            int r1 = r13.length
            r2 = r12
        L_0x0052:
            if (r2 >= r1) goto L_0x006d
            r3 = r13[r2]
            java.lang.reflect.Member r3 = r3.k()
            java.lang.String r3 = r3.getName()
            boolean r3 = com.alibaba.fastjson.util.ASMUtils.a(r3)
            if (r3 != 0) goto L_0x006a
            h2.h r1 = new h2.h
            r1.<init>((java.lang.Class<?>) r9)
            return r1
        L_0x006a:
            int r2 = r2 + 1
            goto L_0x0052
        L_0x006d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ASMSerializer_"
            r1.append(r2)
            java.util.concurrent.atomic.AtomicLong r2 = r0.f14235b
            long r2 = r2.incrementAndGet()
            r1.append(r2)
            java.lang.String r2 = "_"
            r1.append(r2)
            java.lang.String r2 = r9.getSimpleName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.Class<com.alibaba.fastjson.serializer.ASMSerializerFactory> r2 = com.alibaba.fastjson.serializer.ASMSerializerFactory.class
            java.lang.Package r2 = r2.getPackage()
            java.lang.String r2 = r2.getName()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 46
            r5 = 47
            java.lang.String r4 = r2.replace(r4, r5)
            r3.append(r4)
            java.lang.String r4 = "/"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r6 = r3.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = "."
            r3.append(r2)
            r3.append(r1)
            java.lang.String r5 = r3.toString()
            com.alibaba.fastjson.asm.ClassWriter r4 = new com.alibaba.fastjson.asm.ClassWriter
            r4.<init>()
            r17 = 49
            r18 = 33
            java.lang.String r20 = f14230h
            java.lang.String[] r1 = new java.lang.String[r14]
            java.lang.String r2 = f14226d
            r1[r12] = r2
            r16 = r4
            r19 = r6
            r21 = r1
            r16.k(r17, r18, r19, r20, r21)
            int r1 = r13.length
            r2 = r12
        L_0x00e6:
            if (r2 >= r1) goto L_0x0170
            r3 = r13[r2]
            java.lang.Class<?> r12 = r3.f15966f
            boolean r12 = r12.isPrimitive()
            if (r12 != 0) goto L_0x0162
            java.lang.Class<?> r12 = r3.f15966f
            java.lang.Class<java.lang.String> r14 = java.lang.String.class
            if (r12 != r14) goto L_0x00f9
            goto L_0x0162
        L_0x00f9:
            e2.a r12 = new e2.a
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r16 = r1
            java.lang.String r1 = r3.f15962b
            r14.append(r1)
            java.lang.String r1 = "_asm_fieldType"
            r14.append(r1)
            java.lang.String r1 = r14.toString()
            java.lang.String r14 = "Ljava/lang/reflect/Type;"
            r23 = r5
            r5 = 1
            r12.<init>(r4, r5, r1, r14)
            r12.c()
            java.lang.Class<java.util.List> r1 = java.util.List.class
            java.lang.Class<?> r5 = r3.f15966f
            boolean r1 = r1.isAssignableFrom(r5)
            if (r1 == 0) goto L_0x0143
            e2.a r1 = new e2.a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r12 = r3.f15962b
            r5.append(r12)
            java.lang.String r12 = "_asm_list_item_ser_"
            r5.append(r12)
            java.lang.String r5 = r5.toString()
            java.lang.String r12 = f14227e
            r14 = 1
            r1.<init>(r4, r14, r5, r12)
            r1.c()
        L_0x0143:
            e2.a r1 = new e2.a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r3 = r3.f15962b
            r5.append(r3)
            java.lang.String r3 = "_asm_ser_"
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.String r5 = f14227e
            r12 = 1
            r1.<init>(r4, r12, r3, r5)
            r1.c()
            goto L_0x0166
        L_0x0162:
            r16 = r1
            r23 = r5
        L_0x0166:
            int r2 = r2 + 1
            r1 = r16
            r5 = r23
            r12 = 0
            r14 = 1
            goto L_0x00e6
        L_0x0170:
            r23 = r5
            e2.d r1 = new e2.d
            r18 = 1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "("
            r2.append(r3)
            java.lang.String r5 = com.alibaba.fastjson.util.ASMUtils.b(r8)
            r2.append(r5)
            java.lang.String r5 = ")V"
            r2.append(r5)
            java.lang.String r20 = r2.toString()
            r21 = 0
            r22 = 0
            java.lang.String r19 = "<init>"
            r16 = r1
            r17 = r4
            r16.<init>(r17, r18, r19, r20, r21, r22)
            r12 = 25
            r2 = 0
            r1.f(r12, r2)
            r2 = 1
            r1.f(r12, r2)
            r2 = 183(0xb7, float:2.56E-43)
            java.lang.String r14 = f14230h
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r3)
            java.lang.String r3 = com.alibaba.fastjson.util.ASMUtils.b(r8)
            r12.append(r3)
            r12.append(r5)
            java.lang.String r3 = r12.toString()
            java.lang.String r5 = "<init>"
            r1.k(r2, r14, r5, r3)
            r2 = 0
        L_0x01c7:
            int r3 = r13.length
            if (r2 >= r3) goto L_0x024a
            r3 = r13[r2]
            java.lang.Class<?> r5 = r3.f15966f
            boolean r5 = r5.isPrimitive()
            if (r5 != 0) goto L_0x0242
            java.lang.Class<?> r5 = r3.f15966f
            java.lang.Class<java.lang.String> r12 = java.lang.String.class
            if (r5 != r12) goto L_0x01db
            goto L_0x0242
        L_0x01db:
            r5 = 0
            r12 = 25
            r1.f(r12, r5)
            java.lang.reflect.Method r5 = r3.f15963c
            if (r5 == 0) goto L_0x020d
            java.lang.Class<?> r5 = r3.f15968h
            java.lang.String r5 = com.alibaba.fastjson.util.ASMUtils.b(r5)
            e2.e r5 = e2.e.d(r5)
            r1.b(r5)
            java.lang.reflect.Method r5 = r3.f15963c
            java.lang.String r5 = r5.getName()
            r1.b(r5)
            r5 = 184(0xb8, float:2.58E-43)
            java.lang.Class<com.alibaba.fastjson.util.ASMUtils> r12 = com.alibaba.fastjson.util.ASMUtils.class
            java.lang.String r12 = com.alibaba.fastjson.util.ASMUtils.f(r12)
            java.lang.String r14 = "getMethodType"
            r16 = r4
            java.lang.String r4 = "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;"
            r1.k(r5, r12, r14, r4)
            goto L_0x0227
        L_0x020d:
            r16 = r4
            r4 = 0
            r5 = 25
            r1.f(r5, r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r1.b(r4)
            r4 = 183(0xb7, float:2.56E-43)
            java.lang.String r5 = f14230h
            java.lang.String r12 = "getFieldType"
            java.lang.String r14 = "(I)Ljava/lang/reflect/Type;"
            r1.k(r4, r5, r12, r14)
        L_0x0227:
            r4 = 181(0xb5, float:2.54E-43)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r3 = r3.f15962b
            r5.append(r3)
            java.lang.String r3 = "_asm_fieldType"
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.String r5 = "Ljava/lang/reflect/Type;"
            r1.a(r4, r6, r3, r5)
            goto L_0x0244
        L_0x0242:
            r16 = r4
        L_0x0244:
            int r2 = r2 + 1
            r4 = r16
            goto L_0x01c7
        L_0x024a:
            r16 = r4
            r12 = 177(0xb1, float:2.48E-43)
            r1.i(r12)
            r14 = 4
            r1.j(r14, r14)
            r1.l()
            if (r10 == 0) goto L_0x026e
            com.alibaba.fastjson.serializer.SerializerFeature[] r1 = r10.serialzeFeatures()
            int r2 = r1.length
            r3 = 0
        L_0x0260:
            if (r3 >= r2) goto L_0x026e
            r4 = r1[r3]
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect
            if (r4 != r5) goto L_0x026b
            r24 = 1
            goto L_0x0270
        L_0x026b:
            int r3 = r3 + 1
            goto L_0x0260
        L_0x026e:
            r24 = 0
        L_0x0270:
            r5 = 0
        L_0x0271:
            r4 = 7
            java.lang.String r3 = "entity"
            r2 = 192(0xc0, float:2.69E-43)
            java.lang.String r25 = "java/io/IOException"
            java.lang.String r12 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            java.lang.String r14 = "(L"
            java.lang.String r7 = "out"
            r27 = r8
            r8 = 2
            r1 = 3
            if (r5 >= r1) goto L_0x04b5
            if (r5 != 0) goto L_0x028f
            java.lang.String r1 = "write"
            r19 = r1
            r28 = r24
            r18 = 1
            goto L_0x02a3
        L_0x028f:
            r1 = 1
            if (r5 != r1) goto L_0x029b
            java.lang.String r1 = "writeNormal"
            r19 = r1
            r28 = r24
            r18 = 0
            goto L_0x02a3
        L_0x029b:
            java.lang.String r1 = "writeDirectNonContext"
            r19 = r1
            r18 = 1
            r28 = 1
        L_0x02a3:
            com.alibaba.fastjson.serializer.ASMSerializerFactory$a r1 = new com.alibaba.fastjson.serializer.ASMSerializerFactory$a
            r29 = r1
            r2 = r13
            r30 = r3
            r3 = r35
            r31 = r16
            r4 = r6
            r32 = r23
            r23 = r5
            r5 = r18
            r33 = r6
            r6 = r28
            r1.<init>(r2, r3, r4, r5, r6)
            e2.d r1 = new e2.d
            r18 = 1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            java.lang.String r3 = f14225c
            r2.append(r3)
            r2.append(r12)
            java.lang.String r20 = r2.toString()
            r21 = 0
            java.lang.String[] r22 = new java.lang.String[]{r25}
            r16 = r1
            r17 = r31
            r16.<init>(r17, r18, r19, r20, r21, r22)
            com.alibaba.fastjson.asm.Label r2 = new com.alibaba.fastjson.asm.Label
            r2.<init>()
            r4 = 25
            r1.f(r4, r8)
            r5 = 199(0xc7, float:2.79E-43)
            r1.e(r5, r2)
            r5 = 1
            r1.f(r4, r5)
            r6 = 182(0xb6, float:2.55E-43)
            java.lang.String r8 = "writeNull"
            java.lang.String r4 = "()V"
            r1.k(r6, r3, r8, r4)
            r4 = 177(0xb1, float:2.48E-43)
            r1.i(r4)
            r1.d(r2)
            r2 = 25
            r1.f(r2, r5)
            java.lang.String r2 = f14229g
            r8 = 180(0xb4, float:2.52E-43)
            r1.a(r8, r3, r7, r2)
            r2 = r29
            int r4 = r2.g(r7)
            r5 = 58
            r1.f(r5, r4)
            if (r15 != 0) goto L_0x0388
            boolean r8 = r2.f14242d
            if (r8 != 0) goto L_0x0388
            if (r10 == 0) goto L_0x032c
            boolean r8 = r10.alphabetic()
            if (r8 == 0) goto L_0x0388
        L_0x032c:
            com.alibaba.fastjson.asm.Label r8 = new com.alibaba.fastjson.asm.Label
            r8.<init>()
            int r4 = r2.g(r7)
            r5 = 25
            r1.f(r5, r4)
            java.lang.String r4 = f14228f
            java.lang.String r5 = "isSortField"
            r18 = r10
            java.lang.String r10 = "()Z"
            r1.k(r6, r4, r5, r10)
            r4 = 154(0x9a, float:2.16E-43)
            r1.e(r4, r8)
            r4 = 0
            r5 = 25
            r1.f(r5, r4)
            r4 = 1
            r1.f(r5, r4)
            r4 = 2
            r1.f(r5, r4)
            r4 = 3
            r1.f(r5, r4)
            r4 = 4
            r1.f(r5, r4)
            r4 = 5
            r5 = 21
            r1.f(r5, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r14)
            r4.append(r3)
            r4.append(r12)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "writeUnsorted"
            r10 = r33
            r1.k(r6, r10, r5, r4)
            r4 = 177(0xb1, float:2.48E-43)
            r1.i(r4)
            r1.d(r8)
            goto L_0x038c
        L_0x0388:
            r18 = r10
            r10 = r33
        L_0x038c:
            boolean r4 = r2.f14242d
            if (r4 == 0) goto L_0x046b
            if (r28 != 0) goto L_0x046b
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            com.alibaba.fastjson.asm.Label r5 = new com.alibaba.fastjson.asm.Label
            r5.<init>()
            r6 = 25
            r8 = 0
            r1.f(r6, r8)
            r8 = 1
            r1.f(r6, r8)
            java.lang.String r6 = f14230h
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r14)
            r8.append(r3)
            r28 = r11
            java.lang.String r11 = ";)Z"
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            java.lang.String r11 = "writeDirect"
            r20 = r15
            r15 = 182(0xb6, float:2.55E-43)
            r1.k(r15, r6, r11, r8)
            r6 = 154(0x9a, float:2.16E-43)
            r1.e(r6, r5)
            r6 = 0
            r8 = 25
            r1.f(r8, r6)
            r6 = 1
            r1.f(r8, r6)
            r6 = 2
            r1.f(r8, r6)
            r6 = 3
            r1.f(r8, r6)
            r6 = 4
            r1.f(r8, r6)
            r6 = 5
            r8 = 21
            r1.f(r8, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r14)
            r6.append(r3)
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            java.lang.String r8 = "writeNormal"
            r11 = 182(0xb6, float:2.55E-43)
            r1.k(r11, r10, r8, r6)
            r6 = 177(0xb1, float:2.48E-43)
            r1.i(r6)
            r1.d(r5)
            int r5 = r2.g(r7)
            r6 = 25
            r1.f(r6, r5)
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect
            int r5 = r5.mask
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.b(r5)
            java.lang.String r5 = f14228f
            java.lang.String r7 = "isEnabled"
            java.lang.String r8 = "(I)Z"
            r11 = 182(0xb6, float:2.55E-43)
            r1.k(r11, r5, r7, r8)
            r5 = 153(0x99, float:2.14E-43)
            r1.e(r5, r4)
            r5 = 0
            r1.f(r6, r5)
            r5 = 1
            r1.f(r6, r5)
            r5 = 2
            r1.f(r6, r5)
            r5 = 3
            r1.f(r6, r5)
            r5 = 4
            r1.f(r6, r5)
            r6 = 5
            r7 = 21
            r1.f(r7, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r14)
            r6.append(r3)
            r6.append(r12)
            java.lang.String r3 = r6.toString()
            java.lang.String r6 = "writeDirectNonContext"
            r7 = 182(0xb6, float:2.55E-43)
            r1.k(r7, r10, r6, r3)
            r3 = 177(0xb1, float:2.48E-43)
            r1.i(r3)
            r1.d(r4)
            goto L_0x0472
        L_0x046b:
            r28 = r11
            r20 = r15
            r3 = 177(0xb1, float:2.48E-43)
            r5 = 4
        L_0x0472:
            r4 = 2
            r6 = 25
            r1.f(r6, r4)
            java.lang.String r6 = com.alibaba.fastjson.util.ASMUtils.f(r9)
            r11 = 192(0xc0, float:2.69E-43)
            r1.c(r11, r6)
            r15 = r30
            int r6 = r2.g(r15)
            r7 = 58
            r1.f(r7, r6)
            r0.B(r9, r1, r13, r2)
            r1.i(r3)
            int r2 = r2.f14244f
            int r2 = r2 + r4
            r6 = 7
            r1.j(r6, r2)
            r1.l()
            int r1 = r23 + 1
            r7 = r35
            r14 = r5
            r6 = r10
            r10 = r18
            r15 = r20
            r8 = r27
            r11 = r28
            r16 = r31
            r23 = r32
            r12 = 177(0xb1, float:2.48E-43)
            r5 = r1
            goto L_0x0271
        L_0x04b5:
            r10 = r6
            r28 = r11
            r20 = r15
            r31 = r16
            r32 = r23
            r8 = 180(0xb4, float:2.52E-43)
            r11 = r2
            r15 = r3
            r6 = r4
            if (r20 != 0) goto L_0x053c
            com.alibaba.fastjson.serializer.ASMSerializerFactory$a r5 = new com.alibaba.fastjson.serializer.ASMSerializerFactory$a
            r16 = 0
            r1 = r5
            r2 = r13
            r3 = r35
            r4 = r10
            r11 = r5
            r5 = r16
            r6 = r24
            r1.<init>(r2, r3, r4, r5, r6)
            e2.d r1 = new e2.d
            r18 = 1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            java.lang.String r3 = f14225c
            r2.append(r3)
            r2.append(r12)
            java.lang.String r20 = r2.toString()
            r21 = 0
            java.lang.String[] r22 = new java.lang.String[]{r25}
            java.lang.String r19 = "writeUnsorted"
            r16 = r1
            r17 = r31
            r16.<init>(r17, r18, r19, r20, r21, r22)
            r2 = 25
            r4 = 1
            r1.f(r2, r4)
            java.lang.String r4 = f14229g
            r1.a(r8, r3, r7, r4)
            int r3 = r11.g(r7)
            r4 = 58
            r1.f(r4, r3)
            r3 = 2
            r1.f(r2, r3)
            java.lang.String r2 = com.alibaba.fastjson.util.ASMUtils.f(r9)
            r5 = 192(0xc0, float:2.69E-43)
            r1.c(r5, r2)
            int r2 = r11.g(r15)
            r1.f(r4, r2)
            r2 = r28
            r0.B(r9, r1, r2, r11)
            r2 = 177(0xb1, float:2.48E-43)
            r1.i(r2)
            int r2 = r11.f14244f
            int r2 = r2 + r3
            r11 = 7
            r1.j(r11, r2)
            r1.l()
            goto L_0x053d
        L_0x053c:
            r11 = r6
        L_0x053d:
            r5 = 3
            r6 = 0
        L_0x053f:
            if (r6 >= r5) goto L_0x05dc
            if (r6 != 0) goto L_0x054c
            java.lang.String r1 = "writeAsArray"
            r19 = r1
            r17 = r24
            r16 = 1
            goto L_0x0560
        L_0x054c:
            r1 = 1
            if (r6 != r1) goto L_0x0558
            java.lang.String r1 = "writeAsArrayNormal"
            r19 = r1
            r17 = r24
            r16 = 0
            goto L_0x0560
        L_0x0558:
            java.lang.String r1 = "writeAsArrayNonContext"
            r19 = r1
            r16 = 1
            r17 = 1
        L_0x0560:
            com.alibaba.fastjson.serializer.ASMSerializerFactory$a r4 = new com.alibaba.fastjson.serializer.ASMSerializerFactory$a
            r1 = r4
            r2 = r13
            r3 = r35
            r11 = r4
            r4 = r10
            r23 = r5
            r5 = r16
            r26 = r6
            r6 = r17
            r1.<init>(r2, r3, r4, r5, r6)
            e2.d r1 = new e2.d
            r18 = 1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            java.lang.String r3 = f14225c
            r2.append(r3)
            r2.append(r12)
            java.lang.String r20 = r2.toString()
            r21 = 0
            java.lang.String[] r22 = new java.lang.String[]{r25}
            r16 = r1
            r17 = r31
            r16.<init>(r17, r18, r19, r20, r21, r22)
            r2 = 25
            r4 = 1
            r1.f(r2, r4)
            java.lang.String r4 = f14229g
            r1.a(r8, r3, r7, r4)
            int r3 = r11.g(r7)
            r4 = 58
            r1.f(r4, r3)
            r3 = 2
            r1.f(r2, r3)
            java.lang.String r5 = com.alibaba.fastjson.util.ASMUtils.f(r9)
            r6 = 192(0xc0, float:2.69E-43)
            r1.c(r6, r5)
            int r5 = r11.g(r15)
            r1.f(r4, r5)
            r0.A(r9, r1, r13, r11)
            r5 = 177(0xb1, float:2.48E-43)
            r1.i(r5)
            int r11 = r11.f14244f
            int r11 = r11 + r3
            r2 = 7
            r1.j(r2, r11)
            r1.l()
            int r1 = r26 + 1
            r6 = r1
            r11 = r2
            r5 = r23
            goto L_0x053f
        L_0x05dc:
            byte[] r1 = r31.j()
            com.alibaba.fastjson.util.ASMClassLoader r2 = r0.f14234a
            int r3 = r1.length
            r4 = r32
            r5 = 0
            java.lang.Class r1 = r2.a(r4, r1, r5, r3)
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]
            r3[r5] = r27
            java.lang.reflect.Constructor r1 = r1.getConstructor(r3)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r5] = r35
            java.lang.Object r1 = r1.newInstance(r2)
            h2.h r1 = (h2.h) r1
            return r1
        L_0x05fe:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "unsupportd class "
            r2.append(r3)
            java.lang.String r3 = r9.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ASMSerializerFactory.z(h2.o):h2.h");
    }
}
