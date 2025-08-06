package com.hbg.module.content.ui.ability;

import androidx.lifecycle.MutableLiveData;
import b2.a;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.huobi.edgeengine.ability.AbstractAbility;
import d10.p;
import java.util.Locale;
import kotlin.Unit;
import v7.b;

public final class ContentAbility extends AbstractAbility {

    /* renamed from: a  reason: collision with root package name */
    public final HbgBaseProvider f18252a = ((HbgBaseProvider) a.d().a("/provider/content").navigation());

    /* JADX WARNING: type inference failed for: r6v5, types: [android.content.Context] */
    /* JADX WARNING: type inference failed for: r3v13, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(rj.b r17, java.lang.Object r18, com.huobi.edgeengine.ability.AbilityFunction.a r19) {
        /*
            r16 = this;
            r1 = r16
            r0 = r19
            java.lang.String r2 = "symbol"
            java.lang.String r3 = "data"
            java.lang.String r4 = "action"
            if (r0 == 0) goto L_0x0302
            if (r18 != 0) goto L_0x0010
            goto L_0x0302
        L_0x0010:
            r5 = r18
            com.eclipsesource.v8.V8Object r5 = (com.eclipsesource.v8.V8Object) r5     // Catch:{ all -> 0x02fd }
            boolean r6 = r5.contains(r4)     // Catch:{ all -> 0x02fd }
            r7 = 0
            r8 = 1
            if (r6 != r8) goto L_0x001e
            r6 = r8
            goto L_0x001f
        L_0x001e:
            r6 = r7
        L_0x001f:
            java.lang.String r9 = ""
            if (r6 == 0) goto L_0x0028
            java.lang.String r4 = r5.getString(r4)     // Catch:{ all -> 0x02fd }
            goto L_0x0029
        L_0x0028:
            r4 = r9
        L_0x0029:
            boolean r6 = r5.contains(r3)     // Catch:{ all -> 0x02fd }
            if (r6 != r8) goto L_0x0031
            r6 = r8
            goto L_0x0032
        L_0x0031:
            r6 = r7
        L_0x0032:
            if (r6 == 0) goto L_0x003a
            java.lang.String r3 = r5.getString(r3)     // Catch:{ all -> 0x02fd }
            r12 = r3
            goto L_0x003b
        L_0x003a:
            r12 = r9
        L_0x003b:
            r3 = 0
            if (r17 == 0) goto L_0x0044
            android.content.Context r6 = r17.d()     // Catch:{ all -> 0x02fd }
            r11 = r6
            goto L_0x0045
        L_0x0044:
            r11 = r3
        L_0x0045:
            if (r4 == 0) goto L_0x0301
            int r6 = r4.hashCode()     // Catch:{ all -> 0x02fd }
            r10 = 268435456(0x10000000, float:2.5243549E-29)
            java.lang.String r13 = "id"
            r14 = 0
            switch(r6) {
                case -2045796259: goto L_0x02ae;
                case -1811299503: goto L_0x0288;
                case -1145520610: goto L_0x0201;
                case -814477540: goto L_0x01eb;
                case -716853590: goto L_0x01b3;
                case -504772615: goto L_0x0173;
                case -75121853: goto L_0x015c;
                case 3321751: goto L_0x0124;
                case 26059610: goto L_0x010b;
                case 360655386: goto L_0x00f4;
                case 769456244: goto L_0x00ab;
                case 830947425: goto L_0x006d;
                case 2095504552: goto L_0x0056;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x0301
        L_0x0056:
            java.lang.String r2 = "fallColor"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x02fd }
            if (r2 != 0) goto L_0x0060
            goto L_0x0301
        L_0x0060:
            int r2 = com.hbg.lib.core.util.w.d()     // Catch:{ all -> 0x02fd }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x02fd }
            r0.a(r8, r2)     // Catch:{ all -> 0x02fd }
            goto L_0x0301
        L_0x006d:
            java.lang.String r0 = "flashDetail"
            boolean r0 = r4.equals(r0)     // Catch:{ all -> 0x02fd }
            if (r0 != 0) goto L_0x0077
            goto L_0x0301
        L_0x0077:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x00a5 }
            r0.<init>(r12)     // Catch:{ all -> 0x00a5 }
            android.content.Intent r2 = new android.content.Intent     // Catch:{ all -> 0x00a5 }
            java.lang.Class<com.hbg.module.content.ui.activity.NewsDetailActivity> r3 = com.hbg.module.content.ui.activity.NewsDetailActivity.class
            r2.<init>(r11, r3)     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "newflashId"
            long r4 = r0.getLong(r13)     // Catch:{ all -> 0x00a5 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00a5 }
            r2.putExtra(r3, r4)     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "feedCommentClick"
            java.lang.String r4 = "isComment"
            boolean r0 = r0.getBoolean(r4)     // Catch:{ all -> 0x00a5 }
            r2.putExtra(r3, r0)     // Catch:{ all -> 0x00a5 }
            r2.addFlags(r10)     // Catch:{ all -> 0x00a5 }
            if (r11 == 0) goto L_0x0301
            r11.startActivity(r2)     // Catch:{ all -> 0x00a5 }
            goto L_0x0301
        L_0x00a5:
            r0 = move-exception
            i6.d.g(r0)     // Catch:{ all -> 0x02fd }
            goto L_0x0301
        L_0x00ab:
            java.lang.String r2 = "coinPercent"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x02fd }
            if (r2 != 0) goto L_0x00b5
            goto L_0x0301
        L_0x00b5:
            sl.f0 r2 = sl.f0.g()     // Catch:{ all -> 0x02fd }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r2 = r2.h(r12)     // Catch:{ all -> 0x02fd }
            if (r2 == 0) goto L_0x00c4
            java.lang.Double r4 = r2.getClose()     // Catch:{ all -> 0x02fd }
            goto L_0x00c5
        L_0x00c4:
            r4 = r3
        L_0x00c5:
            if (r4 != 0) goto L_0x00c9
            r4 = r14
            goto L_0x00cd
        L_0x00c9:
            double r4 = r4.doubleValue()     // Catch:{ all -> 0x02fd }
        L_0x00cd:
            if (r2 == 0) goto L_0x00d3
            java.lang.Double r3 = r2.getOpen()     // Catch:{ all -> 0x02fd }
        L_0x00d3:
            if (r3 != 0) goto L_0x00d7
            r2 = r14
            goto L_0x00db
        L_0x00d7:
            double r2 = r3.doubleValue()     // Catch:{ all -> 0x02fd }
        L_0x00db:
            double r4 = r4 - r2
            int r6 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r6 != 0) goto L_0x00e1
            r7 = r8
        L_0x00e1:
            if (r7 == 0) goto L_0x00e6
            java.lang.String r2 = "0.00%"
            goto L_0x00ef
        L_0x00e6:
            double r4 = r4 / r2
            int r2 = com.hbg.lib.data.symbol.PrecisionUtil.v(r9)     // Catch:{ all -> 0x02fd }
            java.lang.String r2 = i6.m.S(r4, r2)     // Catch:{ all -> 0x02fd }
        L_0x00ef:
            r0.a(r8, r2)     // Catch:{ all -> 0x02fd }
            goto L_0x0301
        L_0x00f4:
            java.lang.String r2 = "riseColor"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x02fd }
            if (r2 != 0) goto L_0x00fe
            goto L_0x0301
        L_0x00fe:
            int r2 = com.hbg.lib.core.util.w.h()     // Catch:{ all -> 0x02fd }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x02fd }
            r0.a(r8, r2)     // Catch:{ all -> 0x02fd }
            goto L_0x0301
        L_0x010b:
            java.lang.String r2 = "getFormatTime"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x02fd }
            if (r2 != 0) goto L_0x0115
            goto L_0x0301
        L_0x0115:
            long r2 = java.lang.Long.parseLong(r12)     // Catch:{ all -> 0x02fd }
            java.lang.String r4 = "yyyy-MM-dd HH:mm"
            java.lang.String r2 = com.hbg.lib.common.utils.DateTimeUtils.h(r2, r4)     // Catch:{ all -> 0x02fd }
            r0.a(r8, r2)     // Catch:{ all -> 0x02fd }
            goto L_0x0301
        L_0x0124:
            java.lang.String r2 = "like"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x02fd }
            if (r2 != 0) goto L_0x012e
            goto L_0x0301
        L_0x012e:
            com.hbg.module.libkt.provider.HbgBaseProvider r2 = r1.f18252a     // Catch:{ all -> 0x02fd }
            if (r2 == 0) goto L_0x0301
            boolean r2 = r2.j(r11)     // Catch:{ all -> 0x02fd }
            if (r2 == 0) goto L_0x0301
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0156 }
            r2.<init>(r12)     // Catch:{ all -> 0x0156 }
            android.os.Handler r3 = new android.os.Handler     // Catch:{ all -> 0x0156 }
            r3.<init>()     // Catch:{ all -> 0x0156 }
            java.lang.String r4 = r2.getString(r13)     // Catch:{ all -> 0x0156 }
            java.lang.String r5 = "cType"
            int r2 = r2.getInt(r5)     // Catch:{ all -> 0x0156 }
            com.hbg.module.content.ui.ability.ContentAbility$call$2$1 r5 = new com.hbg.module.content.ui.ability.ContentAbility$call$2$1     // Catch:{ all -> 0x0156 }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x0156 }
            r1.d(r4, r2, r5)     // Catch:{ all -> 0x0156 }
            goto L_0x0301
        L_0x0156:
            r0 = move-exception
            i6.d.g(r0)     // Catch:{ all -> 0x02fd }
            goto L_0x0301
        L_0x015c:
            java.lang.String r2 = "getTime"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x02fd }
            if (r2 != 0) goto L_0x0166
            goto L_0x0301
        L_0x0166:
            long r2 = java.lang.Long.parseLong(r12)     // Catch:{ all -> 0x02fd }
            java.lang.String r2 = com.hbg.lib.common.utils.DateTimeUtils.A(r2)     // Catch:{ all -> 0x02fd }
            r0.a(r8, r2)     // Catch:{ all -> 0x02fd }
            goto L_0x0301
        L_0x0173:
            java.lang.String r0 = "openPage"
            boolean r0 = r4.equals(r0)     // Catch:{ all -> 0x02fd }
            if (r0 != 0) goto L_0x017d
            goto L_0x0301
        L_0x017d:
            java.lang.String r0 = "page"
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x02fd }
            java.lang.String r4 = "kline"
            boolean r0 = kotlin.jvm.internal.x.b(r0, r4)     // Catch:{ all -> 0x02fd }
            if (r0 == 0) goto L_0x0301
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x02fd }
            java.lang.String r4 = "params"
            java.lang.String r4 = r5.getString(r4)     // Catch:{ all -> 0x02fd }
            r0.<init>(r4)     // Catch:{ all -> 0x02fd }
            com.hbg.module.content.utls.g r5 = com.hbg.module.content.utls.g.f18913a     // Catch:{ all -> 0x02fd }
            if (r17 == 0) goto L_0x019e
            android.content.Context r3 = r17.d()     // Catch:{ all -> 0x02fd }
        L_0x019e:
            r6 = r3
            java.lang.String r7 = r0.getString(r2)     // Catch:{ all -> 0x02fd }
            r8 = 0
            java.lang.String r0 = r0.getString(r2)     // Catch:{ all -> 0x02fd }
            com.hbg.lib.data.symbol.TradeType r9 = com.hbg.lib.data.symbol.TradeType.getTradeTypeBySymbol(r0)     // Catch:{ all -> 0x02fd }
            java.lang.String r10 = "2"
            r5.a(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x02fd }
            goto L_0x0301
        L_0x01b3:
            java.lang.String r2 = "coinIcon"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x02fd }
            if (r2 != 0) goto L_0x01bd
            goto L_0x0301
        L_0x01bd:
            com.hbg.lib.core.BaseModuleConfig$a r2 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ all -> 0x02fd }
            java.lang.String r2 = r2.j()     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fd }
            r3.<init>()     // Catch:{ all -> 0x02fd }
            r3.append(r2)     // Catch:{ all -> 0x02fd }
            java.lang.String r2 = "/-/x/hb/p/api/contents/currency/icon/"
            r3.append(r2)     // Catch:{ all -> 0x02fd }
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{ all -> 0x02fd }
            java.lang.String r2 = r12.toLowerCase(r2)     // Catch:{ all -> 0x02fd }
            r3.append(r2)     // Catch:{ all -> 0x02fd }
            java.lang.String r2 = ".png"
            r3.append(r2)     // Catch:{ all -> 0x02fd }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x02fd }
            r0.a(r8, r2)     // Catch:{ all -> 0x02fd }
            goto L_0x0301
        L_0x01eb:
            java.lang.String r0 = "goToKline"
            boolean r0 = r4.equals(r0)     // Catch:{ all -> 0x02fd }
            if (r0 != 0) goto L_0x01f5
            goto L_0x0301
        L_0x01f5:
            com.hbg.module.content.utls.g r10 = com.hbg.module.content.utls.g.f18913a     // Catch:{ all -> 0x02fd }
            r13 = 0
            com.hbg.lib.data.symbol.TradeType r14 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ all -> 0x02fd }
            java.lang.String r15 = "6"
            r10.a(r11, r12, r13, r14, r15)     // Catch:{ all -> 0x02fd }
            goto L_0x0301
        L_0x0201:
            java.lang.String r2 = "percentColor"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x02fd }
            if (r2 != 0) goto L_0x020b
            goto L_0x0301
        L_0x020b:
            sl.f0 r2 = sl.f0.g()     // Catch:{ all -> 0x02fd }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r2 = r2.h(r12)     // Catch:{ all -> 0x02fd }
            if (r2 == 0) goto L_0x021a
            java.lang.Double r4 = r2.getClose()     // Catch:{ all -> 0x02fd }
            goto L_0x021b
        L_0x021a:
            r4 = r3
        L_0x021b:
            if (r4 != 0) goto L_0x021f
            r4 = r14
            goto L_0x0223
        L_0x021f:
            double r4 = r4.doubleValue()     // Catch:{ all -> 0x02fd }
        L_0x0223:
            if (r2 == 0) goto L_0x0229
            java.lang.Double r3 = r2.getOpen()     // Catch:{ all -> 0x02fd }
        L_0x0229:
            if (r3 != 0) goto L_0x022d
            r2 = r14
            goto L_0x0231
        L_0x022d:
            double r2 = r3.doubleValue()     // Catch:{ all -> 0x02fd }
        L_0x0231:
            double r4 = r4 - r2
            int r2 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r2 <= 0) goto L_0x023b
            int r2 = com.hbg.lib.core.util.w.h()     // Catch:{ all -> 0x02fd }
            goto L_0x0248
        L_0x023b:
            int r2 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r2 >= 0) goto L_0x0244
            int r2 = com.hbg.lib.core.util.w.d()     // Catch:{ all -> 0x02fd }
            goto L_0x0248
        L_0x0244:
            int r2 = com.hbg.lib.core.util.w.e()     // Catch:{ all -> 0x02fd }
        L_0x0248:
            if (r11 == 0) goto L_0x0301
            android.content.res.Resources r3 = r11.getResources()     // Catch:{ all -> 0x02fd }
            if (r3 == 0) goto L_0x0301
            int r2 = r3.getColor(r2)     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fd }
            r3.<init>()     // Catch:{ all -> 0x02fd }
            java.lang.String r4 = "#"
            r3.append(r4)     // Catch:{ all -> 0x02fd }
            int r4 = android.graphics.Color.red(r2)     // Catch:{ all -> 0x02fd }
            java.lang.String r4 = r1.c(r4)     // Catch:{ all -> 0x02fd }
            r3.append(r4)     // Catch:{ all -> 0x02fd }
            int r4 = android.graphics.Color.green(r2)     // Catch:{ all -> 0x02fd }
            java.lang.String r4 = r1.c(r4)     // Catch:{ all -> 0x02fd }
            r3.append(r4)     // Catch:{ all -> 0x02fd }
            int r2 = android.graphics.Color.blue(r2)     // Catch:{ all -> 0x02fd }
            java.lang.String r2 = r1.c(r2)     // Catch:{ all -> 0x02fd }
            r3.append(r2)     // Catch:{ all -> 0x02fd }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x02fd }
            r0.a(r8, r2)     // Catch:{ all -> 0x02fd }
            goto L_0x0301
        L_0x0288:
            java.lang.String r0 = "shareFlash"
            boolean r0 = r4.equals(r0)     // Catch:{ all -> 0x02fd }
            if (r0 != 0) goto L_0x0291
            goto L_0x0301
        L_0x0291:
            nc.b$a r0 = nc.b.a()     // Catch:{ all -> 0x02fd }
            if (r0 == 0) goto L_0x0301
            com.hbg.module.content.ui.ability.ContentAbility$call$$inlined$gsonToBean$1 r2 = new com.hbg.module.content.ui.ability.ContentAbility$call$$inlined$gsonToBean$1     // Catch:{ all -> 0x02fd }
            r2.<init>()     // Catch:{ all -> 0x02fd }
            java.lang.reflect.Type r2 = r2.getType()     // Catch:{ all -> 0x02fd }
            com.google.gson.Gson r3 = com.hbg.module.libkt.base.ext.f.e()     // Catch:{ all -> 0x02fd }
            java.lang.Object r2 = r3.fromJson((java.lang.String) r12, (java.lang.reflect.Type) r2)     // Catch:{ all -> 0x02fd }
            com.hbg.lib.network.hbg.core.bean.NewFlashInformation r2 = (com.hbg.lib.network.hbg.core.bean.NewFlashInformation) r2     // Catch:{ all -> 0x02fd }
            r0.a(r11, r2)     // Catch:{ all -> 0x02fd }
            goto L_0x0301
        L_0x02ae:
            java.lang.String r0 = "deepDetail"
            boolean r0 = r4.equals(r0)     // Catch:{ all -> 0x02fd }
            if (r0 != 0) goto L_0x02b7
            goto L_0x0301
        L_0x02b7:
            java.lang.String r0 = "TCP_SAT_Articlse"
            kotlin.Pair[] r2 = new kotlin.Pair[r8]     // Catch:{ all -> 0x02f8 }
            java.lang.String r3 = "contentid"
            kotlin.Pair r3 = kotlin.l.a(r3, r12)     // Catch:{ all -> 0x02f8 }
            r2[r7] = r3     // Catch:{ all -> 0x02f8 }
            java.util.HashMap r2 = kotlin.collections.MapsKt__MapsKt.j(r2)     // Catch:{ all -> 0x02f8 }
            nc.c.a(r0, r2)     // Catch:{ all -> 0x02f8 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x02f8 }
            java.lang.Class<com.hbg.lib.core.webview.HBBaseWebActivity> r2 = com.hbg.lib.core.webview.HBBaseWebActivity.class
            r0.<init>(r11, r2)     // Catch:{ all -> 0x02f8 }
            java.lang.String r2 = "url"
            com.hbg.lib.core.BaseModuleConfig$a r3 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ all -> 0x02f8 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f8 }
            r4.<init>()     // Catch:{ all -> 0x02f8 }
            java.lang.String r5 = "pretender/news-detail-long?id="
            r4.append(r5)     // Catch:{ all -> 0x02f8 }
            r4.append(r12)     // Catch:{ all -> 0x02f8 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x02f8 }
            java.lang.String r3 = r3.k(r4)     // Catch:{ all -> 0x02f8 }
            r0.putExtra(r2, r3)     // Catch:{ all -> 0x02f8 }
            r0.addFlags(r10)     // Catch:{ all -> 0x02f8 }
            if (r11 == 0) goto L_0x0301
            r11.startActivity(r0)     // Catch:{ all -> 0x02f8 }
            goto L_0x0301
        L_0x02f8:
            r0 = move-exception
            i6.d.g(r0)     // Catch:{ all -> 0x02fd }
            goto L_0x0301
        L_0x02fd:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0301:
            return
        L_0x0302:
            java.lang.String r0 = "Console"
            java.lang.String r2 = "call ContentAbility error"
            android.util.Log.d(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.ui.ability.ContentAbility.a(rj.b, java.lang.Object, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    public boolean b() {
        return false;
    }

    public final String c(int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Integer.toHexString(i11 & 255));
        while (sb2.length() < 2) {
            sb2.append("0");
        }
        return sb2.toString().toUpperCase(Locale.getDefault());
    }

    public final void d(String str, int i11, p<? super Integer, ? super Integer, Unit> pVar) {
        RequestExtKt.d(b.a().D0(str, i11), new ContentAbility$requestLike$1(pVar), ContentAbility$requestLike$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }
}
