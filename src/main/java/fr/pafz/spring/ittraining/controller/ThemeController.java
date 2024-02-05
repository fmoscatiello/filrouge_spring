package fr.pafz.spring.ittraining.controller;

import fr.pafz.spring.ittraining.dto.ThemeReduitDTO;
import fr.pafz.spring.ittraining.entity.Theme;
import fr.pafz.spring.ittraining.service.ThemeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/themes")
@CrossOrigin
public class ThemeController {

    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping("/all")
    public List<ThemeReduitDTO> findAll(){
        return themeService.findAll();
    }

    @PostMapping("/save")
    public void save(@Validated @RequestBody Theme theme){
        themeService.save(theme);
    }

    @DeleteMapping("/delete")
    public void deleteAll(){
        themeService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        themeService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public Theme findById(@PathVariable long id){
        return themeService.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Theme theme){
        themeService.update(theme);
    }
}
