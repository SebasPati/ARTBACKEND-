package com.challengerFinal.arte.service;

import com.challengerFinal.arte.model.GoodsReceipt;

import java.util.List;

public interface GoodsReceiptService {
    List<GoodsReceipt> getGoodsReceiptsAll();
    GoodsReceipt getGoodsReceiptId(Long id);
    GoodsReceipt saveGoodsReceipt(GoodsReceipt receipt);
}
