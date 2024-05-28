package br.com.dsena7.journey_dev_eficiente.repository;

import br.com.dsena7.journey_dev_eficiente.model.entity.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoEntity, Long> {

    EstadoEntity findByNomeEstado(String nomeEstado);
}
