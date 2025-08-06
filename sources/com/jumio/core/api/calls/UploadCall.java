package com.jumio.core.api.calls;

import com.facebook.appevents.UserDataStore;
import com.google.common.base.Ascii;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.commons.utils.FileUtil;
import com.jumio.core.data.ScanMode;
import com.jumio.core.enums.UploadType;
import com.jumio.core.extraction.liveness.extraction.LivenessDataModel;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.ConsentModel;
import com.jumio.core.models.DeviceRiskModel;
import com.jumio.core.models.DeviceRiskScanPartModel;
import com.jumio.core.models.DocumentDataModel;
import com.jumio.core.models.LivenessScanPartModel;
import com.jumio.core.models.PhysicalIdScanPartModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.util.FileData;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import jumio.core.g;
import jumio.core.h;
import jumio.core.o1;
import jumio.core.q0;
import jumio.core.v1;
import jumio.core.z0;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import net.sf.scuba.smartcards.ISO7816;
import org.json.JSONArray;
import org.json.JSONObject;

public final class UploadCall extends v1<JSONObject> {
    public static final Companion Companion = new Companion((r) null);
    public static final String DATA_CREDENTIAL_ID = "DATA_CREDENTIAL_ID";
    public static final String DATA_PARTS = "DATA_PARTS";

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public UploadCall(h hVar, ApiCallDataModel<?> apiCallDataModel) {
        super(hVar, apiCallDataModel);
        if (!apiCallDataModel.getData().containsKey(DATA_CREDENTIAL_ID)) {
            throw new IllegalArgumentException("Credential ID is missing".toString());
        } else if (!apiCallDataModel.getData().containsKey(DATA_PARTS)) {
            throw new IllegalArgumentException("Upload Parts are missing".toString());
        }
    }

    public static String[] a(String str, String str2, int i11) {
        return new String[]{"Content-Disposition: form-data; name=\"" + str + "\"", "Content-Type: " + str2, "Content-Length: " + i11};
    }

    public String getUri() {
        String b11 = g.b();
        String deobfuscate = StringDeobfuscator.deobfuscate(new byte[]{105, Framer.STDIN_FRAME_PREFIX, 69, 79, 29, Ascii.SUB, -19, 4, ISO7816.INS_ENVELOPE, 62, -18}, 7954085481774384125L);
        String deobfuscate2 = StringDeobfuscator.deobfuscate(new byte[]{18, -65, 7, -10, 84, ISO7816.INS_LOAD_KEY_FILE, -103}, 2727321516117831622L);
        return b11 + deobfuscate + ((String) getApiCallDataModel().getData().get(DATA_CREDENTIAL_ID)) + deobfuscate2;
    }

    public void prepareData() throws Exception {
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (Map.Entry entry : ((HashMap) getApiCallDataModel().getData().get(DATA_PARTS)).entrySet()) {
            UploadType uploadType = (UploadType) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof LivenessDataModel) {
                a(uploadType, (LivenessDataModel) value, jSONArray, false);
            } else if (value instanceof LivenessScanPartModel) {
                LivenessScanPartModel livenessScanPartModel = (LivenessScanPartModel) value;
                if (livenessScanPartModel.getMode() == ScanMode.JUMIO_LIVENESS) {
                    LivenessDataModel livenessData = livenessScanPartModel.getLivenessData();
                    if (livenessData != null) {
                        a(uploadType, livenessData, jSONArray, livenessScanPartModel.getUsability());
                    }
                } else {
                    a(uploadType, (ScanPartModel) value, jSONArray);
                }
            } else if (value instanceof DeviceRiskScanPartModel) {
                JSONArray jSONArray3 = new JSONArray();
                DeviceRiskModel deviceRiskModel = ((DeviceRiskScanPartModel) value).getDeviceRiskModel();
                String jSONObject = new JSONObject().put("deviceRisks", jSONArray3.put(deviceRiskModel != null ? deviceRiskModel.toJson() : null)).toString();
                v1.addPart$default(this, a("deviceRisks", "application/json; charset=UTF-8", jSONObject.length()), jSONObject, 0, 4, (Object) null);
            } else if (value instanceof PhysicalIdScanPartModel) {
                a(uploadType, (ScanPartModel) value, jSONArray);
                a(uploadType, (PhysicalIdScanPartModel) value, jSONArray2);
            } else if (value instanceof ScanPartModel) {
                a(uploadType, (ScanPartModel) value, jSONArray);
            } else {
                Log.w("Given model is not yet supported for upload: " + value);
            }
        }
        ConsentModel consentModel = (ConsentModel) getApiCallSettings().getDataManager().get(ConsentModel.class);
        if (!consentModel.isConsentSent()) {
            getApiCallDataModel().getData().put("consent_pending", Boolean.TRUE);
            String jSONObject2 = new JSONObject().put("consents", consentModel.toJsonArray()).toString();
            v1.addPart$default(this, a("consents", "application/json; charset=UTF-8", jSONObject2.length()), jSONObject2, 0, 4, (Object) null);
        }
        if (jSONArray.length() != 0) {
            String jSONObject3 = new JSONObject().put("files", jSONArray).toString();
            addPart(a("uploadFilesMetadata", "application/json; charset=UTF-8", jSONObject3.length()), jSONObject3, 0);
        }
        if (jSONArray2.length() != 0) {
            String jSONObject4 = new JSONObject().put("parts", jSONArray2).toString();
            addPart(a("uploadDataPartsMetadata", "application/json; charset=UTF-8", jSONObject4.length()), jSONObject4, 0);
        }
    }

    public JSONObject parseResponse(String str) {
        try {
            Serializable serializable = getApiCallDataModel().getData().get("consent_pending");
            Boolean bool = serializable instanceof Boolean ? (Boolean) serializable : null;
            if (bool != null ? bool.booleanValue() : false) {
                ((ConsentModel) getApiCallSettings().getDataManager().get(ConsentModel.class)).setConsentSent(true);
                getApiCallDataModel().getData().put("consent_pending", Boolean.FALSE);
            }
            return new JSONObject(str);
        } catch (Exception e11) {
            Log.w(getTAG(), "Exception", (Throwable) e11);
            return new JSONObject();
        }
    }

    public final Unit a(UploadType uploadType, LivenessDataModel livenessDataModel, JSONArray jSONArray, boolean z11) {
        ImageData[] frames = livenessDataModel.getFrames();
        if (frames == null) {
            return null;
        }
        int length = frames.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            ImageData imageData = frames[i11];
            int i13 = i12 + 1;
            JSONObject put = new JSONObject().put("multipartName", imageData.getFileName()).put("fileType", imageData.getFileType()).put("uploadType", uploadType.name() + "_" + i13).put("usabilityExpected", z11);
            JSONObject uploadMetadata = imageData.getUploadMetadata(Integer.valueOf(i12));
            if (uploadMetadata != null) {
                put.put("fileMetaData", uploadMetadata);
            }
            jSONArray.put(put);
            try {
                byte[] readFile = FileUtil.INSTANCE.readFile(imageData.getPath(), ((q0) getApiCallSettings().getContext()).getSessionKey());
                v1.addPart$default(this, a(imageData.getFileName(), imageData.getMimeType(), readFile.length), readFile, 0, 4, (Object) null);
                i11++;
                i12 = i13;
            } catch (Exception e11) {
                Log.e("ImageData", "Error reading File", (Throwable) e11);
                throw e11;
            }
        }
        return Unit.f56620a;
    }

    public final void a(UploadType uploadType, ScanPartModel scanPartModel, JSONArray jSONArray) {
        if (scanPartModel.getFileData().getHasPath()) {
            JSONObject put = new JSONObject().put("multipartName", scanPartModel.getFileData().getFileName()).put("fileType", scanPartModel.getFileData().getFileType()).put("uploadType", uploadType.name());
            if (scanPartModel instanceof PhysicalIdScanPartModel) {
                PhysicalIdScanPartModel physicalIdScanPartModel = (PhysicalIdScanPartModel) scanPartModel;
                DocumentDataModel documentData = physicalIdScanPartModel.getDocumentData();
                String str = null;
                String issuingCountry = documentData != null ? documentData.getIssuingCountry() : null;
                if (!(issuingCountry == null || issuingCountry.length() == 0)) {
                    str = issuingCountry;
                }
                if (str == null) {
                    str = physicalIdScanPartModel.getSelectionModel().getCountry().getIsoCode();
                }
                put.put(UserDataStore.COUNTRY, str);
                put.put("idType", physicalIdScanPartModel.getSelectionModel().getPhysicalDocumentType().getIdType().name());
                put.put("usabilityExpected", scanPartModel.getUsability());
            } else if (scanPartModel instanceof z0) {
                z0 z0Var = (z0) scanPartModel;
                put.put(UserDataStore.COUNTRY, z0Var.f56350j);
                put.put("docType", z0Var.f56351k.getCode());
            }
            jSONArray.put(put);
            FileData fileData = scanPartModel.getFileData();
            try {
                byte[] readFile = FileUtil.INSTANCE.readFile(fileData.getPath(), ((q0) getApiCallSettings().getContext()).getSessionKey());
                v1.addPart$default(this, a(fileData.getFileName(), fileData.getMimeType(), readFile.length), readFile, 0, 4, (Object) null);
            } catch (Exception e11) {
                Log.e("ImageData", "Error reading File", (Throwable) e11);
                throw e11;
            }
        }
    }

    public final void a(UploadType uploadType, PhysicalIdScanPartModel physicalIdScanPartModel, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        DocumentDataModel documentData = physicalIdScanPartModel.getDocumentData();
        if (documentData != null) {
            documentData.fillRequest(jSONObject, physicalIdScanPartModel);
        }
        jSONObject.put("idType", physicalIdScanPartModel.getSelectionModel().getPhysicalDocumentType().getIdType().name());
        jSONObject.put("documentVariant", physicalIdScanPartModel.getSelectionModel().getVariant().getVariant().name());
        DocumentDataModel documentData2 = physicalIdScanPartModel.getDocumentData();
        String str = null;
        String issuingCountry = documentData2 != null ? documentData2.getIssuingCountry() : null;
        if (!(issuingCountry == null || issuingCountry.length() == 0)) {
            str = issuingCountry;
        }
        if (str == null) {
            str = physicalIdScanPartModel.getSelectionModel().getCountry().getIsoCode();
        }
        o1.a(jSONObject, str);
        String jSONObject2 = jSONObject.toString();
        String str2 = "data" + jSONArray.length();
        v1.addPart$default(this, a(str2, "application/json; charset=UTF-8", jSONObject2.length()), jSONObject2, 0, 4, (Object) null);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("multipartName", str2);
        jSONObject3.put("uploadType", uploadType.name());
        jSONArray.put(jSONObject3);
    }
}
