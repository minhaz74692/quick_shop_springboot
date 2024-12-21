package com.mie.quickshop.repository.files;

import com.mie.quickshop.model.CustomFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomFileRepository extends JpaRepository<CustomFile, UUID> {
}
