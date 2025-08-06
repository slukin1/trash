package zendesk.classic.messaging.ui;

import zendesk.classic.messaging.MessagingItem;

public class i extends f {

    /* renamed from: e  reason: collision with root package name */
    public final String f62798e;

    public i(String str, r rVar, MessagingItem.Query.Status status, n nVar, String str2) {
        super(str, rVar, status, nVar);
        this.f62798e = str2;
    }

    public String e() {
        return this.f62798e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        String str = this.f62798e;
        String str2 = ((i) obj).f62798e;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f62798e;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
