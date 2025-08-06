package com.hbg.module.content.utls.comment;

import android.app.Dialog;
import android.net.Uri;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
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
import d10.u;
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
import rc.a;
import v7.b;

public final class CommentExtKt$createCommentDialog$sendFunction$1 extends Lambda implements l<String, Unit> {
    public final /* synthetic */ Dialog $dialog;
    public final /* synthetic */ String $firstLevelId;
    public final /* synthetic */ FrameLayout $flShowImage;
    public final /* synthetic */ a $listener;
    public final /* synthetic */ String $parentId;
    public final /* synthetic */ Ref$ObjectRef<String> $picUrl;
    public final /* synthetic */ FragmentActivity $this_createCommentDialog;
    public final /* synthetic */ String $topicId;
    public final /* synthetic */ String $topicType;
    public final /* synthetic */ Ref$ObjectRef<String> $upLoadName;
    public final /* synthetic */ Ref$ObjectRef<Uri> $upLoadUri;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentExtKt$createCommentDialog$sendFunction$1(FrameLayout frameLayout, Ref$ObjectRef<Uri> ref$ObjectRef, String str, String str2, String str3, String str4, Dialog dialog, FragmentActivity fragmentActivity, a aVar, Ref$ObjectRef<String> ref$ObjectRef2, Ref$ObjectRef<String> ref$ObjectRef3) {
        super(1);
        this.$flShowImage = frameLayout;
        this.$upLoadUri = ref$ObjectRef;
        this.$topicId = str;
        this.$topicType = str2;
        this.$firstLevelId = str3;
        this.$parentId = str4;
        this.$dialog = dialog;
        this.$this_createCommentDialog = fragmentActivity;
        this.$listener = aVar;
        this.$picUrl = ref$ObjectRef2;
        this.$upLoadName = ref$ObjectRef3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.f56620a;
    }

    public final void invoke(String str) {
        final CommentExtKt$createCommentDialog$sendFunction$1$saveAction$1 commentExtKt$createCommentDialog$sendFunction$1$saveAction$1 = new CommentExtKt$createCommentDialog$sendFunction$1$saveAction$1(this.$dialog, this.$this_createCommentDialog, this.$listener);
        if (this.$flShowImage.getVisibility() != 0 || this.$upLoadUri.element == null) {
            commentExtKt$createCommentDialog$sendFunction$1$saveAction$1.invoke(this.$topicId, this.$topicType, str, this.$firstLevelId, this.$parentId, null, "");
            return;
        }
        d9.a<S3TokenBean> s3Token = b.a().getS3Token();
        final Ref$ObjectRef<Uri> ref$ObjectRef = this.$upLoadUri;
        final FragmentActivity fragmentActivity = this.$this_createCommentDialog;
        final Ref$ObjectRef<String> ref$ObjectRef2 = this.$picUrl;
        final String str2 = this.$topicId;
        final String str3 = this.$topicType;
        final String str4 = this.$firstLevelId;
        final String str5 = this.$parentId;
        final Ref$ObjectRef<String> ref$ObjectRef3 = this.$upLoadName;
        final String str6 = str;
        AnonymousClass1 r02 = new l<S3TokenBean, Unit>() {

            @kotlin.coroutines.jvm.internal.d(c = "com.hbg.module.content.utls.comment.CommentExtKt$createCommentDialog$sendFunction$1$1$3", f = "CommentExt.kt", l = {}, m = "invokeSuspend")
            /* renamed from: com.hbg.module.content.utls.comment.CommentExtKt$createCommentDialog$sendFunction$1$1$3  reason: invalid class name */
            public static final class AnonymousClass3 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
                public int label;

                public final c<Unit> create(Object obj, c<?> cVar) {
                    return new AnonymousClass3(s3TokenBean3, ref$ObjectRef2, ref$ObjectRef3, ref$ObjectRef4, uVar2, str7, str8, str9, str10, str11, fragmentActivity, cVar);
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
                            S3Credentials credentials = s3TokenBean3.getCredentials();
                            Integer num = null;
                            String accessKeyId = credentials != null ? credentials.getAccessKeyId() : null;
                            S3Credentials credentials2 = s3TokenBean3.getCredentials();
                            String secretAccessKey = credentials2 != null ? credentials2.getSecretAccessKey() : null;
                            S3Credentials credentials3 = s3TokenBean3.getCredentials();
                            AmazonS3Client amazonS3Client = new AmazonS3Client((AWSCredentials) new BasicSessionCredentials(accessKeyId, secretAccessKey, credentials3 != null ? credentials3.getSessionToken() : null), Region.e(Regions.fromName(s3TokenBean3.getRegionName())), clientConfiguration);
                            amazonS3Client.w("https://s3." + s3TokenBean3.getRegionName() + ".amazonaws.com");
                            Uri uri = (Uri) ref$ObjectRef2.element;
                            InputStream openInputStream = uri != null ? fragmentActivity.getContentResolver().openInputStream(uri) : null;
                            String str = s3TokenBean3.getPath() + '/' + ((String) ref$ObjectRef3.element);
                            ObjectMetadata objectMetadata = new ObjectMetadata();
                            if (openInputStream != null) {
                                num = kotlin.coroutines.jvm.internal.a.c(openInputStream.available());
                            }
                            objectMetadata.setContentLength((long) num.intValue());
                            amazonS3Client.d0(s3TokenBean3.getBucketName(), str, openInputStream, objectMetadata);
                            ref$ObjectRef4.element = DomainTool.DOMAIN_PREFIX + s3TokenBean3.getDomain() + '/' + str;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("picUrl = ");
                            sb2.append((String) ref$ObjectRef4.element);
                            d.c("SendComment", sb2.toString());
                            uVar2.invoke(str7, str8, str9, str10, str11, null, ref$ObjectRef4.element);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        return Unit.f56620a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((S3TokenBean) obj);
                return Unit.f56620a;
            }

            public final void invoke(S3TokenBean s3TokenBean) {
                S3TokenBean s3TokenBean2 = s3TokenBean;
                d.c("SendComment", "s3Token: onSuccess, it = " + s3TokenBean2);
                if (s3TokenBean2 != null) {
                    if (s3TokenBean.getUploadChannel() == 2) {
                        Uri uri = (Uri) ref$ObjectRef.element;
                        String str = null;
                        File file = uri != null ? S3UploadHelperKt.toFile(uri, fragmentActivity) : null;
                        RequestBody create = RequestBody.Companion.create(MediaType.Companion.parse("image/jpeg"), ImageCompressor.b(fragmentActivity, file, s3TokenBean.getMaxUploadFileSize()));
                        MultipartBody.Part.Companion companion = MultipartBody.Part.Companion;
                        if (file != null) {
                            str = file.getName();
                        }
                        d9.a<UploadFile> uploadFile = b.a().uploadFile(companion.createFormData("file", str, create));
                        final Ref$ObjectRef<String> ref$ObjectRef = ref$ObjectRef2;
                        final u<String, String, String, String, String, String, String, Unit> uVar = commentExtKt$createCommentDialog$sendFunction$1$saveAction$1;
                        final String str2 = str2;
                        final String str3 = str3;
                        final String str4 = str6;
                        final String str5 = str4;
                        final String str6 = str5;
                        RequestExtKt.d(uploadFile, new l<UploadFile, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((UploadFile) obj);
                                return Unit.f56620a;
                            }

                            public final void invoke(UploadFile uploadFile) {
                                T urlForDownload;
                                if (uploadFile != null && (urlForDownload = uploadFile.getUrlForDownload()) != null) {
                                    Ref$ObjectRef<String> ref$ObjectRef = ref$ObjectRef;
                                    u<String, String, String, String, String, String, String, Unit> uVar = uVar;
                                    String str = str2;
                                    String str2 = str3;
                                    String str3 = str4;
                                    String str4 = str5;
                                    String str5 = str6;
                                    ref$ObjectRef.element = urlForDownload;
                                    d.c("SendComment", "picUrl = " + ((String) ref$ObjectRef.element));
                                    uVar.invoke(str, str2, str3, str4, str5, null, ref$ObjectRef.element);
                                }
                            }
                        }, AnonymousClass2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
                        return;
                    }
                    h0 a11 = i0.a(v0.b());
                    final Ref$ObjectRef<Uri> ref$ObjectRef2 = ref$ObjectRef;
                    final Ref$ObjectRef<String> ref$ObjectRef3 = ref$ObjectRef3;
                    final Ref$ObjectRef<String> ref$ObjectRef4 = ref$ObjectRef2;
                    final u<String, String, String, String, String, String, String, Unit> uVar2 = commentExtKt$createCommentDialog$sendFunction$1$saveAction$1;
                    final String str7 = str2;
                    final String str8 = str3;
                    final String str9 = str6;
                    final String str10 = str4;
                    final String str11 = str5;
                    final FragmentActivity fragmentActivity = fragmentActivity;
                    final S3TokenBean s3TokenBean3 = s3TokenBean;
                    n1 unused = i.d(a11, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3((c<? super AnonymousClass3>) null), 3, (Object) null);
                }
            }
        };
        RequestExtKt.d(s3Token, r02, AnonymousClass2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }
}
