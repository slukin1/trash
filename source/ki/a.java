package ki;

import android.os.Handler;
import android.os.Looper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.linear.swap.core.bean.ContractBondAdjustDetailQuestParams;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapBondAdjustDetail;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapBondAdjustResult;
import com.huobi.bond.ContractBondAdjustDialogFragment;
import i6.d;
import rx.Observer;
import u6.g;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public ContractBondAdjustDialogFragment f47604a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f47605b = new Handler(Looper.getMainLooper());

    /* renamed from: ki.a$a  reason: collision with other inner class name */
    public class C0577a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContractBondAdjustDetailQuestParams f47606b;

        public C0577a(ContractBondAdjustDetailQuestParams contractBondAdjustDetailQuestParams) {
            this.f47606b = contractBondAdjustDetailQuestParams;
        }

        public void run() {
            a.this.d(this.f47606b);
        }
    }

    public class b implements Observer<LinearSwapBondAdjustDetail> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContractBondAdjustDetailQuestParams f47608b;

        public b(ContractBondAdjustDetailQuestParams contractBondAdjustDetailQuestParams) {
            this.f47608b = contractBondAdjustDetailQuestParams;
        }

        /* renamed from: a */
        public void onNext(LinearSwapBondAdjustDetail linearSwapBondAdjustDetail) {
            a.this.f47604a.Ih();
            linearSwapBondAdjustDetail.setContractBondAdjustDetailQuestParams(this.f47608b);
            a.this.f47604a.Hh(linearSwapBondAdjustDetail);
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
            a.this.f47604a.Ih();
            a.this.f47604a.Gh(th2);
        }
    }

    public class c implements Observer<LinearSwapBondAdjustResult> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(LinearSwapBondAdjustResult linearSwapBondAdjustResult) {
            a.this.f47604a.Ih();
            a.this.f47604a.Fh(linearSwapBondAdjustResult);
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
            a.this.f47604a.Ih();
            a.this.f47604a.Eh(th2);
        }
    }

    public a(ContractBondAdjustDialogFragment contractBondAdjustDialogFragment) {
        this.f47604a = contractBondAdjustDialogFragment;
    }

    public void b(String str, int i11, String str2, String str3, boolean z11, String str4) {
        d.c("ContractBondAdjust", "adjustBond " + str + " " + i11 + " " + str2 + " " + str3 + " " + z11 + " " + str4);
        this.f47604a.showLoading();
        h8.a.a().U(str, i11, str2, str3, z11, str4).b().compose(RxJavaHelper.t((g) null)).subscribe(new c());
    }

    public void c(ContractBondAdjustDetailQuestParams contractBondAdjustDetailQuestParams) {
        d.c("ContractBondAdjust", "goToRefreshDetail " + contractBondAdjustDetailQuestParams.toString());
        this.f47605b.removeCallbacksAndMessages((Object) null);
        this.f47605b.postDelayed(new C0577a(contractBondAdjustDetailQuestParams), 1000);
    }

    public void d(ContractBondAdjustDetailQuestParams contractBondAdjustDetailQuestParams) {
        d.c("ContractBondAdjust", "refreshDetailReal " + contractBondAdjustDetailQuestParams.toString());
        this.f47604a.showLoading();
        h8.a.a().r0(contractBondAdjustDetailQuestParams.getContractCode(), contractBondAdjustDetailQuestParams.getMarginAccount(), contractBondAdjustDetailQuestParams.getTradePartition(), contractBondAdjustDetailQuestParams.isAdd(), contractBondAdjustDetailQuestParams.getAmount(), contractBondAdjustDetailQuestParams.getDirection()).b().compose(RxJavaHelper.t((g) null)).subscribe(new b(contractBondAdjustDetailQuestParams));
    }
}
