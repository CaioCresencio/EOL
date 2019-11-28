package br.com.ifsp.eol.model;

import br.com.ifsp.eol.model.enums.TypeOrder;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "services")
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private TypeOrder typeOrder;

    private Date create_date;
    private Date assignment_date;

    private Date finishing_date;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    @ManyToOne
    @JoinColumn(name = "installer_id")
    private User installer;

    @PrePersist
    private void createDate() {
        create_date = new Date();
    }

    public Integer getId() {
        return id;
    }

    public TypeOrder getTypeOrder() {
        return typeOrder;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public Date getAssignment_date() {
        return assignment_date;
    }

    public Date getFinishing_date() {
        return finishing_date;
    }

    public Location getLocation() {
        return location;
    }

    public User getClient() {
        return client;
    }

    public User getInstaller() {
        return installer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTypeOrder(TypeOrder typeOrder) {
        this.typeOrder = typeOrder;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public void setAssignment_date(Date assignment_date) {
        this.assignment_date = assignment_date;
    }

    public void setFinishing_date(Date finishing_date) {
        this.finishing_date = finishing_date;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public void setInstaller(User installer) {
        this.installer = installer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceOrder that = (ServiceOrder) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
