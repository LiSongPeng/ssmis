package page;

import java.util.List;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
public class Page {
    private int currentPage; //当前页
    private List<? extends Object> data; //该页数据
    private long totalCount;  // 总页
    public static final int DEFAULT_PAGE_SIZE = 6;  //默认每页条数

    public int calStartIndex(int pageSize){
        return (currentPage - 1) * pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<? extends Object> getData() {
        return data;
    }

    public void setData(List<? extends Object> data) {
        this.data = data;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
