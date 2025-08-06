package com.nostra13.universalimageloader.cache.disc.naming;

import lx.a;

public class HashCodeFileNameGenerator implements a {
    public String a(String str) {
        return String.valueOf(str.hashCode());
    }
}
