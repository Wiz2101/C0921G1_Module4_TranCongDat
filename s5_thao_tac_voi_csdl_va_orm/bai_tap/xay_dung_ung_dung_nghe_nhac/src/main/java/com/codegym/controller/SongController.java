package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    ISongService songService;

    @GetMapping("/song")
    public String findAll(Model model) {
        List<Song> songList = songService.findAll();
            model.addAttribute("songList", songList);
        return "/list";
    }

    @GetMapping("/song/create")
    public String showCreate(Model model) {
        model.addAttribute("song", new Song());
        return "/create";
    }

    @PostMapping("/song/create")
    public String addOrUpdate(@ModelAttribute Song song, RedirectAttributes redirectAttributes) {
        songService.saveOrUpdate(song);
        redirectAttributes.addFlashAttribute("msgSC", "Add new Song successfully!");
        return "redirect:/song";
    }

    @GetMapping("song/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model){
        Song song = songService.findById(id);
        model.addAttribute("song",song);
        return "/edit";
    }

    @PostMapping("song/edit")
    public String edit(@ModelAttribute Song song, RedirectAttributes redirectAttributes){
        songService.edit(song);
        redirectAttributes.addFlashAttribute("msgEdit","Edit successfully!");
        return "redirect:/song";
    }

    @GetMapping("song/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        songService.delete(id);
        redirectAttributes.addFlashAttribute("msgDel", "Delete successfully!");
        return "redirect:/song";
    }
}
