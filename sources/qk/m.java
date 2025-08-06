package qk;

import android.content.Context;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.webview2.ui.ContractWebActivity;

public final class m {
    public static /* synthetic */ void b(Context context, int i11, HBDialogFragment hBDialogFragment) {
        ContractWebActivity.ai(context, "", "", false, false, i11);
        hBDialogFragment.sh();
    }

    public static void c(Context context, TradeType tradeType) {
        d(context, false, tradeType);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(android.content.Context r12, boolean r13, com.hbg.lib.data.symbol.TradeType r14) {
        /*
            oa.a r0 = oa.a.g()
            android.app.Activity r0 = r0.b()
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            tg.r r1 = tg.r.x()
            boolean r1 = r1.X()
            java.lang.String r2 = ""
            r3 = 2131231932(0x7f0804bc, float:1.8079959E38)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x005d
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = new com.hbg.lib.widgets.dialog.DialogUtils$b$d
            r13.<init>(r0)
            r14 = 2132018183(0x7f140407, float:1.9674665E38)
            java.lang.String r14 = r12.getString(r14)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.c1(r14)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.E0(r4)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.i1(r5)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.M0(r3)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.q0(r4)
            r14 = 2132017637(0x7f1401e5, float:1.9673558E38)
            java.lang.String r12 = r12.getString(r14)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r12 = r13.P0(r12)
            cn.n r13 = cn.n.f13170a
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r12 = r12.Q0(r13)
            com.hbg.lib.widgets.dialog.HBDialogFragment r12 = r12.j0()
            androidx.fragment.app.FragmentManager r13 = r0.getSupportFragmentManager()
            r12.show(r13, r2)
            goto L_0x00df
        L_0x005d:
            r1 = 2132020719(0x7f140def, float:1.967981E38)
            java.lang.String r1 = r12.getString(r1)
            com.hbg.lib.data.symbol.TradeType r6 = com.hbg.lib.data.symbol.TradeType.OPTION
            if (r14 != r6) goto L_0x0072
            r14 = 3
            r1 = 2132023392(0x7f141860, float:1.968523E38)
            java.lang.String r1 = r12.getString(r1)
        L_0x0070:
            r11 = r14
            goto L_0x008d
        L_0x0072:
            com.hbg.lib.data.symbol.TradeType r6 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP
            if (r14 != r6) goto L_0x007f
            r14 = 4
            r1 = 2132022728(0x7f1415c8, float:1.9683884E38)
            java.lang.String r1 = r12.getString(r1)
            goto L_0x0070
        L_0x007f:
            com.hbg.lib.data.symbol.TradeType r6 = com.hbg.lib.data.symbol.TradeType.SWAP
            if (r14 != r6) goto L_0x008c
            r14 = 2
            r1 = 2132024791(0x7f141dd7, float:1.9688068E38)
            java.lang.String r1 = r12.getString(r1)
            goto L_0x0070
        L_0x008c:
            r11 = r5
        L_0x008d:
            if (r13 == 0) goto L_0x009a
            r9 = 0
            r10 = 0
            java.lang.String r7 = ""
            java.lang.String r8 = ""
            r6 = r12
            com.huobi.webview2.ui.ContractWebActivity.ai(r6, r7, r8, r9, r10, r11)
            goto L_0x00df
        L_0x009a:
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = new com.hbg.lib.widgets.dialog.DialogUtils$b$d
            r13.<init>(r0)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.c1(r1)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.E0(r4)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.i1(r5)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.M0(r3)
            r14 = 2132020756(0x7f140e14, float:1.9679884E38)
            java.lang.String r14 = r12.getString(r14)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.s0(r14)
            r14 = 2132020718(0x7f140dee, float:1.9679807E38)
            java.lang.String r14 = r12.getString(r14)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.P0(r14)
            qk.l r14 = new qk.l
            r14.<init>(r12, r11)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r12 = r13.Q0(r14)
            cn.n r13 = cn.n.f13170a
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r12 = r12.N0(r13)
            com.hbg.lib.widgets.dialog.HBDialogFragment r12 = r12.j0()
            androidx.fragment.app.FragmentManager r13 = r0.getSupportFragmentManager()
            r12.show(r13, r2)
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qk.m.d(android.content.Context, boolean, com.hbg.lib.data.symbol.TradeType):void");
    }
}
