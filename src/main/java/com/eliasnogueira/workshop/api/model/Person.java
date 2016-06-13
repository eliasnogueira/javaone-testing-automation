
package com.eliasnogueira.workshop.api.model;

/**
 * Pessoa
 * @author Elias Nogueira <elias.nogueira@gmail.com> | eliasnogueira.com
 */
public class Person {
    
    private int id;
    private String nome;
    private String endereco;
    private String hobbies;

    public Person (int id, String nome, String endereco, String hobbies) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.hobbies = hobbies;
    }
    
    public Person (String nome, String endereco, String hobbies) {
        this.nome = nome;
        this.endereco = endereco;
        this.hobbies = hobbies;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the hobbies
     */
    public String getHobbies() {
        return hobbies;
    }

    /**
     * @param hobbies the hobbies to set
     */
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
    
    @Override
    public String toString() {
        return "[ id = " + getId() + ", nome = " + getNome() + ",  endereco = " + getEndereco() + ", hobbies = " + getHobbies() + "]";
    }
}
