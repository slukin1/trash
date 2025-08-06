package g2;

import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.tencent.thumbplayer.tcmedia.core.common.TPPixelFormat;
import e2.d;
import e2.e;
import f2.a;
import f2.c;
import f2.f;
import f2.g;
import i2.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import org.jmrtd.cbeff.ISO781611;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final String f15790c = ASMUtils.f(f2.a.class);

    /* renamed from: d  reason: collision with root package name */
    public static final String f15791d = ASMUtils.f(c.class);

    /* renamed from: a  reason: collision with root package name */
    public final ASMClassLoader f15792a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f15793b = new AtomicLong();

    /* renamed from: g2.a$a  reason: collision with other inner class name */
    public static class C0081a {

        /* renamed from: a  reason: collision with root package name */
        public int f15794a = -1;

        /* renamed from: b  reason: collision with root package name */
        public final Map<String, Integer> f15795b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f15796c;

        /* renamed from: d  reason: collision with root package name */
        public final b f15797d;

        /* renamed from: e  reason: collision with root package name */
        public final String f15798e;

        /* renamed from: f  reason: collision with root package name */
        public i2.a[] f15799f;

        public C0081a(String str, ParserConfig parserConfig, b bVar, int i11) {
            this.f15798e = str;
            this.f15796c = bVar.f15983a;
            this.f15794a = i11;
            this.f15797d = bVar;
            this.f15799f = bVar.f15990h;
        }

        public Class<?> g() {
            Class<?> cls = this.f15797d.f15984b;
            return cls == null ? this.f15796c : cls;
        }

        public int h(String str) {
            if (this.f15795b.get(str) == null) {
                Map<String, Integer> map = this.f15795b;
                int i11 = this.f15794a;
                this.f15794a = i11 + 1;
                map.put(str, Integer.valueOf(i11));
            }
            return this.f15795b.get(str).intValue();
        }

        public int i(String str, int i11) {
            if (this.f15795b.get(str) == null) {
                this.f15795b.put(str, Integer.valueOf(this.f15794a));
                this.f15794a += i11;
            }
            return this.f15795b.get(str).intValue();
        }
    }

    public a(ClassLoader classLoader) {
        this.f15792a = classLoader instanceof ASMClassLoader ? (ASMClassLoader) classLoader : new ASMClassLoader(classLoader);
    }

    public final void a(C0081a aVar, e2.c cVar) {
        b(aVar, cVar, true);
    }

    public final void b(C0081a aVar, e2.c cVar, boolean z11) {
        int length = aVar.f15799f.length;
        for (int i11 = 0; i11 < length; i11++) {
            Label label = new Label();
            if (z11) {
                n(cVar, aVar, i11, label);
            }
            o(aVar, cVar, aVar.f15799f[i11]);
            if (z11) {
                cVar.d(label);
            }
        }
    }

    public final void c(ClassWriter classWriter, C0081a aVar) {
        if (Modifier.isPublic(aVar.f15797d.f15985c.getModifiers())) {
            d dVar = new d(classWriter, 1, "createInstance", "(L" + f15790c + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;", (String) null, (String[]) null);
            dVar.c(187, ASMUtils.f(aVar.g()));
            dVar.i(89);
            dVar.k(183, ASMUtils.f(aVar.g()), "<init>", "()V");
            dVar.i(176);
            dVar.j(3, 3);
            dVar.l();
        }
    }

    public final void d(C0081a aVar, e2.c cVar) {
        Class<k> cls = k.class;
        Constructor<?> constructor = aVar.f15797d.f15985c;
        if (Modifier.isPublic(constructor.getModifiers())) {
            cVar.c(187, ASMUtils.f(aVar.g()));
            cVar.i(89);
            cVar.k(183, ASMUtils.f(constructor.getDeclaringClass()), "<init>", "()V");
            cVar.f(58, aVar.h(DefaultSettingsSpiCall.INSTANCE_PARAM));
            return;
        }
        cVar.f(25, 0);
        cVar.f(25, 1);
        cVar.f(25, 0);
        cVar.a(180, ASMUtils.f(cls), "clazz", "Ljava/lang/Class;");
        String f11 = ASMUtils.f(cls);
        cVar.k(183, f11, "createInstance", "(L" + f15790c + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
        cVar.c(192, ASMUtils.f(aVar.g()));
        cVar.f(58, aVar.h(DefaultSettingsSpiCall.INSTANCE_PARAM));
    }

    public final void e(C0081a aVar, e2.c cVar, i2.a aVar2, Class<?> cls, int i11) {
        int i12;
        C0081a aVar3 = aVar;
        e2.c cVar2 = cVar;
        i2.a aVar4 = aVar2;
        Class<k> cls2 = k.class;
        l(aVar, cVar, aVar2);
        Label label = new Label();
        Label label2 = new Label();
        if ((aVar4.f15971k & Feature.SupportArrayToBean.mask) != 0) {
            cVar2.i(89);
            cVar2.c(193, ASMUtils.f(cls2));
            cVar2.e(153, label);
            cVar2.c(192, ASMUtils.f(cls2));
            cVar2.f(25, 1);
            if (aVar4.f15967g instanceof Class) {
                cVar2.b(e.d(ASMUtils.b(aVar4.f15966f)));
            } else {
                cVar2.f(25, 0);
                cVar2.b(Integer.valueOf(i11));
                cVar2.k(182, ASMUtils.f(cls2), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            }
            cVar2.b(aVar4.f15962b);
            cVar2.b(Integer.valueOf(aVar4.f15971k));
            cVar2.k(182, ASMUtils.f(cls2), "deserialze", "(L" + f15790c + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
            cVar2.c(192, ASMUtils.f(cls));
            cVar2.f(58, aVar3.h(aVar4.f15962b + "_asm"));
            cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label2);
            cVar2.d(label);
            i12 = 1;
        } else {
            i12 = 1;
        }
        cVar2.f(25, i12);
        if (aVar4.f15967g instanceof Class) {
            cVar2.b(e.d(ASMUtils.b(aVar4.f15966f)));
        } else {
            cVar2.f(25, 0);
            cVar2.b(Integer.valueOf(i11));
            cVar2.k(182, ASMUtils.f(cls2), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
        cVar2.b(aVar4.f15962b);
        cVar2.k(185, ASMUtils.f(l.class), "deserialze", "(L" + f15790c + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        cVar2.c(192, ASMUtils.f(cls));
        cVar2.f(58, aVar3.h(aVar4.f15962b + "_asm"));
        cVar2.d(label2);
    }

    public final void f(C0081a aVar, e2.c cVar, Label label) {
        cVar.h(21, aVar.h("matchedCount"));
        cVar.e(ISO781611.SMT_DO_DS, label);
        cVar.f(25, aVar.h("lexer"));
        cVar.k(182, f15791d, "token", "()I");
        cVar.b(13);
        cVar.e(160, label);
        r(aVar, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:97:0x0935  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(com.alibaba.fastjson.asm.ClassWriter r30, g2.a.C0081a r31) {
        /*
            r29 = this;
            r8 = r29
            r9 = r31
            java.lang.Class<f2.f> r0 = f2.f.class
            i2.a[] r1 = r31.f15799f
            int r1 = r1.length
            if (r1 != 0) goto L_0x000e
            return
        L_0x000e:
            i2.a[] r1 = r31.f15799f
            int r2 = r1.length
            r10 = 0
            r3 = r10
        L_0x0015:
            if (r3 >= r2) goto L_0x003f
            r4 = r1[r3]
            java.lang.Class<?> r5 = r4.f15966f
            java.lang.reflect.Type r4 = r4.f15967g
            java.lang.Class r6 = java.lang.Character.TYPE
            if (r5 != r6) goto L_0x0022
            return
        L_0x0022:
            java.lang.Class<java.util.Collection> r6 = java.util.Collection.class
            boolean r5 = r6.isAssignableFrom(r5)
            if (r5 == 0) goto L_0x003c
            boolean r5 = r4 instanceof java.lang.reflect.ParameterizedType
            if (r5 == 0) goto L_0x003b
            java.lang.reflect.ParameterizedType r4 = (java.lang.reflect.ParameterizedType) r4
            java.lang.reflect.Type[] r4 = r4.getActualTypeArguments()
            r4 = r4[r10]
            boolean r4 = r4 instanceof java.lang.Class
            if (r4 == 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            return
        L_0x003c:
            int r3 = r3 + 1
            goto L_0x0015
        L_0x003f:
            i2.b r1 = r31.f15797d
            i2.a[] r2 = r1.f15991i
            i2.a[] unused = r9.f15799f = r2
            e2.d r7 = new e2.d
            r13 = 1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "(L"
            r2.append(r6)
            java.lang.String r3 = f15790c
            r2.append(r3)
            java.lang.String r4 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;"
            r2.append(r4)
            java.lang.String r15 = r2.toString()
            r16 = 0
            r17 = 0
            java.lang.String r14 = "deserialze"
            r11 = r7
            r12 = r30
            r11.<init>(r12, r13, r14, r15, r16, r17)
            com.alibaba.fastjson.asm.Label r11 = new com.alibaba.fastjson.asm.Label
            r11.<init>()
            com.alibaba.fastjson.asm.Label r12 = new com.alibaba.fastjson.asm.Label
            r12.<init>()
            com.alibaba.fastjson.asm.Label r13 = new com.alibaba.fastjson.asm.Label
            r13.<init>()
            com.alibaba.fastjson.asm.Label r14 = new com.alibaba.fastjson.asm.Label
            r14.<init>()
            r8.x(r9, r7)
            com.alibaba.fastjson.asm.Label r2 = new com.alibaba.fastjson.asm.Label
            r2.<init>()
            java.lang.String r15 = "lexer"
            int r4 = r9.h(r15)
            r5 = 25
            r7.f(r5, r4)
            java.lang.String r4 = f15791d
            r10 = 182(0xb6, float:2.55E-43)
            java.lang.String r5 = "token"
            r17 = r14
            java.lang.String r14 = "()I"
            r7.k(r10, r4, r5, r14)
            r5 = 14
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r7.b(r5)
            r5 = 160(0xa0, float:2.24E-43)
            r7.e(r5, r2)
            int r1 = r1.f15992j
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean
            int r14 = r5.mask
            r1 = r1 & r14
            r14 = 21
            r10 = 4
            if (r1 != 0) goto L_0x00e3
            int r1 = r9.h(r15)
            r18 = r11
            r11 = 25
            r7.f(r11, r1)
            r7.f(r14, r10)
            int r1 = r5.mask
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r7.b(r1)
            java.lang.String r1 = "isEnabled"
            java.lang.String r5 = "(II)Z"
            r11 = 182(0xb6, float:2.55E-43)
            r7.k(r11, r4, r1, r5)
            r1 = 153(0x99, float:2.14E-43)
            r7.e(r1, r2)
            goto L_0x00e5
        L_0x00e3:
            r18 = r11
        L_0x00e5:
            r1 = 0
            r5 = 25
            r7.f(r5, r1)
            r11 = 1
            r7.f(r5, r11)
            r1 = 2
            r7.f(r5, r1)
            r14 = 3
            r7.f(r5, r14)
            r7.i(r11)
            r5 = 183(0xb7, float:2.56E-43)
            java.lang.String r1 = r31.f15798e
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r6)
            r10.append(r3)
            java.lang.String r14 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"
            r10.append(r14)
            java.lang.String r10 = r10.toString()
            java.lang.String r14 = "deserialzeArrayMapping"
            r7.k(r5, r1, r14, r10)
            r10 = 176(0xb0, float:2.47E-43)
            r7.i(r10)
            r7.d(r2)
            int r1 = r9.h(r15)
            r2 = 25
            r7.f(r2, r1)
            com.alibaba.fastjson.parser.Feature r1 = com.alibaba.fastjson.parser.Feature.SortFeidFastMatch
            int r1 = r1.mask
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r7.b(r1)
            java.lang.String r1 = "isEnabled"
            java.lang.String r5 = "(I)Z"
            r14 = 182(0xb6, float:2.55E-43)
            r7.k(r14, r4, r1, r5)
            r1 = 153(0x99, float:2.14E-43)
            r7.e(r1, r12)
            int r1 = r9.h(r15)
            r7.f(r2, r1)
            java.lang.Class r1 = r31.f15796c
            java.lang.String r1 = r1.getName()
            r7.b(r1)
            java.lang.String r1 = "scanType"
            java.lang.String r2 = "(Ljava/lang/String;)I"
            r7.k(r14, r4, r1, r2)
            r1 = -1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r7.b(r1)
            r14 = 159(0x9f, float:2.23E-43)
            r7.e(r14, r12)
            r1 = 25
            r7.f(r1, r11)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "()"
            r1.append(r2)
            java.lang.String r2 = com.alibaba.fastjson.util.ASMUtils.b(r0)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "getContext"
            r5 = 182(0xb6, float:2.55E-43)
            r7.k(r5, r3, r2, r1)
            java.lang.String r1 = "mark_context"
            int r1 = r9.h(r1)
            r5 = 58
            r7.f(r5, r1)
            r1 = 3
            r7.i(r1)
            java.lang.String r1 = "matchedCount"
            int r1 = r9.h(r1)
            r2 = 54
            r7.f(r2, r1)
            r8.d(r9, r7)
            r1 = 25
            r7.f(r1, r11)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r10 = "()"
            r1.append(r10)
            java.lang.String r10 = com.alibaba.fastjson.util.ASMUtils.b(r0)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            java.lang.String r10 = "getContext"
            r2 = 182(0xb6, float:2.55E-43)
            r7.k(r2, r3, r10, r1)
            java.lang.String r1 = "context"
            int r1 = r9.h(r1)
            r7.f(r5, r1)
            r1 = 25
            r7.f(r1, r11)
            java.lang.String r2 = "context"
            int r2 = r9.h(r2)
            r7.f(r1, r2)
            java.lang.String r2 = "instance"
            int r2 = r9.h(r2)
            r7.f(r1, r2)
            r2 = 3
            r7.f(r1, r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "("
            r1.append(r2)
            java.lang.String r2 = com.alibaba.fastjson.util.ASMUtils.b(r0)
            r1.append(r2)
            java.lang.String r2 = "Ljava/lang/Object;Ljava/lang/Object;)"
            r1.append(r2)
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.b(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "setContext"
            r2 = 182(0xb6, float:2.55E-43)
            r7.k(r2, r3, r1, r0)
            java.lang.String r0 = "childContext"
            int r0 = r9.h(r0)
            r7.f(r5, r0)
            int r0 = r9.h(r15)
            r1 = 25
            r7.f(r1, r0)
            r10 = 180(0xb4, float:2.52E-43)
            java.lang.String r3 = "matchStat"
            java.lang.String r2 = "I"
            r7.a(r10, r4, r3, r2)
            r0 = 4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r7.b(r1)
            r7.e(r14, r13)
            r0 = 3
            r7.i(r0)
            int r1 = r9.h(r3)
            r4 = 54
            r7.h(r4, r1)
            i2.a[] r1 = r31.f15799f
            int r4 = r1.length
            r1 = 0
        L_0x024d:
            if (r1 >= r4) goto L_0x0274
            r7.i(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r14 = "_asm_flag_"
            r0.append(r14)
            int r14 = r1 / 32
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            int r0 = r9.h(r0)
            r14 = 54
            r7.f(r14, r0)
            int r1 = r1 + 32
            r0 = 3
            r14 = 159(0x9f, float:2.23E-43)
            goto L_0x024d
        L_0x0274:
            int r0 = r9.h(r15)
            r1 = 25
            r7.f(r1, r0)
            com.alibaba.fastjson.parser.Feature r0 = com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty
            int r0 = r0.mask
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.b(r0)
            java.lang.String r0 = f15791d
            java.lang.String r1 = "isEnabled"
            java.lang.String r14 = "(I)Z"
            r10 = 182(0xb6, float:2.55E-43)
            r7.k(r10, r0, r1, r14)
            java.lang.String r0 = "initStringFieldAsEmpty"
            int r0 = r9.h(r0)
            r1 = 54
            r7.h(r1, r0)
            r0 = 0
        L_0x029f:
            java.lang.String r10 = "_asm"
            if (r0 >= r4) goto L_0x03e6
            i2.a[] r1 = r31.f15799f
            r1 = r1[r0]
            java.lang.Class<?> r14 = r1.f15966f
            java.lang.Class r5 = java.lang.Boolean.TYPE
            if (r14 == r5) goto L_0x03b1
            java.lang.Class r5 = java.lang.Byte.TYPE
            if (r14 == r5) goto L_0x03b1
            java.lang.Class r5 = java.lang.Short.TYPE
            if (r14 == r5) goto L_0x03b1
            java.lang.Class r5 = java.lang.Integer.TYPE
            if (r14 != r5) goto L_0x02bd
            goto L_0x03b1
        L_0x02bd:
            java.lang.Class r5 = java.lang.Long.TYPE
            if (r14 != r5) goto L_0x02eb
            r5 = 9
            r7.i(r5)
            r5 = 55
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r1 = r1.f15962b
            r14.append(r1)
            r14.append(r10)
            java.lang.String r1 = r14.toString()
            r10 = 2
            int r1 = r9.i(r1, r10)
            r7.f(r5, r1)
        L_0x02e1:
            r26 = r2
            r27 = r3
            r24 = r12
            r25 = r13
            goto L_0x03d7
        L_0x02eb:
            java.lang.Class r5 = java.lang.Float.TYPE
            if (r14 != r5) goto L_0x030f
            r5 = 11
            r7.i(r5)
            r5 = 56
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r1 = r1.f15962b
            r14.append(r1)
            r14.append(r10)
            java.lang.String r1 = r14.toString()
            int r1 = r9.h(r1)
            r7.f(r5, r1)
            goto L_0x02e1
        L_0x030f:
            java.lang.Class r5 = java.lang.Double.TYPE
            if (r14 != r5) goto L_0x0334
            r5 = 14
            r7.i(r5)
            r5 = 57
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r1 = r1.f15962b
            r14.append(r1)
            r14.append(r10)
            java.lang.String r1 = r14.toString()
            r10 = 2
            int r1 = r9.i(r1, r10)
            r7.f(r5, r1)
            goto L_0x02e1
        L_0x0334:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            if (r14 != r5) goto L_0x0381
            com.alibaba.fastjson.asm.Label r5 = new com.alibaba.fastjson.asm.Label
            r5.<init>()
            com.alibaba.fastjson.asm.Label r11 = new com.alibaba.fastjson.asm.Label
            r11.<init>()
            r24 = r12
            java.lang.String r12 = "initStringFieldAsEmpty"
            int r12 = r9.h(r12)
            r25 = r13
            r13 = 21
            r7.f(r13, r12)
            r12 = 153(0x99, float:2.14E-43)
            r7.e(r12, r11)
            r8.u(r7, r9, r0)
            int r12 = r9.h(r15)
            r13 = 25
            r7.f(r13, r12)
            java.lang.String r12 = f15791d
            java.lang.String r13 = "stringDefaultValue"
            r26 = r2
            java.lang.String r2 = "()Ljava/lang/String;"
            r27 = r3
            r3 = 182(0xb6, float:2.55E-43)
            r7.k(r3, r12, r13, r2)
            r2 = 167(0xa7, float:2.34E-43)
            r7.e(r2, r5)
            r7.d(r11)
            r2 = 1
            r7.i(r2)
            r7.d(r5)
            goto L_0x038d
        L_0x0381:
            r26 = r2
            r27 = r3
            r2 = r11
            r24 = r12
            r25 = r13
            r7.i(r2)
        L_0x038d:
            r2 = 192(0xc0, float:2.69E-43)
            java.lang.String r3 = com.alibaba.fastjson.util.ASMUtils.f(r14)
            r7.c(r2, r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = r1.f15962b
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = r2.toString()
            int r1 = r9.h(r1)
            r2 = 58
            r7.f(r2, r1)
            goto L_0x03d7
        L_0x03b1:
            r26 = r2
            r27 = r3
            r24 = r12
            r25 = r13
            r2 = 3
            r7.i(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = r1.f15962b
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = r2.toString()
            int r1 = r9.h(r1)
            r2 = 54
            r7.f(r2, r1)
        L_0x03d7:
            int r0 = r0 + 1
            r12 = r24
            r13 = r25
            r2 = r26
            r3 = r27
            r5 = 58
            r11 = 1
            goto L_0x029f
        L_0x03e6:
            r26 = r2
            r27 = r3
            r24 = r12
            r25 = r13
            r11 = 0
        L_0x03ef:
            if (r11 >= r4) goto L_0x09d5
            i2.a[] r0 = r31.f15799f
            r5 = r0[r11]
            java.lang.Class<?> r12 = r5.f15966f
            java.lang.reflect.Type r0 = r5.f15967g
            com.alibaba.fastjson.asm.Label r1 = new com.alibaba.fastjson.asm.Label
            r1.<init>()
            java.lang.Class r2 = java.lang.Boolean.TYPE
            java.lang.String r3 = "[C"
            java.lang.String r13 = "_asm_prefix__"
            if (r12 != r2) goto L_0x045a
            int r0 = r9.h(r15)
            r2 = 25
            r7.f(r2, r0)
            r0 = 0
            r7.f(r2, r0)
            java.lang.String r0 = r31.f15798e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = r5.f15962b
            r2.append(r12)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.a(r12, r0, r2, r3)
            java.lang.String r0 = f15791d
            java.lang.String r2 = "scanFieldBoolean"
            java.lang.String r3 = "([C)Z"
            r12 = 182(0xb6, float:2.55E-43)
            r7.k(r12, r0, r2, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r5.f15962b
            r0.append(r2)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.h(r0)
            r2 = 54
            r7.f(r2, r0)
        L_0x0454:
            r28 = r6
            r13 = 58
            goto L_0x0899
        L_0x045a:
            java.lang.Class r2 = java.lang.Byte.TYPE
            if (r12 != r2) goto L_0x04ab
            int r0 = r9.h(r15)
            r2 = 25
            r7.f(r2, r0)
            r0 = 0
            r7.f(r2, r0)
            java.lang.String r0 = r31.f15798e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = r5.f15962b
            r2.append(r12)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.a(r12, r0, r2, r3)
            java.lang.String r0 = f15791d
            java.lang.String r2 = "scanFieldInt"
            java.lang.String r3 = "([C)I"
            r12 = 182(0xb6, float:2.55E-43)
            r7.k(r12, r0, r2, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r5.f15962b
            r0.append(r2)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.h(r0)
            r2 = 54
            r7.f(r2, r0)
            goto L_0x0454
        L_0x04ab:
            java.lang.Class r2 = java.lang.Short.TYPE
            if (r12 != r2) goto L_0x04fd
            int r0 = r9.h(r15)
            r2 = 25
            r7.f(r2, r0)
            r0 = 0
            r7.f(r2, r0)
            java.lang.String r0 = r31.f15798e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = r5.f15962b
            r2.append(r12)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.a(r12, r0, r2, r3)
            java.lang.String r0 = f15791d
            java.lang.String r2 = "scanFieldInt"
            java.lang.String r3 = "([C)I"
            r12 = 182(0xb6, float:2.55E-43)
            r7.k(r12, r0, r2, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r5.f15962b
            r0.append(r2)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.h(r0)
            r2 = 54
            r7.f(r2, r0)
            goto L_0x0454
        L_0x04fd:
            java.lang.Class r2 = java.lang.Integer.TYPE
            if (r12 != r2) goto L_0x054f
            int r0 = r9.h(r15)
            r2 = 25
            r7.f(r2, r0)
            r0 = 0
            r7.f(r2, r0)
            java.lang.String r0 = r31.f15798e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = r5.f15962b
            r2.append(r12)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.a(r12, r0, r2, r3)
            java.lang.String r0 = f15791d
            java.lang.String r2 = "scanFieldInt"
            java.lang.String r3 = "([C)I"
            r12 = 182(0xb6, float:2.55E-43)
            r7.k(r12, r0, r2, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r5.f15962b
            r0.append(r2)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.h(r0)
            r2 = 54
            r7.f(r2, r0)
            goto L_0x0454
        L_0x054f:
            java.lang.Class r2 = java.lang.Long.TYPE
            if (r12 != r2) goto L_0x05a2
            int r0 = r9.h(r15)
            r2 = 25
            r7.f(r2, r0)
            r0 = 0
            r7.f(r2, r0)
            java.lang.String r0 = r31.f15798e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = r5.f15962b
            r2.append(r12)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.a(r12, r0, r2, r3)
            java.lang.String r0 = f15791d
            java.lang.String r2 = "scanFieldLong"
            java.lang.String r3 = "([C)J"
            r12 = 182(0xb6, float:2.55E-43)
            r7.k(r12, r0, r2, r3)
            r0 = 55
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r5.f15962b
            r2.append(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            r3 = 2
            int r2 = r9.i(r2, r3)
            r7.f(r0, r2)
            goto L_0x0454
        L_0x05a2:
            java.lang.Class r2 = java.lang.Float.TYPE
            if (r12 != r2) goto L_0x05f4
            int r0 = r9.h(r15)
            r2 = 25
            r7.f(r2, r0)
            r0 = 0
            r7.f(r2, r0)
            java.lang.String r0 = r31.f15798e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = r5.f15962b
            r2.append(r12)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.a(r12, r0, r2, r3)
            java.lang.String r0 = f15791d
            java.lang.String r2 = "scanFieldFloat"
            java.lang.String r3 = "([C)F"
            r12 = 182(0xb6, float:2.55E-43)
            r7.k(r12, r0, r2, r3)
            r0 = 56
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r5.f15962b
            r2.append(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            int r2 = r9.h(r2)
            r7.f(r0, r2)
            goto L_0x0454
        L_0x05f4:
            java.lang.Class r2 = java.lang.Double.TYPE
            if (r12 != r2) goto L_0x0647
            int r0 = r9.h(r15)
            r2 = 25
            r7.f(r2, r0)
            r0 = 0
            r7.f(r2, r0)
            java.lang.String r0 = r31.f15798e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = r5.f15962b
            r2.append(r12)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.a(r12, r0, r2, r3)
            java.lang.String r0 = f15791d
            java.lang.String r2 = "scanFieldDouble"
            java.lang.String r3 = "([C)D"
            r12 = 182(0xb6, float:2.55E-43)
            r7.k(r12, r0, r2, r3)
            r0 = 57
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r5.f15962b
            r2.append(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            r14 = 2
            int r2 = r9.i(r2, r14)
            r7.f(r0, r2)
            goto L_0x0454
        L_0x0647:
            r14 = 2
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            if (r12 != r2) goto L_0x069d
            int r0 = r9.h(r15)
            r2 = 25
            r7.f(r2, r0)
            r0 = 0
            r7.f(r2, r0)
            java.lang.String r0 = r31.f15798e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = r5.f15962b
            r2.append(r12)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.a(r12, r0, r2, r3)
            java.lang.String r0 = f15791d
            java.lang.String r2 = "scanFieldString"
            java.lang.String r3 = "([C)Ljava/lang/String;"
            r12 = 182(0xb6, float:2.55E-43)
            r7.k(r12, r0, r2, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r5.f15962b
            r0.append(r2)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.h(r0)
            r2 = 58
            r7.f(r2, r0)
        L_0x0698:
            r13 = r2
            r28 = r6
            goto L_0x0899
        L_0x069d:
            java.lang.Class<int[]> r2 = int[].class
            if (r12 != r2) goto L_0x06ee
            int r0 = r9.h(r15)
            r2 = 25
            r7.f(r2, r0)
            r0 = 0
            r7.f(r2, r0)
            java.lang.String r0 = r31.f15798e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = r5.f15962b
            r2.append(r12)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.a(r12, r0, r2, r3)
            java.lang.String r0 = f15791d
            java.lang.String r2 = "scanFieldIntArray"
            java.lang.String r3 = "([C)[I"
            r12 = 182(0xb6, float:2.55E-43)
            r7.k(r12, r0, r2, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r5.f15962b
            r0.append(r2)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.h(r0)
            r2 = 58
            r7.f(r2, r0)
            goto L_0x0698
        L_0x06ee:
            java.lang.Class<float[]> r2 = float[].class
            if (r12 != r2) goto L_0x0740
            int r0 = r9.h(r15)
            r2 = 25
            r7.f(r2, r0)
            r0 = 0
            r7.f(r2, r0)
            java.lang.String r0 = r31.f15798e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = r5.f15962b
            r2.append(r12)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.a(r12, r0, r2, r3)
            java.lang.String r0 = f15791d
            java.lang.String r2 = "scanFieldFloatArray"
            java.lang.String r3 = "([C)[F"
            r12 = 182(0xb6, float:2.55E-43)
            r7.k(r12, r0, r2, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r5.f15962b
            r0.append(r2)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.h(r0)
            r2 = 58
            r7.f(r2, r0)
            goto L_0x0698
        L_0x0740:
            java.lang.Class<float[][]> r2 = float[][].class
            if (r12 != r2) goto L_0x0792
            int r0 = r9.h(r15)
            r2 = 25
            r7.f(r2, r0)
            r0 = 0
            r7.f(r2, r0)
            java.lang.String r0 = r31.f15798e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = r5.f15962b
            r2.append(r12)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.a(r12, r0, r2, r3)
            java.lang.String r0 = f15791d
            java.lang.String r2 = "scanFieldFloatArray2"
            java.lang.String r3 = "([C)[[F"
            r12 = 182(0xb6, float:2.55E-43)
            r7.k(r12, r0, r2, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r5.f15962b
            r0.append(r2)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.h(r0)
            r2 = 58
            r7.f(r2, r0)
            goto L_0x0698
        L_0x0792:
            boolean r2 = r12.isEnum()
            if (r2 == 0) goto L_0x081b
            r2 = 0
            r14 = 25
            r7.f(r14, r2)
            int r0 = r9.h(r15)
            r7.f(r14, r0)
            r7.f(r14, r2)
            java.lang.String r0 = r31.f15798e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r14 = r5.f15962b
            r2.append(r14)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r13 = 180(0xb4, float:2.52E-43)
            r7.a(r13, r0, r2, r3)
            r8.l(r9, r7, r5)
            java.lang.Class<g2.k> r0 = g2.k.class
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.f(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            java.lang.String r3 = f15791d
            r2.append(r3)
            java.lang.String r3 = ";[C"
            r2.append(r3)
            java.lang.Class<g2.l> r3 = g2.l.class
            java.lang.String r3 = com.alibaba.fastjson.util.ASMUtils.b(r3)
            r2.append(r3)
            java.lang.String r3 = ")Ljava/lang/Enum;"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "scanEnum"
            r13 = 182(0xb6, float:2.55E-43)
            r7.k(r13, r0, r3, r2)
            r0 = 192(0xc0, float:2.69E-43)
            java.lang.String r2 = com.alibaba.fastjson.util.ASMUtils.f(r12)
            r7.c(r0, r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r5.f15962b
            r0.append(r2)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.h(r0)
            r2 = 58
            r7.f(r2, r0)
            goto L_0x0698
        L_0x081b:
            java.lang.Class<java.util.Collection> r2 = java.util.Collection.class
            boolean r2 = r2.isAssignableFrom(r12)
            if (r2 == 0) goto L_0x099a
            int r2 = r9.h(r15)
            r14 = 25
            r7.f(r14, r2)
            r2 = 0
            r7.f(r14, r2)
            java.lang.String r2 = r31.f15798e
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r28 = r6
            java.lang.String r6 = r5.f15962b
            r14.append(r6)
            r14.append(r13)
            java.lang.String r6 = r14.toString()
            r13 = 180(0xb4, float:2.52E-43)
            r7.a(r13, r2, r6, r3)
            java.lang.Class r6 = com.alibaba.fastjson.util.TypeUtils.F(r0)
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            if (r6 != r0) goto L_0x0961
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.b(r12)
            e2.e r0 = e2.e.d(r0)
            r7.b(r0)
            java.lang.String r0 = f15791d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "([CLjava/lang/Class;)"
            r2.append(r3)
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            java.lang.String r3 = com.alibaba.fastjson.util.ASMUtils.b(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "scanFieldStringArray"
            r6 = 182(0xb6, float:2.55E-43)
            r7.k(r6, r0, r3, r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r5.f15962b
            r0.append(r2)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.h(r0)
            r13 = 58
            r7.f(r13, r0)
        L_0x0899:
            int r0 = r9.h(r15)
            r2 = 25
            r7.f(r2, r0)
            java.lang.String r0 = f15791d
            r3 = r26
            r14 = r27
            r5 = 180(0xb4, float:2.52E-43)
            r7.a(r5, r0, r14, r3)
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            r12 = 158(0x9e, float:2.21E-43)
            r7.e(r12, r6)
            r8.u(r7, r9, r11)
            r7.d(r6)
            int r6 = r9.h(r15)
            r7.f(r2, r6)
            r7.a(r5, r0, r14, r3)
            r6 = 89
            r7.i(r6)
            int r6 = r9.h(r14)
            r12 = 54
            r7.f(r12, r6)
            r6 = -1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.b(r6)
            r6 = r18
            r12 = 159(0x9f, float:2.23E-43)
            r7.e(r12, r6)
            int r12 = r9.h(r15)
            r7.f(r2, r12)
            r7.a(r5, r0, r14, r3)
            r2 = 158(0x9e, float:2.21E-43)
            r7.e(r2, r1)
            java.lang.String r2 = "matchedCount"
            int r2 = r9.h(r2)
            r5 = 21
            r7.f(r5, r2)
            r2 = 4
            r7.i(r2)
            r5 = 96
            r7.i(r5)
            java.lang.String r5 = "matchedCount"
            int r5 = r9.h(r5)
            r12 = 54
            r7.f(r12, r5)
            int r5 = r9.h(r15)
            r13 = 25
            r7.f(r13, r5)
            r5 = 180(0xb4, float:2.52E-43)
            r7.a(r5, r0, r14, r3)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r2)
            r7.b(r12)
            r12 = r17
            r2 = 159(0x9f, float:2.23E-43)
            r7.e(r2, r12)
            r7.d(r1)
            int r1 = r4 + -1
            if (r11 != r1) goto L_0x094c
            int r1 = r9.h(r15)
            r7.f(r13, r1)
            r7.a(r5, r0, r14, r3)
            r0 = 4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r7.b(r1)
            r0 = 160(0xa0, float:2.24E-43)
            r7.e(r0, r6)
        L_0x094c:
            r17 = r2
            r21 = r3
            r26 = r4
            r18 = r5
            r19 = r10
            r13 = r12
            r12 = r28
            r22 = 54
            r23 = 58
            r10 = r7
            r7 = r6
            goto L_0x09c3
        L_0x0961:
            r13 = r17
            r1 = r18
            r3 = r26
            r14 = r27
            r2 = 159(0x9f, float:2.23E-43)
            r17 = 54
            r18 = 180(0xb4, float:2.52E-43)
            r0 = r29
            r20 = r1
            r19 = r10
            r10 = 2
            r1 = r31
            r21 = r3
            r22 = r17
            r17 = r2
            r2 = r7
            r3 = r20
            r26 = r4
            r4 = r5
            r10 = 25
            r23 = 58
            r5 = r12
            r12 = r28
            r10 = r7
            r7 = r11
            r0.i(r1, r2, r3, r4, r5, r6, r7)
            int r4 = r26 + -1
            r7 = r20
            if (r11 != r4) goto L_0x09c3
            r8.f(r9, r10, r7)
            goto L_0x09c3
        L_0x099a:
            r19 = r10
            r13 = r17
            r21 = r26
            r14 = r27
            r17 = 159(0x9f, float:2.23E-43)
            r22 = 54
            r23 = 58
            r26 = r4
            r10 = r7
            r7 = r18
            r18 = 180(0xb4, float:2.52E-43)
            r0 = r29
            r1 = r31
            r2 = r10
            r3 = r7
            r4 = r5
            r5 = r12
            r12 = r6
            r6 = r11
            r0.j(r1, r2, r3, r4, r5, r6)
            int r4 = r26 + -1
            if (r11 != r4) goto L_0x09c3
            r8.f(r9, r10, r7)
        L_0x09c3:
            int r11 = r11 + 1
            r18 = r7
            r7 = r10
            r6 = r12
            r17 = r13
            r27 = r14
            r10 = r19
            r4 = r26
            r26 = r21
            goto L_0x03ef
        L_0x09d5:
            r26 = r4
            r12 = r6
            r10 = r7
            r13 = r17
            r7 = r18
            r10.d(r13)
            java.lang.Class r0 = r31.f15796c
            boolean r0 = r0.isInterface()
            if (r0 != 0) goto L_0x09fb
            java.lang.Class r0 = r31.f15796c
            int r0 = r0.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isAbstract(r0)
            if (r0 != 0) goto L_0x09fb
            r8.a(r9, r10)
        L_0x09fb:
            r0 = r25
            r10.d(r0)
            r8.t(r9, r10)
            java.lang.String r0 = "instance"
            int r0 = r9.h(r0)
            r1 = 25
            r10.f(r1, r0)
            i2.b r0 = r31.f15797d
            java.lang.reflect.Method r0 = r0.f15988f
            if (r0 == 0) goto L_0x0a40
            java.lang.Class r1 = r31.g()
            java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.f(r1)
            java.lang.String r2 = r0.getName()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "()"
            r3.append(r4)
            java.lang.Class r0 = r0.getReturnType()
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.b(r0)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r3 = 182(0xb6, float:2.55E-43)
            r10.k(r3, r1, r2, r0)
        L_0x0a40:
            r0 = 176(0xb0, float:2.47E-43)
            r10.i(r0)
            r10.d(r7)
            r8.a(r9, r10)
            r0 = 0
            r1 = 25
            r10.f(r1, r0)
            r0 = 1
            r10.f(r1, r0)
            r0 = 2
            r10.f(r1, r0)
            r0 = 3
            r10.f(r1, r0)
            java.lang.String r0 = "instance"
            int r0 = r9.h(r0)
            r10.f(r1, r0)
            r0 = 21
            r1 = 4
            r10.f(r0, r1)
            int r4 = r26 / 32
            if (r26 == 0) goto L_0x0a76
            int r0 = r26 % 32
            if (r0 == 0) goto L_0x0a76
            int r4 = r4 + 1
        L_0x0a76:
            r0 = 1
            if (r4 != r0) goto L_0x0a7e
            r0 = 4
            r10.i(r0)
            goto L_0x0a83
        L_0x0a7e:
            r0 = 16
            r10.h(r0, r4)
        L_0x0a83:
            r0 = 188(0xbc, float:2.63E-43)
            r1 = 10
            r10.h(r0, r1)
            r1 = 0
        L_0x0a8b:
            if (r1 >= r4) goto L_0x0ac8
            r0 = 89
            r10.i(r0)
            if (r1 != 0) goto L_0x0a99
            r0 = 3
            r10.i(r0)
            goto L_0x0aa6
        L_0x0a99:
            r0 = 1
            if (r1 != r0) goto L_0x0aa1
            r0 = 4
            r10.i(r0)
            goto L_0x0aa6
        L_0x0aa1:
            r0 = 16
            r10.h(r0, r1)
        L_0x0aa6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "_asm_flag_"
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            int r0 = r9.h(r0)
            r2 = 21
            r10.f(r2, r0)
            r0 = 79
            r10.i(r0)
            int r1 = r1 + 1
            goto L_0x0a8b
        L_0x0ac8:
            java.lang.Class<g2.k> r0 = g2.k.class
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.f(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r12)
            java.lang.String r2 = f15790c
            r1.append(r2)
            java.lang.String r3 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;I[I)Ljava/lang/Object;"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "parseRest"
            r4 = 182(0xb6, float:2.55E-43)
            r10.k(r4, r0, r3, r1)
            r0 = 192(0xc0, float:2.69E-43)
            java.lang.Class r1 = r31.f15796c
            java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.f(r1)
            r10.c(r0, r1)
            r0 = 176(0xb0, float:2.47E-43)
            r10.i(r0)
            r0 = r24
            r10.d(r0)
            r0 = 0
            r1 = 25
            r10.f(r1, r0)
            r0 = 1
            r10.f(r1, r0)
            r0 = 2
            r10.f(r1, r0)
            r0 = 3
            r10.f(r1, r0)
            r0 = 21
            r1 = 4
            r10.f(r0, r1)
            r0 = 183(0xb7, float:2.56E-43)
            java.lang.Class<g2.k> r1 = g2.k.class
            java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.f(r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r12)
            r3.append(r2)
            java.lang.String r2 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "deserialze"
            r10.k(r0, r1, r3, r2)
            r0 = 176(0xb0, float:2.47E-43)
            r10.i(r0)
            r0 = 10
            int r1 = r31.f15794a
            r10.j(r0, r1)
            r10.l()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.a.g(com.alibaba.fastjson.asm.ClassWriter, g2.a$a):void");
    }

    public final void h(ClassWriter classWriter, C0081a aVar) {
        Class<k> cls;
        int i11;
        d dVar;
        C0081a aVar2 = aVar;
        Class<k> cls2 = k.class;
        d dVar2 = new d(classWriter, 1, "deserialzeArrayMapping", "(L" + f15790c + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", (String) null, (String[]) null);
        x(aVar2, dVar2);
        d(aVar2, dVar2);
        i2.a[] aVarArr = aVar.f15797d.f15991i;
        int length = aVarArr.length;
        int i12 = 0;
        while (i12 < length) {
            boolean z11 = i12 == length + -1;
            int i13 = z11 ? 93 : 44;
            int i14 = length;
            i2.a aVar3 = aVarArr[i12];
            i2.a[] aVarArr2 = aVarArr;
            Class<?> cls3 = aVar3.f15966f;
            boolean z12 = z11;
            Type type = aVar3.f15967g;
            String str = "setToken";
            String str2 = "next";
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                dVar = dVar2;
                cls = cls2;
                i11 = i12;
                dVar.f(25, aVar2.h("lexer"));
                dVar.f(16, i13);
                dVar.k(182, f15791d, "scanInt", "(C)I");
                dVar.f(54, aVar2.h(aVar3.f15962b + "_asm"));
            } else {
                if (cls3 == Long.TYPE) {
                    dVar2.f(25, aVar2.h("lexer"));
                    dVar2.f(16, i13);
                    dVar2.k(182, f15791d, "scanLong", "(C)J");
                    dVar2.f(55, aVar2.i(aVar3.f15962b + "_asm", 2));
                } else if (cls3 == Boolean.TYPE) {
                    dVar2.f(25, aVar2.h("lexer"));
                    dVar2.f(16, i13);
                    dVar2.k(182, f15791d, "scanBoolean", "(C)Z");
                    dVar2.f(54, aVar2.h(aVar3.f15962b + "_asm"));
                } else if (cls3 == Float.TYPE) {
                    dVar2.f(25, aVar2.h("lexer"));
                    dVar2.f(16, i13);
                    dVar2.k(182, f15791d, "scanFloat", "(C)F");
                    dVar2.f(56, aVar2.h(aVar3.f15962b + "_asm"));
                } else if (cls3 == Double.TYPE) {
                    dVar2.f(25, aVar2.h("lexer"));
                    dVar2.f(16, i13);
                    dVar2.k(182, f15791d, "scanDouble", "(C)D");
                    dVar2.f(57, aVar2.i(aVar3.f15962b + "_asm", 2));
                } else if (cls3 == Character.TYPE) {
                    dVar2.f(25, aVar2.h("lexer"));
                    dVar2.f(16, i13);
                    dVar2.k(182, f15791d, "scanString", "(C)Ljava/lang/String;");
                    dVar2.i(3);
                    dVar2.k(182, "java/lang/String", "charAt", "(I)C");
                    dVar2.f(54, aVar2.h(aVar3.f15962b + "_asm"));
                } else {
                    String str3 = "(I)V";
                    if (cls3 == String.class) {
                        dVar2.f(25, aVar2.h("lexer"));
                        dVar2.f(16, i13);
                        dVar2.k(182, f15791d, "scanString", "(C)Ljava/lang/String;");
                        dVar2.f(58, aVar2.h(aVar3.f15962b + "_asm"));
                    } else if (cls3.isEnum()) {
                        Label label = new Label();
                        Label label2 = new Label();
                        Label label3 = new Label();
                        int i15 = i12;
                        Label label4 = new Label();
                        cls = cls2;
                        dVar2.f(25, aVar2.h("lexer"));
                        String str4 = f15791d;
                        dVar2.k(182, str4, "getCurrent", "()C");
                        dVar2.i(89);
                        dVar2.f(54, aVar2.h("ch"));
                        dVar2.b(110);
                        dVar2.e(159, label4);
                        dVar2.f(21, aVar2.h("ch"));
                        dVar2.b(34);
                        dVar2.e(160, label);
                        dVar2.d(label4);
                        dVar2.f(25, aVar2.h("lexer"));
                        dVar2.b(e.d(ASMUtils.b(cls3)));
                        dVar2.f(25, 1);
                        String str5 = f15790c;
                        dVar2.k(182, str5, "getSymbolTable", "()" + ASMUtils.b(g.class));
                        dVar2.f(16, i13);
                        dVar2.k(182, str4, "scanEnum", "(Ljava/lang/Class;" + ASMUtils.b(g.class) + "C)Ljava/lang/Enum;");
                        dVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label3);
                        dVar2.d(label);
                        dVar2.f(21, aVar2.h("ch"));
                        dVar2.b(48);
                        dVar2.e(161, label2);
                        dVar2.f(21, aVar2.h("ch"));
                        dVar2.b(57);
                        dVar2.e(163, label2);
                        l(aVar2, dVar2, aVar3);
                        dVar2.c(192, ASMUtils.f(e.class));
                        dVar2.f(25, aVar2.h("lexer"));
                        dVar2.f(16, i13);
                        dVar2.k(182, str4, "scanInt", "(C)I");
                        dVar2.k(182, ASMUtils.f(e.class), "valueOf", "(I)Ljava/lang/Enum;");
                        dVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label3);
                        dVar2.d(label2);
                        dVar2.f(25, 0);
                        dVar2.f(25, aVar2.h("lexer"));
                        dVar2.f(16, i13);
                        String f11 = ASMUtils.f(cls);
                        dVar2.k(182, f11, "scanEnum", "(L" + str4 + ";C)Ljava/lang/Enum;");
                        dVar2.d(label3);
                        dVar2.c(192, ASMUtils.f(cls3));
                        dVar2.f(58, aVar2.h(aVar3.f15962b + "_asm"));
                        dVar = dVar2;
                        i11 = i15;
                    } else {
                        cls = cls2;
                        int i16 = i12;
                        if (Collection.class.isAssignableFrom(cls3)) {
                            Class<?> F = TypeUtils.F(type);
                            if (F == String.class) {
                                if (cls3 == List.class || cls3 == Collections.class || cls3 == ArrayList.class) {
                                    dVar2.c(187, ASMUtils.f(ArrayList.class));
                                    dVar2.i(89);
                                    dVar2.k(183, ASMUtils.f(ArrayList.class), "<init>", "()V");
                                } else {
                                    dVar2.b(e.d(ASMUtils.b(cls3)));
                                    dVar2.k(184, ASMUtils.f(TypeUtils.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                                }
                                dVar2.f(58, aVar2.h(aVar3.f15962b + "_asm"));
                                dVar2.f(25, aVar2.h("lexer"));
                                dVar2.f(25, aVar2.h(aVar3.f15962b + "_asm"));
                                dVar2.f(16, i13);
                                String str6 = f15791d;
                                dVar2.k(182, str6, "scanStringArray", "(Ljava/util/Collection;C)V");
                                Label label5 = new Label();
                                dVar2.f(25, aVar2.h("lexer"));
                                dVar2.a(180, str6, "matchStat", "I");
                                dVar2.b(5);
                                dVar2.e(160, label5);
                                dVar2.i(1);
                                dVar2.f(58, aVar2.h(aVar3.f15962b + "_asm"));
                                dVar2.d(label5);
                                i11 = i16;
                            } else {
                                Label label6 = new Label();
                                dVar2.f(25, aVar2.h("lexer"));
                                String str7 = f15791d;
                                dVar2.k(182, str7, "token", "()I");
                                dVar2.f(54, aVar2.h("token"));
                                dVar2.f(21, aVar2.h("token"));
                                dVar2.b(Integer.valueOf(i16 == 0 ? 14 : 16));
                                dVar2.e(159, label6);
                                dVar2.f(25, 1);
                                dVar2.f(21, aVar2.h("token"));
                                String str8 = f15790c;
                                String str9 = str3;
                                dVar2.k(182, str8, "throwException", str9);
                                dVar2.d(label6);
                                Label label7 = new Label();
                                Label label8 = new Label();
                                Class<?> cls4 = F;
                                dVar2.f(25, aVar2.h("lexer"));
                                dVar2.k(182, str7, "getCurrent", "()C");
                                dVar2.f(16, 91);
                                dVar2.e(160, label7);
                                dVar2.f(25, aVar2.h("lexer"));
                                dVar2.k(182, str7, str2, "()C");
                                dVar2.i(87);
                                dVar2.f(25, aVar2.h("lexer"));
                                dVar2.b(14);
                                dVar2.k(182, str7, str, str9);
                                dVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label8);
                                dVar2.d(label7);
                                dVar2.f(25, aVar2.h("lexer"));
                                dVar2.b(14);
                                dVar2.k(182, str7, "nextToken", str9);
                                dVar2.d(label8);
                                i11 = i16;
                                p(dVar2, cls3, i11, false);
                                dVar2.i(89);
                                dVar2.f(58, aVar2.h(aVar3.f15962b + "_asm"));
                                Class<?> cls5 = cls4;
                                k(aVar2, dVar2, aVar3, cls5);
                                dVar2.f(25, 1);
                                dVar2.b(e.d(ASMUtils.b(cls5)));
                                dVar2.f(25, 3);
                                String f12 = ASMUtils.f(cls);
                                dVar2.k(184, f12, "parseArray", "(Ljava/util/Collection;" + ASMUtils.b(l.class) + "L" + str8 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                            }
                        } else {
                            String str10 = str3;
                            i11 = i16;
                            if (cls3.isArray()) {
                                dVar2.f(25, aVar2.h("lexer"));
                                dVar2.b(14);
                                dVar2.k(182, f15791d, "nextToken", str10);
                                dVar2.f(25, 1);
                                dVar2.f(25, 0);
                                dVar2.b(Integer.valueOf(i11));
                                dVar2.k(182, ASMUtils.f(cls), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                                dVar2.k(182, f15790c, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                                dVar2.c(192, ASMUtils.f(cls3));
                                dVar2.f(58, aVar2.h(aVar3.f15962b + "_asm"));
                            } else {
                                Label label9 = new Label();
                                Label label10 = new Label();
                                if (cls3 == Date.class) {
                                    dVar2.f(25, aVar2.h("lexer"));
                                    String str11 = f15791d;
                                    dVar2.k(182, str11, "getCurrent", "()C");
                                    dVar2.b(49);
                                    dVar2.e(160, label9);
                                    dVar2.c(187, ASMUtils.f(Date.class));
                                    dVar2.i(89);
                                    dVar2.f(25, aVar2.h("lexer"));
                                    dVar2.f(16, i13);
                                    dVar2.k(182, str11, "scanLong", "(C)J");
                                    dVar2.k(183, ASMUtils.f(Date.class), "<init>", "(J)V");
                                    dVar2.f(58, aVar2.h(aVar3.f15962b + "_asm"));
                                    dVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label10);
                                }
                                dVar2.d(label9);
                                q(aVar2, dVar2, 14);
                                Class<?> cls6 = cls3;
                                dVar = dVar2;
                                e(aVar, dVar2, aVar3, cls6, i11);
                                dVar.f(25, 0);
                                dVar.f(25, aVar2.h("lexer"));
                                if (!z12) {
                                    dVar.b(16);
                                } else {
                                    dVar.b(15);
                                }
                                String f13 = ASMUtils.f(cls);
                                dVar.k(183, f13, "check", "(" + ASMUtils.b(f2.b.class) + "I)V");
                                dVar.d(label10);
                            }
                        }
                        dVar = dVar2;
                    }
                }
                dVar = dVar2;
                cls = cls2;
                i11 = i12;
            }
            i12 = i11 + 1;
            dVar2 = dVar;
            length = i14;
            aVarArr = aVarArr2;
            cls2 = cls;
        }
        String str12 = "next";
        String str13 = "lexer";
        d dVar3 = dVar2;
        b(aVar2, dVar3, false);
        Label label11 = new Label();
        Label label12 = new Label();
        Label label13 = new Label();
        Label label14 = new Label();
        dVar3.f(25, aVar2.h(str13));
        String str14 = f15791d;
        dVar3.k(182, str14, "getCurrent", "()C");
        dVar3.i(89);
        dVar3.f(54, aVar2.h("ch"));
        dVar3.f(16, 44);
        dVar3.e(160, label12);
        dVar3.f(25, aVar2.h(str13));
        dVar3.k(182, str14, str12, "()C");
        dVar3.i(87);
        dVar3.f(25, aVar2.h(str13));
        dVar3.b(16);
        dVar3.k(182, str14, "setToken", "(I)V");
        dVar3.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label14);
        dVar3.d(label12);
        dVar3.f(21, aVar2.h("ch"));
        dVar3.f(16, 93);
        dVar3.e(160, label13);
        dVar3.f(25, aVar2.h(str13));
        dVar3.k(182, str14, str12, "()C");
        dVar3.i(87);
        dVar3.f(25, aVar2.h(str13));
        dVar3.b(15);
        dVar3.k(182, str14, "setToken", "(I)V");
        dVar3.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label14);
        dVar3.d(label13);
        dVar3.f(21, aVar2.h("ch"));
        dVar3.f(16, 26);
        dVar3.e(160, label11);
        dVar3.f(25, aVar2.h(str13));
        dVar3.k(182, str14, str12, "()C");
        dVar3.i(87);
        dVar3.f(25, aVar2.h(str13));
        dVar3.b(20);
        dVar3.k(182, str14, "setToken", "(I)V");
        dVar3.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label14);
        dVar3.d(label11);
        dVar3.f(25, aVar2.h(str13));
        dVar3.b(16);
        dVar3.k(182, str14, "nextToken", "(I)V");
        dVar3.d(label14);
        dVar3.f(25, aVar2.h(DefaultSettingsSpiCall.INSTANCE_PARAM));
        dVar3.i(176);
        dVar3.j(5, aVar.f15794a);
        dVar3.l();
    }

    public final void i(C0081a aVar, e2.c cVar, Label label, i2.a aVar2, Class<?> cls, Class<?> cls2, int i11) {
        String str;
        Label label2;
        String str2;
        String str3;
        String str4;
        int i12;
        String str5;
        C0081a aVar3 = aVar;
        e2.c cVar2 = cVar;
        Label label3 = label;
        i2.a aVar4 = aVar2;
        Class<?> cls3 = cls;
        Class<?> cls4 = cls2;
        int i13 = i11;
        Label label4 = new Label();
        String str6 = f15791d;
        cVar2.k(182, str6, "matchField", "([C)Z");
        cVar2.e(153, label4);
        u(cVar2, aVar3, i13);
        Label label5 = new Label();
        cVar2.f(25, aVar3.h("lexer"));
        cVar2.k(182, str6, "token", "()I");
        cVar2.b(8);
        cVar2.e(160, label5);
        Class<l> cls5 = l.class;
        cVar2.f(25, aVar3.h("lexer"));
        cVar2.b(16);
        cVar2.k(182, str6, "nextToken", "(I)V");
        cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label4);
        cVar2.d(label5);
        Label label6 = new Label();
        Label label7 = new Label();
        Label label8 = label4;
        Label label9 = new Label();
        cVar2.f(25, aVar3.h("lexer"));
        cVar2.k(182, str6, "token", "()I");
        cVar2.b(21);
        cVar2.e(160, label7);
        cVar2.f(25, aVar3.h("lexer"));
        cVar2.b(14);
        cVar2.k(182, str6, "nextToken", "(I)V");
        p(cVar2, cls3, i13, true);
        cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label6);
        cVar2.d(label7);
        cVar2.f(25, aVar3.h("lexer"));
        cVar2.k(182, str6, "token", "()I");
        cVar2.b(14);
        cVar2.e(159, label9);
        cVar2.f(25, aVar3.h("lexer"));
        cVar2.k(182, str6, "token", "()I");
        cVar2.b(12);
        cVar2.e(160, label);
        p(cVar2, cls3, i13, false);
        StringBuilder sb2 = new StringBuilder();
        i2.a aVar5 = aVar2;
        String str7 = "token";
        sb2.append(aVar5.f15962b);
        sb2.append("_asm");
        cVar2.f(58, aVar3.h(sb2.toString()));
        Class<?> cls6 = cls2;
        k(aVar3, cVar2, aVar5, cls6);
        String str8 = "nextToken";
        cVar2.f(25, 1);
        cVar2.b(e.d(ASMUtils.b(cls2)));
        cVar2.i(3);
        String str9 = str6;
        String str10 = "(I)V";
        cVar2.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String f11 = ASMUtils.f(cls5);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("(L");
        String str11 = f15790c;
        sb3.append(str11);
        sb3.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        String str12 = str11;
        cVar2.k(185, f11, "deserialze", sb3.toString());
        cVar2.f(58, aVar3.h("list_item_value"));
        cVar2.f(25, aVar3.h(aVar5.f15962b + "_asm"));
        cVar2.f(25, aVar3.h("list_item_value"));
        if (cls.isInterface()) {
            str = "list_item_value";
            cVar2.k(185, ASMUtils.f(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            str = "list_item_value";
            cVar2.k(182, ASMUtils.f(cls), "add", "(Ljava/lang/Object;)Z");
        }
        cVar2.i(87);
        Label label10 = label8;
        cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label10);
        cVar2.d(label9);
        p(cVar2, cls3, i13, false);
        cVar2.d(label6);
        cVar2.f(58, aVar3.h(aVar5.f15962b + "_asm"));
        boolean n11 = ParserConfig.n(aVar5.f15966f);
        k(aVar3, cVar2, aVar5, cls6);
        if (n11) {
            cVar2.k(185, ASMUtils.f(cls5), "getFastMatchToken", "()I");
            cVar2.f(54, aVar3.h("fastMatchToken"));
            cVar2.f(25, aVar3.h("lexer"));
            cVar2.f(21, aVar3.h("fastMatchToken"));
            str2 = str8;
            str4 = str9;
            str3 = str10;
            cVar2.k(182, str4, str2, str3);
            label2 = label10;
        } else {
            str2 = str8;
            str4 = str9;
            str3 = str10;
            cVar2.i(87);
            cVar2.b(12);
            label2 = label10;
            cVar2.f(54, aVar3.h("fastMatchToken"));
            q(aVar3, cVar2, 12);
        }
        cVar2.f(25, 1);
        String str13 = str3;
        String str14 = str12;
        cVar2.k(182, str14, "getContext", "()" + ASMUtils.b(f.class));
        cVar2.f(58, aVar3.h("listContext"));
        cVar2.f(25, 1);
        cVar2.f(25, aVar3.h(aVar5.f15962b + "_asm"));
        cVar2.b(aVar5.f15962b);
        cVar2.k(182, str14, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.b(f.class));
        cVar2.i(87);
        Label label11 = new Label();
        Label label12 = new Label();
        cVar2.i(3);
        String str15 = str2;
        cVar2.f(54, aVar3.h("i"));
        cVar2.d(label11);
        cVar2.f(25, aVar3.h("lexer"));
        String str16 = str7;
        cVar2.k(182, str4, str16, "()I");
        cVar2.b(15);
        cVar2.e(159, label12);
        Label label13 = label12;
        cVar2.f(25, 0);
        String e11 = aVar.f15798e;
        StringBuilder sb4 = new StringBuilder();
        String str17 = "fastMatchToken";
        sb4.append(aVar5.f15962b);
        sb4.append("_asm_list_item_deser__");
        boolean z11 = n11;
        cVar2.a(180, e11, sb4.toString(), ASMUtils.b(cls5));
        cVar2.f(25, 1);
        cVar2.b(e.d(ASMUtils.b(cls2)));
        cVar2.f(21, aVar3.h("i"));
        cVar2.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String f12 = ASMUtils.f(cls5);
        cVar2.k(185, f12, "deserialze", "(L" + str14 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        String str18 = str;
        cVar2.f(58, aVar3.h(str18));
        cVar2.g(aVar3.h("i"), 1);
        cVar2.f(25, aVar3.h(aVar5.f15962b + "_asm"));
        cVar2.f(25, aVar3.h(str18));
        if (cls.isInterface()) {
            cVar2.k(185, ASMUtils.f(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            cVar2.k(182, ASMUtils.f(cls), "add", "(Ljava/lang/Object;)Z");
        }
        cVar2.i(87);
        cVar2.f(25, 1);
        cVar2.f(25, aVar3.h(aVar5.f15962b + "_asm"));
        cVar2.k(182, str14, "checkListResolve", "(Ljava/util/Collection;)V");
        cVar2.f(25, aVar3.h("lexer"));
        cVar2.k(182, str4, str16, "()I");
        cVar2.b(16);
        cVar2.e(160, label11);
        if (z11) {
            cVar2.f(25, aVar3.h("lexer"));
            cVar2.f(21, aVar3.h(str17));
            cVar2.k(182, str4, str15, str13);
            i12 = TPPixelFormat.TP_PIX_FMT_MEDIACODEC;
            str5 = str14;
        } else {
            str5 = str14;
            q(aVar3, cVar2, 12);
            i12 = TPPixelFormat.TP_PIX_FMT_MEDIACODEC;
        }
        cVar2.e(i12, label11);
        cVar2.d(label13);
        cVar2.f(25, 1);
        cVar2.f(25, aVar3.h("listContext"));
        cVar2.k(182, str5, "setContext", "(" + ASMUtils.b(f.class) + ")V");
        cVar2.f(25, aVar3.h("lexer"));
        cVar2.k(182, str4, str16, "()I");
        cVar2.b(15);
        cVar2.e(160, label);
        r(aVar, cVar);
        cVar2.d(label2);
    }

    public final void j(C0081a aVar, e2.c cVar, Label label, i2.a aVar2, Class<?> cls, int i11) {
        C0081a aVar3 = aVar;
        e2.c cVar2 = cVar;
        i2.a aVar4 = aVar2;
        Class<i> cls2 = i.class;
        Class<f> cls3 = f.class;
        Class<a.C0078a> cls4 = a.C0078a.class;
        Label label2 = new Label();
        Label label3 = new Label();
        cVar2.f(25, aVar3.h("lexer"));
        cVar2.f(25, 0);
        String e11 = aVar.f15798e;
        cVar2.a(180, e11, aVar4.f15962b + "_asm_prefix__", "[C");
        cVar2.k(182, f15791d, "matchField", "([C)Z");
        cVar2.e(154, label2);
        cVar2.i(1);
        cVar2.f(58, aVar3.h(aVar4.f15962b + "_asm"));
        cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label3);
        cVar2.d(label2);
        u(cVar2, aVar3, i11);
        cVar2.f(21, aVar3.h("matchedCount"));
        cVar2.i(4);
        cVar2.i(96);
        cVar2.f(54, aVar3.h("matchedCount"));
        e(aVar, cVar, aVar2, cls, i11);
        cVar2.f(25, 1);
        String str = f15790c;
        cVar2.k(182, str, "getResolveStatus", "()I");
        cVar2.b(1);
        cVar2.e(160, label3);
        cVar2.f(25, 1);
        cVar2.k(182, str, "getLastResolveTask", "()" + ASMUtils.b(cls4));
        cVar2.f(58, aVar3.h("resolveTask"));
        cVar2.f(25, aVar3.h("resolveTask"));
        cVar2.f(25, 1);
        cVar2.k(182, str, "getContext", "()" + ASMUtils.b(cls3));
        cVar2.a(181, ASMUtils.f(cls4), "ownerContext", ASMUtils.b(cls3));
        cVar2.f(25, aVar3.h("resolveTask"));
        cVar2.f(25, 0);
        cVar2.b(aVar4.f15962b);
        String f11 = ASMUtils.f(k.class);
        cVar2.k(182, f11, "getFieldDeserializer", "(Ljava/lang/String;)" + ASMUtils.b(cls2));
        cVar2.a(181, ASMUtils.f(cls4), "fieldDeserializer", ASMUtils.b(cls2));
        cVar2.f(25, 1);
        cVar2.b(0);
        cVar2.k(182, str, "setResolveStatus", "(I)V");
        cVar2.d(label3);
    }

    public final void k(C0081a aVar, e2.c cVar, i2.a aVar2, Class<?> cls) {
        Class<ParserConfig> cls2 = ParserConfig.class;
        Class<l> cls3 = l.class;
        Label label = new Label();
        cVar.f(25, 0);
        String e11 = aVar.f15798e;
        cVar.a(180, e11, aVar2.f15962b + "_asm_list_item_deser__", ASMUtils.b(cls3));
        cVar.e(199, label);
        cVar.f(25, 0);
        cVar.f(25, 1);
        String str = f15790c;
        cVar.k(182, str, "getConfig", "()" + ASMUtils.b(cls2));
        cVar.b(e.d(ASMUtils.b(cls)));
        String f11 = ASMUtils.f(cls2);
        cVar.k(182, f11, "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.b(cls3));
        String e12 = aVar.f15798e;
        cVar.a(181, e12, aVar2.f15962b + "_asm_list_item_deser__", ASMUtils.b(cls3));
        cVar.d(label);
        cVar.f(25, 0);
        String e13 = aVar.f15798e;
        cVar.a(180, e13, aVar2.f15962b + "_asm_list_item_deser__", ASMUtils.b(cls3));
    }

    public final void l(C0081a aVar, e2.c cVar, i2.a aVar2) {
        Class<ParserConfig> cls = ParserConfig.class;
        Class<l> cls2 = l.class;
        Label label = new Label();
        cVar.f(25, 0);
        String e11 = aVar.f15798e;
        cVar.a(180, e11, aVar2.f15962b + "_asm_deser__", ASMUtils.b(cls2));
        cVar.e(199, label);
        cVar.f(25, 0);
        cVar.f(25, 1);
        String str = f15790c;
        cVar.k(182, str, "getConfig", "()" + ASMUtils.b(cls));
        cVar.b(e.d(ASMUtils.b(aVar2.f15966f)));
        String f11 = ASMUtils.f(cls);
        cVar.k(182, f11, "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.b(cls2));
        String e12 = aVar.f15798e;
        cVar.a(181, e12, aVar2.f15962b + "_asm_deser__", ASMUtils.b(cls2));
        cVar.d(label);
        cVar.f(25, 0);
        String e13 = aVar.f15798e;
        cVar.a(180, e13, aVar2.f15962b + "_asm_deser__", ASMUtils.b(cls2));
    }

    public final void m(ClassWriter classWriter, C0081a aVar) {
        ClassWriter classWriter2 = classWriter;
        Class<l> cls = l.class;
        Class<b> cls2 = b.class;
        Class<ParserConfig> cls3 = ParserConfig.class;
        for (i2.a aVar2 : aVar.f15799f) {
            new e2.a(classWriter2, 1, aVar2.f15962b + "_asm_prefix__", "[C").c();
        }
        for (i2.a aVar3 : aVar.f15799f) {
            Class<?> cls4 = aVar3.f15966f;
            if (!cls4.isPrimitive()) {
                if (Collection.class.isAssignableFrom(cls4)) {
                    new e2.a(classWriter2, 1, aVar3.f15962b + "_asm_list_item_deser__", ASMUtils.b(cls)).c();
                } else {
                    new e2.a(classWriter2, 1, aVar3.f15962b + "_asm_deser__", ASMUtils.b(cls)).c();
                }
            }
        }
        d dVar = new d(classWriter, 1, "<init>", "(" + ASMUtils.b(cls3) + ASMUtils.b(cls2) + ")V", (String) null, (String[]) null);
        dVar.f(25, 0);
        dVar.f(25, 1);
        dVar.f(25, 2);
        dVar.k(183, ASMUtils.f(k.class), "<init>", "(" + ASMUtils.b(cls3) + ASMUtils.b(cls2) + ")V");
        int length = aVar.f15799f.length;
        for (int i11 = 0; i11 < length; i11++) {
            i2.a aVar4 = aVar.f15799f[i11];
            dVar.f(25, 0);
            dVar.b("\"" + aVar4.f15962b + "\":");
            dVar.k(182, "java/lang/String", "toCharArray", "()[C");
            dVar.a(181, aVar.f15798e, aVar4.f15962b + "_asm_prefix__", "[C");
        }
        dVar.i(177);
        dVar.j(4, 4);
        dVar.l();
    }

    public final void n(e2.c cVar, C0081a aVar, int i11, Label label) {
        cVar.f(21, aVar.h("_asm_flag_" + (i11 / 32)));
        cVar.b(Integer.valueOf(1 << i11));
        cVar.i(126);
        cVar.e(153, label);
    }

    public final void o(C0081a aVar, e2.c cVar, i2.a aVar2) {
        Class<String> cls = String.class;
        Class<?> cls2 = aVar2.f15966f;
        Type type = aVar2.f15967g;
        if (cls2 == Boolean.TYPE) {
            cVar.f(25, aVar.h(DefaultSettingsSpiCall.INSTANCE_PARAM));
            cVar.f(21, aVar.h(aVar2.f15962b + "_asm"));
            s(aVar, cVar, aVar2);
        } else if (cls2 == Byte.TYPE || cls2 == Short.TYPE || cls2 == Integer.TYPE || cls2 == Character.TYPE) {
            cVar.f(25, aVar.h(DefaultSettingsSpiCall.INSTANCE_PARAM));
            cVar.f(21, aVar.h(aVar2.f15962b + "_asm"));
            s(aVar, cVar, aVar2);
        } else if (cls2 == Long.TYPE) {
            cVar.f(25, aVar.h(DefaultSettingsSpiCall.INSTANCE_PARAM));
            cVar.f(22, aVar.i(aVar2.f15962b + "_asm", 2));
            if (aVar2.f15963c != null) {
                cVar.k(182, ASMUtils.f(aVar.g()), aVar2.f15963c.getName(), ASMUtils.c(aVar2.f15963c));
                if (!aVar2.f15963c.getReturnType().equals(Void.TYPE)) {
                    cVar.i(87);
                    return;
                }
                return;
            }
            cVar.a(181, ASMUtils.f(aVar2.f15968h), aVar2.f15964d.getName(), ASMUtils.b(aVar2.f15966f));
        } else if (cls2 == Float.TYPE) {
            cVar.f(25, aVar.h(DefaultSettingsSpiCall.INSTANCE_PARAM));
            cVar.f(23, aVar.h(aVar2.f15962b + "_asm"));
            s(aVar, cVar, aVar2);
        } else if (cls2 == Double.TYPE) {
            cVar.f(25, aVar.h(DefaultSettingsSpiCall.INSTANCE_PARAM));
            cVar.f(24, aVar.i(aVar2.f15962b + "_asm", 2));
            s(aVar, cVar, aVar2);
        } else if (cls2 == cls) {
            cVar.f(25, aVar.h(DefaultSettingsSpiCall.INSTANCE_PARAM));
            cVar.f(25, aVar.h(aVar2.f15962b + "_asm"));
            s(aVar, cVar, aVar2);
        } else if (cls2.isEnum()) {
            cVar.f(25, aVar.h(DefaultSettingsSpiCall.INSTANCE_PARAM));
            cVar.f(25, aVar.h(aVar2.f15962b + "_asm"));
            s(aVar, cVar, aVar2);
        } else if (Collection.class.isAssignableFrom(cls2)) {
            cVar.f(25, aVar.h(DefaultSettingsSpiCall.INSTANCE_PARAM));
            if (TypeUtils.F(type) == cls) {
                cVar.f(25, aVar.h(aVar2.f15962b + "_asm"));
                cVar.c(192, ASMUtils.f(cls2));
            } else {
                cVar.f(25, aVar.h(aVar2.f15962b + "_asm"));
            }
            s(aVar, cVar, aVar2);
        } else {
            cVar.f(25, aVar.h(DefaultSettingsSpiCall.INSTANCE_PARAM));
            cVar.f(25, aVar.h(aVar2.f15962b + "_asm"));
            s(aVar, cVar, aVar2);
        }
    }

    public final void p(e2.c cVar, Class<?> cls, int i11, boolean z11) {
        if (cls.isAssignableFrom(ArrayList.class) && !z11) {
            cVar.c(187, "java/util/ArrayList");
            cVar.i(89);
            cVar.k(183, "java/util/ArrayList", "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedList.class) && !z11) {
            cVar.c(187, ASMUtils.f(LinkedList.class));
            cVar.i(89);
            cVar.k(183, ASMUtils.f(LinkedList.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(HashSet.class)) {
            cVar.c(187, ASMUtils.f(HashSet.class));
            cVar.i(89);
            cVar.k(183, ASMUtils.f(HashSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            cVar.c(187, ASMUtils.f(TreeSet.class));
            cVar.i(89);
            cVar.k(183, ASMUtils.f(TreeSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            cVar.c(187, ASMUtils.f(LinkedHashSet.class));
            cVar.i(89);
            cVar.k(183, ASMUtils.f(LinkedHashSet.class), "<init>", "()V");
        } else if (z11) {
            cVar.c(187, ASMUtils.f(HashSet.class));
            cVar.i(89);
            cVar.k(183, ASMUtils.f(HashSet.class), "<init>", "()V");
        } else {
            cVar.f(25, 0);
            cVar.b(Integer.valueOf(i11));
            cVar.k(182, ASMUtils.f(k.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            cVar.k(184, ASMUtils.f(TypeUtils.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
        }
        cVar.c(192, ASMUtils.f(cls));
    }

    public final void q(C0081a aVar, e2.c cVar, int i11) {
        Label label = new Label();
        Label label2 = new Label();
        cVar.f(25, aVar.h("lexer"));
        String str = f15791d;
        cVar.k(182, str, "getCurrent", "()C");
        if (i11 == 12) {
            cVar.f(16, 123);
        } else if (i11 == 14) {
            cVar.f(16, 91);
        } else {
            throw new IllegalStateException();
        }
        cVar.e(160, label);
        cVar.f(25, aVar.h("lexer"));
        cVar.k(182, str, "next", "()C");
        cVar.i(87);
        cVar.f(25, aVar.h("lexer"));
        cVar.b(Integer.valueOf(i11));
        cVar.k(182, str, "setToken", "(I)V");
        cVar.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label2);
        cVar.d(label);
        cVar.f(25, aVar.h("lexer"));
        cVar.b(Integer.valueOf(i11));
        cVar.k(182, str, "nextToken", "(I)V");
        cVar.d(label2);
    }

    public final void r(C0081a aVar, e2.c cVar) {
        C0081a aVar2 = aVar;
        e2.c cVar2 = cVar;
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        cVar2.f(25, aVar2.h("lexer"));
        String str = f15791d;
        cVar2.k(182, str, "getCurrent", "()C");
        cVar2.i(89);
        cVar2.f(54, aVar2.h("ch"));
        cVar2.f(16, 44);
        cVar2.e(160, label2);
        cVar2.f(25, aVar2.h("lexer"));
        cVar2.k(182, str, "next", "()C");
        cVar2.i(87);
        cVar2.f(25, aVar2.h("lexer"));
        cVar2.b(16);
        cVar2.k(182, str, "setToken", "(I)V");
        cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label5);
        cVar2.d(label2);
        cVar2.f(21, aVar2.h("ch"));
        cVar2.f(16, 125);
        cVar2.e(160, label3);
        cVar2.f(25, aVar2.h("lexer"));
        cVar2.k(182, str, "next", "()C");
        cVar2.i(87);
        cVar2.f(25, aVar2.h("lexer"));
        cVar2.b(13);
        cVar2.k(182, str, "setToken", "(I)V");
        cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label5);
        cVar2.d(label3);
        cVar2.f(21, aVar2.h("ch"));
        cVar2.f(16, 93);
        cVar2.e(160, label4);
        cVar2.f(25, aVar2.h("lexer"));
        cVar2.k(182, str, "next", "()C");
        cVar2.i(87);
        cVar2.f(25, aVar2.h("lexer"));
        cVar2.b(15);
        cVar2.k(182, str, "setToken", "(I)V");
        cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label5);
        cVar2.d(label4);
        cVar2.f(21, aVar2.h("ch"));
        cVar2.f(16, 26);
        cVar2.e(160, label);
        cVar2.f(25, aVar2.h("lexer"));
        cVar2.b(20);
        cVar2.k(182, str, "setToken", "(I)V");
        cVar2.e(TPPixelFormat.TP_PIX_FMT_MEDIACODEC, label5);
        cVar2.d(label);
        cVar2.f(25, aVar2.h("lexer"));
        cVar2.k(182, str, "nextToken", "()V");
        cVar2.d(label5);
    }

    public final void s(C0081a aVar, e2.c cVar, i2.a aVar2) {
        Method method = aVar2.f15963c;
        if (method != null) {
            cVar.k(method.getDeclaringClass().isInterface() ? 185 : 182, ASMUtils.f(aVar2.f15968h), method.getName(), ASMUtils.c(method));
            if (!aVar2.f15963c.getReturnType().equals(Void.TYPE)) {
                cVar.i(87);
                return;
            }
            return;
        }
        cVar.a(181, ASMUtils.f(aVar2.f15968h), aVar2.f15964d.getName(), ASMUtils.b(aVar2.f15966f));
    }

    public final void t(C0081a aVar, e2.c cVar) {
        Class<f> cls = f.class;
        cVar.f(25, 1);
        cVar.f(25, aVar.h("context"));
        String str = f15790c;
        cVar.k(182, str, "setContext", "(" + ASMUtils.b(cls) + ")V");
        Label label = new Label();
        cVar.f(25, aVar.h("childContext"));
        cVar.e(198, label);
        cVar.f(25, aVar.h("childContext"));
        cVar.f(25, aVar.h(DefaultSettingsSpiCall.INSTANCE_PARAM));
        cVar.a(181, ASMUtils.f(cls), "object", "Ljava/lang/Object;");
        cVar.d(label);
    }

    public final void u(e2.c cVar, C0081a aVar, int i11) {
        String str = "_asm_flag_" + (i11 / 32);
        cVar.f(21, aVar.h(str));
        cVar.b(Integer.valueOf(1 << i11));
        cVar.i(128);
        cVar.f(54, aVar.h(str));
    }

    public l v(ParserConfig parserConfig, b bVar) throws Exception {
        Class<?> cls = bVar.f15983a;
        if (!cls.isPrimitive()) {
            String str = "FastjsonASMDeserializer_" + this.f15793b.incrementAndGet() + "_" + cls.getSimpleName();
            String name = a.class.getPackage().getName();
            String str2 = name.replace('.', '/') + "/" + str;
            String str3 = name + InstructionFileId.DOT + str;
            ClassWriter classWriter = new ClassWriter();
            classWriter.k(49, 33, str2, ASMUtils.f(k.class), (String[]) null);
            m(classWriter, new C0081a(str2, parserConfig, bVar, 3));
            c(classWriter, new C0081a(str2, parserConfig, bVar, 3));
            g(classWriter, new C0081a(str2, parserConfig, bVar, 5));
            h(classWriter, new C0081a(str2, parserConfig, bVar, 4));
            byte[] j11 = classWriter.j();
            return (l) w(str3, j11, 0, j11.length).getConstructor(new Class[]{ParserConfig.class, b.class}).newInstance(new Object[]{parserConfig, bVar});
        }
        throw new IllegalArgumentException("not support type :" + cls.getName());
    }

    public final Class<?> w(String str, byte[] bArr, int i11, int i12) {
        return this.f15792a.a(str, bArr, i11, i12);
    }

    public final void x(C0081a aVar, e2.c cVar) {
        cVar.f(25, 1);
        cVar.a(180, f15790c, "lexer", ASMUtils.b(f2.b.class));
        cVar.c(192, f15791d);
        cVar.f(58, aVar.h("lexer"));
    }
}
