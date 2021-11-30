package uz.pdp.modul;

import java.util.UUID;

public abstract class BaseModel {
    protected UUID id;
    protected String name;

    {
        this.id = UUID.randomUUID();
    }

    public BaseModel() {
    }

    public BaseModel(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
