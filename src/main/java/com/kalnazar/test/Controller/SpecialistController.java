package com.kalnazar.test.Controller;

import com.kalnazar.test.service.SpecialistService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/specialist/")
public class SpecialistController {
    private final SpecialistService specialistService;

    @PostMapping(path = "/save")
    public String saveSpecialist(@RequestBody) {
        Long id = specialistService.add;
    }

}
