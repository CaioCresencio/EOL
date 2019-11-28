package br.com.ifsp.eol.repositories;

import br.com.ifsp.eol.model.ServiceOrder;
import br.com.ifsp.eol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
}
