package fd;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.huobi.im.BR;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.group.ui.JoinGroupAdminActivity;
import gd.a;

public class d extends c implements a.C0187a {
    public static final f.i N = null;
    public static final SparseIntArray O;
    public final LinearLayout J;
    public final ImageView K;
    public final View.OnClickListener L;
    public long M;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        O = sparseIntArray;
        sparseIntArray.put(R$id.vTopBar, 2);
        sparseIntArray.put(R$id.tv_title, 3);
        sparseIntArray.put(R$id.rlRefresh, 4);
        sparseIntArray.put(R$id.rvUserList, 5);
        sparseIntArray.put(R$id.llNoData, 6);
        sparseIntArray.put(R$id.id_common_empty_item_iv, 7);
        sparseIntArray.put(R$id.id_common_empty_item_tv, 8);
    }

    public d(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 9, N, O));
    }

    public void M(JoinGroupAdminActivity joinGroupAdminActivity) {
        this.I = joinGroupAdminActivity;
        synchronized (this) {
            this.M |= 1;
        }
        notifyPropertyChanged(BR.f19600b);
        super.B();
    }

    public final void a(int i11, View view) {
        JoinGroupAdminActivity joinGroupAdminActivity = this.I;
        if (joinGroupAdminActivity != null) {
            joinGroupAdminActivity.finish();
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.M;
            this.M = 0;
        }
        if ((j11 & 2) != 0) {
            this.K.setOnClickListener(this.L);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.M != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.M = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public d(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[7], objArr[8], objArr[6], objArr[4], objArr[5], objArr[3], objArr[2]);
        this.M = -1;
        LinearLayout linearLayout = objArr[0];
        this.J = linearLayout;
        linearLayout.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.K = imageView;
        imageView.setTag((Object) null);
        G(view);
        this.L = new a(this, 1);
        t();
    }
}
