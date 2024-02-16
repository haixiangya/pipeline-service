package com.haixiang.pipeline.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haixiang.pipeline.model.Fruit;
import com.haixiang.pipeline.model.FruitPriceTable;
import com.haixiang.pipeline.model.PurchaseDetails;
import com.haixiang.pipeline.service.FruitPriceTableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/supermaket")
public class SupermarketTest {
    @Resource
    FruitPriceTableService priceTableService;

    @RequestMapping(value = "/pricing",method = RequestMethod.POST)
    public Double Pricing(@RequestBody PurchaseDetails purchaseDetails) {
        // 获取水果购买详细信息，如种类，重量等
        List<Fruit> fruitList = purchaseDetails.getFruitsWeight();
        String promotionalMethods = purchaseDetails.getPromotionalMethods();
        Double amounts = 0.0;
        for (Fruit fruit : fruitList) {
            // 根据水果种类，从数据库中获取水果的单价
            String fruitType = fruit.getFruitName();
            QueryWrapper<FruitPriceTable> query = new QueryWrapper();
            query.eq("fruit_name", fruitType);
            Double fruitPrice = priceTableService.getOne(query).getFruitPrice();
            int fruitWeight = fruit.getFruitWeight();
            // 判断是否有草莓优惠活动
            if (!promotionalMethods.isEmpty() && promotionalMethods.equals("A") && fruitType.equals("strawberry")) {
                amounts = amounts + fruitPrice * fruitWeight * 0.8;
            } else {
                amounts = amounts + fruitPrice * fruitWeight;
            }
        }
        // 判断是否有满减活动
        if (!promotionalMethods.isEmpty() && promotionalMethods.equals("B")) {
            if (amounts >= 100) {
                amounts = amounts - 10;
            }
        }
        return amounts;
    }
}
