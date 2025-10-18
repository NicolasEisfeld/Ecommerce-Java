package dev.nicolas.ecommercesistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.nicolas.ecommercesistema.models.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{

}