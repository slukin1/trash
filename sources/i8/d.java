package i8;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContactConfigInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final List<LinearSwapContactConfigInfo> f70354a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, LinearSwapContactConfigInfo> f70355b;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f70356a = new d();
    }

    public static d e() {
        return b.f70356a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(List list) {
        synchronized (this.f70354a) {
            this.f70354a.clear();
            this.f70354a.addAll(list);
        }
        synchronized (this.f70355b) {
            this.f70355b.clear();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                LinearSwapContactConfigInfo linearSwapContactConfigInfo = (LinearSwapContactConfigInfo) it2.next();
                this.f70355b.put(linearSwapContactConfigInfo.getContractCode(), linearSwapContactConfigInfo);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004b, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(java.lang.String r6, int r7) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r1 = 0
            if (r0 != 0) goto L_0x0051
            java.util.List<com.hbg.lib.network.linear.swap.core.bean.LinearSwapContactConfigInfo> r0 = r5.f70354a
            monitor-enter(r0)
            java.util.List<com.hbg.lib.network.linear.swap.core.bean.LinearSwapContactConfigInfo> r2 = r5.f70354a     // Catch:{ all -> 0x004e }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x004e }
            if (r2 != 0) goto L_0x004c
            java.util.List<com.hbg.lib.network.linear.swap.core.bean.LinearSwapContactConfigInfo> r2 = r5.f70354a     // Catch:{ all -> 0x004e }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x004e }
        L_0x0018:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x004c
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x004e }
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapContactConfigInfo r3 = (com.hbg.lib.network.linear.swap.core.bean.LinearSwapContactConfigInfo) r3     // Catch:{ all -> 0x004e }
            java.lang.String r4 = r3.getContractCode()     // Catch:{ all -> 0x004e }
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x004e }
            if (r4 == 0) goto L_0x0018
            int r6 = r3.getMarginMode()     // Catch:{ all -> 0x004e }
            r2 = 3
            r4 = 1
            if (r6 != r2) goto L_0x0038
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return r4
        L_0x0038:
            int r6 = r3.getMarginMode()     // Catch:{ all -> 0x004e }
            r2 = 2
            if (r6 != r4) goto L_0x0041
            if (r7 == r2) goto L_0x0049
        L_0x0041:
            int r6 = r3.getMarginMode()     // Catch:{ all -> 0x004e }
            if (r6 != r2) goto L_0x004a
            if (r7 != r4) goto L_0x004a
        L_0x0049:
            r1 = r4
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return r1
        L_0x004c:
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            goto L_0x0051
        L_0x004e:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            throw r6
        L_0x0051:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.d.b(java.lang.String, int):boolean");
    }

    public LinearSwapContactConfigInfo c(String str) {
        synchronized (this.f70355b) {
            if (this.f70355b.isEmpty()) {
                return null;
            }
            LinearSwapContactConfigInfo linearSwapContactConfigInfo = this.f70355b.get(str);
            return linearSwapContactConfigInfo;
        }
    }

    public Observable<List<LinearSwapContactConfigInfo>> d(boolean z11) {
        return (!z11 || this.f70354a.isEmpty()) ? h8.a.a().getContractConfigInfo().b().doOnNext(new c(this)) : Observable.just(this.f70354a);
    }

    public d() {
        this.f70354a = new ArrayList();
        this.f70355b = new HashMap();
    }
}
