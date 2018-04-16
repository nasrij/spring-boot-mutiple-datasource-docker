package com.foobar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.foobar.bar.domain.Bar;
import com.foobar.bar.repo.BarRepository;
import com.foobar.foo.domain.Foo;
import com.foobar.foo.repo.FooRepository;

import java.util.List;

@RestController
public class FooBarController {

    private final FooRepository fooRepo;
    private final BarRepository barRepo;

    @Autowired
    FooBarController(FooRepository fooRepo, BarRepository barRepo) {
        this.fooRepo = fooRepo;
        this.barRepo = barRepo;
    }

    @RequestMapping("/foobar/{id}")
    public String fooBar(@PathVariable("id") Long id) {
        Foo foo = fooRepo.findById(id);
        Bar bar = barRepo.findById(id);

        return foo.getFoo() + " " + bar.getBar() + "!";
    }


    @RequestMapping("/bar/all")
    public List<Bar> allBars() {
        return barRepo.findAll();
    }

    @RequestMapping("/foo/all")
    public List<Foo> allFoos() {
        return fooRepo.findAll();
    }


    @PostMapping("/bar")
    public Bar saveBar(@RequestBody Bar bar) {
        return barRepo.save(bar);
    }

    @PostMapping("/foo")
    public Foo saveFoo(@RequestBody Foo foo) {
        return fooRepo.save(foo);
    }


}
