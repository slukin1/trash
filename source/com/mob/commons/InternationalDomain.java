package com.mob.commons;

import com.mob.tools.proguard.EverythingKeeper;

public enum InternationalDomain implements EverythingKeeper {
    JP("jp", "Japan"),
    US("us", "United States of America"),
    DEFAULT((String) null, (int) null);
    
    private String domain;
    private String region;

    private InternationalDomain(String str, String str2) {
        this.domain = str;
        this.region = str2;
    }

    public static InternationalDomain domainOf(String str) {
        if (str == null) {
            return DEFAULT;
        }
        for (InternationalDomain internationalDomain : values()) {
            if (str.equalsIgnoreCase(internationalDomain.domain)) {
                return internationalDomain;
            }
        }
        return DEFAULT;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getRegion() {
        return this.region;
    }
}
