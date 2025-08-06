package yf;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.ShareGroupList;
import com.hbg.module.share.BR;
import com.hbg.module.share.R$drawable;
import com.hbg.module.share.R$id;
import com.hbg.module.share.R$string;

public class f extends e {
    public static final f.i J = null;
    public static final SparseIntArray K;
    public final LinearLayout E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public long I;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K = sparseIntArray;
        sparseIntArray.put(R$id.cbCheck, 5);
    }

    public f(b bVar, View view) {
        this(bVar, view, androidx.databinding.f.w(bVar, view, 6, J, K));
    }

    public void M(ShareGroupList.ShareGroup shareGroup) {
        this.D = shareGroup;
        synchronized (this) {
            this.I |= 1;
        }
        notifyPropertyChanged(BR.f37423a);
        super.B();
    }

    public void i() {
        long j11;
        String str;
        int i11;
        int i12;
        String str2;
        String str3;
        int i13;
        synchronized (this) {
            j11 = this.I;
            this.I = 0;
        }
        ShareGroupList.ShareGroup shareGroup = this.D;
        int i14 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        String str4 = null;
        if (i14 != 0) {
            int i15 = R$drawable.icon_community_user_header;
            if (shareGroup != null) {
                String str5 = shareGroup.avatar;
                String str6 = shareGroup.title;
                String str7 = shareGroup.userCount;
                i13 = shareGroup.isShared;
                String str8 = str6;
                str3 = str5;
                str4 = str7;
                str = str8;
            } else {
                str3 = null;
                str = null;
                i13 = 0;
            }
            String str9 = this.G.getResources().getString(R$string.n_im_current_users) + str4;
            boolean z11 = true;
            if (i13 != 1) {
                z11 = false;
            }
            if (i14 != 0) {
                j11 |= z11 ? 8 : 4;
            }
            str2 = str9;
            i12 = z11 ? 0 : 8;
            i11 = i15;
            str4 = str3;
        } else {
            str2 = null;
            str = null;
            i12 = 0;
            i11 = 0;
        }
        if ((j11 & 3) != 0) {
            he.b.p(this.C, str4, i11);
            TextViewBindingAdapter.c(this.F, str);
            TextViewBindingAdapter.c(this.G, str2);
            this.H.setVisibility(i12);
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

    public f(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[5], objArr[1]);
        this.I = -1;
        this.C.setTag((Object) null);
        LinearLayout linearLayout = objArr[0];
        this.E = linearLayout;
        linearLayout.setTag((Object) null);
        TextView textView = objArr[2];
        this.F = textView;
        textView.setTag((Object) null);
        TextView textView2 = objArr[3];
        this.G = textView2;
        textView2.setTag((Object) null);
        TextView textView3 = objArr[4];
        this.H = textView3;
        textView3.setTag((Object) null);
        G(view);
        t();
    }
}
