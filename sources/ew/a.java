package ew;

import android.widget.TextView;
import rx.Observable;

public final class a {
    public static Observable<CharSequence> a(TextView textView) {
        cw.a.a(textView, "view == null");
        return Observable.create(new b(textView));
    }
}
