package Service.building;

public class Room {

    private int ID;
    private float healthScore;
    private float electricityBalance;
    private float waterBalance;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(float healthScore) {
        this.healthScore = healthScore;
    }

    public float getElectricityBalance() {
        return electricityBalance;
    }

    public void setElectricityBalance(float electricityBalance) {
        this.electricityBalance = electricityBalance;
    }

    public float getWaterBalance() {
        return waterBalance;
    }

    public void setWaterBalance(float waterBalance) {
        this.waterBalance = waterBalance;
    }
}
