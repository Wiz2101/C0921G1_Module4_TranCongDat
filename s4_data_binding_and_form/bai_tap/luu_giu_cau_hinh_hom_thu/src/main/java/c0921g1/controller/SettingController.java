package c0921g1.controller;

import c0921g1.model.Setting;
import c0921g1.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingController {
    @Autowired
    ISettingService settingService;

    @GetMapping("/setting")
    public String showSettings(Model model){
        model.addAttribute("languageList",settingService.showLanguage());
        model.addAttribute("pageList",settingService.showPage());
        model.addAttribute("setting",new Setting());
        return "setting";
    }

    @GetMapping("/list")
    public String findAll(Model model){
        model.addAttribute("settingList",settingService.findAll());
        return "list";
    }

    @PostMapping("/setting")
    public String applySetting(@ModelAttribute Setting setting){
        settingService.save(setting);
        return "redirect:list";
    }

    @GetMapping("/edit/{index}")
    public String showEdit(@PathVariable int index, Model model){
        model.addAttribute("languageList",settingService.showLanguage());
        model.addAttribute("pageList",settingService.showPage());
        model.addAttribute("selectedSetting",settingService.selectSetting(index));
        return "edit";
    }

    @PostMapping("/edit")
    public String editSetting(@ModelAttribute Setting setting){
        settingService.edit(setting);
        return "redirect:/list";
    }
}
