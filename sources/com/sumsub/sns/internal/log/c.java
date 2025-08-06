package com.sumsub.sns.internal.log;

public final class c {
    public static final String a(Object obj) {
        if (!obj.getClass().isAnonymousClass()) {
            String simpleName = obj.getClass().getSimpleName();
            if (simpleName.length() <= 23) {
                return simpleName;
            }
            return simpleName.substring(0, 23);
        }
        String name = obj.getClass().getName();
        return name.length() <= 23 ? name : name.substring(name.length() - 23, name.length());
    }
}
