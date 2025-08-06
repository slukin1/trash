package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class j2 extends i2 {
    public static final f.i J = null;
    public static final SparseIntArray K;
    public final FrameLayout H;
    public long I;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K = sparseIntArray;
        sparseIntArray.put(R$id.loading_layout, 1);
        sparseIntArray.put(R$id.sflRefresh, 2);
        sparseIntArray.put(R$id.rvContent, 3);
        sparseIntArray.put(R$id.unread_tip, 4);
        sparseIntArray.put(R$id.ll_push_switch_tips, 5);
        sparseIntArray.put(R$id.tv_open_push, 6);
    }

    public j2(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 7, J, K));
    }

    public void i() {
        synchronized (this) {
            this.I = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.I != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.I = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public j2(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[5], objArr[1], objArr[3], objArr[2], objArr[6], objArr[4]);
        this.I = -1;
        FrameLayout frameLayout = objArr[0];
        this.H = frameLayout;
        frameLayout.setTag((Object) null);
        G(view);
        t();
    }
}
