package com.example.testboard.dto.response;

import com.example.testboard.entity.Employee;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeResponseDto {
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private OfficeResponseDto office;
    private EmployeeResponseDto reportsTo;
    private String jobTitle;

    public static EmployeeResponseDto from(Employee employee){
        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setEmployeeNumber(employee.getEmployeeNumber());
        dto.setLastName(employee.getLastName());
        dto.setFirstName(employee.getFirstName());
        dto.setExtension(employee.getExtension());
        dto.setEmail(employee.getEmail());
        if(employee.getOffice() != null) {
            dto.setOffice(OfficeResponseDto.from(employee.getOffice()));
        }
        if(employee.getReportsTo() != null){
            dto.setReportsTo(EmployeeResponseDto.from(employee.getReportsTo()));
        }
        dto.setJobTitle(employee.getJobTitle());
        return dto;
    }
}
