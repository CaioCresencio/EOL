package br.com.ifsp.eol.model;

import br.com.ifsp.eol.model.enums.TypeOrder;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "service")
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


    private User client;
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
