package com.demoSpring.demoSpring.entidades;

import com.demoSpring.demoSpring.Enum.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity // MARCA A CLASSE COMO ENTIDADE JPA (SERA UMA TABELA NO BANCO)
@Table(name="tb_order") // DEFINE O NOME DA TABELA NO BANCO
public class Order implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id // O CAMPO DA CLASSE ASSOCIADA SERA CHAVE PRIMARIA
    @GeneratedValue(strategy= GenerationType.IDENTITY) // METODO DE GERACAO AUTOMATICO PARA A CLASSE ASSOCIADA AO @Id
    private Long id;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
    private Instant moment;
    private Integer status;

// UMA ORDER TEM APENAS UM CLIENTE
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="client_id") // @JoinColumn DEFINE O NOME DA COLUNA NO BANCO QUE SERA USADA COMO FK
    private User client;          // INDICA O NOME DA COLUNA NO BANCO

    @OneToMany(mappedBy="id.order")
    private Set<OrderItem> items = new HashSet<>();  //UMA ORDER POSSUI VARIOS ITEMS ( ORDERITEMPK )

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


    @Override
    public int hashCode() {
        return Objects.hash(id); // Uso de java.util.Objects para evitar código manual e erros
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Se comparando com si mesmo
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Se é nulo ou não é da mesma classe
        }
        Order other = (Order) obj;
        return Objects.equals(id, other.id); // Validação do campo id
    }

}


