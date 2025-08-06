package com.business.common.red_packet;

import android.net.Uri;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.v;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.x;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class RedPacketManager {

    /* renamed from: a  reason: collision with root package name */
    public static final RedPacketManager f64339a = new RedPacketManager();

    public static final RedPacketResult b(String str) {
        String str2;
        if (str == null) {
            str = "";
        }
        boolean z11 = true;
        if (str.length() == 0) {
            return new RedPacketResult(false, "");
        }
        try {
            Uri parse = Uri.parse(str);
            List<String> pathSegments = parse.getPathSegments();
            int size = pathSegments.size() - 1;
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    break;
                } else if (!x.b("topic", pathSegments.get(i11)) || !x.b("cryptogift", pathSegments.get(i11 + 1))) {
                    i11++;
                } else {
                    int i12 = i11 + 2;
                    if (i12 < pathSegments.size()) {
                        str2 = pathSegments.get(i12);
                    }
                }
            }
            str2 = "";
            String queryParameter = parse.getQueryParameter("key");
            if (queryParameter != null) {
                if (queryParameter.length() > 0) {
                    str2 = queryParameter;
                }
            }
            if (str2.length() <= 0) {
                z11 = false;
            }
            if (!z11) {
                return new RedPacketResult(false, "");
            }
            Log.d("RedPacket", "识别到红包口令: " + str2);
            boolean matches = new Regex("^[a-zA-Z0-9]{8}$").matches(str2);
            if (!matches) {
                LogAndWoodRecorder.a("RedPacket", "isScanRedEnvelope is invalid : " + str2);
            }
            return new RedPacketResult(matches, str2);
        } catch (Exception e11) {
            LogAndWoodRecorder.a("RedPacket", "isScanRedEnvelope on exception : " + e11.getMessage());
            return new RedPacketResult(false, "");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(java.lang.String r5, java.lang.String r6, kotlin.coroutines.c<? super java.lang.Boolean> r7) {
        /*
            boolean r0 = r7 instanceof com.business.common.red_packet.RedPacketManager$requestRedPacketCollect$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.business.common.red_packet.RedPacketManager$requestRedPacketCollect$1 r0 = (com.business.common.red_packet.RedPacketManager$requestRedPacketCollect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.common.red_packet.RedPacketManager$requestRedPacketCollect$1 r0 = new com.business.common.red_packet.RedPacketManager$requestRedPacketCollect$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r7)
            goto L_0x0047
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.k.b(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.v0.b()
            com.business.common.red_packet.RedPacketManager$requestRedPacketCollect$result$1 r2 = new com.business.common.red_packet.RedPacketManager$requestRedPacketCollect$result$1
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.g.g(r7, r2, r0)
            if (r7 != r1) goto L_0x0047
            return r1
        L_0x0047:
            com.hbg.module.libkt.base.ext.g r7 = (com.hbg.module.libkt.base.ext.g) r7
            boolean r5 = r7 instanceof com.hbg.module.libkt.base.ext.g.b
            java.lang.String r6 = "RedPacket"
            if (r5 == 0) goto L_0x0065
            com.hbg.module.libkt.base.ext.g$b r7 = (com.hbg.module.libkt.base.ext.g.b) r7
            java.lang.Object r5 = r7.a()
            com.hbg.lib.network.hbg.core.bean.RedPacketCollectBean r5 = (com.hbg.lib.network.hbg.core.bean.RedPacketCollectBean) r5
            if (r5 == 0) goto L_0x005e
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r3)
            return r5
        L_0x005e:
            java.lang.String r5 = "requestRedPacketCollect-Data is null"
            com.hbg.lib.common.utils.LogAndWoodRecorder.a(r6, r5)
            goto L_0x012a
        L_0x0065:
            boolean r5 = r7 instanceof com.hbg.module.libkt.base.ext.g.a
            if (r5 == 0) goto L_0x012a
            com.hbg.module.libkt.base.ext.g$a r7 = (com.hbg.module.libkt.base.ext.g.a) r7
            com.hbg.lib.network.retrofit.exception.APIStatusErrorException r5 = r7.a()
            r0 = 41
            if (r5 == 0) goto L_0x0104
            java.lang.String r1 = "4009"
            java.lang.String r2 = "4010"
            java.lang.String r4 = "4011"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2, r4}
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.n(r1)
            java.lang.String r2 = r5.getErrCode()
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x0090
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r3)
            return r5
        L_0x0090:
            java.lang.String r1 = r5.getErrCode()
            if (r1 == 0) goto L_0x00d6
            int r2 = r1.hashCode()
            r3 = 1596801(0x185d81, float:2.237595E-39)
            if (r2 == r3) goto L_0x00c8
            r3 = 1596829(0x185d9d, float:2.237634E-39)
            if (r2 == r3) goto L_0x00b9
            r3 = 1596832(0x185da0, float:2.237638E-39)
            if (r2 == r3) goto L_0x00aa
            goto L_0x00d6
        L_0x00aa:
            java.lang.String r2 = "4015"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00b3
            goto L_0x00d6
        L_0x00b3:
            int r1 = com.business.common.R$string.n_c2c_red_packet_have_failed_verification
            com.hbg.lib.widgets.utils.HuobiToastUtil.j(r1)
            goto L_0x00dd
        L_0x00b9:
            java.lang.String r2 = "4012"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00c2
            goto L_0x00d6
        L_0x00c2:
            int r1 = com.business.common.R$string.n_c2c_red_packet_for_new_users
            com.hbg.lib.widgets.utils.HuobiToastUtil.j(r1)
            goto L_0x00dd
        L_0x00c8:
            java.lang.String r2 = "4005"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00d6
            int r1 = com.business.common.R$string.n_c2c_red_packet_not_claimable
            com.hbg.lib.widgets.utils.HuobiToastUtil.j(r1)
            goto L_0x00dd
        L_0x00d6:
            java.lang.String r1 = r5.getErrMsg()
            com.hbg.lib.widgets.utils.HuobiToastUtil.m(r1)
        L_0x00dd:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "requestRedPacketCollect-APIError(Code:"
            r1.append(r2)
            java.lang.String r2 = r5.getErrCode()
            r1.append(r2)
            java.lang.String r2 = ",Msg:"
            r1.append(r2)
            java.lang.String r5 = r5.getErrMsg()
            r1.append(r5)
            r1.append(r0)
            java.lang.String r5 = r1.toString()
            com.hbg.lib.common.utils.LogAndWoodRecorder.a(r6, r5)
        L_0x0104:
            java.lang.Throwable r5 = r7.b()
            if (r5 == 0) goto L_0x012a
            int r7 = com.business.common.R$string.n_service_error
            com.hbg.lib.widgets.utils.HuobiToastUtil.j(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "requestRedPacketCollect-OtherError(Msg:"
            r7.append(r1)
            java.lang.String r5 = r5.getMessage()
            r7.append(r5)
            r7.append(r0)
            java.lang.String r5 = r7.toString()
            com.hbg.lib.common.utils.LogAndWoodRecorder.a(r6, r5)
        L_0x012a:
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common.red_packet.RedPacketManager.c(java.lang.String, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    public static final void d(FragmentActivity fragmentActivity, String str) {
        f64339a.a(fragmentActivity, v.a(fragmentActivity), str);
    }

    public final void a(FragmentActivity fragmentActivity, LifecycleCoroutineScope lifecycleCoroutineScope, String str) {
        n1 unused = i.d(lifecycleCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new RedPacketManager$actualRequest$1(fragmentActivity, str, fragmentActivity.getSupportFragmentManager(), (c<? super RedPacketManager$actualRequest$1>) null), 3, (Object) null);
    }
}
