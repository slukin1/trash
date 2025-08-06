package com.sumsub.sentry;

import com.facebook.internal.AnalyticsEvents;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 `2\u00020\u0001:\u0002\b\u0011B\u0002\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\t\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010;\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010;\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bZ\u0010[BÏ\u0001\b\u0017\u0012\u0006\u0010\\\u001a\u00020\u001c\u0012\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u00103\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0001\u00105\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0001\u00108\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010:\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010A\u001a\u0004\u0018\u00010;\u0012\n\b\u0001\u0010E\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010I\u001a\u0004\u0018\u00010;\u0012\n\b\u0001\u0010L\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010O\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010S\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010V\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010Y\u001a\u0004\u0018\u00010\n\u0012\b\u0010^\u001a\u0004\u0018\u00010]¢\u0006\u0004\bZ\u0010_J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R(\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR(\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u0012\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0012\u0010\rR.\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00158\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u0018\u0010\u0019R(\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u0012\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u001e\u0010\rR\"\u0010&\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010\u000f\u001a\u0004\b#\u0010$R\"\u0010*\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b'\u0010\"\u0012\u0004\b)\u0010\u000f\u001a\u0004\b(\u0010$R\"\u0010-\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b#\u0010\"\u0012\u0004\b,\u0010\u000f\u001a\u0004\b+\u0010$R\"\u00103\u001a\u0004\u0018\u00010\u001c8\u0006X\u0004¢\u0006\u0012\n\u0004\b.\u0010/\u0012\u0004\b2\u0010\u000f\u001a\u0004\b0\u00101R\"\u00105\u001a\u0004\u0018\u00010\u001c8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001e\u0010/\u0012\u0004\b4\u0010\u000f\u001a\u0004\b\u0016\u00101R\"\u00108\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b6\u0010\"\u0012\u0004\b7\u0010\u000f\u001a\u0004\b\b\u0010$R\"\u0010:\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b(\u0010\"\u0012\u0004\b9\u0010\u000f\u001a\u0004\b!\u0010$R\"\u0010A\u001a\u0004\u0018\u00010;8\u0006X\u0004¢\u0006\u0012\n\u0004\b<\u0010=\u0012\u0004\b@\u0010\u000f\u001a\u0004\b>\u0010?R\"\u0010E\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\bB\u0010\"\u0012\u0004\bD\u0010\u000f\u001a\u0004\bC\u0010$R\"\u0010I\u001a\u0004\u0018\u00010;8\u0006X\u0004¢\u0006\u0012\n\u0004\bF\u0010=\u0012\u0004\bH\u0010\u000f\u001a\u0004\bG\u0010?R\"\u0010L\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b>\u0010\"\u0012\u0004\bK\u0010\u000f\u001a\u0004\bJ\u0010$R\"\u0010O\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\bM\u0010\"\u0012\u0004\bN\u0010\u000f\u001a\u0004\bB\u0010$R\"\u0010S\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\bP\u0010\"\u0012\u0004\bR\u0010\u000f\u001a\u0004\bQ\u0010$R\"\u0010V\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\bT\u0010\"\u0012\u0004\bU\u0010\u000f\u001a\u0004\bP\u0010$R\"\u0010Y\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b0\u0010\"\u0012\u0004\bX\u0010\u000f\u001a\u0004\bW\u0010$¨\u0006a"}, d2 = {"Lcom/sumsub/sentry/h0;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "", "Ljava/util/List;", "C", "()Ljava/util/List;", "getPreContext$annotations", "()V", "preContext", "b", "A", "getPostContext$annotations", "postContext", "", "c", "Ljava/util/Map;", "I", "()Ljava/util/Map;", "getVars$annotations", "vars", "", "d", "i", "getFramesOmitted$annotations", "framesOmitted", "e", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "getFilename$annotations", "filename", "f", "k", "getFunction$annotations", "function", "u", "getModule$annotations", "module", "h", "Ljava/lang/Integer;", "s", "()Ljava/lang/Integer;", "getLineno$annotations", "lineno", "getColno$annotations", "colno", "j", "getAbsPath$annotations", "absPath", "getContextLine$annotations", "contextLine", "", "l", "Ljava/lang/Boolean;", "o", "()Ljava/lang/Boolean;", "getInApp$annotations", "inApp", "m", "w", "getPkg$annotations", "pkg", "n", "K", "isNative$annotations", "isNative", "y", "getPlatform$annotations", "platform", "p", "getImageAddr$annotations", "imageAddr", "q", "G", "getSymbolAddr$annotations", "symbolAddr", "r", "getInstructionAddr$annotations", "instructionAddr", "E", "getRawFunction$annotations", "rawFunction", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class h0 {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f30357a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f30358b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f30359c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Integer> f30360d;

    /* renamed from: e  reason: collision with root package name */
    public final String f30361e;

    /* renamed from: f  reason: collision with root package name */
    public final String f30362f;

    /* renamed from: g  reason: collision with root package name */
    public final String f30363g;

    /* renamed from: h  reason: collision with root package name */
    public final Integer f30364h;

    /* renamed from: i  reason: collision with root package name */
    public final Integer f30365i;

    /* renamed from: j  reason: collision with root package name */
    public final String f30366j;

    /* renamed from: k  reason: collision with root package name */
    public final String f30367k;

    /* renamed from: l  reason: collision with root package name */
    public final Boolean f30368l;

    /* renamed from: m  reason: collision with root package name */
    public final String f30369m;

    /* renamed from: n  reason: collision with root package name */
    public final Boolean f30370n;

    /* renamed from: o  reason: collision with root package name */
    public final String f30371o;

    /* renamed from: p  reason: collision with root package name */
    public final String f30372p;

    /* renamed from: q  reason: collision with root package name */
    public final String f30373q;

    /* renamed from: r  reason: collision with root package name */
    public final String f30374r;

    /* renamed from: s  reason: collision with root package name */
    public final String f30375s;

    public static final class a implements d0<h0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30376a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30377b;

        static {
            a aVar = new a();
            f30376a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SentryStackFrame", aVar, 15);
            pluginGeneratedSerialDescriptor.k("filename", true);
            pluginGeneratedSerialDescriptor.k("function", true);
            pluginGeneratedSerialDescriptor.k("module", true);
            pluginGeneratedSerialDescriptor.k("lineno", true);
            pluginGeneratedSerialDescriptor.k("colno", true);
            pluginGeneratedSerialDescriptor.k("abs_path", true);
            pluginGeneratedSerialDescriptor.k("context_line", true);
            pluginGeneratedSerialDescriptor.k("in_app", true);
            pluginGeneratedSerialDescriptor.k("package", true);
            pluginGeneratedSerialDescriptor.k(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, true);
            pluginGeneratedSerialDescriptor.k("platform", true);
            pluginGeneratedSerialDescriptor.k("image_addr", true);
            pluginGeneratedSerialDescriptor.k("symbol_addr", true);
            pluginGeneratedSerialDescriptor.k("instruction_addr", true);
            pluginGeneratedSerialDescriptor.k("raw_function", true);
            f30377b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x01a6, code lost:
            r3 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x01a8, code lost:
            r6 = r33;
            r2 = r34;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x01ef, code lost:
            r3 = r16;
            r2 = r33;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.h0 deserialize(kotlinx.serialization.encoding.c r39) {
            /*
                r38 = this;
                kotlinx.serialization.descriptors.f r0 = r38.getDescriptor()
                r1 = r39
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r7 = 10
                r8 = 9
                r9 = 7
                r10 = 6
                r11 = 5
                r12 = 3
                r13 = 8
                r14 = 4
                r15 = 2
                r3 = 0
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L_0x0077
                kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r3 = r1.j(r0, r3, r2, r5)
                java.lang.Object r4 = r1.j(r0, r4, r2, r5)
                java.lang.Object r15 = r1.j(r0, r15, r2, r5)
                kotlinx.serialization.internal.m0 r6 = kotlinx.serialization.internal.m0.f57742a
                java.lang.Object r12 = r1.j(r0, r12, r6, r5)
                java.lang.Object r6 = r1.j(r0, r14, r6, r5)
                java.lang.Object r11 = r1.j(r0, r11, r2, r5)
                java.lang.Object r10 = r1.j(r0, r10, r2, r5)
                kotlinx.serialization.internal.h r14 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r9 = r1.j(r0, r9, r14, r5)
                java.lang.Object r13 = r1.j(r0, r13, r2, r5)
                java.lang.Object r8 = r1.j(r0, r8, r14, r5)
                java.lang.Object r7 = r1.j(r0, r7, r2, r5)
                r14 = 11
                java.lang.Object r14 = r1.j(r0, r14, r2, r5)
                r18 = r3
                r3 = 12
                java.lang.Object r3 = r1.j(r0, r3, r2, r5)
                r17 = r3
                r3 = 13
                java.lang.Object r3 = r1.j(r0, r3, r2, r5)
                r16 = r3
                r3 = 14
                java.lang.Object r2 = r1.j(r0, r3, r2, r5)
                r3 = 32767(0x7fff, float:4.5916E-41)
                r20 = r3
                r3 = r16
                goto L_0x0217
            L_0x0077:
                r2 = r3
                r32 = r4
                r3 = r5
                r4 = r3
                r6 = r4
                r7 = r6
                r8 = r7
                r9 = r8
                r10 = r9
                r11 = r10
                r12 = r11
                r13 = r12
                r14 = r13
                r15 = r14
                r29 = r15
                r30 = r29
                r5 = r2
                r2 = r30
            L_0x008d:
                if (r32 == 0) goto L_0x01f5
                r33 = r6
                int r6 = r1.w(r0)
                switch(r6) {
                    case -1: goto L_0x01e1;
                    case 0: goto L_0x01cc;
                    case 1: goto L_0x01ae;
                    case 2: goto L_0x0194;
                    case 3: goto L_0x0181;
                    case 4: goto L_0x016e;
                    case 5: goto L_0x015b;
                    case 6: goto L_0x0148;
                    case 7: goto L_0x0134;
                    case 8: goto L_0x011e;
                    case 9: goto L_0x0108;
                    case 10: goto L_0x00f2;
                    case 11: goto L_0x00dc;
                    case 12: goto L_0x00c0;
                    case 13: goto L_0x00ac;
                    case 14: goto L_0x009e;
                    default: goto L_0x0098;
                }
            L_0x0098:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r6)
                throw r0
            L_0x009e:
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r34 = r2
                r2 = 14
                java.lang.Object r3 = r1.j(r0, r2, r6, r3)
                r5 = r5 | 16384(0x4000, float:2.2959E-41)
                goto L_0x01a8
            L_0x00ac:
                r34 = r2
                r2 = 14
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r16 = r3
                r2 = r30
                r3 = 13
                java.lang.Object r30 = r1.j(r0, r3, r6, r2)
                r5 = r5 | 8192(0x2000, float:1.14794E-41)
                goto L_0x01a6
            L_0x00c0:
                r34 = r2
                r16 = r3
                r2 = r30
                r3 = 13
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r17 = r2
                r3 = r29
                r2 = 12
                java.lang.Object r29 = r1.j(r0, r2, r6, r3)
                r5 = r5 | 4096(0x1000, float:5.74E-42)
                r3 = r16
                r30 = r17
                goto L_0x01a8
            L_0x00dc:
                r34 = r2
                r16 = r3
                r3 = r29
                r17 = r30
                r2 = 12
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r2 = 11
                java.lang.Object r7 = r1.j(r0, r2, r6, r7)
                r5 = r5 | 2048(0x800, float:2.87E-42)
                goto L_0x01a6
            L_0x00f2:
                r34 = r2
                r16 = r3
                r3 = r29
                r17 = r30
                r2 = 11
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r2 = 10
                java.lang.Object r8 = r1.j(r0, r2, r6, r8)
                r5 = r5 | 1024(0x400, float:1.435E-42)
                goto L_0x01a6
            L_0x0108:
                r34 = r2
                r16 = r3
                r3 = r29
                r17 = r30
                r2 = 10
                kotlinx.serialization.internal.h r6 = kotlinx.serialization.internal.h.f57720a
                r2 = 9
                java.lang.Object r13 = r1.j(r0, r2, r6, r13)
                r5 = r5 | 512(0x200, float:7.175E-43)
                goto L_0x01a6
            L_0x011e:
                r34 = r2
                r16 = r3
                r3 = r29
                r17 = r30
                r2 = 9
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r2 = 8
                java.lang.Object r9 = r1.j(r0, r2, r6, r9)
                r5 = r5 | 256(0x100, float:3.59E-43)
                goto L_0x01a6
            L_0x0134:
                r34 = r2
                r16 = r3
                r3 = r29
                r17 = r30
                r2 = 8
                kotlinx.serialization.internal.h r6 = kotlinx.serialization.internal.h.f57720a
                r2 = 7
                java.lang.Object r10 = r1.j(r0, r2, r6, r10)
                r5 = r5 | 128(0x80, float:1.794E-43)
                goto L_0x01a6
            L_0x0148:
                r34 = r2
                r16 = r3
                r3 = r29
                r17 = r30
                r2 = 7
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r2 = 6
                java.lang.Object r11 = r1.j(r0, r2, r6, r11)
                r5 = r5 | 64
                goto L_0x01a6
            L_0x015b:
                r34 = r2
                r16 = r3
                r3 = r29
                r17 = r30
                r2 = 6
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r2 = 5
                java.lang.Object r14 = r1.j(r0, r2, r6, r14)
                r5 = r5 | 32
                goto L_0x01a6
            L_0x016e:
                r34 = r2
                r16 = r3
                r3 = r29
                r17 = r30
                r2 = 5
                kotlinx.serialization.internal.m0 r6 = kotlinx.serialization.internal.m0.f57742a
                r2 = 4
                java.lang.Object r12 = r1.j(r0, r2, r6, r12)
                r5 = r5 | 16
                goto L_0x01a6
            L_0x0181:
                r34 = r2
                r16 = r3
                r3 = r29
                r17 = r30
                r2 = 4
                kotlinx.serialization.internal.m0 r6 = kotlinx.serialization.internal.m0.f57742a
                r2 = 3
                java.lang.Object r15 = r1.j(r0, r2, r6, r15)
                r5 = r5 | 8
                goto L_0x01a6
            L_0x0194:
                r34 = r2
                r16 = r3
                r3 = r29
                r17 = r30
                r2 = 3
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r2 = 2
                java.lang.Object r4 = r1.j(r0, r2, r6, r4)
                r5 = r5 | 4
            L_0x01a6:
                r3 = r16
            L_0x01a8:
                r6 = r33
                r2 = r34
                goto L_0x008d
            L_0x01ae:
                r34 = r2
                r16 = r3
                r3 = r29
                r17 = r30
                r2 = 2
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r19 = r3
                r2 = r34
                r3 = 1
                java.lang.Object r2 = r1.j(r0, r3, r6, r2)
                r5 = r5 | 2
                r3 = r16
                r29 = r19
                r6 = r33
                goto L_0x008d
            L_0x01cc:
                r16 = r3
                r19 = r29
                r17 = r30
                r3 = 1
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r3 = r33
                r33 = r2
                r2 = 0
                java.lang.Object r6 = r1.j(r0, r2, r6, r3)
                r5 = r5 | 1
                goto L_0x01ef
            L_0x01e1:
                r16 = r3
                r19 = r29
                r17 = r30
                r3 = r33
                r33 = r2
                r2 = 0
                r32 = r2
                r6 = r3
            L_0x01ef:
                r3 = r16
                r2 = r33
                goto L_0x008d
            L_0x01f5:
                r33 = r2
                r16 = r3
                r3 = r6
                r19 = r29
                r17 = r30
                r18 = r3
                r20 = r5
                r6 = r12
                r12 = r15
                r2 = r16
                r3 = r17
                r17 = r19
                r15 = r4
                r4 = r33
                r37 = r14
                r14 = r7
                r7 = r8
                r8 = r13
                r13 = r9
                r9 = r10
                r10 = r11
                r11 = r37
            L_0x0217:
                r1.c(r0)
                com.sumsub.sentry.h0 r0 = new com.sumsub.sentry.h0
                r19 = r0
                r21 = r18
                java.lang.String r21 = (java.lang.String) r21
                r22 = r4
                java.lang.String r22 = (java.lang.String) r22
                r23 = r15
                java.lang.String r23 = (java.lang.String) r23
                r24 = r12
                java.lang.Integer r24 = (java.lang.Integer) r24
                r25 = r6
                java.lang.Integer r25 = (java.lang.Integer) r25
                r26 = r11
                java.lang.String r26 = (java.lang.String) r26
                r27 = r10
                java.lang.String r27 = (java.lang.String) r27
                r28 = r9
                java.lang.Boolean r28 = (java.lang.Boolean) r28
                r29 = r13
                java.lang.String r29 = (java.lang.String) r29
                r30 = r8
                java.lang.Boolean r30 = (java.lang.Boolean) r30
                r31 = r7
                java.lang.String r31 = (java.lang.String) r31
                r32 = r14
                java.lang.String r32 = (java.lang.String) r32
                r33 = r17
                java.lang.String r33 = (java.lang.String) r33
                r34 = r3
                java.lang.String r34 = (java.lang.String) r34
                r35 = r2
                java.lang.String r35 = (java.lang.String) r35
                r36 = 0
                r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.h0.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.h0");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            m0 m0Var = m0.f57742a;
            h hVar = h.f57720a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(m0Var), h10.a.u(m0Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(hVar), h10.a.u(v1Var), h10.a.u(hVar), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30377b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, h0 h0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            h0.a(h0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<h0> serializer() {
            return a.f30376a;
        }

        public b() {
        }
    }

    public h0() {
        this((List) null, (List) null, (Map) null, (List) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Boolean) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, 524287, (r) null);
    }

    public static /* synthetic */ void B() {
    }

    public static /* synthetic */ void D() {
    }

    public static /* synthetic */ void F() {
    }

    public static /* synthetic */ void H() {
    }

    public static /* synthetic */ void J() {
    }

    public static /* synthetic */ void L() {
    }

    public static final void a(h0 h0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || h0Var.f30361e != null) {
            bVar.y(fVar, 0, v1.f57779a, h0Var.f30361e);
        }
        if (bVar.q(fVar, 1) || h0Var.f30362f != null) {
            bVar.y(fVar, 1, v1.f57779a, h0Var.f30362f);
        }
        if (bVar.q(fVar, 2) || h0Var.f30363g != null) {
            bVar.y(fVar, 2, v1.f57779a, h0Var.f30363g);
        }
        if (bVar.q(fVar, 3) || h0Var.f30364h != null) {
            bVar.y(fVar, 3, m0.f57742a, h0Var.f30364h);
        }
        if (bVar.q(fVar, 4) || h0Var.f30365i != null) {
            bVar.y(fVar, 4, m0.f57742a, h0Var.f30365i);
        }
        if (bVar.q(fVar, 5) || h0Var.f30366j != null) {
            bVar.y(fVar, 5, v1.f57779a, h0Var.f30366j);
        }
        if (bVar.q(fVar, 6) || h0Var.f30367k != null) {
            bVar.y(fVar, 6, v1.f57779a, h0Var.f30367k);
        }
        if (bVar.q(fVar, 7) || h0Var.f30368l != null) {
            bVar.y(fVar, 7, h.f57720a, h0Var.f30368l);
        }
        if (bVar.q(fVar, 8) || h0Var.f30369m != null) {
            bVar.y(fVar, 8, v1.f57779a, h0Var.f30369m);
        }
        if (bVar.q(fVar, 9) || h0Var.f30370n != null) {
            bVar.y(fVar, 9, h.f57720a, h0Var.f30370n);
        }
        if (bVar.q(fVar, 10) || h0Var.f30371o != null) {
            bVar.y(fVar, 10, v1.f57779a, h0Var.f30371o);
        }
        if (bVar.q(fVar, 11) || h0Var.f30372p != null) {
            bVar.y(fVar, 11, v1.f57779a, h0Var.f30372p);
        }
        if (bVar.q(fVar, 12) || h0Var.f30373q != null) {
            bVar.y(fVar, 12, v1.f57779a, h0Var.f30373q);
        }
        if (bVar.q(fVar, 13) || h0Var.f30374r != null) {
            bVar.y(fVar, 13, v1.f57779a, h0Var.f30374r);
        }
        if (bVar.q(fVar, 14) || h0Var.f30375s != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 14, v1.f57779a, h0Var.f30375s);
        }
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public static /* synthetic */ void h() {
    }

    public static /* synthetic */ void j() {
    }

    public static /* synthetic */ void l() {
    }

    public static /* synthetic */ void n() {
    }

    public static /* synthetic */ void p() {
    }

    public static /* synthetic */ void r() {
    }

    public static /* synthetic */ void t() {
    }

    public static /* synthetic */ void v() {
    }

    public static /* synthetic */ void x() {
    }

    public static /* synthetic */ void z() {
    }

    public final List<String> A() {
        return this.f30358b;
    }

    public final List<String> C() {
        return this.f30357a;
    }

    public final String E() {
        return this.f30375s;
    }

    public final String G() {
        return this.f30373q;
    }

    public final Map<String, String> I() {
        return this.f30359c;
    }

    public final Boolean K() {
        return this.f30370n;
    }

    public final Integer c() {
        return this.f30365i;
    }

    public final String e() {
        return this.f30367k;
    }

    public final String g() {
        return this.f30361e;
    }

    public final List<Integer> i() {
        return this.f30360d;
    }

    public final String k() {
        return this.f30362f;
    }

    public final String m() {
        return this.f30372p;
    }

    public final Boolean o() {
        return this.f30368l;
    }

    public final String q() {
        return this.f30374r;
    }

    public final Integer s() {
        return this.f30364h;
    }

    public final String u() {
        return this.f30363g;
    }

    public final String w() {
        return this.f30369m;
    }

    public final String y() {
        return this.f30371o;
    }

    public /* synthetic */ h0(int i11, String str, String str2, String str3, Integer num, Integer num2, String str4, String str5, Boolean bool, String str6, Boolean bool2, String str7, String str8, String str9, String str10, String str11, q1 q1Var) {
        int i12 = i11;
        if ((i12 & 0) != 0) {
            h1.a(i11, 0, a.f30376a.getDescriptor());
        }
        this.f30357a = null;
        this.f30358b = null;
        this.f30359c = null;
        this.f30360d = null;
        if ((i12 & 1) == 0) {
            this.f30361e = null;
        } else {
            this.f30361e = str;
        }
        if ((i12 & 2) == 0) {
            this.f30362f = null;
        } else {
            this.f30362f = str2;
        }
        if ((i12 & 4) == 0) {
            this.f30363g = null;
        } else {
            this.f30363g = str3;
        }
        if ((i12 & 8) == 0) {
            this.f30364h = null;
        } else {
            this.f30364h = num;
        }
        if ((i12 & 16) == 0) {
            this.f30365i = null;
        } else {
            this.f30365i = num2;
        }
        if ((i12 & 32) == 0) {
            this.f30366j = null;
        } else {
            this.f30366j = str4;
        }
        if ((i12 & 64) == 0) {
            this.f30367k = null;
        } else {
            this.f30367k = str5;
        }
        if ((i12 & 128) == 0) {
            this.f30368l = null;
        } else {
            this.f30368l = bool;
        }
        if ((i12 & 256) == 0) {
            this.f30369m = null;
        } else {
            this.f30369m = str6;
        }
        if ((i12 & 512) == 0) {
            this.f30370n = null;
        } else {
            this.f30370n = bool2;
        }
        if ((i12 & 1024) == 0) {
            this.f30371o = null;
        } else {
            this.f30371o = str7;
        }
        if ((i12 & 2048) == 0) {
            this.f30372p = null;
        } else {
            this.f30372p = str8;
        }
        if ((i12 & 4096) == 0) {
            this.f30373q = null;
        } else {
            this.f30373q = str9;
        }
        if ((i12 & 8192) == 0) {
            this.f30374r = null;
        } else {
            this.f30374r = str10;
        }
        if ((i12 & 16384) == 0) {
            this.f30375s = null;
        } else {
            this.f30375s = str11;
        }
    }

    public final String a() {
        return this.f30366j;
    }

    public h0(List<String> list, List<String> list2, Map<String, String> map, List<Integer> list3, String str, String str2, String str3, Integer num, Integer num2, String str4, String str5, Boolean bool, String str6, Boolean bool2, String str7, String str8, String str9, String str10, String str11) {
        this.f30357a = list;
        this.f30358b = list2;
        this.f30359c = map;
        this.f30360d = list3;
        this.f30361e = str;
        this.f30362f = str2;
        this.f30363g = str3;
        this.f30364h = num;
        this.f30365i = num2;
        this.f30366j = str4;
        this.f30367k = str5;
        this.f30368l = bool;
        this.f30369m = str6;
        this.f30370n = bool2;
        this.f30371o = str7;
        this.f30372p = str8;
        this.f30373q = str9;
        this.f30374r = str10;
        this.f30375s = str11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ h0(java.util.List r21, java.util.List r22, java.util.Map r23, java.util.List r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.Integer r28, java.lang.Integer r29, java.lang.String r30, java.lang.String r31, java.lang.Boolean r32, java.lang.String r33, java.lang.Boolean r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, int r40, kotlin.jvm.internal.r r41) {
        /*
            r20 = this;
            r0 = r40
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r21
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r22
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r23
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r24
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r25
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r26
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r27
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r28
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r29
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r30
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r31
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r32
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r33
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r34
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r35
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r36
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r37
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r38
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r19
            if (r0 == 0) goto L_0x00a4
            r0 = 0
            goto L_0x00a6
        L_0x00a4:
            r0 = r39
        L_0x00a6:
            r21 = r20
            r22 = r1
            r23 = r3
            r24 = r4
            r25 = r5
            r26 = r6
            r27 = r7
            r28 = r8
            r29 = r9
            r30 = r10
            r31 = r11
            r32 = r12
            r33 = r13
            r34 = r14
            r35 = r15
            r36 = r2
            r37 = r16
            r38 = r17
            r39 = r18
            r40 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.h0.<init>(java.util.List, java.util.List, java.util.Map, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.r):void");
    }
}
