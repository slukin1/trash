package bw;

import bw.e;
import kotlinx.serialization.k;
import okhttp3.MediaType;
import retrofit2.Converter;

public final class c {
    public static final Converter.Factory a(k kVar, MediaType mediaType) {
        return new b(mediaType, new e.a(kVar));
    }
}
