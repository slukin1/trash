package org.apache.commons.io.filefilter;

import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.IOCase;

public class PrefixFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 8533897440809599867L;
    private final IOCase caseSensitivity;
    private final String[] prefixes;

    public PrefixFileFilter(String str) {
        this(str, IOCase.SENSITIVE);
    }

    public boolean accept(File file) {
        String name = file.getName();
        for (String checkStartsWith : this.prefixes) {
            if (this.caseSensitivity.checkStartsWith(name, checkStartsWith)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("(");
        if (this.prefixes != null) {
            for (int i11 = 0; i11 < this.prefixes.length; i11++) {
                if (i11 > 0) {
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb2.append(this.prefixes[i11]);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    public PrefixFileFilter(String str, IOCase iOCase) {
        if (str != null) {
            this.prefixes = new String[]{str};
            this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
            return;
        }
        throw new IllegalArgumentException("The prefix must not be null");
    }

    public boolean accept(File file, String str) {
        for (String checkStartsWith : this.prefixes) {
            if (this.caseSensitivity.checkStartsWith(str, checkStartsWith)) {
                return true;
            }
        }
        return false;
    }

    public PrefixFileFilter(String[] strArr) {
        this(strArr, IOCase.SENSITIVE);
    }

    public PrefixFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr != null) {
            String[] strArr2 = new String[strArr.length];
            this.prefixes = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
            return;
        }
        throw new IllegalArgumentException("The array of prefixes must not be null");
    }

    public PrefixFileFilter(List<String> list) {
        this(list, IOCase.SENSITIVE);
    }

    public PrefixFileFilter(List<String> list, IOCase iOCase) {
        if (list != null) {
            this.prefixes = (String[]) list.toArray(new String[list.size()]);
            this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
            return;
        }
        throw new IllegalArgumentException("The list of prefixes must not be null");
    }
}
