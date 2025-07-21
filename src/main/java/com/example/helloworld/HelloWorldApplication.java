// package com.example.helloworld;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class HelloWorldApplication {

//     public static void main(String[] args) {
//         SpringApplication.run(HelloWorldApplication.class, args);
//     }

// }

package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Random;

@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        // 3) Insecure PRNG: fixed seed
        Random rng = new Random(42);
        System.out.println("Random number: " + rng.nextInt());
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}

class hello_world_application2 {
    public static void main(String[] args) {
        // This is a placeholder for the second version of the application
        System.out.println("Hello World Application Version 2");
    }
}