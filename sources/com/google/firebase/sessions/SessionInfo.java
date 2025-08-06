package com.google.firebase.sessions;

import com.fluttercandies.photo_manager.core.entity.a;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003JE\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0006HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lcom/google/firebase/sessions/SessionInfo;", "", "sessionId", "", "firstSessionId", "sessionIndex", "", "eventTimestampUs", "", "dataCollectionStatus", "Lcom/google/firebase/sessions/DataCollectionStatus;", "firebaseInstallationId", "(Ljava/lang/String;Ljava/lang/String;IJLcom/google/firebase/sessions/DataCollectionStatus;Ljava/lang/String;)V", "getDataCollectionStatus", "()Lcom/google/firebase/sessions/DataCollectionStatus;", "setDataCollectionStatus", "(Lcom/google/firebase/sessions/DataCollectionStatus;)V", "getEventTimestampUs", "()J", "setEventTimestampUs", "(J)V", "getFirebaseInstallationId", "()Ljava/lang/String;", "setFirebaseInstallationId", "(Ljava/lang/String;)V", "getFirstSessionId", "getSessionId", "getSessionIndex", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SessionInfo {
    private DataCollectionStatus dataCollectionStatus;
    private long eventTimestampUs;
    private String firebaseInstallationId;
    private final String firstSessionId;
    private final String sessionId;
    private final int sessionIndex;

    public SessionInfo(String str, String str2, int i11, long j11, DataCollectionStatus dataCollectionStatus2, String str3) {
        this.sessionId = str;
        this.firstSessionId = str2;
        this.sessionIndex = i11;
        this.eventTimestampUs = j11;
        this.dataCollectionStatus = dataCollectionStatus2;
        this.firebaseInstallationId = str3;
    }

    public static /* synthetic */ SessionInfo copy$default(SessionInfo sessionInfo, String str, String str2, int i11, long j11, DataCollectionStatus dataCollectionStatus2, String str3, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = sessionInfo.sessionId;
        }
        if ((i12 & 2) != 0) {
            str2 = sessionInfo.firstSessionId;
        }
        String str4 = str2;
        if ((i12 & 4) != 0) {
            i11 = sessionInfo.sessionIndex;
        }
        int i13 = i11;
        if ((i12 & 8) != 0) {
            j11 = sessionInfo.eventTimestampUs;
        }
        long j12 = j11;
        if ((i12 & 16) != 0) {
            dataCollectionStatus2 = sessionInfo.dataCollectionStatus;
        }
        DataCollectionStatus dataCollectionStatus3 = dataCollectionStatus2;
        if ((i12 & 32) != 0) {
            str3 = sessionInfo.firebaseInstallationId;
        }
        return sessionInfo.copy(str, str4, i13, j12, dataCollectionStatus3, str3);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.firstSessionId;
    }

    public final int component3() {
        return this.sessionIndex;
    }

    public final long component4() {
        return this.eventTimestampUs;
    }

    public final DataCollectionStatus component5() {
        return this.dataCollectionStatus;
    }

    public final String component6() {
        return this.firebaseInstallationId;
    }

    public final SessionInfo copy(String str, String str2, int i11, long j11, DataCollectionStatus dataCollectionStatus2, String str3) {
        return new SessionInfo(str, str2, i11, j11, dataCollectionStatus2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionInfo)) {
            return false;
        }
        SessionInfo sessionInfo = (SessionInfo) obj;
        return x.b(this.sessionId, sessionInfo.sessionId) && x.b(this.firstSessionId, sessionInfo.firstSessionId) && this.sessionIndex == sessionInfo.sessionIndex && this.eventTimestampUs == sessionInfo.eventTimestampUs && x.b(this.dataCollectionStatus, sessionInfo.dataCollectionStatus) && x.b(this.firebaseInstallationId, sessionInfo.firebaseInstallationId);
    }

    public final DataCollectionStatus getDataCollectionStatus() {
        return this.dataCollectionStatus;
    }

    public final long getEventTimestampUs() {
        return this.eventTimestampUs;
    }

    public final String getFirebaseInstallationId() {
        return this.firebaseInstallationId;
    }

    public final String getFirstSessionId() {
        return this.firstSessionId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getSessionIndex() {
        return this.sessionIndex;
    }

    public int hashCode() {
        return (((((((((this.sessionId.hashCode() * 31) + this.firstSessionId.hashCode()) * 31) + this.sessionIndex) * 31) + a.a(this.eventTimestampUs)) * 31) + this.dataCollectionStatus.hashCode()) * 31) + this.firebaseInstallationId.hashCode();
    }

    public final void setDataCollectionStatus(DataCollectionStatus dataCollectionStatus2) {
        this.dataCollectionStatus = dataCollectionStatus2;
    }

    public final void setEventTimestampUs(long j11) {
        this.eventTimestampUs = j11;
    }

    public final void setFirebaseInstallationId(String str) {
        this.firebaseInstallationId = str;
    }

    public String toString() {
        return "SessionInfo(sessionId=" + this.sessionId + ", firstSessionId=" + this.firstSessionId + ", sessionIndex=" + this.sessionIndex + ", eventTimestampUs=" + this.eventTimestampUs + ", dataCollectionStatus=" + this.dataCollectionStatus + ", firebaseInstallationId=" + this.firebaseInstallationId + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SessionInfo(String str, String str2, int i11, long j11, DataCollectionStatus dataCollectionStatus2, String str3, int i12, r rVar) {
        this(str, str2, i11, j11, (i12 & 16) != 0 ? new DataCollectionStatus((DataCollectionState) null, (DataCollectionState) null, 0.0d, 7, (r) null) : dataCollectionStatus2, (i12 & 32) != 0 ? "" : str3);
    }
}
