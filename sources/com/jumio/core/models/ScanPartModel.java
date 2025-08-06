package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.commons.camera.ImageData;
import com.jumio.core.data.ScanMode;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.automation.AutomationModel;
import com.jumio.core.util.FileData;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.retry.JumioRetryReason;
import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;
import kotlin.jvm.internal.r;

@PersistWith("ScanPartModel")
public class ScanPartModel implements StaticModel {

    /* renamed from: a  reason: collision with root package name */
    public final JumioCredentialPart f39363a;

    /* renamed from: b  reason: collision with root package name */
    public ScanMode f39364b;

    /* renamed from: c  reason: collision with root package name */
    public final FileData f39365c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39366d;

    /* renamed from: e  reason: collision with root package name */
    public JumioScanStep f39367e;

    /* renamed from: f  reason: collision with root package name */
    public JumioRetryReason f39368f;

    /* renamed from: g  reason: collision with root package name */
    public final String f39369g;

    /* renamed from: h  reason: collision with root package name */
    public AutomationModel f39370h;

    /* renamed from: i  reason: collision with root package name */
    public final HashMap<String, Serializable> f39371i;

    public ScanPartModel(JumioCredentialPart jumioCredentialPart, ScanMode scanMode, FileData fileData) {
        this.f39363a = jumioCredentialPart;
        this.f39364b = scanMode;
        this.f39365c = fileData;
        this.f39369g = UUID.randomUUID().toString();
        this.f39371i = new HashMap<>();
    }

    public final AutomationModel getAutomationModel() {
        return this.f39370h;
    }

    public final JumioCredentialPart getCredentialPart() {
        return this.f39363a;
    }

    public final HashMap<String, Serializable> getData() {
        return this.f39371i;
    }

    public final FileData getFileData() {
        return this.f39365c;
    }

    public final String getId() {
        return this.f39369g;
    }

    public final JumioRetryReason getLastRetryReason() {
        return this.f39368f;
    }

    public final ScanMode getMode() {
        return this.f39364b;
    }

    public final JumioScanStep getScanStep() {
        return this.f39367e;
    }

    public final boolean getUsability() {
        return this.f39366d;
    }

    public boolean isComplete() {
        return this.f39365c.getHasPath();
    }

    public final void setAutomationModel(AutomationModel automationModel) {
        this.f39370h = automationModel;
    }

    public final void setLastRetryReason(JumioRetryReason jumioRetryReason) {
        this.f39368f = jumioRetryReason;
    }

    public final void setMode(ScanMode scanMode) {
        this.f39364b = scanMode;
    }

    public final void setScanStep(JumioScanStep jumioScanStep) {
        this.f39367e = jumioScanStep;
    }

    public final void setUsability(boolean z11) {
        this.f39366d = z11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScanPartModel(JumioCredentialPart jumioCredentialPart, ScanMode scanMode, FileData fileData, int i11, r rVar) {
        this(jumioCredentialPart, scanMode, (i11 & 4) != 0 ? new ImageData() : fileData);
    }
}
