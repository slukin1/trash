package lj;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.b;
import androidx.databinding.f;

public class r0 extends q0 {
    public static final f.i D = null;
    public static final SparseIntArray E = null;
    public final FrameLayout B;
    public long C;

    public r0(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 1, D, E));
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

    public r0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0);
        this.C = -1;
        FrameLayout frameLayout = objArr[0];
        this.B = frameLayout;
        frameLayout.setTag((Object) null);
        G(view);
        t();
    }
}
