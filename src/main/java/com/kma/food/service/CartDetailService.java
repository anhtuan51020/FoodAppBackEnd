package com.kma.food.service;

import com.kma.food.service.dto.CartDetailDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.kma.food.domain.CartDetail}.
 */
public interface CartDetailService {
    /**
     * Save a cartDetails.
     *
     * @param cartDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    CartDetailDTO save(CartDetailDTO cartDetailsDTO);

    /**
     * Partially updates a cartDetails.
     *
     * @param cartDetailsDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CartDetailDTO> partialUpdate(CartDetailDTO cartDetailsDTO);

    /**
     * Get all the cartDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CartDetailDTO> findAll(Pageable pageable);

    /**
     * Get the "id" cartDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CartDetailDTO> findOne(Long id);

    /**
     * Delete the "id" cartDetails.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
