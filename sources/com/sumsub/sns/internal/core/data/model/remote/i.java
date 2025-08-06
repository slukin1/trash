package com.sumsub.sns.internal.core.data.model.remote;

import com.sumsub.sns.core.data.model.FlowActionType;
import com.sumsub.sns.core.data.model.FlowType;
import com.sumsub.sns.core.data.model.FlowType$$serializer;
import com.sumsub.sns.internal.core.data.model.remote.a;
import com.sumsub.sns.internal.core.data.model.remote.c;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 i2\u00020\u0001:\u0002\b\u0015B\u0002\u0012\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\n\u0012\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\t\u0012\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bc\u0010dB¯\u0002\b\u0017\u0012\u0006\u0010e\u001a\u000201\u0012\u0016\b\u0001\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\n\u0012\u0016\b\u0001\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\u0016\b\u0001\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\u0016\b\u0001\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\t\u0012\u0016\b\u0001\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\u0016\b\u0001\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0001\u0010.\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010/\u001a\u0004\u0018\u00010\n\u0012\b\u0010g\u001a\u0004\u0018\u00010f¢\u0006\u0004\bc\u0010hJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0017\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tHÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tHÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\tHÆ\u0003J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tHÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0002\u0010\b\u001a\u00020\u00002\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\t2\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0001J\t\u00100\u001a\u00020\nHÖ\u0001J\t\u00102\u001a\u000201HÖ\u0001J\u0013\u00105\u001a\u0002042\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003R.\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u00106\u0012\u0004\b9\u0010:\u001a\u0004\b7\u00108R\"\u0010 \u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010;\u0012\u0004\b>\u0010:\u001a\u0004\b<\u0010=R\"\u0010!\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010;\u0012\u0004\b@\u0010:\u001a\u0004\b?\u0010=R\"\u0010\"\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010A\u0012\u0004\bD\u0010:\u001a\u0004\bB\u0010CR\"\u0010#\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010;\u0012\u0004\bF\u0010:\u001a\u0004\bE\u0010=R\"\u0010$\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001a\u0010;\u0012\u0004\bH\u0010:\u001a\u0004\bG\u0010=R\"\u0010%\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001c\u0010I\u0012\u0004\bL\u0010:\u001a\u0004\bJ\u0010KR\"\u0010&\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001d\u0010;\u0012\u0004\bN\u0010:\u001a\u0004\bM\u0010=R\"\u0010'\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001e\u0010;\u0012\u0004\bP\u0010:\u001a\u0004\bO\u0010=R.\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u00106\u0012\u0004\bR\u0010:\u001a\u0004\bQ\u00108R.\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u00106\u0012\u0004\bT\u0010:\u001a\u0004\bS\u00108R.\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u00106\u0012\u0004\bV\u0010:\u001a\u0004\bU\u00108R.\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u00106\u0012\u0004\bX\u0010:\u001a\u0004\bW\u00108R.\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u00106\u0012\u0004\bZ\u0010:\u001a\u0004\bY\u00108R\"\u0010-\u001a\u0004\u0018\u00010\u001b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010[\u0012\u0004\b^\u0010:\u001a\u0004\b\\\u0010]R\"\u0010.\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010;\u0012\u0004\b`\u0010:\u001a\u0004\b_\u0010=R\"\u0010/\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010;\u0012\u0004\bb\u0010:\u001a\u0004\ba\u0010=¨\u0006j"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/i;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "", "j", "k", "Lcom/sumsub/sns/core/data/model/FlowType;", "l", "m", "n", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "o", "p", "q", "b", "c", "Lcom/sumsub/sns/internal/core/data/model/remote/c;", "d", "e", "f", "Lcom/sumsub/sns/internal/core/data/model/remote/a;", "g", "h", "i", "uiConf", "applicantId", "flowName", "flowType", "idDocSetType", "actionId", "actionType", "faceLivenessLic", "facemapPublicKey", "sdkDict", "documentsByCountries", "phoneCountryCodeWithMasks", "tinCountryInfo", "initMetadata", "eKycConfig", "verificationUrl", "accessToken", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/Map;", "V", "()Ljava/util/Map;", "getUiConf$annotations", "()V", "Ljava/lang/String;", "x", "()Ljava/lang/String;", "getApplicantId$annotations", "H", "getFlowName$annotations", "Lcom/sumsub/sns/core/data/model/FlowType;", "J", "()Lcom/sumsub/sns/core/data/model/FlowType;", "getFlowType$annotations", "L", "getIdDocSetType$annotations", "t", "getActionId$annotations", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "v", "()Lcom/sumsub/sns/core/data/model/FlowActionType;", "getActionType$annotations", "D", "getFaceLivenessLic$annotations", "F", "getFacemapPublicKey$annotations", "R", "getSdkDict$annotations", "z", "getDocumentsByCountries$annotations", "P", "getPhoneCountryCodeWithMasks$annotations", "T", "getTinCountryInfo$annotations", "N", "getInitMetadata$annotations", "Lcom/sumsub/sns/internal/core/data/model/remote/a;", "B", "()Lcom/sumsub/sns/internal/core/data/model/remote/a;", "getEKycConfig$annotations", "X", "getVerificationUrl$annotations", "r", "getAccessToken$annotations", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowType;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/sumsub/sns/internal/core/data/model/remote/a;Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowType;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/sumsub/sns/internal/core/data/model/remote/a;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class i {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f32748a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32749b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32750c;

    /* renamed from: d  reason: collision with root package name */
    public final FlowType f32751d;

    /* renamed from: e  reason: collision with root package name */
    public final String f32752e;

    /* renamed from: f  reason: collision with root package name */
    public final String f32753f;

    /* renamed from: g  reason: collision with root package name */
    public final FlowActionType f32754g;

    /* renamed from: h  reason: collision with root package name */
    public final String f32755h;

    /* renamed from: i  reason: collision with root package name */
    public final String f32756i;

    /* renamed from: j  reason: collision with root package name */
    public final Map<Object, Object> f32757j;

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, Object> f32758k;

    /* renamed from: l  reason: collision with root package name */
    public final Map<String, c> f32759l;

    /* renamed from: m  reason: collision with root package name */
    public final Map<String, Object> f32760m;

    /* renamed from: n  reason: collision with root package name */
    public final Map<String, String> f32761n;

    /* renamed from: o  reason: collision with root package name */
    public final a f32762o;

    /* renamed from: p  reason: collision with root package name */
    public final String f32763p;

    /* renamed from: q  reason: collision with root package name */
    public final String f32764q;

    public static final class a implements d0<i> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32765a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32766b;

        static {
            a aVar = new a();
            f32765a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.RemoteConfig", aVar, 17);
            pluginGeneratedSerialDescriptor.k("uiConf", true);
            pluginGeneratedSerialDescriptor.k("applicantId", true);
            pluginGeneratedSerialDescriptor.k("flowName", true);
            pluginGeneratedSerialDescriptor.k("flowType", true);
            pluginGeneratedSerialDescriptor.k("idDocSetType", true);
            pluginGeneratedSerialDescriptor.k(TUIConstants.TUIChat.INPUT_MORE_ACTION_ID, true);
            pluginGeneratedSerialDescriptor.k("actionType", true);
            pluginGeneratedSerialDescriptor.k("faceLivenessLic", true);
            pluginGeneratedSerialDescriptor.k("facemapPublicKey", true);
            pluginGeneratedSerialDescriptor.k("sdkDict", false);
            pluginGeneratedSerialDescriptor.k("documentsByCountries", true);
            pluginGeneratedSerialDescriptor.k("phoneCountryCodeWithMasks", true);
            pluginGeneratedSerialDescriptor.k("tinCountryInfo", true);
            pluginGeneratedSerialDescriptor.k("initMetadata", true);
            pluginGeneratedSerialDescriptor.k("eKycConfig", true);
            pluginGeneratedSerialDescriptor.k("verificationUrl", true);
            pluginGeneratedSerialDescriptor.k("accessToken", true);
            f32766b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x012c, code lost:
            r9 = r9 | r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0150, code lost:
            r11 = r27;
            r10 = r28;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x01cf, code lost:
            r11 = r27;
            r10 = r28;
            r4 = r29;
            r6 = r30;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x024a, code lost:
            r4 = r29;
            r6 = r30;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x02e8, code lost:
            r10 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x02e9, code lost:
            r4 = r29;
            r6 = r30;
            r12 = r31;
            r13 = r32;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x02f1, code lost:
            r3 = r33;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0391, code lost:
            r12 = r31;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0393, code lost:
            r13 = r32;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.model.remote.i deserialize(kotlinx.serialization.encoding.c r45) {
            /*
                r44 = this;
                java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                kotlinx.serialization.descriptors.f r1 = r44.getDescriptor()
                r2 = r45
                kotlinx.serialization.encoding.a r2 = r2.b(r1)
                boolean r3 = r2.k()
                r12 = 6
                r13 = 5
                r14 = 3
                r4 = 4
                r5 = 2
                r6 = 1
                r7 = 0
                r8 = 0
                if (r3 == 0) goto L_0x00e5
                kotlinx.serialization.internal.r0 r3 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                kotlinx.serialization.ContextualSerializer r10 = new kotlinx.serialization.ContextualSerializer
                kotlin.reflect.c r15 = kotlin.jvm.internal.Reflection.b(r0)
                kotlinx.serialization.b[] r11 = new kotlinx.serialization.b[r7]
                r10.<init>(r15, r8, r11)
                r3.<init>(r9, r10)
                java.lang.Object r3 = r2.j(r1, r7, r3, r8)
                java.lang.Object r6 = r2.j(r1, r6, r9, r8)
                java.lang.Object r5 = r2.j(r1, r5, r9, r8)
                com.sumsub.sns.core.data.model.FlowType$$serializer r10 = com.sumsub.sns.core.data.model.FlowType$$serializer.INSTANCE
                java.lang.Object r10 = r2.j(r1, r14, r10, r8)
                java.lang.Object r4 = r2.j(r1, r4, r9, r8)
                java.lang.Object r11 = r2.j(r1, r13, r9, r8)
                com.sumsub.sns.internal.core.data.serializer.b r13 = com.sumsub.sns.internal.core.data.serializer.b.f32958a
                java.lang.Object r12 = r2.j(r1, r12, r13, r8)
                r13 = 7
                java.lang.Object r13 = r2.j(r1, r13, r9, r8)
                r14 = 8
                java.lang.Object r14 = r2.j(r1, r14, r9, r8)
                kotlinx.serialization.internal.r0 r15 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.ContextualSerializer r8 = new kotlinx.serialization.ContextualSerializer
                r17 = r3
                kotlin.reflect.c r3 = kotlin.jvm.internal.Reflection.b(r0)
                r18 = r4
                kotlinx.serialization.b[] r4 = new kotlinx.serialization.b[r7]
                r7 = 0
                r8.<init>(r3, r7, r4)
                kotlinx.serialization.ContextualSerializer r3 = new kotlinx.serialization.ContextualSerializer
                kotlin.reflect.c r4 = kotlin.jvm.internal.Reflection.b(r0)
                r19 = r5
                r20 = r6
                r5 = 0
                kotlinx.serialization.b[] r6 = new kotlinx.serialization.b[r5]
                r3.<init>(r4, r7, r6)
                r15.<init>(r8, r3)
                r3 = 9
                java.lang.Object r3 = r2.j(r1, r3, r15, r7)
                kotlinx.serialization.internal.r0 r4 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.ContextualSerializer r6 = new kotlinx.serialization.ContextualSerializer
                kotlin.reflect.c r8 = kotlin.jvm.internal.Reflection.b(r0)
                kotlinx.serialization.b[] r15 = new kotlinx.serialization.b[r5]
                r6.<init>(r8, r7, r15)
                r4.<init>(r9, r6)
                r6 = 10
                java.lang.Object r4 = r2.j(r1, r6, r4, r7)
                kotlinx.serialization.internal.r0 r6 = new kotlinx.serialization.internal.r0
                com.sumsub.sns.internal.core.data.model.remote.c$a r8 = com.sumsub.sns.internal.core.data.model.remote.c.a.f32707a
                r6.<init>(r9, r8)
                r8 = 11
                java.lang.Object r6 = r2.j(r1, r8, r6, r7)
                kotlinx.serialization.internal.r0 r8 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.ContextualSerializer r15 = new kotlinx.serialization.ContextualSerializer
                kotlin.reflect.c r0 = kotlin.jvm.internal.Reflection.b(r0)
                kotlinx.serialization.b[] r5 = new kotlinx.serialization.b[r5]
                r15.<init>(r0, r7, r5)
                r8.<init>(r9, r15)
                r0 = 12
                java.lang.Object r0 = r2.j(r1, r0, r8, r7)
                kotlinx.serialization.internal.r0 r5 = new kotlinx.serialization.internal.r0
                r5.<init>(r9, r9)
                r8 = 13
                java.lang.Object r5 = r2.j(r1, r8, r5, r7)
                com.sumsub.sns.internal.core.data.model.remote.a$a r8 = com.sumsub.sns.internal.core.data.model.remote.a.C0344a.f32697a
                r15 = 14
                java.lang.Object r8 = r2.j(r1, r15, r8, r7)
                r15 = 15
                java.lang.Object r15 = r2.j(r1, r15, r9, r7)
                r16 = r6
                r6 = 16
                java.lang.Object r6 = r2.j(r1, r6, r9, r7)
                r7 = 131071(0x1ffff, float:1.8367E-40)
                r24 = r7
                r22 = r18
                goto L_0x03cb
            L_0x00e5:
                r3 = r6
                r26 = r3
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
                r21 = 0
                r22 = 0
                r23 = 0
                r24 = 0
                r25 = 0
            L_0x00ff:
                if (r26 == 0) goto L_0x0397
                r27 = r11
                int r11 = r2.w(r1)
                switch(r11) {
                    case -1: goto L_0x0376;
                    case 0: goto L_0x0327;
                    case 1: goto L_0x02f5;
                    case 2: goto L_0x02ca;
                    case 3: goto L_0x02ac;
                    case 4: goto L_0x028e;
                    case 5: goto L_0x0271;
                    case 6: goto L_0x0250;
                    case 7: goto L_0x022d;
                    case 8: goto L_0x0212;
                    case 9: goto L_0x01d9;
                    case 10: goto L_0x01a5;
                    case 11: goto L_0x017e;
                    case 12: goto L_0x0155;
                    case 13: goto L_0x013d;
                    case 14: goto L_0x012e;
                    case 15: goto L_0x011d;
                    case 16: goto L_0x0110;
                    default: goto L_0x010a;
                }
            L_0x010a:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r11)
                throw r0
            L_0x0110:
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                r28 = r10
                r10 = 16
                java.lang.Object r6 = r2.j(r1, r10, r11, r6)
                r11 = 65536(0x10000, float:9.18355E-41)
                goto L_0x012c
            L_0x011d:
                r28 = r10
                r10 = 16
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                r10 = 15
                java.lang.Object r12 = r2.j(r1, r10, r11, r12)
                r11 = 32768(0x8000, float:4.5918E-41)
            L_0x012c:
                r9 = r9 | r11
                goto L_0x0150
            L_0x012e:
                r28 = r10
                r10 = 15
                com.sumsub.sns.internal.core.data.model.remote.a$a r11 = com.sumsub.sns.internal.core.data.model.remote.a.C0344a.f32697a
                r10 = 14
                java.lang.Object r13 = r2.j(r1, r10, r11, r13)
                r9 = r9 | 16384(0x4000, float:2.2959E-41)
                goto L_0x0150
            L_0x013d:
                r28 = r10
                r10 = 14
                kotlinx.serialization.internal.r0 r11 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r10 = kotlinx.serialization.internal.v1.f57779a
                r11.<init>(r10, r10)
                r10 = 13
                java.lang.Object r4 = r2.j(r1, r10, r11, r4)
                r9 = r9 | 8192(0x2000, float:1.14794E-41)
            L_0x0150:
                r11 = r27
                r10 = r28
                goto L_0x00ff
            L_0x0155:
                r28 = r10
                r10 = 13
                kotlinx.serialization.internal.r0 r11 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r10 = kotlinx.serialization.internal.v1.f57779a
                r29 = r4
                kotlinx.serialization.ContextualSerializer r4 = new kotlinx.serialization.ContextualSerializer
                r30 = r6
                kotlin.reflect.c r6 = kotlin.jvm.internal.Reflection.b(r0)
                r31 = r12
                r32 = r13
                r12 = 0
                kotlinx.serialization.b[] r13 = new kotlinx.serialization.b[r12]
                r12 = 0
                r4.<init>(r6, r12, r13)
                r11.<init>(r10, r4)
                r4 = 12
                java.lang.Object r14 = r2.j(r1, r4, r11, r14)
                r9 = r9 | 4096(0x1000, float:5.74E-42)
                goto L_0x01cf
            L_0x017e:
                r29 = r4
                r30 = r6
                r28 = r10
                r31 = r12
                r32 = r13
                r4 = 12
                kotlinx.serialization.internal.r0 r6 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r10 = kotlinx.serialization.internal.v1.f57779a
                com.sumsub.sns.internal.core.data.model.remote.c$a r11 = com.sumsub.sns.internal.core.data.model.remote.c.a.f32707a
                r6.<init>(r10, r11)
                r10 = 11
                java.lang.Object r5 = r2.j(r1, r10, r6, r5)
                r9 = r9 | 2048(0x800, float:2.87E-42)
                r11 = r27
                r10 = r28
                r4 = r29
                r6 = r30
                goto L_0x00ff
            L_0x01a5:
                r29 = r4
                r30 = r6
                r28 = r10
                r31 = r12
                r32 = r13
                r4 = 12
                r10 = 11
                kotlinx.serialization.internal.r0 r6 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                kotlinx.serialization.ContextualSerializer r12 = new kotlinx.serialization.ContextualSerializer
                kotlin.reflect.c r13 = kotlin.jvm.internal.Reflection.b(r0)
                r4 = 0
                kotlinx.serialization.b[] r10 = new kotlinx.serialization.b[r4]
                r4 = 0
                r12.<init>(r13, r4, r10)
                r6.<init>(r11, r12)
                r10 = 10
                java.lang.Object r3 = r2.j(r1, r10, r6, r3)
                r9 = r9 | 1024(0x400, float:1.435E-42)
            L_0x01cf:
                r11 = r27
                r10 = r28
                r4 = r29
                r6 = r30
                goto L_0x0391
            L_0x01d9:
                r29 = r4
                r30 = r6
                r28 = r10
                r31 = r12
                r32 = r13
                r4 = 0
                r10 = 10
                kotlinx.serialization.internal.r0 r6 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.ContextualSerializer r11 = new kotlinx.serialization.ContextualSerializer
                kotlin.reflect.c r12 = kotlin.jvm.internal.Reflection.b(r0)
                r13 = 0
                kotlinx.serialization.b[] r10 = new kotlinx.serialization.b[r13]
                r11.<init>(r12, r4, r10)
                kotlinx.serialization.ContextualSerializer r10 = new kotlinx.serialization.ContextualSerializer
                kotlin.reflect.c r12 = kotlin.jvm.internal.Reflection.b(r0)
                r33 = r3
                kotlinx.serialization.b[] r3 = new kotlinx.serialization.b[r13]
                r10.<init>(r12, r4, r3)
                r6.<init>(r11, r10)
                r3 = 9
                java.lang.Object r15 = r2.j(r1, r3, r6, r15)
                r9 = r9 | 512(0x200, float:7.175E-43)
                r11 = r27
                r10 = r28
                goto L_0x02e9
            L_0x0212:
                r33 = r3
                r29 = r4
                r30 = r6
                r28 = r10
                r31 = r12
                r32 = r13
                r3 = 9
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                r6 = 8
                java.lang.Object r8 = r2.j(r1, r6, r4, r8)
                r9 = r9 | 256(0x100, float:3.59E-43)
                r11 = r27
                goto L_0x024a
            L_0x022d:
                r33 = r3
                r29 = r4
                r30 = r6
                r28 = r10
                r31 = r12
                r32 = r13
                r3 = 9
                r6 = 8
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                r10 = 7
                java.lang.Object r7 = r2.j(r1, r10, r4, r7)
                r9 = r9 | 128(0x80, float:1.794E-43)
                r11 = r27
                r10 = r28
            L_0x024a:
                r4 = r29
                r6 = r30
                goto L_0x02f1
            L_0x0250:
                r33 = r3
                r29 = r4
                r30 = r6
                r28 = r10
                r31 = r12
                r32 = r13
                r3 = 9
                r6 = 8
                r10 = 7
                com.sumsub.sns.internal.core.data.serializer.b r4 = com.sumsub.sns.internal.core.data.serializer.b.f32958a
                r12 = r28
                r13 = 6
                java.lang.Object r4 = r2.j(r1, r13, r4, r12)
                r9 = r9 | 64
                r10 = r4
                r11 = r27
                goto L_0x02e9
            L_0x0271:
                r33 = r3
                r29 = r4
                r30 = r6
                r31 = r12
                r32 = r13
                r3 = 9
                r6 = 8
                r13 = 6
                r12 = r10
                r10 = 7
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                r11 = r27
                r3 = 5
                java.lang.Object r11 = r2.j(r1, r3, r4, r11)
                r9 = r9 | 32
                goto L_0x02e8
            L_0x028e:
                r33 = r3
                r29 = r4
                r30 = r6
                r31 = r12
                r32 = r13
                r11 = r27
                r3 = 5
                r6 = 8
                r13 = 6
                r12 = r10
                r10 = 7
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                r3 = r25
                r6 = 4
                java.lang.Object r25 = r2.j(r1, r6, r4, r3)
                r9 = r9 | 16
                goto L_0x02e8
            L_0x02ac:
                r33 = r3
                r29 = r4
                r30 = r6
                r31 = r12
                r32 = r13
                r3 = r25
                r11 = r27
                r6 = 4
                r13 = 6
                r12 = r10
                r10 = 7
                com.sumsub.sns.core.data.model.FlowType$$serializer r4 = com.sumsub.sns.core.data.model.FlowType$$serializer.INSTANCE
                r6 = r24
                r10 = 3
                java.lang.Object r24 = r2.j(r1, r10, r4, r6)
                r9 = r9 | 8
                goto L_0x02e8
            L_0x02ca:
                r33 = r3
                r29 = r4
                r30 = r6
                r31 = r12
                r32 = r13
                r6 = r24
                r3 = r25
                r11 = r27
                r13 = 6
                r12 = r10
                r10 = 3
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                r10 = r23
                r13 = 2
                java.lang.Object r23 = r2.j(r1, r13, r4, r10)
                r9 = r9 | 4
            L_0x02e8:
                r10 = r12
            L_0x02e9:
                r4 = r29
                r6 = r30
                r12 = r31
                r13 = r32
            L_0x02f1:
                r3 = r33
                goto L_0x00ff
            L_0x02f5:
                r33 = r3
                r29 = r4
                r30 = r6
                r31 = r12
                r32 = r13
                r6 = r24
                r3 = r25
                r11 = r27
                r13 = 2
                r12 = r10
                r10 = r23
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                r13 = r22
                r22 = r3
                r3 = 1
                java.lang.Object r4 = r2.j(r1, r3, r4, r13)
                r9 = r9 | 2
                r10 = r12
                r25 = r22
                r6 = r30
                r12 = r31
                r13 = r32
                r3 = r33
                r22 = r4
                r4 = r29
                goto L_0x00ff
            L_0x0327:
                r33 = r3
                r29 = r4
                r30 = r6
                r31 = r12
                r32 = r13
                r13 = r22
                r6 = r24
                r22 = r25
                r11 = r27
                r3 = 1
                r12 = r10
                r10 = r23
                kotlinx.serialization.internal.r0 r4 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                r23 = r5
                kotlinx.serialization.ContextualSerializer r5 = new kotlinx.serialization.ContextualSerializer
                kotlin.reflect.c r6 = kotlin.jvm.internal.Reflection.b(r0)
                r25 = r0
                r20 = r7
                r0 = 0
                kotlinx.serialization.b[] r7 = new kotlinx.serialization.b[r0]
                r0 = 0
                r5.<init>(r6, r0, r7)
                r4.<init>(r3, r5)
                r3 = r21
                r5 = 0
                java.lang.Object r21 = r2.j(r1, r5, r4, r3)
                r9 = r9 | 1
                r7 = r20
                r5 = r23
                r0 = r25
                r4 = r29
                r6 = r30
                r3 = r33
                r23 = r10
                r10 = r12
                r25 = r22
                r12 = r31
                r22 = r13
                goto L_0x0393
            L_0x0376:
                r33 = r3
                r31 = r12
                r32 = r13
                r13 = r22
                r22 = r25
                r12 = r10
                r10 = r23
                r23 = r5
                r5 = 0
                r26 = r5
                r5 = r23
                r11 = r27
                r23 = r10
                r10 = r12
                r22 = r13
            L_0x0391:
                r12 = r31
            L_0x0393:
                r13 = r32
                goto L_0x00ff
            L_0x0397:
                r33 = r3
                r29 = r4
                r30 = r6
                r20 = r7
                r27 = r11
                r31 = r12
                r32 = r13
                r3 = r21
                r13 = r22
                r22 = r25
                r12 = r10
                r10 = r23
                r23 = r5
                r17 = r3
                r19 = r10
                r0 = r14
                r3 = r15
                r16 = r23
                r10 = r24
                r5 = r29
                r15 = r31
                r4 = r33
                r14 = r8
                r24 = r9
                r8 = r32
                r43 = r20
                r20 = r13
                r13 = r43
            L_0x03cb:
                r2.c(r1)
                com.sumsub.sns.internal.core.data.model.remote.i r1 = new com.sumsub.sns.internal.core.data.model.remote.i
                r23 = r1
                r25 = r17
                java.util.Map r25 = (java.util.Map) r25
                r26 = r20
                java.lang.String r26 = (java.lang.String) r26
                r27 = r19
                java.lang.String r27 = (java.lang.String) r27
                r28 = r10
                com.sumsub.sns.core.data.model.FlowType r28 = (com.sumsub.sns.core.data.model.FlowType) r28
                r29 = r22
                java.lang.String r29 = (java.lang.String) r29
                r30 = r11
                java.lang.String r30 = (java.lang.String) r30
                r31 = r12
                com.sumsub.sns.core.data.model.FlowActionType r31 = (com.sumsub.sns.core.data.model.FlowActionType) r31
                r32 = r13
                java.lang.String r32 = (java.lang.String) r32
                r33 = r14
                java.lang.String r33 = (java.lang.String) r33
                r34 = r3
                java.util.Map r34 = (java.util.Map) r34
                r35 = r4
                java.util.Map r35 = (java.util.Map) r35
                r36 = r16
                java.util.Map r36 = (java.util.Map) r36
                r37 = r0
                java.util.Map r37 = (java.util.Map) r37
                r38 = r5
                java.util.Map r38 = (java.util.Map) r38
                r39 = r8
                com.sumsub.sns.internal.core.data.model.remote.a r39 = (com.sumsub.sns.internal.core.data.model.remote.a) r39
                r40 = r15
                java.lang.String r40 = (java.lang.String) r40
                r41 = r6
                java.lang.String r41 = (java.lang.String) r41
                r42 = 0
                r23.<init>((int) r24, (java.util.Map) r25, (java.lang.String) r26, (java.lang.String) r27, (com.sumsub.sns.core.data.model.FlowType) r28, (java.lang.String) r29, (java.lang.String) r30, (com.sumsub.sns.core.data.model.FlowActionType) r31, (java.lang.String) r32, (java.lang.String) r33, (java.util.Map) r34, (java.util.Map) r35, (java.util.Map) r36, (java.util.Map) r37, (java.util.Map) r38, (com.sumsub.sns.internal.core.data.model.remote.a) r39, (java.lang.String) r40, (java.lang.String) r41, (kotlinx.serialization.internal.q1) r42)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.i.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.i");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            Class<Object> cls = Object.class;
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(new r0(v1Var, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0]))), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(FlowType$$serializer.INSTANCE), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(com.sumsub.sns.internal.core.data.serializer.b.f32958a), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(new r0(new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0]), new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0]))), h10.a.u(new r0(v1Var, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0]))), h10.a.u(new r0(v1Var, c.a.f32707a)), h10.a.u(new r0(v1Var, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0]))), h10.a.u(new r0(v1Var, v1Var)), h10.a.u(a.C0344a.f32697a), h10.a.u(v1Var), h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32766b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, i iVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            i.a(iVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<i> serializer() {
            return a.f32765a;
        }

        public b() {
        }
    }

    public /* synthetic */ i(int i11, Map map, String str, String str2, FlowType flowType, String str3, String str4, FlowActionType flowActionType, String str5, String str6, Map map2, Map map3, Map map4, Map map5, Map map6, a aVar, String str7, String str8, q1 q1Var) {
        int i12 = i11;
        if (512 != (i12 & 512)) {
            h1.a(i11, 512, a.f32765a.getDescriptor());
        }
        if ((i12 & 1) == 0) {
            this.f32748a = null;
        } else {
            this.f32748a = map;
        }
        if ((i12 & 2) == 0) {
            this.f32749b = null;
        } else {
            this.f32749b = str;
        }
        if ((i12 & 4) == 0) {
            this.f32750c = null;
        } else {
            this.f32750c = str2;
        }
        if ((i12 & 8) == 0) {
            this.f32751d = null;
        } else {
            this.f32751d = flowType;
        }
        if ((i12 & 16) == 0) {
            this.f32752e = null;
        } else {
            this.f32752e = str3;
        }
        if ((i12 & 32) == 0) {
            this.f32753f = null;
        } else {
            this.f32753f = str4;
        }
        if ((i12 & 64) == 0) {
            this.f32754g = null;
        } else {
            this.f32754g = flowActionType;
        }
        if ((i12 & 128) == 0) {
            this.f32755h = null;
        } else {
            this.f32755h = str5;
        }
        if ((i12 & 256) == 0) {
            this.f32756i = null;
        } else {
            this.f32756i = str6;
        }
        this.f32757j = map2;
        if ((i12 & 1024) == 0) {
            this.f32758k = null;
        } else {
            this.f32758k = map3;
        }
        if ((i12 & 2048) == 0) {
            this.f32759l = null;
        } else {
            this.f32759l = map4;
        }
        if ((i12 & 4096) == 0) {
            this.f32760m = null;
        } else {
            this.f32760m = map5;
        }
        if ((i12 & 8192) == 0) {
            this.f32761n = null;
        } else {
            this.f32761n = map6;
        }
        if ((i12 & 16384) == 0) {
            this.f32762o = null;
        } else {
            this.f32762o = aVar;
        }
        if ((32768 & i12) == 0) {
            this.f32763p = null;
        } else {
            this.f32763p = str7;
        }
        if ((i12 & 65536) == 0) {
            this.f32764q = null;
        } else {
            this.f32764q = str8;
        }
    }

    public static /* synthetic */ void A() {
    }

    public static /* synthetic */ void C() {
    }

    public static /* synthetic */ void E() {
    }

    public static /* synthetic */ void G() {
    }

    public static /* synthetic */ void I() {
    }

    public static /* synthetic */ void K() {
    }

    public static /* synthetic */ void M() {
    }

    public static /* synthetic */ void O() {
    }

    public static /* synthetic */ void Q() {
    }

    public static /* synthetic */ void S() {
    }

    public static /* synthetic */ void U() {
    }

    public static /* synthetic */ void W() {
    }

    public static /* synthetic */ void Y() {
    }

    public static /* synthetic */ void s() {
    }

    public static /* synthetic */ void u() {
    }

    public static /* synthetic */ void w() {
    }

    public static /* synthetic */ void y() {
    }

    public final a B() {
        return this.f32762o;
    }

    public final String D() {
        return this.f32755h;
    }

    public final String F() {
        return this.f32756i;
    }

    public final String H() {
        return this.f32750c;
    }

    public final FlowType J() {
        return this.f32751d;
    }

    public final String L() {
        return this.f32752e;
    }

    public final Map<String, String> N() {
        return this.f32761n;
    }

    public final Map<String, c> P() {
        return this.f32759l;
    }

    public final Map<Object, Object> R() {
        return this.f32757j;
    }

    public final Map<String, Object> T() {
        return this.f32760m;
    }

    public final Map<String, Object> V() {
        return this.f32748a;
    }

    public final String X() {
        return this.f32763p;
    }

    public final Map<String, Object> a() {
        return this.f32748a;
    }

    public final Map<Object, Object> b() {
        return this.f32757j;
    }

    public final Map<String, Object> c() {
        return this.f32758k;
    }

    public final Map<String, c> d() {
        return this.f32759l;
    }

    public final Map<String, Object> e() {
        return this.f32760m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return x.b(this.f32748a, iVar.f32748a) && x.b(this.f32749b, iVar.f32749b) && x.b(this.f32750c, iVar.f32750c) && this.f32751d == iVar.f32751d && x.b(this.f32752e, iVar.f32752e) && x.b(this.f32753f, iVar.f32753f) && x.b(this.f32754g, iVar.f32754g) && x.b(this.f32755h, iVar.f32755h) && x.b(this.f32756i, iVar.f32756i) && x.b(this.f32757j, iVar.f32757j) && x.b(this.f32758k, iVar.f32758k) && x.b(this.f32759l, iVar.f32759l) && x.b(this.f32760m, iVar.f32760m) && x.b(this.f32761n, iVar.f32761n) && x.b(this.f32762o, iVar.f32762o) && x.b(this.f32763p, iVar.f32763p) && x.b(this.f32764q, iVar.f32764q);
    }

    public final Map<String, String> f() {
        return this.f32761n;
    }

    public final a g() {
        return this.f32762o;
    }

    public final String h() {
        return this.f32763p;
    }

    public int hashCode() {
        Map<String, Object> map = this.f32748a;
        int i11 = 0;
        int hashCode = (map == null ? 0 : map.hashCode()) * 31;
        String str = this.f32749b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f32750c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        FlowType flowType = this.f32751d;
        int hashCode4 = (hashCode3 + (flowType == null ? 0 : flowType.hashCode())) * 31;
        String str3 = this.f32752e;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f32753f;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        FlowActionType flowActionType = this.f32754g;
        int hashCode7 = (hashCode6 + (flowActionType == null ? 0 : flowActionType.hashCode())) * 31;
        String str5 = this.f32755h;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f32756i;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Map<Object, Object> map2 = this.f32757j;
        int hashCode10 = (hashCode9 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, Object> map3 = this.f32758k;
        int hashCode11 = (hashCode10 + (map3 == null ? 0 : map3.hashCode())) * 31;
        Map<String, c> map4 = this.f32759l;
        int hashCode12 = (hashCode11 + (map4 == null ? 0 : map4.hashCode())) * 31;
        Map<String, Object> map5 = this.f32760m;
        int hashCode13 = (hashCode12 + (map5 == null ? 0 : map5.hashCode())) * 31;
        Map<String, String> map6 = this.f32761n;
        int hashCode14 = (hashCode13 + (map6 == null ? 0 : map6.hashCode())) * 31;
        a aVar = this.f32762o;
        int hashCode15 = (hashCode14 + (aVar == null ? 0 : aVar.hashCode())) * 31;
        String str7 = this.f32763p;
        int hashCode16 = (hashCode15 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f32764q;
        if (str8 != null) {
            i11 = str8.hashCode();
        }
        return hashCode16 + i11;
    }

    public final String i() {
        return this.f32764q;
    }

    public final String j() {
        return this.f32749b;
    }

    public final String k() {
        return this.f32750c;
    }

    public final FlowType l() {
        return this.f32751d;
    }

    public final String m() {
        return this.f32752e;
    }

    public final String n() {
        return this.f32753f;
    }

    public final FlowActionType o() {
        return this.f32754g;
    }

    public final String p() {
        return this.f32755h;
    }

    public final String q() {
        return this.f32756i;
    }

    public final String r() {
        return this.f32764q;
    }

    public final String t() {
        return this.f32753f;
    }

    public String toString() {
        return "RemoteConfig(uiConf=" + this.f32748a + ", applicantId=" + this.f32749b + ", flowName=" + this.f32750c + ", flowType=" + this.f32751d + ", idDocSetType=" + this.f32752e + ", actionId=" + this.f32753f + ", actionType=" + this.f32754g + ", faceLivenessLic=" + this.f32755h + ", facemapPublicKey=" + this.f32756i + ", sdkDict=" + this.f32757j + ", documentsByCountries=" + this.f32758k + ", phoneCountryCodeWithMasks=" + this.f32759l + ", tinCountryInfo=" + this.f32760m + ", initMetadata=" + this.f32761n + ", eKycConfig=" + this.f32762o + ", verificationUrl=" + this.f32763p + ", accessToken=" + this.f32764q + ')';
    }

    public final FlowActionType v() {
        return this.f32754g;
    }

    public final String x() {
        return this.f32749b;
    }

    public final Map<String, Object> z() {
        return this.f32758k;
    }

    public i(Map<String, ? extends Object> map, String str, String str2, FlowType flowType, String str3, String str4, FlowActionType flowActionType, String str5, String str6, Map<Object, ? extends Object> map2, Map<String, ? extends Object> map3, Map<String, c> map4, Map<String, ? extends Object> map5, Map<String, String> map6, a aVar, String str7, String str8) {
        this.f32748a = map;
        this.f32749b = str;
        this.f32750c = str2;
        this.f32751d = flowType;
        this.f32752e = str3;
        this.f32753f = str4;
        this.f32754g = flowActionType;
        this.f32755h = str5;
        this.f32756i = str6;
        this.f32757j = map2;
        this.f32758k = map3;
        this.f32759l = map4;
        this.f32760m = map5;
        this.f32761n = map6;
        this.f32762o = aVar;
        this.f32763p = str7;
        this.f32764q = str8;
    }

    public final i a(Map<String, ? extends Object> map, String str, String str2, FlowType flowType, String str3, String str4, FlowActionType flowActionType, String str5, String str6, Map<Object, ? extends Object> map2, Map<String, ? extends Object> map3, Map<String, c> map4, Map<String, ? extends Object> map5, Map<String, String> map6, a aVar, String str7, String str8) {
        return new i(map, str, str2, flowType, str3, str4, flowActionType, str5, str6, map2, map3, map4, map5, map6, aVar, str7, str8);
    }

    public static /* synthetic */ i a(i iVar, Map map, String str, String str2, FlowType flowType, String str3, String str4, FlowActionType flowActionType, String str5, String str6, Map map2, Map map3, Map map4, Map map5, Map map6, a aVar, String str7, String str8, int i11, Object obj) {
        i iVar2 = iVar;
        int i12 = i11;
        return iVar.a((i12 & 1) != 0 ? iVar2.f32748a : map, (i12 & 2) != 0 ? iVar2.f32749b : str, (i12 & 4) != 0 ? iVar2.f32750c : str2, (i12 & 8) != 0 ? iVar2.f32751d : flowType, (i12 & 16) != 0 ? iVar2.f32752e : str3, (i12 & 32) != 0 ? iVar2.f32753f : str4, (i12 & 64) != 0 ? iVar2.f32754g : flowActionType, (i12 & 128) != 0 ? iVar2.f32755h : str5, (i12 & 256) != 0 ? iVar2.f32756i : str6, (i12 & 512) != 0 ? iVar2.f32757j : map2, (i12 & 1024) != 0 ? iVar2.f32758k : map3, (i12 & 2048) != 0 ? iVar2.f32759l : map4, (i12 & 4096) != 0 ? iVar2.f32760m : map5, (i12 & 8192) != 0 ? iVar2.f32761n : map6, (i12 & 16384) != 0 ? iVar2.f32762o : aVar, (i12 & 32768) != 0 ? iVar2.f32763p : str7, (i12 & 65536) != 0 ? iVar2.f32764q : str8);
    }

    public static final void a(i iVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        Class<Object> cls = Object.class;
        boolean z11 = false;
        if (bVar.q(fVar, 0) || iVar.f32748a != null) {
            bVar.y(fVar, 0, new r0(v1.f57779a, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), iVar.f32748a);
        }
        if (bVar.q(fVar, 1) || iVar.f32749b != null) {
            bVar.y(fVar, 1, v1.f57779a, iVar.f32749b);
        }
        if (bVar.q(fVar, 2) || iVar.f32750c != null) {
            bVar.y(fVar, 2, v1.f57779a, iVar.f32750c);
        }
        if (bVar.q(fVar, 3) || iVar.f32751d != null) {
            bVar.y(fVar, 3, FlowType$$serializer.INSTANCE, iVar.f32751d);
        }
        if (bVar.q(fVar, 4) || iVar.f32752e != null) {
            bVar.y(fVar, 4, v1.f57779a, iVar.f32752e);
        }
        if (bVar.q(fVar, 5) || iVar.f32753f != null) {
            bVar.y(fVar, 5, v1.f57779a, iVar.f32753f);
        }
        if (bVar.q(fVar, 6) || iVar.f32754g != null) {
            bVar.y(fVar, 6, com.sumsub.sns.internal.core.data.serializer.b.f32958a, iVar.f32754g);
        }
        if (bVar.q(fVar, 7) || iVar.f32755h != null) {
            bVar.y(fVar, 7, v1.f57779a, iVar.f32755h);
        }
        if (bVar.q(fVar, 8) || iVar.f32756i != null) {
            bVar.y(fVar, 8, v1.f57779a, iVar.f32756i);
        }
        bVar.y(fVar, 9, new r0(new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0]), new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), iVar.f32757j);
        if (bVar.q(fVar, 10) || iVar.f32758k != null) {
            bVar.y(fVar, 10, new r0(v1.f57779a, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), iVar.f32758k);
        }
        if (bVar.q(fVar, 11) || iVar.f32759l != null) {
            bVar.y(fVar, 11, new r0(v1.f57779a, c.a.f32707a), iVar.f32759l);
        }
        if (bVar.q(fVar, 12) || iVar.f32760m != null) {
            bVar.y(fVar, 12, new r0(v1.f57779a, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), iVar.f32760m);
        }
        if (bVar.q(fVar, 13) || iVar.f32761n != null) {
            v1 v1Var = v1.f57779a;
            bVar.y(fVar, 13, new r0(v1Var, v1Var), iVar.f32761n);
        }
        if (bVar.q(fVar, 14) || iVar.f32762o != null) {
            bVar.y(fVar, 14, a.C0344a.f32697a, iVar.f32762o);
        }
        if (bVar.q(fVar, 15) || iVar.f32763p != null) {
            bVar.y(fVar, 15, v1.f57779a, iVar.f32763p);
        }
        if (bVar.q(fVar, 16) || iVar.f32764q != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 16, v1.f57779a, iVar.f32764q);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ i(java.util.Map r22, java.lang.String r23, java.lang.String r24, com.sumsub.sns.core.data.model.FlowType r25, java.lang.String r26, java.lang.String r27, com.sumsub.sns.core.data.model.FlowActionType r28, java.lang.String r29, java.lang.String r30, java.util.Map r31, java.util.Map r32, java.util.Map r33, java.util.Map r34, java.util.Map r35, com.sumsub.sns.internal.core.data.model.remote.a r36, java.lang.String r37, java.lang.String r38, int r39, kotlin.jvm.internal.r r40) {
        /*
            r21 = this;
            r0 = r39
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = r2
            goto L_0x000b
        L_0x0009:
            r4 = r22
        L_0x000b:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0011
            r5 = r2
            goto L_0x0013
        L_0x0011:
            r5 = r23
        L_0x0013:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0019
            r6 = r2
            goto L_0x001b
        L_0x0019:
            r6 = r24
        L_0x001b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0021
            r7 = r2
            goto L_0x0023
        L_0x0021:
            r7 = r25
        L_0x0023:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0029
            r8 = r2
            goto L_0x002b
        L_0x0029:
            r8 = r26
        L_0x002b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0031
            r9 = r2
            goto L_0x0033
        L_0x0031:
            r9 = r27
        L_0x0033:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0039
            r10 = r2
            goto L_0x003b
        L_0x0039:
            r10 = r28
        L_0x003b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0041
            r11 = r2
            goto L_0x0043
        L_0x0041:
            r11 = r29
        L_0x0043:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0049
            r12 = r2
            goto L_0x004b
        L_0x0049:
            r12 = r30
        L_0x004b:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0051
            r14 = r2
            goto L_0x0053
        L_0x0051:
            r14 = r32
        L_0x0053:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0059
            r15 = r2
            goto L_0x005b
        L_0x0059:
            r15 = r33
        L_0x005b:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0062
            r16 = r2
            goto L_0x0064
        L_0x0062:
            r16 = r34
        L_0x0064:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x006b
            r17 = r2
            goto L_0x006d
        L_0x006b:
            r17 = r35
        L_0x006d:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0074
            r18 = r2
            goto L_0x0076
        L_0x0074:
            r18 = r36
        L_0x0076:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x007f
            r19 = r2
            goto L_0x0081
        L_0x007f:
            r19 = r37
        L_0x0081:
            r1 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0089
            r20 = r2
            goto L_0x008b
        L_0x0089:
            r20 = r38
        L_0x008b:
            r3 = r21
            r13 = r31
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.i.<init>(java.util.Map, java.lang.String, java.lang.String, com.sumsub.sns.core.data.model.FlowType, java.lang.String, java.lang.String, com.sumsub.sns.core.data.model.FlowActionType, java.lang.String, java.lang.String, java.util.Map, java.util.Map, java.util.Map, java.util.Map, java.util.Map, com.sumsub.sns.internal.core.data.model.remote.a, java.lang.String, java.lang.String, int, kotlin.jvm.internal.r):void");
    }
}
