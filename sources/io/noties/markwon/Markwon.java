package io.noties.markwon;

import android.content.Context;
import android.text.Spanned;

public abstract class Markwon {

    public interface a {
        a a(d dVar);

        Markwon build();
    }

    public interface b {
    }

    public static a a(Context context) {
        return new a(context).a(io.noties.markwon.core.a.h());
    }

    public abstract Spanned b(String str);
}
