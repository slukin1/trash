package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f10815a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f10816b;

    /* renamed from: c  reason: collision with root package name */
    public final DiffUtil.ItemCallback<T> f10817c;

    public static final class a<T> {

        /* renamed from: d  reason: collision with root package name */
        public static final Object f10818d = new Object();

        /* renamed from: e  reason: collision with root package name */
        public static Executor f10819e;

        /* renamed from: a  reason: collision with root package name */
        public Executor f10820a;

        /* renamed from: b  reason: collision with root package name */
        public Executor f10821b;

        /* renamed from: c  reason: collision with root package name */
        public final DiffUtil.ItemCallback<T> f10822c;

        public a(DiffUtil.ItemCallback<T> itemCallback) {
            this.f10822c = itemCallback;
        }

        public c<T> a() {
            if (this.f10821b == null) {
                synchronized (f10818d) {
                    if (f10819e == null) {
                        f10819e = Executors.newFixedThreadPool(2);
                    }
                }
                this.f10821b = f10819e;
            }
            return new c<>(this.f10820a, this.f10821b, this.f10822c);
        }
    }

    public c(Executor executor, Executor executor2, DiffUtil.ItemCallback<T> itemCallback) {
        this.f10815a = executor;
        this.f10816b = executor2;
        this.f10817c = itemCallback;
    }

    public Executor a() {
        return this.f10816b;
    }

    public DiffUtil.ItemCallback<T> b() {
        return this.f10817c;
    }

    public Executor c() {
        return this.f10815a;
    }
}
