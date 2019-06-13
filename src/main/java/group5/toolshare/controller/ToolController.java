package group5.toolshare.controller;

import group5.toolshare.repository.ToolRepository;
import group5.toolshare.model.Tool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tool")
public class ToolController {

    private final ToolRepository repo;
    public ToolController(ToolRepository repo) {
        this.repo = repo;
    }

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

    @GetMapping(params = "edit")
    public String edit(@RequestParam String name, @RequestParam String owner, Model model) {
        Tool tool = repo.findByNameAndOwner(name, owner);
        model.addAttribute(tool);
        return "/tools/form";
    }

    @PostMapping
    public String saveTool(@ModelAttribute("tool") Tool tool, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "tools/form";
        }

        repo.save(tool);

        return "redirect:/tool";
    }

    @GetMapping(params = "delete")
    public String delete(@RequestParam Long id) {
        Tool tool = repo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid tool id:" + id)
        );
        repo.delete(tool);
        return "redirect:/tool";
    }

}
