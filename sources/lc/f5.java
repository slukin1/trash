package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.LiveGroupUserListData;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;

public class f5 extends e5 {
    public static final f.i J = null;
    public static final SparseIntArray K;
    public long I;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K = sparseIntArray;
        sparseIntArray.put(R$id.iv_member_avater, 2);
        sparseIntArray.put(R$id.fl_member_more, 3);
        sparseIntArray.put(R$id.tv_manager, 4);
        sparseIntArray.put(R$id.iv_member_more, 5);
    }

    public f5(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 6, J, K));
    }

    public void M(LiveGroupUserListData.GroupUser groupUser) {
        this.H = groupUser;
        synchronized (this) {
            this.I |= 1;
        }
        notifyPropertyChanged(BR.f17743t);
        super.B();
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.I;
            this.I = 0;
        }
        LiveGroupUserListData.GroupUser groupUser = this.H;
        String str = null;
        int i11 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        if (!(i11 == 0 || groupUser == null)) {
            str = groupUser.getNickname();
        }
        if (i11 != 0) {
            TextViewBindingAdapter.c(this.G, str);
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

    public f5(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[3], objArr[2], objArr[5], objArr[0], objArr[4], objArr[1]);
        this.I = -1;
        this.E.setTag((Object) null);
        this.G.setTag((Object) null);
        G(view);
        t();
    }
}
