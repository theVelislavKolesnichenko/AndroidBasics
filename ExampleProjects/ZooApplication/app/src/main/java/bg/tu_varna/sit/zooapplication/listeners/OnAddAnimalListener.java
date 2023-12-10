package bg.tu_varna.sit.zooapplication.listeners;

import bg.tu_varna.sit.zooapplication.models.Cage;

public interface OnAddAnimalListener {
    void onAddAnimal(Cage cage);

    void onUpdate();
}
