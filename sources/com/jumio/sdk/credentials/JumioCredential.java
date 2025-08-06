package com.jumio.sdk.credentials;

import com.jumio.analytics.Analytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.core.Controller;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.exceptions.SDKNotConfiguredException;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.scanpart.JumioScanPart;
import d10.l;
import java.util.List;
import java.util.TreeMap;
import jumio.core.c0;
import jumio.core.l2;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public abstract class JumioCredential {

    /* renamed from: a  reason: collision with root package name */
    public final Controller f24960a;

    /* renamed from: b  reason: collision with root package name */
    public final c0 f24961b;

    /* renamed from: c  reason: collision with root package name */
    public JumioScanPart f24962c;

    /* renamed from: d  reason: collision with root package name */
    public JumioScanPart f24963d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24964e = true;

    public static final class a extends Lambda implements l<JumioScanPart, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JumioCredential f24965a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(JumioCredential jumioCredential) {
            super(1);
            this.f24965a = jumioCredential;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0024, code lost:
            r0 = (r0 = r0.getScanPart$jumio_core_release()).getScanPartModel();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invoke(java.lang.Object r2) {
            /*
                r1 = this;
                com.jumio.sdk.scanpart.JumioScanPart r2 = (com.jumio.sdk.scanpart.JumioScanPart) r2
                com.jumio.sdk.credentials.JumioCredential r0 = r1.f24965a
                r0.f24963d = r2
                com.jumio.sdk.credentials.JumioCredential r2 = r1.f24965a
                com.jumio.sdk.scanpart.JumioScanPart r0 = r2.f24963d
                r2.setActiveScanPart$jumio_core_release(r0)
                com.jumio.sdk.credentials.JumioCredential r2 = r1.f24965a
                jumio.core.c0 r2 = r2.getData$jumio_core_release()
                com.jumio.sdk.credentials.JumioCredential r0 = r1.f24965a
                com.jumio.sdk.scanpart.JumioScanPart r0 = r0.getActiveScanPart$jumio_core_release()
                if (r0 == 0) goto L_0x002f
                com.jumio.core.scanpart.ScanPart r0 = r0.getScanPart$jumio_core_release()
                if (r0 == 0) goto L_0x002f
                com.jumio.core.models.ScanPartModel r0 = r0.getScanPartModel()
                if (r0 == 0) goto L_0x002f
                com.jumio.sdk.enums.JumioCredentialPart r0 = r0.getCredentialPart()
                goto L_0x0030
            L_0x002f:
                r0 = 0
            L_0x0030:
                r2.f56149g = r0
                kotlin.Unit r2 = kotlin.Unit.f56620a
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.sdk.credentials.JumioCredential.a.invoke(java.lang.Object):java.lang.Object");
        }
    }

    public JumioCredential(Controller controller, c0 c0Var) {
        this.f24960a = controller;
        this.f24961b = c0Var;
    }

    public void cancel() throws SDKNotConfiguredException {
        l2.b bVar;
        if (this.f24964e) {
            JumioScanPart jumioScanPart = this.f24962c;
            if (jumioScanPart != null) {
                jumioScanPart.cancel();
            }
            this.f24960a.finishCredential$jumio_core_release(this);
            this.f24964e = false;
            l2 l2Var = (l2) this.f24960a.getDataManager().get(l2.class);
            String str = this.f24961b.f56143a;
            l2Var.getClass();
            l2.a aVar = l2Var.f56243a.get(str);
            if (!(aVar == null || (bVar = aVar.f56249a) == null)) {
                if (bVar.f56251a != 0) {
                    bVar.f56252b = (System.currentTimeMillis() - bVar.f56251a) + bVar.f56252b;
                }
                bVar.f56251a = 0;
            }
            Analytics.Companion.add(MobileEvents.userAction$default("cancel_credential", (JumioScanStep) null, this.f24961b.f56143a, 2, (Object) null));
            return;
        }
        throw new SDKNotConfiguredException("Credential is not active".toString());
    }

    public void finish() throws SDKNotConfiguredException, IllegalArgumentException {
        l2.b bVar;
        if (!this.f24964e) {
            throw new SDKNotConfiguredException("Credential is not active".toString());
        } else if (isComplete()) {
            this.f24960a.finishCredential$jumio_core_release(this);
            this.f24964e = false;
            l2 l2Var = (l2) this.f24960a.getDataManager().get(l2.class);
            String str = this.f24961b.f56143a;
            l2Var.getClass();
            l2.a aVar = l2Var.f56243a.get(str);
            if (!(aVar == null || (bVar = aVar.f56249a) == null)) {
                if (bVar.f56251a != 0) {
                    bVar.f56252b = (System.currentTimeMillis() - bVar.f56251a) + bVar.f56252b;
                }
                bVar.f56251a = 0;
            }
            Analytics.Companion.add(MobileEvents.userAction$default("finish_credential", (JumioScanStep) null, this.f24961b.f56143a, 2, (Object) null));
        } else {
            throw new IllegalArgumentException("Workflow is not completed".toString());
        }
    }

    public final synchronized void finishScanPart$jumio_core_release(JumioScanPart jumioScanPart) {
        ScanPart<?> scanPart$jumio_core_release;
        JumioScanPart jumioScanPart2 = this.f24962c;
        if (!(jumioScanPart != jumioScanPart2 || jumioScanPart2 == null || (scanPart$jumio_core_release = jumioScanPart2.getScanPart$jumio_core_release()) == null)) {
            scanPart$jumio_core_release.checkForAddon(new a(this));
        }
    }

    public final JumioScanPart getActiveScanPart$jumio_core_release() {
        return this.f24962c;
    }

    public final JumioScanPart getAddonPart() {
        return this.f24963d;
    }

    public final Controller getController$jumio_core_release() {
        return this.f24960a;
    }

    public List<JumioCredentialPart> getCredentialParts() {
        return CollectionsKt___CollectionsKt.I0(this.f24961b.f56147e.keySet());
    }

    public final c0 getData$jumio_core_release() {
        return this.f24961b;
    }

    public abstract JumioScanPart initScanPart(JumioCredentialPart jumioCredentialPart, JumioScanPartInterface jumioScanPartInterface) throws IllegalStateException, IllegalArgumentException, SDKNotConfiguredException;

    public final boolean isComplete() {
        return this.f24961b.c() && this.f24962c == null;
    }

    public abstract boolean isConfigured();

    public final boolean isValid() {
        return this.f24964e;
    }

    public final void persist$jumio_core_release() {
        ScanPart<?> scanPart$jumio_core_release;
        JumioScanPart jumioScanPart = this.f24962c;
        if (jumioScanPart != null && (scanPart$jumio_core_release = jumioScanPart.getScanPart$jumio_core_release()) != null) {
            scanPart$jumio_core_release.persist();
        }
    }

    public final void setActiveScanPart$jumio_core_release(JumioScanPart jumioScanPart) {
        this.f24962c = jumioScanPart;
    }

    public final void setValid(boolean z11) {
        this.f24964e = z11;
    }

    public void start$jumio_core_release() {
        l2 l2Var = (l2) this.f24960a.getDataManager().get(l2.class);
        String str = this.f24961b.f56143a;
        l2Var.getClass();
        l2Var.f56245c = str;
        l2Var.f56246d = null;
        l2Var.f56247e = null;
        TreeMap<String, l2.a> treeMap = l2Var.f56243a;
        l2.a aVar = treeMap.get(str);
        if (aVar == null) {
            aVar = new l2.a(l2Var);
            treeMap.put(str, aVar);
        }
        l2.b bVar = aVar.f56249a;
        bVar.getClass();
        bVar.f56251a = System.currentTimeMillis();
        Analytics.Companion.add(MobileEvents.userAction$default("start_credential", (JumioScanStep) null, this.f24961b.f56143a, 2, (Object) null));
    }
}
