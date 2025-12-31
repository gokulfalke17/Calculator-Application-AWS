package com.techpulse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calc")
public class CalculatorController {

    @GetMapping("/add")
    public ResponseEntity<?> add(@RequestParam double a, @RequestParam double b) {
        return new ResponseEntity<>("Addition is :: "+ (a + b), HttpStatus.OK);

    }

    @GetMapping("/subtract")
    public ResponseEntity<?> subtract(@RequestParam double a, @RequestParam double b) {
        return new ResponseEntity<>("Substraction is :: "+ (a - b), HttpStatus.OK);
    }

    @GetMapping("/multiply")
    public ResponseEntity<?> multiply(@RequestParam double a, @RequestParam double b) {
        return new ResponseEntity<>("Multiplication is :: "+ (a * b), HttpStatus.OK);
    }

    @GetMapping("/divide")
    public ResponseEntity<?> divide(@RequestParam double a, @RequestParam double b) {
        if (b == 0)
            return new ResponseEntity<>("Don't Pass Second Number as Zero.!", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("Division is :: "+ (a / b), HttpStatus.OK);
    }
}
