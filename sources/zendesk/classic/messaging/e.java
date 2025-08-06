package zendesk.classic.messaging;

import android.content.Intent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import zendesk.classic.messaging.MessagingItem;
import zendesk.classic.messaging.c;
import zendesk.classic.messaging.components.DateProvider;
import zendesk.classic.messaging.d;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final DateProvider f62488a;

    public e(DateProvider dateProvider) {
        this.f62488a = dateProvider;
    }

    public d a(MessagingItem.a aVar) {
        return new d.b(aVar, this.f62488a.a());
    }

    public d b(MessagingItem.c.a aVar) {
        return new d.C0691d(aVar, this.f62488a.a());
    }

    public d c(MessagingItem.Query query) {
        return new d.e(query, this.f62488a.a());
    }

    public d d(MessagingItem.Query query) {
        return new d.j(query, this.f62488a.a());
    }

    public d e(MessagingItem.h hVar, MessagingItem.g gVar) {
        return new d.n(hVar, gVar, this.f62488a.a());
    }

    public d f(int i11) {
        return new d.i(this.f62488a.a(), i11);
    }

    public d g(int i11, int i12, Intent intent) {
        return new d.c(i11, i12, intent, this.f62488a.a());
    }

    public d h() {
        return new d.m(this.f62488a.a());
    }

    public d i(MessagingItem.Query query) {
        return new d.k(query, this.f62488a.a());
    }

    public d j(MessagingItem.FileQuery fileQuery) {
        return new d.o(fileQuery, this.f62488a.a());
    }

    public d k(List<File> list) {
        return new d.h(new ArrayList(list), this.f62488a.a());
    }

    public d l(String str) {
        return new d.l(str, this.f62488a.a());
    }

    public d m(c.b bVar) {
        return new d.g(bVar, this.f62488a.a());
    }

    public d n() {
        return new d.p(this.f62488a.a());
    }

    public d o() {
        return new d.q(this.f62488a.a());
    }
}
