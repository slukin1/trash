package kotlinx.serialization.json.internal;

import com.iproov.sdk.bridge.OptionsBridge;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.a;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.b;
import kotlinx.serialization.json.g;
import kotlinx.serialization.json.n;
import kotlinx.serialization.json.t;

public final class JsonTreeReader {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractJsonLexer f57880a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f57881b;

    /* renamed from: c  reason: collision with root package name */
    public int f57882c;

    public JsonTreeReader(JsonConfiguration jsonConfiguration, AbstractJsonLexer abstractJsonLexer) {
        this.f57880a = abstractJsonLexer;
        this.f57881b = jsonConfiguration.m();
    }

    public final g e() {
        g gVar;
        byte E = this.f57880a.E();
        if (E == 1) {
            return j(true);
        }
        if (E == 0) {
            return j(false);
        }
        if (E == 6) {
            int i11 = this.f57882c + 1;
            this.f57882c = i11;
            if (i11 == 200) {
                gVar = g();
            } else {
                gVar = i();
            }
            this.f57882c--;
            return gVar;
        } else if (E == 8) {
            return f();
        } else {
            AbstractJsonLexer.y(this.f57880a, "Cannot begin reading element, unexpected token: " + E, 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public final g f() {
        byte m11 = this.f57880a.m();
        if (this.f57880a.E() != 4) {
            ArrayList arrayList = new ArrayList();
            while (this.f57880a.f()) {
                arrayList.add(e());
                m11 = this.f57880a.m();
                if (m11 != 4) {
                    AbstractJsonLexer abstractJsonLexer = this.f57880a;
                    boolean z11 = m11 == 9;
                    int a11 = abstractJsonLexer.f57852a;
                    if (!z11) {
                        AbstractJsonLexer.y(abstractJsonLexer, "Expected end of the array or comma", a11, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            if (m11 == 8) {
                this.f57880a.n((byte) 9);
            } else if (m11 == 4) {
                AbstractJsonLexer.y(this.f57880a, "Unexpected trailing comma", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
            return new b(arrayList);
        }
        AbstractJsonLexer.y(this.f57880a, "Unexpected leading comma", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final g g() {
        return (g) kotlin.b.b(new a(new JsonTreeReader$readDeepRecursive$1(this, (c<? super JsonTreeReader$readDeepRecursive$1>) null)), Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(kotlin.c<kotlin.Unit, kotlinx.serialization.json.g> r21, kotlin.coroutines.c<? super kotlinx.serialization.json.g> r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            boolean r2 = r1 instanceof kotlinx.serialization.json.internal.JsonTreeReader$readObject$2
            if (r2 == 0) goto L_0x0017
            r2 = r1
            kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 r2 = (kotlinx.serialization.json.internal.JsonTreeReader$readObject$2) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 r2 = new kotlinx.serialization.json.internal.JsonTreeReader$readObject$2
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.label
            r5 = 7
            r6 = 6
            r7 = 1
            r8 = 4
            if (r4 == 0) goto L_0x004d
            if (r4 != r7) goto L_0x0045
            java.lang.Object r4 = r2.L$3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r9 = r2.L$2
            java.util.LinkedHashMap r9 = (java.util.LinkedHashMap) r9
            java.lang.Object r10 = r2.L$1
            kotlinx.serialization.json.internal.JsonTreeReader r10 = (kotlinx.serialization.json.internal.JsonTreeReader) r10
            java.lang.Object r11 = r2.L$0
            kotlin.c r11 = (kotlin.c) r11
            kotlin.k.b(r1)
            r18 = r3
            r3 = r2
            r2 = r18
            goto L_0x00a6
        L_0x0045:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004d:
            kotlin.k.b(r1)
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r0.f57880a
            byte r1 = r1.n(r6)
            kotlinx.serialization.json.internal.AbstractJsonLexer r4 = r0.f57880a
            byte r4 = r4.E()
            if (r4 == r8) goto L_0x00ef
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            r10 = r0
            r9 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r21
        L_0x006a:
            kotlinx.serialization.json.internal.AbstractJsonLexer r11 = r10.f57880a
            boolean r11 = r11.f()
            if (r11 == 0) goto L_0x00ce
            boolean r2 = r10.f57881b
            if (r2 == 0) goto L_0x007d
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r10.f57880a
            java.lang.String r2 = r2.s()
            goto L_0x0083
        L_0x007d:
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r10.f57880a
            java.lang.String r2 = r2.q()
        L_0x0083:
            kotlinx.serialization.json.internal.AbstractJsonLexer r11 = r10.f57880a
            r12 = 5
            r11.n(r12)
            kotlin.Unit r11 = kotlin.Unit.f56620a
            r3.L$0 = r1
            r3.L$1 = r10
            r3.L$2 = r9
            r3.L$3 = r2
            r3.label = r7
            java.lang.Object r11 = r1.b(r11, r3)
            if (r11 != r4) goto L_0x009c
            return r4
        L_0x009c:
            r18 = r11
            r11 = r1
            r1 = r18
            r19 = r4
            r4 = r2
            r2 = r19
        L_0x00a6:
            kotlinx.serialization.json.g r1 = (kotlinx.serialization.json.g) r1
            r9.put(r4, r1)
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r10.f57880a
            byte r1 = r1.m()
            if (r1 == r8) goto L_0x00ca
            if (r1 != r5) goto L_0x00b7
            r2 = r1
            goto L_0x00ce
        L_0x00b7:
            kotlinx.serialization.json.internal.AbstractJsonLexer r12 = r10.f57880a
            r14 = 0
            r15 = 0
            r16 = 6
            r17 = 0
            java.lang.String r13 = "Expected end of the object or comma"
            kotlinx.serialization.json.internal.AbstractJsonLexer.y(r12, r13, r14, r15, r16, r17)
            kotlin.KotlinNothingValueException r1 = new kotlin.KotlinNothingValueException
            r1.<init>()
            throw r1
        L_0x00ca:
            r4 = r2
            r2 = r1
            r1 = r11
            goto L_0x006a
        L_0x00ce:
            if (r2 != r6) goto L_0x00d6
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r10.f57880a
            r1.n(r5)
            goto L_0x00d8
        L_0x00d6:
            if (r2 == r8) goto L_0x00de
        L_0x00d8:
            kotlinx.serialization.json.JsonObject r1 = new kotlinx.serialization.json.JsonObject
            r1.<init>(r9)
            return r1
        L_0x00de:
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r10.f57880a
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            java.lang.String r3 = "Unexpected trailing comma"
            kotlinx.serialization.json.internal.AbstractJsonLexer.y(r2, r3, r4, r5, r6, r7)
            kotlin.KotlinNothingValueException r1 = new kotlin.KotlinNothingValueException
            r1.<init>()
            throw r1
        L_0x00ef:
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r0.f57880a
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            java.lang.String r3 = "Unexpected leading comma"
            kotlinx.serialization.json.internal.AbstractJsonLexer.y(r2, r3, r4, r5, r6, r7)
            kotlin.KotlinNothingValueException r1 = new kotlin.KotlinNothingValueException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonTreeReader.h(kotlin.c, kotlin.coroutines.c):java.lang.Object");
    }

    public final g i() {
        byte n11 = this.f57880a.n((byte) 6);
        if (this.f57880a.E() != 4) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                if (!this.f57880a.f()) {
                    break;
                }
                String s11 = this.f57881b ? this.f57880a.s() : this.f57880a.q();
                this.f57880a.n((byte) 5);
                linkedHashMap.put(s11, e());
                n11 = this.f57880a.m();
                if (n11 != 4) {
                    if (n11 != 7) {
                        AbstractJsonLexer.y(this.f57880a, "Expected end of the object or comma", 0, (String) null, 6, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            if (n11 == 6) {
                this.f57880a.n((byte) 7);
            } else if (n11 == 4) {
                AbstractJsonLexer.y(this.f57880a, "Unexpected trailing comma", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
            return new JsonObject(linkedHashMap);
        }
        AbstractJsonLexer.y(this.f57880a, "Unexpected leading comma", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final t j(boolean z11) {
        String str;
        if (this.f57881b || !z11) {
            str = this.f57880a.s();
        } else {
            str = this.f57880a.q();
        }
        String str2 = str;
        if (z11 || !x.b(str2, OptionsBridge.NULL_VALUE)) {
            return new n(str2, z11, (f) null, 4, (r) null);
        }
        return JsonNull.INSTANCE;
    }
}
