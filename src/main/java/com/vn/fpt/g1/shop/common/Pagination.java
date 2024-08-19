package com.vn.fpt.g1.shop.common;

public class Pagination {
    private int page = 1;
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

    public int getOffset() {
        int i = (page - 1) * size;
        return i <= 0 ? 1 : i;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
        this.totalPages = (int) Math.ceil((double) totalElements / size);
    }
}
