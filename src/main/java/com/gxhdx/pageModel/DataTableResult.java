package com.gxhdx.pageModel;

import java.util.List;

/**
 * Created by Administrator on 2017/3/1/001.
 */
public class DataTableResult {

    private long recordsTotal;

    private long recordsFiltered;

    private List<?> data;

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
