package com.huobi.copytrading.vm;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.blankj.utilcode.util.m;
import com.huobi.copytrading.ui.CopyTradingMainActivity;
import com.huobi.copytrading.ui.CopyTradingTraderInfoActivity;
import com.huobi.edgeengine.viewmodel.EdgeEngineContainerViewModel;
import java.io.Serializable;
import kotlin.jvm.internal.r;
import rj.b;

public final class CopyTradingViewModel extends EdgeEngineContainerViewModel {

    /* renamed from: f  reason: collision with root package name */
    public boolean f43712f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43713g;

    /* renamed from: h  reason: collision with root package name */
    public MutableLiveData<String> f43714h = new MutableLiveData<>();

    public final void A0(int i11, String str) {
        if (str == null) {
            str = "";
        }
        String g11 = m.g(new RequestRankParameters(false, i11, str, 1, (r) null));
        b h02 = h0();
        h02.I("getTraderList(" + g11 + ')');
    }

    public final void B0(boolean z11) {
        this.f43712f = z11;
    }

    public void onCreate(LifecycleOwner lifecycleOwner) {
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        if ((lifecycleOwner instanceof CopyTradingMainActivity) || (lifecycleOwner instanceof CopyTradingTraderInfoActivity)) {
            ek.b.f47515a.e(j0());
        }
    }

    public void onPause(LifecycleOwner lifecycleOwner) {
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        if (this.f43713g) {
            super.onResume(lifecycleOwner);
        }
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        h0().I("moduleAppear()");
    }

    public void onStop(LifecycleOwner lifecycleOwner) {
        h0().I("moduleDisappear()");
    }

    public final void w0() {
        this.f43714h.setValue("");
    }

    public final MutableLiveData<String> x0() {
        return this.f43714h;
    }

    public final boolean y0() {
        return this.f43712f;
    }

    public final void z0() {
        this.f43713g = true;
    }

    public static final class RequestRankParameters implements Serializable {
        private boolean isMore;
        private int rankType;
        private String searchWord;

        public RequestRankParameters() {
            this(false, 0, (String) null, 7, (r) null);
        }

        public RequestRankParameters(boolean z11, int i11, String str) {
            this.isMore = z11;
            this.rankType = i11;
            this.searchWord = str;
        }

        public final int getRankType() {
            return this.rankType;
        }

        public final String getSearchWord() {
            return this.searchWord;
        }

        public final boolean isMore() {
            return this.isMore;
        }

        public final void setMore(boolean z11) {
            this.isMore = z11;
        }

        public final void setRankType(int i11) {
            this.rankType = i11;
        }

        public final void setSearchWord(String str) {
            this.searchWord = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ RequestRankParameters(boolean z11, int i11, String str, int i12, r rVar) {
            this((i12 & 1) != 0 ? false : z11, (i12 & 2) != 0 ? 0 : i11, (i12 & 4) != 0 ? "" : str);
        }
    }
}
