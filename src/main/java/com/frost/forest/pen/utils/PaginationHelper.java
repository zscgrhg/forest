package com.frost.forest.pen.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.frost.forest.pen.bean.service.AbstractFacade;
import com.frost.forest.gen.cgmain.Assist;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by wenkui on 2015/3/18.
 */
public class PaginationHelper<F extends AbstractFacade<T>, T> {
    private int pageSize = 20;
    private int firstRow = 0;
    private Integer count = null;
    private List<T> items = null;
    private F f = null;
    private int maxLinksCount = 5;
    private int[] links;
    private int ff = -2;
    private int fb = -2;


    public PaginationHelper(F f, int pageSize, int firstRow) {

        this.f = f;
        this.pageSize = pageSize;
        this.setFirstRow(firstRow);
    }

    public PaginationHelper(int maxLinksCount, F f, int pageSize, int firstRow) {

        this.f = f;
        this.pageSize = pageSize;
        this.setMaxLinksCount(maxLinksCount);
        this.setFirstRow(firstRow);
    }


    public int getMaxLinksCount() {
        return maxLinksCount;
    }

    public void setMaxLinksCount(int maxLinksCount) {
        if (maxLinksCount <= 0) {
            maxLinksCount = 10;
        }
        this.maxLinksCount = maxLinksCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public void setFirstRow(int firstRow) {
        int count = this.getCount();
        if (count == 0) {
            this.firstRow = 0;
            return;
        }
        int s;
        if (firstRow >= 0) {
            s = firstRow % count;
            this.firstRow = s - s % pageSize;
        } else {
            s = (count - firstRow) % count;
            this.firstRow = s - s % pageSize;
        }

    }

    public int getCount() {
        if (null == count) {
            count = f.count();
        }
        return count;
    }

    ;

    public List<T> getItems() {
        if (null == items) {
            items = f.findRange(new int[]{firstRow, firstRow + pageSize - 1});
        }
        return items;
    }

    ;

    public boolean isHasNextPage() {
        return this.getCount() > this.firstRow + this.pageSize;
    }

    public boolean isHasPreviousPage() {
        return this.firstRow > 0;
    }

    public int getPreviousStartRow() {
        return Math.max(this.firstRow - pageSize, 0);
    }

    public int getNextStartRow() {
        return isHasNextPage() ? (this.firstRow + pageSize) : this.firstRow;
    }


    public int getTotalPage() {
        return (this.getCount() + this.pageSize) / pageSize + getPageNumberFixed();
    }

    public int getCurrentPage() {
        return (this.firstRow + this.pageSize) / pageSize + getPageNumberFixed();
    }

    public int getLastRow() {
        return firstRow + this.getItems().size() - 1;
    }


    public int[] getLinks() {
        if (null == links) {
            ff = -1;
            fb = -1;
            int total = this.getTotalPage();
            int cur = this.getCurrentPage();
            int start;
            int end;
            if (total > this.maxLinksCount) {
                end = Math.min(total, cur - cur % this.maxLinksCount + this.maxLinksCount);
                start = Math.max(1, end - this.maxLinksCount - 1);
            } else {
                start = Math.min(1, total);
                end = total;
            }
            if (1 == start) {
                end = Math.min(total, this.maxLinksCount + 2);
            }
            int s_ = start;
            int e_ = end;
            if (start > 1) {
                fb = start;
                s_ = start + 1;
            }
            if (end < total) {
                ff = end;
                e_ = end - 1;
            }
            int len = e_ - s_ + 1;
            links = new int[len];
            for (int i = 0; i < len; i++) {
                links[i] = s_ + i;
            }
        }
        return links;
    }

    public int getFf() {
        if (ff == -2) {
            getLinks();
        }
        return ff;
    }

    public int getFb() {
        if (fb == -2) {
            getLinks();
        }
        return fb;
    }

    public void setLinks(int[] links) {
        this.links = links;
    }

    private int getStartOffset() {
        return this.firstRow % pageSize;
    }

    private int getPageNumberFixed() {
        return (this.getStartOffset() + pageSize - 1) / pageSize;
    }

    public String json(Object o){
        System.out.println(o);
        try {
            return Assist.objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public Collection getKeys(Object o){
        if(o instanceof Array){
            return  Arrays.asList(o);
        }else if(o instanceof Collection){
            return (Collection) o;
        }else if(o instanceof Map){
            return ((Map)o).entrySet();
        }
        List a=new ArrayList();
        a.add(o);
        return a;
    }
}
