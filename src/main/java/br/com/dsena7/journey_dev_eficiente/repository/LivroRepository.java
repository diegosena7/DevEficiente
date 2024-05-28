package br.com.dsena7.journey_dev_eficiente.repository;

import br.com.dsena7.journey_dev_eficiente.model.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
    LivroEntity findByTitulo(String titulo);
}
