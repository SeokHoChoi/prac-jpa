package com.example.testboard.controller;

import com.example.testboard.dto.request.CustomerRequestDto;
import com.example.testboard.dto.response.CustomerResponseDto;
import com.example.testboard.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    /**
     * 페이지가 매겨진 고객들의 목록.
     *
     * @param pageable 매개변수를 문서화하여 페이지 매김 목적으로 사용됨.
     * @return 메서드가 Page 고객 목록을 포함하는 객체를 반환함.
     */
    @GetMapping("/info")
    @ResponseStatus(HttpStatus.OK)
    public Page<CustomerResponseDto> getCustomerInfo(
        @PageableDefault(
            page = 0,
            size = 10,
            sort = "customerNumber",
            direction = Sort.Direction.DESC
        )
        Pageable pageable
    ) {
        return customerService.getCustomerInfo(pageable);
    }

    /**
     * PathVariable customerNumber 에 부합하는 고객정보
     *
     * @param customerNumber PathVariable 를 문서화하여 응답 목적으로 사용됨.
     * @return 메서드가 customerNumber 가 일치하는 객체를 반환함.
     */
    @GetMapping("/info/{customerNumber}")
    public CustomerResponseDto getCustomerDetailInfo(
        @PathVariable
        int customerNumber
    ) {
        return customerService.getCustomerDetailInfo(customerNumber);
    }

    /**
     * 새로운 고객정보 생성
     *
     * @param customerRequestDto 를 문서화하여 생성 목적으로 사용됨.
     * @return 메서드가 생성된 고객의 customerResponseDto 객체를 반환함.
     */
    // 관계 맺어진 employee는 어쩌지??
    // 내가 생각한 해결책은 판매직원의 사원번호인 salesRepEmployeeNumber 를 find해와서
    // 해당 객체를 그대로 넣어주는걸 Customer Entity의 from에다 기능을 만들까하는데
    // 이상함? 서비스에서 만들어서 객체 넘길꺼임
    @PostMapping(path = "/info", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDto createCustomer(
        @RequestBody
        @Validated
        CustomerRequestDto customerRequestDto
    ) {
        return customerService.createCustomer(customerRequestDto);
    }

    // 왜 안됨?? 이상하네 완벽하다고 생각하는데 안됨.
    @PutMapping(path = "/info/{customerNumber}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDto updateCustomerInfo(
        @PathVariable
        int customerNumber,
        @RequestBody
        @Validated
        CustomerRequestDto customerRequestDto
    ) {
        return customerService.updateCustomerInfo(customerRequestDto, customerNumber);
    }

    // 질문: 관계 엮인 놈들은 알아서 삭제하는거임? 찾아보니까 여러가지 설정으로
    // 엮인 애들도 알아서 삭제.. 이런게 있던데 너무 헷갈림.
    /**
     * 고객정보 삭제
     *
     * @param customerNumber 를 문서화하여 삭제 목적으로 사용됨
     * @return 메서드가 삭제된 고객의 customerResponseDto 객체를 반환함.
     */
    @DeleteMapping(path = "/info/{customerNumber}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponseDto deleteCustomer(
            @PathVariable
            int customerNumber
    ) {
        return customerService.deleteCustomer(customerNumber);
    }
}
