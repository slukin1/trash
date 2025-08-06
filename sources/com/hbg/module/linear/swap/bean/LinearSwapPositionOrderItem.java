package com.hbg.module.linear.swap.bean;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.module.linear.swap.viewhandler.LinearSwapPositionOrderItemHandler;
import com.huobi.feature.ui.LeverSelectDialogFragment;

public class LinearSwapPositionOrderItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public LinearSwapPosition f26409b;

    /* renamed from: c  reason: collision with root package name */
    public FutureContractInfo f26410c;

    /* renamed from: d  reason: collision with root package name */
    public a f26411d;

    public interface a {
        String a();

        void b(LinearSwapPositionOrderItem linearSwapPositionOrderItem);

        void c(LinearSwapPositionOrderItem linearSwapPositionOrderItem);

        void d(LinearSwapPositionOrderItem linearSwapPositionOrderItem, int i11);

        void e(LinearSwapPositionOrderItem linearSwapPositionOrderItem);

        void f(LinearSwapPositionOrderItem linearSwapPositionOrderItem);

        LeverSelectDialogFragment.h g(FutureContractInfo futureContractInfo, int i11);

        void h(LinearSwapPositionOrderItem linearSwapPositionOrderItem);

        void i(LinearSwapPositionOrderItem linearSwapPositionOrderItem);
    }

    public boolean a(Object obj) {
        return obj instanceof LinearSwapPositionOrderItem;
    }

    public a c() {
        return this.f26411d;
    }

    public FutureContractInfo d() {
        return this.f26410c;
    }

    public LinearSwapPosition e() {
        return this.f26409b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapPositionOrderItem)) {
            return false;
        }
        LinearSwapPositionOrderItem linearSwapPositionOrderItem = (LinearSwapPositionOrderItem) obj;
        if (!linearSwapPositionOrderItem.a(this)) {
            return false;
        }
        LinearSwapPosition e11 = e();
        LinearSwapPosition e12 = linearSwapPositionOrderItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        FutureContractInfo d11 = d();
        FutureContractInfo d12 = linearSwapPositionOrderItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = linearSwapPositionOrderItem.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(a aVar) {
        this.f26411d = aVar;
    }

    public void g(FutureContractInfo futureContractInfo) {
        this.f26410c = futureContractInfo;
    }

    public String getViewHandlerName() {
        return LinearSwapPositionOrderItemHandler.class.getName();
    }

    public void h(LinearSwapPosition linearSwapPosition) {
        this.f26409b = linearSwapPosition;
    }

    public int hashCode() {
        LinearSwapPosition e11 = e();
        int i11 = 43;
        int hashCode = e11 == null ? 43 : e11.hashCode();
        FutureContractInfo d11 = d();
        int hashCode2 = ((hashCode + 59) * 59) + (d11 == null ? 43 : d11.hashCode());
        a c11 = c();
        int i12 = hashCode2 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "LinearSwapPositionOrderItem(info=" + e() + ", contractInfo=" + d() + ", callback=" + c() + ")";
    }
}
