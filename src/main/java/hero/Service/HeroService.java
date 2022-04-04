package hero.Service;

import hero.Main.Hero;
import hero.Main.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public Iterable<Hero> getHeroes() {
        return heroRepository.findAll();
    }

    public Hero getHero(Long id) {
        return heroRepository.findById(id).get();
    }

    public Hero updateHero(Hero hero, long id) {
        hero.setId(id);
        return heroRepository.save(hero);
    }

    public void addHeroe(Hero hero) {
        heroRepository.save(hero);
    }

    public void deleteHero(long id) {
        heroRepository.deleteById(id);
    }

}
