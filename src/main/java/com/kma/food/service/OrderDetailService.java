package com.kma.food.service;

import com.kma.food.service.dto.OrderDetailDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.kma.food.domain.OrderDetail}.
 */
public interface OrderDetailService {
    /**
     * Save a orderDetails.
     *
     * @param orderDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    OrderDetailDTO save(OrderDetailDTO orderDetailsDTO);

    /**
     * Partially updates a orderDetails.
     *
     * @param orderDetailsDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<OrderDetailDTO> partialUpdate(OrderDetailDTO orderDetailsDTO);

    /**
     * Get all the orderDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<OrderDetailDTO> findAll(Pageable pageable);

    /**
     * Get the "id" orderDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<OrderDetailDTO> findOne(Long id);

    /**
     * Delete the "id" orderDetails.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
