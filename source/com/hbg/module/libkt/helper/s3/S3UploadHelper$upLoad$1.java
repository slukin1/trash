package com.hbg.module.libkt.helper.s3;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.google.gson.Gson;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.network.hbg.core.bean.S3Credentials;
import com.hbg.lib.network.hbg.core.bean.S3TokenBean;
import com.hbg.lib.network.hbg.core.bean.UploadFile;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.helper.s3.S3UploadInterface;
import com.huobi.utils.ImageCompressor;
import d10.l;
import d10.p;
import d9.a;
import i6.d;
import java.io.File;
import java.io.InputStream;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import v7.b;

public final class S3UploadHelper$upLoad$1 extends Lambda implements l<S3TokenBean, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ S3UploadInterface $listener;
    public final /* synthetic */ String $upLoadName;
    public final /* synthetic */ Uri $upLoadUri;

    @kotlin.coroutines.jvm.internal.d(c = "com.hbg.module.libkt.helper.s3.S3UploadHelper$upLoad$1$3", f = "S3UploadHelper.kt", l = {145, 152}, m = "invokeSuspend")
    /* renamed from: com.hbg.module.libkt.helper.s3.S3UploadHelper$upLoad$1$3  reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass3(s3TokenBean2, uri, str, s3UploadInterface4, cVar);
        }

        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((AnonymousClass3) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.label;
            if (i11 == 0) {
                k.b(obj);
                ClientConfiguration clientConfiguration = new ClientConfiguration();
                S3Credentials credentials = s3TokenBean2.getCredentials();
                String accessKeyId = credentials != null ? credentials.getAccessKeyId() : null;
                S3Credentials credentials2 = s3TokenBean2.getCredentials();
                String secretAccessKey = credentials2 != null ? credentials2.getSecretAccessKey() : null;
                S3Credentials credentials3 = s3TokenBean2.getCredentials();
                AmazonS3Client amazonS3Client = new AmazonS3Client((AWSCredentials) new BasicSessionCredentials(accessKeyId, secretAccessKey, credentials3 != null ? credentials3.getSessionToken() : null), Region.e(Regions.fromName(s3TokenBean2.getRegionName())), clientConfiguration);
                amazonS3Client.g(new RequestHandler2() {
                    public void afterError(Request<?> request, Response<?> response, Exception exc) {
                        try {
                            RequestExtKt.d(b.a().T0(new Gson().toJson((Object) request), new Gson().toJson((Object) response != null ? response.b() : null)), S3UploadHelper$upLoad$1$3$1$afterError$1.INSTANCE, S3UploadHelper$upLoad$1$3$1$afterError$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }

                    public void afterResponse(Request<?> request, Response<?> response) {
                    }

                    public void beforeRequest(Request<?> request) {
                    }
                });
                amazonS3Client.w("https://s3." + s3TokenBean2.getRegionName() + ".amazonaws.com");
                InputStream openInputStream = BaseApplication.b().getContentResolver().openInputStream(uri);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(s3TokenBean2.getPath());
                sb2.append('/');
                String str2 = "";
                if (com.hbg.module.libkt.base.ext.b.x(str)) {
                    String uri = uri.toString();
                    if (StringsKt__StringsKt.g0(uri, InstructionFileId.DOT, 0, false, 6, (Object) null) >= 0) {
                        str2 = uri.substring(StringsKt__StringsKt.m0(uri, InstructionFileId.DOT, 0, false, 6, (Object) null));
                    }
                    str = System.currentTimeMillis() + str2;
                } else {
                    String str3 = str;
                    if ((str3 != null ? StringsKt__StringsKt.g0(str3, InstructionFileId.DOT, 0, false, 6, (Object) null) : -1) >= 0) {
                        String str4 = str;
                        str2 = str4 != null ? str4.substring(StringsKt__StringsKt.m0(str4, InstructionFileId.DOT, 0, false, 6, (Object) null)) : null;
                    }
                    str = MD5Utils.a(str) + str2;
                }
                sb2.append(str);
                final String sb3 = sb2.toString();
                ObjectMetadata objectMetadata = new ObjectMetadata();
                objectMetadata.setContentLength(openInputStream != null ? (long) openInputStream.available() : 0);
                amazonS3Client.d0(s3TokenBean2.getBucketName(), sb3, openInputStream, objectMetadata);
                MainCoroutineDispatcher c11 = v0.c();
                final S3UploadInterface s3UploadInterface = s3UploadInterface4;
                final S3TokenBean s3TokenBean = s3TokenBean2;
                AnonymousClass2 r52 = new p<h0, c<? super Unit>, Object>((c<? super AnonymousClass2>) null) {
                    public int label;

                    public final c<Unit> create(Object obj, c<?> cVar) {
                        return 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public S3UploadHelper$upLoad$1(Uri uri, Context context, S3UploadInterface s3UploadInterface, String str) {
                            super(1);
                            this.$upLoadUri = uri;
                            this.$context = context;
                            this.$listener = s3UploadInterface;
                            this.$upLoadName = str;
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((S3TokenBean) obj);
                            return Unit.f56620a;
                        }

                        public final void invoke(S3TokenBean s3TokenBean) {
                            if (s3TokenBean == null) {
                                S3UploadInterface s3UploadInterface = this.$listener;
                                if (s3UploadInterface != null) {
                                    S3UploadInterface.DefaultImpls.upLoadCallback$default(s3UploadInterface, 1, (String) null, (String) null, 6, (Object) null);
                                }
                            } else if (s3TokenBean.getUploadChannel() == 2) {
                                File file = S3UploadHelperKt.toFile(this.$upLoadUri, this.$context);
                                a<UploadFile> uploadFile = b.a().uploadFile(MultipartBody.Part.Companion.createFormData("file", file != null ? file.getName() : null, RequestBody.Companion.create(MediaType.Companion.parse("image/jpeg"), ImageCompressor.b(this.$context, file, s3TokenBean.getMaxUploadFileSize()))));
                                final S3UploadInterface s3UploadInterface2 = this.$listener;
                                AnonymousClass1 r22 = new l<UploadFile, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((UploadFile) obj);
                                        return Unit.f56620a;
                                    }

                                    public final void invoke(UploadFile uploadFile) {
                                        String urlForDownload;
                                        S3UploadInterface s3UploadInterface;
                                        if (uploadFile != null && (urlForDownload = uploadFile.getUrlForDownload()) != null && (s3UploadInterface = s3UploadInterface2) != null) {
                                            S3UploadInterface.DefaultImpls.upLoadCallback$default(s3UploadInterface, 0, (String) null, urlForDownload, 2, (Object) null);
                                        }
                                    }
                                };
                                final S3UploadInterface s3UploadInterface3 = this.$listener;
                                RequestExtKt.d(uploadFile, r22, new p<Throwable, APIStatusErrorException, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Throwable) obj, (APIStatusErrorException) obj2);
                                        return Unit.f56620a;
                                    }

                                    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
                                        String str;
                                        String errMsg;
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("upload :onError : ");
                                        String str2 = null;
                                        sb2.append(aPIStatusErrorException != null ? aPIStatusErrorException.getErrMsg() : null);
                                        d.c("SendComment", sb2.toString());
                                        if (aPIStatusErrorException != null) {
                                            HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
                                        }
                                        S3UploadInterface s3UploadInterface = s3UploadInterface3;
                                        if (s3UploadInterface != null) {
                                            if (aPIStatusErrorException == null || (errMsg = aPIStatusErrorException.getErrMsg()) == null) {
                                                if (th2 != null) {
                                                    str2 = th2.getMessage();
                                                }
                                                str = str2;
                                            } else {
                                                str = errMsg;
                                            }
                                            S3UploadInterface.DefaultImpls.upLoadCallback$default(s3UploadInterface, 1, str, (String) null, 4, (Object) null);
                                        }
                                    }
                                }, (MutableLiveData) null, 4, (Object) null);
                            } else {
                                h0 a11 = i0.a(v0.b());
                                final Uri uri = this.$upLoadUri;
                                final String str = this.$upLoadName;
                                final S3UploadInterface s3UploadInterface4 = this.$listener;
                                final S3TokenBean s3TokenBean2 = s3TokenBean;
                                n1 unused = i.d(a11, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3((c<? super AnonymousClass3>) null), 3, (Object) null);
                            }
                        }
                    }
