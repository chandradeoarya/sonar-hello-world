package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String sendGreetings() {
        return "Hello, World!!";
    }
}


// package com.example.helloworld.controller;

// import org.springframework.web.bind.annotation.*;
// import org.springframework.http.MediaType;
// import java.security.MessageDigest;
// import java.sql.*;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// @RestController
// @RequestMapping("/api")
// public class HelloWorldController {
//     private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

//     // 2) Hard-coded credentials reused from properties
//     private static final String ADMIN_USER = "admin";
//     private static final String ADMIN_PASSWORD = "SuperSecretPassword";

//     @GetMapping(value = "/greet", produces = MediaType.TEXT_HTML_VALUE)
//     public String greet(@RequestParam String name) {
//         // 4) XSS: unescaped user input in HTML
//         return "<html><body><h1>Hello, " + name + "!</h1></body></html>";
//     }

//     @PostMapping("/login")
//     public String login(@RequestParam String user, @RequestParam String pass) {
//         // Plain-text credential comparison
//         if (ADMIN_USER.equals(user) && ADMIN_PASSWORD.equals(pass)) {
//             return "Login successful";
//         } else {
//             return "Login failed";
//         }
//     }

//     @GetMapping("/hash")
//     public String hashPassword(@RequestParam String password) {
//         try {
//             // 5) Weak crypto: MD5 hashing
//             MessageDigest md = MessageDigest.getInstance("MD5");
//             md.update(password.getBytes());
//             byte[] digest = md.digest();
//             StringBuilder sb = new StringBuilder();
//             for (byte b : digest) {
//                 sb.append(String.format("%02x", b));
//             }
//             return sb.toString();
//         } catch (Exception e) {
//             // 6) Empty catch block → swallowed exception
//         }
//         return "";
//     }

//     @GetMapping("/userById")
//     public String getUserById(@RequestParam String id) {
//         String result = "";
//         Connection conn = null;
//         Statement stmt = null;
//         try {
//             // 7) SQL injection: dynamic query concatenation
//             conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
//             stmt = conn.createStatement();
//             String query = "SELECT name FROM users WHERE id=" + id;
//             ResultSet rs = stmt.executeQuery(query);
//             if (rs.next()) {
//                 result = rs.getString("name");
//             }
//         } catch (SQLException e) {
//             // swallow exception
//         } finally {
//             try {
//                 if (stmt != null) stmt.close();
//                 if (conn != null) conn.close();
//             } catch (SQLException ex) {
//                 // swallow exception
//             }
//         }
//         // 8) Log injection: logging raw user input
//         logger.info("Fetched user by ID: " + id);
//         return result;
//     }
// }