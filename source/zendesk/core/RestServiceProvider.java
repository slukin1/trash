package zendesk.core;

import okhttp3.OkHttpClient;

public interface RestServiceProvider {
    <E> E createRestService(Class<E> cls, String str, String str2);

    <E> E createRestService(Class<E> cls, String str, String str2, CustomNetworkConfig customNetworkConfig);

    <E> E createUnauthenticatedRestService(Class<E> cls, String str, String str2, CustomNetworkConfig customNetworkConfig);

    OkHttpClient getCoreOkHttpClient();

    OkHttpClient getMediaOkHttpClient();
}
