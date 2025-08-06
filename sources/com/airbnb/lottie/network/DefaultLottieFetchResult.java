package com.airbnb.lottie.network;

import com.airbnb.lottie.utils.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class DefaultLottieFetchResult implements LottieFetchResult {
    private final HttpURLConnection connection;

    public DefaultLottieFetchResult(HttpURLConnection httpURLConnection) {
        this.connection = httpURLConnection;
    }

    private String getErrorFromConnection(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb2.append(readLine);
                    sb2.append(10);
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb2.toString();
    }

    public InputStream bodyByteStream() throws IOException {
        return this.connection.getInputStream();
    }

    public void close() {
        this.connection.disconnect();
    }

    public String contentType() {
        return this.connection.getContentType();
    }

    public String error() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.connection.getURL() + ". Failed with " + this.connection.getResponseCode() + "\n" + getErrorFromConnection(this.connection);
        } catch (IOException e11) {
            Logger.warning("get error failed ", e11);
            return e11.getMessage();
        }
    }

    public boolean isSuccessful() {
        try {
            return this.connection.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }
}
