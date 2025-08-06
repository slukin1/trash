package zendesk.classic.messaging;

import android.content.res.Resources;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import g30.f;
import g30.g;
import g30.l;
import g30.w;
import g30.z;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import zendesk.classic.messaging.MessagingItem;
import zendesk.classic.messaging.Update;
import zendesk.classic.messaging.c;
import zendesk.classic.messaging.d;
import zendesk.classic.messaging.m;
import zendesk.configurations.Configuration;

public class k implements g, f, c.C0690c {

    /* renamed from: s  reason: collision with root package name */
    public static final g30.b f62511s;

    /* renamed from: t  reason: collision with root package name */
    public static final Update f62512t;

    /* renamed from: u  reason: collision with root package name */
    public static final Update f62513u = new Update.b(new g[0]);

    /* renamed from: b  reason: collision with root package name */
    public c f62514b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c> f62515c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<c, List<MessagingItem>> f62516d;

    /* renamed from: e  reason: collision with root package name */
    public final l f62517e;

    /* renamed from: f  reason: collision with root package name */
    public final AgentDetails f62518f;

    /* renamed from: g  reason: collision with root package name */
    public final MutableLiveData<List<MessagingItem>> f62519g;

    /* renamed from: h  reason: collision with root package name */
    public final MutableLiveData<List<g>> f62520h;

    /* renamed from: i  reason: collision with root package name */
    public final MutableLiveData<z> f62521i;

    /* renamed from: j  reason: collision with root package name */
    public final MutableLiveData<ConnectionState> f62522j;

    /* renamed from: k  reason: collision with root package name */
    public final MutableLiveData<String> f62523k;

    /* renamed from: l  reason: collision with root package name */
    public final MutableLiveData<Boolean> f62524l;

    /* renamed from: m  reason: collision with root package name */
    public final MutableLiveData<Integer> f62525m;

    /* renamed from: n  reason: collision with root package name */
    public final MutableLiveData<g30.b> f62526n;

    /* renamed from: o  reason: collision with root package name */
    public final w<Update.a.C0685a> f62527o;

    /* renamed from: p  reason: collision with root package name */
    public final w<Banner> f62528p;

    /* renamed from: q  reason: collision with root package name */
    public final w<DialogContent> f62529q;

    /* renamed from: r  reason: collision with root package name */
    public final List<Configuration> f62530r;

    public class a implements m.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f62531a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f62532b;

        public a(List list, List list2) {
            this.f62531a = list;
            this.f62532b = list2;
        }

        public void a() {
            if (mz.a.i(this.f62531a)) {
                k.this.o((c) this.f62531a.get(0));
            } else {
                k.this.o((c) this.f62532b.get(0));
            }
        }
    }

    public class b implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f62534a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f62535b;

        public b(List list, m mVar) {
            this.f62534a = list;
            this.f62535b = mVar;
        }

        public void a(c cVar, boolean z11) {
            if (z11) {
                this.f62534a.add(cVar);
            }
            this.f62535b.a();
        }
    }

    static {
        g30.b bVar = new g30.b(0, false);
        f62511s = bVar;
        f62512t = new Update.State.d("", Boolean.TRUE, bVar, 131073);
    }

    public k(Resources resources, List<c> list, MessagingConfiguration messagingConfiguration, l lVar) {
        this.f62515c = new ArrayList(list.size());
        for (c next : list) {
            if (next != null) {
                this.f62515c.add(next);
            }
        }
        this.f62517e = lVar;
        this.f62530r = messagingConfiguration.getConfigurations();
        this.f62518f = messagingConfiguration.getBotAgentDetails(resources);
        this.f62516d = new LinkedHashMap();
        this.f62519g = new MutableLiveData<>();
        this.f62520h = new MutableLiveData<>();
        this.f62521i = new MutableLiveData<>();
        this.f62522j = new MutableLiveData<>();
        this.f62523k = new MutableLiveData<>();
        this.f62525m = new MutableLiveData<>();
        this.f62524l = new MutableLiveData<>();
        this.f62526n = new MutableLiveData<>();
        this.f62527o = new w<>();
        this.f62528p = new w<>();
        this.f62529q = new w<>();
    }

    public void a(d dVar) {
        this.f62517e.a(dVar);
        if (dVar.a().equals("transfer_option_clicked")) {
            d.g gVar = (d.g) dVar;
            for (c next : this.f62515c) {
                if (gVar.b().b().equals(next.getId())) {
                    o(next);
                    return;
                }
            }
            return;
        }
        c cVar = this.f62514b;
        if (cVar != null) {
            cVar.a(dVar);
        }
    }

    public MutableLiveData<g30.b> c() {
        return this.f62526n;
    }

    public MutableLiveData<Boolean> d() {
        return this.f62524l;
    }

    public MutableLiveData<String> e() {
        return this.f62523k;
    }

    public LiveData<ConnectionState> f() {
        return this.f62522j;
    }

    public w<DialogContent> g() {
        return this.f62529q;
    }

    public w<Banner> h() {
        return this.f62528p;
    }

    public MutableLiveData<Integer> i() {
        return this.f62525m;
    }

    public LiveData<List<g>> j() {
        return this.f62520h;
    }

    public LiveData<List<MessagingItem>> k() {
        return this.f62519g;
    }

    public w<Update.a.C0685a> l() {
        return this.f62527o;
    }

    public LiveData<z> m() {
        return this.f62521i;
    }

    public void n() {
        s(Update.State.d.f(false));
        p(this.f62515c);
    }

    public final void o(c cVar) {
        c cVar2 = this.f62514b;
        if (!(cVar2 == null || cVar2 == cVar)) {
            r(cVar2);
        }
        this.f62514b = cVar;
        cVar.registerObserver(this);
        s(f62512t);
        s(f62513u);
        cVar.b(this);
    }

    public final void p(List<c> list) {
        if (!mz.a.g(list)) {
            if (list.size() == 1) {
                o(list.get(0));
                return;
            }
            ArrayList arrayList = new ArrayList();
            m mVar = new m(new a(arrayList, list));
            mVar.b(list.size());
            for (c isConversationOngoing : list) {
                isConversationOngoing.isConversationOngoing(new b(arrayList, mVar));
            }
        }
    }

    public void q() {
        c cVar = this.f62514b;
        if (cVar != null) {
            cVar.stop();
            this.f62514b.unregisterObserver(this);
        }
    }

    public final void r(c cVar) {
        cVar.stop();
        cVar.unregisterObserver(this);
    }

    public void s(Update update) {
        String a11 = update.a();
        a11.hashCode();
        char c11 = 65535;
        switch (a11.hashCode()) {
            case -1524638175:
                if (a11.equals("update_input_field_state")) {
                    c11 = 0;
                    break;
                }
                break;
            case -358781964:
                if (a11.equals("apply_messaging_items")) {
                    c11 = 1;
                    break;
                }
                break;
            case 35633838:
                if (a11.equals("show_banner")) {
                    c11 = 2;
                    break;
                }
                break;
            case 64608020:
                if (a11.equals("hide_typing")) {
                    c11 = 3;
                    break;
                }
                break;
            case 99891402:
                if (a11.equals("show_dialog")) {
                    c11 = 4;
                    break;
                }
                break;
            case 381787729:
                if (a11.equals("apply_menu_items")) {
                    c11 = 5;
                    break;
                }
                break;
            case 573178105:
                if (a11.equals("show_typing")) {
                    c11 = 6;
                    break;
                }
                break;
            case 1766276262:
                if (a11.equals("update_connection_state")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1862666772:
                if (a11.equals("navigation")) {
                    c11 = 8;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                Update.State.d dVar = (Update.State.d) update;
                String c12 = dVar.c();
                if (c12 != null) {
                    this.f62523k.postValue(c12);
                }
                Boolean e11 = dVar.e();
                if (e11 != null) {
                    this.f62524l.postValue(e11);
                }
                g30.b b11 = dVar.b();
                if (b11 != null) {
                    this.f62526n.postValue(b11);
                }
                Integer d11 = dVar.d();
                if (d11 != null) {
                    this.f62525m.postValue(d11);
                    return;
                } else {
                    this.f62525m.postValue(131073);
                    return;
                }
            case 1:
                this.f62516d.put(this.f62514b, ((Update.State.a) update).b());
                ArrayList arrayList = new ArrayList();
                for (Map.Entry next : this.f62516d.entrySet()) {
                    for (MessagingItem messagingItem : (List) next.getValue()) {
                        if (messagingItem instanceof MessagingItem.m) {
                            Date timestamp = messagingItem.getTimestamp();
                            String a12 = messagingItem.a();
                            MessagingItem.m mVar = (MessagingItem.m) messagingItem;
                            messagingItem = new MessagingItem.m(timestamp, a12, mVar.b(), mVar.d(), mVar.c(), this.f62514b != null && ((c) next.getKey()).equals(this.f62514b));
                        }
                        arrayList.add(messagingItem);
                    }
                }
                this.f62519g.postValue(arrayList);
                this.f62517e.b(arrayList);
                return;
            case 2:
                this.f62528p.postValue(((Update.c) update).b());
                return;
            case 3:
                this.f62521i.postValue(new z(false));
                return;
            case 4:
                this.f62529q.postValue(((Update.d) update).b());
                return;
            case 5:
                this.f62520h.postValue(((Update.b) update).b());
                return;
            case 6:
                this.f62521i.postValue(new z(true, ((Update.State.b) update).b()));
                return;
            case 7:
                this.f62522j.postValue(((Update.State.c) update).b());
                return;
            case 8:
                this.f62527o.postValue((Update.a.C0685a) update);
                return;
            default:
                return;
        }
    }
}
