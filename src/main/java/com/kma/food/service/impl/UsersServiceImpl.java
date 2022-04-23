package com.kma.food.service.impl;

import com.kma.food.domain.Users;
import com.kma.food.repository.UsersRepository;
import com.kma.food.service.UsersService;
import com.kma.food.service.dto.UsersDTO;
import com.kma.food.service.mapper.UsersMapper;
import java.time.Instant;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Users}.
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    private final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);

    private final UsersRepository usersRepository;

    private final UsersMapper usersMapper;

    private PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository, UsersMapper usersMapper, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UsersDTO save(UsersDTO usersDTO) {
        log.debug("Request to save Users : {}", usersDTO);
        usersDTO.setPasswordHash(passwordEncoder.encode(usersDTO.getPasswordHash()));
        usersDTO.setCreatedDate(Instant.now());
        usersDTO.setLastUpdate(Instant.now());
        Users users = usersMapper.toEntity(usersDTO);
        users = usersRepository.save(users);
        return usersMapper.toDto(users);
    }

    @Override
    public Optional<UsersDTO> partialUpdate(UsersDTO usersDTO) {
        log.debug("Request to partially update Users : {}", usersDTO);

        return usersRepository
            .findById(usersDTO.getId())
            .map(existingUsers -> {
                usersMapper.partialUpdate(existingUsers, usersDTO);

                return existingUsers;
            })
            .map(usersRepository::save)
            .map(usersMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UsersDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Users");
        return usersRepository.findAll(pageable).map(usersMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsersDTO> findOne(Long id) {
        log.debug("Request to get Users : {}", id);
        return usersRepository.findById(id).map(usersMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Users : {}", id);
        usersRepository.deleteById(id);
    }
}