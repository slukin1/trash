package com.huobi.utils;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import androidx.annotation.Keep;
import java.lang.ref.SoftReference;

public class BackdoorHelper {

    /* renamed from: a  reason: collision with root package name */
    public static SparseArray<SoftReference<Counter>> f83679a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public static a f83680b = new a(u.f83780a);

    @Keep
    public static class Counter {
        /* access modifiers changed from: private */
        public c6.a callback0;
        /* access modifiers changed from: private */
        public int curCount;
        /* access modifiers changed from: private */
        public long dur;
        /* access modifiers changed from: private */
        public int totalCount;

        public Counter(int i11, int i12, long j11, c6.a aVar) {
            this.totalCount = i11;
            this.curCount = i12;
            this.dur = j11;
            this.callback0 = aVar;
        }

        public static /* synthetic */ int access$004(Counter counter) {
            int i11 = counter.curCount + 1;
            counter.curCount = i11;
            return i11;
        }

        public boolean canEqual(Object obj) {
            return obj instanceof Counter;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Counter)) {
                return false;
            }
            Counter counter = (Counter) obj;
            if (!counter.canEqual(this) || getTotalCount() != counter.getTotalCount() || getCurCount() != counter.getCurCount() || getDur() != counter.getDur()) {
                return false;
            }
            c6.a callback02 = getCallback0();
            c6.a callback03 = counter.getCallback0();
            return callback02 != null ? callback02.equals(callback03) : callback03 == null;
        }

        public c6.a getCallback0() {
            return this.callback0;
        }

        public int getCurCount() {
            return this.curCount;
        }

        public long getDur() {
            return this.dur;
        }

        public int getTotalCount() {
            return this.totalCount;
        }

        public int hashCode() {
            int totalCount2 = ((getTotalCount() + 59) * 59) + getCurCount();
            long dur2 = getDur();
            int i11 = (totalCount2 * 59) + ((int) (dur2 ^ (dur2 >>> 32)));
            c6.a callback02 = getCallback0();
            return (i11 * 59) + (callback02 == null ? 43 : callback02.hashCode());
        }

        public void setCallback0(c6.a aVar) {
            this.callback0 = aVar;
        }

        public void setCurCount(int i11) {
            this.curCount = i11;
        }

        public void setDur(long j11) {
            this.dur = j11;
        }

        public void setTotalCount(int i11) {
            this.totalCount = i11;
        }

        public String toString() {
            return "BackdoorHelper.Counter(totalCount=" + getTotalCount() + ", curCount=" + getCurCount() + ", dur=" + getDur() + ", callback0=" + getCallback0() + ")";
        }
    }

    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public SoftReference<C0860a> f83681a;

        /* renamed from: com.huobi.utils.BackdoorHelper$a$a  reason: collision with other inner class name */
        public interface C0860a {
            void handleMessage(Message message);
        }

        public a(C0860a aVar) {
            this.f83681a = new SoftReference<>(aVar);
        }

        public void handleMessage(Message message) {
            C0860a aVar;
            SoftReference<C0860a> softReference = this.f83681a;
            if (softReference != null && (aVar = softReference.get()) != null) {
                aVar.handleMessage(message);
            }
        }
    }

    public static void b(int i11) {
        Counter counter;
        SoftReference softReference = f83679a.get(i11);
        if (softReference != null && (counter = (Counter) softReference.get()) != null) {
            int unused = counter.curCount = 0;
        }
    }

    public static /* synthetic */ void c(Message message) {
        if (message != null) {
            b(message.what);
        }
    }
}
