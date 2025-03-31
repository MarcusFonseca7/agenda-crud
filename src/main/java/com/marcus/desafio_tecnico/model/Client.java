package com.marcus.desafio_tecnico.model;

public class Client {

    private String name;
    private String cpf;
    private String dateBirth;
    private String address;

    public Client(String name, String cpf, String dateBirth, String address) {
        this.name = name;
        this.cpf = cpf;
        this.dateBirth = dateBirth;
        this.address = address;
    }

    public Client() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
