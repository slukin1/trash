package com.kakao.sdk.share;

import android.content.Context;
import com.kakao.sdk.network.ApiCallback;
import com.kakao.sdk.network.ApiFactory;
import com.kakao.sdk.share.model.ImageUploadResult;
import com.kakao.sdk.share.model.SharingResult;
import com.kakao.sdk.share.model.ValidationResult;
import com.kakao.sdk.template.model.DefaultTemplate;
import com.luck.picture.lib.config.SelectMimeType;
import d10.p;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.r;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0016B\u001b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0019¢\u0006\u0004\b\u001f\u0010 JN\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u001c\u0010\r\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\tH\u0007J8\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u001c\u0010\r\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\tH\u0007R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/kakao/sdk/share/ShareClient;", "", "Landroid/content/Context;", "context", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "defaultTemplate", "", "", "serverCallbackArgs", "Lkotlin/Function2;", "Lcom/kakao/sdk/share/model/SharingResult;", "", "", "callback", "d", "Ljava/io/File;", "image", "", "secureResource", "Lcom/kakao/sdk/share/model/ImageUploadResult;", "e", "Lcom/kakao/sdk/share/ShareApi;", "a", "Lcom/kakao/sdk/share/ShareApi;", "shareApi", "Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "b", "Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "c", "()Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "kakaotalkShareIntentClient", "<init>", "(Lcom/kakao/sdk/share/ShareApi;Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;)V", "share_release"}, k = 1, mv = {1, 6, 0})
public final class ShareClient {

    /* renamed from: c  reason: collision with root package name */
    public static final a f25132c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final i<ShareClient> f25133d = LazyKt__LazyJVMKt.a(ShareClient$Companion$instance$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public final ShareApi f25134a;

    /* renamed from: b  reason: collision with root package name */
    public final KakaoTalkShareIntentClient f25135b;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0002¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/kakao/sdk/share/ShareClient$a;", "", "Lcom/kakao/sdk/share/ShareClient;", "instance$delegate", "Lkotlin/i;", "a", "()Lcom/kakao/sdk/share/ShareClient;", "getInstance$annotations", "()V", "instance", "<init>", "share_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final ShareClient a() {
            return (ShareClient) ShareClient.f25133d.getValue();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, d2 = {"com/kakao/sdk/share/ShareClient$b", "Lcom/kakao/sdk/network/ApiCallback;", "Lcom/kakao/sdk/share/model/ValidationResult;", "model", "", "error", "", "c", "share_release"}, k = 1, mv = {1, 6, 0})
    public static final class b extends ApiCallback<ValidationResult> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ p<SharingResult, Throwable, Unit> f25136c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ShareClient f25137d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f25138e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f25139f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(p<? super SharingResult, ? super Throwable, Unit> pVar, ShareClient shareClient, Context context, Map<String, String> map) {
            super(false, 1, (r) null);
            this.f25136c = pVar;
            this.f25137d = shareClient;
            this.f25138e = context;
            this.f25139f = map;
        }

        /* renamed from: c */
        public void b(ValidationResult validationResult, Throwable th2) {
            if (validationResult != null) {
                try {
                    this.f25136c.invoke(KakaoTalkShareIntentClient.e(this.f25137d.c(), this.f25138e, validationResult, this.f25139f, (String) null, (String) null, 24, (Object) null), null);
                } catch (Throwable th3) {
                    this.f25136c.invoke(null, th3);
                }
            } else {
                this.f25136c.invoke(null, th2);
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, d2 = {"com/kakao/sdk/share/ShareClient$c", "Lcom/kakao/sdk/network/ApiCallback;", "Lcom/kakao/sdk/share/model/ImageUploadResult;", "model", "", "error", "", "c", "share_release"}, k = 1, mv = {1, 6, 0})
    public static final class c extends ApiCallback<ImageUploadResult> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ p<ImageUploadResult, Throwable, Unit> f25140c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(p<? super ImageUploadResult, ? super Throwable, Unit> pVar) {
            super(false, 1, (r) null);
            this.f25140c = pVar;
        }

        /* renamed from: c */
        public void b(ImageUploadResult imageUploadResult, Throwable th2) {
            this.f25140c.invoke(imageUploadResult, th2);
        }
    }

    public ShareClient() {
        this((ShareApi) null, (KakaoTalkShareIntentClient) null, 3, (r) null);
    }

    public ShareClient(ShareApi shareApi, KakaoTalkShareIntentClient kakaoTalkShareIntentClient) {
        this.f25134a = shareApi;
        this.f25135b = kakaoTalkShareIntentClient;
    }

    public static final ShareClient b() {
        return f25132c.a();
    }

    public final KakaoTalkShareIntentClient c() {
        return this.f25135b;
    }

    public final void d(Context context, DefaultTemplate defaultTemplate, Map<String, String> map, p<? super SharingResult, ? super Throwable, Unit> pVar) {
        this.f25134a.validateDefault(defaultTemplate).enqueue(new b(pVar, this, context, map));
    }

    public final void e(File file, boolean z11, p<? super ImageUploadResult, ? super Throwable, Unit> pVar) {
        this.f25134a.uploadImage(MultipartBody.Part.Companion.createFormData("file", file.getName(), RequestBody.Companion.create(file, MediaType.Companion.get(SelectMimeType.SYSTEM_IMAGE))), Boolean.valueOf(z11)).enqueue(new c(pVar));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShareClient(ShareApi shareApi, KakaoTalkShareIntentClient kakaoTalkShareIntentClient, int i11, r rVar) {
        this((i11 & 1) != 0 ? (ShareApi) ApiFactory.f25114a.c().create(ShareApi.class) : shareApi, (i11 & 2) != 0 ? KakaoTalkShareIntentClient.f25127d.a() : kakaoTalkShareIntentClient);
    }
}
