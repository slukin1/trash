package net.lingala.zip4j.unzip;

import java.io.File;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.util.Zip4jUtil;

public class UnzipUtil {
    public static void a(FileHeader fileHeader, File file, UnzipParameters unzipParameters) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("cannot set file properties: file header is null");
        } else if (file == null) {
            throw new ZipException("cannot set file properties: output file is null");
        } else if (Zip4jUtil.a(file)) {
            if (unzipParameters == null || !unzipParameters.c()) {
                c(fileHeader, file);
            }
            if (unzipParameters == null) {
                b(fileHeader, file, true, true, true, true);
            } else if (unzipParameters.a()) {
                b(fileHeader, file, false, false, false, false);
            } else {
                b(fileHeader, file, !unzipParameters.e(), !unzipParameters.d(), !unzipParameters.b(), !unzipParameters.f());
            }
        } else {
            throw new ZipException("cannot set file properties: file doesnot exist");
        }
    }

    public static void b(FileHeader fileHeader, File file, boolean z11, boolean z12, boolean z13, boolean z14) throws ZipException {
        if (fileHeader != null) {
            byte[] h11 = fileHeader.h();
            if (h11 != null) {
                byte b11 = h11[0];
                if (b11 != 1) {
                    if (b11 != 2) {
                        if (b11 == 3) {
                            if (z11) {
                                Zip4jUtil.l(file);
                            }
                            if (z12) {
                                Zip4jUtil.k(file);
                                return;
                            }
                            return;
                        } else if (b11 != 18) {
                            if (b11 != 38) {
                                if (b11 != 48) {
                                    if (b11 != 50) {
                                        switch (b11) {
                                            case 32:
                                                break;
                                            case 33:
                                                if (z13) {
                                                    Zip4jUtil.j(file);
                                                }
                                                if (z11) {
                                                    Zip4jUtil.l(file);
                                                    return;
                                                }
                                                return;
                                            case 34:
                                                break;
                                            case 35:
                                                if (z13) {
                                                    Zip4jUtil.j(file);
                                                }
                                                if (z11) {
                                                    Zip4jUtil.l(file);
                                                }
                                                if (z12) {
                                                    Zip4jUtil.k(file);
                                                    return;
                                                }
                                                return;
                                            default:
                                                return;
                                        }
                                    }
                                    if (z13) {
                                        Zip4jUtil.j(file);
                                    }
                                    if (z12) {
                                        Zip4jUtil.k(file);
                                        return;
                                    }
                                    return;
                                }
                                if (z13) {
                                    Zip4jUtil.j(file);
                                    return;
                                }
                                return;
                            }
                            if (z11) {
                                Zip4jUtil.l(file);
                            }
                            if (z12) {
                                Zip4jUtil.k(file);
                            }
                            if (z14) {
                                Zip4jUtil.m(file);
                                return;
                            }
                            return;
                        }
                    }
                    if (z12) {
                        Zip4jUtil.k(file);
                    }
                } else if (z11) {
                    Zip4jUtil.l(file);
                }
            }
        } else {
            throw new ZipException("invalid file header. cannot set file attributes");
        }
    }

    public static void c(FileHeader fileHeader, File file) throws ZipException {
        if (fileHeader.l() > 0 && file.exists()) {
            file.setLastModified(Zip4jUtil.f(fileHeader.l()));
        }
    }
}
