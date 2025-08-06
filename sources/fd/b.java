package fd;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.CustomerInfo;
import com.hbg.module.huobi.im.BR;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.c2c.ui.CustomerInfoActivity;
import gd.a;

public class b extends a implements a.C0187a {
    public static final f.i V = null;
    public static final SparseIntArray W;
    public final ConstraintLayout L;
    public final ImageView M;
    public final TextView N;
    public final TextView O;
    public final ImageView P;
    public final TextView Q;
    public final View.OnClickListener R;
    public final View.OnClickListener S;
    public final View.OnClickListener T;
    public long U;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        W = sparseIntArray;
        sparseIntArray.put(R$id.vTopBar, 10);
        sparseIntArray.put(R$id.rlActionBar, 11);
        sparseIntArray.put(R$id.tvToolbarTitle, 12);
        sparseIntArray.put(R$id.llMail, 13);
    }

    public b(androidx.databinding.b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 14, V, W));
    }

    public void M(CustomerInfo customerInfo) {
        this.K = customerInfo;
        synchronized (this) {
            this.U |= 2;
        }
        notifyPropertyChanged(BR.f19599a);
        super.B();
    }

    public void N(CustomerInfoActivity customerInfoActivity) {
        this.J = customerInfoActivity;
        synchronized (this) {
            this.U |= 1;
        }
        notifyPropertyChanged(BR.f19600b);
        super.B();
    }

    public final void a(int i11, View view) {
        boolean z11 = false;
        if (i11 == 1) {
            CustomerInfoActivity customerInfoActivity = this.J;
            if (customerInfoActivity != null) {
                z11 = true;
            }
            if (z11) {
                customerInfoActivity.finish();
            }
        } else if (i11 == 2) {
            CustomerInfoActivity customerInfoActivity2 = this.J;
            if (customerInfoActivity2 != null) {
                z11 = true;
            }
            if (z11) {
                customerInfoActivity2.zh();
            }
        } else if (i11 == 3) {
            CustomerInfoActivity customerInfoActivity3 = this.J;
            if (customerInfoActivity3 != null) {
                z11 = true;
            }
            if (z11) {
                customerInfoActivity3.Bh();
            }
        }
    }

    public void i() {
        long j11;
        String str;
        String str2;
        String str3;
        String str4;
        int i11;
        String str5;
        String str6;
        synchronized (this) {
            j11 = this.U;
            this.U = 0;
        }
        CustomerInfo customerInfo = this.K;
        int i12 = ((j11 & 6) > 0 ? 1 : ((j11 & 6) == 0 ? 0 : -1));
        int i13 = 0;
        String str7 = null;
        if (i12 != 0) {
            int i14 = R$drawable.icon_default_avatar;
            if (customerInfo != null) {
                String email = customerInfo.getEmail();
                str2 = customerInfo.getIntroduction();
                str5 = customerInfo.getAvatar();
                String jobNo = customerInfo.getJobNo();
                str = customerInfo.getNickname();
                str6 = email;
                str7 = jobNo;
            } else {
                str6 = null;
                str2 = null;
                str5 = null;
                str = null;
            }
            boolean x11 = com.hbg.module.libkt.base.ext.b.x(str7);
            if (i12 != 0) {
                j11 |= x11 ? 16 : 8;
            }
            if (x11) {
                i13 = 8;
            }
            str4 = str7;
            str7 = str5;
            int i15 = i14;
            str3 = str6;
            i11 = i13;
            i13 = i15;
        } else {
            i11 = 0;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((6 & j11) != 0) {
            he.b.p(this.B, str7, i13);
            this.D.setVisibility(i11);
            TextViewBindingAdapter.c(this.N, str4);
            TextViewBindingAdapter.c(this.O, str3);
            TextViewBindingAdapter.c(this.F, str2);
            TextViewBindingAdapter.c(this.G, str);
        }
        if ((j11 & 4) != 0) {
            this.M.setOnClickListener(this.T);
            this.P.setOnClickListener(this.R);
            this.Q.setOnClickListener(this.S);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.U != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.U = 4;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(androidx.databinding.b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[2], objArr[13], objArr[5], objArr[11], objArr[4], objArr[3], objArr[12], objArr[10]);
        this.U = -1;
        this.B.setTag((Object) null);
        this.D.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.L = constraintLayout;
        constraintLayout.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.M = imageView;
        imageView.setTag((Object) null);
        TextView textView = objArr[6];
        this.N = textView;
        textView.setTag((Object) null);
        TextView textView2 = objArr[7];
        this.O = textView2;
        textView2.setTag((Object) null);
        ImageView imageView2 = objArr[8];
        this.P = imageView2;
        imageView2.setTag((Object) null);
        TextView textView3 = objArr[9];
        this.Q = textView3;
        textView3.setTag((Object) null);
        this.F.setTag((Object) null);
        this.G.setTag((Object) null);
        G(view);
        this.R = new a(this, 2);
        this.S = new a(this, 3);
        this.T = new a(this, 1);
        t();
    }
}
