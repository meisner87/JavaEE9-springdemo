package com.sda.javaee9springdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Javaee9SpringApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void dependencyInjectionFirstTrial() {
        Toy plasticGun = new Toy("Plastic gun");
        Child john = new Child("John",plasticGun);
        // dependency injection is providing all required class dependencies during creation of objects of that class
        //plasticGun of type toy is dependency of john(of type Child)
        // john (which is of type Child) is dependency of jason (of type Parent)
        //dependency is actually composition,so one item is made of another
        Parent jason = new Parent("Jason", john);
    }
}
record Toy(String name){}
//Child is compose of : name and toy
record Child(String name,Toy favoriteToy) {}
//Parent is made of(compose of) :name and child
record Parent(String name, Child child) {
}
class Animal{}
class Tiger extends Mammal{}
class Mammal extends Animal{}
//Tiger is Mammal
//Tiger is Animal
//we cannot say:Parent is Child(Parent dont extend Child)