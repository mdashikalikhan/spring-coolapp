package com.app.springcoolapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name="user_role")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class UserRoleMapping {
    @Id
    @Column(name="user_id")
    private Long userId;
    @Id
    @Column(name="role_id")
    private String roleId;
}
