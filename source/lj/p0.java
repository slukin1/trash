package lj;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import pro.huobi.R;

public class p0 extends o0 {

    /* renamed from: l0  reason: collision with root package name */
    public static final f.i f47622l0 = null;

    /* renamed from: m0  reason: collision with root package name */
    public static final SparseIntArray f47623m0;

    /* renamed from: j0  reason: collision with root package name */
    public final FrameLayout f47624j0;

    /* renamed from: k0  reason: collision with root package name */
    public long f47625k0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f47623m0 = sparseIntArray;
        sparseIntArray.put(R.id.tvTimeTitle, 1);
        sparseIntArray.put(R.id.llCountDown, 2);
        sparseIntArray.put(R.id.tvDay, 3);
        sparseIntArray.put(R.id.tvDayUnit, 4);
        sparseIntArray.put(R.id.tvHour, 5);
        sparseIntArray.put(R.id.tvMinute, 6);
        sparseIntArray.put(R.id.tvSecond, 7);
        sparseIntArray.put(R.id.ivIcon, 8);
        sparseIntArray.put(R.id.tvSymbol, 9);
        sparseIntArray.put(R.id.tvPosSide, 10);
        sparseIntArray.put(R.id.tvMgnMode, 11);
        sparseIntArray.put(R.id.tvLever, 12);
        sparseIntArray.put(R.id.tvClosePosition, 13);
        sparseIntArray.put(R.id.tvMaxPnl, 14);
        sparseIntArray.put(R.id.llPnl, 15);
        sparseIntArray.put(R.id.tvPnlName, 16);
        sparseIntArray.put(R.id.tvPnl, 17);
        sparseIntArray.put(R.id.tvPnlRatioName, 18);
        sparseIntArray.put(R.id.tvPnlRatio, 19);
        sparseIntArray.put(R.id.tvSzName, 20);
        sparseIntArray.put(R.id.tvSz, 21);
        sparseIntArray.put(R.id.tvOpenPxName, 22);
        sparseIntArray.put(R.id.tvOpenPx, 23);
        sparseIntArray.put(R.id.tvMarginName, 24);
        sparseIntArray.put(R.id.tvMargin, 25);
        sparseIntArray.put(R.id.tvMarginRatioName, 26);
        sparseIntArray.put(R.id.tvMarginRatio, 27);
        sparseIntArray.put(R.id.tvLiqPxName, 28);
        sparseIntArray.put(R.id.tvLiqPx, 29);
        sparseIntArray.put(R.id.llFold, 30);
        sparseIntArray.put(R.id.tvChartName, 31);
        sparseIntArray.put(R.id.tvPx, 32);
        sparseIntArray.put(R.id.ivArrow, 33);
        sparseIntArray.put(R.id.kLineView, 34);
    }

    public p0(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 35, f47622l0, f47623m0));
    }

    public void i() {
        synchronized (this) {
            this.f47625k0 = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.f47625k0 != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.f47625k0 = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public p0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[33], objArr[8], objArr[34], objArr[2], objArr[30], objArr[15], objArr[31], objArr[13], objArr[3], objArr[4], objArr[5], objArr[12], objArr[29], objArr[28], objArr[25], objArr[24], objArr[27], objArr[26], objArr[14], objArr[11], objArr[6], objArr[23], objArr[22], objArr[17], objArr[16], objArr[19], objArr[18], objArr[10], objArr[32], objArr[7], objArr[9], objArr[21], objArr[20], objArr[1]);
        this.f47625k0 = -1;
        FrameLayout frameLayout = objArr[0];
        this.f47624j0 = frameLayout;
        frameLayout.setTag((Object) null);
        G(view);
        t();
    }
}
