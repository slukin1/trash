package zendesk.support.guide;

import zendesk.support.CategoryItem;
import zendesk.support.HelpItem;
import zendesk.support.SeeAllArticlesItem;

public interface HelpMvp$Presenter {
    HelpItem getItem(int i11);

    int getItemCount();

    HelpItem getItemForBinding(int i11);

    int getItemViewType(int i11);

    void onAttached();

    boolean onCategoryClick(CategoryItem categoryItem, int i11);

    void onDetached();

    void onSeeAllClick(SeeAllArticlesItem seeAllArticlesItem);

    void setContentPresenter(HelpCenterMvp$Presenter helpCenterMvp$Presenter);
}
