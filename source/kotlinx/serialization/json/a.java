package kotlinx.serialization.json;

import kotlin.jvm.internal.r;
import kotlinx.serialization.g;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;
import kotlinx.serialization.json.internal.JsonToStringWriter;
import kotlinx.serialization.json.internal.TreeJsonEncoderKt;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.json.internal.j0;
import kotlinx.serialization.json.internal.m0;
import kotlinx.serialization.json.internal.o0;
import kotlinx.serialization.json.internal.z;
import kotlinx.serialization.k;
import kotlinx.serialization.modules.d;

public abstract class a implements k {

    /* renamed from: d  reason: collision with root package name */
    public static final C0671a f57827d = new C0671a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final JsonConfiguration f57828a;

    /* renamed from: b  reason: collision with root package name */
    public final d f57829b;

    /* renamed from: c  reason: collision with root package name */
    public final DescriptorSchemaCache f57830c;

    /* renamed from: kotlinx.serialization.json.a$a  reason: collision with other inner class name */
    public static final class C0671a extends a {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public C0671a() {
            /*
                r18 = this;
                kotlinx.serialization.json.JsonConfiguration r15 = new kotlinx.serialization.json.JsonConfiguration
                r1 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 8191(0x1fff, float:1.1478E-41)
                r16 = 0
                r0 = r15
                r17 = r15
                r15 = r16
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
                kotlinx.serialization.modules.d r0 = kotlinx.serialization.modules.e.a()
                r1 = 0
                r2 = r18
                r3 = r17
                r2.<init>(r3, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.a.C0671a.<init>():void");
        }

        public /* synthetic */ C0671a(r rVar) {
            this();
        }
    }

    public a(JsonConfiguration jsonConfiguration, d dVar) {
        this.f57828a = jsonConfiguration;
        this.f57829b = dVar;
        this.f57830c = new DescriptorSchemaCache();
    }

    public /* synthetic */ a(JsonConfiguration jsonConfiguration, d dVar, r rVar) {
        this(jsonConfiguration, dVar);
    }

    public d a() {
        return this.f57829b;
    }

    public final <T> String b(g<? super T> gVar, T t11) {
        JsonToStringWriter jsonToStringWriter = new JsonToStringWriter();
        try {
            z.a(this, jsonToStringWriter, gVar, t11);
            return jsonToStringWriter.toString();
        } finally {
            jsonToStringWriter.g();
        }
    }

    public final <T> T c(kotlinx.serialization.a<? extends T> aVar, String str) {
        m0 m0Var = new m0(str);
        T G = new j0(this, WriteMode.OBJ, m0Var, aVar.getDescriptor(), (j0.a) null).G(aVar);
        m0Var.w();
        return G;
    }

    public final <T> T d(kotlinx.serialization.a<? extends T> aVar, g gVar) {
        return o0.a(this, gVar, aVar);
    }

    public final <T> g e(g<? super T> gVar, T t11) {
        return TreeJsonEncoderKt.c(this, t11, gVar);
    }

    public final JsonConfiguration f() {
        return this.f57828a;
    }

    public final DescriptorSchemaCache g() {
        return this.f57830c;
    }
}
