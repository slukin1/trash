package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import java.util.Comparator;

public abstract class SortedList$Callback<T2> implements Comparator<T2>, p {
    public abstract void a(int i11, int i12);

    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i11, int i12, Object obj) {
        a(i11, i12);
    }
}
