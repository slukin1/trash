package org.bouncycastle.asn1.eac;

import java.util.Enumeration;
import java.util.Hashtable;

public class Flags {
    public int value = 0;

    public static class StringJoiner {
        public boolean First = true;

        /* renamed from: b  reason: collision with root package name */
        public StringBuffer f59049b = new StringBuffer();
        public String mSeparator;

        public StringJoiner(String str) {
            this.mSeparator = str;
        }

        public void add(String str) {
            if (this.First) {
                this.First = false;
            } else {
                this.f59049b.append(this.mSeparator);
            }
            this.f59049b.append(str);
        }

        public String toString() {
            return this.f59049b.toString();
        }
    }

    public Flags() {
    }

    public Flags(int i11) {
        this.value = i11;
    }

    public String decode(Hashtable hashtable) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Integer num = (Integer) keys.nextElement();
            if (isSet(num.intValue())) {
                stringJoiner.add((String) hashtable.get(num));
            }
        }
        return stringJoiner.toString();
    }

    public int getFlags() {
        return this.value;
    }

    public boolean isSet(int i11) {
        return (i11 & this.value) != 0;
    }

    public void set(int i11) {
        this.value = i11 | this.value;
    }
}
