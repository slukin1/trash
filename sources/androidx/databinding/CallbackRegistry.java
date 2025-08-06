package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

public class CallbackRegistry<C, T, A> implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public List<C> f8850b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public long f8851c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long[] f8852d;

    /* renamed from: e  reason: collision with root package name */
    public int f8853e;

    /* renamed from: f  reason: collision with root package name */
    public final NotifierCallback<C, T, A> f8854f;

    public static abstract class NotifierCallback<C, T, A> {
        public abstract void a(C c11, T t11, int i11, A a11);
    }

    public CallbackRegistry(NotifierCallback<C, T, A> notifierCallback) {
        this.f8854f = notifierCallback;
    }

    public synchronized void b(C c11) {
        if (c11 != null) {
            int lastIndexOf = this.f8850b.lastIndexOf(c11);
            if (lastIndexOf < 0 || d(lastIndexOf)) {
                this.f8850b.add(c11);
            }
        } else {
            throw new IllegalArgumentException("callback cannot be null");
        }
    }

    /* renamed from: c */
    public synchronized CallbackRegistry<C, T, A> clone() {
        CallbackRegistry<C, T, A> callbackRegistry;
        CloneNotSupportedException e11;
        try {
            callbackRegistry = (CallbackRegistry) super.clone();
            try {
                callbackRegistry.f8851c = 0;
                callbackRegistry.f8852d = null;
                callbackRegistry.f8853e = 0;
                callbackRegistry.f8850b = new ArrayList();
                int size = this.f8850b.size();
                for (int i11 = 0; i11 < size; i11++) {
                    if (!d(i11)) {
                        callbackRegistry.f8850b.add(this.f8850b.get(i11));
                    }
                }
            } catch (CloneNotSupportedException e12) {
                e11 = e12;
                e11.printStackTrace();
                return callbackRegistry;
            }
        } catch (CloneNotSupportedException e13) {
            CloneNotSupportedException cloneNotSupportedException = e13;
            callbackRegistry = null;
            e11 = cloneNotSupportedException;
            e11.printStackTrace();
            return callbackRegistry;
        }
        return callbackRegistry;
    }

    public final boolean d(int i11) {
        int i12;
        if (i11 < 64) {
            return ((1 << i11) & this.f8851c) != 0;
        }
        long[] jArr = this.f8852d;
        if (jArr == null || (i12 = (i11 / 64) - 1) >= jArr.length) {
            return false;
        }
        if (((1 << (i11 % 64)) & jArr[i12]) != 0) {
            return true;
        }
        return false;
    }

    public synchronized void e(T t11, int i11, A a11) {
        this.f8853e++;
        h(t11, i11, a11);
        int i12 = this.f8853e - 1;
        this.f8853e = i12;
        if (i12 == 0) {
            long[] jArr = this.f8852d;
            if (jArr != null) {
                for (int length = jArr.length - 1; length >= 0; length--) {
                    long j11 = this.f8852d[length];
                    if (j11 != 0) {
                        k((length + 1) * 64, j11);
                        this.f8852d[length] = 0;
                    }
                }
            }
            long j12 = this.f8851c;
            if (j12 != 0) {
                k(0, j12);
                this.f8851c = 0;
            }
        }
    }

    public final void f(T t11, int i11, A a11, int i12, int i13, long j11) {
        long j12 = 1;
        while (i12 < i13) {
            if ((j11 & j12) == 0) {
                this.f8854f.a(this.f8850b.get(i12), t11, i11, a11);
            }
            j12 <<= 1;
            i12++;
        }
    }

    public final void g(T t11, int i11, A a11) {
        f(t11, i11, a11, 0, Math.min(64, this.f8850b.size()), this.f8851c);
    }

    public final void h(T t11, int i11, A a11) {
        int size = this.f8850b.size();
        long[] jArr = this.f8852d;
        int length = jArr == null ? -1 : jArr.length - 1;
        i(t11, i11, a11, length);
        f(t11, i11, a11, (length + 2) * 64, size, 0);
    }

    public final void i(T t11, int i11, A a11, int i12) {
        if (i12 < 0) {
            g(t11, i11, a11);
            return;
        }
        long j11 = this.f8852d[i12];
        int i13 = (i12 + 1) * 64;
        int min = Math.min(this.f8850b.size(), i13 + 64);
        i(t11, i11, a11, i12 - 1);
        f(t11, i11, a11, i13, min, j11);
    }

    public synchronized void j(C c11) {
        if (this.f8853e == 0) {
            this.f8850b.remove(c11);
        } else {
            int lastIndexOf = this.f8850b.lastIndexOf(c11);
            if (lastIndexOf >= 0) {
                l(lastIndexOf);
            }
        }
    }

    public final void k(int i11, long j11) {
        long j12 = Long.MIN_VALUE;
        for (int i12 = (i11 + 64) - 1; i12 >= i11; i12--) {
            if ((j11 & j12) != 0) {
                this.f8850b.remove(i12);
            }
            j12 >>>= 1;
        }
    }

    public final void l(int i11) {
        if (i11 < 64) {
            this.f8851c = (1 << i11) | this.f8851c;
            return;
        }
        int i12 = (i11 / 64) - 1;
        long[] jArr = this.f8852d;
        if (jArr == null) {
            this.f8852d = new long[(this.f8850b.size() / 64)];
        } else if (jArr.length <= i12) {
            long[] jArr2 = new long[(this.f8850b.size() / 64)];
            long[] jArr3 = this.f8852d;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.f8852d = jArr2;
        }
        long j11 = 1 << (i11 % 64);
        long[] jArr4 = this.f8852d;
        jArr4[i12] = j11 | jArr4[i12];
    }
}
