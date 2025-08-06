package retrofit2.adapter.rxjava;

import java.util.Objects;
import retrofit2.Response;

public final class Result<T> {
    private final Throwable error;
    private final Response<T> response;

    private Result(Response<T> response2, Throwable th2) {
        this.response = response2;
        this.error = th2;
    }

    public static <T> Result<T> error(Throwable th2) {
        Objects.requireNonNull(th2, "error == null");
        return new Result<>((Response) null, th2);
    }

    public static <T> Result<T> response(Response<T> response2) {
        Objects.requireNonNull(response2, "response == null");
        return new Result<>(response2, (Throwable) null);
    }

    public boolean isError() {
        return this.error != null;
    }

    public String toString() {
        if (this.error != null) {
            return "Result{isError=true, error=\"" + this.error + "\"}";
        }
        return "Result{isError=false, response=" + this.response + '}';
    }

    public Throwable error() {
        return this.error;
    }

    public Response<T> response() {
        return this.response;
    }
}
