package zendesk.support.guide;

import java.util.List;
import zendesk.support.HelpItem;

public interface HelpMvp$View {
    void addItem(int i11, HelpItem helpItem);

    void removeItem(int i11);

    void showItems(List<HelpItem> list);
}
