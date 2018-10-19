package com.cespereira.rest.all;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class AppRestController {

    private final Company [] companies = {
            Company.builder().id(0L).name("google").build(),
            Company.builder().id(1L).name("facebook").build(),
            Company.builder().id(2L).name("ibm").build(),
            Company.builder().id(3L).name("oracle").build(),
            Company.builder().id(4L).name("pivotal").build(),
            Company.builder().id(5L).name("slack").build()
    };

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(Arrays.asList(this.companies));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable("id") final Long id) {
        Optional<Company> company = Arrays.stream(this.companies).filter(i -> i.getId().equals(id)).findFirst();
        if(company.isPresent()) {
            return ResponseEntity.ok(company.get());
        }
        return ResponseEntity.notFound().build();
    }


}
