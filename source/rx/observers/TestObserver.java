package rx.observers;

import com.iproov.sdk.bridge.OptionsBridge;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import rx.Notification;
import rx.Observer;
import rx.exceptions.CompositeException;

@Deprecated
public class TestObserver<T> implements Observer<T> {
    private static final Observer<Object> INERT = new Observer<Object>() {
        public void onCompleted() {
        }

        public void onError(Throwable th2) {
        }

        public void onNext(Object obj) {
        }
    };
    private final Observer<T> delegate;
    private final List<Notification<T>> onCompletedEvents;
    private final List<Throwable> onErrorEvents;
    private final List<T> onNextEvents;

    public TestObserver(Observer<T> observer) {
        this.onNextEvents = new ArrayList();
        this.onErrorEvents = new ArrayList();
        this.onCompletedEvents = new ArrayList();
        this.delegate = observer;
    }

    public void assertReceivedOnNext(List<T> list) {
        if (this.onNextEvents.size() != list.size()) {
            assertionError("Number of items does not match. Provided: " + list.size() + "  Actual: " + this.onNextEvents.size() + ".\n" + "Provided values: " + list + "\n" + "Actual values: " + this.onNextEvents + "\n");
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            T t11 = list.get(i11);
            T t12 = this.onNextEvents.get(i11);
            if (t11 == null) {
                if (t12 != null) {
                    assertionError("Value at index: " + i11 + " expected to be [null] but was: [" + t12 + "]\n");
                }
            } else if (!t11.equals(t12)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Value at index: ");
                sb2.append(i11);
                sb2.append(" expected to be [");
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
    }

    public void assertTerminalEvent() {
        if (this.onErrorEvents.size() > 1) {
            assertionError("Too many onError events: " + this.onErrorEvents.size());
        }
        if (this.onCompletedEvents.size() > 1) {
            assertionError("Too many onCompleted events: " + this.onCompletedEvents.size());
        }
        if (this.onCompletedEvents.size() == 1 && this.onErrorEvents.size() == 1) {
            assertionError("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.onCompletedEvents.isEmpty() && this.onErrorEvents.isEmpty()) {
            assertionError("No terminal events received.");
        }
    }

    public final void assertionError(String str) {
        StringBuilder sb2 = new StringBuilder(str.length() + 32);
        sb2.append(str);
        sb2.append(" (");
        int size = this.onCompletedEvents.size();
        sb2.append(size);
        sb2.append(" completion");
        if (size != 1) {
            sb2.append('s');
        }
        sb2.append(')');
        if (!this.onErrorEvents.isEmpty()) {
            int size2 = this.onErrorEvents.size();
            sb2.append(" (+");
            sb2.append(size2);
            sb2.append(" error");
            if (size2 != 1) {
                sb2.append('s');
            }
            sb2.append(')');
        }
        AssertionError assertionError = new AssertionError(sb2.toString());
        if (!this.onErrorEvents.isEmpty()) {
            if (this.onErrorEvents.size() == 1) {
                assertionError.initCause(this.onErrorEvents.get(0));
            } else {
                assertionError.initCause(new CompositeException((Collection<? extends Throwable>) this.onErrorEvents));
            }
        }
        throw assertionError;
    }

    public List<Object> getEvents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.onNextEvents);
        arrayList.add(this.onErrorEvents);
        arrayList.add(this.onCompletedEvents);
        return Collections.unmodifiableList(arrayList);
    }

    public List<Notification<T>> getOnCompletedEvents() {
        return Collections.unmodifiableList(this.onCompletedEvents);
    }

    public List<Throwable> getOnErrorEvents() {
        return Collections.unmodifiableList(this.onErrorEvents);
    }

    public List<T> getOnNextEvents() {
        return Collections.unmodifiableList(this.onNextEvents);
    }

    public void onCompleted() {
        this.onCompletedEvents.add(Notification.createOnCompleted());
        this.delegate.onCompleted();
    }

    public void onError(Throwable th2) {
        this.onErrorEvents.add(th2);
        this.delegate.onError(th2);
    }

    public void onNext(T t11) {
        this.onNextEvents.add(t11);
        this.delegate.onNext(t11);
    }

    public TestObserver() {
        this.onNextEvents = new ArrayList();
        this.onErrorEvents = new ArrayList();
        this.onCompletedEvents = new ArrayList();
        this.delegate = INERT;
    }
}
