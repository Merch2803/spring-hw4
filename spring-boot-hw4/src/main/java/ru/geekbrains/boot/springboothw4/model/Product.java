package ru.geekbrains.boot.springboothw4.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private int price;
}
