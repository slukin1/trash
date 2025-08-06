package kotlinx.coroutines;

public abstract class JobNode extends CompletionHandlerBase implements x0, i1 {

    /* renamed from: e  reason: collision with root package name */
    public JobSupport f56956e;

    public NodeList a() {
        return null;
    }

    public void dispose() {
        r().P0(this);
    }

    public boolean isActive() {
        return true;
    }

    public final JobSupport r() {
        JobSupport jobSupport = this.f56956e;
        if (jobSupport != null) {
            return jobSupport;
        }
        return null;
    }

    public final void s(JobSupport jobSupport) {
        this.f56956e = jobSupport;
    }

    public String toString() {
        return k0.a(this) + '@' + k0.b(this) + "[job@" + k0.b(r()) + ']';
    }
}
