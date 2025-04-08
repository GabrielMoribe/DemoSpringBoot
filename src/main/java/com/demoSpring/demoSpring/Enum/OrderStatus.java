package com.demoSpring.demoSpring.Enum;

public enum OrderStatus {

    WAITING_PAYIMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;
    private OrderStatus(int code){
        this.code=code;
    }


    public int getCode(){
        return this.code;
    }
    public static OrderStatus valueOf(int code){
        for(OrderStatus status:OrderStatus.values()){
            if(status.getCode()==code){
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid code: "+code);
    }
}
