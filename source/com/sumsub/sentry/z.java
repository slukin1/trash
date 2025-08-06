package com.sumsub.sentry;

import cn.sharesdk.framework.InnerShareParams;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.sumsub.sentry.SentryLevel;
import com.sumsub.sentry.a0;
import com.sumsub.sentry.b;
import com.sumsub.sentry.d;
import com.sumsub.sentry.d0;
import com.sumsub.sentry.g;
import com.sumsub.sentry.k0;
import com.sumsub.sentry.m0;
import com.sumsub.sentry.p;
import com.sumsub.sentry.q0;
import com.sumsub.sentry.s;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 p2\u00020\u0001:\u0002\b)B¦\u0001\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#\u0012\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010#\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010=\u0012\u0016\b\u0002\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010D\u0012\b\b\u0002\u0010Q\u001a\u00020Kø\u0001\u0000¢\u0006\u0004\bX\u0010YBâ\u0002\b\u0017\u0012\u0006\u0010[\u001a\u00020Z\u0012\n\b\u0001\u0010]\u001a\u0004\u0018\u00010\\\u0012\n\b\u0001\u0010_\u001a\u0004\u0018\u00010^\u0012\u0016\b\u0001\u0010`\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010D\u0012\n\b\u0001\u0010a\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010b\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010c\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010e\u001a\u0004\u0018\u00010d\u0012\n\b\u0001\u0010f\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010g\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0001\u0010j\u001a\n\u0012\u0004\u0012\u00020i\u0018\u00010h\u0012\u0016\b\u0001\u0010l\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020k\u0018\u00010D\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0001\u0010,\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#\u0012\u0010\b\u0001\u00101\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010#\u0012\n\b\u0001\u00108\u001a\u0004\u0018\u000102\u0012\n\b\u0001\u0010<\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0001\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010=\u0012\u0016\b\u0001\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010D\u0012\n\b\u0001\u0010Q\u001a\u0004\u0018\u00010K\u0012\b\u0010n\u001a\u0004\u0018\u00010mø\u0001\u0000¢\u0006\u0004\bX\u0010oJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R1\u0010\u0012\u001a\u00020\t8\u0016@\u0016X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0018\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0017\u001a\u00020\u00138\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0015\u0010\rR\"\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\"\u001a\u0004\u0018\u00010\u00138\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u0012\u0004\b!\u0010\u0011\u001a\u0004\b \u0010\rR0\u0010,\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b%\u0010&\u0012\u0004\b+\u0010\u0011\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R0\u00101\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b.\u0010&\u0012\u0004\b0\u0010\u0011\u001a\u0004\b/\u0010(\"\u0004\b\b\u0010*R\"\u00108\u001a\u0004\u0018\u0001028\u0006X\u0004¢\u0006\u0012\n\u0004\b3\u00104\u0012\u0004\b7\u0010\u0011\u001a\u0004\b5\u00106R\"\u0010<\u001a\u0004\u0018\u00010\u00138\u0006X\u0004¢\u0006\u0012\n\u0004\b9\u0010\u000b\u0012\u0004\b;\u0010\u0011\u001a\u0004\b:\u0010\rR(\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010=8\u0006X\u0004¢\u0006\u0012\n\u0004\b>\u0010?\u0012\u0004\bB\u0010\u0011\u001a\u0004\b@\u0010AR.\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010D8\u0006X\u0004¢\u0006\u0012\n\u0004\bE\u0010F\u0012\u0004\bI\u0010\u0011\u001a\u0004\bG\u0010HR \u0010Q\u001a\u00020K8\u0006X\u0004¢\u0006\u0012\n\u0004\bL\u0010M\u0012\u0004\bP\u0010\u0011\u001a\u0004\bN\u0010OR\u0011\u0010U\u001a\u00020R8F¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0011\u0010W\u001a\u00020R8F¢\u0006\u0006\u001a\u0004\bV\u0010T\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006q"}, d2 = {"Lcom/sumsub/sentry/z;", "Lcom/sumsub/sentry/u;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sentry/d0;", "o", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "getEventId-uFNw5ug$annotations", "()V", "eventId", "", "p", "S", "getTimestamp$annotations", "timestamp", "Lcom/sumsub/sentry/p;", "q", "Lcom/sumsub/sentry/p;", "M", "()Lcom/sumsub/sentry/p;", "getMessage$annotations", "message", "r", "K", "getLogger$annotations", "logger", "Lcom/sumsub/sentry/m0;", "Lcom/sumsub/sentry/k0;", "s", "Lcom/sumsub/sentry/m0;", "Q", "()Lcom/sumsub/sentry/m0;", "b", "(Lcom/sumsub/sentry/m0;)V", "getThreads$annotations", "threads", "Lcom/sumsub/sentry/a0;", "t", "E", "getException$annotations", "exception", "Lcom/sumsub/sentry/SentryLevel;", "u", "Lcom/sumsub/sentry/SentryLevel;", "I", "()Lcom/sumsub/sentry/SentryLevel;", "getLevel$annotations", "level", "v", "U", "getTransaction$annotations", "transaction", "", "w", "Ljava/util/List;", "G", "()Ljava/util/List;", "getFingerprint$annotations", "fingerprint", "", "x", "Ljava/util/Map;", "O", "()Ljava/util/Map;", "getModules$annotations", "modules", "Lcom/sumsub/sentry/g;", "y", "Lcom/sumsub/sentry/g;", "B", "()Lcom/sumsub/sentry/g;", "getDebugMeta$annotations", "debugMeta", "", "W", "()Z", "isCrashed", "X", "isErrored", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sentry/p;Ljava/lang/String;Lcom/sumsub/sentry/m0;Lcom/sumsub/sentry/m0;Lcom/sumsub/sentry/SentryLevel;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Lcom/sumsub/sentry/g;Lkotlin/jvm/internal/r;)V", "", "seen1", "Lcom/sumsub/sentry/d;", "contexts", "Lcom/sumsub/sentry/s;", "sdk", "tags", "release", "environment", "platform", "Lcom/sumsub/sentry/q0;", "user", "serverName", "dist", "", "Lcom/sumsub/sentry/b;", "breadcrumbs", "", "extra", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sentry/d;Lcom/sumsub/sentry/s;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sentry/q0;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sentry/p;Ljava/lang/String;Lcom/sumsub/sentry/m0;Lcom/sumsub/sentry/m0;Lcom/sumsub/sentry/SentryLevel;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Lcom/sumsub/sentry/g;Lkotlinx/serialization/internal/q1;Lkotlin/jvm/internal/r;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class z extends u {
    public static final b Companion = new b((r) null);

    /* renamed from: o  reason: collision with root package name */
    public String f30533o;

    /* renamed from: p  reason: collision with root package name */
    public final String f30534p;

    /* renamed from: q  reason: collision with root package name */
    public final p f30535q;

    /* renamed from: r  reason: collision with root package name */
    public final String f30536r;

    /* renamed from: s  reason: collision with root package name */
    public m0<k0> f30537s;

    /* renamed from: t  reason: collision with root package name */
    public m0<a0> f30538t;

    /* renamed from: u  reason: collision with root package name */
    public final SentryLevel f30539u;

    /* renamed from: v  reason: collision with root package name */
    public final String f30540v;

    /* renamed from: w  reason: collision with root package name */
    public final List<String> f30541w;

    /* renamed from: x  reason: collision with root package name */
    public final Map<String, String> f30542x;

    /* renamed from: y  reason: collision with root package name */
    public final g f30543y;

    public static final class a implements d0<z> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30544a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30545b;

        static {
            a aVar = new a();
            f30544a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SentryEvent", aVar, 22);
            pluginGeneratedSerialDescriptor.k("contexts", true);
            pluginGeneratedSerialDescriptor.k(ServerProtocol.DIALOG_PARAM_SDK_VERSION, true);
            pluginGeneratedSerialDescriptor.k(InnerShareParams.TAGS, true);
            pluginGeneratedSerialDescriptor.k("release", true);
            pluginGeneratedSerialDescriptor.k("environment", true);
            pluginGeneratedSerialDescriptor.k("platform", true);
            pluginGeneratedSerialDescriptor.k("user", true);
            pluginGeneratedSerialDescriptor.k("server_name", true);
            pluginGeneratedSerialDescriptor.k("dist", true);
            pluginGeneratedSerialDescriptor.k("breadcrumbs", true);
            pluginGeneratedSerialDescriptor.k("extra", true);
            pluginGeneratedSerialDescriptor.k("event_id", true);
            pluginGeneratedSerialDescriptor.k("timestamp", true);
            pluginGeneratedSerialDescriptor.k("message", true);
            pluginGeneratedSerialDescriptor.k("logger", true);
            pluginGeneratedSerialDescriptor.k("threads", true);
            pluginGeneratedSerialDescriptor.k(Constants.EXCEPTION, true);
            pluginGeneratedSerialDescriptor.k(FirebaseAnalytics.Param.LEVEL, true);
            pluginGeneratedSerialDescriptor.k("transaction", true);
            pluginGeneratedSerialDescriptor.k(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, true);
            pluginGeneratedSerialDescriptor.k("modules", true);
            pluginGeneratedSerialDescriptor.k("debug_meta", true);
            f30545b = pluginGeneratedSerialDescriptor;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v2, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v3, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v4, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v4, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v5, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v5, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v6, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v7, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v3, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v4, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v5, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v15, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v6, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v7, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v19, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v21, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v8, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v8, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v23, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v9, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v26, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v10, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v6, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v29, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v7, resolved type: java.lang.String} */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x01da, code lost:
            r9 = r45;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0262, code lost:
            r25 = r35;
            r26 = r36;
            r24 = r37;
            r23 = r38;
            r27 = r39;
            r9 = r45;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0282, code lost:
            r48 = r0;
            r12 = r11;
            r25 = r35;
            r26 = r36;
            r24 = r37;
            r23 = r38;
            r27 = r39;
            r9 = r45;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x02ff, code lost:
            r11 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0330, code lost:
            r11 = r5;
            r5 = r49;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x04d5, code lost:
            r9 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x04d6, code lost:
            r6 = r54;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x04d8, code lost:
            r33 = r33 | r11;
            r11 = r12;
            r38 = r23;
            r37 = r24;
            r35 = r25;
            r36 = r26;
            r39 = r27;
            r12 = r44;
            r0 = r48;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.z deserialize(kotlinx.serialization.encoding.c r54) {
            /*
                r53 = this;
                java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                kotlinx.serialization.descriptors.f r1 = r53.getDescriptor()
                r2 = r54
                kotlinx.serialization.encoding.a r2 = r2.b(r1)
                boolean r3 = r2.k()
                r13 = 9
                r14 = 7
                r15 = 6
                r4 = 5
                r5 = 3
                r6 = 8
                r7 = 4
                r8 = 2
                r9 = 1
                r10 = 0
                r11 = 0
                if (r3 == 0) goto L_0x0105
                com.sumsub.sentry.d$b r3 = com.sumsub.sentry.d.b.f30313a
                java.lang.Object r3 = r2.p(r1, r10, r3, r11)
                com.sumsub.sentry.s$a r12 = com.sumsub.sentry.s.a.f30494a
                java.lang.Object r9 = r2.j(r1, r9, r12, r11)
                kotlinx.serialization.internal.r0 r12 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r10 = kotlinx.serialization.internal.v1.f57779a
                r12.<init>(r10, r10)
                java.lang.Object r8 = r2.j(r1, r8, r12, r11)
                java.lang.Object r5 = r2.j(r1, r5, r10, r11)
                java.lang.Object r7 = r2.j(r1, r7, r10, r11)
                java.lang.Object r4 = r2.j(r1, r4, r10, r11)
                com.sumsub.sentry.q0$a r12 = com.sumsub.sentry.q0.a.f30482a
                java.lang.Object r12 = r2.j(r1, r15, r12, r11)
                java.lang.Object r14 = r2.j(r1, r14, r10, r11)
                java.lang.Object r6 = r2.j(r1, r6, r10, r11)
                kotlinx.serialization.internal.e r15 = new kotlinx.serialization.internal.e
                r24 = r3
                com.sumsub.sentry.b$a r3 = com.sumsub.sentry.b.a.f30295a
                r15.<init>(r3)
                java.lang.Object r3 = r2.j(r1, r13, r15, r11)
                kotlinx.serialization.internal.r0 r13 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.ContextualSerializer r15 = new kotlinx.serialization.ContextualSerializer
                kotlin.reflect.c r0 = kotlin.jvm.internal.Reflection.b(r0)
                r25 = r3
                r3 = 0
                kotlinx.serialization.b[] r3 = new kotlinx.serialization.b[r3]
                r15.<init>(r0, r11, r3)
                r13.<init>(r10, r15)
                r0 = 10
                java.lang.Object r0 = r2.j(r1, r0, r13, r11)
                com.sumsub.sentry.d0$a r3 = com.sumsub.sentry.d0.a.f30317a
                r13 = 11
                java.lang.Object r3 = r2.p(r1, r13, r3, r11)
                r13 = 12
                java.lang.String r13 = r2.i(r1, r13)
                com.sumsub.sentry.p$a r15 = com.sumsub.sentry.p.a.f30465a
                r22 = r0
                r0 = 13
                java.lang.Object r0 = r2.j(r1, r0, r15, r11)
                r15 = 14
                java.lang.Object r15 = r2.j(r1, r15, r10, r11)
                com.sumsub.sentry.m0$b r11 = com.sumsub.sentry.m0.Companion
                r20 = r0
                com.sumsub.sentry.k0$a r0 = com.sumsub.sentry.k0.a.f30423a
                kotlinx.serialization.b r0 = r11.serializer(r0)
                r21 = r3
                r19 = r4
                r3 = 15
                r4 = 0
                java.lang.Object r0 = r2.j(r1, r3, r0, r4)
                com.sumsub.sentry.a0$a r3 = com.sumsub.sentry.a0.a.f30257a
                kotlinx.serialization.b r3 = r11.serializer(r3)
                r11 = 16
                java.lang.Object r3 = r2.j(r1, r11, r3, r4)
                com.sumsub.sentry.SentryLevel$a r11 = com.sumsub.sentry.SentryLevel.a.f30237a
                r18 = r0
                r0 = 17
                java.lang.Object r0 = r2.j(r1, r0, r11, r4)
                r11 = 18
                java.lang.Object r11 = r2.j(r1, r11, r10, r4)
                r16 = r0
                kotlinx.serialization.internal.e r0 = new kotlinx.serialization.internal.e
                r0.<init>(r10)
                r17 = r3
                r3 = 19
                java.lang.Object r0 = r2.j(r1, r3, r0, r4)
                kotlinx.serialization.internal.r0 r3 = new kotlinx.serialization.internal.r0
                r3.<init>(r10, r10)
                r10 = 20
                java.lang.Object r3 = r2.j(r1, r10, r3, r4)
                com.sumsub.sentry.g$a r10 = com.sumsub.sentry.g.a.f30348a
                r54 = r0
                r0 = 21
                java.lang.Object r0 = r2.p(r1, r0, r10, r4)
                r4 = 4194303(0x3fffff, float:5.87747E-39)
                r27 = r4
                r44 = r6
                r40 = r13
                r28 = r14
                r49 = r15
                r15 = r16
                r4 = r19
                r6 = r25
                r13 = r3
                r14 = r11
                r3 = r54
                r11 = r0
                r0 = r22
                goto L_0x053d
            L_0x0105:
                r43 = r9
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
                r14 = 0
                r15 = 0
                r33 = 0
                r34 = 0
                r35 = 0
                r36 = 0
                r37 = 0
                r38 = 0
                r39 = 0
                r40 = 0
                r41 = 0
                r42 = 0
            L_0x0128:
                if (r43 == 0) goto L_0x0508
                r44 = r12
                int r12 = r2.w(r1)
                switch(r12) {
                    case -1: goto L_0x04eb;
                    case 0: goto L_0x04a2;
                    case 1: goto L_0x046f;
                    case 2: goto L_0x0436;
                    case 3: goto L_0x0401;
                    case 4: goto L_0x03ce;
                    case 5: goto L_0x039c;
                    case 6: goto L_0x0369;
                    case 7: goto L_0x0335;
                    case 8: goto L_0x0303;
                    case 9: goto L_0x02d1;
                    case 10: goto L_0x0293;
                    case 11: goto L_0x0270;
                    case 12: goto L_0x024b;
                    case 13: goto L_0x0238;
                    case 14: goto L_0x0225;
                    case 15: goto L_0x01f8;
                    case 16: goto L_0x01de;
                    case 17: goto L_0x01b6;
                    case 18: goto L_0x0193;
                    case 19: goto L_0x0172;
                    case 20: goto L_0x014a;
                    case 21: goto L_0x0139;
                    default: goto L_0x0133;
                }
            L_0x0133:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r12)
                throw r0
            L_0x0139:
                com.sumsub.sentry.g$a r12 = com.sumsub.sentry.g.a.f30348a
                r45 = r9
                r9 = 21
                java.lang.Object r9 = r2.p(r1, r9, r12, r11)
                r11 = 2097152(0x200000, float:2.938736E-39)
                r48 = r0
                r12 = r9
                goto L_0x0262
            L_0x014a:
                r45 = r9
                kotlinx.serialization.internal.r0 r9 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r12 = kotlinx.serialization.internal.v1.f57779a
                r9.<init>(r12, r12)
                r12 = 20
                java.lang.Object r9 = r2.j(r1, r12, r9, r13)
                r12 = 1048576(0x100000, float:1.469368E-39)
                r48 = r0
                r13 = r9
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r27 = r39
                r9 = r45
                r0 = 0
                r52 = r12
                r12 = r11
                r11 = r52
                goto L_0x04d8
            L_0x0172:
                r45 = r9
                kotlinx.serialization.internal.e r9 = new kotlinx.serialization.internal.e
                kotlinx.serialization.internal.v1 r12 = kotlinx.serialization.internal.v1.f57779a
                r9.<init>(r12)
                r12 = 19
                java.lang.Object r6 = r2.j(r1, r12, r9, r6)
                r9 = 524288(0x80000, float:7.34684E-40)
                r48 = r0
                r12 = r11
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r27 = r39
                r0 = 0
                r11 = r9
                goto L_0x01da
            L_0x0193:
                r45 = r9
                r12 = 19
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                r54 = r6
                r6 = 18
                java.lang.Object r9 = r2.j(r1, r6, r9, r14)
                r14 = 262144(0x40000, float:3.67342E-40)
                r6 = r54
                r48 = r0
                r12 = r11
                r11 = r14
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r27 = r39
                r0 = 0
                r14 = r9
                goto L_0x01da
            L_0x01b6:
                r54 = r6
                r45 = r9
                r6 = 18
                r12 = 19
                com.sumsub.sentry.SentryLevel$a r9 = com.sumsub.sentry.SentryLevel.a.f30237a
                r6 = 17
                java.lang.Object r9 = r2.j(r1, r6, r9, r15)
                r15 = 131072(0x20000, float:1.83671E-40)
                r6 = r54
                r48 = r0
                r12 = r11
                r11 = r15
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r27 = r39
                r0 = 0
                r15 = r9
            L_0x01da:
                r9 = r45
                goto L_0x04d8
            L_0x01de:
                r54 = r6
                r45 = r9
                r6 = 17
                r12 = 19
                com.sumsub.sentry.m0$b r9 = com.sumsub.sentry.m0.Companion
                com.sumsub.sentry.a0$a r6 = com.sumsub.sentry.a0.a.f30257a
                kotlinx.serialization.b r6 = r9.serializer(r6)
                r9 = 16
                java.lang.Object r4 = r2.j(r1, r9, r6, r4)
                r6 = 65536(0x10000, float:9.18355E-41)
                goto L_0x0282
            L_0x01f8:
                r54 = r6
                r45 = r9
                r9 = 16
                r12 = 19
                com.sumsub.sentry.m0$b r6 = com.sumsub.sentry.m0.Companion
                com.sumsub.sentry.k0$a r9 = com.sumsub.sentry.k0.a.f30423a
                kotlinx.serialization.b r6 = r6.serializer(r9)
                r9 = 15
                java.lang.Object r6 = r2.j(r1, r9, r6, r7)
                r7 = 32768(0x8000, float:4.5918E-41)
                r48 = r0
                r12 = r11
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r27 = r39
                r9 = r45
                r0 = 0
                r11 = r7
                r7 = r6
                goto L_0x04d6
            L_0x0225:
                r54 = r6
                r45 = r9
                r9 = 15
                r12 = 19
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r9 = 14
                java.lang.Object r5 = r2.j(r1, r9, r6, r5)
                r6 = 16384(0x4000, float:2.2959E-41)
                goto L_0x0282
            L_0x0238:
                r54 = r6
                r45 = r9
                r9 = 14
                r12 = 19
                com.sumsub.sentry.p$a r6 = com.sumsub.sentry.p.a.f30465a
                r9 = 13
                java.lang.Object r10 = r2.j(r1, r9, r6, r10)
                r6 = 8192(0x2000, float:1.14794E-41)
                goto L_0x0282
            L_0x024b:
                r54 = r6
                r45 = r9
                r6 = 12
                r9 = 13
                r12 = 19
                java.lang.String r40 = r2.i(r1, r6)
                r21 = 4096(0x1000, float:5.74E-42)
                r6 = r54
                r48 = r0
                r12 = r11
                r11 = r21
            L_0x0262:
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r27 = r39
                r9 = r45
                goto L_0x0366
            L_0x0270:
                r54 = r6
                r45 = r9
                r9 = 13
                r12 = 19
                com.sumsub.sentry.d0$a r6 = com.sumsub.sentry.d0.a.f30317a
                r9 = 11
                java.lang.Object r8 = r2.p(r1, r9, r6, r8)
                r6 = 2048(0x800, float:2.87E-42)
            L_0x0282:
                r48 = r0
                r12 = r11
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r27 = r39
                r9 = r45
                goto L_0x02ff
            L_0x0293:
                r54 = r6
                r45 = r9
                r9 = 11
                r12 = 19
                kotlinx.serialization.internal.r0 r6 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                kotlinx.serialization.ContextualSerializer r12 = new kotlinx.serialization.ContextualSerializer
                r47 = r4
                kotlin.reflect.c r4 = kotlin.jvm.internal.Reflection.b(r0)
                r48 = r0
                r49 = r5
                r0 = 0
                kotlinx.serialization.b[] r5 = new kotlinx.serialization.b[r0]
                r0 = 0
                r12.<init>(r4, r0, r5)
                r6.<init>(r9, r12)
                r4 = 10
                java.lang.Object r3 = r2.j(r1, r4, r6, r3)
                r5 = 1024(0x400, float:1.435E-42)
                r6 = r54
                r12 = r11
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r27 = r39
                r9 = r45
                r4 = r47
                r0 = 0
                goto L_0x0330
            L_0x02d1:
                r48 = r0
                r47 = r4
                r49 = r5
                r54 = r6
                r45 = r9
                r0 = 0
                r4 = 10
                kotlinx.serialization.internal.e r5 = new kotlinx.serialization.internal.e
                com.sumsub.sentry.b$a r6 = com.sumsub.sentry.b.a.f30295a
                r5.<init>(r6)
                r6 = r45
                r9 = 9
                java.lang.Object r5 = r2.j(r1, r9, r5, r6)
                r6 = 512(0x200, float:7.175E-43)
                r9 = r5
                r12 = r11
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r27 = r39
                r4 = r47
                r5 = r49
            L_0x02ff:
                r0 = 0
                r11 = r6
                goto L_0x04d6
            L_0x0303:
                r48 = r0
                r47 = r4
                r49 = r5
                r54 = r6
                r6 = r9
                r0 = 0
                r4 = 10
                r9 = 9
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r12 = r44
                r0 = 8
                java.lang.Object r12 = r2.j(r1, r0, r5, r12)
                r5 = 256(0x100, float:3.59E-43)
                r9 = r6
                r44 = r12
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r27 = r39
                r4 = r47
                r0 = 0
                r6 = r54
                r12 = r11
            L_0x0330:
                r11 = r5
                r5 = r49
                goto L_0x04d8
            L_0x0335:
                r48 = r0
                r47 = r4
                r49 = r5
                r54 = r6
                r6 = r9
                r12 = r44
                r0 = 8
                r4 = 10
                r9 = 9
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r0 = r42
                r4 = 7
                java.lang.Object r5 = r2.j(r1, r4, r5, r0)
                r0 = 128(0x80, float:1.794E-43)
                r42 = r5
                r9 = r6
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r27 = r39
                r4 = r47
                r5 = r49
                r6 = r54
                r12 = r11
                r11 = r0
            L_0x0366:
                r0 = 0
                goto L_0x04d8
            L_0x0369:
                r48 = r0
                r47 = r4
                r49 = r5
                r54 = r6
                r6 = r9
                r0 = r42
                r12 = r44
                r4 = 7
                r9 = 9
                com.sumsub.sentry.q0$a r5 = com.sumsub.sentry.q0.a.f30482a
                r4 = r41
                r9 = 6
                java.lang.Object r5 = r2.j(r1, r9, r5, r4)
                r4 = 64
                r41 = r5
                r9 = r6
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r27 = r39
                r5 = r49
                r0 = 0
                r6 = r54
                r12 = r11
                r11 = r4
                r4 = r47
                goto L_0x04d8
            L_0x039c:
                r48 = r0
                r47 = r4
                r49 = r5
                r54 = r6
                r6 = r9
                r4 = r41
                r0 = r42
                r12 = r44
                r9 = 6
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r28 = r0
                r9 = r39
                r0 = 5
                java.lang.Object r5 = r2.j(r1, r0, r5, r9)
                r9 = 32
                r27 = r5
                r42 = r28
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r4 = r47
                r5 = r49
                r0 = 0
                r12 = r11
                r11 = r9
                goto L_0x04d5
            L_0x03ce:
                r48 = r0
                r47 = r4
                r49 = r5
                r54 = r6
                r6 = r9
                r9 = r39
                r4 = r41
                r28 = r42
                r12 = r44
                r0 = 5
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r27 = r3
                r0 = r36
                r3 = 4
                java.lang.Object r36 = r2.j(r1, r3, r5, r0)
                r3 = r27
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r4 = r47
                r5 = r49
                r0 = 0
                r27 = r9
                r12 = r11
                r11 = 16
                goto L_0x04d5
            L_0x0401:
                r48 = r0
                r27 = r3
                r47 = r4
                r49 = r5
                r54 = r6
                r6 = r9
                r0 = r36
                r9 = r39
                r4 = r41
                r28 = r42
                r12 = r44
                r3 = 4
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r26 = r0
                r3 = r35
                r0 = 3
                java.lang.Object r3 = r2.j(r1, r0, r5, r3)
                r25 = r3
                r3 = r27
                r24 = r37
                r23 = r38
                r4 = r47
                r5 = r49
                r0 = 0
                r27 = r9
                r12 = r11
                r11 = 8
                goto L_0x04d5
            L_0x0436:
                r48 = r0
                r27 = r3
                r47 = r4
                r49 = r5
                r54 = r6
                r6 = r9
                r3 = r35
                r26 = r36
                r9 = r39
                r4 = r41
                r28 = r42
                r12 = r44
                r0 = 3
                kotlinx.serialization.internal.r0 r5 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r0 = kotlinx.serialization.internal.v1.f57779a
                r5.<init>(r0, r0)
                r25 = r3
                r0 = r37
                r3 = 2
                java.lang.Object r37 = r2.j(r1, r3, r5, r0)
                r3 = r27
                r24 = r37
                r23 = r38
                r4 = r47
                r5 = r49
                r0 = 0
                r27 = r9
                r12 = r11
                r11 = 4
                goto L_0x04d5
            L_0x046f:
                r48 = r0
                r27 = r3
                r47 = r4
                r49 = r5
                r54 = r6
                r6 = r9
                r25 = r35
                r26 = r36
                r0 = r37
                r9 = r39
                r4 = r41
                r28 = r42
                r12 = r44
                r3 = 2
                com.sumsub.sentry.s$a r5 = com.sumsub.sentry.s.a.f30494a
                r24 = r0
                r3 = r38
                r0 = 1
                java.lang.Object r38 = r2.j(r1, r0, r5, r3)
                r3 = r27
                r23 = r38
                r4 = r47
                r5 = r49
                r0 = 0
                r27 = r9
                r12 = r11
                r11 = 2
                goto L_0x04d5
            L_0x04a2:
                r48 = r0
                r27 = r3
                r47 = r4
                r49 = r5
                r54 = r6
                r6 = r9
                r25 = r35
                r26 = r36
                r24 = r37
                r3 = r38
                r9 = r39
                r4 = r41
                r28 = r42
                r12 = r44
                r0 = 1
                com.sumsub.sentry.d$b r5 = com.sumsub.sentry.d.b.f30313a
                r23 = r3
                r3 = r34
                r0 = 0
                java.lang.Object r3 = r2.p(r1, r0, r5, r3)
                r34 = r3
                r3 = r27
                r4 = r47
                r5 = r49
                r27 = r9
                r12 = r11
                r11 = 1
            L_0x04d5:
                r9 = r6
            L_0x04d6:
                r6 = r54
            L_0x04d8:
                r33 = r33 | r11
                r11 = r12
                r38 = r23
                r37 = r24
                r35 = r25
                r36 = r26
                r39 = r27
                r12 = r44
                r0 = r48
                goto L_0x0128
            L_0x04eb:
                r48 = r0
                r27 = r3
                r54 = r6
                r6 = r9
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r9 = r39
                r0 = 0
                r43 = r0
                r12 = r44
                r0 = r48
                r9 = r6
                r6 = r54
                goto L_0x0128
            L_0x0508:
                r27 = r3
                r47 = r4
                r49 = r5
                r54 = r6
                r6 = r9
                r44 = r12
                r3 = r34
                r25 = r35
                r26 = r36
                r24 = r37
                r23 = r38
                r9 = r39
                r4 = r41
                r28 = r42
                r12 = r4
                r18 = r7
                r21 = r8
                r4 = r9
                r20 = r10
                r9 = r23
                r8 = r24
                r5 = r25
                r7 = r26
                r0 = r27
                r27 = r33
                r17 = r47
                r24 = r3
                r3 = r54
            L_0x053d:
                r2.c(r1)
                com.sumsub.sentry.z r1 = new com.sumsub.sentry.z
                r2 = r24
                com.sumsub.sentry.d r2 = (com.sumsub.sentry.d) r2
                r29 = r9
                com.sumsub.sentry.s r29 = (com.sumsub.sentry.s) r29
                r30 = r8
                java.util.Map r30 = (java.util.Map) r30
                r31 = r5
                java.lang.String r31 = (java.lang.String) r31
                r32 = r7
                java.lang.String r32 = (java.lang.String) r32
                r33 = r4
                java.lang.String r33 = (java.lang.String) r33
                r34 = r12
                com.sumsub.sentry.q0 r34 = (com.sumsub.sentry.q0) r34
                r35 = r28
                java.lang.String r35 = (java.lang.String) r35
                r36 = r44
                java.lang.String r36 = (java.lang.String) r36
                r37 = r6
                java.util.List r37 = (java.util.List) r37
                r38 = r0
                java.util.Map r38 = (java.util.Map) r38
                com.sumsub.sentry.d0 r21 = (com.sumsub.sentry.d0) r21
                if (r21 == 0) goto L_0x0579
                java.lang.String r0 = r21.b()
                r39 = r0
                goto L_0x057b
            L_0x0579:
                r39 = 0
            L_0x057b:
                r41 = r20
                com.sumsub.sentry.p r41 = (com.sumsub.sentry.p) r41
                r42 = r49
                java.lang.String r42 = (java.lang.String) r42
                r43 = r18
                com.sumsub.sentry.m0 r43 = (com.sumsub.sentry.m0) r43
                r44 = r17
                com.sumsub.sentry.m0 r44 = (com.sumsub.sentry.m0) r44
                r45 = r15
                com.sumsub.sentry.SentryLevel r45 = (com.sumsub.sentry.SentryLevel) r45
                r46 = r14
                java.lang.String r46 = (java.lang.String) r46
                r47 = r3
                java.util.List r47 = (java.util.List) r47
                r48 = r13
                java.util.Map r48 = (java.util.Map) r48
                r49 = r11
                com.sumsub.sentry.g r49 = (com.sumsub.sentry.g) r49
                r50 = 0
                r51 = 0
                r26 = r1
                r28 = r2
                r26.<init>(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.z.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.z");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            m0.b bVar = m0.Companion;
            return new kotlinx.serialization.b[]{d.b.f30313a, h10.a.u(s.a.f30494a), h10.a.u(new r0(v1Var, v1Var)), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(q0.a.f30482a), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(new e(b.a.f30295a)), h10.a.u(new r0(v1Var, new ContextualSerializer(Reflection.b(Object.class), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0]))), d0.a.f30317a, v1Var, h10.a.u(p.a.f30465a), h10.a.u(v1Var), h10.a.u(bVar.serializer(k0.a.f30423a)), h10.a.u(bVar.serializer(a0.a.f30257a)), h10.a.u(SentryLevel.a.f30237a), h10.a.u(v1Var), h10.a.u(new e(v1Var)), h10.a.u(new r0(v1Var, v1Var)), g.a.f30348a};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30545b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(kotlinx.serialization.encoding.d dVar, z zVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            z.a(zVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<z> serializer() {
            return a.f30544a;
        }

        public b() {
        }
    }

    public /* synthetic */ z(int i11, d dVar, s sVar, Map map, String str, String str2, String str3, q0 q0Var, String str4, String str5, List list, Map map2, String str6, String str7, p pVar, String str8, m0 m0Var, m0 m0Var2, SentryLevel sentryLevel, String str9, List list2, Map map3, g gVar, q1 q1Var, r rVar) {
        this(i11, dVar, sVar, map, str, str2, str3, q0Var, str4, str5, list, map2, str6, str7, pVar, str8, m0Var, m0Var2, sentryLevel, str9, list2, map3, gVar, q1Var);
    }

    public static /* synthetic */ void C() {
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

    public static /* synthetic */ void N() {
    }

    public static /* synthetic */ void P() {
    }

    public static /* synthetic */ void R() {
    }

    public static /* synthetic */ void T() {
    }

    public static /* synthetic */ void V() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(com.sumsub.sentry.z r7, kotlinx.serialization.encoding.b r8, kotlinx.serialization.descriptors.f r9) {
        /*
            com.sumsub.sentry.u.a(r7, r8, r9)
            r0 = 11
            boolean r1 = r8.q(r9, r0)
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x000f
            goto L_0x001d
        L_0x000f:
            java.lang.String r1 = r7.j()
            java.lang.String r5 = com.sumsub.sentry.d0.a(r2, r4, r2)
            boolean r1 = com.sumsub.sentry.d0.a((java.lang.String) r1, (java.lang.String) r5)
            if (r1 != 0) goto L_0x001f
        L_0x001d:
            r1 = r4
            goto L_0x0020
        L_0x001f:
            r1 = r3
        L_0x0020:
            if (r1 == 0) goto L_0x002f
            com.sumsub.sentry.d0$a r1 = com.sumsub.sentry.d0.a.f30317a
            java.lang.String r5 = r7.j()
            com.sumsub.sentry.d0 r5 = com.sumsub.sentry.d0.a(r5)
            r8.F(r9, r0, r1, r5)
        L_0x002f:
            r0 = 12
            boolean r1 = r8.q(r9, r0)
            if (r1 == 0) goto L_0x0038
            goto L_0x004a
        L_0x0038:
            java.lang.String r1 = r7.f30534p
            com.sumsub.sentry.e r5 = com.sumsub.sentry.e.f30319a
            java.util.Date r6 = r5.a()
            java.lang.String r5 = r5.a((java.util.Date) r6)
            boolean r1 = kotlin.jvm.internal.x.b(r1, r5)
            if (r1 != 0) goto L_0x004c
        L_0x004a:
            r1 = r4
            goto L_0x004d
        L_0x004c:
            r1 = r3
        L_0x004d:
            if (r1 == 0) goto L_0x0054
            java.lang.String r1 = r7.f30534p
            r8.p(r9, r0, r1)
        L_0x0054:
            r0 = 13
            boolean r1 = r8.q(r9, r0)
            if (r1 == 0) goto L_0x005d
            goto L_0x0061
        L_0x005d:
            com.sumsub.sentry.p r1 = r7.f30535q
            if (r1 == 0) goto L_0x0063
        L_0x0061:
            r1 = r4
            goto L_0x0064
        L_0x0063:
            r1 = r3
        L_0x0064:
            if (r1 == 0) goto L_0x006d
            com.sumsub.sentry.p$a r1 = com.sumsub.sentry.p.a.f30465a
            com.sumsub.sentry.p r5 = r7.f30535q
            r8.y(r9, r0, r1, r5)
        L_0x006d:
            r0 = 14
            boolean r1 = r8.q(r9, r0)
            if (r1 == 0) goto L_0x0076
            goto L_0x007a
        L_0x0076:
            java.lang.String r1 = r7.f30536r
            if (r1 == 0) goto L_0x007c
        L_0x007a:
            r1 = r4
            goto L_0x007d
        L_0x007c:
            r1 = r3
        L_0x007d:
            if (r1 == 0) goto L_0x0086
            kotlinx.serialization.internal.v1 r1 = kotlinx.serialization.internal.v1.f57779a
            java.lang.String r5 = r7.f30536r
            r8.y(r9, r0, r1, r5)
        L_0x0086:
            r0 = 15
            boolean r1 = r8.q(r9, r0)
            if (r1 == 0) goto L_0x008f
            goto L_0x0093
        L_0x008f:
            com.sumsub.sentry.m0<com.sumsub.sentry.k0> r1 = r7.f30537s
            if (r1 == 0) goto L_0x0095
        L_0x0093:
            r1 = r4
            goto L_0x0096
        L_0x0095:
            r1 = r3
        L_0x0096:
            if (r1 == 0) goto L_0x00a5
            com.sumsub.sentry.m0$b r1 = com.sumsub.sentry.m0.Companion
            com.sumsub.sentry.k0$a r5 = com.sumsub.sentry.k0.a.f30423a
            kotlinx.serialization.b r1 = r1.serializer(r5)
            com.sumsub.sentry.m0<com.sumsub.sentry.k0> r5 = r7.f30537s
            r8.y(r9, r0, r1, r5)
        L_0x00a5:
            r0 = 16
            boolean r1 = r8.q(r9, r0)
            if (r1 == 0) goto L_0x00ae
            goto L_0x00b2
        L_0x00ae:
            com.sumsub.sentry.m0<com.sumsub.sentry.a0> r1 = r7.f30538t
            if (r1 == 0) goto L_0x00b4
        L_0x00b2:
            r1 = r4
            goto L_0x00b5
        L_0x00b4:
            r1 = r3
        L_0x00b5:
            if (r1 == 0) goto L_0x00c4
            com.sumsub.sentry.m0$b r1 = com.sumsub.sentry.m0.Companion
            com.sumsub.sentry.a0$a r5 = com.sumsub.sentry.a0.a.f30257a
            kotlinx.serialization.b r1 = r1.serializer(r5)
            com.sumsub.sentry.m0<com.sumsub.sentry.a0> r5 = r7.f30538t
            r8.y(r9, r0, r1, r5)
        L_0x00c4:
            r0 = 17
            boolean r1 = r8.q(r9, r0)
            if (r1 == 0) goto L_0x00cd
            goto L_0x00d1
        L_0x00cd:
            com.sumsub.sentry.SentryLevel r1 = r7.f30539u
            if (r1 == 0) goto L_0x00d3
        L_0x00d1:
            r1 = r4
            goto L_0x00d4
        L_0x00d3:
            r1 = r3
        L_0x00d4:
            if (r1 == 0) goto L_0x00dd
            com.sumsub.sentry.SentryLevel$a r1 = com.sumsub.sentry.SentryLevel.a.f30237a
            com.sumsub.sentry.SentryLevel r5 = r7.f30539u
            r8.y(r9, r0, r1, r5)
        L_0x00dd:
            r0 = 18
            boolean r1 = r8.q(r9, r0)
            if (r1 == 0) goto L_0x00e6
            goto L_0x00ea
        L_0x00e6:
            java.lang.String r1 = r7.f30540v
            if (r1 == 0) goto L_0x00ec
        L_0x00ea:
            r1 = r4
            goto L_0x00ed
        L_0x00ec:
            r1 = r3
        L_0x00ed:
            if (r1 == 0) goto L_0x00f6
            kotlinx.serialization.internal.v1 r1 = kotlinx.serialization.internal.v1.f57779a
            java.lang.String r5 = r7.f30540v
            r8.y(r9, r0, r1, r5)
        L_0x00f6:
            r0 = 19
            boolean r1 = r8.q(r9, r0)
            if (r1 == 0) goto L_0x00ff
            goto L_0x0103
        L_0x00ff:
            java.util.List<java.lang.String> r1 = r7.f30541w
            if (r1 == 0) goto L_0x0105
        L_0x0103:
            r1 = r4
            goto L_0x0106
        L_0x0105:
            r1 = r3
        L_0x0106:
            if (r1 == 0) goto L_0x0114
            kotlinx.serialization.internal.e r1 = new kotlinx.serialization.internal.e
            kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
            r1.<init>(r5)
            java.util.List<java.lang.String> r5 = r7.f30541w
            r8.y(r9, r0, r1, r5)
        L_0x0114:
            r0 = 20
            boolean r1 = r8.q(r9, r0)
            if (r1 == 0) goto L_0x011d
            goto L_0x0121
        L_0x011d:
            java.util.Map<java.lang.String, java.lang.String> r1 = r7.f30542x
            if (r1 == 0) goto L_0x0123
        L_0x0121:
            r1 = r4
            goto L_0x0124
        L_0x0123:
            r1 = r3
        L_0x0124:
            if (r1 == 0) goto L_0x0132
            kotlinx.serialization.internal.r0 r1 = new kotlinx.serialization.internal.r0
            kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
            r1.<init>(r5, r5)
            java.util.Map<java.lang.String, java.lang.String> r5 = r7.f30542x
            r8.y(r9, r0, r1, r5)
        L_0x0132:
            r0 = 21
            boolean r1 = r8.q(r9, r0)
            if (r1 == 0) goto L_0x013b
            goto L_0x0149
        L_0x013b:
            com.sumsub.sentry.g r1 = r7.f30543y
            com.sumsub.sentry.g r5 = new com.sumsub.sentry.g
            r6 = 3
            r5.<init>((com.sumsub.sentry.r) r2, (java.util.List) r2, (int) r6, (kotlin.jvm.internal.r) r2)
            boolean r1 = kotlin.jvm.internal.x.b(r1, r5)
            if (r1 != 0) goto L_0x014a
        L_0x0149:
            r3 = r4
        L_0x014a:
            if (r3 == 0) goto L_0x0153
            com.sumsub.sentry.g$a r1 = com.sumsub.sentry.g.a.f30348a
            com.sumsub.sentry.g r7 = r7.f30543y
            r8.F(r9, r0, r1, r7)
        L_0x0153:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.z.a(com.sumsub.sentry.z, kotlinx.serialization.encoding.b, kotlinx.serialization.descriptors.f):void");
    }

    public final g B() {
        return this.f30543y;
    }

    public final m0<a0> E() {
        return this.f30538t;
    }

    public final List<String> G() {
        return this.f30541w;
    }

    public final SentryLevel I() {
        return this.f30539u;
    }

    public final String K() {
        return this.f30536r;
    }

    public final p M() {
        return this.f30535q;
    }

    public final Map<String, String> O() {
        return this.f30542x;
    }

    public final m0<k0> Q() {
        return this.f30537s;
    }

    public final String S() {
        return this.f30534p;
    }

    public final String U() {
        return this.f30540v;
    }

    public final boolean W() {
        List<a0> a11;
        m0<a0> m0Var = this.f30538t;
        if (m0Var == null || (a11 = m0Var.a()) == null) {
            return false;
        }
        for (a0 a0Var : a11) {
            if (a0Var.a() != null && a0Var.a().e() != null && !a0Var.a().e().booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean X() {
        /*
            r2 = this;
            com.sumsub.sentry.m0<com.sumsub.sentry.a0> r0 = r2.f30538t
            r1 = 1
            if (r0 == 0) goto L_0x0013
            java.util.List r0 = r0.a()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r1
            if (r0 != r1) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r1 = 0
        L_0x0014:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.z.X():boolean");
    }

    public final void b(m0<k0> m0Var) {
        this.f30537s = m0Var;
    }

    public void d(String str) {
        this.f30533o = str;
    }

    public String j() {
        return this.f30533o;
    }

    public /* synthetic */ z(String str, String str2, p pVar, String str3, m0 m0Var, m0 m0Var2, SentryLevel sentryLevel, String str4, List list, Map map, g gVar, r rVar) {
        this(str, str2, pVar, str3, m0Var, m0Var2, sentryLevel, str4, list, map, gVar);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(int i11, d dVar, s sVar, Map<String, String> map, String str, String str2, String str3, q0 q0Var, String str4, String str5, List<b> list, Map<String, Object> map2, String str6, String str7, p pVar, String str8, m0<k0> m0Var, m0<a0> m0Var2, SentryLevel sentryLevel, String str9, List<String> list2, Map<String, String> map3, g gVar, q1 q1Var) {
        super(i11, dVar, sVar, map, str, str2, str3, q0Var, str4, str5, list, map2, q1Var);
        String str10;
        int i12 = i11;
        if ((i12 & 0) != 0) {
            h1.a(i12, 0, a.f30544a.getDescriptor());
        }
        this.f30533o = (i12 & 2048) == 0 ? d0.a((String) null, 1, (r) null) : str6;
        if ((i12 & 4096) == 0) {
            e eVar = e.f30319a;
            str10 = eVar.a(eVar.a());
        } else {
            str10 = str7;
        }
        this.f30534p = str10;
        if ((i12 & 8192) == 0) {
            this.f30535q = null;
        } else {
            this.f30535q = pVar;
        }
        if ((i12 & 16384) == 0) {
            this.f30536r = null;
        } else {
            this.f30536r = str8;
        }
        if ((32768 & i12) == 0) {
            this.f30537s = null;
        } else {
            this.f30537s = m0Var;
        }
        if ((65536 & i12) == 0) {
            this.f30538t = null;
        } else {
            this.f30538t = m0Var2;
        }
        if ((131072 & i12) == 0) {
            this.f30539u = null;
        } else {
            this.f30539u = sentryLevel;
        }
        if ((262144 & i12) == 0) {
            this.f30540v = null;
        } else {
            this.f30540v = str9;
        }
        if ((524288 & i12) == 0) {
            this.f30541w = null;
        } else {
            this.f30541w = list2;
        }
        if ((1048576 & i12) == 0) {
            this.f30542x = null;
        } else {
            this.f30542x = map3;
        }
        this.f30543y = (2097152 & i12) == 0 ? new g((r) null, (List) null, 3, (r) null) : gVar;
    }

    public final void a(m0<a0> m0Var) {
        this.f30538t = m0Var;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ z(java.lang.String r14, java.lang.String r15, com.sumsub.sentry.p r16, java.lang.String r17, com.sumsub.sentry.m0 r18, com.sumsub.sentry.m0 r19, com.sumsub.sentry.SentryLevel r20, java.lang.String r21, java.util.List r22, java.util.Map r23, com.sumsub.sentry.g r24, int r25, kotlin.jvm.internal.r r26) {
        /*
            r13 = this;
            r0 = r25
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000d
            r1 = 1
            java.lang.String r1 = com.sumsub.sentry.d0.a(r2, r1, r2)
            goto L_0x000e
        L_0x000d:
            r1 = r14
        L_0x000e:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001d
            com.sumsub.sentry.e r3 = com.sumsub.sentry.e.f30319a
            java.util.Date r4 = r3.a()
            java.lang.String r3 = r3.a((java.util.Date) r4)
            goto L_0x001e
        L_0x001d:
            r3 = r15
        L_0x001e:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0024
            r4 = r2
            goto L_0x0026
        L_0x0024:
            r4 = r16
        L_0x0026:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x002c
            r5 = r2
            goto L_0x002e
        L_0x002c:
            r5 = r17
        L_0x002e:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0034
            r6 = r2
            goto L_0x0036
        L_0x0034:
            r6 = r18
        L_0x0036:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x003c
            r7 = r2
            goto L_0x003e
        L_0x003c:
            r7 = r19
        L_0x003e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0044
            r8 = r2
            goto L_0x0046
        L_0x0044:
            r8 = r20
        L_0x0046:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x004c
            r9 = r2
            goto L_0x004e
        L_0x004c:
            r9 = r21
        L_0x004e:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0054
            r10 = r2
            goto L_0x0056
        L_0x0054:
            r10 = r22
        L_0x0056:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x005c
            r11 = r2
            goto L_0x005e
        L_0x005c:
            r11 = r23
        L_0x005e:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0069
            com.sumsub.sentry.g r0 = new com.sumsub.sentry.g
            r12 = 3
            r0.<init>((com.sumsub.sentry.r) r2, (java.util.List) r2, (int) r12, (kotlin.jvm.internal.r) r2)
            goto L_0x006b
        L_0x0069:
            r0 = r24
        L_0x006b:
            r2 = 0
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r0
            r26 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.z.<init>(java.lang.String, java.lang.String, com.sumsub.sentry.p, java.lang.String, com.sumsub.sentry.m0, com.sumsub.sentry.m0, com.sumsub.sentry.SentryLevel, java.lang.String, java.util.List, java.util.Map, com.sumsub.sentry.g, int, kotlin.jvm.internal.r):void");
    }

    public z(String str, String str2, p pVar, String str3, m0<k0> m0Var, m0<a0> m0Var2, SentryLevel sentryLevel, String str4, List<String> list, Map<String, String> map, g gVar) {
        this.f30533o = str;
        this.f30534p = str2;
        this.f30535q = pVar;
        this.f30536r = str3;
        this.f30537s = m0Var;
        this.f30538t = m0Var2;
        this.f30539u = sentryLevel;
        this.f30540v = str4;
        this.f30541w = list;
        this.f30542x = map;
        this.f30543y = gVar;
    }
}
