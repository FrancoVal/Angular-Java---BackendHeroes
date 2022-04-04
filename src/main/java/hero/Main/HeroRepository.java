package hero.Main;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Long> {
    @Query("from Hero h where lower(h.name) like CONCAT('%', lower(:contains), '%')")
    // selecciona de la query hero, donde el valor que esta en name sea = a lo que sea contains
    public Iterable<Hero> findByName(@Param("contains") String name);
}