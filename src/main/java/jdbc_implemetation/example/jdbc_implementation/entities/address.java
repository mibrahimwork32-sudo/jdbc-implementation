package jdbc_implemetation.example.jdbc_implementation.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;


    public address() {
    }


    public address(String city, String street) {
        this.city = city;
        this.street = street;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}