package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;
import com.hbg.module.content.ui.activity.NewContentActivity;
import mc.a;

public class p extends o implements a.C0130a {
    public static final f.i K = null;
    public static final SparseIntArray L;
    public final LinearLayout G;
    public final ImageView H;
    public final View.OnClickListener I;
    public long J;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L = sparseIntArray;
        sparseIntArray.put(R$id.vTopBar, 2);
        sparseIntArray.put(R$id.coIndicator, 3);
        sparseIntArray.put(R$id.ivSearch, 4);
        sparseIntArray.put(R$id.vpContent, 5);
    }

    public p(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 6, K, L));
    }

    public void M(NewContentActivity newContentActivity) {
        this.F = newContentActivity;
        synchronized (this) {
            this.J |= 1;
        }
        notifyPropertyChanged(BR.f17732i);
        super.B();
    }

    public final void a(int i11, View view) {
        NewContentActivity newContentActivity = this.F;
        if (newContentActivity != null) {
            newContentActivity.finish();
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.J;
            this.J = 0;
        }
        if ((j11 & 2) != 0) {
            this.H.setOnClickListener(this.I);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.J != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.J = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public p(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[3], objArr[4], objArr[2], objArr[5]);
        this.J = -1;
        LinearLayout linearLayout = objArr[0];
        this.G = linearLayout;
        linearLayout.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.H = imageView;
        imageView.setTag((Object) null);
        G(view);
        this.I = new a(this, 1);
        t();
    }
}
