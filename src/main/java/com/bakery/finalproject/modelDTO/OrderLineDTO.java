package com.bakery.finalproject.modelDTO;

import com.bakery.finalproject.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class OrderLineDTO {
    private Product product;
    private Integer quantity;
}
