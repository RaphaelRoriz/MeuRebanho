package com.raphaelRoriz.meurebanho.Repository;

import com.raphaelRoriz.meurebanho.entity.FazendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FazendaRepository extends JpaRepository<FazendaEntity,Long> {
}
