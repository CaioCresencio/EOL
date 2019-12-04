package br.com.ifsp.eol.model;

public class AtribuiReqDTO {

    private Long id_serviceOrder;
    private Long id_installer;

    public AtribuiReqDTO() {

    }

    public Long getId_serviceOrder() {
        return id_serviceOrder;
    }

    public void setId_serviceOrder(Long id_serviceOrder) {
        this.id_serviceOrder = id_serviceOrder;
    }

    public Long getId_installer() {
        return id_installer;
    }

    public void setId_installer(Long id_installer) {
        this.id_installer = id_installer;
    }
}
