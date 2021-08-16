package com.example.core_sesa.Repository;

import com.example.core_sesa.Entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryPessoa extends CrudRepository<Pessoa, Long> {
}
