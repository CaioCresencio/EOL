package br.com.ifsp.eol.model.enums;

public enum TypeOrder {
    MONO(1, "MONOFASICO"),
    BI(2, "BIFASICO"),
    TRI(3, "TRIFASICO");


    private int cod;
    private String description;

    private TypeOrder(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription () {
        return description;
    }

    public static TypeOrder toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (TypeOrder x : TypeOrder.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}
