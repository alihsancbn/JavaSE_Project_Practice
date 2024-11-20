package com.alihs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class lombokDeneme {
    private String data;

    public static void main(String[] args) {
        lombokDeneme deneme = new lombokDeneme();
        deneme.setData("Data 44");
        System.out.println(deneme.getData());
    }
}
