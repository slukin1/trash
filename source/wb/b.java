package wb;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.f;
import com.hbg.module.account.BR;
import com.hbg.module.account.R$id;
import com.hbg.module.account.index.ui.AccountActivity;
import yb.a;

public class b extends a implements a.C0889a {
    public static final f.i L = null;
    public static final SparseIntArray M;
    public final View.OnClickListener J;
    public long K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M = sparseIntArray;
        sparseIntArray.put(R$id.vTopBar, 2);
        sparseIntArray.put(R$id.tvAccountActionBar, 3);
        sparseIntArray.put(R$id.tvCustomBtn, 4);
        sparseIntArray.put(R$id.tvSettingBtn, 5);
        sparseIntArray.put(R$id.tvAccountContent, 6);
    }

    public b(androidx.databinding.b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 7, L, M));
    }

    public void M(AccountActivity accountActivity) {
        this.I = accountActivity;
        synchronized (this) {
            this.K |= 1;
        }
        notifyPropertyChanged(BR.f77644a);
        super.B();
    }

    public final void a(int i11, View view) {
        AccountActivity accountActivity = this.I;
        if (accountActivity != null) {
            accountActivity.finish();
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.K;
            this.K = 0;
        }
        if ((j11 & 2) != 0) {
            this.B.setOnClickListener(this.J);
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(androidx.databinding.b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[1], objArr[3], objArr[0], objArr[6], objArr[4], objArr[5], objArr[2]);
        this.K = -1;
        this.B.setTag((Object) null);
        this.D.setTag((Object) null);
        View view2 = view;
        G(view);
        this.J = new a(this, 1);
        t();
    }
}
