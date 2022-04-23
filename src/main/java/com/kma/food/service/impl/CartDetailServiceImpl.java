package com.kma.food.service.impl;

import com.kma.food.domain.CartDetail;
import com.kma.food.repository.CartDetailRepository;
import com.kma.food.service.CartDetailService;
import com.kma.food.service.dto.CartDetailDTO;
import com.kma.food.service.mapper.CartDetailMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CartDetail}.
 */
@Service
@Transactional
public class CartDetailServiceImpl implements CartDetailService {

    private final Logger log = LoggerFactory.getLogger(CartDetailServiceImpl.class);

    private final CartDetailRepository cartDetailsRepository;

    private final CartDetailMapper cartDetailsMapper;

    public CartDetailServiceImpl(CartDetailRepository cartDetailsRepository, CartDetailMapper cartDetailsMapper) {
        this.cartDetailsRepository = cartDetailsRepository;
        this.cartDetailsMapper = cartDetailsMapper;
    }

    @Override
    public CartDetailDTO save(CartDetailDTO cartDetailsDTO) {
        log.debug("Request to save CartDetail : {}", cartDetailsDTO);
        CartDetail cartDetails = cartDetailsMapper.toEntity(cartDetailsDTO);
        cartDetails = cartDetailsRepository.save(cartDetails);
        return cartDetailsMapper.toDto(cartDetails);
    }

    @Override
    public Optional<CartDetailDTO> partialUpdate(CartDetailDTO cartDetailsDTO) {
        log.debug("Request to partially update CartDetail : {}", cartDetailsDTO);

        return cartDetailsRepository
            .findById(cartDetailsDTO.getId())
            .map(existingCartDetail -> {
                cartDetailsMapper.partialUpdate(existingCartDetail, cartDetailsDTO);

                return existingCartDetail;
            })
            .map(cartDetailsRepository::save)
            .map(cartDetailsMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CartDetailDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CartDetail");
        return cartDetailsRepository.findAll(pageable).map(cartDetailsMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CartDetailDTO> findOne(Long id) {
        log.debug("Request to get CartDetail : {}", id);
        return cartDetailsRepository.findById(id).map(cartDetailsMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CartDetail : {}", id);
        cartDetailsRepository.deleteById(id);
    }
}
