package io.noties.markwon.core.factory;

import com.amazonaws.services.s3.model.InstructionFileId;
import io.noties.markwon.b;
import io.noties.markwon.core.CoreProps;
import rz.c;
import rz.e;
import tz.g;

public class ListItemSpanFactory implements e {
    public Object a(b bVar, c cVar) {
        if (CoreProps.ListItemType.BULLET == CoreProps.f55291a.d(cVar)) {
            return new tz.b(bVar.g(), CoreProps.f55292b.d(cVar).intValue());
        }
        return new g(bVar.g(), String.valueOf(CoreProps.f55293c.d(cVar)) + InstructionFileId.DOT + 160);
    }
}
