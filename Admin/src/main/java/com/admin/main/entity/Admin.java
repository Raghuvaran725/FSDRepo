package com.admin.main.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="admin")
public class Admin {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  //  @NotNull(message = "Username cannot be null")
    private String username;
  //  @NotNull(message = "Password cannot be null")
    private String password;
}
