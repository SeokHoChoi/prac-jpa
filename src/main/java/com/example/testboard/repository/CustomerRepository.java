package com.example.testboard.repository;

import com.example.testboard.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // <Customer, Integer> 에서 int 사용인데 여따 못넣어서 Integer넣음 이래도됨?
    // 그리고 전체를 Classiccmodels로 퉁쳐서 만들려했는데 <>부분 때문에
    // 그냥 다 쪼개기로함..

    // get 안되길래.. 해결방법중 하나로 이걸했으나 안됨.
//    @Query(value = "SELECT c.customerNumber, c.customerName, c.contactLastName, c.contactFirstName, c.phone, c.addressLine1, c.addressLine2, c.city, c.state, c.postalCode, c.country, c.salesRepEmployee, c.creditLimit FROM Customer c")
//    Page<CustomerResponseDto> findCustomerInfo(Pageable pageable);

    // 순간 헷갈림..
    // Entity는 언제 쓰더라.. 리포지터리에서 디비랑 주고받을때는 일단 다 Entity로 받아서 변형해야하나..?
//    CustomerResponseDto findByCustomerNumber(int customerNumber);
}
/**
 *
 * DB, JPA(스프링진영 hibernate 구현기능 , 영속성 관리라이브러리), @Repository 데이터 저장소
 *
 * jpa가 리포지터리 어노테이션을 이용해서 클래스를 구현하고,
 * 그 내부에선 db에 명령을 내리는 쿼리를 작성한다.
 * 그래서 데이터에 관련된 crud함.
 *
 * jpa가 쿼리 작성할때 어떻게 함수명만으로 쿼리를 그렇게 작성할수 있는지 설명해봐.
 * 사용자가 어떻게 어떤 함수를 작성할지 알고 그걸 분석해서 함수를 작성하고 함수이름을 갖고올까요?
 *
 * 엔티티어노테이션이 달려있는 클래스들을 스캔한후 그 안에있는 아이디 , 컬럼등 어노테이션등을 리플랙션을 통해서
 * 클래스에 대한정보를 다 갖고올수있는데 이걸 읽어오는거임.
 * 엔드라던가 키워드들, 인터페이스에 있는 네이밍규칙들을 틀리면 실행이 잘 안되는데
 * 이런 규칙이 있기 때문에 그럼.
 * 벨리데이트가 아니라 논으로 뒀던게 리포지터리를 스캐닝 하지 않던거임.
 */