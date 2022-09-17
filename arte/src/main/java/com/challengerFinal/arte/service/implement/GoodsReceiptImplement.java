package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.model.GoodsReceipt;
import com.challengerFinal.arte.repositories.GoodsReceiptRepository;
import com.challengerFinal.arte.service.GoodsReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsReceiptImplement implements GoodsReceiptService {
    @Autowired
    GoodsReceiptRepository goodsReceiptRepository;
    @Override
    public List<GoodsReceipt> getGoodsReceiptsAll() {
        return goodsReceiptRepository.findAll();
    }

    @Override
    public GoodsReceipt getGoodsReceiptId(Long id) {
        return goodsReceiptRepository.findById(id).get();
    }

    @Override
    public GoodsReceipt saveGoodsReceipt(GoodsReceipt receipt) {
        return goodsReceiptRepository.save(receipt);
    }
}
