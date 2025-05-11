package com.demoSpring.demoSpring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name="tb_product")
public class Product implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    @ManyToMany
    //        (  NOME DA TABLE NO BANCO  ,     NOME DA FK DA TABELA DE PRODUTOS     ), NOME DA FK DA TABELA DE CATEGORIA
    @JoinTable(name="tb_product_category", joinColumns=@JoinColumn(name="product_id"), inverseJoinColumns=@JoinColumn(name="category_id"))
    private Set<Category> category_list =new HashSet<>();

    @OneToMany(mappedBy="id.product")
    private Set<OrderItem> orderItem_list = new HashSet<>();


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
    @JsonIgnore
    public Set<Order> getOrder_list() {
        Set<Order> set = new HashSet<>();
        for(OrderItem i : orderItem_list){
            set.add(i.getOrder());
        }
        return set;
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
