package zendesk.classic.messaging.ui;

import g30.a;
import g30.b;
import zendesk.classic.messaging.MessagingItem;

public class g extends f {

    /* renamed from: e  reason: collision with root package name */
    public final a f62794e;

    /* renamed from: f  reason: collision with root package name */
    public final MessagingItem.FileQuery.FailureReason f62795f;

    /* renamed from: g  reason: collision with root package name */
    public final b f62796g;

    public g(String str, r rVar, MessagingItem.Query.Status status, n nVar, a aVar, MessagingItem.FileQuery.FailureReason failureReason, b bVar) {
        super(str, rVar, status, nVar);
        this.f62795f = failureReason;
        this.f62796g = bVar;
    }

    public a e() {
        return this.f62794e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f62795f != gVar.f62795f) {
            return false;
        }
        b bVar = this.f62796g;
        if (bVar != null) {
            return bVar.equals(gVar.f62796g);
        }
        if (gVar.f62796g == null) {
            return true;
        }
        return false;
    }

    public b f() {
        return this.f62796g;
    }

    public MessagingItem.FileQuery.FailureReason g() {
        return this.f62795f;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((super.hashCode() * 31) + 0) * 31;
        MessagingItem.FileQuery.FailureReason failureReason = this.f62795f;
        int hashCode2 = (hashCode + (failureReason != null ? failureReason.hashCode() : 0)) * 31;
        b bVar = this.f62796g;
        if (bVar != null) {
            i11 = bVar.hashCode();
        }
        return hashCode2 + i11;
    }
}
