package lj;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.d;
import androidx.databinding.f;
import androidx.lifecycle.MutableLiveData;
import com.huobi.copytrading.ui.CopyTradingHomeFragment;
import com.huobi.copytrading.vm.CopyTradingViewModel;
import jl.a;
import pro.huobi.R;

public class x extends w implements a.C0808a {
    public static final f.i S = null;
    public static final SparseIntArray T;
    public final FrameLayout L;
    public final ImageView M;
    public final AppCompatEditText N;
    public final View.OnClickListener O;
    public final View.OnClickListener P;
    public d Q;
    public long R;

    public class a implements d {
        public a() {
        }

        public void c() {
            String a11 = TextViewBindingAdapter.a(x.this.N);
            CopyTradingViewModel copyTradingViewModel = x.this.J;
            boolean z11 = true;
            if (copyTradingViewModel != null) {
                MutableLiveData<String> x02 = copyTradingViewModel.x0();
                if (x02 == null) {
                    z11 = false;
                }
                if (z11) {
                    x02.setValue(a11);
                }
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        T = sparseIntArray;
        sparseIntArray.put(R.id.iv_bg, 4);
        sparseIntArray.put(R.id.tv_title, 5);
        sparseIntArray.put(R.id.iv_more, 6);
        sparseIntArray.put(R.id.app_bar, 7);
        sparseIntArray.put(R.id.llSort, 8);
        sparseIntArray.put(R.id.tv_sort, 9);
        sparseIntArray.put(R.id.nl_root, 10);
    }

    public x(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 11, S, T));
    }

    public void K(CopyTradingHomeFragment copyTradingHomeFragment) {
        this.K = copyTradingHomeFragment;
        synchronized (this) {
            this.R |= 4;
        }
        notifyPropertyChanged(12);
        super.B();
    }

    public void L(CopyTradingViewModel copyTradingViewModel) {
        this.J = copyTradingViewModel;
        synchronized (this) {
            this.R |= 2;
        }
        notifyPropertyChanged(24);
        super.B();
    }

    public final boolean N(MutableLiveData<String> mutableLiveData, int i11) {
        if (i11 != 0) {
            return false;
        }
        synchronized (this) {
            this.R |= 1;
        }
        return true;
    }

    public final void a(int i11, View view) {
        boolean z11 = false;
        if (i11 == 1) {
            CopyTradingHomeFragment copyTradingHomeFragment = this.K;
            if (copyTradingHomeFragment != null) {
                z11 = true;
            }
            if (z11) {
                copyTradingHomeFragment.Th();
            }
        } else if (i11 == 2) {
            CopyTradingViewModel copyTradingViewModel = this.J;
            if (copyTradingViewModel != null) {
                z11 = true;
            }
            if (z11) {
                copyTradingViewModel.w0();
            }
        }
    }

    public void i() {
        long j11;
        String str;
        synchronized (this) {
            j11 = this.R;
            this.R = 0;
        }
        CopyTradingViewModel copyTradingViewModel = this.J;
        int i11 = ((j11 & 11) > 0 ? 1 : ((j11 & 11) == 0 ? 0 : -1));
        int i12 = 0;
        if (i11 != 0) {
            MutableLiveData<String> x02 = copyTradingViewModel != null ? copyTradingViewModel.x0() : null;
            I(0, x02);
            str = x02 != null ? x02.getValue() : null;
            boolean isEmpty = TextUtils.isEmpty(str);
            if (i11 != 0) {
                j11 |= isEmpty ? 32 : 16;
            }
            if (isEmpty) {
                i12 = 8;
            }
        } else {
            str = null;
        }
        if ((8 & j11) != 0) {
            this.D.setOnClickListener(this.O);
            this.M.setOnClickListener(this.P);
            TextViewBindingAdapter.d(this.N, (TextViewBindingAdapter.c) null, (TextViewBindingAdapter.d) null, (TextViewBindingAdapter.b) null, this.Q);
        }
        if ((j11 & 11) != 0) {
            this.D.setVisibility(i12);
            TextViewBindingAdapter.c(this.N, str);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.R != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.R = 8;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        if (i11 != 0) {
            return false;
        }
        return N((MutableLiveData) obj, i12);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(b bVar, View view, Object[] objArr) {
        super(bVar, view, 1, objArr[7], objArr[4], objArr[3], objArr[6], objArr[8], objArr[10], objArr[9], objArr[5]);
        this.Q = new a();
        this.R = -1;
        this.D.setTag((Object) null);
        FrameLayout frameLayout = objArr[0];
        this.L = frameLayout;
        frameLayout.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.M = imageView;
        imageView.setTag((Object) null);
        AppCompatEditText appCompatEditText = objArr[2];
        this.N = appCompatEditText;
        appCompatEditText.setTag((Object) null);
        View view2 = view;
        G(view);
        this.O = new jl.a(this, 2);
        this.P = new jl.a(this, 1);
        t();
    }
}
