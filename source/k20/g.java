package k20;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public f f68229a;

    /* renamed from: b  reason: collision with root package name */
    public f f68230b;

    public synchronized void a(f fVar) {
        if (fVar != null) {
            try {
                f fVar2 = this.f68230b;
                if (fVar2 != null) {
                    fVar2.f68228c = fVar;
                    this.f68230b = fVar;
                } else if (this.f68229a == null) {
                    this.f68230b = fVar;
                    this.f68229a = fVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th2) {
                throw th2;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    public synchronized f b() {
        f fVar;
        fVar = this.f68229a;
        if (fVar != null) {
            f fVar2 = fVar.f68228c;
            this.f68229a = fVar2;
            if (fVar2 == null) {
                this.f68230b = null;
            }
        }
        return fVar;
    }

    public synchronized f c(int i11) throws InterruptedException {
        if (this.f68229a == null) {
            wait((long) i11);
        }
        return b();
    }
}
