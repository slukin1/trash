package q6;

import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import i6.i;
import rx.functions.Action0;
import rx.functions.Action1;
import u6.g;

public class d<T> extends EasySubscriber<T> {

    /* renamed from: b  reason: collision with root package name */
    public g f69031b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f69032c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f69033d;

    public d(g gVar) {
        this.f69031b = gVar;
    }

    public static <B> d<B> b(g gVar, Action0 action0, Action1<B> action1, Action1<APIStatusErrorException> action12, Action1<Throwable> action13, Action0 action02) {
        return new d(gVar, action0, action1, action12, action13, action02);
    }

    public static <B> d<B> c(g gVar, Action1<B> action1) {
        return new d<>(gVar, action1);
    }

    public static <B> d<B> d(g gVar, Action1<B> action1, Action1<APIStatusErrorException> action12, Action1<Throwable> action13) {
        return new d<>(gVar, action1, action12, action13);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        g gVar = this.f69031b;
        if (gVar != null && gVar.isAlive()) {
            this.f69032c = true;
            this.f69031b.showProgressDialog(this.f69033d);
        }
    }

    public void onAfter() {
        super.onAfter();
        g gVar = this.f69031b;
        if (gVar != null && this.f69032c) {
            try {
                gVar.dismissProgressDialog();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void onStart() {
        super.onStart();
        i6.d.b("enter");
        i.b().d(new c(this));
    }

    public d(g gVar, boolean z11) {
        this.f69031b = gVar;
        this.f69033d = z11;
    }

    public d(g gVar, Action1<T> action1) {
        super(action1);
        this.f69031b = gVar;
    }

    public d(g gVar, Action1<T> action1, Action1<APIStatusErrorException> action12, Action1<Throwable> action13) {
        super(action1, action12, action13);
        this.f69031b = gVar;
    }

    public d(g gVar, Action0 action0, Action1<T> action1, Action1<APIStatusErrorException> action12, Action1<Throwable> action13, Action0 action02) {
        super(action0, action1, action12, action13, action02);
        this.f69031b = gVar;
    }
}
