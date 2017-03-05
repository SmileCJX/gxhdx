package com.gxhdx.pageModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/1/001.
 */
public class PageModelBase implements Serializable {

    private int draw;

    private long recordsFiltered;

    private int start;

    private int length;

    private String ids;

    private List<Order> orderList = new ArrayList<Order>();


    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }


    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }


    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

}