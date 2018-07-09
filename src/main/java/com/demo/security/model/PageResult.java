package com.demo.security.model;


import org.springframework.data.domain.Page;

import java.util.Collection;

public class PageResult{

    public PageResult(Page<?> page) {
        this.total = page.getTotalElements();
        this.rows = page.getContent();
    }

    private long total = 0;

    private Collection<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Collection<?> getRows() {
        return rows;
    }

    public void setRows(Collection<?> rows) {
        this.rows = rows;
    }
}
