package br.com.ifsp.eol.model;

import br.com.ifsp.eol.model.enums.TypeOrder;

import javax.persistence.*;
import java.time.LocalDate;
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

    private LocalDate create_date;
    private LocalDate assignment_date;

    private LocalDate finishing_date;

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
        create_date = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public TypeOrder getTypeOrder() {
        return typeOrder;
    }

    public LocalDate getCreate_date() {
        return create_date;
    }

    public LocalDate getAssignment_date() {
        return assignment_date;
    }

    public LocalDate getFinishing_date() {
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

    public void setCreate_date(LocalDate create_date) {
        this.create_date = create_date;
    }

    public void setAssignment_date(LocalDate assignment_date) {
        this.assignment_date = assignment_date;
    }

    public void setFinishing_date(LocalDate finishing_date) {
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
