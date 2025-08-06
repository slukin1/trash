package n10;

import java.io.File;
import java.util.ArrayList;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.Zip4jUtil;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public ZipModel f58297a;

    /* renamed from: n10.a$a  reason: collision with other inner class name */
    public class C0674a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f58298b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnzipParameters f58299c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ProgressMonitor f58300d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f58301e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0674a(String str, ArrayList arrayList, UnzipParameters unzipParameters, ProgressMonitor progressMonitor, String str2) {
            super(str);
            this.f58298b = arrayList;
            this.f58299c = unzipParameters;
            this.f58300d = progressMonitor;
            this.f58301e = str2;
        }

        public void run() {
            try {
                a.this.e(this.f58298b, this.f58299c, this.f58300d, this.f58301e);
                this.f58300d.b();
            } catch (ZipException unused) {
            }
        }
    }

    public a(ZipModel zipModel) throws ZipException {
        if (zipModel != null) {
            this.f58297a = zipModel;
            return;
        }
        throw new ZipException("ZipModel is null");
    }

    public final long b(ArrayList arrayList) throws ZipException {
        long j11;
        if (arrayList != null) {
            long j12 = 0;
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                FileHeader fileHeader = (FileHeader) arrayList.get(i11);
                if (fileHeader.p() == null || fileHeader.p().d() <= 0) {
                    j11 = fileHeader.b();
                } else {
                    j11 = fileHeader.p().a();
                }
                j12 += j11;
            }
            return j12;
        }
        throw new ZipException("fileHeaders is null, cannot calculate total work");
    }

    public final void c(FileHeader fileHeader, String str, String str2) throws ZipException {
        if (fileHeader == null || !Zip4jUtil.h(str)) {
            throw new ZipException("Cannot check output directory structure...one of the parameters was null");
        }
        String k11 = fileHeader.k();
        if (!Zip4jUtil.h(str2)) {
            str2 = k11;
        }
        if (Zip4jUtil.h(str2)) {
            try {
                File file = new File(new File(str + str2).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e11) {
                throw new ZipException((Throwable) e11);
            }
        }
    }

    public void d(UnzipParameters unzipParameters, String str, ProgressMonitor progressMonitor, boolean z11) throws ZipException {
        CentralDirectory b11 = this.f58297a.b();
        if (b11 == null || b11.a() == null) {
            throw new ZipException("invalid central directory in zipModel");
        }
        ArrayList a11 = b11.a();
        progressMonitor.f(1);
        progressMonitor.j(b(a11));
        progressMonitor.i(1);
        if (z11) {
            new C0674a("Zip4j", a11, unzipParameters, progressMonitor, str).start();
        } else {
            e(a11, unzipParameters, progressMonitor, str);
        }
    }

    public final void e(ArrayList arrayList, UnzipParameters unzipParameters, ProgressMonitor progressMonitor, String str) throws ZipException {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            f((FileHeader) arrayList.get(i11), str, unzipParameters, (String) null, progressMonitor);
            if (progressMonitor.d()) {
                progressMonitor.h(3);
                progressMonitor.i(0);
                return;
            }
        }
    }

    public final void f(FileHeader fileHeader, String str, UnzipParameters unzipParameters, String str2, ProgressMonitor progressMonitor) throws ZipException {
        if (fileHeader != null) {
            try {
                progressMonitor.g(fileHeader.k());
                String str3 = o10.a.f58788b;
                if (!str.endsWith(str3)) {
                    str = str + str3;
                }
                if (fileHeader.q()) {
                    String k11 = fileHeader.k();
                    if (Zip4jUtil.h(k11)) {
                        File file = new File(str + k11);
                        if (!file.exists()) {
                            file.mkdirs();
                            return;
                        }
                        return;
                    }
                    return;
                }
                c(fileHeader, str, str2);
                new b(this.f58297a, fileHeader).t(progressMonitor, str, str2, unzipParameters);
            } catch (Exception e11) {
                progressMonitor.a(e11);
                throw new ZipException((Throwable) e11);
            } catch (Exception e12) {
                progressMonitor.a(e12);
                throw new ZipException((Throwable) e12);
            } catch (ZipException e13) {
                progressMonitor.a(e13);
                throw e13;
            } catch (Exception e14) {
                progressMonitor.a(e14);
                throw new ZipException((Throwable) e14);
            }
        } else {
            throw new ZipException("fileHeader is null");
        }
    }
}
