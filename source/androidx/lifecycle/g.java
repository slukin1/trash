package androidx.lifecycle;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ComputableLiveData f10003b;

    public /* synthetic */ g(ComputableLiveData computableLiveData) {
        this.f10003b = computableLiveData;
    }

    public final void run() {
        ComputableLiveData.f(this.f10003b);
    }
}
