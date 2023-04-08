package com.sasha.store.clothesservice.service.clothes;

import com.sasha.store.clothesservice.dao.entities.Clothes;
import com.sasha.store.clothesservice.dao.entities.Size;
import com.sasha.store.clothesservice.dao.entities.TypeClothes;
import com.sasha.store.clothesservice.dao.repositories.ClothesRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Slf4j
public class ClothesService implements IClothesServices{

    private final ClothesRepository clothesRepository;

    @PostConstruct
    private void loadData(){
        // Functional approach
        IntStream.range(1, 9999)
                .mapToObj(i -> Clothes.builder()
                        .name("NAME_" + i)
                        .typeClothes(i % 2 == 0 ? TypeClothes.PANT : TypeClothes.JEANS)
                        .price(new Random().nextDouble(0, 1000))
                        .description("DESCRIPTION_" + i)
                        .isAvailable(new Random().nextDouble(1, 2) == 2)
                        .quantity(new Random().nextLong(0, 1000))
                        .hasDiscount(new Random().nextDouble(1, 2) == 2)
                        .size(i % 2 == 0 ? Size.S : Size.L)
                        .build())
                .forEach(clothesRepository::save);
        // Traditional or imperative approach
        //for (int i = 0; i < 10000; i++) {
        //    Clothes clothes = Clothes.builder()
        //            .name("NAME_" + i)
        //            .typeClothes(i % 2 == 0 ? TypeClothes.PANT : TypeClothes.JEANS)
        //            .price(new Random().nextDouble(0, 1000))
        //            .description("DESCRIPTION_" + i)
        //            .isAvailable(new Random().nextDouble(1, 2) == 2)
        //            .quantity(new Random().nextLong(0, 1000))
        //            .hasDiscount(new Random().nextDouble(1, 2) == 2)
        //            .size(i % 2 == 0 ? Size.S : Size.L)
        //            .build();
        //    clothesRepository.save(clothes);
        //}
    }


    @Override
    public List<Clothes> getAllClothes() {
        return clothesRepository.findAll();
    }

    @Override
    public List<Clothes> getAllTypeClothes(TypeClothes typeClothes) {
        return clothesRepository.findAll()
                .stream()
                .filter(clothes -> clothes.getTypeClothes().equals(typeClothes))
                .filter(getClothesAmountAvailable())
                .collect(Collectors.toList());
    }

    @Override
    public List<Clothes> getAllAvailableClothes(Boolean isAvailable) {
        return clothesRepository.getClothesByIsAvailable(isAvailable);
    }

    @Override
    public List<Clothes> getAllHasDiscountClothes(Boolean hasDiscount) {
        return clothesRepository.findAll()
                .stream()
                .filter(getClothesCondition(hasDiscount))
                .filter(getClothesAmountAvailable())
                .collect(Collectors.toList());
    }



    @Override
    public List<Clothes> getAllSizeClothes(Size size) {
        return clothesRepository.findAll()
                .stream()
                .filter(clothes -> clothes.getSize().equals(size))
                .filter(getClothesAmountAvailable())
                .collect(Collectors.toList());
    }

    @Override
    public Clothes createNewClothes() {
        return null;
    }

    private static Predicate<Clothes> getClothesCondition(Boolean condition) {
        return clothes -> clothes.getHasDiscount() == condition;
    }

    private static Predicate<Clothes> getClothesAmountAvailable() {
        return clothesSize -> clothesSize.getQuantity() > 0 && clothesSize.getIsAvailable();
    }
}
