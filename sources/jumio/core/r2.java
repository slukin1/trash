package jumio.core;

import com.jumio.ale.swig.ALECore;
import com.jumio.ale.swig.ALERequest;
import com.jumio.ale.swig.ALESettings;

public final class r2 extends ALECore {

    /* renamed from: b  reason: collision with root package name */
    public final Object f56315b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public boolean f56316c = true;

    public r2(ALESettings aLESettings) {
        super(aLESettings);
    }

    public final ALERequest createRequest() throws Exception {
        ALERequest createRequest;
        synchronized (this.f56315b) {
            if (this.f56316c) {
                createRequest = super.createRequest();
            } else {
                throw new Exception("AleCore instance not valid");
            }
        }
        return createRequest;
    }

    public final synchronized void delete() {
        synchronized (this.f56315b) {
            this.f56316c = false;
            super.delete();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(1:5)(2:6|7)|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void destroyRequest(com.jumio.ale.swig.ALERequest r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f56315b
            monitor-enter(r0)
            boolean r1 = r2.f56316c     // Catch:{ all -> 0x0010 }
            if (r1 == 0) goto L_0x000b
            super.destroyRequest(r3)     // Catch:{ all -> 0x0010 }
            goto L_0x000e
        L_0x000b:
            r3.delete()     // Catch:{ Exception -> 0x000e }
        L_0x000e:
            monitor-exit(r0)     // Catch:{ all -> 0x0010 }
            return
        L_0x0010:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0010 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.r2.destroyRequest(com.jumio.ale.swig.ALERequest):void");
    }
}
