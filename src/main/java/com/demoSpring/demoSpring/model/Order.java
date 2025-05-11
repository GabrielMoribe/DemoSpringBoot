package com.demoSpring.demoSpring.model;

import com.demoSpring.demoSpring.Enum.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name="tb_order")
public class Order implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id // O CAMPO DA CLASSE ASSOCIADA SERA CHAVE PRIMARIA
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
    private Instant moment;
    private Integer status;

// UMA ORDER TEM APENAS UM CLIENTE
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="client_id")
    private User client;

    @OneToMany(mappedBy="id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy="order" , cascade = CascadeType.ALL)
    private Payment payment;


    public Order(){}
    public Order(Long id, Instant moment, OrderStatus status, User client){
        this.id=id;
        this.moment=moment;
        setStatus(status);
        this.client=client;
    }


    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Instant getMoment(){
        return this.moment;
    }
    public void setMoment(Instant moment){
        this.moment=moment;
    }

    public OrderStatus getStatus(){
        return OrderStatus.valueOf(status);
    }
    public void setStatus(OrderStatus status){
        if(status!=null){
            this.status=status.getCode();
        }
    }
    public User getClient(){
        return this.client;
    }
    public void setClient(User client){
        this.client=client;
    }
    public Set<OrderItem> getItems(){
        return this.items;
    }
    public Set<OrderItem> setItems(Set<OrderItem> items){
        return this.items=items;
    }
    public Payment getPayment(){
        return this.payment;
    }
    public void setPayment(Payment payment){
        this.payment=payment;
    }


    public Double getTotal(){
        double sum = 0.0;
        for(OrderItem i : items){
            sum+=i.getSubTotal();
        }
        return sum;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Se comparando com si mesmo
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Order other = (Order) obj;
        return Objects.equals(id, other.id);
    }

}


