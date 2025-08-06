package retrofit2;

import java.io.IOException;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private final Call.Factory callFactory;
    private volatile boolean canceled;
    private Throwable creationFailure;
    private boolean executed;
    private Call rawCall;
    private final RequestFactory requestFactory;
    private final Converter<ResponseBody, T> responseConverter;

    public static final class ExceptionCatchingResponseBody extends ResponseBody {
        private final ResponseBody delegate;
        private final BufferedSource delegateSource;
        public IOException thrownException;

        public ExceptionCatchingResponseBody(ResponseBody responseBody) {
            this.delegate = responseBody;
            this.delegateSource = Okio.buffer((Source) new ForwardingSource(responseBody.source()) {
                public long read(Buffer buffer, long j11) throws IOException {
                    try {
                        return super.read(buffer, j11);
                    } catch (IOException e11) {
                        ExceptionCatchingResponseBody.this.thrownException = e11;
                        throw e11;
                    }
                }
            });
        }

        public void close() {
            this.delegate.close();
        }

        public long contentLength() {
            return this.delegate.contentLength();
        }

        public MediaType contentType() {
            return this.delegate.contentType();
        }

        public BufferedSource source() {
            return this.delegateSource;
        }

        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    public static final class NoContentResponseBody extends ResponseBody {
        private final long contentLength;
        private final MediaType contentType;

        public NoContentResponseBody(MediaType mediaType, long j11) {
            this.contentType = mediaType;
            this.contentLength = j11;
        }

        public long contentLength() {
            return this.contentLength;
        }

        public MediaType contentType() {
            return this.contentType;
        }

        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(RequestFactory requestFactory2, Object[] objArr, Call.Factory factory, Converter<ResponseBody, T> converter) {
        this.requestFactory = requestFactory2;
        this.args = objArr;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    private Call createRawCall() throws IOException {
        Call newCall = this.callFactory.newCall(this.requestFactory.create(this.args));
        Objects.requireNonNull(newCall, "Call.Factory returned null.");
        return newCall;
    }

    private Call getRawCall() throws IOException {
        Call call = this.rawCall;
        if (call != null) {
            return call;
        }
        Throwable th2 = this.creationFailure;
        if (th2 == null) {
            try {
                Call createRawCall = createRawCall();
                this.rawCall = createRawCall;
                return createRawCall;
            } catch (IOException | Error | RuntimeException e11) {
                Utils.throwIfFatal(e11);
                this.creationFailure = e11;
                throw e11;
            }
        } else if (th2 instanceof IOException) {
            throw ((IOException) th2);
        } else if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        } else {
            throw ((Error) th2);
        }
    }

    public void cancel() {
        Call call;
        this.canceled = true;
        synchronized (this) {
            call = this.rawCall;
        }
        if (call != null) {
            call.cancel();
        }
    }

    public void enqueue(final Callback<T> callback) {
        Call call;
        Throwable th2;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                call = this.rawCall;
                th2 = this.creationFailure;
                if (call == null && th2 == null) {
                    try {
                        Call createRawCall = createRawCall();
                        this.rawCall = createRawCall;
                        call = createRawCall;
                    } catch (Throwable th3) {
                        th2 = th3;
                        Utils.throwIfFatal(th2);
                        this.creationFailure = th2;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th2 != null) {
            callback.onFailure(this, th2);
            return;
        }
        if (this.canceled) {
            call.cancel();
        }
        call.enqueue(new Callback() {
            private void callFailure(Throwable th2) {
                try {
                    callback.onFailure(OkHttpCall.this, th2);
                } catch (Throwable th3) {
                    Utils.throwIfFatal(th3);
                    th3.printStackTrace();
                }
            }

            public void onFailure(Call call, IOException iOException) {
                callFailure(iOException);
            }

            public void onResponse(Call call, Response response) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(response));
                    } catch (Throwable th2) {
                        Utils.throwIfFatal(th2);
                        th2.printStackTrace();
                    }
                } catch (Throwable th3) {
                    Utils.throwIfFatal(th3);
                    callFailure(th3);
                }
            }
        });
    }

    public Response<T> execute() throws IOException {
        Call rawCall2;
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                rawCall2 = getRawCall();
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.canceled) {
            rawCall2.cancel();
        }
        return parseResponse(rawCall2.execute());
    }

    public boolean isCanceled() {
        boolean z11 = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            Call call = this.rawCall;
            if (call == null || !call.isCanceled()) {
                z11 = false;
            }
        }
        return z11;
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public Response<T> parseResponse(Response response) throws IOException {
        ResponseBody body = response.body();
        Response build = response.newBuilder().body(new NoContentResponseBody(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return Response.error(Utils.buffer(body), build);
            } finally {
                body.close();
            }
        } else if (code == 204 || code == 205) {
            body.close();
            return Response.success(null, build);
        } else {
            ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(body);
            try {
                return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), build);
            } catch (RuntimeException e11) {
                exceptionCatchingResponseBody.throwIfCaught();
                throw e11;
            }
        }
    }

    public synchronized Request request() {
        try {
        } catch (IOException e11) {
            throw new RuntimeException("Unable to create request.", e11);
        }
        return getRawCall().request();
    }

    public synchronized Timeout timeout() {
        try {
        } catch (IOException e11) {
            throw new RuntimeException("Unable to create call.", e11);
        }
        return getRawCall().timeout();
    }

    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }
}
