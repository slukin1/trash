package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$string;

public class l0 extends k0 {

    /* renamed from: b0  reason: collision with root package name */
    public static final f.i f19194b0 = null;

    /* renamed from: c0  reason: collision with root package name */
    public static final SparseIntArray f19195c0;
    public final LinearLayout Y;
    public final TextView Z;

    /* renamed from: a0  reason: collision with root package name */
    public long f19196a0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f19195c0 = sparseIntArray;
        sparseIntArray.put(R$id.vSpace, 2);
        sparseIntArray.put(R$id.ivClose, 3);
        sparseIntArray.put(R$id.ivAvatar, 4);
        sparseIntArray.put(R$id.tvNickName, 5);
        sparseIntArray.put(R$id.tvTotalProfit, 6);
        sparseIntArray.put(R$id.tvCopyUserNum, 7);
        sparseIntArray.put(R$id.tvWinRate, 8);
        sparseIntArray.put(R$id.tvThirtyYield, 9);
        sparseIntArray.put(R$id.tvCopyTotalProfit, 10);
        sparseIntArray.put(R$id.tvCopyNum, 11);
        sparseIntArray.put(R$id.tvWinNum, 12);
        sparseIntArray.put(R$id.tvAvgHoldTime, 13);
        sparseIntArray.put(R$id.tvTotalTime, 14);
        sparseIntArray.put(R$id.tvSymbolPref, 15);
        sparseIntArray.put(R$id.pkCommonView, 16);
        sparseIntArray.put(R$id.clReason, 17);
        sparseIntArray.put(R$id.tvReasonTitle, 18);
        sparseIntArray.put(R$id.llCollapseBtn, 19);
        sparseIntArray.put(R$id.tvCollapse, 20);
        sparseIntArray.put(R$id.ivArrow, 21);
        sparseIntArray.put(R$id.tvReason, 22);
        sparseIntArray.put(R$id.tvCopy, 23);
        sparseIntArray.put(R$id.tvMyOrder, 24);
    }

    public l0(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 25, f19194b0, f19195c0));
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.f19196a0;
            this.f19196a0 = 0;
        }
        if ((j11 & 1) != 0) {
            TextView textView = this.Z;
            TextViewBindingAdapter.c(textView, textView.getResources().getString(R$string.n_grid_strategy_profit, new Object[]{"USDT"}));
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.f19196a0 != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.f19196a0 = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public l0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[17], objArr[21], objArr[4], objArr[3], objArr[19], objArr[16], objArr[13], objArr[20], objArr[23], objArr[11], objArr[10], objArr[7], objArr[24], objArr[5], objArr[22], objArr[18], objArr[15], objArr[9], objArr[6], objArr[14], objArr[12], objArr[8], objArr[2]);
        this.f19196a0 = -1;
        LinearLayout linearLayout = objArr[0];
        this.Y = linearLayout;
        linearLayout.setTag((Object) null);
        TextView textView = objArr[1];
        this.Z = textView;
        textView.setTag((Object) null);
        G(view);
        t();
    }
}
