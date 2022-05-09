package com.bakery.finalproject.modelDTO;

import com.bakery.finalproject.entity.ProductCategory;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductDTO {
    private Integer productId;
    private ProductCategory category;
    private String name;
}
