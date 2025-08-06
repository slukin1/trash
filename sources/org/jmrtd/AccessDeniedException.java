package org.jmrtd;

import net.sf.scuba.smartcards.CardServiceException;

@Deprecated
public class AccessDeniedException extends CardServiceException {
    private static final long serialVersionUID = -7094953658210693249L;
    private final AccessKeySpec bacKey;

    public AccessDeniedException(String str, int i11) {
        this(str, (AccessKeySpec) null, i11);
    }

    public AccessKeySpec getAccessKey() {
        return this.bacKey;
    }

    public AccessDeniedException(String str, AccessKeySpec accessKeySpec, int i11) {
        super(str, i11);
        this.bacKey = accessKeySpec;
    }
}
