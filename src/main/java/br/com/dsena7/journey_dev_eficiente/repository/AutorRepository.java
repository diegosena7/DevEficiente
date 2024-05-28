package br.com.dsena7.journey_dev_eficiente.repository;

import br.com.dsena7.journey_dev_eficiente.model.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long> {

    List<AutorEntity> findByEmail(String email);
}
