### 1. Aperçu

Dans ce didacticiel, nous allons aborder l'utilisation de l'annotation @EmbeddedId et 
de la méthode « findBy » pour interroger une entité JPA basée sur une clé composite.

Par conséquent, nous utiliserons les annotations @EmbeddeId et @Embeddable pour représenter les clés composites dans les entités JPA. 
Nous devons également utiliser Spring JpaRepository pour atteindre notre objectif.

Nous nous concentrerons sur l’interrogation d’objets par clé primaire partielle.

### 2. Besoin de @Embeddable et @EmbeddedId

Les clés primaires composites sont des clés qui utilisent plus d'une colonne
pour identifier une ligne de la table de manière unique.
Nous représentons une clé primaire composite dans Spring Data en utilisant l'annotation @Embeddable sur une classe. 
Cette clé est ensuite intégrée dans la classe d'entité correspondante de la table en tant que clé primaire composite en utilisant l'annotation @EmbeddedId sur un champ de type @Embeddable.

### 3. Exemple
Considérons une table de livre, dans laquelle un enregistrement de livre possède une clé primaire composite composée de l'auteur et du nom. 
Parfois, nous pouvons vouloir rechercher des livres par partie de la clé primaire. Par exemple, un utilisateur peut souhaiter rechercher des livres uniquement par un auteur particulier. 
Nous allons apprendre comment faire cela avec JPA.

Notre application principale consistera en un @Embeddable BookId et un @Entity Book avec @EmbeddedId BookId.

#### 3.1. @Embeddable
Définissons notre classe BookId dans cette section. 
L'auteur et le nom spécifieront un BookId unique — la classe est sérialisable et implémente les méthodes equals et hashCode

    @Embeddable
    public class BookId implements Serializable {
    private String author;
    private String name;

    // standard getters and setters
    }
#### 3.2. @Entity and @EmbeddedId
Notre entité Book a @EmbeddedId BookId et d'autres champs liés à un livre. 
BookId indique à JPA que l'entité Book possède une clé composite

    @Entity
    public class Book {

    @EmbeddedId
    private BookId id;
    private String genre;
    private Integer price;

    //standard getters and setters
    }

#### 3.3. JPA Repository and Method Naming
    @Repository
    public interface BookRepository extends JpaRepository<Book, BookId> {

    List<Book> findByIdName(String name);

    List<Book> findByIdAuthor(String author);
    }

Nous utilisons une partie des noms de champs de la variable id pour dériver nos méthodes de requête Spring Data. 
Par conséquent, JPA interprète la requête de clé primaire partielle comme:

    findByIdName -> directive "findBy" field "id.name"
    findByIdAuthor -> directive "findBy" field "id.author"

### 4. Conclusion

JPA peut être utilisé pour mapper efficacement des clés composites et les interroger via des requêtes dérivées.

Dans cet article, nous avons vu un petit exemple d’exécution d’une recherche de champ d’identification partielle. 
Nous avons examiné l'annotation @Embeddable pour représenter la clé primaire composite et l'annotation @EmbeddedId pour insérer une clé composite dans une entité.

Enfin, nous avons vu comment utiliser les méthodes dérivées de JpaRepository findBy pour effectuer une recherche avec des champs d'identification partiels.