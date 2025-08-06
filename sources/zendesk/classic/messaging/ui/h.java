package zendesk.classic.messaging.ui;

import com.squareup.picasso.Picasso;
import g30.a;
import g30.b;
import zendesk.classic.messaging.MessagingItem;

public class h extends g {

    /* renamed from: h  reason: collision with root package name */
    public final Picasso f62797h;

    public h(String str, r rVar, MessagingItem.Query.Status status, n nVar, a aVar, MessagingItem.FileQuery.FailureReason failureReason, b bVar, Picasso picasso) {
        super(str, rVar, status, nVar, aVar, failureReason, bVar);
        this.f62797h = picasso;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        Picasso picasso = this.f62797h;
        Picasso picasso2 = ((h) obj).f62797h;
        if (picasso != null) {
            return picasso.equals(picasso2);
        }
        if (picasso2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        Picasso picasso = this.f62797h;
        return hashCode + (picasso != null ? picasso.hashCode() : 0);
    }
}
