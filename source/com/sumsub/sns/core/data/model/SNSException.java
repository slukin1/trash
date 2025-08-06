package com.sumsub.sns.core.data.model;

import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@a
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\u0006\u0007\bB\u0013\b\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "wrap", "", "(Ljava/lang/Throwable;)V", "Api", "Network", "Unknown", "Lcom/sumsub/sns/core/data/model/SNSException$Api;", "Lcom/sumsub/sns/core/data/model/SNSException$Network;", "Lcom/sumsub/sns/core/data/model/SNSException$Unknown;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class SNSException extends Exception {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSException$Api;", "Lcom/sumsub/sns/core/data/model/SNSException;", "description", "", "code", "", "correlationId", "errorCode", "errorName", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCorrelationId", "()Ljava/lang/String;", "getDescription", "getErrorCode", "getErrorName", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/SNSException$Api;", "equals", "", "other", "", "hashCode", "toString", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Api extends SNSException {
        private final Integer code;
        private final String correlationId;
        private final String description;
        private final Integer errorCode;
        private final String errorName;

        public Api(String str, Integer num, String str2, Integer num2, String str3) {
            super(new Exception(str), (r) null);
            this.description = str;
            this.code = num;
            this.correlationId = str2;
            this.errorCode = num2;
            this.errorName = str3;
        }

        public static /* synthetic */ Api copy$default(Api api, String str, Integer num, String str2, Integer num2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = api.description;
            }
            if ((i11 & 2) != 0) {
                num = api.code;
            }
            Integer num3 = num;
            if ((i11 & 4) != 0) {
                str2 = api.correlationId;
            }
            String str4 = str2;
            if ((i11 & 8) != 0) {
                num2 = api.errorCode;
            }
            Integer num4 = num2;
            if ((i11 & 16) != 0) {
                str3 = api.errorName;
            }
            return api.copy(str, num3, str4, num4, str3);
        }

        public final String component1() {
            return this.description;
        }

        public final Integer component2() {
            return this.code;
        }

        public final String component3() {
            return this.correlationId;
        }

        public final Integer component4() {
            return this.errorCode;
        }

        public final String component5() {
            return this.errorName;
        }

        public final Api copy(String str, Integer num, String str2, Integer num2, String str3) {
            return new Api(str, num, str2, num2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Api)) {
                return false;
            }
            Api api = (Api) obj;
            return x.b(this.description, api.description) && x.b(this.code, api.code) && x.b(this.correlationId, api.correlationId) && x.b(this.errorCode, api.errorCode) && x.b(this.errorName, api.errorName);
        }

        public final Integer getCode() {
            return this.code;
        }

        public final String getCorrelationId() {
            return this.correlationId;
        }

        public final String getDescription() {
            return this.description;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorName() {
            return this.errorName;
        }

        public int hashCode() {
            String str = this.description;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.code;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.correlationId;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num2 = this.errorCode;
            int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str3 = this.errorName;
            if (str3 != null) {
                i11 = str3.hashCode();
            }
            return hashCode4 + i11;
        }

        public String toString() {
            return "Api(description=" + this.description + ", code=" + this.code + ", correlationId=" + this.correlationId + ", errorCode=" + this.errorCode + ", errorName=" + this.errorName + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSException$Network;", "Lcom/sumsub/sns/core/data/model/SNSException;", "wrap", "", "(Ljava/lang/Throwable;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Network extends SNSException {
        public Network(Throwable th2) {
            super(th2, (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSException$Unknown;", "Lcom/sumsub/sns/core/data/model/SNSException;", "wrap", "", "(Ljava/lang/Throwable;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Unknown extends SNSException {
        public Unknown() {
            this((Throwable) null, 1, (r) null);
        }

        public Unknown(Throwable th2) {
            super(th2, (r) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Unknown(Throwable th2, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : th2);
        }
    }

    public /* synthetic */ SNSException(Throwable th2, r rVar) {
        this(th2);
    }

    private SNSException(Throwable th2) {
        super(th2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSException(Throwable th2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : th2, (r) null);
    }
}
