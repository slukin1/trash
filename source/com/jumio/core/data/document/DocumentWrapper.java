package com.jumio.core.data.document;

import com.jumio.core.data.digitaldocument.DigitalDocumentType;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.x;

public final class DocumentWrapper implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final List<PhysicalDocumentType> f39122a;

    /* renamed from: b  reason: collision with root package name */
    public final List<DigitalDocumentType> f39123b;

    public DocumentWrapper(List<PhysicalDocumentType> list, List<DigitalDocumentType> list2) {
        this.f39122a = list;
        this.f39123b = list2;
    }

    public static /* synthetic */ DocumentWrapper copy$default(DocumentWrapper documentWrapper, List<PhysicalDocumentType> list, List<DigitalDocumentType> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = documentWrapper.f39122a;
        }
        if ((i11 & 2) != 0) {
            list2 = documentWrapper.f39123b;
        }
        return documentWrapper.copy(list, list2);
    }

    public final List<PhysicalDocumentType> component1() {
        return this.f39122a;
    }

    public final List<DigitalDocumentType> component2() {
        return this.f39123b;
    }

    public final DocumentWrapper copy(List<PhysicalDocumentType> list, List<DigitalDocumentType> list2) {
        return new DocumentWrapper(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DocumentWrapper)) {
            return false;
        }
        DocumentWrapper documentWrapper = (DocumentWrapper) obj;
        return x.b(this.f39122a, documentWrapper.f39122a) && x.b(this.f39123b, documentWrapper.f39123b);
    }

    public final List<DigitalDocumentType> getDigitalDocuments() {
        return this.f39123b;
    }

    public final List<PhysicalDocumentType> getPhysicalDocuments() {
        return this.f39122a;
    }

    public int hashCode() {
        return this.f39123b.hashCode() + (this.f39122a.hashCode() * 31);
    }

    public String toString() {
        List<PhysicalDocumentType> list = this.f39122a;
        List<DigitalDocumentType> list2 = this.f39123b;
        return "DocumentWrapper(physicalDocuments=" + list + ", digitalDocuments=" + list2 + ")";
    }
}
