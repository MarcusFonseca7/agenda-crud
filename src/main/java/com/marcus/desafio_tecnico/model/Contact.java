package com.marcus.desafio_tecnico.model;


public class Contact {

    private String typeContact;
    private String valueContact;
    private String obs;

    public Contact(String typeContact, String valueContact, String obs) {
        this.typeContact = typeContact;
        this.valueContact = valueContact;
        this.obs = obs;
    }

    public Contact() {}

    public String getTypeContact() {
        return typeContact;
    }

    public void setTypeContact(String typeContact) {
        this.typeContact = typeContact;
    }

    public String getValueContact() {
        return valueContact;
    }

    public void setValueContact(String valueContact) {
        this.valueContact = valueContact;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

}
