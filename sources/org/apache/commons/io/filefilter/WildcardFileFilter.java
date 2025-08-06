package org.apache.commons.io.filefilter;

import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

public class WildcardFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -7426486598995782105L;
    private final IOCase caseSensitivity;
    private final String[] wildcards;

    public WildcardFileFilter(String str) {
        this(str, IOCase.SENSITIVE);
    }

    public boolean accept(File file, String str) {
        for (String g11 : this.wildcards) {
            if (FilenameUtils.g(str, g11, this.caseSensitivity)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("(");
        if (this.wildcards != null) {
            for (int i11 = 0; i11 < this.wildcards.length; i11++) {
                if (i11 > 0) {
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb2.append(this.wildcards[i11]);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    public WildcardFileFilter(String str, IOCase iOCase) {
        if (str != null) {
            this.wildcards = new String[]{str};
            this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
            return;
        }
        throw new IllegalArgumentException("The wildcard must not be null");
    }

    public boolean accept(File file) {
        String name = file.getName();
        for (String g11 : this.wildcards) {
            if (FilenameUtils.g(name, g11, this.caseSensitivity)) {
                return true;
            }
        }
        return false;
    }

    public WildcardFileFilter(String[] strArr) {
        this(strArr, IOCase.SENSITIVE);
    }

    public WildcardFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr != null) {
            String[] strArr2 = new String[strArr.length];
            this.wildcards = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
            return;
        }
        throw new IllegalArgumentException("The wildcard array must not be null");
    }

    public WildcardFileFilter(List<String> list) {
        this(list, IOCase.SENSITIVE);
    }

    public WildcardFileFilter(List<String> list, IOCase iOCase) {
        if (list != null) {
            this.wildcards = (String[]) list.toArray(new String[list.size()]);
            this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
            return;
        }
        throw new IllegalArgumentException("The wildcard list must not be null");
    }
}
