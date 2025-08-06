package fd;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.ApplyListBean;
import com.hbg.module.huobi.im.BR;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$string;

public class f extends e {
    public static final f.i L = null;
    public static final SparseIntArray M;
    public final ConstraintLayout J;
    public long K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M = sparseIntArray;
        sparseIntArray.put(R$id.tvTime, 7);
    }

    public f(b bVar, View view) {
        this(bVar, view, androidx.databinding.f.w(bVar, view, 8, L, M));
    }

    public void M(ApplyListBean.ApplyUser applyUser) {
        this.I = applyUser;
        synchronized (this) {
            this.K |= 1;
        }
        notifyPropertyChanged(BR.f19599a);
        super.B();
    }

    public void i() {
        long j11;
        int i11;
        int i12;
        int i13;
        int i14;
        String str;
        String str2;
        String str3;
        int i15;
        String str4;
        String str5;
        synchronized (this) {
            j11 = this.K;
            this.K = 0;
        }
        ApplyListBean.ApplyUser applyUser = this.I;
        int i16 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        String str6 = null;
        if (i16 != 0) {
            i14 = R$drawable.icon_community_user_header;
            if (applyUser != null) {
                String str7 = applyUser.avatar;
                String str8 = applyUser.reason;
                i15 = applyUser.status;
                str5 = applyUser.nickname;
                String str9 = str8;
                str4 = str7;
                str6 = str9;
            } else {
                str5 = null;
                str4 = null;
                i15 = 0;
            }
            boolean x11 = com.hbg.module.libkt.base.ext.b.x(str6);
            boolean z11 = true;
            boolean z12 = i15 == 1;
            boolean z13 = i15 != 1;
            if (i15 != 2) {
                z11 = false;
            }
            if (i16 != 0) {
                j11 |= x11 ? 32 : 16;
            }
            if ((j11 & 3) != 0) {
                j11 |= z12 ? 128 : 64;
            }
            if ((j11 & 3) != 0) {
                j11 |= z13 ? 512 : 256;
            }
            if ((j11 & 3) != 0) {
                j11 |= z11 ? 8 : 4;
            }
            int i17 = x11 ? 8 : 0;
            i12 = z12 ? 0 : 8;
            int i18 = z13 ? 0 : 8;
            str2 = this.D.getResources().getString(z11 ? R$string.n_live_group_already_agree : R$string.n_live_group_already_reject);
            i11 = i17;
            str = str5;
            str3 = str6;
            str6 = str4;
            i13 = i18;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i14 = 0;
            i13 = 0;
            i12 = 0;
            i11 = 0;
        }
        if ((j11 & 3) != 0) {
            he.b.p(this.B, str6, i14);
            this.C.setVisibility(i12);
            TextViewBindingAdapter.c(this.D, str2);
            this.D.setVisibility(i13);
            TextViewBindingAdapter.c(this.E, str3);
            this.E.setVisibility(i11);
            TextViewBindingAdapter.c(this.F, str);
            this.G.setVisibility(i12);
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
        super(bVar, view, 0, objArr[1], objArr[4], objArr[5], objArr[6], objArr[2], objArr[3], objArr[7]);
        this.K = -1;
        this.B.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.J = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.C.setTag((Object) null);
        this.D.setTag((Object) null);
        this.E.setTag((Object) null);
        this.F.setTag((Object) null);
        this.G.setTag((Object) null);
        G(view);
        t();
    }
}
