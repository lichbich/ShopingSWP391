package com.vn.fpt.g1.shop.common;

public class Pagination {
    private int page = 0;
    private int size = 10;
    private int totalPages;
    private long totalElements;

    public Pagination(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }
}
