package jumio.core;

import com.jumio.commons.PersistWith;
import com.jumio.core.data.ScanMode;
import com.jumio.core.data.document.Document;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.util.FileData;
import com.jumio.sdk.enums.JumioCredentialPart;

@PersistWith("DocumentScanPartModel")
public final class z0 extends ScanPartModel {

    /* renamed from: j  reason: collision with root package name */
    public final String f56350j;

    /* renamed from: k  reason: collision with root package name */
    public final Document f56351k;

    public z0(JumioCredentialPart jumioCredentialPart, ScanMode scanMode, String str, Document document) {
        super(jumioCredentialPart, scanMode, new FileData());
        this.f56350j = str;
        this.f56351k = document;
    }

    public final Document a() {
        return this.f56351k;
    }
}
