package com.hbg.module.content.utls.comment;

import android.app.Activity;
import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.hbg.lib.network.hbg.core.bean.S3Credentials;
import com.hbg.lib.network.hbg.core.bean.S3TokenBean;
import com.hbg.lib.network.hbg.core.bean.UploadFile;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.helper.s3.S3UploadHelperKt;
import com.huobi.utils.ImageCompressor;
import com.huochat.community.network.domain.DomainTool;
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
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rc.b;

public final class CommentExtKt$createH5CommentDialog$6$onEditorAction$1 extends Lambda implements l<S3TokenBean, Unit> {
    public final /* synthetic */ String $content;
    public final /* synthetic */ Ref$ObjectRef<String> $imageUrl;
    public final /* synthetic */ b $listener;
    public final /* synthetic */ Activity $this_createH5CommentDialog;
    public final /* synthetic */ Ref$ObjectRef<String> $upLoadName;
    public final /* synthetic */ Ref$ObjectRef<Uri> $upLoadUri;

    @kotlin.coroutines.jvm.internal.d(c = "com.hbg.module.content.utls.comment.CommentExtKt$createH5CommentDialog$6$onEditorAction$1$3", f = "CommentExt.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.hbg.module.content.utls.comment.CommentExtKt$createH5CommentDialog$6$onEditorAction$1$3  reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass3(s3TokenBean2, ref$ObjectRef2, ref$ObjectRef3, ref$ObjectRef4, bVar2, str3, activity, cVar);
        }

        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((AnonymousClass3) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.label == 0) {
                k.b(obj);
                try {
                    ClientConfiguration clientConfiguration = new ClientConfiguration();
                    S3Credentials credentials = s3TokenBean2.getCredentials();
                    Integer num = null;
                    String accessKeyId = credentials != null ? credentials.getAccessKeyId() : null;
                    S3Credentials credentials2 = s3TokenBean2.getCredentials();
                    String secretAccessKey = credentials2 != null ? credentials2.getSecretAccessKey() : null;
                    S3Credentials credentials3 = s3TokenBean2.getCredentials();
                    AmazonS3Client amazonS3Client = new AmazonS3Client((AWSCredentials) new BasicSessionCredentials(accessKeyId, secretAccessKey, credentials3 != null ? credentials3.getSessionToken() : null), Region.e(Regions.fromName(s3TokenBean2.getRegionName())), clientConfiguration);
                    amazonS3Client.w("https://s3." + s3TokenBean2.getRegionName() + ".amazonaws.com");
                    Uri uri = (Uri) ref$ObjectRef2.element;
                    InputStream openInputStream = uri != null ? activity.getContentResolver().openInputStream(uri) : null;
                    String str = s3TokenBean2.getPath() + '/' + ((String) ref$ObjectRef3.element);
                    ObjectMetadata objectMetadata = new ObjectMetadata();
                    if (openInputStream != null) {
                        num = kotlin.coroutines.jvm.internal.a.c(openInputStream.available());
                    }
                    objectMetadata.setContentLength((long) num.intValue());
                    amazonS3Client.d0(s3TokenBean2.getBucketName(), str, openInputStream, objectMetadata);
                    ref$ObjectRef4.element = DomainTool.DOMAIN_PREFIX + s3TokenBean2.getDomain() + '/' + str;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("picUrl = ");
                    sb2.append((String) ref$ObjectRef4.element);
                    d.c("SendComment", sb2.toString());
                    b bVar = bVar2;
                    if (bVar != null) {
                        bVar.a(str3, (String) ref$ObjectRef4.element);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentExtKt$createH5CommentDialog$6$onEditorAction$1(Ref$ObjectRef<Uri> ref$ObjectRef, Activity activity, Ref$ObjectRef<String> ref$ObjectRef2, b bVar, String str, Ref$ObjectRef<String> ref$ObjectRef3) {
        super(1);
        this.$upLoadUri = ref$ObjectRef;
        this.$this_createH5CommentDialog = activity;
        this.$imageUrl = ref$ObjectRef2;
        this.$listener = bVar;
        this.$content = str;
        this.$upLoadName = ref$ObjectRef3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((S3TokenBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(S3TokenBean s3TokenBean) {
        d.c("SendComment", "s3Token: onSuccess, it = " + s3TokenBean);
        if (s3TokenBean != null) {
            if (s3TokenBean.getUploadChannel() == 2) {
                Uri uri = (Uri) this.$upLoadUri.element;
                String str = null;
                File file = uri != null ? S3UploadHelperKt.toFile(uri, this.$this_createH5CommentDialog) : null;
                RequestBody create = RequestBody.Companion.create(MediaType.Companion.parse("image/jpeg"), ImageCompressor.b(this.$this_createH5CommentDialog, file, s3TokenBean.getMaxUploadFileSize()));
                MultipartBody.Part.Companion companion = MultipartBody.Part.Companion;
                if (file != null) {
                    str = file.getName();
                }
                a<UploadFile> uploadFile = v7.b.a().uploadFile(companion.createFormData("file", str, create));
                final Ref$ObjectRef<String> ref$ObjectRef = this.$imageUrl;
                final b bVar = this.$listener;
                final String str2 = this.$content;
                RequestExtKt.d(uploadFile, new l<UploadFile, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((UploadFile) obj);
                        return Unit.f56620a;
                    }

                    public final void invoke(UploadFile uploadFile) {
                        T urlForDownload;
                        if (uploadFile != null && (urlForDownload = uploadFile.getUrlForDownload()) != null) {
                            Ref$ObjectRef<String> ref$ObjectRef = ref$ObjectRef;
                            b bVar = bVar;
                            String str = str2;
                            ref$ObjectRef.element = urlForDownload;
                            d.c("SendComment", "picUrl = " + ((String) ref$ObjectRef.element));
                            if (bVar != null) {
                                bVar.a(str, (String) ref$ObjectRef.element);
                            }
                        }
                    }
                }, AnonymousClass2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
                return;
            }
            h0 a11 = i0.a(v0.b());
            final Ref$ObjectRef<Uri> ref$ObjectRef2 = this.$upLoadUri;
            final Ref$ObjectRef<String> ref$ObjectRef3 = this.$upLoadName;
            final Ref$ObjectRef<String> ref$ObjectRef4 = this.$imageUrl;
            final b bVar2 = this.$listener;
            final String str3 = this.$content;
            final Activity activity = this.$this_createH5CommentDialog;
            final S3TokenBean s3TokenBean2 = s3TokenBean;
            n1 unused = i.d(a11, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3((c<? super AnonymousClass3>) null), 3, (Object) null);
        }
    }
}
