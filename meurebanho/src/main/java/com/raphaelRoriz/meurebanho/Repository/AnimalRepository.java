package com.raphaelRoriz.meurebanho.Repository;

import com.raphaelRoriz.meurebanho.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity,Long> {
}
