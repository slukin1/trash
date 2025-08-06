package g30;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import zendesk.classic.messaging.MessagingItem;
import zendesk.classic.messaging.d;
import zendesk.classic.messaging.j;

public class l {

    /* renamed from: d  reason: collision with root package name */
    public static final Comparator<o> f60297d = new a();

    /* renamed from: a  reason: collision with root package name */
    public final j f60298a;

    /* renamed from: b  reason: collision with root package name */
    public final List<MessagingItem> f60299b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final List<d> f60300c = new ArrayList();

    public class a implements Comparator<o> {
        /* renamed from: a */
        public int compare(o oVar, o oVar2) {
            return oVar.getTimestamp().compareTo(oVar2.getTimestamp());
        }
    }

    public l(j jVar) {
        this.f60298a = jVar;
    }

    public void a(d dVar) {
        this.f60300c.add(dVar);
    }

    public void b(List<MessagingItem> list) {
        this.f60299b.clear();
        if (mz.a.i(list)) {
            this.f60299b.addAll(list);
        }
    }
}
