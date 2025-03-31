package com.marcus.desafio_tecnico.service;


import com.marcus.desafio_tecnico.model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    private static List<Contact> contacts;

    static {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Email", "marcus@gmail.com", "Contato de Emergência" ));
        contacts.add(new Contact("Telefone", "11930093724", "Número de telefone"));
    }

    public List<Contact> getAllContactsByName(String name) {

        if(name !=null){
        return contacts;

        }

        return null;
    }

    public void save(Contact contact) {

        contacts.add(contact);
    }

    public Contact findByValueAndDelete(String valueContact) {
        Contact contact = contacts.stream()
                .filter(it-> it.getValueContact()
                .equals(valueContact))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        contacts.remove(contact);
        return contact;
    }

    public void edit(Contact contact) {
        save(contact);
    }

    public void delete(String valueContact) {
        findByValueAndDelete(valueContact);
    }
}
