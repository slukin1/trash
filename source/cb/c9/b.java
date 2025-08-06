package c9;

import okhttp3.OkHttpClient;

public interface b {
    void buildOkHttpClient(OkHttpClient.Builder builder);

    void buildSocketOkHttpClient(OkHttpClient.Builder builder);

    String getHost();

    String getWebSocketHost();
}
