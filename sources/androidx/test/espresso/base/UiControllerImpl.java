package androidx.test.espresso.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import androidx.test.espresso.IdlingPolicies;
import androidx.test.espresso.IdlingPolicy;
import androidx.test.espresso.InjectEventSecurityException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.base.Interrogator;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Throwables;
import java.util.BitSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import q00.a;

final class UiControllerImpl implements Handler.Callback, UiController {

    /* renamed from: l  reason: collision with root package name */
    public static final String f11115l = UiControllerImpl.class.getSimpleName();

    /* renamed from: m  reason: collision with root package name */
    public static final Callable<Void> f11116m = new Callable<Void>() {
        /* renamed from: a */
        public Void call() {
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final EventInjector f11117b;

    /* renamed from: c  reason: collision with root package name */
    public final BitSet f11118c;

    /* renamed from: d  reason: collision with root package name */
    public final ExecutorService f11119d;

    /* renamed from: e  reason: collision with root package name */
    public final Looper f11120e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f11121f;

    /* renamed from: g  reason: collision with root package name */
    public MainThreadInterrogation f11122g;

    /* renamed from: h  reason: collision with root package name */
    public int f11123h;

    /* renamed from: i  reason: collision with root package name */
    public IdleNotifier<Runnable> f11124i;

    /* renamed from: j  reason: collision with root package name */
    public IdleNotifier<Runnable> f11125j;

    /* renamed from: k  reason: collision with root package name */
    public a<IdleNotifier<Object>> f11126k;

    public enum IdleCondition {
        DELAY_HAS_PAST,
        ASYNC_TASKS_HAVE_IDLED,
        COMPAT_TASKS_HAVE_IDLED,
        KEY_INJECT_HAS_COMPLETED,
        MOTION_INJECTION_HAS_COMPLETED,
        DYNAMIC_TASKS_HAVE_IDLED;

        public static BitSet createConditionSet() {
            return new BitSet(values().length);
        }

        public static boolean handleMessage(Message message, BitSet bitSet, int i11) {
            IdleCondition[] values = values();
            int i12 = message.what;
            if (i12 < 0 || i12 >= values.length) {
                return false;
            }
            IdleCondition idleCondition = values[i12];
            if (message.arg1 == i11) {
                idleCondition.signal(bitSet);
                return true;
            }
            String d11 = UiControllerImpl.f11115l;
            String valueOf = String.valueOf(idleCondition);
            int i13 = message.arg1;
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 90);
            sb2.append("ignoring signal of: ");
            sb2.append(valueOf);
            sb2.append(" from previous generation: ");
            sb2.append(i13);
            sb2.append(" current generation: ");
            sb2.append(i11);
            Log.w(d11, sb2.toString());
            return true;
        }

        public Message createSignal(Handler handler, int i11) {
            return Message.obtain(handler, ordinal(), i11, 0, (Object) null);
        }

        public boolean isSignaled(BitSet bitSet) {
            return bitSet.get(ordinal());
        }

        public void reset(BitSet bitSet) {
            bitSet.set(ordinal(), false);
        }

        public void signal(BitSet bitSet) {
            bitSet.set(ordinal());
        }
    }

    public enum InterrogationStatus {
        TIMED_OUT,
        COMPLETED,
        INTERRUPTED
    }

    public static final class MainThreadInterrogation implements Interrogator.InterrogationHandler<InterrogationStatus> {

        /* renamed from: a  reason: collision with root package name */
        public final EnumSet<IdleCondition> f11136a;

        /* renamed from: b  reason: collision with root package name */
        public final BitSet f11137b;

        /* renamed from: c  reason: collision with root package name */
        public final long f11138c;

        /* renamed from: d  reason: collision with root package name */
        public InterrogationStatus f11139d = InterrogationStatus.COMPLETED;

        /* renamed from: e  reason: collision with root package name */
        public int f11140e = 0;

        public MainThreadInterrogation(EnumSet<IdleCondition> enumSet, BitSet bitSet, long j11) {
            this.f11136a = enumSet;
            this.f11137b = bitSet;
            this.f11138c = j11;
        }

        public boolean a() {
            return i();
        }

        public boolean b() {
            this.f11140e++;
            return i();
        }

        public boolean c() {
            return i();
        }

        public boolean d() {
            return !h();
        }

        public void e() {
        }

        public boolean f() {
            return !h();
        }

        public final boolean h() {
            boolean z11 = true;
            if (InterrogationStatus.INTERRUPTED == this.f11139d) {
                return true;
            }
            int i11 = this.f11140e;
            boolean z12 = i11 > 0 && i11 % 100 == 0;
            Iterator it2 = this.f11136a.iterator();
            while (it2.hasNext()) {
                IdleCondition idleCondition = (IdleCondition) it2.next();
                if (!idleCondition.isSignaled(this.f11137b)) {
                    if (!z12) {
                        return false;
                    }
                    String d11 = UiControllerImpl.f11115l;
                    String name = idleCondition.name();
                    int i12 = this.f11140e;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(name).length() + 41);
                    sb2.append("Waiting for: ");
                    sb2.append(name);
                    sb2.append(" for ");
                    sb2.append(i12);
                    sb2.append(" iterations.");
                    Log.w(d11, sb2.toString());
                    z11 = false;
                }
            }
            return z11;
        }

        public final boolean i() {
            if (InterrogationStatus.INTERRUPTED == this.f11139d) {
                return false;
            }
            if (SystemClock.uptimeMillis() < this.f11138c) {
                return true;
            }
            this.f11139d = InterrogationStatus.TIMED_OUT;
            return false;
        }

        /* renamed from: j */
        public InterrogationStatus get() {
            return this.f11139d;
        }
    }

    public class SignalingTask<T> extends FutureTask<T> {

        /* renamed from: b  reason: collision with root package name */
        public final IdleCondition f11141b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11142c;

        public SignalingTask(Callable<T> callable, IdleCondition idleCondition, int i11) {
            super(callable);
            this.f11141b = (IdleCondition) Preconditions.i(idleCondition);
            this.f11142c = i11;
        }

        public void done() {
            UiControllerImpl.this.f11121f.sendMessage(this.f11141b.createSignal(UiControllerImpl.this.f11121f, this.f11142c));
        }
    }

    public boolean a(final MotionEvent motionEvent) throws InjectEventSecurityException {
        Preconditions.i(motionEvent);
        Preconditions.p(Looper.myLooper() == this.f11120e, "Expecting to be on main thread!");
        g();
        AnonymousClass3 r12 = new Callable<Boolean>() {
            /* renamed from: a */
            public Boolean call() throws Exception {
                EventInjector unused = UiControllerImpl.this.f11117b;
                throw null;
            }
        };
        IdleCondition idleCondition = IdleCondition.MOTION_INJECTION_HAS_COMPLETED;
        SignalingTask signalingTask = new SignalingTask(r12, idleCondition, this.f11123h);
        this.f11119d.submit(signalingTask);
        j(idleCondition, this.f11126k.get());
        try {
            Preconditions.p(signalingTask.isDone(), "Motion event injection was signaled - but it wasnt done.");
            boolean booleanValue = ((Boolean) signalingTask.get()).booleanValue();
            h();
            return booleanValue;
        } catch (ExecutionException e11) {
            if (!(e11.getCause() instanceof InjectEventSecurityException)) {
                Throwables.e(e11.getCause() != null ? e11.getCause() : e11);
                Throwable cause = e11.getCause();
                Throwable th2 = e11;
                if (cause != null) {
                    th2 = e11.getCause();
                }
                throw new RuntimeException(th2);
            }
            throw ((InjectEventSecurityException) e11.getCause());
        } catch (InterruptedException e12) {
            throw new RuntimeException(e12);
        } catch (Throwable th3) {
            h();
            throw th3;
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Iterable<android.view.MotionEvent>, java.lang.Object, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(java.lang.Iterable<android.view.MotionEvent> r6) throws androidx.test.espresso.InjectEventSecurityException {
        /*
            r5 = this;
            androidx.test.espresso.core.internal.deps.guava.base.Preconditions.i(r6)
            boolean r0 = androidx.test.espresso.core.internal.deps.guava.collect.Iterables.b(r6)
            r1 = 1
            r0 = r0 ^ r1
            java.lang.String r2 = "Expecting non-empty events to inject"
            androidx.test.espresso.core.internal.deps.guava.base.Preconditions.p(r0, r2)
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r2 = r5.f11120e
            if (r0 != r2) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            java.lang.String r0 = "Expecting to be on main thread!"
            androidx.test.espresso.core.internal.deps.guava.base.Preconditions.p(r1, r0)
            r5.g()
            java.util.Iterator r0 = r6.iterator()
            r1 = 0
            java.lang.Object r6 = androidx.test.espresso.core.internal.deps.guava.collect.Iterables.a(r6, r1)
            android.view.MotionEvent r6 = (android.view.MotionEvent) r6
            long r1 = r6.getEventTime()
            long r3 = android.os.SystemClock.uptimeMillis()
            long r3 = r3 - r1
            androidx.test.espresso.base.UiControllerImpl$SignalingTask r6 = new androidx.test.espresso.base.UiControllerImpl$SignalingTask
            androidx.test.espresso.base.UiControllerImpl$4 r1 = new androidx.test.espresso.base.UiControllerImpl$4
            r1.<init>(r0, r3)
            androidx.test.espresso.base.UiControllerImpl$IdleCondition r0 = androidx.test.espresso.base.UiControllerImpl.IdleCondition.MOTION_INJECTION_HAS_COMPLETED
            int r2 = r5.f11123h
            r6.<init>(r1, r0, r2)
            java.util.concurrent.ExecutorService r1 = r5.f11119d
            r1.submit(r6)
            q00.a<androidx.test.espresso.base.IdleNotifier<java.lang.Object>> r1 = r5.f11126k
            java.lang.Object r1 = r1.get()
            androidx.test.espresso.base.IdleNotifier r1 = (androidx.test.espresso.base.IdleNotifier) r1
            r5.j(r0, r1)
            boolean r0 = r6.isDone()     // Catch:{ ExecutionException -> 0x0072, InterruptedException -> 0x006b }
            java.lang.String r1 = "MotionEvents injection was signaled - but it wasnt done."
            androidx.test.espresso.core.internal.deps.guava.base.Preconditions.p(r0, r1)     // Catch:{ ExecutionException -> 0x0072, InterruptedException -> 0x006b }
            java.lang.Object r6 = r6.get()     // Catch:{ ExecutionException -> 0x0072, InterruptedException -> 0x006b }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ ExecutionException -> 0x0072, InterruptedException -> 0x006b }
            boolean r6 = r6.booleanValue()     // Catch:{ ExecutionException -> 0x0072, InterruptedException -> 0x006b }
            r5.h()
            return r6
        L_0x0069:
            r6 = move-exception
            goto L_0x00a1
        L_0x006b:
            r6 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0069 }
            r0.<init>(r6)     // Catch:{ all -> 0x0069 }
            throw r0     // Catch:{ all -> 0x0069 }
        L_0x0072:
            r6 = move-exception
            java.lang.Throwable r0 = r6.getCause()     // Catch:{ all -> 0x0069 }
            boolean r0 = r0 instanceof androidx.test.espresso.InjectEventSecurityException     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x009a
            java.lang.Throwable r0 = r6.getCause()     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x0086
            java.lang.Throwable r0 = r6.getCause()     // Catch:{ all -> 0x0069 }
            goto L_0x0087
        L_0x0086:
            r0 = r6
        L_0x0087:
            androidx.test.espresso.core.internal.deps.guava.base.Throwables.e(r0)     // Catch:{ all -> 0x0069 }
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0069 }
            java.lang.Throwable r1 = r6.getCause()     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x0096
            java.lang.Throwable r6 = r6.getCause()     // Catch:{ all -> 0x0069 }
        L_0x0096:
            r0.<init>(r6)     // Catch:{ all -> 0x0069 }
            throw r0     // Catch:{ all -> 0x0069 }
        L_0x009a:
            java.lang.Throwable r6 = r6.getCause()     // Catch:{ all -> 0x0069 }
            androidx.test.espresso.InjectEventSecurityException r6 = (androidx.test.espresso.InjectEventSecurityException) r6     // Catch:{ all -> 0x0069 }
            throw r6     // Catch:{ all -> 0x0069 }
        L_0x00a1:
            r5.h()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.base.UiControllerImpl.b(java.lang.Iterable):boolean");
    }

    public void c(long j11) {
        g();
        boolean z11 = false;
        Preconditions.p(Looper.myLooper() == this.f11120e, "Expecting to be on main thread!");
        IdleCondition idleCondition = IdleCondition.DELAY_HAS_PAST;
        Preconditions.p(!idleCondition.isSignaled(this.f11118c), "recursion detected!");
        if (j11 > 0) {
            z11 = true;
        }
        Preconditions.d(z11);
        this.f11121f.postAtTime(new SignalingTask(f11116m, idleCondition, this.f11123h), Integer.valueOf(this.f11123h), SystemClock.uptimeMillis() + j11);
        j(idleCondition, this.f11126k.get());
        h();
    }

    public final void g() {
        if (this.f11121f == null) {
            this.f11121f = new Handler(this);
        }
    }

    /* JADX INFO: finally extract failed */
    public void h() {
        g();
        Preconditions.p(Looper.myLooper() == this.f11120e, "Expecting to be on main thread!");
        IdleNotifier<Object> idleNotifier = this.f11126k.get();
        while (true) {
            EnumSet<E> noneOf = EnumSet.noneOf(IdleCondition.class);
            if (!this.f11124i.a()) {
                IdleNotifier<Runnable> idleNotifier2 = this.f11124i;
                Callable<Void> callable = f11116m;
                IdleCondition idleCondition = IdleCondition.ASYNC_TASKS_HAVE_IDLED;
                idleNotifier2.c(new SignalingTask(callable, idleCondition, this.f11123h));
                noneOf.add(idleCondition);
            }
            if (!this.f11125j.a()) {
                IdleNotifier<Runnable> idleNotifier3 = this.f11125j;
                Callable<Void> callable2 = f11116m;
                IdleCondition idleCondition2 = IdleCondition.COMPAT_TASKS_HAVE_IDLED;
                idleNotifier3.c(new SignalingTask(callable2, idleCondition2, this.f11123h));
                noneOf.add(idleCondition2);
            }
            if (!idleNotifier.a()) {
                final IdlingPolicy b11 = IdlingPolicies.b();
                final IdlingPolicy a11 = IdlingPolicies.a();
                Callable<Void> callable3 = f11116m;
                IdleCondition idleCondition3 = IdleCondition.DYNAMIC_TASKS_HAVE_IDLED;
                final SignalingTask signalingTask = new SignalingTask(callable3, idleCondition3, this.f11123h);
                idleNotifier.c(new Object() {
                });
                noneOf.add(idleCondition3);
            }
            try {
                idleNotifier = i(noneOf, idleNotifier);
                this.f11124i.b();
                this.f11125j.b();
                idleNotifier.b();
                if (this.f11124i.a() && this.f11125j.a() && idleNotifier.a()) {
                    return;
                }
            } catch (Throwable th2) {
                this.f11124i.b();
                this.f11125j.b();
                idleNotifier.b();
                throw th2;
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (IdleCondition.handleMessage(message, this.f11118c, this.f11123h)) {
            return true;
        }
        String str = f11115l;
        String valueOf = String.valueOf(message);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 22);
        sb2.append("Unknown message type: ");
        sb2.append(valueOf);
        Log.i(str, sb2.toString());
        return false;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final androidx.test.espresso.base.IdleNotifier<java.lang.Object> i(java.util.EnumSet<androidx.test.espresso.base.UiControllerImpl.IdleCondition> r10, androidx.test.espresso.base.IdleNotifier<java.lang.Object> r11) {
        /*
            r9 = this;
            java.lang.String r0 = "Espresso interrogation of the main thread is interrupted"
            androidx.test.espresso.IdlingPolicy r1 = androidx.test.espresso.IdlingPolicies.c()
            r2 = 0
            r3 = 1
            long r4 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00c9 }
            java.util.concurrent.TimeUnit r6 = r1.b()     // Catch:{ all -> 0x00c9 }
            long r7 = r1.a()     // Catch:{ all -> 0x00c9 }
            long r6 = r6.toMillis(r7)     // Catch:{ all -> 0x00c9 }
            long r4 = r4 + r6
            androidx.test.espresso.base.UiControllerImpl$MainThreadInterrogation r6 = new androidx.test.espresso.base.UiControllerImpl$MainThreadInterrogation     // Catch:{ all -> 0x00c9 }
            java.util.BitSet r7 = r9.f11118c     // Catch:{ all -> 0x00c9 }
            r6.<init>(r10, r7, r4)     // Catch:{ all -> 0x00c9 }
            r9.f11122g = r6     // Catch:{ all -> 0x00c9 }
            java.lang.Object r4 = androidx.test.espresso.base.Interrogator.d(r6)     // Catch:{ all -> 0x00c9 }
            androidx.test.espresso.base.UiControllerImpl$InterrogationStatus r4 = (androidx.test.espresso.base.UiControllerImpl.InterrogationStatus) r4     // Catch:{ all -> 0x00c9 }
            androidx.test.espresso.base.UiControllerImpl$InterrogationStatus r5 = androidx.test.espresso.base.UiControllerImpl.InterrogationStatus.COMPLETED     // Catch:{ all -> 0x00c9 }
            if (r5 != r4) goto L_0x004a
            int r0 = r9.f11123h
            int r0 = r0 + r3
            r9.f11123h = r0
            java.util.Iterator r10 = r10.iterator()
        L_0x0035:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x0047
            java.lang.Object r0 = r10.next()
            androidx.test.espresso.base.UiControllerImpl$IdleCondition r0 = (androidx.test.espresso.base.UiControllerImpl.IdleCondition) r0
            java.util.BitSet r1 = r9.f11118c
            r0.reset(r1)
            goto L_0x0035
        L_0x0047:
            r9.f11122g = r2
            return r11
        L_0x004a:
            androidx.test.espresso.base.UiControllerImpl$InterrogationStatus r5 = androidx.test.espresso.base.UiControllerImpl.InterrogationStatus.INTERRUPTED     // Catch:{ all -> 0x00c9 }
            if (r5 == r4) goto L_0x00be
            java.util.ArrayList r0 = androidx.test.espresso.core.internal.deps.guava.collect.Lists.g()     // Catch:{ all -> 0x00c9 }
            java.util.Iterator r4 = r10.iterator()     // Catch:{ all -> 0x00c9 }
        L_0x0056:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00c9 }
            if (r5 == 0) goto L_0x0072
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00c9 }
            androidx.test.espresso.base.UiControllerImpl$IdleCondition r5 = (androidx.test.espresso.base.UiControllerImpl.IdleCondition) r5     // Catch:{ all -> 0x00c9 }
            java.util.BitSet r6 = r9.f11118c     // Catch:{ all -> 0x00c9 }
            boolean r6 = r5.isSignaled(r6)     // Catch:{ all -> 0x00c9 }
            if (r6 != 0) goto L_0x0056
            java.lang.String r5 = r5.name()     // Catch:{ all -> 0x00c9 }
            r0.add(r5)     // Catch:{ all -> 0x00c9 }
            goto L_0x0056
        L_0x0072:
            java.lang.String r4 = "Looped for %s iterations over %s %s."
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00c9 }
            r6 = 0
            androidx.test.espresso.base.UiControllerImpl$MainThreadInterrogation r7 = r9.f11122g     // Catch:{ all -> 0x00c9 }
            int r7 = r7.f11140e     // Catch:{ all -> 0x00c9 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x00c9 }
            r5[r6] = r7     // Catch:{ all -> 0x00c9 }
            long r6 = r1.a()     // Catch:{ all -> 0x00c9 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x00c9 }
            r5[r3] = r6     // Catch:{ all -> 0x00c9 }
            r6 = 2
            java.util.concurrent.TimeUnit r7 = r1.b()     // Catch:{ all -> 0x00c9 }
            java.lang.String r7 = r7.name()     // Catch:{ all -> 0x00c9 }
            r5[r6] = r7     // Catch:{ all -> 0x00c9 }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ all -> 0x00c9 }
            r1.c(r0, r4)     // Catch:{ all -> 0x00c9 }
            int r0 = r9.f11123h
            int r0 = r0 + r3
            r9.f11123h = r0
            java.util.Iterator r10 = r10.iterator()
        L_0x00a9:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x00bb
            java.lang.Object r0 = r10.next()
            androidx.test.espresso.base.UiControllerImpl$IdleCondition r0 = (androidx.test.espresso.base.UiControllerImpl.IdleCondition) r0
            java.util.BitSet r1 = r9.f11118c
            r0.reset(r1)
            goto L_0x00a9
        L_0x00bb:
            r9.f11122g = r2
            return r11
        L_0x00be:
            java.lang.String r11 = f11115l     // Catch:{ all -> 0x00c9 }
            android.util.Log.w(r11, r0)     // Catch:{ all -> 0x00c9 }
            java.lang.RuntimeException r11 = new java.lang.RuntimeException     // Catch:{ all -> 0x00c9 }
            r11.<init>(r0)     // Catch:{ all -> 0x00c9 }
            throw r11     // Catch:{ all -> 0x00c9 }
        L_0x00c9:
            r11 = move-exception
            int r0 = r9.f11123h
            int r0 = r0 + r3
            r9.f11123h = r0
            java.util.Iterator r10 = r10.iterator()
        L_0x00d3:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x00e5
            java.lang.Object r0 = r10.next()
            androidx.test.espresso.base.UiControllerImpl$IdleCondition r0 = (androidx.test.espresso.base.UiControllerImpl.IdleCondition) r0
            java.util.BitSet r1 = r9.f11118c
            r0.reset(r1)
            goto L_0x00d3
        L_0x00e5:
            r9.f11122g = r2
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.base.UiControllerImpl.i(java.util.EnumSet, androidx.test.espresso.base.IdleNotifier):androidx.test.espresso.base.IdleNotifier");
    }

    public final void j(IdleCondition idleCondition, IdleNotifier<Object> idleNotifier) {
        i(EnumSet.of(idleCondition), idleNotifier);
    }
}
