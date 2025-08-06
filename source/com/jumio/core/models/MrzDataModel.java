package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.JumioMrzData;
import com.jumio.core.enums.EMRTDStatus;
import com.jumio.core.util.StringUtilKt;
import d10.l;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import jumio.core.g1;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@PersistWith("MrzDataModel")
public final class MrzDataModel extends DocumentDataModel {

    /* renamed from: v  reason: collision with root package name */
    public EMRTDStatus f39346v = EMRTDStatus.NOT_AVAILABLE;

    /* renamed from: w  reason: collision with root package name */
    public MrtdDataModel f39347w;

    /* renamed from: x  reason: collision with root package name */
    public final JumioMrzData f39348x = new JumioMrzData();

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39349a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.jumio.sdk.enums.JumioCredentialPart[] r0 = com.jumio.sdk.enums.JumioCredentialPart.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.enums.JumioCredentialPart r1 = com.jumio.sdk.enums.JumioCredentialPart.FRONT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.jumio.sdk.enums.JumioCredentialPart r1 = com.jumio.sdk.enums.JumioCredentialPart.BACK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f39349a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.models.MrzDataModel.a.<clinit>():void");
        }
    }

    public static final class b extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MrzDataModel f39350a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MrzDataModel mrzDataModel) {
            super(1);
            this.f39350a = mrzDataModel;
        }

        public final Object invoke(Object obj) {
            this.f39350a.setFirstName((String) obj);
            return Unit.f56620a;
        }
    }

    public static final class c extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MrzDataModel f39351a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(MrzDataModel mrzDataModel) {
            super(1);
            this.f39351a = mrzDataModel;
        }

        public final Object invoke(Object obj) {
            this.f39351a.setLastName((String) obj);
            return Unit.f56620a;
        }
    }

    public static final class d extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MrzDataModel f39352a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(MrzDataModel mrzDataModel) {
            super(1);
            this.f39352a = mrzDataModel;
        }

        public final Object invoke(Object obj) {
            this.f39352a.setPersonalNumber((String) obj);
            return Unit.f56620a;
        }
    }

    public static final class e extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MrzDataModel f39353a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(MrzDataModel mrzDataModel) {
            super(1);
            this.f39353a = mrzDataModel;
        }

        public final Object invoke(Object obj) {
            this.f39353a.setIdNumber((String) obj);
            return Unit.f56620a;
        }
    }

    public static final class f extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MrzDataModel f39354a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(MrzDataModel mrzDataModel) {
            super(1);
            this.f39354a = mrzDataModel;
        }

        public final Object invoke(Object obj) {
            this.f39354a.setIssuingCountry((String) obj);
            return Unit.f56620a;
        }
    }

    public static final class g extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MrzDataModel f39355a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(MrzDataModel mrzDataModel) {
            super(1);
            this.f39355a = mrzDataModel;
        }

        public final Object invoke(Object obj) {
            this.f39355a.setOriginatingCountry((String) obj);
            return Unit.f56620a;
        }
    }

    public void fillRequest(JSONObject jSONObject, ScanPartModel scanPartModel) throws JSONException {
        EMRTDStatus eMRTDStatus;
        JumioMrzData mrzData;
        JumioMrzData mrzData2;
        JumioMrzData mrzData3;
        Date issuingDate;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        appendValue(jSONObject, "firstName", getFirstName());
        appendValue(jSONObject, "lastName", getLastName());
        appendValue(jSONObject, "placeOfBirth", getPlaceOfBirth());
        int i11 = a.f39349a[scanPartModel.getCredentialPart().ordinal()];
        boolean z11 = true;
        appendValue(jSONObject, "extractionSide", i11 != 1 ? i11 != 2 ? "" : "BACK" : "FRONT");
        int[] iArr = null;
        appendValue(jSONObject, "issuingDate", (getIssuingDate() == null || (issuingDate = getIssuingDate()) == null) ? null : simpleDateFormat.format(issuingDate));
        appendValue(jSONObject, "mrzFormat", this.f39348x.getFormat().name());
        appendValue(jSONObject, "mrzLine1", this.f39348x.getMrzLine1());
        appendValue(jSONObject, "mrzLine2", this.f39348x.getMrzLine2());
        appendValue(jSONObject, "mrzLine3", this.f39348x.getMrzLine3());
        MrtdDataModel mrtdDataModel = this.f39347w;
        if (mrtdDataModel != null && (eMRTDStatus = this.f39346v) != null) {
            if (eMRTDStatus == EMRTDStatus.VERIFIED || eMRTDStatus == EMRTDStatus.DENIED) {
                if (mrtdDataModel.getMrzData() != null) {
                    MrtdDataModel mrtdDataModel2 = this.f39347w;
                    appendValue(jSONObject, "nfcLine1", (mrtdDataModel2 == null || (mrzData3 = mrtdDataModel2.getMrzData()) == null) ? null : mrzData3.getMrzLine1());
                    MrtdDataModel mrtdDataModel3 = this.f39347w;
                    appendValue(jSONObject, "nfcLine2", (mrtdDataModel3 == null || (mrzData2 = mrtdDataModel3.getMrzData()) == null) ? null : mrzData2.getMrzLine2());
                    MrtdDataModel mrtdDataModel4 = this.f39347w;
                    appendValue(jSONObject, "nfcLine3", (mrtdDataModel4 == null || (mrzData = mrtdDataModel4.getMrzData()) == null) ? null : mrzData.getMrzLine3());
                }
                JSONObject jSONObject2 = new JSONObject();
                MrtdDataModel mrtdDataModel5 = this.f39347w;
                jSONObject2.put("BAC", mrtdDataModel5 != null ? Integer.valueOf(mrtdDataModel5.getBacCheckResult()) : null);
                MrtdDataModel mrtdDataModel6 = this.f39347w;
                jSONObject2.put("AA", mrtdDataModel6 != null ? Integer.valueOf(mrtdDataModel6.getActiveAuthResult()) : null);
                JSONObject jSONObject3 = new JSONObject();
                MrtdDataModel mrtdDataModel7 = this.f39347w;
                jSONObject3.put("DSC", mrtdDataModel7 != null ? Integer.valueOf(mrtdDataModel7.getDscCheckResult()) : null);
                MrtdDataModel mrtdDataModel8 = this.f39347w;
                jSONObject3.put("CSCA", mrtdDataModel8 != null ? Integer.valueOf(mrtdDataModel8.getRootCertCheck()) : null);
                JSONObject jSONObject4 = new JSONObject();
                MrtdDataModel mrtdDataModel9 = this.f39347w;
                Map<String, Integer> htCheckResults = mrtdDataModel9 != null ? mrtdDataModel9.getHtCheckResults() : null;
                if (htCheckResults != null) {
                    for (Map.Entry next : htCheckResults.entrySet()) {
                        jSONObject4.put((String) next.getKey(), ((Number) next.getValue()).intValue());
                    }
                    jSONObject3.put("HTC", jSONObject4);
                }
                jSONObject2.put("PA", jSONObject3);
                MrtdDataModel mrtdDataModel10 = this.f39347w;
                if (mrtdDataModel10 != null) {
                    iArr = mrtdDataModel10.getEncodedDataItems();
                }
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("authenticationSteps", "\"" + jSONObject2 + "\"");
                if (this.f39346v != EMRTDStatus.VERIFIED) {
                    z11 = false;
                }
                jSONObject5.put("authenticationValid", z11);
                jSONObject5.put("additionalData", Arrays.toString(iArr));
                jSONObject.put("eMRTD", jSONObject5);
            }
        }
    }

    public final JumioMrzData getMrzData() {
        return this.f39348x;
    }

    public final void setEMRTDStatus(EMRTDStatus eMRTDStatus) {
        this.f39346v = eMRTDStatus;
    }

    public final void setFromExtractedData(g1 g1Var) {
        setIssuingCountry(g1Var.f56206a);
        setDob(g1Var.f56207b);
        setExpiryDate(g1Var.f56208c);
        setIdNumber(g1Var.f56209d);
        this.f39348x.setMrzLine1(g1Var.f56210e);
        this.f39348x.setMrzLine2(g1Var.f56211f);
        this.f39348x.setMrzLine3(g1Var.f56212g);
    }

    public final void setMrtdData(MrtdDataModel mrtdDataModel, boolean z11) {
        this.f39347w = mrtdDataModel;
        if (z11) {
            StringUtilKt.isNotNullOrEmpty(mrtdDataModel.getMrzFirstName(), new b(this));
            StringUtilKt.isNotNullOrEmpty(mrtdDataModel.getMrzLastName(), new c(this));
            StringUtilKt.isNotNullOrEmpty(mrtdDataModel.getMrzPersonalNumber(), new d(this));
            StringUtilKt.isNotNullOrEmpty(mrtdDataModel.getMrzIdNumber(), new e(this));
            StringUtilKt.isNotNullOrEmpty(mrtdDataModel.getMrzIssuingCountry(), new f(this));
            Date issuingDate = mrtdDataModel.getIssuingDate();
            if (issuingDate != null) {
                setIssuingDate(issuingDate);
            }
            StringUtilKt.isNotNullOrEmpty(mrtdDataModel.getMrzOriginatingCountry(), new g(this));
        }
    }
}
