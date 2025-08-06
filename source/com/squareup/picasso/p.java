package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.y;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class p extends ThreadPoolExecutor {

    public static final class a extends FutureTask<c> implements Comparable<a> {

        /* renamed from: b  reason: collision with root package name */
        public final c f30080b;

        public a(c cVar) {
            super(cVar, (Object) null);
            this.f30080b = cVar;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            Picasso.Priority r11 = this.f30080b.r();
            Picasso.Priority r12 = aVar.f30080b.r();
            return r11 == r12 ? this.f30080b.f30007b - aVar.f30080b.f30007b : r12.ordinal() - r11.ordinal();
        }
    }

    public p() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new y.c());
    }

    public void a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            b(3);
            return;
        }
        int type = networkInfo.getType();
        if (type == 0) {
            int subtype = networkInfo.getSubtype();
            switch (subtype) {
                case 1:
                case 2:
                    b(1);
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
                    switch (subtype) {
                        case 12:
                            break;
                        case 13:
                        case 14:
                        case 15:
                            b(3);
                            return;
                        default:
                            b(3);
                            return;
                    }
            }
            b(2);
        } else if (type == 1 || type == 6 || type == 9) {
            b(4);
        } else {
            b(3);
        }
    }

    public final void b(int i11) {
        setCorePoolSize(i11);
        setMaximumPoolSize(i11);
    }

    public Future<?> submit(Runnable runnable) {
        a aVar = new a((c) runnable);
        execute(aVar);
        return aVar;
    }
}
