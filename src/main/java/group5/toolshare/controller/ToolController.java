package group5.toolshare.model.controller;

import group5.toolshare.model.ToolRepository;
import group5.toolshare.model.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tool")
public class ToolController {

    @Autowired
    private ToolRepository repo;
    public ToolController() { }

    /**
     * Example showing auto binding by the framework to setup repo
     public AirportController(AirportRepository repo) {
     this.repo = repo;
     }
     */


    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("tools", repo.findAll());

        return "tools/list";
    }

    @GetMapping(params = "add")
    public String add(Model model) {
        model.addAttribute("tool", new Tool());
        return "tools/form";
    }

    /**
     * Demo showing handling of request param
     *
     * @param code
     * @param model
     * @return
     */

    @GetMapping(params = "edit")
    public String edit(@RequestParam Long id, Model model) {
        Tool tool = repo.findByID(id);
        model.addAttribute(tool);
        return "/tools/form";
    }

    @PostMapping
    public String saveFlight(@ModelAttribute("tool") Tool tool, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "tools/form";
        }

        repo.save(tool);

        return "redirect:/tool";
    }

    /**
     * Demo showing 1) passing ID rather than Code 2) Handling of Optional when
     * using findById
     *
     * @param id
     * @return
     */
    @GetMapping(params = "delete")
    public String delete(@RequestParam Long id) {
        Tool tool = repo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid tool id:" + id)
        );
        repo.delete(tool);
        return "redirect:/tool";
    }

}
