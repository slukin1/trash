package com.sumsub.sentry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.r;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001d2\u00020\u0001:\u0002\b\u0014B+\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f¢\u0006\u0004\b\u0016\u0010\u0017B;\b\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0016\u0010\u001cJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J%\u0010\b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\b\u0010\u000eJ\u0012\u0010\b\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007R\u001c\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u001c\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sentry/j0;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/StackTraceElement;", "elements", "", "Lcom/sumsub/sentry/h0;", "([Ljava/lang/StackTraceElement;)Ljava/util/List;", "", "className", "", "Ljava/util/List;", "inAppExcludes", "b", "inAppIncludes", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class j0 {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f30399a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f30400b;

    public static final class a implements d0<j0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30401a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30402b;

        static {
            a aVar = new a();
            f30401a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SentryStackTraceFactory", aVar, 2);
            pluginGeneratedSerialDescriptor.k("inAppExcludes", true);
            pluginGeneratedSerialDescriptor.k("inAppIncludes", true);
            f30402b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public j0 deserialize(c cVar) {
            int i11;
            Object obj;
            Object obj2;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                v1 v1Var = v1.f57779a;
                obj2 = b11.j(descriptor, 0, new e(v1Var), null);
                obj = b11.j(descriptor, 1, new e(v1Var), null);
                i11 = 3;
            } else {
                obj2 = null;
                Object obj3 = null;
                int i12 = 0;
                boolean z11 = true;
                while (z11) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        z11 = false;
                    } else if (w11 == 0) {
                        obj2 = b11.j(descriptor, 0, new e(v1.f57779a), obj2);
                        i12 |= 1;
                    } else if (w11 == 1) {
                        obj3 = b11.j(descriptor, 1, new e(v1.f57779a), obj3);
                        i12 |= 2;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                obj = obj3;
                i11 = i12;
            }
            b11.c(descriptor);
            return new j0(i11, (List) obj2, (List) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(new e(v1Var)), h10.a.u(new e(v1Var))};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30402b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, j0 j0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            j0.a(j0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<j0> serializer() {
            return a.f30401a;
        }

        public b() {
        }
    }

    public j0() {
        this((List) null, (List) null, 3, (r) null);
    }

    public static final void a(j0 j0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || j0Var.f30399a != null) {
            bVar.y(fVar, 0, new e(v1.f57779a), j0Var.f30399a);
        }
        if (bVar.q(fVar, 1) || j0Var.f30400b != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 1, new e(v1.f57779a), j0Var.f30400b);
        }
    }

    public /* synthetic */ j0(int i11, List list, List list2, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30401a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f30399a = null;
        } else {
            this.f30399a = list;
        }
        if ((i11 & 2) == 0) {
            this.f30400b = null;
        } else {
            this.f30400b = list2;
        }
    }

    public final List<h0> a(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        if (stackTraceElementArr2 != null) {
            if (!(stackTraceElementArr2.length == 0)) {
                ArrayList arrayList = new ArrayList();
                Iterator a11 = h.a(stackTraceElementArr);
                while (a11.hasNext()) {
                    StackTraceElement stackTraceElement = (StackTraceElement) a11.next();
                    String className = stackTraceElement.getClassName();
                    boolean a12 = a(className);
                    String methodName = stackTraceElement.getMethodName();
                    String fileName = stackTraceElement.getFileName();
                    Integer valueOf = Integer.valueOf(stackTraceElement.getLineNumber());
                    h0 h0Var = r6;
                    h0 h0Var2 = new h0((List) null, (List) null, (Map) null, (List) null, fileName, methodName, className, valueOf.intValue() >= 0 ? valueOf : null, (Integer) null, (String) null, (String) null, Boolean.valueOf(a12), (String) null, Boolean.valueOf(stackTraceElement.isNativeMethod()), (String) null, (String) null, (String) null, (String) null, (String) null, 513807, (r) null);
                    arrayList.add(h0Var);
                }
                CollectionsKt___CollectionsJvmKt.O(arrayList);
                return arrayList;
            }
        }
        return null;
    }

    public j0(List<String> list, List<String> list2) {
        this.f30399a = list;
        this.f30400b = list2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j0(List list, List list2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : list2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035 A[LOOP:1: B:18:0x0035->B:21:0x0045, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 == 0) goto L_0x0048
            int r1 = r7.length()
            r2 = 0
            if (r1 != 0) goto L_0x000c
            r1 = r0
            goto L_0x000d
        L_0x000c:
            r1 = r2
        L_0x000d:
            if (r1 == 0) goto L_0x0010
            goto L_0x0048
        L_0x0010:
            java.util.List<java.lang.String> r1 = r6.f30400b
            r3 = 0
            r4 = 2
            if (r1 == 0) goto L_0x002d
            java.util.Iterator r1 = r1.iterator()
        L_0x001a:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x002d
            java.lang.Object r5 = r1.next()
            java.lang.String r5 = (java.lang.String) r5
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.M(r7, r5, r2, r4, r3)
            if (r5 == 0) goto L_0x001a
            return r0
        L_0x002d:
            java.util.List<java.lang.String> r0 = r6.f30399a
            if (r0 == 0) goto L_0x0047
            java.util.Iterator r0 = r0.iterator()
        L_0x0035:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.M(r7, r1, r2, r4, r3)
            if (r1 == 0) goto L_0x0035
        L_0x0047:
            return r2
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.j0.a(java.lang.String):boolean");
    }
}
