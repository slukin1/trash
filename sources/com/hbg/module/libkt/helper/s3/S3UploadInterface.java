package com.hbg.module.libkt.helper.s3;

public interface S3UploadInterface {

    public static final class DefaultImpls {
        public static /* synthetic */ void upLoadCallback$default(S3UploadInterface s3UploadInterface, int i11, String str, String str2, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    str = null;
                }
                if ((i12 & 4) != 0) {
                    str2 = null;
                }
                s3UploadInterface.upLoadCallback(i11, str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upLoadCallback");
        }
    }

    void upLoadCallback(int i11, String str, String str2);
}
