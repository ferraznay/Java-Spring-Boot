package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.Entity;

import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.embeddable.LanguageKey;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

@Entity
@Data
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Long release_year;

    @Column(nullable = false)
    private Double rental_rate;

    @Column(nullable = false)
    private LocalDate last_update;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn (name = "category_category_id", referencedColumnName = "id")
    private Category catCategory;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn (name = "language_country", referencedColumnName = "country"),
            @JoinColumn (name = "language_name", referencedColumnName = "name")
    })
    private Language language;




}
