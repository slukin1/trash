package zendesk.classic.messaging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.z;
import g30.w;
import java.util.List;
import zendesk.classic.messaging.Update;
import zendesk.classic.messaging.ui.MessagingState;

public class l extends ViewModel implements g30.f {

    /* renamed from: b  reason: collision with root package name */
    public final k f62537b;

    /* renamed from: c  reason: collision with root package name */
    public final MediatorLiveData<MessagingState> f62538c;

    /* renamed from: d  reason: collision with root package name */
    public final LiveData<Update.a.C0685a> f62539d;

    /* renamed from: e  reason: collision with root package name */
    public final MediatorLiveData<DialogContent> f62540e = new MediatorLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    public final MediatorLiveData<Banner> f62541f;

    public class a implements z<List<MessagingItem>> {
        public a() {
        }

        /* renamed from: a */
        public void onChanged(List<MessagingItem> list) {
            l.this.f62538c.setValue(((MessagingState) l.this.f62538c.getValue()).a().g(list).a());
        }
    }

    public class b implements z<Boolean> {
        public b() {
        }

        /* renamed from: a */
        public void onChanged(Boolean bool) {
            l.this.f62538c.setValue(((MessagingState) l.this.f62538c.getValue()).a().e(bool.booleanValue()).a());
        }
    }

    public class c implements z<g30.z> {
        public c() {
        }

        /* renamed from: a */
        public void onChanged(g30.z zVar) {
            l.this.f62538c.setValue(((MessagingState) l.this.f62538c.getValue()).a().h(new MessagingState.b(zVar.b(), zVar.a())).a());
        }
    }

    public class d implements z<ConnectionState> {
        public d() {
        }

        /* renamed from: a */
        public void onChanged(ConnectionState connectionState) {
            l.this.f62538c.setValue(((MessagingState) l.this.f62538c.getValue()).a().d(connectionState).a());
        }
    }

    public class e implements z<String> {
        public e() {
        }

        /* renamed from: a */
        public void onChanged(String str) {
            l.this.f62538c.setValue(((MessagingState) l.this.f62538c.getValue()).a().c(str).a());
        }
    }

    public class f implements z<Integer> {
        public f() {
        }

        /* renamed from: a */
        public void onChanged(Integer num) {
            l.this.f62538c.setValue(((MessagingState) l.this.f62538c.getValue()).a().f(num.intValue()).a());
        }
    }

    public class g implements z<g30.b> {
        public g() {
        }

        /* renamed from: a */
        public void onChanged(g30.b bVar) {
            l.this.f62538c.setValue(((MessagingState) l.this.f62538c.getValue()).a().b(bVar).a());
        }
    }

    public class h implements z<Banner> {
        public h() {
        }

        /* renamed from: a */
        public void onChanged(Banner banner) {
            l.this.f62541f.setValue(banner);
        }
    }

    public l(k kVar) {
        this.f62537b = kVar;
        MediatorLiveData<MessagingState> mediatorLiveData = new MediatorLiveData<>();
        this.f62538c = mediatorLiveData;
        this.f62539d = kVar.l();
        mediatorLiveData.setValue(new MessagingState.Builder().e(true).a());
        MediatorLiveData<Banner> mediatorLiveData2 = new MediatorLiveData<>();
        this.f62541f = mediatorLiveData2;
        mediatorLiveData.b(kVar.k(), new a());
        mediatorLiveData.b(kVar.d(), new b());
        mediatorLiveData.b(kVar.m(), new c());
        mediatorLiveData.b(kVar.f(), new d());
        mediatorLiveData.b(kVar.e(), new e());
        mediatorLiveData.b(kVar.i(), new f());
        mediatorLiveData.b(kVar.c(), new g());
        mediatorLiveData2.b(kVar.h(), new h());
    }

    public void a(d dVar) {
        this.f62537b.a(dVar);
    }

    public w<DialogContent> h0() {
        return this.f62537b.g();
    }

    public w<Banner> i0() {
        return this.f62537b.h();
    }

    public LiveData<List<g30.g>> j0() {
        return this.f62537b.j();
    }

    public LiveData<MessagingState> k0() {
        return this.f62538c;
    }

    public LiveData<Update.a.C0685a> l0() {
        return this.f62539d;
    }

    public void m0() {
        this.f62537b.n();
    }

    public void onCleared() {
        this.f62537b.q();
    }
}
