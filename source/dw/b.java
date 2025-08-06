package dw;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

public final class b implements Observable.OnSubscribe<Void> {

    /* renamed from: b  reason: collision with root package name */
    public final View f40475b;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Subscriber f40476b;

        public a(Subscriber subscriber) {
            this.f40476b = subscriber;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (!this.f40476b.isUnsubscribed()) {
                this.f40476b.onNext(null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: dw.b$b  reason: collision with other inner class name */
    public class C0545b extends MainThreadSubscription {
        public C0545b() {
        }

        public void onUnsubscribe() {
            b.this.f40475b.setOnClickListener((View.OnClickListener) null);
        }
    }

    public b(View view) {
        this.f40475b = view;
    }

    /* renamed from: a */
    public void call(Subscriber<? super Void> subscriber) {
        cw.a.b();
        this.f40475b.setOnClickListener(new a(subscriber));
        subscriber.add(new C0545b());
    }
}
