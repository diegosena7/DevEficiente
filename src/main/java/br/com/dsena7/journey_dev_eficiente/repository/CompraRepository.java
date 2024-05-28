package br.com.dsena7.journey_dev_eficiente.repository;

import br.com.dsena7.journey_dev_eficiente.model.entity.CompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<CompraEntity,Long> {
}
