package okio.internal;

import java.util.Comparator;

public final class ZipFilesKt$buildIndex$$inlined$sortedBy$1<T> implements Comparator {
    public final int compare(T t11, T t12) {
        return ComparisonsKt__ComparisonsKt.a(((ZipEntry) t11).getCanonicalPath(), ((ZipEntry) t12).getCanonicalPath());
    }
}
