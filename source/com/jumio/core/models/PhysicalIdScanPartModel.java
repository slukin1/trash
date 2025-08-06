package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.commons.camera.ImageData;
import com.jumio.core.data.ScanMode;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.util.FileData;
import com.jumio.sdk.enums.JumioCredentialPart;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

@PersistWith("PhysicalIdScanPartModel")
public final class PhysicalIdScanPartModel extends ScanPartModel {

    /* renamed from: j  reason: collision with root package name */
    public final DocumentFormat f39356j;

    /* renamed from: k  reason: collision with root package name */
    public final PhysicalSelectionModel f39357k;

    /* renamed from: l  reason: collision with root package name */
    public final List<ScanMode> f39358l;

    /* renamed from: m  reason: collision with root package name */
    public final Map<ScanMode, ScanMode> f39359m;

    /* renamed from: n  reason: collision with root package name */
    public DocumentDataModel f39360n;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhysicalIdScanPartModel(JumioCredentialPart jumioCredentialPart, ScanMode scanMode, DocumentFormat documentFormat, PhysicalSelectionModel physicalSelectionModel, FileData fileData, List list, Map map, int i11, r rVar) {
        this(jumioCredentialPart, scanMode, documentFormat, physicalSelectionModel, (i11 & 16) != 0 ? new ImageData() : fileData, (i11 & 32) != 0 ? CollectionsKt__CollectionsKt.p(scanMode) : list, (i11 & 64) != 0 ? new LinkedHashMap() : map);
    }

    public final DocumentDataModel getDocumentData() {
        return this.f39360n;
    }

    public final List<ScanMode> getExtraction() {
        return this.f39358l;
    }

    public final DocumentFormat getFormat() {
        return this.f39356j;
    }

    public final PhysicalSelectionModel getSelectionModel() {
        return this.f39357k;
    }

    public final Map<ScanMode, ScanMode> getSubExtraction() {
        return this.f39359m;
    }

    public final void setDocumentData(DocumentDataModel documentDataModel) {
        this.f39360n = documentDataModel;
    }

    public PhysicalIdScanPartModel(JumioCredentialPart jumioCredentialPart, ScanMode scanMode, DocumentFormat documentFormat, PhysicalSelectionModel physicalSelectionModel, FileData fileData, List<ScanMode> list, Map<ScanMode, ScanMode> map) {
        super(jumioCredentialPart, scanMode, fileData);
        this.f39356j = documentFormat;
        this.f39357k = physicalSelectionModel;
        this.f39358l = list;
        this.f39359m = map;
    }
}
