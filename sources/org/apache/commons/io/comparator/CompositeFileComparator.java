package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompositeFileComparator extends a implements Serializable {
    private static final Comparator<?>[] NO_COMPARATORS = new Comparator[0];
    private static final long serialVersionUID = -2224170307287243428L;
    private final Comparator<File>[] delegates;

    public CompositeFileComparator(Comparator<File>... comparatorArr) {
        if (comparatorArr == null) {
            this.delegates = NO_COMPARATORS;
            return;
        }
        Comparator<File>[] comparatorArr2 = new Comparator[comparatorArr.length];
        this.delegates = comparatorArr2;
        System.arraycopy(comparatorArr, 0, comparatorArr2, 0, comparatorArr.length);
    }

    public /* bridge */ /* synthetic */ List sort(List list) {
        return super.sort((List<File>) list);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append('{');
        for (int i11 = 0; i11 < this.delegates.length; i11++) {
            if (i11 > 0) {
                sb2.append(',');
            }
            sb2.append(this.delegates[i11]);
        }
        sb2.append('}');
        return sb2.toString();
    }

    public int compare(File file, File file2) {
        int i11 = 0;
        for (Comparator<File> compare : this.delegates) {
            i11 = compare.compare(file, file2);
            if (i11 != 0) {
                break;
            }
        }
        return i11;
    }

    public /* bridge */ /* synthetic */ File[] sort(File[] fileArr) {
        return super.sort(fileArr);
    }

    public CompositeFileComparator(Iterable<Comparator<File>> iterable) {
        if (iterable == null) {
            this.delegates = NO_COMPARATORS;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Comparator<File> add : iterable) {
            arrayList.add(add);
        }
        this.delegates = (Comparator[]) arrayList.toArray(new Comparator[arrayList.size()]);
    }
}
