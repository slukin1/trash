package androidx.appcompat.widget;

public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Toolbar f4567b;

    public /* synthetic */ f0(Toolbar toolbar) {
        this.f4567b = toolbar;
    }

    public final void run() {
        this.f4567b.invalidateMenu();
    }
}
