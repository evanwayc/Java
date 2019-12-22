
package level_2;


class Car {  //新增定義一個新的類別 Car
    double price;
    int volume;
    String brand;
    int speed;

    //增加功能用函數，速度上升
    void speedUp(){
        speed += 10;
    }
    
    //增加功能用函數，速度下降  
    void speedDown(){
        if (speed >= 10){
            speed -= 10;
        }
    }
}

public class n25_Class {
    public static void main(String[] args) {
        Car c1 = new Car(); //新增一個c1的物件，類別是Car
        c1.brand = "Toyota";
        c1.price = 500000;
        c1.volume = 1800;
        
        System.out.println("c1.brand " + c1.brand);
        System.out.println("c1.speed " + c1.speed);
        c1.speedUp();
        System.out.println("c1.speed " + c1.speed);
        c1.speedDown();
        System.out.println("c1.speed " + c1.speed);
        
        Car c2 = new Car(); //新增一個c1的物件，類別是Car
        System.out.println("c1.brand " + c2.brand);
        System.out.println("c1.speed " + c2.speed);
        
    }
}
