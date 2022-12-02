package com.qcby.hongyanredenvelopes.entity;

import lombok.Data;

@Data
public class WareStock {
    private Long id;
    private Long wareNumberId;
    private Long productId;
    private Integer stock;
    private Integer stockLock;


    public Integer getStockNoLock() {
        return stock - stockLock > 0 ? stock - stockLock : 0;
    }
}
