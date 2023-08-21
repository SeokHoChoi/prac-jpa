package com.example.testboard.dto.response;

import com.example.testboard.entity.Office;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OfficeResponseDto {
    private String officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;

    public static OfficeResponseDto from(Office office) {
        OfficeResponseDto officeResponseDto = new OfficeResponseDto();
        officeResponseDto.setOfficeCode(office.getOfficeCode());
        officeResponseDto.setCity(office.getCity());
        officeResponseDto.setPhone(office.getPhone());
        officeResponseDto.setAddressLine1(office.getAddressLine1());
        officeResponseDto.setAddressLine2(office.getAddressLine2());
        officeResponseDto.setState(office.getState());
        officeResponseDto.setCountry(office.getCountry());
        officeResponseDto.setPostalCode(office.getPostalCode());
        officeResponseDto.setTerritory(office.getTerritory());
        return officeResponseDto;
    }
}
