package com.sumsub.sns.core.data.model;

import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.b;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@a
@f
@Keep
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 )2\u00020\u0001:\u0002*)B7\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\f¢\u0006\u0004\b#\u0010$BK\b\u0017\u0012\u0006\u0010%\u001a\u00020\u0013\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0001\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0012\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b#\u0010(J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\fHÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\fHÆ\u0001J\t\u0010\u0012\u001a\u00020\tHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u0018\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\u0018\u0012\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001aR.\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSInitConfig;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "write$Self", "", "component1", "component2", "", "component3", "email", "phone", "strings", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getEmail", "()Ljava/lang/String;", "getEmail$annotations", "()V", "getPhone", "getPhone$annotations", "Ljava/util/Map;", "getStrings", "()Ljava/util/Map;", "getStrings$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/q1;)V", "Companion", "$serializer", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSInitConfig {
    public static final Companion Companion = new Companion((r) null);
    private final String email;
    private final String phone;
    private final Map<String, String> strings;

    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSInitConfig$Companion;", "", "Lkotlinx/serialization/b;", "Lcom/sumsub/sns/core/data/model/SNSInitConfig;", "serializer", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final b<SNSInitConfig> serializer() {
            return SNSInitConfig$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public SNSInitConfig() {
        this((String) null, (String) null, (Map) null, 7, (r) null);
    }

    public static /* synthetic */ SNSInitConfig copy$default(SNSInitConfig sNSInitConfig, String str, String str2, Map<String, String> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = sNSInitConfig.email;
        }
        if ((i11 & 2) != 0) {
            str2 = sNSInitConfig.phone;
        }
        if ((i11 & 4) != 0) {
            map = sNSInitConfig.strings;
        }
        return sNSInitConfig.copy(str, str2, map);
    }

    public static /* synthetic */ void getEmail$annotations() {
    }

    public static /* synthetic */ void getPhone$annotations() {
    }

    public static /* synthetic */ void getStrings$annotations() {
    }

    public static final void write$Self(SNSInitConfig sNSInitConfig, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || sNSInitConfig.email != null) {
            bVar.y(fVar, 0, v1.f57779a, sNSInitConfig.email);
        }
        if (bVar.q(fVar, 1) || sNSInitConfig.phone != null) {
            bVar.y(fVar, 1, v1.f57779a, sNSInitConfig.phone);
        }
        if (bVar.q(fVar, 2) || sNSInitConfig.strings != null) {
            z11 = true;
        }
        if (z11) {
            v1 v1Var = v1.f57779a;
            bVar.y(fVar, 2, new r0(v1Var, v1Var), sNSInitConfig.strings);
        }
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.phone;
    }

    public final Map<String, String> component3() {
        return this.strings;
    }

    public final SNSInitConfig copy(String str, String str2, Map<String, String> map) {
        return new SNSInitConfig(str, str2, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SNSInitConfig)) {
            return false;
        }
        SNSInitConfig sNSInitConfig = (SNSInitConfig) obj;
        return x.b(this.email, sNSInitConfig.email) && x.b(this.phone, sNSInitConfig.phone) && x.b(this.strings, sNSInitConfig.strings);
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final Map<String, String> getStrings() {
        return this.strings;
    }

    public int hashCode() {
        String str = this.email;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.phone;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, String> map = this.strings;
        if (map != null) {
            i11 = map.hashCode();
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "SNSInitConfig(email=" + this.email + ", phone=" + this.phone + ", strings=" + this.strings + ')';
    }

    public /* synthetic */ SNSInitConfig(int i11, String str, String str2, Map map, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, SNSInitConfig$$serializer.INSTANCE.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.email = null;
        } else {
            this.email = str;
        }
        if ((i11 & 2) == 0) {
            this.phone = null;
        } else {
            this.phone = str2;
        }
        if ((i11 & 4) == 0) {
            this.strings = null;
        } else {
            this.strings = map;
        }
    }

    public SNSInitConfig(String str, String str2, Map<String, String> map) {
        this.email = str;
        this.phone = str2;
        this.strings = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSInitConfig(String str, String str2, Map map, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : map);
    }
}
