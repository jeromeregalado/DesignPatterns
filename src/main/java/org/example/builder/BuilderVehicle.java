package org.example.builder;

public class BuilderVehicle
{
    private String engine;
    private int wheel;
    private int airbags;

    public String getEngine()
    {
        return this.engine;
    }

    public int getWheel()
    {
        return this.wheel;
    }

    public int getAirbags()
    {
        return this.airbags;
    }

    private BuilderVehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    public static class VehicleBuilder {
        private String engine;
        private int wheel;
        private int airbags;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public BuilderVehicle build() {
            return new BuilderVehicle(this);
        }
    }
}
