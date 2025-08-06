package com.huobi.copytrading.widget;

import com.hbg.lib.widgets.dialog.dialogfragment.BaseTopRightListDialogFragment;
import com.huobi.copytrading.widget.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import pro.huobi.R;

public final class CopyTradingMoreDialog extends BaseTopRightListDialogFragment<a> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f43719f = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public boolean f43720b;

    /* renamed from: c  reason: collision with root package name */
    public int f43721c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43722d;

    /* renamed from: e  reason: collision with root package name */
    public a.C0566a f43723e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CopyTradingMoreDialog(boolean z11, int i11, boolean z12, int i12, r rVar) {
        this(z11, (i12 & 2) != 0 ? 0 : i11, (i12 & 4) != 0 ? false : z12);
    }

    public List<a> getDataList() {
        if (this.f43721c == 0) {
            ArrayList arrayList = new ArrayList();
            if (!this.f43720b && !tg.r.x().X()) {
                arrayList.add(new a(0, R.drawable.ic_apply_trder_cp, getString(R.string.n_copy_trading_apply_trader), this.f43723e));
            }
            arrayList.add(new a(1, R.drawable.icon_copytrading_guide, getString(R.string.n_copy_trading_documentary_guide), this.f43723e));
            arrayList.add(new a(2, R.drawable.ic_ruler_cp, getString(R.string.n_contract_trade_new_guide_menu), this.f43723e));
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        if (this.f43722d) {
            arrayList2.add(new a(0, R.drawable.edge_engine_pop_setting, getString(R.string.n_user_center_setting_page), this.f43723e));
        }
        arrayList2.add(new a(1, R.drawable.edge_engine_pop_history, getString(R.string.n_copy_trading_transfer_history), this.f43723e));
        arrayList2.add(new a(2, R.drawable.edge_engine_pop_flow, getString(R.string.n_copytrading_flow_record), this.f43723e));
        if (this.f43720b) {
            arrayList2.add(new a(3, R.drawable.edge_engine_pop_share, getString(R.string.n_share_sys_share), this.f43723e));
        }
        return arrayList2;
    }

    public final void sh(a.C0566a aVar) {
        this.f43723e = aVar;
    }

    public CopyTradingMoreDialog(boolean z11, int i11, boolean z12) {
        this.f43720b = z11;
        this.f43721c = i11;
        this.f43722d = z12;
    }
}
