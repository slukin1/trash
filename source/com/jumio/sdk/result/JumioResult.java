package com.jumio.sdk.result;

import com.jumio.sdk.credentials.JumioCredentialCategory;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.error.JumioError;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

public final class JumioResult implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f25006a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25007b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f25008c;

    /* renamed from: d  reason: collision with root package name */
    public final List<JumioCredentialInfo> f25009d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, JumioCredentialResult> f25010e;

    /* renamed from: f  reason: collision with root package name */
    public final JumioError f25011f;

    public JumioResult(String str, String str2, boolean z11, List<JumioCredentialInfo> list, Map<String, ? extends JumioCredentialResult> map, JumioError jumioError) {
        this.f25006a = str;
        this.f25007b = str2;
        this.f25008c = z11;
        this.f25009d = list;
        this.f25010e = map;
        this.f25011f = jumioError;
    }

    public final String getAccountId() {
        return this.f25007b;
    }

    public final List<JumioCredentialInfo> getCredentialInfos() {
        return this.f25009d;
    }

    public final JumioError getError() {
        return this.f25011f;
    }

    public final JumioFaceResult getFaceResult(JumioCredentialInfo jumioCredentialInfo) {
        if (jumioCredentialInfo.getCategory() != JumioCredentialCategory.FACE) {
            return null;
        }
        return (JumioFaceResult) getResult(jumioCredentialInfo);
    }

    public final JumioIDResult getIDResult(JumioCredentialInfo jumioCredentialInfo) {
        if (jumioCredentialInfo.getCategory() != JumioCredentialCategory.ID) {
            return null;
        }
        return (JumioIDResult) getResult(jumioCredentialInfo);
    }

    public final JumioCredentialResult getResult(JumioCredentialInfo jumioCredentialInfo) {
        Map<String, JumioCredentialResult> map = this.f25010e;
        if (map != null) {
            return map.get(jumioCredentialInfo.getId());
        }
        return null;
    }

    public final String getWorkflowExecutionId() {
        return this.f25006a;
    }

    public final boolean isSuccess() {
        return this.f25008c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioResult(String str, String str2, boolean z11, List list, Map map, JumioError jumioError, int i11, r rVar) {
        this(str, str2, z11, (i11 & 8) != 0 ? null : list, (i11 & 16) != 0 ? null : map, (i11 & 32) != 0 ? null : jumioError);
    }
}
