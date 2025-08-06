package androidx.test.espresso.base;

import android.os.Binder;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Log;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Throwables;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class Interrogator {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f11105a;

    /* renamed from: b  reason: collision with root package name */
    public static final Field f11106b;

    /* renamed from: c  reason: collision with root package name */
    public static final Method f11107c;

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal<Boolean> f11108d = new ThreadLocal<Boolean>() {
        /* renamed from: a */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    public interface InterrogationHandler<R> extends QueueInterrogationHandler<R> {
        boolean b();

        void e();
    }

    public interface QueueInterrogationHandler<R> {
        boolean a();

        boolean c();

        boolean d();

        boolean f();

        R get();
    }

    static {
        try {
            Method declaredMethod = MessageQueue.class.getDeclaredMethod("next", new Class[0]);
            f11105a = declaredMethod;
            declaredMethod.setAccessible(true);
            Field declaredField = MessageQueue.class.getDeclaredField("mMessages");
            f11106b = declaredField;
            declaredField.setAccessible(true);
            Method method = null;
            try {
                method = Message.class.getDeclaredMethod("recycleUnchecked", new Class[0]);
                method.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f11107c = method;
        } catch (IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | SecurityException e11) {
            Log.e("Interrogator", "Could not initialize interrogator!", e11);
            throw new RuntimeException("Could not initialize interrogator!", e11);
        }
    }

    public static void a() {
        Preconditions.p(Looper.myLooper() != null, "Calling non-looper thread!");
        Preconditions.p(Boolean.FALSE.equals(f11108d.get()), "Already interrogating!");
    }

    public static Message b() {
        try {
            return (Message) f11105a.invoke(Looper.myQueue(), new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException | InvocationTargetException e11) {
            Throwables.e(e11);
            throw new RuntimeException(e11);
        }
    }

    public static boolean c(MessageQueue messageQueue, QueueInterrogationHandler<?> queueInterrogationHandler) {
        synchronized (messageQueue) {
            try {
                Message message = (Message) f11106b.get(messageQueue);
                if (message == null) {
                    boolean d11 = queueInterrogationHandler.d();
                    return d11;
                } else if (message.getTarget() == null) {
                    if (Log.isLoggable("Interrogator", 3)) {
                        Log.d("Interrogator", "barrier is up");
                    }
                    boolean a11 = queueInterrogationHandler.a();
                    return a11;
                } else {
                    long when = message.getWhen();
                    long uptimeMillis = SystemClock.uptimeMillis() + 15;
                    if (Log.isLoggable("Interrogator", 3)) {
                        boolean z11 = uptimeMillis < when;
                        StringBuilder sb2 = new StringBuilder(75);
                        sb2.append("headWhen: ");
                        sb2.append(when);
                        sb2.append(" nowFuz: ");
                        sb2.append(uptimeMillis);
                        sb2.append(" due long: ");
                        sb2.append(z11);
                        Log.d("Interrogator", sb2.toString());
                    }
                    if (uptimeMillis > when) {
                        boolean c11 = queueInterrogationHandler.c();
                        return c11;
                    }
                    boolean f11 = queueInterrogationHandler.f();
                    return f11;
                }
            } catch (IllegalAccessException e11) {
                throw new RuntimeException(e11);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static <R> R d(InterrogationHandler<R> interrogationHandler) {
        a();
        f11108d.set(Boolean.TRUE);
        Looper.myLooper();
        MessageQueue myQueue = Looper.myQueue();
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            long clearCallingIdentity2 = Binder.clearCallingIdentity();
            boolean z11 = true;
            while (z11) {
                z11 = c(myQueue, interrogationHandler);
                if (z11) {
                    Message b11 = b();
                    if (b11 == null) {
                        interrogationHandler.e();
                        return interrogationHandler.get();
                    }
                    boolean b12 = interrogationHandler.b();
                    b11.getTarget().dispatchMessage(b11);
                    long clearCallingIdentity3 = Binder.clearCallingIdentity();
                    if (clearCallingIdentity3 != clearCallingIdentity2) {
                        String hexString = Long.toHexString(clearCallingIdentity2);
                        String hexString2 = Long.toHexString(clearCallingIdentity3);
                        String name = b11.getTarget().getClass().getName();
                        String valueOf = String.valueOf(b11.getCallback());
                        int i11 = b11.what;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + 77 + String.valueOf(hexString2).length() + name.length() + valueOf.length());
                        sb2.append("Thread identity changed from 0x");
                        sb2.append(hexString);
                        sb2.append(" to 0x");
                        sb2.append(hexString2);
                        sb2.append(" while dispatching to ");
                        sb2.append(name);
                        sb2.append(" ");
                        sb2.append(valueOf);
                        sb2.append(" what=");
                        sb2.append(i11);
                        Log.wtf("Interrogator", sb2.toString());
                    }
                    e(b11);
                    z11 = b12;
                }
            }
            Binder.restoreCallingIdentity(clearCallingIdentity);
            f11108d.set(Boolean.FALSE);
            return interrogationHandler.get();
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            f11108d.set(Boolean.FALSE);
        }
    }

    public static void e(Message message) {
        Method method = f11107c;
        if (method != null) {
            try {
                method.invoke(message, new Object[0]);
            } catch (IllegalAccessException | IllegalArgumentException | SecurityException e11) {
                Throwables.e(e11);
                throw new RuntimeException(e11);
            } catch (InvocationTargetException e12) {
                if (e12.getCause() != null) {
                    Throwables.e(e12.getCause());
                    throw new RuntimeException(e12.getCause());
                }
                throw new RuntimeException(e12);
            }
        } else {
            message.recycle();
        }
    }
}
