package zendesk.classic.messaging.ui;

import zendesk.classic.messaging.MessagingItem;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f62790a;

    /* renamed from: b  reason: collision with root package name */
    public final r f62791b;

    /* renamed from: c  reason: collision with root package name */
    public final MessagingItem.Query.Status f62792c;

    /* renamed from: d  reason: collision with root package name */
    public final n f62793d;

    public f(String str, r rVar, MessagingItem.Query.Status status, n nVar) {
        this.f62790a = str;
        this.f62791b = rVar;
        this.f62792c = status;
        this.f62793d = nVar;
    }

    public String a() {
        return this.f62790a;
    }

    public n b() {
        return this.f62793d;
    }

    public r c() {
        return this.f62791b;
    }

    public MessagingItem.Query.Status d() {
        return this.f62792c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.f62790a;
        if (str == null ? fVar.f62790a != null : !str.equals(fVar.f62790a)) {
            return false;
        }
        r rVar = this.f62791b;
        if (rVar == null ? fVar.f62791b != null : !rVar.equals(fVar.f62791b)) {
            return false;
        }
        if (this.f62792c != fVar.f62792c) {
            return false;
        }
        if ((this.f62793d != null) == (fVar.f62793d == null)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f62790a;
        int i11 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        r rVar = this.f62791b;
        int hashCode2 = (hashCode + (rVar != null ? rVar.hashCode() : 0)) * 31;
        MessagingItem.Query.Status status = this.f62792c;
        int hashCode3 = (hashCode2 + (status != null ? status.hashCode() : 0)) * 31;
        n nVar = this.f62793d;
        if (nVar != null) {
            i11 = nVar.hashCode();
        }
        return hashCode3 + i11;
    }
}
