package modelo;

public class Publicacao {
    
    private String titulo;
    private String autor;
    private String conteudo;

    public Publicacao() {
    }
    
    public Publicacao(String titulo, String autor, String conteudo) {
        this.titulo = titulo;
        this.autor = autor;
        this.conteudo = conteudo;
    }
        
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "Publicacao{" + "titulo=" + titulo + ", autor=" + autor + ", conteudo=" + conteudo + '}';
    }
    
    
  
}

