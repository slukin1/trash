package zendesk.support;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import mz.a;

class HelpResponse {
    private List<CategoryItem> categories;
    @SerializedName("category_count")
    private int categoryCount;

    public List<CategoryItem> getCategories() {
        return a.c(this.categories);
    }

    public int getCategoryCount() {
        return this.categoryCount;
    }
}
