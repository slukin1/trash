package com.jumio.sdk.credentials;

import com.jumio.analytics.Analytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.core.Controller;
import com.jumio.core.data.ScanMode;
import com.jumio.core.data.country.Country;
import com.jumio.core.data.digitaldocument.DigitalDocumentPart;
import com.jumio.core.data.digitaldocument.DigitalDocumentType;
import com.jumio.core.data.document.DocumentPart;
import com.jumio.core.models.CountryDocumentModel;
import com.jumio.core.models.DigitalIdScanPartModel;
import com.jumio.core.models.DigitalSelectionModel;
import com.jumio.core.models.PhysicalIdScanPartModel;
import com.jumio.core.models.PhysicalSelectionModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.models.SelectionModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.plugins.ScanPartPlugin;
import com.jumio.core.util.FileData;
import com.jumio.sdk.document.JumioDigitalDocument;
import com.jumio.sdk.document.JumioDocument;
import com.jumio.sdk.document.JumioPhysicalDocument;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.exceptions.SDKNotConfiguredException;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.scanpart.JumioScanPart;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import jumio.core.a0;
import jumio.core.b2;
import jumio.core.d2;
import jumio.core.f0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.r;

public final class JumioIDCredential extends JumioCredential {

    /* renamed from: f  reason: collision with root package name */
    public final a0 f24971f;

    public JumioIDCredential(Controller controller, f0 f0Var) {
        super(controller, f0Var);
        this.f24971f = new a0((CountryDocumentModel) controller.getDataManager().get(CountryDocumentModel.class), ((SettingsModel) controller.getDataManager().get(SettingsModel.class)).getCountryForIp(), f0Var);
    }

    public static /* synthetic */ void getCountries$annotations() {
    }

    public final void a() {
        a0 a0Var = this.f24971f;
        SortedMap<JumioCredentialPart, ScanPartModel> sortedMap = getData$jumio_core_release().f56147e;
        a0Var.getClass();
        sortedMap.clear();
        SelectionModel a11 = a0Var.a();
        int i11 = 0;
        if (a11 != null) {
            if (a11 instanceof PhysicalSelectionModel) {
                PhysicalSelectionModel physicalSelectionModel = (PhysicalSelectionModel) a11;
                for (DocumentPart documentPart : physicalSelectionModel.getVariant().getParts()) {
                    JumioCredentialPart side = documentPart.getSide();
                    PhysicalIdScanPartModel physicalIdScanPartModel = r5;
                    PhysicalIdScanPartModel physicalIdScanPartModel2 = new PhysicalIdScanPartModel(documentPart.getSide(), documentPart.getExtraction().get(i11), physicalSelectionModel.getVariant().getFormat(), physicalSelectionModel, (FileData) null, CollectionsKt___CollectionsKt.L0(documentPart.getExtraction()), (Map) null, 80, (r) null);
                    sortedMap.put(side, physicalIdScanPartModel);
                    i11 = 0;
                }
            } else if (a11 instanceof DigitalSelectionModel) {
                DigitalSelectionModel digitalSelectionModel = (DigitalSelectionModel) a11;
                for (DigitalDocumentPart extraction : digitalSelectionModel.getDigitalDocumentType().getParts()) {
                    sortedMap.put(JumioCredentialPart.DIGITAL, new DigitalIdScanPartModel(extraction.getExtraction(), digitalSelectionModel));
                }
            }
        }
        SettingsModel settingsModel = (SettingsModel) getController$jumio_core_release().getDataManager().get(SettingsModel.class);
        for (Map.Entry<JumioCredentialPart, ScanPartModel> value : getData$jumio_core_release().f56147e.entrySet()) {
            ScanPartModel scanPartModel = (ScanPartModel) value.getValue();
            if ((scanPartModel instanceof PhysicalIdScanPartModel) && settingsModel.getAutomaticBarcodeExtraction()) {
                PhysicalIdScanPartModel physicalIdScanPartModel3 = (PhysicalIdScanPartModel) scanPartModel;
                List<ScanMode> extraction2 = physicalIdScanPartModel3.getExtraction();
                ScanMode scanMode = ScanMode.DOCFINDER;
                if (extraction2.contains(scanMode) && getController$jumio_core_release().getPluginRegistry().b(d2.DOCFINDER)) {
                    List<ScanMode> extraction3 = physicalIdScanPartModel3.getExtraction();
                    ScanMode scanMode2 = ScanMode.PDF417;
                    if (extraction3.contains(scanMode2)) {
                        physicalIdScanPartModel3.getExtraction().remove(scanMode2);
                        scanPartModel.setMode(physicalIdScanPartModel3.getExtraction().get(0));
                    }
                    physicalIdScanPartModel3.getSubExtraction().put(scanMode, scanMode2);
                }
            }
        }
        Analytics.Companion.add(MobileEvents.userAction$default("configuration", (JumioScanStep) null, this.f24971f.a(), 2, (Object) null));
    }

    public void cancel() throws SDKNotConfiguredException {
        super.cancel();
        f0 f0Var = (f0) getData$jumio_core_release();
        f0Var.f56195k = null;
        f0Var.f56196l = null;
        a0 a0Var = this.f24971f;
        a0Var.f56117e = null;
        a0Var.f56118f = null;
        a0Var.f56119g = null;
        a0Var.f56120h = null;
    }

    public void finish() throws SDKNotConfiguredException {
        super.finish();
        f0 f0Var = (f0) getData$jumio_core_release();
        f0Var.f56195k = null;
        f0Var.f56196l = null;
        a0 a0Var = this.f24971f;
        a0Var.f56117e = null;
        a0Var.f56118f = null;
        a0Var.f56119g = null;
        a0Var.f56120h = null;
    }

    public final Map<String, List<JumioPhysicalDocument>> getCountries() {
        a0 a0Var = this.f24971f;
        a0Var.getClass();
        HashMap hashMap = new HashMap();
        for (Country country : a0Var.f56116d) {
            ArrayList a11 = a0Var.a(country);
            if (!a11.isEmpty()) {
                hashMap.put(country.getIsoCode(), Collections.unmodifiableList(a11));
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public List<JumioCredentialPart> getCredentialParts() {
        if (super.getCredentialParts().size() == 1) {
            return super.getCredentialParts();
        }
        return CollectionsKt__CollectionsJVMKt.e(JumioCredentialPart.MULTIPART);
    }

    public final List<JumioDigitalDocument> getDigitalDocumentsForCountry(String str) {
        a0 a0Var = this.f24971f;
        a0Var.getClass();
        Country a11 = a0Var.a(str);
        if (a11 == null) {
            return CollectionsKt__CollectionsKt.k();
        }
        List<DigitalDocumentType> digitalDocumentTypesFor = a0Var.f56113a.getDigitalDocumentTypesFor(a11);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(digitalDocumentTypesFor, 10));
        for (DigitalDocumentType digitalDocumentType : digitalDocumentTypesFor) {
            arrayList.add(new JumioDigitalDocument(digitalDocumentType.getType(), digitalDocumentType.getTitle()));
        }
        return arrayList;
    }

    public final List<JumioPhysicalDocument> getPhysicalDocumentsForCountry(String str) {
        a0 a0Var = this.f24971f;
        a0Var.getClass();
        Country a11 = a0Var.a(str);
        if (a11 == null) {
            return CollectionsKt__CollectionsKt.k();
        }
        return a0Var.a(a11);
    }

    public final String getSuggestedCountry() {
        a0 a0Var = this.f24971f;
        if (a0Var.a(a0Var.f56114b) != null) {
            return a0Var.f56114b;
        }
        return null;
    }

    public final List<String> getSupportedCountries() {
        List<Country> list = this.f24971f.f56116d;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        for (Country isoCode : list) {
            arrayList.add(isoCode.getIsoCode());
        }
        return arrayList;
    }

    public synchronized JumioScanPart initScanPart(JumioCredentialPart jumioCredentialPart, JumioScanPartInterface jumioScanPartInterface) {
        JumioScanPart jumioScanPart;
        if (!isValid()) {
            throw new SDKNotConfiguredException("Credential is not active".toString());
        } else if (getCredentialParts().contains(jumioCredentialPart)) {
            SelectionModel a11 = this.f24971f.a();
            if (a11 != null) {
                if (getActiveScanPart$jumio_core_release() == null) {
                    getData$jumio_core_release().a(jumioCredentialPart);
                    if (a11 instanceof PhysicalSelectionModel) {
                        Controller controller$jumio_core_release = getController$jumio_core_release();
                        Collection<ScanPartModel> values = getData$jumio_core_release().b().values();
                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(values, 10));
                        for (ScanPartModel scanPartModel : values) {
                            arrayList.add((PhysicalIdScanPartModel) scanPartModel);
                        }
                        jumioScanPart = new JumioScanPart(new b2(controller$jumio_core_release, this, arrayList, jumioScanPartInterface));
                    } else if (a11 instanceof DigitalSelectionModel) {
                        Controller controller$jumio_core_release2 = getController$jumio_core_release();
                        DigitalIdScanPartModel digitalIdScanPartModel = (DigitalIdScanPartModel) getData$jumio_core_release().b().get(jumioCredentialPart);
                        ScanPartPlugin scanPartPlugin = (ScanPartPlugin) controller$jumio_core_release2.getPluginRegistry().a(d2.DIGITAL_IDENTITY);
                        if (scanPartPlugin != null) {
                            jumioScanPart = new JumioScanPart(scanPartPlugin.getScanPart(controller$jumio_core_release2, this, digitalIdScanPartModel, jumioScanPartInterface));
                        } else {
                            throw new SDKNotConfiguredException("'jumio-digital-identity' module is required to handle digital documents!");
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    setActiveScanPart$jumio_core_release(jumioScanPart);
                } else {
                    throw new IllegalStateException("Please finish the active scan part first".toString());
                }
            } else {
                throw new SDKNotConfiguredException("Country/Document selection not found");
            }
        } else {
            throw new IllegalArgumentException((jumioCredentialPart + " not found").toString());
        }
        return jumioScanPart;
    }

    public boolean isConfigured() {
        if (isValid()) {
            a0 a0Var = this.f24971f;
            if ((a0Var.f56117e == null || ((a0Var.f56118f == null || a0Var.f56119g == null) && a0Var.f56120h == null)) ? false : true) {
                return true;
            }
        }
        return false;
    }

    public final boolean isSupportedConfiguration(String str, JumioDocument jumioDocument) {
        if (!isValid()) {
            return false;
        }
        return this.f24971f.a(str, jumioDocument);
    }

    public final void setConfiguration(String str, JumioDocument jumioDocument) throws IllegalArgumentException {
        if (isValid()) {
            if (isSupportedConfiguration(str, jumioDocument)) {
                if (jumioDocument instanceof JumioPhysicalDocument) {
                    this.f24971f.a(str, (JumioPhysicalDocument) jumioDocument);
                } else if (jumioDocument instanceof JumioDigitalDocument) {
                    this.f24971f.a(str, (JumioDigitalDocument) jumioDocument);
                }
                f0 f0Var = (f0) getData$jumio_core_release();
                f0Var.f56195k = str;
                f0Var.f56196l = jumioDocument;
                a();
                return;
            }
            throw new IllegalArgumentException("The selected country/document combination is not valid".toString());
        }
    }

    public void start$jumio_core_release() {
        super.start$jumio_core_release();
        a0 a0Var = this.f24971f;
        if ((a0Var.f56117e == null || ((a0Var.f56118f == null || a0Var.f56119g == null) && a0Var.f56120h == null)) ? false : true) {
            a();
        }
    }
}
