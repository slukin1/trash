package org.cybergarage.xml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.cybergarage.http.HTTPRequest;
import org.cybergarage.http.HTTPResponse;

public abstract class Parser {
    public Node a(File file) throws ParserException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Node b11 = b(fileInputStream);
            fileInputStream.close();
            return b11;
        } catch (Exception e11) {
            throw new ParserException(e11);
        }
    }

    public abstract Node b(InputStream inputStream) throws ParserException;

    public Node c(URL url) throws ParserException {
        String host = url.getHost();
        int port = url.getPort();
        if (port == -1) {
            port = 80;
        }
        String path = url.getPath();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Length", "0");
            if (host != null) {
                httpURLConnection.setRequestProperty("HOST", host);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            Node b11 = b(inputStream);
            inputStream.close();
            httpURLConnection.disconnect();
            return b11;
        } catch (Exception unused) {
            HTTPRequest hTTPRequest = new HTTPRequest();
            hTTPRequest.L0("GET");
            hTTPRequest.P0(path);
            HTTPResponse C0 = hTTPRequest.C0(host, port);
            if (C0.n0()) {
                return b(new ByteArrayInputStream(new String(C0.f()).getBytes()));
            }
            throw new ParserException("HTTP comunication failed: no answer from peer.Unable to retrive resoure -> " + url.toString());
        }
    }
}
