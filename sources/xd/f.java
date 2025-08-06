package xd;

import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import h8.a;
import i6.i;
import xd.j;

public class f extends j {
    public f(j.f fVar) {
        super(fVar);
    }

    public void o(KlineInfo klineInfo) {
        if (j(this.f26333a, this.f26334b)) {
            a.a().f(this.f26333a, this.f26334b, Period.fromSecondTime(this.f26334b, klineInfo.getId(), i()), klineInfo.getId(), this.f26347i);
        }
    }

    public void p() {
        a.a().c(this.f26348j);
    }

    public void q() {
        a.a().d(this.f26348j);
    }

    public void r() {
        if (j(this.f26333a, this.f26334b)) {
            a.a().f(this.f26333a, this.f26334b, Period.fromSecondTime(this.f26334b, i()), System.currentTimeMillis() / 1000, this.f26347i);
            i.b().g(this.f26346h, DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS);
            return;
        }
        j.f fVar = this.f26345g;
        if (fVar != null) {
            fVar.A(false);
        }
    }

    public void t(Period period, boolean z11) {
        if (j(this.f26333a, period)) {
            a.a().g(z11, this.f26333a, period, this.f26349k);
        }
    }
}
