package com.kma.food.repository;

import com.kma.food.domain.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the CartDetail entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long>, JpaSpecificationExecutor<CartDetail> {}
