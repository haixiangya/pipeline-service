package com.haixiang.pipeline.model;

import lombok.Data;

import java.util.List;

@Data
public class PurchaseDetails {
    private List<Fruit> fruitsWeight;

    private String promotionalMethods;
}
