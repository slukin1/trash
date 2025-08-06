package com.jumio.sdk.document;

import java.util.Arrays;
import kotlin.jvm.internal.d0;

public final class JumioPhysicalDocument implements JumioDocument {

    /* renamed from: a  reason: collision with root package name */
    public final JumioDocumentType f24974a;

    /* renamed from: b  reason: collision with root package name */
    public final JumioDocumentVariant f24975b;

    public JumioPhysicalDocument(JumioDocumentType jumioDocumentType, JumioDocumentVariant jumioDocumentVariant) {
        this.f24974a = jumioDocumentType;
        this.f24975b = jumioDocumentVariant;
    }

    public static /* synthetic */ JumioPhysicalDocument copy$default(JumioPhysicalDocument jumioPhysicalDocument, JumioDocumentType jumioDocumentType, JumioDocumentVariant jumioDocumentVariant, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            jumioDocumentType = jumioPhysicalDocument.f24974a;
        }
        if ((i11 & 2) != 0) {
            jumioDocumentVariant = jumioPhysicalDocument.f24975b;
        }
        return jumioPhysicalDocument.copy(jumioDocumentType, jumioDocumentVariant);
    }

    public final JumioDocumentType component1() {
        return this.f24974a;
    }

    public final JumioDocumentVariant component2() {
        return this.f24975b;
    }

    public final JumioPhysicalDocument copy(JumioDocumentType jumioDocumentType, JumioDocumentVariant jumioDocumentVariant) {
        return new JumioPhysicalDocument(jumioDocumentType, jumioDocumentVariant);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JumioPhysicalDocument)) {
            return false;
        }
        JumioPhysicalDocument jumioPhysicalDocument = (JumioPhysicalDocument) obj;
        return this.f24974a == jumioPhysicalDocument.f24974a && this.f24975b == jumioPhysicalDocument.f24975b;
    }

    public final JumioDocumentType getType() {
        return this.f24974a;
    }

    public final JumioDocumentVariant getVariant() {
        return this.f24975b;
    }

    public int hashCode() {
        return this.f24975b.hashCode() + (this.f24974a.hashCode() * 31);
    }

    public String toString() {
        d0 d0Var = d0.f56774a;
        return String.format("%s %s", Arrays.copyOf(new Object[]{this.f24974a.name(), this.f24975b.name()}, 2));
    }
}
