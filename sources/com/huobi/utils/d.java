package com.huobi.utils;

import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import i6.k;
import tg.r;
import u6.g;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f83723a = new d();

    public class a extends BaseSubscriber<UserInfoData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f83724b;

        public a(b bVar) {
            this.f83724b = bVar;
        }

        /* renamed from: a */
        public void onNext(UserInfoData userInfoData) {
            super.onNext(userInfoData);
            r.x().c0(userInfoData);
            b bVar = this.f83724b;
            if (bVar != null) {
                bVar.a();
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if ((th2 instanceof APIStatusErrorException) && ((APIStatusErrorException) th2).getErrCode().equalsIgnoreCase("512")) {
                r.x().k();
            }
            k.o("global_login_auto", "使用oldUcToken登录失败: " + th2);
            b bVar = this.f83724b;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    public interface b {
        void a();

        void b();
    }

    public static d b() {
        return f83723a;
    }

    public final void a(b bVar) {
        r.x().f0(false).compose(RxJavaHelper.t((g) null)).subscribe(new a(bVar));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0102, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void c(com.huobi.utils.d.b r7, boolean r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            tg.r r0 = tg.r.x()     // Catch:{ all -> 0x0103 }
            boolean r0 = r0.F0()     // Catch:{ all -> 0x0103 }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r6)
            return
        L_0x000d:
            java.lang.String r0 = "user_config"
            java.lang.String r1 = "config_current_uid"
            java.lang.String r2 = ""
            java.lang.String r0 = com.hbg.lib.core.util.ConfigPreferences.e(r0, r1, r2)     // Catch:{ all -> 0x0103 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0103 }
            if (r1 != 0) goto L_0x00f7
            java.lang.String r1 = "user_config"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0103 }
            r2.<init>()     // Catch:{ all -> 0x0103 }
            r2.append(r0)     // Catch:{ all -> 0x0103 }
            java.lang.String r0 = "_"
            r2.append(r0)     // Catch:{ all -> 0x0103 }
            java.lang.String r0 = "config_tua"
            r2.append(r0)     // Catch:{ all -> 0x0103 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0103 }
            java.lang.String r2 = ""
            java.lang.String r0 = com.hbg.lib.core.util.ConfigPreferences.e(r1, r0, r2)     // Catch:{ all -> 0x0103 }
            java.lang.String r1 = "global_login_auto"
            java.lang.String r2 = "currentId 不为空"
            i6.k.o(r1, r2)     // Catch:{ all -> 0x0103 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0103 }
            if (r1 != 0) goto L_0x00ec
            java.lang.String r0 = com.hbg.lib.core.util.a.a(r0)     // Catch:{ all -> 0x0103 }
            com.huobi.login.utils.FingerprintHelper r1 = new com.huobi.login.utils.FingerprintHelper     // Catch:{ all -> 0x0103 }
            r1.<init>()     // Catch:{ all -> 0x0103 }
            boolean r1 = r1.d()     // Catch:{ all -> 0x0103 }
            boolean r2 = com.huobi.utils.GestureUtil.c()     // Catch:{ all -> 0x0103 }
            java.lang.String r3 = "global_login_auto"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0103 }
            r4.<init>()     // Catch:{ all -> 0x0103 }
            java.lang.String r5 = "openFingerprint :"
            r4.append(r5)     // Catch:{ all -> 0x0103 }
            r4.append(r1)     // Catch:{ all -> 0x0103 }
            java.lang.String r5 = " hasGesture:"
            r4.append(r5)     // Catch:{ all -> 0x0103 }
            r4.append(r2)     // Catch:{ all -> 0x0103 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0103 }
            i6.k.o(r3, r4)     // Catch:{ all -> 0x0103 }
            if (r1 != 0) goto L_0x00cf
            if (r2 != 0) goto L_0x00cf
            boolean r8 = tg.f.g()     // Catch:{ all -> 0x0103 }
            java.lang.String r1 = "global_login_auto"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0103 }
            r2.<init>()     // Catch:{ all -> 0x0103 }
            java.lang.String r3 = "lastLogin : "
            r2.append(r3)     // Catch:{ all -> 0x0103 }
            r2.append(r8)     // Catch:{ all -> 0x0103 }
            java.lang.String r3 = " oldToken:"
            r2.append(r3)     // Catch:{ all -> 0x0103 }
            r2.append(r0)     // Catch:{ all -> 0x0103 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0103 }
            i6.k.o(r1, r2)     // Catch:{ all -> 0x0103 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0103 }
            if (r1 != 0) goto L_0x00b5
            java.lang.String r8 = "global_login_auto"
            java.lang.String r1 = "oldToken 不为空 fetchUserInfo"
            i6.k.o(r8, r1)     // Catch:{ all -> 0x0103 }
            tg.r r8 = tg.r.x()     // Catch:{ all -> 0x0103 }
            r8.x0(r0)     // Catch:{ all -> 0x0103 }
            r6.a(r7)     // Catch:{ all -> 0x0103 }
            goto L_0x0101
        L_0x00b5:
            java.lang.String r0 = "global_login_auto"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0103 }
            r1.<init>()     // Catch:{ all -> 0x0103 }
            java.lang.String r2 = " lastLogin:"
            r1.append(r2)     // Catch:{ all -> 0x0103 }
            r1.append(r8)     // Catch:{ all -> 0x0103 }
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x0103 }
            i6.k.o(r0, r8)     // Catch:{ all -> 0x0103 }
            r7.b()     // Catch:{ all -> 0x0103 }
            goto L_0x0101
        L_0x00cf:
            java.lang.String r0 = "global_login_auto"
            java.lang.String r1 = " UserCenterActionHelper.checkLogin"
            i6.k.o(r0, r1)     // Catch:{ all -> 0x0103 }
            r7.b()     // Catch:{ all -> 0x0103 }
            if (r8 == 0) goto L_0x0101
            rn.c r7 = rn.c.i()     // Catch:{ all -> 0x0103 }
            oa.a r8 = oa.a.g()     // Catch:{ all -> 0x0103 }
            android.app.Activity r8 = r8.b()     // Catch:{ all -> 0x0103 }
            r0 = 0
            r7.d(r8, r0)     // Catch:{ all -> 0x0103 }
            goto L_0x0101
        L_0x00ec:
            java.lang.String r8 = "global_login_auto"
            java.lang.String r0 = "自动登录没有加密的UcToken"
            i6.k.o(r8, r0)     // Catch:{ all -> 0x0103 }
            r7.b()     // Catch:{ all -> 0x0103 }
            goto L_0x0101
        L_0x00f7:
            java.lang.String r8 = "global_login_auto"
            java.lang.String r0 = "自动登录没有currentId"
            i6.k.o(r8, r0)     // Catch:{ all -> 0x0103 }
            r7.b()     // Catch:{ all -> 0x0103 }
        L_0x0101:
            monitor-exit(r6)
            return
        L_0x0103:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.utils.d.c(com.huobi.utils.d$b, boolean):void");
    }
}
