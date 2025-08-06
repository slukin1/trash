package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class x6 extends w6 {
    public static final f.i L = null;
    public static final SparseIntArray M;
    public final LinearLayout J;
    public long K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M = sparseIntArray;
        sparseIntArray.put(R$id.ivPopTopArrow, 1);
        sparseIntArray.put(R$id.llShare, 2);
        sparseIntArray.put(R$id.llDel, 3);
        sparseIntArray.put(R$id.llReport, 4);
        sparseIntArray.put(R$id.llMute3Day, 5);
        sparseIntArray.put(R$id.llMuteForever, 6);
        sparseIntArray.put(R$id.llUnMute, 7);
        sparseIntArray.put(R$id.ivPopBottomArrow, 8);
    }

    public x6(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 9, L, M));
    }

    public void i() {
        synchronized (this) {
            this.K = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.K != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.K = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x6(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[8], objArr[1], objArr[3], objArr[5], objArr[6], objArr[4], objArr[2], objArr[7]);
        this.K = -1;
        LinearLayout linearLayout = objArr[0];
        this.J = linearLayout;
        linearLayout.setTag((Object) null);
        View view2 = view;
        G(view);
        t();
    }
}
