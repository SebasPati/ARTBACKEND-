package com.challengerFinal.arte.controllers;

import com.challengerFinal.arte.dtos.GoodsReceiptDto;
import com.challengerFinal.arte.service.GoodsReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class GoodsReceiptController {
    @Autowired
    GoodsReceiptService goodsReceiptService;

    @GetMapping(value = "/goodsReceipts")
    public List<GoodsReceiptDto> getExistAll(){
        return goodsReceiptService.getGoodsReceiptsAll().stream().map(GoodsReceiptDto::new).collect(Collectors.toList());
    }
    @GetMapping(value = "/goodsReceipts/{goodsReceiptId}")
    public GoodsReceiptDto getGoodsReceiptId(@PathVariable Long goodsReceiptId){
        return new GoodsReceiptDto(goodsReceiptService.getGoodsReceiptId(goodsReceiptId));
    }

}
