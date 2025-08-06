package ew;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

public final class b implements Observable.OnSubscribe<CharSequence> {

    /* renamed from: b  reason: collision with root package name */
    public final TextView f40483b;

    public class a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Subscriber f40484b;

        public a(Subscriber subscriber) {
            this.f40484b = subscriber;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (!this.f40484b.isUnsubscribed()) {
                this.f40484b.onNext(charSequence);
            }
        }
    }

    /* renamed from: ew.b$b  reason: collision with other inner class name */
    public class C0546b extends MainThreadSubscription {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextWatcher f40486b;

        public C0546b(TextWatcher textWatcher) {
            this.f40486b = textWatcher;
        }

        public void onUnsubscribe() {
            b.this.f40483b.removeTextChangedListener(this.f40486b);
        }
    }

    public b(TextView textView) {
        this.f40483b = textView;
    }

    /* renamed from: a */
    public void call(Subscriber<? super CharSequence> subscriber) {
        cw.a.b();
        a aVar = new a(subscriber);
        this.f40483b.addTextChangedListener(aVar);
        subscriber.add(new C0546b(aVar));
        subscriber.onNext(this.f40483b.getText());
    }
}
