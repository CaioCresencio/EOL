package br.com.ifsp.eol.repositories;

        import br.com.ifsp.eol.model.ServiceOrder;
        import br.com.ifsp.eol.model.UserDTO;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {

    @Query("SELECT s FROM ServiceOrder s WHERE s.installer = NULL")
    List<ServiceOrder> findOSNotStarted();

    @Query("SELECT s FROM ServiceOrder s WHERE s.assignment_date+5 < SYSDATE")
    List<ServiceOrder> findOsDelayed();

    @Query("SELECT s FROM ServiceOrder s WHERE s.assignment_date+5 < s.finishing_date")
    List<ServiceOrder> findOsDelayedFinishing();

    @Query("SELECT s FROM ServiceOrder s WHERE s.assignment_date+5 < s.finishing_date ORDER BY count(*) DESC ")
    List<UserDTO> findFinishOsDESC();

    @Query("SELECT s FROM ServiceOrder s WHERE s.installer.id = :id_installer AND s.finishing_date = NULL")
    List<ServiceOrder> findOSNotStartedByInstaller(@Param(value = "id_installer")Long id);


  /* @Query("SELECT u, count(*) FROM User u INNER JOIN ServiceOrder b on u.id = b.installer  WHERE assignment_date+5 > finishing_date  GROUP BY u.id, b.installer ")
    List<UserDTO> findFinishOs();

    @Query("SELECT u, count(*) FROM User u INNER JOIN ServiceOrder b on u.id = b.installer  WHERE assignment_date+5 < finishing_date  GROUP BY u.id, b.installer ORDER BY count(*) DESC ")
    List<UserDTO> findFinishOsDESC();*/




}
