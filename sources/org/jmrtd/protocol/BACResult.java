package org.jmrtd.protocol;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import org.jmrtd.AccessKeySpec;

public class BACResult implements Serializable {
    private static final long serialVersionUID = -7114911372181772099L;
    private AccessKeySpec bacKey;
    private SecureMessagingWrapper wrapper;

    public BACResult(SecureMessagingWrapper secureMessagingWrapper) {
        this((AccessKeySpec) null, secureMessagingWrapper);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BACResult bACResult = (BACResult) obj;
        AccessKeySpec accessKeySpec = this.bacKey;
        if (accessKeySpec == null) {
            if (bACResult.bacKey != null) {
                return false;
            }
        } else if (!accessKeySpec.equals(bACResult.bacKey)) {
            return false;
        }
        SecureMessagingWrapper secureMessagingWrapper = this.wrapper;
        if (secureMessagingWrapper == null) {
            if (bACResult.wrapper != null) {
                return false;
            }
        } else if (!secureMessagingWrapper.equals(bACResult.wrapper)) {
            return false;
        }
        return true;
    }

    public AccessKeySpec getBACKey() {
        return this.bacKey;
    }

    public SecureMessagingWrapper getWrapper() {
        return this.wrapper;
    }

    public int hashCode() {
        AccessKeySpec accessKeySpec = this.bacKey;
        int i11 = 0;
        int hashCode = (1303377669 + (accessKeySpec == null ? 0 : accessKeySpec.hashCode())) * 1234567891;
        SecureMessagingWrapper secureMessagingWrapper = this.wrapper;
        if (secureMessagingWrapper != null) {
            i11 = secureMessagingWrapper.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("BACResult [bacKey: ");
        Object obj = this.bacKey;
        if (obj == null) {
            obj = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        sb3.append(obj);
        sb2.append(sb3.toString());
        sb2.append(", wrapper: " + this.wrapper);
        sb2.append("]");
        return sb2.toString();
    }

    public BACResult(AccessKeySpec accessKeySpec, SecureMessagingWrapper secureMessagingWrapper) {
        this.bacKey = accessKeySpec;
        this.wrapper = secureMessagingWrapper;
    }
}
