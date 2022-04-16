package com.bakery.finalproject.modelDTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductCategoryDTO {
    private Integer categoryId;
    private String name;
    private String description;
}
