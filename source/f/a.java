package f;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public class a implements TransformationMethod {

    /* renamed from: b  reason: collision with root package name */
    public Locale f15679b;

    public a(Context context) {
        this.f15679b = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f15679b);
        }
        return null;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z11, int i11, Rect rect) {
    }
}
