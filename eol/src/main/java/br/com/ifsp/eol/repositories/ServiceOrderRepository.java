package br.com.ifsp.eol.repositories;

import br.com.ifsp.eol.model.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {

    @Query("SELECT s FROM ServiceOrder s WHERE s.installer = NULL")
    List<ServiceOrder> findOSNotStarted();
}
