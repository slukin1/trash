package com.sumsub.sns.core.data.model;

import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.b;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@a
@f
@Keep
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B\u001f\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001c\u0010\u001dB3\b\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0010\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001c\u0010!J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u000f\u001a\u00020\tHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u0015\u0012\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0017¨\u0006$"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSDocumentDefinition;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "write$Self", "", "component1", "component2", "idDocType", "country", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getIdDocType", "()Ljava/lang/String;", "getIdDocType$annotations", "()V", "getCountry", "getCountry$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "$serializer", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSDocumentDefinition {
    public static final Companion Companion = new Companion((r) null);
    private final String country;
    private final String idDocType;

    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSDocumentDefinition$Companion;", "", "Lkotlinx/serialization/b;", "Lcom/sumsub/sns/core/data/model/SNSDocumentDefinition;", "serializer", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final b<SNSDocumentDefinition> serializer() {
            return SNSDocumentDefinition$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public SNSDocumentDefinition() {
        this((String) null, (String) null, 3, (r) null);
    }

    public static /* synthetic */ SNSDocumentDefinition copy$default(SNSDocumentDefinition sNSDocumentDefinition, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = sNSDocumentDefinition.idDocType;
        }
        if ((i11 & 2) != 0) {
            str2 = sNSDocumentDefinition.country;
        }
        return sNSDocumentDefinition.copy(str, str2);
    }

    public static /* synthetic */ void getCountry$annotations() {
    }

    public static /* synthetic */ void getIdDocType$annotations() {
    }

    public static final void write$Self(SNSDocumentDefinition sNSDocumentDefinition, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || sNSDocumentDefinition.idDocType != null) {
            bVar.y(fVar, 0, v1.f57779a, sNSDocumentDefinition.idDocType);
        }
        if (bVar.q(fVar, 1) || sNSDocumentDefinition.country != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 1, v1.f57779a, sNSDocumentDefinition.country);
        }
    }

    public final String component1() {
        return this.idDocType;
    }

    public final String component2() {
        return this.country;
    }

    public final SNSDocumentDefinition copy(String str, String str2) {
        return new SNSDocumentDefinition(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SNSDocumentDefinition)) {
            return false;
        }
        SNSDocumentDefinition sNSDocumentDefinition = (SNSDocumentDefinition) obj;
        return x.b(this.idDocType, sNSDocumentDefinition.idDocType) && x.b(this.country, sNSDocumentDefinition.country);
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getIdDocType() {
        return this.idDocType;
    }

    public int hashCode() {
        String str = this.idDocType;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.country;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "SNSDocumentDefinition(idDocType=" + this.idDocType + ", country=" + this.country + ')';
    }

    public /* synthetic */ SNSDocumentDefinition(int i11, String str, String str2, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, SNSDocumentDefinition$$serializer.INSTANCE.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.idDocType = null;
        } else {
            this.idDocType = str;
        }
        if ((i11 & 2) == 0) {
            this.country = null;
        } else {
            this.country = str2;
        }
    }

    public SNSDocumentDefinition(String str, String str2) {
        this.idDocType = str;
        this.country = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSDocumentDefinition(String str, String str2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }
}
