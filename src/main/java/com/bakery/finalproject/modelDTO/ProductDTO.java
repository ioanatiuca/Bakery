package com.bakery.finalproject.modelDTO;

import com.bakery.finalproject.enums.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProductDTO {
    private ProductCategory category;
    private String name;
}
