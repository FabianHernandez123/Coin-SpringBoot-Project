package com.tts.coinCollection.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.coinCollection.model.Coin;

@Repository
public interface CoinRepository extends CrudRepository<Coin, Long> {
	List<Coin> findByYear(int year);
}
