package com.sasha.store.clothesservice.controllers;

import com.sasha.store.clothesservice.dao.entities.Clothes;
import com.sasha.store.clothesservice.service.clothes.IClothesServices;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/clothes")
public class ClothesController {

    private final IClothesServices clothesServices;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createClothes(@RequestBody Clothes clothes, HttpRequest request, HttpResponse httpResponse){
        return ResponseEntity.ok(clothesServices.getAllClothes());
    }

    @GetMapping
    public ResponseEntity<List<Clothes>> getAllClothes(ServletRequest request, ServletResponse httpResponse){
        return ResponseEntity.ok(clothesServices.getAllClothes());
    }
}
