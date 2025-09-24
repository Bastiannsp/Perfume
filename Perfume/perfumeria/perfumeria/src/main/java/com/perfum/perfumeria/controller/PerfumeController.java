package com.perfum.perfumeria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.perfum.perfumeria.repository.PerfumeRepository;


@Controller
public class PerfumeController {

    private final PerfumeRepository repo;

    public PerfumeController(PerfumeRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("perfumes", repo.findAll());
        return "index"; // buscará templates/index.html
    }
}
