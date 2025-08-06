package io.flutter.embedding.android;

import android.view.textservice.SpellCheckerInfo;
import java.util.function.Predicate;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ a f55117a = new a();

    public final boolean test(Object obj) {
        return ((SpellCheckerInfo) obj).getPackageName().equals("com.google.android.inputmethod.latin");
    }
}
