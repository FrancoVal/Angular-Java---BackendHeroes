package hero.Controller;

import hero.Service.HeroService;
import hero.Main.Hero;


import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping()
    public ResponseEntity<Object> getHeroes() {
        return ResponseEntity.ok(heroService.getHeroes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getHero(@PathVariable("id") Long id) {
        return ResponseEntity.ok(heroService.getHero(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateHero(@RequestBody Hero hero, @PathVariable long id) {
        return ResponseEntity.ok(heroService.updateHero(hero, id));
    }
    //responseEntity a los demas metodos

    @PostMapping()
    public void addHeroe(@RequestBody Hero hero) {
        heroService.addHeroe(hero);
    }

    @DeleteMapping("/{id}")
    public void deleteHero(@RequestBody long id) {
        heroService.deleteHero(id);
    }
}
