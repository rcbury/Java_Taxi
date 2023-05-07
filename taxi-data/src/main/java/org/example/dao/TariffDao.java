package org.example.dao;

import org.example.entity.Tariff;
import org.springframework.data.repository.CrudRepository;

public interface TariffDao extends CrudRepository<Tariff, Long> {
}
