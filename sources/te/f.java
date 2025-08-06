package te;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;

public class f extends e {
    public static final f.i D = null;
    public static final SparseIntArray E = null;
    public final LinearLayout B;
    public long C;

    public f(b bVar, View view) {
        this(bVar, view, androidx.databinding.f.w(bVar, view, 1, D, E));
    }

    public void i() {
        synchronized (this) {
            this.C = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.C != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.C = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public f(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0);
        this.C = -1;
        LinearLayout linearLayout = objArr[0];
        this.B = linearLayout;
        linearLayout.setTag((Object) null);
        G(view);
        t();
    }
}
