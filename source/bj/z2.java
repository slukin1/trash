package bj;

import com.huobi.contract.entity.FutureDialogPriorityBean;
import ej.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class z2 {

    /* renamed from: a  reason: collision with root package name */
    public static List<FutureDialogPriorityBean> f40897a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, FutureDialogPriorityBean> f40898b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static volatile z2 f40899c;

    public z2() {
        FutureDialogPriorityBean futureDialogPriorityBean = new FutureDialogPriorityBean("CLEAR_NAME", 1, true, 20, true);
        FutureDialogPriorityBean futureDialogPriorityBean2 = new FutureDialogPriorityBean("CLEAR_AFTER_NAME", 1, true, 21, true);
        FutureDialogPriorityBean futureDialogPriorityBean3 = new FutureDialogPriorityBean("NEW_GUIDE_NAME", 1, false, 30, false);
        FutureDialogPriorityBean futureDialogPriorityBean4 = new FutureDialogPriorityBean("TP_SL_GUIDE_NAME", j.c() ? 3 : 1, false, 35, false);
        FutureDialogPriorityBean futureDialogPriorityBean5 = new FutureDialogPriorityBean("OPEN_NAME", 1, false, 40, true);
        f40897a.add(futureDialogPriorityBean4);
        f40897a.add(futureDialogPriorityBean);
        f40897a.add(futureDialogPriorityBean2);
        f40897a.add(futureDialogPriorityBean3);
        f40897a.add(futureDialogPriorityBean5);
        Collections.sort(f40897a, y2.f12531b);
        f40898b.put("TP_SL_GUIDE_NAME", futureDialogPriorityBean4);
        f40898b.put("CLEAR_NAME", futureDialogPriorityBean);
        f40898b.put("CLEAR_AFTER_NAME", futureDialogPriorityBean2);
        f40898b.put("NEW_GUIDE_NAME", futureDialogPriorityBean3);
        f40898b.put("OPEN_NAME", futureDialogPriorityBean5);
    }

    public static z2 c() {
        if (f40899c == null) {
            synchronized (z2.class) {
                if (f40899c == null) {
                    f40899c = new z2();
                }
            }
        }
        return f40899c;
    }

    public static /* synthetic */ int d(FutureDialogPriorityBean futureDialogPriorityBean, FutureDialogPriorityBean futureDialogPriorityBean2) {
        return futureDialogPriorityBean.getShowLever() - futureDialogPriorityBean2.getShowLever();
    }

    public void b(String str, int i11) {
        FutureDialogPriorityBean futureDialogPriorityBean = f40898b.get(str);
        if (futureDialogPriorityBean != null) {
            futureDialogPriorityBean.setShowStatus(i11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(java.lang.String r8) {
        /*
            r7 = this;
            java.util.Map<java.lang.String, com.huobi.contract.entity.FutureDialogPriorityBean> r0 = f40898b
            java.lang.Object r8 = r0.get(r8)
            com.huobi.contract.entity.FutureDialogPriorityBean r8 = (com.huobi.contract.entity.FutureDialogPriorityBean) r8
            r0 = 1
            r1 = 0
            if (r8 == 0) goto L_0x004c
            java.util.List<com.huobi.contract.entity.FutureDialogPriorityBean> r2 = f40897a
            int r2 = r2.indexOf(r8)
            sc.a r3 = com.hbg.module.contract.ContractModuleConfig.a()
            boolean r3 = r3.a()
            r4 = r1
        L_0x001b:
            if (r4 >= r2) goto L_0x003f
            java.util.List<com.huobi.contract.entity.FutureDialogPriorityBean> r5 = f40897a
            java.lang.Object r5 = r5.get(r4)
            com.huobi.contract.entity.FutureDialogPriorityBean r5 = (com.huobi.contract.entity.FutureDialogPriorityBean) r5
            boolean r6 = r5.isLoginShow()
            if (r6 == 0) goto L_0x0034
            if (r3 == 0) goto L_0x003c
            boolean r5 = r5.isNotShowOrShowing()
            if (r5 == 0) goto L_0x003c
            goto L_0x003a
        L_0x0034:
            boolean r5 = r5.isNotShowOrShowing()
            if (r5 == 0) goto L_0x003c
        L_0x003a:
            r0 = r1
            goto L_0x003f
        L_0x003c:
            int r4 = r4 + 1
            goto L_0x001b
        L_0x003f:
            boolean r2 = r8.isShowIng()
            if (r2 != 0) goto L_0x004b
            boolean r8 = r8.isShowed()
            if (r8 == 0) goto L_0x004c
        L_0x004b:
            r0 = r1
        L_0x004c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bj.z2.e(java.lang.String):boolean");
    }
}
