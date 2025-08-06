package zendesk.support;

class ZendeskHelpCenterSessionCache implements HelpCenterSessionCache {
    public static final LastSearch DEFAULT_SEARCH = new LastSearch("", 0);
    private LastSearch lastSearch;
    private boolean uniqueSearchResultClick = false;

    public LastSearch getLastSearch() {
        LastSearch lastSearch2 = this.lastSearch;
        return lastSearch2 != null ? lastSearch2 : DEFAULT_SEARCH;
    }

    public boolean isUniqueSearchResultClick() {
        return this.uniqueSearchResultClick;
    }

    public void setLastSearch(String str, int i11) {
        this.lastSearch = new LastSearch(str, i11);
        this.uniqueSearchResultClick = true;
    }

    public void unsetUniqueSearchResultClick() {
        this.uniqueSearchResultClick = false;
    }
}
