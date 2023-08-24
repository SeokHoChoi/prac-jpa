package com.example.testboard.dto.response;


import com.example.testboard.entity.ProductLine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ProductLineResponseDto {
    private String productLine;
    private String textDescription;
    private String htmlDescription;

    public static ProductLineResponseDto from(ProductLine productLine) {
        ProductLineResponseDto productLineResponseDto = new ProductLineResponseDto();
        productLineResponseDto.setProductLine(productLine.getProductLine());
        productLineResponseDto.setTextDescription(productLine.getTextDescription());
        productLineResponseDto.setHtmlDescription(productLine.getHtmlDescription());
        return productLineResponseDto;
    }
}
