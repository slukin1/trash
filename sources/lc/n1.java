package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;
import com.hbg.module.content.ui.fragment.H5Fragment;
import mc.a;

public class n1 extends m1 implements a.C0130a {
    public static final f.i J = null;
    public static final SparseIntArray K;
    public final RelativeLayout F;
    public final ImageView G;
    public final View.OnClickListener H;
    public long I;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K = sparseIntArray;
        sparseIntArray.put(R$id.rlActionBar, 2);
        sparseIntArray.put(R$id.hbWebView, 3);
        sparseIntArray.put(R$id.loading_layout, 4);
    }

    public n1(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 5, J, K));
    }

    public void M(H5Fragment h5Fragment) {
        this.E = h5Fragment;
        synchronized (this) {
            this.I |= 1;
        }
        notifyPropertyChanged(BR.f17733j);
        super.B();
    }

    public final void a(int i11, View view) {
        H5Fragment h5Fragment = this.E;
        if (h5Fragment != null) {
            h5Fragment.hi();
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.I;
            this.I = 0;
        }
        if ((j11 & 2) != 0) {
            this.G.setOnClickListener(this.H);
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
            this.I = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public n1(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[3], objArr[4], objArr[2]);
        this.I = -1;
        RelativeLayout relativeLayout = objArr[0];
        this.F = relativeLayout;
        relativeLayout.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.G = imageView;
        imageView.setTag((Object) null);
        G(view);
        this.H = new a(this, 1);
        t();
    }
}
