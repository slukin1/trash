package com.sumsub.sns.core.data.model;

import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.b;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@a
@f
@Keep
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 )2\u00020\u0001:\u0002*)B3\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0004\b#\u0010$BK\b\u0017\u0012\u0006\u0010%\u001a\u00020\u0013\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0001\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f\u0012\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b#\u0010(J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fHÆ\u0003J7\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fHÆ\u0001J\t\u0010\u0012\u001a\u00020\tHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\u000e\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u0018\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\u0018\u0012\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001aR.\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSTrackEvents;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "write$Self", "", "component1", "component2", "", "component3", "activity", "ts", "payload", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getActivity", "()Ljava/lang/String;", "getActivity$annotations", "()V", "getTs", "getTs$annotations", "Ljava/util/Map;", "getPayload", "()Ljava/util/Map;", "getPayload$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/q1;)V", "Companion", "$serializer", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSTrackEvents {
    public static final Companion Companion = new Companion((r) null);
    private final String activity;
    private final Map<String, Object> payload;

    /* renamed from: ts  reason: collision with root package name */
    private final String f30756ts;

    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSTrackEvents$Companion;", "", "Lkotlinx/serialization/b;", "Lcom/sumsub/sns/core/data/model/SNSTrackEvents;", "serializer", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final b<SNSTrackEvents> serializer() {
            return SNSTrackEvents$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SNSTrackEvents(int i11, String str, String str2, Map map, q1 q1Var) {
        if (1 != (i11 & 1)) {
            h1.a(i11, 1, SNSTrackEvents$$serializer.INSTANCE.getDescriptor());
        }
        this.activity = str;
        if ((i11 & 2) == 0) {
            this.f30756ts = null;
        } else {
            this.f30756ts = str2;
        }
        if ((i11 & 4) == 0) {
            this.payload = null;
        } else {
            this.payload = map;
        }
    }

    public static /* synthetic */ SNSTrackEvents copy$default(SNSTrackEvents sNSTrackEvents, String str, String str2, Map<String, Object> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = sNSTrackEvents.activity;
        }
        if ((i11 & 2) != 0) {
            str2 = sNSTrackEvents.f30756ts;
        }
        if ((i11 & 4) != 0) {
            map = sNSTrackEvents.payload;
        }
        return sNSTrackEvents.copy(str, str2, map);
    }

    public static /* synthetic */ void getActivity$annotations() {
    }

    public static /* synthetic */ void getPayload$annotations() {
    }

    public static /* synthetic */ void getTs$annotations() {
    }

    public static final void write$Self(SNSTrackEvents sNSTrackEvents, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        bVar.p(fVar, 0, sNSTrackEvents.activity);
        boolean z11 = true;
        if (bVar.q(fVar, 1) || sNSTrackEvents.f30756ts != null) {
            bVar.y(fVar, 1, v1.f57779a, sNSTrackEvents.f30756ts);
        }
        if (!bVar.q(fVar, 2) && sNSTrackEvents.payload == null) {
            z11 = false;
        }
        if (z11) {
            bVar.y(fVar, 2, new r0(v1.f57779a, new ContextualSerializer(Reflection.b(Object.class), (b) null, new b[0])), sNSTrackEvents.payload);
        }
    }

    public final String component1() {
        return this.activity;
    }

    public final String component2() {
        return this.f30756ts;
    }

    public final Map<String, Object> component3() {
        return this.payload;
    }

    public final SNSTrackEvents copy(String str, String str2, Map<String, ? extends Object> map) {
        return new SNSTrackEvents(str, str2, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SNSTrackEvents)) {
            return false;
        }
        SNSTrackEvents sNSTrackEvents = (SNSTrackEvents) obj;
        return x.b(this.activity, sNSTrackEvents.activity) && x.b(this.f30756ts, sNSTrackEvents.f30756ts) && x.b(this.payload, sNSTrackEvents.payload);
    }

    public final String getActivity() {
        return this.activity;
    }

    public final Map<String, Object> getPayload() {
        return this.payload;
    }

    public final String getTs() {
        return this.f30756ts;
    }

    public int hashCode() {
        int hashCode = this.activity.hashCode() * 31;
        String str = this.f30756ts;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, Object> map = this.payload;
        if (map != null) {
            i11 = map.hashCode();
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "SNSTrackEvents(activity=" + this.activity + ", ts=" + this.f30756ts + ", payload=" + this.payload + ')';
    }

    public SNSTrackEvents(String str, String str2, Map<String, ? extends Object> map) {
        this.activity = str;
        this.f30756ts = str2;
        this.payload = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSTrackEvents(String str, String str2, Map map, int i11, r rVar) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : map);
    }
}
