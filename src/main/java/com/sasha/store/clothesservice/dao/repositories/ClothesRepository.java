package com.sasha.store.clothesservice.dao.repositories;

import com.sasha.store.clothesservice.dao.entities.Clothes;
import com.sasha.store.clothesservice.dao.entities.Size;
import com.sasha.store.clothesservice.dao.entities.TypeClothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long> {

    List<Clothes> findAllByTypeClothes(TypeClothes typeClothes);

    List<Clothes> getClothesByIsAvailable(Boolean isAvailable);

    List<Clothes> getClothesByHasDiscount(TypeClothes typeClothes);

    List<Clothes> getClothesBySize(Size size);

}
