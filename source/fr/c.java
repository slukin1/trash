package fr;

import android.util.Pair;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FutureTypeUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import d7.a1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f84128a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f84129b = new ArrayList();

    public class a implements Comparator<Pair<String, Object>> {
        /* renamed from: a */
        public int compare(Pair<String, Object> pair, Pair<String, Object> pair2) {
            String str;
            Object obj = pair.second;
            String str2 = "";
            if (obj instanceof ContractCurrencyInfo) {
                str = ((ContractCurrencyInfo) obj).getContractCode();
            } else if (obj instanceof SwapCurrencyInfo) {
                str = ((SwapCurrencyInfo) obj).getSymbol() + "9995";
            } else {
                if (obj instanceof FutureContractInfo) {
                    FutureContractInfo futureContractInfo = (FutureContractInfo) obj;
                    if (FutureTypeUtil.a(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), futureContractInfo.getOptionCode()) == TradeType.LINEAR_SWAP) {
                        str = futureContractInfo.getSymbol() + "9996";
                    }
                } else if (obj instanceof IndexCurrencyInfo) {
                    IndexCurrencyInfo indexCurrencyInfo = (IndexCurrencyInfo) obj;
                    if ("usdt".equalsIgnoreCase(indexCurrencyInfo.getQuoteCurrency())) {
                        str = indexCurrencyInfo.getSymbol() + "9998";
                    } else {
                        str = indexCurrencyInfo.getSymbol() + "9997";
                    }
                }
                str = str2;
            }
            Object obj2 = pair2.second;
            if (obj2 instanceof ContractCurrencyInfo) {
                str2 = ((ContractCurrencyInfo) obj2).getContractCode();
            } else if (obj2 instanceof SwapCurrencyInfo) {
                str2 = ((SwapCurrencyInfo) obj2).getSymbol() + "9995";
            } else if (obj2 instanceof FutureContractInfo) {
                FutureContractInfo futureContractInfo2 = (FutureContractInfo) obj2;
                if (FutureTypeUtil.a(futureContractInfo2.getContractCode(), futureContractInfo2.getContractShortType(), futureContractInfo2.getOptionCode()) == TradeType.LINEAR_SWAP) {
                    str2 = futureContractInfo2.getSymbol() + "9996";
                }
            } else if (obj2 instanceof IndexCurrencyInfo) {
                IndexCurrencyInfo indexCurrencyInfo2 = (IndexCurrencyInfo) obj2;
                if ("usdt".equalsIgnoreCase(indexCurrencyInfo2.getQuoteCurrency())) {
                    str2 = indexCurrencyInfo2.getSymbol() + "9998";
                } else {
                    str2 = indexCurrencyInfo2.getSymbol() + "9997";
                }
            }
            return str.compareTo(str2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:160:0x0452  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0479 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<android.util.Pair<java.lang.String, java.lang.Object>> a(android.content.Context r23, java.lang.String r24, boolean r25) {
        /*
            r0 = r23
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List<java.lang.String> r2 = f84129b
            if (r2 == 0) goto L_0x04c0
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0013
            goto L_0x04c0
        L_0x0013:
            java.util.List<java.lang.String> r2 = f84129b
            int r2 = r2.size()
            java.lang.String r3 = com.hbg.lib.common.utils.StringUtils.i(r24)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r14 = 0
        L_0x004b:
            if (r14 >= r2) goto L_0x0165
            java.util.List<java.lang.String> r13 = f84128a
            java.lang.Object r13 = r13.get(r14)
            java.lang.String r13 = (java.lang.String) r13
            boolean r16 = android.text.TextUtils.isEmpty(r13)
            if (r16 != 0) goto L_0x0159
            boolean r16 = r13.contains(r3)
            if (r16 == 0) goto L_0x0159
            java.lang.String r15 = "/"
            boolean r17 = r3.contains(r15)
            r18 = r2
            r2 = 0
            if (r17 == 0) goto L_0x0080
            android.util.Pair r13 = new android.util.Pair
            java.util.List<java.lang.String> r15 = f84129b
            java.lang.Object r15 = r15.get(r14)
            java.lang.String r15 = (java.lang.String) r15
            r13.<init>(r15, r2)
            r12.add(r13)
        L_0x007c:
            r19 = r1
            goto L_0x015d
        L_0x0080:
            java.lang.String[] r13 = r13.split(r15)
            int r15 = r13.length
            r2 = 2
            if (r15 == r2) goto L_0x0089
            goto L_0x007c
        L_0x0089:
            r2 = 0
            r15 = r13[r2]
            boolean r15 = r15.equals(r3)
            if (r15 == 0) goto L_0x00a7
            android.util.Pair r15 = new android.util.Pair
            java.util.List<java.lang.String> r2 = f84129b
            java.lang.Object r2 = r2.get(r14)
            java.lang.String r2 = (java.lang.String) r2
            r19 = r1
            r1 = 0
            r15.<init>(r2, r1)
            r4.add(r15)
        L_0x00a5:
            r2 = 1
            goto L_0x00f5
        L_0x00a7:
            r19 = r1
            r1 = 0
            r15 = r13[r2]
            boolean r15 = r15.startsWith(r3)
            if (r15 == 0) goto L_0x00c3
            android.util.Pair r15 = new android.util.Pair
            java.util.List<java.lang.String> r2 = f84129b
            java.lang.Object r2 = r2.get(r14)
            java.lang.String r2 = (java.lang.String) r2
            r15.<init>(r2, r1)
            r5.add(r15)
            goto L_0x00a5
        L_0x00c3:
            r15 = r13[r2]
            boolean r15 = r15.endsWith(r3)
            if (r15 == 0) goto L_0x00dc
            android.util.Pair r15 = new android.util.Pair
            java.util.List<java.lang.String> r2 = f84129b
            java.lang.Object r2 = r2.get(r14)
            java.lang.String r2 = (java.lang.String) r2
            r15.<init>(r2, r1)
            r7.add(r15)
            goto L_0x00a5
        L_0x00dc:
            r15 = r13[r2]
            boolean r2 = r15.contains(r3)
            if (r2 == 0) goto L_0x00a5
            android.util.Pair r2 = new android.util.Pair
            java.util.List<java.lang.String> r15 = f84129b
            java.lang.Object r15 = r15.get(r14)
            java.lang.String r15 = (java.lang.String) r15
            r2.<init>(r15, r1)
            r6.add(r2)
            goto L_0x00a5
        L_0x00f5:
            r15 = r13[r2]
            boolean r15 = r15.equals(r3)
            if (r15 == 0) goto L_0x010e
            android.util.Pair r2 = new android.util.Pair
            java.util.List<java.lang.String> r13 = f84129b
            java.lang.Object r13 = r13.get(r14)
            java.lang.String r13 = (java.lang.String) r13
            r2.<init>(r13, r1)
            r9.add(r2)
            goto L_0x015d
        L_0x010e:
            r15 = r13[r2]
            boolean r15 = r15.startsWith(r3)
            if (r15 == 0) goto L_0x0127
            android.util.Pair r2 = new android.util.Pair
            java.util.List<java.lang.String> r13 = f84129b
            java.lang.Object r13 = r13.get(r14)
            java.lang.String r13 = (java.lang.String) r13
            r2.<init>(r13, r1)
            r8.add(r2)
            goto L_0x015d
        L_0x0127:
            r15 = r13[r2]
            boolean r15 = r15.endsWith(r3)
            if (r15 == 0) goto L_0x0140
            android.util.Pair r2 = new android.util.Pair
            java.util.List<java.lang.String> r13 = f84129b
            java.lang.Object r13 = r13.get(r14)
            java.lang.String r13 = (java.lang.String) r13
            r2.<init>(r13, r1)
            r11.add(r2)
            goto L_0x015d
        L_0x0140:
            r2 = r13[r2]
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x015d
            android.util.Pair r2 = new android.util.Pair
            java.util.List<java.lang.String> r13 = f84129b
            java.lang.Object r13 = r13.get(r14)
            java.lang.String r13 = (java.lang.String) r13
            r2.<init>(r13, r1)
            r10.add(r2)
            goto L_0x015d
        L_0x0159:
            r19 = r1
            r18 = r2
        L_0x015d:
            int r14 = r14 + 1
            r2 = r18
            r1 = r19
            goto L_0x004b
        L_0x0165:
            r19 = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r2 = com.huobi.contract.helper.ContractCurrencyUtils.m()
            int r13 = r2.size()
            r14 = 0
        L_0x0175:
            if (r14 >= r13) goto L_0x01dc
            java.lang.Object r15 = r2.get(r14)
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r15 = (com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo) r15
            r17 = r2
            java.lang.String r2 = r15.getSymbol()
            r18 = r13
            java.lang.String r13 = r15.getContractShortType()
            r20 = r11
            java.lang.String r11 = r15.getContractCode()
            r21 = r10
            r10 = 1
            java.lang.String r11 = ej.g.d(r13, r11, r10)
            boolean r10 = android.text.TextUtils.isEmpty(r2)
            if (r10 != 0) goto L_0x01a4
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x01a4
            r2 = 1
            goto L_0x01a5
        L_0x01a4:
            r2 = 0
        L_0x01a5:
            boolean r10 = android.text.TextUtils.isEmpty(r11)
            if (r10 != 0) goto L_0x01b3
            boolean r10 = r11.contains(r3)
            if (r10 == 0) goto L_0x01b3
            r10 = 1
            goto L_0x01b4
        L_0x01b3:
            r10 = 0
        L_0x01b4:
            if (r2 == 0) goto L_0x01c3
            android.util.Pair r2 = new android.util.Pair
            java.lang.String r10 = r15.getContractShortType()
            r2.<init>(r10, r15)
            r1.add(r2)
            goto L_0x01d1
        L_0x01c3:
            if (r10 == 0) goto L_0x01d1
            android.util.Pair r2 = new android.util.Pair
            java.lang.String r10 = r15.getContractShortType()
            r2.<init>(r10, r15)
            r12.add(r2)
        L_0x01d1:
            int r14 = r14 + 1
            r2 = r17
            r13 = r18
            r11 = r20
            r10 = r21
            goto L_0x0175
        L_0x01dc:
            r21 = r10
            r20 = r11
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController r10 = com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController.k()
            java.util.List r10 = r10.e()
            int r11 = r10.size()
            r13 = 0
        L_0x01f2:
            if (r13 >= r11) goto L_0x0248
            java.lang.Object r14 = r10.get(r13)
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r14 = (com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo) r14
            java.lang.String r15 = r14.getSymbol()
            r17 = r10
            java.lang.String r10 = r14.getSymbol()
            java.lang.String r10 = us.j.f(r10, r0)
            boolean r18 = android.text.TextUtils.isEmpty(r15)
            if (r18 != 0) goto L_0x0216
            boolean r15 = r15.contains(r3)
            if (r15 == 0) goto L_0x0216
            r15 = 1
            goto L_0x0217
        L_0x0216:
            r15 = 0
        L_0x0217:
            boolean r18 = android.text.TextUtils.isEmpty(r10)
            if (r18 != 0) goto L_0x0225
            boolean r10 = r10.contains(r3)
            if (r10 == 0) goto L_0x0225
            r10 = 1
            goto L_0x0226
        L_0x0225:
            r10 = 0
        L_0x0226:
            if (r15 == 0) goto L_0x0235
            android.util.Pair r10 = new android.util.Pair
            java.lang.String r15 = r14.getContractCode()
            r10.<init>(r15, r14)
            r2.add(r10)
            goto L_0x0243
        L_0x0235:
            if (r10 == 0) goto L_0x0243
            android.util.Pair r10 = new android.util.Pair
            java.lang.String r15 = r14.getContractCode()
            r10.<init>(r15, r14)
            r12.add(r10)
        L_0x0243:
            int r13 = r13 + 1
            r10 = r17
            goto L_0x01f2
        L_0x0248:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            if (r25 == 0) goto L_0x02cd
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController r13 = com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController.k()
            java.lang.String r14 = "usd"
            java.util.List r13 = r13.f(r14)
            com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController r14 = com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController.k()
            java.lang.String r15 = "usdt"
            java.util.List r14 = r14.f(r15)
            r11.addAll(r13)
            r11.addAll(r14)
            int r13 = r11.size()
            r14 = 0
        L_0x0273:
            if (r14 >= r13) goto L_0x02cd
            java.lang.Object r15 = r11.get(r14)
            com.hbg.lib.network.index.core.bean.IndexCurrencyInfo r15 = (com.hbg.lib.network.index.core.bean.IndexCurrencyInfo) r15
            r25 = r11
            java.lang.String r11 = r15.getSymbol()
            r17 = r13
            java.lang.String r13 = r15.getSymbol()
            java.lang.String r13 = us.j.a(r13, r0)
            boolean r18 = android.text.TextUtils.isEmpty(r11)
            if (r18 != 0) goto L_0x0299
            boolean r11 = r11.contains(r3)
            if (r11 == 0) goto L_0x0299
            r11 = 1
            goto L_0x029a
        L_0x0299:
            r11 = 0
        L_0x029a:
            boolean r18 = android.text.TextUtils.isEmpty(r13)
            if (r18 != 0) goto L_0x02a8
            boolean r13 = r13.contains(r3)
            if (r13 == 0) goto L_0x02a8
            r13 = 1
            goto L_0x02a9
        L_0x02a8:
            r13 = 0
        L_0x02a9:
            if (r11 == 0) goto L_0x02b8
            android.util.Pair r11 = new android.util.Pair
            java.lang.String r13 = r15.getContractCode()
            r11.<init>(r13, r15)
            r10.add(r11)
            goto L_0x02c6
        L_0x02b8:
            if (r13 == 0) goto L_0x02c6
            android.util.Pair r11 = new android.util.Pair
            java.lang.String r13 = r15.getContractCode()
            r11.<init>(r13, r15)
            r12.add(r11)
        L_0x02c6:
            int r14 = r14 + 1
            r11 = r25
            r13 = r17
            goto L_0x0273
        L_0x02cd:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            com.hbg.lib.data.future.controller.FutureContractInfoController r13 = com.hbg.lib.data.future.controller.FutureContractInfoController.n()
            java.util.List r13 = r13.f()
            int r14 = r13.size()
            r15 = 0
        L_0x02df:
            if (r15 >= r14) goto L_0x0347
            java.lang.Object r17 = r13.get(r15)
            r25 = r13
            r13 = r17
            com.hbg.lib.data.future.bean.FutureContractInfo r13 = (com.hbg.lib.data.future.bean.FutureContractInfo) r13
            r17 = r14
            java.lang.String r14 = r13.getSymbol()
            r18 = r8
            java.lang.String r8 = r13.getSymbol()
            r22 = r9
            java.lang.String r9 = r13.getQuoteCurrency()
            java.lang.String r8 = a7.e.l(r0, r8, r9)
            boolean r9 = android.text.TextUtils.isEmpty(r14)
            if (r9 != 0) goto L_0x030f
            boolean r9 = r14.contains(r3)
            if (r9 == 0) goto L_0x030f
            r9 = 1
            goto L_0x0310
        L_0x030f:
            r9 = 0
        L_0x0310:
            boolean r14 = android.text.TextUtils.isEmpty(r8)
            if (r14 != 0) goto L_0x031e
            boolean r8 = r8.contains(r3)
            if (r8 == 0) goto L_0x031e
            r8 = 1
            goto L_0x031f
        L_0x031e:
            r8 = 0
        L_0x031f:
            if (r9 == 0) goto L_0x032e
            android.util.Pair r8 = new android.util.Pair
            java.lang.String r9 = r13.getContractCode()
            r8.<init>(r9, r13)
            r11.add(r8)
            goto L_0x033c
        L_0x032e:
            if (r8 == 0) goto L_0x033c
            android.util.Pair r8 = new android.util.Pair
            java.lang.String r9 = r13.getContractCode()
            r8.<init>(r9, r13)
            r12.add(r8)
        L_0x033c:
            int r15 = r15 + 1
            r13 = r25
            r14 = r17
            r8 = r18
            r9 = r22
            goto L_0x02df
        L_0x0347:
            r18 = r8
            r22 = r9
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            int r9 = r8.size()
            r13 = 0
        L_0x035a:
            if (r13 >= r9) goto L_0x03c5
            java.lang.Object r14 = r8.get(r13)
            com.hbg.lib.data.future.bean.FutureContractInfo r14 = (com.hbg.lib.data.future.bean.FutureContractInfo) r14
            java.lang.String r15 = r14.getSymbol()
            r23 = r8
            java.lang.String r8 = r14.getOptionCode()
            r25 = r9
            android.app.Application r9 = bh.j.c()
            r17 = r7
            r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            android.text.SpannableStringBuilder r7 = a7.e.z(r15, r8, r9, r7)
            java.lang.String r7 = r7.toString()
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x0387
        L_0x0384:
            r9 = 1
            r15 = 2
            goto L_0x03bc
        L_0x0387:
            java.lang.String r8 = "-"
            java.lang.String[] r7 = r7.split(r8)
            int r8 = r7.length
            r9 = 4
            if (r8 >= r9) goto L_0x0392
            goto L_0x0384
        L_0x0392:
            r8 = 0
            r9 = r7[r8]
            boolean r9 = r9.contains(r3)
            if (r9 != 0) goto L_0x03ae
            r9 = 1
            r15 = r7[r9]
            boolean r15 = r15.contains(r3)
            if (r15 != 0) goto L_0x03af
            r15 = 2
            r7 = r7[r15]
            boolean r7 = r7.contains(r3)
            if (r7 == 0) goto L_0x03bc
            goto L_0x03b0
        L_0x03ae:
            r9 = 1
        L_0x03af:
            r15 = 2
        L_0x03b0:
            android.util.Pair r7 = new android.util.Pair
            java.lang.String r8 = r14.getOptionCode()
            r7.<init>(r8, r14)
            r0.add(r7)
        L_0x03bc:
            int r13 = r13 + 1
            r8 = r23
            r9 = r25
            r7 = r17
            goto L_0x035a
        L_0x03c5:
            r17 = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r7.addAll(r1)
            r7.addAll(r2)
            r7.addAll(r11)
            r7.addAll(r10)
            fr.c$a r1 = new fr.c$a
            r1.<init>()
            java.util.Collections.sort(r7, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r13 = 0
        L_0x03f5:
            int r10 = r7.size()
            if (r13 >= r10) goto L_0x047f
            java.lang.Object r10 = r7.get(r13)
            android.util.Pair r10 = (android.util.Pair) r10
            java.lang.Object r11 = r10.second
            boolean r14 = r11 instanceof com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo
            if (r14 == 0) goto L_0x0410
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r11 = (com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo) r11
            java.lang.String r11 = r11.getSymbol()
        L_0x040d:
            r23 = r7
            goto L_0x044b
        L_0x0410:
            boolean r14 = r11 instanceof com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo
            if (r14 == 0) goto L_0x041b
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r11 = (com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo) r11
            java.lang.String r11 = r11.getSymbol()
            goto L_0x040d
        L_0x041b:
            boolean r14 = r11 instanceof com.hbg.lib.network.index.core.bean.IndexCurrencyInfo
            if (r14 == 0) goto L_0x0426
            com.hbg.lib.network.index.core.bean.IndexCurrencyInfo r11 = (com.hbg.lib.network.index.core.bean.IndexCurrencyInfo) r11
            java.lang.String r11 = r11.getSymbol()
            goto L_0x040d
        L_0x0426:
            boolean r14 = r11 instanceof com.hbg.lib.data.future.bean.FutureContractInfo
            if (r14 == 0) goto L_0x0447
            com.hbg.lib.data.future.bean.FutureContractInfo r11 = (com.hbg.lib.data.future.bean.FutureContractInfo) r11
            java.lang.String r14 = r11.getContractCode()
            java.lang.String r15 = r11.getContractShortType()
            r23 = r7
            java.lang.String r7 = r11.getOptionCode()
            com.hbg.lib.data.symbol.TradeType r7 = com.hbg.lib.data.future.util.FutureTypeUtil.a(r14, r15, r7)
            com.hbg.lib.data.symbol.TradeType r14 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP
            if (r7 != r14) goto L_0x0449
            java.lang.String r11 = r11.getSymbol()
            goto L_0x044b
        L_0x0447:
            r23 = r7
        L_0x0449:
            java.lang.String r11 = ""
        L_0x044b:
            boolean r7 = android.text.TextUtils.isEmpty(r11)
            if (r7 == 0) goto L_0x0452
            goto L_0x0479
        L_0x0452:
            boolean r7 = r11.equals(r3)
            if (r7 == 0) goto L_0x045c
            r1.add(r10)
            goto L_0x0479
        L_0x045c:
            boolean r7 = r11.startsWith(r3)
            if (r7 == 0) goto L_0x0466
            r2.add(r10)
            goto L_0x0479
        L_0x0466:
            boolean r7 = r11.endsWith(r3)
            if (r7 == 0) goto L_0x0470
            r9.add(r10)
            goto L_0x0479
        L_0x0470:
            boolean r7 = r11.contains(r3)
            if (r7 == 0) goto L_0x0479
            r8.add(r10)
        L_0x0479:
            int r13 = r13 + 1
            r7 = r23
            goto L_0x03f5
        L_0x047f:
            r7 = r19
            r7.addAll(r4)
            r7.addAll(r5)
            gj.d r3 = gj.d.n()
            boolean r3 = r3.E()
            if (r3 == 0) goto L_0x04a3
            r7.addAll(r1)
            r7.addAll(r2)
            r7.addAll(r8)
            r7.addAll(r9)
            r7.addAll(r12)
            r7.addAll(r0)
        L_0x04a3:
            r7.addAll(r6)
            r0 = r17
            r7.addAll(r0)
            r0 = r22
            r7.addAll(r0)
            r0 = r18
            r7.addAll(r0)
            r0 = r21
            r7.addAll(r0)
            r0 = r20
            r7.addAll(r0)
            return r7
        L_0x04c0:
            r7 = r1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.c.a(android.content.Context, java.lang.String, boolean):java.util.List");
    }

    public static void b(List<String> list) {
        f84128a.clear();
        f84129b.clear();
        if (list != null && list.size() > 0) {
            Collections.sort(list);
            for (String next : list) {
                f84128a.add(a1.v().W(next));
                f84129b.add(next);
            }
        }
    }
}
