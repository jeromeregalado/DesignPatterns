package org.example.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeVehicle implements Cloneable {
    private List<String> vehicleList;

    public PrototypeVehicle()
    {
        this.vehicleList = new ArrayList<String>();
    }

    public PrototypeVehicle(List<String> list)
    {
        this.vehicleList = list;
    }

    public void insertData()
    {
        vehicleList.add("Toyota Fortuner");
        vehicleList.add("Honda Civic");
        vehicleList.add("Ford Ecosport");
        vehicleList.add("Mitsubishi Mirage");
        vehicleList.add("Toyota Vios");
    }

    public List<String> getVehicleList()
    {
        return this.vehicleList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        List<String> tempList = new ArrayList<String>();

        for(String s : this.getVehicleList())
        {
            tempList.add(s);
        }

        return new PrototypeVehicle(tempList);
    }
}
