package fi.harjoitustyo.syksy2021.vaappukanta.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MalliRepository extends CrudRepository<Malli, Long> {

    List<Malli> findAll();
    

}
