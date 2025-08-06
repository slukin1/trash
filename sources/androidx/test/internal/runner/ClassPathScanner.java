package androidx.test.internal.runner;

import com.amazonaws.services.s3.model.InstructionFileId;
import dalvik.system.DexFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ClassPathScanner {

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f11393a;

    public static class AcceptAllFilter implements ClassNameFilter {
        public boolean a(String str) {
            return true;
        }
    }

    public static class ChainedClassNameFilter implements ClassNameFilter {

        /* renamed from: a  reason: collision with root package name */
        public final List<ClassNameFilter> f11394a = new ArrayList();

        public boolean a(String str) {
            for (ClassNameFilter a11 : this.f11394a) {
                if (!a11.a(str)) {
                    return false;
                }
            }
            return true;
        }

        public void b(ClassNameFilter classNameFilter) {
            this.f11394a.add(classNameFilter);
        }
    }

    public interface ClassNameFilter {
        boolean a(String str);
    }

    public static class ExcludeClassNamesFilter implements ClassNameFilter {

        /* renamed from: a  reason: collision with root package name */
        public Set<String> f11395a;

        public ExcludeClassNamesFilter(Set<String> set) {
            this.f11395a = set;
        }

        public boolean a(String str) {
            return !this.f11395a.contains(str);
        }
    }

    public static class ExcludePackageNameFilter implements ClassNameFilter {

        /* renamed from: a  reason: collision with root package name */
        public final String f11396a;

        public ExcludePackageNameFilter(String str) {
            if (!str.endsWith(InstructionFileId.DOT)) {
                this.f11396a = String.format("%s.", new Object[]{str});
                return;
            }
            this.f11396a = str;
        }

        public boolean a(String str) {
            return !str.startsWith(this.f11396a);
        }
    }

    public static class ExternalClassNameFilter implements ClassNameFilter {
        public boolean a(String str) {
            return !str.contains("$");
        }
    }

    public static class InclusivePackageNamesFilter implements ClassNameFilter {

        /* renamed from: a  reason: collision with root package name */
        public final Collection<String> f11397a;

        public InclusivePackageNamesFilter(Collection<String> collection) {
            this.f11397a = new ArrayList(collection.size());
            for (String next : collection) {
                if (!next.endsWith(InstructionFileId.DOT)) {
                    this.f11397a.add(String.format("%s.", new Object[]{next}));
                } else {
                    this.f11397a.add(next);
                }
            }
        }

        public boolean a(String str) {
            for (String startsWith : this.f11397a) {
                if (str.startsWith(startsWith)) {
                    return true;
                }
            }
            return false;
        }
    }

    public ClassPathScanner(Collection<String> collection) {
        HashSet hashSet = new HashSet();
        this.f11393a = hashSet;
        hashSet.addAll(collection);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.Set<java.lang.String> r4, java.lang.String r5, androidx.test.internal.runner.ClassPathScanner.ClassNameFilter r6) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            dalvik.system.DexFile r1 = new dalvik.system.DexFile     // Catch:{ all -> 0x0027 }
            r1.<init>(r5)     // Catch:{ all -> 0x0027 }
            java.util.Enumeration r5 = r3.c(r1)     // Catch:{ all -> 0x0024 }
        L_0x000a:
            boolean r0 = r5.hasMoreElements()     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0020
            java.lang.Object r0 = r5.nextElement()     // Catch:{ all -> 0x0024 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0024 }
            boolean r2 = r6.a(r0)     // Catch:{ all -> 0x0024 }
            if (r2 == 0) goto L_0x000a
            r4.add(r0)     // Catch:{ all -> 0x0024 }
            goto L_0x000a
        L_0x0020:
            r1.close()
            return
        L_0x0024:
            r4 = move-exception
            r0 = r1
            goto L_0x0028
        L_0x0027:
            r4 = move-exception
        L_0x0028:
            if (r0 == 0) goto L_0x002d
            r0.close()
        L_0x002d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.internal.runner.ClassPathScanner.a(java.util.Set, java.lang.String, androidx.test.internal.runner.ClassPathScanner$ClassNameFilter):void");
    }

    public Set<String> b(ClassNameFilter classNameFilter) throws IOException {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String a11 : this.f11393a) {
            a(linkedHashSet, a11, classNameFilter);
        }
        return linkedHashSet;
    }

    public Enumeration<String> c(DexFile dexFile) {
        return dexFile.entries();
    }
}
