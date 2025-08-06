package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;

public class j1 extends i1 {
    public static final f.i D = null;
    public static final SparseIntArray E = null;
    public long C;

    public j1(b bVar, View view) {
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

    public j1(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[0]);
        this.C = -1;
        this.B.setTag((Object) null);
        G(view);
        t();
    }
}
