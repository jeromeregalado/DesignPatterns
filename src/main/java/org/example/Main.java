package org.example;


import com.sun.net.httpserver.Filter;
import org.example.adapter.BirdAdapter;
import org.example.adapter.PlasticToyDuck;
import org.example.adapter.Sparrow;
import org.example.builder.BuilderVehicle;
import org.example.chainOfResponsibility.ATMDispenseMachine;
import org.example.composite.CompositeAccount;
import org.example.composite.DepositAccount;
import org.example.composite.SavingsAccount;
import org.example.decorator.*;
import org.example.factory.Shape;
import org.example.factory.ShapeFactory;
import org.example.prototype.PrototypeVehicle;
import org.example.singleton.SingletonLogger;
import java.util.List;

public class Main {
    public static void AdapterDemo(){
        Sparrow sparrow = new Sparrow();
        PlasticToyDuck toyDuck = new PlasticToyDuck();


        BirdAdapter birdAdapter = new BirdAdapter(sparrow);

        System.out.print("The Sparrow is ");
        sparrow.fly();
        sparrow.makeSound();

        System.out.print("ToyDuck does ");
        toyDuck.squeak();

        System.out.print("Bird...");
        birdAdapter.squeak();
    }

    public static void ChainOfResponsibilityDemo(){
        ATMDispenseMachine dispenseMachine = new ATMDispenseMachine();
        dispenseMachine.dispense(100);
        System.out.println("Break");

        dispenseMachine.dispense(220);
        System.out.println("Break");

        dispenseMachine.dispense(10);
        System.out.println("Break");

        dispenseMachine.dispense(50);
        System.out.println("Break");
    }

    public static void CompositeDemo(){
        CompositeAccount component = new CompositeAccount();

        component.addAccount(new DepositAccount("DA001", 100));
        component.addAccount(new DepositAccount("DA002", 150));
        component.addAccount(new SavingsAccount("SA001", 200));

        float totalBalance = component.getBalance();
        System.out.println("Total Balance : " + totalBalance);
    }

    public static void PrototypeDemo() throws CloneNotSupportedException {
        PrototypeVehicle a = new PrototypeVehicle();
        a.insertData();

        PrototypeVehicle b = (PrototypeVehicle) a.clone();
        List<String> list = b.getVehicleList();
        list.add("Toyota Hilux");

        System.out.println(a.getVehicleList());
        System.out.println(list);

        b.getVehicleList().remove("Audi A4");
        System.out.println(list);
        System.out.println(a.getVehicleList());

    }

    public static void DecoratorDemo(){
        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble();
        System.out.println();

        Dress fancyDress = new FancyDress(new BasicDress());
        fancyDress.assemble();
        System.out.println();

        Dress casualDress = new CasualDress(new BasicDress());
        casualDress.assemble();
        System.out.println();

        Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
        sportyFancyDress.assemble();
        System.out.println();

        Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
        casualFancyDress.assemble();
    }

    public static void BuilderDemo(){
        BuilderVehicle car = new BuilderVehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
        BuilderVehicle bike = new BuilderVehicle.VehicleBuilder("250cc", 2).build();

        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        System.out.println(car.getAirbags());

        System.out.println(bike.getEngine());
        System.out.println(bike.getWheel());
        System.out.println(bike.getAirbags());
    }

    public static void FactoryDemo(){
        ShapeFactory shapeFactory = new ShapeFactory();

        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //call draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Rectangle
        shape2.draw();

        //get an object of Square and call its draw method.
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //call draw method of square
        shape3.draw();
    }

    public static void singletonLoggerDemo(){
        SingletonLogger logger1 = SingletonLogger.getInstance();
        SingletonLogger logger2 = SingletonLogger.getInstance();
        SingletonLogger logger3 = SingletonLogger.getInstance();

        logger1.logDeposit("0001", 80.5);
        logger2.logWithdraw("0005", 100);
        logger1.logTransfer("0001", "0003", 40);
        logger3.logDeposit("0004", 56.74);
        logger2.logWithdraw("0005", 30);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        AdapterDemo();
        ChainOfResponsibilityDemo();
        CompositeDemo();
        PrototypeDemo();
        DecoratorDemo();
        BuilderDemo();
        FactoryDemo();
        singletonLoggerDemo();
        System.out.println("Hello world!");
    }
}