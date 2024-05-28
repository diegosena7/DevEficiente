package br.com.dsena7.journey_dev_eficiente.repository;

import br.com.dsena7.journey_dev_eficiente.model.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

    Optional<CategoriaEntity> findByNome(String nome);
}
