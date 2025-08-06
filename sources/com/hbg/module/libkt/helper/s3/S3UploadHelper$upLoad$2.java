package com.hbg.module.libkt.helper.s3;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.libkt.helper.s3.S3UploadInterface;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class S3UploadHelper$upLoad$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ S3UploadInterface $listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public S3UploadHelper$upLoad$2(S3UploadInterface s3UploadInterface) {
        super(2);
        this.$listener = s3UploadInterface;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        String str;
        String errMsg;
        S3UploadInterface s3UploadInterface = this.$listener;
        if (s3UploadInterface != null) {
            if (aPIStatusErrorException == null || (errMsg = aPIStatusErrorException.getErrMsg()) == null) {
                str = th2 != null ? th2.getMessage() : null;
            } else {
                str = errMsg;
            }
            S3UploadInterface.DefaultImpls.upLoadCallback$default(s3UploadInterface, 1, str, (String) null, 4, (Object) null);
        }
    }
}
