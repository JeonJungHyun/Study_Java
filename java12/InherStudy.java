package java12;

// 상속             부모 것은 내 것
class Car {
    private String name;
    private String fuel;
    public Car( String name, String fuel )   {
        this.name = name;
        this.fuel = fuel;
    }
    public String getName() {
        return name;
    }
    public String getFuel() {
        return fuel;
    }
}
class Truck extends Car {
    private int carry;
    public Truck( String name, String fuel, int carry ) {
        super( name, fuel );
        this.carry = carry;
    }
    public int getCarry() {
        return carry;
    }
}
class Bus extends Car {
    private int number;
    public Bus( String name, String fuel, int number ) {
        super( name, fuel );
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
}
class Bike extends Car {
    public Bike( String name, String fuel ) {
        super( name, fuel );
    }
}
class Cycle extends Car {
    private int gear;
    public Cycle( String name, int gear ) {
        super( name, null );
        this.gear = gear;
    }
    public int getGear() {
        return gear;
    }
}
public class InherStudy {
    public static void main(String[] args) {
        // Car 부모 클래스 
        Truck t = new Truck( "현대", "경유", 10 );
        System.out.println( "제조사 : " + t.getName() );        
        System.out.println( "연료 : " + t.getFuel() );
        System.out.println( "적재 : " + t.getCarry() + "톤" );

        Bus b = new Bus( "대우", "전기", 652 );
        System.out.println( "제조사 : " + b.getName() );
        System.out.println( "연료 : " + b.getFuel() );
        System.out.println( "노선 : " + b.getNumber() );

        Bike k = new Bike( "대림", "휘발유" );
        System.out.println( "제조사 : " + k.getName() );
        System.out.println( "연료 : " + k.getFuel() );

        Cycle c = new Cycle( "삼천리", 22 );
        System.out.println( "제조사 : " + c.getName() );
        System.out.println( "기어 : " + c.getGear() + "단" );
    }
}
