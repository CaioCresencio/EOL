package br.com.ifsp.eol.model.enums;

public enum TypeOrder {
    MONO("MONOFASICO"),
    BI("BIFASICO"),
    TRI("TRIFASICO");

    private String description;

    private TypeOrder(String description) {
        this.description = description;
    }

    public String getDescription () {
        return description;
    }

}
