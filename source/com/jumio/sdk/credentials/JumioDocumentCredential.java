package com.jumio.sdk.credentials;

import com.facebook.appevents.UserDataStore;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.core.Controller;
import com.jumio.core.data.ScanMode;
import com.jumio.core.data.document.Document;
import com.jumio.core.models.DocumentModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.sdk.enums.JumioAcquireMode;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.scanpart.JumioScanPart;
import java.util.List;
import java.util.SortedMap;
import jumio.core.d0;
import jumio.core.k1;
import jumio.core.y0;
import jumio.core.z0;
import kotlin.NoWhenBranchMatchedException;

public final class JumioDocumentCredential extends JumioCredential {

    /* renamed from: f  reason: collision with root package name */
    public JumioAcquireMode f24968f;

    /* renamed from: g  reason: collision with root package name */
    public final List<JumioAcquireMode> f24969g;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.jumio.sdk.enums.JumioAcquireMode[] r0 = com.jumio.sdk.enums.JumioAcquireMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.enums.JumioAcquireMode r1 = com.jumio.sdk.enums.JumioAcquireMode.CAMERA     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.jumio.sdk.enums.JumioAcquireMode r1 = com.jumio.sdk.enums.JumioAcquireMode.FILE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.sdk.credentials.JumioDocumentCredential.WhenMappings.<clinit>():void");
        }
    }

    public JumioDocumentCredential(Controller controller, d0 d0Var) {
        super(controller, d0Var);
        List p11 = CollectionsKt__CollectionsKt.p(JumioAcquireMode.CAMERA);
        if (((SettingsModel) controller.getDataManager().get(SettingsModel.class)).getDvFileUploadEnabled()) {
            p11.add(JumioAcquireMode.FILE);
        }
        List<JumioAcquireMode> I0 = CollectionsKt___CollectionsKt.I0(p11);
        this.f24969g = I0;
        if (I0.size() == 1) {
            setConfiguration((JumioAcquireMode) CollectionsKt___CollectionsKt.a0(I0));
        }
    }

    public final void a(JumioAcquireMode jumioAcquireMode) {
        String str;
        z0 z0Var;
        String str2;
        d0 d0Var = (d0) getData$jumio_core_release();
        List<String> list = d0Var.f56158h;
        String str3 = "";
        if (list == null || (str = list.get(0)) == null) {
            str = str3;
        }
        DocumentModel documentModel = (DocumentModel) getController$jumio_core_release().getDataManager().get(DocumentModel.class);
        List<String> list2 = d0Var.f56159i;
        if (!(list2 == null || (str2 = list2.get(0)) == null)) {
            str3 = str2;
        }
        Document a11 = documentModel.a(str3);
        if (a11 != null) {
            getData$jumio_core_release().f56147e.clear();
            SortedMap<JumioCredentialPart, ScanPartModel> sortedMap = getData$jumio_core_release().f56147e;
            JumioCredentialPart jumioCredentialPart = JumioCredentialPart.DOCUMENT;
            int i11 = WhenMappings.$EnumSwitchMapping$0[jumioAcquireMode.ordinal()];
            if (i11 == 1) {
                z0Var = new z0(jumioCredentialPart, ScanMode.MANUAL, str, a11);
            } else if (i11 == 2) {
                z0Var = new z0(jumioCredentialPart, ScanMode.FILE, str, a11);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            sortedMap.put(jumioCredentialPart, z0Var);
            MetaInfo metaInfo = new MetaInfo();
            metaInfo.put(UserDataStore.COUNTRY, str);
            metaInfo.put("type", a11.getCode());
            metaInfo.put("additionalData", jumioAcquireMode.toString());
            Analytics.Companion.add(MobileEvents.userAction$default("configuration", (JumioScanStep) null, metaInfo, 2, (Object) null));
            return;
        }
        throw new IllegalArgumentException("Document could not be found");
    }

    public final List<JumioAcquireMode> getAvailableAcquireModes() {
        return this.f24969g;
    }

    public synchronized JumioScanPart initScanPart(JumioCredentialPart jumioCredentialPart, JumioScanPartInterface jumioScanPartInterface) {
        JumioScanPart jumioScanPart;
        ScanPart scanPart;
        ScanPartModel scanPartModel = getData$jumio_core_release().b().get(jumioCredentialPart);
        if (scanPartModel != null) {
            if (scanPartModel.getMode() == ScanMode.FILE) {
                scanPart = new k1(getController$jumio_core_release(), this, (z0) scanPartModel, jumioScanPartInterface);
            } else {
                scanPart = new y0(getController$jumio_core_release(), this, scanPartModel, jumioScanPartInterface);
            }
            jumioScanPart = new JumioScanPart(scanPart);
            getData$jumio_core_release().a(jumioCredentialPart);
            setActiveScanPart$jumio_core_release(jumioScanPart);
        } else {
            throw new IllegalArgumentException((jumioCredentialPart + " not found").toString());
        }
        return jumioScanPart;
    }

    public boolean isConfigured() {
        return this.f24968f != null;
    }

    public final boolean isSupportedConfiguration(JumioAcquireMode jumioAcquireMode) {
        if (!isValid()) {
            return false;
        }
        return this.f24969g.contains(jumioAcquireMode);
    }

    public final void setConfiguration(JumioAcquireMode jumioAcquireMode) throws IllegalArgumentException {
        if (isValid()) {
            if (isSupportedConfiguration(jumioAcquireMode)) {
                this.f24968f = jumioAcquireMode;
                a(jumioAcquireMode);
                return;
            }
            throw new IllegalArgumentException(("The selected " + "JumioAcquireMode" + " is not valid").toString());
        }
    }

    public void start$jumio_core_release() {
        JumioAcquireMode jumioAcquireMode;
        super.start$jumio_core_release();
        if (isConfigured() && (jumioAcquireMode = this.f24968f) != null) {
            a(jumioAcquireMode);
        }
    }

    public final synchronized JumioScanPart initScanPart(JumioScanPartInterface jumioScanPartInterface) {
        return initScanPart(getData$jumio_core_release().f56147e.firstKey(), jumioScanPartInterface);
    }
}
