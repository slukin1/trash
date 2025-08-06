package yf;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.share.BR;
import com.hbg.module.share.R$id;
import com.hbg.module.share.ui.GroupShareActivity;
import zf.a;

public class d extends c implements a.C0554a {
    public static final f.i M = null;
    public static final SparseIntArray N;
    public final ImageView H;
    public final ImageView I;
    public final View.OnClickListener J;
    public final View.OnClickListener K;
    public long L;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        N = sparseIntArray;
        sparseIntArray.put(R$id.rvContent, 3);
        sparseIntArray.put(R$id.clShareText, 4);
        sparseIntArray.put(R$id.etShareText, 5);
        sparseIntArray.put(R$id.tvSend, 6);
    }

    public d(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 7, M, N));
    }

    public void M(GroupShareActivity groupShareActivity) {
        this.G = groupShareActivity;
        synchronized (this) {
            this.L |= 1;
        }
        notifyPropertyChanged(BR.f37424b);
        super.B();
    }

    public final void a(int i11, View view) {
        boolean z11 = false;
        if (i11 == 1) {
            GroupShareActivity groupShareActivity = this.G;
            if (groupShareActivity != null) {
                z11 = true;
            }
            if (z11) {
                groupShareActivity.Bh();
            }
        } else if (i11 == 2) {
            GroupShareActivity groupShareActivity2 = this.G;
            if (groupShareActivity2 != null) {
                z11 = true;
            }
            if (z11) {
                groupShareActivity2.Bh();
            }
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.L;
            this.L = 0;
        }
        if ((j11 & 2) != 0) {
            this.H.setOnClickListener(this.J);
            this.I.setOnClickListener(this.K);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.L != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.L = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public d(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[4], objArr[5], objArr[0], objArr[3], objArr[6]);
        this.L = -1;
        this.D.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.H = imageView;
        imageView.setTag((Object) null);
        ImageView imageView2 = objArr[2];
        this.I = imageView2;
        imageView2.setTag((Object) null);
        G(view);
        this.J = new a(this, 1);
        this.K = new a(this, 2);
        t();
    }
}
