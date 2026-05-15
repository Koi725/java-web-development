package ti.exame2;

public class Book {
    private String title;
    private String author;
    private int publicationYear;

    public Book() {}

    public Book(String title,String author,int publicationYear){
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
    
    public String getTitle(){
      return title;
    }
    
    public String getAuthor(){
      return author;
    }
    
    public int getPublicationYear(){
      return publicationYear;
    }

    public void setTitle(String title){
      this.title = title;
    }

    public void setAuthor(String author){
      this.author = author;
    }

    public void setPublicationYear(int publicationYear){
      this.publicationYear = publicationYear;
    }
}