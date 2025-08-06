package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.TraderRank;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;

public class z5 extends y5 {
    public static final f.i T = null;
    public static final SparseIntArray U;
    public long S;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        U = sparseIntArray;
        sparseIntArray.put(R$id.ivCheck, 8);
        sparseIntArray.put(R$id.tvRank, 9);
        sparseIntArray.put(R$id.tvTotalPnlTitle, 10);
        sparseIntArray.put(R$id.tvTotalProfitsTitle, 11);
        sparseIntArray.put(R$id.lcChart, 12);
        sparseIntArray.put(R$id.vLine, 13);
        sparseIntArray.put(R$id.tvWinRateTitle, 14);
        sparseIntArray.put(R$id.tvFollowProfitsTitle, 15);
    }

    public z5(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 16, T, U));
    }

    public void M(TraderRank.TraderInfo traderInfo) {
        this.R = traderInfo;
        synchronized (this) {
            this.S |= 1;
        }
        notifyPropertyChanged(BR.f17742s);
        super.B();
    }

    public void i() {
        long j11;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i11;
        synchronized (this) {
            j11 = this.S;
            this.S = 0;
        }
        TraderRank.TraderInfo traderInfo = this.R;
        int i12 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        int i13 = 0;
        String str7 = null;
        if (i12 != 0) {
            int i14 = R$drawable.account_user_image;
            if (traderInfo != null) {
                String str8 = traderInfo.imgUrl;
                String winRateStr = traderInfo.getWinRateStr();
                str4 = traderInfo.copyProfit;
                str3 = traderInfo.profit;
                str2 = traderInfo.nickName;
                i11 = traderInfo.fullUserNum;
                String str9 = winRateStr;
                str7 = str8;
                i13 = traderInfo.copyUserNum;
                str = traderInfo.getApyStr();
                str5 = str9;
            } else {
                i11 = 0;
                str5 = null;
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            int i15 = i14;
            str6 = (i13 + "/") + i11;
            i13 = i15;
        } else {
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if (i12 != 0) {
            he.b.p(this.C, str7, i13);
            TextViewBindingAdapter.c(this.F, str6);
            TextViewBindingAdapter.c(this.G, str4);
            TextViewBindingAdapter.c(this.I, str2);
            TextViewBindingAdapter.c(this.K, str);
            TextViewBindingAdapter.c(this.M, str3);
            TextViewBindingAdapter.c(this.O, str5);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.S != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.S = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public z5(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[0], objArr[1], objArr[8], objArr[12], objArr[3], objArr[7], objArr[15], objArr[2], objArr[9], objArr[4], objArr[10], objArr[5], objArr[11], objArr[6], objArr[14], objArr[13]);
        this.S = -1;
        this.B.setTag((Object) null);
        this.C.setTag((Object) null);
        this.F.setTag((Object) null);
        this.G.setTag((Object) null);
        this.I.setTag((Object) null);
        this.K.setTag((Object) null);
        this.M.setTag((Object) null);
        this.O.setTag((Object) null);
        G(view);
        t();
    }
}
