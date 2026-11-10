package com.example.practice2;

import java.util.Objects;

public class GoodsInventory {
    private final Goods[] goods;
    private int size;

    public GoodsInventory(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        goods = new Goods[capacity];
    }

    public boolean addGoods(Goods newGoods) {
        Objects.requireNonNull(newGoods);

        for (int i = 0; i < size; i++) {
            if (goods[i].getCode().equals(newGoods.getCode())) {
                return false;
            }
        }

        if (size == goods.length) {
            return false;
        }

        goods[size] = newGoods;
        size++;
        return true;
    }

    public int getTotalQuantity(Class<? extends Goods> type) {
        Objects.requireNonNull(type);

        int total = 0;
        for (int i = 0; i < size; i++) {
            if (type.isInstance(goods[i])) {
                total += goods[i].getQuantity();
            }
        }
        return total;
    }
}