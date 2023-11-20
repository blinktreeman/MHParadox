package ru.letdigit.mhparadox.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.letdigit.mhparadox.entities.GameParameter;
import ru.letdigit.mhparadox.entities.MHResult;
import ru.letdigit.mhparadox.services.MHService;

@Controller
@RequestMapping(path = "/")
public class MHController {
    private final MHService mhService;
    private final MHResult mhResult = new MHResult();

    public MHController(MHService mhService) {
        this.mhService = mhService;
    }

    @ModelAttribute(name = "gameParameter")
    public GameParameter gameParameter() {
        return new GameParameter();
    }

    @PostMapping
    public String solve(@ModelAttribute GameParameter gameParameter) {
        mhService.solve(gameParameter.getNumberOfIterations(), gameParameter.getChangeOfChoice());
        this.mhResult.setNumbersOfIterations(gameParameter.getNumberOfIterations());
        this.mhResult.setChangeOfChoice(gameParameter.getChangeOfChoice());
        this.mhResult.setPositiveResults(mhService.getResults());
        return "redirect:/results/";
    }

    @GetMapping(path = "results/")
    public String result(Model model) {
        model.addAttribute("results", mhResult);
        return "results";
    }

    @GetMapping
    public String home() {
        return "index";
    }
}
