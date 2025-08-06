package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.credentials.DeviceRiskVendor;
import com.jumio.core.data.ScanMode;
import com.jumio.core.util.FileData;
import com.jumio.sdk.enums.JumioCredentialPart;
import kotlin.jvm.internal.r;

@PersistWith("DeviceRiskScanPartModel")
public class DeviceRiskScanPartModel extends ScanPartModel {

    /* renamed from: j  reason: collision with root package name */
    public DeviceRiskVendor f39272j;

    /* renamed from: k  reason: collision with root package name */
    public DeviceRiskModel f39273k;

    public DeviceRiskScanPartModel(ScanMode scanMode) {
        super(JumioCredentialPart.DEVICE_RISK, scanMode, (FileData) null, 4, (r) null);
    }

    public final DeviceRiskModel getDeviceRiskModel() {
        return this.f39273k;
    }

    public final DeviceRiskVendor getDeviceRiskVendor() {
        return this.f39272j;
    }

    public boolean isComplete() {
        return getData().containsKey("deviceRisk");
    }

    public final void setDeviceRiskModel(DeviceRiskModel deviceRiskModel) {
        this.f39273k = deviceRiskModel;
    }

    public final void setDeviceRiskVendor(DeviceRiskVendor deviceRiskVendor) {
        this.f39272j = deviceRiskVendor;
    }
}
