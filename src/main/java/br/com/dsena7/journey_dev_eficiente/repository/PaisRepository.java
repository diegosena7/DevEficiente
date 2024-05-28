package br.com.dsena7.journey_dev_eficiente.repository;

import br.com.dsena7.journey_dev_eficiente.model.entity.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<PaisEntity, Long> {

    PaisEntity findByNomePais(String nomePais);

}
