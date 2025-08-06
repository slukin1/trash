package com.sumsub.sns.internal.core.presentation.base.adapter;

import com.sumsub.sns.internal.core.data.model.Document;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

public final class SNSDocumentViewTypeInfo {

    /* renamed from: a  reason: collision with root package name */
    public final Type f33695a;

    /* renamed from: b  reason: collision with root package name */
    public final Document f33696b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/internal/core/presentation/base/adapter/SNSDocumentViewTypeInfo$Type;", "", "(Ljava/lang/String;I)V", "DOCUMENT", "VIDEO_IDENTIFICATION", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum Type {
        DOCUMENT,
        VIDEO_IDENTIFICATION
    }

    public SNSDocumentViewTypeInfo(Type type, Document document) {
        this.f33695a = type;
        this.f33696b = document;
    }

    public final Type a() {
        return this.f33695a;
    }

    public final Document b() {
        return this.f33696b;
    }

    public final Document c() {
        return this.f33696b;
    }

    public final Type d() {
        return this.f33695a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SNSDocumentViewTypeInfo)) {
            return false;
        }
        SNSDocumentViewTypeInfo sNSDocumentViewTypeInfo = (SNSDocumentViewTypeInfo) obj;
        return this.f33695a == sNSDocumentViewTypeInfo.f33695a && x.b(this.f33696b, sNSDocumentViewTypeInfo.f33696b);
    }

    public int hashCode() {
        return (this.f33695a.hashCode() * 31) + this.f33696b.hashCode();
    }

    public String toString() {
        return "SNSDocumentViewTypeInfo(type=" + this.f33695a + ", document=" + this.f33696b + ')';
    }

    public final SNSDocumentViewTypeInfo a(Type type, Document document) {
        return new SNSDocumentViewTypeInfo(type, document);
    }

    public static /* synthetic */ SNSDocumentViewTypeInfo a(SNSDocumentViewTypeInfo sNSDocumentViewTypeInfo, Type type, Document document, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            type = sNSDocumentViewTypeInfo.f33695a;
        }
        if ((i11 & 2) != 0) {
            document = sNSDocumentViewTypeInfo.f33696b;
        }
        return sNSDocumentViewTypeInfo.a(type, document);
    }
}
