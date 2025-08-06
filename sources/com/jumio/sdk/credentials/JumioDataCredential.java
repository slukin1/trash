package com.jumio.sdk.credentials;

import com.jumio.commons.log.Log;
import com.jumio.core.Controller;
import com.jumio.core.credentials.DeviceRiskVendor;
import com.jumio.core.data.ScanMode;
import com.jumio.core.models.DeviceRiskModel;
import com.jumio.core.models.DeviceRiskScanPartModel;
import com.jumio.core.models.DeviceRiskTokenDataModel;
import com.jumio.core.plugins.ScanPartPlugin;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.scanpart.JumioScanPart;
import java.util.List;
import jumio.core.b0;
import jumio.core.d2;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class JumioDataCredential extends JumioCredential {
    public static final Companion Companion = new Companion((r) null);
    public static final String TAG = "JumioDataCredential";

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.jumio.core.credentials.DeviceRiskVendor[] r0 = com.jumio.core.credentials.DeviceRiskVendor.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.core.credentials.DeviceRiskVendor r1 = com.jumio.core.credentials.DeviceRiskVendor.NONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.jumio.core.credentials.DeviceRiskVendor r1 = com.jumio.core.credentials.DeviceRiskVendor.SARDINE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.sdk.credentials.JumioDataCredential.WhenMappings.<clinit>():void");
        }
    }

    public JumioDataCredential(Controller controller, b0 b0Var) {
        super(controller, b0Var);
    }

    public JumioScanPart initScanPart(JumioCredentialPart jumioCredentialPart, JumioScanPartInterface jumioScanPartInterface) {
        ScanPartPlugin scanPartPlugin;
        if (getData$jumio_core_release().b().containsKey(jumioCredentialPart)) {
            List<DeviceRiskVendor> d11 = ((b0) getData$jumio_core_release()).d();
            if (!d11.isEmpty()) {
                DeviceRiskScanPartModel deviceRiskScanPartModel = (DeviceRiskScanPartModel) getData$jumio_core_release().b().get(jumioCredentialPart);
                for (DeviceRiskVendor deviceRiskVendor : d11) {
                    int i11 = WhenMappings.$EnumSwitchMapping$0[deviceRiskVendor.ordinal()];
                    if (i11 == 1) {
                        Log.w(TAG, "No matching vendor for device risk plugin!");
                        scanPartPlugin = null;
                        continue;
                    } else if (i11 == 2) {
                        scanPartPlugin = (ScanPartPlugin) getController$jumio_core_release().getPluginRegistry().a(d2.SARDINE);
                        continue;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (scanPartPlugin != null) {
                        deviceRiskScanPartModel.setDeviceRiskVendor(deviceRiskVendor);
                        List<DeviceRiskModel> deviceRiskModels = ((DeviceRiskTokenDataModel) getController$jumio_core_release().getDataManager().get(DeviceRiskTokenDataModel.class)).getDeviceRiskModels();
                        DeviceRiskVendor deviceRiskVendor2 = deviceRiskScanPartModel.getDeviceRiskVendor();
                        for (DeviceRiskModel deviceRiskModel : deviceRiskModels) {
                            if (x.b(deviceRiskModel.getSdkType().name(), deviceRiskVendor2 != null ? deviceRiskVendor2.name() : null)) {
                                deviceRiskScanPartModel.setDeviceRiskModel(deviceRiskModel);
                                setActiveScanPart$jumio_core_release(new JumioScanPart(scanPartPlugin.getScanPart(getController$jumio_core_release(), this, deviceRiskScanPartModel, jumioScanPartInterface)));
                                getData$jumio_core_release().a(jumioCredentialPart);
                                return getActiveScanPart$jumio_core_release();
                            }
                        }
                        throw new IllegalStateException("No matching vendor!");
                    }
                }
                throw new IllegalStateException("No matching device vendor with linked modules");
            }
            throw new IllegalArgumentException(("No device risk vendors provided for " + b0.class.getSimpleName()).toString());
        }
        throw new IllegalArgumentException((jumioCredentialPart + " not found").toString());
    }

    public boolean isConfigured() {
        return true;
    }

    public void start$jumio_core_release() {
        super.start$jumio_core_release();
        getData$jumio_core_release().f56147e.put(JumioCredentialPart.DEVICE_RISK, new DeviceRiskScanPartModel(ScanMode.DEVICE_RISK));
    }
}
