package com.example.testboard.service;

import com.example.testboard.exception.NotFoundException;
import com.example.testboard.dto.request.CustomerRequestDto;
import com.example.testboard.dto.response.CustomerResponseDto;
import com.example.testboard.entity.Customer;
import com.example.testboard.entity.Employee;
import com.example.testboard.repository.CustomerRepository;
import com.example.testboard.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;

    public Page<CustomerResponseDto> getCustomerInfo(Pageable pageable) {
        Page<Customer> customers = customerRepository.findAll(pageable);

        Page<CustomerResponseDto> customerResponseDto = new PageImpl<>(customers.getContent().stream()
                .map(CustomerResponseDto::from)
                .collect(Collectors.toList()), customers.getPageable(), customers.getTotalElements());
        return customerResponseDto;

    }

    public CustomerResponseDto getCustomerDetailInfo(int customerNumber) {
        // 굳이 리포지터리에서 Customer로 받아서 여기서 이렇게 from으로 변환하는게 맞나..?
        // 게다가 .map(CustomerResponseDto::from) 하려고 static으로 해놨는데
        // 여기서 그거때매 new해서 안하고 바로 . 찍어서 from을 쓰고있는데 잘하는짓인가.?
        CustomerResponseDto customerResponseDto =
                CustomerResponseDto.from(
                        customerRepository.findById(customerNumber).orElseThrow(NotFoundException::new)
                );
        return customerResponseDto;
    }

    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) {
        Employee employee =
                employeeRepository.findByEmployeeNumber
                                (customerRequestDto.getSalesRepEmployee()).orElseThrow(NotFoundException::new);
        Customer customer = Customer.from(customerRequestDto, employee);
        return CustomerResponseDto.from(customerRepository.save(customer));
    }

    public CustomerResponseDto updateCustomerInfo(CustomerRequestDto customerRequestDto, int customerNumber) {

       Customer findCustomer = customerRepository.findById(customerNumber).orElseThrow(NotFoundException::new);
       Employee employee = employeeRepository.findByEmployeeNumber(customerRequestDto.getSalesRepEmployee()).orElseThrow(NotFoundException::new);
        customerRepository.save(findCustomer.compare(customerRequestDto, employee));
       return  CustomerResponseDto.from(findCustomer);
    }

    public CustomerResponseDto deleteCustomer(int customerNumber) {
        Customer customer =
                customerRepository
                        .findById(customerNumber)
                        .orElseThrow(NotFoundException::new);
        customerRepository.delete(customer);
        return CustomerResponseDto.from(customer);
    }
}
