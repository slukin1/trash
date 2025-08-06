package g30;

import android.content.Context;
import android.content.res.Resources;
import com.squareup.picasso.Picasso;
import zendesk.belvedere.a;

public abstract class r {
    public static a a(Context context) {
        return a.c(context);
    }

    public static Picasso b(Context context) {
        return new Picasso.b(context).a();
    }

    public static Resources c(Context context) {
        return context.getResources();
    }
}
