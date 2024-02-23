package Game;

import VillageElements.Peasant;
import VillageElements.Recruitable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkForce implements Serializable {
    List<Peasant> workers;

    public WorkForce(List<Peasant> workers) {
        this.workers = workers;
    }

    public WorkForce() {
        this.workers = new ArrayList<>();
    }

    public List<Peasant> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Peasant> workers) {
        this.workers = workers;
    }

    public boolean addWorker(Peasant worker) {
        if (this.workers.add(worker)) {
            return true;
        }
        return false;
    }
}
