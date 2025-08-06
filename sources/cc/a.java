package cc;

import com.hbg.lib.network.hbg.core.bean.IntegrationQuestionInfo;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.module.asset.withdraw.viewhandler.WithdrawReqListItemHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public IntegrationQuestionInfo f16929b;

    /* renamed from: c  reason: collision with root package name */
    public C0120a f16930c;

    /* renamed from: cc.a$a  reason: collision with other inner class name */
    public interface C0120a {
        void H7(IntegrationQuestionInfo integrationQuestionInfo, CommonCheckBox commonCheckBox);

        boolean ce(IntegrationQuestionInfo integrationQuestionInfo);
    }

    public a(IntegrationQuestionInfo integrationQuestionInfo, C0120a aVar) {
        this.f16929b = integrationQuestionInfo;
        this.f16930c = aVar;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public C0120a c() {
        return this.f16930c;
    }

    public IntegrationQuestionInfo d() {
        return this.f16929b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.a(this)) {
            return false;
        }
        IntegrationQuestionInfo d11 = d();
        IntegrationQuestionInfo d12 = aVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        C0120a c11 = c();
        C0120a c12 = aVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return WithdrawReqListItemHandler.class.getName();
    }

    public int hashCode() {
        IntegrationQuestionInfo d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        C0120a c11 = c();
        int i12 = (hashCode + 59) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "WithdrawReqListItem(info=" + d() + ", callback=" + c() + ")";
    }
}
