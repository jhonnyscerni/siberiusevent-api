package br.com.siberius.siberiusevent.model;

import br.com.siberius.siberiusevent.model.enums.StatusEvento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Evento {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;

	@Column
	private String sigla;

	@Column
	@Lob
	private String conteudo;

	@Column
	private String descricao;

	@Column
	private String publicoAlvo;

	@Embedded
	private Endereco endereco;

	@Column
	@Enumerated(EnumType.STRING)
	private StatusEvento status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date inicioEvento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fimEvento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date inicioInscricao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fimInscricao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPublicacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataLiberacaoCertificado;

	@Column
	private String email;

	@Column
	private String cargaHoraria;

	@Column
	private BigDecimal vagas;

	@Column
	private String qtdAtividade;

	@ManyToOne
	@JoinColumn(name = "codigo_categoria_evento")
	private CategoriaEvento categoriaEvento;

}
