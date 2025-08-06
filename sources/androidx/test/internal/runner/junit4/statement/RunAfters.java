package androidx.test.internal.runner.junit4.statement;

import java.util.List;
import org.junit.runners.model.Statement;
import x20.c;

public class RunAfters extends UiThreadStatement {

    /* renamed from: c  reason: collision with root package name */
    public final Statement f11545c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f11546d;

    /* renamed from: e  reason: collision with root package name */
    public final List<c> f11547e;

    public RunAfters(c cVar, Statement statement, List<c> list, Object obj) {
        super(statement, UiThreadStatement.e(cVar));
        this.f11545c = statement;
        this.f11547e = list;
        this.f11546d = obj;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void a() throws java.lang.Throwable {
        /*
            r7 = this;
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            r1 = 0
            org.junit.runners.model.Statement r2 = r7.f11545c     // Catch:{ all -> 0x0039 }
            r2.a()     // Catch:{ all -> 0x0039 }
            java.util.List<x20.c> r2 = r7.f11547e
            java.util.Iterator r2 = r2.iterator()
        L_0x0011:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x006b
            java.lang.Object r3 = r2.next()
            x20.c r3 = (x20.c) r3
            boolean r4 = androidx.test.internal.runner.junit4.statement.UiThreadStatement.e(r3)
            if (r4 == 0) goto L_0x002c
            androidx.test.internal.runner.junit4.statement.RunAfters$1 r4 = new androidx.test.internal.runner.junit4.statement.RunAfters$1
            r4.<init>(r3, r0)
            androidx.test.internal.runner.junit4.statement.UiThreadStatement.d(r4)
            goto L_0x0011
        L_0x002c:
            java.lang.Object r4 = r7.f11546d     // Catch:{ all -> 0x0034 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0034 }
            r3.m(r4, r5)     // Catch:{ all -> 0x0034 }
            goto L_0x0011
        L_0x0034:
            r3 = move-exception
            r0.add(r3)
            goto L_0x0011
        L_0x0039:
            r2 = move-exception
            r0.add(r2)     // Catch:{ all -> 0x006f }
            java.util.List<x20.c> r2 = r7.f11547e
            java.util.Iterator r2 = r2.iterator()
        L_0x0043:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x006b
            java.lang.Object r3 = r2.next()
            x20.c r3 = (x20.c) r3
            boolean r4 = androidx.test.internal.runner.junit4.statement.UiThreadStatement.e(r3)
            if (r4 == 0) goto L_0x005e
            androidx.test.internal.runner.junit4.statement.RunAfters$1 r4 = new androidx.test.internal.runner.junit4.statement.RunAfters$1
            r4.<init>(r3, r0)
            androidx.test.internal.runner.junit4.statement.UiThreadStatement.d(r4)
            goto L_0x0043
        L_0x005e:
            java.lang.Object r4 = r7.f11546d     // Catch:{ all -> 0x0066 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0066 }
            r3.m(r4, r5)     // Catch:{ all -> 0x0066 }
            goto L_0x0043
        L_0x0066:
            r3 = move-exception
            r0.add(r3)
            goto L_0x0043
        L_0x006b:
            org.junit.runners.model.MultipleFailureException.assertEmpty(r0)
            return
        L_0x006f:
            r2 = move-exception
            java.util.List<x20.c> r3 = r7.f11547e
            java.util.Iterator r3 = r3.iterator()
        L_0x0076:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x009e
            java.lang.Object r4 = r3.next()
            x20.c r4 = (x20.c) r4
            boolean r5 = androidx.test.internal.runner.junit4.statement.UiThreadStatement.e(r4)
            if (r5 == 0) goto L_0x0091
            androidx.test.internal.runner.junit4.statement.RunAfters$1 r5 = new androidx.test.internal.runner.junit4.statement.RunAfters$1
            r5.<init>(r4, r0)
            androidx.test.internal.runner.junit4.statement.UiThreadStatement.d(r5)
            goto L_0x0076
        L_0x0091:
            java.lang.Object r5 = r7.f11546d     // Catch:{ all -> 0x0099 }
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x0099 }
            r4.m(r5, r6)     // Catch:{ all -> 0x0099 }
            goto L_0x0076
        L_0x0099:
            r4 = move-exception
            r0.add(r4)
            goto L_0x0076
        L_0x009e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.internal.runner.junit4.statement.RunAfters.a():void");
    }
}
