package com.corebank.corebank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(updatable = false)
    @JsonIgnore
    private LocalDateTime createdAt;



    @Column(insertable = false)
    @JsonIgnore
    private LocalDateTime updatedAt;

   /* @ManyToOne
    @JoinColumn(name = "updated_by", insertable = false)
    private User updatedBy;*/
}

