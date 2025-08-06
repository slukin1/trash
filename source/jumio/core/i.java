package jumio.core;

import com.jumio.core.models.ApiCallDataModel;

public interface i {
    void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th2);

    void onResult(ApiCallDataModel<?> apiCallDataModel, Object obj);
}
