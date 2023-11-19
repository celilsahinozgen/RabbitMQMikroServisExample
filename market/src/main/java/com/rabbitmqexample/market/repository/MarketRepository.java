package com.rabbitmqexample.market.repository;

import com.rabbitmqexample.market.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarketRepository extends JpaRepository<Market,Long> {

    Optional<Market> findByUrunId(String urunId);
}
