    package com.collabor8.controller;

    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class HomeController {

        @GetMapping("/")
        public ResponseEntity<?> loadHomePage() {
            return ResponseEntity.status(HttpStatus.OK).body("Welcome to Collabor8");
        }
    }
