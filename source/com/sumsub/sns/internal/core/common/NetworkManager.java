package com.sumsub.sns.internal.core.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import androidx.core.content.ContextCompat;
import com.sumsub.sns.internal.log.c;
import d10.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.Lambda;

public final class NetworkManager {

    /* renamed from: a  reason: collision with root package name */
    public Context f31960a;

    /* renamed from: b  reason: collision with root package name */
    public final i f31961b = LazyKt__LazyJVMKt.a(new a(this));

    /* renamed from: c  reason: collision with root package name */
    public l<? super NetworkType, Unit> f31962c;

    /* renamed from: d  reason: collision with root package name */
    public final b f31963d = new b(this);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/internal/core/common/NetworkManager$NetworkType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "OTHER", "WIFI", "MOBILE", "ETHERNET", "M_2G", "M_3G", "M_4G", "M_5G", "LTE", "NONE", "NO_PERMISSION", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum NetworkType {
        OTHER("Other"),
        WIFI("WiFi"),
        MOBILE("Mobile"),
        ETHERNET("Ethernet"),
        M_2G("2G"),
        M_3G("3G"),
        M_4G("4G"),
        M_5G("5G"),
        LTE("LTE"),
        NONE("None"),
        NO_PERMISSION("No permission");
        
        private final String type;

        private NetworkType(String str) {
            this.type = str;
        }

        public final String getType() {
            return this.type;
        }
    }

    public static final class a extends Lambda implements d10.a<ConnectivityManager> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NetworkManager f31964a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(NetworkManager networkManager) {
            super(0);
            this.f31964a = networkManager;
        }

        /* renamed from: a */
        public final ConnectivityManager invoke() {
            Context a11 = this.f31964a.f31960a;
            return (ConnectivityManager) (a11 != null ? a11.getSystemService("connectivity") : null);
        }
    }

    public static final class b extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NetworkManager f31965a;

        public b(NetworkManager networkManager) {
            this.f31965a = networkManager;
        }

        public void onAvailable(Network network) {
            super.onAvailable(network);
            try {
                l<NetworkType, Unit> a11 = this.f31965a.a();
                if (a11 != null) {
                    NetworkManager networkManager = this.f31965a;
                    a11.invoke(networkManager.a(networkManager.f31960a));
                }
            } catch (Throwable th2) {
                com.sumsub.sns.internal.log.b.b(com.sumsub.sns.internal.log.a.f34862a, c.a(this), "Ooops", th2);
            }
        }

        public void onLost(Network network) {
            super.onLost(network);
            try {
                l<NetworkType, Unit> a11 = this.f31965a.a();
                if (a11 != null) {
                    NetworkManager networkManager = this.f31965a;
                    a11.invoke(networkManager.a(networkManager.f31960a));
                }
            } catch (Throwable th2) {
                com.sumsub.sns.internal.log.b.b(com.sumsub.sns.internal.log.a.f34862a, c.a(this), "Ooops", th2);
            }
        }
    }

    public final ConnectivityManager b() {
        return (ConnectivityManager) this.f31961b.getValue();
    }

    public final void c() {
        ConnectivityManager b11;
        try {
            Context context = this.f31960a;
            if (context != null && a(context, "android.permission.CHANGE_NETWORK_STATE") && (b11 = b()) != null) {
                b11.unregisterNetworkCallback(this.f31963d);
            }
        } catch (Exception e11) {
            com.sumsub.sns.internal.log.b.b(com.sumsub.sns.internal.log.a.f34862a, c.a(this), "Can't stop network manager", e11);
        }
    }

    public final l<NetworkType, Unit> a() {
        return this.f31962c;
    }

    public final void a(l<? super NetworkType, Unit> lVar) {
        this.f31962c = lVar;
    }

    public final void a(Context context, l<? super NetworkType, Unit> lVar) {
        this.f31960a = context;
        try {
            if (!a(context, "android.permission.CHANGE_NETWORK_STATE")) {
                lVar.invoke(NetworkType.NO_PERMISSION);
                return;
            }
            this.f31962c = lVar;
            NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
            ConnectivityManager b11 = b();
            if (b11 != null) {
                b11.requestNetwork(build, this.f31963d);
            }
        } catch (Throwable th2) {
            com.sumsub.sns.internal.log.b.b(com.sumsub.sns.internal.log.a.f34862a, c.a(this), "Can't start network manager", th2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x007f, code lost:
        r7 = r7.getActiveNetworkInfo();
     */
    @android.annotation.SuppressLint({"MissingPermission"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.sumsub.sns.internal.core.common.NetworkManager.NetworkType a(android.content.Context r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0005
            com.sumsub.sns.internal.core.common.NetworkManager$NetworkType r7 = com.sumsub.sns.internal.core.common.NetworkManager.NetworkType.NONE     // Catch:{ all -> 0x00aa }
            return r7
        L_0x0005:
            java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r0 = r6.a((android.content.Context) r7, (java.lang.String) r0)     // Catch:{ all -> 0x00aa }
            if (r0 != 0) goto L_0x0010
            com.sumsub.sns.internal.core.common.NetworkManager$NetworkType r7 = com.sumsub.sns.internal.core.common.NetworkManager.NetworkType.NO_PERMISSION     // Catch:{ all -> 0x00aa }
            return r7
        L_0x0010:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00aa }
            r1 = 23
            r2 = 1
            if (r0 < r1) goto L_0x0079
            android.net.ConnectivityManager r1 = r6.b()     // Catch:{ all -> 0x00aa }
            if (r1 == 0) goto L_0x0076
            android.net.Network r1 = r1.getActiveNetwork()     // Catch:{ all -> 0x00aa }
            if (r1 != 0) goto L_0x0024
            goto L_0x0076
        L_0x0024:
            android.net.ConnectivityManager r3 = r6.b()     // Catch:{ all -> 0x00aa }
            if (r3 == 0) goto L_0x0073
            android.net.NetworkCapabilities r1 = r3.getNetworkCapabilities(r1)     // Catch:{ all -> 0x00aa }
            if (r1 != 0) goto L_0x0031
            goto L_0x0073
        L_0x0031:
            boolean r2 = r1.hasTransport(r2)     // Catch:{ all -> 0x00aa }
            if (r2 == 0) goto L_0x003a
            com.sumsub.sns.internal.core.common.NetworkManager$NetworkType r7 = com.sumsub.sns.internal.core.common.NetworkManager.NetworkType.WIFI     // Catch:{ all -> 0x00aa }
            return r7
        L_0x003a:
            r2 = 3
            boolean r2 = r1.hasTransport(r2)     // Catch:{ all -> 0x00aa }
            if (r2 == 0) goto L_0x0044
            com.sumsub.sns.internal.core.common.NetworkManager$NetworkType r7 = com.sumsub.sns.internal.core.common.NetworkManager.NetworkType.ETHERNET     // Catch:{ all -> 0x00aa }
            return r7
        L_0x0044:
            r2 = 0
            boolean r1 = r1.hasTransport(r2)     // Catch:{ all -> 0x00aa }
            if (r1 == 0) goto L_0x0070
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            boolean r1 = r6.a((android.content.Context) r7, (java.lang.String) r1)     // Catch:{ all -> 0x00aa }
            if (r1 == 0) goto L_0x006d
            java.lang.String r1 = "phone"
            java.lang.Object r7 = r7.getSystemService(r1)     // Catch:{ all -> 0x00aa }
            android.telephony.TelephonyManager r7 = (android.telephony.TelephonyManager) r7     // Catch:{ all -> 0x00aa }
            r1 = 24
            if (r0 < r1) goto L_0x0064
            int r7 = r7.getDataNetworkType()     // Catch:{ all -> 0x00aa }
            goto L_0x0068
        L_0x0064:
            int r7 = r7.getNetworkType()     // Catch:{ all -> 0x00aa }
        L_0x0068:
            com.sumsub.sns.internal.core.common.NetworkManager$NetworkType r7 = r6.a((int) r7)     // Catch:{ all -> 0x00aa }
            goto L_0x0072
        L_0x006d:
            com.sumsub.sns.internal.core.common.NetworkManager$NetworkType r7 = com.sumsub.sns.internal.core.common.NetworkManager.NetworkType.NONE     // Catch:{ all -> 0x00aa }
            goto L_0x0072
        L_0x0070:
            com.sumsub.sns.internal.core.common.NetworkManager$NetworkType r7 = com.sumsub.sns.internal.core.common.NetworkManager.NetworkType.OTHER     // Catch:{ all -> 0x00aa }
        L_0x0072:
            return r7
        L_0x0073:
            com.sumsub.sns.internal.core.common.NetworkManager$NetworkType r7 = com.sumsub.sns.internal.core.common.NetworkManager.NetworkType.NONE     // Catch:{ all -> 0x00aa }
            return r7
        L_0x0076:
            com.sumsub.sns.internal.core.common.NetworkManager$NetworkType r7 = com.sumsub.sns.internal.core.common.NetworkManager.NetworkType.OTHER     // Catch:{ all -> 0x00aa }
            return r7
        L_0x0079:
            android.net.ConnectivityManager r7 = r6.b()     // Catch:{ all -> 0x00aa }
            if (r7 == 0) goto L_0x008e
            android.net.NetworkInfo r7 = r7.getActiveNetworkInfo()     // Catch:{ all -> 0x00aa }
            if (r7 == 0) goto L_0x008e
            int r7 = r7.getType()     // Catch:{ all -> 0x00aa }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x00aa }
            goto L_0x008f
        L_0x008e:
            r7 = 0
        L_0x008f:
            if (r7 != 0) goto L_0x0092
            goto L_0x009b
        L_0x0092:
            int r0 = r7.intValue()     // Catch:{ all -> 0x00aa }
            if (r0 != r2) goto L_0x009b
            com.sumsub.sns.internal.core.common.NetworkManager$NetworkType r7 = com.sumsub.sns.internal.core.common.NetworkManager.NetworkType.WIFI     // Catch:{ all -> 0x00aa }
            goto L_0x00a9
        L_0x009b:
            if (r7 != 0) goto L_0x009e
            goto L_0x00a7
        L_0x009e:
            int r7 = r7.intValue()     // Catch:{ all -> 0x00aa }
            if (r7 != 0) goto L_0x00a7
            com.sumsub.sns.internal.core.common.NetworkManager$NetworkType r7 = com.sumsub.sns.internal.core.common.NetworkManager.NetworkType.MOBILE     // Catch:{ all -> 0x00aa }
            goto L_0x00a9
        L_0x00a7:
            com.sumsub.sns.internal.core.common.NetworkManager$NetworkType r7 = com.sumsub.sns.internal.core.common.NetworkManager.NetworkType.OTHER     // Catch:{ all -> 0x00aa }
        L_0x00a9:
            return r7
        L_0x00aa:
            com.sumsub.sns.internal.log.a r0 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r1 = com.sumsub.sns.internal.log.c.a(r6)
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r2 = "Error while getting network type"
            com.sumsub.sns.internal.log.b.b(r0, r1, r2, r3, r4, r5)
            com.sumsub.sns.internal.core.common.NetworkManager$NetworkType r7 = com.sumsub.sns.internal.core.common.NetworkManager.NetworkType.NONE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.NetworkManager.a(android.content.Context):com.sumsub.sns.internal.core.common.NetworkManager$NetworkType");
    }

    public final NetworkType a(int i11) {
        switch (i11) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkType.M_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return NetworkType.M_3G;
            case 13:
                return NetworkType.LTE;
            case 18:
                return NetworkType.M_4G;
            case 20:
                return NetworkType.M_5G;
            default:
                return NetworkType.OTHER;
        }
    }

    public final boolean a(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }
}
