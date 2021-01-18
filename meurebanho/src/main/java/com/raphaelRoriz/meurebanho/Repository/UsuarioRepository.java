package com.raphaelRoriz.meurebanho.Repository;

import com.raphaelRoriz.meurebanho.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {
}
