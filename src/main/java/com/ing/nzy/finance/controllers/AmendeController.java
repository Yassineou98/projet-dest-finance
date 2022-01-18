package com.ing.nzy.finance.controllers;

import com.ing.nzy.finance.services.AmendeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/amendes")
@RequiredArgsConstructor
public class AmendeController {

    private final AmendeService amendeService;

    @PatchMapping("/{amendeId}")
    public ResponseEntity<?> reglerAmende(@PathVariable Long amendeId) {

        amendeService.reglerAmende(amendeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
