package androidx.activity;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f3676b;

    public /* synthetic */ h(ComponentActivity componentActivity) {
        this.f3676b = componentActivity;
    }

    public final void run() {
        this.f3676b.invalidateMenu();
    }
}
