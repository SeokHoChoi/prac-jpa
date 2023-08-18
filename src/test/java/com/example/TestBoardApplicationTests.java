package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestBoardApplicationTests {

    @Test
    void contextLoads() {
        Car sm6 = new Sm6();
        System.out.println(sm6.name());
    }

    class Car {
        public String name(){
            return "Car";
        }
    }
    class Samsung extends Car {
        public String name(){
            return "Samsung";
        }
    }
    class Sm6 extends Samsung {
        public String name(){
            return "SM6";
        }
    }
    class Qm6 extends Sm6{
        public String name(){
            return "Qm6";
        }
    }

}
