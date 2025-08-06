package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.community.ui.FansListActivity;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;
import mc.a;

public class f extends e implements a.C0130a {
    public static final f.i L = null;
    public static final SparseIntArray M;
    public final LinearLayout H;
    public final ImageView I;
    public final View.OnClickListener J;
    public long K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M = sparseIntArray;
        sparseIntArray.put(R$id.vTopBar, 2);
        sparseIntArray.put(R$id.tvTitle, 3);
        sparseIntArray.put(R$id.loading_layout, 4);
        sparseIntArray.put(R$id.rlRefresh, 5);
        sparseIntArray.put(R$id.rvWatch, 6);
    }

    public f(b bVar, View view) {
        this(bVar, view, androidx.databinding.f.w(bVar, view, 7, L, M));
    }

    public void M(FansListActivity fansListActivity) {
        this.G = fansListActivity;
        synchronized (this) {
            this.K |= 1;
        }
        notifyPropertyChanged(BR.f17732i);
        super.B();
    }

    public final void a(int i11, View view) {
        FansListActivity fansListActivity = this.G;
        if (fansListActivity != null) {
            fansListActivity.finish();
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.K;
            this.K = 0;
        }
        if ((j11 & 2) != 0) {
            this.I.setOnClickListener(this.J);
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
            this.K = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public f(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[4], objArr[5], objArr[6], objArr[3], objArr[2]);
        this.K = -1;
        LinearLayout linearLayout = objArr[0];
        this.H = linearLayout;
        linearLayout.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.I = imageView;
        imageView.setTag((Object) null);
        G(view);
        this.J = new a(this, 1);
        t();
    }
}
