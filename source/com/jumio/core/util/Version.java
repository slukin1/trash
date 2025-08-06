package com.jumio.core.util;

import kotlin.jvm.internal.x;
import kotlin.text.Regex;

public final class Version implements Comparable<Version> {

    /* renamed from: a  reason: collision with root package name */
    public final String f39506a;

    public Version(String str) {
        this.f39506a = str;
        if (!new Regex("[0-9]+(\\.[0-9]+)*").matches(str)) {
            throw new IllegalArgumentException("Invalid version format".toString());
        }
    }

    public static /* synthetic */ Version copy$default(Version version, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = version.f39506a;
        }
        return version.copy(str);
    }

    public final Version copy(String str) {
        return new Version(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (x.b(Version.class, obj.getClass()) && compareTo((Version) obj) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f39506a.hashCode();
    }

    public String toString() {
        return this.f39506a;
    }

    public int compareTo(Version version) {
        if (version == null) {
            return 1;
        }
        String[] strArr = (String[]) new Regex("\\.").split(this.f39506a, 0).toArray(new String[0]);
        String[] strArr2 = (String[]) new Regex("\\.").split(version.f39506a, 0).toArray(new String[0]);
        int d11 = RangesKt___RangesKt.d(strArr.length, strArr2.length);
        int i11 = 0;
        while (i11 < d11) {
            int parseInt = i11 < strArr.length ? Integer.parseInt(strArr[i11]) : 0;
            int parseInt2 = i11 < strArr2.length ? Integer.parseInt(strArr2[i11]) : 0;
            if (parseInt < parseInt2) {
                return -1;
            }
            if (parseInt > parseInt2) {
                return 1;
            }
            i11++;
        }
        return 0;
    }
}
