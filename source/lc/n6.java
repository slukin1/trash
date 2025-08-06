package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class n6 extends m6 {
    public static final f.i I = null;
    public static final SparseIntArray J;
    public long H;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        J = sparseIntArray;
        sparseIntArray.put(R$id.rb480, 1);
        sparseIntArray.put(R$id.sOne, 2);
        sparseIntArray.put(R$id.rb720, 3);
        sparseIntArray.put(R$id.sTwo, 4);
        sparseIntArray.put(R$id.rb1080, 5);
    }

    public n6(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 6, I, J));
    }

    public void i() {
        synchronized (this) {
            this.H = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.H != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.H = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public n6(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[5], objArr[1], objArr[3], objArr[0], objArr[2], objArr[4]);
        this.H = -1;
        this.E.setTag((Object) null);
        G(view);
        t();
    }
}
