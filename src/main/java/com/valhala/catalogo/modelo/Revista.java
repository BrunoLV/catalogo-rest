package com.valhala.catalogo.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que mapeia a entidade Revista para mapeamento com a tabela TB_REVISTA.
 *
 * @author Bruno Luiz Viana
 */
@Entity
@Table(name = "TB_REVISTA")
@NamedQueries({
        @NamedQuery(name = "buscarTodasRevistas", query = "SELECT r FROM Revista r"),
        @NamedQuery(name = "buscarRevistaPorTituloEEdicao", query = "SELECT r FROM Revista r WHERE r.titulo = :titulo AND r.edicao = :edicao"),
        @NamedQuery(name = "buscarRevistasPorTitulo", query = "SELECT r FROM Revista r WHERE r.titulo = :titulo"),
        @NamedQuery(name = "buscarRevistasPorArco", query = "SELECT r FROM Revista r WHERE r.arco = :arco")
})
@XmlRootElement
public class Revista implements Serializable {

    private static final long serialVersionUID = -3588551146035566527L;

    @Id
    @Column(name = "ID_REVISTA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TITULO_REVISTA", length = 100, nullable = false)
    private String titulo;
    @Column(name = "SUBTITULO_REVISTA", length = 150, nullable = false)
    private String subTitulo;
    @Column(name = "ARCO_REVISTA", length = 100, nullable = true)
    private String arco;
    @Column(name = "EDICAO_REVISTA", nullable = false)
    private Short edicao;
    @Column(name = "ANO_REVISTA", length = 4, nullable = false)
    private Short anoPublicacao;
    @Column(name = "VALOR_REVISTA", precision = 5, scale = 2)
    private Double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public String getArco() {
        return arco;
    }

    public void setArco(String arco) {
        this.arco = arco;
    }

    public Short getEdicao() {
        return edicao;
    }

    public void setEdicao(Short edicao) {
        this.edicao = edicao;
    }

    public Short getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Short anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Revista [");
        if (id != null)
            builder.append("id=").append(id).append(", ");
        if (titulo != null)
            builder.append("titulo=").append(titulo).append(", ");
        if (subTitulo != null)
            builder.append("subTitulo=").append(subTitulo).append(", ");
        if (arco != null)
            builder.append("arco=").append(arco).append(", ");
        if (edicao != null)
            builder.append("edicao=").append(edicao).append(", ");
        if (anoPublicacao != null)
            builder.append("anoPublicacao=").append(anoPublicacao).append(", ");
        if (valor != null)
            builder.append("valor=").append(valor);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Revista other = (Revista) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

} // fim da classe Revista