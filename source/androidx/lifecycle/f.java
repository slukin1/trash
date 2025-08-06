package androidx.lifecycle;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ComputableLiveData f10001b;

    public /* synthetic */ f(ComputableLiveData computableLiveData) {
        this.f10001b = computableLiveData;
    }

    public final void run() {
        ComputableLiveData.g(this.f10001b);
    }
}
