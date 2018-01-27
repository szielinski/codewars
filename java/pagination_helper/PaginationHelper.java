// https://www.codewars.com/kata/515bb423de843ea99400000a
// written for java8

import java.util.ArrayList;
import java.util.List;

public class PaginationHelper<I> {

    ArrayList<ArrayList<I>> pages = new ArrayList<>();
    int itemsPerPage;
    int noItems;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        int noPages = collection.size() / itemsPerPage;
        for(int i=0; i<=noPages; i++)
            pages.add(new ArrayList<>());
        int page = 0;
        for(I i : collection){
            if(pages.get(page).size() >= itemsPerPage) page++;
            pages.get(page).add(i);
        }
        this.itemsPerPage = itemsPerPage;
        this.noItems = collection.size();
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return pages.stream().mapToInt(List::size).sum();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return pages.size();
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if(pageIndex >= pages.size()) return -1;
        return pages.get(pageIndex).size();
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if(itemIndex < 0 || itemIndex > noItems || pages.isEmpty() || pages.get(0).isEmpty()) return -1;
        return itemIndex / itemsPerPage;
    }
}
