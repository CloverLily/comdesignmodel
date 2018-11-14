package DesignModel_23.BehavioralModel_11._19Memento;

/**
 * Memento类是备忘录类
 */
public class Memento {

    private String value;

    public Memento(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
