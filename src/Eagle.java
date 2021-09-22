public class Eagle extends Bird implements Fly{

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    @Override
    public void takeOff() {
        if (!this.flying && this.altitude == 0) {
            this.flying = true;
            System.out.printf("%s is taking off.%n", this.getName());
        }else{
            System.out.printf("%s is already flying.%n", this.getName());
        }
    }

    @Override
    public int ascend(int meters) {
        if (this.isFlying()){
            this.altitude = Math.min(this.altitude + meters, 3000);
            System.out.printf("%s flies %d meters upward. Actual altitude: %d.%n", this.getName(), meters, this.altitude);
        }
        return this.altitude;
    }

    @Override
    public int descend(int meters) {
        if (this.isFlying()){
            this.altitude = Math.max(this.altitude - meters, 0);
            System.out.printf("%s flies %d meters downward. Actual altitude: %d.%n", this.getName(), meters, this.altitude);
        }
        return this.altitude;
    }

    @Override
    public void land() {
        if (this.flying && this.altitude ==0){
            System.out.printf("%s lands on the ground.%n", this.getName());
            this.flying = false;
        }else{
            System.out.printf("%s tries to land. It is too high, it can't land. Actual altitude: %d%n", this.getName(), this.altitude);
        }
    }

}
