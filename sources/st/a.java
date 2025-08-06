package st;

import rx.subjects.BehaviorSubject;

public final class a<TYPE> {

    /* renamed from: a  reason: collision with root package name */
    public final BehaviorSubject<TYPE> f84885a;

    public a(TYPE type) {
        this.f84885a = BehaviorSubject.create(type);
    }

    public void a() {
        this.f84885a.onCompleted();
    }

    public void b(TYPE type) {
        this.f84885a.onNext(type);
    }
}
