package jumio.core;

import com.jumio.commons.log.LogUtils;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.network.ApiCall;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.text.b;

public abstract class o2<T> extends ApiCall<T> {

    /* renamed from: h  reason: collision with root package name */
    public String f56290h = "";

    public o2(h hVar, ApiCallDataModel<?> apiCallDataModel) {
        super(hVar, apiCallDataModel);
    }

    public void fillRequest(OutputStream outputStream) throws IOException {
        outputStream.write(this.f56290h.getBytes(b.f56908b));
    }

    public abstract String getRequest() throws Exception;

    public int prepareRequest() throws Exception {
        this.f56290h = getRequest();
        LogUtils.INSTANCE.logServerRequest(getClass().getSimpleName(), this.f56290h);
        return this.f56290h.getBytes(b.f56908b).length;
    }
}
