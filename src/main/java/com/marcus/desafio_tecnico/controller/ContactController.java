package com.marcus.desafio_tecnico.controller;

import com.marcus.desafio_tecnico.model.Contact;
import com.marcus.desafio_tecnico.service.ContactService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public String getContactPage(@RequestParam(required = false) String name,
                                 @RequestParam(required = false) String cpf,
                                 @RequestParam(required = false) String dateBirth,
                                 @RequestParam(required = false) String address,
                                 Model model,
                                 HttpServletRequest request) {

        HttpSession session = request.getSession();
        if(name != null && !name.isEmpty()){
            session.setAttribute("clientName", name);
        }

        String clientName = (String) session.getAttribute("clientName");
        model.addAttribute("clientName", clientName);

        List<Contact> contacts = contactService.getAllContactsByName(clientName);

        model.addAttribute("clientContacts", contacts);

        return "contactPage";
    }


    @GetMapping("/create")
    public String getCreateContactPage(Model model) {
        model.addAttribute("newContact", new Contact());

        return "createContact";
    }

    @GetMapping("/createContact")
    public String createContact(@ModelAttribute Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/edit/{valueContact}")
    public String getEditContactPage(Model model, @PathVariable String valueContact) {
       Contact byValue = contactService.findByValueAndDelete(valueContact);
       model.addAttribute("contactToEdit", byValue);
        return "editContact";
    }

    @GetMapping("/editContact")
    public String editContact(@ModelAttribute Contact contact){
        contactService.edit(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/delete/{valueContact}")
    public String deleteContact(@PathVariable String valueContact) {
        contactService.delete(valueContact);
        return "redirect:/contacts";
    }

}
