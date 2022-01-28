public class FacadeDesignPatternConstruction {
    public static void main(String[] args) {
        BuildingContract buildingContract = new BuildingContract();
        buildingContract.startConstruction();
    }
}

class Bricks{
    public void manufactureBricks(int quantity)
    {
        System.out.println("Manufacturing " + quantity +  " bricks");
    }
}

class WorkerContract{
    public void bringWorkers(int quantity)
    {
        System.out.println("Bringing " + quantity + " workers");
    }
}
class SteelFactory
{
    public void manufactureSteel(int tons)
    {
        System.out.println("Manufacturing " + tons + " tons of steel");
    }
}

class BuildingDesign
{
    private String name;
    private int floors;
    private int rooms;
    private int workers;
    private int bricks;
    private int steelQuantity;
    private boolean workersDone = false;
    private boolean bricksDone = false;
    private boolean steelDone = false;

    public void setName(String name)
    {
        this.name = name;
    }
    public void setFloors(int floors)
    {
        this.floors = floors;
    }
    public void setRooms(int rooms)
    {
        this.rooms = rooms;
    }

    public void getBricks(int b)
    {
        Bricks bricks = new Bricks();
        this.bricks = b;
        bricks.manufactureBricks(b);
        this.bricksDone = true;
    }

    public void getWorkers(int workers)
    {
        this.workers = workers;
        WorkerContract wc = new WorkerContract();
        wc.bringWorkers(workers);
        this.workersDone = true;
    }

    public void getSteel(int tons)
    {
        this.steelQuantity = tons;
        SteelFactory sf = new SteelFactory();
        sf.manufactureSteel(tons);
        this.steelDone = true;
    }

    public void startConstruction()
    {
        if(steelDone&&workersDone&&bricksDone)
        {
            System.out.println("Construction started");
        }
        else
        {
            System.out.println("Some materials is missing");
        }
    }
}

class BuildingContract
{
    private BuildingDesign bd;
    public void startConstruction()
    {
        this.bd = new BuildingDesign();

        this.bd.getBricks(1000);
        this.bd.getSteel(1000);
        this.bd.getWorkers(50);

        this.bd.startConstruction();
    }
}
