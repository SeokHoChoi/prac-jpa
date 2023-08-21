package com.example.testboard.dto.response;

import com.example.testboard.entity.Product;
import com.example.testboard.entity.ProductLine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ProductResponseDto {
    private String productCode;
    private String productName;
    private ProductLineResponseDto productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private int quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal m_s_r_p;

    public static ProductResponseDto from(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setProductCode(product.getProductCode());
        productResponseDto.setProductName(product.getProductName());
        if(product.getProductLine() != null) {
            productResponseDto.setProductLine(ProductLineResponseDto.from(product.getProductLine()));
        }
        productResponseDto.setProductScale(product.getProductScale());
        productResponseDto.setProductVendor(product.getProductVendor());
        productResponseDto.setProductDescription(product.getProductDescription());
        productResponseDto.setQuantityInStock(product.getQuantityInStock());
        productResponseDto.setBuyPrice(product.getBuyPrice());
        productResponseDto.setM_s_r_p(product.getM_s_r_p());
        return productResponseDto;
    }
}
