package com.business.common.airdrop;

import android.content.Context;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.hbg.module.libkt.utils.i;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import d10.p;
import java.io.File;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

@d(c = "com.business.common.airdrop.AirdropManager$downloadAnimation$2", f = "AirdropManager.kt", l = {}, m = "invokeSuspend")
public final class AirdropManager$downloadAnimation$2 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $url;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirdropManager$downloadAnimation$2(String str, Context context, c<? super AirdropManager$downloadAnimation$2> cVar) {
        super(2, cVar);
        this.$url = str;
        this.$context = context;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new AirdropManager$downloadAnimation$2(this.$url, this.$context, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((AirdropManager$downloadAnimation$2) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        byte[] bArr;
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            boolean z11 = false;
            if (!(this.$url.length() > 0) || !StringsKt__StringsJVMKt.v(this.$url, ".json", false, 2, (Object) null)) {
                AirdropManager.f64272a.j("缓存文件不是Json,不缓存: " + this.$url);
                LogAndWoodRecorder.a("Airdrop", "DownloadAnimation-缓存文件不是Json(" + this.$url + ')');
            } else {
                String a11 = i.a(this.$url);
                if (a11.length() > 0) {
                    File file = new File(this.$context.getCacheDir(), "animation");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File file2 = new File(file, a11 + ".json");
                    try {
                        if (file2.exists()) {
                            AirdropManager.f64272a.j("缓存文件已存在: " + this.$url);
                        } else {
                            AirdropManager airdropManager = AirdropManager.f64272a;
                            airdropManager.j("缓存文件不存在,开始缓存: " + this.$url);
                            ResponseBody body = new OkHttpClient().newCall(new Request.Builder().url(this.$url).build()).execute().body();
                            if (body == null || (bArr = body.bytes()) == null) {
                                bArr = new byte[0];
                            }
                            if (bArr.length == 0) {
                                z11 = true;
                            }
                            if (true ^ z11) {
                                FilesKt__FileReadWriteKt.c(file2, bArr);
                                airdropManager.j("缓存文件不存在,缓存成功: " + this.$url);
                            } else {
                                airdropManager.j("缓存文件不存在,下载失败: " + this.$url);
                                LogAndWoodRecorder.a("Airdrop", "DownloadAnimation-下载失败(" + this.$url + ')');
                            }
                        }
                    } catch (Exception e11) {
                        AirdropManager airdropManager2 = AirdropManager.f64272a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("缓存出现异常: ");
                        String message = e11.getMessage();
                        String str = "--";
                        if (message == null) {
                            message = str;
                        }
                        sb2.append(message);
                        sb2.append(l.f34627b);
                        sb2.append(this.$url);
                        airdropManager2.j(sb2.toString());
                        file2.deleteOnExit();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("DownloadAnimation-下载异常(");
                        sb3.append(this.$url);
                        sb3.append(',');
                        String message2 = e11.getMessage();
                        if (message2 != null) {
                            str = message2;
                        }
                        sb3.append(str);
                        sb3.append(')');
                        LogAndWoodRecorder.a("Airdrop", sb3.toString());
                    }
                }
            }
            return Unit.f56620a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
