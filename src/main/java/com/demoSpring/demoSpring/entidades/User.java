package com.demoSpring.demoSpring.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity // MARCA A CLASSE COMO ENTIDADE JPA (SERA UMA TABELA NO BANCO)
@Table(name="tb_user") // DEFINE O NOME DA TABELA NO BANCO
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // O CAMPO DA CLASSE ASSOCIADA SERA CHAVE PRIMARIA
    @GeneratedValue(strategy= GenerationType.IDENTITY) // METODO DE GERACAO AUTOMATICO PARA A CLASSE ASSOCIADA AO @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;

    //@JsonIgnore
    @OneToMany(mappedBy="client") // UM USER PODE TER VARIOS ORDERS
                                  // MAPPED INDICA QUE O ATRIBUTO client EM ORDER, GERENCIA O MAPEAMETO NO BANCO
    private List<Order> orders = new ArrayList<>();


    public User() {}
    public User(Long id, String name, String email,String phone, String password) {
        super();
        this.id=id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;

    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public List<Order> getOrder(){
        return this.orders  ;
    }


    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id==null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        User other = (User) obj;
        if(id==null){
            if(other.id != null){
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
