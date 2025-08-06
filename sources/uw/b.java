package uw;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kakao.network.NetworkService;
import com.kakao.network.NetworkTask;
import com.kakao.network.callback.ResponseCallback;
import com.kakao.network.response.ApiResponseStatusError;
import com.kakao.network.response.ResponseBody;
import com.kakao.network.response.ResponseStringConverter;
import com.kakao.network.tasks.KakaoResultTask;
import java.io.IOException;
import java.util.concurrent.Future;

public class b implements NetworkService {

    /* renamed from: a  reason: collision with root package name */
    public xw.b f26264a;

    public class a extends KakaoResultTask<T> {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f26265d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ResponseStringConverter f26266e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ResponseCallback responseCallback, e eVar, ResponseStringConverter responseStringConverter) {
            super(responseCallback);
            this.f26265d = eVar;
            this.f26266e = responseStringConverter;
        }

        public T b() throws Exception {
            return b.this.b(this.f26265d, this.f26266e);
        }
    }

    public b(xw.b bVar) {
        this.f26264a = bVar;
    }

    public <T> Future<T> a(e eVar, ResponseStringConverter<T> responseStringConverter, ResponseCallback<T> responseCallback) {
        return this.f26264a.a(new a(responseCallback, eVar, responseStringConverter));
    }

    public <T> T b(e eVar, ResponseStringConverter<T> responseStringConverter) throws IOException, ResponseBody.ResponseBodyException, ApiResponseStatusError {
        ww.b a11 = new NetworkTask().a(eVar);
        com.kakao.util.helper.log.a.a("" + a11.b());
        if (a11.a() == 200) {
            return responseStringConverter.convert(a11.b());
        }
        ResponseBody responseBody = new ResponseBody(a11.b());
        throw new ApiResponseStatusError(responseBody.a("code"), responseBody.g(RemoteMessageConst.MessageBody.MSG, ""), a11.a(), responseBody);
    }
}
