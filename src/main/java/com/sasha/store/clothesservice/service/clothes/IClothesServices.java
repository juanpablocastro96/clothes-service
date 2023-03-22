package com.sasha.store.clothesservice.service.clothes;

import com.sasha.store.clothesservice.dao.entities.Clothes;
import com.sasha.store.clothesservice.dao.entities.Size;
import com.sasha.store.clothesservice.dao.entities.TypeClothes;

import java.util.List;

public interface IClothesServices {
    List<Clothes> getAllClothes();

    List<Clothes> getAllTypeClothes(TypeClothes typeClothe);

    List<Clothes> getAllAvailableClothes(Boolean isAvailable);

    List<Clothes> getAllHasDiscountClothes(Boolean hasDiscount);

    List<Clothes> getAllSizeClothes(Size size);

    Clothes createNewClothes();

}
