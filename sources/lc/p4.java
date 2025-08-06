package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class p4 extends o4 {
    public static final f.i G = null;
    public static final SparseIntArray H;
    public final RelativeLayout E;
    public long F;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H = sparseIntArray;
        sparseIntArray.put(R$id.imgAward, 1);
        sparseIntArray.put(R$id.tvAwardContent, 2);
        sparseIntArray.put(R$id.tvAwardNum, 3);
    }

    public p4(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 4, G, H));
    }

    public void i() {
        synchronized (this) {
            this.F = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.F != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.F = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public p4(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[1], objArr[2], objArr[3]);
        this.F = -1;
        RelativeLayout relativeLayout = objArr[0];
        this.E = relativeLayout;
        relativeLayout.setTag((Object) null);
        G(view);
        t();
    }
}
