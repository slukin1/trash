package org.junit.runner.notification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

public class RunNotifier {

    /* renamed from: a  reason: collision with root package name */
    public final List<RunListener> f25467a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f25468b = false;

    public class a extends h {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Description f25469c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Description description) throws Exception {
            super(RunNotifier.this);
            this.f25469c = description;
        }

        public void a(RunListener runListener) throws Exception {
            runListener.f(this.f25469c);
        }
    }

    public class b extends h {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Result f25471c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Result result) throws Exception {
            super(RunNotifier.this);
            this.f25471c = result;
        }

        public void a(RunListener runListener) throws Exception {
            runListener.e(this.f25471c);
        }
    }

    public class c extends h {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Description f25473c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Description description) throws Exception {
            super(RunNotifier.this);
            this.f25473c = description;
        }

        public void a(RunListener runListener) throws Exception {
            runListener.g(this.f25473c);
        }
    }

    public class d extends h {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f25475c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(List list, List list2) throws Exception {
            super(list);
            this.f25475c = list2;
        }

        public void a(RunListener runListener) throws Exception {
            for (Failure b11 : this.f25475c) {
                runListener.b(b11);
            }
        }
    }

    public class e extends h {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Failure f25477c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Failure failure) {
            super(RunNotifier.this);
            this.f25477c = failure;
        }

        public void a(RunListener runListener) throws Exception {
            runListener.a(this.f25477c);
        }
    }

    public class f extends h {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Description f25479c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Description description) throws Exception {
            super(RunNotifier.this);
            this.f25479c = description;
        }

        public void a(RunListener runListener) throws Exception {
            runListener.d(this.f25479c);
        }
    }

    public class g extends h {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Description f25481c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Description description) throws Exception {
            super(RunNotifier.this);
            this.f25481c = description;
        }

        public void a(RunListener runListener) throws Exception {
            runListener.c(this.f25481c);
        }
    }

    public abstract class h {

        /* renamed from: a  reason: collision with root package name */
        public final List<RunListener> f25483a;

        public h(RunNotifier runNotifier) {
            this(runNotifier.f25467a);
        }

        public abstract void a(RunListener runListener) throws Exception;

        public void b() {
            int size = this.f25483a.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (RunListener next : this.f25483a) {
                try {
                    a(next);
                    arrayList.add(next);
                } catch (Exception e11) {
                    arrayList2.add(new Failure(Description.TEST_MECHANISM, e11));
                }
            }
            RunNotifier.this.g(arrayList, arrayList2);
        }

        public h(List<RunListener> list) {
            this.f25483a = list;
        }
    }

    public void c(RunListener runListener) {
        Objects.requireNonNull(runListener, "Cannot add a null listener");
        this.f25467a.add(0, n(runListener));
    }

    public void d(RunListener runListener) {
        Objects.requireNonNull(runListener, "Cannot add a null listener");
        this.f25467a.add(n(runListener));
    }

    public void e(Failure failure) {
        new e(failure).b();
    }

    public void f(Failure failure) {
        g(this.f25467a, Arrays.asList(new Failure[]{failure}));
    }

    public final void g(List<RunListener> list, List<Failure> list2) {
        if (!list2.isEmpty()) {
            new d(list, list2).b();
        }
    }

    public void h(Description description) {
        new g(description).b();
    }

    public void i(Description description) {
        new f(description).b();
    }

    public void j(Result result) {
        new b(result).b();
    }

    public void k(Description description) {
        new a(description).b();
    }

    public void l(Description description) throws StoppedByUserException {
        if (!this.f25468b) {
            new c(description).b();
            return;
        }
        throw new StoppedByUserException();
    }

    public void m(RunListener runListener) {
        Objects.requireNonNull(runListener, "Cannot remove a null listener");
        this.f25467a.remove(n(runListener));
    }

    public RunListener n(RunListener runListener) {
        return runListener.getClass().isAnnotationPresent(RunListener.a.class) ? runListener : new a(runListener, this);
    }
}
