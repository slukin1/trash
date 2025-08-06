package org.apache.commons.io.filefilter;

import com.iproov.sdk.bridge.OptionsBridge;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import t10.a;

public class OrFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 5767770777065432721L;
    private final List<a> fileFilters;

    public OrFileFilter() {
        this.fileFilters = new ArrayList();
    }

    public boolean accept(File file) {
        for (a accept : this.fileFilters) {
            if (accept.accept(file)) {
                return true;
            }
        }
        return false;
    }

    public void addFileFilter(a aVar) {
        this.fileFilters.add(aVar);
    }

    public List<a> getFileFilters() {
        return Collections.unmodifiableList(this.fileFilters);
    }

    public boolean removeFileFilter(a aVar) {
        return this.fileFilters.remove(aVar);
    }

    public void setFileFilters(List<a> list) {
        this.fileFilters.clear();
        this.fileFilters.addAll(list);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("(");
        if (this.fileFilters != null) {
            for (int i11 = 0; i11 < this.fileFilters.size(); i11++) {
                if (i11 > 0) {
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                a aVar = this.fileFilters.get(i11);
                if (aVar == null) {
                    str = OptionsBridge.NULL_VALUE;
                } else {
                    str = aVar.toString();
                }
                sb2.append(str);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    public OrFileFilter(List<a> list) {
        if (list == null) {
            this.fileFilters = new ArrayList();
        } else {
            this.fileFilters = new ArrayList(list);
        }
    }

    public boolean accept(File file, String str) {
        for (a accept : this.fileFilters) {
            if (accept.accept(file, str)) {
                return true;
            }
        }
        return false;
    }

    public OrFileFilter(a aVar, a aVar2) {
        if (aVar == null || aVar2 == null) {
            throw new IllegalArgumentException("The filters must not be null");
        }
        this.fileFilters = new ArrayList(2);
        addFileFilter(aVar);
        addFileFilter(aVar2);
    }
}
