package lt.techin.zoo.model;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
//@EntityListeners(AuditingEntityListener.class) <-- nebus per egzamina
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    @NotNull
    private AnimalType type;

    private String description;

    private Boolean registered;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")

    private Room room;


    @CreatedDate
    private LocalDateTime createdDate;


    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String modifiedBy;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
        modifiedDate = LocalDateTime.now();
        createdBy = "API app";
        modifiedBy = "API app";
    }

    @PreUpdate
    public void preUpdate() {
        modifiedDate = LocalDateTime.now();
        modifiedBy = "API app";
    }

    //iskvieciamas pries trinant Entity
    //@PreRemove

    public Animal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id) && Objects.equals(name, animal.name) && type == animal.type && Objects.equals(description, animal.description) && Objects.equals(registered, animal.registered) && Objects.equals(room, animal.room) && Objects.equals(createdDate, animal.createdDate) && Objects.equals(modifiedDate, animal.modifiedDate) && Objects.equals(createdBy, animal.createdBy) && Objects.equals(modifiedBy, animal.modifiedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, description, registered, room, createdDate, modifiedDate, createdBy, modifiedBy);
    }
}
