package com.bakery.finalproject.modelDTO;

import com.bakery.finalproject.entity.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Integer productId;
    private ProductCategory category;
    private String name;
}
