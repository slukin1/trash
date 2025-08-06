package dw;

import android.view.View;
import rx.Observable;

public final class a {
    public static Observable<Void> a(View view) {
        cw.a.a(view, "view == null");
        return Observable.create(new b(view));
    }
}
