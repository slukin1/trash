package com.jumio.sdk.credentials;

import com.jumio.core.Controller;
import com.jumio.core.data.ScanMode;
import com.jumio.core.models.FaceScanPartModel;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.scanpart.JumioScanPart;
import jumio.core.e0;

public final class JumioFaceCredential extends JumioCredential {

    /* renamed from: f  reason: collision with root package name */
    public final boolean f24970f = true;

    public JumioFaceCredential(Controller controller, e0 e0Var) {
        super(controller, e0Var);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.jumio.sdk.scanpart.JumioScanPart initScanPart(com.jumio.sdk.enums.JumioCredentialPart r12, com.jumio.sdk.interfaces.JumioScanPartInterface r13) throws java.lang.IllegalArgumentException {
        /*
            r11 = this;
            monitor-enter(r11)
            jumio.core.c0 r0 = r11.getData$jumio_core_release()     // Catch:{ all -> 0x015a }
            java.util.SortedMap r0 = r0.b()     // Catch:{ all -> 0x015a }
            boolean r0 = r0.containsKey(r12)     // Catch:{ all -> 0x015a }
            if (r0 == 0) goto L_0x013f
            com.jumio.core.Controller r0 = r11.getController$jumio_core_release()     // Catch:{ all -> 0x015a }
            jumio.core.e2 r0 = r0.getPluginRegistry()     // Catch:{ all -> 0x015a }
            jumio.core.d2 r1 = jumio.core.d2.FACE_IPROOV     // Catch:{ all -> 0x015a }
            com.jumio.core.plugins.Plugin r0 = r0.a((jumio.core.d2) r1)     // Catch:{ all -> 0x015a }
            com.jumio.core.plugins.ScanPartPlugin r0 = (com.jumio.core.plugins.ScanPartPlugin) r0     // Catch:{ all -> 0x015a }
            com.jumio.core.Controller r1 = r11.getController$jumio_core_release()     // Catch:{ all -> 0x015a }
            jumio.core.e2 r1 = r1.getPluginRegistry()     // Catch:{ all -> 0x015a }
            jumio.core.d2 r2 = jumio.core.d2.JUMIO_LIVENESS     // Catch:{ all -> 0x015a }
            com.jumio.core.plugins.Plugin r1 = r1.a((jumio.core.d2) r2)     // Catch:{ all -> 0x015a }
            com.jumio.core.plugins.ScanPartPlugin r1 = (com.jumio.core.plugins.ScanPartPlugin) r1     // Catch:{ all -> 0x015a }
            jumio.core.c0 r2 = r11.getData$jumio_core_release()     // Catch:{ all -> 0x015a }
            java.util.SortedMap<com.jumio.sdk.enums.JumioCredentialPart, com.jumio.core.models.ScanPartModel> r2 = r2.f56147e     // Catch:{ all -> 0x015a }
            java.lang.Object r2 = r2.get(r12)     // Catch:{ all -> 0x015a }
            com.jumio.core.models.FaceScanPartModel r2 = (com.jumio.core.models.FaceScanPartModel) r2     // Catch:{ all -> 0x015a }
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x008e
            com.jumio.core.Controller r5 = r11.getController$jumio_core_release()     // Catch:{ all -> 0x015a }
            jumio.core.c0 r6 = r11.getData$jumio_core_release()     // Catch:{ all -> 0x015a }
            java.util.SortedMap<com.jumio.sdk.enums.JumioCredentialPart, com.jumio.core.models.ScanPartModel> r6 = r6.f56147e     // Catch:{ all -> 0x015a }
            java.lang.Object r6 = r6.get(r12)     // Catch:{ all -> 0x015a }
            com.jumio.core.models.ScanPartModel r6 = (com.jumio.core.models.ScanPartModel) r6     // Catch:{ all -> 0x015a }
            boolean r5 = r0.isUsable(r5, r6)     // Catch:{ all -> 0x015a }
            if (r5 == 0) goto L_0x008e
            r5 = 2
            jumio.core.r1[] r6 = new jumio.core.r1[r5]     // Catch:{ all -> 0x015a }
            jumio.core.r1 r7 = jumio.core.r1.IPROOV_STANDARD     // Catch:{ all -> 0x015a }
            r6[r4] = r7     // Catch:{ all -> 0x015a }
            jumio.core.r1 r7 = jumio.core.r1.IPROOV_PREMIUM     // Catch:{ all -> 0x015a }
            r6[r3] = r7     // Catch:{ all -> 0x015a }
            jumio.core.c0 r7 = r11.getData$jumio_core_release()     // Catch:{ all -> 0x015a }
            jumio.core.e0 r7 = (jumio.core.e0) r7     // Catch:{ all -> 0x015a }
            java.util.List<jumio.core.r1> r8 = r7.f56181h     // Catch:{ all -> 0x015a }
            if (r8 == 0) goto L_0x0073
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x015a }
            if (r8 == 0) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            r8 = r4
            goto L_0x0074
        L_0x0073:
            r8 = r3
        L_0x0074:
            if (r8 == 0) goto L_0x0077
            goto L_0x0084
        L_0x0077:
            r8 = r4
        L_0x0078:
            if (r8 >= r5) goto L_0x0089
            r9 = r6[r8]     // Catch:{ all -> 0x015a }
            java.util.List<jumio.core.r1> r10 = r7.f56181h     // Catch:{ all -> 0x015a }
            boolean r9 = r10.contains(r9)     // Catch:{ all -> 0x015a }
            if (r9 == 0) goto L_0x0086
        L_0x0084:
            r5 = r3
            goto L_0x008a
        L_0x0086:
            int r8 = r8 + 1
            goto L_0x0078
        L_0x0089:
            r5 = r4
        L_0x008a:
            if (r5 == 0) goto L_0x008e
            r5 = r3
            goto L_0x008f
        L_0x008e:
            r5 = r4
        L_0x008f:
            if (r5 == 0) goto L_0x00a0
            com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.FACE_IPROOV     // Catch:{ all -> 0x015a }
            r2.setMode(r1)     // Catch:{ all -> 0x015a }
            com.jumio.core.Controller r1 = r11.getController$jumio_core_release()     // Catch:{ all -> 0x015a }
            com.jumio.core.scanpart.ScanPart r13 = r0.getScanPart(r1, r11, r2, r13)     // Catch:{ all -> 0x015a }
            goto L_0x012a
        L_0x00a0:
            if (r1 == 0) goto L_0x00e5
            com.jumio.core.Controller r0 = r11.getController$jumio_core_release()     // Catch:{ all -> 0x015a }
            jumio.core.c0 r5 = r11.getData$jumio_core_release()     // Catch:{ all -> 0x015a }
            java.util.SortedMap<com.jumio.sdk.enums.JumioCredentialPart, com.jumio.core.models.ScanPartModel> r5 = r5.f56147e     // Catch:{ all -> 0x015a }
            java.lang.Object r5 = r5.get(r12)     // Catch:{ all -> 0x015a }
            com.jumio.core.models.ScanPartModel r5 = (com.jumio.core.models.ScanPartModel) r5     // Catch:{ all -> 0x015a }
            boolean r0 = r1.isUsable(r0, r5)     // Catch:{ all -> 0x015a }
            if (r0 == 0) goto L_0x00e5
            jumio.core.r1[] r0 = new jumio.core.r1[r3]     // Catch:{ all -> 0x015a }
            jumio.core.r1 r5 = jumio.core.r1.JUMIO_LIVENESS     // Catch:{ all -> 0x015a }
            r0[r4] = r5     // Catch:{ all -> 0x015a }
            jumio.core.c0 r5 = r11.getData$jumio_core_release()     // Catch:{ all -> 0x015a }
            jumio.core.e0 r5 = (jumio.core.e0) r5     // Catch:{ all -> 0x015a }
            java.util.List<jumio.core.r1> r6 = r5.f56181h     // Catch:{ all -> 0x015a }
            if (r6 == 0) goto L_0x00d1
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x015a }
            if (r6 == 0) goto L_0x00cf
            goto L_0x00d1
        L_0x00cf:
            r6 = r4
            goto L_0x00d2
        L_0x00d1:
            r6 = r3
        L_0x00d2:
            if (r6 == 0) goto L_0x00d5
            goto L_0x00df
        L_0x00d5:
            r0 = r0[r4]     // Catch:{ all -> 0x015a }
            java.util.List<jumio.core.r1> r5 = r5.f56181h     // Catch:{ all -> 0x015a }
            boolean r0 = r5.contains(r0)     // Catch:{ all -> 0x015a }
            if (r0 == 0) goto L_0x00e1
        L_0x00df:
            r0 = r3
            goto L_0x00e2
        L_0x00e1:
            r0 = r4
        L_0x00e2:
            if (r0 == 0) goto L_0x00e5
            goto L_0x00e6
        L_0x00e5:
            r3 = r4
        L_0x00e6:
            if (r3 == 0) goto L_0x011b
            jumio.core.c0 r0 = r11.getData$jumio_core_release()     // Catch:{ all -> 0x015a }
            java.util.SortedMap<com.jumio.sdk.enums.JumioCredentialPart, com.jumio.core.models.ScanPartModel> r0 = r0.f56147e     // Catch:{ all -> 0x015a }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x015a }
            boolean r0 = r0 instanceof com.jumio.core.models.LivenessScanPartModel     // Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0106
            jumio.core.c0 r0 = r11.getData$jumio_core_release()     // Catch:{ all -> 0x015a }
            java.util.SortedMap<com.jumio.sdk.enums.JumioCredentialPart, com.jumio.core.models.ScanPartModel> r0 = r0.f56147e     // Catch:{ all -> 0x015a }
            com.jumio.core.models.LivenessScanPartModel r2 = new com.jumio.core.models.LivenessScanPartModel     // Catch:{ all -> 0x015a }
            com.jumio.core.data.ScanMode r3 = com.jumio.core.data.ScanMode.JUMIO_LIVENESS     // Catch:{ all -> 0x015a }
            r2.<init>(r3)     // Catch:{ all -> 0x015a }
            r0.put(r12, r2)     // Catch:{ all -> 0x015a }
        L_0x0106:
            com.jumio.core.Controller r0 = r11.getController$jumio_core_release()     // Catch:{ all -> 0x015a }
            jumio.core.c0 r2 = r11.getData$jumio_core_release()     // Catch:{ all -> 0x015a }
            java.util.SortedMap<com.jumio.sdk.enums.JumioCredentialPart, com.jumio.core.models.ScanPartModel> r2 = r2.f56147e     // Catch:{ all -> 0x015a }
            java.lang.Object r2 = r2.get(r12)     // Catch:{ all -> 0x015a }
            com.jumio.core.models.LivenessScanPartModel r2 = (com.jumio.core.models.LivenessScanPartModel) r2     // Catch:{ all -> 0x015a }
            com.jumio.core.scanpart.ScanPart r13 = r1.getScanPart(r0, r11, r2, r13)     // Catch:{ all -> 0x015a }
            goto L_0x012a
        L_0x011b:
            com.jumio.core.data.ScanMode r0 = com.jumio.core.data.ScanMode.FACE_MANUAL     // Catch:{ all -> 0x015a }
            r2.setMode(r0)     // Catch:{ all -> 0x015a }
            com.jumio.core.scanpart.FaceScanPart r0 = new com.jumio.core.scanpart.FaceScanPart     // Catch:{ all -> 0x015a }
            com.jumio.core.Controller r1 = r11.getController$jumio_core_release()     // Catch:{ all -> 0x015a }
            r0.<init>(r1, r11, r2, r13)     // Catch:{ all -> 0x015a }
            r13 = r0
        L_0x012a:
            jumio.core.c0 r0 = r11.getData$jumio_core_release()     // Catch:{ all -> 0x015a }
            r0.a((com.jumio.sdk.enums.JumioCredentialPart) r12)     // Catch:{ all -> 0x015a }
            com.jumio.sdk.scanpart.JumioScanPart r12 = new com.jumio.sdk.scanpart.JumioScanPart     // Catch:{ all -> 0x015a }
            r12.<init>(r13)     // Catch:{ all -> 0x015a }
            r11.setActiveScanPart$jumio_core_release(r12)     // Catch:{ all -> 0x015a }
            com.jumio.sdk.scanpart.JumioScanPart r12 = r11.getActiveScanPart$jumio_core_release()     // Catch:{ all -> 0x015a }
            monitor-exit(r11)
            return r12
        L_0x013f:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x015a }
            r13.<init>()     // Catch:{ all -> 0x015a }
            r13.append(r12)     // Catch:{ all -> 0x015a }
            java.lang.String r12 = " not found"
            r13.append(r12)     // Catch:{ all -> 0x015a }
            java.lang.String r12 = r13.toString()     // Catch:{ all -> 0x015a }
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x015a }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x015a }
            r13.<init>(r12)     // Catch:{ all -> 0x015a }
            throw r13     // Catch:{ all -> 0x015a }
        L_0x015a:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.sdk.credentials.JumioFaceCredential.initScanPart(com.jumio.sdk.enums.JumioCredentialPart, com.jumio.sdk.interfaces.JumioScanPartInterface):com.jumio.sdk.scanpart.JumioScanPart");
    }

    public boolean isConfigured() {
        return this.f24970f;
    }

    public void start$jumio_core_release() {
        super.start$jumio_core_release();
        getData$jumio_core_release().f56147e.put(JumioCredentialPart.FACE, new FaceScanPartModel(ScanMode.FACE_MANUAL));
    }

    public final synchronized JumioScanPart initScanPart(JumioScanPartInterface jumioScanPartInterface) {
        return initScanPart(getData$jumio_core_release().f56147e.firstKey(), jumioScanPartInterface);
    }
}
