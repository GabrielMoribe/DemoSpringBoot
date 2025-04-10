package com.demoSpring.demoSpring.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity // MARCA A CLASSE COMO ENTIDADE JPA (SERA UMA TABELA NO BANCO)
@Table(name="tb_product") // DEFINE O NOME DA TABELA NO BANCO
public class Product implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id // O CAMPO DA CLASSE ASSOCIADA SERA CHAVE PRIMARIA
    @GeneratedValue(strategy= GenerationType.IDENTITY) // METODO DE GERACAO AUTOMATICO PARA A CLASSE ASSOCIADA AO @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    @ManyToMany
    @JoinTable(name="tb_product_category", joinColumns=@JoinColumn(name="product_id"), inverseJoinColumns=@JoinColumn(name="category_id"))
    private Set<Category> category_list =new HashSet<>(); // UTILIZA-SE SET POIS ELE NAO ADMITE REPETICAO DE CATEGORIAS



    public Product(){}
    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public Set<Category> getCategory_list() {
        return category_list;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(imgUrl, product.imgUrl) && Objects.equals(category_list, product.category_list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, imgUrl, category_list);
    }
}
