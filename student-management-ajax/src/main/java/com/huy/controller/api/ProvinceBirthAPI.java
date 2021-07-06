package com.huy.controller.api;

import com.huy.model.ProvinceBirth;
import com.huy.service.provinceBirth.IProvinceBirthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/provinceBirths")
public class ProvinceBirthAPI {
    @Autowired
    private IProvinceBirthService provinceBirthService;

    @GetMapping
    public ResponseEntity<Iterable<ProvinceBirth>> allProvinceBirths() {
        Iterable<ProvinceBirth> provinceBirths = provinceBirthService.findAll();
        if (((List) provinceBirths).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(provinceBirths, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProvinceBirth> deleteProvinceBirth(@PathVariable Long id) {
        Optional<ProvinceBirth> provinceBirthOptional = provinceBirthService.findById(id);
        if (!provinceBirthOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        provinceBirthService.remove(id);
        return new ResponseEntity<>(provinceBirthOptional.get(), HttpStatus.NO_CONTENT);
    }
}
