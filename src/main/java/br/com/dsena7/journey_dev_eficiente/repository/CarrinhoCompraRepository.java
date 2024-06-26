package br.com.dsena7.journey_dev_eficiente.repository;

import br.com.dsena7.journey_dev_eficiente.model.entity.CarrinhoCompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompraEntity , Long> {
}
