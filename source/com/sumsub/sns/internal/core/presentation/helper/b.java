package com.sumsub.sns.internal.core.presentation.helper;

import com.sumsub.sns.internal.core.data.model.ApplicantStatus;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.g;
import java.util.List;
import kotlin.jvm.internal.x;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final ApplicantStatus f33844a;

    /* renamed from: b  reason: collision with root package name */
    public final g f33845b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Document> f33846c;

    public b(ApplicantStatus applicantStatus, g gVar, List<Document> list) {
        this.f33844a = applicantStatus;
        this.f33845b = gVar;
        this.f33846c = list;
    }

    public final ApplicantStatus a() {
        return this.f33844a;
    }

    public final g b() {
        return this.f33845b;
    }

    public final List<Document> c() {
        return this.f33846c;
    }

    public final g d() {
        return this.f33845b;
    }

    public final List<Document> e() {
        return this.f33846c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f33844a == bVar.f33844a && x.b(this.f33845b, bVar.f33845b) && x.b(this.f33846c, bVar.f33846c);
    }

    public final ApplicantStatus f() {
        return this.f33844a;
    }

    public int hashCode() {
        return (((this.f33844a.hashCode() * 31) + this.f33845b.hashCode()) * 31) + this.f33846c.hashCode();
    }

    public String toString() {
        return "DocumentItemsParams(status=" + this.f33844a + ", applicant=" + this.f33845b + ", documents=" + this.f33846c + ')';
    }

    public final b a(ApplicantStatus applicantStatus, g gVar, List<Document> list) {
        return new b(applicantStatus, gVar, list);
    }

    public static /* synthetic */ b a(b bVar, ApplicantStatus applicantStatus, g gVar, List<Document> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            applicantStatus = bVar.f33844a;
        }
        if ((i11 & 2) != 0) {
            gVar = bVar.f33845b;
        }
        if ((i11 & 4) != 0) {
            list = bVar.f33846c;
        }
        return bVar.a(applicantStatus, gVar, list);
    }
}
