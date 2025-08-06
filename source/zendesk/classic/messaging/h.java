package zendesk.classic.messaging;

import android.content.Context;
import android.content.res.Resources;
import com.squareup.picasso.Picasso;
import java.util.List;

public interface h {

    public interface a {
        a a(List<c> list);

        a b(MessagingConfiguration messagingConfiguration);

        h build();

        a c(Context context);
    }

    BelvedereMediaHolder a();

    Resources b();

    zendesk.belvedere.a c();

    l d();

    Picasso e();

    MessagingConfiguration f();
}
