package rx.observers;

import com.iproov.sdk.bridge.OptionsBridge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.CompositeException;

public class TestSubscriber<T> extends Subscriber<T> {
    private static final Observer<Object> INERT = new Observer<Object>() {
        public void onCompleted() {
        }

        public void onError(Throwable th2) {
        }

        public void onNext(Object obj) {
        }
    };
    private int completions;
    private final Observer<T> delegate;
    private final List<Throwable> errors;
    private volatile Thread lastSeenThread;
    private final CountDownLatch latch;
    private volatile int valueCount;
    private final List<T> values;

    public TestSubscriber(long j11) {
        this(INERT, j11);
    }

    private void assertItem(T t11, int i11) {
        T t12 = this.values.get(i11);
        if (t11 == null) {
            if (t12 != null) {
                assertionError("Value at index: " + i11 + " expected: [null] but was: [" + t12 + "]\n");
            }
        } else if (!t11.equals(t12)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Value at index: ");
            sb2.append(i11);
            sb2.append(" expected: [");
            sb2.append(t11);
            sb2.append("] (");
            sb2.append(t11.getClass().getSimpleName());
            sb2.append(") but was: [");
            sb2.append(t12);
            sb2.append("] (");
            sb2.append(t12 != null ? t12.getClass().getSimpleName() : OptionsBridge.NULL_VALUE);
            sb2.append(")\n");
            assertionError(sb2.toString());
        }
    }

    public static <T> TestSubscriber<T> create() {
        return new TestSubscriber<>();
    }

    public void assertCompleted() {
        int i11 = this.completions;
        if (i11 == 0) {
            assertionError("Not completed!");
        } else if (i11 > 1) {
            assertionError("Completed multiple times: " + i11);
        }
    }

    public void assertError(Class<? extends Throwable> cls) {
        List<Throwable> list = this.errors;
        if (list.isEmpty()) {
            assertionError("No errors");
        } else if (list.size() > 1) {
            AssertionError assertionError = new AssertionError("Multiple errors: " + list.size());
            assertionError.initCause(new CompositeException((Collection<? extends Throwable>) list));
            throw assertionError;
        } else if (!cls.isInstance(list.get(0))) {
            AssertionError assertionError2 = new AssertionError("Exceptions differ; expected: " + cls + ", actual: " + list.get(0));
            assertionError2.initCause(list.get(0));
            throw assertionError2;
        }
    }

    public void assertNoErrors() {
        if (!getOnErrorEvents().isEmpty()) {
            assertionError("Unexpected onError events");
        }
    }

    public void assertNoTerminalEvent() {
        List<Throwable> list = this.errors;
        int i11 = this.completions;
        if (list.isEmpty() && i11 <= 0) {
            return;
        }
        if (list.isEmpty()) {
            assertionError("Found " + list.size() + " errors and " + i11 + " completion events instead of none");
        } else if (list.size() == 1) {
            assertionError("Found " + list.size() + " errors and " + i11 + " completion events instead of none");
        } else {
            assertionError("Found " + list.size() + " errors and " + i11 + " completion events instead of none");
        }
    }

    public void assertNoValues() {
        int size = this.values.size();
        if (size != 0) {
            assertionError("No onNext events expected yet some received: " + size);
        }
    }

    public void assertNotCompleted() {
        int i11 = this.completions;
        if (i11 == 1) {
            assertionError("Completed!");
        } else if (i11 > 1) {
            assertionError("Completed multiple times: " + i11);
        }
    }

    public void assertReceivedOnNext(List<T> list) {
        if (this.values.size() != list.size()) {
            assertionError("Number of items does not match. Provided: " + list.size() + "  Actual: " + this.values.size() + ".\n" + "Provided values: " + list + "\n" + "Actual values: " + this.values + "\n");
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            assertItem(list.get(i11), i11);
        }
    }

    public void assertTerminalEvent() {
        if (this.errors.size() > 1) {
            assertionError("Too many onError events: " + this.errors.size());
        }
        if (this.completions > 1) {
            assertionError("Too many onCompleted events: " + this.completions);
        }
        if (this.completions == 1 && this.errors.size() == 1) {
            assertionError("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.completions == 0 && this.errors.isEmpty()) {
            assertionError("No terminal events received.");
        }
    }

    public void assertUnsubscribed() {
        if (!isUnsubscribed()) {
            assertionError("Not unsubscribed.");
        }
    }

    public void assertValue(T t11) {
        assertReceivedOnNext(Collections.singletonList(t11));
    }

    public void assertValueCount(int i11) {
        int size = this.values.size();
        if (size != i11) {
            assertionError("Number of onNext events differ; expected: " + i11 + ", actual: " + size);
        }
    }

    public void assertValues(T... tArr) {
        assertReceivedOnNext(Arrays.asList(tArr));
    }

    public final void assertValuesAndClear(T t11, T... tArr) {
        assertValueCount(tArr.length + 1);
        int i11 = 0;
        assertItem(t11, 0);
        while (i11 < tArr.length) {
            T t12 = tArr[i11];
            i11++;
            assertItem(t12, i11);
        }
        this.values.clear();
    }

    public final void assertionError(String str) {
        StringBuilder sb2 = new StringBuilder(str.length() + 32);
        sb2.append(str);
        sb2.append(" (");
        int i11 = this.completions;
        sb2.append(i11);
        sb2.append(" completion");
        if (i11 != 1) {
            sb2.append('s');
        }
        sb2.append(')');
        if (!this.errors.isEmpty()) {
            int size = this.errors.size();
            sb2.append(" (+");
            sb2.append(size);
            sb2.append(" error");
            if (size != 1) {
                sb2.append('s');
            }
            sb2.append(')');
        }
        AssertionError assertionError = new AssertionError(sb2.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                assertionError.initCause(this.errors.get(0));
            } else {
                assertionError.initCause(new CompositeException((Collection<? extends Throwable>) this.errors));
            }
        }
        throw assertionError;
    }

    public void awaitTerminalEvent() {
        try {
            this.latch.await();
        } catch (InterruptedException e11) {
            throw new IllegalStateException("Interrupted", e11);
        }
    }

    public void awaitTerminalEventAndUnsubscribeOnTimeout(long j11, TimeUnit timeUnit) {
        try {
            if (!this.latch.await(j11, timeUnit)) {
                unsubscribe();
            }
        } catch (InterruptedException unused) {
            unsubscribe();
        }
    }

    public final boolean awaitValueCount(int i11, long j11, TimeUnit timeUnit) {
        while (j11 != 0 && this.valueCount < i11) {
            try {
                timeUnit.sleep(1);
                j11--;
            } catch (InterruptedException e11) {
                throw new IllegalStateException("Interrupted", e11);
            }
        }
        return this.valueCount >= i11;
    }

    public final int getCompletions() {
        return this.completions;
    }

    public Thread getLastSeenThread() {
        return this.lastSeenThread;
    }

    @Deprecated
    public List<Notification<T>> getOnCompletedEvents() {
        int i11 = this.completions;
        ArrayList arrayList = new ArrayList(i11 != 0 ? i11 : 1);
        for (int i12 = 0; i12 < i11; i12++) {
            arrayList.add(Notification.createOnCompleted());
        }
        return arrayList;
    }

    public List<Throwable> getOnErrorEvents() {
        return this.errors;
    }

    public List<T> getOnNextEvents() {
        return this.values;
    }

    public final int getValueCount() {
        return this.valueCount;
    }

    public void onCompleted() {
        try {
            this.completions++;
            this.lastSeenThread = Thread.currentThread();
            this.delegate.onCompleted();
        } finally {
            this.latch.countDown();
        }
    }

    public void onError(Throwable th2) {
        try {
            this.lastSeenThread = Thread.currentThread();
            this.errors.add(th2);
            this.delegate.onError(th2);
        } finally {
            this.latch.countDown();
        }
    }

    public void onNext(T t11) {
        this.lastSeenThread = Thread.currentThread();
        this.values.add(t11);
        this.valueCount = this.values.size();
        this.delegate.onNext(t11);
    }

    public void requestMore(long j11) {
        request(j11);
    }

    public TestSubscriber(Observer<T> observer, long j11) {
        this.latch = new CountDownLatch(1);
        Objects.requireNonNull(observer);
        this.delegate = observer;
        if (j11 >= 0) {
            request(j11);
        }
        this.values = new ArrayList();
        this.errors = new ArrayList();
    }

    public static <T> TestSubscriber<T> create(long j11) {
        return new TestSubscriber<>(j11);
    }

    public static <T> TestSubscriber<T> create(Observer<T> observer, long j11) {
        return new TestSubscriber<>(observer, j11);
    }

    public void awaitTerminalEvent(long j11, TimeUnit timeUnit) {
        try {
            this.latch.await(j11, timeUnit);
        } catch (InterruptedException e11) {
            throw new IllegalStateException("Interrupted", e11);
        }
    }

    public static <T> TestSubscriber<T> create(Subscriber<T> subscriber) {
        return new TestSubscriber<>(subscriber);
    }

    public static <T> TestSubscriber<T> create(Observer<T> observer) {
        return new TestSubscriber<>(observer);
    }

    public TestSubscriber(Subscriber<T> subscriber) {
        this(subscriber, -1);
    }

    public TestSubscriber(Observer<T> observer) {
        this(observer, -1);
    }

    public TestSubscriber() {
        this(-1);
    }

    public void assertError(Throwable th2) {
        List<Throwable> list = this.errors;
        if (list.isEmpty()) {
            assertionError("No errors");
        } else if (list.size() > 1) {
            assertionError("Multiple errors");
        } else if (!th2.equals(list.get(0))) {
            assertionError("Exceptions differ; expected: " + th2 + ", actual: " + list.get(0));
        }
    }
}
